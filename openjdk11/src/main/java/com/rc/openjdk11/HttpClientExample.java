package com.rc.openjdk11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

/**
 * @ClassName HttpClientExample
 * @Description 标准HTTP客户端
 * @Author liux
 * @Date 19-4-1 下午4:24
 * @Version 1.0
 */
public class HttpClientExample {

     /*
     * @Author liux
     * @Description 同步的GET方法
     * @Date 19-4-1 下午4:28
     * @param uri
     * @return void
     **/
    private static void syncGet(String uri) throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.body());
    }

    /*
     * @Author liux
     * @Description 异步的GET方法
     * @Date 19-4-1 下午4:45
     * @param uri
     * @return void
     **/
    private static void asyncGet(String uri) throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
        future.whenComplete((stringHttpResponse, throwable) -> {
            if (throwable != null) {
                throwable.printStackTrace();
            } else {
                System.out.println(stringHttpResponse.statusCode());
                System.out.println(stringHttpResponse.body());
            }
        }).join();
    }

    public static void main(String[] args) throws Exception  {
        String uri = "http://t.weather.sojson.com/api/weather/city/101030100";
//        syncGet(uri);
        asyncGet(uri);
    }
}
