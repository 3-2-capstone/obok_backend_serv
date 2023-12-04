package com.example.img_test.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Data {
    private MsgBody msgBody;

    public Data() {
        this.msgBody = new MsgBody();
    }


    @JsonProperty("MsgBody")
    public MsgBody getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(MsgBody msgBody) {
        this.msgBody = msgBody;
    }

    public static class MsgBody {
        private List<MsgItem> items;

        public MsgBody() {
            // 기본 생성자를 통해 초기화
            this.items = List.of(
                    new MsgItem(36.37234148651351,127.33916474404471,List.of("10","17")),
                    new MsgItem(36.372480719597334,127.33452964396974,List.of("14","16","20")),
                    new MsgItem(36.369547997405284,127.33431651218476,List.of("14","18","19")),
                    new MsgItem(36.364145556079215,127.33428225888733,List.of("11","12","13")),
                    new MsgItem(36.3615117236892,127.33514006694628,List.of("10","21")),
                    new MsgItem(36.35954717795019,127.33190612832428,List.of("21")),
                    new MsgItem(36.37846271962652,127.31870238398638,List.of("16","17")),
                    new MsgItem(36.3756918272033,127.31522530031033,List.of("13","14")),
                    new MsgItem(36.37152899281538,127.31670729105267,List.of("18","19","20","21")),
                    new MsgItem(36.36844196591037,127.32195425162705,List.of("19")),
                    new MsgItem(36.366841954775786,127.3153567394925,List.of("13","14")),
                    new MsgItem(36.387206650458346,127.30740853428344,List.of("19","22")),
                    new MsgItem(36.39244796313544,127.31223325923413,List.of("10","11")),
                    new MsgItem(36.38639929375412,127.31804374941196,List.of("10","11")),
                    new MsgItem(36.387178383001824,127.35040265247876,List.of("19","20")),
                    new MsgItem(36.412851780470845,127.33820912071864,List.of("11","12")),
                    new MsgItem(36.39787714403915,127.40134847177765,List.of("6","11","19")),
                    new MsgItem(36.386053709193845,127.37932004078219,List.of("17","18")),
                    new MsgItem(36.37591750210777,127.38294276432728,List.of("15","16")),
                    new MsgItem(36.3766941375774,127.3935334687434,List.of("12")),
                    new MsgItem(36.368966018795945,127.38120381526355,List.of("14")),
                    new MsgItem(36.36611527485649,127.37360737130274,List.of("16","20")),
                    new MsgItem(36.363590413859406,127.37122200441027,List.of("19","20")),
                    new MsgItem(36.36166285157685,127.37810415428814,List.of("16","17")),
                    new MsgItem(36.357170458730856,127.37092969510574,List.of("9","16")),
                    new MsgItem(36.35556378522015,127.36296732817482,List.of("20","21")),
                    new MsgItem(36.356684397671394,127.35893939502779,List.of("17","21")),
                    new MsgItem(36.354205340385064,127.35620406146765,List.of("16","17","18","19")),
                    new MsgItem(36.34662113951658,127.38128981497096,List.of("13","20")),
                    new MsgItem(36.344175778503875,127.38368958842744,List.of("8","11")),
                    new MsgItem(36.34384339370811,127.38894019460366,List.of("17","18","19")),
                    new MsgItem(36.347296506465234,127.38844493188084,List.of("20")),
                    new MsgItem(36.350139364760764,127.38924444600875,List.of("21","22")),
                    new MsgItem(36.35668309235629,127.3494999548665,List.of("18","21")),
                    new MsgItem(36.34611822978321,127.3884418643402,List.of("15","21")),
                    new MsgItem(36.34579470227207,127.39367591481177,List.of("16","21")),
                    new MsgItem(36.34000791667192,127.38715839650209,List.of("14","17")),
                    new MsgItem(36.33829387653621,127.39323160471675,List.of("19")),
                    new MsgItem(36.33137553976957,127.38965506389694,List.of("20","21")),
                    new MsgItem(36.32865818710267,127.38136654995283,List.of("19","20","21")),
                    new MsgItem(36.331643370101595,127.37206442339637,List.of("14")),
                    new MsgItem(36.32348469034567,127.37733776056668,List.of("20")),
                    new MsgItem(36.323547722385875,127.36869054394019,List.of("21")),
                    new MsgItem(36.320572021113406,127.37362653074753,List.of("13","21")),
                    new MsgItem(36.317075066020614,127.37518553091697,List.of("16","20")),
                    new MsgItem(36.309706716114114,127.37699856438475,List.of("14","19","21")),
                    new MsgItem(36.344450394424086,127.43443970189637,List.of("9","10","17")),
                    new MsgItem(36.354706681333234,127.43911460959146,List.of("20","22")),
                    new MsgItem(36.365374241755454,127.43974280659172,List.of("8","18")),
                    new MsgItem(36.37433152408592,127.42742366029958,List.of("21","22")),
                    new MsgItem(36.35913402040538,127.41442187836209,List.of("19")),
                    new MsgItem(36.34373203452316,127.43248631932285,List.of("16","17","20")),
                    new MsgItem(36.31657804436149,127.46297563515056,List.of("15","18")),
                    new MsgItem(36.30370309478259,127.45754422429907,List.of("20")),
                    new MsgItem(36.29584818876235,127.38775275230549,List.of("14","21")),
                    new MsgItem(36.300595011292245,127.37866366653512,List.of("13","19","20")),
                    new MsgItem(36.303713098387874,127.36416037390806,List.of("17","18","21")),
                    new MsgItem(36.30627476728232,127.34826167538267,List.of("13","17")),
                    new MsgItem(36.30829850731282,127.3370527881833,List.of("15","20")),
                    new MsgItem(36.29901964875298,127.34064780752284,List.of("11")),
                    new MsgItem(36.29493668610606,127.33608243728365,List.of("15","21")),
                    new MsgItem(36.30177697712958,127.31869348925187,List.of("7"))
                    );
        }

        public List<MsgItem> getItems() {
            return items;
        }

        public void setItems(List<MsgItem> items) {
            this.items = items;
        }
    }

    public static class MsgItem {
        private double latitude;
        private double longitude;
        private List<String> regDtTm; // 시간대를 배열로 변경

        public MsgItem() {
            // 기본 생성자 추가
        }

        public MsgItem(double latitude, double longitude,List<String> regDtTm) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.regDtTm = regDtTm;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public List<String> getRegDtTm() {
            return regDtTm;
        }

        public void setRegDtTm(List<String> regDtTm) {
            this.regDtTm = regDtTm;
        }
    }
}
