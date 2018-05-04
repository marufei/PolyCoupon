package cn.njyyc.polycoupon;

import android.app.Application;
import android.util.Log;

import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;

/**
 * Created by 马如飞 on 2018/4/23.
 */

public class MyApplicaition extends Application {
    private String TAG="MyApplication";
    @Override
    public void onCreate() {
        super.onCreate();

        AlibcTradeSDK.asyncInit(this, new AlibcTradeInitCallback() {
            @Override
            public void onSuccess() {
                //初始化成功，设置相关的全局配置参数
                Log.e(TAG,"初始化成功");
                // ...
            }

            @Override
            public void onFailure(int code, String msg) {
                //初始化失败，可以根据code和msg判断失败原因，详情参见错误说明
                Log.e(TAG,"初始化失败--code:"+code+"--msg:"+msg);
            }
        });
    }
}
