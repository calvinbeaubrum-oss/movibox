package ov;

import java.util.Arrays;
import kotlin.Metadata;
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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f73443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f73444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f73445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f73446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b[] f73447e;

    public d(int i11, String str, int i12, boolean z11, b[] formats) {
        Intrinsics.g(formats, "formats");
        this.f73443a = i11;
        this.f73444b = str;
        this.f73445c = i12;
        this.f73446d = z11;
        this.f73447e = formats;
    }

    public final boolean a() {
        return this.f73446d;
    }

    public final b[] b() {
        return this.f73447e;
    }

    public final String c() {
        return this.f73444b;
    }

    public final int d() {
        return this.f73443a;
    }

    public final int e() {
        return this.f73445c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f73443a == dVar.f73443a && Intrinsics.b(this.f73444b, dVar.f73444b) && this.f73445c == dVar.f73445c && this.f73446d == dVar.f73446d && Intrinsics.b(this.f73447e, dVar.f73447e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        int i11 = this.f73443a * 31;
        String str = this.f73444b;
        int iHashCode = (((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.f73445c) * 31;
        boolean z11 = this.f73446d;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return ((iHashCode + r11) * 31) + Arrays.hashCode(this.f73447e);
    }

    public String toString() {
        return "TnTracksGroup(length=" + this.f73443a + ", id=" + this.f73444b + ", type=" + this.f73445c + ", adaptiveSupported=" + this.f73446d + ", formats=" + Arrays.toString(this.f73447e) + ")";
    }
}
