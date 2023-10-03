package cn.btbu.chatgpt.api.test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ZYC on 2023/9/3 20:11
 * 单元测试hhh
 */
public class ApiTest {
    @Test
    public void query_unanwsered_questions() throws IOException {

        String requestUrl = "https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20";

        //创建 HttpClient 实例
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建 HTTP GET 请求
        HttpGet httpGet = new HttpGet(requestUrl);

        httpGet.addHeader("cookie", "zsxq_access_token=611796ED-DA8D-3686-BB05-7E6360D93D9D_C1B6AC4465B960F1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218a50e36d39f9e-010b06d007ddb9f-26031f51-1821369-18a50e36d3a1461%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhNTBlMzZkMzlmOWUtMDEwYjA2ZDAwN2RkYjlmLTI2MDMxZjUxLTE4MjEzNjktMThhNTBlMzZkM2ExNDYxIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218a50e36d39f9e-010b06d007ddb9f-26031f51-1821369-18a50e36d3a1461%22%7D; abtest_env=product; zsxqsessionid=7b15dbde9d95005f72f6605e59d0595a; amp_6e403e=Y85R6oRmvmaDn3E_GbCyQm...1h9et3emn.1h9et3emn.0.0.0");
        httpGet.addHeader("content-type", "application/json; charset=UTF-8");

        //发送请求并获取响应
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //读取响应内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder responseBody = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            responseBody.append(line);
        }
        reader.close();

        //输出响应内容
        System.out.println("Response Body:");
        System.out.println(responseBody.toString());
    }
}
