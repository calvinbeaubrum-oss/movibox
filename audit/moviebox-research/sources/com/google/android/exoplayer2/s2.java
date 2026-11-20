package com.google.android.exoplayer2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class s2 extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f33725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f33726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f33727i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f33728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j3[] f33729k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object[] f33730l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap<Object, Integer> f33731m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s2(Collection<? extends e2> collection, nh.e0 e0Var) {
        super(false, e0Var);
        int iT = 0;
        int size = collection.size();
        this.f33727i = new int[size];
        this.f33728j = new int[size];
        this.f33729k = new j3[size];
        this.f33730l = new Object[size];
        this.f33731m = new HashMap<>();
        int iM = 0;
        int i11 = 0;
        for (e2 e2Var : collection) {
            this.f33729k[i11] = e2Var.b();
            this.f33728j[i11] = iT;
            this.f33727i[i11] = iM;
            iT += this.f33729k[i11].t();
            iM += this.f33729k[i11].m();
            this.f33730l[i11] = e2Var.a();
            this.f33731m.put(this.f33730l[i11], Integer.valueOf(i11));
            i11++;
        }
        this.f33725g = iT;
        this.f33726h = iM;
    }

    @Override // com.google.android.exoplayer2.a
    public int A(int i11) {
        return com.google.android.exoplayer2.util.o0.h(this.f33728j, i11 + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.a
    public Object D(int i11) {
        return this.f33730l[i11];
    }

    @Override // com.google.android.exoplayer2.a
    public int F(int i11) {
        return this.f33727i[i11];
    }

    @Override // com.google.android.exoplayer2.a
    public int G(int i11) {
        return this.f33728j[i11];
    }

    @Override // com.google.android.exoplayer2.a
    public j3 J(int i11) {
        return this.f33729k[i11];
    }

    public List<j3> K() {
        return Arrays.asList(this.f33729k);
    }

    @Override // com.google.android.exoplayer2.j3
    public int m() {
        return this.f33726h;
    }

    @Override // com.google.android.exoplayer2.j3
    public int t() {
        return this.f33725g;
    }

    @Override // com.google.android.exoplayer2.a
    public int y(Object obj) {
        Integer num = this.f33731m.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.exoplayer2.a
    public int z(int i11) {
        return com.google.android.exoplayer2.util.o0.h(this.f33727i, i11 + 1, false, false);
    }
}
