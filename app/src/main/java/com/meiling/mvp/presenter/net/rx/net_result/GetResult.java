package com.meiling.mvp.presenter.net.rx.net_result;

import java.util.List;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

public class GetResult {

    /**
     * Results : {"Category":"WatchList","WatchList":[{"IMEI":"355637051751824","Location":"113.2412139,23.1326755","Name":"%E8%83%A1%E9%97%B9","Online":"1","PhoneNum":"13903054492","Picture":"http://picture.quanjiakan.com:9080/quanjiakan/resources/device/20170517115310_g8w6xyh3swy4427do3ud.png","Time":"2017-04-19 14:51:53","Type":"1"}]}
     */

    private ResultsBean Results;

    public ResultsBean getResults() {
        return Results;
    }

    public void setResults(ResultsBean Results) {
        this.Results = Results;
    }

    public static class ResultsBean {
        /**
         * Category : WatchList
         * WatchList : [{"IMEI":"355637051751824","Location":"113.2412139,23.1326755","Name":"%E8%83%A1%E9%97%B9","Online":"1","PhoneNum":"13903054492","Picture":"http://picture.quanjiakan.com:9080/quanjiakan/resources/device/20170517115310_g8w6xyh3swy4427do3ud.png","Time":"2017-04-19 14:51:53","Type":"1"}]
         */

        private String Category;
        private List<WatchListBean> WatchList;

        public String getCategory() {
            return Category;
        }

        public void setCategory(String Category) {
            this.Category = Category;
        }

        public List<WatchListBean> getWatchList() {
            return WatchList;
        }

        public void setWatchList(List<WatchListBean> WatchList) {
            this.WatchList = WatchList;
        }

        public static class WatchListBean {
            /**
             * IMEI : 355637051751824
             * Location : 113.2412139,23.1326755
             * Name : %E8%83%A1%E9%97%B9
             * Online : 1
             * PhoneNum : 13903054492
             * Picture : http://picture.quanjiakan.com:9080/quanjiakan/resources/device/20170517115310_g8w6xyh3swy4427do3ud.png
             * Time : 2017-04-19 14:51:53
             * Type : 1
             */

            private String IMEI;
            private String Location;
            private String Name;
            private String Online;
            private String PhoneNum;
            private String Picture;
            private String Time;
            private String Type;

            public String getIMEI() {
                return IMEI;
            }

            public void setIMEI(String IMEI) {
                this.IMEI = IMEI;
            }

            public String getLocation() {
                return Location;
            }

            public void setLocation(String Location) {
                this.Location = Location;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getOnline() {
                return Online;
            }

            public void setOnline(String Online) {
                this.Online = Online;
            }

            public String getPhoneNum() {
                return PhoneNum;
            }

            public void setPhoneNum(String PhoneNum) {
                this.PhoneNum = PhoneNum;
            }

            public String getPicture() {
                return Picture;
            }

            public void setPicture(String Picture) {
                this.Picture = Picture;
            }

            public String getTime() {
                return Time;
            }

            public void setTime(String Time) {
                this.Time = Time;
            }

            public String getType() {
                return Type;
            }

            public void setType(String Type) {
                this.Type = Type;
            }

            @Override
            public String toString() {
                return "\nWatchListBean{" +
                        "IMEI='" + IMEI + '\'' +
                        ", Location='" + Location + '\'' +
                        ", Name='" + Name + '\'' +
                        ", Online='" + Online + '\'' +
                        ", PhoneNum='" + PhoneNum + '\'' +
                        ", Picture='" + Picture + '\'' +
                        ", Time='" + Time + '\'' +
                        ", Type='" + Type + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "\nResultsBean{" +
                    "Category='" + Category + '\'' +
                    ", WatchList=" + WatchList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "\nGetResult{" +
                "Results=" + Results +
                '}';
    }
}
