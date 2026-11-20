package com.mbridge.msdk.e;

import android.util.Log;
import com.mbridge.msdk.e.a.z;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private q f43908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f43909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f43910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v f43911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f43912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.e.a.q f43913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Executor f43914g;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements com.mbridge.msdk.e.a.r.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f43916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final s f43917b;

        public a(q qVar, s sVar) {
            this.f43916a = qVar;
            this.f43917b = sVar;
        }

        @Override // com.mbridge.msdk.e.a.r.a
        public final void a(z zVar) {
            if (y.b(this.f43916a)) {
                try {
                    this.f43916a.a(this.f43917b, 0, zVar.getMessage());
                } catch (Exception e11) {
                    if (com.mbridge.msdk.e.a.f43738a) {
                        Log.e("TrackManager", "onErrorResponse error", e11);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements com.mbridge.msdk.e.a.r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f43918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final s f43919b;

        public b(q qVar, s sVar) {
            this.f43918a = qVar;
            this.f43919b = sVar;
        }

        @Override // com.mbridge.msdk.e.a.r.b
        public final void a(Object obj) {
            if (y.b(this.f43918a)) {
                try {
                    this.f43918a.a(this.f43919b);
                } catch (Exception e11) {
                    if (com.mbridge.msdk.e.a.f43738a) {
                        Log.e("TrackManager", "onResponse error", e11);
                    }
                }
            }
        }
    }

    public n(int i11, o oVar, v vVar, int i12) {
        this.f43909b = i11;
        this.f43910c = oVar;
        this.f43911d = vVar;
        this.f43912e = i12;
        this.f43914g = new ThreadPoolExecutor(1, i11, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.e.n.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeReportResponseThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public final void a(q qVar) {
        this.f43908a = qVar;
    }

    public final void a(s sVar, Map<String, String> map, boolean z11) {
        if (y.a(map)) {
            q qVar = this.f43908a;
            if (qVar != null) {
                try {
                    qVar.a(sVar, 0, "params is null");
                    return;
                } catch (Exception e11) {
                    if (com.mbridge.msdk.e.a.f43738a) {
                        Log.e("TrackManager", "send error", e11);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        try {
            if (!y.b(this.f43913f)) {
                com.mbridge.msdk.e.a.q qVarA = com.mbridge.msdk.e.a.a.l.a(new com.mbridge.msdk.e.a.a.b(this.f43910c.c()), new com.mbridge.msdk.e.a.h(this.f43914g), this.f43909b, null);
                this.f43913f = qVarA;
                qVarA.a();
            }
            u uVar = this.f43912e == 1 ? new u(this.f43910c.b(), 1, this.f43910c.a()) : new u(this.f43910c.b(), 1);
            uVar.a(map);
            uVar.a(false);
            uVar.b(true);
            uVar.c(true);
            uVar.a(this.f43911d);
            uVar.a(z11 ? com.mbridge.msdk.e.a.p.b.HIGH : com.mbridge.msdk.e.a.p.b.NORMAL);
            uVar.a((com.mbridge.msdk.e.a.r.b) new b(this.f43908a, sVar));
            uVar.a((com.mbridge.msdk.e.a.r.a) new a(this.f43908a, sVar));
            this.f43913f.a(uVar);
        } catch (Exception e12) {
            if (com.mbridge.msdk.e.a.f43738a) {
                Log.e("TrackManager", "send error", e12);
            }
            if (y.b(this.f43908a)) {
                this.f43908a.a(sVar, 0, e12.getMessage());
            }
        }
    }
}
