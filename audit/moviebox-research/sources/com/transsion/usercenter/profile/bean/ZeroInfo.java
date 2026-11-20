package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class ZeroInfo implements Serializable {
    private ButtonInfo button;
    private String iconUrl;
    private boolean showButton;
    private String status;
    private String subtitle;
    private String title;

    public ZeroInfo(String str, String str2, String str3, String str4, boolean z11, ButtonInfo buttonInfo) {
        this.title = str;
        this.subtitle = str2;
        this.status = str3;
        this.iconUrl = str4;
        this.showButton = z11;
        this.button = buttonInfo;
    }

    public /* synthetic */ ZeroInfo(String str, String str2, String str3, String str4, boolean z11, ButtonInfo buttonInfo, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? false : z11, (i11 & 32) != 0 ? null : buttonInfo);
    }

    public static /* synthetic */ ZeroInfo copy$default(ZeroInfo zeroInfo, String str, String str2, String str3, String str4, boolean z11, ButtonInfo buttonInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = zeroInfo.title;
        }
        if ((i11 & 2) != 0) {
            str2 = zeroInfo.subtitle;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = zeroInfo.status;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            str4 = zeroInfo.iconUrl;
        }
        String str7 = str4;
        if ((i11 & 16) != 0) {
            z11 = zeroInfo.showButton;
        }
        boolean z12 = z11;
        if ((i11 & 32) != 0) {
            buttonInfo = zeroInfo.button;
        }
        return zeroInfo.copy(str, str5, str6, str7, z12, buttonInfo);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subtitle;
    }

    public final String component3() {
        return this.status;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final boolean component5() {
        return this.showButton;
    }

    public final ButtonInfo component6() {
        return this.button;
    }

    public final ZeroInfo copy(String str, String str2, String str3, String str4, boolean z11, ButtonInfo buttonInfo) {
        return new ZeroInfo(str, str2, str3, str4, z11, buttonInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZeroInfo)) {
            return false;
        }
        ZeroInfo zeroInfo = (ZeroInfo) obj;
        return Intrinsics.b(this.title, zeroInfo.title) && Intrinsics.b(this.subtitle, zeroInfo.subtitle) && Intrinsics.b(this.status, zeroInfo.status) && Intrinsics.b(this.iconUrl, zeroInfo.iconUrl) && this.showButton == zeroInfo.showButton && Intrinsics.b(this.button, zeroInfo.button);
    }

    public final ButtonInfo getButton() {
        return this.button;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final boolean getShowButton() {
        return this.showButton;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subtitle;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.status;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.iconUrl;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        boolean z11 = this.showButton;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode4 + r11) * 31;
        ButtonInfo buttonInfo = this.button;
        return i11 + (buttonInfo != null ? buttonInfo.hashCode() : 0);
    }

    public final void setButton(ButtonInfo buttonInfo) {
        this.button = buttonInfo;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final void setShowButton(boolean z11) {
        this.showButton = z11;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final void setSubtitle(String str) {
        this.subtitle = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "ZeroInfo(title=" + this.title + ", subtitle=" + this.subtitle + ", status=" + this.status + ", iconUrl=" + this.iconUrl + ", showButton=" + this.showButton + ", button=" + this.button + ")";
    }
}
