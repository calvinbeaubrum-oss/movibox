package com.transsion.usercenter.setting.labelsfeedback.model;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class FbTvData implements Parcelable {
    public static final Parcelable.Creator<FbTvData> CREATOR = new a();
    private final int episode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f59745id;
    private final int season;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<FbTvData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FbTvData createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new FbTvData(parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final FbTvData[] newArray(int i11) {
            return new FbTvData[i11];
        }
    }

    public FbTvData(String id2, int i11, int i12) {
        Intrinsics.g(id2, "id");
        this.f59745id = id2;
        this.season = i11;
        this.episode = i12;
    }

    public static /* synthetic */ FbTvData copy$default(FbTvData fbTvData, String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = fbTvData.f59745id;
        }
        if ((i13 & 2) != 0) {
            i11 = fbTvData.season;
        }
        if ((i13 & 4) != 0) {
            i12 = fbTvData.episode;
        }
        return fbTvData.copy(str, i11, i12);
    }

    public final String component1() {
        return this.f59745id;
    }

    public final int component2() {
        return this.season;
    }

    public final int component3() {
        return this.episode;
    }

    public final FbTvData copy(String id2, int i11, int i12) {
        Intrinsics.g(id2, "id");
        return new FbTvData(id2, i11, i12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FbTvData)) {
            return false;
        }
        FbTvData fbTvData = (FbTvData) obj;
        return Intrinsics.b(this.f59745id, fbTvData.f59745id) && this.season == fbTvData.season && this.episode == fbTvData.episode;
    }

    public final int getEpisode() {
        return this.episode;
    }

    public final String getId() {
        return this.f59745id;
    }

    public final int getSeason() {
        return this.season;
    }

    public int hashCode() {
        return (((this.f59745id.hashCode() * 31) + this.season) * 31) + this.episode;
    }

    public String toString() {
        return "FbTvData(id=" + this.f59745id + ", season=" + this.season + ", episode=" + this.episode + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.f59745id);
        out.writeInt(this.season);
        out.writeInt(this.episode);
    }
}
