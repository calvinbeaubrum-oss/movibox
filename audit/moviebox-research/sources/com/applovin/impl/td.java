package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class td implements o2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final td f23244g = new c().a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final o2.a f23245h = new o2.a() { // from class: com.applovin.impl.f60
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return td.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f23247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f23248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vd f23249d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f23250f;

    /* JADX INFO: compiled from: source.java */
    public static final class b {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f23251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Uri f23252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f23253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f23254d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f23255e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f23256f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f23257g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f23258h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private e.a f23259i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List f23260j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f23261k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private List f23262l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Object f23263m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private vd f23264n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private f.a f23265o;

        public c() {
            this.f23255e = Long.MIN_VALUE;
            this.f23259i = new e.a();
            this.f23260j = Collections.emptyList();
            this.f23262l = Collections.emptyList();
            this.f23265o = new f.a();
        }

        private c(td tdVar) {
            this();
            d dVar = tdVar.f23250f;
            this.f23255e = dVar.f23268b;
            this.f23256f = dVar.f23269c;
            this.f23257g = dVar.f23270d;
            this.f23254d = dVar.f23267a;
            this.f23258h = dVar.f23271f;
            this.f23251a = tdVar.f23246a;
            this.f23264n = tdVar.f23249d;
            this.f23265o = tdVar.f23248c.a();
            g gVar = tdVar.f23247b;
            if (gVar != null) {
                this.f23261k = gVar.f23304e;
                this.f23253c = gVar.f23301b;
                this.f23252b = gVar.f23300a;
                this.f23260j = gVar.f23303d;
                this.f23262l = gVar.f23305f;
                this.f23263m = gVar.f23306g;
                e eVar = gVar.f23302c;
                this.f23259i = eVar != null ? eVar.a() : new e.a();
            }
        }

        public c a(Uri uri) {
            this.f23252b = uri;
            return this;
        }

        public c a(Object obj) {
            this.f23263m = obj;
            return this;
        }

        public c a(String str) {
            this.f23261k = str;
            return this;
        }

        public td a() {
            g gVar;
            b1.b(this.f23259i.f23281b == null || this.f23259i.f23280a != null);
            Uri uri = this.f23252b;
            if (uri != null) {
                gVar = new g(uri, this.f23253c, this.f23259i.f23280a != null ? this.f23259i.a() : null, null, this.f23260j, this.f23261k, this.f23262l, this.f23263m);
            } else {
                gVar = null;
            }
            String str = this.f23251a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            d dVar = new d(this.f23254d, this.f23255e, this.f23256f, this.f23257g, this.f23258h);
            f fVarA = this.f23265o.a();
            vd vdVar = this.f23264n;
            if (vdVar == null) {
                vdVar = vd.H;
            }
            return new td(str2, dVar, gVar, fVarA, vdVar);
        }

        public c b(String str) {
            this.f23251a = (String) b1.a((Object) str);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements o2 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final o2.a f23266g = new o2.a() { // from class: com.applovin.impl.g60
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return td.d.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f23267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f23268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f23269c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f23270d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f23271f;

        private d(long j11, long j12, boolean z11, boolean z12, boolean z13) {
            this.f23267a = j11;
            this.f23268b = j12;
            this.f23269c = z11;
            this.f23270d = z12;
            this.f23271f = z13;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ d a(Bundle bundle) {
            return new d(bundle.getLong(a(0), 0L), bundle.getLong(a(1), Long.MIN_VALUE), bundle.getBoolean(a(2), false), bundle.getBoolean(a(3), false), bundle.getBoolean(a(4), false));
        }

        private static String a(int i11) {
            return Integer.toString(i11, 36);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f23267a == dVar.f23267a && this.f23268b == dVar.f23268b && this.f23269c == dVar.f23269c && this.f23270d == dVar.f23270d && this.f23271f == dVar.f23271f;
        }

        public int hashCode() {
            long j11 = this.f23267a;
            int i11 = ((int) (j11 ^ (j11 >>> 32))) * 31;
            long j12 = this.f23268b;
            return ((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f23269c ? 1 : 0)) * 31) + (this.f23270d ? 1 : 0)) * 31) + (this.f23271f ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f23272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f23273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final gb f23274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f23275d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f23276e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f23277f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final eb f23278g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final byte[] f23279h;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private UUID f23280a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Uri f23281b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private gb f23282c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f23283d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f23284e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f23285f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private eb f23286g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private byte[] f23287h;

            private a() {
                this.f23282c = gb.h();
                this.f23286g = eb.h();
            }

            private a(e eVar) {
                this.f23280a = eVar.f23272a;
                this.f23281b = eVar.f23273b;
                this.f23282c = eVar.f23274c;
                this.f23283d = eVar.f23275d;
                this.f23284e = eVar.f23276e;
                this.f23285f = eVar.f23277f;
                this.f23286g = eVar.f23278g;
                this.f23287h = eVar.f23279h;
            }

            public e a() {
                return new e(this);
            }
        }

        private e(a aVar) {
            b1.b((aVar.f23285f && aVar.f23281b == null) ? false : true);
            this.f23272a = (UUID) b1.a(aVar.f23280a);
            this.f23273b = aVar.f23281b;
            this.f23274c = aVar.f23282c;
            this.f23275d = aVar.f23283d;
            this.f23277f = aVar.f23285f;
            this.f23276e = aVar.f23284e;
            this.f23278g = aVar.f23286g;
            this.f23279h = aVar.f23287h != null ? Arrays.copyOf(aVar.f23287h, aVar.f23287h.length) : null;
        }

        public a a() {
            return new a();
        }

        public byte[] b() {
            byte[] bArr = this.f23279h;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f23272a.equals(eVar.f23272a) && xp.a(this.f23273b, eVar.f23273b) && xp.a(this.f23274c, eVar.f23274c) && this.f23275d == eVar.f23275d && this.f23277f == eVar.f23277f && this.f23276e == eVar.f23276e && this.f23278g.equals(eVar.f23278g) && Arrays.equals(this.f23279h, eVar.f23279h);
        }

        public int hashCode() {
            int iHashCode = this.f23272a.hashCode() * 31;
            Uri uri = this.f23273b;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f23274c.hashCode()) * 31) + (this.f23275d ? 1 : 0)) * 31) + (this.f23277f ? 1 : 0)) * 31) + (this.f23276e ? 1 : 0)) * 31) + this.f23278g.hashCode()) * 31) + Arrays.hashCode(this.f23279h);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements o2 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final f f23288g = new a().a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final o2.a f23289h = new o2.a() { // from class: com.applovin.impl.h60
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return td.f.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f23290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f23291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f23292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f23293d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f23294f;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f23295a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f23296b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private long f23297c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private float f23298d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private float f23299e;

            public a() {
                this.f23295a = C.TIME_UNSET;
                this.f23296b = C.TIME_UNSET;
                this.f23297c = C.TIME_UNSET;
                this.f23298d = -3.4028235E38f;
                this.f23299e = -3.4028235E38f;
            }

            private a(f fVar) {
                this.f23295a = fVar.f23290a;
                this.f23296b = fVar.f23291b;
                this.f23297c = fVar.f23292c;
                this.f23298d = fVar.f23293d;
                this.f23299e = fVar.f23294f;
            }

            public f a() {
                return new f(this);
            }
        }

        public f(long j11, long j12, long j13, float f11, float f12) {
            this.f23290a = j11;
            this.f23291b = j12;
            this.f23292c = j13;
            this.f23293d = f11;
            this.f23294f = f12;
        }

        private f(a aVar) {
            this(aVar.f23295a, aVar.f23296b, aVar.f23297c, aVar.f23298d, aVar.f23299e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ f a(Bundle bundle) {
            return new f(bundle.getLong(a(0), C.TIME_UNSET), bundle.getLong(a(1), C.TIME_UNSET), bundle.getLong(a(2), C.TIME_UNSET), bundle.getFloat(a(3), -3.4028235E38f), bundle.getFloat(a(4), -3.4028235E38f));
        }

        private static String a(int i11) {
            return Integer.toString(i11, 36);
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f23290a == fVar.f23290a && this.f23291b == fVar.f23291b && this.f23292c == fVar.f23292c && this.f23293d == fVar.f23293d && this.f23294f == fVar.f23294f;
        }

        public int hashCode() {
            long j11 = this.f23290a;
            long j12 = this.f23291b;
            int i11 = ((((int) (j11 ^ (j11 >>> 32))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            long j13 = this.f23292c;
            int i12 = (i11 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
            float f11 = this.f23293d;
            int iFloatToIntBits = (i12 + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
            float f12 = this.f23294f;
            return iFloatToIntBits + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f23300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f23301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f23302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f23303d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f23304e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f23305f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Object f23306g;

        private g(Uri uri, String str, e eVar, b bVar, List list, String str2, List list2, Object obj) {
            this.f23300a = uri;
            this.f23301b = str;
            this.f23302c = eVar;
            this.f23303d = list;
            this.f23304e = str2;
            this.f23305f = list2;
            this.f23306g = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f23300a.equals(gVar.f23300a) && xp.a((Object) this.f23301b, (Object) gVar.f23301b) && xp.a(this.f23302c, gVar.f23302c) && xp.a((Object) null, (Object) null) && this.f23303d.equals(gVar.f23303d) && xp.a((Object) this.f23304e, (Object) gVar.f23304e) && this.f23305f.equals(gVar.f23305f) && xp.a(this.f23306g, gVar.f23306g);
        }

        public int hashCode() {
            int iHashCode = this.f23300a.hashCode() * 31;
            String str = this.f23301b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            e eVar = this.f23302c;
            int iHashCode3 = (((iHashCode2 + (eVar == null ? 0 : eVar.hashCode())) * 961) + this.f23303d.hashCode()) * 31;
            String str2 = this.f23304e;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f23305f.hashCode()) * 31;
            Object obj = this.f23306g;
            return iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }
    }

    private td(String str, d dVar, g gVar, f fVar, vd vdVar) {
        this.f23246a = str;
        this.f23247b = gVar;
        this.f23248c = fVar;
        this.f23249d = vdVar;
        this.f23250f = dVar;
    }

    public static td a(Uri uri) {
        return new c().a(uri).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static td a(Bundle bundle) {
        String str = (String) b1.a((Object) bundle.getString(a(0), ""));
        Bundle bundle2 = bundle.getBundle(a(1));
        f fVar = bundle2 == null ? f.f23288g : (f) f.f23289h.a(bundle2);
        Bundle bundle3 = bundle.getBundle(a(2));
        vd vdVar = bundle3 == null ? vd.H : (vd) vd.I.a(bundle3);
        Bundle bundle4 = bundle.getBundle(a(3));
        return new td(str, bundle4 == null ? new d(0L, Long.MIN_VALUE, false, false, false) : (d) d.f23266g.a(bundle4), null, fVar, vdVar);
    }

    private static String a(int i11) {
        return Integer.toString(i11, 36);
    }

    public c a() {
        return new c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof td)) {
            return false;
        }
        td tdVar = (td) obj;
        return xp.a((Object) this.f23246a, (Object) tdVar.f23246a) && this.f23250f.equals(tdVar.f23250f) && xp.a(this.f23247b, tdVar.f23247b) && xp.a(this.f23248c, tdVar.f23248c) && xp.a(this.f23249d, tdVar.f23249d);
    }

    public int hashCode() {
        int iHashCode = this.f23246a.hashCode() * 31;
        g gVar = this.f23247b;
        return ((((((iHashCode + (gVar != null ? gVar.hashCode() : 0)) * 31) + this.f23248c.hashCode()) * 31) + this.f23250f.hashCode()) * 31) + this.f23249d.hashCode();
    }
}
