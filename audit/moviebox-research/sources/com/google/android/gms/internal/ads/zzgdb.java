package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.util.concurrent.s;
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
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgdb<V> extends zzgfq implements s<V> {
    private static final Object zzaZ;
    private static final zza zzbc;
    static final boolean zzd;
    static final zzgex zze;
    private volatile zzd listeners;
    private volatile Object value;
    private volatile zzk waiters;

    /* JADX INFO: compiled from: source.java */
    abstract class zza {
        public /* synthetic */ zza(zzgda zzgdaVar) {
        }

        public abstract zzd zza(zzgdb zzgdbVar, zzd zzdVar);

        public abstract zzk zzb(zzgdb zzgdbVar, zzk zzkVar);

        public abstract void zzc(zzk zzkVar, zzk zzkVar2);

        public abstract void zzd(zzk zzkVar, Thread thread);

        public abstract boolean zze(zzgdb zzgdbVar, zzd zzdVar, zzd zzdVar2);

        public abstract boolean zzf(zzgdb zzgdbVar, Object obj, Object obj2);

        public abstract boolean zzg(zzgdb zzgdbVar, zzk zzkVar, zzk zzkVar2);
    }

    /* JADX INFO: compiled from: source.java */
    final class zzb {
        static final zzb zza;
        static final zzb zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzgdb.zzd) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zzb(false, null);
                zza = new zzb(true, null);
            }
        }

        public zzb(boolean z11, Throwable th2) {
            this.zzc = z11;
            this.zzd = th2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzgdb.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        public zzc(Throwable th2) {
            th2.getClass();
            this.zzb = th2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        public zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        public zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* JADX INFO: compiled from: source.java */
    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<zzgdb, zzk> zzc;
        final AtomicReferenceFieldUpdater<zzgdb, zzd> zzd;
        final AtomicReferenceFieldUpdater<zzgdb, Object> zze;

        public zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super(null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final zzd zza(zzgdb zzgdbVar, zzd zzdVar) {
            return this.zzd.getAndSet(zzgdbVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final zzk zzb(zzgdb zzgdbVar, zzk zzkVar) {
            return this.zzc.getAndSet(zzgdbVar, zzkVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final void zzc(zzk zzkVar, zzk zzkVar2) {
            this.zzb.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final void zzd(zzk zzkVar, Thread thread) {
            this.zza.lazySet(zzkVar, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final boolean zze(zzgdb zzgdbVar, zzd zzdVar, zzd zzdVar2) {
            return zzgdc.zza(this.zzd, zzgdbVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final boolean zzf(zzgdb zzgdbVar, Object obj, Object obj2) {
            return zzgdc.zza(this.zze, zzgdbVar, obj, obj2);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final boolean zzg(zzgdb zzgdbVar, zzk zzkVar, zzk zzkVar2) {
            return zzgdc.zza(this.zzc, zzgdbVar, zzkVar, zzkVar2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    final class zzf<V> implements Runnable {
        final zzgdb<V> zza;
        final s<? extends V> zzb;

        public zzf(zzgdb zzgdbVar, s sVar) {
            this.zza = zzgdbVar;
            this.zzb = sVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((zzgdb) this.zza).value != this) {
                return;
            }
            s<? extends V> sVar = this.zzb;
            if (zzgdb.zzbc.zzf(this.zza, this, zzgdb.zze(sVar))) {
                zzgdb.zzx(this.zza, false);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    final class zzg extends zza {
        private zzg() {
            super(null);
        }

        public /* synthetic */ zzg(zzgdd zzgddVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final zzd zza(zzgdb zzgdbVar, zzd zzdVar) {
            zzd zzdVar2;
            synchronized (zzgdbVar) {
                try {
                    zzdVar2 = zzgdbVar.listeners;
                    if (zzdVar2 != zzdVar) {
                        zzgdbVar.listeners = zzdVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final zzk zzb(zzgdb zzgdbVar, zzk zzkVar) {
            zzk zzkVar2;
            synchronized (zzgdbVar) {
                try {
                    zzkVar2 = zzgdbVar.waiters;
                    if (zzkVar2 != zzkVar) {
                        zzgdbVar.waiters = zzkVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final void zzc(zzk zzkVar, zzk zzkVar2) {
            zzkVar.next = zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final void zzd(zzk zzkVar, Thread thread) {
            zzkVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final boolean zze(zzgdb zzgdbVar, zzd zzdVar, zzd zzdVar2) {
            synchronized (zzgdbVar) {
                try {
                    if (zzgdbVar.listeners != zzdVar) {
                        return false;
                    }
                    zzgdbVar.listeners = zzdVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final boolean zzf(zzgdb zzgdbVar, Object obj, Object obj2) {
            synchronized (zzgdbVar) {
                try {
                    if (zzgdbVar.value != obj) {
                        return false;
                    }
                    zzgdbVar.value = obj2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final boolean zzg(zzgdb zzgdbVar, zzk zzkVar, zzk zzkVar2) {
            synchronized (zzgdbVar) {
                try {
                    if (zzgdbVar.waiters != zzkVar) {
                        return false;
                    }
                    zzgdbVar.waiters = zzkVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    interface zzh<V> extends s<V> {
        @Override // com.google.common.util.concurrent.s
        /* synthetic */ void addListener(Runnable runnable, Executor executor);
    }

    /* JADX INFO: compiled from: source.java */
    abstract class zzi<V> extends zzgdb<V> implements zzh<V> {
    }

    /* JADX INFO: compiled from: source.java */
    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e11) {
                    throw new RuntimeException("Could not initialize intrinsics", e11.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.ads.zzgdb.zzj.1
                    @Override // java.security.PrivilegedExceptionAction
                    public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
            try {
                zzc = unsafe.objectFieldOffset(zzgdb.class.getDeclaredField("waiters"));
                zzb = unsafe.objectFieldOffset(zzgdb.class.getDeclaredField("listeners"));
                zzd = unsafe.objectFieldOffset(zzgdb.class.getDeclaredField(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                zze = unsafe.objectFieldOffset(zzk.class.getDeclaredField("thread"));
                zzf = unsafe.objectFieldOffset(zzk.class.getDeclaredField("next"));
                zza = unsafe;
            } catch (NoSuchFieldException e12) {
                throw new RuntimeException(e12);
            }
        }

        private zzj() {
            super(null);
        }

        public /* synthetic */ zzj(zzgdf zzgdfVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final zzd zza(zzgdb zzgdbVar, zzd zzdVar) {
            zzd zzdVar2;
            do {
                zzdVar2 = zzgdbVar.listeners;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zze(zzgdbVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final zzk zzb(zzgdb zzgdbVar, zzk zzkVar) {
            zzk zzkVar2;
            do {
                zzkVar2 = zzgdbVar.waiters;
                if (zzkVar == zzkVar2) {
                    break;
                }
            } while (!zzg(zzgdbVar, zzkVar2, zzkVar));
            return zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final void zzc(zzk zzkVar, zzk zzkVar2) {
            zza.putObject(zzkVar, zzf, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final void zzd(zzk zzkVar, Thread thread) {
            zza.putObject(zzkVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final boolean zze(zzgdb zzgdbVar, zzd zzdVar, zzd zzdVar2) {
            return zzgde.zza(zza, zzgdbVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final boolean zzf(zzgdb zzgdbVar, Object obj, Object obj2) {
            return zzgde.zza(zza, zzgdbVar, zzd, obj, obj2);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        public final boolean zzg(zzgdb zzgdbVar, zzk zzkVar, zzk zzkVar2) {
            return zzgde.zza(zza, zzgdbVar, zzc, zzkVar, zzkVar2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    final class zzk {
        static final zzk zza = new zzk(false);
        volatile zzk next;
        volatile Thread thread;

        public zzk() {
            zzgdb.zzbc.zzd(this, Thread.currentThread());
        }

        public zzk(boolean z11) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        boolean z11;
        Throwable th2;
        Throwable th3;
        zza zzgVar;
        try {
            z11 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z11 = false;
        }
        zzd = z11;
        zze = new zzgex(zzgdb.class);
        Object[] objArr = 0;
        try {
            zzgVar = new zzj(null);
            th3 = null;
            th2 = null;
        } catch (Error | Exception e11) {
            try {
                th2 = null;
                th3 = e11;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzgdb.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzgdb.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzgdb.class, Object.class, AppMeasurementSdk.ConditionalUserProperty.VALUE));
            } catch (Error | Exception e12) {
                th2 = e12;
                th3 = e11;
                zzgVar = new zzg(objArr == true ? 1 : 0);
            }
        }
        zzbc = zzgVar;
        if (th2 != null) {
            zzgex zzgexVar = zze;
            Logger loggerZza = zzgexVar.zza();
            Level level = Level.SEVERE;
            loggerZza.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th3);
            zzgexVar.zza().logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
        zzaZ = new Object();
    }

    private static final Object zzA(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th2 = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th2);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzaZ) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object zze(s sVar) {
        Throwable thZzl;
        if (sVar instanceof zzh) {
            Object zzbVar = ((zzgdb) sVar).value;
            if (zzbVar instanceof zzb) {
                zzb zzbVar2 = (zzb) zzbVar;
                if (zzbVar2.zzc) {
                    Throwable th2 = zzbVar2.zzd;
                    zzbVar = th2 != null ? new zzb(false, th2) : zzb.zzb;
                }
            }
            Objects.requireNonNull(zzbVar);
            return zzbVar;
        }
        if ((sVar instanceof zzgfq) && (thZzl = ((zzgfq) sVar).zzl()) != null) {
            return new zzc(thZzl);
        }
        boolean zIsCancelled = sVar.isCancelled();
        if ((!zzd) && zIsCancelled) {
            zzb zzbVar3 = zzb.zzb;
            Objects.requireNonNull(zzbVar3);
            return zzbVar3;
        }
        try {
            Object objZzf = zzf(sVar);
            if (!zIsCancelled) {
                return objZzf == null ? zzaZ : objZzf;
            }
            return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(sVar)));
        } catch (Error e11) {
            e = e11;
            return new zzc(e);
        } catch (CancellationException e12) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(sVar)), e12)) : new zzb(false, e12);
        } catch (ExecutionException e13) {
            return zIsCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(sVar)), e13)) : new zzc(e13.getCause());
        } catch (Exception e14) {
            e = e14;
            return new zzc(e);
        }
    }

    private static Object zzf(Future future) throws ExecutionException {
        Object obj;
        boolean z11 = false;
        while (true) {
            try {
                obj = future.get();
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
        return obj;
    }

    private final void zzu(StringBuilder sb2) {
        try {
            Object objZzf = zzf(this);
            sb2.append("SUCCESS, result=[");
            if (objZzf == null) {
                sb2.append("null");
            } else if (objZzf == this) {
                sb2.append("this future");
            } else {
                sb2.append(objZzf.getClass().getName());
                sb2.append("@");
                sb2.append(Integer.toHexString(System.identityHashCode(objZzf)));
            }
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        } catch (Exception e12) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e12.getClass());
            sb2.append(" thrown from get()]");
        }
    }

    private final void zzv(StringBuilder sb2) {
        String strConcat;
        int length = sb2.length();
        sb2.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb2.append(", setFuture=[");
            zzw(sb2, ((zzf) obj).zzb);
            sb2.append("]");
        } else {
            try {
                strConcat = zzfxt.zza(zza());
            } catch (Exception | StackOverflowError e11) {
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(e11.getClass()));
            }
            if (strConcat != null) {
                sb2.append(", info=[");
                sb2.append(strConcat);
                sb2.append("]");
            }
        }
        if (isDone()) {
            sb2.delete(length, sb2.length());
            zzu(sb2);
        }
    }

    private final void zzw(StringBuilder sb2, Object obj) {
        try {
            if (obj == this) {
                sb2.append("this future");
            } else {
                sb2.append(obj);
            }
        } catch (Exception e11) {
            e = e11;
            sb2.append("Exception thrown from implementation: ");
            sb2.append(e.getClass());
        } catch (StackOverflowError e12) {
            e = e12;
            sb2.append("Exception thrown from implementation: ");
            sb2.append(e.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzx(zzgdb zzgdbVar, boolean z11) {
        zzd zzdVar = null;
        while (true) {
            for (zzk zzkVarZzb = zzbc.zzb(zzgdbVar, zzk.zza); zzkVarZzb != null; zzkVarZzb = zzkVarZzb.next) {
                Thread thread = zzkVarZzb.thread;
                if (thread != null) {
                    zzkVarZzb.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z11) {
                zzgdbVar.zzq();
            }
            zzgdbVar.zzb();
            zzd zzdVar2 = zzdVar;
            zzd zzdVarZza = zzbc.zza(zzgdbVar, zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zzdVarZza != null) {
                zzd zzdVar4 = zzdVarZza.next;
                zzdVarZza.next = zzdVar3;
                zzdVar3 = zzdVarZza;
                zzdVarZza = zzdVar4;
            }
            while (zzdVar3 != null) {
                zzdVar = zzdVar3.next;
                Runnable runnable = zzdVar3.zzb;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof zzf) {
                    zzf zzfVar = (zzf) runnable2;
                    zzgdbVar = zzfVar.zza;
                    if (zzgdbVar.value == zzfVar) {
                        if (zzbc.zzf(zzgdbVar, zzfVar, zze(zzfVar.zzb))) {
                            z11 = false;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzdVar3.zzc;
                    Objects.requireNonNull(executor);
                    zzy(runnable2, executor);
                }
                zzdVar3 = zzdVar;
            }
            return;
        }
    }

    private static void zzy(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e11) {
            zze.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e11);
        }
    }

    private final void zzz(zzk zzkVar) {
        zzkVar.thread = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 != zzk.zza) {
                zzk zzkVar3 = null;
                while (zzkVar2 != null) {
                    zzk zzkVar4 = zzkVar2.next;
                    if (zzkVar2.thread != null) {
                        zzkVar3 = zzkVar2;
                    } else if (zzkVar3 != null) {
                        zzkVar3.next = zzkVar4;
                        if (zzkVar3.thread == null) {
                        }
                    } else if (!zzbc.zzg(this, zzkVar2, zzkVar4)) {
                    }
                    zzkVar2 = zzkVar4;
                }
                return;
            }
            return;
        }
    }

    @Override // com.google.common.util.concurrent.s
    public void addListener(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzfxe.zzc(runnable, "Runnable was null.");
        zzfxe.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listeners) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzbc.zze(this, zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listeners;
                }
            } while (zzdVar != zzd.zza);
        }
        zzy(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z11) {
        zzb zzbVar;
        Object obj = this.value;
        if (!(obj instanceof zzf) && !(obj == null)) {
            return false;
        }
        if (zzd) {
            zzbVar = new zzb(z11, new CancellationException("Future.cancel() was called."));
        } else {
            zzbVar = z11 ? zzb.zza : zzb.zzb;
            Objects.requireNonNull(zzbVar);
        }
        boolean z12 = false;
        zzgdb<V> zzgdbVar = this;
        while (true) {
            if (zzbc.zzf(zzgdbVar, obj, zzbVar)) {
                zzx(zzgdbVar, z11);
                if (obj instanceof zzf) {
                    s<? extends V> sVar = ((zzf) obj).zzb;
                    if (sVar instanceof zzh) {
                        zzgdbVar = (zzgdb) sVar;
                        obj = zzgdbVar.value;
                        if ((obj == null) | (obj instanceof zzf)) {
                            z12 = true;
                        }
                    } else {
                        sVar.cancel(z11);
                    }
                }
                return true;
            }
            obj = zzgdbVar.value;
            if (!(obj instanceof zzf)) {
                return z12;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof zzf))) {
            return zzA(obj2);
        }
        zzk zzkVar = this.waiters;
        if (zzkVar != zzk.zza) {
            zzk zzkVar2 = new zzk();
            do {
                zza zzaVar = zzbc;
                zzaVar.zzc(zzkVar2, zzkVar);
                if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzz(zzkVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zzf))));
                    return zzA(obj);
                }
                zzkVar = this.waiters;
            } while (zzkVar != zzk.zza);
        }
        Object obj3 = this.value;
        Objects.requireNonNull(obj3);
        return zzA(obj3);
    }

    @Override // java.util.concurrent.Future
    public Object get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j11);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        boolean z11 = true;
        if ((obj != null) && (!(obj instanceof zzf))) {
            return zzA(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            zzk zzkVar = this.waiters;
            if (zzkVar != zzk.zza) {
                zzk zzkVar2 = new zzk();
                while (true) {
                    zza zzaVar = zzbc;
                    zzaVar.zzc(zzkVar2, zzkVar);
                    if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                zzz(zzkVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                                return zzA(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        zzz(zzkVar2);
                        break;
                    }
                    zzkVar = this.waiters;
                    if (zzkVar == zzk.zza) {
                    }
                }
            }
            Object obj3 = this.value;
            Objects.requireNonNull(obj3);
            return zzA(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.value;
            if ((obj4 != null) && (!(obj4 instanceof zzf))) {
                return zzA(obj4);
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
        String strConcat = "Waited " + j11 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strConcat2 = strConcat.concat(" (plus ");
            long j12 = -nanos;
            long jConvert = timeUnit.convert(j12, TimeUnit.NANOSECONDS);
            long nanos2 = j12 - timeUnit.toNanos(jConvert);
            if (jConvert != 0 && nanos2 <= 1000) {
                z11 = false;
            }
            if (jConvert > 0) {
                String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                if (z11) {
                    strConcat3 = strConcat3.concat(",");
                }
                strConcat2 = strConcat3.concat(" ");
            }
            if (z11) {
                strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
            }
            strConcat = strConcat2.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(strConcat + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof zzb;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.value;
        return (obj != null) & (!(obj instanceof zzf));
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
            zzu(sb2);
        } else {
            zzv(sb2);
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String zza() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public void zzb() {
    }

    public boolean zzc(Object obj) {
        if (obj == null) {
            obj = zzaZ;
        }
        if (!zzbc.zzf(this, null, obj)) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    public boolean zzd(Throwable th2) {
        th2.getClass();
        if (!zzbc.zzf(this, null, new zzc(th2))) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgfq
    public final Throwable zzl() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    public void zzq() {
    }

    public final void zzr(Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(zzt());
        }
    }

    public final boolean zzs(s sVar) {
        zzc zzcVar;
        sVar.getClass();
        Object obj = this.value;
        if (obj == null) {
            if (sVar.isDone()) {
                if (!zzbc.zzf(this, null, zze(sVar))) {
                    return false;
                }
                zzx(this, false);
                return true;
            }
            zzf zzfVar = new zzf(this, sVar);
            if (zzbc.zzf(this, null, zzfVar)) {
                try {
                    sVar.addListener(zzfVar, zzgeb.INSTANCE);
                } catch (Throwable th2) {
                    try {
                        zzcVar = new zzc(th2);
                    } catch (Error | Exception unused) {
                        zzcVar = zzc.zza;
                    }
                    zzbc.zzf(this, zzfVar, zzcVar);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzb) {
            sVar.cancel(((zzb) obj).zzc);
        }
        return false;
    }

    public final boolean zzt() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }
}
