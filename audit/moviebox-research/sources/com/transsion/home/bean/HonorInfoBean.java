package com.transsion.home.bean;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class HonorInfoBean {
    public static final int $stable = 0;
    private final HonorBackground background;
    private final String dotColor;
    private final String icon;
    private final String subtitle;
    private final String title;

    public HonorInfoBean() {
        this(null, null, null, null, null, 31, null);
    }

    public HonorInfoBean(String str, String str2, String str3, HonorBackground honorBackground, String str4) {
        this.icon = str;
        this.title = str2;
        this.subtitle = str3;
        this.background = honorBackground;
        this.dotColor = str4;
    }

    public /* synthetic */ HonorInfoBean(String str, String str2, String str3, HonorBackground honorBackground, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : honorBackground, (i11 & 16) != 0 ? null : str4);
    }

    public static /* synthetic */ HonorInfoBean copy$default(HonorInfoBean honorInfoBean, String str, String str2, String str3, HonorBackground honorBackground, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = honorInfoBean.icon;
        }
        if ((i11 & 2) != 0) {
            str2 = honorInfoBean.title;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = honorInfoBean.subtitle;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            honorBackground = honorInfoBean.background;
        }
        HonorBackground honorBackground2 = honorBackground;
        if ((i11 & 16) != 0) {
            str4 = honorInfoBean.dotColor;
        }
        return honorInfoBean.copy(str, str5, str6, honorBackground2, str4);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.subtitle;
    }

    public final HonorBackground component4() {
        return this.background;
    }

    public final String component5() {
        return this.dotColor;
    }

    public final HonorInfoBean copy(String str, String str2, String str3, HonorBackground honorBackground, String str4) {
        return new HonorInfoBean(str, str2, str3, honorBackground, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HonorInfoBean)) {
            return false;
        }
        HonorInfoBean honorInfoBean = (HonorInfoBean) obj;
        return Intrinsics.b(this.icon, honorInfoBean.icon) && Intrinsics.b(this.title, honorInfoBean.title) && Intrinsics.b(this.subtitle, honorInfoBean.subtitle) && Intrinsics.b(this.background, honorInfoBean.background) && Intrinsics.b(this.dotColor, honorInfoBean.dotColor);
    }

    public final HonorBackground getBackground() {
        return this.background;
    }

    public final String getDotColor() {
        return this.dotColor;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.icon;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subtitle;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        HonorBackground honorBackground = this.background;
        int iHashCode4 = (iHashCode3 + (honorBackground == null ? 0 : honorBackground.hashCode())) * 31;
        String str4 = this.dotColor;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "HonorInfoBean(icon=" + this.icon + ", title=" + this.title + ", subtitle=" + this.subtitle + ", background=" + this.background + ", dotColor=" + this.dotColor + ")";
    }
}
