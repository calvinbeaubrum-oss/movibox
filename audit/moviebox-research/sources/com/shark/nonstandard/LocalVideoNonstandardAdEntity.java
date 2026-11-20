package com.shark.nonstandard;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LocalVideoNonstandardAdEntity implements Parcelable {
    public static final a CREATOR = new a(null);
    private String adImageUrl;
    private Integer autoCloseTime;
    private String deeplink;
    private Integer firstShowTime;
    private String h5Url;
    private Integer intervalTime;
    private Boolean isCloseable;
    private Boolean isInstation;
    private Boolean isOpen;
    private String key;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<LocalVideoNonstandardAdEntity> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalVideoNonstandardAdEntity createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new LocalVideoNonstandardAdEntity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalVideoNonstandardAdEntity[] newArray(int i11) {
            return new LocalVideoNonstandardAdEntity[i11];
        }
    }

    public LocalVideoNonstandardAdEntity() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalVideoNonstandardAdEntity(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
        this.key = parcel.readString();
        this.adImageUrl = parcel.readString();
        this.h5Url = parcel.readString();
        this.deeplink = parcel.readString();
        Class cls = Integer.TYPE;
        Object value = parcel.readValue(cls.getClassLoader());
        this.autoCloseTime = value instanceof Integer ? (Integer) value : null;
        Class cls2 = Boolean.TYPE;
        Object value2 = parcel.readValue(cls2.getClassLoader());
        this.isCloseable = value2 instanceof Boolean ? (Boolean) value2 : null;
        Object value3 = parcel.readValue(cls2.getClassLoader());
        this.isOpen = value3 instanceof Boolean ? (Boolean) value3 : null;
        Object value4 = parcel.readValue(cls.getClassLoader());
        this.firstShowTime = value4 instanceof Integer ? (Integer) value4 : null;
        Object value5 = parcel.readValue(cls.getClassLoader());
        this.intervalTime = value5 instanceof Integer ? (Integer) value5 : null;
        Object value6 = parcel.readValue(cls2.getClassLoader());
        this.isInstation = value6 instanceof Boolean ? (Boolean) value6 : null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getAdImageUrl() {
        return this.adImageUrl;
    }

    public final Integer getAutoCloseTime() {
        return this.autoCloseTime;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final Integer getFirstShowTime() {
        return this.firstShowTime;
    }

    public final String getH5Url() {
        return this.h5Url;
    }

    public final Integer getIntervalTime() {
        return this.intervalTime;
    }

    public final String getKey() {
        return this.key;
    }

    public final Boolean isCloseable() {
        return this.isCloseable;
    }

    public final Boolean isInstation() {
        return this.isInstation;
    }

    public final Boolean isOpen() {
        return this.isOpen;
    }

    public final void setAdImageUrl(String str) {
        this.adImageUrl = str;
    }

    public final void setAutoCloseTime(Integer num) {
        this.autoCloseTime = num;
    }

    public final void setCloseable(Boolean bool) {
        this.isCloseable = bool;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final void setFirstShowTime(Integer num) {
        this.firstShowTime = num;
    }

    public final void setH5Url(String str) {
        this.h5Url = str;
    }

    public final void setInstation(Boolean bool) {
        this.isInstation = bool;
    }

    public final void setIntervalTime(Integer num) {
        this.intervalTime = num;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final void setOpen(Boolean bool) {
        this.isOpen = bool;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.key);
        parcel.writeString(this.adImageUrl);
        parcel.writeString(this.h5Url);
        parcel.writeString(this.deeplink);
        parcel.writeValue(this.autoCloseTime);
        parcel.writeValue(this.isCloseable);
        parcel.writeValue(this.isOpen);
        parcel.writeValue(this.firstShowTime);
        parcel.writeValue(this.intervalTime);
        parcel.writeValue(this.isInstation);
    }
}
