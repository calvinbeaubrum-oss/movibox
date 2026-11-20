package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class kj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final kj f20255c = new kj(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f20256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f20257b;

    public kj(long j11, long j12) {
        this.f20256a = j11;
        this.f20257b = j12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || kj.class != obj.getClass()) {
            return false;
        }
        kj kjVar = (kj) obj;
        return this.f20256a == kjVar.f20256a && this.f20257b == kjVar.f20257b;
    }

    public int hashCode() {
        return (((int) this.f20256a) * 31) + ((int) this.f20257b);
    }

    public String toString() {
        return "[timeUs=" + this.f20256a + ", position=" + this.f20257b + "]";
    }
}
