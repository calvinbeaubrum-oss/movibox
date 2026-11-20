package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.OperateItem;
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
public final class SubOperateData implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<SubOperateData> CREATOR = new a();
    private List<OperateItem> items;
    private String ops;
    private String trendingTitle;
    private String version;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SubOperateData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SubOperateData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(parcel.readParcelable(SubOperateData.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new SubOperateData(arrayList, parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SubOperateData[] newArray(int i11) {
            return new SubOperateData[i11];
        }
    }

    public SubOperateData() {
        this(null, null, null, null, 15, null);
    }

    public SubOperateData(List<OperateItem> list, String str, String str2, String str3) {
        this.items = list;
        this.version = str;
        this.trendingTitle = str2;
        this.ops = str3;
    }

    public /* synthetic */ SubOperateData(List list, String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubOperateData copy$default(SubOperateData subOperateData, List list, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = subOperateData.items;
        }
        if ((i11 & 2) != 0) {
            str = subOperateData.version;
        }
        if ((i11 & 4) != 0) {
            str2 = subOperateData.trendingTitle;
        }
        if ((i11 & 8) != 0) {
            str3 = subOperateData.ops;
        }
        return subOperateData.copy(list, str, str2, str3);
    }

    public final List<OperateItem> component1() {
        return this.items;
    }

    public final String component2() {
        return this.version;
    }

    public final String component3() {
        return this.trendingTitle;
    }

    public final String component4() {
        return this.ops;
    }

    public final SubOperateData copy(List<OperateItem> list, String str, String str2, String str3) {
        return new SubOperateData(list, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubOperateData)) {
            return false;
        }
        SubOperateData subOperateData = (SubOperateData) obj;
        return Intrinsics.b(this.items, subOperateData.items) && Intrinsics.b(this.version, subOperateData.version) && Intrinsics.b(this.trendingTitle, subOperateData.trendingTitle) && Intrinsics.b(this.ops, subOperateData.ops);
    }

    public final List<OperateItem> getItems() {
        return this.items;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getTrendingTitle() {
        return this.trendingTitle;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        List<OperateItem> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.version;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.trendingTitle;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ops;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setItems(List<OperateItem> list) {
        this.items = list;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setTrendingTitle(String str) {
        this.trendingTitle = str;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "SubOperateData(items=" + this.items + ", version=" + this.version + ", trendingTitle=" + this.trendingTitle + ", ops=" + this.ops + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<OperateItem> list = this.items;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<OperateItem> it = list.iterator();
            while (it.hasNext()) {
                out.writeParcelable(it.next(), i11);
            }
        }
        out.writeString(this.version);
        out.writeString(this.trendingTitle);
        out.writeString(this.ops);
    }
}
