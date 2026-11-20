package com.tmc.network;

import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class NetworkConfig {
    private static boolean isNetworkImproveEnable;
    private static boolean isNetworkMonitorEnable;
    public static final NetworkConfig INSTANCE = new NetworkConfig();
    private static CopyOnWriteArraySet<String> preConnectList = new CopyOnWriteArraySet<>();
    private static String packageName = "";
    private static int monitorId = -1;
    private static int monitorRandomNum = 1000;

    private NetworkConfig() {
    }

    public static /* synthetic */ void setAppMonitorRandom$default(NetworkConfig networkConfig, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 1000;
        }
        networkConfig.setAppMonitorRandom(i11);
    }

    public final int getAppMonitorId() {
        return monitorId;
    }

    public final int getAppMonitorRandom() {
        return monitorRandomNum;
    }

    public final String getPackageName() {
        return packageName;
    }

    public final CopyOnWriteArraySet<String> getPreConnectList() {
        return preConnectList;
    }

    public final boolean isNetworkImproveEnable() {
        return isNetworkImproveEnable;
    }

    public final boolean isNetworkMonitorEnable() {
        return isNetworkMonitorEnable;
    }

    public final void setAppMonitorId(int i11) {
        monitorId = i11;
    }

    public final void setAppMonitorRandom(int i11) {
        monitorRandomNum = i11;
    }

    public final void setNetworkImproveEnable(boolean z11) {
        isNetworkImproveEnable = z11;
    }

    public final void setNetworkMonitorEnable(boolean z11) {
        isNetworkMonitorEnable = z11;
    }

    public final void setPackageName(String str) {
        packageName = str;
    }

    public final void setPreConnectList(CopyOnWriteArraySet<String> copyOnWriteArraySet) {
        Intrinsics.g(copyOnWriteArraySet, "<set-?>");
        preConnectList = copyOnWriteArraySet;
    }

    public final void setPreHostList(List<String> urlList) {
        Intrinsics.g(urlList, "urlList");
        preConnectList.addAll(urlList);
    }
}
