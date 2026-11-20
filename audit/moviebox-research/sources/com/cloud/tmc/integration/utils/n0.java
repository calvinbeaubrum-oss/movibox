package com.cloud.tmc.integration.utils;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f31078a = new n0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f31079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f31080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f31081d;

    static {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        f31079b = concurrentHashMap;
        ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<>();
        f31080c = concurrentHashMap2;
        String[] strArr = {"%2B", com.cloud.tmc.miniutils.util.g.h("miniSymbol_01"), "+", "%20", com.cloud.tmc.miniutils.util.g.h("miniSymbol_02"), " "};
        f31081d = strArr;
        String str = strArr[0];
        Intrinsics.f(str, "symbol_plus[0]");
        String str2 = strArr[1];
        Intrinsics.f(str2, "symbol_plus[1]");
        concurrentHashMap.put(str, str2);
        String str3 = strArr[1];
        Intrinsics.f(str3, "symbol_plus[1]");
        String str4 = strArr[2];
        Intrinsics.f(str4, "symbol_plus[2]");
        concurrentHashMap2.put(str3, str4);
        String str5 = strArr[3];
        Intrinsics.f(str5, "symbol_plus[3]");
        String str6 = strArr[4];
        Intrinsics.f(str6, "symbol_plus[4]");
        concurrentHashMap2.put(str5, str6);
        String str7 = strArr[4];
        Intrinsics.f(str7, "symbol_plus[4]");
        String str8 = strArr[5];
        Intrinsics.f(str8, "symbol_plus[5]");
        concurrentHashMap2.put(str7, str8);
    }

    @JvmStatic
    public static final boolean h(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    String string = StringsKt__StringsKt.Z0(str).toString();
                    return kotlin.text.l.L(string, "http://", false, 2, null) || kotlin.text.l.L(string, AgentPageJsBridge.HTTPS, false, 2, null);
                }
            } catch (Throwable th2) {
                TmcLogger.g("UrlUtil", "Invalid url", th2);
            }
        }
        return false;
    }

    public final String a(String key) {
        String str;
        Intrinsics.g(key, "key");
        ConcurrentHashMap<String, String> concurrentHashMap = f31080c;
        String str2 = "";
        if (concurrentHashMap.containsKey(key) && (str = concurrentHashMap.get(key)) != null) {
            str2 = str;
        }
        TmcLogger.c("seven", "[convertDecodeSymbol] -> key:" + key + ", ret:" + str2);
        return str2;
    }

    public final String b(String key) {
        String str;
        Intrinsics.g(key, "key");
        ConcurrentHashMap<String, String> concurrentHashMap = f31079b;
        String str2 = "";
        if (concurrentHashMap.containsKey(key) && (str = concurrentHashMap.get(key)) != null) {
            str2 = str;
        }
        TmcLogger.c("seven", "[convertEncodeSymbol] -> key:" + key + ", ret:" + str2);
        return str2;
    }

    public final String c(String orginalUrl, boolean z11) {
        Intrinsics.g(orginalUrl, "orginalUrl");
        TmcLogger.c("seven", "[fixEncodeUrl] -> orginalUrl:" + orginalUrl);
        if (!z11) {
            return orginalUrl;
        }
        try {
            String[] strArr = f31081d;
            String str = strArr[0];
            Intrinsics.f(str, "symbol_plus[0]");
            String str2 = strArr[0];
            Intrinsics.f(str2, "symbol_plus[0]");
            orginalUrl = kotlin.text.l.F(orginalUrl, str, b(str2), false, 4, null);
            TmcLogger.c("seven", "[fixEncodeUrl] -> fixUrl:" + orginalUrl);
            return orginalUrl;
        } catch (Throwable unused) {
            return orginalUrl;
        }
    }

    public final String d(String orginalUrl, boolean z11) {
        Intrinsics.g(orginalUrl, "orginalUrl");
        try {
            TmcLogger.c("seven", "[getFixDecodeUrl] -> orginalUrl:" + orginalUrl);
            if (!z11) {
                return orginalUrl;
            }
            String[] strArr = f31081d;
            String str = strArr[1];
            Intrinsics.f(str, "symbol_plus[1]");
            String str2 = strArr[1];
            Intrinsics.f(str2, "symbol_plus[1]");
            orginalUrl = kotlin.text.l.F(orginalUrl, str, a(str2), false, 4, null);
            TmcLogger.c("seven", "[getFixDecodeUrl] -> fixUrl:" + orginalUrl);
            return orginalUrl;
        } catch (Throwable unused) {
            return orginalUrl;
        }
    }

    public final Map<String, String> e(String str) {
        HashMap map = new HashMap();
        String strG = g(str);
        if (strG == null) {
            return map;
        }
        Iterator itA = ArrayIteratorKt.a((String[]) new Regex("[&]").split(strG, 0).toArray(new String[0]));
        while (itA.hasNext()) {
            String[] strArr = (String[]) new Regex("[=]").split((String) itA.next(), 0).toArray(new String[0]);
            if (strArr.length > 1) {
                map.put(strArr[0], strArr[1]);
            } else {
                String str2 = strArr[0];
                if (str2 != "") {
                    map.put(str2, "");
                }
            }
        }
        return map;
    }

    public final String f(String key, String url) {
        Intrinsics.g(key, "key");
        Intrinsics.g(url, "url");
        Map<String, String> mapE = e(url);
        if (mapE == null || mapE.isEmpty()) {
            return "";
        }
        String str = mapE.get(key);
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public final String g(String str) {
        String string;
        String str2;
        List<String> listSplit;
        if (str != null) {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = Intrinsics.i(str.charAt(!z11 ? i11 : length), 32) <= 0;
                if (z11) {
                    if (!z12) {
                        break;
                    }
                    length--;
                } else if (z12) {
                    i11++;
                } else {
                    z11 = true;
                }
            }
            string = str.subSequence(i11, length + 1).toString();
        } else {
            string = null;
        }
        String[] strArr = (string == null || (listSplit = new Regex("[?]").split(string, 0)) == null) ? null : (String[]) listSplit.toArray(new String[0]);
        if (string == null || string.length() <= 1 || strArr == null || strArr.length <= 1 || (str2 = strArr[1]) == null) {
            return null;
        }
        return str2;
    }
}
