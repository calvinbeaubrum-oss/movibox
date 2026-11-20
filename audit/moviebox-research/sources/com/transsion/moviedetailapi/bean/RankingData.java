package com.transsion.moviedetailapi.bean;

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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class RankingData implements Parcelable {
    public static final Parcelable.Creator<RankingData> CREATOR = new a();
    private Integer perRow;
    private transient boolean rankingHorizontal;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<RankingData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RankingData createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new RankingData(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RankingData[] newArray(int i11) {
            return new RankingData[i11];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RankingData() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public RankingData(Integer num, boolean z11) {
        this.perRow = num;
        this.rankingHorizontal = z11;
    }

    public /* synthetic */ RankingData(Integer num, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 3 : num, (i11 & 2) != 0 ? false : z11);
    }

    public static /* synthetic */ RankingData copy$default(RankingData rankingData, Integer num, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = rankingData.perRow;
        }
        if ((i11 & 2) != 0) {
            z11 = rankingData.rankingHorizontal;
        }
        return rankingData.copy(num, z11);
    }

    public final Integer component1() {
        return this.perRow;
    }

    public final boolean component2() {
        return this.rankingHorizontal;
    }

    public final RankingData copy(Integer num, boolean z11) {
        return new RankingData(num, z11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RankingData)) {
            return false;
        }
        RankingData rankingData = (RankingData) obj;
        return Intrinsics.b(this.perRow, rankingData.perRow) && this.rankingHorizontal == rankingData.rankingHorizontal;
    }

    public final Integer getPerRow() {
        return this.perRow;
    }

    public final boolean getRankingHorizontal() {
        return this.rankingHorizontal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        Integer num = this.perRow;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        boolean z11 = this.rankingHorizontal;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode + r11;
    }

    public final void setPerRow(Integer num) {
        this.perRow = num;
    }

    public final void setRankingHorizontal(boolean z11) {
        this.rankingHorizontal = z11;
    }

    public String toString() {
        return "RankingData(perRow=" + this.perRow + ", rankingHorizontal=" + this.rankingHorizontal + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        int iIntValue;
        Intrinsics.g(out, "out");
        Integer num = this.perRow;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
        out.writeInt(this.rankingHorizontal ? 1 : 0);
    }
}
