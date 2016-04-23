package com.tongming.materialbili.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.tongming.materialbili.R;
import com.tongming.materialbili.base.BaseFragment;
import com.tongming.materialbili.fragment.SearchIntegrationFragment;
import com.tongming.materialbili.fragment.SearchPanFragment;
import com.tongming.materialbili.fragment.SearchTopicFragment;
import com.tongming.materialbili.fragment.SearchUpFragment;
import com.tongming.materialbili.model.Search;
import com.tongming.materialbili.presenter.SearchPresenterCompl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 搜索完成之后跳转到的界面
 * Created by Tongming on 2016/3/29.
 */
public class SearchResultActivity extends AppCompatActivity implements ISearchView {

    private final String TAG = "result";
    private Toolbar toolbar;
    private EditText et_result;

    private List<String> titleList = new ArrayList<>();
    private List<BaseFragment> fragmentList = new ArrayList<>();
    private ViewPager vp_result;
    private TabLayout tl_result;
    private static TextView tv_rele;

    private static Handler mHandler;
    private String search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        //TranslucentUtil.translucentNavigation(SearchResultActivity.this);
        initData();
        initView();
    }

    private void initData() {
        fragmentList.add(new SearchIntegrationFragment());
        fragmentList.add(new SearchPanFragment());
        fragmentList.add(new SearchTopicFragment());
        fragmentList.add(new SearchUpFragment());
        titleList.add("综合");
        titleList.add("番剧");
        titleList.add("专题");
        titleList.add("up主");

        Intent intent = getIntent();
        search = intent.getStringExtra("search");
        Map<String, String> map = new HashMap<>();
        map.put("content", search);
        SearchPresenterCompl presenterCompl = new SearchPresenterCompl(this);
        presenterCompl.getSearchResult(map);
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.tl_reslut);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        tv_rele = (TextView) findViewById(R.id.tv_rele);
        et_result = (EditText) findViewById(R.id.et_result);
        et_result.setText(search);
        tl_result = (TabLayout) findViewById(R.id.tab_result);
        vp_result = (ViewPager) findViewById(R.id.vp_result);
        vp_result.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return titleList.size();
            }
        });
        tl_result.setupWithViewPager(vp_result);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle()==toolbar.getTitle()){
            finish();
        }
        return false;
    }

    public void setHandler(Handler handler){
        mHandler = handler;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onGetResult(Search search) {
        Message fMsg = mHandler.obtainMessage();
        fMsg.what = 0;
        fMsg.obj = search;
        mHandler.sendMessage(fMsg);
        tv_rele.setText(
                "相关视频(" +
                        search.getPage_info().getVideo().getTotal()
                        + ")"
        );
    }
}
