package androidx.media3.common;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y {
    public static final y K = new b().I();
    public static final String L = u0.E0(0);
    public static final String M = u0.E0(1);
    public static final String N = u0.E0(2);
    public static final String O = u0.E0(3);
    public static final String P = u0.E0(4);
    public static final String Q = u0.E0(5);
    public static final String R = u0.E0(6);
    public static final String S = u0.E0(7);
    public static final String T = u0.E0(8);
    public static final String U = u0.E0(9);
    public static final String V = u0.E0(10);
    public static final String W = u0.E0(11);
    public static final String X = u0.E0(12);
    public static final String Y = u0.E0(13);
    public static final String Z = u0.E0(14);

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f9470a0 = u0.E0(15);

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f9471b0 = u0.E0(16);

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f9472c0 = u0.E0(17);

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f9473d0 = u0.E0(18);

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final String f9474e0 = u0.E0(19);

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final String f9475f0 = u0.E0(20);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f9476g0 = u0.E0(21);

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f9477h0 = u0.E0(22);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f9478i0 = u0.E0(23);

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final String f9479j0 = u0.E0(24);

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f9480k0 = u0.E0(25);

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f9481l0 = u0.E0(26);

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final String f9482m0 = u0.E0(27);

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final String f9483n0 = u0.E0(28);

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final String f9484o0 = u0.E0(29);

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final String f9485p0 = u0.E0(30);

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final String f9486q0 = u0.E0(31);

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final String f9487r0 = u0.E0(32);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    @Deprecated
    public static final i<y> f9488s0 = new androidx.media3.common.b();
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public int J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f9489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f9490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a0> f9491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f9492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f9496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f9497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final String f9498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final Metadata f9499k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final String f9500l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final String f9501m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f9502n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<byte[]> f9503o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final DrmInitData f9504p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f9505q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f9506r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f9507s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f9508t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f9509u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f9510v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public final byte[] f9511w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f9512x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public final k f9513y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f9514z;

    /* JADX INFO: compiled from: source.java */
    public static final class b {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public String f9515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String f9516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<a0> f9517c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public String f9518d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9519e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f9520f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f9521g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f9522h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public String f9523i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public Metadata f9524j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public String f9525k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        public String f9526l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f9527m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Nullable
        public List<byte[]> f9528n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @Nullable
        public DrmInitData f9529o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f9530p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f9531q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f9532r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f9533s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f9534t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f9535u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @Nullable
        public byte[] f9536v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f9537w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @Nullable
        public k f9538x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f9539y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f9540z;

        public b() {
            this.f9517c = ImmutableList.of();
            this.f9521g = -1;
            this.f9522h = -1;
            this.f9527m = -1;
            this.f9530p = Long.MAX_VALUE;
            this.f9531q = -1;
            this.f9532r = -1;
            this.f9533s = -1.0f;
            this.f9535u = 1.0f;
            this.f9537w = -1;
            this.f9539y = -1;
            this.f9540z = -1;
            this.A = -1;
            this.D = -1;
            this.E = 1;
            this.F = -1;
            this.G = -1;
            this.H = 0;
        }

        public b(y yVar) {
            this.f9515a = yVar.f9489a;
            this.f9516b = yVar.f9490b;
            this.f9517c = yVar.f9491c;
            this.f9518d = yVar.f9492d;
            this.f9519e = yVar.f9493e;
            this.f9520f = yVar.f9494f;
            this.f9521g = yVar.f9495g;
            this.f9522h = yVar.f9496h;
            this.f9523i = yVar.f9498j;
            this.f9524j = yVar.f9499k;
            this.f9525k = yVar.f9500l;
            this.f9526l = yVar.f9501m;
            this.f9527m = yVar.f9502n;
            this.f9528n = yVar.f9503o;
            this.f9529o = yVar.f9504p;
            this.f9530p = yVar.f9505q;
            this.f9531q = yVar.f9506r;
            this.f9532r = yVar.f9507s;
            this.f9533s = yVar.f9508t;
            this.f9534t = yVar.f9509u;
            this.f9535u = yVar.f9510v;
            this.f9536v = yVar.f9511w;
            this.f9537w = yVar.f9512x;
            this.f9538x = yVar.f9513y;
            this.f9539y = yVar.f9514z;
            this.f9540z = yVar.A;
            this.A = yVar.B;
            this.B = yVar.C;
            this.C = yVar.D;
            this.D = yVar.E;
            this.E = yVar.F;
            this.F = yVar.G;
            this.G = yVar.H;
            this.H = yVar.I;
        }

        public y I() {
            return new y(this);
        }

        public b J(int i11) {
            this.D = i11;
            return this;
        }

        public b K(int i11) {
            this.f9521g = i11;
            return this;
        }

        public b L(int i11) {
            this.f9539y = i11;
            return this;
        }

        public b M(@Nullable String str) {
            this.f9523i = str;
            return this;
        }

        public b N(@Nullable k kVar) {
            this.f9538x = kVar;
            return this;
        }

        public b O(@Nullable String str) {
            this.f9525k = f0.t(str);
            return this;
        }

        public b P(int i11) {
            this.H = i11;
            return this;
        }

        public b Q(int i11) {
            this.E = i11;
            return this;
        }

        public b R(@Nullable DrmInitData drmInitData) {
            this.f9529o = drmInitData;
            return this;
        }

        public b S(int i11) {
            this.B = i11;
            return this;
        }

        public b T(int i11) {
            this.C = i11;
            return this;
        }

        public b U(float f11) {
            this.f9533s = f11;
            return this;
        }

        public b V(int i11) {
            this.f9532r = i11;
            return this;
        }

        public b W(int i11) {
            this.f9515a = Integer.toString(i11);
            return this;
        }

        public b X(@Nullable String str) {
            this.f9515a = str;
            return this;
        }

        public b Y(@Nullable List<byte[]> list) {
            this.f9528n = list;
            return this;
        }

        public b Z(@Nullable String str) {
            this.f9516b = str;
            return this;
        }

        public b a0(List<a0> list) {
            this.f9517c = ImmutableList.copyOf((Collection) list);
            return this;
        }

        public b b0(@Nullable String str) {
            this.f9518d = str;
            return this;
        }

        public b c0(int i11) {
            this.f9527m = i11;
            return this;
        }

        public b d0(@Nullable Metadata metadata) {
            this.f9524j = metadata;
            return this;
        }

        public b e0(int i11) {
            this.A = i11;
            return this;
        }

        public b f0(int i11) {
            this.f9522h = i11;
            return this;
        }

        public b g0(float f11) {
            this.f9535u = f11;
            return this;
        }

        public b h0(@Nullable byte[] bArr) {
            this.f9536v = bArr;
            return this;
        }

        public b i0(int i11) {
            this.f9520f = i11;
            return this;
        }

        public b j0(int i11) {
            this.f9534t = i11;
            return this;
        }

        public b k0(@Nullable String str) {
            this.f9526l = f0.t(str);
            return this;
        }

        public b l0(int i11) {
            this.f9540z = i11;
            return this;
        }

        public b m0(int i11) {
            this.f9519e = i11;
            return this;
        }

        public b n0(int i11) {
            this.f9537w = i11;
            return this;
        }

        public b o0(long j11) {
            this.f9530p = j11;
            return this;
        }

        public b p0(int i11) {
            this.F = i11;
            return this;
        }

        public b q0(int i11) {
            this.G = i11;
            return this;
        }

        public b r0(int i11) {
            this.f9531q = i11;
            return this;
        }
    }

    public y(final b bVar) {
        this.f9489a = bVar.f9515a;
        String strU0 = u0.U0(bVar.f9518d);
        this.f9492d = strU0;
        if (bVar.f9517c.isEmpty() && bVar.f9516b != null) {
            this.f9491c = ImmutableList.of(new a0(strU0, bVar.f9516b));
            this.f9490b = bVar.f9516b;
        } else if (bVar.f9517c.isEmpty() || bVar.f9516b != null) {
            z3.a.g((bVar.f9517c.isEmpty() && bVar.f9516b == null) || bVar.f9517c.stream().anyMatch(new Predicate() { // from class: androidx.media3.common.x
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return y.j(bVar, (a0) obj);
                }
            }));
            this.f9491c = bVar.f9517c;
            this.f9490b = bVar.f9516b;
        } else {
            this.f9491c = bVar.f9517c;
            this.f9490b = f(bVar.f9517c, strU0);
        }
        this.f9493e = bVar.f9519e;
        this.f9494f = bVar.f9520f;
        int i11 = bVar.f9521g;
        this.f9495g = i11;
        int i12 = bVar.f9522h;
        this.f9496h = i12;
        this.f9497i = i12 != -1 ? i12 : i11;
        this.f9498j = bVar.f9523i;
        this.f9499k = bVar.f9524j;
        this.f9500l = bVar.f9525k;
        this.f9501m = bVar.f9526l;
        this.f9502n = bVar.f9527m;
        this.f9503o = bVar.f9528n == null ? Collections.emptyList() : bVar.f9528n;
        DrmInitData drmInitData = bVar.f9529o;
        this.f9504p = drmInitData;
        this.f9505q = bVar.f9530p;
        this.f9506r = bVar.f9531q;
        this.f9507s = bVar.f9532r;
        this.f9508t = bVar.f9533s;
        this.f9509u = bVar.f9534t == -1 ? 0 : bVar.f9534t;
        this.f9510v = bVar.f9535u == -1.0f ? 1.0f : bVar.f9535u;
        this.f9511w = bVar.f9536v;
        this.f9512x = bVar.f9537w;
        this.f9513y = bVar.f9538x;
        this.f9514z = bVar.f9539y;
        this.A = bVar.f9540z;
        this.B = bVar.A;
        this.C = bVar.B == -1 ? 0 : bVar.B;
        this.D = bVar.C != -1 ? bVar.C : 0;
        this.E = bVar.D;
        this.F = bVar.E;
        this.G = bVar.F;
        this.H = bVar.G;
        if (bVar.H != 0 || drmInitData == null) {
            this.I = bVar.H;
        } else {
            this.I = 1;
        }
    }

    @Nullable
    public static <T> T d(@Nullable T t11, @Nullable T t12) {
        return t11 != null ? t11 : t12;
    }

    public static y e(Bundle bundle) {
        b bVar = new b();
        z3.c.a(bundle);
        String string = bundle.getString(L);
        y yVar = K;
        bVar.X((String) d(string, yVar.f9489a)).Z((String) d(bundle.getString(M), yVar.f9490b));
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f9487r0);
        bVar.a0(parcelableArrayList == null ? ImmutableList.of() : z3.c.b(new com.google.common.base.f() { // from class: androidx.media3.common.w
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return a0.a((Bundle) obj);
            }
        }, parcelableArrayList)).b0((String) d(bundle.getString(N), yVar.f9492d)).m0(bundle.getInt(O, yVar.f9493e)).i0(bundle.getInt(P, yVar.f9494f)).K(bundle.getInt(Q, yVar.f9495g)).f0(bundle.getInt(R, yVar.f9496h)).M((String) d(bundle.getString(S), yVar.f9498j)).d0((Metadata) d((Metadata) bundle.getParcelable(T), yVar.f9499k)).O((String) d(bundle.getString(U), yVar.f9500l)).k0((String) d(bundle.getString(V), yVar.f9501m)).c0(bundle.getInt(W, yVar.f9502n));
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (true) {
            byte[] byteArray = bundle.getByteArray(i(i11));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i11++;
        }
        b bVarR = bVar.Y(arrayList).R((DrmInitData) bundle.getParcelable(Y));
        String str = Z;
        y yVar2 = K;
        bVarR.o0(bundle.getLong(str, yVar2.f9505q)).r0(bundle.getInt(f9470a0, yVar2.f9506r)).V(bundle.getInt(f9471b0, yVar2.f9507s)).U(bundle.getFloat(f9472c0, yVar2.f9508t)).j0(bundle.getInt(f9473d0, yVar2.f9509u)).g0(bundle.getFloat(f9474e0, yVar2.f9510v)).h0(bundle.getByteArray(f9475f0)).n0(bundle.getInt(f9476g0, yVar2.f9512x));
        Bundle bundle2 = bundle.getBundle(f9477h0);
        if (bundle2 != null) {
            bVar.N(k.f(bundle2));
        }
        bVar.L(bundle.getInt(f9478i0, yVar2.f9514z)).l0(bundle.getInt(f9479j0, yVar2.A)).e0(bundle.getInt(f9480k0, yVar2.B)).S(bundle.getInt(f9481l0, yVar2.C)).T(bundle.getInt(f9482m0, yVar2.D)).J(bundle.getInt(f9483n0, yVar2.E)).p0(bundle.getInt(f9485p0, yVar2.G)).q0(bundle.getInt(f9486q0, yVar2.H)).P(bundle.getInt(f9484o0, yVar2.I));
        return bVar.I();
    }

    public static String f(List<a0> list, @Nullable String str) {
        for (a0 a0Var : list) {
            if (TextUtils.equals(a0Var.f8906a, str)) {
                return a0Var.f8907b;
            }
        }
        return list.get(0).f8907b;
    }

    public static String i(int i11) {
        return X + "_" + Integer.toString(i11, 36);
    }

    public static /* synthetic */ boolean j(b bVar, a0 a0Var) {
        return a0Var.f8907b.equals(bVar.f9516b);
    }

    public static String m(@Nullable y yVar) {
        if (yVar == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id=");
        sb2.append(yVar.f9489a);
        sb2.append(", mimeType=");
        sb2.append(yVar.f9501m);
        if (yVar.f9500l != null) {
            sb2.append(", container=");
            sb2.append(yVar.f9500l);
        }
        if (yVar.f9497i != -1) {
            sb2.append(", bitrate=");
            sb2.append(yVar.f9497i);
        }
        if (yVar.f9498j != null) {
            sb2.append(", codecs=");
            sb2.append(yVar.f9498j);
        }
        if (yVar.f9504p != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i11 = 0;
            while (true) {
                DrmInitData drmInitData = yVar.f9504p;
                if (i11 >= drmInitData.schemeDataCount) {
                    break;
                }
                UUID uuid = drmInitData.get(i11).uuid;
                if (uuid.equals(j.f9252b)) {
                    linkedHashSet.add(C.CENC_TYPE_cenc);
                } else if (uuid.equals(j.f9253c)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(j.f9255e)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(j.f9254d)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(j.f9251a)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
                i11++;
            }
            sb2.append(", drm=[");
            com.google.common.base.g.g(',').b(sb2, linkedHashSet);
            sb2.append(']');
        }
        if (yVar.f9506r != -1 && yVar.f9507s != -1) {
            sb2.append(", res=");
            sb2.append(yVar.f9506r);
            sb2.append("x");
            sb2.append(yVar.f9507s);
        }
        k kVar = yVar.f9513y;
        if (kVar != null && kVar.k()) {
            sb2.append(", color=");
            sb2.append(yVar.f9513y.p());
        }
        if (yVar.f9508t != -1.0f) {
            sb2.append(", fps=");
            sb2.append(yVar.f9508t);
        }
        if (yVar.f9514z != -1) {
            sb2.append(", channels=");
            sb2.append(yVar.f9514z);
        }
        if (yVar.A != -1) {
            sb2.append(", sample_rate=");
            sb2.append(yVar.A);
        }
        if (yVar.f9492d != null) {
            sb2.append(", language=");
            sb2.append(yVar.f9492d);
        }
        if (!yVar.f9491c.isEmpty()) {
            sb2.append(", labels=[");
            com.google.common.base.g.g(',').b(sb2, yVar.f9491c);
            sb2.append("]");
        }
        if (yVar.f9493e != 0) {
            sb2.append(", selectionFlags=[");
            com.google.common.base.g.g(',').b(sb2, u0.o0(yVar.f9493e));
            sb2.append("]");
        }
        if (yVar.f9494f != 0) {
            sb2.append(", roleFlags=[");
            com.google.common.base.g.g(',').b(sb2, u0.n0(yVar.f9494f));
            sb2.append("]");
        }
        return sb2.toString();
    }

    public b b() {
        return new b();
    }

    public y c(int i11) {
        return b().P(i11).I();
    }

    public boolean equals(@Nullable Object obj) {
        int i11;
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        int i12 = this.J;
        return (i12 == 0 || (i11 = yVar.J) == 0 || i12 == i11) && this.f9493e == yVar.f9493e && this.f9494f == yVar.f9494f && this.f9495g == yVar.f9495g && this.f9496h == yVar.f9496h && this.f9502n == yVar.f9502n && this.f9505q == yVar.f9505q && this.f9506r == yVar.f9506r && this.f9507s == yVar.f9507s && this.f9509u == yVar.f9509u && this.f9512x == yVar.f9512x && this.f9514z == yVar.f9514z && this.A == yVar.A && this.B == yVar.B && this.C == yVar.C && this.D == yVar.D && this.E == yVar.E && this.G == yVar.G && this.H == yVar.H && this.I == yVar.I && Float.compare(this.f9508t, yVar.f9508t) == 0 && Float.compare(this.f9510v, yVar.f9510v) == 0 && u0.c(this.f9489a, yVar.f9489a) && u0.c(this.f9490b, yVar.f9490b) && this.f9491c.equals(yVar.f9491c) && u0.c(this.f9498j, yVar.f9498j) && u0.c(this.f9500l, yVar.f9500l) && u0.c(this.f9501m, yVar.f9501m) && u0.c(this.f9492d, yVar.f9492d) && Arrays.equals(this.f9511w, yVar.f9511w) && u0.c(this.f9499k, yVar.f9499k) && u0.c(this.f9513y, yVar.f9513y) && u0.c(this.f9504p, yVar.f9504p) && h(yVar);
    }

    public int g() {
        int i11;
        int i12 = this.f9506r;
        if (i12 == -1 || (i11 = this.f9507s) == -1) {
            return -1;
        }
        return i12 * i11;
    }

    public boolean h(y yVar) {
        if (this.f9503o.size() != yVar.f9503o.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f9503o.size(); i11++) {
            if (!Arrays.equals(this.f9503o.get(i11), yVar.f9503o.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.J == 0) {
            String str = this.f9489a;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f9490b;
            int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f9491c.hashCode()) * 31;
            String str3 = this.f9492d;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f9493e) * 31) + this.f9494f) * 31) + this.f9495g) * 31) + this.f9496h) * 31;
            String str4 = this.f9498j;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.f9499k;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.f9500l;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f9501m;
            this.J = ((((((((((((((((((((((((((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f9502n) * 31) + ((int) this.f9505q)) * 31) + this.f9506r) * 31) + this.f9507s) * 31) + Float.floatToIntBits(this.f9508t)) * 31) + this.f9509u) * 31) + Float.floatToIntBits(this.f9510v)) * 31) + this.f9512x) * 31) + this.f9514z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.G) * 31) + this.H) * 31) + this.I;
        }
        return this.J;
    }

    public Bundle k() {
        return l(false);
    }

    public Bundle l(boolean z11) {
        Bundle bundle = new Bundle();
        bundle.putString(L, this.f9489a);
        bundle.putString(M, this.f9490b);
        bundle.putParcelableArrayList(f9487r0, z3.c.c(this.f9491c, new com.google.common.base.f() { // from class: androidx.media3.common.v
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return ((a0) obj).b();
            }
        }));
        bundle.putString(N, this.f9492d);
        bundle.putInt(O, this.f9493e);
        bundle.putInt(P, this.f9494f);
        bundle.putInt(Q, this.f9495g);
        bundle.putInt(R, this.f9496h);
        bundle.putString(S, this.f9498j);
        if (!z11) {
            bundle.putParcelable(T, this.f9499k);
        }
        bundle.putString(U, this.f9500l);
        bundle.putString(V, this.f9501m);
        bundle.putInt(W, this.f9502n);
        for (int i11 = 0; i11 < this.f9503o.size(); i11++) {
            bundle.putByteArray(i(i11), this.f9503o.get(i11));
        }
        bundle.putParcelable(Y, this.f9504p);
        bundle.putLong(Z, this.f9505q);
        bundle.putInt(f9470a0, this.f9506r);
        bundle.putInt(f9471b0, this.f9507s);
        bundle.putFloat(f9472c0, this.f9508t);
        bundle.putInt(f9473d0, this.f9509u);
        bundle.putFloat(f9474e0, this.f9510v);
        bundle.putByteArray(f9475f0, this.f9511w);
        bundle.putInt(f9476g0, this.f9512x);
        k kVar = this.f9513y;
        if (kVar != null) {
            bundle.putBundle(f9477h0, kVar.o());
        }
        bundle.putInt(f9478i0, this.f9514z);
        bundle.putInt(f9479j0, this.A);
        bundle.putInt(f9480k0, this.B);
        bundle.putInt(f9481l0, this.C);
        bundle.putInt(f9482m0, this.D);
        bundle.putInt(f9483n0, this.E);
        bundle.putInt(f9485p0, this.G);
        bundle.putInt(f9486q0, this.H);
        bundle.putInt(f9484o0, this.I);
        return bundle;
    }

    public y n(y yVar) {
        String str;
        if (this == yVar) {
            return this;
        }
        int iK = f0.k(this.f9501m);
        String str2 = yVar.f9489a;
        int i11 = yVar.G;
        int i12 = yVar.H;
        String str3 = yVar.f9490b;
        if (str3 == null) {
            str3 = this.f9490b;
        }
        List<a0> list = !yVar.f9491c.isEmpty() ? yVar.f9491c : this.f9491c;
        String str4 = this.f9492d;
        if ((iK == 3 || iK == 1) && (str = yVar.f9492d) != null) {
            str4 = str;
        }
        int i13 = this.f9495g;
        if (i13 == -1) {
            i13 = yVar.f9495g;
        }
        int i14 = this.f9496h;
        if (i14 == -1) {
            i14 = yVar.f9496h;
        }
        String str5 = this.f9498j;
        if (str5 == null) {
            String strQ = u0.Q(yVar.f9498j, iK);
            if (u0.q1(strQ).length == 1) {
                str5 = strQ;
            }
        }
        Metadata metadata = this.f9499k;
        Metadata metadataCopyWithAppendedEntriesFrom = metadata == null ? yVar.f9499k : metadata.copyWithAppendedEntriesFrom(yVar.f9499k);
        float f11 = this.f9508t;
        if (f11 == -1.0f && iK == 2) {
            f11 = yVar.f9508t;
        }
        return b().X(str2).Z(str3).a0(list).b0(str4).m0(this.f9493e | yVar.f9493e).i0(this.f9494f | yVar.f9494f).K(i13).f0(i14).M(str5).d0(metadataCopyWithAppendedEntriesFrom).R(DrmInitData.createSessionCreationData(yVar.f9504p, this.f9504p)).U(f11).p0(i11).q0(i12).I();
    }

    public String toString() {
        return "Format(" + this.f9489a + ", " + this.f9490b + ", " + this.f9500l + ", " + this.f9501m + ", " + this.f9498j + ", " + this.f9497i + ", " + this.f9492d + ", [" + this.f9506r + ", " + this.f9507s + ", " + this.f9508t + ", " + this.f9513y + "], [" + this.f9514z + ", " + this.A + "])";
    }
}
