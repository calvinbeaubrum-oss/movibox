package com.transsnet.flow.event.sync.event;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AddToDownloadEvent implements Serializable {
    private final boolean add;
    private final boolean isSeries;
    private final String resourceId;
    private final String subjectId;

    public AddToDownloadEvent(String str, String str2, boolean z11, boolean z12) {
        this.subjectId = str;
        this.resourceId = str2;
        this.add = z11;
        this.isSeries = z12;
    }

    public /* synthetic */ AddToDownloadEvent(String str, String str2, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? false : z12);
    }

    public static /* synthetic */ AddToDownloadEvent copy$default(AddToDownloadEvent addToDownloadEvent, String str, String str2, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = addToDownloadEvent.subjectId;
        }
        if ((i11 & 2) != 0) {
            str2 = addToDownloadEvent.resourceId;
        }
        if ((i11 & 4) != 0) {
            z11 = addToDownloadEvent.add;
        }
        if ((i11 & 8) != 0) {
            z12 = addToDownloadEvent.isSeries;
        }
        return addToDownloadEvent.copy(str, str2, z11, z12);
    }

    public final String component1() {
        return this.subjectId;
    }

    public final String component2() {
        return this.resourceId;
    }

    public final boolean component3() {
        return this.add;
    }

    public final boolean component4() {
        return this.isSeries;
    }

    public final AddToDownloadEvent copy(String str, String str2, boolean z11, boolean z12) {
        return new AddToDownloadEvent(str, str2, z11, z12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddToDownloadEvent)) {
            return false;
        }
        AddToDownloadEvent addToDownloadEvent = (AddToDownloadEvent) obj;
        return Intrinsics.b(this.subjectId, addToDownloadEvent.subjectId) && Intrinsics.b(this.resourceId, addToDownloadEvent.resourceId) && this.add == addToDownloadEvent.add && this.isSeries == addToDownloadEvent.isSeries;
    }

    public final boolean getAdd() {
        return this.add;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        String str = this.subjectId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.resourceId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z11 = this.add;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode2 + r11) * 31;
        boolean z12 = this.isSeries;
        return i11 + (z12 ? 1 : z12);
    }

    public final boolean isSeries() {
        return this.isSeries;
    }

    public String toString() {
        return "AddToDownloadEvent(subjectId=" + this.subjectId + ", resourceId=" + this.resourceId + ", add=" + this.add + ", isSeries=" + this.isSeries + ")";
    }
}
