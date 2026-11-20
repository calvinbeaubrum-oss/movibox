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
public final class ProfileEntranceInfo implements Serializable {
    private final EntranceInfo entranceInfo;

    public ProfileEntranceInfo(EntranceInfo entranceInfo) {
        this.entranceInfo = entranceInfo;
    }

    public static /* synthetic */ ProfileEntranceInfo copy$default(ProfileEntranceInfo profileEntranceInfo, EntranceInfo entranceInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            entranceInfo = profileEntranceInfo.entranceInfo;
        }
        return profileEntranceInfo.copy(entranceInfo);
    }

    public final EntranceInfo component1() {
        return this.entranceInfo;
    }

    public final ProfileEntranceInfo copy(EntranceInfo entranceInfo) {
        return new ProfileEntranceInfo(entranceInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProfileEntranceInfo) && Intrinsics.b(this.entranceInfo, ((ProfileEntranceInfo) obj).entranceInfo);
    }

    public final EntranceInfo getEntranceInfo() {
        return this.entranceInfo;
    }

    public int hashCode() {
        EntranceInfo entranceInfo = this.entranceInfo;
        if (entranceInfo == null) {
            return 0;
        }
        return entranceInfo.hashCode();
    }

    public String toString() {
        return "ProfileEntranceInfo(entranceInfo=" + this.entranceInfo + ")";
    }
}
