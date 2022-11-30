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
    sql_update = "update tt_news SET n_title = %s, n_url = %s where n_date= %s and n_no = %s"

    options = webdriver.ChromeOptions()
    options.add_experimental_option("excludeSwitches", ["enable-logging"])
    options.add_argument("headless")
    driver = webdriver.Chrome(executable_path='C:/DEV/analysis_workspace/Project_TT/chromedriver.exe', options=options)

    url=f'https://sports.naver.com/qatar2022/news/index?date={date}&isphoto=N&sort=popular&isAmatch=false&type=popular'

    driver.get(url)
    time.sleep(5)
    html = driver.page_source
    soup=BeautifulSoup(html,"html.parser")
    # class는. id는 #

    title=soup.select_one(".content")
    title2=title.select_one(".news_list")
    if title2 is not None :
        title3=title2.select(".text")
        title_list = []
        title_url = []
        for i in range(5):
            title_list.append(title3[i].select_one('span').get_text())
            title_url.append(title3[i].select_one('.title').attrs["href"])
        for j in range(len(title_list)):
            cur.execute(sql_update, (title_list[j],"sports.naver.com"+title_url[j],date,j+1))
            con.commit()
        con.close()
    else :
        print("데이터 없음.")
    print(now,"수집완료")

def exit():
    print("종료")
    sys.exit()

# 주기 설정
schedule.every(30).minutes.do(start)
# schedule.every(1).seconds.do(start) #테스트코드
while True:
    schedule.run_pending()
    time.sleep(1)
