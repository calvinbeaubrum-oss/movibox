package com.transsnet.downloader.core.thread;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class DownloadExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f60487a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<DownloadExecutor> f60488b = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<DownloadExecutor>() { // from class: com.transsnet.downloader.core.thread.DownloadExecutor$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadExecutor invoke() {
            return new DownloadExecutor(null);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f60489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f60490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f60491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BlockingQueue<Runnable> f60492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadFactory f60493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ThreadPoolExecutor f60494h;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class BackgroundThread extends Thread {
        public BackgroundThread(Runnable runnable, String str) {
            super(runnable, str);
            setPriority(5);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f60495a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Intrinsics.g(runnable, "runnable");
            return new BackgroundThread(runnable, "or_download_" + this.f60495a.getAndIncrement());
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return DownloadExecutor.f60490d;
        }

        public final DownloadExecutor b() {
            return (DownloadExecutor) DownloadExecutor.f60488b.getValue();
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f60489c = iAvailableProcessors;
        f60490d = kotlin.ranges.a.d(iAvailableProcessors, 8);
        f60491e = kotlin.ranges.a.d(iAvailableProcessors, 8);
        f60492f = new LinkedBlockingQueue(64);
        f60493g = new a();
    }

    public DownloadExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f60490d, f60491e, 20L, TimeUnit.SECONDS, f60492f, f60493g, new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f60494h = threadPoolExecutor;
    }

    public /* synthetic */ DownloadExecutor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void c(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = f60494h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(runnable);
        }
    }
}
