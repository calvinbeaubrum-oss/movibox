package com.transsion.upload.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class TstTokenEntity implements Parcelable {
    public static final Parcelable.Creator<TstTokenEntity> CREATOR = new a();
    private final String accessKeyId;
    private final String accessKeySecret;
    private final String bucket;
    private final String endPoint;
    private final Long expireTime;
    private final String regionId;
    private final String securityToken;
    private final String storage;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<TstTokenEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TstTokenEntity createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new TstTokenEntity(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TstTokenEntity[] newArray(int i11) {
            return new TstTokenEntity[i11];
        }
    }

    public TstTokenEntity(String str, String str2, String str3, Long l11, String str4, String str5, String str6, String str7) {
        this.accessKeyId = str;
        this.accessKeySecret = str2;
        this.securityToken = str3;
        this.expireTime = l11;
        this.regionId = str4;
        this.endPoint = str5;
        this.bucket = str6;
        this.storage = str7;
    }

    public final String component1() {
        return this.accessKeyId;
    }

    public final String component2() {
        return this.accessKeySecret;
    }

    public final String component3() {
        return this.securityToken;
    }

    public final Long component4() {
        return this.expireTime;
    }

    public final String component5() {
        return this.regionId;
    }

    public final String component6() {
        return this.endPoint;
    }

    public final String component7() {
        return this.bucket;
    }

    public final String component8() {
        return this.storage;
    }

    public final TstTokenEntity copy(String str, String str2, String str3, Long l11, String str4, String str5, String str6, String str7) {
        return new TstTokenEntity(str, str2, str3, l11, str4, str5, str6, str7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TstTokenEntity)) {
            return false;
        }
        TstTokenEntity tstTokenEntity = (TstTokenEntity) obj;
        return Intrinsics.b(this.accessKeyId, tstTokenEntity.accessKeyId) && Intrinsics.b(this.accessKeySecret, tstTokenEntity.accessKeySecret) && Intrinsics.b(this.securityToken, tstTokenEntity.securityToken) && Intrinsics.b(this.expireTime, tstTokenEntity.expireTime) && Intrinsics.b(this.regionId, tstTokenEntity.regionId) && Intrinsics.b(this.endPoint, tstTokenEntity.endPoint) && Intrinsics.b(this.bucket, tstTokenEntity.bucket) && Intrinsics.b(this.storage, tstTokenEntity.storage);
    }

    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    public final String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getEndPoint() {
        return this.endPoint;
    }

    public final Long getExpireTime() {
        return this.expireTime;
    }

    public final String getRegionId() {
        return this.regionId;
    }

    public final String getSecurityToken() {
        return this.securityToken;
    }

    public final String getStorage() {
        return this.storage;
    }

    public int hashCode() {
        String str = this.accessKeyId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.accessKeySecret;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.securityToken;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l11 = this.expireTime;
        int iHashCode4 = (iHashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str4 = this.regionId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.endPoint;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.bucket;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.storage;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "TstTokenEntity(accessKeyId=" + this.accessKeyId + ", accessKeySecret=" + this.accessKeySecret + ", securityToken=" + this.securityToken + ", expireTime=" + this.expireTime + ", regionId=" + this.regionId + ", endPoint=" + this.endPoint + ", bucket=" + this.bucket + ", storage=" + this.storage + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.accessKeyId);
        out.writeString(this.accessKeySecret);
        out.writeString(this.securityToken);
        Long l11 = this.expireTime;
        if (l11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l11.longValue());
        }
        out.writeString(this.regionId);
        out.writeString(this.endPoint);
        out.writeString(this.bucket);
        out.writeString(this.storage);
    }
}
