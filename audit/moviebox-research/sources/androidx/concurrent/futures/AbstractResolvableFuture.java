package androidx.concurrent.futures;

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
public abstract class AbstractResolvableFuture<V> implements s<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f6265d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f6266f = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f6267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f6268h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public volatile Object f6269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public volatile d f6270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public volatile g f6271c;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class Failure {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Failure f6272b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f6273a;

        public Failure(Throwable th2) {
            this.f6273a = (Throwable) AbstractResolvableFuture.e(th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class SetFuture<V> implements Runnable {
        final s<? extends V> future;
        final AbstractResolvableFuture<V> owner;

        public SetFuture(AbstractResolvableFuture<V> abstractResolvableFuture, s<? extends V> sVar) {
            this.owner = abstractResolvableFuture;
            this.future = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.owner.f6269a != this) {
                return;
            }
            if (AbstractResolvableFuture.f6267g.b(this.owner, this, AbstractResolvableFuture.n(this.future))) {
                AbstractResolvableFuture.k(this.owner);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2);

        public abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, g gVar, g gVar2);

        public abstract void d(g gVar, g gVar2);

        public abstract void e(g gVar, Thread thread);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f6274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f6275d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f6276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final Throwable f6277b;

        static {
            if (AbstractResolvableFuture.f6265d) {
                f6275d = null;
                f6274c = null;
            } else {
                f6275d = new c(false, null);
                f6274c = new c(true, null);
            }
        }

        public c(boolean z11, @Nullable Throwable th2) {
            this.f6276a = z11;
            this.f6277b = th2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f6278d = new d(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f6279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f6280b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public d f6281c;

        public d(Runnable runnable, Executor executor) {
            this.f6279a = runnable;
            this.f6280b = executor;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<g, Thread> f6282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<g, g> f6283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, g> f6284c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, d> f6285d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> f6286e;

        public e(AtomicReferenceFieldUpdater<g, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<g, g> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, g> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f6282a = atomicReferenceFieldUpdater;
            this.f6283b = atomicReferenceFieldUpdater2;
            this.f6284c = atomicReferenceFieldUpdater3;
            this.f6285d = atomicReferenceFieldUpdater4;
            this.f6286e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2) {
            return androidx.concurrent.futures.a.a(this.f6285d, abstractResolvableFuture, dVar, dVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f6286e, abstractResolvableFuture, obj, obj2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, g gVar, g gVar2) {
            return androidx.concurrent.futures.a.a(this.f6284c, abstractResolvableFuture, gVar, gVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(g gVar, g gVar2) {
            this.f6283b.lazySet(gVar, gVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(g gVar, Thread thread) {
            this.f6282a.lazySet(gVar, thread);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class f extends b {
        public f() {
            super();
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f6270b != dVar) {
                        return false;
                    }
                    abstractResolvableFuture.f6270b = dVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f6269a != obj) {
                        return false;
                    }
                    abstractResolvableFuture.f6269a = obj2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, g gVar, g gVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f6271c != gVar) {
                        return false;
                    }
                    abstractResolvableFuture.f6271c = gVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(g gVar, g gVar2) {
            gVar.f6289b = gVar2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(g gVar, Thread thread) {
            gVar.f6288a = thread;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f6287c = new g(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public volatile Thread f6288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public volatile g f6289b;

        public g() {
            AbstractResolvableFuture.f6267g.e(this, Thread.currentThread());
        }

        public g(boolean z11) {
        }

        public void a(g gVar) {
            AbstractResolvableFuture.f6267g.d(this, gVar);
        }

        public void b() {
            Thread thread = this.f6288a;
            if (thread != null) {
                this.f6288a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        b fVar;
        try {
            fVar = new e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, g.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, d.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            fVar = new f();
        }
        f6267g = fVar;
        if (th != null) {
            f6266f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f6268h = new Object();
    }

    public static CancellationException d(@Nullable String str, @Nullable Throwable th2) {
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
    public static void k(AbstractResolvableFuture<?> abstractResolvableFuture) {
        d dVar = null;
        while (true) {
            abstractResolvableFuture.t();
            abstractResolvableFuture.c();
            d dVarH = abstractResolvableFuture.h(dVar);
            while (dVarH != null) {
                dVar = dVarH.f6281c;
                Runnable runnable = dVarH.f6279a;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractResolvableFuture = setFuture.owner;
                    if (abstractResolvableFuture.f6269a == setFuture) {
                        if (f6267g.b(abstractResolvableFuture, setFuture, n(setFuture.future))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    l(runnable, dVarH.f6280b);
                }
                dVarH = dVar;
            }
            return;
        }
    }

    public static void l(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            f6266f.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e11);
        }
    }

    public static Object n(s<?> sVar) {
        if (sVar instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) sVar).f6269a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.f6276a) {
                return cVar.f6277b != null ? new c(false, cVar.f6277b) : c.f6275d;
            }
            return obj;
        }
        boolean zIsCancelled = sVar.isCancelled();
        if ((!f6265d) && zIsCancelled) {
            return c.f6275d;
        }
        try {
            Object objO = o(sVar);
            return objO == null ? f6268h : objO;
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

    public static <V> V o(Future<V> future) throws ExecutionException {
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

    @Override // com.google.common.util.concurrent.s
    public final void addListener(Runnable runnable, Executor executor) {
        e(runnable);
        e(executor);
        d dVar = this.f6270b;
        if (dVar != d.f6278d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f6281c = dVar;
                if (f6267g.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.f6270b;
                }
            } while (dVar != d.f6278d);
        }
        l(runnable, executor);
    }

    public final void b(StringBuilder sb2) {
        try {
            Object objO = o(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(x(objO));
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

    public void c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z11) {
        c cVar;
        Object obj = this.f6269a;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        if (f6265d) {
            cVar = new c(z11, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z11 ? c.f6274c : c.f6275d;
        }
        boolean z12 = false;
        AbstractResolvableFuture<V> abstractResolvableFuture = this;
        while (true) {
            if (f6267g.b(abstractResolvableFuture, obj, cVar)) {
                if (z11) {
                    abstractResolvableFuture.p();
                }
                k(abstractResolvableFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                s<? extends V> sVar = ((SetFuture) obj).future;
                if (!(sVar instanceof AbstractResolvableFuture)) {
                    sVar.cancel(z11);
                    return true;
                }
                abstractResolvableFuture = (AbstractResolvableFuture) sVar;
                obj = abstractResolvableFuture.f6269a;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    return true;
                }
                z12 = true;
            } else {
                obj = abstractResolvableFuture.f6269a;
                if (!(obj instanceof SetFuture)) {
                    return z12;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f6269a;
        if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
            return m(obj2);
        }
        g gVar = this.f6271c;
        if (gVar != g.f6287c) {
            g gVar2 = new g();
            do {
                gVar2.a(gVar);
                if (f6267g.c(this, gVar, gVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            u(gVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f6269a;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return m(obj);
                }
                gVar = this.f6271c;
            } while (gVar != g.f6287c);
        }
        return m(this.f6269a);
    }

    @Override // java.util.concurrent.Future
    public final V get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j11);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f6269a;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return m(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            g gVar = this.f6271c;
            if (gVar != g.f6287c) {
                g gVar2 = new g();
                while (true) {
                    gVar2.a(gVar);
                    if (f6267g.c(this, gVar, gVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                u(gVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f6269a;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return m(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        u(gVar2);
                        break;
                    }
                    gVar = this.f6271c;
                    if (gVar == g.f6287c) {
                    }
                }
            }
            return m(this.f6269a);
        }
        while (nanos > 0) {
            Object obj3 = this.f6269a;
            if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                return m(obj3);
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

    public final d h(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f6270b;
        } while (!f6267g.a(this, dVar2, d.f6278d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.f6281c;
            dVar4.f6281c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f6269a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f6269a;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V m(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw d("Task was cancelled.", ((c) obj).f6277b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f6273a);
        }
        if (obj == f6268h) {
            return null;
        }
        return obj;
    }

    public void p() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public String q() {
        Object obj = this.f6269a;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + x(((SetFuture) obj).future) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void t() {
        g gVar;
        do {
            gVar = this.f6271c;
        } while (!f6267g.c(this, gVar, g.f6287c));
        while (gVar != null) {
            gVar.b();
            gVar = gVar.f6289b;
        }
    }

    public String toString() {
        String strQ;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            b(sb2);
        } else {
            try {
                strQ = q();
            } catch (RuntimeException e11) {
                strQ = "Exception thrown from implementation: " + e11.getClass();
            }
            if (strQ != null && !strQ.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(strQ);
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

    public final void u(g gVar) {
        gVar.f6288a = null;
        while (true) {
            g gVar2 = this.f6271c;
            if (gVar2 == g.f6287c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f6289b;
                if (gVar2.f6288a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f6289b = gVar4;
                    if (gVar3.f6288a == null) {
                    }
                } else if (!f6267g.c(this, gVar2, gVar4)) {
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
    public boolean v(@Nullable V v11) {
        if (v11 == null) {
            v11 = (V) f6268h;
        }
        if (!f6267g.b(this, null, v11)) {
            return false;
        }
        k(this);
        return true;
    }

    public boolean w(Throwable th2) {
        if (!f6267g.b(this, null, new Failure((Throwable) e(th2)))) {
            return false;
        }
        k(this);
        return true;
    }

    public final String x(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final boolean y() {
        Object obj = this.f6269a;
        return (obj instanceof c) && ((c) obj).f6276a;
    }
}
