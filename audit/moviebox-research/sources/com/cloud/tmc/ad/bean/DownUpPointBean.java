package com.cloud.tmc.ad.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rc.b;

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
public final class DownUpPointBean extends b {
    private float downX;
    private float downY;
    private int imageH;
    private int imageW;
    private float upX;
    private float upY;

    public DownUpPointBean() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 63, null);
    }

    public DownUpPointBean(float f11, float f12, float f13, float f14, int i11, int i12) {
        this.downX = f11;
        this.downY = f12;
        this.upX = f13;
        this.upY = f14;
        this.imageH = i11;
        this.imageW = i12;
    }

    public /* synthetic */ DownUpPointBean(float f11, float f12, float f13, float f14, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0.0f : f11, (i13 & 2) != 0 ? 0.0f : f12, (i13 & 4) != 0 ? 0.0f : f13, (i13 & 8) == 0 ? f14 : 0.0f, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? 0 : i12);
    }

    public static /* synthetic */ DownUpPointBean copy$default(DownUpPointBean downUpPointBean, float f11, float f12, float f13, float f14, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            f11 = downUpPointBean.downX;
        }
        if ((i13 & 2) != 0) {
            f12 = downUpPointBean.downY;
        }
        float f15 = f12;
        if ((i13 & 4) != 0) {
            f13 = downUpPointBean.upX;
        }
        float f16 = f13;
        if ((i13 & 8) != 0) {
            f14 = downUpPointBean.upY;
        }
        float f17 = f14;
        if ((i13 & 16) != 0) {
            i11 = downUpPointBean.imageH;
        }
        int i14 = i11;
        if ((i13 & 32) != 0) {
            i12 = downUpPointBean.imageW;
        }
        return downUpPointBean.copy(f11, f15, f16, f17, i14, i12);
    }

    public final float component1() {
        return this.downX;
    }

    public final float component2() {
        return this.downY;
    }

    public final float component3() {
        return this.upX;
    }

    public final float component4() {
        return this.upY;
    }

    public final int component5() {
        return this.imageH;
    }

    public final int component6() {
        return this.imageW;
    }

    public final DownUpPointBean copy(float f11, float f12, float f13, float f14, int i11, int i12) {
        return new DownUpPointBean(f11, f12, f13, f14, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownUpPointBean)) {
            return false;
        }
        DownUpPointBean downUpPointBean = (DownUpPointBean) obj;
        return Float.compare(this.downX, downUpPointBean.downX) == 0 && Float.compare(this.downY, downUpPointBean.downY) == 0 && Float.compare(this.upX, downUpPointBean.upX) == 0 && Float.compare(this.upY, downUpPointBean.upY) == 0 && this.imageH == downUpPointBean.imageH && this.imageW == downUpPointBean.imageW;
    }

    public final float getDownX() {
        return this.downX;
    }

    public final float getDownY() {
        return this.downY;
    }

    public final int getImageH() {
        return this.imageH;
    }

    public final int getImageW() {
        return this.imageW;
    }

    public final float getUpX() {
        return this.upX;
    }

    public final float getUpY() {
        return this.upY;
    }

    public int hashCode() {
        return (((((((((Float.floatToIntBits(this.downX) * 31) + Float.floatToIntBits(this.downY)) * 31) + Float.floatToIntBits(this.upX)) * 31) + Float.floatToIntBits(this.upY)) * 31) + this.imageH) * 31) + this.imageW;
    }

    public final void setDownX(float f11) {
        this.downX = f11;
    }

    public final void setDownY(float f11) {
        this.downY = f11;
    }

    public final void setImageH(int i11) {
        this.imageH = i11;
    }

    public final void setImageW(int i11) {
        this.imageW = i11;
    }

    public final void setUpX(float f11) {
        this.upX = f11;
    }

    public final void setUpY(float f11) {
        this.upY = f11;
    }

    public String toString() {
        return "DownUpPointBean(downX=" + this.downX + ", downY=" + this.downY + ", upX=" + this.upX + ", upY=" + this.upY + ", imageH=" + this.imageH + ", imageW=" + this.imageW + ')';
    }
}
