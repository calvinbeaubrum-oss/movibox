package com.transsion.home.bean;

import com.google.gson.annotations.SerializedName;
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
public final class FilterItems implements Serializable {
    public static final int $stable = 8;

    @SerializedName("typeList")
    private final List<Channel> typeList;

    public FilterItems(List<Channel> typeList) {
        Intrinsics.g(typeList, "typeList");
        this.typeList = typeList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilterItems copy$default(FilterItems filterItems, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = filterItems.typeList;
        }
        return filterItems.copy(list);
    }

    public final List<Channel> component1() {
        return this.typeList;
    }

    public final FilterItems copy(List<Channel> typeList) {
        Intrinsics.g(typeList, "typeList");
        return new FilterItems(typeList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FilterItems) && Intrinsics.b(this.typeList, ((FilterItems) obj).typeList);
    }

    public final List<Channel> getTypeList() {
        return this.typeList;
    }

    public int hashCode() {
        return this.typeList.hashCode();
    }

    public String toString() {
        return "FilterItems(typeList=" + this.typeList + ")";
    }
}
