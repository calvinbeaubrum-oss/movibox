package com.applovin.impl;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f21480a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21481b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21482c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f21483d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21484e = 15;

    private void b() {
        int[] iArr = this.f21483d;
        int length = iArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int i11 = this.f21480a;
        int i12 = length2 - i11;
        System.arraycopy(iArr, i11, iArr2, 0, i12);
        System.arraycopy(this.f21483d, 0, iArr2, i12, i11);
        this.f21480a = 0;
        this.f21481b = this.f21482c - 1;
        this.f21483d = iArr2;
        this.f21484e = length - 1;
    }

    public void a() {
        this.f21480a = 0;
        this.f21481b = -1;
        this.f21482c = 0;
    }

    public void a(int i11) {
        if (this.f21482c == this.f21483d.length) {
            b();
        }
        int i12 = (this.f21481b + 1) & this.f21484e;
        this.f21481b = i12;
        this.f21483d[i12] = i11;
        this.f21482c++;
    }

    public boolean c() {
        return this.f21482c == 0;
    }

    public int d() {
        int i11 = this.f21482c;
        if (i11 == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.f21483d;
        int i12 = this.f21480a;
        int i13 = iArr[i12];
        this.f21480a = (i12 + 1) & this.f21484e;
        this.f21482c = i11 - 1;
        return i13;
    }
}
