package com.cloud.tmc.offline.download.thread;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class DownloadDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f32060c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f32061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f32062b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmOverloads
    public DownloadDispatcher(ExecutorService executorService) {
        this.f32061a = executorService;
        this.f32062b = executorService == null ? new ScheduledThreadPoolExecutor(Math.max(8, Runtime.getRuntime().availableProcessors() * 2), new DownloadThreadFactory("DownLoadThreadFactory", false)) : executorService;
    }

    public static final boolean e(final ce.b task, final DownloadDispatcher this$0, final Function1 function1) {
        Intrinsics.g(task, "$task");
        Intrinsics.g(this$0, "this$0");
        TmcLogger.c("TmcOfflineDownload: DownLoadDispatcher", "execute idleHandler task: " + task);
        this$0.f32062b.execute(new Runnable() { // from class: com.cloud.tmc.offline.download.thread.c
            @Override // java.lang.Runnable
            public final void run() {
                DownloadDispatcher.f(this.f32073a, task, function1);
            }
        });
        return false;
    }

    public static final void f(DownloadDispatcher this$0, ce.b task, Function1 function1) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(task, "$task");
        this$0.h(task);
        if (function1 != null) {
            function1.invoke(task);
        }
    }

    public static final void g(DownloadDispatcher this$0, ce.b task, Function1 function1) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(task, "$task");
        this$0.h(task);
        if (function1 != null) {
            function1.invoke(task);
        }
    }

    public final void d(final ce.b task, final Function1<? super ce.b, Unit> function1) {
        Intrinsics.g(task, "task");
        if (!task.M() || Build.VERSION.SDK_INT < 23) {
            this.f32062b.execute(new Runnable() { // from class: com.cloud.tmc.offline.download.thread.b
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadDispatcher.g(this.f32070a, task, function1);
                }
            });
        } else {
            Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.cloud.tmc.offline.download.thread.a
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    return DownloadDispatcher.e(task, this, function1);
                }
            });
        }
    }

    public final void h(final ce.b bVar) {
        TmcLogger.c("TmcOfflineDownload: DownLoadDispatcher", "execute task: " + bVar);
        try {
            bVar.P(new Function1<yd.a<?>, Unit>() { // from class: com.cloud.tmc.offline.download.thread.DownloadDispatcher$execute$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(yd.a<?> aVar) {
                    invoke2(aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(yd.a<?> result) {
                    Intrinsics.g(result, "result");
                    Function2<ce.b, yd.a<?>, Unit> function2J = bVar.J();
                    if (function2J != null) {
                        function2J.invoke(bVar, result);
                    }
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: DownLoadDispatcher", "execute task run failed!", th2);
        }
    }

    public final Future<?> i(Runnable runnable) {
        Intrinsics.g(runnable, "runnable");
        Future<?> futureSubmit = this.f32062b.submit(runnable);
        Intrinsics.f(futureSubmit, "mExecutor.submit(runnable)");
        return futureSubmit;
    }
}
