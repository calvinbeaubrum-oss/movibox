package com.tn.lib.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class ThreadPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f49416a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<ThreadPool> f49417b = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<ThreadPool>() { // from class: com.tn.lib.thread.ThreadPool$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ThreadPool invoke() {
            return new ThreadPool(null);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f49418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f49419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f49420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BlockingQueue<Runnable> f49421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadFactory f49422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ThreadPoolExecutor f49423h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class BackgroundThread extends Thread {
        public BackgroundThread(Runnable runnable, String str) {
            super(runnable, str);
            setPriority(5);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f49424a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Intrinsics.g(runnable, "runnable");
            return new BackgroundThread(runnable, "or_threadpool_" + this.f49424a.getAndIncrement());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ThreadPool a() {
            return (ThreadPool) ThreadPool.f49417b.getValue();
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f49418c = iAvailableProcessors;
        f49419d = kotlin.ranges.a.g(iAvailableProcessors - 1, 4);
        f49420e = kotlin.ranges.a.g((iAvailableProcessors * 2) + 1, 8);
        f49421f = new LinkedBlockingQueue(64);
        f49422g = new a();
    }

    public ThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f49419d, f49420e, 30L, TimeUnit.SECONDS, f49421f, f49422g, new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f49423h = threadPoolExecutor;
    }

    public /* synthetic */ ThreadPool(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final ThreadPool c() {
        return f49416a.a();
    }

    public final void b(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = f49423h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(runnable);
        }
    }
}
