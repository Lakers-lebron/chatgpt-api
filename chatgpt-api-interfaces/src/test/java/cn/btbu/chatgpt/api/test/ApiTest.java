package cn.btbu.chatgpt.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        get.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218a50e36d39f9e-010b06d007ddb9f-26031f51-1821369-18a50e36d3a1461%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhNTBlMzZkMzlmOWUtMDEwYjA2ZDAwN2RkYjlmLTI2MDMxZjUxLTE4MjEzNjktMThhNTBlMzZkM2ExNDYxIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218a50e36d39f9e-010b06d007ddb9f-26031f51-1821369-18a50e36d3a1461%22%7D; amp_6e403e=Y85R6oRmvmaDn3E_GbCyQm...1h9et3emn.1h9et3emn.0.0.0; zsxq_access_token=B3E3DF00-E372-708C-22C8-5FA52081582A_C1B6AC4465B960F1; abtest_env=product; zsxqsessionid=77a2347c924baee7b6cd5616c4b267b8");
        get.addHeader("content-Type", "application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void answer() throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/811252484522812/comments");
        post.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218a50e36d39f9e-010b06d007ddb9f-26031f51-1821369-18a50e36d3a1461%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhNTBlMzZkMzlmOWUtMDEwYjA2ZDAwN2RkYjlmLTI2MDMxZjUxLTE4MjEzNjktMThhNTBlMzZkM2ExNDYxIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218a50e36d39f9e-010b06d007ddb9f-26031f51-1821369-18a50e36d3a1461%22%7D; amp_6e403e=Y85R6oRmvmaDn3E_GbCyQm...1h9et3emn.1h9et3emn.0.0.0; zsxq_access_token=B3E3DF00-E372-708C-22C8-5FA52081582A_C1B6AC4465B960F1; abtest_env=product; zsxqsessionid=77a2347c924baee7b6cd5616c4b267b8");
        post.addHeader("content-Type","application/json");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我不会\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
