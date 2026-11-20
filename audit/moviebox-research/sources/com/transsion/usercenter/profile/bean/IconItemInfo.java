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
public final class IconItemInfo implements Serializable {
    private int bgRes;
    private boolean checkLogin;
    private String deepLink;
    private String des;
    private boolean divider;
    private int iconRes;
    private String moduleName;
    private String title;
    private int top;

    public IconItemInfo(String str, String str2, String str3, int i11, int i12, boolean z11, int i13, boolean z12, String str4) {
        this.title = str;
        this.des = str2;
        this.deepLink = str3;
        this.iconRes = i11;
        this.bgRes = i12;
        this.divider = z11;
        this.top = i13;
        this.checkLogin = z12;
        this.moduleName = str4;
    }

    public /* synthetic */ IconItemInfo(String str, String str2, String str3, int i11, int i12, boolean z11, int i13, boolean z12, String str4, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i14 & 8) != 0 ? 0 : i11, (i14 & 16) != 0 ? 0 : i12, (i14 & 32) != 0 ? false : z11, (i14 & 64) != 0 ? 0 : i13, (i14 & 128) != 0 ? false : z12, (i14 & 256) != 0 ? null : str4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.des;
    }

    public final String component3() {
        return this.deepLink;
    }

    public final int component4() {
        return this.iconRes;
    }

    public final int component5() {
        return this.bgRes;
    }

    public final boolean component6() {
        return this.divider;
    }

    public final int component7() {
        return this.top;
    }

    public final boolean component8() {
        return this.checkLogin;
    }

    public final String component9() {
        return this.moduleName;
    }

    public final IconItemInfo copy(String str, String str2, String str3, int i11, int i12, boolean z11, int i13, boolean z12, String str4) {
        return new IconItemInfo(str, str2, str3, i11, i12, z11, i13, z12, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IconItemInfo)) {
            return false;
        }
        IconItemInfo iconItemInfo = (IconItemInfo) obj;
        return Intrinsics.b(this.title, iconItemInfo.title) && Intrinsics.b(this.des, iconItemInfo.des) && Intrinsics.b(this.deepLink, iconItemInfo.deepLink) && this.iconRes == iconItemInfo.iconRes && this.bgRes == iconItemInfo.bgRes && this.divider == iconItemInfo.divider && this.top == iconItemInfo.top && this.checkLogin == iconItemInfo.checkLogin && Intrinsics.b(this.moduleName, iconItemInfo.moduleName);
    }

    public final int getBgRes() {
        return this.bgRes;
    }

    public final boolean getCheckLogin() {
        return this.checkLogin;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final String getDes() {
        return this.des;
    }

    public final boolean getDivider() {
        return this.divider;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTop() {
        return this.top;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.des;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deepLink;
        int iHashCode3 = (((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.iconRes) * 31) + this.bgRes) * 31;
        boolean z11 = this.divider;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (((iHashCode3 + r11) * 31) + this.top) * 31;
        boolean z12 = this.checkLogin;
        int i12 = (i11 + (z12 ? 1 : z12)) * 31;
        String str4 = this.moduleName;
        return i12 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setBgRes(int i11) {
        this.bgRes = i11;
    }

    public final void setCheckLogin(boolean z11) {
        this.checkLogin = z11;
    }

    public final void setDeepLink(String str) {
        this.deepLink = str;
    }

    public final void setDes(String str) {
        this.des = str;
    }

    public final void setDivider(boolean z11) {
        this.divider = z11;
    }

    public final void setIconRes(int i11) {
        this.iconRes = i11;
    }

    public final void setModuleName(String str) {
        this.moduleName = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTop(int i11) {
        this.top = i11;
    }

    public String toString() {
        return "IconItemInfo(title=" + this.title + ", des=" + this.des + ", deepLink=" + this.deepLink + ", iconRes=" + this.iconRes + ", bgRes=" + this.bgRes + ", divider=" + this.divider + ", top=" + this.top + ", checkLogin=" + this.checkLogin + ", moduleName=" + this.moduleName + ")";
    }
}
