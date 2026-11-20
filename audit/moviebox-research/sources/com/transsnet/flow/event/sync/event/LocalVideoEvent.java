package com.transsnet.flow.event.sync.event;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
public final class LocalVideoEvent implements Serializable {
    private final long duration;
    private final boolean isSeries;
    private final long readProgress;
    private final boolean refreshItemAll;
    private final String resourceId;

    public LocalVideoEvent(String resourceId, long j11, long j12, boolean z11, boolean z12) {
        Intrinsics.g(resourceId, "resourceId");
        this.resourceId = resourceId;
        this.readProgress = j11;
        this.duration = j12;
        this.isSeries = z11;
        this.refreshItemAll = z12;
    }

    public /* synthetic */ LocalVideoEvent(String str, long j11, long j12, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? -1L : j11, (i11 & 4) == 0 ? j12 : -1L, (i11 & 8) != 0 ? false : z11, (i11 & 16) == 0 ? z12 : false);
    }

    public static /* synthetic */ LocalVideoEvent copy$default(LocalVideoEvent localVideoEvent, String str, long j11, long j12, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = localVideoEvent.resourceId;
        }
        if ((i11 & 2) != 0) {
            j11 = localVideoEvent.readProgress;
        }
        long j13 = j11;
        if ((i11 & 4) != 0) {
            j12 = localVideoEvent.duration;
        }
        long j14 = j12;
        if ((i11 & 8) != 0) {
            z11 = localVideoEvent.isSeries;
        }
        boolean z13 = z11;
        if ((i11 & 16) != 0) {
            z12 = localVideoEvent.refreshItemAll;
        }
        return localVideoEvent.copy(str, j13, j14, z13, z12);
    }

    public final String component1() {
        return this.resourceId;
    }

    public final long component2() {
        return this.readProgress;
    }

    public final long component3() {
        return this.duration;
    }

    public final boolean component4() {
        return this.isSeries;
    }

    public final boolean component5() {
        return this.refreshItemAll;
    }

    public final LocalVideoEvent copy(String resourceId, long j11, long j12, boolean z11, boolean z12) {
        Intrinsics.g(resourceId, "resourceId");
        return new LocalVideoEvent(resourceId, j11, j12, z11, z12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalVideoEvent)) {
            return false;
        }
        LocalVideoEvent localVideoEvent = (LocalVideoEvent) obj;
        return Intrinsics.b(this.resourceId, localVideoEvent.resourceId) && this.readProgress == localVideoEvent.readProgress && this.duration == localVideoEvent.duration && this.isSeries == localVideoEvent.isSeries && this.refreshItemAll == localVideoEvent.refreshItemAll;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getReadProgress() {
        return this.readProgress;
    }

    public final boolean getRefreshItemAll() {
        return this.refreshItemAll;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((this.resourceId.hashCode() * 31) + p.a(this.readProgress)) * 31) + p.a(this.duration)) * 31;
        boolean z11 = this.isSeries;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode + r11) * 31;
        boolean z12 = this.refreshItemAll;
        return i11 + (z12 ? 1 : z12);
    }

    public final boolean isSeries() {
        return this.isSeries;
    }

    public String toString() {
        return "LocalVideoEvent(resourceId=" + this.resourceId + ", readProgress=" + this.readProgress + ", duration=" + this.duration + ", isSeries=" + this.isSeries + ", refreshItemAll=" + this.refreshItemAll + ")";
    }
}
