package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b0 f8942i = new c().a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f8943j = u0.E0(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f8944k = u0.E0(1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f8945l = u0.E0(2);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f8946m = u0.E0(3);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f8947n = u0.E0(4);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f8948o = u0.E0(5);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Deprecated
    public static final androidx.media3.common.i<b0> f8949p = new androidx.media3.common.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final h f8951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    @Deprecated
    public final h f8952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f8953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d0 f8954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f8955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Deprecated
    public final e f8956g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f8957h;

    /* JADX INFO: compiled from: source.java */
    public static final class b {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public String f8958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Uri f8959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public String f8960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d.a f8961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public f.a f8962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<StreamKey> f8963f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public String f8964g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ImmutableList<k> f8965h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public Object f8966i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f8967j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public d0 f8968k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public g.a f8969l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public i f8970m;

        public c() {
            this.f8961d = new d.a();
            this.f8962e = new f.a();
            this.f8963f = Collections.emptyList();
            this.f8965h = ImmutableList.of();
            this.f8969l = new g.a();
            this.f8970m = i.f9056d;
            this.f8967j = C.TIME_UNSET;
        }

        public c(b0 b0Var) {
            this();
            this.f8961d = b0Var.f8955f.a();
            this.f8958a = b0Var.f8950a;
            this.f8968k = b0Var.f8954e;
            this.f8969l = b0Var.f8953d.a();
            this.f8970m = b0Var.f8957h;
            h hVar = b0Var.f8951b;
            if (hVar != null) {
                this.f8964g = hVar.f9051e;
                this.f8960c = hVar.f9048b;
                this.f8959b = hVar.f9047a;
                this.f8963f = hVar.f9050d;
                this.f8965h = hVar.f9052f;
                this.f8966i = hVar.f9054h;
                f fVar = hVar.f9049c;
                this.f8962e = fVar != null ? fVar.b() : new f.a();
                this.f8967j = hVar.f9055i;
            }
        }

        public b0 a() {
            h hVar;
            z3.a.g(this.f8962e.f9014b == null || this.f8962e.f9013a != null);
            Uri uri = this.f8959b;
            if (uri != null) {
                hVar = new h(uri, this.f8960c, this.f8962e.f9013a != null ? this.f8962e.i() : null, null, this.f8963f, this.f8964g, this.f8965h, this.f8966i, this.f8967j);
            } else {
                hVar = null;
            }
            String str = this.f8958a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e eVarG = this.f8961d.g();
            g gVarF = this.f8969l.f();
            d0 d0Var = this.f8968k;
            if (d0Var == null) {
                d0Var = d0.G;
            }
            return new b0(str2, eVarG, hVar, gVarF, d0Var, this.f8970m);
        }

        public c b(@Nullable String str) {
            this.f8964g = str;
            return this;
        }

        public c c(g gVar) {
            this.f8969l = gVar.a();
            return this;
        }

        public c d(String str) {
            this.f8958a = (String) z3.a.e(str);
            return this;
        }

        public c e(@Nullable String str) {
            this.f8960c = str;
            return this;
        }

        public c f(@Nullable List<StreamKey> list) {
            this.f8963f = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public c g(List<k> list) {
            this.f8965h = ImmutableList.copyOf((Collection) list);
            return this;
        }

        public c h(@Nullable Object obj) {
            this.f8966i = obj;
            return this;
        }

        public c i(@Nullable Uri uri) {
            this.f8959b = uri;
            return this;
        }

        public c j(@Nullable String str) {
            return i(str == null ? null : Uri.parse(str));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f8971h = new a().f();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f8972i = u0.E0(0);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f8973j = u0.E0(1);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f8974k = u0.E0(2);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f8975l = u0.E0(3);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f8976m = u0.E0(4);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f8977n = u0.E0(5);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f8978o = u0.E0(6);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @Deprecated
        public static final androidx.media3.common.i<e> f8979p = new androidx.media3.common.b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f8980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f8981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f8982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f8983d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f8984e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f8985f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f8986g;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f8987a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public long f8988b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f8989c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f8990d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f8991e;

            public a() {
                this.f8988b = Long.MIN_VALUE;
            }

            public a(d dVar) {
                this.f8987a = dVar.f8981b;
                this.f8988b = dVar.f8983d;
                this.f8989c = dVar.f8984e;
                this.f8990d = dVar.f8985f;
                this.f8991e = dVar.f8986g;
            }

            public d f() {
                return new d(this);
            }

            @Deprecated
            public e g() {
                return new e(this);
            }
        }

        public d(a aVar) {
            this.f8980a = u0.B1(aVar.f8987a);
            this.f8982c = u0.B1(aVar.f8988b);
            this.f8981b = aVar.f8987a;
            this.f8983d = aVar.f8988b;
            this.f8984e = aVar.f8989c;
            this.f8985f = aVar.f8990d;
            this.f8986g = aVar.f8991e;
        }

        public a a() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f8981b == dVar.f8981b && this.f8983d == dVar.f8983d && this.f8984e == dVar.f8984e && this.f8985f == dVar.f8985f && this.f8986g == dVar.f8986g;
        }

        public int hashCode() {
            long j11 = this.f8981b;
            int i11 = ((int) (j11 ^ (j11 >>> 32))) * 31;
            long j12 = this.f8983d;
            return ((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f8984e ? 1 : 0)) * 31) + (this.f8985f ? 1 : 0)) * 31) + (this.f8986g ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public static final class e extends d {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final e f8992q = new d.a().g();

        public e(d.a aVar) {
            super(aVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f8993l = u0.E0(0);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f8994m = u0.E0(1);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f8995n = u0.E0(2);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f8996o = u0.E0(3);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String f8997p = u0.E0(4);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final String f8998q = u0.E0(5);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final String f8999r = u0.E0(6);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final String f9000s = u0.E0(7);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @Deprecated
        public static final androidx.media3.common.i<f> f9001t = new androidx.media3.common.b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f9002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public final UUID f9003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Uri f9004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public final ImmutableMap<String, String> f9005d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImmutableMap<String, String> f9006e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f9007f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f9008g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f9009h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Deprecated
        public final ImmutableList<Integer> f9010i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ImmutableList<Integer> f9011j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public final byte[] f9012k;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            public UUID f9013a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            public Uri f9014b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public ImmutableMap<String, String> f9015c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f9016d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f9017e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f9018f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public ImmutableList<Integer> f9019g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            @Nullable
            public byte[] f9020h;

            @Deprecated
            public a() {
                this.f9015c = ImmutableMap.of();
                this.f9017e = true;
                this.f9019g = ImmutableList.of();
            }

            public a(f fVar) {
                this.f9013a = fVar.f9002a;
                this.f9014b = fVar.f9004c;
                this.f9015c = fVar.f9006e;
                this.f9016d = fVar.f9007f;
                this.f9017e = fVar.f9008g;
                this.f9018f = fVar.f9009h;
                this.f9019g = fVar.f9011j;
                this.f9020h = fVar.f9012k;
            }

            public f i() {
                return new f(this);
            }
        }

        public f(a aVar) {
            z3.a.g((aVar.f9018f && aVar.f9014b == null) ? false : true);
            UUID uuid = (UUID) z3.a.e(aVar.f9013a);
            this.f9002a = uuid;
            this.f9003b = uuid;
            this.f9004c = aVar.f9014b;
            this.f9005d = aVar.f9015c;
            this.f9006e = aVar.f9015c;
            this.f9007f = aVar.f9016d;
            this.f9009h = aVar.f9018f;
            this.f9008g = aVar.f9017e;
            this.f9010i = aVar.f9019g;
            this.f9011j = aVar.f9019g;
            this.f9012k = aVar.f9020h != null ? Arrays.copyOf(aVar.f9020h, aVar.f9020h.length) : null;
        }

        public a b() {
            return new a();
        }

        @Nullable
        public byte[] c() {
            byte[] bArr = this.f9012k;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f9002a.equals(fVar.f9002a) && u0.c(this.f9004c, fVar.f9004c) && u0.c(this.f9006e, fVar.f9006e) && this.f9007f == fVar.f9007f && this.f9009h == fVar.f9009h && this.f9008g == fVar.f9008g && this.f9011j.equals(fVar.f9011j) && Arrays.equals(this.f9012k, fVar.f9012k);
        }

        public int hashCode() {
            int iHashCode = this.f9002a.hashCode() * 31;
            Uri uri = this.f9004c;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f9006e.hashCode()) * 31) + (this.f9007f ? 1 : 0)) * 31) + (this.f9009h ? 1 : 0)) * 31) + (this.f9008g ? 1 : 0)) * 31) + this.f9011j.hashCode()) * 31) + Arrays.hashCode(this.f9012k);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final g f9021f = new a().f();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f9022g = u0.E0(0);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f9023h = u0.E0(1);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f9024i = u0.E0(2);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f9025j = u0.E0(3);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f9026k = u0.E0(4);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Deprecated
        public static final androidx.media3.common.i<g> f9027l = new androidx.media3.common.b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f9028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f9029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f9030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f9031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f9032e;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f9033a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public long f9034b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f9035c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public float f9036d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public float f9037e;

            public a() {
                this.f9033a = C.TIME_UNSET;
                this.f9034b = C.TIME_UNSET;
                this.f9035c = C.TIME_UNSET;
                this.f9036d = -3.4028235E38f;
                this.f9037e = -3.4028235E38f;
            }

            public a(g gVar) {
                this.f9033a = gVar.f9028a;
                this.f9034b = gVar.f9029b;
                this.f9035c = gVar.f9030c;
                this.f9036d = gVar.f9031d;
                this.f9037e = gVar.f9032e;
            }

            public g f() {
                return new g(this);
            }

            public a g(long j11) {
                this.f9035c = j11;
                return this;
            }

            public a h(float f11) {
                this.f9037e = f11;
                return this;
            }

            public a i(long j11) {
                this.f9034b = j11;
                return this;
            }

            public a j(float f11) {
                this.f9036d = f11;
                return this;
            }

            public a k(long j11) {
                this.f9033a = j11;
                return this;
            }
        }

        @Deprecated
        public g(long j11, long j12, long j13, float f11, float f12) {
            this.f9028a = j11;
            this.f9029b = j12;
            this.f9030c = j13;
            this.f9031d = f11;
            this.f9032e = f12;
        }

        public g(a aVar) {
            this(aVar.f9033a, aVar.f9034b, aVar.f9035c, aVar.f9036d, aVar.f9037e);
        }

        public a a() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f9028a == gVar.f9028a && this.f9029b == gVar.f9029b && this.f9030c == gVar.f9030c && this.f9031d == gVar.f9031d && this.f9032e == gVar.f9032e;
        }

        public int hashCode() {
            long j11 = this.f9028a;
            long j12 = this.f9029b;
            int i11 = ((((int) (j11 ^ (j11 >>> 32))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            long j13 = this.f9030c;
            int i12 = (i11 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
            float f11 = this.f9031d;
            int iFloatToIntBits = (i12 + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
            float f12 = this.f9032e;
            return iFloatToIntBits + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f9038j = u0.E0(0);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f9039k = u0.E0(1);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f9040l = u0.E0(2);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f9041m = u0.E0(3);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f9042n = u0.E0(4);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f9043o = u0.E0(5);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String f9044p = u0.E0(6);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final String f9045q = u0.E0(7);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @Deprecated
        public static final androidx.media3.common.i<h> f9046r = new androidx.media3.common.b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f9047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f9048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final f f9049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<StreamKey> f9050d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final String f9051e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImmutableList<k> f9052f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public final List<j> f9053g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final Object f9054h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f9055i;

        public h(Uri uri, @Nullable String str, @Nullable f fVar, @Nullable b bVar, List<StreamKey> list, @Nullable String str2, ImmutableList<k> immutableList, @Nullable Object obj, long j11) {
            this.f9047a = uri;
            this.f9048b = f0.t(str);
            this.f9049c = fVar;
            this.f9050d = list;
            this.f9051e = str2;
            this.f9052f = immutableList;
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                aVarBuilder.a(immutableList.get(i11).a().i());
            }
            this.f9053g = aVarBuilder.m();
            this.f9054h = obj;
            this.f9055i = j11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f9047a.equals(hVar.f9047a) && u0.c(this.f9048b, hVar.f9048b) && u0.c(this.f9049c, hVar.f9049c) && u0.c(null, null) && this.f9050d.equals(hVar.f9050d) && u0.c(this.f9051e, hVar.f9051e) && this.f9052f.equals(hVar.f9052f) && u0.c(this.f9054h, hVar.f9054h) && u0.c(Long.valueOf(this.f9055i), Long.valueOf(hVar.f9055i));
        }

        public int hashCode() {
            int iHashCode = this.f9047a.hashCode() * 31;
            String str = this.f9048b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.f9049c;
            int iHashCode3 = (((iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 961) + this.f9050d.hashCode()) * 31;
            String str2 = this.f9051e;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f9052f.hashCode()) * 31;
            Object obj = this.f9054h;
            return (int) ((((long) (iHashCode4 + (obj != null ? obj.hashCode() : 0))) * 31) + this.f9055i);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final i f9056d = new a().d();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f9057e = u0.E0(0);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f9058f = u0.E0(1);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f9059g = u0.E0(2);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Deprecated
        public static final androidx.media3.common.i<i> f9060h = new androidx.media3.common.b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Uri f9061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f9062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Bundle f9063c;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            public Uri f9064a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            public String f9065b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            public Bundle f9066c;

            public i d() {
                return new i(this);
            }
        }

        public i(a aVar) {
            this.f9061a = aVar.f9064a;
            this.f9062b = aVar.f9065b;
            this.f9063c = aVar.f9066c;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            if (u0.c(this.f9061a, iVar.f9061a) && u0.c(this.f9062b, iVar.f9062b)) {
                if ((this.f9063c == null) == (iVar.f9063c == null)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Uri uri = this.f9061a;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.f9062b;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.f9063c != null ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public static final class j extends k {
        public j(k.a aVar) {
            super(aVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class k {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f9067h = u0.E0(0);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f9068i = u0.E0(1);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f9069j = u0.E0(2);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f9070k = u0.E0(3);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f9071l = u0.E0(4);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f9072m = u0.E0(5);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f9073n = u0.E0(6);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @Deprecated
        public static final androidx.media3.common.i<k> f9074o = new androidx.media3.common.b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f9075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f9076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f9077c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f9078d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f9079e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final String f9080f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public final String f9081g;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Uri f9082a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            public String f9083b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            public String f9084c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f9085d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f9086e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @Nullable
            public String f9087f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            @Nullable
            public String f9088g;

            public a(k kVar) {
                this.f9082a = kVar.f9075a;
                this.f9083b = kVar.f9076b;
                this.f9084c = kVar.f9077c;
                this.f9085d = kVar.f9078d;
                this.f9086e = kVar.f9079e;
                this.f9087f = kVar.f9080f;
                this.f9088g = kVar.f9081g;
            }

            public final j i() {
                return new j(this);
            }
        }

        public k(a aVar) {
            this.f9075a = aVar.f9082a;
            this.f9076b = aVar.f9083b;
            this.f9077c = aVar.f9084c;
            this.f9078d = aVar.f9085d;
            this.f9079e = aVar.f9086e;
            this.f9080f = aVar.f9087f;
            this.f9081g = aVar.f9088g;
        }

        public a a() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.f9075a.equals(kVar.f9075a) && u0.c(this.f9076b, kVar.f9076b) && u0.c(this.f9077c, kVar.f9077c) && this.f9078d == kVar.f9078d && this.f9079e == kVar.f9079e && u0.c(this.f9080f, kVar.f9080f) && u0.c(this.f9081g, kVar.f9081g);
        }

        public int hashCode() {
            int iHashCode = this.f9075a.hashCode() * 31;
            String str = this.f9076b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f9077c;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f9078d) * 31) + this.f9079e) * 31;
            String str3 = this.f9080f;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f9081g;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }
    }

    public b0(String str, e eVar, @Nullable h hVar, g gVar, d0 d0Var, i iVar) {
        this.f8950a = str;
        this.f8951b = hVar;
        this.f8952c = hVar;
        this.f8953d = gVar;
        this.f8954e = d0Var;
        this.f8955f = eVar;
        this.f8956g = eVar;
        this.f8957h = iVar;
    }

    public static b0 b(String str) {
        return new c().j(str).a();
    }

    public c a() {
        return new c();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return u0.c(this.f8950a, b0Var.f8950a) && this.f8955f.equals(b0Var.f8955f) && u0.c(this.f8951b, b0Var.f8951b) && u0.c(this.f8953d, b0Var.f8953d) && u0.c(this.f8954e, b0Var.f8954e) && u0.c(this.f8957h, b0Var.f8957h);
    }

    public int hashCode() {
        int iHashCode = this.f8950a.hashCode() * 31;
        h hVar = this.f8951b;
        return ((((((((iHashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.f8953d.hashCode()) * 31) + this.f8955f.hashCode()) * 31) + this.f8954e.hashCode()) * 31) + this.f8957h.hashCode();
    }
}
