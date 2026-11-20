package com.cloud.hisavana.sdk.ext.attr;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
public final class AttrData {
    private int count;
    private String creatives;
    private int errorCode;
    private String errorList;
    private long eventTs;
    private int failCount;
    private String linkId;
    private int type;

    public AttrData() {
        this(0, null, 0, 0L, null, 0, null, 0, 255, null);
    }

    public AttrData(int i11, String linkId, int i12, long j11, String creatives, int i13, String errorList, int i14) {
        Intrinsics.g(linkId, "linkId");
        Intrinsics.g(creatives, "creatives");
        Intrinsics.g(errorList, "errorList");
        this.type = i11;
        this.linkId = linkId;
        this.count = i12;
        this.eventTs = j11;
        this.creatives = creatives;
        this.failCount = i13;
        this.errorList = errorList;
        this.errorCode = i14;
    }

    public /* synthetic */ AttrData(int i11, String str, int i12, long j11, String str2, int i13, String str3, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? 0 : i11, (i15 & 2) != 0 ? "" : str, (i15 & 4) != 0 ? 0 : i12, (i15 & 8) != 0 ? 0L : j11, (i15 & 16) != 0 ? "" : str2, (i15 & 32) != 0 ? 0 : i13, (i15 & 64) == 0 ? str3 : "", (i15 & 128) == 0 ? i14 : 0);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.linkId;
    }

    public final int component3() {
        return this.count;
    }

    public final long component4() {
        return this.eventTs;
    }

    public final String component5() {
        return this.creatives;
    }

    public final int component6() {
        return this.failCount;
    }

    public final String component7() {
        return this.errorList;
    }

    public final int component8() {
        return this.errorCode;
    }

    public final AttrData copy(int i11, String linkId, int i12, long j11, String creatives, int i13, String errorList, int i14) {
        Intrinsics.g(linkId, "linkId");
        Intrinsics.g(creatives, "creatives");
        Intrinsics.g(errorList, "errorList");
        return new AttrData(i11, linkId, i12, j11, creatives, i13, errorList, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttrData)) {
            return false;
        }
        AttrData attrData = (AttrData) obj;
        return this.type == attrData.type && Intrinsics.b(this.linkId, attrData.linkId) && this.count == attrData.count && this.eventTs == attrData.eventTs && Intrinsics.b(this.creatives, attrData.creatives) && this.failCount == attrData.failCount && Intrinsics.b(this.errorList, attrData.errorList) && this.errorCode == attrData.errorCode;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getCreatives() {
        return this.creatives;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorList() {
        return this.errorList;
    }

    public final long getEventTs() {
        return this.eventTs;
    }

    public final int getFailCount() {
        return this.failCount;
    }

    public final String getLinkId() {
        return this.linkId;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((this.type * 31) + this.linkId.hashCode()) * 31) + this.count) * 31) + p.a(this.eventTs)) * 31) + this.creatives.hashCode()) * 31) + this.failCount) * 31) + this.errorList.hashCode()) * 31) + this.errorCode;
    }

    public final void setCount(int i11) {
        this.count = i11;
    }

    public final void setCreatives(String str) {
        Intrinsics.g(str, "<set-?>");
        this.creatives = str;
    }

    public final void setErrorCode(int i11) {
        this.errorCode = i11;
    }

    public final void setErrorList(String str) {
        Intrinsics.g(str, "<set-?>");
        this.errorList = str;
    }

    public final void setEventTs(long j11) {
        this.eventTs = j11;
    }

    public final void setFailCount(int i11) {
        this.failCount = i11;
    }

    public final void setLinkId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.linkId = str;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "AttrData(type=" + this.type + ", linkId=" + this.linkId + ", count=" + this.count + ", eventTs=" + this.eventTs + ", creatives=" + this.creatives + ", failCount=" + this.failCount + ", errorList=" + this.errorList + ", errorCode=" + this.errorCode + ')';
    }
}
