package com.transsion.lib_web.zip.db;

import android.os.Parcel;
import android.os.Parcelable;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class WebViewCacheConfigData implements Parcelable {
    public static final Parcelable.Creator<WebViewCacheConfigData> CREATOR = new a();
    private final String htmlUrl;
    private final String scene;
    private final int sourceType;
    private final String updateTime;
    private final String zipMd5;
    private final String zipUrl;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<WebViewCacheConfigData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WebViewCacheConfigData createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new WebViewCacheConfigData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final WebViewCacheConfigData[] newArray(int i11) {
            return new WebViewCacheConfigData[i11];
        }
    }

    public WebViewCacheConfigData(String scene, String htmlUrl, String zipUrl, String zipMd5, int i11, String str) {
        Intrinsics.g(scene, "scene");
        Intrinsics.g(htmlUrl, "htmlUrl");
        Intrinsics.g(zipUrl, "zipUrl");
        Intrinsics.g(zipMd5, "zipMd5");
        this.scene = scene;
        this.htmlUrl = htmlUrl;
        this.zipUrl = zipUrl;
        this.zipMd5 = zipMd5;
        this.sourceType = i11;
        this.updateTime = str;
    }

    public static /* synthetic */ WebViewCacheConfigData copy$default(WebViewCacheConfigData webViewCacheConfigData, String str, String str2, String str3, String str4, int i11, String str5, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = webViewCacheConfigData.scene;
        }
        if ((i12 & 2) != 0) {
            str2 = webViewCacheConfigData.htmlUrl;
        }
        String str6 = str2;
        if ((i12 & 4) != 0) {
            str3 = webViewCacheConfigData.zipUrl;
        }
        String str7 = str3;
        if ((i12 & 8) != 0) {
            str4 = webViewCacheConfigData.zipMd5;
        }
        String str8 = str4;
        if ((i12 & 16) != 0) {
            i11 = webViewCacheConfigData.sourceType;
        }
        int i13 = i11;
        if ((i12 & 32) != 0) {
            str5 = webViewCacheConfigData.updateTime;
        }
        return webViewCacheConfigData.copy(str, str6, str7, str8, i13, str5);
    }

    public final String component1() {
        return this.scene;
    }

    public final String component2() {
        return this.htmlUrl;
    }

    public final String component3() {
        return this.zipUrl;
    }

    public final String component4() {
        return this.zipMd5;
    }

    public final int component5() {
        return this.sourceType;
    }

    public final String component6() {
        return this.updateTime;
    }

    public final WebViewCacheConfigData copy(String scene, String htmlUrl, String zipUrl, String zipMd5, int i11, String str) {
        Intrinsics.g(scene, "scene");
        Intrinsics.g(htmlUrl, "htmlUrl");
        Intrinsics.g(zipUrl, "zipUrl");
        Intrinsics.g(zipMd5, "zipMd5");
        return new WebViewCacheConfigData(scene, htmlUrl, zipUrl, zipMd5, i11, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebViewCacheConfigData)) {
            return false;
        }
        WebViewCacheConfigData webViewCacheConfigData = (WebViewCacheConfigData) obj;
        return Intrinsics.b(this.scene, webViewCacheConfigData.scene) && Intrinsics.b(this.htmlUrl, webViewCacheConfigData.htmlUrl) && Intrinsics.b(this.zipUrl, webViewCacheConfigData.zipUrl) && Intrinsics.b(this.zipMd5, webViewCacheConfigData.zipMd5) && this.sourceType == webViewCacheConfigData.sourceType && Intrinsics.b(this.updateTime, webViewCacheConfigData.updateTime);
    }

    public final String getHtmlUrl() {
        return this.htmlUrl;
    }

    public final String getScene() {
        return this.scene;
    }

    public final int getSourceType() {
        return this.sourceType;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getZipMd5() {
        return this.zipMd5;
    }

    public final String getZipUrl() {
        return this.zipUrl;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.scene.hashCode() * 31) + this.htmlUrl.hashCode()) * 31) + this.zipUrl.hashCode()) * 31) + this.zipMd5.hashCode()) * 31) + this.sourceType) * 31;
        String str = this.updateTime;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "WebViewCacheConfigData(scene=" + this.scene + ", htmlUrl=" + this.htmlUrl + ", zipUrl=" + this.zipUrl + ", zipMd5=" + this.zipMd5 + ", sourceType=" + this.sourceType + ", updateTime=" + this.updateTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.scene);
        out.writeString(this.htmlUrl);
        out.writeString(this.zipUrl);
        out.writeString(this.zipMd5);
        out.writeInt(this.sourceType);
        out.writeString(this.updateTime);
    }
}
