package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Pager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public final class TrendingRespData implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<TrendingRespData> CREATOR = new a();
    private List<TrendingRespItem> items;
    private Pager pager;
    private Integer perRow;
    private List<OperateItem> transferData;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<TrendingRespData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TrendingRespData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(TrendingRespItem.CREATOR.createFromParcel(parcel));
                }
            }
            Pager pager = (Pager) parcel.readSerializable();
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i13 = parcel.readInt();
                arrayList2 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList2.add(parcel.readParcelable(TrendingRespData.class.getClassLoader()));
                }
            }
            return new TrendingRespData(arrayList, pager, arrayList2, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TrendingRespData[] newArray(int i11) {
            return new TrendingRespData[i11];
        }
    }

    public TrendingRespData() {
        this(null, null, null, null, 15, null);
    }

    public TrendingRespData(List<TrendingRespItem> list, Pager pager, List<OperateItem> list2, Integer num) {
        this.items = list;
        this.pager = pager;
        this.transferData = list2;
        this.perRow = num;
    }

    public /* synthetic */ TrendingRespData(List list, Pager pager, List list2, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : pager, (i11 & 4) != 0 ? null : list2, (i11 & 8) != 0 ? 1 : num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrendingRespData copy$default(TrendingRespData trendingRespData, List list, Pager pager, List list2, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = trendingRespData.items;
        }
        if ((i11 & 2) != 0) {
            pager = trendingRespData.pager;
        }
        if ((i11 & 4) != 0) {
            list2 = trendingRespData.transferData;
        }
        if ((i11 & 8) != 0) {
            num = trendingRespData.perRow;
        }
        return trendingRespData.copy(list, pager, list2, num);
    }

    public final List<TrendingRespItem> component1() {
        return this.items;
    }

    public final Pager component2() {
        return this.pager;
    }

    public final List<OperateItem> component3() {
        return this.transferData;
    }

    public final Integer component4() {
        return this.perRow;
    }

    public final TrendingRespData copy(List<TrendingRespItem> list, Pager pager, List<OperateItem> list2, Integer num) {
        return new TrendingRespData(list, pager, list2, num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrendingRespData)) {
            return false;
        }
        TrendingRespData trendingRespData = (TrendingRespData) obj;
        return Intrinsics.b(this.items, trendingRespData.items) && Intrinsics.b(this.pager, trendingRespData.pager) && Intrinsics.b(this.transferData, trendingRespData.transferData) && Intrinsics.b(this.perRow, trendingRespData.perRow);
    }

    public final List<TrendingRespItem> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final Integer getPerRow() {
        return this.perRow;
    }

    public final List<OperateItem> getTransferData() {
        return this.transferData;
    }

    public int hashCode() {
        List<TrendingRespItem> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Pager pager = this.pager;
        int iHashCode2 = (iHashCode + (pager == null ? 0 : pager.hashCode())) * 31;
        List<OperateItem> list2 = this.transferData;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num = this.perRow;
        return iHashCode3 + (num != null ? num.hashCode() : 0);
    }

    public final void setItems(List<TrendingRespItem> list) {
        this.items = list;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public final void setPerRow(Integer num) {
        this.perRow = num;
    }

    public final void setTransferData(List<OperateItem> list) {
        this.transferData = list;
    }

    public String toString() {
        return "TrendingRespData(items=" + this.items + ", pager=" + this.pager + ", transferData=" + this.transferData + ", perRow=" + this.perRow + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<TrendingRespItem> list = this.items;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<TrendingRespItem> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        out.writeSerializable(this.pager);
        List<OperateItem> list2 = this.transferData;
        if (list2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list2.size());
            Iterator<OperateItem> it2 = list2.iterator();
            while (it2.hasNext()) {
                out.writeParcelable(it2.next(), i11);
            }
        }
        Integer num = this.perRow;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
    }
}
