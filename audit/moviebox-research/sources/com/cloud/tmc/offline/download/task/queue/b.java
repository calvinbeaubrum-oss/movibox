package com.cloud.tmc.offline.download.task.queue;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.offline.download.thread.DownloadDispatcher;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f32050g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f32051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f32052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadDispatcher f32053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PriorityBlockingQueue<ce.b> f32054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TaskExecutor f32055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f32056f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b() {
        this(false, 1, null);
    }

    public b(boolean z11) {
        this.f32051a = z11;
        Looper looperMyLooper = Looper.myLooper();
        this.f32052b = new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper, new Handler.Callback() { // from class: com.cloud.tmc.offline.download.task.queue.a
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return b.d(this.f32049a, message);
            }
        });
        this.f32053c = new DownloadDispatcher(e.b());
        this.f32054d = new PriorityBlockingQueue<>();
        this.f32056f = new AtomicInteger();
    }

    public /* synthetic */ b(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11);
    }

    public static final boolean d(b this$0, Message it) {
        TaskExecutor taskExecutor;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(it, "it");
        try {
            int i11 = it.what;
            if (i11 == 1) {
                TaskExecutor taskExecutor2 = this$0.f32055e;
                if (taskExecutor2 != null) {
                    taskExecutor2.startQueue();
                }
            } else if (i11 == 2 && (taskExecutor = this$0.f32055e) != null) {
                taskExecutor.quit();
            }
        } catch (Throwable th2) {
            TmcLogger.h("TaskQueue", th2);
        }
        return true;
    }

    public final <T extends ce.b> int b(T task) {
        Intrinsics.g(task, "task");
        c();
        if (!this.f32054d.contains(task)) {
            PriorityBlockingQueue<ce.b> priorityBlockingQueue = this.f32054d;
            task.K(this.f32056f.incrementAndGet());
            priorityBlockingQueue.add(task);
        }
        return this.f32054d.size();
    }

    public final void c() {
        if (this.f32055e == null) {
            this.f32055e = new TaskExecutor(this.f32053c, 1, this.f32054d);
        }
        if (this.f32051a) {
            e();
        }
    }

    public final void e() {
        this.f32052b.sendEmptyMessage(1);
    }
}
