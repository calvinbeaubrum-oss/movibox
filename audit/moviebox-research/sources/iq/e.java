package iq;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import l.p;
import org.mvel2.ast.ASTNode;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class e {
    public static final a J = new a(null);
    public int A;
    public String B;
    public String C;
    public String D;
    public String E;
    public int F;
    public String G;
    public String H;
    public int I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f67598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f67599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f67600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f67601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f67602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f67603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f67604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f67605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f67606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f67607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f67608k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f67609l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f67610m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f67611n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f67612o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f67613p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f67614q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f67615r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f67616s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f67617t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f67618u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f67619v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f67620w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f67621x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f67622y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f67623z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a(int i11, String str) {
            e eVar = new e(0, null, 0, 0, null, null, null, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, null, null, null, null, null, 0, null, null, null, null, 0, null, null, 0, -1, 7, null);
            eVar.l0(i11);
            eVar.N(str);
            return eVar;
        }
    }

    public e() {
        this(0, null, 0, 0, null, null, null, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, null, null, null, null, null, 0, null, null, null, null, 0, null, null, 0, -1, 7, null);
    }

    public e(int i11, String callId, int i12, int i13, String errorMsg, String serverApi, String str, String ipAddr, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, String cdnSpeed, String cdnIp, String cdnProvider, String country, String path, String host, int i14, String str2, String sdkVersion, String protocol, String compareTag, int i15, String contentEncoding, String tlsVersion, int i16) {
        Intrinsics.g(callId, "callId");
        Intrinsics.g(errorMsg, "errorMsg");
        Intrinsics.g(serverApi, "serverApi");
        Intrinsics.g(ipAddr, "ipAddr");
        Intrinsics.g(cdnSpeed, "cdnSpeed");
        Intrinsics.g(cdnIp, "cdnIp");
        Intrinsics.g(cdnProvider, "cdnProvider");
        Intrinsics.g(country, "country");
        Intrinsics.g(path, "path");
        Intrinsics.g(host, "host");
        Intrinsics.g(sdkVersion, "sdkVersion");
        Intrinsics.g(protocol, "protocol");
        Intrinsics.g(compareTag, "compareTag");
        Intrinsics.g(contentEncoding, "contentEncoding");
        Intrinsics.g(tlsVersion, "tlsVersion");
        this.f67598a = i11;
        this.f67599b = callId;
        this.f67600c = i12;
        this.f67601d = i13;
        this.f67602e = errorMsg;
        this.f67603f = serverApi;
        this.f67604g = str;
        this.f67605h = ipAddr;
        this.f67606i = j11;
        this.f67607j = j12;
        this.f67608k = j13;
        this.f67609l = j14;
        this.f67610m = j15;
        this.f67611n = j16;
        this.f67612o = j17;
        this.f67613p = j18;
        this.f67614q = j19;
        this.f67615r = j21;
        this.f67616s = j22;
        this.f67617t = j23;
        this.f67618u = cdnSpeed;
        this.f67619v = cdnIp;
        this.f67620w = cdnProvider;
        this.f67621x = country;
        this.f67622y = path;
        this.f67623z = host;
        this.A = i14;
        this.B = str2;
        this.C = sdkVersion;
        this.D = protocol;
        this.E = compareTag;
        this.F = i15;
        this.G = contentEncoding;
        this.H = tlsVersion;
        this.I = i16;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ e(int i11, String str, int i12, int i13, String str2, String str3, String str4, String str5, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, String str6, String str7, String str8, String str9, String str10, String str11, int i14, String str12, String str13, String str14, String str15, int i15, String str16, String str17, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        String strReplace;
        String strA;
        int i19 = (i17 & 1) != 0 ? 0 : i11;
        if ((i17 & 2) != 0) {
            String string = UUID.randomUUID().toString();
            Intrinsics.f(string, "randomUUID().toString()");
            strReplace = new Regex("-").replace(string, "");
        } else {
            strReplace = str;
        }
        int i21 = (i17 & 4) != 0 ? 0 : i12;
        int i22 = (i17 & 8) != 0 ? 0 : i13;
        String str18 = (i17 & 16) != 0 ? "" : str2;
        String str19 = (i17 & 32) != 0 ? "" : str3;
        String str20 = (i17 & 64) != 0 ? null : str4;
        String str21 = (i17 & 128) != 0 ? "" : str5;
        long j24 = (i17 & 256) != 0 ? 0L : j11;
        long j25 = (i17 & 512) != 0 ? 0L : j12;
        long j26 = (i17 & 1024) != 0 ? 0L : j13;
        long j27 = (i17 & 2048) != 0 ? 0L : j14;
        long j28 = (i17 & 4096) != 0 ? 0L : j15;
        long j29 = (i17 & 8192) != 0 ? 0L : j16;
        long j31 = (i17 & 16384) != 0 ? 0L : j17;
        long j32 = (32768 & i17) != 0 ? 0L : j18;
        long j33 = (65536 & i17) != 0 ? 0L : j19;
        long j34 = (131072 & i17) != 0 ? 0L : j21;
        long j35 = (262144 & i17) != 0 ? 0L : j22;
        long j36 = (524288 & i17) == 0 ? j23 : 0L;
        String str22 = (1048576 & i17) != 0 ? "" : str6;
        String str23 = (i17 & 2097152) != 0 ? "" : str7;
        String str24 = (i17 & 4194304) != 0 ? "" : str8;
        if ((i17 & 8388608) != 0) {
            strA = o.a();
            Intrinsics.f(strA, "getCountry()");
        } else {
            strA = str9;
        }
        this(i19, strReplace, i21, i22, str18, str19, str20, str21, j24, j25, j26, j27, j28, j29, j31, j32, j33, j34, j35, j36, str22, str23, str24, strA, (16777216 & i17) != 0 ? "" : str10, (i17 & ASTNode.PCTX_STORED) != 0 ? r4 : str11, (i17 & 67108864) != 0 ? 0 : i14, (i17 & ASTNode.NOJIT) != 0 ? "All" : str12, (i17 & ASTNode.DEOP) != 0 ? "1.0.17.1" : str13, (i17 & ASTNode.DISCARD) != 0 ? r4 : str14, (i17 & 1073741824) != 0 ? r4 : str15, (i17 & Integer.MIN_VALUE) != 0 ? 1 : i15, (i18 & 1) != 0 ? r4 : str16, (i18 & 2) != 0 ? r4 : str17, (i18 & 4) != 0 ? 0 : i16);
    }

    public final long A() {
        return this.f67609l;
    }

    public final String B() {
        return this.f67603f;
    }

    public final long C() {
        return this.f67615r;
    }

    public final long D() {
        return this.f67608k;
    }

    public final long E() {
        return this.f67607j;
    }

    public final String F() {
        return this.H;
    }

    public final int G() {
        return this.f67598a;
    }

    public final long H() {
        return this.f67610m;
    }

    public final void I(int i11) {
        this.f67600c = i11;
    }

    public final void J(long j11) {
        this.f67617t = j11;
    }

    public final void K(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f67620w = str;
    }

    public final void L(long j11) {
        this.f67616s = j11;
    }

    public final void M(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f67618u = str;
    }

    public final void N(String str) {
        this.B = str;
    }

    public final void O(String str) {
        Intrinsics.g(str, "<set-?>");
        this.E = str;
    }

    public final void P(String str) {
        this.f67604g = str;
    }

    public final void Q(String str) {
        Intrinsics.g(str, "<set-?>");
        this.G = str;
    }

    public final void R(long j11) {
        this.f67606i = j11;
    }

    public final void S(int i11) {
        this.f67601d = i11;
    }

    public final void T(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f67602e = str;
    }

    public final void U(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f67623z = str;
    }

    public final void V(int i11) {
        this.F = i11;
    }

    public final void W(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f67605h = str;
    }

    public final void X(int i11) {
        this.A = i11;
    }

    public final void Y(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f67622y = str;
    }

    public final void Z(String str) {
        Intrinsics.g(str, "<set-?>");
        this.D = str;
    }

    public final String a() {
        return this.f67599b;
    }

    public final void a0(long j11) {
        this.f67611n = j11;
    }

    public final int b() {
        return this.f67600c;
    }

    public final void b0(long j11) {
        this.f67613p = j11;
    }

    public final long c() {
        return this.f67617t;
    }

    public final void c0(long j11) {
        this.f67612o = j11;
    }

    public final String d() {
        return this.f67620w;
    }

    public final void d0(int i11) {
        this.I = i11;
    }

    public final long e() {
        return this.f67616s;
    }

    public final void e0(long j11) {
        this.f67614q = j11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f67598a == eVar.f67598a && Intrinsics.b(this.f67599b, eVar.f67599b) && this.f67600c == eVar.f67600c && this.f67601d == eVar.f67601d && Intrinsics.b(this.f67602e, eVar.f67602e) && Intrinsics.b(this.f67603f, eVar.f67603f) && Intrinsics.b(this.f67604g, eVar.f67604g) && Intrinsics.b(this.f67605h, eVar.f67605h) && this.f67606i == eVar.f67606i && this.f67607j == eVar.f67607j && this.f67608k == eVar.f67608k && this.f67609l == eVar.f67609l && this.f67610m == eVar.f67610m && this.f67611n == eVar.f67611n && this.f67612o == eVar.f67612o && this.f67613p == eVar.f67613p && this.f67614q == eVar.f67614q && this.f67615r == eVar.f67615r && this.f67616s == eVar.f67616s && this.f67617t == eVar.f67617t && Intrinsics.b(this.f67618u, eVar.f67618u) && Intrinsics.b(this.f67619v, eVar.f67619v) && Intrinsics.b(this.f67620w, eVar.f67620w) && Intrinsics.b(this.f67621x, eVar.f67621x) && Intrinsics.b(this.f67622y, eVar.f67622y) && Intrinsics.b(this.f67623z, eVar.f67623z) && this.A == eVar.A && Intrinsics.b(this.B, eVar.B) && Intrinsics.b(this.C, eVar.C) && Intrinsics.b(this.D, eVar.D) && Intrinsics.b(this.E, eVar.E) && this.F == eVar.F && Intrinsics.b(this.G, eVar.G) && Intrinsics.b(this.H, eVar.H) && this.I == eVar.I;
    }

    public final String f() {
        return this.f67618u;
    }

    public final void f0(long j11) {
        this.f67609l = j11;
    }

    public final String g() {
        return this.B;
    }

    public final void g0(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f67603f = str;
    }

    public final String h() {
        return this.E;
    }

    public final void h0(long j11) {
        this.f67615r = j11;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.f67598a * 31) + this.f67599b.hashCode()) * 31) + this.f67600c) * 31) + this.f67601d) * 31) + this.f67602e.hashCode()) * 31) + this.f67603f.hashCode()) * 31;
        String str = this.f67604g;
        int iHashCode2 = (((((((((((((((((((((((((((((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f67605h.hashCode()) * 31) + p.a(this.f67606i)) * 31) + p.a(this.f67607j)) * 31) + p.a(this.f67608k)) * 31) + p.a(this.f67609l)) * 31) + p.a(this.f67610m)) * 31) + p.a(this.f67611n)) * 31) + p.a(this.f67612o)) * 31) + p.a(this.f67613p)) * 31) + p.a(this.f67614q)) * 31) + p.a(this.f67615r)) * 31) + p.a(this.f67616s)) * 31) + p.a(this.f67617t)) * 31) + this.f67618u.hashCode()) * 31) + this.f67619v.hashCode()) * 31) + this.f67620w.hashCode()) * 31) + this.f67621x.hashCode()) * 31) + this.f67622y.hashCode()) * 31) + this.f67623z.hashCode()) * 31) + this.A) * 31;
        String str2 = this.B;
        return ((((((((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.C.hashCode()) * 31) + this.D.hashCode()) * 31) + this.E.hashCode()) * 31) + this.F) * 31) + this.G.hashCode()) * 31) + this.H.hashCode()) * 31) + this.I;
    }

    public final String i() {
        return this.f67604g;
    }

    public final void i0(long j11) {
        this.f67608k = j11;
    }

    public final String j() {
        return this.G;
    }

    public final void j0(long j11) {
        this.f67607j = j11;
    }

    public final String k() {
        return this.f67621x;
    }

    public final void k0(String str) {
        Intrinsics.g(str, "<set-?>");
        this.H = str;
    }

    public final long l() {
        return this.f67606i;
    }

    public final void l0(int i11) {
        this.f67598a = i11;
    }

    public final int m() {
        return this.f67601d;
    }

    public final void m0(long j11) {
        this.f67610m = j11;
    }

    public final String n() {
        return this.f67602e;
    }

    public final String o() {
        return this.f67623z;
    }

    public final int p() {
        return this.F;
    }

    public final String q() {
        return this.f67605h;
    }

    public final int r() {
        return this.A;
    }

    public final String s() {
        return this.f67622y;
    }

    public final String t() {
        return this.D;
    }

    public String toString() {
        return "{\n                    usage            : " + this.f67598a + "\n                    call_id          : " + this.f67599b + "\n                    call_result_code : " + this.f67600c + "\n                    server_api       : " + this.f67603f + "\n                    complete_api     : " + this.f67604g + "\n                    ip_address       : " + this.f67605h + "\n                    error_code       : " + this.f67601d + "\n                    error_msg        : " + this.f67602e + "\n                    req_time         : " + this.f67612o + "ms\n                    dns_time         : " + this.f67606i + "ms\n                    tcp_time         : " + this.f67607j + "ms\n                    ssl_time         : " + this.f67608k + "ms\n                    send_time        : " + this.f67609l + "ms\n                    wait_time        : " + this.f67610m + "ms\n                    rec_time         : " + this.f67611n + "ms\n                    req_body_size    : " + this.f67613p + "b\n                    res_body_size    : " + this.f67614q + "b\n                    server_time      : " + this.f67615r + "ms\n                    cdn_req_time     : " + this.f67616s + "ms\n                    cdn_down_time    : " + this.f67617t + "ms\n                    cdn_speed        : " + this.f67618u + "kb/s\n                    cdn_provider     : " + this.f67620w + "\n                    country          : " + this.f67621x + "\n                    path             : " + this.f67622y + "\n                    host             : " + this.f67623z + "\n                    channel          : " + this.B + "\n                    sdk_version      : " + this.C + "\n                    protocol         : " + this.D + "\n                    compare_tag      : " + this.E + "\n                    http_type        : " + this.F + "\n                    content_encoding : " + this.G + "\n                    tls_version      : " + this.H + "\n                    request_downgrade : " + this.I + "\n                  }";
    }

    public final long u() {
        return this.f67611n;
    }

    public final long v() {
        return this.f67613p;
    }

    public final long w() {
        return this.f67612o;
    }

    public final int x() {
        return this.I;
    }

    public final long y() {
        return this.f67614q;
    }

    public final String z() {
        return this.C;
    }
}
