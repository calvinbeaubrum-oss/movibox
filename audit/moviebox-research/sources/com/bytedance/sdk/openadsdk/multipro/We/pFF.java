package com.bytedance.sdk.openadsdk.multipro.We;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.Ol;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> f28616sc;

    private static Object pFF(Context context, String str, String str2, String str3) {
        String strSc = sc(str);
        if (!sc(context, strSc, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase("string")) {
            return sc.sc(context, strSc, str2, (String) null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(sc.sc(context, strSc, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(sc.sc(context, strSc, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(sc.sc(context, strSc, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(sc.sc(context, strSc, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return sc.sc(context, strSc, str2, (String) null);
        }
        return null;
    }

    public static void pFF(Context context, String str) {
        if (Ol.qr(str)) {
            com.bytedance.sdk.component.pFF.sc(context, str).pFF().clear().apply();
            pFF(str);
            return;
        }
        SharedPreferences sharedPreferencesSc = sc(context, str);
        if (sharedPreferencesSc == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesSc.edit();
        editorEdit.clear();
        editorEdit.apply();
        pFF(str);
    }

    public static void pFF(Context context, String str, String str2) {
        try {
            String strSc = sc.sc(str, str2);
            if (Ol.qr(strSc)) {
                com.bytedance.sdk.component.pFF.sc(context, strSc).pFF().remove(str2).apply();
                return;
            }
            SharedPreferences sharedPreferencesSc = sc(context, strSc);
            if (sharedPreferencesSc == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesSc.edit();
            editorEdit.remove(str2);
            editorEdit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f28616sc;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            Map<String, Object> map = f28616sc.get().get(sc(strSc));
            if (map != null && map.size() != 0) {
                map.remove(str2);
            }
        } catch (Throwable unused) {
        }
    }

    private static void pFF(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f28616sc;
        if (softReference == null || softReference.get() == null || (map = f28616sc.get().get(sc(str))) == null) {
            return;
        }
        map.clear();
    }

    @Nullable
    public static SharedPreferences sc(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(sc(str), 0);
        } catch (Throwable th2) {
            Tf.sc("SPMultiHelperImpl", "getSharedPreferences error ", th2.getMessage());
            return null;
        }
    }

    private static Object sc(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f28616sc;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(sc(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    public static String sc(Context context, String str, String str2, String str3) {
        Object objSc = sc(str, str2);
        if (objSc != null) {
            return String.valueOf(objSc);
        }
        Object objPFF = pFF(context, str, str2, str3);
        sc(str, str2, objPFF);
        return String.valueOf(objPFF);
    }

    private static String sc(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    public static synchronized <T> void sc(Context context, String str, String str2, T t11) {
        String strSc = sc.sc(str, str2);
        if (Ol.qr(strSc)) {
            com.bytedance.sdk.component.pFF pffSc = com.bytedance.sdk.component.pFF.sc(context, strSc);
            if (t11.equals(sc(strSc, str2))) {
                return;
            }
            com.bytedance.sdk.component.pFF.zY zYVarPFF = pffSc.pFF();
            sc(zYVarPFF, str2, (Object) t11);
            zYVarPFF.apply();
            sc(strSc, str2, t11);
            return;
        }
        SharedPreferences sharedPreferencesSc = sc(context, strSc);
        if (sharedPreferencesSc == null) {
            return;
        }
        if (t11.equals(sc(strSc, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesSc.edit();
        sc(editorEdit, str2, t11);
        editorEdit.apply();
        sc(strSc, str2, t11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void sc(SharedPreferences.Editor editor, String str, T t11) {
        if (t11 instanceof Integer) {
            editor.putInt(str, ((Integer) t11).intValue());
        }
        if (t11 instanceof Long) {
            editor.putLong(str, ((Long) t11).longValue());
        }
        if (t11 instanceof Float) {
            editor.putFloat(str, ((Float) t11).floatValue());
        }
        if (t11 instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t11).booleanValue());
        }
        if (t11 instanceof String) {
            editor.putString(str, (String) t11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void sc(com.bytedance.sdk.component.pFF.zY zYVar, String str, T t11) {
        if (t11 instanceof Integer) {
            zYVar.putInt(str, ((Integer) t11).intValue());
        }
        if (t11 instanceof Long) {
            zYVar.putLong(str, ((Long) t11).longValue());
        }
        if (t11 instanceof Float) {
            zYVar.putFloat(str, ((Float) t11).floatValue());
        }
        if (t11 instanceof Boolean) {
            zYVar.putBoolean(str, ((Boolean) t11).booleanValue());
        }
        if (t11 instanceof String) {
            zYVar.putString(str, (String) t11);
        }
    }

    private static void sc(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f28616sc;
        if (softReference == null || softReference.get() == null) {
            f28616sc = new SoftReference<>(new ConcurrentHashMap());
        }
        String strSc = sc(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = f28616sc.get();
        if (concurrentHashMap.get(strSc) == null) {
            concurrentHashMap.put(strSc, new HashMap());
        }
        concurrentHashMap.get(strSc).put(str2, obj);
    }

    public static boolean sc(Context context, String str, String str2) {
        String strSc = sc.sc(str, str2);
        if (Ol.qr(strSc)) {
            return com.bytedance.sdk.component.pFF.sc(context, strSc).sc(str2);
        }
        SharedPreferences sharedPreferencesSc = sc(context, strSc);
        return sharedPreferencesSc != null && sharedPreferencesSc.contains(str2);
    }

    public static Map<String, ?> zY(Context context, String str) {
        SharedPreferences sharedPreferencesSc = sc(context, str);
        if (sharedPreferencesSc == null) {
            return null;
        }
        return sharedPreferencesSc.getAll();
    }
}
