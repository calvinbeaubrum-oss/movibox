package androidx.work.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractFuture<V> implements s<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f13509d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f13510f = Logger.getLogger(AbstractFuture.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f13511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f13512h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public volatile Object f13513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public volatile d f13514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public volatile g f13515c;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class Failure {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Failure f13516b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.work.impl.utils.futures.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f13517a;

        public Failure(Throwable th2) {
            this.f13517a = (Throwable) AbstractFuture.e(th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class SetFuture<V> implements Runnable {
        final s<? extends V> future;
        final AbstractFuture<V> owner;

        public SetFuture(AbstractFuture<V> abstractFuture, s<? extends V> sVar) {
            this.owner = abstractFuture;
            this.future = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.owner.f13513a != this) {
                return;
            }
            if (AbstractFuture.f13511g.b(this.owner, this, AbstractFuture.l(this.future))) {
                AbstractFuture.g(this.owner);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture<?> abstractFuture, g gVar, g gVar2);

        public abstract void d(g gVar, g gVar2);

        public abstract void e(g gVar, Thread thread);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f13518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f13519d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f13520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final Throwable f13521b;

        static {
            if (AbstractFuture.f13509d) {
                f13519d = null;
                f13518c = null;
            } else {
                f13519d = new c(false, null);
                f13518c = new c(true, null);
            }
        }

        public c(boolean z11, @Nullable Throwable th2) {
            this.f13520a = z11;
            this.f13521b = th2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f13522d = new d(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f13523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f13524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public d f13525c;

        public d(Runnable runnable, Executor executor) {
            this.f13523a = runnable;
            this.f13524b = executor;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<g, Thread> f13526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<g, g> f13527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, g> f13528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, d> f13529d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> f13530e;

        public e(AtomicReferenceFieldUpdater<g, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<g, g> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, g> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f13526a = atomicReferenceFieldUpdater;
            this.f13527b = atomicReferenceFieldUpdater2;
            this.f13528c = atomicReferenceFieldUpdater3;
            this.f13529d = atomicReferenceFieldUpdater4;
            this.f13530e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return androidx.concurrent.futures.a.a(this.f13529d, abstractFuture, dVar, dVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f13530e, abstractFuture, obj, obj2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, g gVar, g gVar2) {
            return androidx.concurrent.futures.a.a(this.f13528c, abstractFuture, gVar, gVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void d(g gVar, g gVar2) {
            this.f13527b.lazySet(gVar, gVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void e(g gVar, Thread thread) {
            this.f13526a.lazySet(gVar, thread);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class f extends b {
        public f() {
            super();
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f13514b != dVar) {
                        return false;
                    }
                    abstractFuture.f13514b = dVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f13513a != obj) {
                        return false;
                    }
                    abstractFuture.f13513a = obj2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, g gVar, g gVar2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f13515c != gVar) {
                        return false;
                    }
                    abstractFuture.f13515c = gVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void d(g gVar, g gVar2) {
            gVar.f13533b = gVar2;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void e(g gVar, Thread thread) {
            gVar.f13532a = thread;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f13531c = new g(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public volatile Thread f13532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public volatile g f13533b;

        public g() {
            AbstractFuture.f13511g.e(this, Thread.currentThread());
        }

        public g(boolean z11) {
        }

        public void a(g gVar) {
            AbstractFuture.f13511g.d(this, gVar);
        }

        public void b() {
            Thread thread = this.f13532a;
            if (thread != null) {
                this.f13532a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        b fVar;
        try {
            fVar = new e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, g.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            fVar = new f();
        }
        f13511g = fVar;
        if (th != null) {
            f13510f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f13512h = new Object();
    }

    private void b(StringBuilder sb2) {
        try {
            Object objM = m(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(w(objM));
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e11) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e11.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e12) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e12.getCause());
            sb2.append("]");
        }
    }

    private static CancellationException d(@Nullable String str, @Nullable Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    @NonNull
    public static <T> T e(@Nullable T t11) {
        t11.getClass();
        return t11;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void g(AbstractFuture<?> abstractFuture) {
        d dVar = null;
        while (true) {
            abstractFuture.p();
            abstractFuture.c();
            d dVarF = abstractFuture.f(dVar);
            while (dVarF != null) {
                dVar = dVarF.f13525c;
                Runnable runnable = dVarF.f13523a;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractFuture = setFuture.owner;
                    if (abstractFuture.f13513a == setFuture) {
                        if (f13511g.b(abstractFuture, setFuture, l(setFuture.future))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    h(runnable, dVarF.f13524b);
                }
                dVarF = dVar;
            }
            return;
        }
    }

    private static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            f13510f.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V k(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw d("Task was cancelled.", ((c) obj).f13521b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f13517a);
        }
        if (obj == f13512h) {
            return null;
        }
        return obj;
    }

    public static Object l(s<?> sVar) {
        if (sVar instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) sVar).f13513a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.f13520a) {
                return cVar.f13521b != null ? new c(false, cVar.f13521b) : c.f13519d;
            }
            return obj;
        }
        boolean zIsCancelled = sVar.isCancelled();
        if ((!f13509d) && zIsCancelled) {
            return c.f13519d;
        }
        try {
            Object objM = m(sVar);
            return objM == null ? f13512h : objM;
        } catch (CancellationException e11) {
            if (zIsCancelled) {
                return new c(false, e11);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + sVar, e11));
        } catch (ExecutionException e12) {
            return new Failure(e12.getCause());
        } catch (Throwable th2) {
            return new Failure(th2);
        }
    }

    private static <V> V m(Future<V> future) throws ExecutionException {
        V v11;
        boolean z11 = false;
        while (true) {
            try {
                v11 = future.get();
                break;
            } catch (InterruptedException unused) {
                z11 = true;
            } catch (Throwable th2) {
                if (z11) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
        return v11;
    }

    private void p() {
        g gVar;
        do {
            gVar = this.f13515c;
        } while (!f13511g.c(this, gVar, g.f13531c));
        while (gVar != null) {
            gVar.b();
            gVar = gVar.f13533b;
        }
    }

    private String w(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // com.google.common.util.concurrent.s
    public final void addListener(Runnable runnable, Executor executor) {
        e(runnable);
        e(executor);
        d dVar = this.f13514b;
        if (dVar != d.f13522d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f13525c = dVar;
                if (f13511g.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.f13514b;
                }
            } while (dVar != d.f13522d);
        }
        h(runnable, executor);
    }

    public void c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z11) {
        c cVar;
        Object obj = this.f13513a;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        if (f13509d) {
            cVar = new c(z11, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z11 ? c.f13518c : c.f13519d;
        }
        boolean z12 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (f13511g.b(abstractFuture, obj, cVar)) {
                if (z11) {
                    abstractFuture.n();
                }
                g(abstractFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                s<? extends V> sVar = ((SetFuture) obj).future;
                if (!(sVar instanceof AbstractFuture)) {
                    sVar.cancel(z11);
                    return true;
                }
                abstractFuture = (AbstractFuture) sVar;
                obj = abstractFuture.f13513a;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    return true;
                }
                z12 = true;
            } else {
                obj = abstractFuture.f13513a;
                if (!(obj instanceof SetFuture)) {
                    return z12;
                }
            }
        }
    }

    public final d f(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f13514b;
        } while (!f13511g.a(this, dVar2, d.f13522d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.f13525c;
            dVar4.f13525c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f13513a;
        if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
            return k(obj2);
        }
        g gVar = this.f13515c;
        if (gVar != g.f13531c) {
            g gVar2 = new g();
            do {
                gVar2.a(gVar);
                if (f13511g.c(this, gVar, gVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            q(gVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f13513a;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return k(obj);
                }
                gVar = this.f13515c;
            } while (gVar != g.f13531c);
        }
        return k(this.f13513a);
    }

    @Override // java.util.concurrent.Future
    public final V get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j11);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f13513a;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return k(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            g gVar = this.f13515c;
            if (gVar != g.f13531c) {
                g gVar2 = new g();
                while (true) {
                    gVar2.a(gVar);
                    if (f13511g.c(this, gVar, gVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                q(gVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f13513a;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return k(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        q(gVar2);
                        break;
                    }
                    gVar = this.f13515c;
                    if (gVar == g.f13531c) {
                    }
                }
            }
            return k(this.f13513a);
        }
        while (nanos > 0) {
            Object obj3 = this.f13513a;
            if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                return k(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j11 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j12 = -nanos;
            long jConvert = timeUnit.convert(j12, TimeUnit.NANOSECONDS);
            long nanos2 = j12 - timeUnit.toNanos(jConvert);
            boolean z11 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z11) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z11) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f13513a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f13513a;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    public void n() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public String o() {
        Object obj = this.f13513a;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + w(((SetFuture) obj).future) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void q(g gVar) {
        gVar.f13532a = null;
        while (true) {
            g gVar2 = this.f13515c;
            if (gVar2 == g.f13531c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f13533b;
                if (gVar2.f13532a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f13533b = gVar4;
                    if (gVar3.f13532a == null) {
                    }
                } else if (!f13511g.c(this, gVar2, gVar4)) {
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean t(@Nullable V v11) {
        if (v11 == null) {
            v11 = (V) f13512h;
        }
        if (!f13511g.b(this, null, v11)) {
            return false;
        }
        g(this);
        return true;
    }

    public String toString() {
        String strO;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            b(sb2);
        } else {
            try {
                strO = o();
            } catch (RuntimeException e11) {
                strO = "Exception thrown from implementation: " + e11.getClass();
            }
            if (strO != null && !strO.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(strO);
                sb2.append("]");
            } else if (isDone()) {
                b(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public boolean u(Throwable th2) {
        if (!f13511g.b(this, null, new Failure((Throwable) e(th2)))) {
            return false;
        }
        g(this);
        return true;
    }

    public boolean v(s<? extends V> sVar) {
        Failure failure;
        e(sVar);
        Object obj = this.f13513a;
        if (obj == null) {
            if (sVar.isDone()) {
                if (!f13511g.b(this, null, l(sVar))) {
                    return false;
                }
                g(this);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, sVar);
            if (f13511g.b(this, null, setFuture)) {
                try {
                    sVar.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th2) {
                    try {
                        failure = new Failure(th2);
                    } catch (Throwable unused) {
                        failure = Failure.f13516b;
                    }
                    f13511g.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.f13513a;
        }
        if (obj instanceof c) {
            sVar.cancel(((c) obj).f13520a);
        }
        return false;
    }
}
