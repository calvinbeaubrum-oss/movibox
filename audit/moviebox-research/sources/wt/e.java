package wt;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<vt.e, b> f79600a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f79601b = new c(null);

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lock f79602a = new ReentrantLock();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f79603b;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<b> f79604a = new ArrayDeque();

        public /* synthetic */ c(a aVar) {
        }

        public b a() {
            b bVarPoll;
            synchronized (this.f79604a) {
                bVarPoll = this.f79604a.poll();
            }
            return bVarPoll == null ? new b(null) : bVarPoll;
        }

        public void b(b bVar) {
            synchronized (this.f79604a) {
                try {
                    if (this.f79604a.size() < 10) {
                        this.f79604a.offer(bVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void a(vt.e eVar) {
        b bVarA;
        synchronized (this) {
            try {
                bVarA = this.f79600a.get(eVar);
                if (bVarA == null) {
                    bVarA = this.f79601b.a();
                    this.f79600a.put(eVar, bVarA);
                }
                bVarA.f79603b++;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        bVarA.f79602a.lock();
    }

    public void b(vt.e eVar) {
        b bVar;
        synchronized (this) {
            try {
                bVar = this.f79600a.get(eVar);
                int i11 = bVar.f79603b;
                if (i11 < 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Cannot release a lock that is not held, key: ");
                    sb2.append(eVar);
                    sb2.append(", interestedThreads: ");
                    sb2.append(bVar.f79603b);
                    throw new IllegalStateException(sb2.toString());
                }
                int i12 = i11 - 1;
                bVar.f79603b = i12;
                if (i12 == 0) {
                    b bVarRemove = this.f79600a.remove(eVar);
                    if (!bVarRemove.equals(bVar)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Removed the wrong lock, expected to remove: ");
                        sb3.append(bVar);
                        sb3.append(", but actually removed: ");
                        sb3.append(bVarRemove);
                        sb3.append(", key: ");
                        sb3.append(eVar);
                        throw new IllegalStateException(sb3.toString());
                    }
                    this.f79601b.b(bVarRemove);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        bVar.f79602a.unlock();
    }
}
