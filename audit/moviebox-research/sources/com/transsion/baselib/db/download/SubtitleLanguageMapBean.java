package com.transsion.baselib.db.download;

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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class SubtitleLanguageMapBean {
    private boolean inSearch;
    private String lan;
    private String lanIOS3;
    private String lanName;

    public SubtitleLanguageMapBean(String lan, String str, String lanName, boolean z11) {
        Intrinsics.g(lan, "lan");
        Intrinsics.g(lanName, "lanName");
        this.lan = lan;
        this.lanIOS3 = str;
        this.lanName = lanName;
        this.inSearch = z11;
    }

    public /* synthetic */ SubtitleLanguageMapBean(String str, String str2, String str3, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? "" : str2, str3, (i11 & 8) != 0 ? false : z11);
    }

    public static /* synthetic */ SubtitleLanguageMapBean copy$default(SubtitleLanguageMapBean subtitleLanguageMapBean, String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subtitleLanguageMapBean.lan;
        }
        if ((i11 & 2) != 0) {
            str2 = subtitleLanguageMapBean.lanIOS3;
        }
        if ((i11 & 4) != 0) {
            str3 = subtitleLanguageMapBean.lanName;
        }
        if ((i11 & 8) != 0) {
            z11 = subtitleLanguageMapBean.inSearch;
        }
        return subtitleLanguageMapBean.copy(str, str2, str3, z11);
    }

    public final String component1() {
        return this.lan;
    }

    public final String component2() {
        return this.lanIOS3;
    }

    public final String component3() {
        return this.lanName;
    }

    public final boolean component4() {
        return this.inSearch;
    }

    public final SubtitleLanguageMapBean copy(String lan, String str, String lanName, boolean z11) {
        Intrinsics.g(lan, "lan");
        Intrinsics.g(lanName, "lanName");
        return new SubtitleLanguageMapBean(lan, str, lanName, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubtitleLanguageMapBean)) {
            return false;
        }
        SubtitleLanguageMapBean subtitleLanguageMapBean = (SubtitleLanguageMapBean) obj;
        return Intrinsics.b(this.lan, subtitleLanguageMapBean.lan) && Intrinsics.b(this.lanIOS3, subtitleLanguageMapBean.lanIOS3) && Intrinsics.b(this.lanName, subtitleLanguageMapBean.lanName) && this.inSearch == subtitleLanguageMapBean.inSearch;
    }

    public final boolean getInSearch() {
        return this.inSearch;
    }

    public final String getLan() {
        return this.lan;
    }

    public final String getLanAbbr() {
        return Intrinsics.b(this.lan, "in_id") ? "in" : this.lan;
    }

    public final String getLanIOS3() {
        return this.lanIOS3;
    }

    public final String getLanName() {
        return this.lanName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = this.lan.hashCode() * 31;
        String str = this.lanIOS3;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.lanName.hashCode()) * 31;
        boolean z11 = this.inSearch;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode2 + r11;
    }

    public final void setInSearch(boolean z11) {
        this.inSearch = z11;
    }

    public final void setLan(String str) {
        Intrinsics.g(str, "<set-?>");
        this.lan = str;
    }

    public final void setLanIOS3(String str) {
        this.lanIOS3 = str;
    }

    public final void setLanName(String str) {
        Intrinsics.g(str, "<set-?>");
        this.lanName = str;
    }

    public String toString() {
        return "SubtitleLanguageMapBean(lan=" + this.lan + ", lanIOS3=" + this.lanIOS3 + ", lanName=" + this.lanName + ", inSearch=" + this.inSearch + ")";
    }
}
