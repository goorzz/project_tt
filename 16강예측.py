import threading
import time



def script():
    import pandas as pd
    import numpy as np
    import pymysql.cursors
    ### 스케쥴 가저오기
    connection= pymysql.connect(host='192.168.31.23', user='java', password='java1234!',db='project_tt', charset='utf8',autocommit=True,cursorclass=pymysql.cursors.DictCursor)
    cursor=connection.cursor()
    cursor.execute("SELECT * FROM project_tt.tt_schedule")
    result=cursor.fetchall()
    df_schedule=pd.DataFrame(result)
    df_schedule=df_schedule[~df_schedule['w_group'].str.contains("조", na=False)]  ## 조별리그 제외
    df_schedule=df_schedule.reset_index(drop=True)
    df_schedule=df_schedule.drop(['no'],axis=1)

    ### csv파일 읽어서 모델훈련

    df_All_stat = pd.read_csv('C:/Users/ojm/Downloads/PlayerStatisticALL.csv', encoding='cp949',index_col=0)
    df_group_stat=df_All_stat[df_All_stat['round16']!='OUT']  # group stage 광탈제거 df_grouo에 저장
    df_group_stat['fn_evalation']=df_group_stat['evaluation']+df_group_stat['successful_pass_percentage']*0.01+df_group_stat['man_of_the_match']*2+df_group_stat['Goals']*0.5  # 스텟계산  
    df_group_stat['fn_evalation']=df_group_stat['fn_evalation'].round(2)
    randteam = [(df_group_stat[df_group_stat['Position']=='GK'].sample(1)['fn_evalation'].sum()+df_group_stat[df_group_stat['Position']!='GK'].sample(10)['fn_evalation'].sum()).round(2) for x in range(1000)] # 1000개의 랜덤팀 샘플데이터
    list_learn=[]
    for i in range (1000):
        for j in range(1000):
            if randteam[i]>randteam[j]:
                if abs(randteam[i]-randteam[j])>0.7:
                    list_learn.append((randteam[i],randteam[j],2))   # 승리: 2
                else:
                    list_learn.append((randteam[i],randteam[j],1))   # 무승부: 1
            else :     
                if abs(randteam[i]-randteam[j])>0.7:   
                    list_learn.append((randteam[i],randteam[j],0))    # 패배: 0
                else:
                    list_learn.append((randteam[i],randteam[j],1))   # 무승부: 1

    ### ----

    df_learn_list = pd.DataFrame(list_learn, columns=['team1', 'team2', 'result'])
    df_learn_list
    from sklearn.linear_model import LinearRegression
    from sklearn.model_selection import train_test_split
    from sklearn.metrics import mean_squared_error, r2_score
    X=df_learn_list.drop(['result'],axis=1)
    y=df_learn_list['result']
    x_train, x_test, y_train, y_test =train_test_split(X,y,test_size=0.3,random_state=1)
    lr=LinearRegression()
    lr.fit(x_train.values,y_train)
    y_predict=lr.predict(x_test)
    mse=mean_squared_error(y_test,y_predict)

    import numpy as np
    rmse=np.sqrt(mse)

    # print('예측 값의 오차 값은',rmse)
    # print('평가값은',r2_score(y_test,y_predict)) 

    #갱신되는 실시간 로스터 선발명단 확인용
    import pymysql.cursors
    connection= pymysql.connect(host='localhost', user='python', password='Python00!',db='python_test', charset='utf8',autocommit=True,cursorclass=pymysql.cursors.DictCursor)
    cursor=connection.cursor()
    cursor.execute("SELECT * FROM project_tt.rosters")
    result=cursor.fetchall()
    df_player_roster=pd.DataFrame(result)

    ## df_predict_schedule 준비
    df_group_stat[df_group_stat['소속_국가'].str.contains('네덜란드',na=False)]['fn_evalation'].sum()/df_group_stat[df_group_stat['소속_국가'].str.contains('네덜란드',na=False)]['fn_evalation'].count()*11
    df_group_stat[df_group_stat['소속_국가'].str.contains('미국',na=False)]['fn_evalation'].sum()/df_group_stat[df_group_stat['소속_국가'].str.contains('미국',na=False)]['fn_evalation'].count()*11
    df_predict_schedule=df_schedule[['date','w_group','time','name_1','name_2','score_1','score_2']]
    df_predict_schedule['predict']=""
    df_predict_schedule['win_team']=""

    # 승부예측
    df_match_team=df_player_roster['match_team']
    df_match_team=df_match_team.drop_duplicates()
    df_match_team=df_match_team.reset_index(drop=True)
    list=[]
    for i in range(len(df_match_team)):
        list.append(df_match_team[i])
    for i in range(16):
        try:
            if df_schedule['time'][i]=="종료":
                    
                if df_schedule['score_1'][i][0:1]>df_schedule['score_2'][i][0:1]:                   
                    df_predict_schedule['win_team'][i]=df_schedule['name_1'][i]
                elif df_schedule['score_1'][i][0:1]<df_schedule['score_2'][i][0:1]:
                    df_predict_schedule['win_team'][i]=df_schedule['name_2'][i]
                else:
                    if df_schedule['score_1'][i][2:3]>df_schedule['score_2'][i][2:3]:
                        df_predict_schedule['win_team'][i]=df_schedule['name_1'][i]
                    else:
                        df_predict_schedule['win_team'][i]=df_schedule['name_2'][i]
            else:
                df_predict_schedule['win_team'][i]="경기전"


            match_str=df_schedule['name_1'][i]+"vs"+df_schedule['name_2'][i]

            if match_str in list:
                ## team1
                new_df1=df_group_stat[df_group_stat['소속_국가'].str.contains(df_schedule['name_1'][i],na=False)][{'한글_이름','fn_evalation'}]
                new_df1=new_df1.reset_index(drop=True)
                # df_player_roster2=df_player_roster[df_player_roster['match_team'].str.contains('세네갈vs네덜란드',na=False)]
                df_player_roster2=df_player_roster[df_player_roster['match_team'].str.contains(match_str,na=False)]
                new_df2=df_player_roster2[df_player_roster2['country'].str.contains(df_schedule['name_1'][i],na=False)][{'name','starter','InandOut'}]
                new_df2=new_df2.reset_index(drop=True)
                starter_list=[]
                for z in range(len(new_df1)):
                    for j in range(len(new_df2)):
                        if new_df2['name'][j] in new_df1['한글_이름'][z]:
                            starter_list.append((new_df1['한글_이름'][z],new_df1['fn_evalation'][z],new_df2['name'][j],new_df2['starter'][j],new_df2['InandOut'][j]))
                        else:
                            pass
                df_starter_list = pd.DataFrame(starter_list,columns=['full_name','fn_evalation','short_name','start','InandOut'])
                df_starter_list=df_starter_list.drop_duplicates(['full_name','fn_evalation','short_name'])
                a=df_starter_list[df_starter_list['InandOut'].str.contains('IN',na=False)]['fn_evalation'].sum()/df_starter_list[df_starter_list['InandOut'].str.contains('IN',na=False)]['fn_evalation'].count()*11
                
                ## team2
                new_df3=df_group_stat[df_group_stat['소속_국가'].str.contains(df_schedule['name_2'][i],na=False)][{'한글_이름','fn_evalation'}]
                new_df3=new_df3.reset_index(drop=True)
                # df_player_roster2=df_player_roster[df_player_roster['match_team'].str.contains('세네갈vs네덜란드',na=False)]
                df_player_roster2=df_player_roster[df_player_roster['match_team'].str.contains(match_str,na=False)]
                new_df4=df_player_roster2[df_player_roster2['country'].str.contains(df_schedule['name_2'][i],na=False)][{'name','starter','InandOut'}]
                new_df4=new_df4.reset_index(drop=True)
                starter_list2=[]
                for z in range(len(new_df3)):
                    for j in range(len(new_df4)):
                        if new_df4['name'][j] in new_df3['한글_이름'][z]:
                            starter_list2.append((new_df3['한글_이름'][z],new_df3['fn_evalation'][z],new_df4['name'][j],new_df4['starter'][j],new_df4['InandOut'][j]))
                        else:
                            pass
                df_starter_list = pd.DataFrame(starter_list2,columns=['full_name','fn_evalation','short_name','start','InandOut'])
                df_starter_list=df_starter_list.drop_duplicates(['full_name','fn_evalation','short_name'])
                b=df_starter_list[df_starter_list['InandOut'].str.contains('IN',na=False)]['fn_evalation'].sum()/df_starter_list[df_starter_list['InandOut'].str.contains('IN',na=False)]['fn_evalation'].count()*11
                

                score=np.array(lr.predict([[a,b]]))

                print(df_schedule['name_1'][i],":",df_schedule['name_2'][i] )
                print((score*100/200*100).round(2),":",(100-score*100/200*100).round(2))

                if score>1:
                    df_predict_schedule['predict'][i]=df_schedule['name_1'][i]
                else:
                    df_predict_schedule['predict'][i]=df_schedule['name_2'][i] 

            else:
                a=df_group_stat[df_group_stat['소속_국가'].str.contains(df_schedule['name_1'][i],na=False)]['fn_evalation'].sum()/df_group_stat[df_group_stat['소속_국가'].str.contains(df_schedule['name_1'][i],na=False)]['fn_evalation'].count()*11
                b=df_group_stat[df_group_stat['소속_국가'].str.contains(df_schedule['name_2'][i],na=False)]['fn_evalation'].sum()/df_group_stat[df_group_stat['소속_국가'].str.contains(df_schedule['name_2'][i],na=False)]['fn_evalation'].count()*11
                

                score=np.array(lr.predict([[a,b]]))
                print(df_schedule['name_1'][i],":",df_schedule['name_2'][i] )
                print((score*100/200*100).round(2),":",(100-score*100/200*100).round(2))
                if score>1:
                    df_predict_schedule['predict'][i]=df_schedule['name_1'][i]
                else:
                    df_predict_schedule['predict'][i]=df_schedule['name_2'][i]   
        except:
            continue


    # 데이터 db 삽입
    from sqlalchemy import create_engine
    import pymysql
    import pandas as pd

    db_connection_str = 'mysql+pymysql://java:java1234!@192.168.31.23/project_tt'
    db_connection = create_engine(db_connection_str)
    con = db_connection.connect()
    df_predict_schedule.to_sql(name='tt_predict_roundover16', con=db_connection, if_exists='replace',index=False) 

    threading.Timer(30, script).start()
    print("30초뒤 다시시작")

script()