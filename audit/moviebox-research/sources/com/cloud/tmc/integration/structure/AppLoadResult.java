package com.cloud.tmc.integration.structure;

import android.os.Parcel;
import android.os.Parcelable;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;
import xb.e;

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
public final class AppLoadResult extends b implements Serializable, Parcelable {
    public static final a CREATOR = new a(null);

    @JvmField
    public MiniAppConfigModel appConfigModel;

    @JvmField
    public String appType;

    @JvmField
    public String appVersion;
    private String chunkJsUrl;

    @JvmField
    public MiniAppConfigModel commonResAppConfigModel;
    private String faviconIco;

    @JvmField
    public AppModel frameWorkModel;

    @JvmField
    public MiniAppConfigModel frameworkConfigModel;

    @JvmField
    public HashMap<?, ?> htmlMap;
    private String mainCSSUrl;

    @JvmField
    public String mainHtmlUrl;

    @JvmField
    public String mainJsUrl;
    private String renderJsUrl;
    private String secondHtmlUrl;
    private Future<Boolean> waitLoadFuture;
    private String workerJsUrl;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<AppLoadResult> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppLoadResult createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new AppLoadResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppLoadResult[] newArray(int i11) {
            return new AppLoadResult[i11];
        }
    }

    public AppLoadResult() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppLoadResult(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
        this.mainJsUrl = parcel.readString();
        this.renderJsUrl = parcel.readString();
        this.workerJsUrl = parcel.readString();
        this.chunkJsUrl = parcel.readString();
        this.mainHtmlUrl = parcel.readString();
        this.secondHtmlUrl = parcel.readString();
        this.faviconIco = parcel.readString();
        this.mainCSSUrl = parcel.readString();
        this.appType = parcel.readString();
        this.appVersion = parcel.readString();
        this.htmlMap = parcel.readHashMap(HashMap.class.getClassLoader());
        this.frameWorkModel = (AppModel) parcel.readParcelable(AppModel.class.getClassLoader());
        this.appConfigModel = (MiniAppConfigModel) parcel.readParcelable(MiniAppConfigModel.class.getClassLoader());
        this.frameworkConfigModel = (MiniAppConfigModel) parcel.readParcelable(MiniAppConfigModel.class.getClassLoader());
        this.commonResAppConfigModel = (MiniAppConfigModel) parcel.readParcelable(MiniAppConfigModel.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getChunkJsUrl() {
        return this.chunkJsUrl;
    }

    public final String getFaviconIco() {
        return this.faviconIco;
    }

    public final String getMainCSSUrl() {
        return this.mainCSSUrl;
    }

    public final String getRenderJsUrl() {
        return this.renderJsUrl;
    }

    public final String getSecondHtmlUrl() {
        return this.secondHtmlUrl;
    }

    public final String getVersion() {
        AppModel appModel = this.frameWorkModel;
        String strC = e.c(appModel != null ? appModel.getDeployVersion() : null);
        AppModel appModel2 = this.frameWorkModel;
        String developerVersion = appModel2 != null ? appModel2.getDeveloperVersion() : null;
        if (developerVersion == null) {
            developerVersion = "";
        }
        return e.a(strC, developerVersion);
    }

    public final Future<Boolean> getWaitLoadFuture() {
        return this.waitLoadFuture;
    }

    public final String getWorkerJsUrl() {
        return this.workerJsUrl;
    }

    public final void setChunkJsUrl(String str) {
        this.chunkJsUrl = str;
    }

    public final void setFaviconIco(String str) {
        this.faviconIco = str;
    }

    public final void setMainCSSUrl(String str) {
        this.mainCSSUrl = str;
    }

    public final void setRenderJsUrl(String str) {
        this.renderJsUrl = str;
    }

    public final void setSecondHtmlUrl(String str) {
        this.secondHtmlUrl = str;
    }

    public final void setWaitLoadFuture(Future<Boolean> future) {
        this.waitLoadFuture = future;
    }

    public final void setWorkerJsUrl(String str) {
        this.workerJsUrl = str;
    }

    public String toString() {
        return "AppLoadResult{mainJsUrl='" + this.mainJsUrl + "', mainHtmlUrl='" + this.mainHtmlUrl + "', appType=" + this.appType + ", appVersion='" + this.appVersion + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.mainJsUrl);
        parcel.writeString(this.renderJsUrl);
        parcel.writeString(this.workerJsUrl);
        parcel.writeString(this.chunkJsUrl);
        parcel.writeString(this.mainHtmlUrl);
        parcel.writeString(this.secondHtmlUrl);
        parcel.writeString(this.faviconIco);
        parcel.writeString(this.mainCSSUrl);
        parcel.writeString(this.appType);
        parcel.writeString(this.appVersion);
        parcel.writeMap(this.htmlMap);
        parcel.writeParcelable(this.frameWorkModel, i11);
        parcel.writeParcelable(this.appConfigModel, i11);
        parcel.writeParcelable(this.frameworkConfigModel, i11);
        parcel.writeParcelable(this.commonResAppConfigModel, i11);
    }
}
