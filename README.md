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
 http://localhost:8081/ccu/tra/swagger-ui/index.html#/test-controller
![image](https://user-images.githubusercontent.com/114802887/235485630-20857fcd-35ea-4495-8d68-256a2da92c82.png)
