package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class Processor implements e, androidx.work.impl.foreground.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f13314n = androidx.work.j.i("Processor");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f13316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.work.a f13317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t6.c f13318d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WorkDatabase f13319f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<s> f13323j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, WorkerWrapper> f13321h = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, WorkerWrapper> f13320g = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Set<String> f13324k = new HashSet();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<e> f13325l = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public PowerManager.WakeLock f13315a = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f13326m = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, Set<u>> f13322i = new HashMap();

    /* JADX INFO: compiled from: source.java */
    public static class FutureListener implements Runnable {

        @NonNull
        private e mExecutionListener;

        @NonNull
        private com.google.common.util.concurrent.s<Boolean> mFuture;

        @NonNull
        private final s6.m mWorkGenerationalId;

        public FutureListener(@NonNull e eVar, @NonNull s6.m mVar, @NonNull com.google.common.util.concurrent.s<Boolean> sVar) {
            this.mExecutionListener = eVar;
            this.mWorkGenerationalId = mVar;
            this.mFuture = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zBooleanValue;
            try {
                zBooleanValue = this.mFuture.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                zBooleanValue = true;
            }
            this.mExecutionListener.l(this.mWorkGenerationalId, zBooleanValue);
        }
    }

    public Processor(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull t6.c cVar, @NonNull WorkDatabase workDatabase, @NonNull List<s> list) {
        this.f13316b = context;
        this.f13317c = aVar;
        this.f13318d = cVar;
        this.f13319f = workDatabase;
        this.f13323j = list;
    }

    public static boolean i(@NonNull String str, @Nullable WorkerWrapper workerWrapper) {
        if (workerWrapper == null) {
            androidx.work.j.e().a(f13314n, "WorkerWrapper could not be found for " + str);
            return false;
        }
        workerWrapper.interrupt();
        androidx.work.j.e().a(f13314n, "WorkerWrapper interrupted for " + str);
        return true;
    }

    @Override // androidx.work.impl.foreground.a
    public void a(@NonNull String str) {
        synchronized (this.f13326m) {
            this.f13320g.remove(str);
            s();
        }
    }

    @Override // androidx.work.impl.foreground.a
    public boolean b(@NonNull String str) {
        boolean zContainsKey;
        synchronized (this.f13326m) {
            zContainsKey = this.f13320g.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // androidx.work.impl.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void l(@NonNull s6.m mVar, boolean z11) {
        synchronized (this.f13326m) {
            try {
                WorkerWrapper workerWrapper = this.f13321h.get(mVar.b());
                if (workerWrapper != null && mVar.equals(workerWrapper.getWorkGenerationalId())) {
                    this.f13321h.remove(mVar.b());
                }
                androidx.work.j.e().a(f13314n, getClass().getSimpleName() + " " + mVar.b() + " executed; reschedule = " + z11);
                Iterator<e> it = this.f13325l.iterator();
                while (it.hasNext()) {
                    it.next().l(mVar, z11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.work.impl.foreground.a
    public void d(@NonNull String str, @NonNull androidx.work.e eVar) {
        synchronized (this.f13326m) {
            try {
                androidx.work.j.e().f(f13314n, "Moving WorkSpec (" + str + ") to the foreground");
                WorkerWrapper workerWrapperRemove = this.f13321h.remove(str);
                if (workerWrapperRemove != null) {
                    if (this.f13315a == null) {
                        PowerManager.WakeLock wakeLockB = androidx.work.impl.utils.s.b(this.f13316b, "ProcessorForegroundLck");
                        this.f13315a = wakeLockB;
                        wakeLockB.acquire();
                    }
                    this.f13320g.put(str, workerWrapperRemove);
                    z2.a.startForegroundService(this.f13316b, SystemForegroundDispatcher.f(this.f13316b, workerWrapperRemove.getWorkGenerationalId(), eVar));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void g(@NonNull e eVar) {
        synchronized (this.f13326m) {
            this.f13325l.add(eVar);
        }
    }

    @Nullable
    public s6.u h(@NonNull String str) {
        synchronized (this.f13326m) {
            try {
                WorkerWrapper workerWrapper = this.f13320g.get(str);
                if (workerWrapper == null) {
                    workerWrapper = this.f13321h.get(str);
                }
                if (workerWrapper == null) {
                    return null;
                }
                return workerWrapper.getWorkSpec();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean j(@NonNull String str) {
        boolean zContains;
        synchronized (this.f13326m) {
            zContains = this.f13324k.contains(str);
        }
        return zContains;
    }

    public boolean k(@NonNull String str) {
        boolean z11;
        synchronized (this.f13326m) {
            try {
                z11 = this.f13321h.containsKey(str) || this.f13320g.containsKey(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z11;
    }

    public final /* synthetic */ s6.u m(ArrayList arrayList, String str) throws Exception {
        arrayList.addAll(this.f13319f.O().b(str));
        return this.f13319f.N().j(str);
    }

    public void n(@NonNull e eVar) {
        synchronized (this.f13326m) {
            this.f13325l.remove(eVar);
        }
    }

    public final void o(@NonNull final s6.m mVar, final boolean z11) {
        this.f13318d.a().execute(new Runnable() { // from class: androidx.work.impl.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f13480a.l(mVar, z11);
            }
        });
    }

    public boolean p(@NonNull u uVar) {
        return q(uVar, null);
    }

    public boolean q(@NonNull u uVar, @Nullable WorkerParameters.a aVar) {
        s6.m mVarA = uVar.a();
        final String strB = mVarA.b();
        final ArrayList arrayList = new ArrayList();
        s6.u uVar2 = (s6.u) this.f13319f.C(new Callable() { // from class: androidx.work.impl.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13477a.m(arrayList, strB);
            }
        });
        if (uVar2 == null) {
            androidx.work.j.e().k(f13314n, "Didn't find WorkSpec for id " + mVarA);
            o(mVarA, false);
            return false;
        }
        synchronized (this.f13326m) {
            try {
                if (k(strB)) {
                    Set<u> set = this.f13322i.get(strB);
                    if (set.iterator().next().a().a() == mVarA.a()) {
                        set.add(uVar);
                        androidx.work.j.e().a(f13314n, "Work " + mVarA + " is already enqueued for processing");
                    } else {
                        o(mVarA, false);
                    }
                    return false;
                }
                if (uVar2.f() != mVarA.a()) {
                    o(mVarA, false);
                    return false;
                }
                WorkerWrapper workerWrapperB = new WorkerWrapper.a(this.f13316b, this.f13317c, this.f13318d, this, this.f13319f, uVar2, arrayList).d(this.f13323j).c(aVar).b();
                com.google.common.util.concurrent.s<Boolean> future = workerWrapperB.getFuture();
                future.addListener(new FutureListener(this, uVar.a(), future), this.f13318d.a());
                this.f13321h.put(strB, workerWrapperB);
                HashSet hashSet = new HashSet();
                hashSet.add(uVar);
                this.f13322i.put(strB, hashSet);
                this.f13318d.b().execute(workerWrapperB);
                androidx.work.j.e().a(f13314n, getClass().getSimpleName() + ": processing " + mVarA);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean r(@NonNull String str) {
        WorkerWrapper workerWrapperRemove;
        boolean z11;
        synchronized (this.f13326m) {
            try {
                androidx.work.j.e().a(f13314n, "Processor cancelling " + str);
                this.f13324k.add(str);
                workerWrapperRemove = this.f13320g.remove(str);
                z11 = workerWrapperRemove != null;
                if (workerWrapperRemove == null) {
                    workerWrapperRemove = this.f13321h.remove(str);
                }
                if (workerWrapperRemove != null) {
                    this.f13322i.remove(str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        boolean zI = i(str, workerWrapperRemove);
        if (z11) {
            s();
        }
        return zI;
    }

    public final void s() {
        synchronized (this.f13326m) {
            try {
                if (!(!this.f13320g.isEmpty())) {
                    try {
                        this.f13316b.startService(SystemForegroundDispatcher.g(this.f13316b));
                    } catch (Throwable th2) {
                        androidx.work.j.e().d(f13314n, "Unable to stop foreground service", th2);
                    }
                    PowerManager.WakeLock wakeLock = this.f13315a;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.f13315a = null;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public boolean t(@NonNull u uVar) {
        WorkerWrapper workerWrapperRemove;
        String strB = uVar.a().b();
        synchronized (this.f13326m) {
            try {
                androidx.work.j.e().a(f13314n, "Processor stopping foreground work " + strB);
                workerWrapperRemove = this.f13320g.remove(strB);
                if (workerWrapperRemove != null) {
                    this.f13322i.remove(strB);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i(strB, workerWrapperRemove);
    }

    public boolean u(@NonNull u uVar) {
        String strB = uVar.a().b();
        synchronized (this.f13326m) {
            try {
                WorkerWrapper workerWrapperRemove = this.f13321h.remove(strB);
                if (workerWrapperRemove == null) {
                    androidx.work.j.e().a(f13314n, "WorkerWrapper could not be found for " + strB);
                    return false;
                }
                Set<u> set = this.f13322i.get(strB);
                if (set != null && set.contains(uVar)) {
                    androidx.work.j.e().a(f13314n, "Processor stopping background work " + strB);
                    this.f13322i.remove(strB);
                    return i(strB, workerWrapperRemove);
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
