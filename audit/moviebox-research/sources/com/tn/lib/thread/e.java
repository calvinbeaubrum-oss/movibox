package com.tn.lib.thread;

import com.tn.lib.thread.wrapper.RunnableWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class e implements Executor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f49439g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f49440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f49441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kp.b f49442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Executor f49443d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ThreadLocal<lp.d> f49444f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final lp.a a(int i11) {
            return new lp.a(i11, 1, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49445a;

        public b(int i11) {
            this.f49445a = i11;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Intrinsics.g(runnable, "runnable");
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f49445a);
            return thread;
        }
    }

    public e(int i11, int i12, int i13, String threadName, kp.b bVar, Executor executor, ExecutorService executorService) {
        Intrinsics.g(threadName, "threadName");
        this.f49441b = threadName;
        this.f49442c = bVar;
        this.f49443d = executor;
        this.f49440a = executorService == null ? a(i11, i12, i13) : executorService;
        this.f49441b = threadName;
        this.f49442c = bVar;
        this.f49443d = executor;
        this.f49444f = new ThreadLocal<>();
    }

    public final ExecutorService a(int i11, int i12, int i13) {
        if (i11 == 1) {
            ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(i12, new b(i13));
            Intrinsics.f(executorServiceNewFixedThreadPool, "newFixedThreadPool(\n    …y(priority)\n            )");
            return executorServiceNewFixedThreadPool;
        }
        if (i11 == 2) {
            ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool(new b(i13));
            Intrinsics.f(executorServiceNewCachedThreadPool, "newCachedThreadPool(\n   …y(priority)\n            )");
            return executorServiceNewCachedThreadPool;
        }
        if (i11 == 3) {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(i12, new b(i13));
            Intrinsics.f(scheduledExecutorServiceNewScheduledThreadPool, "newScheduledThreadPool(\n…y(priority)\n            )");
            return scheduledExecutorServiceNewScheduledThreadPool;
        }
        if (i11 != 4) {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new b(i13));
            Intrinsics.f(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(…          )\n            )");
            return executorServiceNewSingleThreadExecutor;
        }
        ExecutorService executorServiceNewSingleThreadExecutor2 = Executors.newSingleThreadExecutor(new b(i13));
        Intrinsics.f(executorServiceNewSingleThreadExecutor2, "newSingleThreadExecutor(…y(priority)\n            )");
        return executorServiceNewSingleThreadExecutor2;
    }

    public final lp.d b() {
        ThreadLocal<lp.d> threadLocal = this.f49444f;
        lp.d dVar = threadLocal != null ? threadLocal.get() : null;
        if (dVar == null) {
            dVar = new lp.d();
            dVar.h(this.f49441b);
            dVar.g(this.f49442c);
            dVar.f(this.f49443d);
            ThreadLocal<lp.d> threadLocal2 = this.f49444f;
            if (threadLocal2 != null) {
                threadLocal2.set(dVar);
            }
        }
        return dVar;
    }

    public final void c() {
        ThreadLocal<lp.d> threadLocal = this.f49444f;
        if (threadLocal != null) {
            threadLocal.set(null);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        Intrinsics.g(command, "command");
        lp.d dVarB = b();
        mp.c.f71157b.a().e(dVarB.b(), this.f49440a, new RunnableWrapper(dVarB).setRunnable(command));
        c();
    }
}
