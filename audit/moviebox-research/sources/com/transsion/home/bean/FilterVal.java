package com.transsion.home.bean;

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
public final class FilterVal implements Serializable {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f52332id;
    private final String name;

    public FilterVal(String id2, String name) {
        Intrinsics.g(id2, "id");
        Intrinsics.g(name, "name");
        this.f52332id = id2;
        this.name = name;
    }

    public static /* synthetic */ FilterVal copy$default(FilterVal filterVal, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = filterVal.f52332id;
        }
        if ((i11 & 2) != 0) {
            str2 = filterVal.name;
        }
        return filterVal.copy(str, str2);
    }

    public final String component1() {
        return this.f52332id;
    }

    public final String component2() {
        return this.name;
    }

    public final FilterVal copy(String id2, String name) {
        Intrinsics.g(id2, "id");
        Intrinsics.g(name, "name");
        return new FilterVal(id2, name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterVal)) {
            return false;
        }
        FilterVal filterVal = (FilterVal) obj;
        return Intrinsics.b(this.f52332id, filterVal.f52332id) && Intrinsics.b(this.name, filterVal.name);
    }

    public final String getId() {
        return this.f52332id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.f52332id.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "FilterVal(id=" + this.f52332id + ", name=" + this.name + ")";
    }
}
