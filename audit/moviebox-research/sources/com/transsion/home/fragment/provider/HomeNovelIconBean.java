package com.transsion.home.fragment.provider;

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
public final class HomeNovelIconBean {
    public static final int $stable = 0;
    private final String deeplink;
    private final String icUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public HomeNovelIconBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public HomeNovelIconBean(String str, String str2) {
        this.icUrl = str;
        this.deeplink = str2;
    }

    public /* synthetic */ HomeNovelIconBean(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }

    public static /* synthetic */ HomeNovelIconBean copy$default(HomeNovelIconBean homeNovelIconBean, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = homeNovelIconBean.icUrl;
        }
        if ((i11 & 2) != 0) {
            str2 = homeNovelIconBean.deeplink;
        }
        return homeNovelIconBean.copy(str, str2);
    }

    public final String component1() {
        return this.icUrl;
    }

    public final String component2() {
        return this.deeplink;
    }

    public final HomeNovelIconBean copy(String str, String str2) {
        return new HomeNovelIconBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeNovelIconBean)) {
            return false;
        }
        HomeNovelIconBean homeNovelIconBean = (HomeNovelIconBean) obj;
        return Intrinsics.b(this.icUrl, homeNovelIconBean.icUrl) && Intrinsics.b(this.deeplink, homeNovelIconBean.deeplink);
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getIcUrl() {
        return this.icUrl;
    }

    public int hashCode() {
        String str = this.icUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deeplink;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HomeNovelIconBean(icUrl=" + this.icUrl + ", deeplink=" + this.deeplink + ")";
    }
}
