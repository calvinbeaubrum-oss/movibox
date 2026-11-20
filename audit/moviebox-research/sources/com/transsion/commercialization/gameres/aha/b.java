package com.transsion.commercialization.gameres.aha;

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
    public Integer f51668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f51669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f51670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f51671d;

    public b() {
        this(null, null, null, null, 15, null);
    }

    public b(Integer num, String str, Long l11, c cVar) {
        this.f51668a = num;
        this.f51669b = str;
        this.f51670c = l11;
        this.f51671d = cVar;
    }

    public /* synthetic */ b(Integer num, String str, Long l11, c cVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : l11, (i11 & 8) != 0 ? null : cVar);
    }

    public final Integer a() {
        return this.f51668a;
    }

    public final c b() {
        return this.f51671d;
    }

    public final String c() {
        return this.f51669b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.b(this.f51668a, bVar.f51668a) && Intrinsics.b(this.f51669b, bVar.f51669b) && Intrinsics.b(this.f51670c, bVar.f51670c) && Intrinsics.b(this.f51671d, bVar.f51671d);
    }

    public int hashCode() {
        Integer num = this.f51668a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f51669b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l11 = this.f51670c;
        int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        c cVar = this.f51671d;
        return iHashCode3 + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "AHAGameResDto(code=" + this.f51668a + ", message=" + this.f51669b + ", timestamp=" + this.f51670c + ", data=" + this.f51671d + ")";
    }
}
