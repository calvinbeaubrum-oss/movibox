package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class to {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final so[] f23421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23422c;

    public to(so... soVarArr) {
        this.f23421b = soVarArr;
        this.f23420a = soVarArr.length;
    }

    public so a(int i11) {
        return this.f23421b[i11];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || to.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f23421b, ((to) obj).f23421b);
    }

    public int hashCode() {
        if (this.f23422c == 0) {
            this.f23422c = Arrays.hashCode(this.f23421b) + 527;
        }
        return this.f23422c;
    }
}
