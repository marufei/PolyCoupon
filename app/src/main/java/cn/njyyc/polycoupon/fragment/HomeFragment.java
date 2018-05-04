package cn.njyyc.polycoupon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.adapter.login.AlibcLogin;
import com.alibaba.baichuan.android.trade.callback.AlibcLoginCallback;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.constants.AlibcConstants;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.model.TradeResult;
import com.alibaba.baichuan.android.trade.page.AlibcBasePage;
import com.alibaba.baichuan.android.trade.page.AlibcDetailPage;
import com.alibaba.fastjson.JSON;
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
import cn.njyyc.polycoupon.Entity.HomeGoodsBean.DataBean;
import cn.njyyc.polycoupon.R;
import cn.njyyc.polycoupon.activity.MainActivity;
import cn.njyyc.polycoupon.adapter.Fragment_HomeLvAdapter;
import cn.njyyc.polycoupon.http.HttpAddress;
import cn.njyyc.polycoupon.utils.VolleyUtils;

/**
 * Created by 马如飞 on 2018/5/4.
 */

public class HomeFragment extends BaseFragment {
    private View view;
    private ListView home_lv;
    private Fragment_HomeLvAdapter adapter;
    private List<HomeGoodsBean.DataBean> listData=new ArrayList<>();

    @Override
    protected void lazyLoad() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getActivity(), R.layout.fragment_home,null);
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
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //商品详情page
                AlibcBasePage detailPage = new AlibcDetailPage(String.valueOf(listData.get(i).getId()));

                //提供给三方传递配置参数
                Map<String, String> exParams = new HashMap<>();
                exParams.put(AlibcConstants.ISV_CODE, "appisvcode");

                AlibcShowParams showParams=new AlibcShowParams(OpenType.Native,false);

                //使用百川sdk提供默认的Activity打开detail
                AlibcTrade.show(getActivity(), detailPage, showParams, null, exParams ,
                        new AlibcTradeCallback() {
                            @Override
                            public void onTradeSuccess(TradeResult tradeResult) {
                                //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
                                Log.e(TAG,"tradeResult:"+tradeResult.toString());
                            }

                            @Override
                            public void onFailure(int code, String msg) {
                                //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
                                Log.e(TAG,"msg:"+msg);
                            }
                        });

            }
        });
    }

    private void initData() {
        Log.e(TAG,"进入initData");
        String url= HttpAddress.GOODS_LIST;
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG,"response:"+response);
                Gson gson=new Gson();
//                type=new TypeToken<List<DataBean>>().getType();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    listData= gson.fromJson(String.valueOf(jsonArray),new TypeToken<List<HomeGoodsBean.DataBean>>(){}.getType());
                    if(listData!=null){
                        adapter=new Fragment_HomeLvAdapter(getActivity(),listData);
                        home_lv.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,"error:"+error);
                Toast.makeText(getActivity(),"网络有问题" ,Toast.LENGTH_LONG);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String > map=new HashMap<>();
                map.put("pageSize","10");
                map.put("p","1");
                return map;
            }
        };
        VolleyUtils.setTimeOut(stringRequest);
        VolleyUtils.getInstance(getActivity()).addToRequestQueue(stringRequest);

    }

    private void initViews() {
        home_lv=view.findViewById(R.id.home_lv);
    }

}
