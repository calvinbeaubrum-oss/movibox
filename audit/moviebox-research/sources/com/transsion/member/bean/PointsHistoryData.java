package com.transsion.member.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Iterator;
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
@Keep
@Metadata
public final class PointsHistoryData implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PointsHistoryData> CREATOR = new a();
    private final String coinBalance;
    private final List<PointsHistoryItem> list;
    private final Pager page;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PointsHistoryData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PointsHistoryData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(PointsHistoryItem.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new PointsHistoryData(arrayList, (Pager) parcel.readSerializable(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PointsHistoryData[] newArray(int i11) {
            return new PointsHistoryData[i11];
        }
    }

    public PointsHistoryData(List<PointsHistoryItem> list, Pager page, String str) {
        Intrinsics.g(page, "page");
        this.list = list;
        this.page = page;
        this.coinBalance = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PointsHistoryData copy$default(PointsHistoryData pointsHistoryData, List list, Pager pager, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = pointsHistoryData.list;
        }
        if ((i11 & 2) != 0) {
            pager = pointsHistoryData.page;
        }
        if ((i11 & 4) != 0) {
            str = pointsHistoryData.coinBalance;
        }
        return pointsHistoryData.copy(list, pager, str);
    }

    public final List<PointsHistoryItem> component1() {
        return this.list;
    }

    public final Pager component2() {
        return this.page;
    }

    public final String component3() {
        return this.coinBalance;
    }

    public final PointsHistoryData copy(List<PointsHistoryItem> list, Pager page, String str) {
        Intrinsics.g(page, "page");
        return new PointsHistoryData(list, page, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointsHistoryData)) {
            return false;
        }
        PointsHistoryData pointsHistoryData = (PointsHistoryData) obj;
        return Intrinsics.b(this.list, pointsHistoryData.list) && Intrinsics.b(this.page, pointsHistoryData.page) && Intrinsics.b(this.coinBalance, pointsHistoryData.coinBalance);
    }

    public final String getCoinBalance() {
        return this.coinBalance;
    }

    public final List<PointsHistoryItem> getList() {
        return this.list;
    }

    public final Pager getPage() {
        return this.page;
    }

    public int hashCode() {
        List<PointsHistoryItem> list = this.list;
        int iHashCode = (((list == null ? 0 : list.hashCode()) * 31) + this.page.hashCode()) * 31;
        String str = this.coinBalance;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "PointsHistoryData(list=" + this.list + ", page=" + this.page + ", coinBalance=" + this.coinBalance + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<PointsHistoryItem> list = this.list;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<PointsHistoryItem> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        out.writeSerializable(this.page);
        out.writeString(this.coinBalance);
    }
}
