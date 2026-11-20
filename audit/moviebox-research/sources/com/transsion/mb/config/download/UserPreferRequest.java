package com.transsion.mb.config.download;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
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
public final class UserPreferRequest implements Parcelable {
    public static final Parcelable.Creator<UserPreferRequest> CREATOR = new a();
    private final List<String> ids;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<UserPreferRequest> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserPreferRequest createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new UserPreferRequest(parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final UserPreferRequest[] newArray(int i11) {
            return new UserPreferRequest[i11];
        }
    }

    public UserPreferRequest(List<String> ids) {
        Intrinsics.g(ids, "ids");
        this.ids = ids;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserPreferRequest copy$default(UserPreferRequest userPreferRequest, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = userPreferRequest.ids;
        }
        return userPreferRequest.copy(list);
    }

    public final List<String> component1() {
        return this.ids;
    }

    public final UserPreferRequest copy(List<String> ids) {
        Intrinsics.g(ids, "ids");
        return new UserPreferRequest(ids);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserPreferRequest) && Intrinsics.b(this.ids, ((UserPreferRequest) obj).ids);
    }

    public final List<String> getIds() {
        return this.ids;
    }

    public int hashCode() {
        return this.ids.hashCode();
    }

    public String toString() {
        return "UserPreferRequest(ids=" + this.ids + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeStringList(this.ids);
    }
}
