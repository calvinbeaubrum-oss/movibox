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
public final class ExtendModel extends b implements Serializable, Parcelable {
    public static final a CREATOR = new a(null);
    private String exclusiveLogoUrl;
    private String h5Url;
    private List<String> jumpUrlWhitelist;
    private String offlinePackageVersion;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<ExtendModel> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExtendModel createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new ExtendModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExtendModel[] newArray(int i11) {
            return new ExtendModel[i11];
        }
    }

    public ExtendModel() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtendModel(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
        this.h5Url = parcel.readString();
        this.exclusiveLogoUrl = parcel.readString();
        this.offlinePackageVersion = parcel.readString();
        this.jumpUrlWhitelist = parcel.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getExclusiveLogoUrl() {
        return this.exclusiveLogoUrl;
    }

    public final String getH5Url() {
        return this.h5Url;
    }

    public final List<String> getJumpUrlWhitelist() {
        return this.jumpUrlWhitelist;
    }

    public final String getOfflinePackageVersion() {
        return this.offlinePackageVersion;
    }

    public final void setExclusiveLogoUrl(String str) {
        this.exclusiveLogoUrl = str;
    }

    public final void setH5Url(String str) {
        this.h5Url = str;
    }

    public final void setJumpUrlWhitelist(List<String> list) {
        this.jumpUrlWhitelist = list;
    }

    public final void setOfflinePackageVersion(String str) {
        this.offlinePackageVersion = str;
    }

    public String toString() {
        return "ExtendModel(h5Url=" + this.h5Url + ", exclusiveLogoUrl=" + this.exclusiveLogoUrl + ", offlinePackageVersion=" + this.offlinePackageVersion + ", jumpUrlWhitelist=" + this.jumpUrlWhitelist + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.h5Url);
        parcel.writeString(this.exclusiveLogoUrl);
        parcel.writeString(this.offlinePackageVersion);
        parcel.writeStringList(this.jumpUrlWhitelist);
    }
}
