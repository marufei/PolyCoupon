package cn.njyyc.polycoupon.utils;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.ali.auth.third.login.callback.LogoutCallback;
import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.adapter.login.AlibcLogin;
import com.alibaba.baichuan.android.trade.callback.AlibcLoginCallback;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.constants.AlibcConstants;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.model.TradeResult;
import com.alibaba.baichuan.android.trade.page.AlibcAddCartPage;
import com.alibaba.baichuan.android.trade.page.AlibcBasePage;
import com.alibaba.baichuan.android.trade.page.AlibcDetailPage;
import com.alibaba.baichuan.android.trade.page.AlibcMyCartsPage;
import com.alibaba.baichuan.android.trade.page.AlibcMyOrdersPage;
import com.alibaba.baichuan.android.trade.page.AlibcPage;
import com.alibaba.baichuan.android.trade.page.AlibcShopPage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 马如飞 on 2018/5/7.
 */

public class AliTkUtils {
    private static String TAG="AliTkUtils";

    /**
     * 淘宝登录退出组件
     */
    static AlibcLogin alibcLogin = AlibcLogin.getInstance();
//    /使用自己的Activity & webview打开detail
//    AlibcTrade.show(context, webView, webViewClient, webChromeClien, tdetailPage, showParams, null, exParams ,
//            new AlibcTradeCallback() {
//        @Override
//        public void onTradeSuccess(TradeResult tradeResult) {
//            //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
//        }
//
//        @Override
//        public void onFailure(int code, String msg) {
//            //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
//        }
//    });
    /**
     * 打开优惠券界面
     * @param context
     * @param taokeUrl
     */
    public static void getTick(Activity context, String taokeUrl){
        //实例化URL打开page
        AlibcBasePage page = new AlibcPage(taokeUrl);

        AlibcShowParams showParams=new AlibcShowParams(OpenType.Native,false);

        //提供给三方传递配置参数
        Map<String, String> exParams = new HashMap<>();
        exParams.put(AlibcConstants.ISV_CODE, "appisvcode");

        //使用百川sdk提供默认的Activity打开detail
        AlibcTrade.show(context, page, showParams, null, exParams ,
                new AlibcTradeCallback() {
                    @Override
                    public void onTradeSuccess(TradeResult tradeResult) {
                        //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
                        MyUtils.Loge(TAG,"getTick--onTradeSuccess");
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
                        MyUtils.Loge(TAG,"getTick--onFailure");
                    }
                });
    }

    /**
     * 手淘--打开商品详情页
     * @param context
     * @param itemId
     */
    public static void getGoodsInfo(Activity context,String itemId){
        //商品详情page
        AlibcBasePage detailPage = new AlibcDetailPage(itemId);

        AlibcShowParams showParams=new AlibcShowParams(OpenType.Native,false);

        //提供给三方传递配置参数
        Map<String, String> exParams = new HashMap<>();
        exParams.put(AlibcConstants.ISV_CODE, "appisvcode");

        //使用百川sdk提供默认的Activity打开detail
        AlibcTrade.show(context, detailPage, showParams, null, exParams ,
                new AlibcTradeCallback() {
                    @Override
                    public void onTradeSuccess(TradeResult tradeResult) {
                        //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
                        MyUtils.Loge(TAG,"getGoodsInfo--onTradeSuccess");
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
                        MyUtils.Loge(TAG,"getGoodsInfo--onFailure");
                    }
                });
    }

    /**
     * 手淘--获取店铺
     * @param context
     * @param shopId
     */
    public static void getShop(Activity context,String shopId){
        //实例化店铺打开page
        AlibcBasePage shopPage = new AlibcShopPage(shopId);

        AlibcShowParams showParams=new AlibcShowParams(OpenType.Native,false);

        //提供给三方传递配置参数
        Map<String, String> exParams = new HashMap<>();
        exParams.put(AlibcConstants.ISV_CODE, "appisvcode");

        //使用百川sdk提供默认的Activity打开detail
        AlibcTrade.show(context, shopPage, showParams, null, exParams ,
                new AlibcTradeCallback() {
                    @Override
                    public void onTradeSuccess(TradeResult tradeResult) {
                        //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
                        MyUtils.Loge(TAG,"getGoodsInfo--onTradeSuccess");
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
                        MyUtils.Loge(TAG,"getGoodsInfo--onFailure");
                    }
                });
    }

    /**
     * 手淘--添加购物车
     * @param context
     * @param itemId
     */
    public static void addCardPage(Activity context,String itemId){
        //实例化添加购物车打开page
        AlibcBasePage addCardPage = new AlibcAddCartPage(itemId);

        AlibcShowParams showParams=new AlibcShowParams(OpenType.Native,false);

        //提供给三方传递配置参数
        Map<String, String> exParams = new HashMap<>();
        exParams.put(AlibcConstants.ISV_CODE, "appisvcode");

        //使用百川sdk提供默认的Activity打开detail
        AlibcTrade.show(context, addCardPage, showParams, null, exParams ,
                new AlibcTradeCallback() {
                    @Override
                    public void onTradeSuccess(TradeResult tradeResult) {
                        //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
                        MyUtils.Loge(TAG,"getGoodsInfo--onTradeSuccess");
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
                        MyUtils.Loge(TAG,"getGoodsInfo--onFailure");
                    }
                });
    }

    /**
     * 手淘--我的订单
     * @param context
     * @param status
     * @param allOrder
     */
    public static void myOrders(Activity context,int status,boolean allOrder){
        //实例化我的订单打开page
        AlibcBasePage ordersPage = new AlibcMyOrdersPage(status, allOrder);

        AlibcShowParams showParams=new AlibcShowParams(OpenType.Native,false);

        //提供给三方传递配置参数
        Map<String, String> exParams = new HashMap<>();
        exParams.put(AlibcConstants.ISV_CODE, "appisvcode");

        //使用百川sdk提供默认的Activity打开detail
        AlibcTrade.show(context, ordersPage, showParams, null, exParams ,
                new AlibcTradeCallback() {
                    @Override
                    public void onTradeSuccess(TradeResult tradeResult) {
                        //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
                        MyUtils.Loge(TAG,"getGoodsInfo--onTradeSuccess");
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
                        MyUtils.Loge(TAG,"getGoodsInfo--onFailure");
                    }
                });
    }

    /**
     * 手淘--我的购物车
     * @param context
     */
    public static void myCards(Activity context){
        //实例化我的购物车打开page
        AlibcBasePage myCartsPage = new AlibcMyCartsPage();

        AlibcShowParams showParams=new AlibcShowParams(OpenType.Native,false);

        //提供给三方传递配置参数
        Map<String, String> exParams = new HashMap<>();
        exParams.put(AlibcConstants.ISV_CODE, "appisvcode");

        //使用百川sdk提供默认的Activity打开detail
        AlibcTrade.show(context, myCartsPage, showParams, null, exParams ,
                new AlibcTradeCallback() {
                    @Override
                    public void onTradeSuccess(TradeResult tradeResult) {
                        //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
                        MyUtils.Loge(TAG,"getGoodsInfo--onTradeSuccess");
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
                        MyUtils.Loge(TAG,"getGoodsInfo--onFailure");
                    }
                });
    }

    /**
     * 判断手淘是否登录
     * @return
     */
    public static boolean aliIsLogin(){
        try{
            return alibcLogin.isLogin();
        }catch (Exception e){
            return false;
        }

    }

    /**
     * 手淘--淘宝登录授权
     * @param context
     * @return
     */
    public static void aliLogin(final Activity context){

        if(!aliIsLogin()){
            alibcLogin.showLogin(context, new AlibcLoginCallback() {
                @Override
                public void onSuccess() {
                    Toast.makeText(context, "登录成功 ",
                            Toast.LENGTH_LONG).show();
                    //获取淘宝用户信息
                    Log.i(TAG, "获取淘宝用户信息: "+ AlibcLogin.getInstance().getSession());

                }
                @Override
                public void onFailure(int code, String msg) {
                    Toast.makeText(context, "登录失败 ",
                            Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    /**
     * 手淘--退出登录
     * @param context
     */
    public static void aliLoginOut(final Activity context){
        alibcLogin.logout(context, new LogoutCallback() {
            @Override
            public void onSuccess() {
                Toast.makeText(context, "退出登录成功",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int code, String msg) {
                Toast.makeText(context, "退出登录失败 " + code + msg,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * web--打开优惠券界面
     * @param context
     * @param taokeUrl
     */
    public static void web_getTick(Activity context, String taokeUrl){
        //实例化URL打开page
        AlibcBasePage page = new AlibcPage(taokeUrl);

        AlibcShowParams showParams=new AlibcShowParams(OpenType.Native,true);

        //提供给三方传递配置参数
        Map<String, String> exParams = new HashMap<>();
        exParams.put(AlibcConstants.ISV_CODE, "appisvcode");

        //使用百川sdk提供默认的Activity打开detail
        AlibcTrade.show(context, page, showParams, null, exParams ,
                new AlibcTradeCallback() {
                    @Override
                    public void onTradeSuccess(TradeResult tradeResult) {
                        //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
                        MyUtils.Loge(TAG,"getTick--onTradeSuccess");
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
                        MyUtils.Loge(TAG,"getTick--onFailure");
                    }
                });
    }

}
