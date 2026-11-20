package com.bytedance.sdk.component.TRI.sc.sc.sc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {
    public static int sc(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                return sc.sc(context).sc().sc(str, contentValues, str2, strArr);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static int sc(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return sc.sc(context).sc().sc(str, str2, strArr);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static Cursor sc(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return sc.sc(context).sc().sc(str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void sc(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            sc.sc(context).sc().sc(Uri.decode(str));
        } catch (Throwable unused) {
        }
    }

    public static void sc(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            sc.sc(context).sc().sc(str, (String) null, contentValues);
        } catch (Throwable unused) {
        }
    }

    public static void sc(Context context, String str, List<com.bytedance.sdk.component.TRI.sc.We.sc> list) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            sc.sc(context).sc().sc(str, (String) null, list);
        } catch (Throwable unused) {
        }
    }
}
