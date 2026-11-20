package rj;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class t implements yk.d, yk.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, ConcurrentHashMap<yk.b<Object>, Executor>> f75573a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Queue<yk.a<?>> f75574b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f75575c;

    public t(Executor executor) {
        this.f75575c = executor;
    }

    public static /* synthetic */ void f(Map.Entry entry, yk.a aVar) {
        ((yk.b) entry.getKey()).a(aVar);
    }

    @Override // yk.d
    public <T> void a(Class<T> cls, yk.b<? super T> bVar) {
        b(cls, this.f75575c, bVar);
    }

    @Override // yk.d
    public synchronized <T> void b(Class<T> cls, Executor executor, yk.b<? super T> bVar) {
        try {
            a0.b(cls);
            a0.b(bVar);
            a0.b(executor);
            if (!this.f75573a.containsKey(cls)) {
                this.f75573a.put(cls, new ConcurrentHashMap<>());
            }
            this.f75573a.get(cls).put(bVar, executor);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void d() {
        Queue<yk.a<?>> queue;
        synchronized (this) {
            try {
                queue = this.f75574b;
                if (queue != null) {
                    this.f75574b = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (queue != null) {
            Iterator<yk.a<?>> it = queue.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
        }
    }

    public final synchronized Set<Map.Entry<yk.b<Object>, Executor>> e(yk.a<?> aVar) {
        ConcurrentHashMap<yk.b<Object>, Executor> concurrentHashMap;
        try {
            concurrentHashMap = this.f75573a.get(aVar.b());
        } catch (Throwable th2) {
            throw th2;
        }
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    public void g(final yk.a<?> aVar) {
        a0.b(aVar);
        synchronized (this) {
            try {
                Queue<yk.a<?>> queue = this.f75574b;
                if (queue != null) {
                    queue.add(aVar);
                    return;
                }
                for (final Map.Entry<yk.b<Object>, Executor> entry : e(aVar)) {
                    entry.getValue().execute(new Runnable() { // from class: rj.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            t.f(entry, aVar);
                        }
                    });
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
