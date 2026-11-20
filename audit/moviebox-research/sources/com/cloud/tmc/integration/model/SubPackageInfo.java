package com.cloud.tmc.integration.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SubPackageInfo extends b implements Serializable, Parcelable {
    public static final a CREATOR = new a(null);
    private String name;
    private List<String> pages;
    private String root;
    private String subPackageUrl;
    private String subPackageUrlMD5;
    private String subUnzipFilePath;
    private String subZipPath;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SubPackageInfo> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SubPackageInfo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new SubPackageInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SubPackageInfo[] newArray(int i11) {
            return new SubPackageInfo[i11];
        }
    }

    public SubPackageInfo() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubPackageInfo(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
        this.root = parcel.readString();
        this.name = parcel.readString();
        this.pages = parcel.createStringArrayList();
        this.subPackageUrl = parcel.readString();
        this.subPackageUrlMD5 = parcel.readString();
        this.subZipPath = parcel.readString();
        this.subUnzipFilePath = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getPages() {
        return this.pages;
    }

    public final String getRoot() {
        return this.root;
    }

    public final String getSubPackageUrl() {
        return this.subPackageUrl;
    }

    public final String getSubPackageUrlMD5() {
        return this.subPackageUrlMD5;
    }

    public final String getSubUnzipFilePath() {
        return this.subUnzipFilePath;
    }

    public final String getSubZipPath() {
        return this.subZipPath;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPages(List<String> list) {
        this.pages = list;
    }

    public final void setRoot(String str) {
        this.root = str;
    }

    public final void setSubPackageUrl(String str) {
        this.subPackageUrl = str;
    }

    public final void setSubPackageUrlMD5(String str) {
        this.subPackageUrlMD5 = str;
    }

    public final void setSubUnzipFilePath(String str) {
        this.subUnzipFilePath = str;
    }

    public final void setSubZipPath(String str) {
        this.subZipPath = str;
    }

    public String toString() {
        return "SubPackageInfo(root=" + this.root + ", name=" + this.name + ", pages=" + this.pages + ", subPackageUrl=" + this.subPackageUrl + ", subPackageUrlMD5=" + this.subPackageUrlMD5 + ", subZipPath=" + this.subZipPath + ", subUnzipFilePath=" + this.subUnzipFilePath + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.root);
        parcel.writeString(this.name);
        parcel.writeStringList(this.pages);
        parcel.writeString(this.subPackageUrl);
        parcel.writeString(this.subPackageUrlMD5);
        parcel.writeString(this.subZipPath);
        parcel.writeString(this.subUnzipFilePath);
    }
}
