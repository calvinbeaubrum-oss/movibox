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
public final class AdClickBean implements Serializable {
    private String showArea;
    private long showDuration;
    private int showTimes;

    public AdClickBean() {
        this(0, 0L, null, 7, null);
    }

    public AdClickBean(int i11, long j11, String showArea) {
        Intrinsics.g(showArea, "showArea");
        this.showTimes = i11;
        this.showDuration = j11;
        this.showArea = showArea;
    }

    public /* synthetic */ AdClickBean(int i11, long j11, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11, (i12 & 2) != 0 ? 0L : j11, (i12 & 4) != 0 ? "" : str);
    }

    public static /* synthetic */ AdClickBean copy$default(AdClickBean adClickBean, int i11, long j11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = adClickBean.showTimes;
        }
        if ((i12 & 2) != 0) {
            j11 = adClickBean.showDuration;
        }
        if ((i12 & 4) != 0) {
            str = adClickBean.showArea;
        }
        return adClickBean.copy(i11, j11, str);
    }

    public final int component1() {
        return this.showTimes;
    }

    public final long component2() {
        return this.showDuration;
    }

    public final String component3() {
        return this.showArea;
    }

    public final AdClickBean copy(int i11, long j11, String showArea) {
        Intrinsics.g(showArea, "showArea");
        return new AdClickBean(i11, j11, showArea);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdClickBean)) {
            return false;
        }
        AdClickBean adClickBean = (AdClickBean) obj;
        return this.showTimes == adClickBean.showTimes && this.showDuration == adClickBean.showDuration && Intrinsics.b(this.showArea, adClickBean.showArea);
    }

    public final String getShowArea() {
        return this.showArea;
    }

    public final long getShowDuration() {
        return this.showDuration;
    }

    public final int getShowTimes() {
        return this.showTimes;
    }

    public int hashCode() {
        return (((this.showTimes * 31) + p.a(this.showDuration)) * 31) + this.showArea.hashCode();
    }

    public final void setShowArea(String str) {
        Intrinsics.g(str, "<set-?>");
        this.showArea = str;
    }

    public final void setShowDuration(long j11) {
        this.showDuration = j11;
    }

    public final void setShowTimes(int i11) {
        this.showTimes = i11;
    }

    public String toString() {
        return "AdClickBean(showTimes=" + this.showTimes + ", showDuration=" + this.showDuration + ", showArea=" + this.showArea + ')';
    }
}
