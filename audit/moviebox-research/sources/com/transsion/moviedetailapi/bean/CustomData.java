package com.transsion.moviedetailapi.bean;

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
public final class CustomData implements Parcelable {
    public static final Parcelable.Creator<CustomData> CREATOR = new a();
    private Boolean hiddenTitle;
    private List<BannerData> items;
    private int rowCount;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CustomData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CustomData createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            int i11 = parcel.readInt();
            ArrayList arrayList = null;
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() != 0) {
                int i12 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i12);
                for (int i13 = 0; i13 != i12; i13++) {
                    arrayList2.add(BannerData.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new CustomData(i11, boolValueOf, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CustomData[] newArray(int i11) {
            return new CustomData[i11];
        }
    }

    public CustomData(int i11, Boolean bool, List<BannerData> list) {
        this.rowCount = i11;
        this.hiddenTitle = bool;
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomData copy$default(CustomData customData, int i11, Boolean bool, List list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = customData.rowCount;
        }
        if ((i12 & 2) != 0) {
            bool = customData.hiddenTitle;
        }
        if ((i12 & 4) != 0) {
            list = customData.items;
        }
        return customData.copy(i11, bool, list);
    }

    public final int component1() {
        return this.rowCount;
    }

    public final Boolean component2() {
        return this.hiddenTitle;
    }

    public final List<BannerData> component3() {
        return this.items;
    }

    public final CustomData copy(int i11, Boolean bool, List<BannerData> list) {
        return new CustomData(i11, bool, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomData)) {
            return false;
        }
        CustomData customData = (CustomData) obj;
        return this.rowCount == customData.rowCount && Intrinsics.b(this.hiddenTitle, customData.hiddenTitle) && Intrinsics.b(this.items, customData.items);
    }

    public final Boolean getHiddenTitle() {
        return this.hiddenTitle;
    }

    public final List<BannerData> getItems() {
        return this.items;
    }

    public final int getRowCount() {
        return this.rowCount;
    }

    public int hashCode() {
        int i11 = this.rowCount * 31;
        Boolean bool = this.hiddenTitle;
        int iHashCode = (i11 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<BannerData> list = this.items;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setHiddenTitle(Boolean bool) {
        this.hiddenTitle = bool;
    }

    public final void setItems(List<BannerData> list) {
        this.items = list;
    }

    public final void setRowCount(int i11) {
        this.rowCount = i11;
    }

    public String toString() {
        return "CustomData(rowCount=" + this.rowCount + ", hiddenTitle=" + this.hiddenTitle + ", items=" + this.items + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.rowCount);
        Boolean bool = this.hiddenTitle;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        List<BannerData> list = this.items;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        Iterator<BannerData> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i11);
        }
    }
}
