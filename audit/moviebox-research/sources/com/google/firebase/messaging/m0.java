package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class m0 {
    public static SharedPreferences a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    public static boolean b(Context context) {
        return a(context).getBoolean("proxy_notification_initialized", false);
    }

    public static void c(Context context, boolean z11) {
        SharedPreferences.Editor editorEdit = a(context).edit();
        editorEdit.putBoolean("proxy_notification_initialized", z11);
        editorEdit.apply();
    }
}
