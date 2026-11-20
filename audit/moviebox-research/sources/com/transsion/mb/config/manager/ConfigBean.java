package com.transsion.mb.config.manager;

import android.os.Parcel;
import android.os.Parcelable;
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
public final class ConfigBean implements Parcelable {
    public static final a CREATOR = new a(null);
    private boolean hasUpdate;
    private boolean isFirebase;
    private String key;
    private String ops;
    private String value;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<ConfigBean> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConfigBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new ConfigBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ConfigBean[] newArray(int i11) {
            return new ConfigBean[i11];
        }
    }

    public ConfigBean() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConfigBean(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
        this.key = parcel.readString();
        this.ops = parcel.readString();
        this.value = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getHasUpdate() {
        return this.hasUpdate;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean isFirebase() {
        return this.isFirebase;
    }

    public final void setFirebase(boolean z11) {
        this.isFirebase = z11;
    }

    public final void setHasUpdate(boolean z11) {
        this.hasUpdate = z11;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.key);
        parcel.writeString(this.ops);
        parcel.writeString(this.value);
    }
}
