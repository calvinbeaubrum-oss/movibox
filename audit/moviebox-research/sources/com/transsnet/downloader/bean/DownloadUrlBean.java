package com.transsnet.downloader.bean;

import com.transsion.moviedetailapi.DownloadItem;
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
@Metadata
public final class DownloadUrlBean implements Serializable {
    private String downloadUrl;
    private String jsUrl;
    private String method;
    private String name;
    private DownloadItem resource;
    private int totalEpisode;

    public DownloadUrlBean(String method, String downloadUrl, String jsUrl, String name, DownloadItem downloadItem, int i11) {
        Intrinsics.g(method, "method");
        Intrinsics.g(downloadUrl, "downloadUrl");
        Intrinsics.g(jsUrl, "jsUrl");
        Intrinsics.g(name, "name");
        this.method = method;
        this.downloadUrl = downloadUrl;
        this.jsUrl = jsUrl;
        this.name = name;
        this.resource = downloadItem;
        this.totalEpisode = i11;
    }

    public /* synthetic */ DownloadUrlBean(String str, String str2, String str3, String str4, DownloadItem downloadItem, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, downloadItem, (i12 & 32) != 0 ? 1 : i11);
    }

    public static /* synthetic */ DownloadUrlBean copy$default(DownloadUrlBean downloadUrlBean, String str, String str2, String str3, String str4, DownloadItem downloadItem, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = downloadUrlBean.method;
        }
        if ((i12 & 2) != 0) {
            str2 = downloadUrlBean.downloadUrl;
        }
        String str5 = str2;
        if ((i12 & 4) != 0) {
            str3 = downloadUrlBean.jsUrl;
        }
        String str6 = str3;
        if ((i12 & 8) != 0) {
            str4 = downloadUrlBean.name;
        }
        String str7 = str4;
        if ((i12 & 16) != 0) {
            downloadItem = downloadUrlBean.resource;
        }
        DownloadItem downloadItem2 = downloadItem;
        if ((i12 & 32) != 0) {
            i11 = downloadUrlBean.totalEpisode;
        }
        return downloadUrlBean.copy(str, str5, str6, str7, downloadItem2, i11);
    }

    public final String component1() {
        return this.method;
    }

    public final String component2() {
        return this.downloadUrl;
    }

    public final String component3() {
        return this.jsUrl;
    }

    public final String component4() {
        return this.name;
    }

    public final DownloadItem component5() {
        return this.resource;
    }

    public final int component6() {
        return this.totalEpisode;
    }

    public final DownloadUrlBean copy(String method, String downloadUrl, String jsUrl, String name, DownloadItem downloadItem, int i11) {
        Intrinsics.g(method, "method");
        Intrinsics.g(downloadUrl, "downloadUrl");
        Intrinsics.g(jsUrl, "jsUrl");
        Intrinsics.g(name, "name");
        return new DownloadUrlBean(method, downloadUrl, jsUrl, name, downloadItem, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadUrlBean)) {
            return false;
        }
        DownloadUrlBean downloadUrlBean = (DownloadUrlBean) obj;
        return Intrinsics.b(this.method, downloadUrlBean.method) && Intrinsics.b(this.downloadUrl, downloadUrlBean.downloadUrl) && Intrinsics.b(this.jsUrl, downloadUrlBean.jsUrl) && Intrinsics.b(this.name, downloadUrlBean.name) && Intrinsics.b(this.resource, downloadUrlBean.resource) && this.totalEpisode == downloadUrlBean.totalEpisode;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final String getJsUrl() {
        return this.jsUrl;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getName() {
        return this.name;
    }

    public final DownloadItem getResource() {
        return this.resource;
    }

    public final int getTotalEpisode() {
        return this.totalEpisode;
    }

    public int hashCode() {
        int iHashCode = ((((((this.method.hashCode() * 31) + this.downloadUrl.hashCode()) * 31) + this.jsUrl.hashCode()) * 31) + this.name.hashCode()) * 31;
        DownloadItem downloadItem = this.resource;
        return ((iHashCode + (downloadItem == null ? 0 : downloadItem.hashCode())) * 31) + this.totalEpisode;
    }

    public final void setDownloadUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.downloadUrl = str;
    }

    public final void setJsUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.jsUrl = str;
    }

    public final void setMethod(String str) {
        Intrinsics.g(str, "<set-?>");
        this.method = str;
    }

    public final void setName(String str) {
        Intrinsics.g(str, "<set-?>");
        this.name = str;
    }

    public final void setResource(DownloadItem downloadItem) {
        this.resource = downloadItem;
    }

    public final void setTotalEpisode(int i11) {
        this.totalEpisode = i11;
    }

    public String toString() {
        return "DownloadUrlBean(method=" + this.method + ", downloadUrl=" + this.downloadUrl + ", jsUrl=" + this.jsUrl + ", name=" + this.name + ", resource=" + this.resource + ", totalEpisode=" + this.totalEpisode + ")";
    }
}
