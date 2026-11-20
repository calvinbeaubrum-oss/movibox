package com.cloud.tmc.integration.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
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
public final class EntryInfo extends b implements Serializable, Parcelable {
    public static final a CREATOR = new a(null);

    @JvmField
    public String appId;
    private List<String> classificationNames;

    @JvmField
    public String desc;

    @JvmField
    public String developer;
    private String exclusiveLogoUrl;

    @JvmField
    public String iconUrl;
    private boolean isOffline;

    @JvmField
    public String slogan;

    @JvmField
    public String title;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<EntryInfo> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public EntryInfo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new EntryInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public EntryInfo[] newArray(int i11) {
            return new EntryInfo[i11];
        }
    }

    public EntryInfo() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EntryInfo(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
        this.appId = parcel.readString();
        this.title = parcel.readString();
        this.iconUrl = parcel.readString();
        this.desc = parcel.readString();
        this.slogan = parcel.readString();
        this.isOffline = parcel.readByte() != 0;
        this.developer = parcel.readString();
        this.classificationNames = parcel.createStringArrayList();
        this.exclusiveLogoUrl = parcel.readString();
    }

    public EntryInfo(String str, String str2, String str3, String str4, boolean z11, String str5, List<String> list, String str6) {
        this();
        this.appId = str;
        this.title = str2;
        this.iconUrl = str3;
        this.slogan = str4;
        this.isOffline = z11;
        this.developer = str5;
        this.classificationNames = list;
        this.exclusiveLogoUrl = str6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<String> getClassificationNames() {
        return this.classificationNames;
    }

    public final String getExclusiveLogoUrl() {
        return this.exclusiveLogoUrl;
    }

    public final boolean isOffline() {
        return this.isOffline;
    }

    public final void setClassificationNames(List<String> list) {
        this.classificationNames = list;
    }

    public final void setExclusiveLogoUrl(String str) {
        this.exclusiveLogoUrl = str;
    }

    public final void setOffline(boolean z11) {
        this.isOffline = z11;
    }

    public String toString() {
        return "EntryInfo{appId='" + this.appId + "'title='" + this.title + "', iconUrl='" + this.iconUrl + "', slogan='" + this.slogan + "', desc='" + this.desc + "', classificationNames='" + this.classificationNames + "', exclusiveLogoUrl='" + this.exclusiveLogoUrl + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.appId);
        parcel.writeString(this.title);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.desc);
        parcel.writeString(this.slogan);
        parcel.writeByte(this.isOffline ? (byte) 1 : (byte) 0);
        parcel.writeString(this.developer);
        parcel.writeStringList(this.classificationNames);
        parcel.writeString(this.exclusiveLogoUrl);
    }
}
