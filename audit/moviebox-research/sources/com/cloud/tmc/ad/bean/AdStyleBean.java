package com.cloud.tmc.ad.bean;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AdStyleBean implements Serializable {
    private final boolean showButton;
    private final boolean showDescript;
    private final boolean showLogo;
    private final boolean showTitle;

    public AdStyleBean(boolean z11, boolean z12, boolean z13, boolean z14) {
        this.showTitle = z11;
        this.showDescript = z12;
        this.showLogo = z13;
        this.showButton = z14;
    }

    public static /* synthetic */ AdStyleBean copy$default(AdStyleBean adStyleBean, boolean z11, boolean z12, boolean z13, boolean z14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = adStyleBean.showTitle;
        }
        if ((i11 & 2) != 0) {
            z12 = adStyleBean.showDescript;
        }
        if ((i11 & 4) != 0) {
            z13 = adStyleBean.showLogo;
        }
        if ((i11 & 8) != 0) {
            z14 = adStyleBean.showButton;
        }
        return adStyleBean.copy(z11, z12, z13, z14);
    }

    public final boolean component1() {
        return this.showTitle;
    }

    public final boolean component2() {
        return this.showDescript;
    }

    public final boolean component3() {
        return this.showLogo;
    }

    public final boolean component4() {
        return this.showButton;
    }

    public final AdStyleBean copy(boolean z11, boolean z12, boolean z13, boolean z14) {
        return new AdStyleBean(z11, z12, z13, z14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdStyleBean)) {
            return false;
        }
        AdStyleBean adStyleBean = (AdStyleBean) obj;
        return this.showTitle == adStyleBean.showTitle && this.showDescript == adStyleBean.showDescript && this.showLogo == adStyleBean.showLogo && this.showButton == adStyleBean.showButton;
    }

    public final boolean getShowButton() {
        return this.showButton;
    }

    public final boolean getShowDescript() {
        return this.showDescript;
    }

    public final boolean getShowLogo() {
        return this.showLogo;
    }

    public final boolean getShowTitle() {
        return this.showTitle;
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
        boolean z11 = this.showTitle;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        boolean z12 = this.showDescript;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i12 = (i11 + r12) * 31;
        boolean z13 = this.showLogo;
        ?? r13 = z13;
        if (z13) {
            r13 = 1;
        }
        int i13 = (i12 + r13) * 31;
        boolean z14 = this.showButton;
        return i13 + (z14 ? 1 : z14);
    }

    public String toString() {
        return "AdStyleBean(showTitle=" + this.showTitle + ", showDescript=" + this.showDescript + ", showLogo=" + this.showLogo + ", showButton=" + this.showButton + ')';
    }
}
