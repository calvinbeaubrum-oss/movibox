package com.transsion.memberapi;

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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class MemberCheckResult implements Parcelable {
    public static final Parcelable.Creator<MemberCheckResult> CREATOR = new a();
    private String currency;
    private String interceptType;
    private String inviteH5Url;
    private String inviteRewardDays;
    private Boolean isPassed;
    private String memberPrice;
    private List<MemberRights> memberRights;
    private Integer multiDownloadLimit;
    private String pointUrl;
    private List<String> vipAdScenes;
    private Boolean vipEnable;
    private Boolean vipPayEnable;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<MemberCheckResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MemberCheckResult createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(MemberRights.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new MemberCheckResult(boolValueOf, string, string2, string3, arrayList, parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MemberCheckResult[] newArray(int i11) {
            return new MemberCheckResult[i11];
        }
    }

    public MemberCheckResult(Boolean bool, String str, String str2, String str3, List<MemberRights> list, Boolean bool2, Boolean bool3, Integer num, String str4, String str5, String str6, List<String> list2) {
        this.isPassed = bool;
        this.interceptType = str;
        this.memberPrice = str2;
        this.currency = str3;
        this.memberRights = list;
        this.vipEnable = bool2;
        this.vipPayEnable = bool3;
        this.multiDownloadLimit = num;
        this.inviteRewardDays = str4;
        this.inviteH5Url = str5;
        this.pointUrl = str6;
        this.vipAdScenes = list2;
    }

    public final Boolean component1() {
        return this.isPassed;
    }

    public final String component10() {
        return this.inviteH5Url;
    }

    public final String component11() {
        return this.pointUrl;
    }

    public final List<String> component12() {
        return this.vipAdScenes;
    }

    public final String component2() {
        return this.interceptType;
    }

    public final String component3() {
        return this.memberPrice;
    }

    public final String component4() {
        return this.currency;
    }

    public final List<MemberRights> component5() {
        return this.memberRights;
    }

    public final Boolean component6() {
        return this.vipEnable;
    }

    public final Boolean component7() {
        return this.vipPayEnable;
    }

    public final Integer component8() {
        return this.multiDownloadLimit;
    }

    public final String component9() {
        return this.inviteRewardDays;
    }

    public final MemberCheckResult copy(Boolean bool, String str, String str2, String str3, List<MemberRights> list, Boolean bool2, Boolean bool3, Integer num, String str4, String str5, String str6, List<String> list2) {
        return new MemberCheckResult(bool, str, str2, str3, list, bool2, bool3, num, str4, str5, str6, list2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberCheckResult)) {
            return false;
        }
        MemberCheckResult memberCheckResult = (MemberCheckResult) obj;
        return Intrinsics.b(this.isPassed, memberCheckResult.isPassed) && Intrinsics.b(this.interceptType, memberCheckResult.interceptType) && Intrinsics.b(this.memberPrice, memberCheckResult.memberPrice) && Intrinsics.b(this.currency, memberCheckResult.currency) && Intrinsics.b(this.memberRights, memberCheckResult.memberRights) && Intrinsics.b(this.vipEnable, memberCheckResult.vipEnable) && Intrinsics.b(this.vipPayEnable, memberCheckResult.vipPayEnable) && Intrinsics.b(this.multiDownloadLimit, memberCheckResult.multiDownloadLimit) && Intrinsics.b(this.inviteRewardDays, memberCheckResult.inviteRewardDays) && Intrinsics.b(this.inviteH5Url, memberCheckResult.inviteH5Url) && Intrinsics.b(this.pointUrl, memberCheckResult.pointUrl) && Intrinsics.b(this.vipAdScenes, memberCheckResult.vipAdScenes);
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getInterceptType() {
        return this.interceptType;
    }

    public final String getInviteH5Url() {
        return this.inviteH5Url;
    }

    public final String getInviteRewardDays() {
        return this.inviteRewardDays;
    }

    public final String getMemberPrice() {
        return this.memberPrice;
    }

    public final List<MemberRights> getMemberRights() {
        return this.memberRights;
    }

    public final Integer getMultiDownloadLimit() {
        return this.multiDownloadLimit;
    }

    public final String getPointUrl() {
        return this.pointUrl;
    }

    public final List<String> getVipAdScenes() {
        return this.vipAdScenes;
    }

    public final Boolean getVipEnable() {
        return this.vipEnable;
    }

    public final Boolean getVipPayEnable() {
        return this.vipPayEnable;
    }

    public int hashCode() {
        Boolean bool = this.isPassed;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.interceptType;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.memberPrice;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.currency;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<MemberRights> list = this.memberRights;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool2 = this.vipEnable;
        int iHashCode6 = (iHashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.vipPayEnable;
        int iHashCode7 = (iHashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num = this.multiDownloadLimit;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.inviteRewardDays;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.inviteH5Url;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.pointUrl;
        int iHashCode11 = (iHashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<String> list2 = this.vipAdScenes;
        return iHashCode11 + (list2 != null ? list2.hashCode() : 0);
    }

    public final Boolean isPassed() {
        return this.isPassed;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setInterceptType(String str) {
        this.interceptType = str;
    }

    public final void setInviteH5Url(String str) {
        this.inviteH5Url = str;
    }

    public final void setInviteRewardDays(String str) {
        this.inviteRewardDays = str;
    }

    public final void setMemberPrice(String str) {
        this.memberPrice = str;
    }

    public final void setMemberRights(List<MemberRights> list) {
        this.memberRights = list;
    }

    public final void setMultiDownloadLimit(Integer num) {
        this.multiDownloadLimit = num;
    }

    public final void setPassed(Boolean bool) {
        this.isPassed = bool;
    }

    public final void setPointUrl(String str) {
        this.pointUrl = str;
    }

    public final void setVipAdScenes(List<String> list) {
        this.vipAdScenes = list;
    }

    public final void setVipEnable(Boolean bool) {
        this.vipEnable = bool;
    }

    public final void setVipPayEnable(Boolean bool) {
        this.vipPayEnable = bool;
    }

    public String toString() {
        return "MemberCheckResult(isPassed=" + this.isPassed + ", interceptType=" + this.interceptType + ", memberPrice=" + this.memberPrice + ", currency=" + this.currency + ", memberRights=" + this.memberRights + ", vipEnable=" + this.vipEnable + ", vipPayEnable=" + this.vipPayEnable + ", multiDownloadLimit=" + this.multiDownloadLimit + ", inviteRewardDays=" + this.inviteRewardDays + ", inviteH5Url=" + this.inviteH5Url + ", pointUrl=" + this.pointUrl + ", vipAdScenes=" + this.vipAdScenes + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        Boolean bool = this.isPassed;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        out.writeString(this.interceptType);
        out.writeString(this.memberPrice);
        out.writeString(this.currency);
        List<MemberRights> list = this.memberRights;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<MemberRights> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        Boolean bool2 = this.vipEnable;
        if (bool2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.vipPayEnable;
        if (bool3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        Integer num = this.multiDownloadLimit;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.inviteRewardDays);
        out.writeString(this.inviteH5Url);
        out.writeString(this.pointUrl);
        out.writeStringList(this.vipAdScenes);
    }
}
