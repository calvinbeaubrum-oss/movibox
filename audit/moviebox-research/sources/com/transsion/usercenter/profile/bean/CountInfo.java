package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class CountInfo implements Serializable {
    private int count;

    public CountInfo(int i11) {
        this.count = i11;
    }

    public static /* synthetic */ CountInfo copy$default(CountInfo countInfo, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = countInfo.count;
        }
        return countInfo.copy(i11);
    }

    public final int component1() {
        return this.count;
    }

    public final CountInfo copy(int i11) {
        return new CountInfo(i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CountInfo) && this.count == ((CountInfo) obj).count;
    }

    public final int getCount() {
        return this.count;
    }

    public int hashCode() {
        return this.count;
    }

    public final void setCount(int i11) {
        this.count = i11;
    }

    public String toString() {
        return "CountInfo(count=" + this.count + ")";
    }
}
