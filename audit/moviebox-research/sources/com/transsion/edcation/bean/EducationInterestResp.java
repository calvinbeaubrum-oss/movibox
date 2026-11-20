package com.transsion.edcation.bean;

import java.io.Serializable;
import java.util.List;
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
public final class EducationInterestResp implements Serializable {
    private final List<InterestBean> options;

    public EducationInterestResp(List<InterestBean> options) {
        Intrinsics.g(options, "options");
        this.options = options;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EducationInterestResp copy$default(EducationInterestResp educationInterestResp, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = educationInterestResp.options;
        }
        return educationInterestResp.copy(list);
    }

    public final List<InterestBean> component1() {
        return this.options;
    }

    public final EducationInterestResp copy(List<InterestBean> options) {
        Intrinsics.g(options, "options");
        return new EducationInterestResp(options);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EducationInterestResp) && Intrinsics.b(this.options, ((EducationInterestResp) obj).options);
    }

    public final List<InterestBean> getOptions() {
        return this.options;
    }

    public int hashCode() {
        return this.options.hashCode();
    }

    public String toString() {
        return "EducationInterestResp(options=" + this.options + ")";
    }
}
