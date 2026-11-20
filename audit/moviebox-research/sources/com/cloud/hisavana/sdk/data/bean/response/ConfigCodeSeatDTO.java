package com.cloud.hisavana.sdk.data.bean.response;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ConfigCodeSeatDTO {
    private int adRequestVer;
    private String adSeatType;
    private Integer adShowCountLimit;
    private String applicationId;
    private Integer carouselCount;
    private Integer carouselTime;
    private String codeSeatId;
    private Integer codeSeatType;
    private Boolean crosslevelComparison;
    private volatile int currentShowTimes;
    private String date;
    private Integer fillTimeoutDuration;
    private String h5AdUrl;
    private Boolean isDefaultConfig;
    private transient String json;
    private Boolean lastOfflineAdEnable;
    private long lastRequestAdTime;
    private volatile long lastShowAdTime;
    private volatile int localOfflineAdCacheCount;
    private Integer offlineAdCacheCount;
    private boolean offlineAdEnable;
    private Integer offlineAdRequestCount;
    private Integer offlineAdRequestTimeInterval;
    private Integer offlineAdRequestTimeIntervalNoAd;
    private Boolean priorityH5Ad;
    private Integer showInterval;
    private boolean isAdRequestFail = true;
    private int pictureDelayCloseTime = 0;
    private int videoDelayCloseTime = 0;

    public int getAdRequestVer() {
        return this.adRequestVer;
    }

    public String getAdSeatType() {
        return this.adSeatType;
    }

    public Integer getAdShowCountLimit() {
        Integer num = this.adShowCountLimit;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public Integer getCarouselCount() {
        Integer num = this.carouselCount;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getCarouselTime() {
        Integer num = this.carouselTime;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getCodeSeatId() {
        return this.codeSeatId;
    }

    public Integer getCodeSeatType() {
        Integer num = this.codeSeatType;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Boolean getCrosslevelComparison() {
        Boolean bool = this.crosslevelComparison;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public int getCurrentShowTimes() {
        return this.currentShowTimes;
    }

    public String getDate() {
        return TextUtils.isEmpty(this.date) ? "0" : this.date;
    }

    public Boolean getDefaultConfig() {
        return this.isDefaultConfig;
    }

    public Integer getFillTimeoutDuration() {
        Integer num = this.fillTimeoutDuration;
        return Integer.valueOf(num == null ? 5000 : num.intValue());
    }

    public String getH5AdUrl() {
        return this.h5AdUrl;
    }

    public String getJson() {
        return this.json;
    }

    public Boolean getLastOfflineAdEnable() {
        Boolean bool = this.lastOfflineAdEnable;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public long getLastRequestAdTime() {
        return this.lastRequestAdTime;
    }

    public long getLastShowAdTime() {
        return this.lastShowAdTime;
    }

    public int getLocalOfflineAdCacheCount() {
        return this.localOfflineAdCacheCount;
    }

    public Integer getOfflineAdCacheCount() {
        Integer num = this.offlineAdCacheCount;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getOfflineAdRequestCount() {
        Integer num = this.offlineAdRequestCount;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getOfflineAdRequestTimeInterval() {
        Integer num = this.offlineAdRequestTimeInterval;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getOfflineAdRequestTimeIntervalNoAd() {
        Integer num = this.offlineAdRequestTimeIntervalNoAd;
        return Integer.valueOf(num == null ? 0 : num.intValue() * 3600);
    }

    public int getPictureDelayCloseTime() {
        return this.pictureDelayCloseTime;
    }

    public Integer getShowInterval() {
        Integer num = this.showInterval;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getVideoDelayCloseTime() {
        return this.videoDelayCloseTime;
    }

    public boolean isAdRequestFail() {
        return this.isAdRequestFail;
    }

    public boolean isOfflineAdEnable() {
        return this.offlineAdEnable;
    }

    public Boolean isPriorityH5Ad() {
        Boolean bool = this.priorityH5Ad;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public void setAdRequestFail(boolean z11) {
        this.isAdRequestFail = z11;
    }

    public void setAdRequestVer(int i11) {
        this.adRequestVer = i11;
    }

    public void setAdSeatType(String str) {
        this.adSeatType = str;
    }

    public void setAdShowCountLimit(Integer num) {
        this.adShowCountLimit = num;
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public void setCarouselCount(Integer num) {
        this.carouselCount = num;
    }

    public void setCarouselTime(Integer num) {
        this.carouselTime = num;
    }

    public void setCodeSeatId(String str) {
        this.codeSeatId = str;
    }

    public void setCodeSeatType(Integer num) {
        this.codeSeatType = num;
    }

    public void setCrosslevelComparison(Boolean bool) {
        this.crosslevelComparison = bool;
    }

    public void setCurrentShowTimes(int i11) {
        this.currentShowTimes = i11;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDefaultConfig(Boolean bool) {
        this.isDefaultConfig = bool;
    }

    public void setFillTimeoutDuration(Integer num) {
        this.fillTimeoutDuration = num;
    }

    public void setH5AdUrl(String str) {
        this.h5AdUrl = str;
    }

    public void setJson(String str) {
        this.json = str;
    }

    public void setLastOfflineAdEnable(Boolean bool) {
        this.lastOfflineAdEnable = bool;
    }

    public void setLastRequestAdTime(long j11) {
        this.lastRequestAdTime = j11;
    }

    public void setLastShowAdTime(long j11) {
        this.lastShowAdTime = j11;
    }

    public void setLocalOfflineAdCacheCount(int i11) {
        this.localOfflineAdCacheCount = i11;
    }

    public void setOfflineAdCacheCount(Integer num) {
        this.offlineAdCacheCount = num;
    }

    public void setOfflineAdEnable(boolean z11) {
        this.offlineAdEnable = z11;
    }

    public void setOfflineAdRequestCount(Integer num) {
        this.offlineAdRequestCount = num;
    }

    public void setOfflineAdRequestTimeInterval(Integer num) {
        this.offlineAdRequestTimeInterval = num;
    }

    public void setOfflineAdRequestTimeIntervalNoAd(Integer num) {
        this.offlineAdRequestTimeIntervalNoAd = num;
    }

    public void setPriorityH5Ad(Boolean bool) {
        this.priorityH5Ad = bool;
    }

    public void setShowInterval(Integer num) {
        this.showInterval = num;
    }

    public String toString() {
        return "ConfigCodeSeatDTO{applicationId='" + this.applicationId + "', codeSeatId='" + this.codeSeatId + "', codeSeatType=" + this.codeSeatType + ", adSeatType='" + this.adSeatType + "', offlineAdEnable=" + this.offlineAdEnable + ", offlineAdCacheCount=" + this.offlineAdCacheCount + ", offlineAdRequestCount=" + this.offlineAdRequestCount + ", offlineAdRequestTimeInterval=" + this.offlineAdRequestTimeInterval + ", offlineAdRequestTimeIntervalNoAd=" + this.offlineAdRequestTimeIntervalNoAd + ", isAdRequestFail=" + this.isAdRequestFail + ", adShowCountLimit=" + this.adShowCountLimit + ", currentShowTimes=" + this.currentShowTimes + ", date='" + this.date + "', lastRequestAdTime=" + this.lastRequestAdTime + ", carouselTime=" + this.carouselTime + ", carouselCount=" + this.carouselCount + ", showInterval=" + this.showInterval + ", lastShowAdTime=" + this.lastShowAdTime + ", fillTimeoutDuration=" + this.fillTimeoutDuration + ", localOfflineAdCacheCount=" + this.localOfflineAdCacheCount + ", lastOfflineAdEnable=" + this.lastOfflineAdEnable + ", crosslevelComparison =" + this.crosslevelComparison + ", priorityH5Ad =" + this.priorityH5Ad + ", h5AdUrl =" + this.h5AdUrl + ", pictureDelayCloseTime =" + this.pictureDelayCloseTime + ", videoDelayCloseTime =" + this.videoDelayCloseTime + '}';
    }
}
