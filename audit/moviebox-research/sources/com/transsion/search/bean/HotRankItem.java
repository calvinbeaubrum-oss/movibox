package com.transsion.search.bean;

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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class HotRankItem implements Parcelable {
    public static final String CATE_GROUP = "Group";
    public static final String CATE_MOVIE = "Movie";
    public static final String CATE_MUSIC = "Music";
    public static final String CATE_TV = "TV";
    private String category;
    private List<GroupInfo> groups;
    private int index;
    private List<HotSubject> items;
    private String name;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<HotRankItem> CREATOR = new b();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Parcelable.Creator<HotRankItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HotRankItem createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            ArrayList arrayList2 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(HotSubject.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() != 0) {
                int i13 = parcel.readInt();
                arrayList2 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList2.add(GroupInfo.CREATOR.createFromParcel(parcel));
                }
            }
            return new HotRankItem(string, string2, arrayList, arrayList2, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HotRankItem[] newArray(int i11) {
            return new HotRankItem[i11];
        }
    }

    public HotRankItem(String category, String name, List<HotSubject> list, List<GroupInfo> list2, int i11) {
        Intrinsics.g(category, "category");
        Intrinsics.g(name, "name");
        this.category = category;
        this.name = name;
        this.items = list;
        this.groups = list2;
        this.index = i11;
    }

    public /* synthetic */ HotRankItem(String str, String str2, List list, List list2, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, list2, (i12 & 16) != 0 ? 0 : i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HotRankItem copy$default(HotRankItem hotRankItem, String str, String str2, List list, List list2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = hotRankItem.category;
        }
        if ((i12 & 2) != 0) {
            str2 = hotRankItem.name;
        }
        String str3 = str2;
        if ((i12 & 4) != 0) {
            list = hotRankItem.items;
        }
        List list3 = list;
        if ((i12 & 8) != 0) {
            list2 = hotRankItem.groups;
        }
        List list4 = list2;
        if ((i12 & 16) != 0) {
            i11 = hotRankItem.index;
        }
        return hotRankItem.copy(str, str3, list3, list4, i11);
    }

    public final String component1() {
        return this.category;
    }

    public final String component2() {
        return this.name;
    }

    public final List<HotSubject> component3() {
        return this.items;
    }

    public final List<GroupInfo> component4() {
        return this.groups;
    }

    public final int component5() {
        return this.index;
    }

    public final HotRankItem copy(String category, String name, List<HotSubject> list, List<GroupInfo> list2, int i11) {
        Intrinsics.g(category, "category");
        Intrinsics.g(name, "name");
        return new HotRankItem(category, name, list, list2, i11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HotRankItem)) {
            return false;
        }
        HotRankItem hotRankItem = (HotRankItem) obj;
        return Intrinsics.b(this.category, hotRankItem.category) && Intrinsics.b(this.name, hotRankItem.name) && Intrinsics.b(this.items, hotRankItem.items) && Intrinsics.b(this.groups, hotRankItem.groups) && this.index == hotRankItem.index;
    }

    public final String getCategory() {
        return this.category;
    }

    public final List<GroupInfo> getGroups() {
        return this.groups;
    }

    public final int getIndex() {
        return this.index;
    }

    public final List<HotSubject> getItems() {
        return this.items;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iHashCode = ((this.category.hashCode() * 31) + this.name.hashCode()) * 31;
        List<HotSubject> list = this.items;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<GroupInfo> list2 = this.groups;
        return ((iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.index;
    }

    public final void setCategory(String str) {
        Intrinsics.g(str, "<set-?>");
        this.category = str;
    }

    public final void setGroups(List<GroupInfo> list) {
        this.groups = list;
    }

    public final void setIndex(int i11) {
        this.index = i11;
    }

    public final void setItems(List<HotSubject> list) {
        this.items = list;
    }

    public final void setName(String str) {
        Intrinsics.g(str, "<set-?>");
        this.name = str;
    }

    public String toString() {
        return "HotRankItem(category=" + this.category + ", name=" + this.name + ", items=" + this.items + ", groups=" + this.groups + ", index=" + this.index + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.category);
        out.writeString(this.name);
        List<HotSubject> list = this.items;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<HotSubject> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        List<GroupInfo> list2 = this.groups;
        if (list2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list2.size());
            Iterator<GroupInfo> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(out, i11);
            }
        }
        out.writeInt(this.index);
    }
}
