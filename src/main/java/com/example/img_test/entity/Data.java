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
                    new MsgItem("대전광역시 대덕구 신탄진동로24번길 42", "미설치", 36.445968, 127.432271, "대덕경찰서", "대전 대덕구", 1081776314, "2017-01-31", "어린이집", "042-608-5293", "하늘꿈대전어린이집"),
                    new MsgItem("대전광역시 대덕구 벚꽃길 148", "미설치", 36.425082, 127.427008, "대덕경찰서", "대전 대덕구", 1081776313, "2017-01-31", "어린이집", "042-608-5293", "코레일대전어린이집"),
                    new MsgItem("대전광역시 대덕구 동서대로1778번길 8", "설치", 36.353562, 127.445281, "대덕경찰서", "대전 대덕구", 1081776312, "2017-01-31", "어린이집", "042-608-5293", "새봄어린이집")
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
        private String address;
        private String cctv;
        private double latitude;
        private double longitude;
        private String manageCop;
        private String manageInstitution;
        private long ntatcSeq;
        private String regDtTm;
        private String section;
        private String tel;
        private String title;

        public MsgItem() {
            // 기본 생성자 추가
        }

        public MsgItem(String address, String cctv, double latitude, double longitude, String manageCop, String manageInstitution, long ntatcSeq, String regDtTm, String section, String tel, String title) {
            this.address = address;
            this.cctv = cctv;
            this.latitude = latitude;
            this.longitude = longitude;
            this.manageCop = manageCop;
            this.manageInstitution = manageInstitution;
            this.ntatcSeq = ntatcSeq;
            this.regDtTm = regDtTm;
            this.section = section;
            this.tel = tel;
            this.title = title;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCctv() {
            return cctv;
        }

        public void setCctv(String cctv) {
            this.cctv = cctv;
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

        public String getManageCop() {
            return manageCop;
        }

        public void setManageCop(String manageCop) {
            this.manageCop = manageCop;
        }

        public String getManageInstitution() {
            return manageInstitution;
        }

        public void setManageInstitution(String manageInstitution) {
            this.manageInstitution = manageInstitution;
        }

        public long getNtatcSeq() {
            return ntatcSeq;
        }

        public void setNtatcSeq(long ntatcSeq) {
            this.ntatcSeq = ntatcSeq;
        }

        public String getRegDtTm() {
            return regDtTm;
        }

        public void setRegDtTm(String regDtTm) {
            this.regDtTm = regDtTm;
        }

        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
