package com.transsion.fission;

import android.os.Parcel;
import android.os.Parcelable;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public class WebViewCacheConfigData implements Parcelable {
    public static final Parcelable.Creator<WebViewCacheConfigData> CREATOR = new a();
    private String htmlUrl;
    private String zipMd5;
    private String zipUrl;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<WebViewCacheConfigData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WebViewCacheConfigData createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new WebViewCacheConfigData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final WebViewCacheConfigData[] newArray(int i11) {
            return new WebViewCacheConfigData[i11];
        }
    }

    public WebViewCacheConfigData() {
        this(null, null, null, 7, null);
    }

    public WebViewCacheConfigData(String str, String str2, String str3) {
        this.htmlUrl = str;
        this.zipUrl = str2;
        this.zipMd5 = str3;
    }

    public /* synthetic */ WebViewCacheConfigData(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public String getZipMd5() {
        return this.zipMd5;
    }

    public String getZipUrl() {
        return this.zipUrl;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public void setZipMd5(String str) {
        this.zipMd5 = str;
    }

    public void setZipUrl(String str) {
        this.zipUrl = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.htmlUrl);
        out.writeString(this.zipUrl);
        out.writeString(this.zipMd5);
    }
}
