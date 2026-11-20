package com.transsion.ad.monopoly.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

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
@Metadata
public final class AdPlans implements Parcelable {
    public static final Parcelable.Creator<AdPlans> CREATOR = new a();
    private List<AdMaterialList> adMaterialList;
    private final String adPlanCreateTime;
    private final String adPlanUpdateTime;
    private final String adShowLevel;
    private String adSource;
    private String advertiserAvatar;
    private String advertiserAvatarPath;
    private String advertiserName;
    private final String appSizeDesc;
    private final String appStarDesc;
    private Double bidEcpmCent;
    private final List<String> brand;
    private final List<String> country;
    private CtxAttributeConfig ctxAttributeConfig;
    private final String ctxDisableExpr;
    private final String ctxEnableExpr;
    private final List<String> denyBrand;
    private final List<String> denyModel;
    private String dispatchTimeEnd;
    private String dispatchTimeStart;
    private final Integer displayTimes;
    private Long ecpmCent;
    private final String endTime;
    private String extAdSlot;
    private MbAdImage extImage;
    private final String extraConfig;
    private final String filterClientVersion;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f50536id;
    private final List<String> model;
    private final String name;
    private final List<String> scenes;
    private String showDate;
    private Integer showedTimes;
    private final Integer sort;
    private final String startTime;
    private final String version;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<AdPlans> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AdPlans createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            Integer numValueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string6 = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            Integer numValueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
            ArrayList<String> arrayListCreateStringArrayList3 = parcel.createStringArrayList();
            ArrayList<String> arrayListCreateStringArrayList4 = parcel.createStringArrayList();
            ArrayList<String> arrayListCreateStringArrayList5 = parcel.createStringArrayList();
            ArrayList<String> arrayListCreateStringArrayList6 = parcel.createStringArrayList();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            String string10 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                int i12 = 0;
                while (i12 != i11) {
                    arrayList2.add(AdMaterialList.CREATOR.createFromParcel(parcel));
                    i12++;
                    i11 = i11;
                }
                arrayList = arrayList2;
            }
            return new AdPlans(string, string2, numValueOf, string3, string4, string5, numValueOf2, string6, arrayListCreateStringArrayList, numValueOf3, arrayListCreateStringArrayList2, arrayListCreateStringArrayList3, arrayListCreateStringArrayList4, arrayListCreateStringArrayList5, arrayListCreateStringArrayList6, string7, string8, string9, string10, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : CtxAttributeConfig.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : MbAdImage.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AdPlans[] newArray(int i11) {
            return new AdPlans[i11];
        }
    }

    public AdPlans() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 15, null);
    }

    public AdPlans(String str, String str2, Integer num, String str3, String str4, String str5, Integer num2, String str6, List<String> list, Integer num3, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str7, String str8, String str9, String str10, List<AdMaterialList> list7, String str11, String str12, String str13, String str14, String str15, String str16, String str17, CtxAttributeConfig ctxAttributeConfig, String str18, String str19, String str20, String str21, MbAdImage mbAdImage, String str22, Double d11, Long l11) {
        this.f50536id = str;
        this.name = str2;
        this.sort = num;
        this.advertiserName = str3;
        this.advertiserAvatar = str4;
        this.advertiserAvatarPath = str5;
        this.showedTimes = num2;
        this.showDate = str6;
        this.scenes = list;
        this.displayTimes = num3;
        this.country = list2;
        this.brand = list3;
        this.denyBrand = list4;
        this.model = list5;
        this.denyModel = list6;
        this.filterClientVersion = str7;
        this.startTime = str8;
        this.endTime = str9;
        this.extraConfig = str10;
        this.adMaterialList = list7;
        this.adPlanCreateTime = str11;
        this.adPlanUpdateTime = str12;
        this.adShowLevel = str13;
        this.appStarDesc = str14;
        this.appSizeDesc = str15;
        this.ctxEnableExpr = str16;
        this.ctxDisableExpr = str17;
        this.ctxAttributeConfig = ctxAttributeConfig;
        this.dispatchTimeStart = str18;
        this.dispatchTimeEnd = str19;
        this.adSource = str20;
        this.extAdSlot = str21;
        this.extImage = mbAdImage;
        this.version = str22;
        this.bidEcpmCent = d11;
        this.ecpmCent = l11;
    }

    public /* synthetic */ AdPlans(String str, String str2, Integer num, String str3, String str4, String str5, Integer num2, String str6, List list, Integer num3, List list2, List list3, List list4, List list5, List list6, String str7, String str8, String str9, String str10, List list7, String str11, String str12, String str13, String str14, String str15, String str16, String str17, CtxAttributeConfig ctxAttributeConfig, String str18, String str19, String str20, String str21, MbAdImage mbAdImage, String str22, Double d11, Long l11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? Integer.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER) : num, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? null : num2, (i11 & 128) != 0 ? null : str6, (i11 & 256) != 0 ? null : list, (i11 & 512) != 0 ? null : num3, (i11 & 1024) != 0 ? null : list2, (i11 & 2048) != 0 ? null : list3, (i11 & 4096) != 0 ? null : list4, (i11 & 8192) != 0 ? null : list5, (i11 & 16384) != 0 ? null : list6, (i11 & 32768) != 0 ? null : str7, (i11 & 65536) != 0 ? null : str8, (i11 & 131072) != 0 ? null : str9, (i11 & 262144) != 0 ? null : str10, (i11 & 524288) != 0 ? null : list7, (i11 & 1048576) != 0 ? null : str11, (i11 & 2097152) != 0 ? null : str12, (i11 & 4194304) != 0 ? null : str13, (i11 & 8388608) != 0 ? null : str14, (i11 & 16777216) != 0 ? null : str15, (i11 & ASTNode.PCTX_STORED) != 0 ? null : str16, (i11 & 67108864) != 0 ? null : str17, (i11 & ASTNode.NOJIT) != 0 ? null : ctxAttributeConfig, (i11 & ASTNode.DEOP) != 0 ? null : str18, (i11 & ASTNode.DISCARD) != 0 ? null : str19, (i11 & 1073741824) != 0 ? null : str20, (i11 & Integer.MIN_VALUE) != 0 ? null : str21, (i12 & 1) != 0 ? null : mbAdImage, (i12 & 2) != 0 ? null : str22, (i12 & 4) != 0 ? null : d11, (i12 & 8) != 0 ? null : l11);
    }

    public final String component1() {
        return this.f50536id;
    }

    public final Integer component10() {
        return this.displayTimes;
    }

    public final List<String> component11() {
        return this.country;
    }

    public final List<String> component12() {
        return this.brand;
    }

    public final List<String> component13() {
        return this.denyBrand;
    }

    public final List<String> component14() {
        return this.model;
    }

    public final List<String> component15() {
        return this.denyModel;
    }

    public final String component16() {
        return this.filterClientVersion;
    }

    public final String component17() {
        return this.startTime;
    }

    public final String component18() {
        return this.endTime;
    }

    public final String component19() {
        return this.extraConfig;
    }

    public final String component2() {
        return this.name;
    }

    public final List<AdMaterialList> component20() {
        return this.adMaterialList;
    }

    public final String component21() {
        return this.adPlanCreateTime;
    }

    public final String component22() {
        return this.adPlanUpdateTime;
    }

    public final String component23() {
        return this.adShowLevel;
    }

    public final String component24() {
        return this.appStarDesc;
    }

    public final String component25() {
        return this.appSizeDesc;
    }

    public final String component26() {
        return this.ctxEnableExpr;
    }

    public final String component27() {
        return this.ctxDisableExpr;
    }

    public final CtxAttributeConfig component28() {
        return this.ctxAttributeConfig;
    }

    public final String component29() {
        return this.dispatchTimeStart;
    }

    public final Integer component3() {
        return this.sort;
    }

    public final String component30() {
        return this.dispatchTimeEnd;
    }

    public final String component31() {
        return this.adSource;
    }

    public final String component32() {
        return this.extAdSlot;
    }

    public final MbAdImage component33() {
        return this.extImage;
    }

    public final String component34() {
        return this.version;
    }

    public final Double component35() {
        return this.bidEcpmCent;
    }

    public final Long component36() {
        return this.ecpmCent;
    }

    public final String component4() {
        return this.advertiserName;
    }

    public final String component5() {
        return this.advertiserAvatar;
    }

    public final String component6() {
        return this.advertiserAvatarPath;
    }

    public final Integer component7() {
        return this.showedTimes;
    }

    public final String component8() {
        return this.showDate;
    }

    public final List<String> component9() {
        return this.scenes;
    }

    public final AdPlans copy(String str, String str2, Integer num, String str3, String str4, String str5, Integer num2, String str6, List<String> list, Integer num3, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str7, String str8, String str9, String str10, List<AdMaterialList> list7, String str11, String str12, String str13, String str14, String str15, String str16, String str17, CtxAttributeConfig ctxAttributeConfig, String str18, String str19, String str20, String str21, MbAdImage mbAdImage, String str22, Double d11, Long l11) {
        return new AdPlans(str, str2, num, str3, str4, str5, num2, str6, list, num3, list2, list3, list4, list5, list6, str7, str8, str9, str10, list7, str11, str12, str13, str14, str15, str16, str17, ctxAttributeConfig, str18, str19, str20, str21, mbAdImage, str22, d11, l11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdPlans)) {
            return false;
        }
        AdPlans adPlans = (AdPlans) obj;
        return Intrinsics.b(this.f50536id, adPlans.f50536id) && Intrinsics.b(this.name, adPlans.name) && Intrinsics.b(this.sort, adPlans.sort) && Intrinsics.b(this.advertiserName, adPlans.advertiserName) && Intrinsics.b(this.advertiserAvatar, adPlans.advertiserAvatar) && Intrinsics.b(this.advertiserAvatarPath, adPlans.advertiserAvatarPath) && Intrinsics.b(this.showedTimes, adPlans.showedTimes) && Intrinsics.b(this.showDate, adPlans.showDate) && Intrinsics.b(this.scenes, adPlans.scenes) && Intrinsics.b(this.displayTimes, adPlans.displayTimes) && Intrinsics.b(this.country, adPlans.country) && Intrinsics.b(this.brand, adPlans.brand) && Intrinsics.b(this.denyBrand, adPlans.denyBrand) && Intrinsics.b(this.model, adPlans.model) && Intrinsics.b(this.denyModel, adPlans.denyModel) && Intrinsics.b(this.filterClientVersion, adPlans.filterClientVersion) && Intrinsics.b(this.startTime, adPlans.startTime) && Intrinsics.b(this.endTime, adPlans.endTime) && Intrinsics.b(this.extraConfig, adPlans.extraConfig) && Intrinsics.b(this.adMaterialList, adPlans.adMaterialList) && Intrinsics.b(this.adPlanCreateTime, adPlans.adPlanCreateTime) && Intrinsics.b(this.adPlanUpdateTime, adPlans.adPlanUpdateTime) && Intrinsics.b(this.adShowLevel, adPlans.adShowLevel) && Intrinsics.b(this.appStarDesc, adPlans.appStarDesc) && Intrinsics.b(this.appSizeDesc, adPlans.appSizeDesc) && Intrinsics.b(this.ctxEnableExpr, adPlans.ctxEnableExpr) && Intrinsics.b(this.ctxDisableExpr, adPlans.ctxDisableExpr) && Intrinsics.b(this.ctxAttributeConfig, adPlans.ctxAttributeConfig) && Intrinsics.b(this.dispatchTimeStart, adPlans.dispatchTimeStart) && Intrinsics.b(this.dispatchTimeEnd, adPlans.dispatchTimeEnd) && Intrinsics.b(this.adSource, adPlans.adSource) && Intrinsics.b(this.extAdSlot, adPlans.extAdSlot) && Intrinsics.b(this.extImage, adPlans.extImage) && Intrinsics.b(this.version, adPlans.version) && Intrinsics.b(this.bidEcpmCent, adPlans.bidEcpmCent) && Intrinsics.b(this.ecpmCent, adPlans.ecpmCent);
    }

    public final List<AdMaterialList> getAdMaterialList() {
        return this.adMaterialList;
    }

    public final String getAdPlanCreateTime() {
        return this.adPlanCreateTime;
    }

    public final String getAdPlanUpdateTime() {
        return this.adPlanUpdateTime;
    }

    public final String getAdShowLevel() {
        return this.adShowLevel;
    }

    public final String getAdSource() {
        return this.adSource;
    }

    public final String getAdvertiserAvatar() {
        return this.advertiserAvatar;
    }

    public final String getAdvertiserAvatarPath() {
        return this.advertiserAvatarPath;
    }

    public final String getAdvertiserName() {
        return this.advertiserName;
    }

    public final String getAppSizeDesc() {
        return this.appSizeDesc;
    }

    public final String getAppStarDesc() {
        return this.appStarDesc;
    }

    public final Double getBidEcpmCent() {
        return this.bidEcpmCent;
    }

    public final List<String> getBrand() {
        return this.brand;
    }

    public final List<String> getCountry() {
        return this.country;
    }

    public final CtxAttributeConfig getCtxAttributeConfig() {
        return this.ctxAttributeConfig;
    }

    public final String getCtxDisableExpr() {
        return this.ctxDisableExpr;
    }

    public final String getCtxEnableExpr() {
        return this.ctxEnableExpr;
    }

    public final List<String> getDenyBrand() {
        return this.denyBrand;
    }

    public final List<String> getDenyModel() {
        return this.denyModel;
    }

    public final String getDispatchTimeEnd() {
        return this.dispatchTimeEnd;
    }

    public final String getDispatchTimeStart() {
        return this.dispatchTimeStart;
    }

    public final Integer getDisplayTimes() {
        return this.displayTimes;
    }

    public final Long getEcpmCent() {
        return this.ecpmCent;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getExtAdSlot() {
        return this.extAdSlot;
    }

    public final MbAdImage getExtImage() {
        return this.extImage;
    }

    public final String getExtraConfig() {
        return this.extraConfig;
    }

    public final String getFilterClientVersion() {
        return this.filterClientVersion;
    }

    public final String getId() {
        return this.f50536id;
    }

    public final List<String> getModel() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getScenes() {
        return this.scenes;
    }

    public final String getShowDate() {
        return this.showDate;
    }

    public final Integer getShowedTimes() {
        return this.showedTimes;
    }

    public final Integer getSort() {
        return this.sort;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.f50536id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.sort;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.advertiserName;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.advertiserAvatar;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.advertiserAvatarPath;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.showedTimes;
        int iHashCode7 = (iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str6 = this.showDate;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<String> list = this.scenes;
        int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num3 = this.displayTimes;
        int iHashCode10 = (iHashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List<String> list2 = this.country;
        int iHashCode11 = (iHashCode10 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.brand;
        int iHashCode12 = (iHashCode11 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<String> list4 = this.denyBrand;
        int iHashCode13 = (iHashCode12 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<String> list5 = this.model;
        int iHashCode14 = (iHashCode13 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<String> list6 = this.denyModel;
        int iHashCode15 = (iHashCode14 + (list6 == null ? 0 : list6.hashCode())) * 31;
        String str7 = this.filterClientVersion;
        int iHashCode16 = (iHashCode15 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.startTime;
        int iHashCode17 = (iHashCode16 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.endTime;
        int iHashCode18 = (iHashCode17 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.extraConfig;
        int iHashCode19 = (iHashCode18 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<AdMaterialList> list7 = this.adMaterialList;
        int iHashCode20 = (iHashCode19 + (list7 == null ? 0 : list7.hashCode())) * 31;
        String str11 = this.adPlanCreateTime;
        int iHashCode21 = (iHashCode20 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.adPlanUpdateTime;
        int iHashCode22 = (iHashCode21 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.adShowLevel;
        int iHashCode23 = (iHashCode22 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.appStarDesc;
        int iHashCode24 = (iHashCode23 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.appSizeDesc;
        int iHashCode25 = (iHashCode24 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.ctxEnableExpr;
        int iHashCode26 = (iHashCode25 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.ctxDisableExpr;
        int iHashCode27 = (iHashCode26 + (str17 == null ? 0 : str17.hashCode())) * 31;
        CtxAttributeConfig ctxAttributeConfig = this.ctxAttributeConfig;
        int iHashCode28 = (iHashCode27 + (ctxAttributeConfig == null ? 0 : ctxAttributeConfig.hashCode())) * 31;
        String str18 = this.dispatchTimeStart;
        int iHashCode29 = (iHashCode28 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.dispatchTimeEnd;
        int iHashCode30 = (iHashCode29 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.adSource;
        int iHashCode31 = (iHashCode30 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.extAdSlot;
        int iHashCode32 = (iHashCode31 + (str21 == null ? 0 : str21.hashCode())) * 31;
        MbAdImage mbAdImage = this.extImage;
        int iHashCode33 = (iHashCode32 + (mbAdImage == null ? 0 : mbAdImage.hashCode())) * 31;
        String str22 = this.version;
        int iHashCode34 = (iHashCode33 + (str22 == null ? 0 : str22.hashCode())) * 31;
        Double d11 = this.bidEcpmCent;
        int iHashCode35 = (iHashCode34 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Long l11 = this.ecpmCent;
        return iHashCode35 + (l11 != null ? l11.hashCode() : 0);
    }

    public final void setAdMaterialList(List<AdMaterialList> list) {
        this.adMaterialList = list;
    }

    public final void setAdSource(String str) {
        this.adSource = str;
    }

    public final void setAdvertiserAvatar(String str) {
        this.advertiserAvatar = str;
    }

    public final void setAdvertiserAvatarPath(String str) {
        this.advertiserAvatarPath = str;
    }

    public final void setAdvertiserName(String str) {
        this.advertiserName = str;
    }

    public final void setBidEcpmCent(Double d11) {
        this.bidEcpmCent = d11;
    }

    public final void setCtxAttributeConfig(CtxAttributeConfig ctxAttributeConfig) {
        this.ctxAttributeConfig = ctxAttributeConfig;
    }

    public final void setDispatchTimeEnd(String str) {
        this.dispatchTimeEnd = str;
    }

    public final void setDispatchTimeStart(String str) {
        this.dispatchTimeStart = str;
    }

    public final void setEcpmCent(Long l11) {
        this.ecpmCent = l11;
    }

    public final void setExtAdSlot(String str) {
        this.extAdSlot = str;
    }

    public final void setExtImage(MbAdImage mbAdImage) {
        this.extImage = mbAdImage;
    }

    public final void setShowDate(String str) {
        this.showDate = str;
    }

    public final void setShowedTimes(Integer num) {
        this.showedTimes = num;
    }

    public String toString() {
        return "AdPlans(id=" + this.f50536id + ", name=" + this.name + ", sort=" + this.sort + ", advertiserName=" + this.advertiserName + ", advertiserAvatar=" + this.advertiserAvatar + ", advertiserAvatarPath=" + this.advertiserAvatarPath + ", showedTimes=" + this.showedTimes + ", showDate=" + this.showDate + ", scenes=" + this.scenes + ", displayTimes=" + this.displayTimes + ", country=" + this.country + ", brand=" + this.brand + ", denyBrand=" + this.denyBrand + ", model=" + this.model + ", denyModel=" + this.denyModel + ", filterClientVersion=" + this.filterClientVersion + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", extraConfig=" + this.extraConfig + ", adMaterialList=" + this.adMaterialList + ", adPlanCreateTime=" + this.adPlanCreateTime + ", adPlanUpdateTime=" + this.adPlanUpdateTime + ", adShowLevel=" + this.adShowLevel + ", appStarDesc=" + this.appStarDesc + ", appSizeDesc=" + this.appSizeDesc + ", ctxEnableExpr=" + this.ctxEnableExpr + ", ctxDisableExpr=" + this.ctxDisableExpr + ", ctxAttributeConfig=" + this.ctxAttributeConfig + ", dispatchTimeStart=" + this.dispatchTimeStart + ", dispatchTimeEnd=" + this.dispatchTimeEnd + ", adSource=" + this.adSource + ", extAdSlot=" + this.extAdSlot + ", extImage=" + this.extImage + ", version=" + this.version + ", bidEcpmCent=" + this.bidEcpmCent + ", ecpmCent=" + this.ecpmCent + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.f50536id);
        out.writeString(this.name);
        Integer num = this.sort;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.advertiserName);
        out.writeString(this.advertiserAvatar);
        out.writeString(this.advertiserAvatarPath);
        Integer num2 = this.showedTimes;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        out.writeString(this.showDate);
        out.writeStringList(this.scenes);
        Integer num3 = this.displayTimes;
        if (num3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num3.intValue());
        }
        out.writeStringList(this.country);
        out.writeStringList(this.brand);
        out.writeStringList(this.denyBrand);
        out.writeStringList(this.model);
        out.writeStringList(this.denyModel);
        out.writeString(this.filterClientVersion);
        out.writeString(this.startTime);
        out.writeString(this.endTime);
        out.writeString(this.extraConfig);
        List<AdMaterialList> list = this.adMaterialList;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<AdMaterialList> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        out.writeString(this.adPlanCreateTime);
        out.writeString(this.adPlanUpdateTime);
        out.writeString(this.adShowLevel);
        out.writeString(this.appStarDesc);
        out.writeString(this.appSizeDesc);
        out.writeString(this.ctxEnableExpr);
        out.writeString(this.ctxDisableExpr);
        CtxAttributeConfig ctxAttributeConfig = this.ctxAttributeConfig;
        if (ctxAttributeConfig == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            ctxAttributeConfig.writeToParcel(out, i11);
        }
        out.writeString(this.dispatchTimeStart);
        out.writeString(this.dispatchTimeEnd);
        out.writeString(this.adSource);
        out.writeString(this.extAdSlot);
        MbAdImage mbAdImage = this.extImage;
        if (mbAdImage == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            mbAdImage.writeToParcel(out, i11);
        }
        out.writeString(this.version);
        Double d11 = this.bidEcpmCent;
        if (d11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeDouble(d11.doubleValue());
        }
        Long l11 = this.ecpmCent;
        if (l11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l11.longValue());
        }
    }
}
