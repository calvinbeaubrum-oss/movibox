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
public final class ConditionParamX {
    private final List<String> mcc;
    private final List<String> osVersion;
    private final List<String> phoneBrand;
    private final List<String> phoneLanguage;
    private final List<String> phoneModel;

    public ConditionParamX(List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
        this.mcc = list;
        this.osVersion = list2;
        this.phoneModel = list3;
        this.phoneBrand = list4;
        this.phoneLanguage = list5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConditionParamX copy$default(ConditionParamX conditionParamX, List list, List list2, List list3, List list4, List list5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = conditionParamX.mcc;
        }
        if ((i11 & 2) != 0) {
            list2 = conditionParamX.osVersion;
        }
        List list6 = list2;
        if ((i11 & 4) != 0) {
            list3 = conditionParamX.phoneModel;
        }
        List list7 = list3;
        if ((i11 & 8) != 0) {
            list4 = conditionParamX.phoneBrand;
        }
        List list8 = list4;
        if ((i11 & 16) != 0) {
            list5 = conditionParamX.phoneLanguage;
        }
        return conditionParamX.copy(list, list6, list7, list8, list5);
    }

    public final List<String> component1() {
        return this.mcc;
    }

    public final List<String> component2() {
        return this.osVersion;
    }

    public final List<String> component3() {
        return this.phoneModel;
    }

    public final List<String> component4() {
        return this.phoneBrand;
    }

    public final List<String> component5() {
        return this.phoneLanguage;
    }

    public final ConditionParamX copy(List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
        return new ConditionParamX(list, list2, list3, list4, list5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConditionParamX)) {
            return false;
        }
        ConditionParamX conditionParamX = (ConditionParamX) obj;
        return Intrinsics.b(this.mcc, conditionParamX.mcc) && Intrinsics.b(this.osVersion, conditionParamX.osVersion) && Intrinsics.b(this.phoneModel, conditionParamX.phoneModel) && Intrinsics.b(this.phoneBrand, conditionParamX.phoneBrand) && Intrinsics.b(this.phoneLanguage, conditionParamX.phoneLanguage);
    }

    public final List<String> getMcc() {
        return this.mcc;
    }

    public final List<String> getOsVersion() {
        return this.osVersion;
    }

    public final List<String> getPhoneBrand() {
        return this.phoneBrand;
    }

    public final List<String> getPhoneLanguage() {
        return this.phoneLanguage;
    }

    public final List<String> getPhoneModel() {
        return this.phoneModel;
    }

    public int hashCode() {
        List<String> list = this.mcc;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.osVersion;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.phoneModel;
        int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<String> list4 = this.phoneBrand;
        int iHashCode4 = (iHashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<String> list5 = this.phoneLanguage;
        return iHashCode4 + (list5 != null ? list5.hashCode() : 0);
    }

    public String toString() {
        return "ConditionParamX(mcc=" + this.mcc + ", osVersion=" + this.osVersion + ", phoneModel=" + this.phoneModel + ", phoneBrand=" + this.phoneBrand + ", phoneLanguage=" + this.phoneLanguage + ')';
    }
}
