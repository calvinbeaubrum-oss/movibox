package com.google.common.util.concurrent;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.j2objc.annotations.ReflectionSupport;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
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
/* JADX INFO: loaded from: classes.dex */
@ReflectionSupport(ReflectionSupport.Level.FULL)
public abstract class AbstractFuture<V> extends ij.a implements s<V> {
    private static final b ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log;
    private volatile d listeners;
    private volatile Object value;
    private volatile j waiters;

    /* JADX INFO: compiled from: source.java */
    public static final class Failure {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Failure f38850b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Throwable f38851a;

        public Failure(Throwable th2) {
            this.f38851a = (Throwable) com.google.common.base.m.p(th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class SetFuture<V> implements Runnable {
        final s<? extends V> future;
        final AbstractFuture<V> owner;

        public SetFuture(AbstractFuture<V> abstractFuture, s<? extends V> sVar) {
            this.owner = abstractFuture;
            this.future = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractFuture) this.owner).value != this) {
                return;
            }
            if (AbstractFuture.ATOMIC_HELPER.b(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                AbstractFuture.complete(this.owner, false);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture<?> abstractFuture, j jVar, j jVar2);

        public abstract d d(AbstractFuture<?> abstractFuture, d dVar);

        public abstract j e(AbstractFuture<?> abstractFuture, j jVar);

        public abstract void f(j jVar, j jVar2);

        public abstract void g(j jVar, Thread thread);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final c f38852c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final c f38853d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f38854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f38855b;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                f38853d = null;
                f38852c = null;
            } else {
                f38853d = new c(false, null);
                f38852c = new c(true, null);
            }
        }

        public c(boolean z11, Throwable th2) {
            this.f38854a = z11;
            this.f38855b = th2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static final class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final d f38856c = new d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f38857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f38858b;
        d next;

        public d() {
            this.f38857a = null;
            this.f38858b = null;
        }

        public d(Runnable runnable, Executor executor) {
            this.f38857a = runnable;
            this.f38858b = executor;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<j, Thread> f38859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<j, j> f38860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, j> f38861c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, d> f38862d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> f38863e;

        public e(AtomicReferenceFieldUpdater<j, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<j, j> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, j> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f38859a = atomicReferenceFieldUpdater;
            this.f38860b = atomicReferenceFieldUpdater2;
            this.f38861c = atomicReferenceFieldUpdater3;
            this.f38862d = atomicReferenceFieldUpdater4;
            this.f38863e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return androidx.concurrent.futures.a.a(this.f38862d, abstractFuture, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f38863e, abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, j jVar, j jVar2) {
            return androidx.concurrent.futures.a.a(this.f38861c, abstractFuture, jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public d d(AbstractFuture<?> abstractFuture, d dVar) {
            return this.f38862d.getAndSet(abstractFuture, dVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public j e(AbstractFuture<?> abstractFuture, j jVar) {
            return this.f38861c.getAndSet(abstractFuture, jVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void f(j jVar, j jVar2) {
            this.f38860b.lazySet(jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void g(j jVar, Thread thread) {
            this.f38859a.lazySet(jVar, thread);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static final class f extends b {
        public f() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
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

        @Override // com.google.common.util.concurrent.AbstractFuture.b
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

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, j jVar, j jVar2) {
            synchronized (abstractFuture) {
                try {
                    if (((AbstractFuture) abstractFuture).waiters != jVar) {
                        return false;
                    }
                    ((AbstractFuture) abstractFuture).waiters = jVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public d d(AbstractFuture<?> abstractFuture, d dVar) {
            d dVar2;
            synchronized (abstractFuture) {
                try {
                    dVar2 = ((AbstractFuture) abstractFuture).listeners;
                    if (dVar2 != dVar) {
                        ((AbstractFuture) abstractFuture).listeners = dVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return dVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public j e(AbstractFuture<?> abstractFuture, j jVar) {
            j jVar2;
            synchronized (abstractFuture) {
                try {
                    jVar2 = ((AbstractFuture) abstractFuture).waiters;
                    if (jVar2 != jVar) {
                        ((AbstractFuture) abstractFuture).waiters = jVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return jVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void f(j jVar, j jVar2) {
            jVar.next = jVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void g(j jVar, Thread thread) {
            jVar.thread = thread;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public interface g<V> extends s<V> {
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static abstract class h<V> extends AbstractFuture<V> implements g<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.s
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z11) {
            return super.cancel(z11);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j11, timeUnit);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean isDone() {
            return super.isDone();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static final class i extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Unsafe f38864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final long f38865b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final long f38866c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final long f38867d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final long f38868e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f38869f;

        /* JADX INFO: compiled from: source.java */
        public class a implements PrivilegedExceptionAction<Unsafe> {
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
                f38866c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
                f38865b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
                f38867d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                f38868e = unsafe.objectFieldOffset(j.class.getDeclaredField("thread"));
                f38869f = unsafe.objectFieldOffset(j.class.getDeclaredField("next"));
                f38864a = unsafe;
            } catch (NoSuchFieldException e12) {
                throw new RuntimeException(e12);
            } catch (RuntimeException e13) {
                throw e13;
            }
        }

        public i() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return com.google.android.gms.internal.ads.k.a(f38864a, abstractFuture, f38865b, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return com.google.android.gms.internal.ads.k.a(f38864a, abstractFuture, f38867d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, j jVar, j jVar2) {
            return com.google.android.gms.internal.ads.k.a(f38864a, abstractFuture, f38866c, jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public d d(AbstractFuture<?> abstractFuture, d dVar) {
            d dVar2;
            do {
                dVar2 = ((AbstractFuture) abstractFuture).listeners;
                if (dVar == dVar2) {
                    return dVar2;
                }
            } while (!a(abstractFuture, dVar2, dVar));
            return dVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public j e(AbstractFuture<?> abstractFuture, j jVar) {
            j jVar2;
            do {
                jVar2 = ((AbstractFuture) abstractFuture).waiters;
                if (jVar == jVar2) {
                    return jVar2;
                }
            } while (!c(abstractFuture, jVar2, jVar));
            return jVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void f(j jVar, j jVar2) {
            f38864a.putObject(jVar, f38869f, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void g(j jVar, Thread thread) {
            f38864a.putObject(jVar, f38868e, thread);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final j f38870a = new j(false);
        volatile j next;
        volatile Thread thread;

        public j() {
            AbstractFuture.ATOMIC_HELPER.g(this, Thread.currentThread());
        }

        public j(boolean z11) {
        }

        public void a(j jVar) {
            AbstractFuture.ATOMIC_HELPER.f(this, jVar);
        }

        public void b() {
            Thread thread = this.thread;
            if (thread != null) {
                this.thread = null;
                LockSupport.unpark(thread);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.common.util.concurrent.AbstractFuture$a] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    static {
        boolean z11;
        b fVar;
        try {
            z11 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z11 = false;
        }
        GENERATE_CANCELLATION_CAUSES = z11;
        log = Logger.getLogger(AbstractFuture.class.getName());
        ?? r11 = 0;
        r11 = 0;
        try {
            fVar = new i();
            e = null;
        } catch (Error | RuntimeException e11) {
            e = e11;
            try {
                fVar = new e(AtomicReferenceFieldUpdater.newUpdater(j.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(j.class, j.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, j.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, AppMeasurementSdk.ConditionalUserProperty.VALUE));
            } catch (Error | RuntimeException e12) {
                fVar = new f();
                r11 = e12;
            }
        }
        ATOMIC_HELPER = fVar;
        if (r11 != 0) {
            ?? r12 = log;
            Level level = Level.SEVERE;
            r12.log(level, "UnsafeAtomicHelper is broken!", e);
            r12.log(level, "SafeAtomicHelper is broken!", r11);
        }
        NULL = new Object();
    }

    private void addDoneString(StringBuilder sb2) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb2.append("SUCCESS, result=[");
            appendResultObject(sb2, uninterruptibly);
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

    private void addPendingString(StringBuilder sb2) {
        String strA;
        int length = sb2.length();
        sb2.append("PENDING");
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            sb2.append(", setFuture=[");
            appendUserObject(sb2, ((SetFuture) obj).future);
            sb2.append("]");
        } else {
            try {
                strA = com.google.common.base.p.a(pendingToString());
            } catch (RuntimeException | StackOverflowError e11) {
                strA = "Exception thrown from implementation: " + e11.getClass();
            }
            if (strA != null) {
                sb2.append(", info=[");
                sb2.append(strA);
                sb2.append("]");
            }
        }
        if (isDone()) {
            sb2.delete(length, sb2.length());
            addDoneString(sb2);
        }
    }

    private void appendResultObject(StringBuilder sb2, Object obj) {
        if (obj == null) {
            sb2.append("null");
        } else {
            if (obj == this) {
                sb2.append("this future");
                return;
            }
            sb2.append(obj.getClass().getName());
            sb2.append("@");
            sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    private void appendUserObject(StringBuilder sb2, Object obj) {
        try {
            if (obj == this) {
                sb2.append("this future");
            } else {
                sb2.append(obj);
            }
        } catch (RuntimeException e11) {
            e = e11;
            sb2.append("Exception thrown from implementation: ");
            sb2.append(e.getClass());
        } catch (StackOverflowError e12) {
            e = e12;
            sb2.append("Exception thrown from implementation: ");
            sb2.append(e.getClass());
        }
    }

    private static CancellationException cancellationExceptionWithCause(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    private d clearListeners(d dVar) {
        d dVar2 = dVar;
        d dVarD = ATOMIC_HELPER.d(this, d.f38856c);
        while (dVarD != null) {
            d dVar3 = dVarD.next;
            dVarD.next = dVar2;
            dVar2 = dVarD;
            dVarD = dVar3;
        }
        return dVar2;
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
    public static void complete(AbstractFuture<?> abstractFuture, boolean z11) {
        d dVar = null;
        while (true) {
            abstractFuture.releaseWaiters();
            if (z11) {
                abstractFuture.interruptTask();
                z11 = false;
            }
            abstractFuture.afterDone();
            d dVarClearListeners = abstractFuture.clearListeners(dVar);
            while (dVarClearListeners != null) {
                dVar = dVarClearListeners.next;
                Runnable runnable = dVarClearListeners.f38857a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable2;
                    abstractFuture = setFuture.owner;
                    if (((AbstractFuture) abstractFuture).value == setFuture) {
                        if (ATOMIC_HELPER.b(abstractFuture, setFuture, getFutureValue(setFuture.future))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = dVarClearListeners.f38858b;
                    Objects.requireNonNull(executor);
                    executeListener(runnable2, executor);
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
            throw cancellationExceptionWithCause("Task was cancelled.", ((c) obj).f38855b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f38851a);
        }
        return obj == NULL ? (V) x.b() : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object getFutureValue(s<?> sVar) {
        Throwable thA;
        if (sVar instanceof g) {
            Object cVar = ((AbstractFuture) sVar).value;
            if (cVar instanceof c) {
                c cVar2 = (c) cVar;
                if (cVar2.f38854a) {
                    cVar = cVar2.f38855b != null ? new c(false, cVar2.f38855b) : c.f38853d;
                }
            }
            Objects.requireNonNull(cVar);
            return cVar;
        }
        if ((sVar instanceof ij.a) && (thA = ij.b.a((ij.a) sVar)) != null) {
            return new Failure(thA);
        }
        boolean zIsCancelled = sVar.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && zIsCancelled) {
            c cVar3 = c.f38853d;
            Objects.requireNonNull(cVar3);
            return cVar3;
        }
        try {
            Object uninterruptibly = getUninterruptibly(sVar);
            if (!zIsCancelled) {
                return uninterruptibly == null ? NULL : uninterruptibly;
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + sVar));
        } catch (Error e11) {
            e = e11;
            return new Failure(e);
        } catch (CancellationException e12) {
            if (zIsCancelled) {
                return new c(false, e12);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + sVar, e12));
        } catch (RuntimeException e13) {
            e = e13;
            return new Failure(e);
        } catch (ExecutionException e14) {
            if (!zIsCancelled) {
                return new Failure(e14.getCause());
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + sVar, e14));
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
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

    private void releaseWaiters() {
        for (j jVarE = ATOMIC_HELPER.e(this, j.f38870a); jVarE != null; jVarE = jVarE.next) {
            jVarE.b();
        }
    }

    private void removeWaiter(j jVar) {
        jVar.thread = null;
        while (true) {
            j jVar2 = this.waiters;
            if (jVar2 == j.f38870a) {
                return;
            }
            j jVar3 = null;
            while (jVar2 != null) {
                j jVar4 = jVar2.next;
                if (jVar2.thread != null) {
                    jVar3 = jVar2;
                } else if (jVar3 != null) {
                    jVar3.next = jVar4;
                    if (jVar3.thread == null) {
                    }
                } else if (!ATOMIC_HELPER.c(this, jVar2, jVar4)) {
                }
                jVar2 = jVar4;
            }
            return;
        }
    }

    @Override // com.google.common.util.concurrent.s
    public void addListener(Runnable runnable, Executor executor) {
        d dVar;
        com.google.common.base.m.q(runnable, "Runnable was null.");
        com.google.common.base.m.q(executor, "Executor was null.");
        if (!isDone() && (dVar = this.listeners) != d.f38856c) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.next = dVar;
                if (ATOMIC_HELPER.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.listeners;
                }
            } while (dVar != d.f38856c);
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
            cVar = z11 ? c.f38852c : c.f38853d;
            Objects.requireNonNull(cVar);
        }
        boolean z12 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (ATOMIC_HELPER.b(abstractFuture, obj, cVar)) {
                complete(abstractFuture, z11);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                s<? extends V> sVar = ((SetFuture) obj).future;
                if (!(sVar instanceof g)) {
                    sVar.cancel(z11);
                    return true;
                }
                abstractFuture = (AbstractFuture) sVar;
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
        j jVar = this.waiters;
        if (jVar != j.f38870a) {
            j jVar2 = new j();
            do {
                jVar2.a(jVar);
                if (ATOMIC_HELPER.c(this, jVar, jVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            removeWaiter(jVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return getDoneValue(obj);
                }
                jVar = this.waiters;
            } while (jVar != j.f38870a);
        }
        Object obj3 = this.value;
        Objects.requireNonNull(obj3);
        return getDoneValue(obj3);
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
            j jVar = this.waiters;
            if (jVar != j.f38870a) {
                j jVar2 = new j();
                while (true) {
                    jVar2.a(jVar);
                    if (ATOMIC_HELPER.c(this, jVar, jVar2)) {
                        do {
                            y.a(this, nanos);
                            if (Thread.interrupted()) {
                                removeWaiter(jVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return getDoneValue(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        removeWaiter(jVar2);
                        break;
                    }
                    jVar = this.waiters;
                    if (jVar == j.f38870a) {
                    }
                }
            }
            Object obj3 = this.value;
            Objects.requireNonNull(obj3);
            return getDoneValue(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.value;
            if ((obj4 != null) && (!(obj4 instanceof SetFuture))) {
                return getDoneValue(obj4);
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
        complete(this, false);
        return true;
    }

    public boolean setException(Throwable th2) {
        if (!ATOMIC_HELPER.b(this, null, new Failure((Throwable) com.google.common.base.m.p(th2)))) {
            return false;
        }
        complete(this, false);
        return true;
    }

    public boolean setFuture(s<? extends V> sVar) {
        Failure failure;
        com.google.common.base.m.p(sVar);
        Object obj = this.value;
        if (obj == null) {
            if (sVar.isDone()) {
                if (!ATOMIC_HELPER.b(this, null, getFutureValue(sVar))) {
                    return false;
                }
                complete(this, false);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, sVar);
            if (ATOMIC_HELPER.b(this, null, setFuture)) {
                try {
                    sVar.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Error | RuntimeException e11) {
                    try {
                        failure = new Failure(e11);
                    } catch (Error | RuntimeException unused) {
                        failure = Failure.f38850b;
                    }
                    ATOMIC_HELPER.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            sVar.cancel(((c) obj).f38854a);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb2.append(getClass().getSimpleName());
        } else {
            sb2.append(getClass().getName());
        }
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb2);
        } else {
            addPendingString(sb2);
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // ij.a
    public final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof g)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof Failure) {
            return ((Failure) obj).f38851a;
        }
        return null;
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof c) && ((c) obj).f38854a;
    }
}
