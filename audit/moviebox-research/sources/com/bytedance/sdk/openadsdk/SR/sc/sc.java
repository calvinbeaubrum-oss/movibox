package com.bytedance.sdk.openadsdk.SR.sc;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    String BT;
    float ExN;
    float Ol;
    float Qj;
    float Ql;
    int SR;
    int TRI;
    float Tf;
    float UFX;
    int WH;
    float We;
    int Xc;
    float dE;
    int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    float f27121qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    String f27122sc;
    float zY;
    int wjp = -1;
    String Sfl = "";

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.SR.sc.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0269sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        sc f27123sc = new sc();

        public C0269sc ExN(float f11) {
            this.f27123sc.ExN(f11);
            return this;
        }

        public C0269sc Ol(float f11) {
            this.f27123sc.Ol(f11);
            return this;
        }

        public C0269sc Qj(float f11) {
            this.f27123sc.Qj(f11);
            return this;
        }

        public C0269sc TRI(float f11) {
            this.f27123sc.TRI(f11);
            return this;
        }

        public C0269sc WH(float f11) {
            this.f27123sc.WH(f11);
            return this;
        }

        public C0269sc We(float f11) {
            this.f27123sc.We(f11);
            return this;
        }

        public C0269sc pFF(float f11) {
            this.f27123sc.pFF(f11);
            return this;
        }

        public C0269sc pFF(int i11) {
            this.f27123sc.ExN(i11);
            return this;
        }

        public C0269sc pFF(String str) {
            this.f27123sc.zY(str);
            return this;
        }

        public C0269sc qr(float f11) {
            this.f27123sc.qr(f11);
            return this;
        }

        public C0269sc sc(float f11) {
            this.f27123sc.sc(f11);
            return this;
        }

        public C0269sc sc(int i11) {
            this.f27123sc.pFF(i11);
            return this;
        }

        public C0269sc sc(String str) {
            this.f27123sc.pFF(str);
            return this;
        }

        public sc sc() {
            return this.f27123sc;
        }

        public C0269sc zY(float f11) {
            this.f27123sc.zY(f11);
            return this;
        }

        public C0269sc zY(int i11) {
            this.f27123sc.TRI(i11);
            return this;
        }
    }

    public BigDecimal BT() {
        return new BigDecimal(this.Ql).setScale(3, RoundingMode.HALF_UP);
    }

    public float ExN() {
        return this.zY;
    }

    public void ExN(float f11) {
        this.Qj = f11;
    }

    public void ExN(int i11) {
        this.SR = i11;
    }

    public float Ol() {
        return this.f27121qr;
    }

    public void Ol(float f11) {
        this.Ql = f11;
    }

    public int Qj() {
        return this.TRI;
    }

    public void Qj(float f11) {
        this.Tf = f11;
    }

    public float Ql() {
        return this.UFX;
    }

    public float SR() {
        return this.Tf;
    }

    public int Sfl() {
        return this.Xc;
    }

    public float TRI() {
        return this.We;
    }

    public void TRI(float f11) {
        this.Ol = f11;
    }

    public void TRI(int i11) {
        this.Xc = i11;
    }

    public int Tf() {
        return this.WH;
    }

    public float UFX() {
        return this.Ol;
    }

    public float WH() {
        return this.Qj;
    }

    public void WH(float f11) {
        this.dE = f11;
    }

    public int We() {
        return this.pFF;
    }

    public void We(float f11) {
        this.f27121qr = f11;
    }

    public void We(int i11) {
        this.WH = i11;
    }

    public String Xc() {
        return this.BT;
    }

    public int dE() {
        return this.SR;
    }

    public String pFF() {
        return this.Sfl;
    }

    public void pFF(float f11) {
        this.We = f11;
    }

    public void pFF(int i11) {
        this.pFF = i11;
    }

    public void pFF(String str) {
        this.f27122sc = str;
    }

    public float qr() {
        return this.ExN;
    }

    public void qr(float f11) {
        this.UFX = f11;
    }

    public int sc() {
        return this.wjp;
    }

    public void sc(float f11) {
        this.zY = f11;
    }

    public void sc(int i11) {
        this.wjp = i11;
    }

    public void sc(String str) {
        this.Sfl = str;
    }

    public float wjp() {
        return this.dE;
    }

    public String zY() {
        return this.f27122sc;
    }

    public void zY(float f11) {
        this.ExN = f11;
    }

    public void zY(int i11) {
        this.TRI = i11;
    }

    public void zY(String str) {
        this.BT = str;
    }
}
