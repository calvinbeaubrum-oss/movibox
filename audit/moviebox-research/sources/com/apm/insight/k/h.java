package com.apm.insight.k;

import android.content.Context;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.n;
import com.apm.insight.runtime.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f16918a;

    private h(Context context) {
        this.f16918a = context;
    }

    public static void a(Context context) {
        n.a().a(new h(context), 0L);
    }

    public static boolean a() {
        return b.a().c() || !com.apm.insight.l.a.c(com.apm.insight.e.g());
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.apm.insight.b.f.a(this.f16918a).a().f();
        } catch (Throwable unused) {
        }
        try {
            if (com.apm.insight.l.a.c(this.f16918a)) {
                b.a().a(com.apm.insight.l.k.b(this.f16918a));
            } else {
                NativeImpl.j();
            }
            q.a().a(com.apm.insight.e.a().b(), com.apm.insight.entity.b.b());
            if (n.a().a() == null) {
            }
        } catch (Throwable th2) {
            try {
                com.apm.insight.a.b(th2);
            } finally {
                q.a().a(com.apm.insight.e.a().b(), com.apm.insight.entity.b.b());
                if (n.a().a() != null) {
                    com.apm.insight.j.d.a(n.a().a(), this.f16918a).a();
                }
            }
        }
    }
}
