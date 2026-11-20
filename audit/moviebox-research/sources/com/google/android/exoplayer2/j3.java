package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class j3 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j3 f33359a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g.a<j3> f33360b = new g.a() { // from class: com.google.android.exoplayer2.i3
        @Override // com.google.android.exoplayer2.g.a
        public final g a(Bundle bundle) {
            return j3.b(bundle);
        }
    };

    /* JADX INFO: compiled from: source.java */
    public class a extends j3 {
        @Override // com.google.android.exoplayer2.j3
        public int f(Object obj) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.j3
        public b k(int i11, b bVar, boolean z11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.j3
        public int m() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.j3
        public Object q(int i11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.j3
        public d s(int i11, d dVar, long j11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.j3
        public int t() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements g {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final g.a<b> f33361i = new g.a() { // from class: com.google.android.exoplayer2.k3
            @Override // com.google.android.exoplayer2.g.a
            public final g a(Bundle bundle) {
                return j3.b.c(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Object f33362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Object f33363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f33364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f33365d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f33366f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f33367g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public oh.c f33368h = oh.c.f72417h;

        public static b c(Bundle bundle) {
            int i11 = bundle.getInt(u(0), 0);
            long j11 = bundle.getLong(u(1), C.TIME_UNSET);
            long j12 = bundle.getLong(u(2), 0L);
            boolean z11 = bundle.getBoolean(u(3));
            Bundle bundle2 = bundle.getBundle(u(4));
            oh.c cVar = bundle2 != null ? (oh.c) oh.c.f72419j.a(bundle2) : oh.c.f72417h;
            b bVar = new b();
            bVar.w(null, null, i11, j11, j12, cVar, z11);
            return bVar;
        }

        private static String u(int i11) {
            return Integer.toString(i11, 36);
        }

        public int d(int i11) {
            return this.f33368h.c(i11).f72428b;
        }

        public long e(int i11, int i12) {
            oh.c.a aVarC = this.f33368h.c(i11);
            return aVarC.f72428b != -1 ? aVarC.f72431f[i12] : C.TIME_UNSET;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return com.google.android.exoplayer2.util.o0.c(this.f33362a, bVar.f33362a) && com.google.android.exoplayer2.util.o0.c(this.f33363b, bVar.f33363b) && this.f33364c == bVar.f33364c && this.f33365d == bVar.f33365d && this.f33366f == bVar.f33366f && this.f33367g == bVar.f33367g && com.google.android.exoplayer2.util.o0.c(this.f33368h, bVar.f33368h);
        }

        public int f() {
            return this.f33368h.f72421b;
        }

        public int g(long j11) {
            return this.f33368h.d(j11, this.f33365d);
        }

        public int h(long j11) {
            return this.f33368h.e(j11, this.f33365d);
        }

        public int hashCode() {
            Object obj = this.f33362a;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f33363b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f33364c) * 31;
            long j11 = this.f33365d;
            int i11 = (iHashCode2 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f33366f;
            return ((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f33367g ? 1 : 0)) * 31) + this.f33368h.hashCode();
        }

        public long i(int i11) {
            return this.f33368h.c(i11).f72427a;
        }

        public long j() {
            return this.f33368h.f72422c;
        }

        public int k(int i11, int i12) {
            oh.c.a aVarC = this.f33368h.c(i11);
            if (aVarC.f72428b != -1) {
                return aVarC.f72430d[i12];
            }
            return 0;
        }

        public long l(int i11) {
            return this.f33368h.c(i11).f72432g;
        }

        public long m() {
            return this.f33365d;
        }

        public int n(int i11) {
            return this.f33368h.c(i11).e();
        }

        public int o(int i11, int i12) {
            return this.f33368h.c(i11).f(i12);
        }

        public long p() {
            return com.google.android.exoplayer2.util.o0.f1(this.f33366f);
        }

        public long q() {
            return this.f33366f;
        }

        public int r() {
            return this.f33368h.f72424f;
        }

        public boolean s(int i11) {
            return !this.f33368h.c(i11).g();
        }

        public boolean t(int i11) {
            return this.f33368h.c(i11).f72433h;
        }

        @Override // com.google.android.exoplayer2.g
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(u(0), this.f33364c);
            bundle.putLong(u(1), this.f33365d);
            bundle.putLong(u(2), this.f33366f);
            bundle.putBoolean(u(3), this.f33367g);
            bundle.putBundle(u(4), this.f33368h.toBundle());
            return bundle;
        }

        public b v(@Nullable Object obj, @Nullable Object obj2, int i11, long j11, long j12) {
            return w(obj, obj2, i11, j11, j12, oh.c.f72417h, false);
        }

        public b w(@Nullable Object obj, @Nullable Object obj2, int i11, long j11, long j12, oh.c cVar, boolean z11) {
            this.f33362a = obj;
            this.f33363b = obj2;
            this.f33364c = i11;
            this.f33365d = j11;
            this.f33366f = j12;
            this.f33368h = cVar;
            this.f33367g = z11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends j3 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImmutableList<d> f33369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImmutableList<b> f33370d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f33371f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int[] f33372g;

        public c(ImmutableList<d> immutableList, ImmutableList<b> immutableList2, int[] iArr) {
            com.google.android.exoplayer2.util.a.a(immutableList.size() == iArr.length);
            this.f33369c = immutableList;
            this.f33370d = immutableList2;
            this.f33371f = iArr;
            this.f33372g = new int[iArr.length];
            for (int i11 = 0; i11 < iArr.length; i11++) {
                this.f33372g[iArr[i11]] = i11;
            }
        }

        @Override // com.google.android.exoplayer2.j3
        public int e(boolean z11) {
            if (u()) {
                return -1;
            }
            if (z11) {
                return this.f33371f[0];
            }
            return 0;
        }

        @Override // com.google.android.exoplayer2.j3
        public int f(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.j3
        public int g(boolean z11) {
            if (u()) {
                return -1;
            }
            return z11 ? this.f33371f[t() - 1] : t() - 1;
        }

        @Override // com.google.android.exoplayer2.j3
        public int i(int i11, int i12, boolean z11) {
            if (i12 == 1) {
                return i11;
            }
            if (i11 != g(z11)) {
                return z11 ? this.f33371f[this.f33372g[i11] + 1] : i11 + 1;
            }
            if (i12 == 2) {
                return e(z11);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.j3
        public b k(int i11, b bVar, boolean z11) {
            b bVar2 = this.f33370d.get(i11);
            bVar.w(bVar2.f33362a, bVar2.f33363b, bVar2.f33364c, bVar2.f33365d, bVar2.f33366f, bVar2.f33368h, bVar2.f33367g);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.j3
        public int m() {
            return this.f33370d.size();
        }

        @Override // com.google.android.exoplayer2.j3
        public int p(int i11, int i12, boolean z11) {
            if (i12 == 1) {
                return i11;
            }
            if (i11 != e(z11)) {
                return z11 ? this.f33371f[this.f33372g[i11] - 1] : i11 - 1;
            }
            if (i12 == 2) {
                return g(z11);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.j3
        public Object q(int i11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.j3
        public d s(int i11, d dVar, long j11) {
            d dVar2 = this.f33369c.get(i11);
            dVar.k(dVar2.f33377a, dVar2.f33379c, dVar2.f33380d, dVar2.f33381f, dVar2.f33382g, dVar2.f33383h, dVar2.f33384i, dVar2.f33385j, dVar2.f33387l, dVar2.f33389n, dVar2.f33390o, dVar2.f33391p, dVar2.f33392q, dVar2.f33393r);
            dVar.f33388m = dVar2.f33388m;
            return dVar;
        }

        @Override // com.google.android.exoplayer2.j3
        public int t() {
            return this.f33369c.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements g {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final Object f33373s = new Object();

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final Object f33374t = new Object();

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final u1 f33375u = new u1.c().d("com.google.android.exoplayer2.Timeline").i(Uri.EMPTY).a();

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final g.a<d> f33376v = new g.a() { // from class: com.google.android.exoplayer2.l3
            @Override // com.google.android.exoplayer2.g.a
            public final g a(Bundle bundle) {
                return j3.d.c(bundle);
            }
        };

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        @Deprecated
        public Object f33378b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Object f33380d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f33381f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f33382g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f33383h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f33384i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f33385j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Deprecated
        public boolean f33386k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        public u1.g f33387l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f33388m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f33389n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f33390o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f33391p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f33392q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f33393r;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f33377a = f33373s;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public u1 f33379c = f33375u;

        public static d c(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(j(1));
            u1 u1Var = bundle2 != null ? (u1) u1.f34774k.a(bundle2) : null;
            long j11 = bundle.getLong(j(2), C.TIME_UNSET);
            long j12 = bundle.getLong(j(3), C.TIME_UNSET);
            long j13 = bundle.getLong(j(4), C.TIME_UNSET);
            boolean z11 = bundle.getBoolean(j(5), false);
            boolean z12 = bundle.getBoolean(j(6), false);
            Bundle bundle3 = bundle.getBundle(j(7));
            u1.g gVar = bundle3 != null ? (u1.g) u1.g.f34828h.a(bundle3) : null;
            boolean z13 = bundle.getBoolean(j(8), false);
            long j14 = bundle.getLong(j(9), 0L);
            long j15 = bundle.getLong(j(10), C.TIME_UNSET);
            int i11 = bundle.getInt(j(11), 0);
            int i12 = bundle.getInt(j(12), 0);
            long j16 = bundle.getLong(j(13), 0L);
            d dVar = new d();
            dVar.k(f33374t, u1Var, null, j11, j12, j13, z11, z12, gVar, j14, j15, i11, i12, j16);
            dVar.f33388m = z13;
            return dVar;
        }

        private static String j(int i11) {
            return Integer.toString(i11, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle l(boolean z11) {
            Bundle bundle = new Bundle();
            bundle.putBundle(j(1), (z11 ? u1.f34773j : this.f33379c).toBundle());
            bundle.putLong(j(2), this.f33381f);
            bundle.putLong(j(3), this.f33382g);
            bundle.putLong(j(4), this.f33383h);
            bundle.putBoolean(j(5), this.f33384i);
            bundle.putBoolean(j(6), this.f33385j);
            u1.g gVar = this.f33387l;
            if (gVar != null) {
                bundle.putBundle(j(7), gVar.toBundle());
            }
            bundle.putBoolean(j(8), this.f33388m);
            bundle.putLong(j(9), this.f33389n);
            bundle.putLong(j(10), this.f33390o);
            bundle.putInt(j(11), this.f33391p);
            bundle.putInt(j(12), this.f33392q);
            bundle.putLong(j(13), this.f33393r);
            return bundle;
        }

        public long d() {
            return com.google.android.exoplayer2.util.o0.b0(this.f33383h);
        }

        public long e() {
            return com.google.android.exoplayer2.util.o0.f1(this.f33389n);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !d.class.equals(obj.getClass())) {
                return false;
            }
            d dVar = (d) obj;
            return com.google.android.exoplayer2.util.o0.c(this.f33377a, dVar.f33377a) && com.google.android.exoplayer2.util.o0.c(this.f33379c, dVar.f33379c) && com.google.android.exoplayer2.util.o0.c(this.f33380d, dVar.f33380d) && com.google.android.exoplayer2.util.o0.c(this.f33387l, dVar.f33387l) && this.f33381f == dVar.f33381f && this.f33382g == dVar.f33382g && this.f33383h == dVar.f33383h && this.f33384i == dVar.f33384i && this.f33385j == dVar.f33385j && this.f33388m == dVar.f33388m && this.f33389n == dVar.f33389n && this.f33390o == dVar.f33390o && this.f33391p == dVar.f33391p && this.f33392q == dVar.f33392q && this.f33393r == dVar.f33393r;
        }

        public long f() {
            return this.f33389n;
        }

        public long g() {
            return com.google.android.exoplayer2.util.o0.f1(this.f33390o);
        }

        public long h() {
            return this.f33393r;
        }

        public int hashCode() {
            int iHashCode = (((217 + this.f33377a.hashCode()) * 31) + this.f33379c.hashCode()) * 31;
            Object obj = this.f33380d;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            u1.g gVar = this.f33387l;
            int iHashCode3 = (iHashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j11 = this.f33381f;
            int i11 = (iHashCode3 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f33382g;
            int i12 = (i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            long j13 = this.f33383h;
            int i13 = (((((((i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31) + (this.f33384i ? 1 : 0)) * 31) + (this.f33385j ? 1 : 0)) * 31) + (this.f33388m ? 1 : 0)) * 31;
            long j14 = this.f33389n;
            int i14 = (i13 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
            long j15 = this.f33390o;
            int i15 = (((((i14 + ((int) (j15 ^ (j15 >>> 32)))) * 31) + this.f33391p) * 31) + this.f33392q) * 31;
            long j16 = this.f33393r;
            return i15 + ((int) (j16 ^ (j16 >>> 32)));
        }

        public boolean i() {
            com.google.android.exoplayer2.util.a.g(this.f33386k == (this.f33387l != null));
            return this.f33387l != null;
        }

        public d k(Object obj, @Nullable u1 u1Var, @Nullable Object obj2, long j11, long j12, long j13, boolean z11, boolean z12, @Nullable u1.g gVar, long j14, long j15, int i11, int i12, long j16) {
            u1.h hVar;
            this.f33377a = obj;
            this.f33379c = u1Var != null ? u1Var : f33375u;
            this.f33378b = (u1Var == null || (hVar = u1Var.f34776b) == null) ? null : hVar.f34846h;
            this.f33380d = obj2;
            this.f33381f = j11;
            this.f33382g = j12;
            this.f33383h = j13;
            this.f33384i = z11;
            this.f33385j = z12;
            this.f33386k = gVar != null;
            this.f33387l = gVar;
            this.f33389n = j14;
            this.f33390o = j15;
            this.f33391p = i11;
            this.f33392q = i12;
            this.f33393r = j16;
            this.f33388m = false;
            return this;
        }

        @Override // com.google.android.exoplayer2.g
        public Bundle toBundle() {
            return l(false);
        }
    }

    public static j3 b(Bundle bundle) {
        ImmutableList immutableListC = c(d.f33376v, com.google.android.exoplayer2.util.c.a(bundle, w(0)));
        ImmutableList immutableListC2 = c(b.f33361i, com.google.android.exoplayer2.util.c.a(bundle, w(1)));
        int[] intArray = bundle.getIntArray(w(2));
        if (intArray == null) {
            intArray = d(immutableListC.size());
        }
        return new c(immutableListC, immutableListC2, intArray);
    }

    public static <T extends g> ImmutableList<T> c(g.a<T> aVar, @Nullable IBinder iBinder) {
        if (iBinder == null) {
            return ImmutableList.of();
        }
        ImmutableList.a aVar2 = new ImmutableList.a();
        ImmutableList<Bundle> immutableListA = f.a(iBinder);
        for (int i11 = 0; i11 < immutableListA.size(); i11++) {
            aVar2.a(aVar.a(immutableListA.get(i11)));
        }
        return aVar2.m();
    }

    public static int[] d(int i11) {
        int[] iArr = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr[i12] = i12;
        }
        return iArr;
    }

    private static String w(int i11) {
        return Integer.toString(i11, 36);
    }

    public int e(boolean z11) {
        return u() ? -1 : 0;
    }

    public boolean equals(@Nullable Object obj) {
        int iG;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j3)) {
            return false;
        }
        j3 j3Var = (j3) obj;
        if (j3Var.t() != t() || j3Var.m() != m()) {
            return false;
        }
        d dVar = new d();
        b bVar = new b();
        d dVar2 = new d();
        b bVar2 = new b();
        for (int i11 = 0; i11 < t(); i11++) {
            if (!r(i11, dVar).equals(j3Var.r(i11, dVar2))) {
                return false;
            }
        }
        for (int i12 = 0; i12 < m(); i12++) {
            if (!k(i12, bVar, true).equals(j3Var.k(i12, bVar2, true))) {
                return false;
            }
        }
        int iE = e(true);
        if (iE != j3Var.e(true) || (iG = g(true)) != j3Var.g(true)) {
            return false;
        }
        while (iE != iG) {
            int i13 = i(iE, 0, true);
            if (i13 != j3Var.i(iE, 0, true)) {
                return false;
            }
            iE = i13;
        }
        return true;
    }

    public abstract int f(Object obj);

    public int g(boolean z11) {
        if (u()) {
            return -1;
        }
        return t() - 1;
    }

    public final int h(int i11, b bVar, d dVar, int i12, boolean z11) {
        int i13 = j(i11, bVar).f33364c;
        if (r(i13, dVar).f33392q != i11) {
            return i11 + 1;
        }
        int i14 = i(i13, i12, z11);
        if (i14 == -1) {
            return -1;
        }
        return r(i14, dVar).f33391p;
    }

    public int hashCode() {
        d dVar = new d();
        b bVar = new b();
        int iT = 217 + t();
        for (int i11 = 0; i11 < t(); i11++) {
            iT = (iT * 31) + r(i11, dVar).hashCode();
        }
        int iM = (iT * 31) + m();
        for (int i12 = 0; i12 < m(); i12++) {
            iM = (iM * 31) + k(i12, bVar, true).hashCode();
        }
        int iE = e(true);
        while (iE != -1) {
            iM = (iM * 31) + iE;
            iE = i(iE, 0, true);
        }
        return iM;
    }

    public int i(int i11, int i12, boolean z11) {
        if (i12 == 0) {
            if (i11 == g(z11)) {
                return -1;
            }
            return i11 + 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == g(z11) ? e(z11) : i11 + 1;
        }
        throw new IllegalStateException();
    }

    public final b j(int i11, b bVar) {
        return k(i11, bVar, false);
    }

    public abstract b k(int i11, b bVar, boolean z11);

    public b l(Object obj, b bVar) {
        return k(f(obj), bVar, true);
    }

    public abstract int m();

    public final Pair<Object, Long> n(d dVar, b bVar, int i11, long j11) {
        return (Pair) com.google.android.exoplayer2.util.a.e(o(dVar, bVar, i11, j11, 0L));
    }

    @Nullable
    public final Pair<Object, Long> o(d dVar, b bVar, int i11, long j11, long j12) {
        com.google.android.exoplayer2.util.a.c(i11, 0, t());
        s(i11, dVar, j12);
        if (j11 == C.TIME_UNSET) {
            j11 = dVar.f();
            if (j11 == C.TIME_UNSET) {
                return null;
            }
        }
        int i12 = dVar.f33391p;
        j(i12, bVar);
        while (i12 < dVar.f33392q && bVar.f33366f != j11) {
            int i13 = i12 + 1;
            if (j(i13, bVar).f33366f > j11) {
                break;
            }
            i12 = i13;
        }
        k(i12, bVar, true);
        long jMin = j11 - bVar.f33366f;
        long j13 = bVar.f33365d;
        if (j13 != C.TIME_UNSET) {
            jMin = Math.min(jMin, j13 - 1);
        }
        return Pair.create(com.google.android.exoplayer2.util.a.e(bVar.f33363b), Long.valueOf(Math.max(0L, jMin)));
    }

    public int p(int i11, int i12, boolean z11) {
        if (i12 == 0) {
            if (i11 == e(z11)) {
                return -1;
            }
            return i11 - 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == e(z11) ? g(z11) : i11 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object q(int i11);

    public final d r(int i11, d dVar) {
        return s(i11, dVar, 0L);
    }

    public abstract d s(int i11, d dVar, long j11);

    public abstract int t();

    @Override // com.google.android.exoplayer2.g
    public final Bundle toBundle() {
        return x(false);
    }

    public final boolean u() {
        return t() == 0;
    }

    public final boolean v(int i11, b bVar, d dVar, int i12, boolean z11) {
        return h(i11, bVar, dVar, i12, z11) == -1;
    }

    public final Bundle x(boolean z11) {
        ArrayList arrayList = new ArrayList();
        int iT = t();
        d dVar = new d();
        for (int i11 = 0; i11 < iT; i11++) {
            arrayList.add(s(i11, dVar, 0L).l(z11));
        }
        ArrayList arrayList2 = new ArrayList();
        int iM = m();
        b bVar = new b();
        for (int i12 = 0; i12 < iM; i12++) {
            arrayList2.add(k(i12, bVar, false).toBundle());
        }
        int[] iArr = new int[iT];
        if (iT > 0) {
            iArr[0] = e(true);
        }
        for (int i13 = 1; i13 < iT; i13++) {
            iArr[i13] = i(iArr[i13 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        com.google.android.exoplayer2.util.c.c(bundle, w(0), new f(arrayList));
        com.google.android.exoplayer2.util.c.c(bundle, w(1), new f(arrayList2));
        bundle.putIntArray(w(2), iArr);
        return bundle;
    }
}
