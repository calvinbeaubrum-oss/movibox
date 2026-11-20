package com.cloud.h5update.download;

import android.content.Context;
import com.cloud.h5update.bean.DownloadEntity;
import java.io.File;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import okhttp3.OkHttpClient;

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
public final class DownloadManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f28882g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy<DownloadManager> f28883h = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<DownloadManager>() { // from class: com.cloud.h5update.download.DownloadManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadManager invoke() {
            return new DownloadManager(null);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedBlockingDeque<Runnable> f28885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ThreadPoolExecutor f28886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, DownloadTask> f28887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OkHttpClient f28888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f28889f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadManager a() {
            return (DownloadManager) DownloadManager.f28883h.getValue();
        }
    }

    public DownloadManager() {
        this.f28884a = 1;
    }

    public /* synthetic */ DownloadManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void c(DownloadManager downloadManager, DownloadTask downloadTask, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        downloadManager.b(downloadTask, z11);
    }

    public static /* synthetic */ void k(DownloadManager downloadManager, Context context, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = downloadManager.e();
        }
        downloadManager.i(context, i11);
    }

    public final void b(DownloadTask task, boolean z11) {
        String taskId;
        Map<String, DownloadTask> map;
        Intrinsics.g(task, "task");
        if (!z11 && (map = this.f28887d) != null) {
            DownloadEntity downloadEntity = task.getDownloadEntity();
            if (map.containsKey(downloadEntity != null ? downloadEntity.getTaskId() : null)) {
                return;
            }
        }
        DownloadEntity downloadEntity2 = task.getDownloadEntity();
        if (downloadEntity2 == null || (taskId = downloadEntity2.getTaskId()) == null || !(!l.y(taskId))) {
            return;
        }
        task.setClient(this.f28888e);
        Map<String, DownloadTask> map2 = this.f28887d;
        Intrinsics.d(map2);
        String taskId2 = downloadEntity2.getTaskId();
        Intrinsics.d(taskId2);
        map2.put(taskId2, task);
        LinkedBlockingDeque<Runnable> linkedBlockingDeque = this.f28885b;
        Intrinsics.d(linkedBlockingDeque);
        if (linkedBlockingDeque.contains(task)) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = this.f28886c;
        Intrinsics.d(threadPoolExecutor);
        threadPoolExecutor.execute(task);
    }

    public final void d(String str) {
        Map<String, DownloadTask> map;
        if (str == null || l.y(str) || (map = this.f28887d) == null || map == null) {
            return;
        }
        map.remove(str);
    }

    public final int e() {
        return (Runtime.getRuntime().availableProcessors() * 2) + 1;
    }

    public final ThreadPoolExecutor f() {
        return this.f28886c;
    }

    public final OkHttpClient g() {
        OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().connectTimeout(15L, TimeUnit.SECONDS).build();
        Intrinsics.f(okHttpClientBuild, "Builder().connectTimeout…TimeUnit.SECONDS).build()");
        return okHttpClientBuild;
    }

    public final DownloadTask h(String str) {
        Map<String, DownloadTask> map;
        DownloadEntity downloadEntityH;
        if (str == null || l.y(str) || (map = this.f28887d) == null) {
            return null;
        }
        Intrinsics.d(map);
        DownloadTask downloadTask = map.get(str);
        return (downloadTask != null || (downloadEntityH = com.cloud.h5update.utils.l.f28923a.h(str)) == null) ? downloadTask : new DownloadTask(downloadEntityH);
    }

    @JvmOverloads
    public final void i(Context context, int i11) {
        Intrinsics.g(context, "context");
        j(context, i11, g());
    }

    public final void j(Context context, int i11, OkHttpClient okHttpClient) {
        this.f28889f = context;
        if (i11 < 1) {
            i11 = 1;
        } else if (i11 > 15) {
            i11 = 15;
        }
        this.f28884a = i11;
        int i12 = this.f28884a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i12, i12, 20L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque());
        this.f28886c = threadPoolExecutor;
        Intrinsics.d(threadPoolExecutor);
        BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
        if (queue == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.LinkedBlockingDeque<java.lang.Runnable>");
        }
        this.f28885b = (LinkedBlockingDeque) queue;
        this.f28887d = new ConcurrentHashMap();
        this.f28888e = okHttpClient;
    }

    public final boolean l(String str) {
        DownloadEntity downloadEntityH = com.cloud.h5update.utils.l.f28923a.h(str);
        if (downloadEntityH == null) {
            return false;
        }
        String filePath = downloadEntityH.getFilePath();
        String fileName = downloadEntityH.getFileName();
        if (fileName == null) {
            fileName = "";
        }
        File file = new File(filePath, fileName);
        return file.exists() && file.length() == downloadEntityH.getTotalSize();
    }

    public final void m(DownloadTask task) {
        Intrinsics.g(task, "task");
        c(this, task, false, 2, null);
    }
}
