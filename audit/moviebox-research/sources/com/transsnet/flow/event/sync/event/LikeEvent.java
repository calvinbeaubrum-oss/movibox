package com.transsnet.flow.event.sync.event;

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
public final class LikeEvent implements Serializable {
    private final boolean like;
    private final String subjectId;

    public LikeEvent(boolean z11, String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        this.like = z11;
        this.subjectId = subjectId;
    }

    public static /* synthetic */ LikeEvent copy$default(LikeEvent likeEvent, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = likeEvent.like;
        }
        if ((i11 & 2) != 0) {
            str = likeEvent.subjectId;
        }
        return likeEvent.copy(z11, str);
    }

    public final boolean component1() {
        return this.like;
    }

    public final String component2() {
        return this.subjectId;
    }

    public final LikeEvent copy(boolean z11, String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        return new LikeEvent(z11, subjectId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikeEvent)) {
            return false;
        }
        LikeEvent likeEvent = (LikeEvent) obj;
        return this.like == likeEvent.like && Intrinsics.b(this.subjectId, likeEvent.subjectId);
    }

    public final boolean getLike() {
        return this.like;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z11 = this.like;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return (r11 * 31) + this.subjectId.hashCode();
    }

    public String toString() {
        return "LikeEvent(like=" + this.like + ", subjectId=" + this.subjectId + ")";
    }
}
