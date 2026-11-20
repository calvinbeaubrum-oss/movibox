package com.bytedance.sdk.openadsdk.SR.sc;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    private boolean ExN;
    private String TRI;
    private int We;
    private Sfl pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f27119qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f27120sc;
    private String zY;
    private int Qj = 0;
    private int Ol = 0;

    public boolean ExN() {
        return this.ExN;
    }

    public int Ol() {
        return this.Ol;
    }

    public int Qj() {
        return this.Qj;
    }

    public String TRI() {
        return this.TRI;
    }

    public int We() {
        return this.We;
    }

    public void We(int i11) {
        this.Ol = i11;
    }

    public Sfl pFF() {
        return this.pFF;
    }

    public void pFF(int i11) {
        this.f27119qr = i11;
    }

    public void pFF(String str) {
        this.zY = str;
    }

    public int qr() {
        return this.f27119qr;
    }

    public String sc() {
        return this.f27120sc;
    }

    public void sc(int i11) {
        this.We = i11;
    }

    public void sc(Sfl sfl) {
        this.pFF = sfl;
    }

    public void sc(String str) {
        this.f27120sc = str;
    }

    public void sc(boolean z11) {
        this.ExN = z11;
    }

    public String zY() {
        Sfl sfl;
        if (TextUtils.isEmpty(this.zY) && (sfl = this.pFF) != null) {
            this.zY = cJ.sc(sfl);
        }
        return this.zY;
    }

    public void zY(int i11) {
        this.Qj = i11;
    }

    public void zY(String str) {
        this.TRI = str;
    }
}
