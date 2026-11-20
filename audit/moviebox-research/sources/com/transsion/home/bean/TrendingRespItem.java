package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Subject;
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
@Keep
@Metadata
public final class TrendingRespItem implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<TrendingRespItem> CREATOR = new a();
    private OperateItem playlist;
    private Subject subject;
    private Integer type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<TrendingRespItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TrendingRespItem createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new TrendingRespItem(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), (Subject) parcel.readSerializable(), (OperateItem) parcel.readParcelable(TrendingRespItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TrendingRespItem[] newArray(int i11) {
            return new TrendingRespItem[i11];
        }
    }

    public TrendingRespItem(Integer num, Subject subject, OperateItem operateItem) {
        this.type = num;
        this.subject = subject;
        this.playlist = operateItem;
    }

    public static /* synthetic */ TrendingRespItem copy$default(TrendingRespItem trendingRespItem, Integer num, Subject subject, OperateItem operateItem, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = trendingRespItem.type;
        }
        if ((i11 & 2) != 0) {
            subject = trendingRespItem.subject;
        }
        if ((i11 & 4) != 0) {
            operateItem = trendingRespItem.playlist;
        }
        return trendingRespItem.copy(num, subject, operateItem);
    }

    public final Integer component1() {
        return this.type;
    }

    public final Subject component2() {
        return this.subject;
    }

    public final OperateItem component3() {
        return this.playlist;
    }

    public final TrendingRespItem copy(Integer num, Subject subject, OperateItem operateItem) {
        return new TrendingRespItem(num, subject, operateItem);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrendingRespItem)) {
            return false;
        }
        TrendingRespItem trendingRespItem = (TrendingRespItem) obj;
        return Intrinsics.b(this.type, trendingRespItem.type) && Intrinsics.b(this.subject, trendingRespItem.subject) && Intrinsics.b(this.playlist, trendingRespItem.playlist);
    }

    public final OperateItem getPlaylist() {
        return this.playlist;
    }

    public final Subject getSubject() {
        return this.subject;
    }

    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Integer num = this.type;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Subject subject = this.subject;
        int iHashCode2 = (iHashCode + (subject == null ? 0 : subject.hashCode())) * 31;
        OperateItem operateItem = this.playlist;
        return iHashCode2 + (operateItem != null ? operateItem.hashCode() : 0);
    }

    public final void setPlaylist(OperateItem operateItem) {
        this.playlist = operateItem;
    }

    public final void setSubject(Subject subject) {
        this.subject = subject;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public String toString() {
        return "TrendingRespItem(type=" + this.type + ", subject=" + this.subject + ", playlist=" + this.playlist + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        int iIntValue;
        Intrinsics.g(out, "out");
        Integer num = this.type;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
        out.writeSerializable(this.subject);
        out.writeParcelable(this.playlist, i11);
    }
}
