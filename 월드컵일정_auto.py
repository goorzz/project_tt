from bs4 import BeautifulSoup
import pandas as pd
import requests
import pymysql
import schedule
import time
import sys
import datetime

def start():
    now = datetime.datetime.now()
    for i in range(1,20) :
        # date=input(" 날짜입력 예) 11월21일 : ")
        date=f"12월{i}일"
        #mysql 연결
        con = pymysql.connect(host='localhost', user='python', password='java1234!',
            db='project_tt', charset='utf8') # 한글처리 (charset = 'utf8')
        cur = con.cursor()    
        #sql 쿼리문
        # sql_insert = "INSERT INTO tt_db (p_no, date, w_group, time, name_1, name_2, score_1, score_2) VALUES (%s, %s, %s, %s, %s, %s, %s, %s)"
        sql_update =  "UPDATE tt_schedule SET time = %s, name_1 = %s, name_2 = %s, score_1 = %s, score_2 = %s WHERE date = %s and p_no = %s"

        url = f"https://search.daum.net/search?w=tot&DA=SPV&q=월드컵%20{date}%20일정&rtmaxcoll=SPV"
        # print(url) #url정상적으로 들어가는지 테스트
        request=requests.get(url)
        html=request.content
        soup = BeautifulSoup(html,'html.parser')
        # print(soup) # text잘받아오는지 테스트

        # 수집할 내용 (국가, 시간, 조, 스코어 )
        # 국가 수집
        name_1 = soup.find_all('div',class_='info_item')
        name=[]
        for i in name_1:
            name.append(i.get_text().replace(' ',''))
        # 시간, 조, 스코어 수집
        time_1 = soup.find_all('span',class_='info_state')
        score_1= soup.find_all('div',class_='score_info')
        time_2=[] 
        score_2=[]  
        score=[]
        time=[]
        group=[]
        #크롤링한 값을 텍스트로 변환해 저장
        for i in time_1: 
            time_2.append(i.get_text().split())
        for i in score_1:
            score_2.append(i.get_text().split())
        #저장한 텍스트값을 내가 원하는 모양으로 다시 정제
        for i in range(1,len(time_2)):
            time.append(time_2[i][2])
            group.append(time_2[i][0])
            # score.append(score_2[i][0])

        # 경기결과가 있다면 스코어점수를 없다면 경기시작전을 넣어보자
        # 먼저 그 날자의 국가갯수만큼 경기시작전 리스트를 만들고(1) 결과가 나오면 리스트값을 바꿔준다(2).
        # 1.
        for i in range(0,len(name)):
            score.append("00경기시작전")
        # 2.
        for i in range(0,len(score_2)):
            score[i] = score_2[i][0]
            
        # for i,j in zip(range(int(len(name)/2)),range(0,len(name),2)):
        #     print(date,group[i],time[i],name[j],":",name[1+j],score[j][2:],":",score[1+j][2:])

        #데이터 삽입
        for i,j in zip(range(int(len(name)/2)),range(0,len(name),2)):
            cur.execute(sql_update, (time[i],name[j],name[1+j],score[j][2:],score[1+j][2:],date,i+1))
            con.commit()
        con.close()
    print(now,"수집완료")
   

def exit():
    print("종료")
    sys.exit()

# 주기 설정
schedule.every(15).minutes.do(start)

while True:
    schedule.run_pending()
    time.sleep(1)
