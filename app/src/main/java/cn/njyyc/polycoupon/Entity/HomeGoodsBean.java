package cn.njyyc.polycoupon.Entity;

import java.util.List;

/**
 * Created by 马如飞 on 2018/5/4.
 */

public class HomeGoodsBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2861
         * category : 50002766
         * commission_rate : 2.00
         * coupon_click_url : https://uland.taobao.com/coupon/edetail?e=bfgD4q193j0GQASttHIRqdtIwrc%2FfVQQgzCdb0BYZFTB76UlhXoJ9wOFbpxjLcw%2Bh4kNFiiSN7OJcMTMRn6Y9ZMWqGtVCyf5DfqEFBOhTcz5VEOjVYA5yMd0%2BNdYR3NiZ8sQCHv4Y%2FUD9EDqYpQwIWPfrr0N2WBe%2F5o7UCVjjRrk92%2BM7h46c2nmNIxKBRTBY7UCno%2FSsVI%3D&traceId=0ab2cfa915254128353175883e
         * coupon_end_time : 2018-05-08
         * coupon_info : 满10元减3元
         * coupon_remain_count : 3000
         * coupon_start_time : 2018-05-04
         * coupon_total_count : 3000
         * item_description :
         * item_url : http://detail.tmall.com/item.htm?id=555691236311
         * nick : 江湖食族
         * num_iid : 555691236311
         * pict_url : http://img.alicdn.com/tfscom/i2/2649634838/TB10UKyk49YBuNjy0FfXXXIsVXa_!!2-item_pic.png
         * seller_id : 2147483647
         * shop_title : 智造优选
         * small_images : ,http://img.alicdn.com/tfscom/i2/2649634838/TB2IUT5aMIlyKJjSZFqXXX9xpXa_!!2649634838.jpg,http://img.alicdn.com/tfscom/i1/2649634838/TB2q.L7aP3nyKJjSZFHXXaTCpXa_!!2649634838.jpg,http://img.alicdn.com/tfscom/i3/2649634838/TB2Mz6Zj8DH8KJjSszcXXbDTFXa_!!2649634838.jpg,http://img.alicdn.com/tfscom/i2/2649634838/TB2h.qvlwvD8KJjSsplXXaIEFXa_!!2649634838.jpg
         * title : 口水娃休闲零食大礼包1200g组合鱼肉口水鱼薯片锅巴混装多口味
         * user_type : 0
         * volume : 26
         * zk_final_price : 38.90
         * created_at : 1525412837
         * updated_at : 1525412837
         * type : 1
         * status : 1
         */

        private int id;
        private int category;
        private String commission_rate;
        private String coupon_click_url;
        private String coupon_end_time;
        private String coupon_info;
        private int coupon_remain_count;
        private String coupon_start_time;
        private int coupon_total_count;
        private String item_description;
        private String item_url;
        private String nick;
        private String num_iid;
        private String pict_url;
        private int seller_id;
        private String shop_title;
        private String small_images;
        private String title;
        private int user_type;
        private int volume;
        private String zk_final_price;
        private int created_at;
        private int updated_at;
        private int type;
        private int status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public String getCommission_rate() {
            return commission_rate;
        }

        public void setCommission_rate(String commission_rate) {
            this.commission_rate = commission_rate;
        }

        public String getCoupon_click_url() {
            return coupon_click_url;
        }

        public void setCoupon_click_url(String coupon_click_url) {
            this.coupon_click_url = coupon_click_url;
        }

        public String getCoupon_end_time() {
            return coupon_end_time;
        }

        public void setCoupon_end_time(String coupon_end_time) {
            this.coupon_end_time = coupon_end_time;
        }

        public String getCoupon_info() {
            return coupon_info;
        }

        public void setCoupon_info(String coupon_info) {
            this.coupon_info = coupon_info;
        }

        public int getCoupon_remain_count() {
            return coupon_remain_count;
        }

        public void setCoupon_remain_count(int coupon_remain_count) {
            this.coupon_remain_count = coupon_remain_count;
        }

        public String getCoupon_start_time() {
            return coupon_start_time;
        }

        public void setCoupon_start_time(String coupon_start_time) {
            this.coupon_start_time = coupon_start_time;
        }

        public int getCoupon_total_count() {
            return coupon_total_count;
        }

        public void setCoupon_total_count(int coupon_total_count) {
            this.coupon_total_count = coupon_total_count;
        }

        public String getItem_description() {
            return item_description;
        }

        public void setItem_description(String item_description) {
            this.item_description = item_description;
        }

        public String getItem_url() {
            return item_url;
        }

        public void setItem_url(String item_url) {
            this.item_url = item_url;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getNum_iid() {
            return num_iid;
        }

        public void setNum_iid(String num_iid) {
            this.num_iid = num_iid;
        }

        public String getPict_url() {
            return pict_url;
        }

        public void setPict_url(String pict_url) {
            this.pict_url = pict_url;
        }

        public int getSeller_id() {
            return seller_id;
        }

        public void setSeller_id(int seller_id) {
            this.seller_id = seller_id;
        }

        public String getShop_title() {
            return shop_title;
        }

        public void setShop_title(String shop_title) {
            this.shop_title = shop_title;
        }

        public String getSmall_images() {
            return small_images;
        }

        public void setSmall_images(String small_images) {
            this.small_images = small_images;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUser_type() {
            return user_type;
        }

        public void setUser_type(int user_type) {
            this.user_type = user_type;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public String getZk_final_price() {
            return zk_final_price;
        }

        public void setZk_final_price(String zk_final_price) {
            this.zk_final_price = zk_final_price;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
