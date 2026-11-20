package com.cloud.tmc.offline.download.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.cloud.tmc.integration.model.AppModel;
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
@kotlin.Metadata
public final class PrePullAppInfo extends b implements Parcelable {
    public static final a CREATOR = new a(null);
    private final String appId;
    private final AppModel appInfo;

    /* JADX INFO: compiled from: source.java */
    @kotlin.Metadata
    public static final class a implements Parcelable.Creator<PrePullAppInfo> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PrePullAppInfo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PrePullAppInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PrePullAppInfo[] newArray(int i11) {
            return new PrePullAppInfo[i11];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PrePullAppInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PrePullAppInfo(Parcel parcel) {
        this(parcel.readString(), (AppModel) parcel.readParcelable(AppModel.class.getClassLoader()));
        Intrinsics.g(parcel, "parcel");
    }

    public PrePullAppInfo(String str, AppModel appModel) {
        this.appId = str;
        this.appInfo = appModel;
    }

    public /* synthetic */ PrePullAppInfo(String str, AppModel appModel, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : appModel);
    }

    public static /* synthetic */ PrePullAppInfo copy$default(PrePullAppInfo prePullAppInfo, String str, AppModel appModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = prePullAppInfo.appId;
        }
        if ((i11 & 2) != 0) {
            appModel = prePullAppInfo.appInfo;
        }
        return prePullAppInfo.copy(str, appModel);
    }

    public final String component1() {
        return this.appId;
    }

    public final AppModel component2() {
        return this.appInfo;
    }

    public final PrePullAppInfo copy(String str, AppModel appModel) {
        return new PrePullAppInfo(str, appModel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrePullAppInfo)) {
            return false;
        }
        PrePullAppInfo prePullAppInfo = (PrePullAppInfo) obj;
        return Intrinsics.b(this.appId, prePullAppInfo.appId) && Intrinsics.b(this.appInfo, prePullAppInfo.appInfo);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final AppModel getAppInfo() {
        return this.appInfo;
    }

    public int hashCode() {
        String str = this.appId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        AppModel appModel = this.appInfo;
        return iHashCode + (appModel != null ? appModel.hashCode() : 0);
    }

    public String toString() {
        return "PrePullAppInfo(appId=" + this.appId + ", appInfo=" + this.appInfo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.appId);
        parcel.writeParcelable(this.appInfo, i11);
    }
}
