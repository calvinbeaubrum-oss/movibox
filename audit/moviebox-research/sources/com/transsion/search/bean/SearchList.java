package com.transsion.search.bean;

import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
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
public final class SearchList {
    private final List<Group> groups;
    private final String moreTabId;
    private final Boolean showMore;
    private final List<Staff> staffs;
    private final List<Subject> subjects;
    private final String title;
    private final String topicType;
    private final List<VerticalRank> verticalRanks;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchList(String str, String str2, Boolean bool, String str3, List<? extends Subject> list, List<? extends Staff> list2, List<Group> list3, List<VerticalRank> list4) {
        this.topicType = str;
        this.title = str2;
        this.showMore = bool;
        this.moreTabId = str3;
        this.subjects = list;
        this.staffs = list2;
        this.groups = list3;
        this.verticalRanks = list4;
    }

    public final String component1() {
        return this.topicType;
    }

    public final String component2() {
        return this.title;
    }

    public final Boolean component3() {
        return this.showMore;
    }

    public final String component4() {
        return this.moreTabId;
    }

    public final List<Subject> component5() {
        return this.subjects;
    }

    public final List<Staff> component6() {
        return this.staffs;
    }

    public final List<Group> component7() {
        return this.groups;
    }

    public final List<VerticalRank> component8() {
        return this.verticalRanks;
    }

    public final SearchList copy(String str, String str2, Boolean bool, String str3, List<? extends Subject> list, List<? extends Staff> list2, List<Group> list3, List<VerticalRank> list4) {
        return new SearchList(str, str2, bool, str3, list, list2, list3, list4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchList)) {
            return false;
        }
        SearchList searchList = (SearchList) obj;
        return Intrinsics.b(this.topicType, searchList.topicType) && Intrinsics.b(this.title, searchList.title) && Intrinsics.b(this.showMore, searchList.showMore) && Intrinsics.b(this.moreTabId, searchList.moreTabId) && Intrinsics.b(this.subjects, searchList.subjects) && Intrinsics.b(this.staffs, searchList.staffs) && Intrinsics.b(this.groups, searchList.groups) && Intrinsics.b(this.verticalRanks, searchList.verticalRanks);
    }

    public final List<Group> getGroups() {
        return this.groups;
    }

    public final String getMoreTabId() {
        return this.moreTabId;
    }

    public final Boolean getShowMore() {
        return this.showMore;
    }

    public final List<Staff> getStaffs() {
        return this.staffs;
    }

    public final List<Subject> getSubjects() {
        return this.subjects;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTopicType() {
        return this.topicType;
    }

    public final List<VerticalRank> getVerticalRanks() {
        return this.verticalRanks;
    }

    public int hashCode() {
        String str = this.topicType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.showMore;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.moreTabId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<Subject> list = this.subjects;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<Staff> list2 = this.staffs;
        int iHashCode6 = (iHashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Group> list3 = this.groups;
        int iHashCode7 = (iHashCode6 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<VerticalRank> list4 = this.verticalRanks;
        return iHashCode7 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        return "SearchList(topicType=" + this.topicType + ", title=" + this.title + ", showMore=" + this.showMore + ", moreTabId=" + this.moreTabId + ", subjects=" + this.subjects + ", staffs=" + this.staffs + ", groups=" + this.groups + ", verticalRanks=" + this.verticalRanks + ")";
    }
}
