package com.cloud.config.bean;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ShuntInfo {
    private final List<String> conditionParamKeys;
    private final String expireTimestampMill;
    private final String shuntStatus;
    private final String shuntType;

    public ShuntInfo(List<String> list, String str, String str2, String str3) {
        this.conditionParamKeys = list;
        this.expireTimestampMill = str;
        this.shuntStatus = str2;
        this.shuntType = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShuntInfo copy$default(ShuntInfo shuntInfo, List list, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = shuntInfo.conditionParamKeys;
        }
        if ((i11 & 2) != 0) {
            str = shuntInfo.expireTimestampMill;
        }
        if ((i11 & 4) != 0) {
            str2 = shuntInfo.shuntStatus;
        }
        if ((i11 & 8) != 0) {
            str3 = shuntInfo.shuntType;
        }
        return shuntInfo.copy(list, str, str2, str3);
    }

    public final List<String> component1() {
        return this.conditionParamKeys;
    }

    public final String component2() {
        return this.expireTimestampMill;
    }

    public final String component3() {
        return this.shuntStatus;
    }

    public final String component4() {
        return this.shuntType;
    }

    public final ShuntInfo copy(List<String> list, String str, String str2, String str3) {
        return new ShuntInfo(list, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShuntInfo)) {
            return false;
        }
        ShuntInfo shuntInfo = (ShuntInfo) obj;
        return Intrinsics.b(this.conditionParamKeys, shuntInfo.conditionParamKeys) && Intrinsics.b(this.expireTimestampMill, shuntInfo.expireTimestampMill) && Intrinsics.b(this.shuntStatus, shuntInfo.shuntStatus) && Intrinsics.b(this.shuntType, shuntInfo.shuntType);
    }

    public final List<String> getConditionParamKeys() {
        return this.conditionParamKeys;
    }

    public final String getExpireTimestampMill() {
        return this.expireTimestampMill;
    }

    public final String getShuntStatus() {
        return this.shuntStatus;
    }

    public final String getShuntType() {
        return this.shuntType;
    }

    public int hashCode() {
        List<String> list = this.conditionParamKeys;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.expireTimestampMill;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.shuntStatus;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.shuntType;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isShuntOpen() {
        String str = this.expireTimestampMill;
        return (str == null ? 0L : Long.parseLong(str)) > System.currentTimeMillis() && Intrinsics.b(this.shuntStatus, "1");
    }

    public String toString() {
        return "ShuntInfo(conditionParamKeys=" + this.conditionParamKeys + ", expireTimestampMill=" + ((Object) this.expireTimestampMill) + ", shuntStatus=" + ((Object) this.shuntStatus) + ", shuntType=" + ((Object) this.shuntType) + ')';
    }
}
