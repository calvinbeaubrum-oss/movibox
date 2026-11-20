package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f44680a = "j";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f44681b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f44683d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ExecutorService f44685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.net.stack.b f44686g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<i> f44682c = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicInteger f44684e = new AtomicInteger();

    public j(Context context) {
        a();
        this.f44681b = context.getApplicationContext();
        this.f44683d = new d(new Handler(Looper.getMainLooper()));
    }

    public j(Context context, com.mbridge.msdk.foundation.same.net.stack.b bVar) {
        this.f44686g = bVar;
        a();
        this.f44681b = context.getApplicationContext();
        this.f44683d = new d(new Handler(Looper.getMainLooper()));
    }

    private void a() {
        af afVarA = af.a();
        if (!afVarA.a("c_v_r_q_t", true)) {
            this.f44685f = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardPolicy());
            return;
        }
        try {
            this.f44685f = new ThreadPoolExecutor(afVarA.a("v_r_q_c_s", 10), afVarA.a("v_r_q_m_s", 25), afVarA.a("v_r_q_c_t", 15), TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        } catch (Exception unused) {
            this.f44685f = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardPolicy());
        }
    }

    public final void a(final i iVar) {
        iVar.a(this);
        synchronized (this) {
            this.f44682c.add(iVar);
        }
        iVar.b(this.f44684e.incrementAndGet());
        ad.c(f44680a, "add-to-queue request=" + iVar.s());
        this.f44685f.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.j.1
            @Override // java.lang.Runnable
            public final void run() {
                if (j.this.f44686g == null) {
                    new h(j.this.f44683d).a(iVar);
                } else {
                    new h(j.this.f44683d, j.this.f44686g).a(iVar);
                }
            }
        });
    }

    public final void b(i iVar) {
        synchronized (this) {
            this.f44682c.remove(iVar);
        }
    }
}
