package com.transsion.postdetail.comment;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
@Metadata
public final class SocialStatus implements Serializable {
    private boolean showDownload;
    private boolean showLike;
    private boolean showShare;
    private boolean showTint;

    public SocialStatus() {
        this(false, false, false, false, 15, null);
    }

    public SocialStatus(boolean z11, boolean z12, boolean z13, boolean z14) {
        this.showTint = z11;
        this.showLike = z12;
        this.showShare = z13;
        this.showDownload = z14;
    }

    public /* synthetic */ SocialStatus(boolean z11, boolean z12, boolean z13, boolean z14, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? true : z12, (i11 & 4) != 0 ? true : z13, (i11 & 8) != 0 ? true : z14);
    }

    public static /* synthetic */ SocialStatus copy$default(SocialStatus socialStatus, boolean z11, boolean z12, boolean z13, boolean z14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = socialStatus.showTint;
        }
        if ((i11 & 2) != 0) {
            z12 = socialStatus.showLike;
        }
        if ((i11 & 4) != 0) {
            z13 = socialStatus.showShare;
        }
        if ((i11 & 8) != 0) {
            z14 = socialStatus.showDownload;
        }
        return socialStatus.copy(z11, z12, z13, z14);
    }

    public final boolean component1() {
        return this.showTint;
    }

    public final boolean component2() {
        return this.showLike;
    }

    public final boolean component3() {
        return this.showShare;
    }

    public final boolean component4() {
        return this.showDownload;
    }

    public final SocialStatus copy(boolean z11, boolean z12, boolean z13, boolean z14) {
        return new SocialStatus(z11, z12, z13, z14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SocialStatus)) {
            return false;
        }
        SocialStatus socialStatus = (SocialStatus) obj;
        return this.showTint == socialStatus.showTint && this.showLike == socialStatus.showLike && this.showShare == socialStatus.showShare && this.showDownload == socialStatus.showDownload;
    }

    public final boolean getShowDownload() {
        return this.showDownload;
    }

    public final boolean getShowLike() {
        return this.showLike;
    }

    public final boolean getShowShare() {
        return this.showShare;
    }

    public final boolean getShowTint() {
        return this.showTint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        boolean z11 = this.showTint;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        boolean z12 = this.showLike;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i12 = (i11 + r12) * 31;
        boolean z13 = this.showShare;
        ?? r13 = z13;
        if (z13) {
            r13 = 1;
        }
        int i13 = (i12 + r13) * 31;
        boolean z14 = this.showDownload;
        return i13 + (z14 ? 1 : z14);
    }

    public final void setShowDownload(boolean z11) {
        this.showDownload = z11;
    }

    public final void setShowLike(boolean z11) {
        this.showLike = z11;
    }

    public final void setShowShare(boolean z11) {
        this.showShare = z11;
    }

    public final void setShowTint(boolean z11) {
        this.showTint = z11;
    }

    public String toString() {
        return "SocialStatus(showTint=" + this.showTint + ", showLike=" + this.showLike + ", showShare=" + this.showShare + ", showDownload=" + this.showDownload + ")";
    }
}
