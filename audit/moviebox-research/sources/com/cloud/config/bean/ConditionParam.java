package com.cloud.config.bean;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ConditionParam {
    private final String cacheFileUrl;
    private final ConditionParamX conditionParam;
    private final ShuntInfo shuntInfo;

    public ConditionParam(String str, ConditionParamX conditionParamX, ShuntInfo shuntInfo) {
        this.cacheFileUrl = str;
        this.conditionParam = conditionParamX;
        this.shuntInfo = shuntInfo;
    }

    public static /* synthetic */ ConditionParam copy$default(ConditionParam conditionParam, String str, ConditionParamX conditionParamX, ShuntInfo shuntInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = conditionParam.cacheFileUrl;
        }
        if ((i11 & 2) != 0) {
            conditionParamX = conditionParam.conditionParam;
        }
        if ((i11 & 4) != 0) {
            shuntInfo = conditionParam.shuntInfo;
        }
        return conditionParam.copy(str, conditionParamX, shuntInfo);
    }

    public final String component1() {
        return this.cacheFileUrl;
    }

    public final ConditionParamX component2() {
        return this.conditionParam;
    }

    public final ShuntInfo component3() {
        return this.shuntInfo;
    }

    public final ConditionParam copy(String str, ConditionParamX conditionParamX, ShuntInfo shuntInfo) {
        return new ConditionParam(str, conditionParamX, shuntInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConditionParam)) {
            return false;
        }
        ConditionParam conditionParam = (ConditionParam) obj;
        return Intrinsics.b(this.cacheFileUrl, conditionParam.cacheFileUrl) && Intrinsics.b(this.conditionParam, conditionParam.conditionParam) && Intrinsics.b(this.shuntInfo, conditionParam.shuntInfo);
    }

    public final String getCacheFileUrl() {
        return this.cacheFileUrl;
    }

    public final ConditionParamX getConditionParam() {
        return this.conditionParam;
    }

    public final ShuntInfo getShuntInfo() {
        return this.shuntInfo;
    }

    public int hashCode() {
        String str = this.cacheFileUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ConditionParamX conditionParamX = this.conditionParam;
        int iHashCode2 = (iHashCode + (conditionParamX == null ? 0 : conditionParamX.hashCode())) * 31;
        ShuntInfo shuntInfo = this.shuntInfo;
        return iHashCode2 + (shuntInfo != null ? shuntInfo.hashCode() : 0);
    }

    public String toString() {
        return "ConditionParam(cacheFileUrl=" + ((Object) this.cacheFileUrl) + ", conditionParam=" + this.conditionParam + ", shuntInfo=" + this.shuntInfo + ')';
    }
}
