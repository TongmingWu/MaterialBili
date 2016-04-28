package com.tongming.materialbili.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tongming.materialbili.CusView.GlideGircleTransform;
import com.tongming.materialbili.R;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.fragment.AnimeFragment;
import com.tongming.materialbili.fragment.AttentionFragment;
import com.tongming.materialbili.fragment.DiscoverFragment;
import com.tongming.materialbili.fragment.LiveFragment;
import com.tongming.materialbili.fragment.RecommendFragment;
import com.tongming.materialbili.fragment.SubareaFragment;
import com.tongming.materialbili.model.User;
import com.tongming.materialbili.presenter.UserPresenterCompl;
import com.tongming.materialbili.utils.CommonUtil;
import com.tongming.materialbili.utils.ToastUtil;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements IUserView {

    private final String TAG = "HOME";
    private static boolean isExit;
    private final String[] TAB = {"直播", "番剧", "推荐", "分区", "关注", "发现"};
    private TabLayout tabLayout;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;
    private List<android.support.v4.app.Fragment> fragments = new ArrayList<>();
    private List<String> tabTitles = new ArrayList<>();
    private ViewPager mViewPager;
    private NavigationView navigationView;
    private final MyHandler mHandler = new MyHandler(this);
    private static boolean flag;
    private ImageView mAvatar;
    private RelativeLayout mRlOutLogin;
    private RelativeLayout mRlLogin;
    private UserPresenterCompl mPresenterCompl;
    private ImageView mLevel;
    private ImageView mSex;

    private static class MyHandler extends Handler {
        private final WeakReference<HomeActivity> mActivity;

        private MyHandler(HomeActivity activity) {
            mActivity = new WeakReference<HomeActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            HomeActivity activity = mActivity.get();
            if (activity != null) {
                isExit = false;
            }
        }
    }

    private SearchView mSearchView;
    private MenuItem menuItem;
    private SharedPreferences sharedPreferences;
    private InputMethodManager manager;
    private static TextView mTv_coins;
    private static TextView mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TranslucentUtil.translucentNavigation(HomeActivity.this);
        sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
        mPresenterCompl = new UserPresenterCompl(this);
        initViews();

        //测试
    }

    //初始化控件
    private void initViews() {
        navigationView = (NavigationView) findViewById(R.id.navigation);
        handNavigation();
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        Collections.addAll(tabTitles, TAB);

        fragments.add(new LiveFragment());
        fragments.add(new AnimeFragment());
        fragments.add(new RecommendFragment());
        fragments.add(new SubareaFragment());
        fragments.add(new AttentionFragment());
        fragments.add(new DiscoverFragment());

        //如果网络不可用
        if (!CommonUtil.isNet(HomeActivity.this)) {
            for (int i = 0; i < tabTitles.size(); i++) {
                tabLayout.addTab(tabLayout.newTab().setText(tabTitles.get(i)));
            }
        } else {
            mViewPager = (ViewPager) findViewById(R.id.viewpager);
            //mViewPager.setOffscreenPageLimit(5);//缓存的数量
            mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                    //super.destroyItem(container, position, object);
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    return tabTitles.get(position);
                }

                @Override
                public android.support.v4.app.Fragment getItem(int position) {
                    return fragments.get(position);
                }

                @Override
                public int getCount() {
                    return fragments.size();
                }
            });
            tabLayout.setupWithViewPager(mViewPager);

        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(drawerToggle);
    }


    @Override
    public void onGetUserInfo(User user) {
        Glide.with(this)
                .load(user.getFace())
                .transform(new GlideGircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(mAvatar);
        mTv_coins.setText("硬币:" + user.getCoins());
        mUserName.setText(user.getName());
        int level = user.getLevel_info().getCurrent_level();
        switch (level){
            case 0:
                Glide.with(this)
                        .load(R.drawable.ic_lv0)
                        .into(mLevel);
                break;
            case 1:
                Glide.with(this)
                        .load(R.drawable.ic_lv1)
                        .into(mLevel);
                break;
            case 2:
                Glide.with(this)
                        .load(R.drawable.ic_lv2)
                        .into(mLevel);
                break;
            case 3:
                Glide.with(this)
                        .load(R.drawable.ic_lv3)
                        .into(mLevel);
                break;
            case 4:
                Glide.with(this)
                        .load(R.drawable.ic_lv4)
                        .into(mLevel);
                break;
            case 5:
                Glide.with(this)
                        .load(R.drawable.ic_lv5)
                        .into(mLevel);
                break;
            case 6:
                Glide.with(this)
                        .load(R.drawable.ic_lv6)
                        .into(mLevel);
                break;
        }
        if(user.getSex().equals("男")){
            Glide.with(this)
                    .load(R.drawable.ic_user_male)
                    .into(mSex);
        }else if(user.getSex().equals("女")){
            Glide.with(this)
                    .load(R.drawable.ic_user_female)
                    .into(mSex);
        }else {
            Glide.with(this)
                    .load(R.drawable.ic_user_gay)
                    .into(mSex);
        }
    }

    //处理Navigation的方法
    private void handNavigation() {
        View headerLayout = navigationView.inflateHeaderView(R.layout.navigation_header);
        mAvatar = (ImageView) headerLayout.findViewById(R.id.iv_avatar);
        mTv_coins = (TextView) headerLayout.findViewById(R.id.tv_coin);
        mUserName = (TextView) headerLayout.findViewById(R.id.tv_userName);
        mLevel = (ImageView) headerLayout.findViewById(R.id.iv_level);
        mSex = (ImageView) headerLayout.findViewById(R.id.iv_sex);
        mRlOutLogin = (RelativeLayout) headerLayout.findViewById(R.id.rl_outLogin);
        mRlLogin = (RelativeLayout) headerLayout.findViewById(R.id.rl_login);
        final ImageView iv_out = (ImageView) headerLayout.findViewById(R.id.iv_outLogin);
        TextView tv_out = (TextView) headerLayout.findViewById(R.id.tv_outLogin);
        tv_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        if (sharedPreferences.getBoolean("isLogin", true)) {
            mRlOutLogin.setVisibility(View.GONE);
            mRlLogin.setVisibility(View.VISIBLE);
        } else {
            mRlOutLogin.setVisibility(View.VISIBLE);
            mRlLogin.setVisibility(View.GONE);
            Glide.with(BaseApplication.getInstance()).load(R.drawable.ic_outlogin).transform(new GlideGircleTransform(BaseApplication.getInstance())).into(iv_out);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            //用于辨别此前是否有选中的条目
            MenuItem preMenuItem;

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (preMenuItem != null) {
                    preMenuItem.setChecked(false);
                } else {
                    item.setChecked(true);
                    preMenuItem = item;

                    //不同的item对应不同的图片
                    switch (item.getItemId()) {
                        case R.id.index:
                            //首页

                            break;
                        case R.id.download:
                            //缓存
                            break;
                        case R.id.stars:
                            //收藏
                            break;
                        case R.id.history:
                            //历史记录
                            break;
                        case R.id.attention:
                            //关注
                            break;
                        case R.id.cost:
                            //消费记录
                            break;
                        case R.id.theme:
                            //主题选择
                            break;
                        case R.id.application:
                            //应用推荐
                            break;
                        case R.id.setting:
                            //设置与帮助
                            break;
                        case R.id.logout:
                            //退出登录
                            mRlOutLogin.setVisibility(View.VISIBLE);
                            mRlLogin.setVisibility(View.GONE);
                            Glide.with(BaseApplication.getInstance()).load(R.drawable.ic_outlogin).transform(new GlideGircleTransform(BaseApplication.getInstance())).into(iv_out);
                            sharedPreferences.edit().putBoolean("isLogin", false).apply();
                            /*startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                            finish();*/
                            break;
                    }
                }
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        });
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle() == toolbar.getTitle()) {
            //LogUtil.i("Home","汉堡包菜单被点击了");
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        if (item.getItemId() == R.id.menu_search) {
            mSearchView.requestFocus();
            mSearchView.post(new Runnable() {
                @Override
                public void run() {
                    showSoftInputUnchecked();
                }
            });
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top, menu);
        menuItem = menu.findItem(R.id.menu_search);
        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mSearchView = (SearchView) menuItem.getActionView();
        SearchManager sManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        //获取搜索配置信息,并设置
        mSearchView.setSearchableInfo(sManager.getSearchableInfo(getComponentName()));
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setQueryHint("请输入av号...");
        //去掉SearchView左边的搜索图标
        int magId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView magImage = (ImageView) mSearchView.findViewById(magId);
        magImage.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (mSearchView != null) {
                    if (manager != null) {
                        manager.hideSoftInputFromWindow(mSearchView.getWindowToken(), 0);
                    }
                    if (!mSearchView.isIconified()) {
                        mSearchView.setIconified(true);
                    }
                    mSearchView.clearFocus();
                }
                //ToastUtil.showToast(HomeActivity.this, query);
                menuItem.collapseActionView();
                Intent intent = new Intent(HomeActivity.this, SearchResultActivity.class);
                intent.putExtra("search", query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    //弹出软键盘
    private void showSoftInputUnchecked() {
        Method showSoftInputUnchecked = null;
        if (manager != null) {
            try {
                showSoftInputUnchecked = manager.getClass()
                        .getMethod("showSoftInputUnchecked", int.class, ResultReceiver.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            if (showSoftInputUnchecked != null) {
                try {
                    showSoftInputUnchecked.invoke(manager, 0, null);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle.getString("classID").equals("Splash") && sharedPreferences.getBoolean("isLogin", true)) {
            mPresenterCompl.getUserInfo(sharedPreferences.getString("uid",""));
        } else if(bundle.getString("classID").equals("Login")) {
            mPresenterCompl.getUserInfo(bundle.getString("uid"));
        }else {

        }
        //启动应用时跳转到第三个页面:推荐页
        //mViewPager.setCurrentItem(2);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                drawerLayout.closeDrawer(Gravity.LEFT);
                return false;
            } else {
                exit();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            ToastUtil.showToast(HomeActivity.this, "再点一次退出");
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            System.exit(0);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
