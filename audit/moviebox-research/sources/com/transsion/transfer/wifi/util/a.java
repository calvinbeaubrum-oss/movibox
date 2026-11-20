package com.transsion.transfer.wifi.util;

import android.annotation.SuppressLint;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f59244a = new a();

    public final int a(WifiConfiguration wifiConfig) {
        Intrinsics.g(wifiConfig, "wifiConfig");
        try {
            return wifiConfig.getClass().getDeclaredField("numAssociation").getInt(wifiConfig);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final String b(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return "OPEN";
        }
        String str2 = "WEP";
        if (!StringsKt__StringsKt.Q(str, "WEP", false, 2, null)) {
            str2 = "PSK";
            if (!StringsKt__StringsKt.Q(str, "PSK", false, 2, null) && !StringsKt__StringsKt.Q(str, "WPA", false, 2, null)) {
                str2 = "EAP";
                if (!StringsKt__StringsKt.Q(str, "EAP", false, 2, null)) {
                    str2 = "OTHER";
                    if (!StringsKt__StringsKt.Q(str, "OTHER", false, 2, null)) {
                        return "OPEN";
                    }
                }
            }
        }
        return str2;
    }

    public final boolean c(String str) {
        int length = str != null ? str.length() : 0;
        if (length != 10 && length != 26 && length != 58) {
            return false;
        }
        Intrinsics.d(str);
        return new Regex("[0-9A-Fa-f]*").matches(str);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public final void d(WifiConfiguration wifiConfig) {
        Intrinsics.g(wifiConfig, "wifiConfig");
        try {
            Field declaredField = wifiConfig.getClass().getDeclaredField("numNoInternetAccessReports");
            declaredField.setAccessible(true);
            declaredField.setInt(wifiConfig, 1);
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void e(WifiManager wifiManager, WifiConfiguration wifiConfig) {
        Intrinsics.g(wifiManager, "wifiManager");
        Intrinsics.g(wifiConfig, "wifiConfig");
        try {
            int i11 = 0;
            for (WifiConfiguration con : wifiManager.getConfiguredNetworks()) {
                a aVar = f59244a;
                Intrinsics.f(con, "con");
                int iA = aVar.a(con);
                if (iA > i11) {
                    i11 = iA;
                }
            }
            Field declaredField = wifiConfig.getClass().getDeclaredField("numAssociation");
            declaredField.setAccessible(true);
            declaredField.setInt(wifiConfig, i11);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x00dc  */
    public final void f(WifiConfiguration config, String str, String str2) {
        Intrinsics.g(config, "config");
        config.allowedAuthAlgorithms.clear();
        config.allowedGroupCiphers.clear();
        config.allowedKeyManagement.clear();
        config.allowedPairwiseCiphers.clear();
        config.allowedProtocols.clear();
        switch (b(str)) {
            case "EAP":
                config.allowedProtocols.set(1);
                config.allowedProtocols.set(0);
                config.allowedGroupCiphers.set(0);
                config.allowedGroupCiphers.set(1);
                config.allowedGroupCiphers.set(2);
                config.allowedGroupCiphers.set(3);
                config.allowedPairwiseCiphers.set(1);
                config.allowedPairwiseCiphers.set(2);
                config.allowedKeyManagement.set(2);
                config.allowedKeyManagement.set(3);
                WifiUtils wifiUtils = WifiUtils.f59242a;
                Intrinsics.d(str2);
                config.preSharedKey = wifiUtils.c(str2);
                break;
            case "PSK":
                config.hiddenSSID = true;
                config.allowedAuthAlgorithms.set(0);
                config.allowedProtocols.set(1);
                config.allowedProtocols.set(0);
                config.allowedKeyManagement.set(1);
                config.allowedPairwiseCiphers.set(2);
                config.allowedPairwiseCiphers.set(1);
                config.allowedGroupCiphers.set(0);
                config.allowedGroupCiphers.set(1);
                config.allowedGroupCiphers.set(3);
                config.allowedGroupCiphers.set(2);
                WifiUtils wifiUtils2 = WifiUtils.f59242a;
                Intrinsics.d(str2);
                config.preSharedKey = wifiUtils2.c(str2);
                config.status = 2;
                break;
            case "WEP":
                config.hiddenSSID = true;
                config.wepTxKeyIndex = 0;
                config.allowedKeyManagement.set(0);
                config.allowedAuthAlgorithms.set(1);
                config.allowedPairwiseCiphers.set(2);
                config.allowedPairwiseCiphers.set(1);
                config.allowedGroupCiphers.set(0);
                config.allowedGroupCiphers.set(1);
                config.status = 2;
                if (!f59244a.c(str2)) {
                    String[] strArr = config.wepKeys;
                    WifiUtils wifiUtils3 = WifiUtils.f59242a;
                    Intrinsics.d(str2);
                    strArr[0] = wifiUtils3.c(str2);
                } else {
                    config.wepKeys[0] = str2;
                }
                break;
            case "OPEN":
                config.allowedKeyManagement.set(0);
                break;
            default:
                StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                String str3 = String.format("\"%s\"", Arrays.copyOf(new Object[]{str2}, 1));
                Intrinsics.f(str3, "format(...)");
                config.preSharedKey = str3;
                break;
        }
        config.status = 2;
    }

    public final int g(WifiManager wifiManager, WifiConfiguration config) {
        Intrinsics.g(wifiManager, "wifiManager");
        Intrinsics.g(config, "config");
        a aVar = f59244a;
        aVar.e(wifiManager, config);
        aVar.d(config);
        return wifiManager.updateNetwork(config);
    }
}
