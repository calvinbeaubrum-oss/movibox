package com.bytedance.sdk.component.TRI.sc.TRI;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {
    private final int ExN;
    private String Qj;
    private final String TRI;
    private boolean UFX;
    private final String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private String f26588qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26589sc;
    private final boolean zY;
    private int We = -1;
    private int Ol = 0;
    private String WH = null;

    public We(String str, String str2, boolean z11, int i11, String str3) {
        this.f26589sc = str;
        this.pFF = str2;
        this.zY = z11;
        this.ExN = i11;
        this.TRI = str3;
    }

    public int ExN() {
        return this.ExN;
    }

    public String Ol() {
        return this.Qj;
    }

    public int Qj() {
        return this.Ol;
    }

    public String TRI() {
        return this.TRI;
    }

    public boolean UFX() {
        return this.We == -1;
    }

    public boolean WH() {
        return this.UFX;
    }

    public int We() {
        return this.We;
    }

    public String pFF() {
        return this.pFF;
    }

    public void pFF(int i11) {
        this.Ol = i11;
        if (i11 == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f26588qr)) {
            this.f26588qr = String.valueOf(this.Ol);
            return;
        }
        this.f26588qr += "," + this.Ol;
    }

    public void pFF(String str) {
        this.Qj = str;
    }

    public String qr() {
        return this.f26588qr;
    }

    public Runnable sc(String str, Map<String, String> map) {
        return sc.sc().sc(this, str, map);
    }

    public String sc() {
        return this.f26589sc;
    }

    public void sc(int i11) {
        this.We = i11;
    }

    public void sc(String str) {
        this.f26588qr = str;
    }

    public void sc(boolean z11) {
        this.UFX = z11;
    }

    public void zY(String str) {
        this.WH = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.Qj)) {
            this.Qj = String.valueOf(this.WH);
            return;
        }
        this.Qj += "," + this.WH;
    }

    public boolean zY() {
        return this.zY;
    }
}
