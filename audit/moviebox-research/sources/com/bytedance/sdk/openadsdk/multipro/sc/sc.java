package com.bytedance.sdk.openadsdk.multipro.sc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.TRI.sc.TRI;
import com.bytedance.sdk.openadsdk.core.ExN;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.multipro.We;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private static final ConcurrentHashMap<String, Object> pFF = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static TRI f28654sc;

    public static int sc(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            synchronized (sc(str)) {
                try {
                    try {
                        if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                            return ExN.sc(context).sc().sc(str, contentValues, str2, strArr);
                        }
                        TRI triSc = sc(context);
                        if (triSc != null) {
                            return triSc.sc(Uri.parse(sc() + str), contentValues, str2, strArr);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return 0;
    }

    public static int sc(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (sc(str)) {
            try {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                        return ExN.sc(context).sc().sc(str, str2, strArr);
                    }
                    TRI triSc = sc(context);
                    if (triSc != null) {
                        return triSc.sc(Uri.parse(sc() + str), str2, strArr);
                    }
                    return 0;
                } catch (Throwable th2) {
                    throw th2;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0009 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0002, B:4:0x0005, B:6:0x0009, B:8:0x000f, B:9:0x001f), top: B:14:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x000f A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0002, B:4:0x0005, B:6:0x0009, B:8:0x000f, B:9:0x001f), top: B:14:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x001f A[Catch: all -> 0x0026, TRY_LEAVE, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0002, B:4:0x0005, B:6:0x0009, B:8:0x000f, B:9:0x001f), top: B:14:0x0002 }] */
    public static TRI sc(Context context) {
        if (context == null) {
            try {
                Xc.sc();
                if (f28654sc == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                        f28654sc = TRI.sc.sc(com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc().sc(5));
                    } else {
                        f28654sc = com.bytedance.sdk.openadsdk.multipro.aidl.sc.TRI.pFF();
                    }
                }
            } catch (Throwable unused) {
                cJ.Qj("binder error");
            }
        } else if (f28654sc == null) {
            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                f28654sc = TRI.sc.sc(com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc().sc(5));
            } else {
                f28654sc = com.bytedance.sdk.openadsdk.multipro.aidl.sc.TRI.pFF();
            }
        }
        return f28654sc;
    }

    private static Object sc(String str) {
        Object obj;
        ConcurrentHashMap<String, Object> concurrentHashMap = pFF;
        Object obj2 = concurrentHashMap.get(str);
        if (obj2 != null) {
            return obj2;
        }
        synchronized (sc.class) {
            try {
                obj = concurrentHashMap.get(str);
                if (obj == null) {
                    obj = new Object();
                    concurrentHashMap.put(str, obj);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return obj;
    }

    private static String sc() {
        return We.pFF + "/t_db/ttopensdk.db/";
    }

    public static Map<String, List<String>> sc(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (sc(str)) {
            try {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                        return sc(ExN.sc(context).sc().sc(str, strArr, str2, strArr2, str3, str4, str5));
                    }
                    TRI triSc = sc(context);
                    if (triSc != null) {
                        return triSc.sc(Uri.parse(sc() + str), strArr, str2, strArr2, str5);
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Map<String, List<String>> sc(Cursor cursor) {
        HashMap map = new HashMap();
        if (cursor != null) {
            try {
                String[] columnNames = cursor.getColumnNames();
                while (cursor.getCount() > 0 && cursor.moveToNext()) {
                    for (String str : columnNames) {
                        if (!map.containsKey(str)) {
                            map.put(str, new LinkedList());
                        }
                        ((List) map.get(str)).add(cursor.getString(cursor.getColumnIndex(str)));
                    }
                }
            } catch (Throwable unused) {
            }
            cursor.close();
        }
        return map;
    }

    public static void sc(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (sc(str)) {
            try {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                        ExN.sc(context).sc().sc(str, (String) null, contentValues);
                        return;
                    }
                    TRI triSc = sc(context);
                    if (triSc != null) {
                        triSc.sc(Uri.parse(sc() + str), contentValues);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } catch (Throwable unused) {
            }
        }
    }
}
