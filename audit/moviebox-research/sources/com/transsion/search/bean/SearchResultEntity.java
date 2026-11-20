package com.transsion.search.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.search.fragment.result.ResultWrapData;
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
public final class SearchResultEntity implements Parcelable {
    public static final Parcelable.Creator<SearchResultEntity> CREATOR = new a();
    private List<ResultWrapData> convertData;
    private final Pager pager;
    private List<SearchList> results;
    private String tabId;
    private List<TabItem> tabs;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SearchResultEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SearchResultEntity createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            Pager pager = (Pager) parcel.readSerializable();
            List list = null;
            String string = parcel.readString();
            ArrayList arrayList2 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(TabItem.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() != 0) {
                int i13 = parcel.readInt();
                arrayList2 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList2.add(ResultWrapData.CREATOR.createFromParcel(parcel));
                }
            }
            return new SearchResultEntity(pager, list, string, arrayList, arrayList2, 2, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SearchResultEntity[] newArray(int i11) {
            return new SearchResultEntity[i11];
        }
    }

    public SearchResultEntity(Pager pager, List<SearchList> list, String str, List<TabItem> list2, List<ResultWrapData> list3) {
        Intrinsics.g(pager, "pager");
        this.pager = pager;
        this.results = list;
        this.tabId = str;
        this.tabs = list2;
        this.convertData = list3;
    }

    public /* synthetic */ SearchResultEntity(Pager pager, List list, String str, List list2, List list3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(pager, (i11 & 2) != 0 ? null : list, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : list2, (i11 & 16) != 0 ? null : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchResultEntity copy$default(SearchResultEntity searchResultEntity, Pager pager, List list, String str, List list2, List list3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            pager = searchResultEntity.pager;
        }
        if ((i11 & 2) != 0) {
            list = searchResultEntity.results;
        }
        List list4 = list;
        if ((i11 & 4) != 0) {
            str = searchResultEntity.tabId;
        }
        String str2 = str;
        if ((i11 & 8) != 0) {
            list2 = searchResultEntity.tabs;
        }
        List list5 = list2;
        if ((i11 & 16) != 0) {
            list3 = searchResultEntity.convertData;
        }
        return searchResultEntity.copy(pager, list4, str2, list5, list3);
    }

    public static /* synthetic */ void getResults$annotations() {
    }

    public final Pager component1() {
        return this.pager;
    }

    public final List<SearchList> component2() {
        return this.results;
    }

    public final String component3() {
        return this.tabId;
    }

    public final List<TabItem> component4() {
        return this.tabs;
    }

    public final List<ResultWrapData> component5() {
        return this.convertData;
    }

    public final SearchResultEntity copy(Pager pager, List<SearchList> list, String str, List<TabItem> list2, List<ResultWrapData> list3) {
        Intrinsics.g(pager, "pager");
        return new SearchResultEntity(pager, list, str, list2, list3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchResultEntity)) {
            return false;
        }
        SearchResultEntity searchResultEntity = (SearchResultEntity) obj;
        return Intrinsics.b(this.pager, searchResultEntity.pager) && Intrinsics.b(this.results, searchResultEntity.results) && Intrinsics.b(this.tabId, searchResultEntity.tabId) && Intrinsics.b(this.tabs, searchResultEntity.tabs) && Intrinsics.b(this.convertData, searchResultEntity.convertData);
    }

    public final List<ResultWrapData> getConvertData() {
        return this.convertData;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final List<SearchList> getResults() {
        return this.results;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final List<TabItem> getTabs() {
        return this.tabs;
    }

    public int hashCode() {
        int iHashCode = this.pager.hashCode() * 31;
        List<SearchList> list = this.results;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.tabId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<TabItem> list2 = this.tabs;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<ResultWrapData> list3 = this.convertData;
        return iHashCode4 + (list3 != null ? list3.hashCode() : 0);
    }

    public final void setConvertData(List<ResultWrapData> list) {
        this.convertData = list;
    }

    public final void setResults(List<SearchList> list) {
        this.results = list;
    }

    public final void setTabId(String str) {
        this.tabId = str;
    }

    public final void setTabs(List<TabItem> list) {
        this.tabs = list;
    }

    public String toString() {
        return "SearchResultEntity(pager=" + this.pager + ", results=" + this.results + ", tabId=" + this.tabId + ", tabs=" + this.tabs + ", convertData=" + this.convertData + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeSerializable(this.pager);
        out.writeString(this.tabId);
        List<TabItem> list = this.tabs;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<TabItem> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        List<ResultWrapData> list2 = this.convertData;
        if (list2 == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list2.size());
        Iterator<ResultWrapData> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i11);
        }
    }
}
