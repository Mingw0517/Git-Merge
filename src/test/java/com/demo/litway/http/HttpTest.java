package com.demo.litway.http;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.demo.litway.pojo.LoginQuery;
import com.demo.litway.pojo.OrderQuery;
import com.demo.litway.pojo.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author Litway
 * @version 1.0
 */
@SpringBootTest
public class HttpTest {

    private String url = "http://172.31.151.142/dev-api/system/user/list?pageNum=1&pageSize=10";

    private String kingUrl = "http://10.1.9.43/k3cloud/Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery.common.kdsvc";

    private String webApiLogin = "http://10.1.9.43/k3cloud/Kingdee.BOS.WebApi.ServicesStub.AuthService.ValidateUser.common.kdsvc";

    private String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2tleSI6ImNlZTg1N2M2LTI5OTktNGY3Zi1hNTg3LTMxNTcwZjY2MTMwYiIsInVzZXJuYW1lIjoiYWRtaW4ifQ.7Z4EhyrqWB-4yobrHoY8LGu0oH9Y4RGfD0aC0XV7vZPNiTrBihZmQMEvkjRJkv_4-7hEIb5yM0gYjWRi9paeoA";

    private String ua = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36";

    @Test
    public void testHttp() {
        HashMap<String, Object> query = new HashMap<>();
        query.put("pageNum", 1);
        query.put("pageSize", 10);

        String body = HttpRequest.get(url)
                .header("Authorization", token)
                .header("User-Agent", ua)
                .execute().body();

        System.out.println(JSONUtil.toJsonPrettyStr(body));
    }

    @Test
    public void testJson() {
        UserQuery userQuery = new UserQuery();
        userQuery.setPageNum(1);
        userQuery.setPageSize(10);

        String json = JSONUtil.toJsonStr(userQuery);
        System.out.println(json);

        String prettyJson = JSONUtil.toJsonPrettyStr(userQuery);
        System.out.println(prettyJson);

        ArrayList<String> list = new ArrayList<>();
        list.add("fcusid");
        list.add("fnumber");
        String s = list.stream().map(Object::toString).collect(Collectors.joining(","));

        System.out.println(s);
    }

    @Test
    public void testQuery() {
        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setFormId("order");

        ArrayList<String> list = new ArrayList<>();
        list.add("fcusid");
        list.add("fnumber");
        String s = list.stream().map(Object::toString).collect(Collectors.joining(","));
        orderQuery.setFieldKeys(s);

        orderQuery.setTopRowCount(10);
        orderQuery.setStartRow(0);

        String json = JSONUtil.toJsonPrettyStr(orderQuery);
        System.out.println(json);
    }

    @Test
    public void testApi() {
        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setFormId("order");

        ArrayList<String> list = new ArrayList<>();
        list.add("fcusid");
        list.add("fnumber");
        String s = list.stream().map(Object::toString).collect(Collectors.joining(","));
        orderQuery.setFieldKeys(s);

        orderQuery.setTopRowCount(10);
        orderQuery.setStartRow(0);

        String json = JSONUtil.toJsonStr(orderQuery);

        String body = HttpRequest.post(kingUrl)
                .header(Header.ACCEPT_ENCODING, "gzip, deflate, br")
                .header(Header.CONTENT_TYPE, "text/json")
                .header(Header.COOKIE, "ASP.NET_SessionId=edkceb4y0s4cjqcy5jwfry43; Theme=standard; kdservice-sessionid=a3b2f7a5-76c3-4e3b-b6b8-2e329f8ef8c9")
                .header("Csrf-Token", "R0xqSGl5JjNhMWQ1N2MzYzVhMjRlMjUmMTY4NDQ4ODM5MzU3Mg==")
                .header("Kdbiz-Info", "{\"m\":\"MainBarItemClick\",\"t\":\"SAL_SaleOrder\",\"s\":\"ListService\"}")
                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                .body(json)
                .execute().body();
        System.out.println(body);
    }

    @Test
    public void testGet() {
        HashMap<String, Object> paramMap = new HashMap<>();

        ArrayList<String> list = new ArrayList<>();
        list.add("fcusid");
        list.add("fnumber");
        String s = list.stream().map(Object::toString).collect(Collectors.joining(","));
        paramMap.put("FieldKeys", s);

        String s1 = HttpUtil.get(kingUrl, paramMap);
        System.out.println(s1);

    }

    @Test
    public void testWebApiLogin() {
        LoginQuery loginQuery = new LoginQuery();
        loginQuery.setAcctId("6466e44dde6a23");
        loginQuery.setUsername("Administrator");
        loginQuery.setPassword("123456Aa!");
        loginQuery.setLcid(2052);

        String json = JSONUtil.toJsonStr(loginQuery);
        String post = HttpUtil.post(webApiLogin, json);
        System.out.println(post);

    }

}
