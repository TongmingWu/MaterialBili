package com.tongming.materialbili.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.squareup.leakcanary.RefWatcher;
import com.tongming.materialbili.R;
import com.tongming.materialbili.activity.SearchResultActivity;
import com.tongming.materialbili.activity.VideoPlayActivity;
import com.tongming.materialbili.adapter.SearchVideoAdapter;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.model.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tongming on 2016/4/2.
 */
public class SearchIntegrationFragment extends BaseFragment {
    private boolean isPrepared;
    private ListView lv_integration;
    private Search search ;

    private List<String> pic = new ArrayList<>();
    private List<String> title = new ArrayList<>();
    private List<String> up = new ArrayList<>();
    private List<String> play = new ArrayList<>();
    private List<String> danmaku = new ArrayList<>();
    private List<String> aid = new ArrayList<>();

    private Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    search = (Search) msg.obj;
                    lazyLoad();
                    break;
            }
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_integration;
    }

    @Override
    protected void afterCreate(Bundle saveInstanceState) {
        initView();
        isPrepared = true;
    }

    private void initView(){
        lv_integration = (ListView) mRootView.findViewById(R.id.lv_integration);
    }

    private void initData(){
        List<Search.ResultEntity.VideoEntity> video = search.getResult().getVideo();
        for(int i = 0; i<video.size();i++){
            pic.add(video.get(i).getPic());
            title.add(video.get(i).getTitle());
            up.add(video.get(i).getAuthor());
            play.add(video.get(i).getPlay()+"");
            danmaku.add(video.get(i).getVideo_review()+"");
            aid.add(video.get(i).getAid());
        }
        lv_integration.setAdapter(new SearchVideoAdapter(pic,title,up,play,danmaku,getActivity()));
        lv_integration.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), VideoPlayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("aid",aid.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void lazyLoad() {
        if(!isPrepared||!isVisible){
            return;
        }
        //初始化数据
        initData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            SearchResultActivity mActivity = (SearchResultActivity) context;
            mActivity.setHandler(handler);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = BaseApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
