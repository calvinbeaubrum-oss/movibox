package com.transsion.commercialization.gameres.aha;

import com.google.gson.annotations.SerializedName;
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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f51672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f51673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Double f51674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f51675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f51676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SerializedName("link")
    private String f51677f;

    public c() {
        this(null, null, null, null, null, null, 63, null);
    }

    public c(String str, String str2, Double d11, String str3, String str4, String str5) {
        this.f51672a = str;
        this.f51673b = str2;
        this.f51674c = d11;
        this.f51675d = str3;
        this.f51676e = str4;
        this.f51677f = str5;
    }

    public /* synthetic */ c(String str, String str2, Double d11, String str3, String str4, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : d11, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5);
    }

    public final String a() {
        return this.f51677f;
    }

    public final String b() {
        return this.f51676e;
    }

    public final String c() {
        return this.f51673b;
    }

    public final String d() {
        return this.f51675d;
    }

    public final Double e() {
        return this.f51674c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.b(this.f51672a, cVar.f51672a) && Intrinsics.b(this.f51673b, cVar.f51673b) && Intrinsics.b(this.f51674c, cVar.f51674c) && Intrinsics.b(this.f51675d, cVar.f51675d) && Intrinsics.b(this.f51676e, cVar.f51676e) && Intrinsics.b(this.f51677f, cVar.f51677f);
    }

    public final String f() {
        return this.f51672a;
    }

    public int hashCode() {
        String str = this.f51672a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f51673b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d11 = this.f51674c;
        int iHashCode3 = (iHashCode2 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str3 = this.f51675d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f51676e;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f51677f;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "AHAGameResInfo(title=" + this.f51672a + ", icon=" + this.f51673b + ", star=" + this.f51674c + ", size=" + this.f51675d + ", category=" + this.f51676e + ", appLink=" + this.f51677f + ")";
    }
}
