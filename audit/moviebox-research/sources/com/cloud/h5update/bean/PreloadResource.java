package com.cloud.h5update.bean;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PreloadResource {
    private final String encryptedStaticZip;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final Integer f28881id;
    private final String staticZipUrl;
    private final String url;
    private final Long version;

    public PreloadResource() {
        this(null, null, null, null, null, 31, null);
    }

    public PreloadResource(String str, Integer num, String str2, String str3, Long l11) {
        this.encryptedStaticZip = str;
        this.f28881id = num;
        this.staticZipUrl = str2;
        this.url = str3;
        this.version = l11;
    }

    public /* synthetic */ PreloadResource(String str, Integer num, String str2, String str3, Long l11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : l11);
    }

    public static /* synthetic */ PreloadResource copy$default(PreloadResource preloadResource, String str, Integer num, String str2, String str3, Long l11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = preloadResource.encryptedStaticZip;
        }
        if ((i11 & 2) != 0) {
            num = preloadResource.f28881id;
        }
        Integer num2 = num;
        if ((i11 & 4) != 0) {
            str2 = preloadResource.staticZipUrl;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            str3 = preloadResource.url;
        }
        String str5 = str3;
        if ((i11 & 16) != 0) {
            l11 = preloadResource.version;
        }
        return preloadResource.copy(str, num2, str4, str5, l11);
    }

    public final String component1() {
        return this.encryptedStaticZip;
    }

    public final Integer component2() {
        return this.f28881id;
    }

    public final String component3() {
        return this.staticZipUrl;
    }

    public final String component4() {
        return this.url;
    }

    public final Long component5() {
        return this.version;
    }

    public final PreloadResource copy(String str, Integer num, String str2, String str3, Long l11) {
        return new PreloadResource(str, num, str2, str3, l11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreloadResource)) {
            return false;
        }
        PreloadResource preloadResource = (PreloadResource) obj;
        return Intrinsics.b(this.encryptedStaticZip, preloadResource.encryptedStaticZip) && Intrinsics.b(this.f28881id, preloadResource.f28881id) && Intrinsics.b(this.staticZipUrl, preloadResource.staticZipUrl) && Intrinsics.b(this.url, preloadResource.url) && Intrinsics.b(this.version, preloadResource.version);
    }

    public final String getEncryptedStaticZip() {
        return this.encryptedStaticZip;
    }

    public final Integer getId() {
        return this.f28881id;
    }

    public final String getStaticZipUrl() {
        return this.staticZipUrl;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Long getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.encryptedStaticZip;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.f28881id;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.staticZipUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l11 = this.version;
        return iHashCode4 + (l11 != null ? l11.hashCode() : 0);
    }

    public String toString() {
        return "PreloadResource(encryptedStaticZip=" + this.encryptedStaticZip + ", id=" + this.f28881id + ", staticZipUrl=" + this.staticZipUrl + ", url=" + this.url + ", version=" + this.version + ')';
    }
}
