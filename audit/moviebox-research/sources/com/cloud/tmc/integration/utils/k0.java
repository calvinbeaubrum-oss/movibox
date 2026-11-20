package com.cloud.tmc.integration.utils;

import android.content.Context;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.proxy.FileProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import java.util.Iterator;
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
public final class k0 extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k0 f31068a = new k0();

    public static /* synthetic */ void s(k0 k0Var, Context context, AppModel appModel, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = null;
        }
        k0Var.r(context, appModel, str);
    }

    public final void m(Context context, String str, String str2, boolean z11) {
        Intrinsics.g(context, "context");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        if (str != null) {
            kVStorageProxy.putBoolean(context, str, str2 + "_bgDownStatus", z11);
        }
    }

    public final void n(Context context, AppModel appModel, String str) {
        c(context, appModel.getAppId(), str, false);
        d(context, appModel.getAppId(), str, false);
        b(context, appModel.getAppId(), str, false);
    }

    public final boolean o(Context context, String str, String identificationEncryptionUrl) {
        Intrinsics.g(context, "context");
        Intrinsics.g(identificationEncryptionUrl, "identificationEncryptionUrl");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        if (str == null) {
            return false;
        }
        return kVStorageProxy.getBoolean(context, str, identificationEncryptionUrl + "_bgDownStatus", false);
    }

    public final boolean p(AppModel appModel, SubPackageInfo subPackageInfo) {
        Intrinsics.g(appModel, "appModel");
        PathProxy pathProxy = (PathProxy) tc.a.a(PathProxy.class);
        AppUtils appUtils = AppUtils.f31011a;
        String strK = AppUtils.k(appUtils, appModel, subPackageInfo, null, 4, null);
        String strV = v(appModel, strK);
        String strM = AppUtils.m(appUtils, appModel, subPackageInfo, null, 4, null);
        String strA = com.cloud.tmc.miniutils.util.o.a(strV, strM + ".tar");
        String strA2 = com.cloud.tmc.miniutils.util.o.a(strV, "Manifest.json");
        String strF = com.cloud.tmc.miniutils.util.h.f(com.cloud.tmc.miniutils.util.i.c(pathProxy.getTarPath(appModel.getAppId(), strK, strM)));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(pathProxy.getZipUnCompressPath(appModel.getAppId(), strK));
        sb2.append("/Manifest.json");
        return Intrinsics.b(strA, strF) && Intrinsics.b(strA2, com.cloud.tmc.miniutils.util.h.f(com.cloud.tmc.miniutils.util.i.c(sb2.toString())));
    }

    public final boolean q(Context context, String str, String identificationEncryptionUrl) {
        Intrinsics.g(context, "context");
        Intrinsics.g(identificationEncryptionUrl, "identificationEncryptionUrl");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        if (str == null) {
            return false;
        }
        return kVStorageProxy.getBoolean(context, str, identificationEncryptionUrl + "_tar", false);
    }

    public final void r(Context context, AppModel appModel, String str) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        try {
            ((FileProxy) tc.a.a(FileProxy.class)).deleteAllFileForVersion(appModel, str);
            if (str != null && str.length() != 0) {
                n(context, appModel, str);
                return;
            }
            String packageUrl_MD5 = appModel.getPackageUrl_MD5();
            if (packageUrl_MD5 != null) {
                f31068a.n(context, appModel, packageUrl_MD5);
            }
            String mainPackageUrlEncryption = appModel.getMainPackageUrlEncryption();
            if (mainPackageUrlEncryption != null) {
                f31068a.n(context, appModel, mainPackageUrlEncryption);
            }
            List<SubPackageInfo> subPackagePages = appModel.getSubPackagePages();
            if (subPackagePages != null) {
                Iterator<SubPackageInfo> it = subPackagePages.iterator();
                while (it.hasNext()) {
                    f31068a.n(context, appModel, it.next().getSubPackageUrlMD5());
                }
            }
        } catch (Throwable th2) {
            TmcLogger.h("clearVersion", th2);
        }
    }

    public final void t(Context context, String str, String str2) {
        Intrinsics.g(context, "context");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        if (str != null) {
            kVStorageProxy.remove(context, str, str2 + "_bgDownStatus");
        }
    }

    public final String u(AppModel appModel, String str) {
        Intrinsics.g(appModel, "appModel");
        String strE = com.cloud.tmc.miniutils.util.i.e(((PathProxy) tc.a.a(PathProxy.class)).getZipUnCompressPath(appModel.getAppId(), str) + "/Manifest.json");
        Intrinsics.f(strE, "readFile2String(\n       …/Manifest.json\"\n        )");
        return strE;
    }

    public final String v(AppModel appModel, String str) {
        Intrinsics.g(appModel, "appModel");
        String strE = com.cloud.tmc.miniutils.util.i.e(((PathProxy) tc.a.a(PathProxy.class)).getZipUnCompressPath(appModel.getAppId(), str) + "/SIGN.json");
        Intrinsics.f(strE, "readFile2String(path)");
        return strE;
    }
}
