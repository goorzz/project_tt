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
    # mysql 연결
    con = pymysql.connect(host='localhost', user='python', password='java1234!',
        db='project_tt', charset='utf8') # 한글처리 (charset = 'utf8')
    cur = con.cursor()    
    # sql 쿼리문
    sql_update = "update tt_rank SET r_rank = %s, r_count = %s, r_win = %s, r_draw = %s, r_lose = %s, r_gain = %s, r_wincount = %s where r_name = %s"

    url = f"https://search.daum.net/search?w=tot&DA=SPV&q=월드컵%20A%2CB조%20순위&rtmaxcoll=SPV"
    # print(url) #url정상적으로 들어가는지 테스트
    request=requests.get(url)
    html=request.content
    soup = BeautifulSoup(html,'html.parser')
    # print(soup)

    # 수집할 내용 (조, 순위, 국가, 경기, 승, 무, 패, 득실, 승점)
    cont_1= soup.find_all('td')
    cont=[]
    for i in cont_1:
        cont.append(i.get_text().replace(' ',''))

    for j in range(0,224,7):
        cur.execute(sql_update, (cont[0+j][:2],cont[1+j],cont[2+j],cont[3+j],cont[4+j],cont[5+j],cont[6+j],cont[0+j][2:]))
        con.commit() 
    con.close()
    print(now,"수집완료")

def exit():
    print("종료")
    sys.exit()

# 주기 설정
schedule.every(30).minutes.do(start)

while True:
    schedule.run_pending()
    time.sleep(1)
