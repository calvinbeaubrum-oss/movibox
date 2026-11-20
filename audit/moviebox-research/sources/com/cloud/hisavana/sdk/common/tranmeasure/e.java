package com.cloud.hisavana.sdk.common.tranmeasure;

import android.view.View;
import androidx.annotation.NonNull;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.t;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CopyOnWriteArrayList<d> f29489a = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29490b = 10;

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f29491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f29492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.b f29493c;

        public a(Object obj, View view, d.b bVar) {
            this.f29491a = obj;
            this.f29492b = view;
            this.f29493c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c().b(this.f29491a).b(this.f29492b, this.f29493c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f29495a = new e();
    }

    public static e c() {
        return b.f29495a;
    }

    public final <T> d b(T t11) {
        for (d dVar : this.f29489a) {
            if (dVar != null && dVar.d(t11)) {
                z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "MeasureSessionManager have existed session");
                return dVar;
            }
        }
        z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "MeasureSession create new session");
        return new d(t11);
    }

    public void d(d dVar) {
        z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "registerSession(注册一个 需要监控的 Session)");
        if (dVar == null || this.f29489a.contains(dVar)) {
            return;
        }
        this.f29489a.add(dVar);
        if (this.f29489a.size() > 10) {
            this.f29489a.remove(0);
        }
        if (h()) {
            Monitor.getInstance().start();
        }
    }

    public <T> void e(T t11, View view, d.b<T> bVar) {
        if (t11 == null || view == null || bVar == null) {
            z.a().e(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "registerView: key or adView or listener is null");
        } else {
            t.a().b(new a(t11, view, bVar));
        }
    }

    public void f(d dVar) {
        z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "unregisterSession(注销监控)");
        if (dVar != null) {
            this.f29489a.remove(dVar);
        }
        if (h()) {
            return;
        }
        Monitor.getInstance().end();
    }

    public <T> void g(T t11) {
        if (t11 == null) {
            return;
        }
        for (d dVar : this.f29489a) {
            if (dVar != null && dVar.d(t11)) {
                z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "got existed session");
                dVar.a();
                return;
            }
        }
    }

    public final boolean h() {
        return this.f29489a.size() > 0;
    }

    public void i() {
        for (d dVar : this.f29489a) {
            if (dVar != null) {
                dVar.j();
            }
        }
    }
}
