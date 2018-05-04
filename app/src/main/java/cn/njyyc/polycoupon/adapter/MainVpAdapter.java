package cn.njyyc.polycoupon.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cn.njyyc.polycoupon.fragment.FenLeiFragment;
import cn.njyyc.polycoupon.fragment.FindFragment;
import cn.njyyc.polycoupon.fragment.GouWuCarFragement;
import cn.njyyc.polycoupon.fragment.HomeFragment;
import cn.njyyc.polycoupon.fragment.MineFragment;


/**
 * Created by Administrator on 2016/8/3.
 */
public class MainVpAdapter extends FragmentPagerAdapter {
    private HomeFragment main0Fragment = null;
    private FenLeiFragment main1Fragment = null;
    private GouWuCarFragement main2Fragment=null;
    private FindFragment main3Fragment=null;
    private MineFragment main4Fragment = null;

    public MainVpAdapter(FragmentManager fm) {
        super(fm);
        main0Fragment = new HomeFragment();
        main1Fragment = new FenLeiFragment();
        main2Fragment = new GouWuCarFragement();
        main3Fragment = new FindFragment();
        main4Fragment = new MineFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = main0Fragment;
                break;
            case 1:
                fragment = main1Fragment;
                break;
            case 2:
                fragment = main2Fragment;
                break;
            case 3:
                fragment = main3Fragment;
                break;
            case 4:
                fragment=main4Fragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

}
