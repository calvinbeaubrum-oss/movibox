package com.bytedance.sdk.component.adexpress.pFF;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SR {
    private boolean BT;
    private double ExN;
    private float Ol;
    private float Qj;
    private String Ql;
    private int SR;
    private double TRI;
    private double Tf;
    private double UFX;
    private float WH;
    private double We;
    private View dE;
    private boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private float f26884qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26885sc;
    private double zY;

    public float BT() {
        return this.WH;
    }

    public double ExN() {
        return this.We;
    }

    public void ExN(double d11) {
        this.UFX = d11;
    }

    public double Ol() {
        return this.Tf;
    }

    public double Qj() {
        return this.UFX;
    }

    public float Ql() {
        return this.Qj;
    }

    public float SR() {
        return this.Ol;
    }

    public double TRI() {
        return this.ExN;
    }

    public void TRI(double d11) {
        this.Tf = d11;
    }

    public float Tf() {
        return this.f26884qr;
    }

    public int UFX() {
        return this.SR;
    }

    public String WH() {
        return this.Ql;
    }

    public double We() {
        return this.zY;
    }

    public void We(double d11) {
        this.TRI = d11;
    }

    public void We(float f11) {
        this.WH = f11;
    }

    public int pFF() {
        return this.f26885sc;
    }

    public void pFF(double d11) {
        this.We = d11;
    }

    public void pFF(float f11) {
        this.Qj = f11;
    }

    public void pFF(int i11) {
        this.SR = i11;
    }

    public void pFF(boolean z11) {
        if (this.BT) {
            return;
        }
        this.BT = z11;
    }

    public double qr() {
        return this.TRI;
    }

    public View sc() {
        return this.dE;
    }

    public void sc(double d11) {
        this.zY = d11;
    }

    public void sc(float f11) {
        this.f26884qr = f11;
    }

    public void sc(int i11) {
        this.f26885sc = i11;
    }

    public void sc(View view) {
        this.dE = view;
    }

    public void sc(String str) {
        this.Ql = str;
    }

    public void sc(boolean z11) {
        this.pFF = z11;
    }

    public void zY(double d11) {
        this.ExN = d11;
    }

    public void zY(float f11) {
        this.Ol = f11;
    }

    public boolean zY() {
        return this.pFF;
    }
}
