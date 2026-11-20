package com.applovin.impl;

import android.text.Layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class jp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f20004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f20006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f20007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f20008e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f20014k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f20015l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Layout.Alignment f20018o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Layout.Alignment f20019p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private xn f20021r;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f20009f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f20010g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20011h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20012i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f20013j = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f20016m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f20017n = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f20020q = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f20022s = Float.MAX_VALUE;

    private jp a(jp jpVar, boolean z11) {
        int i11;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (jpVar != null) {
            if (!this.f20006c && jpVar.f20006c) {
                b(jpVar.f20005b);
            }
            if (this.f20011h == -1) {
                this.f20011h = jpVar.f20011h;
            }
            if (this.f20012i == -1) {
                this.f20012i = jpVar.f20012i;
            }
            if (this.f20004a == null && (str = jpVar.f20004a) != null) {
                this.f20004a = str;
            }
            if (this.f20009f == -1) {
                this.f20009f = jpVar.f20009f;
            }
            if (this.f20010g == -1) {
                this.f20010g = jpVar.f20010g;
            }
            if (this.f20017n == -1) {
                this.f20017n = jpVar.f20017n;
            }
            if (this.f20018o == null && (alignment2 = jpVar.f20018o) != null) {
                this.f20018o = alignment2;
            }
            if (this.f20019p == null && (alignment = jpVar.f20019p) != null) {
                this.f20019p = alignment;
            }
            if (this.f20020q == -1) {
                this.f20020q = jpVar.f20020q;
            }
            if (this.f20013j == -1) {
                this.f20013j = jpVar.f20013j;
                this.f20014k = jpVar.f20014k;
            }
            if (this.f20021r == null) {
                this.f20021r = jpVar.f20021r;
            }
            if (this.f20022s == Float.MAX_VALUE) {
                this.f20022s = jpVar.f20022s;
            }
            if (z11 && !this.f20008e && jpVar.f20008e) {
                a(jpVar.f20007d);
            }
            if (z11 && this.f20016m == -1 && (i11 = jpVar.f20016m) != -1) {
                this.f20016m = i11;
            }
        }
        return this;
    }

    public int a() {
        if (this.f20008e) {
            return this.f20007d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public jp a(float f11) {
        this.f20014k = f11;
        return this;
    }

    public jp a(int i11) {
        this.f20007d = i11;
        this.f20008e = true;
        return this;
    }

    public jp a(Layout.Alignment alignment) {
        this.f20019p = alignment;
        return this;
    }

    public jp a(jp jpVar) {
        return a(jpVar, true);
    }

    public jp a(xn xnVar) {
        this.f20021r = xnVar;
        return this;
    }

    public jp a(String str) {
        this.f20004a = str;
        return this;
    }

    public jp a(boolean z11) {
        this.f20011h = z11 ? 1 : 0;
        return this;
    }

    public int b() {
        if (this.f20006c) {
            return this.f20005b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public jp b(float f11) {
        this.f20022s = f11;
        return this;
    }

    public jp b(int i11) {
        this.f20005b = i11;
        this.f20006c = true;
        return this;
    }

    public jp b(Layout.Alignment alignment) {
        this.f20018o = alignment;
        return this;
    }

    public jp b(String str) {
        this.f20015l = str;
        return this;
    }

    public jp b(boolean z11) {
        this.f20012i = z11 ? 1 : 0;
        return this;
    }

    public jp c(int i11) {
        this.f20013j = i11;
        return this;
    }

    public jp c(boolean z11) {
        this.f20009f = z11 ? 1 : 0;
        return this;
    }

    public String c() {
        return this.f20004a;
    }

    public float d() {
        return this.f20014k;
    }

    public jp d(int i11) {
        this.f20017n = i11;
        return this;
    }

    public jp d(boolean z11) {
        this.f20020q = z11 ? 1 : 0;
        return this;
    }

    public int e() {
        return this.f20013j;
    }

    public jp e(int i11) {
        this.f20016m = i11;
        return this;
    }

    public jp e(boolean z11) {
        this.f20010g = z11 ? 1 : 0;
        return this;
    }

    public String f() {
        return this.f20015l;
    }

    public Layout.Alignment g() {
        return this.f20019p;
    }

    public int h() {
        return this.f20017n;
    }

    public int i() {
        return this.f20016m;
    }

    public float j() {
        return this.f20022s;
    }

    public int k() {
        int i11 = this.f20011h;
        if (i11 == -1 && this.f20012i == -1) {
            return -1;
        }
        return (i11 == 1 ? 1 : 0) | (this.f20012i == 1 ? 2 : 0);
    }

    public Layout.Alignment l() {
        return this.f20018o;
    }

    public boolean m() {
        return this.f20020q == 1;
    }

    public xn n() {
        return this.f20021r;
    }

    public boolean o() {
        return this.f20008e;
    }

    public boolean p() {
        return this.f20006c;
    }

    public boolean q() {
        return this.f20009f == 1;
    }

    public boolean r() {
        return this.f20010g == 1;
    }
}
