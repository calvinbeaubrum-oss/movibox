package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class v0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference<v0> f40939d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f40940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s0 f40941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f40942c;

    public v0(SharedPreferences sharedPreferences, Executor executor) {
        this.f40942c = executor;
        this.f40940a = sharedPreferences;
    }

    public static synchronized v0 a(Context context, Executor executor) {
        v0 v0Var;
        try {
            WeakReference<v0> weakReference = f40939d;
            v0Var = weakReference != null ? weakReference.get() : null;
            if (v0Var == null) {
                v0Var = new v0(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                v0Var.c();
                f40939d = new WeakReference<>(v0Var);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return v0Var;
    }

    @Nullable
    public synchronized u0 b() {
        return u0.a(this.f40941b.e());
    }

    public final synchronized void c() {
        this.f40941b = s0.c(this.f40940a, "topic_operation_queue", ",", this.f40942c);
    }

    public synchronized boolean d(u0 u0Var) {
        return this.f40941b.f(u0Var.e());
    }
}
