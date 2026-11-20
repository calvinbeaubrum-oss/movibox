package qy;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.c;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.d;
import fp.b;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final C0821a f74994r = new C0821a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f74995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f74996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f74997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f74998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f74999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f75000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f75001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f75002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f75003i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f75004j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f75005k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f75006l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f75007m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f75008n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f75009o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f75010p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f75011q;

    /* JADX INFO: renamed from: qy.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0821a {
        public C0821a() {
        }

        public /* synthetic */ C0821a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(a aVar) {
            if (aVar.q()) {
                throw new RuntimeException("the device isn‘t sender");
            }
            if (aVar.a()) {
                String strB = b();
                String upperCase = d.f59247a.a(4).toUpperCase(Locale.ROOT);
                Intrinsics.f(upperCase, "toUpperCase(...)");
                return strB + "-5G-" + upperCase;
            }
            String strB2 = b();
            String upperCase2 = d.f59247a.a(4).toUpperCase(Locale.ROOT);
            Intrinsics.f(upperCase2, "toUpperCase(...)");
            return strB2 + "-" + upperCase2;
        }

        public final String b() {
            String upperCase = d.f59247a.a(2).toUpperCase(Locale.ROOT);
            Intrinsics.f(upperCase, "toUpperCase(...)");
            return "DIRECT-" + upperCase + "-MOVIEBOX";
        }

        public final a c(boolean z11) {
            String str = null;
            a aVar = new a(null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, str, false, 131071, null);
            aVar.y("mb_unique");
            aVar.u(Build.DEVICE);
            aVar.s(Build.BRAND);
            aVar.w(Build.PRODUCT);
            aVar.C(Build.VERSION.RELEASE);
            aVar.D(String.valueOf(Build.VERSION.SDK_INT));
            aVar.A(String.valueOf(c.d()));
            aVar.B(c.f());
            aVar.v(c.c());
            b.a aVar2 = b.f65208a;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            aVar.t(aVar2.e(applicationA));
            aVar.z("userId");
            aVar.r("avatarIndex");
            if (z11) {
                aVar.E("5G");
            } else {
                aVar.E("2.4G");
            }
            aVar.H(a(aVar));
            com.transsion.transfer.wifi.util.b bVar = com.transsion.transfer.wifi.util.b.f59245a;
            String strP = aVar.p();
            if (strP == null) {
                strP = "";
            }
            String strSubstring = bVar.a(strP).substring(0, 8);
            Intrinsics.f(strSubstring, "substring(...)");
            aVar.G(strSubstring);
            aVar.x(true);
            return aVar;
        }
    }

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 131071, null);
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, boolean z11) {
        this.f74995a = str;
        this.f74996b = str2;
        this.f74997c = str3;
        this.f74998d = str4;
        this.f74999e = str5;
        this.f75000f = str6;
        this.f75001g = str7;
        this.f75002h = str8;
        this.f75003i = str9;
        this.f75004j = str10;
        this.f75005k = str11;
        this.f75006l = str12;
        this.f75007m = str13;
        this.f75008n = str14;
        this.f75009o = str15;
        this.f75010p = str16;
        this.f75011q = z11;
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : str7, (i11 & 128) != 0 ? null : str8, (i11 & 256) != 0 ? null : str9, (i11 & 512) != 0 ? null : str10, (i11 & 1024) != 0 ? null : str11, (i11 & 2048) != 0 ? null : str12, (i11 & 4096) != 0 ? null : str13, (i11 & 8192) != 0 ? null : str14, (i11 & 16384) != 0 ? null : str15, (i11 & 32768) != 0 ? null : str16, (i11 & 65536) != 0 ? false : z11);
    }

    public final void A(String str) {
        this.f75001g = str;
    }

    public final void B(String str) {
        this.f75002h = str;
    }

    public final void C(String str) {
        this.f74999e = str;
    }

    public final void D(String str) {
        this.f75000f = str;
    }

    public final void E(String str) {
        this.f75009o = str;
    }

    public final void F(String str) {
        this.f75010p = str;
    }

    public final void G(String str) {
        this.f75008n = str;
    }

    public final void H(String str) {
        this.f75007m = str;
    }

    public final boolean a() {
        return WifiUtils.f59242a.m() && TextUtils.equals(this.f75009o, "5G");
    }

    public final String b() {
        return this.f75006l;
    }

    public final String c() {
        return this.f74997c;
    }

    public final String d() {
        return this.f75004j;
    }

    public final String e() {
        return this.f74996b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f74995a, aVar.f74995a) && Intrinsics.b(this.f74996b, aVar.f74996b) && Intrinsics.b(this.f74997c, aVar.f74997c) && Intrinsics.b(this.f74998d, aVar.f74998d) && Intrinsics.b(this.f74999e, aVar.f74999e) && Intrinsics.b(this.f75000f, aVar.f75000f) && Intrinsics.b(this.f75001g, aVar.f75001g) && Intrinsics.b(this.f75002h, aVar.f75002h) && Intrinsics.b(this.f75003i, aVar.f75003i) && Intrinsics.b(this.f75004j, aVar.f75004j) && Intrinsics.b(this.f75005k, aVar.f75005k) && Intrinsics.b(this.f75006l, aVar.f75006l) && Intrinsics.b(this.f75007m, aVar.f75007m) && Intrinsics.b(this.f75008n, aVar.f75008n) && Intrinsics.b(this.f75009o, aVar.f75009o) && Intrinsics.b(this.f75010p, aVar.f75010p) && this.f75011q == aVar.f75011q;
    }

    public final String f() {
        return this.f75003i;
    }

    public final String g() {
        return this.f74998d;
    }

    public final String h() {
        return this.f75005k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.f74995a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f74996b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f74997c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f74998d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f74999e;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f75000f;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f75001g;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f75002h;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f75003i;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.f75004j;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.f75005k;
        int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.f75006l;
        int iHashCode12 = (iHashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.f75007m;
        int iHashCode13 = (iHashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.f75008n;
        int iHashCode14 = (iHashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.f75009o;
        int iHashCode15 = (iHashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.f75010p;
        int iHashCode16 = (iHashCode15 + (str16 != null ? str16.hashCode() : 0)) * 31;
        boolean z11 = this.f75011q;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode16 + r11;
    }

    public final String i() {
        return this.f75001g;
    }

    public final String j() {
        return this.f75002h;
    }

    public final String k() {
        return this.f74999e;
    }

    public final String l() {
        return this.f75000f;
    }

    public final String m() {
        return this.f75009o;
    }

    public final String n() {
        return this.f75010p;
    }

    public final String o() {
        return this.f75008n;
    }

    public final String p() {
        return this.f75007m;
    }

    public final boolean q() {
        return this.f75011q;
    }

    public final void r(String str) {
        this.f75006l = str;
    }

    public final void s(String str) {
        this.f74997c = str;
    }

    public final void t(String str) {
        this.f75004j = str;
    }

    public String toString() {
        return "WifiInfoModel(unique=" + this.f74995a + ", device=" + this.f74996b + ", brand=" + this.f74997c + ", product=" + this.f74998d + ", versionRelease=" + this.f74999e + ", versionSdkInt=" + this.f75000f + ", versionCode=" + this.f75001g + ", versionName=" + this.f75002h + ", packageName=" + this.f75003i + ", channel=" + this.f75004j + ", userId=" + this.f75005k + ", avatarIndex=" + this.f75006l + ", wifiSsid=" + this.f75007m + ", wifiPwd=" + this.f75008n + ", wifiChannel=" + this.f75009o + ", wifiIp=" + this.f75010p + ", isSender=" + this.f75011q + ")";
    }

    public final void u(String str) {
        this.f74996b = str;
    }

    public final void v(String str) {
        this.f75003i = str;
    }

    public final void w(String str) {
        this.f74998d = str;
    }

    public final void x(boolean z11) {
        this.f75011q = z11;
    }

    public final void y(String str) {
        this.f74995a = str;
    }

    public final void z(String str) {
        this.f75005k = str;
    }
}
