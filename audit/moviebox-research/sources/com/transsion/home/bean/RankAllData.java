package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
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
public final class RankAllData implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<RankAllData> CREATOR = new a();
    private List<CategoryType> categoryList;
    private String currentCategoryType;
    private String ops;
    private Pager pager;
    private List<? extends Subject> subjects;
    private String title;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<RankAllData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RankAllData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            ArrayList arrayList2 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList3.add(CategoryType.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList3;
            }
            String string = parcel.readString();
            if (parcel.readInt() != 0) {
                int i13 = parcel.readInt();
                arrayList2 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList2.add(parcel.readSerializable());
                }
            }
            return new RankAllData(arrayList, string, arrayList2, (Pager) parcel.readSerializable(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RankAllData[] newArray(int i11) {
            return new RankAllData[i11];
        }
    }

    public RankAllData() {
        this(null, null, null, null, null, null, 63, null);
    }

    public RankAllData(List<CategoryType> list, String str, List<? extends Subject> list2, Pager pager, String str2, String str3) {
        this.categoryList = list;
        this.currentCategoryType = str;
        this.subjects = list2;
        this.pager = pager;
        this.title = str2;
        this.ops = str3;
    }

    public /* synthetic */ RankAllData(List list, String str, List list2, Pager pager, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : list2, (i11 & 8) != 0 ? null : pager, (i11 & 16) != 0 ? null : str2, (i11 & 32) != 0 ? null : str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RankAllData copy$default(RankAllData rankAllData, List list, String str, List list2, Pager pager, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = rankAllData.categoryList;
        }
        if ((i11 & 2) != 0) {
            str = rankAllData.currentCategoryType;
        }
        String str4 = str;
        if ((i11 & 4) != 0) {
            list2 = rankAllData.subjects;
        }
        List list3 = list2;
        if ((i11 & 8) != 0) {
            pager = rankAllData.pager;
        }
        Pager pager2 = pager;
        if ((i11 & 16) != 0) {
            str2 = rankAllData.title;
        }
        String str5 = str2;
        if ((i11 & 32) != 0) {
            str3 = rankAllData.ops;
        }
        return rankAllData.copy(list, str4, list3, pager2, str5, str3);
    }

    public final List<CategoryType> component1() {
        return this.categoryList;
    }

    public final String component2() {
        return this.currentCategoryType;
    }

    public final List<Subject> component3() {
        return this.subjects;
    }

    public final Pager component4() {
        return this.pager;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.ops;
    }

    public final RankAllData copy(List<CategoryType> list, String str, List<? extends Subject> list2, Pager pager, String str2, String str3) {
        return new RankAllData(list, str, list2, pager, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RankAllData)) {
            return false;
        }
        RankAllData rankAllData = (RankAllData) obj;
        return Intrinsics.b(this.categoryList, rankAllData.categoryList) && Intrinsics.b(this.currentCategoryType, rankAllData.currentCategoryType) && Intrinsics.b(this.subjects, rankAllData.subjects) && Intrinsics.b(this.pager, rankAllData.pager) && Intrinsics.b(this.title, rankAllData.title) && Intrinsics.b(this.ops, rankAllData.ops);
    }

    public final List<CategoryType> getCategoryList() {
        return this.categoryList;
    }

    public final String getCurrentCategoryType() {
        return this.currentCategoryType;
    }

    public final String getOps() {
        return this.ops;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final List<Subject> getSubjects() {
        return this.subjects;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        List<CategoryType> list = this.categoryList;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.currentCategoryType;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<? extends Subject> list2 = this.subjects;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Pager pager = this.pager;
        int iHashCode4 = (iHashCode3 + (pager == null ? 0 : pager.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ops;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setCategoryList(List<CategoryType> list) {
        this.categoryList = list;
    }

    public final void setCurrentCategoryType(String str) {
        this.currentCategoryType = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public final void setSubjects(List<? extends Subject> list) {
        this.subjects = list;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "RankAllData(categoryList=" + this.categoryList + ", currentCategoryType=" + this.currentCategoryType + ", subjects=" + this.subjects + ", pager=" + this.pager + ", title=" + this.title + ", ops=" + this.ops + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<CategoryType> list = this.categoryList;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<CategoryType> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        out.writeString(this.currentCategoryType);
        List<? extends Subject> list2 = this.subjects;
        if (list2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list2.size());
            Iterator<? extends Subject> it2 = list2.iterator();
            while (it2.hasNext()) {
                out.writeSerializable(it2.next());
            }
        }
        out.writeSerializable(this.pager);
        out.writeString(this.title);
        out.writeString(this.ops);
    }
}
