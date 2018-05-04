package cn.njyyc.polycoupon.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import cn.njyyc.polycoupon.Entity.HomeGoodsBean;
import cn.njyyc.polycoupon.R;

/**
 * Created by 马如飞 on 2018/5/4.
 */

public class Fragment_HomeLvAdapter extends BaseAdapter {
    private Context context;
    private List<HomeGoodsBean.DataBean> data;
    public Fragment_HomeLvAdapter(Context context,List<HomeGoodsBean.DataBean> data){
        this.context=context;
        this.data=data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            view=View.inflate(context, R.layout.item_home_lv,null);
            viewHolder.iv_pic=view.findViewById(R.id.item_home_pic);
            viewHolder.tv_title=view.findViewById(R.id.item_home_title);
            viewHolder.tv_nick=view.findViewById(R.id.item_home_nick);
            viewHolder.tv_price=view.findViewById(R.id.item_home_price);
            viewHolder.tv_xl=view.findViewById(R.id.item_home_xl);
            viewHolder.tv_zk=view.findViewById(R.id.item_home_zk);
            view.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.tv_title.setText(data.get(i).getTitle());
        viewHolder.tv_nick.setText(data.get(i).getNick());
        viewHolder.tv_price.setText("￥"+data.get(i).getZk_final_price());
        Picasso.with(context).load(data.get(i).getPict_url()).into(viewHolder.iv_pic);
        viewHolder.tv_zk.setText(data.get(i).getCoupon_info());
        viewHolder.tv_xl.setText(data.get(i).getVolume()+"件");
        return view;
    }
    class ViewHolder{
        TextView tv_title,tv_nick,tv_price,tv_zk,tv_xl;
        ImageView iv_pic;
    }
}
