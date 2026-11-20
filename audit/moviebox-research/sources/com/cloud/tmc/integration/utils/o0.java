package com.cloud.tmc.integration.utils;

import android.text.TextUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy;
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
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f31090a = new o0();

    public final boolean a(String newVersion, String oldVersion) {
        int iCharAt;
        int iCharAt2;
        Intrinsics.g(newVersion, "newVersion");
        Intrinsics.g(oldVersion, "oldVersion");
        try {
            if (TextUtils.isEmpty(oldVersion)) {
                return true;
            }
            String miniAppVersion = ((IConfigStrategyProxy) tc.a.a(IConfigStrategyProxy.class)).getMiniAppVersion(newVersion);
            String miniAppVersion2 = ((IConfigStrategyProxy) tc.a.a(IConfigStrategyProxy.class)).getMiniAppVersion(oldVersion);
            int length = miniAppVersion.length();
            int length2 = miniAppVersion2.length();
            int i11 = 0;
            int i12 = 0;
            do {
                if (i11 < length || i12 < length2) {
                    iCharAt = 0;
                    while (i11 < length && miniAppVersion.charAt(i11) != '.') {
                        iCharAt = ((iCharAt * 10) + miniAppVersion.charAt(i11)) - 48;
                        i11++;
                    }
                    i11++;
                    iCharAt2 = 0;
                    while (i12 < length2 && miniAppVersion2.charAt(i12) != '.') {
                        iCharAt2 = ((iCharAt2 * 10) + miniAppVersion2.charAt(i12)) - 48;
                        i12++;
                    }
                    i12++;
                }
            } while (iCharAt == iCharAt2);
            return iCharAt > iCharAt2;
        } catch (Throwable th2) {
            TmcLogger.g("compareVersion", "compareVersion error", th2);
        }
        return false;
    }

    public final boolean b(String oldVersion, String str) {
        Intrinsics.g(oldVersion, "oldVersion");
        if (str == null) {
            str = "";
        }
        return a(str, oldVersion);
    }

    public final boolean c(String newVersion, String oldVersion) {
        Intrinsics.g(newVersion, "newVersion");
        Intrinsics.g(oldVersion, "oldVersion");
        return a(kotlin.text.l.F(newVersion, "-offline", "", false, 4, null), kotlin.text.l.F(oldVersion, "-offline", "", false, 4, null));
    }
}
