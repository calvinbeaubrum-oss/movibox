package com.cloud.tmc.ad.bean;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AdShowBean implements Serializable {
    private int imageHeight;
    private int imageWidth;
    private boolean isClose;
    private int isEffectiveShow;
    private String showArea;
    private long showDuration;
    private int showReportTimeType;
    private int showTimes;
    private long showTs;

    public AdShowBean() {
        this(0, 0, 0L, 0, 0L, null, 0, 0, false, 511, null);
    }

    public AdShowBean(int i11, int i12, long j11, int i13, long j12, String showArea, int i14, int i15, boolean z11) {
        Intrinsics.g(showArea, "showArea");
        this.imageWidth = i11;
        this.imageHeight = i12;
        this.showTs = j11;
        this.isEffectiveShow = i13;
        this.showDuration = j12;
        this.showArea = showArea;
        this.showReportTimeType = i14;
        this.showTimes = i15;
        this.isClose = z11;
    }

    public /* synthetic */ AdShowBean(int i11, int i12, long j11, int i13, long j12, String str, int i14, int i15, boolean z11, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i11, (i16 & 2) != 0 ? 0 : i12, (i16 & 4) != 0 ? 0L : j11, (i16 & 8) != 0 ? 0 : i13, (i16 & 16) == 0 ? j12 : 0L, (i16 & 32) != 0 ? "" : str, (i16 & 64) != 0 ? 0 : i14, (i16 & 128) != 0 ? 0 : i15, (i16 & 256) == 0 ? z11 : false);
    }

    public final int component1() {
        return this.imageWidth;
    }

    public final int component2() {
        return this.imageHeight;
    }

    public final long component3() {
        return this.showTs;
    }

    public final int component4() {
        return this.isEffectiveShow;
    }

    public final long component5() {
        return this.showDuration;
    }

    public final String component6() {
        return this.showArea;
    }

    public final int component7() {
        return this.showReportTimeType;
    }

    public final int component8() {
        return this.showTimes;
    }

    public final boolean component9() {
        return this.isClose;
    }

    public final AdShowBean copy(int i11, int i12, long j11, int i13, long j12, String showArea, int i14, int i15, boolean z11) {
        Intrinsics.g(showArea, "showArea");
        return new AdShowBean(i11, i12, j11, i13, j12, showArea, i14, i15, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdShowBean)) {
            return false;
        }
        AdShowBean adShowBean = (AdShowBean) obj;
        return this.imageWidth == adShowBean.imageWidth && this.imageHeight == adShowBean.imageHeight && this.showTs == adShowBean.showTs && this.isEffectiveShow == adShowBean.isEffectiveShow && this.showDuration == adShowBean.showDuration && Intrinsics.b(this.showArea, adShowBean.showArea) && this.showReportTimeType == adShowBean.showReportTimeType && this.showTimes == adShowBean.showTimes && this.isClose == adShowBean.isClose;
    }

    public final int getImageHeight() {
        return this.imageHeight;
    }

    public final int getImageWidth() {
        return this.imageWidth;
    }

    public final String getShowArea() {
        return this.showArea;
    }

    public final long getShowDuration() {
        return this.showDuration;
    }

    public final int getShowReportTimeType() {
        return this.showReportTimeType;
    }

    public final int getShowTimes() {
        return this.showTimes;
    }

    public final long getShowTs() {
        return this.showTs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public int hashCode() {
        int iA = ((((((((((((((this.imageWidth * 31) + this.imageHeight) * 31) + p.a(this.showTs)) * 31) + this.isEffectiveShow) * 31) + p.a(this.showDuration)) * 31) + this.showArea.hashCode()) * 31) + this.showReportTimeType) * 31) + this.showTimes) * 31;
        boolean z11 = this.isClose;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iA + r11;
    }

    public final boolean isClose() {
        return this.isClose;
    }

    public final int isEffectiveShow() {
        return this.isEffectiveShow;
    }

    public final void setClose(boolean z11) {
        this.isClose = z11;
    }

    public final void setEffectiveShow(int i11) {
        this.isEffectiveShow = i11;
    }

    public final void setImageHeight(int i11) {
        this.imageHeight = i11;
    }

    public final void setImageWidth(int i11) {
        this.imageWidth = i11;
    }

    public final void setShowArea(String str) {
        Intrinsics.g(str, "<set-?>");
        this.showArea = str;
    }

    public final void setShowDuration(long j11) {
        this.showDuration = j11;
    }

    public final void setShowReportTimeType(int i11) {
        this.showReportTimeType = i11;
    }

    public final void setShowTimes(int i11) {
        this.showTimes = i11;
    }

    public final void setShowTs(long j11) {
        this.showTs = j11;
    }

    public String toString() {
        return "AdShowBean(imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", showTs=" + this.showTs + ", isEffectiveShow=" + this.isEffectiveShow + ", showDuration=" + this.showDuration + ", showArea=" + this.showArea + ", showReportTimeType=" + this.showReportTimeType + ", showTimes=" + this.showTimes + ", isClose=" + this.isClose + ')';
    }
}
