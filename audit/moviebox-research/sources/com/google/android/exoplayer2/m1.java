package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m1 implements g {
    public static final m1 H = new b().E();
    public static final g.a<m1> I = new g.a() { // from class: com.google.android.exoplayer2.l1
        @Override // com.google.android.exoplayer2.g.a
        public final g a(Bundle bundle) {
            return m1.e(bundle);
        }
    };
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f33434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f33435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f33436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33437d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f33438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f33439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f33440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f33441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final String f33442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final Metadata f33443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final String f33444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final String f33445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f33446n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<byte[]> f33447o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final DrmInitData f33448p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f33449q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f33450r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f33451s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f33452t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f33453u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f33454v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public final byte[] f33455w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f33456x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public final com.google.android.exoplayer2.video.c f33457y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f33458z;

    /* JADX INFO: compiled from: source.java */
    public static final class b {
        public int A;
        public int B;
        public int C;
        public int D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public String f33459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String f33460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public String f33461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f33462d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f33463e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f33464f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f33465g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public String f33466h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public Metadata f33467i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public String f33468j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public String f33469k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f33470l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Nullable
        public List<byte[]> f33471m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Nullable
        public DrmInitData f33472n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f33473o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f33474p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f33475q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f33476r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f33477s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float f33478t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @Nullable
        public byte[] f33479u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f33480v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @Nullable
        public com.google.android.exoplayer2.video.c f33481w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f33482x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f33483y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f33484z;

        public b() {
            this.f33464f = -1;
            this.f33465g = -1;
            this.f33470l = -1;
            this.f33473o = Long.MAX_VALUE;
            this.f33474p = -1;
            this.f33475q = -1;
            this.f33476r = -1.0f;
            this.f33478t = 1.0f;
            this.f33480v = -1;
            this.f33482x = -1;
            this.f33483y = -1;
            this.f33484z = -1;
            this.C = -1;
            this.D = 0;
        }

        public b(m1 m1Var) {
            this.f33459a = m1Var.f33434a;
            this.f33460b = m1Var.f33435b;
            this.f33461c = m1Var.f33436c;
            this.f33462d = m1Var.f33437d;
            this.f33463e = m1Var.f33438f;
            this.f33464f = m1Var.f33439g;
            this.f33465g = m1Var.f33440h;
            this.f33466h = m1Var.f33442j;
            this.f33467i = m1Var.f33443k;
            this.f33468j = m1Var.f33444l;
            this.f33469k = m1Var.f33445m;
            this.f33470l = m1Var.f33446n;
            this.f33471m = m1Var.f33447o;
            this.f33472n = m1Var.f33448p;
            this.f33473o = m1Var.f33449q;
            this.f33474p = m1Var.f33450r;
            this.f33475q = m1Var.f33451s;
            this.f33476r = m1Var.f33452t;
            this.f33477s = m1Var.f33453u;
            this.f33478t = m1Var.f33454v;
            this.f33479u = m1Var.f33455w;
            this.f33480v = m1Var.f33456x;
            this.f33481w = m1Var.f33457y;
            this.f33482x = m1Var.f33458z;
            this.f33483y = m1Var.A;
            this.f33484z = m1Var.B;
            this.A = m1Var.C;
            this.B = m1Var.D;
            this.C = m1Var.E;
            this.D = m1Var.F;
        }

        public m1 E() {
            return new m1(this);
        }

        public b F(int i11) {
            this.C = i11;
            return this;
        }

        public b G(int i11) {
            this.f33464f = i11;
            return this;
        }

        public b H(int i11) {
            this.f33482x = i11;
            return this;
        }

        public b I(@Nullable String str) {
            this.f33466h = str;
            return this;
        }

        public b J(@Nullable com.google.android.exoplayer2.video.c cVar) {
            this.f33481w = cVar;
            return this;
        }

        public b K(@Nullable String str) {
            this.f33468j = str;
            return this;
        }

        public b L(int i11) {
            this.D = i11;
            return this;
        }

        public b M(@Nullable DrmInitData drmInitData) {
            this.f33472n = drmInitData;
            return this;
        }

        public b N(int i11) {
            this.A = i11;
            return this;
        }

        public b O(int i11) {
            this.B = i11;
            return this;
        }

        public b P(float f11) {
            this.f33476r = f11;
            return this;
        }

        public b Q(int i11) {
            this.f33475q = i11;
            return this;
        }

        public b R(int i11) {
            this.f33459a = Integer.toString(i11);
            return this;
        }

        public b S(@Nullable String str) {
            this.f33459a = str;
            return this;
        }

        public b T(@Nullable List<byte[]> list) {
            this.f33471m = list;
            return this;
        }

        public b U(@Nullable String str) {
            this.f33460b = str;
            return this;
        }

        public b V(@Nullable String str) {
            this.f33461c = str;
            return this;
        }

        public b W(int i11) {
            this.f33470l = i11;
            return this;
        }

        public b X(@Nullable Metadata metadata) {
            this.f33467i = metadata;
            return this;
        }

        public b Y(int i11) {
            this.f33484z = i11;
            return this;
        }

        public b Z(int i11) {
            this.f33465g = i11;
            return this;
        }

        public b a0(float f11) {
            this.f33478t = f11;
            return this;
        }

        public b b0(@Nullable byte[] bArr) {
            this.f33479u = bArr;
            return this;
        }

        public b c0(int i11) {
            this.f33463e = i11;
            return this;
        }

        public b d0(int i11) {
            this.f33477s = i11;
            return this;
        }

        public b e0(@Nullable String str) {
            this.f33469k = str;
            return this;
        }

        public b f0(int i11) {
            this.f33483y = i11;
            return this;
        }

        public b g0(int i11) {
            this.f33462d = i11;
            return this;
        }

        public b h0(int i11) {
            this.f33480v = i11;
            return this;
        }

        public b i0(long j11) {
            this.f33473o = j11;
            return this;
        }

        public b j0(int i11) {
            this.f33474p = i11;
            return this;
        }
    }

    public m1(b bVar) {
        this.f33434a = bVar.f33459a;
        this.f33435b = bVar.f33460b;
        this.f33436c = com.google.android.exoplayer2.util.o0.E0(bVar.f33461c);
        this.f33437d = bVar.f33462d;
        this.f33438f = bVar.f33463e;
        int i11 = bVar.f33464f;
        this.f33439g = i11;
        int i12 = bVar.f33465g;
        this.f33440h = i12;
        this.f33441i = i12 != -1 ? i12 : i11;
        this.f33442j = bVar.f33466h;
        this.f33443k = bVar.f33467i;
        this.f33444l = bVar.f33468j;
        this.f33445m = bVar.f33469k;
        this.f33446n = bVar.f33470l;
        this.f33447o = bVar.f33471m == null ? Collections.emptyList() : bVar.f33471m;
        DrmInitData drmInitData = bVar.f33472n;
        this.f33448p = drmInitData;
        this.f33449q = bVar.f33473o;
        this.f33450r = bVar.f33474p;
        this.f33451s = bVar.f33475q;
        this.f33452t = bVar.f33476r;
        this.f33453u = bVar.f33477s == -1 ? 0 : bVar.f33477s;
        this.f33454v = bVar.f33478t == -1.0f ? 1.0f : bVar.f33478t;
        this.f33455w = bVar.f33479u;
        this.f33456x = bVar.f33480v;
        this.f33457y = bVar.f33481w;
        this.f33458z = bVar.f33482x;
        this.A = bVar.f33483y;
        this.B = bVar.f33484z;
        this.C = bVar.A == -1 ? 0 : bVar.A;
        this.D = bVar.B != -1 ? bVar.B : 0;
        this.E = bVar.C;
        if (bVar.D != 0 || drmInitData == null) {
            this.F = bVar.D;
        } else {
            this.F = 1;
        }
    }

    @Nullable
    public static <T> T d(@Nullable T t11, @Nullable T t12) {
        return t11 != null ? t11 : t12;
    }

    public static m1 e(Bundle bundle) {
        b bVar = new b();
        com.google.android.exoplayer2.util.d.a(bundle);
        int i11 = 0;
        String string = bundle.getString(h(0));
        m1 m1Var = H;
        bVar.S((String) d(string, m1Var.f33434a)).U((String) d(bundle.getString(h(1)), m1Var.f33435b)).V((String) d(bundle.getString(h(2)), m1Var.f33436c)).g0(bundle.getInt(h(3), m1Var.f33437d)).c0(bundle.getInt(h(4), m1Var.f33438f)).G(bundle.getInt(h(5), m1Var.f33439g)).Z(bundle.getInt(h(6), m1Var.f33440h)).I((String) d(bundle.getString(h(7)), m1Var.f33442j)).X((Metadata) d((Metadata) bundle.getParcelable(h(8)), m1Var.f33443k)).K((String) d(bundle.getString(h(9)), m1Var.f33444l)).e0((String) d(bundle.getString(h(10)), m1Var.f33445m)).W(bundle.getInt(h(11), m1Var.f33446n));
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte[] byteArray = bundle.getByteArray(i(i11));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i11++;
        }
        b bVarM = bVar.T(arrayList).M((DrmInitData) bundle.getParcelable(h(13)));
        String strH = h(14);
        m1 m1Var2 = H;
        bVarM.i0(bundle.getLong(strH, m1Var2.f33449q)).j0(bundle.getInt(h(15), m1Var2.f33450r)).Q(bundle.getInt(h(16), m1Var2.f33451s)).P(bundle.getFloat(h(17), m1Var2.f33452t)).d0(bundle.getInt(h(18), m1Var2.f33453u)).a0(bundle.getFloat(h(19), m1Var2.f33454v)).b0(bundle.getByteArray(h(20))).h0(bundle.getInt(h(21), m1Var2.f33456x));
        Bundle bundle2 = bundle.getBundle(h(22));
        if (bundle2 != null) {
            bVar.J((com.google.android.exoplayer2.video.c) com.google.android.exoplayer2.video.c.f35716g.a(bundle2));
        }
        bVar.H(bundle.getInt(h(23), m1Var2.f33458z)).f0(bundle.getInt(h(24), m1Var2.A)).Y(bundle.getInt(h(25), m1Var2.B)).N(bundle.getInt(h(26), m1Var2.C)).O(bundle.getInt(h(27), m1Var2.D)).F(bundle.getInt(h(28), m1Var2.E)).L(bundle.getInt(h(29), m1Var2.F));
        return bVar.E();
    }

    private static String h(int i11) {
        return Integer.toString(i11, 36);
    }

    public static String i(int i11) {
        return h(12) + "_" + Integer.toString(i11, 36);
    }

    public b b() {
        return new b();
    }

    public m1 c(int i11) {
        return b().L(i11).E();
    }

    public boolean equals(@Nullable Object obj) {
        int i11;
        if (this == obj) {
            return true;
        }
        if (obj == null || m1.class != obj.getClass()) {
            return false;
        }
        m1 m1Var = (m1) obj;
        int i12 = this.G;
        return (i12 == 0 || (i11 = m1Var.G) == 0 || i12 == i11) && this.f33437d == m1Var.f33437d && this.f33438f == m1Var.f33438f && this.f33439g == m1Var.f33439g && this.f33440h == m1Var.f33440h && this.f33446n == m1Var.f33446n && this.f33449q == m1Var.f33449q && this.f33450r == m1Var.f33450r && this.f33451s == m1Var.f33451s && this.f33453u == m1Var.f33453u && this.f33456x == m1Var.f33456x && this.f33458z == m1Var.f33458z && this.A == m1Var.A && this.B == m1Var.B && this.C == m1Var.C && this.D == m1Var.D && this.E == m1Var.E && this.F == m1Var.F && Float.compare(this.f33452t, m1Var.f33452t) == 0 && Float.compare(this.f33454v, m1Var.f33454v) == 0 && com.google.android.exoplayer2.util.o0.c(this.f33434a, m1Var.f33434a) && com.google.android.exoplayer2.util.o0.c(this.f33435b, m1Var.f33435b) && com.google.android.exoplayer2.util.o0.c(this.f33442j, m1Var.f33442j) && com.google.android.exoplayer2.util.o0.c(this.f33444l, m1Var.f33444l) && com.google.android.exoplayer2.util.o0.c(this.f33445m, m1Var.f33445m) && com.google.android.exoplayer2.util.o0.c(this.f33436c, m1Var.f33436c) && Arrays.equals(this.f33455w, m1Var.f33455w) && com.google.android.exoplayer2.util.o0.c(this.f33443k, m1Var.f33443k) && com.google.android.exoplayer2.util.o0.c(this.f33457y, m1Var.f33457y) && com.google.android.exoplayer2.util.o0.c(this.f33448p, m1Var.f33448p) && g(m1Var);
    }

    public int f() {
        int i11;
        int i12 = this.f33450r;
        if (i12 == -1 || (i11 = this.f33451s) == -1) {
            return -1;
        }
        return i12 * i11;
    }

    public boolean g(m1 m1Var) {
        if (this.f33447o.size() != m1Var.f33447o.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f33447o.size(); i11++) {
            if (!Arrays.equals(this.f33447o.get(i11), m1Var.f33447o.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.G == 0) {
            String str = this.f33434a;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f33435b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f33436c;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f33437d) * 31) + this.f33438f) * 31) + this.f33439g) * 31) + this.f33440h) * 31;
            String str4 = this.f33442j;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.f33443k;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.f33444l;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f33445m;
            this.G = ((((((((((((((((((((((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f33446n) * 31) + ((int) this.f33449q)) * 31) + this.f33450r) * 31) + this.f33451s) * 31) + Float.floatToIntBits(this.f33452t)) * 31) + this.f33453u) * 31) + Float.floatToIntBits(this.f33454v)) * 31) + this.f33456x) * 31) + this.f33458z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.F;
        }
        return this.G;
    }

    public m1 j(m1 m1Var) {
        String str;
        if (this == m1Var) {
            return this;
        }
        int iK = com.google.android.exoplayer2.util.w.k(this.f33445m);
        String str2 = m1Var.f33434a;
        String str3 = m1Var.f33435b;
        if (str3 == null) {
            str3 = this.f33435b;
        }
        String str4 = this.f33436c;
        if ((iK == 3 || iK == 1) && (str = m1Var.f33436c) != null) {
            str4 = str;
        }
        int i11 = this.f33439g;
        if (i11 == -1) {
            i11 = m1Var.f33439g;
        }
        int i12 = this.f33440h;
        if (i12 == -1) {
            i12 = m1Var.f33440h;
        }
        String str5 = this.f33442j;
        if (str5 == null) {
            String strL = com.google.android.exoplayer2.util.o0.L(m1Var.f33442j, iK);
            if (com.google.android.exoplayer2.util.o0.V0(strL).length == 1) {
                str5 = strL;
            }
        }
        Metadata metadata = this.f33443k;
        Metadata metadataCopyWithAppendedEntriesFrom = metadata == null ? m1Var.f33443k : metadata.copyWithAppendedEntriesFrom(m1Var.f33443k);
        float f11 = this.f33452t;
        if (f11 == -1.0f && iK == 2) {
            f11 = m1Var.f33452t;
        }
        return b().S(str2).U(str3).V(str4).g0(this.f33437d | m1Var.f33437d).c0(this.f33438f | m1Var.f33438f).G(i11).Z(i12).I(str5).X(metadataCopyWithAppendedEntriesFrom).M(DrmInitData.createSessionCreationData(m1Var.f33448p, this.f33448p)).P(f11).E();
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(h(0), this.f33434a);
        bundle.putString(h(1), this.f33435b);
        bundle.putString(h(2), this.f33436c);
        bundle.putInt(h(3), this.f33437d);
        bundle.putInt(h(4), this.f33438f);
        bundle.putInt(h(5), this.f33439g);
        bundle.putInt(h(6), this.f33440h);
        bundle.putString(h(7), this.f33442j);
        bundle.putParcelable(h(8), this.f33443k);
        bundle.putString(h(9), this.f33444l);
        bundle.putString(h(10), this.f33445m);
        bundle.putInt(h(11), this.f33446n);
        for (int i11 = 0; i11 < this.f33447o.size(); i11++) {
            bundle.putByteArray(i(i11), this.f33447o.get(i11));
        }
        bundle.putParcelable(h(13), this.f33448p);
        bundle.putLong(h(14), this.f33449q);
        bundle.putInt(h(15), this.f33450r);
        bundle.putInt(h(16), this.f33451s);
        bundle.putFloat(h(17), this.f33452t);
        bundle.putInt(h(18), this.f33453u);
        bundle.putFloat(h(19), this.f33454v);
        bundle.putByteArray(h(20), this.f33455w);
        bundle.putInt(h(21), this.f33456x);
        if (this.f33457y != null) {
            bundle.putBundle(h(22), this.f33457y.toBundle());
        }
        bundle.putInt(h(23), this.f33458z);
        bundle.putInt(h(24), this.A);
        bundle.putInt(h(25), this.B);
        bundle.putInt(h(26), this.C);
        bundle.putInt(h(27), this.D);
        bundle.putInt(h(28), this.E);
        bundle.putInt(h(29), this.F);
        return bundle;
    }

    public String toString() {
        return "Format(" + this.f33434a + ", " + this.f33435b + ", " + this.f33444l + ", " + this.f33445m + ", " + this.f33442j + ", " + this.f33441i + ", " + this.f33436c + ", [" + this.f33450r + ", " + this.f33451s + ", " + this.f33452t + "], [" + this.f33458z + ", " + this.A + "])";
    }
}
