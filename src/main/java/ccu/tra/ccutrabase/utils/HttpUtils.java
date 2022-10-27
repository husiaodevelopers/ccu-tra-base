package ccu.tra.ccutrabase.utils;

import ccu.tra.ccutrabase.common.constant.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HttpUtils {

    @Value("${tdx.client.id}")
    private static String CLIENTID;
    @Value("${tdx.client.secret}")
    private static String CLIENTSECRET;

    public static String doHttpGet(String url) throws Exception{

        try {
            List<NameValuePair> tokenParams = new ArrayList<>();
            Map<String,String> headers = new HashMap<>();
            tokenParams.add(new BasicNameValuePair("grant_type", "client_credentials"));
            tokenParams.add(new BasicNameValuePair("client_id",CLIENTID)); //your clientId
            tokenParams.add(new BasicNameValuePair("client_secret",CLIENTSECRET)); //your clientSecret
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String tokenInfo = postJsonString(Constants.tokenUrl, tokenParams);
            JsonNode tokenElem = objectMapper.readTree(tokenInfo);

            String accessToken = tokenElem.get("access_token").asText();
            headers.put("authorization", String.format("Bearer %s", accessToken));
            String resultJson = getJsonString(url, headers);
            System.out.println(resultJson);
            return resultJson;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getJsonString(String tdxUrl, Map<String, String> headers) throws Exception {
        HttpGet httpGet = new HttpGet(tdxUrl);
        if (Objects.nonNull(headers)) {
            headers.forEach(httpGet::addHeader);
        }
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpGet);
             InputStream content = response.getEntity().getContent();
             BufferedReader reader = new BufferedReader(new InputStreamReader(content, StandardCharsets.UTF_8))) {
//			System.out.println("ResponseStatus：" + response.getStatusLine().getStatusCode());
            return EntityUtils.toString(response.getEntity());
        }
    }

    private static String postJsonString(String url, List<NameValuePair> params) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpPost);
             InputStream content = response.getEntity().getContent();) {
//			System.out.println("ResponseStatus：" + response.getStatusLine().getStatusCode());
            return EntityUtils.toString(response.getEntity());
        }
    }


    public static String parseJsonToUrlParams(String json){
        try{
            //解析json數據是會打亂原有數據順序的，因為源碼的排序規則是根據HASH值排序的，
            //如果想要按照字符串順序遍歷JSON屬性,需要在轉換的時候指定使用LinkedHashMap代替HashMap。
            LinkedHashMap<String, String> jsonMap =
                    JSON.parseObject(json, new TypeReference<LinkedHashMap<String, String>>() {});
            String paramStr = "";
            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                paramStr += "&"+entry.getKey()+"="+entry.getValue();
            }
            return paramStr;
        } catch (JSONException e) {
            return null;
        }
    }

}
