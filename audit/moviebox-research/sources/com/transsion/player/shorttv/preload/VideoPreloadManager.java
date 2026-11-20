package com.transsion.player.shorttv.preload;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.DownloadRequest;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.exoplayer.scheduler.Requirements;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.transsion.player.MediaSource;
import com.transsion.player.exo.DemoDownloadService;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

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
public final class VideoPreloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final VideoPreloadManager f54774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.transsion.player.shorttv.preload.a> f54775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f54776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HandlerThread f54777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Handler f54778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f54779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Function0<Unit> f54780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f54781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f54782i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message msg) {
            Intrinsics.g(msg, "msg");
            try {
                super.dispatchMessage(msg);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements DownloadManager.d {
        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void a(DownloadManager downloadManager, boolean z11) {
            Intrinsics.g(downloadManager, "downloadManager");
            Log.e("VideoPreloadUtil", "onWaitingForRequirementsChanged:");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void b(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c download) {
            Intrinsics.g(downloadManager, "downloadManager");
            Intrinsics.g(download, "download");
            Log.e("VideoPreloadUtil", "onDownloadRemoved:");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void c(DownloadManager downloadManager, boolean z11) {
            Intrinsics.g(downloadManager, "downloadManager");
            Log.e("VideoPreloadUtil", "onDownloadsPausedChanged:");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void d(DownloadManager downloadManager) {
            Intrinsics.g(downloadManager, "downloadManager");
            Log.e("VideoPreloadUtil", "onIdle:");
            VideoPreloadManager.f54774a.C();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void e(DownloadManager downloadManager, Requirements requirements, int i11) {
            Intrinsics.g(downloadManager, "downloadManager");
            Intrinsics.g(requirements, "requirements");
            Log.e("VideoPreloadUtil", "onRequirementsStateChanged:");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void f(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c download, Exception exc) {
            Intrinsics.g(downloadManager, "downloadManager");
            Intrinsics.g(download, "download");
            Log.e("VideoPreloadUtil", "onDownloadChanged:  download.requestId:" + download.f10901a.f10832id + "     bytesDownloaded:" + download.a() + "  contentLength:" + download.f10905e + "  percentDownloaded:" + download.b());
            com.transsion.player.shorttv.preload.a aVar = (com.transsion.player.shorttv.preload.a) VideoPreloadManager.f54775b.get(download.f10901a.f10832id);
            if (aVar != null) {
                aVar.h(download.a());
                aVar.g(download.f10905e);
                int i11 = download.f10902b;
                if (i11 == 2) {
                    long jB = aVar.b();
                    long jD = aVar.d();
                    if (1 <= jD && jD < jB) {
                        VideoPreloadManager videoPreloadManager = VideoPreloadManager.f54774a;
                        String str = aVar.e().f10832id;
                        Intrinsics.f(str, "request.id");
                        videoPreloadManager.E(str);
                    }
                } else if (i11 == 1 || i11 == 3) {
                    VideoPreloadManager videoPreloadManager2 = VideoPreloadManager.f54774a;
                    String str2 = aVar.e().f10832id;
                    Intrinsics.f(str2, "request.id");
                    videoPreloadManager2.y(str2);
                }
            }
            VideoPreloadManager.f54774a.B();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void g(DownloadManager downloadManager) {
            Intrinsics.g(downloadManager, "downloadManager");
        }
    }

    static {
        VideoPreloadManager videoPreloadManager = new VideoPreloadManager();
        f54774a = videoPreloadManager;
        f54775b = new ConcurrentHashMap<>();
        f54776c = LazyKt__LazyJVMKt.b(new Function0<Application>() { // from class: com.transsion.player.shorttv.preload.VideoPreloadManager$context$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Application invoke() {
                return Utils.a();
            }
        });
        HandlerThread handlerThread = new HandlerThread("VideoPreloadUtil");
        f54777d = handlerThread;
        f54779f = 100L;
        f54780g = new Function0<Unit>() { // from class: com.transsion.player.shorttv.preload.VideoPreloadManager$updateIntervalRunnable$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                for (androidx.media3.exoplayer.offline.c cVar : com.transsion.player.exo.a.h(VideoPreloadManager.f54774a.o()).e()) {
                    if (cVar.f10902b == 2) {
                        String str = cVar.f10901a.f10832id;
                        long jA = cVar.a();
                        long j11 = cVar.f10905e;
                        float fB = cVar.b();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("progress 111:  download.requestId:");
                        sb2.append(str);
                        sb2.append("     bytesDownloaded:");
                        sb2.append(jA);
                        sb2.append("  contentLength:");
                        sb2.append(j11);
                        sb2.append("  percentDownloaded:");
                        sb2.append(fB);
                        a aVar = (a) VideoPreloadManager.f54775b.get(cVar.f10901a.f10832id);
                        if (aVar != null) {
                            aVar.h(cVar.a());
                            aVar.g(cVar.f10905e);
                            long jB = aVar.b();
                            long jD = aVar.d();
                            if (1 <= jD && jD < jB) {
                                VideoPreloadManager videoPreloadManager2 = VideoPreloadManager.f54774a;
                                String str2 = aVar.e().f10832id;
                                Intrinsics.f(str2, "request.id");
                                videoPreloadManager2.y(str2);
                            }
                        }
                    }
                }
                if (VideoPreloadManager.f54782i) {
                    VideoPreloadManager.f54774a.q();
                }
            }
        };
        b bVar = new b();
        f54781h = bVar;
        handlerThread.start();
        f54778e = new a(handlerThread.getLooper());
        com.transsion.player.exo.a.h(videoPreloadManager.o()).d(bVar);
    }

    public static final void D(Function0 tmp0) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final void F(String key) {
        Intrinsics.g(key, "$key");
        com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, "VideoPreloadUtil", "stopPreload   key:" + key, false, 4, null);
        DownloadService.z(f54774a.o(), DemoDownloadService.class, key, 10086, false);
    }

    public static final void r(Function0 tmp0) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final void s(Function0 tmp0) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final void v(MediaSource shortTVItem) {
        Intrinsics.g(shortTVItem, "$shortTVItem");
        VideoPreloadManager videoPreloadManager = f54774a;
        videoPreloadManager.t(videoPreloadManager.n(shortTVItem));
    }

    public static final void w(com.transsion.player.shorttv.preload.a shortTVDownloadBean) {
        Intrinsics.g(shortTVDownloadBean, "$shortTVDownloadBean");
        Log.e("VideoPreloadUtil", "preloadVideo id:" + shortTVDownloadBean.c() + " downloadLength:" + shortTVDownloadBean.b() + "  maxLength:" + shortTVDownloadBean.d() + " contentLength:" + shortTVDownloadBean.a());
        if (shortTVDownloadBean.d() == -1 || shortTVDownloadBean.b() < shortTVDownloadBean.d()) {
            if (shortTVDownloadBean.f()) {
                DownloadService.z(f54774a.o(), DemoDownloadService.class, shortTVDownloadBean.c(), 0, false);
                Log.e("VideoPreloadUtil", "checkToStart restart  shortTVItem:" + shortTVDownloadBean);
                return;
            }
            DownloadService.x(f54774a.o(), DemoDownloadService.class, shortTVDownloadBean.e(), false);
            Log.e("VideoPreloadUtil", "checkToStart add    shortTVItem:" + shortTVDownloadBean);
        }
    }

    public static final void z(String key) {
        Intrinsics.g(key, "$key");
        com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, "VideoPreloadUtil", "removePreload   key:" + key, false, 4, null);
        DownloadService.y(f54774a.o(), DemoDownloadService.class, key, false);
    }

    public final void A(Runnable runnable) {
        Intrinsics.g(runnable, "runnable");
        f54778e.post(runnable);
    }

    public final void B() {
        if (f54782i) {
            return;
        }
        f54782i = true;
        q();
    }

    public final void C() {
        f54782i = false;
        Handler handler = f54778e;
        final Function0<Unit> function0 = f54780g;
        handler.removeCallbacks(new Runnable() { // from class: com.transsion.player.shorttv.preload.j
            @Override // java.lang.Runnable
            public final void run() {
                VideoPreloadManager.D(function0);
            }
        });
    }

    public final void E(final String key) {
        Intrinsics.g(key, "key");
        A(new Runnable() { // from class: com.transsion.player.shorttv.preload.h
            @Override // java.lang.Runnable
            public final void run() {
                VideoPreloadManager.F(key);
            }
        });
    }

    public final String G(String str) {
        int iD0 = str != null ? StringsKt__StringsKt.d0(str, "?", 0, false, 6, null) : -1;
        if (str != null && iD0 >= 0) {
            return com.transsion.player.utils.a.f54864a.a((String) StringsKt__StringsKt.E0(str, new String[]{"?"}, false, 0, 6, null).get(0));
        }
        com.transsion.player.utils.a.C0585a c0585a = com.transsion.player.utils.a.f54864a;
        if (str == null) {
            str = "";
        }
        return c0585a.a(str);
    }

    public final com.transsion.player.shorttv.preload.a n(MediaSource shortTVItem) throws IOException {
        DownloadRequest downloadRequest;
        Intrinsics.g(shortTVItem, "shortTVItem");
        ConcurrentHashMap<String, com.transsion.player.shorttv.preload.a> concurrentHashMap = f54775b;
        com.transsion.player.shorttv.preload.a aVar = concurrentHashMap.get(shortTVItem.f());
        if (aVar != null) {
            com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, "VideoPreloadUtil", "createDownloadRequest [from map]  shortTVItem:" + shortTVItem, false, 4, null);
            return aVar;
        }
        androidx.media3.exoplayer.offline.c cVarH = com.transsion.player.exo.a.h(Utils.a()).f().h(shortTVItem.f());
        if (Intrinsics.b((cVarH == null || (downloadRequest = cVarH.f10901a) == null) ? null : downloadRequest.f10832id, shortTVItem.f())) {
            com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, "VideoPreloadUtil", "createDownloadRequest [from currentDownloads]   shortTVItem:" + shortTVItem, false, 4, null);
            String strF = shortTVItem.f();
            String strJ = shortTVItem.j();
            DownloadRequest downloadRequest2 = cVarH.f10901a;
            Intrinsics.f(downloadRequest2, "currentDownload.request");
            return new com.transsion.player.shorttv.preload.a(strF, strJ, downloadRequest2, cVarH.f10905e, cVarH.a(), 307200L, true);
        }
        String strF2 = shortTVItem.f();
        String strJ2 = shortTVItem.j();
        DownloadRequest downloadRequestA = new DownloadRequest.b(strF2, Uri.parse(strJ2)).b(strF2).a();
        Intrinsics.f(downloadRequestA, "Builder(cacheKey, Uri.pa…\n                .build()");
        com.transsion.player.shorttv.preload.a aVar2 = new com.transsion.player.shorttv.preload.a(strF2, strJ2, downloadRequestA, -1L, 0L, 307200L, false);
        concurrentHashMap.put(strF2, aVar2);
        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, "VideoPreloadUtil", "createDownloadRequest [from new]  shortTVItem:" + shortTVItem, false, 4, null);
        return aVar2;
    }

    public final Context o() {
        Object value = f54776c.getValue();
        Intrinsics.f(value, "<get-context>(...)");
        return (Context) value;
    }

    public final boolean p(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (kotlin.text.l.L(str, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
            return com.transsion.player.exo.a.f(Utils.a()).isCached(G(str), 0L, 200L);
        }
        return true;
    }

    public final void q() {
        Handler handler = f54778e;
        final Function0<Unit> function0 = f54780g;
        handler.removeCallbacks(new Runnable() { // from class: com.transsion.player.shorttv.preload.k
            @Override // java.lang.Runnable
            public final void run() {
                VideoPreloadManager.r(function0);
            }
        });
        handler.postDelayed(new Runnable() { // from class: com.transsion.player.shorttv.preload.l
            @Override // java.lang.Runnable
            public final void run() {
                VideoPreloadManager.s(function0);
            }
        }, f54779f);
    }

    public final com.transsion.player.shorttv.preload.a t(final com.transsion.player.shorttv.preload.a shortTVDownloadBean) {
        Intrinsics.g(shortTVDownloadBean, "shortTVDownloadBean");
        A(new Runnable() { // from class: com.transsion.player.shorttv.preload.n
            @Override // java.lang.Runnable
            public final void run() {
                VideoPreloadManager.w(shortTVDownloadBean);
            }
        });
        return shortTVDownloadBean;
    }

    public final void u(final MediaSource shortTVItem) {
        Intrinsics.g(shortTVItem, "shortTVItem");
        A(new Runnable() { // from class: com.transsion.player.shorttv.preload.i
            @Override // java.lang.Runnable
            public final void run() {
                VideoPreloadManager.v(shortTVItem);
            }
        });
    }

    public final com.transsion.player.shorttv.preload.a x(MediaSource shortTVItem) throws IOException {
        Intrinsics.g(shortTVItem, "shortTVItem");
        com.transsion.player.shorttv.preload.a aVarN = n(shortTVItem);
        t(aVarN);
        return aVarN;
    }

    public final void y(final String key) {
        Intrinsics.g(key, "key");
        f54775b.remove(key);
        A(new Runnable() { // from class: com.transsion.player.shorttv.preload.m
            @Override // java.lang.Runnable
            public final void run() {
                VideoPreloadManager.z(key);
            }
        });
    }
}
