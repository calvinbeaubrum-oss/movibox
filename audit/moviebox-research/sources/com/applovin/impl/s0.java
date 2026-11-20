package com.applovin.impl;

import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Objects;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface s0 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f22209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final fo f22210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f22211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final be.a f22212d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f22213e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final fo f22214f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f22215g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final be.a f22216h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f22217i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f22218j;

        public a(long j11, fo foVar, int i11, be.a aVar, long j12, fo foVar2, int i12, be.a aVar2, long j13, long j14) {
            this.f22209a = j11;
            this.f22210b = foVar;
            this.f22211c = i11;
            this.f22212d = aVar;
            this.f22213e = j12;
            this.f22214f = foVar2;
            this.f22215g = i12;
            this.f22216h = aVar2;
            this.f22217i = j13;
            this.f22218j = j14;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f22209a == aVar.f22209a && this.f22211c == aVar.f22211c && this.f22213e == aVar.f22213e && this.f22215g == aVar.f22215g && this.f22217i == aVar.f22217i && this.f22218j == aVar.f22218j && Objects.equal(this.f22210b, aVar.f22210b) && Objects.equal(this.f22212d, aVar.f22212d) && Objects.equal(this.f22214f, aVar.f22214f) && Objects.equal(this.f22216h, aVar.f22216h);
        }

        public int hashCode() {
            return Objects.hashCode(Long.valueOf(this.f22209a), this.f22210b, Integer.valueOf(this.f22211c), this.f22212d, Long.valueOf(this.f22213e), this.f22214f, Integer.valueOf(this.f22215g), this.f22216h, Long.valueOf(this.f22217i), Long.valueOf(this.f22218j));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b9 f22219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SparseArray f22220b;

        public b(b9 b9Var, SparseArray sparseArray) {
            this.f22219a = b9Var;
            SparseArray sparseArray2 = new SparseArray(b9Var.a());
            for (int i11 = 0; i11 < b9Var.a(); i11++) {
                int iB = b9Var.b(i11);
                sparseArray2.append(iB, (a) b1.a((a) sparseArray.get(iB)));
            }
            this.f22220b = sparseArray2;
        }
    }

    void a(qh qhVar, b bVar);

    void a(a aVar);

    void a(a aVar, float f11);

    void a(a aVar, int i11);

    void a(a aVar, int i11, int i12);

    void a(a aVar, int i11, int i12, int i13, float f11);

    void a(a aVar, int i11, long j11);

    void a(a aVar, int i11, long j11, long j12);

    void a(a aVar, int i11, f9 f9Var);

    void a(a aVar, int i11, n5 n5Var);

    void a(a aVar, int i11, String str, long j11);

    void a(a aVar, long j11);

    void a(a aVar, long j11, int i11);

    void a(a aVar, bf bfVar);

    void a(a aVar, f9 f9Var);

    void a(a aVar, f9 f9Var, q5 q5Var);

    void a(a aVar, n5 n5Var);

    void a(a aVar, nc ncVar, ud udVar);

    void a(a aVar, nc ncVar, ud udVar, IOException iOException, boolean z11);

    void a(a aVar, nh nhVar);

    void a(a aVar, ph phVar);

    void a(a aVar, po poVar, to toVar);

    void a(a aVar, qh.b bVar);

    void a(a aVar, qh.f fVar, qh.f fVar2, int i11);

    void a(a aVar, td tdVar, int i11);

    void a(a aVar, ud udVar);

    void a(a aVar, vd vdVar);

    void a(a aVar, xq xqVar);

    void a(a aVar, Exception exc);

    void a(a aVar, Object obj, long j11);

    void a(a aVar, String str);

    void a(a aVar, String str, long j11);

    void a(a aVar, String str, long j11, long j12);

    void a(a aVar, boolean z11);

    void a(a aVar, boolean z11, int i11);

    void b(a aVar);

    void b(a aVar, int i11);

    void b(a aVar, int i11, long j11, long j12);

    void b(a aVar, int i11, n5 n5Var);

    void b(a aVar, f9 f9Var);

    void b(a aVar, f9 f9Var, q5 q5Var);

    void b(a aVar, n5 n5Var);

    void b(a aVar, nc ncVar, ud udVar);

    void b(a aVar, Exception exc);

    void b(a aVar, String str);

    void b(a aVar, String str, long j11);

    void b(a aVar, String str, long j11, long j12);

    void b(a aVar, boolean z11);

    void b(a aVar, boolean z11, int i11);

    void c(a aVar);

    void c(a aVar, int i11);

    void c(a aVar, n5 n5Var);

    void c(a aVar, nc ncVar, ud udVar);

    void c(a aVar, Exception exc);

    void c(a aVar, boolean z11);

    void d(a aVar);

    void d(a aVar, int i11);

    void d(a aVar, n5 n5Var);

    void d(a aVar, Exception exc);

    void d(a aVar, boolean z11);

    void e(a aVar);

    void e(a aVar, int i11);

    void e(a aVar, boolean z11);

    void f(a aVar);

    void f(a aVar, int i11);

    void g(a aVar);

    void h(a aVar);
}
