package p007do;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.common.base.h;
import com.google.common.base.p;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.b0;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.v;
import com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadService;
import com.polygamma.ogm.j;
import com.polygamma.ogm.t;
import io.c;
import io.d0;
import io.f;
import io.g;
import io.l;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class m {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f63464o = "0.5.13.4";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReentrantLock f63465p = new ReentrantLock();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final IdentityHashMap f63466q = new IdentityHashMap();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static m f63467r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f63468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f63469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference f63470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f63471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e0 f63472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f63473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReadWriteLock f63474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f63475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CountDownLatch f63476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ReadWriteLock f63477j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IdentityHashMap f63478k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final IdentityHashMap f63479l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final IdentityHashMap f63480m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public v f63481n;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IdentityHashMap f63482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Context f63483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f63484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f63485d;

        public a() {
            this.f63485d = false;
        }

        public /* synthetic */ a(int i11) {
            this();
        }

        public static d c(a aVar) {
            String strE = "";
            Context context = aVar.f63483b;
            d dVar = aVar.f63484c;
            d.a aVarG = dVar == null ? d.g() : dVar.k();
            try {
                PackageManager packageManager = context.getPackageManager();
                String strE2 = p.e(context.getPackageName());
                try {
                    String string = ((CharSequence) h.a(packageManager.getApplicationLabel(packageManager.getApplicationInfo(strE2, 0)), "")).toString();
                    String strE3 = p.e(packageManager.getPackageInfo(strE2, 0).versionName);
                    if (!strE2.isEmpty()) {
                        aVarG.f(strE2);
                    }
                    if (!string.isEmpty()) {
                        aVarG.b(string);
                    }
                    if (!strE3.isEmpty()) {
                        aVarG.e(strE3);
                    }
                    aVarG.g(Process.myPid());
                    aVarG.c(io.a.a(context));
                    aVarG.d(Process.myUid());
                } catch (Throwable unused) {
                    String str = m.f63464o;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 30) {
                        InstallSourceInfo installSourceInfo = packageManager.getInstallSourceInfo(strE2);
                        strE = (String) h.a(installSourceInfo.getInstallingPackageName(), (String) h.a(installSourceInfo.getInitiatingPackageName(), (String) h.a(installSourceInfo.getOriginatingPackageName(), "")));
                    }
                    if (strE.isEmpty()) {
                        strE = p.e(packageManager.getInstallerPackageName(strE2));
                    }
                    aVarG.a(strE);
                } catch (Throwable unused2) {
                    String str2 = m.f63464o;
                }
                return aVarG.build();
            } catch (Throwable unused3) {
                String str3 = m.f63464o;
                return aVarG.build();
            }
        }

        public static /* synthetic */ void d(m mVar, c cVar, Object obj, Throwable th2) {
            String str = m.f63464o;
            if (th2 != null) {
                try {
                    try {
                        SharedPreferences sharedPreferences = mVar.f63471d;
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().clear().apply();
                        }
                        mVar.J();
                    } catch (Throwable th3) {
                        mVar.J();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    cVar.accept(null, th2);
                    throw th4;
                }
            }
            if (th2 != null) {
                mVar = null;
            }
            cVar.accept(mVar, th2);
        }

        public static /* synthetic */ void e(List list, m mVar) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                mVar.A((Class) it.next());
            }
            m.s(mVar);
        }

        public a f(n.a<?> aVar) {
            if (this.f63482a == null) {
                this.f63482a = new IdentityHashMap();
            }
            this.f63482a.put(aVar.a(), aVar);
            return this;
        }

        public a h(Context context) {
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            Objects.requireNonNull(context);
            this.f63483b = context;
            return this;
        }

        public void i(final c<m, ? super Throwable> cVar) {
            d0.a();
            com.google.common.base.m.w(this.f63483b != null, "context not specified");
            final m mVar = new m(this);
            if (this.f63485d && Build.VERSION.SDK_INT >= 28) {
                String strI = mVar.f63469b.i();
                if (!p.b(strI) && !strI.equals(mVar.f63469b.c())) {
                    try {
                        WebView.setDataDirectorySuffix(strI.replace('.', '_').replace(':', '-'));
                    } catch (Throwable unused) {
                        String str = m.f63464o;
                    }
                }
            }
            final List listEmptyList = this.f63482a == null ? Collections.emptyList() : new ArrayList(this.f63482a.keySet());
            if (!listEmptyList.isEmpty()) {
                mVar.f63475h.putAll(this.f63482a);
            }
            g.a(mVar.f63473f.submit(new Runnable() { // from class: do.k
                @Override // java.lang.Runnable
                public final void run() {
                    m.a.e(listEmptyList, mVar);
                }
            }, null), new c() { // from class: do.l
                @Override // io.c
                public final void accept(Object obj, Object obj2) {
                    m.a.d(mVar, cVar, obj, (Throwable) obj2);
                }
            });
        }
    }

    static {
        d0.a();
    }

    public m(a aVar) {
        SharedPreferences sharedPreferences;
        Context context = aVar.f63483b;
        t tVar = new t(this);
        this.f63468a = UUID.randomUUID();
        d dVarC = a.c(aVar);
        this.f63469b = dVarC;
        this.f63470c = new WeakReference(context, tVar.f48887a);
        try {
            sharedPreferences = context.getSharedPreferences(f.b("pgogm_" + dVarC.i()), 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        this.f63471d = sharedPreferences;
        this.f63472e = new e0(context.getMainLooper());
        this.f63473f = new s();
        this.f63474g = d0.d();
        this.f63475h = new LinkedHashMap();
        this.f63476i = new CountDownLatch(1);
        this.f63477j = d0.d();
        this.f63478k = new IdentityHashMap();
        this.f63479l = new IdentityHashMap();
        this.f63480m = new IdentityHashMap();
        new Thread(tVar).start();
    }

    public static a C() {
        return new a(0);
    }

    public static void h(String str, ExecutorService executorService) {
        executorService.shutdown();
        for (int i11 = 0; i11 < 2; i11++) {
            try {
                if (executorService.awaitTermination(1L, TimeUnit.MINUTES)) {
                    return;
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    public static n.a k(Class cls) {
        try {
            e = cls.getDeclaredMethod("ofProvider", null).invoke(null, null);
        } catch (IllegalAccessException e11) {
            e = e11;
        } catch (NoSuchMethodException e12) {
            e = e12;
        } catch (InvocationTargetException e13) {
            e = e13;
        }
        if (!(e instanceof Throwable)) {
            if (e instanceof n.a) {
                return (n.a) e;
            }
            throw new IllegalArgumentException(cls.getSimpleName().concat("::ofProvider() did not return a provider"));
        }
        throw new IllegalArgumentException("unable to access " + cls.getSimpleName() + "::ofProvider()", (Throwable) e);
    }

    public static m r() {
        m mVar = f63467r;
        if (mVar != null) {
            return mVar;
        }
        throw new IllegalStateException("module not yet initialized");
    }

    public static void s(m mVar) {
        ReentrantLock reentrantLock = f63465p;
        reentrantLock.lock();
        try {
            m mVar2 = f63467r;
            if (mVar2 == null) {
                x(mVar);
                reentrantLock.unlock();
                return;
            }
            mVar2.J();
            for (int i11 = 0; i11 != 5; i11++) {
                try {
                    if (mVar2.j(1L, TimeUnit.MINUTES)) {
                        x(mVar);
                        f63465p.unlock();
                        return;
                    }
                    continue;
                } catch (InterruptedException unused) {
                }
            }
            throw new IllegalStateException("failed to stop previous SDK");
        } catch (Throwable th2) {
            f63465p.unlock();
            throw th2;
        }
    }

    public static void u(m mVar) {
        mVar.getClass();
        try {
            mVar.m();
            h("background", mVar.f63473f);
            h(DownloadService.KEY_FOREGROUND, mVar.f63472e);
            mVar.f63476i.countDown();
            f63465p.lock();
            try {
                if (f63467r == mVar) {
                    f63467r = null;
                }
            } finally {
                f63465p.unlock();
            }
        } catch (Throwable th2) {
            mVar.f63476i.countDown();
            f63465p.lock();
            try {
                if (f63467r == mVar) {
                    f63467r = null;
                }
                throw th2;
            } finally {
                f63465p.unlock();
            }
        }
    }

    public static void x(final m mVar) {
        f63467r = mVar;
        for (final androidx.core.util.a aVar : f63466q.keySet()) {
            mVar.n().execute(new Runnable() { // from class: do.e
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.accept(mVar);
                }
            });
        }
    }

    public <M extends n> M A(Class<M> cls) {
        d0.b();
        M m11 = (M) v(cls);
        if (m11 != null) {
            return m11;
        }
        d0.b();
        Lock lockWriteLock = this.f63474g.writeLock();
        lockWriteLock.lock();
        try {
            Object objD = this.f63475h.get(cls);
            if (objD == null) {
                objD = k(cls);
            }
            if (objD instanceof n.a) {
                objD = d(lockWriteLock, cls, (n.a) objD);
            }
            if (objD instanceof Throwable) {
                throw new IllegalStateException("module failed to load", (Throwable) objD);
            }
            lockWriteLock.unlock();
            if (objD instanceof Future) {
                try {
                    objD = ((Future) objD).get(1L, TimeUnit.MINUTES);
                } catch (InterruptedException e11) {
                    e = e11;
                    throw new IllegalStateException("module failed to load", e);
                } catch (ExecutionException e12) {
                    e = e12;
                    throw new IllegalStateException("module failed to load", e);
                } catch (TimeoutException unused) {
                    throw new IllegalStateException("recursive dependency on " + cls + " detected");
                }
            }
            return (M) objD;
        } catch (Throwable th2) {
            lockWriteLock.unlock();
            throw th2;
        }
    }

    public String B(String str, String str2) {
        SharedPreferences sharedPreferences = this.f63471d;
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }

    public void D(String str, JSONObject jSONObject) {
        try {
            F(str, f.b(jSONObject.toString()));
        } catch (Throwable unused) {
            String.format("Failed to update JSON preferences: %s", jSONObject);
        }
    }

    public void E(String str, long j11) {
        SharedPreferences sharedPreferences = this.f63471d;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str, j11).apply();
        }
    }

    public void F(String str, String str2) {
        SharedPreferences sharedPreferences = this.f63471d;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public void G(androidx.core.util.a<Map<n, l>> aVar) {
        Lock lockWriteLock = this.f63477j.writeLock();
        lockWriteLock.lock();
        try {
            this.f63480m.put(aVar, Boolean.TRUE);
        } finally {
            lockWriteLock.unlock();
        }
    }

    public s<?> H(Runnable runnable) {
        e0 e0Var = this.f63472e;
        s sVar = this.f63473f;
        e0Var.getClass();
        com.polygamma.ogm.h hVar = new com.polygamma.ogm.h(e0Var, sVar, runnable);
        e0Var.c(hVar, 0L, false);
        return hVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public s<?> I(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        e0 e0Var = this.f63472e;
        s sVar = this.f63473f;
        e0Var.getClass();
        j jVar = new j(e0Var, sVar, runnable, timeUnit.toMillis(j11), timeUnit.toMillis(j12));
        e0Var.c(jVar, jVar.f48881c, false);
        return jVar;
    }

    public void J() {
        this.f63470c.enqueue();
        this.f63470c.clear();
    }

    public UUID K() {
        return this.f63468a;
    }

    public final Object d(Lock lock, Class cls, n.a aVar) {
        n nVar;
        Throwable th2;
        Object obj;
        if (!aVar.a().isAssignableFrom(cls)) {
            throw new IllegalArgumentException(aVar.getClass() + " provides module type " + aVar.a() + ", which is not assignable to " + cls);
        }
        Context contextQ = q();
        b0 b0VarB = b0.b();
        this.f63475h.put(cls, b0VarB);
        lock.unlock();
        try {
            n nVarB = aVar.b(this, contextQ);
            try {
                nVarB.e(contextQ);
                b0VarB.set(nVarB);
                obj = nVarB;
            } catch (Throwable th3) {
                nVar = nVarB;
                th2 = th3;
                if (nVar != null) {
                    try {
                        nVar.a();
                    } catch (Throwable unused) {
                    }
                }
                try {
                    b0VarB.setException(th2);
                    obj = th2;
                } catch (Throwable th4) {
                    lock.lock();
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            nVar = null;
            th2 = th5;
        }
        lock.lock();
        if (obj instanceof n) {
            this.f63475h.remove(cls);
            this.f63475h.put(cls, (n) obj);
        } else {
            this.f63475h.put(cls, obj);
        }
        return obj;
    }

    public final void e() {
        Lock lock = this.f63477j.readLock();
        lock.lock();
        try {
            Map mapUnmodifiableMap = Collections.unmodifiableMap(new IdentityHashMap(this.f63479l));
            androidx.core.util.a[] aVarArr = (androidx.core.util.a[]) this.f63480m.keySet().toArray(new androidx.core.util.a[0]);
            this.f63479l.clear();
            this.f63481n = null;
            lock.unlock();
            for (androidx.core.util.a aVar : aVarArr) {
                try {
                    aVar.accept(mapUnmodifiableMap);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th2) {
            this.f63481n = null;
            lock.unlock();
            throw th2;
        }
    }

    public final void g(n nVar, l lVar) {
        nVar.d();
        Lock lockWriteLock = this.f63477j.writeLock();
        lockWriteLock.lock();
        try {
            this.f63478k.put(nVar, lVar);
            this.f63479l.put(nVar, lVar);
            if (this.f63481n == null) {
                try {
                    s sVar = this.f63473f;
                    Runnable runnable = new Runnable() { // from class: do.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f63450a.e();
                        }
                    };
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    sVar.getClass();
                    this.f63481n = sVar.a(new com.polygamma.ogm.m(sVar, runnable, null), 10L, timeUnit);
                } catch (RejectedExecutionException unused) {
                }
            }
        } finally {
            lockWriteLock.unlock();
        }
    }

    public d i() {
        return this.f63469b;
    }

    public boolean j(long j11, TimeUnit timeUnit) throws InterruptedException {
        return this.f63476i.await(j11, timeUnit);
    }

    public final void m() {
        IllegalStateException illegalStateException = new IllegalStateException("module unloaded");
        this.f63474g.readLock().lock();
        try {
            ArrayList arrayList = new ArrayList(this.f63475h.entrySet());
            this.f63474g.readLock().unlock();
            while (!arrayList.isEmpty()) {
                Map.Entry entry = (Map.Entry) arrayList.remove(arrayList.size() - 1);
                n nVar = entry.getValue() instanceof n ? (n) entry.getValue() : null;
                if (nVar != null) {
                    try {
                        nVar.a();
                    } catch (Exception unused) {
                        String.format("failed to destroy module %s", nVar);
                    }
                    this.f63474g.writeLock().lock();
                    try {
                        this.f63475h.put((Class) entry.getKey(), illegalStateException);
                        this.f63474g.writeLock().unlock();
                    } catch (Throwable th2) {
                        this.f63474g.writeLock().unlock();
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            this.f63474g.readLock().unlock();
            throw th3;
        }
    }

    public v n() {
        return this.f63473f;
    }

    public <V> s<V> p(Callable<V> callable) {
        s sVar = this.f63473f;
        if (d0.c()) {
            return sVar.submit((Callable) callable);
        }
        try {
            return Futures.g(callable.call());
        } catch (Exception e11) {
            return Futures.f(e11);
        }
    }

    public Context q() {
        Context context = (Context) this.f63470c.get();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException();
    }

    public String toString() {
        return "OriginMobile[" + this.f63468a + "]";
    }

    @Nullable
    public <M extends n> M v(Class<M> cls) {
        Lock lock = this.f63474g.readLock();
        lock.lock();
        try {
            Object obj = this.f63475h.get(cls);
            return obj instanceof n ? (M) obj : null;
        } finally {
            lock.unlock();
        }
    }

    public v w() {
        return this.f63472e;
    }

    public JSONObject y(String str, JSONObject jSONObject) {
        String strB = B(str, "");
        if (strB.isEmpty()) {
            return jSONObject;
        }
        try {
            return new JSONObject(f.c(strB));
        } catch (Throwable unused) {
            "Malformed JSON preferences: ".concat(strB);
            return jSONObject;
        }
    }

    public long z(String str, long j11) {
        SharedPreferences sharedPreferences = this.f63471d;
        return sharedPreferences == null ? j11 : sharedPreferences.getLong(str, j11);
    }
}
