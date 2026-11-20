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
public final class CloudConfigResponse {
    private final String cloudconfigKey;
    private final ConditionInfo conditionInfo;

    public CloudConfigResponse(String str, ConditionInfo conditionInfo) {
        this.cloudconfigKey = str;
        this.conditionInfo = conditionInfo;
    }

    public static /* synthetic */ CloudConfigResponse copy$default(CloudConfigResponse cloudConfigResponse, String str, ConditionInfo conditionInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cloudConfigResponse.cloudconfigKey;
        }
        if ((i11 & 2) != 0) {
            conditionInfo = cloudConfigResponse.conditionInfo;
        }
        return cloudConfigResponse.copy(str, conditionInfo);
    }

    public final String component1() {
        return this.cloudconfigKey;
    }

    public final ConditionInfo component2() {
        return this.conditionInfo;
    }

    public final CloudConfigResponse copy(String str, ConditionInfo conditionInfo) {
        return new CloudConfigResponse(str, conditionInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloudConfigResponse)) {
            return false;
        }
        CloudConfigResponse cloudConfigResponse = (CloudConfigResponse) obj;
        return Intrinsics.b(this.cloudconfigKey, cloudConfigResponse.cloudconfigKey) && Intrinsics.b(this.conditionInfo, cloudConfigResponse.conditionInfo);
    }

    public final String getCloudconfigKey() {
        return this.cloudconfigKey;
    }

    public final ConditionInfo getConditionInfo() {
        return this.conditionInfo;
    }

    public int hashCode() {
        String str = this.cloudconfigKey;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ConditionInfo conditionInfo = this.conditionInfo;
        return iHashCode + (conditionInfo != null ? conditionInfo.hashCode() : 0);
    }

    public String toString() {
        return "CloudConfigResponse(cloudconfigKey=" + ((Object) this.cloudconfigKey) + ", conditionInfo=" + this.conditionInfo + ')';
    }
}
