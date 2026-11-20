package com.transsion.edcation.bean;

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
public final class InterestBean implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f51874id;
    private final String name;

    public InterestBean(String str, String str2) {
        this.f51874id = str;
        this.name = str2;
    }

    public static /* synthetic */ InterestBean copy$default(InterestBean interestBean, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = interestBean.f51874id;
        }
        if ((i11 & 2) != 0) {
            str2 = interestBean.name;
        }
        return interestBean.copy(str, str2);
    }

    public final String component1() {
        return this.f51874id;
    }

    public final String component2() {
        return this.name;
    }

    public final InterestBean copy(String str, String str2) {
        return new InterestBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterestBean)) {
            return false;
        }
        InterestBean interestBean = (InterestBean) obj;
        return Intrinsics.b(this.f51874id, interestBean.f51874id) && Intrinsics.b(this.name, interestBean.name);
    }

    public final String getId() {
        return this.f51874id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.f51874id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InterestBean(id=" + this.f51874id + ", name=" + this.name + ")";
    }
}
