import numpy as np
import pandas as pd
import requests
import json
import xmltodict
from datetime import datetime
import pymysql
import tensorflow as tf
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

con = pymysql.connect(host='localhost', user='root', password='1234',
                      db='data', charset='utf8', # 한글처리 (charset = 'utf8')
                      autocommit=True, # 결과 DB 반영 (Insert or update)
                      cursorclass=pymysql.cursors.DictCursor # DB조회시 컬럼명을 동시에 보여줌
                     )
cur = con.cursor()

url = 'http://openapi.seoul.go.kr:8088/66656f464677616c36325670547576/xml/culturalEventInfo/1/1000'
response= requests.get(url)
data=xmltodict.parse(response.text)
json_data = json.loads(json.dumps(data))['culturalEventInfo']['row']

for i in range(0, len(json_data)):
    try:
        if(datetime.now().strftime('%Y-%m-%d %H:%M:%S') < json_data[i]["END_DATE"]):
            sql = 'insert into data values("'+json_data[i]["CODENAME"]+'"," '+json_data[i]["GUNAME"]+'","'+json_data[i]["TITLE"]+'","'+json_data[i]["PLACE"]+'","'+str(json_data[i]["ORG_NAME"])+'","'+json_data[i]["USE_TRGT"]+'","'+str(json_data[i]["USE_FEE"])+'","'+str(json_data[i]["PLAYER"])+'","'+str(json_data[i]["PROGRAM"])+'","'+json_data[i]["ORG_LINK"]+'","'+json_data[i]["MAIN_IMG"]+'","'+json_data[i]["RGSTDATE"]+'","'+json_data[i]["STRTDATE"]+'","'+json_data[i]["END_DATE"]+'")'
            cur.execute(sql)
    except:
        continue