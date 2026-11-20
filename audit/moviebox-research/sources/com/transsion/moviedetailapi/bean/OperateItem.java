package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.ad.bidding.nativead.c;
import com.transsion.bean.AhaGameAllGames;
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
public final class OperateItem implements Parcelable {
    public static final Parcelable.Creator<OperateItem> CREATOR = new a();
    private BannerBean banner;
    private CustomData customData;
    private String deepLink;
    private Subject feedsSubject;
    private List<FilterItem> filters;
    private List<AhaGameAllGames> gameList;
    private List<Group> groups;
    private List<LiveListItem> liveList;
    private String md5;
    private transient c nonAdDelegate;
    private String opId;
    private SingleImagePage page;
    private transient String pageName;
    private PlayListItem playListData;
    private Integer position;
    private RankingData rankingData;
    private RankingListData rankingListData;
    private List<? extends Subject> rankings;
    private List<AppointSubject> subjects;
    private String title;
    private String type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<OperateItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final OperateItem createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            ArrayList arrayList5;
            ArrayList arrayList6;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string3 = parcel.readString();
            BannerBean bannerBeanCreateFromParcel = parcel.readInt() == 0 ? null : BannerBean.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(FilterItem.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i13 = parcel.readInt();
                arrayList2 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList2.add(parcel.readSerializable());
                }
            }
            CustomData customDataCreateFromParcel = parcel.readInt() == 0 ? null : CustomData.CREATOR.createFromParcel(parcel);
            PlayListItem playListItemCreateFromParcel = parcel.readInt() == 0 ? null : PlayListItem.CREATOR.createFromParcel(parcel);
            Subject subject = (Subject) parcel.readSerializable();
            String string4 = parcel.readString();
            SingleImagePage singleImagePageCreateFromParcel = parcel.readInt() == 0 ? null : SingleImagePage.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList3 = null;
            } else {
                int i15 = parcel.readInt();
                ArrayList arrayList7 = new ArrayList(i15);
                int i16 = 0;
                while (i16 != i15) {
                    arrayList7.add(parcel.readSerializable());
                    i16++;
                    i15 = i15;
                }
                arrayList3 = arrayList7;
            }
            RankingData rankingDataCreateFromParcel = parcel.readInt() == 0 ? null : RankingData.CREATOR.createFromParcel(parcel);
            RankingListData rankingListDataCreateFromParcel = parcel.readInt() == 0 ? null : RankingListData.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList4 = null;
            } else {
                int i17 = parcel.readInt();
                ArrayList arrayList8 = new ArrayList(i17);
                int i18 = 0;
                while (i18 != i17) {
                    arrayList8.add(LiveListItem.CREATOR.createFromParcel(parcel));
                    i18++;
                    i17 = i17;
                }
                arrayList4 = arrayList8;
            }
            if (parcel.readInt() == 0) {
                arrayList5 = null;
            } else {
                int i19 = parcel.readInt();
                ArrayList arrayList9 = new ArrayList(i19);
                int i21 = 0;
                while (i21 != i19) {
                    arrayList9.add(parcel.readParcelable(OperateItem.class.getClassLoader()));
                    i21++;
                    i19 = i19;
                }
                arrayList5 = arrayList9;
            }
            if (parcel.readInt() == 0) {
                arrayList6 = null;
            } else {
                int i22 = parcel.readInt();
                ArrayList arrayList10 = new ArrayList(i22);
                for (int i23 = 0; i23 != i22; i23++) {
                    arrayList10.add(parcel.readSerializable());
                }
                arrayList6 = arrayList10;
            }
            return new OperateItem(string, string2, numValueOf, string3, bannerBeanCreateFromParcel, arrayList, arrayList2, customDataCreateFromParcel, playListItemCreateFromParcel, subject, string4, singleImagePageCreateFromParcel, arrayList3, rankingDataCreateFromParcel, rankingListDataCreateFromParcel, arrayList4, arrayList5, arrayList6, null, parcel.readString(), parcel.readString(), 262144, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final OperateItem[] newArray(int i11) {
            return new OperateItem[i11];
        }
    }

    public OperateItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    public OperateItem(String str, String str2, Integer num, String str3, BannerBean bannerBean, List<FilterItem> list, List<AppointSubject> list2, CustomData customData, PlayListItem playListItem, Subject subject, String str4, SingleImagePage singleImagePage, List<? extends Subject> list3, RankingData rankingData, RankingListData rankingListData, List<LiveListItem> list4, List<AhaGameAllGames> list5, List<Group> list6, c cVar, String str5, String str6) {
        this.title = str;
        this.type = str2;
        this.position = num;
        this.deepLink = str3;
        this.banner = bannerBean;
        this.filters = list;
        this.subjects = list2;
        this.customData = customData;
        this.playListData = playListItem;
        this.feedsSubject = subject;
        this.opId = str4;
        this.page = singleImagePage;
        this.rankings = list3;
        this.rankingData = rankingData;
        this.rankingListData = rankingListData;
        this.liveList = list4;
        this.gameList = list5;
        this.groups = list6;
        this.nonAdDelegate = cVar;
        this.pageName = str5;
        this.md5 = str6;
    }

    public /* synthetic */ OperateItem(String str, String str2, Integer num, String str3, BannerBean bannerBean, List list, List list2, CustomData customData, PlayListItem playListItem, Subject subject, String str4, SingleImagePage singleImagePage, List list3, RankingData rankingData, RankingListData rankingListData, List list4, List list5, List list6, c cVar, String str5, String str6, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) == 0 ? str2 : "", (i11 & 4) != 0 ? 0 : num, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : bannerBean, (i11 & 32) != 0 ? null : list, (i11 & 64) != 0 ? null : list2, (i11 & 128) != 0 ? null : customData, (i11 & 256) != 0 ? null : playListItem, (i11 & 512) != 0 ? null : subject, (i11 & 1024) != 0 ? null : str4, (i11 & 2048) != 0 ? null : singleImagePage, (i11 & 4096) != 0 ? null : list3, (i11 & 8192) != 0 ? null : rankingData, (i11 & 16384) != 0 ? null : rankingListData, (i11 & 32768) != 0 ? null : list4, (i11 & 65536) != 0 ? null : list5, (i11 & 131072) != 0 ? null : list6, (i11 & 262144) != 0 ? null : cVar, (i11 & 524288) != 0 ? null : str5, (i11 & 1048576) != 0 ? null : str6);
    }

    public static /* synthetic */ void getNonAdDelegate$annotations() {
    }

    public final String component1() {
        return this.title;
    }

    public final Subject component10() {
        return this.feedsSubject;
    }

    public final String component11() {
        return this.opId;
    }

    public final SingleImagePage component12() {
        return this.page;
    }

    public final List<Subject> component13() {
        return this.rankings;
    }

    public final RankingData component14() {
        return this.rankingData;
    }

    public final RankingListData component15() {
        return this.rankingListData;
    }

    public final List<LiveListItem> component16() {
        return this.liveList;
    }

    public final List<AhaGameAllGames> component17() {
        return this.gameList;
    }

    public final List<Group> component18() {
        return this.groups;
    }

    public final c component19() {
        return this.nonAdDelegate;
    }

    public final String component2() {
        return this.type;
    }

    public final String component20() {
        return this.pageName;
    }

    public final String component21() {
        return this.md5;
    }

    public final Integer component3() {
        return this.position;
    }

    public final String component4() {
        return this.deepLink;
    }

    public final BannerBean component5() {
        return this.banner;
    }

    public final List<FilterItem> component6() {
        return this.filters;
    }

    public final List<AppointSubject> component7() {
        return this.subjects;
    }

    public final CustomData component8() {
        return this.customData;
    }

    public final PlayListItem component9() {
        return this.playListData;
    }

    public final OperateItem copy(String str, String str2, Integer num, String str3, BannerBean bannerBean, List<FilterItem> list, List<AppointSubject> list2, CustomData customData, PlayListItem playListItem, Subject subject, String str4, SingleImagePage singleImagePage, List<? extends Subject> list3, RankingData rankingData, RankingListData rankingListData, List<LiveListItem> list4, List<AhaGameAllGames> list5, List<Group> list6, c cVar, String str5, String str6) {
        return new OperateItem(str, str2, num, str3, bannerBean, list, list2, customData, playListItem, subject, str4, singleImagePage, list3, rankingData, rankingListData, list4, list5, list6, cVar, str5, str6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OperateItem)) {
            return false;
        }
        OperateItem operateItem = (OperateItem) obj;
        return Intrinsics.b(this.title, operateItem.title) && Intrinsics.b(this.type, operateItem.type) && Intrinsics.b(this.position, operateItem.position) && Intrinsics.b(this.deepLink, operateItem.deepLink) && Intrinsics.b(this.banner, operateItem.banner) && Intrinsics.b(this.filters, operateItem.filters) && Intrinsics.b(this.subjects, operateItem.subjects) && Intrinsics.b(this.customData, operateItem.customData) && Intrinsics.b(this.playListData, operateItem.playListData) && Intrinsics.b(this.feedsSubject, operateItem.feedsSubject) && Intrinsics.b(this.opId, operateItem.opId) && Intrinsics.b(this.page, operateItem.page) && Intrinsics.b(this.rankings, operateItem.rankings) && Intrinsics.b(this.rankingData, operateItem.rankingData) && Intrinsics.b(this.rankingListData, operateItem.rankingListData) && Intrinsics.b(this.liveList, operateItem.liveList) && Intrinsics.b(this.gameList, operateItem.gameList) && Intrinsics.b(this.groups, operateItem.groups) && Intrinsics.b(this.nonAdDelegate, operateItem.nonAdDelegate) && Intrinsics.b(this.pageName, operateItem.pageName) && Intrinsics.b(this.md5, operateItem.md5);
    }

    public final BannerBean getBanner() {
        return this.banner;
    }

    public final CustomData getCustomData() {
        return this.customData;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final Subject getFeedsSubject() {
        return this.feedsSubject;
    }

    public final List<FilterItem> getFilters() {
        return this.filters;
    }

    public final List<AhaGameAllGames> getGameList() {
        return this.gameList;
    }

    public final List<Group> getGroups() {
        return this.groups;
    }

    public final List<LiveListItem> getLiveList() {
        return this.liveList;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final c getNonAdDelegate() {
        return this.nonAdDelegate;
    }

    public final String getOpId() {
        return this.opId;
    }

    public final SingleImagePage getPage() {
        return this.page;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final PlayListItem getPlayListData() {
        return this.playListData;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final RankingData getRankingData() {
        return this.rankingData;
    }

    public final RankingListData getRankingListData() {
        return this.rankingListData;
    }

    public final List<Subject> getRankings() {
        return this.rankings;
    }

    public final List<AppointSubject> getSubjects() {
        return this.subjects;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.position;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.deepLink;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        BannerBean bannerBean = this.banner;
        int iHashCode5 = (iHashCode4 + (bannerBean == null ? 0 : bannerBean.hashCode())) * 31;
        List<FilterItem> list = this.filters;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        List<AppointSubject> list2 = this.subjects;
        int iHashCode7 = (iHashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        CustomData customData = this.customData;
        int iHashCode8 = (iHashCode7 + (customData == null ? 0 : customData.hashCode())) * 31;
        PlayListItem playListItem = this.playListData;
        int iHashCode9 = (iHashCode8 + (playListItem == null ? 0 : playListItem.hashCode())) * 31;
        Subject subject = this.feedsSubject;
        int iHashCode10 = (iHashCode9 + (subject == null ? 0 : subject.hashCode())) * 31;
        String str4 = this.opId;
        int iHashCode11 = (iHashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        SingleImagePage singleImagePage = this.page;
        int iHashCode12 = (iHashCode11 + (singleImagePage == null ? 0 : singleImagePage.hashCode())) * 31;
        List<? extends Subject> list3 = this.rankings;
        int iHashCode13 = (iHashCode12 + (list3 == null ? 0 : list3.hashCode())) * 31;
        RankingData rankingData = this.rankingData;
        int iHashCode14 = (iHashCode13 + (rankingData == null ? 0 : rankingData.hashCode())) * 31;
        RankingListData rankingListData = this.rankingListData;
        int iHashCode15 = (iHashCode14 + (rankingListData == null ? 0 : rankingListData.hashCode())) * 31;
        List<LiveListItem> list4 = this.liveList;
        int iHashCode16 = (iHashCode15 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<AhaGameAllGames> list5 = this.gameList;
        int iHashCode17 = (iHashCode16 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<Group> list6 = this.groups;
        int iHashCode18 = (iHashCode17 + (list6 == null ? 0 : list6.hashCode())) * 31;
        c cVar = this.nonAdDelegate;
        int iHashCode19 = (iHashCode18 + (cVar == null ? 0 : cVar.hashCode())) * 31;
        String str5 = this.pageName;
        int iHashCode20 = (iHashCode19 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.md5;
        return iHashCode20 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setBanner(BannerBean bannerBean) {
        this.banner = bannerBean;
    }

    public final void setCustomData(CustomData customData) {
        this.customData = customData;
    }

    public final void setDeepLink(String str) {
        this.deepLink = str;
    }

    public final void setFeedsSubject(Subject subject) {
        this.feedsSubject = subject;
    }

    public final void setFilters(List<FilterItem> list) {
        this.filters = list;
    }

    public final void setGameList(List<AhaGameAllGames> list) {
        this.gameList = list;
    }

    public final void setGroups(List<Group> list) {
        this.groups = list;
    }

    public final void setLiveList(List<LiveListItem> list) {
        this.liveList = list;
    }

    public final void setMd5(String str) {
        this.md5 = str;
    }

    public final void setNonAdDelegate(c cVar) {
        this.nonAdDelegate = cVar;
    }

    public final void setOpId(String str) {
        this.opId = str;
    }

    public final void setPage(SingleImagePage singleImagePage) {
        this.page = singleImagePage;
    }

    public final void setPageName(String str) {
        this.pageName = str;
    }

    public final void setPlayListData(PlayListItem playListItem) {
        this.playListData = playListItem;
    }

    public final void setPosition(Integer num) {
        this.position = num;
    }

    public final void setRankingData(RankingData rankingData) {
        this.rankingData = rankingData;
    }

    public final void setRankingListData(RankingListData rankingListData) {
        this.rankingListData = rankingListData;
    }

    public final void setRankings(List<? extends Subject> list) {
        this.rankings = list;
    }

    public final void setSubjects(List<AppointSubject> list) {
        this.subjects = list;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "OperateItem(title=" + this.title + ", type=" + this.type + ", position=" + this.position + ", deepLink=" + this.deepLink + ", banner=" + this.banner + ", filters=" + this.filters + ", subjects=" + this.subjects + ", customData=" + this.customData + ", playListData=" + this.playListData + ", feedsSubject=" + this.feedsSubject + ", opId=" + this.opId + ", page=" + this.page + ", rankings=" + this.rankings + ", rankingData=" + this.rankingData + ", rankingListData=" + this.rankingListData + ", liveList=" + this.liveList + ", gameList=" + this.gameList + ", groups=" + this.groups + ", nonAdDelegate=" + this.nonAdDelegate + ", pageName=" + this.pageName + ", md5=" + this.md5 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.title);
        out.writeString(this.type);
        Integer num = this.position;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.deepLink);
        BannerBean bannerBean = this.banner;
        if (bannerBean == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            bannerBean.writeToParcel(out, i11);
        }
        List<FilterItem> list = this.filters;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<FilterItem> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        List<AppointSubject> list2 = this.subjects;
        if (list2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list2.size());
            Iterator<AppointSubject> it2 = list2.iterator();
            while (it2.hasNext()) {
                out.writeSerializable(it2.next());
            }
        }
        CustomData customData = this.customData;
        if (customData == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            customData.writeToParcel(out, i11);
        }
        PlayListItem playListItem = this.playListData;
        if (playListItem == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            playListItem.writeToParcel(out, i11);
        }
        out.writeSerializable(this.feedsSubject);
        out.writeString(this.opId);
        SingleImagePage singleImagePage = this.page;
        if (singleImagePage == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            singleImagePage.writeToParcel(out, i11);
        }
        List<? extends Subject> list3 = this.rankings;
        if (list3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list3.size());
            Iterator<? extends Subject> it3 = list3.iterator();
            while (it3.hasNext()) {
                out.writeSerializable(it3.next());
            }
        }
        RankingData rankingData = this.rankingData;
        if (rankingData == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            rankingData.writeToParcel(out, i11);
        }
        RankingListData rankingListData = this.rankingListData;
        if (rankingListData == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            rankingListData.writeToParcel(out, i11);
        }
        List<LiveListItem> list4 = this.liveList;
        if (list4 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list4.size());
            Iterator<LiveListItem> it4 = list4.iterator();
            while (it4.hasNext()) {
                it4.next().writeToParcel(out, i11);
            }
        }
        List<AhaGameAllGames> list5 = this.gameList;
        if (list5 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list5.size());
            Iterator<AhaGameAllGames> it5 = list5.iterator();
            while (it5.hasNext()) {
                out.writeParcelable(it5.next(), i11);
            }
        }
        List<Group> list6 = this.groups;
        if (list6 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list6.size());
            Iterator<Group> it6 = list6.iterator();
            while (it6.hasNext()) {
                out.writeSerializable(it6.next());
            }
        }
        out.writeString(this.pageName);
        out.writeString(this.md5);
    }
}
