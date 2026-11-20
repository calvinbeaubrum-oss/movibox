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
public final class WatchLaterEvent implements Serializable {
    private final String subjectId;
    private final boolean watchLater;

    public WatchLaterEvent(boolean z11, String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        this.watchLater = z11;
        this.subjectId = subjectId;
    }

    public static /* synthetic */ WatchLaterEvent copy$default(WatchLaterEvent watchLaterEvent, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = watchLaterEvent.watchLater;
        }
        if ((i11 & 2) != 0) {
            str = watchLaterEvent.subjectId;
        }
        return watchLaterEvent.copy(z11, str);
    }

    public final boolean component1() {
        return this.watchLater;
    }

    public final String component2() {
        return this.subjectId;
    }

    public final WatchLaterEvent copy(boolean z11, String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        return new WatchLaterEvent(z11, subjectId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchLaterEvent)) {
            return false;
        }
        WatchLaterEvent watchLaterEvent = (WatchLaterEvent) obj;
        return this.watchLater == watchLaterEvent.watchLater && Intrinsics.b(this.subjectId, watchLaterEvent.subjectId);
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final boolean getWatchLater() {
        return this.watchLater;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z11 = this.watchLater;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return (r11 * 31) + this.subjectId.hashCode();
    }

    public String toString() {
        return "WatchLaterEvent(watchLater=" + this.watchLater + ", subjectId=" + this.subjectId + ")";
    }
}
