package com.cloud.tmc.integration.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.intf.ISDKConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
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
public class k {
    public final void a(Intent intent, Context context) {
        Intrinsics.g(intent, "<this>");
        intent.setPackage(context != null ? context.getPackageName() : null);
    }

    public final void b(Context context, String str, String str2, boolean z11) {
        Intrinsics.g(context, "context");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        if (str != null) {
            kVStorageProxy.putBoolean(context, str, str2 + "_tar", z11);
        }
    }

    public final synchronized void c(Context context, String str, String str2, boolean z11) {
        Intrinsics.g(context, "context");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        if (str != null) {
            kVStorageProxy.putBoolean(context, str, str2 + "_download", z11);
        }
    }

    public final void d(Context context, String str, String str2, boolean z11) {
        Intrinsics.g(context, "context");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        if (str != null) {
            kVStorageProxy.putBoolean(context, str, str2 + "_zip", z11);
        }
    }

    public final synchronized boolean e(Context context, String str, String str2) {
        boolean z11;
        Intrinsics.g(context, "context");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        z11 = false;
        if (str != null) {
            z11 = kVStorageProxy.getBoolean(context, str, str2 + "_download", false);
        }
        return z11;
    }

    public final boolean f(Context context, String str, String str2) {
        Intrinsics.g(context, "context");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        if (str == null) {
            return false;
        }
        return kVStorageProxy.getBoolean(context, str, str2 + "_zip", false);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x013f A[Catch: all -> 0x013b, TryCatch #3 {all -> 0x013b, blocks: (B:4:0x000d, B:8:0x0039, B:11:0x004b, B:14:0x005d, B:22:0x0111, B:26:0x0129, B:28:0x0137, B:21:0x00f9, B:32:0x013f, B:33:0x0147, B:35:0x014d, B:38:0x015c, B:15:0x00dc, B:18:0x00e5), top: B:49:0x000d, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x014d A[Catch: all -> 0x013b, TryCatch #3 {all -> 0x013b, blocks: (B:4:0x000d, B:8:0x0039, B:11:0x004b, B:14:0x005d, B:22:0x0111, B:26:0x0129, B:28:0x0137, B:21:0x00f9, B:32:0x013f, B:33:0x0147, B:35:0x014d, B:38:0x015c, B:15:0x00dc, B:18:0x00e5), top: B:49:0x000d, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x015c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x015b A[SYNTHETIC] */
    public final Map<String, String> g(Map<String, String> map, boolean z11) {
        String packageName;
        String str;
        String str2 = "0000-0000-0000-0000";
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (z11) {
            try {
                String country = Locale.getDefault().getCountry();
                Intrinsics.f(country, "getDefault().country");
                linkedHashMap.put("m-country-alpha2", country);
                linkedHashMap.put("m-os", "android");
                String appVersion = ((ISDKConfig) tc.a.a(ISDKConfig.class)).getAppVersion();
                String strT = "";
                if (appVersion == null) {
                    appVersion = "";
                }
                linkedHashMap.put("m-app-ver", appVersion);
                String frameworkVersion = ((IPackageConfig) tc.a.a(IPackageConfig.class)).getFrameworkVersion();
                if (frameworkVersion == null) {
                    frameworkVersion = "";
                }
                linkedHashMap.put("m-fw-ver", frameworkVersion);
                String sDKVersion = ((IPackageConfig) tc.a.a(IPackageConfig.class)).getSDKVersion();
                if (sDKVersion == null) {
                    sDKVersion = "";
                }
                linkedHashMap.put("m-mnsdk-ver", sDKVersion);
                linkedHashMap.put("m-mcc", h());
                linkedHashMap.put("m-mnc", i());
                String strK = NetworkUtil.k(NetworkUtil.f(com.cloud.tmc.miniutils.util.e0.a(), true));
                Intrinsics.f(strK, "transferNetworkType(currentNetworkType)");
                linkedHashMap.put("m-nettype", strK);
                String language = Locale.getDefault().getLanguage();
                Intrinsics.f(language, "getDefault().language");
                linkedHashMap.put("m-language", language);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Build.MANUFACTURER);
                sb2.append(' ');
                String MODEL = Build.MODEL;
                sb2.append(MODEL);
                linkedHashMap.put("m-phone-model", sb2.toString());
                Intrinsics.f(MODEL, "MODEL");
                linkedHashMap.put("m-device-model", MODEL);
                String strH = com.cloud.tmc.miniutils.util.g.h(((IPackageConfig) tc.a.a(IPackageConfig.class)).getAppId());
                Intrinsics.f(strH, "urlEncode(TmcProxy.get(I…onfig::class.java).appId)");
                linkedHashMap.put("m-app", strH);
                try {
                    if (!q.f31091a.j()) {
                        String vaid = ((ReportProxy) tc.a.a(ReportProxy.class)).getVaid();
                        Intrinsics.f(vaid, "{\n                      …aid\n                    }");
                        str2 = vaid;
                    }
                } catch (Throwable th2) {
                    TmcLogger.f("CommonHeader", "just print get vaid failed. errMsg: " + th2.getMessage());
                }
                linkedHashMap.put("m-vaid", str2);
                linkedHashMap.put("m-mini-sdk-mode", AppDynamicBuildConfig.r());
                try {
                    packageName = com.cloud.tmc.miniutils.util.e0.a().getPackageName();
                } catch (Throwable unused) {
                    packageName = "";
                }
                Intrinsics.f(packageName, "try {\n                  …     \"\"\n                }");
                linkedHashMap.put("m-app-pkg", packageName);
                try {
                    strT = AppDynamicBuildConfig.t();
                } catch (Throwable unused2) {
                }
                linkedHashMap.put("m-mnsdk-num", strT);
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        str = map.get(str3);
                        if (str == null) {
                            linkedHashMap.put(str3, str);
                        }
                    }
                }
            } catch (Throwable th3) {
                TmcLogger.h("CommonHeader", th3);
            }
        } else if (map != null) {
            while (r9.hasNext()) {
                str = map.get(str3);
                if (str == null) {
                    linkedHashMap.put(str3, str);
                }
            }
        }
        return linkedHashMap;
    }

    public final String h() {
        String strSubstring;
        String strJ = j();
        if (TextUtils.isEmpty(strJ) || strJ == null || strJ.length() < 3) {
            strSubstring = "";
        } else if (strJ != null) {
            strSubstring = strJ.substring(0, 3);
            Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            strSubstring = null;
        }
        return strSubstring == null ? "" : strSubstring;
    }

    public final String i() {
        String strSubstring;
        String strJ = j();
        if (TextUtils.isEmpty(strJ) || strJ == null || strJ.length() < 3) {
            strSubstring = "";
        } else if (strJ != null) {
            strSubstring = strJ.substring(3);
            Intrinsics.f(strSubstring, "this as java.lang.String).substring(startIndex)");
        } else {
            strSubstring = null;
        }
        return strSubstring == null ? "" : strSubstring;
    }

    public final String j() {
        try {
            Object systemService = com.cloud.tmc.miniutils.util.e0.a().getSystemService("phone");
            TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public final boolean k(int i11) {
        return i11 == MiniAppType.SHELL.getType() || i11 == MiniAppType.SHELL_GAME.getType();
    }

    public final boolean l(AppModel appModel) {
        if (appModel != null) {
            return appModel.getAppinfoCategoryType() == MiniAppType.SHELL.getType() || appModel.getAppinfoCategoryType() == MiniAppType.SHELL_GAME.getType();
        }
        return false;
    }
}
