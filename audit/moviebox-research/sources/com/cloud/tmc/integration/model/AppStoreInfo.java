package com.cloud.tmc.integration.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
public final class AppStoreInfo extends b implements Serializable, Parcelable {
    public static final a CREATOR = new a(null);
    private String appId;
    private String category;
    private String desc;
    private String exclusiveLogo;
    private String logo;
    private String name;
    private long saveTime;
    private int sourceType;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<AppStoreInfo> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppStoreInfo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new AppStoreInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppStoreInfo[] newArray(int i11) {
            return new AppStoreInfo[i11];
        }
    }

    public AppStoreInfo() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppStoreInfo(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
        this.appId = parcel.readString();
        this.name = parcel.readString();
        this.logo = parcel.readString();
        this.desc = parcel.readString();
        this.category = parcel.readString();
        this.exclusiveLogo = parcel.readString();
        this.sourceType = parcel.readInt();
    }

    public AppStoreInfo(String str, String str2, String str3, String str4, String str5, String str6, int i11) {
        this();
        this.appId = str;
        this.name = str2;
        this.logo = str3;
        this.desc = str4;
        this.category = str5;
        this.exclusiveLogo = str6;
        this.saveTime = System.currentTimeMillis();
        this.sourceType = i11;
    }

    public /* synthetic */ AppStoreInfo(String str, String str2, String str3, String str4, String str5, String str6, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i12 & 32) != 0 ? null : str6, (i12 & 64) != 0 ? 0 : i11);
    }

    public AppStoreInfo(String str, String str2, String str3, String str4, List<String> list, String str5, int i11) {
        this();
        this.appId = str;
        this.name = str2;
        this.logo = str3;
        this.desc = str4;
        List<String> list2 = list;
        this.category = (list2 == null || list2.isEmpty()) ? "" : list.get(0);
        this.exclusiveLogo = str5;
        this.saveTime = System.currentTimeMillis();
        this.sourceType = i11;
    }

    public /* synthetic */ AppStoreInfo(String str, String str2, String str3, String str4, List list, String str5, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (List<String>) list, (i12 & 32) != 0 ? null : str5, (i12 & 64) != 0 ? 0 : i11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.b(AppStoreInfo.class, obj.getClass())) {
            return false;
        }
        AppStoreInfo appStoreInfo = (AppStoreInfo) obj;
        return Intrinsics.b(this.appId, appStoreInfo.appId) && Intrinsics.b(this.name, appStoreInfo.name) && Intrinsics.b(this.logo, appStoreInfo.logo);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getExclusiveLogo() {
        return this.exclusiveLogo;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSaveTime() {
        return this.saveTime;
    }

    public final int getSourceType() {
        return this.sourceType;
    }

    public int hashCode() {
        return Objects.hash(this.appId, this.name, this.logo);
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setExclusiveLogo(String str) {
        this.exclusiveLogo = str;
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setSourceType(int i11) {
        this.sourceType = i11;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.appId);
        parcel.writeString(this.name);
        parcel.writeString(this.logo);
        parcel.writeString(this.desc);
        parcel.writeString(this.category);
        parcel.writeString(this.exclusiveLogo);
        parcel.writeInt(this.sourceType);
    }
}
