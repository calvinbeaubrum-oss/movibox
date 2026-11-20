package com.transsion.usercenter.profile.bean;

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
public final class MeItemInfo implements Serializable {
    private Object data;
    private int type;

    public MeItemInfo(int i11, Object obj) {
        this.type = i11;
        this.data = obj;
    }

    public static /* synthetic */ MeItemInfo copy$default(MeItemInfo meItemInfo, int i11, Object obj, int i12, Object obj2) {
        if ((i12 & 1) != 0) {
            i11 = meItemInfo.type;
        }
        if ((i12 & 2) != 0) {
            obj = meItemInfo.data;
        }
        return meItemInfo.copy(i11, obj);
    }

    public final int component1() {
        return this.type;
    }

    public final Object component2() {
        return this.data;
    }

    public final MeItemInfo copy(int i11, Object obj) {
        return new MeItemInfo(i11, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MeItemInfo)) {
            return false;
        }
        MeItemInfo meItemInfo = (MeItemInfo) obj;
        return this.type == meItemInfo.type && Intrinsics.b(this.data, meItemInfo.data);
    }

    public final Object getData() {
        return this.data;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i11 = this.type * 31;
        Object obj = this.data;
        return i11 + (obj == null ? 0 : obj.hashCode());
    }

    public final void setData(Object obj) {
        this.data = obj;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "MeItemInfo(type=" + this.type + ", data=" + this.data + ")";
    }
}
