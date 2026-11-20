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
public final class HotSubjectEntity implements Parcelable {
    public static final Parcelable.Creator<HotSubjectEntity> CREATOR = new a();
    private List<HotSearchKeyWord> everyoneSearch;
    private List<HotRankItem> hot;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<HotSubjectEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HotSubjectEntity createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            ArrayList arrayList2 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(HotRankItem.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() != 0) {
                int i13 = parcel.readInt();
                arrayList2 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList2.add(HotSearchKeyWord.CREATOR.createFromParcel(parcel));
                }
            }
            return new HotSubjectEntity(arrayList, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HotSubjectEntity[] newArray(int i11) {
            return new HotSubjectEntity[i11];
        }
    }

    public HotSubjectEntity(List<HotRankItem> list, List<HotSearchKeyWord> list2) {
        this.hot = list;
        this.everyoneSearch = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HotSubjectEntity copy$default(HotSubjectEntity hotSubjectEntity, List list, List list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = hotSubjectEntity.hot;
        }
        if ((i11 & 2) != 0) {
            list2 = hotSubjectEntity.everyoneSearch;
        }
        return hotSubjectEntity.copy(list, list2);
    }

    public final List<HotRankItem> component1() {
        return this.hot;
    }

    public final List<HotSearchKeyWord> component2() {
        return this.everyoneSearch;
    }

    public final HotSubjectEntity copy(List<HotRankItem> list, List<HotSearchKeyWord> list2) {
        return new HotSubjectEntity(list, list2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HotSubjectEntity)) {
            return false;
        }
        HotSubjectEntity hotSubjectEntity = (HotSubjectEntity) obj;
        return Intrinsics.b(this.hot, hotSubjectEntity.hot) && Intrinsics.b(this.everyoneSearch, hotSubjectEntity.everyoneSearch);
    }

    public final List<HotSearchKeyWord> getEveryoneSearch() {
        return this.everyoneSearch;
    }

    public final List<HotRankItem> getHot() {
        return this.hot;
    }

    public int hashCode() {
        List<HotRankItem> list = this.hot;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<HotSearchKeyWord> list2 = this.everyoneSearch;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setEveryoneSearch(List<HotSearchKeyWord> list) {
        this.everyoneSearch = list;
    }

    public final void setHot(List<HotRankItem> list) {
        this.hot = list;
    }

    public String toString() {
        return "HotSubjectEntity(hot=" + this.hot + ", everyoneSearch=" + this.everyoneSearch + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<HotRankItem> list = this.hot;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<HotRankItem> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        List<HotSearchKeyWord> list2 = this.everyoneSearch;
        if (list2 == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list2.size());
        Iterator<HotSearchKeyWord> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i11);
        }
    }
}
