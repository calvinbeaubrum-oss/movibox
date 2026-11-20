package com.transsion.search.bean;

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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class SearchSuggestEntity implements Parcelable {
    public static final Parcelable.Creator<SearchSuggestEntity> CREATOR = new a();
    private List<SuggestEntity> items;
    private String keyword;
    private String ops;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SearchSuggestEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SearchSuggestEntity createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(SuggestEntity.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new SearchSuggestEntity(arrayList, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SearchSuggestEntity[] newArray(int i11) {
            return new SearchSuggestEntity[i11];
        }
    }

    public SearchSuggestEntity(List<SuggestEntity> list, String str, String str2) {
        this.items = list;
        this.keyword = str;
        this.ops = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchSuggestEntity copy$default(SearchSuggestEntity searchSuggestEntity, List list, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = searchSuggestEntity.items;
        }
        if ((i11 & 2) != 0) {
            str = searchSuggestEntity.keyword;
        }
        if ((i11 & 4) != 0) {
            str2 = searchSuggestEntity.ops;
        }
        return searchSuggestEntity.copy(list, str, str2);
    }

    public final List<SuggestEntity> component1() {
        return this.items;
    }

    public final String component2() {
        return this.keyword;
    }

    public final String component3() {
        return this.ops;
    }

    public final SearchSuggestEntity copy(List<SuggestEntity> list, String str, String str2) {
        return new SearchSuggestEntity(list, str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchSuggestEntity)) {
            return false;
        }
        SearchSuggestEntity searchSuggestEntity = (SearchSuggestEntity) obj;
        return Intrinsics.b(this.items, searchSuggestEntity.items) && Intrinsics.b(this.keyword, searchSuggestEntity.keyword) && Intrinsics.b(this.ops, searchSuggestEntity.ops);
    }

    public final List<SuggestEntity> getItems() {
        return this.items;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final String getOps() {
        return this.ops;
    }

    public int hashCode() {
        List<SuggestEntity> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.keyword;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ops;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setItems(List<SuggestEntity> list) {
        this.items = list;
    }

    public final void setKeyword(String str) {
        this.keyword = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public String toString() {
        return "SearchSuggestEntity(items=" + this.items + ", keyword=" + this.keyword + ", ops=" + this.ops + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<SuggestEntity> list = this.items;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<SuggestEntity> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        out.writeString(this.keyword);
        out.writeString(this.ops);
    }
}
