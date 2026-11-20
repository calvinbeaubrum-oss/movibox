package com.transsion.ad.db.pslink;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
public final class PsLinkAdPlan implements Parcelable {
    public static final Parcelable.Creator<PsLinkAdPlan> CREATOR = new a();
    private String adSource;
    private String extAdSlot;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f50399id;
    private String nonId;
    private String psInfoJson;
    private String psLinkAdInfoStr;
    private String psPlanId;
    private int rank;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PsLinkAdPlan> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PsLinkAdPlan createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PsLinkAdPlan(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PsLinkAdPlan[] newArray(int i11) {
            return new PsLinkAdPlan[i11];
        }
    }

    public PsLinkAdPlan(int i11, String nonId, String adSource, String extAdSlot, int i12, String str, String str2, String str3) {
        Intrinsics.g(nonId, "nonId");
        Intrinsics.g(adSource, "adSource");
        Intrinsics.g(extAdSlot, "extAdSlot");
        this.f50399id = i11;
        this.nonId = nonId;
        this.adSource = adSource;
        this.extAdSlot = extAdSlot;
        this.rank = i12;
        this.psPlanId = str;
        this.psLinkAdInfoStr = str2;
        this.psInfoJson = str3;
    }

    public /* synthetic */ PsLinkAdPlan(int i11, String str, String str2, String str3, int i12, String str4, String str5, String str6, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, str, str2, str3, (i13 & 16) != 0 ? 0 : i12, (i13 & 32) != 0 ? null : str4, (i13 & 64) != 0 ? null : str5, (i13 & 128) != 0 ? null : str6);
    }

    public final int component1() {
        return this.f50399id;
    }

    public final String component2() {
        return this.nonId;
    }

    public final String component3() {
        return this.adSource;
    }

    public final String component4() {
        return this.extAdSlot;
    }

    public final int component5() {
        return this.rank;
    }

    public final String component6() {
        return this.psPlanId;
    }

    public final String component7() {
        return this.psLinkAdInfoStr;
    }

    public final String component8() {
        return this.psInfoJson;
    }

    public final PsLinkAdPlan copy(int i11, String nonId, String adSource, String extAdSlot, int i12, String str, String str2, String str3) {
        Intrinsics.g(nonId, "nonId");
        Intrinsics.g(adSource, "adSource");
        Intrinsics.g(extAdSlot, "extAdSlot");
        return new PsLinkAdPlan(i11, nonId, adSource, extAdSlot, i12, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PsLinkAdPlan)) {
            return false;
        }
        PsLinkAdPlan psLinkAdPlan = (PsLinkAdPlan) obj;
        return this.f50399id == psLinkAdPlan.f50399id && Intrinsics.b(this.nonId, psLinkAdPlan.nonId) && Intrinsics.b(this.adSource, psLinkAdPlan.adSource) && Intrinsics.b(this.extAdSlot, psLinkAdPlan.extAdSlot) && this.rank == psLinkAdPlan.rank && Intrinsics.b(this.psPlanId, psLinkAdPlan.psPlanId) && Intrinsics.b(this.psLinkAdInfoStr, psLinkAdPlan.psLinkAdInfoStr) && Intrinsics.b(this.psInfoJson, psLinkAdPlan.psInfoJson);
    }

    public final String getAdSource() {
        return this.adSource;
    }

    public final String getExtAdSlot() {
        return this.extAdSlot;
    }

    public final int getId() {
        return this.f50399id;
    }

    public final String getNonId() {
        return this.nonId;
    }

    public final String getPsInfoJson() {
        return this.psInfoJson;
    }

    public final String getPsLinkAdInfoStr() {
        return this.psLinkAdInfoStr;
    }

    public final String getPsPlanId() {
        return this.psPlanId;
    }

    public final int getRank() {
        return this.rank;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.f50399id * 31) + this.nonId.hashCode()) * 31) + this.adSource.hashCode()) * 31) + this.extAdSlot.hashCode()) * 31) + this.rank) * 31;
        String str = this.psPlanId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.psLinkAdInfoStr;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.psInfoJson;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setAdSource(String str) {
        Intrinsics.g(str, "<set-?>");
        this.adSource = str;
    }

    public final void setExtAdSlot(String str) {
        Intrinsics.g(str, "<set-?>");
        this.extAdSlot = str;
    }

    public final void setId(int i11) {
        this.f50399id = i11;
    }

    public final void setNonId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.nonId = str;
    }

    public final void setPsInfoJson(String str) {
        this.psInfoJson = str;
    }

    public final void setPsLinkAdInfoStr(String str) {
        this.psLinkAdInfoStr = str;
    }

    public final void setPsPlanId(String str) {
        this.psPlanId = str;
    }

    public final void setRank(int i11) {
        this.rank = i11;
    }

    public String toString() {
        return "PsLinkAdPlan(id=" + this.f50399id + ", nonId=" + this.nonId + ", adSource=" + this.adSource + ", extAdSlot=" + this.extAdSlot + ", rank=" + this.rank + ", psPlanId=" + this.psPlanId + ", psLinkAdInfoStr=" + this.psLinkAdInfoStr + ", psInfoJson=" + this.psInfoJson + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.f50399id);
        out.writeString(this.nonId);
        out.writeString(this.adSource);
        out.writeString(this.extAdSlot);
        out.writeInt(this.rank);
        out.writeString(this.psPlanId);
        out.writeString(this.psLinkAdInfoStr);
        out.writeString(this.psInfoJson);
    }
}
