package com.transsion.usercenter.profile.bean;

import java.io.Serializable;
import kotlin.Metadata;

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
public final class ProfileNewMessage implements Serializable {
    private final int commentCnt;
    private final int interactiveCnt;
    private final int likeCnt;
    private final int systemCnt;

    public ProfileNewMessage(int i11, int i12, int i13, int i14) {
        this.interactiveCnt = i11;
        this.systemCnt = i12;
        this.likeCnt = i13;
        this.commentCnt = i14;
    }

    public static /* synthetic */ ProfileNewMessage copy$default(ProfileNewMessage profileNewMessage, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = profileNewMessage.interactiveCnt;
        }
        if ((i15 & 2) != 0) {
            i12 = profileNewMessage.systemCnt;
        }
        if ((i15 & 4) != 0) {
            i13 = profileNewMessage.likeCnt;
        }
        if ((i15 & 8) != 0) {
            i14 = profileNewMessage.commentCnt;
        }
        return profileNewMessage.copy(i11, i12, i13, i14);
    }

    public final int component1() {
        return this.interactiveCnt;
    }

    public final int component2() {
        return this.systemCnt;
    }

    public final int component3() {
        return this.likeCnt;
    }

    public final int component4() {
        return this.commentCnt;
    }

    public final ProfileNewMessage copy(int i11, int i12, int i13, int i14) {
        return new ProfileNewMessage(i11, i12, i13, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileNewMessage)) {
            return false;
        }
        ProfileNewMessage profileNewMessage = (ProfileNewMessage) obj;
        return this.interactiveCnt == profileNewMessage.interactiveCnt && this.systemCnt == profileNewMessage.systemCnt && this.likeCnt == profileNewMessage.likeCnt && this.commentCnt == profileNewMessage.commentCnt;
    }

    public final int getCommentCnt() {
        return this.commentCnt;
    }

    public final int getInteractiveCnt() {
        return this.interactiveCnt;
    }

    public final int getLikeCnt() {
        return this.likeCnt;
    }

    public final int getSystemCnt() {
        return this.systemCnt;
    }

    public int hashCode() {
        return (((((this.interactiveCnt * 31) + this.systemCnt) * 31) + this.likeCnt) * 31) + this.commentCnt;
    }

    public String toString() {
        return "ProfileNewMessage(interactiveCnt=" + this.interactiveCnt + ", systemCnt=" + this.systemCnt + ", likeCnt=" + this.likeCnt + ", commentCnt=" + this.commentCnt + ")";
    }
}
