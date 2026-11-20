package ov;

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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f73429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f73430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f73431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f73432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f73433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f73434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f73435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f73436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f73437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f73438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f73439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f73440l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f73441m;

    public b() {
        this(null, null, null, 0, 0, 0, 0, null, 0, 0, 0.0f, 0, 0.0f, 8191, null);
    }

    public b(String str, String str2, String str3, int i11, int i12, int i13, int i14, String str4, int i15, int i16, float f11, int i17, float f12) {
        this.f73429a = str;
        this.f73430b = str2;
        this.f73431c = str3;
        this.f73432d = i11;
        this.f73433e = i12;
        this.f73434f = i13;
        this.f73435g = i14;
        this.f73436h = str4;
        this.f73437i = i15;
        this.f73438j = i16;
        this.f73439k = f11;
        this.f73440l = i17;
        this.f73441m = f12;
    }

    public /* synthetic */ b(String str, String str2, String str3, int i11, int i12, int i13, int i14, String str4, int i15, int i16, float f11, int i17, float f12, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? null : str, (i18 & 2) != 0 ? null : str2, (i18 & 4) != 0 ? null : str3, (i18 & 8) != 0 ? 0 : i11, (i18 & 16) != 0 ? 0 : i12, (i18 & 32) != 0 ? 0 : i13, (i18 & 64) != 0 ? 0 : i14, (i18 & 128) == 0 ? str4 : null, (i18 & 256) != 0 ? 0 : i15, (i18 & 512) != 0 ? 0 : i16, (i18 & 1024) != 0 ? 0.0f : f11, (i18 & 2048) == 0 ? i17 : 0, (i18 & 4096) == 0 ? f12 : 0.0f);
    }

    public final int a() {
        return this.f73435g;
    }

    public final String b() {
        return this.f73436h;
    }

    public final int c() {
        return this.f73438j;
    }

    public final String d() {
        return this.f73429a;
    }

    public final int e() {
        return this.f73434f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.b(this.f73429a, bVar.f73429a) && Intrinsics.b(this.f73430b, bVar.f73430b) && Intrinsics.b(this.f73431c, bVar.f73431c) && this.f73432d == bVar.f73432d && this.f73433e == bVar.f73433e && this.f73434f == bVar.f73434f && this.f73435g == bVar.f73435g && Intrinsics.b(this.f73436h, bVar.f73436h) && this.f73437i == bVar.f73437i && this.f73438j == bVar.f73438j && Float.compare(this.f73439k, bVar.f73439k) == 0 && this.f73440l == bVar.f73440l && Float.compare(this.f73441m, bVar.f73441m) == 0;
    }

    public final int f() {
        return this.f73437i;
    }

    public int hashCode() {
        String str = this.f73429a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f73430b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f73431c;
        int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f73432d) * 31) + this.f73433e) * 31) + this.f73434f) * 31) + this.f73435g) * 31;
        String str4 = this.f73436h;
        return ((((((((((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.f73437i) * 31) + this.f73438j) * 31) + Float.floatToIntBits(this.f73439k)) * 31) + this.f73440l) * 31) + Float.floatToIntBits(this.f73441m);
    }

    public String toString() {
        return "TnFormat(id=" + this.f73429a + ", label=" + this.f73430b + ", language=" + this.f73431c + ", selectionFlags=" + this.f73432d + ", averageBitrate=" + this.f73433e + ", peakBitrate=" + this.f73434f + ", bitrate=" + this.f73435g + ", codecs=" + this.f73436h + ", width=" + this.f73437i + ", height=" + this.f73438j + ", frameRate=" + this.f73439k + ", rotationDegrees=" + this.f73440l + ", pixelWidthHeightRatio=" + this.f73441m + ")";
    }
}
