package com.transsion.moviedetailapi.bean;

import com.google.gson.annotations.SerializedName;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class StaffType implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final int f53887id;

    @SerializedName("name")
    private final String name;

    public StaffType(int i11, String str) {
        this.f53887id = i11;
        this.name = str;
    }

    public static /* synthetic */ StaffType copy$default(StaffType staffType, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = staffType.f53887id;
        }
        if ((i12 & 2) != 0) {
            str = staffType.name;
        }
        return staffType.copy(i11, str);
    }

    public final int component1() {
        return this.f53887id;
    }

    public final String component2() {
        return this.name;
    }

    public final StaffType copy(int i11, String str) {
        return new StaffType(i11, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StaffType)) {
            return false;
        }
        StaffType staffType = (StaffType) obj;
        return this.f53887id == staffType.f53887id && Intrinsics.b(this.name, staffType.name);
    }

    public final int getId() {
        return this.f53887id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int i11 = this.f53887id * 31;
        String str = this.name;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "StaffType(id=" + this.f53887id + ", name=" + this.name + ")";
    }
}
