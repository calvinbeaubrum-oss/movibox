package com.transsion.ad.middle.icon;

import androidx.annotation.Keep;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsion.ad.ps.model.RecommendInfo;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class WrapperIconBean implements Serializable {
    public static final a Companion = new a(null);
    public static final int WRAPPER_ICON_ITEM_HI = 2;
    public static final int WRAPPER_ICON_ITEM_PS = 1;
    private TAdNativeInfo nativeInfo;
    private RecommendInfo recommendInfo;
    private int type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WrapperIconBean(int i11, RecommendInfo recommendInfo, TAdNativeInfo tAdNativeInfo) {
        this.type = i11;
        this.recommendInfo = recommendInfo;
        this.nativeInfo = tAdNativeInfo;
    }

    public static /* synthetic */ WrapperIconBean copy$default(WrapperIconBean wrapperIconBean, int i11, RecommendInfo recommendInfo, TAdNativeInfo tAdNativeInfo, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = wrapperIconBean.type;
        }
        if ((i12 & 2) != 0) {
            recommendInfo = wrapperIconBean.recommendInfo;
        }
        if ((i12 & 4) != 0) {
            tAdNativeInfo = wrapperIconBean.nativeInfo;
        }
        return wrapperIconBean.copy(i11, recommendInfo, tAdNativeInfo);
    }

    public final int component1() {
        return this.type;
    }

    public final RecommendInfo component2() {
        return this.recommendInfo;
    }

    public final TAdNativeInfo component3() {
        return this.nativeInfo;
    }

    public final WrapperIconBean copy(int i11, RecommendInfo recommendInfo, TAdNativeInfo tAdNativeInfo) {
        return new WrapperIconBean(i11, recommendInfo, tAdNativeInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WrapperIconBean)) {
            return false;
        }
        WrapperIconBean wrapperIconBean = (WrapperIconBean) obj;
        return this.type == wrapperIconBean.type && Intrinsics.b(this.recommendInfo, wrapperIconBean.recommendInfo) && Intrinsics.b(this.nativeInfo, wrapperIconBean.nativeInfo);
    }

    public final TAdNativeInfo getNativeInfo() {
        return this.nativeInfo;
    }

    public final RecommendInfo getRecommendInfo() {
        return this.recommendInfo;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i11 = this.type * 31;
        RecommendInfo recommendInfo = this.recommendInfo;
        int iHashCode = (i11 + (recommendInfo == null ? 0 : recommendInfo.hashCode())) * 31;
        TAdNativeInfo tAdNativeInfo = this.nativeInfo;
        return iHashCode + (tAdNativeInfo != null ? tAdNativeInfo.hashCode() : 0);
    }

    public final void setNativeInfo(TAdNativeInfo tAdNativeInfo) {
        this.nativeInfo = tAdNativeInfo;
    }

    public final void setRecommendInfo(RecommendInfo recommendInfo) {
        this.recommendInfo = recommendInfo;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "WrapperIconBean(type=" + this.type + ", recommendInfo=" + this.recommendInfo + ", nativeInfo=" + this.nativeInfo + ")";
    }
}
