package com.cloud.hisavana.sdk.data.bean.request;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CodeSeatDTO {
    private int adCount;
    private int adPriority;
    private Map<String, Object> extInfo;
    private String gameName;
    private String gameScene;
    private int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f29639id;
    private boolean offlineAdEnable;
    private int type;
    private SdkVideo video;
    private int width;

    public int getAdCount() {
        return this.adCount;
    }

    public int getAdPriority() {
        return this.adPriority;
    }

    public Map<String, Object> getExtInfo() {
        return this.extInfo;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getGameScene() {
        return this.gameScene;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.f29639id;
    }

    public int getType() {
        return this.type;
    }

    public SdkVideo getVideo() {
        return this.video;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isOfflineAdEnable() {
        return this.offlineAdEnable;
    }

    public void setAdCount(int i11) {
        this.adCount = i11;
    }

    public void setAdPriority(int i11) {
        this.adPriority = i11;
    }

    public void setExtInfo(Map<String, Object> map) {
        this.extInfo = map;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGameScene(String str) {
        this.gameScene = str;
    }

    public void setHeight(int i11) {
        this.height = i11;
    }

    public void setId(String str) {
        this.f29639id = str;
    }

    public void setOfflineAdEnable(boolean z11) {
        this.offlineAdEnable = z11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setVideo(SdkVideo sdkVideo) {
        this.video = sdkVideo;
    }

    public void setWidth(int i11) {
        this.width = i11;
    }
}
