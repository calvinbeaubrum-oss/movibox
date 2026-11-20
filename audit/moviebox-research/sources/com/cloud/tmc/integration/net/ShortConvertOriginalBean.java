package com.cloud.tmc.integration.net;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
public final class ShortConvertOriginalBean extends b {
    private final String originalUrl;

    public ShortConvertOriginalBean(String str) {
        this.originalUrl = str;
    }

    public static /* synthetic */ ShortConvertOriginalBean copy$default(ShortConvertOriginalBean shortConvertOriginalBean, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = shortConvertOriginalBean.originalUrl;
        }
        return shortConvertOriginalBean.copy(str);
    }

    public final String component1() {
        return this.originalUrl;
    }

    public final ShortConvertOriginalBean copy(String str) {
        return new ShortConvertOriginalBean(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShortConvertOriginalBean) && Intrinsics.b(this.originalUrl, ((ShortConvertOriginalBean) obj).originalUrl);
    }

    public final String getOriginalUrl() {
        return this.originalUrl;
    }

    public int hashCode() {
        String str = this.originalUrl;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ShortConvertOriginalBean(originalUrl=" + this.originalUrl + ')';
    }
}
