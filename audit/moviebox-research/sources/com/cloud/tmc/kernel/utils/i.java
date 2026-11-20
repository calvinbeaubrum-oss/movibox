package com.cloud.tmc.kernel.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
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
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f31287a = new i();

    @JvmStatic
    public static final String b(String str, Bundle bundle) {
        StringBuilder sb2;
        String str2;
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("原链接：");
            sb3.append(str);
            sb3.append(", startParams:");
            sb3.append(bundle != null ? Integer.valueOf(bundle.hashCode()) : null);
            TmcLogger.c("KUrlUtils", sb3.toString());
            String strL = r.l(str);
            if (strL == null) {
                strL = "";
            }
            String strG = r.g(str);
            if (strG == null) {
                strG = "";
            }
            String strI = r.i(str);
            if (strI == null) {
                strI = "";
            }
            int iJ = r.j(str);
            String strK = r.k(str);
            if (strK == null) {
                strK = "";
            }
            TmcLogger.c("KUrlUtils", "originQuery ->" + strK);
            if (strL.length() != 0 && strG.length() != 0 && strI.length() != 0) {
                if (iJ != -1) {
                    sb2 = new StringBuilder(strL + "://" + strG + ':' + iJ);
                } else {
                    sb2 = new StringBuilder(strL + "://" + strG);
                }
                String string = bundle != null ? bundle.getString("h5Path") : null;
                if (string == null) {
                    string = "";
                }
                TmcLogger.c("KUrlUtils", "H5Path 真实地址：" + string);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("H5PathCopy 真实地址：");
                sb4.append(bundle != null ? bundle.getString("h5PathCopy") : null);
                TmcLogger.c("KUrlUtils", sb4.toString());
                List listE0 = StringsKt__StringsKt.E0(string, new String[]{"?"}, false, 0, 6, null);
                if (listE0.size() == 2) {
                    string = (String) listE0.get(0);
                    str2 = (String) listE0.get(1);
                } else {
                    str2 = "";
                }
                String strA = f31287a.a(str, bundle, str2);
                TmcLogger.c("KUrlUtils", "H5Path 解析后地址：" + string);
                if (string.length() > 0) {
                    if (bundle != null) {
                        String string2 = bundle.getString("h5Path");
                        if (string2 == null) {
                            string2 = "";
                        }
                        bundle.putString("h5PathCopy", string2);
                    }
                    if (bundle != null) {
                        bundle.remove("h5Path");
                    }
                    if (kotlin.text.l.L(string, "/", false, 2, null)) {
                        sb2.append(string);
                    } else {
                        sb2.append('/' + string);
                    }
                } else {
                    TmcLogger.c("KUrlUtils", "originPath ->" + strI);
                    if (kotlin.text.l.L(strI, "/", false, 2, null)) {
                        sb2.append(strI);
                    } else {
                        sb2.append('/' + strI);
                    }
                }
                if (strA != null) {
                    strK = strA;
                }
                TmcLogger.c("KUrlUtils", "baseUrl->" + ((Object) sb2));
                TmcLogger.c("KUrlUtils", "realQuery ->" + strK);
                if (!TextUtils.isEmpty(strK)) {
                    sb2.append("?");
                    sb2.append(strK);
                }
                String string3 = sb2.toString();
                Intrinsics.f(string3, "baseUrl.toString()");
                TmcLogger.c("KUrlUtils", "新链接：" + string3);
                return string3;
            }
            TmcLogger.c("KUrlUtils", "原链接检查到 scheme: " + strL + " and originHost: " + strG + " and originPath: " + strI + " 含有 empty 内容");
            return str == null ? "" : str;
        } catch (Throwable th2) {
            TmcLogger.g("KUrlUtils", "Error generateShellUrl failed!", th2);
            return str == null ? "" : str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:44:0x010a  */
    /* JADX WARN: Code duplicated, block: B:49:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    public final String a(String str, Bundle bundle, String str2) {
        String str3;
        List listE0;
        LinkedHashMap linkedHashMap;
        int size;
        int i11;
        List listE1;
        String string;
        String str4 = str2;
        String string2 = bundle != null ? bundle.getString("query") : null;
        if (string2 == null) {
            string2 = "";
        }
        TmcLogger.c("KUrlUtils", "Query 参数：" + string2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("QueryCopy 参数：");
        sb2.append(bundle != null ? bundle.getString("queryCopy") : null);
        TmcLogger.c("KUrlUtils", sb2.toString());
        TmcLogger.c("KUrlUtils", "h5PathQuery 参数：" + str4);
        if (string2.length() <= 0 || str2.length() <= 0) {
            if (string2.length() != 0 || str2.length() <= 0) {
                str3 = string2;
            }
            TmcLogger.c("KUrlUtils", "组装后Query 参数：" + str3);
            if (str3.length() > 0) {
                return null;
            }
            if (bundle != null) {
                string = bundle.getString("query");
                if (string == null) {
                    string = "";
                }
                bundle.putString("queryCopy", string);
            }
            if (bundle != null) {
                bundle.remove("query");
            }
            listE0 = StringsKt__StringsKt.E0(str3, new String[]{"&"}, false, 0, 6, null);
            linkedHashMap = new LinkedHashMap();
            size = listE0.size();
            for (i11 = 0; i11 < size; i11++) {
                listE1 = StringsKt__StringsKt.E0((CharSequence) listE0.get(i11), new String[]{"="}, false, 0, 6, null);
                if (listE1.size() == 2) {
                    linkedHashMap.put((String) listE1.get(0), (String) listE1.get(1));
                }
            }
            String strC = r.c(str, linkedHashMap, true);
            return r.k(strC != null ? strC : "");
        }
        str4 = str4 + '&' + string2;
        str3 = str4;
        TmcLogger.c("KUrlUtils", "组装后Query 参数：" + str3);
        if (str3.length() > 0) {
            return null;
        }
        if (bundle != null) {
            string = bundle.getString("query");
            if (string == null) {
                string = "";
            }
            bundle.putString("queryCopy", string);
        }
        if (bundle != null) {
            bundle.remove("query");
        }
        listE0 = StringsKt__StringsKt.E0(str3, new String[]{"&"}, false, 0, 6, null);
        linkedHashMap = new LinkedHashMap();
        size = listE0.size();
        while (i11 < size) {
            listE1 = StringsKt__StringsKt.E0((CharSequence) listE0.get(i11), new String[]{"="}, false, 0, 6, null);
            if (listE1.size() == 2) {
                linkedHashMap.put((String) listE1.get(0), (String) listE1.get(1));
            }
        }
        String strC2 = r.c(str, linkedHashMap, true);
        return r.k(strC2 != null ? strC2 : "");
    }
}
