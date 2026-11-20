package com.bytedance.sdk.openadsdk.core.Ol;

import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static com.bytedance.sdk.openadsdk.core.Ol.sc f28034sc;
    private String pFF;

    /* JADX INFO: compiled from: source.java */
    public static class sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private static final pFF f28035sc = new pFF();
    }

    private pFF() {
        this.pFF = null;
        f28034sc = new com.bytedance.sdk.openadsdk.core.Ol.sc();
    }

    public static pFF pFF() {
        return sc.f28035sc;
    }

    public String ExN() {
        com.bytedance.sdk.openadsdk.core.Ol.sc scVar = f28034sc;
        return scVar != null ? scVar.ExN() : "";
    }

    public long TRI() {
        com.bytedance.sdk.openadsdk.core.Ol.sc scVar = f28034sc;
        if (scVar != null) {
            return scVar.TRI();
        }
        return 0L;
    }

    public String We() {
        String strWe;
        com.bytedance.sdk.openadsdk.core.Ol.sc scVar = f28034sc;
        return (scVar == null || (strWe = scVar.We()) == null) ? "" : strWe;
    }

    public void pFF(String str) {
        com.bytedance.sdk.openadsdk.core.Ol.sc scVar;
        if (TextUtils.isEmpty(str) || (scVar = f28034sc) == null) {
            return;
        }
        scVar.pFF(str);
    }

    public int qr() {
        com.bytedance.sdk.openadsdk.core.Ol.sc scVar = f28034sc;
        if (scVar != null) {
            return scVar.qr();
        }
        return 1;
    }

    public Map<String, String> sc(String str, byte[] bArr) {
        com.bytedance.sdk.openadsdk.core.Ol.sc scVar = f28034sc;
        return scVar != null ? scVar.sc(str, bArr) : new HashMap();
    }

    public void sc() {
        com.bytedance.sdk.openadsdk.core.Ol.sc scVar = f28034sc;
        if (scVar != null) {
            scVar.zY();
        }
    }

    public void sc(MotionEvent motionEvent) {
        com.bytedance.sdk.openadsdk.core.Ol.sc scVar = f28034sc;
        if (scVar != null) {
            scVar.sc(motionEvent);
        }
    }

    public void sc(String str) {
        com.bytedance.sdk.openadsdk.core.Ol.sc scVar;
        if (TextUtils.isEmpty(str) || (scVar = f28034sc) == null) {
            return;
        }
        scVar.sc(str);
    }

    public void sc(@NonNull String str, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.Ol.sc scVar = f28034sc;
        if (scVar != null) {
            scVar.sc(str, map);
        }
    }

    public boolean zY() {
        com.bytedance.sdk.openadsdk.core.Ol.sc scVar = f28034sc;
        if (scVar == null) {
            return false;
        }
        return scVar.pFF();
    }
}
