這專案的parent名稱為common-parent，裡面主要放了一些公共程式碼像是enums、redis相關的methods，增加專案可擴展性
連結如下:https://github.com/husiaodevelopers/common-parent


# ccu-tra-base
這是一個串接了TDX(運輸資料流通服務)裡面API的練習，目前只有針對台鐵實作了指定[日期],[起迄站間]之站間時刻表資料和取得當天所有車次的時刻表資料。
TDX的網址: https://tdx.transportdata.tw/。
若往後TDX有新增關於訂票的API，將會持續更新。

執行步驟:
1.開啟終端機或是命令提示字元，進入專案根目錄。
2.要先 mvn clean install，會在/target下產生我們專案的jar檔案，這裡我的檔案名稱為ccutraapi.jar。
3.接著要看docker-compose.yml 這檔案，我在這裡串接了本專案、Redis、MySQL三個docker container，執行docker-compose up --build 
  ，便會啟動三個服務。
 
 swagger連結如下:
 http://localhost:8081/ccu/tra/swagger-ui/index.html#/
![image](https://user-images.githubusercontent.com/114802887/235485630-20857fcd-35ea-4495-8d68-256a2da92c82.png)

api調用範例如下
http://localhost:8081/ccu/tra/DailyTimetable/queryByODAndTrainDate
method:POST
範例:
request body:
{
    "originStationID":"1040",
    "destinationStationID":"6000",
    "trainDate":"2023-04-29",
    "departureStartTime":"2023-04-29 00:20:00",
    "departureEndTime":"2023-04-29 23:20:00",
    "top":30,
    "format":"JSON"
}
response:
{
    "code": 200,
    "msg": "成功",
    "data": [
        {
            "trainNo": "402",
            "startingStationID": "1040",
            "endingStationID": "5230",
            "trainTypeID": "1101",
            "originStationID": "1040",
            "destinationStationID": "6000",
            "startingStationNameZh": "樹林",
            "startingStationNameEn": "Shulin",
            "endingStationNameZh": "知本",
            "endingStationNameEn": "Zhiben",
            "trainTypeNameZh": "太魯閣",
            "trainTypeNameEn": "Taroko Express",
            "originStationNameZh": "樹林",
            "originStationNameEn": "Shulin",
            "originStationDepartureTime": "05:54",
            "destinationStationNameZh": "臺東",
            "destinationStationNameEn": "Taitung",
            "destinationStationArrivalTime": "10:09"
        }
 ],.
 .
 .
    "success": true
}

參數說明:
    "originStationID":起點站代號
    "destinationStationID":終點站代號
    "trainDate":"2023-04-29":查詢的日期
    "departureStartTime":欲查詢的開始時間
    "departureEndTime":欲查詢的結束時間
我這裡只列出其中一個車次，實際上會把所有符合條件的車次都列出來

