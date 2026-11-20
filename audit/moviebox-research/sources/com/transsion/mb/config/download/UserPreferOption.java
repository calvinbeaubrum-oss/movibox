package com.transsion.mb.config.download;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
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
public final class UserPreferOption implements Parcelable {
    public static final Parcelable.Creator<UserPreferOption> CREATOR = new a();

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f53108id;
    private final String name;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<UserPreferOption> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserPreferOption createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new UserPreferOption(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final UserPreferOption[] newArray(int i11) {
            return new UserPreferOption[i11];
        }
    }

    public UserPreferOption(String str, String str2) {
        this.f53108id = str;
        this.name = str2;
    }

    public static /* synthetic */ UserPreferOption copy$default(UserPreferOption userPreferOption, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = userPreferOption.f53108id;
        }
        if ((i11 & 2) != 0) {
            str2 = userPreferOption.name;
        }
        return userPreferOption.copy(str, str2);
    }

    public final String component1() {
        return this.f53108id;
    }

    public final String component2() {
        return this.name;
    }

    public final UserPreferOption copy(String str, String str2) {
        return new UserPreferOption(str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserPreferOption)) {
            return false;
        }
        UserPreferOption userPreferOption = (UserPreferOption) obj;
        return Intrinsics.b(this.f53108id, userPreferOption.f53108id) && Intrinsics.b(this.name, userPreferOption.name);
    }

    public final String getId() {
        return this.f53108id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.f53108id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "UserPreferOption(id=" + this.f53108id + ", name=" + this.name + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.f53108id);
        out.writeString(this.name);
    }
}
