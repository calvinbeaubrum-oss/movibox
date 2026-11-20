package com.transsion.infra.gateway.core.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f52916a;

    public static Context a() {
        Context context = f52916a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("u should init first");
    }

    public static void b(@NonNull Context context) {
        if (f52916a != null) {
            return;
        }
        f52916a = context.getApplicationContext();
    }
}
