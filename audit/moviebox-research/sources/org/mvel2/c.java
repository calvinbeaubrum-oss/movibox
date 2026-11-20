package org.mvel2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f73294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f73295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f73296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f73297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f73298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f73299f;

    public c(char[] cArr, int i11, boolean z11, String str) {
        this.f73294a = cArr;
        this.f73295b = i11;
        this.f73296c = z11;
        this.f73297d = str;
        a();
    }

    public void a() {
        char[] cArr;
        if ((this.f73298e != 0 && this.f73299f != 0) || (cArr = this.f73294a) == null || cArr.length == 0) {
            return;
        }
        int i11 = 1;
        int i12 = 1;
        for (int i13 = 0; i13 < this.f73295b; i13++) {
            char c11 = this.f73294a[i13];
            if (c11 == '\n') {
                i11++;
                i12 = 0;
            } else if (c11 != '\r') {
                i12++;
            }
        }
        this.f73298e = i11;
        this.f73299f = i12;
    }

    public int b() {
        return this.f73299f;
    }

    public int c() {
        return this.f73295b;
    }

    public char[] d() {
        return this.f73294a;
    }

    public int e() {
        return this.f73298e;
    }

    public String f() {
        return this.f73297d;
    }

    public boolean g() {
        return this.f73296c;
    }

    public void h(int i11) {
        this.f73299f = i11;
    }

    public void i(int i11) {
        this.f73295b = i11;
    }

    public void j(char[] cArr) {
        this.f73294a = cArr;
    }

    public void k(int i11) {
        this.f73298e = i11;
    }

    public String toString() {
        if (this.f73296c) {
            return "(" + this.f73298e + "," + this.f73299f + ") " + this.f73297d;
        }
        return "(" + this.f73298e + "," + this.f73299f + ") WARNING: " + this.f73297d;
    }
}
