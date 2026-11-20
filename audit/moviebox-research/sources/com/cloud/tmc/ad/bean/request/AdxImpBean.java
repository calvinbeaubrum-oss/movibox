package com.cloud.tmc.ad.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AdxImpBean extends b {
    private Integer adt;
    private Integer isTimeOut;
    private Integer mAdCount;
    private Boolean offlineAd;
    private String pmid;
    private String requestId;
    private Long requestTs;
    private Integer requestType;
    private String triggerId;

    public AdxImpBean() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public AdxImpBean(String str, Integer num, Integer num2, Integer num3, Long l11, String str2, String str3, Integer num4, Boolean bool) {
        this.pmid = str;
        this.adt = num;
        this.mAdCount = num2;
        this.requestType = num3;
        this.requestTs = l11;
        this.requestId = str2;
        this.triggerId = str3;
        this.isTimeOut = num4;
        this.offlineAd = bool;
    }

    public /* synthetic */ AdxImpBean(String str, Integer num, Integer num2, Integer num3, Long l11, String str2, String str3, Integer num4, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 0 : num, (i11 & 4) != 0 ? 1 : num2, (i11 & 8) != 0 ? 0 : num3, (i11 & 16) != 0 ? 0L : l11, (i11 & 32) != 0 ? null : str2, (i11 & 64) == 0 ? str3 : null, (i11 & 128) != 0 ? 0 : num4, (i11 & 256) != 0 ? Boolean.FALSE : bool);
    }

    private final Long component5() {
        return this.requestTs;
    }

    public final String component1() {
        return this.pmid;
    }

    public final Integer component2() {
        return this.adt;
    }

    public final Integer component3() {
        return this.mAdCount;
    }

    public final Integer component4() {
        return this.requestType;
    }

    public final String component6() {
        return this.requestId;
    }

    public final String component7() {
        return this.triggerId;
    }

    public final Integer component8() {
        return this.isTimeOut;
    }

    public final Boolean component9() {
        return this.offlineAd;
    }

    public final AdxImpBean copy(String str, Integer num, Integer num2, Integer num3, Long l11, String str2, String str3, Integer num4, Boolean bool) {
        return new AdxImpBean(str, num, num2, num3, l11, str2, str3, num4, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdxImpBean)) {
            return false;
        }
        AdxImpBean adxImpBean = (AdxImpBean) obj;
        return Intrinsics.b(this.pmid, adxImpBean.pmid) && Intrinsics.b(this.adt, adxImpBean.adt) && Intrinsics.b(this.mAdCount, adxImpBean.mAdCount) && Intrinsics.b(this.requestType, adxImpBean.requestType) && Intrinsics.b(this.requestTs, adxImpBean.requestTs) && Intrinsics.b(this.requestId, adxImpBean.requestId) && Intrinsics.b(this.triggerId, adxImpBean.triggerId) && Intrinsics.b(this.isTimeOut, adxImpBean.isTimeOut) && Intrinsics.b(this.offlineAd, adxImpBean.offlineAd);
    }

    public final Integer getAdt() {
        return this.adt;
    }

    public final Integer getMAdCount() {
        return this.mAdCount;
    }

    public final Boolean getOfflineAd() {
        return this.offlineAd;
    }

    public final String getPmid() {
        return this.pmid;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final long getRequestTs() {
        Long l11 = this.requestTs;
        if (l11 != null) {
            return l11.longValue();
        }
        return 0L;
    }

    public final Integer getRequestType() {
        return this.requestType;
    }

    public final String getTriggerId() {
        return this.triggerId;
    }

    public int hashCode() {
        String str = this.pmid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.adt;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.mAdCount;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.requestType;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Long l11 = this.requestTs;
        int iHashCode5 = (iHashCode4 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str2 = this.requestId;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.triggerId;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num4 = this.isTimeOut;
        int iHashCode8 = (iHashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Boolean bool = this.offlineAd;
        return iHashCode8 + (bool != null ? bool.hashCode() : 0);
    }

    public final Integer isTimeOut() {
        return this.isTimeOut;
    }

    public final void setAdt(Integer num) {
        this.adt = num;
    }

    public final void setMAdCount(Integer num) {
        this.mAdCount = num;
    }

    public final void setOfflineAd(Boolean bool) {
        this.offlineAd = bool;
    }

    public final void setPmid(String str) {
        this.pmid = str;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final void setRequestType(Integer num) {
        this.requestType = num;
    }

    public final void setTimeOut(Integer num) {
        this.isTimeOut = num;
    }

    public final void setTriggerId(String str) {
        this.triggerId = str;
    }

    public String toString() {
        return "AdxImpBean{, pmid='" + this.pmid + "', adt=" + this.adt + ", mAdCount=" + this.mAdCount + '}';
    }
}
