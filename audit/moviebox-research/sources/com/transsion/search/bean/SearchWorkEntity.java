package com.transsion.search.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.transsion.moviedetailapi.bean.Staff;
import java.io.Serializable;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class SearchWorkEntity implements Serializable {

    @SerializedName("accurate")
    private final AccurateSubject accurateSubject;

    @SerializedName("counts")
    private final List<Count> counts;

    @SerializedName("items")
    private final List<SearchSubject> items;

    @SerializedName("pager")
    private final Pager pager;

    @SerializedName("staffs")
    private final List<Staff> staffs;

    @SerializedName("subjectType")
    private final Integer subjectType;

    @SerializedName("verticalRanks")
    private final List<VerticalRank> verticalRanks;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchWorkEntity(List<SearchSubject> items, Pager pager, List<VerticalRank> list, List<Count> counts, Integer num, List<? extends Staff> list2, AccurateSubject accurateSubject) {
        Intrinsics.g(items, "items");
        Intrinsics.g(pager, "pager");
        Intrinsics.g(counts, "counts");
        this.items = items;
        this.pager = pager;
        this.verticalRanks = list;
        this.counts = counts;
        this.subjectType = num;
        this.staffs = list2;
        this.accurateSubject = accurateSubject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchWorkEntity copy$default(SearchWorkEntity searchWorkEntity, List list, Pager pager, List list2, List list3, Integer num, List list4, AccurateSubject accurateSubject, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = searchWorkEntity.items;
        }
        if ((i11 & 2) != 0) {
            pager = searchWorkEntity.pager;
        }
        Pager pager2 = pager;
        if ((i11 & 4) != 0) {
            list2 = searchWorkEntity.verticalRanks;
        }
        List list5 = list2;
        if ((i11 & 8) != 0) {
            list3 = searchWorkEntity.counts;
        }
        List list6 = list3;
        if ((i11 & 16) != 0) {
            num = searchWorkEntity.subjectType;
        }
        Integer num2 = num;
        if ((i11 & 32) != 0) {
            list4 = searchWorkEntity.staffs;
        }
        List list7 = list4;
        if ((i11 & 64) != 0) {
            accurateSubject = searchWorkEntity.accurateSubject;
        }
        return searchWorkEntity.copy(list, pager2, list5, list6, num2, list7, accurateSubject);
    }

    public final List<SearchSubject> component1() {
        return this.items;
    }

    public final Pager component2() {
        return this.pager;
    }

    public final List<VerticalRank> component3() {
        return this.verticalRanks;
    }

    public final List<Count> component4() {
        return this.counts;
    }

    public final Integer component5() {
        return this.subjectType;
    }

    public final List<Staff> component6() {
        return this.staffs;
    }

    public final AccurateSubject component7() {
        return this.accurateSubject;
    }

    public final SearchWorkEntity copy(List<SearchSubject> items, Pager pager, List<VerticalRank> list, List<Count> counts, Integer num, List<? extends Staff> list2, AccurateSubject accurateSubject) {
        Intrinsics.g(items, "items");
        Intrinsics.g(pager, "pager");
        Intrinsics.g(counts, "counts");
        return new SearchWorkEntity(items, pager, list, counts, num, list2, accurateSubject);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchWorkEntity)) {
            return false;
        }
        SearchWorkEntity searchWorkEntity = (SearchWorkEntity) obj;
        return Intrinsics.b(this.items, searchWorkEntity.items) && Intrinsics.b(this.pager, searchWorkEntity.pager) && Intrinsics.b(this.verticalRanks, searchWorkEntity.verticalRanks) && Intrinsics.b(this.counts, searchWorkEntity.counts) && Intrinsics.b(this.subjectType, searchWorkEntity.subjectType) && Intrinsics.b(this.staffs, searchWorkEntity.staffs) && Intrinsics.b(this.accurateSubject, searchWorkEntity.accurateSubject);
    }

    public final AccurateSubject getAccurateSubject() {
        return this.accurateSubject;
    }

    public final List<Count> getCounts() {
        return this.counts;
    }

    public final List<SearchSubject> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final List<Staff> getStaffs() {
        return this.staffs;
    }

    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public final List<VerticalRank> getVerticalRanks() {
        return this.verticalRanks;
    }

    public int hashCode() {
        int iHashCode = ((this.items.hashCode() * 31) + this.pager.hashCode()) * 31;
        List<VerticalRank> list = this.verticalRanks;
        int iHashCode2 = (((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.counts.hashCode()) * 31;
        Integer num = this.subjectType;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        List<Staff> list2 = this.staffs;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        AccurateSubject accurateSubject = this.accurateSubject;
        return iHashCode4 + (accurateSubject != null ? accurateSubject.hashCode() : 0);
    }

    public String toString() {
        return "SearchWorkEntity(items=" + this.items + ", pager=" + this.pager + ", verticalRanks=" + this.verticalRanks + ", counts=" + this.counts + ", subjectType=" + this.subjectType + ", staffs=" + this.staffs + ", accurateSubject=" + this.accurateSubject + ")";
    }
}
