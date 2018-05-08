package cn.njyyc.polycoupon.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ali.auth.third.ui.context.CallbackContext;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.njyyc.polycoupon.Entity.HomeGoodsBean;
import cn.njyyc.polycoupon.R;
import cn.njyyc.polycoupon.adapter.Fragment_HomeLvAdapter;
import cn.njyyc.polycoupon.http.HttpAddress;
import cn.njyyc.polycoupon.utils.AliTkUtils;
import cn.njyyc.polycoupon.utils.MyUtils;
import cn.njyyc.polycoupon.utils.VolleyUtils;

/**
 * Created by 马如飞 on 2018/5/4.
 */

public class HomeFragment extends BaseFragment {
    private View view;
    private ListView home_lv;
    private Fragment_HomeLvAdapter adapter;
    private List<HomeGoodsBean.DataBean> listData = new ArrayList<>();

    @Override
    protected void lazyLoad() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_home, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        initData();
        initEvent();
    }

    private void initEvent() {
        home_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                if (AliTkUtils.aliIsLogin()) {
                    //领券
//                    AliTkUtils.getTick(getActivity(), listData.get(i).getCoupon_click_url());
                    //店铺
//                    AliTkUtils.myOrders(getActivity(),1,true);
                    //购物车
//                    AliTkUtils.myCards(getActivity());
                    //获取商品详情
                    AliTkUtils.getGoodsInfo(getActivity(),listData.get(i).getId()+"");
                    //添加购物车
//                    AliTkUtils.addCardPage(getActivity(),listData.get(i).getId()+"");
                } else {
                    AliTkUtils.aliLogin(getActivity());
                }


            }
        });
    }

    /**
     * 获取数据源
     */
    private void initData() {
        Log.e(TAG, "进入initData");
        String url = HttpAddress.GOODS_LIST;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "response:" + response);
                Gson gson = new Gson();
//                type=new TypeToken<List<DataBean>>().getType();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    listData = gson.fromJson(String.valueOf(jsonArray), new TypeToken<List<HomeGoodsBean.DataBean>>() {
                    }.getType());
                    if (listData != null) {
                        adapter = new Fragment_HomeLvAdapter(getActivity(), listData);
                        home_lv.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "error:" + error);
                Toast.makeText(getActivity(), "网络有问题", Toast.LENGTH_LONG);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("pageSize", "20");
                map.put("p", "1");
                map.put("timeStamp", MyUtils.getTimestamp());
                map.put("sign", MyUtils.getSign());
                MyUtils.Loge(TAG, "timeStamp:" + MyUtils.getTimestamp());
                MyUtils.Loge(TAG, "sign:" + MyUtils.getSign());
                return map;
            }
        };
        VolleyUtils.setTimeOut(stringRequest);
        VolleyUtils.getInstance(getActivity()).addToRequestQueue(stringRequest);

    }

    private void initViews() {
        home_lv = view.findViewById(R.id.home_lv);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        CallbackContext.onActivityResult(requestCode, resultCode, data);
    }


}
