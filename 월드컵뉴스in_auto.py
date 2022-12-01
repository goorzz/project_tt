from bs4 import BeautifulSoup
import pandas as pd
import requests
import pymysql
import schedule
import time
import sys
import datetime
from selenium import webdriver

def start():  
    now=datetime.datetime.now()
    date=str(now.year)+str(now.month)+str(now.day)
    # date=20221123

    # mysql 연결
    con = pymysql.connect(host='localhost', user='python', password='java1234!',
        db='project_tt', charset='utf8') # 한글처리 (charset = 'utf8')
    cur = con.cursor()    
    # sql 쿼리문
    sql_insert = "INSERT INTO tt_news (n_date, n_title, n_no, n_url) VALUES (%s,%s,%s,%s)"

    for j in range(5):
        cur.execute(sql_insert, (date,"-",j+1,"-"))
        con.commit()
    con.close()
    print(now,"수집완료")

def exit():
    print("종료")
    sys.exit()

# 주기 설정
schedule.every().day.at("00:01").do(start)
# schedule.every(1).seconds.do(start) #테스트코드
while True:
    schedule.run_pending()
    time.sleep(1)
