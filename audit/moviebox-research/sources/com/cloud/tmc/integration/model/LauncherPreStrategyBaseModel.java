package com.cloud.tmc.integration.model;

import java.util.ArrayList;
import kotlin.Metadata;
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
public final class LauncherPreStrategyBaseModel extends b {
    private ArrayList<LauncherPreStrategyModel> configList;
    private final String configVerion;

    public LauncherPreStrategyBaseModel(String configVerion, ArrayList<LauncherPreStrategyModel> arrayList) {
        Intrinsics.g(configVerion, "configVerion");
        this.configVerion = configVerion;
        this.configList = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LauncherPreStrategyBaseModel copy$default(LauncherPreStrategyBaseModel launcherPreStrategyBaseModel, String str, ArrayList arrayList, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = launcherPreStrategyBaseModel.configVerion;
        }
        if ((i11 & 2) != 0) {
            arrayList = launcherPreStrategyBaseModel.configList;
        }
        return launcherPreStrategyBaseModel.copy(str, arrayList);
    }

    public final String component1() {
        return this.configVerion;
    }

    public final ArrayList<LauncherPreStrategyModel> component2() {
        return this.configList;
    }

    public final LauncherPreStrategyBaseModel copy(String configVerion, ArrayList<LauncherPreStrategyModel> arrayList) {
        Intrinsics.g(configVerion, "configVerion");
        return new LauncherPreStrategyBaseModel(configVerion, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LauncherPreStrategyBaseModel)) {
            return false;
        }
        LauncherPreStrategyBaseModel launcherPreStrategyBaseModel = (LauncherPreStrategyBaseModel) obj;
        return Intrinsics.b(this.configVerion, launcherPreStrategyBaseModel.configVerion) && Intrinsics.b(this.configList, launcherPreStrategyBaseModel.configList);
    }

    public final ArrayList<LauncherPreStrategyModel> getConfigList() {
        return this.configList;
    }

    public final String getConfigVerion() {
        return this.configVerion;
    }

    public int hashCode() {
        int iHashCode = this.configVerion.hashCode() * 31;
        ArrayList<LauncherPreStrategyModel> arrayList = this.configList;
        return iHashCode + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public final void setConfigList(ArrayList<LauncherPreStrategyModel> arrayList) {
        this.configList = arrayList;
    }

    public String toString() {
        return "LauncherPreStrategyBaseModel(configVerion=" + this.configVerion + ", configList=" + this.configList + ')';
    }
}
