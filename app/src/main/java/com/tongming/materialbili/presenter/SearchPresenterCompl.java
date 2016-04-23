package com.tongming.materialbili.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.reflect.TypeToken;
import com.tongming.materialbili.activity.ISearchView;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.model.Search;
import com.tongming.materialbili.utils.LogUtil;
import com.tongming.materialbili.utils.URLUtil;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Tongming on 2016/4/23.
 */
public class SearchPresenterCompl implements ISearchPresenter {
    private ISearchView mSearchView;
    private Handler mHandler;

    public SearchPresenterCompl(ISearchView searchView) {
        mSearchView = searchView;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void getSearchResult(Map<String,String> map) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        RequestBody formBody = builder.build();
        final Request request = new Request.Builder()
                .url(URLUtil.SEARCH_URL)
                .post(formBody)
                .build();
        BaseApplication.client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i("Search", "搜索失败");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String result = response.body().string();
                final Search search = BaseApplication.gson.fromJson(result,
                        new TypeToken<Search>() {
                        }.getType());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mSearchView.onGetResult(search);
                    }
                });
                /*Message msg = new Message();
                msg.what = 0;
                msg.obj = result;
                handler.sendMessage(msg);*/
                LogUtil.i("Search", "搜索成功");
            }
        });
    }
}
