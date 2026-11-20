package com.transsnet.downloader.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class StartlDownloadBean implements Parcelable {
    public static final Parcelable.Creator<StartlDownloadBean> CREATOR = new a();
    private Integer episode;
    private String resourceId;
    private String subjectId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<StartlDownloadBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final StartlDownloadBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new StartlDownloadBean(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final StartlDownloadBean[] newArray(int i11) {
            return new StartlDownloadBean[i11];
        }
    }

    public StartlDownloadBean(String str, String str2, Integer num) {
        this.subjectId = str;
        this.resourceId = str2;
        this.episode = num;
    }

    public /* synthetic */ StartlDownloadBean(String str, String str2, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? 0 : num);
    }

    public static /* synthetic */ StartlDownloadBean copy$default(StartlDownloadBean startlDownloadBean, String str, String str2, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = startlDownloadBean.subjectId;
        }
        if ((i11 & 2) != 0) {
            str2 = startlDownloadBean.resourceId;
        }
        if ((i11 & 4) != 0) {
            num = startlDownloadBean.episode;
        }
        return startlDownloadBean.copy(str, str2, num);
    }

    public final String component1() {
        return this.subjectId;
    }

    public final String component2() {
        return this.resourceId;
    }

    public final Integer component3() {
        return this.episode;
    }

    public final StartlDownloadBean copy(String str, String str2, Integer num) {
        return new StartlDownloadBean(str, str2, num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StartlDownloadBean)) {
            return false;
        }
        StartlDownloadBean startlDownloadBean = (StartlDownloadBean) obj;
        return Intrinsics.b(this.subjectId, startlDownloadBean.subjectId) && Intrinsics.b(this.resourceId, startlDownloadBean.resourceId) && Intrinsics.b(this.episode, startlDownloadBean.episode);
    }

    public final Integer getEpisode() {
        return this.episode;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public int hashCode() {
        String str = this.subjectId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.resourceId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.episode;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final void setEpisode(Integer num) {
        this.episode = num;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public String toString() {
        return "StartlDownloadBean(subjectId=" + this.subjectId + ", resourceId=" + this.resourceId + ", episode=" + this.episode + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        int iIntValue;
        Intrinsics.g(out, "out");
        out.writeString(this.subjectId);
        out.writeString(this.resourceId);
        Integer num = this.episode;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
    }
}
