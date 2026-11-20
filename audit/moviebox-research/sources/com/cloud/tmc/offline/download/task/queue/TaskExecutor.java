package com.cloud.tmc.offline.download.task.queue;

import android.util.Log;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.thread.DownloadDispatcher;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class TaskExecutor implements Runnable {
    public static final a Companion = new a(null);
    private static final int MAX_WAIT_COUNT_LIMIT = 3;
    private static final long MAX_WAIT_TIMEOUT = 10000;
    private static final String TAG = "TmcOfflineDownload: TaskExecutor";
    private final DownloadDispatcher dispatcher;
    private final AtomicInteger inFlightTasks;
    private final AtomicBoolean isRunning;
    private final BlockingQueue<ce.b> mTask;
    private final int parallelism;
    private final AtomicInteger waitCountLimit;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TaskExecutor(DownloadDispatcher dispatcher, int i11, BlockingQueue<ce.b> mTask) {
        Intrinsics.g(dispatcher, "dispatcher");
        Intrinsics.g(mTask, "mTask");
        this.dispatcher = dispatcher;
        this.parallelism = i11;
        this.mTask = mTask;
        this.isRunning = new AtomicBoolean(false);
        this.inFlightTasks = new AtomicInteger(0);
        this.waitCountLimit = new AtomicInteger(0);
    }

    public /* synthetic */ TaskExecutor(DownloadDispatcher downloadDispatcher, int i11, BlockingQueue blockingQueue, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(downloadDispatcher, (i12 & 2) != 0 ? 1 : i11, blockingQueue);
    }

    private final void log(String str, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(' ');
        sb2.append(z11 ? Log.getStackTraceString(new Throwable("Just Print")) : "");
        TmcLogger.c(TAG, sb2.toString());
    }

    public static /* synthetic */ void log$default(TaskExecutor taskExecutor, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        taskExecutor.log(str, z11);
    }

    private final void sleep() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e11) {
            TmcLogger.g(TAG, "InterruptedException while sleeping.", e11);
        }
    }

    public final void quit() {
        if (this.isRunning.getAndSet(false)) {
            log$default(this, "quit", false, 2, null);
            try {
                Thread.currentThread().interrupt();
            } catch (Throwable th2) {
                TmcLogger.h(TAG, th2);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.isRunning.get() && !Thread.currentThread().isInterrupted()) {
            log$default(this, "Start Waiting...", false, 2, null);
            try {
                final ce.b bVarPoll = this.mTask.poll(10000L, TimeUnit.MILLISECONDS);
                log$default(this, "Waiting for task: " + bVarPoll, false, 2, null);
                if (bVarPoll == null) {
                    int iIncrementAndGet = this.waitCountLimit.incrementAndGet();
                    log$default(this, "incrementAndGet: " + iIncrementAndGet, false, 2, null);
                    if (iIncrementAndGet >= 3) {
                        log$default(this, "When the maximum number of acquisition timeouts is reached, exit the current thread", false, 2, null);
                        quit();
                        return;
                    }
                    bVarPoll = null;
                }
                if (bVarPoll != null) {
                    this.waitCountLimit.set(0);
                }
                int iIncrementAndGet2 = this.inFlightTasks.incrementAndGet();
                log$default(this, "inFlight: " + iIncrementAndGet2, false, 2, null);
                if (iIncrementAndGet2 > this.parallelism) {
                    sleep();
                    if (bVarPoll != null) {
                        log$default(this, "Reached the maximum parallelism, re-throw into the queue " + bVarPoll, false, 2, null);
                        this.mTask.add(bVarPoll);
                    }
                    this.inFlightTasks.decrementAndGet();
                } else if (bVarPoll != null) {
                    log$default(this, "Run task: " + bVarPoll, false, 2, null);
                    this.dispatcher.d(bVarPoll, new Function1<ce.b, Unit>() { // from class: com.cloud.tmc.offline.download.task.queue.TaskExecutor$run$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ce.b bVar) {
                            invoke2(bVar);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ce.b it) {
                            Intrinsics.g(it, "it");
                            TaskExecutor.log$default(this.this$0, "Run task finished: " + bVarPoll, false, 2, null);
                            this.this$0.inFlightTasks.decrementAndGet();
                        }
                    });
                } else {
                    this.inFlightTasks.decrementAndGet();
                }
            } catch (InterruptedException unused) {
                if (!this.isRunning.get()) {
                    quit();
                    return;
                }
            }
        }
    }

    public final void startQueue() {
        if (this.isRunning.getAndSet(true)) {
            return;
        }
        log$default(this, "startQueue", false, 2, null);
        this.inFlightTasks.set(0);
        this.waitCountLimit.set(0);
        this.dispatcher.i(this);
    }
}
