package com.bytedance.sdk.component.Qj.zY.sc;

import android.text.TextUtils;
import com.bytedance.sdk.component.Qj.zY.pFF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private long ExN;
    private long TRI;
    private long We;
    private int pFF = 0;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f26581sc;
    private long zY;

    public long ExN() {
        return this.ExN;
    }

    public long TRI() {
        return this.TRI;
    }

    public long We() {
        return this.We;
    }

    public int pFF() {
        return this.pFF;
    }

    public String sc() {
        return this.f26581sc;
    }

    public void sc(pFF pff) {
        synchronized (this) {
            try {
                if (TextUtils.isEmpty(this.f26581sc)) {
                    this.f26581sc = pff.pFF();
                }
                this.zY += pff.TRI();
                this.We += pff.qr();
                this.ExN = Math.max(this.ExN, pff.TRI());
                this.TRI = Math.max(this.TRI, pff.qr());
                this.pFF++;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        pff.TRI();
        pff.qr();
        toString();
    }

    public String toString() {
        return this.f26581sc + " times=" + this.pFF + ",waitMaxTime=" + this.ExN + ",runMaxTime=" + this.TRI + ",runTotalTime=" + this.We + ",waitTotalTime=" + this.zY;
    }

    public long zY() {
        return this.zY;
    }
}
