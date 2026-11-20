package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
public final class MainOperateData implements Parcelable {
    public static final Parcelable.Creator<MainOperateData> CREATOR = new a();
    private Integer groupPos;
    private List<OperateItem> items;
    private String ops;
    private transient String sourceFrom;
    private String version;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MainOperateData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MainOperateData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(OperateItem.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new MainOperateData(arrayList, parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MainOperateData[] newArray(int i11) {
            return new MainOperateData[i11];
        }
    }

    public MainOperateData() {
        this(null, null, null, null, null, 31, null);
    }

    public MainOperateData(List<OperateItem> list, String str, String str2, Integer num, String sourceFrom) {
        Intrinsics.g(sourceFrom, "sourceFrom");
        this.items = list;
        this.version = str;
        this.ops = str2;
        this.groupPos = num;
        this.sourceFrom = sourceFrom;
    }

    public /* synthetic */ MainOperateData(List list, String str, String str2, Integer num, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2, (i11 & 8) == 0 ? num : null, (i11 & 16) != 0 ? "" : str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MainOperateData copy$default(MainOperateData mainOperateData, List list, String str, String str2, Integer num, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = mainOperateData.items;
        }
        if ((i11 & 2) != 0) {
            str = mainOperateData.version;
        }
        String str4 = str;
        if ((i11 & 4) != 0) {
            str2 = mainOperateData.ops;
        }
        String str5 = str2;
        if ((i11 & 8) != 0) {
            num = mainOperateData.groupPos;
        }
        Integer num2 = num;
        if ((i11 & 16) != 0) {
            str3 = mainOperateData.sourceFrom;
        }
        return mainOperateData.copy(list, str4, str5, num2, str3);
    }

    public final List<OperateItem> component1() {
        return this.items;
    }

    public final String component2() {
        return this.version;
    }

    public final String component3() {
        return this.ops;
    }

    public final Integer component4() {
        return this.groupPos;
    }

    public final String component5() {
        return this.sourceFrom;
    }

    public final MainOperateData copy(List<OperateItem> list, String str, String str2, Integer num, String sourceFrom) {
        Intrinsics.g(sourceFrom, "sourceFrom");
        return new MainOperateData(list, str, str2, num, sourceFrom);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MainOperateData)) {
            return false;
        }
        MainOperateData mainOperateData = (MainOperateData) obj;
        return Intrinsics.b(this.items, mainOperateData.items) && Intrinsics.b(this.version, mainOperateData.version) && Intrinsics.b(this.ops, mainOperateData.ops) && Intrinsics.b(this.groupPos, mainOperateData.groupPos) && Intrinsics.b(this.sourceFrom, mainOperateData.sourceFrom);
    }

    public final Integer getGroupPos() {
        return this.groupPos;
    }

    public final List<OperateItem> getItems() {
        return this.items;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        List<OperateItem> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.version;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ops;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.groupPos;
        return ((iHashCode3 + (num != null ? num.hashCode() : 0)) * 31) + this.sourceFrom.hashCode();
    }

    public final void setGroupPos(Integer num) {
        this.groupPos = num;
    }

    public final void setItems(List<OperateItem> list) {
        this.items = list;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setSourceFrom(String str) {
        Intrinsics.g(str, "<set-?>");
        this.sourceFrom = str;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "MainOperateData(items=" + this.items + ", version=" + this.version + ", ops=" + this.ops + ", groupPos=" + this.groupPos + ", sourceFrom=" + this.sourceFrom + ")";
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
                it.next().writeToParcel(out, i11);
            }
        }
        out.writeString(this.version);
        out.writeString(this.ops);
        Integer num = this.groupPos;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.sourceFrom);
    }
}
