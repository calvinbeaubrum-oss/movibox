package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class fo implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fo f19028a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o2.a f19029b = new o2.a() { // from class: com.applovin.impl.uv
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return fo.a(bundle);
        }
    };

    /* JADX INFO: compiled from: source.java */
    public class a extends fo {
        @Override // com.applovin.impl.fo
        public int a() {
            return 0;
        }

        @Override // com.applovin.impl.fo
        public int a(Object obj) {
            return -1;
        }

        @Override // com.applovin.impl.fo
        public b a(int i11, b bVar, boolean z11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.applovin.impl.fo
        public d a(int i11, d dVar, long j11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.applovin.impl.fo
        public int b() {
            return 0;
        }

        @Override // com.applovin.impl.fo
        public Object b(int i11) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements o2 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final o2.a f19030i = new o2.a() { // from class: com.applovin.impl.vv
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return fo.b.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f19032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19033c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f19034d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f19035f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f19036g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private u f19037h = u.f23439h;

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(Bundle bundle) {
            int i11 = bundle.getInt(g(0), 0);
            long j11 = bundle.getLong(g(1), C.TIME_UNSET);
            long j12 = bundle.getLong(g(2), 0L);
            boolean z11 = bundle.getBoolean(g(3));
            Bundle bundle2 = bundle.getBundle(g(4));
            u uVar = bundle2 != null ? (u) u.f23441j.a(bundle2) : u.f23439h;
            b bVar = new b();
            bVar.a(null, null, i11, j11, j12, uVar, z11);
            return bVar;
        }

        private static String g(int i11) {
            return Integer.toString(i11, 36);
        }

        public int a() {
            return this.f19037h.f23443b;
        }

        public int a(int i11) {
            return this.f19037h.a(i11).f23450b;
        }

        public int a(long j11) {
            return this.f19037h.a(j11, this.f19034d);
        }

        public long a(int i11, int i12) {
            u.a aVarA = this.f19037h.a(i11);
            return aVarA.f23450b != -1 ? aVarA.f23453f[i12] : C.TIME_UNSET;
        }

        public b a(Object obj, Object obj2, int i11, long j11, long j12) {
            return a(obj, obj2, i11, j11, j12, u.f23439h, false);
        }

        public b a(Object obj, Object obj2, int i11, long j11, long j12, u uVar, boolean z11) {
            this.f19031a = obj;
            this.f19032b = obj2;
            this.f19033c = i11;
            this.f19034d = j11;
            this.f19035f = j12;
            this.f19037h = uVar;
            this.f19036g = z11;
            return this;
        }

        public int b(int i11, int i12) {
            return this.f19037h.a(i11).a(i12);
        }

        public int b(long j11) {
            return this.f19037h.b(j11, this.f19034d);
        }

        public long b() {
            return this.f19037h.f23444c;
        }

        public long b(int i11) {
            return this.f19037h.a(i11).f23449a;
        }

        public long c() {
            return this.f19034d;
        }

        public long c(int i11) {
            return this.f19037h.a(i11).f23454g;
        }

        public int d(int i11) {
            return this.f19037h.a(i11).a();
        }

        public long d() {
            return t2.b(this.f19035f);
        }

        public long e() {
            return this.f19035f;
        }

        public boolean e(int i11) {
            return !this.f19037h.a(i11).b();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return xp.a(this.f19031a, bVar.f19031a) && xp.a(this.f19032b, bVar.f19032b) && this.f19033c == bVar.f19033c && this.f19034d == bVar.f19034d && this.f19035f == bVar.f19035f && this.f19036g == bVar.f19036g && xp.a(this.f19037h, bVar.f19037h);
        }

        public int f() {
            return this.f19037h.f23446f;
        }

        public boolean f(int i11) {
            return this.f19037h.a(i11).f23455h;
        }

        public int hashCode() {
            Object obj = this.f19031a;
            int iHashCode = ((obj == null ? 0 : obj.hashCode()) + 217) * 31;
            Object obj2 = this.f19032b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f19033c) * 31;
            long j11 = this.f19034d;
            int i11 = (iHashCode2 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f19035f;
            return ((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f19036g ? 1 : 0)) * 31) + this.f19037h.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends fo {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final eb f19038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final eb f19039d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[] f19040f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int[] f19041g;

        public c(eb ebVar, eb ebVar2, int[] iArr) {
            b1.a(ebVar.size() == iArr.length);
            this.f19038c = ebVar;
            this.f19039d = ebVar2;
            this.f19040f = iArr;
            this.f19041g = new int[iArr.length];
            for (int i11 = 0; i11 < iArr.length; i11++) {
                this.f19041g[iArr[i11]] = i11;
            }
        }

        @Override // com.applovin.impl.fo
        public int a() {
            return this.f19039d.size();
        }

        @Override // com.applovin.impl.fo
        public int a(int i11, int i12, boolean z11) {
            if (i12 == 1) {
                return i11;
            }
            if (i11 != b(z11)) {
                return z11 ? this.f19040f[this.f19041g[i11] + 1] : i11 + 1;
            }
            if (i12 == 2) {
                return a(z11);
            }
            return -1;
        }

        @Override // com.applovin.impl.fo
        public int a(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.applovin.impl.fo
        public int a(boolean z11) {
            if (c()) {
                return -1;
            }
            if (z11) {
                return this.f19040f[0];
            }
            return 0;
        }

        @Override // com.applovin.impl.fo
        public b a(int i11, b bVar, boolean z11) {
            b bVar2 = (b) this.f19039d.get(i11);
            bVar.a(bVar2.f19031a, bVar2.f19032b, bVar2.f19033c, bVar2.f19034d, bVar2.f19035f, bVar2.f19037h, bVar2.f19036g);
            return bVar;
        }

        @Override // com.applovin.impl.fo
        public d a(int i11, d dVar, long j11) {
            d dVar2 = (d) this.f19038c.get(i11);
            dVar.a(dVar2.f19046a, dVar2.f19048c, dVar2.f19049d, dVar2.f19050f, dVar2.f19051g, dVar2.f19052h, dVar2.f19053i, dVar2.f19054j, dVar2.f19056l, dVar2.f19058n, dVar2.f19059o, dVar2.f19060p, dVar2.f19061q, dVar2.f19062r);
            dVar.f19057m = dVar2.f19057m;
            return dVar;
        }

        @Override // com.applovin.impl.fo
        public int b() {
            return this.f19038c.size();
        }

        @Override // com.applovin.impl.fo
        public int b(int i11, int i12, boolean z11) {
            if (i12 == 1) {
                return i11;
            }
            if (i11 != a(z11)) {
                return z11 ? this.f19040f[this.f19041g[i11] - 1] : i11 - 1;
            }
            if (i12 == 2) {
                return b(z11);
            }
            return -1;
        }

        @Override // com.applovin.impl.fo
        public int b(boolean z11) {
            if (c()) {
                return -1;
            }
            return z11 ? this.f19040f[b() - 1] : b() - 1;
        }

        @Override // com.applovin.impl.fo
        public Object b(int i11) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements o2 {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final Object f19042s = new Object();

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static final Object f19043t = new Object();

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static final td f19044u = new td.c().b("com.applovin.exoplayer2.Timeline").a(Uri.EMPTY).a();

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final o2.a f19045v = new o2.a() { // from class: com.applovin.impl.wv
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return fo.d.a(bundle);
            }
        };

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f19047b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f19049d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f19050f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f19051g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f19052h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f19053i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f19054j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f19055k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public td.f f19056l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f19057m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f19058n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f19059o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f19060p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f19061q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f19062r;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19046a = f19042s;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public td f19048c = f19044u;

        /* JADX INFO: Access modifiers changed from: private */
        public static d a(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(a(1));
            td tdVar = bundle2 != null ? (td) td.f23245h.a(bundle2) : null;
            long j11 = bundle.getLong(a(2), C.TIME_UNSET);
            long j12 = bundle.getLong(a(3), C.TIME_UNSET);
            long j13 = bundle.getLong(a(4), C.TIME_UNSET);
            boolean z11 = bundle.getBoolean(a(5), false);
            boolean z12 = bundle.getBoolean(a(6), false);
            Bundle bundle3 = bundle.getBundle(a(7));
            td.f fVar = bundle3 != null ? (td.f) td.f.f23289h.a(bundle3) : null;
            boolean z13 = bundle.getBoolean(a(8), false);
            long j14 = bundle.getLong(a(9), 0L);
            long j15 = bundle.getLong(a(10), C.TIME_UNSET);
            int i11 = bundle.getInt(a(11), 0);
            int i12 = bundle.getInt(a(12), 0);
            long j16 = bundle.getLong(a(13), 0L);
            d dVar = new d();
            dVar.a(f19043t, tdVar, null, j11, j12, j13, z11, z12, fVar, j14, j15, i11, i12, j16);
            dVar.f19057m = z13;
            return dVar;
        }

        private static String a(int i11) {
            return Integer.toString(i11, 36);
        }

        public long a() {
            return xp.a(this.f19052h);
        }

        public d a(Object obj, td tdVar, Object obj2, long j11, long j12, long j13, boolean z11, boolean z12, td.f fVar, long j14, long j15, int i11, int i12, long j16) {
            td.g gVar;
            this.f19046a = obj;
            this.f19048c = tdVar != null ? tdVar : f19044u;
            this.f19047b = (tdVar == null || (gVar = tdVar.f23247b) == null) ? null : gVar.f23306g;
            this.f19049d = obj2;
            this.f19050f = j11;
            this.f19051g = j12;
            this.f19052h = j13;
            this.f19053i = z11;
            this.f19054j = z12;
            this.f19055k = fVar != null;
            this.f19056l = fVar;
            this.f19058n = j14;
            this.f19059o = j15;
            this.f19060p = i11;
            this.f19061q = i12;
            this.f19062r = j16;
            this.f19057m = false;
            return this;
        }

        public long b() {
            return t2.b(this.f19058n);
        }

        public long c() {
            return this.f19058n;
        }

        public long d() {
            return t2.b(this.f19059o);
        }

        public boolean e() {
            b1.b(this.f19055k == (this.f19056l != null));
            return this.f19056l != null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !d.class.equals(obj.getClass())) {
                return false;
            }
            d dVar = (d) obj;
            return xp.a(this.f19046a, dVar.f19046a) && xp.a(this.f19048c, dVar.f19048c) && xp.a(this.f19049d, dVar.f19049d) && xp.a(this.f19056l, dVar.f19056l) && this.f19050f == dVar.f19050f && this.f19051g == dVar.f19051g && this.f19052h == dVar.f19052h && this.f19053i == dVar.f19053i && this.f19054j == dVar.f19054j && this.f19057m == dVar.f19057m && this.f19058n == dVar.f19058n && this.f19059o == dVar.f19059o && this.f19060p == dVar.f19060p && this.f19061q == dVar.f19061q && this.f19062r == dVar.f19062r;
        }

        public int hashCode() {
            int iHashCode = (((this.f19046a.hashCode() + 217) * 31) + this.f19048c.hashCode()) * 31;
            Object obj = this.f19049d;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            td.f fVar = this.f19056l;
            int iHashCode3 = fVar != null ? fVar.hashCode() : 0;
            long j11 = this.f19050f;
            int i11 = (((iHashCode2 + iHashCode3) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f19051g;
            int i12 = (i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            long j13 = this.f19052h;
            int i13 = (((((((i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31) + (this.f19053i ? 1 : 0)) * 31) + (this.f19054j ? 1 : 0)) * 31) + (this.f19057m ? 1 : 0)) * 31;
            long j14 = this.f19058n;
            int i14 = (i13 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
            long j15 = this.f19059o;
            int i15 = (((((i14 + ((int) (j15 ^ (j15 >>> 32)))) * 31) + this.f19060p) * 31) + this.f19061q) * 31;
            long j16 = this.f19062r;
            return i15 + ((int) (j16 ^ (j16 >>> 32)));
        }
    }

    private static eb a(o2.a aVar, IBinder iBinder) {
        if (iBinder == null) {
            return eb.h();
        }
        eb.a aVar2 = new eb.a();
        eb ebVarA = m2.a(iBinder);
        for (int i11 = 0; i11 < ebVarA.size(); i11++) {
            aVar2.b(aVar.a((Bundle) ebVarA.get(i11)));
        }
        return aVar2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static fo a(Bundle bundle) {
        eb ebVarA = a(d.f19045v, n2.a(bundle, c(0)));
        eb ebVarA2 = a(b.f19030i, n2.a(bundle, c(1)));
        int[] intArray = bundle.getIntArray(c(2));
        if (intArray == null) {
            intArray = a(ebVarA.size());
        }
        return new c(ebVarA, ebVarA2, intArray);
    }

    private static int[] a(int i11) {
        int[] iArr = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr[i12] = i12;
        }
        return iArr;
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    public abstract int a();

    public int a(int i11, int i12, boolean z11) {
        if (i12 == 0) {
            if (i11 == b(z11)) {
                return -1;
            }
            return i11 + 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == b(z11) ? a(z11) : i11 + 1;
        }
        throw new IllegalStateException();
    }

    public final int a(int i11, b bVar, d dVar, int i12, boolean z11) {
        int i13 = a(i11, bVar).f19033c;
        if (a(i13, dVar).f19061q != i11) {
            return i11 + 1;
        }
        int iA = a(i13, i12, z11);
        if (iA == -1) {
            return -1;
        }
        return a(iA, dVar).f19060p;
    }

    public abstract int a(Object obj);

    public int a(boolean z11) {
        return c() ? -1 : 0;
    }

    public final Pair a(d dVar, b bVar, int i11, long j11) {
        return (Pair) b1.a(a(dVar, bVar, i11, j11, 0L));
    }

    public final Pair a(d dVar, b bVar, int i11, long j11, long j12) {
        b1.a(i11, 0, b());
        a(i11, dVar, j12);
        if (j11 == C.TIME_UNSET) {
            j11 = dVar.c();
            if (j11 == C.TIME_UNSET) {
                return null;
            }
        }
        int i12 = dVar.f19060p;
        a(i12, bVar);
        while (i12 < dVar.f19061q && bVar.f19035f != j11) {
            int i13 = i12 + 1;
            if (a(i13, bVar).f19035f > j11) {
                break;
            }
            i12 = i13;
        }
        a(i12, bVar, true);
        long jMin = j11 - bVar.f19035f;
        long j13 = bVar.f19034d;
        if (j13 != C.TIME_UNSET) {
            jMin = Math.min(jMin, j13 - 1);
        }
        return Pair.create(b1.a(bVar.f19032b), Long.valueOf(Math.max(0L, jMin)));
    }

    public final b a(int i11, b bVar) {
        return a(i11, bVar, false);
    }

    public abstract b a(int i11, b bVar, boolean z11);

    public b a(Object obj, b bVar) {
        return a(a(obj), bVar, true);
    }

    public final d a(int i11, d dVar) {
        return a(i11, dVar, 0L);
    }

    public abstract d a(int i11, d dVar, long j11);

    public abstract int b();

    public int b(int i11, int i12, boolean z11) {
        if (i12 == 0) {
            if (i11 == a(z11)) {
                return -1;
            }
            return i11 - 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == a(z11) ? b(z11) : i11 - 1;
        }
        throw new IllegalStateException();
    }

    public int b(boolean z11) {
        if (c()) {
            return -1;
        }
        return b() - 1;
    }

    public abstract Object b(int i11);

    public final boolean b(int i11, b bVar, d dVar, int i12, boolean z11) {
        return a(i11, bVar, dVar, i12, z11) == -1;
    }

    public final boolean c() {
        return b() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fo)) {
            return false;
        }
        fo foVar = (fo) obj;
        if (foVar.b() != b() || foVar.a() != a()) {
            return false;
        }
        d dVar = new d();
        b bVar = new b();
        d dVar2 = new d();
        b bVar2 = new b();
        for (int i11 = 0; i11 < b(); i11++) {
            if (!a(i11, dVar).equals(foVar.a(i11, dVar2))) {
                return false;
            }
        }
        for (int i12 = 0; i12 < a(); i12++) {
            if (!a(i12, bVar, true).equals(foVar.a(i12, bVar2, true))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        d dVar = new d();
        b bVar = new b();
        int iB = b() + 217;
        for (int i11 = 0; i11 < b(); i11++) {
            iB = (iB * 31) + a(i11, dVar).hashCode();
        }
        int iA = (iB * 31) + a();
        for (int i12 = 0; i12 < a(); i12++) {
            iA = (iA * 31) + a(i12, bVar, true).hashCode();
        }
        return iA;
    }
}
