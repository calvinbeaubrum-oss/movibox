package com.transsion.memberapi;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class SkuData {
    private List<MemberRight> memberRights;
    private List<SkuItem> skuList;
    private List<SkuItem> skuPointList;

    public SkuData(List<SkuItem> list, List<SkuItem> list2, List<MemberRight> list3) {
        this.skuList = list;
        this.skuPointList = list2;
        this.memberRights = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuData copy$default(SkuData skuData, List list, List list2, List list3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = skuData.skuList;
        }
        if ((i11 & 2) != 0) {
            list2 = skuData.skuPointList;
        }
        if ((i11 & 4) != 0) {
            list3 = skuData.memberRights;
        }
        return skuData.copy(list, list2, list3);
    }

    public final List<SkuItem> component1() {
        return this.skuList;
    }

    public final List<SkuItem> component2() {
        return this.skuPointList;
    }

    public final List<MemberRight> component3() {
        return this.memberRights;
    }

    public final SkuData copy(List<SkuItem> list, List<SkuItem> list2, List<MemberRight> list3) {
        return new SkuData(list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuData)) {
            return false;
        }
        SkuData skuData = (SkuData) obj;
        return Intrinsics.b(this.skuList, skuData.skuList) && Intrinsics.b(this.skuPointList, skuData.skuPointList) && Intrinsics.b(this.memberRights, skuData.memberRights);
    }

    public final List<MemberRight> getMemberRights() {
        return this.memberRights;
    }

    public final List<SkuItem> getSkuList() {
        return this.skuList;
    }

    public final List<SkuItem> getSkuPointList() {
        return this.skuPointList;
    }

    public int hashCode() {
        List<SkuItem> list = this.skuList;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<SkuItem> list2 = this.skuPointList;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MemberRight> list3 = this.memberRights;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public final void setMemberRights(List<MemberRight> list) {
        this.memberRights = list;
    }

    public final void setSkuList(List<SkuItem> list) {
        this.skuList = list;
    }

    public final void setSkuPointList(List<SkuItem> list) {
        this.skuPointList = list;
    }

    public String toString() {
        return "SkuData(skuList=" + this.skuList + ", skuPointList=" + this.skuPointList + ", memberRights=" + this.memberRights + ")";
    }
}
