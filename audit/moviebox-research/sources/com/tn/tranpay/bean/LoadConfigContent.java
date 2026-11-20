package com.tn.tranpay.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tn.tranpay.network.BaseContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
public final class LoadConfigContent extends BaseContent implements Parcelable {
    public static final Parcelable.Creator<LoadConfigContent> CREATOR = new a();
    private final String amount;
    private final String areaCode;
    private final String bindToken;
    private final Integer coins;
    private final String countryCode;
    private final String countryLogo;
    private final String countryName;
    private final String cpFrontPage;
    private final String cpLogo;
    private final String cpName;
    private final String currency;
    private final Map<String, String> languagePackage;
    private final Boolean loginStatus;
    private final List<MediumInputBean> medium;
    private final String orderDescription;
    private final String orderId;
    private final String symbol;
    private final Integer testMode;
    private final String txnId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<LoadConfigContent> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LoadConfigContent createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Boolean boolValueOf;
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            String string10 = parcel.readString();
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i11 = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(i11);
                int i12 = 0;
                while (i12 != i11) {
                    linkedHashMap2.put(parcel.readString(), parcel.readString());
                    i12++;
                    i11 = i11;
                }
                linkedHashMap = linkedHashMap2;
            }
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i13 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i13);
                int i14 = 0;
                while (i14 != i13) {
                    arrayList2.add(MediumInputBean.CREATOR.createFromParcel(parcel));
                    i14++;
                    i13 = i13;
                }
                arrayList = arrayList2;
            }
            return new LoadConfigContent(string, string2, string3, numValueOf, string4, string5, string6, string7, string8, string9, string10, linkedHashMap, boolValueOf, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final LoadConfigContent[] newArray(int i11) {
            return new LoadConfigContent[i11];
        }
    }

    public LoadConfigContent() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    public LoadConfigContent(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map<String, String> map, Boolean bool, List<MediumInputBean> list, String str11, String str12, String str13, Integer num2, String str14) {
        this.amount = str;
        this.areaCode = str2;
        this.bindToken = str3;
        this.coins = num;
        this.countryCode = str4;
        this.countryLogo = str5;
        this.countryName = str6;
        this.cpFrontPage = str7;
        this.cpLogo = str8;
        this.cpName = str9;
        this.currency = str10;
        this.languagePackage = map;
        this.loginStatus = bool;
        this.medium = list;
        this.orderDescription = str11;
        this.orderId = str12;
        this.symbol = str13;
        this.testMode = num2;
        this.txnId = str14;
    }

    public /* synthetic */ LoadConfigContent(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map map, Boolean bool, List list, String str11, String str12, String str13, Integer num2, String str14, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : num, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? null : str6, (i11 & 128) != 0 ? null : str7, (i11 & 256) != 0 ? null : str8, (i11 & 512) != 0 ? null : str9, (i11 & 1024) != 0 ? null : str10, (i11 & 2048) != 0 ? null : map, (i11 & 4096) != 0 ? null : bool, (i11 & 8192) != 0 ? null : list, (i11 & 16384) != 0 ? null : str11, (i11 & 32768) != 0 ? null : str12, (i11 & 65536) != 0 ? null : str13, (i11 & 131072) != 0 ? null : num2, (i11 & 262144) != 0 ? null : str14);
    }

    public final String component1() {
        return this.amount;
    }

    public final String component10() {
        return this.cpName;
    }

    public final String component11() {
        return this.currency;
    }

    public final Map<String, String> component12() {
        return this.languagePackage;
    }

    public final Boolean component13() {
        return this.loginStatus;
    }

    public final List<MediumInputBean> component14() {
        return this.medium;
    }

    public final String component15() {
        return this.orderDescription;
    }

    public final String component16() {
        return this.orderId;
    }

    public final String component17() {
        return this.symbol;
    }

    public final Integer component18() {
        return this.testMode;
    }

    public final String component19() {
        return this.txnId;
    }

    public final String component2() {
        return this.areaCode;
    }

    public final String component3() {
        return this.bindToken;
    }

    public final Integer component4() {
        return this.coins;
    }

    public final String component5() {
        return this.countryCode;
    }

    public final String component6() {
        return this.countryLogo;
    }

    public final String component7() {
        return this.countryName;
    }

    public final String component8() {
        return this.cpFrontPage;
    }

    public final String component9() {
        return this.cpLogo;
    }

    public final LoadConfigContent copy(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map<String, String> map, Boolean bool, List<MediumInputBean> list, String str11, String str12, String str13, Integer num2, String str14) {
        return new LoadConfigContent(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, map, bool, list, str11, str12, str13, num2, str14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadConfigContent)) {
            return false;
        }
        LoadConfigContent loadConfigContent = (LoadConfigContent) obj;
        return Intrinsics.b(this.amount, loadConfigContent.amount) && Intrinsics.b(this.areaCode, loadConfigContent.areaCode) && Intrinsics.b(this.bindToken, loadConfigContent.bindToken) && Intrinsics.b(this.coins, loadConfigContent.coins) && Intrinsics.b(this.countryCode, loadConfigContent.countryCode) && Intrinsics.b(this.countryLogo, loadConfigContent.countryLogo) && Intrinsics.b(this.countryName, loadConfigContent.countryName) && Intrinsics.b(this.cpFrontPage, loadConfigContent.cpFrontPage) && Intrinsics.b(this.cpLogo, loadConfigContent.cpLogo) && Intrinsics.b(this.cpName, loadConfigContent.cpName) && Intrinsics.b(this.currency, loadConfigContent.currency) && Intrinsics.b(this.languagePackage, loadConfigContent.languagePackage) && Intrinsics.b(this.loginStatus, loadConfigContent.loginStatus) && Intrinsics.b(this.medium, loadConfigContent.medium) && Intrinsics.b(this.orderDescription, loadConfigContent.orderDescription) && Intrinsics.b(this.orderId, loadConfigContent.orderId) && Intrinsics.b(this.symbol, loadConfigContent.symbol) && Intrinsics.b(this.testMode, loadConfigContent.testMode) && Intrinsics.b(this.txnId, loadConfigContent.txnId);
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    public final String getBindToken() {
        return this.bindToken;
    }

    public final Integer getCoins() {
        return this.coins;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getCountryLogo() {
        return this.countryLogo;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final String getCpFrontPage() {
        return this.cpFrontPage;
    }

    public final String getCpLogo() {
        return this.cpLogo;
    }

    public final String getCpName() {
        return this.cpName;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final Map<String, String> getLanguagePackage() {
        return this.languagePackage;
    }

    public final Boolean getLoginStatus() {
        return this.loginStatus;
    }

    public final List<MediumInputBean> getMedium() {
        return this.medium;
    }

    public final String getOrderDescription() {
        return this.orderDescription;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public final Integer getTestMode() {
        return this.testMode;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public int hashCode() {
        String str = this.amount;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.areaCode;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.bindToken;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.coins;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.countryCode;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.countryLogo;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.countryName;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.cpFrontPage;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.cpLogo;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.cpName;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.currency;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Map<String, String> map = this.languagePackage;
        int iHashCode12 = (iHashCode11 + (map == null ? 0 : map.hashCode())) * 31;
        Boolean bool = this.loginStatus;
        int iHashCode13 = (iHashCode12 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<MediumInputBean> list = this.medium;
        int iHashCode14 = (iHashCode13 + (list == null ? 0 : list.hashCode())) * 31;
        String str11 = this.orderDescription;
        int iHashCode15 = (iHashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.orderId;
        int iHashCode16 = (iHashCode15 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.symbol;
        int iHashCode17 = (iHashCode16 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num2 = this.testMode;
        int iHashCode18 = (iHashCode17 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str14 = this.txnId;
        return iHashCode18 + (str14 != null ? str14.hashCode() : 0);
    }

    public String toString() {
        return "LoadConfigContent(amount=" + this.amount + ", areaCode=" + this.areaCode + ", bindToken=" + this.bindToken + ", coins=" + this.coins + ", countryCode=" + this.countryCode + ", countryLogo=" + this.countryLogo + ", countryName=" + this.countryName + ", cpFrontPage=" + this.cpFrontPage + ", cpLogo=" + this.cpLogo + ", cpName=" + this.cpName + ", currency=" + this.currency + ", languagePackage=" + this.languagePackage + ", loginStatus=" + this.loginStatus + ", medium=" + this.medium + ", orderDescription=" + this.orderDescription + ", orderId=" + this.orderId + ", symbol=" + this.symbol + ", testMode=" + this.testMode + ", txnId=" + this.txnId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.amount);
        out.writeString(this.areaCode);
        out.writeString(this.bindToken);
        Integer num = this.coins;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.countryCode);
        out.writeString(this.countryLogo);
        out.writeString(this.countryName);
        out.writeString(this.cpFrontPage);
        out.writeString(this.cpLogo);
        out.writeString(this.cpName);
        out.writeString(this.currency);
        Map<String, String> map = this.languagePackage;
        if (map == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                out.writeString(entry.getKey());
                out.writeString(entry.getValue());
            }
        }
        Boolean bool = this.loginStatus;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        List<MediumInputBean> list = this.medium;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<MediumInputBean> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        out.writeString(this.orderDescription);
        out.writeString(this.orderId);
        out.writeString(this.symbol);
        Integer num2 = this.testMode;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        out.writeString(this.txnId);
    }
}
