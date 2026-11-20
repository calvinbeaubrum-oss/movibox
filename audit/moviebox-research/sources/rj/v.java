package rj;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class v<T> implements bl.b<Set<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Set<T> f75580b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Set<bl.b<T>> f75579a = Collections.newSetFromMap(new ConcurrentHashMap());

    public v(Collection<bl.b<T>> collection) {
        this.f75579a.addAll(collection);
    }

    public static v<?> b(Collection<bl.b<?>> collection) {
        return new v<>((Set) collection);
    }

    public synchronized void a(bl.b<T> bVar) {
        try {
            if (this.f75580b == null) {
                this.f75579a.add(bVar);
            } else {
                this.f75580b.add(bVar.get());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // bl.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set<T> get() {
        if (this.f75580b == null) {
            synchronized (this) {
                try {
                    if (this.f75580b == null) {
                        this.f75580b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return Collections.unmodifiableSet(this.f75580b);
    }

    public final synchronized void d() {
        try {
            Iterator<bl.b<T>> it = this.f75579a.iterator();
            while (it.hasNext()) {
                this.f75580b.add(it.next().get());
            }
            this.f75579a = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
