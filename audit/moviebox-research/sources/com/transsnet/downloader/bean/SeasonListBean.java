package com.transsnet.downloader.bean;

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
public final class SeasonListBean implements Serializable {
    private boolean isSelected;
    private int season;

    public SeasonListBean(int i11, boolean z11) {
        this.season = i11;
        this.isSelected = z11;
    }

    public static /* synthetic */ SeasonListBean copy$default(SeasonListBean seasonListBean, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = seasonListBean.season;
        }
        if ((i12 & 2) != 0) {
            z11 = seasonListBean.isSelected;
        }
        return seasonListBean.copy(i11, z11);
    }

    public final int component1() {
        return this.season;
    }

    public final boolean component2() {
        return this.isSelected;
    }

    public final SeasonListBean copy(int i11, boolean z11) {
        return new SeasonListBean(i11, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SeasonListBean)) {
            return false;
        }
        SeasonListBean seasonListBean = (SeasonListBean) obj;
        return this.season == seasonListBean.season && this.isSelected == seasonListBean.isSelected;
    }

    public final int getSeason() {
        return this.season;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int i11 = this.season * 31;
        boolean z11 = this.isSelected;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return i11 + r11;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSeason(int i11) {
        this.season = i11;
    }

    public final void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public String toString() {
        return "SeasonListBean(season=" + this.season + ", isSelected=" + this.isSelected + ")";
    }
}
