package wn;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockingQueue<Runnable> f79565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadPoolExecutor f79566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<b> f79567c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f79568d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f79565a = linkedBlockingQueue;
        this.f79566b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    @Override // wn.b.a
    public void a(b bVar) {
        this.f79568d = null;
        b();
    }

    public final void b() {
        b bVarPoll = this.f79567c.poll();
        this.f79568d = bVarPoll;
        if (bVarPoll != null) {
            bVarPoll.b(this.f79566b);
        }
    }

    public void c(b bVar) {
        bVar.c(this);
        this.f79567c.add(bVar);
        if (this.f79568d == null) {
            b();
        }
    }
}
