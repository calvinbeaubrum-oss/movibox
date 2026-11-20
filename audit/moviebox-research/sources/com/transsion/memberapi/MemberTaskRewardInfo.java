package com.transsion.memberapi;

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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class MemberTaskRewardInfo implements Serializable {
    private final String description;
    private final int duration;

    public MemberTaskRewardInfo(String description, int i11) {
        Intrinsics.g(description, "description");
        this.description = description;
        this.duration = i11;
    }

    public static /* synthetic */ MemberTaskRewardInfo copy$default(MemberTaskRewardInfo memberTaskRewardInfo, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = memberTaskRewardInfo.description;
        }
        if ((i12 & 2) != 0) {
            i11 = memberTaskRewardInfo.duration;
        }
        return memberTaskRewardInfo.copy(str, i11);
    }

    public final String component1() {
        return this.description;
    }

    public final int component2() {
        return this.duration;
    }

    public final MemberTaskRewardInfo copy(String description, int i11) {
        Intrinsics.g(description, "description");
        return new MemberTaskRewardInfo(description, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberTaskRewardInfo)) {
            return false;
        }
        MemberTaskRewardInfo memberTaskRewardInfo = (MemberTaskRewardInfo) obj;
        return Intrinsics.b(this.description, memberTaskRewardInfo.description) && this.duration == memberTaskRewardInfo.duration;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getDuration() {
        return this.duration;
    }

    public int hashCode() {
        return (this.description.hashCode() * 31) + this.duration;
    }

    public String toString() {
        return "MemberTaskRewardInfo(description=" + this.description + ", duration=" + this.duration + ")";
    }
}
