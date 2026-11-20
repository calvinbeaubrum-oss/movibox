package com.transsion.usercenter.profile.bean;

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
@Metadata
public final class EntranceInfo implements Serializable {
    private final String description;
    private final int jumpType;
    private final String jumpUrl;
    private final String title;

    public EntranceInfo(String str, String str2, int i11, String str3) {
        this.title = str;
        this.description = str2;
        this.jumpType = i11;
        this.jumpUrl = str3;
    }

    public static /* synthetic */ EntranceInfo copy$default(EntranceInfo entranceInfo, String str, String str2, int i11, String str3, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = entranceInfo.title;
        }
        if ((i12 & 2) != 0) {
            str2 = entranceInfo.description;
        }
        if ((i12 & 4) != 0) {
            i11 = entranceInfo.jumpType;
        }
        if ((i12 & 8) != 0) {
            str3 = entranceInfo.jumpUrl;
        }
        return entranceInfo.copy(str, str2, i11, str3);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final int component3() {
        return this.jumpType;
    }

    public final String component4() {
        return this.jumpUrl;
    }

    public final EntranceInfo copy(String str, String str2, int i11, String str3) {
        return new EntranceInfo(str, str2, i11, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntranceInfo)) {
            return false;
        }
        EntranceInfo entranceInfo = (EntranceInfo) obj;
        return Intrinsics.b(this.title, entranceInfo.title) && Intrinsics.b(this.description, entranceInfo.description) && this.jumpType == entranceInfo.jumpType && Intrinsics.b(this.jumpUrl, entranceInfo.jumpUrl);
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.jumpType) * 31;
        String str3 = this.jumpUrl;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "EntranceInfo(title=" + this.title + ", description=" + this.description + ", jumpType=" + this.jumpType + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
