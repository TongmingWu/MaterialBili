package com.tongming.materialbili.utils;

/**
 * post请求
 * Created by Tongming on 2016/4/2.
 */
class PostUtil {
    /*private static final String URL = "http://bilibili-service.daoapp.io/search";
    private static String result;
    public static void doPost(Map<String, String> param) {
        OkHttpClient client = new OkHttpClient();
        if (param == null && param.size() == 0) {
            return;
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            builder.add(entry.getKey(),entry.getValue());
        }
        RequestBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(URL)
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i("Search","搜索失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //LogUtil.i("Search",response.body().string());
                String result = response.body().string();
                Message msg = new Message();
                msg.what = 0;
                msg.obj = result;
                SearchResultActivity.handler.sendMessage(msg);
                LogUtil.i("Search","搜索成功");
            }
        });
    }*/
}
