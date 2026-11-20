package com.cloud.tmc.integration.utils;

import android.content.Context;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.proxy.FileProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
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
public final class h extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f31061a = new h();

    public final void m(Context context, AppModel appModel, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        String appId = appModel.getAppId();
        if (appId != null) {
            kVStorageProxy.putBoolean(context, appId, appModel.getPackageUrl_MD5() + "_tar", z11);
        }
    }

    public final synchronized void n(Context context, AppModel appModel, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        String appId = appModel.getAppId();
        if (appId != null) {
            kVStorageProxy.putBoolean(context, appId, appModel.getPackageUrl_MD5() + "_download", z11);
        }
    }

    public final void o(Context context, AppModel appModel, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        String appId = appModel.getAppId();
        if (appId != null) {
            kVStorageProxy.putBoolean(context, appId, appModel.getPackageUrl_MD5() + "_zip", z11);
        }
    }

    public final boolean p(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        PathProxy pathProxy = (PathProxy) tc.a.a(PathProxy.class);
        String strU = u(appModel);
        String strA = com.cloud.tmc.miniutils.util.o.a(strU, appModel.getAppId() + ".tar");
        String strA2 = com.cloud.tmc.miniutils.util.o.a(strU, "Manifest.json");
        String strF = com.cloud.tmc.miniutils.util.h.f(com.cloud.tmc.miniutils.util.i.c(pathProxy.getTarPath(appModel)));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(pathProxy.getZipUnCompressPath(appModel));
        sb2.append("/Manifest.json");
        return Intrinsics.b(strA, strF) && Intrinsics.b(strA2, com.cloud.tmc.miniutils.util.h.f(com.cloud.tmc.miniutils.util.i.c(sb2.toString())));
    }

    public final boolean q(Context context, AppModel appModel) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        String appId = appModel.getAppId();
        if (appId == null) {
            return false;
        }
        return kVStorageProxy.getBoolean(context, appId, appModel.getPackageUrl_MD5() + "_tar", false);
    }

    public final synchronized boolean r(Context context, AppModel appModel) {
        boolean z11;
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        String appId = appModel.getAppId();
        z11 = false;
        if (appId != null) {
            z11 = kVStorageProxy.getBoolean(context, appId, appModel.getPackageUrl_MD5() + "_download", false);
        }
        return z11;
    }

    public final void s(Context context, AppModel appModel) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        ((FileProxy) tc.a.a(FileProxy.class)).deleteAllFileForVersion(appModel);
        n(context, appModel, false);
        o(context, appModel, false);
        m(context, appModel, false);
    }

    public final String t(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        String strE = com.cloud.tmc.miniutils.util.i.e(((PathProxy) tc.a.a(PathProxy.class)).getZipUnCompressPath(appModel) + "/Manifest.json");
        Intrinsics.f(strE, "readFile2String(\"${pathP…ppModel)}/Manifest.json\")");
        return strE;
    }

    public final String u(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        String strE = com.cloud.tmc.miniutils.util.i.e(((PathProxy) tc.a.a(PathProxy.class)).getZipUnCompressPath(appModel) + "/SIGN.json");
        Intrinsics.f(strE, "readFile2String(path)");
        return strE;
    }

    public final String v(String url) {
        Intrinsics.g(url, "url");
        String strE = com.cloud.tmc.miniutils.util.h.e(url);
        Intrinsics.f(strE, "encryptSHA256ToString(url)");
        return strE;
    }
}
