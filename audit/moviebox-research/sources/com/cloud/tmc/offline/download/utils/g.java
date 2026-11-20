package com.cloud.tmc.offline.download.utils;

import android.text.TextUtils;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflinePkgCachePath;
import com.cloud.tmc.offline.download.model.ZipFileInfo;
import com.transsion.core.deviceinfo.DeviceInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

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
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f32096a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f32097b;

    public final String a(OfflinePkgCachePath offlinePkgCachePath) {
        AppInfoModel appInfo;
        String deployVersion = null;
        if (offlinePkgCachePath != null) {
            try {
                List<ZipFileInfo> zipFileInfo = offlinePkgCachePath.getZipFileInfo();
                if (zipFileInfo != null && !zipFileInfo.isEmpty()) {
                    OffPkgConfig manifest = offlinePkgCachePath.getZipFileInfo().get(0).getManifest();
                    if (manifest != null && (appInfo = manifest.getAppInfo()) != null) {
                        deployVersion = appInfo.getDeployVersion();
                    }
                    TmcLogger.c("Subpackage::", "getAppVersionFromOfflinePkgCache:appVersion:" + deployVersion);
                }
            } catch (Throwable unused) {
            }
        }
        return deployVersion;
    }

    public final String b() {
        String str = f32097b;
        if (str != null) {
            return str;
        }
        String deviceOperator = DeviceInfo.f();
        if (!TextUtils.isEmpty(deviceOperator) && deviceOperator.length() >= 3) {
            Intrinsics.f(deviceOperator, "deviceOperator");
            String strSubstring = deviceOperator.substring(0, 3);
            Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            f32097b = strSubstring;
        }
        return f32097b;
    }

    public final boolean c(String str) {
        Intrinsics.g(str, "str");
        return new Regex("\\d+").matches(str);
    }
}
