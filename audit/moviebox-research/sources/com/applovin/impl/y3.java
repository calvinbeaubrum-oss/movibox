package com.applovin.impl;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final y3 f24490a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final y3 f24491b = new b(-1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final y3 f24492c = new b(1);

    /* JADX INFO: compiled from: source.java */
    public class a extends y3 {
        public a() {
            super(null);
        }

        public y3 a(int i11) {
            if (i11 < 0) {
                return y3.f24491b;
            }
            return i11 > 0 ? y3.f24492c : y3.f24490a;
        }

        @Override // com.applovin.impl.y3
        public y3 a(int i11, int i12) {
            return a(ub.a(i11, i12));
        }

        @Override // com.applovin.impl.y3
        public y3 a(long j11, long j12) {
            return a(sc.a(j11, j12));
        }

        @Override // com.applovin.impl.y3
        public y3 a(Object obj, Object obj2, Comparator comparator) {
            return a(comparator.compare(obj, obj2));
        }

        @Override // com.applovin.impl.y3
        public y3 a(boolean z11, boolean z12) {
            return a(k2.a(z11, z12));
        }

        @Override // com.applovin.impl.y3
        public y3 b(boolean z11, boolean z12) {
            return a(k2.a(z12, z11));
        }

        @Override // com.applovin.impl.y3
        public int d() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends y3 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f24493d;

        public b(int i11) {
            super(null);
            this.f24493d = i11;
        }

        @Override // com.applovin.impl.y3
        public y3 a(int i11, int i12) {
            return this;
        }

        @Override // com.applovin.impl.y3
        public y3 a(long j11, long j12) {
            return this;
        }

        @Override // com.applovin.impl.y3
        public y3 a(Object obj, Object obj2, Comparator comparator) {
            return this;
        }

        @Override // com.applovin.impl.y3
        public y3 a(boolean z11, boolean z12) {
            return this;
        }

        @Override // com.applovin.impl.y3
        public y3 b(boolean z11, boolean z12) {
            return this;
        }

        @Override // com.applovin.impl.y3
        public int d() {
            return this.f24493d;
        }
    }

    private y3() {
    }

    public /* synthetic */ y3(a aVar) {
        this();
    }

    public static y3 e() {
        return f24490a;
    }

    public abstract y3 a(int i11, int i12);

    public abstract y3 a(long j11, long j12);

    public abstract y3 a(Object obj, Object obj2, Comparator comparator);

    public abstract y3 a(boolean z11, boolean z12);

    public abstract y3 b(boolean z11, boolean z12);

    public abstract int d();
}
