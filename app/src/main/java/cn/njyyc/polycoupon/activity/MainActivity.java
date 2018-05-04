package cn.njyyc.polycoupon.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.njyyc.polycoupon.R;
import cn.njyyc.polycoupon.adapter.MainVpAdapter;
import cn.njyyc.polycoupon.fragment.FenLeiFragment;
import cn.njyyc.polycoupon.fragment.FindFragment;
import cn.njyyc.polycoupon.fragment.GouWuCarFragement;
import cn.njyyc.polycoupon.fragment.HomeFragment;
import cn.njyyc.polycoupon.fragment.MineFragment;
import cn.njyyc.polycoupon.utils.ActivityUtil;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener {
    private ViewPager main_vp;
    private RadioGroup rg_bottom;
    private RadioButton rb0;
    private RadioButton rb1;
    private RadioButton rb2;
    private HomeFragment fragment1;
    private FenLeiFragment fragment2;
    private GouWuCarFragement fragment3;
    private FindFragment fragment4;
    private MineFragment fragment5;
    private List<Fragment> listFragnet=new ArrayList<>();
    private long exitTime=0l;
    private RadioButton rb3;
    private RadioButton rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityUtil.add(this);
        initView();
        initEvent();
    }

    private void initEvent() {
        //设置主页第一个分页被选中
        rb0.setSelected(true);
        rb0.setChecked(true);
        fragment1 = new HomeFragment();
        fragment2 = new FenLeiFragment();
        fragment3 = new GouWuCarFragement();
        fragment4=new FindFragment();
        fragment5=new MineFragment();
        listFragnet.add(fragment1);
        listFragnet.add(fragment2);
        listFragnet.add(fragment3);
        listFragnet.add(fragment4);
        listFragnet.add(fragment5);

        rg_bottom.setOnCheckedChangeListener(this);
        main_vp.setAdapter(new MainVpAdapter(getSupportFragmentManager()));
        main_vp.setCurrentItem(0);
        main_vp.addOnPageChangeListener(this);
    }

    private void initView() {
        main_vp = (ViewPager) findViewById(R.id.main_vp);
        rg_bottom = (RadioGroup) findViewById(R.id.rg_bottom);
        rb0 = (RadioButton) findViewById(R.id.rb0);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb0:
                main_vp.setCurrentItem(0);
                break;
            case R.id.rb1:
                main_vp.setCurrentItem(1);
                break;
            case R.id.rb2:
                main_vp.setCurrentItem(2);
                break;
            case R.id.rb3:
                main_vp.setCurrentItem(3);
                break;
            case R.id.rb4:
                main_vp.setCurrentItem(4);
                break;

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == 2) {
            switch (main_vp.getCurrentItem()) {
                case 0:
                    rb0.setChecked(true);
                    break;
                case 1:
                    rb1.setChecked(true);
                    break;
                case 2:
                    rb2.setChecked(true);
                    break;
                case 3:
                    rb3.setChecked(true);
            }
        }
    }

    /**
     * 返回键的监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
//                ActivityUtil.exitAll();
                finish();
                System.exit(0);
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return false;
    }

}
