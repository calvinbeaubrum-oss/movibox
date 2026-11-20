package com.transsion.moviedetailapi.bean;

import java.io.Serializable;
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
public final class SubjectPostCount implements Serializable {
    private String count;

    public SubjectPostCount(String str) {
        this.count = str;
    }

    public static /* synthetic */ SubjectPostCount copy$default(SubjectPostCount subjectPostCount, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subjectPostCount.count;
        }
        return subjectPostCount.copy(str);
    }

    public final String component1() {
        return this.count;
    }

    public final SubjectPostCount copy(String str) {
        return new SubjectPostCount(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SubjectPostCount) && Intrinsics.b(this.count, ((SubjectPostCount) obj).count);
    }

    public final String getCount() {
        return this.count;
    }

    public int hashCode() {
        String str = this.count;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setCount(String str) {
        this.count = str;
    }

    public String toString() {
        return "SubjectPostCount(count=" + this.count + ")";
    }
}
