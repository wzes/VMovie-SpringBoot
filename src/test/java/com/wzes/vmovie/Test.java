package com.wzes.vmovie;

import okhttp3.*;

import java.io.IOException;

/**
 * @author Create by xuantang
 * @date on 11/1/17
 */
public class Test {
    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();

        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("username", "1552730");
        formBody.add("password", "123456");
        RequestBody requestBody = formBody.build();

        Request request = new Request.Builder()
                .url("http://localhost:9999/vmovie/login")
                .post(requestBody)
                .build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
    }
}
