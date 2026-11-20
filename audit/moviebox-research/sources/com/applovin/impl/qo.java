package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface qo {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f21968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f21969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f21970d;

        public a(int i11, byte[] bArr, int i12, int i13) {
            this.f21967a = i11;
            this.f21968b = bArr;
            this.f21969c = i12;
            this.f21970d = i13;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f21967a == aVar.f21967a && this.f21969c == aVar.f21969c && this.f21970d == aVar.f21970d && Arrays.equals(this.f21968b, aVar.f21968b);
        }

        public int hashCode() {
            return (((((this.f21967a * 31) + Arrays.hashCode(this.f21968b)) * 31) + this.f21969c) * 31) + this.f21970d;
        }
    }

    int a(g5 g5Var, int i11, boolean z11);

    int a(g5 g5Var, int i11, boolean z11, int i12);

    void a(long j11, int i11, int i12, int i13, a aVar);

    void a(bh bhVar, int i11);

    void a(bh bhVar, int i11, int i12);

    void a(f9 f9Var);
}
