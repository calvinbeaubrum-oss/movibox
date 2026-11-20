package com.apm.insight.b;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f16648a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static g f16649c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f16650b;

    private f(@NonNull Context context) {
        this.f16650b = new b(context);
        g gVar = new g();
        f16649c = gVar;
        gVar.a();
    }

    public static f a(Context context) {
        if (f16648a == null) {
            synchronized (f.class) {
                try {
                    if (f16648a == null) {
                        f16648a = new f(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f16648a;
    }

    public static g b() {
        return f16649c;
    }

    public final b a() {
        return this.f16650b;
    }

    public final void c() {
        this.f16650b.a();
    }

    public final void d() {
        this.f16650b.b();
    }
}
