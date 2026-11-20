package com.cloud.tmc.offline.download.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
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
public final class VerifyServerFileMetadata extends b implements Parcelable {
    public static final a CREATOR = new a(null);
    private final String appId;
    private final List<Metadata> metadata;

    /* JADX INFO: compiled from: source.java */
    @kotlin.Metadata
    public static final class a implements Parcelable.Creator<VerifyServerFileMetadata> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VerifyServerFileMetadata createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new VerifyServerFileMetadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public VerifyServerFileMetadata[] newArray(int i11) {
            return new VerifyServerFileMetadata[i11];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerifyServerFileMetadata(Parcel parcel) {
        this(parcel.readString(), parcel.createTypedArrayList(Metadata.CREATOR));
        Intrinsics.g(parcel, "parcel");
    }

    public VerifyServerFileMetadata(String str, List<Metadata> list) {
        this.appId = str;
        this.metadata = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VerifyServerFileMetadata copy$default(VerifyServerFileMetadata verifyServerFileMetadata, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = verifyServerFileMetadata.appId;
        }
        if ((i11 & 2) != 0) {
            list = verifyServerFileMetadata.metadata;
        }
        return verifyServerFileMetadata.copy(str, list);
    }

    public final String component1() {
        return this.appId;
    }

    public final List<Metadata> component2() {
        return this.metadata;
    }

    public final VerifyServerFileMetadata copy(String str, List<Metadata> list) {
        return new VerifyServerFileMetadata(str, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerifyServerFileMetadata)) {
            return false;
        }
        VerifyServerFileMetadata verifyServerFileMetadata = (VerifyServerFileMetadata) obj;
        return Intrinsics.b(this.appId, verifyServerFileMetadata.appId) && Intrinsics.b(this.metadata, verifyServerFileMetadata.metadata);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final List<Metadata> getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        String str = this.appId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<Metadata> list = this.metadata;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "VerifyServerFileMetadata(appId=" + this.appId + ", metadata=" + this.metadata + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.appId);
        parcel.writeTypedList(this.metadata);
    }
}
