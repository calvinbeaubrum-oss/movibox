package com.cloud.tmc.integration.utils;

import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
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
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f31133a = new v();

    public final String a(String vurl) {
        MatchGroupCollection matchGroupCollectionC;
        MatchGroup matchGroup;
        String strA;
        Intrinsics.g(vurl, "vurl");
        try {
            MatchResult matchResultFind$default = Regex.find$default(new Regex("https://(.*?).miniapp.transsion.com"), vurl, 0, 2, null);
            return (matchResultFind$default == null || (matchGroupCollectionC = matchResultFind$default.c()) == null || (matchGroup = matchGroupCollectionC.get(1)) == null || (strA = matchGroup.a()) == null) ? "" : strA;
        } catch (Throwable th2) {
            TmcLogger.h("FilePathUtils", th2);
            return "";
        }
    }

    public final boolean b(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(((IApplicationContextGetter) tc.a.a(IApplicationContextGetter.class)).getApplicationContext(), str, str + "_scan_downgrade", false);
                }
            } catch (Throwable th2) {
                TmcLogger.h("FilePathUtils", th2);
            }
        }
        return true;
    }

    public final boolean c() {
        return MiniAppConfigHelper.f30370a.b("downgradeScanFile", false);
    }

    public final String d(String str, String str2) {
        if (b(str)) {
            TmcLogger.f("FilePathUtils", "appId=" + str + " downgrade status is true.");
            return null;
        }
        String strD = com.cloud.tmc.kernel.utils.r.d(str2);
        if (str == null || str.length() == 0 || strD == null || strD.length() == 0) {
            TmcLogger.f("FilePathUtils", "appId=" + str + " or vUrl=" + strD + " is invalid.");
            return null;
        }
        String str3 = AgentPageJsBridge.HTTPS + str + ".miniapp.transsion.com/temp_data";
        if (kotlin.text.l.L(strD, str3, false, 2, null)) {
            String strG = kotlin.text.l.G(strD, str3, ((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(str) + File.separator + "temp_data", true);
            TmcLogger.c("FilePathUtils", strD + " ======> " + strG);
            return strG;
        }
        String str4 = AgentPageJsBridge.HTTPS + str + ".miniapp.transsion.com/local_data";
        if (!kotlin.text.l.L(strD, str4, false, 2, null)) {
            return null;
        }
        String strG2 = kotlin.text.l.G(strD, str4, ((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(str) + File.separator + "local_data", true);
        TmcLogger.c("FilePathUtils", strD + " ======> " + strG2);
        return strG2;
    }
}
