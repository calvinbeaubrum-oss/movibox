package com.cloud.tmc.integration.activity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class StartClientBundle implements Parcelable {
    public static final a CREATOR = new a(null);

    @JvmField
    public String appId;
    private String appType;

    @JvmField
    public Bundle sceneParams;

    @JvmField
    public StartAction startAction;

    @JvmField
    public Bundle startParams;

    @JvmField
    public long startToken;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<StartClientBundle> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StartClientBundle createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new StartClientBundle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public StartClientBundle[] newArray(int i11) {
            return new StartClientBundle[i11];
        }
    }

    public StartClientBundle() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StartClientBundle(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
        this.appId = parcel.readString();
        this.appType = parcel.readString();
        this.startToken = parcel.readLong();
        String string = parcel.readString();
        this.startAction = string != null ? StartAction.valueOf(string) : null;
        this.startParams = parcel.readBundle(StartClientBundle.class.getClassLoader());
        this.sceneParams = parcel.readBundle(StartClientBundle.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getAppType() {
        return this.appType;
    }

    public final void setAppType(String str) {
        this.appType = str;
    }

    public String toString() {
        return "StartClientBundle{appId=" + this.appId + ", appType=" + this.appType + ", startToken=" + this.startToken + ", startAction=" + this.startAction + ", startParams=" + this.startParams + ", sceneParams=" + this.sceneParams + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.appId);
        parcel.writeString(this.appType);
        parcel.writeLong(this.startToken);
        StartAction startAction = this.startAction;
        parcel.writeString(startAction != null ? startAction.name() : null);
        parcel.writeBundle(this.startParams);
        parcel.writeBundle(this.sceneParams);
    }
}
