import re
from selenium import webdriver
from bs4 import BeautifulSoup
import threading
import time 
import pymysql
# from selenium.webdriver.chrome.service import Service as ChromeService


count=0
page_num = [f"{i+29}" for i in range(66)]
def script():

    print(page_num)

    for i in range(len(page_num)):       
        try:
            
            url='https://focus.daum.net/ch/wc2022/game?gameId=800647'+page_num[i]
            options = webdriver.ChromeOptions()
            options.add_experimental_option("excludeSwitches", ["enable-logging"])
            options.add_argument('headless')
            driver = webdriver.Chrome(executable_path='C:/DEV/analysis_workspace/분석/chromedriver.exe', options=options)
            # service = ChromeService(executable_path='C:/DEV/analysis_workspace/분석/chromedriver.exe')
            # driver = webdriver.Chrome(service=service, options=options)
            driver.get(url)
            time.sleep(5)
            html = driver.page_source
            soup=BeautifulSoup(html,"html.parser")
            group=soup.select_one("body")
            group=group.select_one("main")  
            groupF=group.select(".group_lineup")
            
            firstA=[]
            firstB=[]
            candidateA=[]
            candidateB=[]

            #경기가 시작전인가?
            start=group.select_one(".game_leaguecard")  

            for i in start.select(".info_league"):
                result=i.get_text()

            if "경기전" in result:      
                driver.quit()
                break
            #****경기끝났을떄 데이터넣고싶으면 이부분주석처리
            #elif "경기종료" in result:  #경기종료 데이터는 가져올 필요가 없음
            #    for i in range(len(page_num)):
            #        page_num[i]=str(int(page_num[i])+1)
            #    driver.quit()
            #    continue
            #****경기끝났을떄 데이터넣고싶으면 이부분주석처리
            else:

            #팀이름 가져오기 
                Teamname=group.select(".txt_team")

                for i in Teamname[0]:
                    TeamA=i
                for i in Teamname[1]:
                    TeamB=i

                # 선발대

                try:
                    groupA=groupF[0].select(".line_player")
                except:
                    pass

                for j in range(5):
                    try:
                        for i in groupA[j].select("div > ul > li > a "):
                            for k in i.select("p"):
                                # 선발대명단
                                firstA.append(k.getText())
                    except: ##인덱스 벗어나는 에러를 잡았을 경우에 대해서만
                        pass                                 

                try:
                    groupB=groupF[1].select(".line_player")
                except:
                    pass

                for j in range(5):
                    try:
                        for i in groupB[j].select("div > ul > li > a "):
                            for k in i.select("p"):
                                # 선발대명단
                                firstB.append(k.get_text())
                    except: ##인덱스 벗어나는 에러를 잡았을 경우에 대해서만
                        pass

                #후발대
                groupAsub=group.select(".team_vs1 > ul > li")

                for j in range(15):
                    try:
                        for i in groupAsub[j].select("li > a"):        
                            strText=re.sub(r"[0-9]", "", i.getText())  
                            strText=strText[2:]

                            strL=strText.split()
                            if len(strL)==1:
                                candidateA.append(strL[0])
                            elif len(strL)>=2:
                                if strL[1]=="교체":
                                    candidateA.append(strL[0])
                                else:
                                    candidateA.append(strL[0]+" "+strL[1])
                    except: ##인덱스 벗어나는 에러를 잡았을 경우에 대해서만
                        pass

                groupBsub=group.select(".team_vs2 > ul > li")
                for j in range(15):
                    try:
                        for i in groupBsub[j].select("li > a"):        
                            strText=re.sub(r"[0-9]", "", i.getText())
                            strText=strText[2:]

                            strL=strText.split()
                            if len(strL)==1:
                                candidateB.append(strL[0])
                            elif len(strL)>=2:
                                if strL[1]=="교체":
                                    candidateB.append(strL[0])
                                else:
                                    candidateB.append(strL[0]+" "+strL[1])

                    except: ##인덱스 벗어나는 에러를 잡았을 경우에 대해서만
                        pass

                # print(TeamA,firstA)
                # print(TeamB,firstB)
                # print(TeamA,candidateA)
                # print(TeamB,candidateB)

                # groupRecord=group.select(".inner_relay")
                # half=groupRecord[0].select("div")

                # first_half=half[0]
                # second_half=half[1]
                # plus_half=half[2]

                # print("______전반기록")
                # for i in first_half.select("ul > li > p"):
                #     if "교체" in i.getText() or "투입" in i.getText():
                #         print(i.getText())

                # print("______후반기록")
                # for i in second_half.select("ul > li > p"):
                #     if "교체" in i.getText() or "투입" in i.getText():
                #         print(i.getText())

                # print("__연장")
                # for i in plus_half.select("ul > li > p"):
                #     if "교체" in i.getText() or "투입" in i.getText():
                #         print(i.getText())


                con = pymysql.connect(host='localhost', user='python', password='Python00!',
                                    db='project_tt', charset='utf8') # 한글처리 (charset = 'utf8')
                                    
                cur = con.cursor()
                sql_select= "SELECT * FROM project_tt.rosters where match_team=%s"
                cur.execute(sql_select,TeamA+"vs"+TeamB)
                row_result = cur.rowcount  #쿼리를 가져온 값의 수가 0
                print(row_result)
                # match_team 데이터가 없을때만 insert
                if row_result==0:
                    sql_insert = "INSERT INTO rosters (match_team, country,name, starter, InandOut) VALUES (%s, %s, %s, %s, %s)"
                    for i in range(len(firstA)):
                        cur.execute(sql_insert, (TeamA+"vs"+TeamB, TeamA, firstA[i], '선발', 'IN'))
                    for i in range(len(candidateA)):
                        cur.execute(sql_insert, (TeamA+"vs"+TeamB, TeamA, candidateA[i], '후발', 'OUT'))
                    for i in range(len(firstB)):
                        cur.execute(sql_insert, (TeamA+"vs"+TeamB, TeamB, firstB[i], '선발', 'IN'))
                    for i in range(len(candidateB)):
                        cur.execute(sql_insert, (TeamA+"vs"+TeamB, TeamB, candidateB[i], '후발', 'OUT'))
                
                print("insert끝")

                # 교체시 update
                sql_update="UPDATE project_tt.rosters SET InandOut =%s WHERE country = %s and name= %s"

                for j in range(5):
                    try:
                        for i in groupA[j].select("div > ul > li > a "):
                            for k in i.select("p"):
                                name=k.getText()
                            for l in i.select(".ico_qatargame"):
                                if "교체" in l.getText():
                                    cur.execute(sql_update, ('OUT', TeamA, name))
                                    
                    except: ##인덱스 벗어나는 에러를 잡았을 경우에 대해서만
                        pass
                
                for j in range(5):
                    try:
                        for i in groupB[j].select("div > ul > li > a "):
                            for k in i.select("p"):
                                name=k.getText()
                            for l in i.select(".ico_qatargame"):
                                if "교체" in l.getText():
                                    cur.execute(sql_update, ('OUT', TeamB, name))
                    except: ##인덱스 벗어나는 에러를 잡았을 경우에 대해서만
                        pass

                for j in range(15):
                    try:
                        for i in groupAsub[j].select("li > a"):        
                            strText=re.sub(r"[0-9]", "", i.getText())
                            strText=strText[2:]
                            strL=strText.split()

                            if len(strL)==1:
                                name=strL[0]
                            elif len(strL)>=2:
                                if strL[1]=="교체":
                                    name=strL[0]
                                else:
                                    name=strL[0]+" "+strL[1]

                            if "IN" in strText:
                                cur.execute(sql_update, ('IN', TeamA, name))
                                if "OUT" in strText:
                                    cur.execute(sql_update, ('OUT', TeamA, name))
                    except: ##인덱스 벗어나는 에러를 잡았을 경우에 대해서만
                        pass
                
                for j in range(15):
                    try:
                        for i in groupBsub[j].select("li > a"):        
                            strText=re.sub(r"[0-9]", "", i.getText())
                            strText=strText[2:]
                            strL=strText.split()

                            if len(strL)==1:
                                name=strL[0]
                            elif len(strL)>=2:
                                if strL[1]=="교체":
                                    name=strL[0]
                                else:
                                    name=strL[0]+" "+strL[1]

                            if "IN" in strText:
                                cur.execute(sql_update, ('IN', TeamB, name))
                                if "OUT" in strText:
                                    cur.execute(sql_update, ('OUT', TeamB, name))
                    except: ##인덱스 벗어나는 에러를 잡았을 경우에 대해서만
                        pass
                print("update끝")

                driver.quit()

                con.commit()
                con.close()
        except: ##인덱스 벗어나는 에러를 잡았을 경우에 대해서만           
            continue
    threading.Timer(60, script).start()


script()
