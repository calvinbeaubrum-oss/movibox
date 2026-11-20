package com.transsion.mb.config.download;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonArray;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AppStartConfig implements Parcelable {
    public static final a CREATOR = new a(null);
    private JsonArray items;
    private String version;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<AppStartConfig> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppStartConfig createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new AppStartConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppStartConfig[] newArray(int i11) {
            return new AppStartConfig[i11];
        }
    }

    public AppStartConfig() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppStartConfig(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final JsonArray getItems() {
        return this.items;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setItems(JsonArray jsonArray) {
        this.items = jsonArray;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
    }
}
