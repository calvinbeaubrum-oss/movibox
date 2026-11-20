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
public final class PostListRefreshEvent implements Serializable {
    private Integer tabId;

    public PostListRefreshEvent(Integer num) {
        this.tabId = num;
    }

    public static /* synthetic */ PostListRefreshEvent copy$default(PostListRefreshEvent postListRefreshEvent, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = postListRefreshEvent.tabId;
        }
        return postListRefreshEvent.copy(num);
    }

    public final Integer component1() {
        return this.tabId;
    }

    public final PostListRefreshEvent copy(Integer num) {
        return new PostListRefreshEvent(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PostListRefreshEvent) && Intrinsics.b(this.tabId, ((PostListRefreshEvent) obj).tabId);
    }

    public final Integer getTabId() {
        return this.tabId;
    }

    public int hashCode() {
        Integer num = this.tabId;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public final void setTabId(Integer num) {
        this.tabId = num;
    }

    public String toString() {
        return "PostListRefreshEvent(tabId=" + this.tabId + ")";
    }
}
