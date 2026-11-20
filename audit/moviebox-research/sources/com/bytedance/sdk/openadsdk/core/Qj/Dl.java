package com.bytedance.sdk.openadsdk.core.Qj;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Dl implements com.bytedance.sdk.openadsdk.core.UFX.ExN.zY {
    private String TRI;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f28044sc = 0;
    private long pFF = 0;
    private int zY = 0;
    private String We = null;
    private String ExN = null;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final AtomicBoolean f28043qr = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.zY
    public void pFF(String str) {
        this.ExN = str;
        this.pFF = SystemClock.elapsedRealtime();
        this.f28043qr.set(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.zY
    public void sc(int i11, String str, String str2) {
        this.zY = i11;
        this.We = str;
        this.ExN = str2;
        this.pFF = SystemClock.elapsedRealtime();
        this.f28043qr.set(false);
    }

    public void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str) {
        if (this.f28043qr.get()) {
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, false, str, "success", this.pFF - this.f28044sc, this.ExN, this.TRI, 0, null);
        } else {
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, false, str, "fail", this.pFF - this.f28044sc, this.ExN, this.TRI, this.zY, this.We);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.zY
    public void sc(String str) {
        this.TRI = str;
        this.f28044sc = SystemClock.elapsedRealtime();
    }
}
