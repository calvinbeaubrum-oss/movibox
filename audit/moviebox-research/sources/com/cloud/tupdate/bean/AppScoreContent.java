package com.cloud.tupdate.bean;

import java.util.List;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AppScoreContent {
    private final String cancelScoreButton;
    private final List<Float> intervalDays;
    private final String scoreButton;
    private final String scoreContent;
    private final String scoreDeeplink;
    private final String scoreTitle;
    private final Boolean showAfterUpdate;

    public AppScoreContent() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public AppScoreContent(Boolean bool, String str, String str2, String str3, String str4, String str5, List<Float> list) {
        this.showAfterUpdate = bool;
        this.scoreTitle = str;
        this.scoreContent = str2;
        this.scoreButton = str3;
        this.cancelScoreButton = str4;
        this.scoreDeeplink = str5;
        this.intervalDays = list;
    }

    public /* synthetic */ AppScoreContent(Boolean bool, String str, String str2, String str3, String str4, String str5, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppScoreContent copy$default(AppScoreContent appScoreContent, Boolean bool, String str, String str2, String str3, String str4, String str5, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = appScoreContent.showAfterUpdate;
        }
        if ((i11 & 2) != 0) {
            str = appScoreContent.scoreTitle;
        }
        String str6 = str;
        if ((i11 & 4) != 0) {
            str2 = appScoreContent.scoreContent;
        }
        String str7 = str2;
        if ((i11 & 8) != 0) {
            str3 = appScoreContent.scoreButton;
        }
        String str8 = str3;
        if ((i11 & 16) != 0) {
            str4 = appScoreContent.cancelScoreButton;
        }
        String str9 = str4;
        if ((i11 & 32) != 0) {
            str5 = appScoreContent.scoreDeeplink;
        }
        String str10 = str5;
        if ((i11 & 64) != 0) {
            list = appScoreContent.intervalDays;
        }
        return appScoreContent.copy(bool, str6, str7, str8, str9, str10, list);
    }

    public final Boolean component1() {
        return this.showAfterUpdate;
    }

    public final String component2() {
        return this.scoreTitle;
    }

    public final String component3() {
        return this.scoreContent;
    }

    public final String component4() {
        return this.scoreButton;
    }

    public final String component5() {
        return this.cancelScoreButton;
    }

    public final String component6() {
        return this.scoreDeeplink;
    }

    public final List<Float> component7() {
        return this.intervalDays;
    }

    public final AppScoreContent copy(Boolean bool, String str, String str2, String str3, String str4, String str5, List<Float> list) {
        return new AppScoreContent(bool, str, str2, str3, str4, str5, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppScoreContent)) {
            return false;
        }
        AppScoreContent appScoreContent = (AppScoreContent) obj;
        return Intrinsics.b(this.showAfterUpdate, appScoreContent.showAfterUpdate) && Intrinsics.b(this.scoreTitle, appScoreContent.scoreTitle) && Intrinsics.b(this.scoreContent, appScoreContent.scoreContent) && Intrinsics.b(this.scoreButton, appScoreContent.scoreButton) && Intrinsics.b(this.cancelScoreButton, appScoreContent.cancelScoreButton) && Intrinsics.b(this.scoreDeeplink, appScoreContent.scoreDeeplink) && Intrinsics.b(this.intervalDays, appScoreContent.intervalDays);
    }

    public final String getCancelScoreButton() {
        return this.cancelScoreButton;
    }

    public final List<Float> getIntervalDays() {
        return this.intervalDays;
    }

    public final String getScoreButton() {
        return this.scoreButton;
    }

    public final String getScoreContent() {
        return this.scoreContent;
    }

    public final String getScoreDeeplink() {
        return this.scoreDeeplink;
    }

    public final String getScoreTitle() {
        return this.scoreTitle;
    }

    public final Boolean getShowAfterUpdate() {
        return this.showAfterUpdate;
    }

    public int hashCode() {
        Boolean bool = this.showAfterUpdate;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.scoreTitle;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.scoreContent;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.scoreButton;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cancelScoreButton;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.scoreDeeplink;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<Float> list = this.intervalDays;
        return iHashCode6 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "AppScoreContent(showAfterUpdate=" + this.showAfterUpdate + ", scoreTitle=" + ((Object) this.scoreTitle) + ", scoreContent=" + ((Object) this.scoreContent) + ", scoreButton=" + ((Object) this.scoreButton) + ", cancelScoreButton=" + ((Object) this.cancelScoreButton) + ", scoreDeeplink=" + ((Object) this.scoreDeeplink) + ", intervalDays=" + this.intervalDays + ')';
    }
}
