package com.transsnet.flow.event.sync.event;

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
public final class PublishEvent implements Serializable {
    private final String groupId;
    private String postId;
    private final int sourceType;

    public PublishEvent(String postId, String str, int i11) {
        Intrinsics.g(postId, "postId");
        this.postId = postId;
        this.groupId = str;
        this.sourceType = i11;
    }

    public static /* synthetic */ PublishEvent copy$default(PublishEvent publishEvent, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = publishEvent.postId;
        }
        if ((i12 & 2) != 0) {
            str2 = publishEvent.groupId;
        }
        if ((i12 & 4) != 0) {
            i11 = publishEvent.sourceType;
        }
        return publishEvent.copy(str, str2, i11);
    }

    public final String component1() {
        return this.postId;
    }

    public final String component2() {
        return this.groupId;
    }

    public final int component3() {
        return this.sourceType;
    }

    public final PublishEvent copy(String postId, String str, int i11) {
        Intrinsics.g(postId, "postId");
        return new PublishEvent(postId, str, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublishEvent)) {
            return false;
        }
        PublishEvent publishEvent = (PublishEvent) obj;
        return Intrinsics.b(this.postId, publishEvent.postId) && Intrinsics.b(this.groupId, publishEvent.groupId) && this.sourceType == publishEvent.sourceType;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final int getSourceType() {
        return this.sourceType;
    }

    public int hashCode() {
        int iHashCode = this.postId.hashCode() * 31;
        String str = this.groupId;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.sourceType;
    }

    public final void setPostId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.postId = str;
    }

    public String toString() {
        return "PublishEvent(postId=" + this.postId + ", groupId=" + this.groupId + ", sourceType=" + this.sourceType + ")";
    }
}
