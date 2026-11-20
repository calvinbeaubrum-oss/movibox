package com.transsion.player.shorttv.preload;

import android.content.Context;
import android.util.Log;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.scheduler.Requirements;
import com.transsion.player.MediaSource;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
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
public final class g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f54806g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f54807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<MediaSource> f54808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f54809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f54810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f54811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.transsion.player.shorttv.preload.a> f54812f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements DownloadManager.d {
        public b() {
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void a(DownloadManager downloadManager, boolean z11) {
            Intrinsics.g(downloadManager, "downloadManager");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void b(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c download) {
            Intrinsics.g(downloadManager, "downloadManager");
            Intrinsics.g(download, "download");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void c(DownloadManager downloadManager, boolean z11) {
            Intrinsics.g(downloadManager, "downloadManager");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void d(DownloadManager downloadManager) {
            Intrinsics.g(downloadManager, "downloadManager");
            Log.e("VideoPreloadHelper", "onIdle:");
            g.this.m();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void e(DownloadManager downloadManager, Requirements requirements, int i11) {
            Intrinsics.g(downloadManager, "downloadManager");
            Intrinsics.g(requirements, "requirements");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void f(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c download, Exception exc) {
            Intrinsics.g(downloadManager, "downloadManager");
            Intrinsics.g(download, "download");
            Log.e("VideoPreloadHelper", "onDownloadChanged:  download.requestId:" + download.f10901a.f10832id + "     bytesDownloaded:" + download.a() + "  contentLength:" + download.f10905e + "  percentDownloaded:" + download.b());
            com.transsion.player.shorttv.preload.a aVar = (com.transsion.player.shorttv.preload.a) g.this.f54812f.get(download.f10901a.f10832id);
            if (aVar != null) {
                aVar.h(download.a());
                aVar.g(download.f10905e);
            }
            if (Intrinsics.b(download.f10901a.f10832id, g.this.f54810d)) {
                int i11 = download.f10902b;
                if (i11 == 1 || i11 == 3 || i11 == 4) {
                    g.this.f54810d = null;
                    g.this.m();
                }
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void g(DownloadManager downloadManager) {
            Intrinsics.g(downloadManager, "downloadManager");
        }
    }

    public g(Context context) {
        Intrinsics.g(context, "context");
        this.f54807a = context;
        this.f54808b = new CopyOnWriteArrayList();
        b bVar = new b();
        this.f54811e = bVar;
        this.f54812f = new ConcurrentHashMap<>();
        com.transsion.player.exo.a.h(context).d(bVar);
    }

    public static final void k(MediaSource shortTVItem, g this$0) throws IOException {
        Intrinsics.g(shortTVItem, "$shortTVItem");
        Intrinsics.g(this$0, "this$0");
        this$0.f54812f.put(shortTVItem.f(), VideoPreloadManager.f54774a.x(shortTVItem));
    }

    public static final void n(g this$0, int i11) throws IOException {
        Intrinsics.g(this$0, "this$0");
        int size = this$0.f54808b.size();
        Log.e("VideoPreloadHelper", "loadNext， position:" + i11 + "   size:" + size);
        int iG = kotlin.ranges.a.g(i11 + 6, size);
        for (int i12 = i11 + 1; i12 < iG; i12++) {
            MediaSource mediaSource = this$0.f54808b.get(i12);
            if (mediaSource != null) {
                com.transsion.player.shorttv.preload.a aVarL = this$0.l(i12, mediaSource);
                aVarL.i(307200L);
                if (aVarL.b() < aVarL.d()) {
                    Log.e("VideoPreloadHelper", "非当前选中  下载大小 downloadLength:" + aVarL.b() + "  index:" + i12);
                    this$0.f54810d = aVarL.c();
                    VideoPreloadManager.f54774a.t(aVarL);
                    return;
                }
                aVarL.b();
                aVarL.a();
                Log.e("VideoPreloadHelper", "非当前选中  下载大小 downloadLength:" + aVarL.b() + " 大于最小下载，跳过 index:" + i12);
            }
        }
        Log.e("VideoPreloadHelper", "不用全量下载");
    }

    public final void f(int i11, MediaSource mediaSource) {
        Intrinsics.g(mediaSource, "mediaSource");
        if (i11 <= this.f54808b.size()) {
            this.f54808b.add(i11, mediaSource);
        }
        m();
    }

    public final void g(MediaSource mediaSource) {
        Intrinsics.g(mediaSource, "mediaSource");
        this.f54808b.add(mediaSource);
        m();
    }

    public final void h(int i11) {
        Log.e("VideoPreloadHelper", "changeSelect  position:" + i11);
        if (this.f54809c == i11) {
            return;
        }
        this.f54810d = null;
        this.f54809c = i11;
        i(i11);
        j(this.f54809c + 1);
    }

    public final void i(int i11) {
        MediaSource mediaSource;
        if (i11 < 0 || i11 >= this.f54808b.size() || (mediaSource = this.f54808b.get(i11)) == null) {
            return;
        }
        Log.e("VideoPreloadHelper", "checkToPause   position:" + i11 + "  shortTVItem:" + mediaSource);
        VideoPreloadManager.f54774a.E(mediaSource.f());
    }

    public final void j(int i11) {
        final MediaSource mediaSource;
        if (i11 < 0 || i11 >= this.f54808b.size() || (mediaSource = this.f54808b.get(i11)) == null) {
            return;
        }
        VideoPreloadManager.f54774a.A(new Runnable() { // from class: com.transsion.player.shorttv.preload.f
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                g.k(mediaSource, this);
            }
        });
    }

    public final com.transsion.player.shorttv.preload.a l(int i11, MediaSource mediaSource) throws IOException {
        com.transsion.player.shorttv.preload.a aVar = this.f54812f.get(mediaSource.f());
        if (aVar != null) {
            Log.e("VideoPreloadHelper", "createDownloadRequest [from map] position:" + i11 + "  shortTVItem:" + mediaSource);
            return aVar;
        }
        String strF = mediaSource.f();
        com.transsion.player.shorttv.preload.a aVarN = VideoPreloadManager.f54774a.n(mediaSource);
        this.f54812f.put(strF, aVarN);
        Log.e("VideoPreloadHelper", "createDownloadRequest [from new] position:" + i11 + "  shortTVItem:" + mediaSource);
        return aVarN;
    }

    public final void m() {
        final int i11 = this.f54809c;
        if (i11 >= 0 && this.f54810d == null) {
            VideoPreloadManager.f54774a.A(new Runnable() { // from class: com.transsion.player.shorttv.preload.e
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    g.n(this.f54802a, i11);
                }
            });
        }
    }

    public final void o() {
        i(this.f54809c);
        this.f54809c = -1;
    }

    public final void p() {
        com.transsion.player.exo.a.h(this.f54807a).w(this.f54811e);
        o();
    }

    public final void q(String key) {
        Intrinsics.g(key, "key");
        this.f54812f.remove(key);
        VideoPreloadManager.f54774a.y(key);
    }
}
