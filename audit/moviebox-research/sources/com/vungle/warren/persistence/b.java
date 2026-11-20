package com.vungle.warren.persistence;

import android.content.ContentValues;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {
    public static boolean a(ContentValues contentValues, String str) {
        Object obj = contentValues.get(str);
        if (obj == null) {
            return false;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            if (obj instanceof CharSequence) {
                return Boolean.valueOf(obj.toString()).booleanValue() || "1".equals(obj);
            }
            return (obj instanceof Number) && ((Number) obj).intValue() != 0;
        }
    }
}
