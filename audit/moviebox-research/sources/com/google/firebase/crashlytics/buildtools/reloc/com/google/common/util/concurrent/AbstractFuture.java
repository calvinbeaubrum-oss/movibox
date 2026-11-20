package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
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
import sun.misc.Unsafe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractFuture<V> extends a0<V> {
    private static final b ATOMIC_HELPER;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private volatile d listeners;
    private volatile Object value;
    private volatile i waiters;
    private static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());

    /* JADX INFO: compiled from: source.java */
    public static final class Failure {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Failure f39924b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f39925a;

        public Failure(Throwable th2) {
            this.f39925a = (Throwable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class SetFuture<V> implements Runnable {
        final i0<? extends V> future;
        final AbstractFuture<V> owner;

        public SetFuture(AbstractFuture<V> abstractFuture, i0<? extends V> i0Var) {
            this.owner = abstractFuture;
            this.future = i0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractFuture) this.owner).value != this) {
                return;
            }
            if (AbstractFuture.ATOMIC_HELPER.b(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                AbstractFuture.complete(this.owner);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture<?> abstractFuture, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f39926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f39927d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f39928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f39929b;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                f39927d = null;
                f39926c = null;
            } else {
                f39927d = new c(false, null);
                f39926c = new c(true, null);
            }
        }

        public c(boolean z11, Throwable th2) {
            this.f39928a = z11;
            this.f39929b = th2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f39930d = new d(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f39931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f39932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f39933c;

        public d(Runnable runnable, Executor executor) {
            this.f39931a = runnable;
            this.f39932b = executor;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<i, Thread> f39934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<i, i> f39935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, i> f39936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, d> f39937d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> f39938e;

        public e(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f39934a = atomicReferenceFieldUpdater;
            this.f39935b = atomicReferenceFieldUpdater2;
            this.f39936c = atomicReferenceFieldUpdater3;
            this.f39937d = atomicReferenceFieldUpdater4;
            this.f39938e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return androidx.concurrent.futures.a.a(this.f39937d, abstractFuture, dVar, dVar2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f39938e, abstractFuture, obj, obj2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, i iVar, i iVar2) {
            return androidx.concurrent.futures.a.a(this.f39936c, abstractFuture, iVar, iVar2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public void d(i iVar, i iVar2) {
            this.f39935b.lazySet(iVar, iVar2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public void e(i iVar, Thread thread) {
            this.f39934a.lazySet(iVar, thread);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f extends b {
        public f() {
            super();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            synchronized (abstractFuture) {
                try {
                    if (((AbstractFuture) abstractFuture).listeners != dVar) {
                        return false;
                    }
                    ((AbstractFuture) abstractFuture).listeners = dVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (((AbstractFuture) abstractFuture).value != obj) {
                        return false;
                    }
                    ((AbstractFuture) abstractFuture).value = obj2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, i iVar, i iVar2) {
            synchronized (abstractFuture) {
                try {
                    if (((AbstractFuture) abstractFuture).waiters != iVar) {
                        return false;
                    }
                    ((AbstractFuture) abstractFuture).waiters = iVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public void d(i iVar, i iVar2) {
            iVar.f39947b = iVar2;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public void e(i iVar, Thread thread) {
            iVar.f39946a = thread;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class g<V> extends AbstractFuture<V> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.i0
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z11) {
            return super.cancel(z11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j11, timeUnit);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Unsafe f39939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final long f39940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final long f39941c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f39942d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final long f39943e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final long f39944f;

        /* JADX INFO: compiled from: source.java */
        public static class a implements PrivilegedExceptionAction<Unsafe> {
            @Override // java.security.PrivilegedExceptionAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e11) {
                    throw new RuntimeException("Could not initialize intrinsics", e11.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
            }
            try {
                f39941c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
                f39940b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
                f39942d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                f39943e = unsafe.objectFieldOffset(i.class.getDeclaredField("a"));
                f39944f = unsafe.objectFieldOffset(i.class.getDeclaredField(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B));
                f39939a = unsafe;
            } catch (Exception e12) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.r.f(e12);
                throw new RuntimeException(e12);
            }
        }

        public h() {
            super();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return com.google.android.gms.internal.ads.k.a(f39939a, abstractFuture, f39940b, dVar, dVar2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return com.google.android.gms.internal.ads.k.a(f39939a, abstractFuture, f39942d, obj, obj2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, i iVar, i iVar2) {
            return com.google.android.gms.internal.ads.k.a(f39939a, abstractFuture, f39941c, iVar, iVar2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public void d(i iVar, i iVar2) {
            f39939a.putObject(iVar, f39944f, iVar2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture.b
        public void e(i iVar, Thread thread) {
            f39939a.putObject(iVar, f39943e, thread);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f39945c = new i(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f39946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile i f39947b;

        public i() {
            AbstractFuture.ATOMIC_HELPER.e(this, Thread.currentThread());
        }

        public i(boolean z11) {
        }

        public void a(i iVar) {
            AbstractFuture.ATOMIC_HELPER.d(this, iVar);
        }

        public void b() {
            Thread thread = this.f39946a;
            if (thread != null) {
                this.f39946a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture$a] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    static {
        b fVar;
        ?? r11 = 0;
        r11 = 0;
        try {
            fVar = new h();
            th = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                fVar = new e(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, i.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, AppMeasurementSdk.ConditionalUserProperty.VALUE));
            } catch (Throwable th3) {
                fVar = new f();
                r11 = th3;
            }
        }
        ATOMIC_HELPER = fVar;
        if (r11 != 0) {
            ?? r12 = log;
            Level level = Level.SEVERE;
            r12.log(level, "UnsafeAtomicHelper is broken!", th);
            r12.log(level, "SafeAtomicHelper is broken!", r11);
        }
        NULL = new Object();
    }

    private void addDoneString(StringBuilder sb2) {
        try {
            Object objD = Futures.d(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(userObjectToString(objD));
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

    private static CancellationException cancellationExceptionWithCause(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    private d clearListeners(d dVar) {
        d dVar2;
        do {
            dVar2 = this.listeners;
        } while (!ATOMIC_HELPER.a(this, dVar2, d.f39930d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.f39933c;
            dVar4.f39933c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
    public static void complete(AbstractFuture<?> abstractFuture) {
        d dVar = null;
        while (true) {
            abstractFuture.releaseWaiters();
            abstractFuture.afterDone();
            d dVarClearListeners = abstractFuture.clearListeners(dVar);
            while (dVarClearListeners != null) {
                dVar = dVarClearListeners.f39933c;
                Runnable runnable = dVarClearListeners.f39931a;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractFuture = setFuture.owner;
                    if (((AbstractFuture) abstractFuture).value == setFuture) {
                        if (ATOMIC_HELPER.b(abstractFuture, setFuture, getFutureValue(setFuture.future))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    executeListener(runnable, dVarClearListeners.f39932b);
                }
                dVarClearListeners = dVar;
            }
            return;
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((c) obj).f39929b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f39925a);
        }
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getFutureValue(i0<?> i0Var) {
        Object failure;
        if (i0Var instanceof g) {
            Object obj = ((AbstractFuture) i0Var).value;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.f39928a) {
                return cVar.f39929b != null ? new c(false, cVar.f39929b) : c.f39927d;
            }
            return obj;
        }
        try {
            Object objD = Futures.d(i0Var);
            return objD == null ? NULL : objD;
        } catch (CancellationException e11) {
            failure = new c(false, e11);
            return failure;
        } catch (ExecutionException e12) {
            failure = new Failure(e12.getCause());
            return failure;
        } catch (Throwable th2) {
            failure = new Failure(th2);
            return failure;
        }
    }

    private void releaseWaiters() {
        i iVar;
        do {
            iVar = this.waiters;
        } while (!ATOMIC_HELPER.c(this, iVar, i.f39945c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f39947b;
        }
    }

    private void removeWaiter(i iVar) {
        iVar.f39946a = null;
        while (true) {
            i iVar2 = this.waiters;
            if (iVar2 == i.f39945c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f39947b;
                if (iVar2.f39946a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f39947b = iVar4;
                    if (iVar3.f39946a == null) {
                    }
                } else if (!ATOMIC_HELPER.c(this, iVar2, iVar4)) {
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    private String userObjectToString(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.i0
    public void addListener(Runnable runnable, Executor executor) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(runnable, "Runnable was null.");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(executor, "Executor was null.");
        d dVar = this.listeners;
        if (dVar != d.f39930d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f39933c = dVar;
                if (ATOMIC_HELPER.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.listeners;
                }
            } while (dVar != d.f39930d);
        }
        executeListener(runnable, executor);
    }

    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z11) {
        c cVar;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            cVar = new c(z11, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z11 ? c.f39926c : c.f39927d;
        }
        boolean z12 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (ATOMIC_HELPER.b(abstractFuture, obj, cVar)) {
                if (z11) {
                    abstractFuture.interruptTask();
                }
                complete(abstractFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                i0<? extends V> i0Var = ((SetFuture) obj).future;
                if (!(i0Var instanceof g)) {
                    i0Var.cancel(z11);
                    return true;
                }
                abstractFuture = (AbstractFuture) i0Var;
                obj = abstractFuture.value;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    return true;
                }
                z12 = true;
            } else {
                obj = abstractFuture.value;
                if (!(obj instanceof SetFuture)) {
                    return z12;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
            return getDoneValue(obj2);
        }
        i iVar = this.waiters;
        if (iVar != i.f39945c) {
            i iVar2 = new i();
            do {
                iVar2.a(iVar);
                if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            removeWaiter(iVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return getDoneValue(obj);
                }
                iVar = this.waiters;
            } while (iVar != i.f39945c);
        }
        return getDoneValue(this.value);
    }

    @Override // java.util.concurrent.Future
    public V get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j11);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return getDoneValue(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.waiters;
            if (iVar != i.f39945c) {
                i iVar2 = new i();
                while (true) {
                    iVar2.a(iVar);
                    if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                removeWaiter(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return getDoneValue(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        removeWaiter(iVar2);
                        break;
                    }
                    iVar = this.waiters;
                    if (iVar == i.f39945c) {
                    }
                }
            }
            return getDoneValue(this.value);
        }
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                return getDoneValue(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        if (isDone()) {
            throw new TimeoutException("Waited " + j11 + " " + com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.a.c(timeUnit.toString()) + " but future completed as timeout expired");
        }
        throw new TimeoutException("Waited " + j11 + " " + com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.a.c(timeUnit.toString()) + " for " + string);
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    public final void maybePropagateCancellationTo(Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + userObjectToString(((SetFuture) obj).future) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
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
    public boolean set(V v11) {
        if (v11 == null) {
            v11 = (V) NULL;
        }
        if (!ATOMIC_HELPER.b(this, null, v11)) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setException(Throwable th2) {
        if (!ATOMIC_HELPER.b(this, null, new Failure((Throwable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(th2)))) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setFuture(i0<? extends V> i0Var) {
        Failure failure;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(i0Var);
        Object obj = this.value;
        if (obj == null) {
            if (i0Var.isDone()) {
                if (!ATOMIC_HELPER.b(this, null, getFutureValue(i0Var))) {
                    return false;
                }
                complete(this);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, i0Var);
            if (ATOMIC_HELPER.b(this, null, setFuture)) {
                try {
                    i0Var.addListener(setFuture, MoreExecutors.a());
                } catch (Throwable th2) {
                    try {
                        failure = new Failure(th2);
                    } catch (Throwable unused) {
                        failure = Failure.f39924b;
                    }
                    ATOMIC_HELPER.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            i0Var.cancel(((c) obj).f39928a);
        }
        return false;
    }

    public String toString() {
        String strPendingToString;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb2);
        } else {
            try {
                strPendingToString = pendingToString();
            } catch (RuntimeException e11) {
                strPendingToString = "Exception thrown from implementation: " + e11.getClass();
            }
            if (!com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.p.a(strPendingToString)) {
                sb2.append("PENDING, info=[");
                sb2.append(strPendingToString);
                sb2.append("]");
            } else if (isDone()) {
                addDoneString(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public final Throwable trustedGetException() {
        return ((Failure) this.value).f39925a;
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof c) && ((c) obj).f39928a;
    }
}
