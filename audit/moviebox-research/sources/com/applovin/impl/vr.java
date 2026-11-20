package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class vr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f23969f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f23971h;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f23978o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f23964a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f23965b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set f23966c = Collections.emptySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23967d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f23968e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f23970g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f23972i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f23973j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f23974k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f23975l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f23976m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f23977n = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f23979p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f23980q = false;

    private static int a(int i11, String str, String str2, int i12) {
        if (str.isEmpty() || i11 == -1) {
            return i11;
        }
        if (str.equals(str2)) {
            return i11 + i12;
        }
        return -1;
    }

    public int a() {
        if (this.f23972i) {
            return this.f23971h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public int a(String str, String str2, Set set, String str3) {
        if (this.f23964a.isEmpty() && this.f23965b.isEmpty() && this.f23966c.isEmpty() && this.f23967d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iA = a(a(a(0, this.f23964a, str, 1073741824), this.f23965b, str2, 2), this.f23967d, str3, 4);
        if (iA == -1 || !set.containsAll(this.f23966c)) {
            return 0;
        }
        return iA + (this.f23966c.size() * 4);
    }

    public vr a(float f11) {
        this.f23978o = f11;
        return this;
    }

    public vr a(int i11) {
        this.f23971h = i11;
        this.f23972i = true;
        return this;
    }

    public vr a(String str) {
        this.f23968e = str == null ? null : Ascii.toLowerCase(str);
        return this;
    }

    public vr a(boolean z11) {
        this.f23975l = z11 ? 1 : 0;
        return this;
    }

    public void a(String[] strArr) {
        this.f23966c = new HashSet(Arrays.asList(strArr));
    }

    public vr b(int i11) {
        this.f23969f = i11;
        this.f23970g = true;
        return this;
    }

    public vr b(boolean z11) {
        this.f23980q = z11;
        return this;
    }

    public void b(String str) {
        this.f23964a = str;
    }

    public boolean b() {
        return this.f23980q;
    }

    public int c() {
        if (this.f23970g) {
            return this.f23969f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public vr c(int i11) {
        this.f23977n = i11;
        return this;
    }

    public vr c(boolean z11) {
        this.f23976m = z11 ? 1 : 0;
        return this;
    }

    public void c(String str) {
        this.f23965b = str;
    }

    public vr d(int i11) {
        this.f23979p = i11;
        return this;
    }

    public vr d(boolean z11) {
        this.f23974k = z11 ? 1 : 0;
        return this;
    }

    public String d() {
        return this.f23968e;
    }

    public void d(String str) {
        this.f23967d = str;
    }

    public float e() {
        return this.f23978o;
    }

    public int f() {
        return this.f23977n;
    }

    public int g() {
        return this.f23979p;
    }

    public int h() {
        int i11 = this.f23975l;
        if (i11 == -1 && this.f23976m == -1) {
            return -1;
        }
        return (i11 == 1 ? 1 : 0) | (this.f23976m == 1 ? 2 : 0);
    }

    public boolean i() {
        return this.f23972i;
    }

    public boolean j() {
        return this.f23970g;
    }

    public boolean k() {
        return this.f23973j == 1;
    }

    public boolean l() {
        return this.f23974k == 1;
    }
}
