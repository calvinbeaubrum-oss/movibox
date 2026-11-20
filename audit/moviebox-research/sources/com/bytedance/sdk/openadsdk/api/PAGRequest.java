package com.bytedance.sdk.openadsdk.api;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PAGRequest {
    private Map<String, Object> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f27650sc;
    private Bundle zY = null;

    public final void addNetworkExtrasBundle(Class<?> cls, Bundle bundle) {
        if (this.zY == null) {
            this.zY = new Bundle();
        }
        this.zY.putBundle(cls.getName(), bundle);
    }

    public String getAdString() {
        return this.f27650sc;
    }

    public Map<String, Object> getExtraInfo() {
        return this.pFF;
    }

    public Bundle getNetworkExtrasBundle() {
        return this.zY;
    }

    public void setAdString(String str) {
        this.f27650sc = str;
    }

    public void setExtraInfo(Map<String, Object> map) {
        this.pFF = map;
    }
}
