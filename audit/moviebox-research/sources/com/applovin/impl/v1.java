package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f23727b;

    public v1(int i11, float f11) {
        this.f23726a = i11;
        this.f23727b = f11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v1.class != obj.getClass()) {
            return false;
        }
        v1 v1Var = (v1) obj;
        return this.f23726a == v1Var.f23726a && Float.compare(v1Var.f23727b, this.f23727b) == 0;
    }

    public int hashCode() {
        return ((this.f23726a + 527) * 31) + Float.floatToIntBits(this.f23727b);
    }
}
