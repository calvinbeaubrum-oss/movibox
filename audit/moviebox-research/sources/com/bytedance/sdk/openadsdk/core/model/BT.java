package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BT {
    private boolean ExN;
    private String TRI;
    private double We;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f28374sc;
    private int zY;

    public boolean ExN() {
        return !TextUtils.isEmpty(this.f28374sc) && this.pFF > 0 && this.zY > 0;
    }

    public boolean TRI() {
        return this.ExN;
    }

    public double We() {
        return this.We;
    }

    public int pFF() {
        return this.pFF;
    }

    public void pFF(int i11) {
        this.zY = i11;
    }

    public void pFF(String str) {
        this.TRI = str;
    }

    public String qr() {
        return this.TRI;
    }

    public String sc() {
        return this.f28374sc;
    }

    public void sc(int i11) {
        this.pFF = i11;
    }

    public void sc(String str) {
        this.f28374sc = str;
    }

    public void sc(boolean z11) {
        this.ExN = z11;
    }

    public int zY() {
        return this.zY;
    }
}
