package com.transsion.core.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static File a(Context context) {
        try {
            Field declaredField = Environment.class.getDeclaredField("sUserRequired");
            declaredField.setAccessible(true);
            if (declaredField.getBoolean(new Environment())) {
                return null;
            }
            try {
                return context.getExternalCacheDir();
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
