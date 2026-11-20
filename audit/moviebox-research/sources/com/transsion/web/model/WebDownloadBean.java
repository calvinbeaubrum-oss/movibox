package com.transsion.web.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class WebDownloadBean implements Parcelable {
    public static final Parcelable.Creator<WebDownloadBean> CREATOR = new a();
    private String downloadUrl;
    private String jsUrl;
    private String method;
    private String name;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<WebDownloadBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WebDownloadBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new WebDownloadBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final WebDownloadBean[] newArray(int i11) {
            return new WebDownloadBean[i11];
        }
    }

    public WebDownloadBean(String method, String downloadUrl, String jsUrl, String name) {
        Intrinsics.g(method, "method");
        Intrinsics.g(downloadUrl, "downloadUrl");
        Intrinsics.g(jsUrl, "jsUrl");
        Intrinsics.g(name, "name");
        this.method = method;
        this.downloadUrl = downloadUrl;
        this.jsUrl = jsUrl;
        this.name = name;
    }

    public static /* synthetic */ WebDownloadBean copy$default(WebDownloadBean webDownloadBean, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = webDownloadBean.method;
        }
        if ((i11 & 2) != 0) {
            str2 = webDownloadBean.downloadUrl;
        }
        if ((i11 & 4) != 0) {
            str3 = webDownloadBean.jsUrl;
        }
        if ((i11 & 8) != 0) {
            str4 = webDownloadBean.name;
        }
        return webDownloadBean.copy(str, str2, str3, str4);
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

    public final WebDownloadBean copy(String method, String downloadUrl, String jsUrl, String name) {
        Intrinsics.g(method, "method");
        Intrinsics.g(downloadUrl, "downloadUrl");
        Intrinsics.g(jsUrl, "jsUrl");
        Intrinsics.g(name, "name");
        return new WebDownloadBean(method, downloadUrl, jsUrl, name);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebDownloadBean)) {
            return false;
        }
        WebDownloadBean webDownloadBean = (WebDownloadBean) obj;
        return Intrinsics.b(this.method, webDownloadBean.method) && Intrinsics.b(this.downloadUrl, webDownloadBean.downloadUrl) && Intrinsics.b(this.jsUrl, webDownloadBean.jsUrl) && Intrinsics.b(this.name, webDownloadBean.name);
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

    public int hashCode() {
        return (((((this.method.hashCode() * 31) + this.downloadUrl.hashCode()) * 31) + this.jsUrl.hashCode()) * 31) + this.name.hashCode();
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

    public String toString() {
        return "WebDownloadBean(method=" + this.method + ", downloadUrl=" + this.downloadUrl + ", jsUrl=" + this.jsUrl + ", name=" + this.name + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.method);
        out.writeString(this.downloadUrl);
        out.writeString(this.jsUrl);
        out.writeString(this.name);
    }
}
