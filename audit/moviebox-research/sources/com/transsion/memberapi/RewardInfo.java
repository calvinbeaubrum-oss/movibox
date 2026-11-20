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
public final class RewardInfo implements Serializable {
    private String description;
    private int duration;
    private String notice;

    public RewardInfo(String description, String notice, int i11) {
        Intrinsics.g(description, "description");
        Intrinsics.g(notice, "notice");
        this.description = description;
        this.notice = notice;
        this.duration = i11;
    }

    public static /* synthetic */ RewardInfo copy$default(RewardInfo rewardInfo, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = rewardInfo.description;
        }
        if ((i12 & 2) != 0) {
            str2 = rewardInfo.notice;
        }
        if ((i12 & 4) != 0) {
            i11 = rewardInfo.duration;
        }
        return rewardInfo.copy(str, str2, i11);
    }

    public final String component1() {
        return this.description;
    }

    public final String component2() {
        return this.notice;
    }

    public final int component3() {
        return this.duration;
    }

    public final RewardInfo copy(String description, String notice, int i11) {
        Intrinsics.g(description, "description");
        Intrinsics.g(notice, "notice");
        return new RewardInfo(description, notice, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardInfo)) {
            return false;
        }
        RewardInfo rewardInfo = (RewardInfo) obj;
        return Intrinsics.b(this.description, rewardInfo.description) && Intrinsics.b(this.notice, rewardInfo.notice) && this.duration == rewardInfo.duration;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getNotice() {
        return this.notice;
    }

    public int hashCode() {
        return (((this.description.hashCode() * 31) + this.notice.hashCode()) * 31) + this.duration;
    }

    public final void setDescription(String str) {
        Intrinsics.g(str, "<set-?>");
        this.description = str;
    }

    public final void setDuration(int i11) {
        this.duration = i11;
    }

    public final void setNotice(String str) {
        Intrinsics.g(str, "<set-?>");
        this.notice = str;
    }

    public String toString() {
        return "RewardInfo(description=" + this.description + ", notice=" + this.notice + ", duration=" + this.duration + ")";
    }
}
