package com.transsion.search.bean;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class Count implements Serializable {
    private String name;
    private Integer num;
    private Integer subjectType;

    public Count(Integer num, String str, Integer num2) {
        this.subjectType = num;
        this.name = str;
        this.num = num2;
    }

    public static /* synthetic */ Count copy$default(Count count, Integer num, String str, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = count.subjectType;
        }
        if ((i11 & 2) != 0) {
            str = count.name;
        }
        if ((i11 & 4) != 0) {
            num2 = count.num;
        }
        return count.copy(num, str, num2);
    }

    public final Integer component1() {
        return this.subjectType;
    }

    public final String component2() {
        return this.name;
    }

    public final Integer component3() {
        return this.num;
    }

    public final Count copy(Integer num, String str, Integer num2) {
        return new Count(num, str, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Count)) {
            return false;
        }
        Count count = (Count) obj;
        return Intrinsics.b(this.subjectType, count.subjectType) && Intrinsics.b(this.name, count.name) && Intrinsics.b(this.num, count.num);
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getNum() {
        return this.num;
    }

    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public int hashCode() {
        Integer num = this.subjectType;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.num;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setNum(Integer num) {
        this.num = num;
    }

    public final void setSubjectType(Integer num) {
        this.subjectType = num;
    }

    public String toString() {
        return "Count(subjectType=" + this.subjectType + ", name=" + this.name + ", num=" + this.num + ")";
    }
}
