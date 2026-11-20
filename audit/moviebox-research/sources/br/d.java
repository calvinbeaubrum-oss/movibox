package br;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.util.j;
import athena.a0;
import athena.j0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d {
    public static <E> int a(Collection<E> collection, j<E> jVar) {
        int i11 = 0;
        if (k(collection)) {
            return 0;
        }
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            if (jVar.test(it.next())) {
                i11++;
            }
        }
        return i11;
    }

    public static Boolean b(Context context, String str, boolean z11) throws IllegalArgumentException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Boolean) clsLoadClass.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(clsLoadClass, str, Boolean.valueOf(z11));
        } catch (IllegalArgumentException e11) {
            throw e11;
        } catch (Exception unused) {
            return Boolean.valueOf(z11);
        }
    }

    public static Long c(Context context, String str, long j11) throws IllegalArgumentException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Long) clsLoadClass.getMethod("getLong", String.class, Long.TYPE).invoke(clsLoadClass, str, Long.valueOf(j11));
        } catch (IllegalArgumentException e11) {
            throw e11;
        } catch (Exception unused) {
            return Long.valueOf(j11);
        }
    }

    public static String d(Collection<? extends Object> collection, String str) {
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = true;
        for (Object obj : collection) {
            if (z11) {
                z11 = false;
            } else {
                sb2.append(str);
            }
            sb2.append(obj.toString());
        }
        return sb2.toString();
    }

    public static String e(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b11 : bArr) {
            String hexString = Integer.toHexString(b11 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("appver", com.transsion.core.utils.a.b() + "");
            jSONObject.put("anver", Build.VERSION.RELEASE);
            jSONObject.put("apppkg", com.transsion.core.utils.a.a());
            jSONObject.put("gaid", j0.c());
            jSONObject.put("mcc", com.transsion.ga.g.g());
            jSONObject.put("lang", Locale.getDefault().getLanguage());
            jSONObject.put("installer", com.transsion.ga.g.d());
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
        return jSONObject;
    }

    public static void g(StringBuilder sb2, Object obj) {
        if (sb2.length() == 0) {
            sb2.append(obj);
        } else {
            sb2.append(",");
            sb2.append(obj);
        }
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (!next.contains("&")) {
                jSONObject2.put(next, obj);
            } else if (!jSONObject2.has(next)) {
                jSONObject2.put(next, obj);
            } else if (next.endsWith("&add")) {
                jSONObject2.put(next, Long.parseLong(obj.toString()) + jSONObject2.getLong(next));
            } else if (next.endsWith("&append")) {
                Object objPut = jSONObject2.get(next);
                if (objPut instanceof JSONArray) {
                    ((JSONArray) objPut).put(obj);
                } else {
                    objPut = new JSONArray().put(objPut).put(obj);
                }
                jSONObject2.put(next, objPut);
            }
        }
    }

    public static boolean i(Collection<?> collection) {
        return collection != null && collection.size() > 0;
    }

    public static byte[] j(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i11 = 0; i11 < str.length() / 2; i11++) {
            int i12 = i11 * 2;
            int i13 = i12 + 1;
            bArr[i11] = (byte) ((Integer.parseInt(str.substring(i12, i13), 16) * 16) + Integer.parseInt(str.substring(i13, i12 + 2), 16));
        }
        return bArr;
    }

    public static boolean k(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean l(Collection<?> collection) {
        return (collection == null || collection.isEmpty()) ? false : true;
    }

    public static boolean m(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }
}
