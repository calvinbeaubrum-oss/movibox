package on;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockingQueue<Runnable> f72495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadPoolExecutor f72496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<b> f72497c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f72498d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f72495a = linkedBlockingQueue;
        this.f72496b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    @Override // on.b.a
    public void a(b bVar) {
        this.f72498d = null;
        b();
    }

    public final void b() {
        b bVarPoll = this.f72497c.poll();
        this.f72498d = bVarPoll;
        if (bVarPoll != null) {
            bVarPoll.b(this.f72496b);
        }
    }

    public void c(b bVar) {
        bVar.c(this);
        this.f72497c.add(bVar);
        if (this.f72498d == null) {
            b();
        }
    }
}
