package com.transsnet.downloader.proxy;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.danikula.videocache.m;
import com.danikula.videocache.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsnet.downloader.core.task.DownloadTaskUtil;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.util.DownloadUtil;
import g00.d;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import tr.h;

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
@SourceDebugExtension
public final class DownloadFileCache implements com.danikula.videocache.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RandomAccessFile f61095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DownloadBean f61096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f61097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f61098g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DownloadRange f61100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f61101j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f61103l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public m f61104m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f61092a = 3145728;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f61093b = 3145728;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f61094c = LazyKt__LazyJVMKt.b(new Function0<h>() { // from class: com.transsnet.downloader.proxy.DownloadFileCache$rangeDao$2
        @Override // kotlin.jvm.functions.Function0
        public final h invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).F0();
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ConcurrentHashMap<String, b> f61099h = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f61102k = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f61105n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f61106o = new a();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a extends d {
        public a() {
        }

        @Override // g00.d
        public void h(DownloadBean bean, int i11) {
            m mVar;
            m mVar2;
            Intrinsics.g(bean, "bean");
            if (DownloadFileCache.this.f61100i == null || (mVar = DownloadFileCache.this.f61104m) == null || !mVar.b()) {
                return;
            }
            long j11 = DownloadFileCache.this.f61103l + ((long) 8192);
            DownloadRange downloadRange = DownloadFileCache.this.f61100i;
            Intrinsics.d(downloadRange);
            if (j11 > downloadRange.totalProgress() || (mVar2 = DownloadFileCache.this.f61104m) == null) {
                return;
            }
            mVar2.c();
        }
    }

    @Override // com.danikula.videocache.a
    public long A() {
        Long size;
        DownloadBean downloadBean = this.f61096e;
        if (downloadBean == null || (size = downloadBean.getSize()) == null) {
            return 0L;
        }
        return size.longValue();
    }

    @Override // com.danikula.videocache.a
    public void B() {
        try {
            DownloadBean downloadBean = this.f61096e;
            String path = downloadBean != null ? downloadBean.getPath() : null;
            if (path != null && path.length() != 0) {
                q.b("1-path create");
                DownloadBean downloadBean2 = this.f61096e;
                this.f61095d = new RandomAccessFile(downloadBean2 != null ? downloadBean2.getPath() : null, CampaignEx.JSON_KEY_AD_R);
                return;
            }
            q.b("path is null, is not downloading");
        } catch (Throwable th2) {
            DownloadBean downloadBean3 = this.f61096e;
            q.b("1--path = " + (downloadBean3 != null ? downloadBean3.getPath() : null) + ",error = " + th2);
            try {
                q.b("2-path create");
                DownloadBean downloadBean4 = this.f61096e;
                this.f61095d = new RandomAccessFile(downloadBean4 != null ? downloadBean4.getPath() : null, "rwd");
            } catch (Throwable th3) {
                DownloadBean downloadBean5 = this.f61096e;
                q.b("2--path = " + (downloadBean5 != null ? downloadBean5.getPath() : null) + ",error = " + th3);
            }
        }
    }

    @Override // com.danikula.videocache.a
    public void C(long j11) {
        Object resourceId;
        String url;
        List<DownloadRange> downloadRanges;
        if (DownloadTaskUtil.f60483a.e()) {
            f(j11);
            return;
        }
        DownloadRange downloadRange = this.f61100i;
        if (downloadRange == null) {
            uo.b.a aVar = uo.b.f78622a;
            DownloadBean downloadBean = this.f61096e;
            String resourceId2 = downloadBean != null ? downloadBean.getResourceId() : null;
            DownloadBean downloadBean2 = this.f61096e;
            aVar.h(DownloadBaseRunnable.TAG, "download&play currentRangeNull currentRange is null, offset = " + j11 + ",resourceId=" + resourceId2 + ",,name=" + (downloadBean2 != null ? downloadBean2.getName() : null), true);
            return;
        }
        Intrinsics.d(downloadRange);
        long start = downloadRange.getStart();
        DownloadRange downloadRange2 = this.f61100i;
        Intrinsics.d(downloadRange2);
        if (j11 <= downloadRange2.totalProgress() && start <= j11) {
            p("currentRange1", "当前分片已下载进度内，不做任何处理，直接返回, offset = " + j11);
            return;
        }
        DownloadRange downloadRange3 = this.f61100i;
        Intrinsics.d(downloadRange3);
        if (j11 < downloadRange3.getStart()) {
            g("beforeRange", j11);
            return;
        }
        DownloadRange downloadRange4 = this.f61100i;
        Intrinsics.d(downloadRange4);
        if (j11 >= downloadRange4.getEnd()) {
            g("afterRange", j11);
            return;
        }
        DownloadRange downloadRange5 = this.f61100i;
        Intrinsics.d(downloadRange5);
        long start2 = downloadRange5.getStart();
        DownloadRange downloadRange6 = this.f61100i;
        Intrinsics.d(downloadRange6);
        if (j11 < start2 + downloadRange6.getProgress() + this.f61093b) {
            p("currentRange21", "当前分片内，快进小于阈值，等待下载, offset = " + j11);
            return;
        }
        DownloadRange downloadRange7 = this.f61100i;
        Intrinsics.d(downloadRange7);
        if (downloadRange7.getEnd() - j11 < this.f61093b) {
            p("currentRange22", "当前分片内，（暂停当前线程，启动新线程下载）快进 新增分片小于阈值，使用阈值大小, offset = " + j11);
            DownloadRange downloadRange8 = this.f61100i;
            Intrinsics.d(downloadRange8);
            j11 = downloadRange8.getEnd() - this.f61093b;
        } else {
            p("currentRange23", "当前分片内，（暂停当前线程，启动新线程下载）快进 新增分片大于阈值, offset = " + j11);
        }
        if (f.f49475a.e()) {
            DownloadRange downloadRange9 = new DownloadRange();
            DownloadBean downloadBean3 = this.f61096e;
            if (downloadBean3 == null || (resourceId = downloadBean3.getResourceId()) == null) {
                resourceId = 0;
            }
            downloadRange9.setThreadId(resourceId.hashCode());
            DownloadRange downloadRange10 = this.f61100i;
            Intrinsics.d(downloadRange10);
            downloadRange9.setRangeId(com.transsion.startup.pref.consume.a.a(downloadRange10.getEnd() + j11));
            DownloadRange downloadRange11 = this.f61100i;
            Intrinsics.d(downloadRange11);
            downloadRange9.setResourceId(downloadRange11.getResourceId());
            downloadRange9.setStart(j11);
            DownloadRange downloadRange12 = this.f61100i;
            Intrinsics.d(downloadRange12);
            downloadRange9.setEnd(downloadRange12.getEnd());
            downloadRange9.setProgress(0L);
            DownloadRange downloadRange13 = this.f61100i;
            Intrinsics.d(downloadRange13);
            downloadRange13.setEnd(downloadRange9.getStart() - 1);
            DownloadBean downloadBean4 = this.f61096e;
            if (downloadBean4 != null && (downloadRanges = downloadBean4.getDownloadRanges()) != null) {
                downloadRanges.add(downloadRange9);
            }
            DownloadRange downloadRange14 = this.f61100i;
            this.f61100i = downloadRange9;
            DownloadBean downloadBean5 = this.f61096e;
            q(downloadBean5 != null ? downloadBean5.getDownloadRanges() : null);
            b bVar = this.f61098g;
            if (bVar != null) {
                DownloadBean downloadBean6 = this.f61096e;
                bVar.a(downloadBean6 != null ? downloadBean6.getResourceId() : null, this.f61101j, downloadRange14, downloadRange9);
            }
            for (Map.Entry<String, b> entry : this.f61099h.entrySet()) {
                String key = entry.getKey();
                DownloadBean downloadBean7 = this.f61096e;
                if (downloadBean7 == null || (url = downloadBean7.getResourceId()) == null) {
                    DownloadBean downloadBean8 = this.f61096e;
                    url = downloadBean8 != null ? downloadBean8.getUrl() : null;
                }
                if (Intrinsics.b(key, url)) {
                    b value = entry.getValue();
                    DownloadBean downloadBean9 = this.f61096e;
                    value.a(downloadBean9 != null ? downloadBean9.getResourceId() : null, this.f61101j, downloadRange14, downloadRange9);
                }
            }
        }
    }

    @Override // com.danikula.videocache.a
    public int D(byte[] buffer, long j11, int i11, String url) throws IOException {
        RandomAccessFile randomAccessFile;
        Intrinsics.g(buffer, "buffer");
        Intrinsics.g(url, "url");
        if (this.f61095d == null) {
            B();
        }
        RandomAccessFile randomAccessFile2 = this.f61095d;
        if ((randomAccessFile2 != null ? randomAccessFile2.length() : 0L) == 0) {
            DownloadRange downloadRange = this.f61100i;
            if ((downloadRange != null ? downloadRange.getProgress() : 0L) > 0) {
                q.f("read error, create new data file");
                B();
            }
        }
        RandomAccessFile randomAccessFile3 = this.f61095d;
        if (randomAccessFile3 != null) {
            randomAccessFile3.seek(j11);
        }
        DownloadRange downloadRange2 = this.f61100i;
        Intrinsics.d(downloadRange2);
        int i12 = (j11 <= downloadRange2.totalProgress() && (randomAccessFile = this.f61095d) != null) ? randomAccessFile.read(buffer, 0, i11) : -1;
        if (i12 == -1) {
            RandomAccessFile randomAccessFile4 = this.f61095d;
            Long lValueOf = randomAccessFile4 != null ? Long.valueOf(randomAccessFile4.length()) : null;
            DownloadRange downloadRange3 = this.f61100i;
            Integer numValueOf = downloadRange3 != null ? Integer.valueOf(downloadRange3.getRangeId()) : null;
            DownloadRange downloadRange4 = this.f61100i;
            Long lValueOf2 = downloadRange4 != null ? Long.valueOf(downloadRange4.getStart()) : null;
            DownloadRange downloadRange5 = this.f61100i;
            Long lValueOf3 = downloadRange5 != null ? Long.valueOf(downloadRange5.getEnd()) : null;
            DownloadRange downloadRange6 = this.f61100i;
            q.b("read -1, dataFile created & length= " + lValueOf + ", rangeId = " + numValueOf + ", offset = " + j11 + " , start =  " + lValueOf2 + ",end =  " + lValueOf3 + ", totalProgress = " + (downloadRange6 != null ? Long.valueOf(downloadRange6.totalProgress()) : null));
        }
        return i12;
    }

    @Override // com.danikula.videocache.a
    public void E(long j11) {
        if (DownloadTaskUtil.f60483a.e()) {
            return;
        }
        DownloadRange downloadRange = this.f61100i;
        if (downloadRange != null) {
            Intrinsics.d(downloadRange);
            long start = downloadRange.getStart();
            DownloadRange downloadRange2 = this.f61100i;
            Intrinsics.d(downloadRange2);
            if (j11 <= downloadRange2.getEnd() && start <= j11) {
                return;
            }
        }
        q.a("check  downloadBean = " + (this.f61096e == null));
        DownloadBean downloadBean = this.f61096e;
        if (downloadBean != null) {
            for (DownloadRange downloadRange3 : downloadBean.getDownloadRanges()) {
                if (downloadRange3.contains(j11)) {
                    this.f61101j = downloadRange3.getThreadIndex();
                    this.f61100i = downloadRange3;
                    break;
                }
            }
            uo.b.a aVar = uo.b.f78622a;
            int i11 = this.f61101j;
            DownloadRange downloadRange4 = this.f61100i;
            Object objValueOf = downloadRange4 != null ? Integer.valueOf(downloadRange4.getRangeId()) : "range is null";
            DownloadRange downloadRange5 = this.f61100i;
            Long lValueOf = downloadRange5 != null ? Long.valueOf(downloadRange5.getStart()) : null;
            DownloadRange downloadRange6 = this.f61100i;
            Long lValueOf2 = downloadRange6 != null ? Long.valueOf(downloadRange6.getEnd()) : null;
            DownloadRange downloadRange7 = this.f61100i;
            Long lValueOf3 = downloadRange7 != null ? Long.valueOf(downloadRange7.getProgress()) : null;
            DownloadBean downloadBean2 = this.f61096e;
            String resourceId = downloadBean2 != null ? downloadBean2.getResourceId() : null;
            DownloadBean downloadBean3 = this.f61096e;
            aVar.c(DownloadBaseRunnable.TAG, StringsKt__IndentKt.f("download&play set new download thread, offset=" + j11 + ",index = " + i11 + " \n                           currentRange.rangeId = " + objValueOf + ", start = " + lValueOf + ", end = " + lValueOf2 + ",\n                           progress = " + lValueOf3 + ",resourceId=" + resourceId + ",name=" + (downloadBean3 != null ? downloadBean3.getName() : null) + "\n                    "), true);
        }
    }

    @Override // com.danikula.videocache.a
    public void F(m proxyCache) {
        Intrinsics.g(proxyCache, "proxyCache");
        this.f61104m = proxyCache;
    }

    @Override // com.danikula.videocache.a
    public long G() {
        DownloadRange downloadRange = this.f61100i;
        return downloadRange != null ? downloadRange.getEnd() : A();
    }

    @Override // com.danikula.videocache.a
    public boolean H(long j11, int i11, String url) {
        Intrinsics.g(url, "url");
        this.f61103l = j11;
        DownloadBean downloadBean = this.f61096e;
        if (downloadBean != null) {
            downloadBean.setCurrentOffset(j11);
        }
        if (this.f61100i == null) {
            return false;
        }
        RandomAccessFile randomAccessFile = this.f61095d;
        if ((randomAccessFile != null ? randomAccessFile.length() : 0L) < j11) {
            return false;
        }
        DownloadRange downloadRange = this.f61100i;
        Intrinsics.d(downloadRange);
        if (downloadRange.isRangeDownloadSuccess()) {
            return true;
        }
        long j12 = j11 + ((long) i11);
        DownloadRange downloadRange2 = this.f61100i;
        Intrinsics.d(downloadRange2);
        return j12 <= downloadRange2.totalProgress();
    }

    @Override // com.danikula.videocache.a
    public void close() {
        try {
            RandomAccessFile randomAccessFile = this.f61095d;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.f61102k = "";
        } catch (Throwable unused) {
        }
    }

    public final void e(String resourceId, b callback) {
        Intrinsics.g(resourceId, "resourceId");
        Intrinsics.g(callback, "callback");
        this.f61099h.put(resourceId, callback);
    }

    public final void f(long j11) {
        DownloadRange downloadRange;
        DownloadRange downloadRange2 = this.f61100i;
        if (downloadRange2 != null) {
            Intrinsics.d(downloadRange2);
            if (downloadRange2.contains(j11)) {
                return;
            }
        }
        q.a("checkDownloadNewV2Ranges = " + (this.f61096e == null));
        DownloadBean downloadBean = this.f61096e;
        if (downloadBean != null) {
            DownloadRange downloadRange3 = this.f61100i;
            for (DownloadRange downloadRange4 : downloadBean.getDownloadRanges()) {
                if (downloadRange4.contains(j11)) {
                    this.f61101j = downloadRange4.getThreadIndex();
                    this.f61100i = downloadRange4;
                    break;
                }
            }
            uo.b.a aVar = uo.b.f78622a;
            int i11 = this.f61101j;
            DownloadRange downloadRange5 = this.f61100i;
            Boolean boolValueOf = downloadRange5 != null ? Boolean.valueOf(downloadRange5.isDownloading()) : null;
            DownloadRange downloadRange6 = this.f61100i;
            Boolean boolValueOf2 = downloadRange6 != null ? Boolean.valueOf(downloadRange6.isRangeDownloadSuccess()) : null;
            DownloadRange downloadRange7 = this.f61100i;
            Object objValueOf = downloadRange7 != null ? Integer.valueOf(downloadRange7.getRangeId()) : "range is null";
            DownloadRange downloadRange8 = this.f61100i;
            Long lValueOf = downloadRange8 != null ? Long.valueOf(downloadRange8.getStart()) : null;
            DownloadRange downloadRange9 = this.f61100i;
            Long lValueOf2 = downloadRange9 != null ? Long.valueOf(downloadRange9.getEnd()) : null;
            DownloadRange downloadRange10 = this.f61100i;
            Long lValueOf3 = downloadRange10 != null ? Long.valueOf(downloadRange10.getProgress()) : null;
            aVar.c(DownloadBaseRunnable.TAG, StringsKt__IndentKt.f("download&play checkDownloadNewV2Ranges, offset=" + j11 + ",index = " + i11 + " \n                  currentRange, isDownloading: " + boolValueOf + ", downloadSuccess: " + boolValueOf2 + "\n                  rangeId: " + objValueOf + ", start: " + lValueOf + ", end: " + lValueOf2 + ",progress: " + lValueOf3 + "\n                  resourceId:" + downloadBean.getResourceId() + ",name:" + downloadBean.getName() + "\n                "), true);
            DownloadRange downloadRange11 = this.f61100i;
            if (downloadRange11 != null) {
                Intrinsics.d(downloadRange11);
                if (downloadRange11.isDownloading()) {
                    return;
                }
                DownloadRange downloadRange12 = this.f61100i;
                Intrinsics.d(downloadRange12);
                if (downloadRange12.isRangeDownloadSuccess() || !f.f49475a.e()) {
                    return;
                }
                b bVar = this.f61098g;
                if (bVar != null) {
                    String resourceId = downloadBean.getResourceId();
                    int i12 = this.f61101j;
                    DownloadRange downloadRange13 = this.f61100i;
                    Intrinsics.d(downloadRange13);
                    downloadRange = downloadRange3;
                    bVar.a(resourceId, i12, downloadRange, downloadRange13);
                } else {
                    downloadRange = downloadRange3;
                }
                for (Map.Entry<String, b> entry : this.f61099h.entrySet()) {
                    String key = entry.getKey();
                    String resourceId2 = downloadBean.getResourceId();
                    if (resourceId2 == null) {
                        resourceId2 = downloadBean.getUrl();
                    }
                    if (Intrinsics.b(key, resourceId2)) {
                        b value = entry.getValue();
                        String resourceId3 = downloadBean.getResourceId();
                        int i13 = this.f61101j;
                        DownloadRange downloadRange14 = this.f61100i;
                        Intrinsics.d(downloadRange14);
                        value.a(resourceId3, i13, downloadRange, downloadRange14);
                    }
                }
            }
        }
    }

    public final void g(String str, long j11) {
        Object resourceId;
        List<DownloadRange> downloadRanges;
        String url;
        DownloadBean downloadBean = this.f61096e;
        List<DownloadRange> downloadRanges2 = downloadBean != null ? downloadBean.getDownloadRanges() : null;
        if (downloadRanges2 == null || downloadRanges2.isEmpty()) {
            return;
        }
        DownloadBean downloadBean2 = this.f61096e;
        Intrinsics.d(downloadBean2);
        for (DownloadRange downloadRange : downloadBean2.getDownloadRanges()) {
            if (downloadRange.contains(j11)) {
                DownloadRange downloadRange2 = this.f61100i;
                long start = downloadRange.getStart();
                if (j11 <= downloadRange.totalProgress() && start <= j11) {
                    this.f61100i = downloadRange;
                    p(str + "_range1", str + " 暂停当前线程，启动新线程下载, 已经下载，直接返回, offset = " + j11 + ", rangeId = " + downloadRange.getRangeId());
                } else if (j11 < downloadRange.getStart() + downloadRange.getProgress() + this.f61093b) {
                    this.f61100i = downloadRange;
                    p(str + "_range2", str + " 暂停当前线程，启动新线程下载, 小于阈值，等待下载,只的启动线程，不处理range, offset = " + j11);
                } else {
                    if (downloadRange.getEnd() - j11 < this.f61093b) {
                        p(str + "_range3", str + " 暂停当前线程，启动新线程下载, 新增分片小于阈值，使用阈值大小, offset = " + j11);
                        j11 = downloadRange.getEnd() - this.f61093b;
                    } else {
                        p(str + "_range4", str + " 暂停当前线程，启动新线程下载, 新增分片大于阈值, offset = " + j11);
                    }
                    if (f.f49475a.e()) {
                        DownloadRange downloadRange3 = new DownloadRange();
                        DownloadBean downloadBean3 = this.f61096e;
                        if (downloadBean3 == null || (resourceId = downloadBean3.getResourceId()) == null) {
                            resourceId = 0;
                        }
                        downloadRange3.setThreadId(resourceId.hashCode());
                        downloadRange3.setRangeId(com.transsion.startup.pref.consume.a.a(downloadRange.getEnd() + j11));
                        downloadRange3.setResourceId(downloadRange.getResourceId());
                        downloadRange3.setStart(j11);
                        downloadRange3.setEnd(downloadRange.getEnd());
                        downloadRange3.setProgress(0L);
                        downloadRange.setEnd(downloadRange3.getStart() - 1);
                        DownloadBean downloadBean4 = this.f61096e;
                        if (downloadBean4 != null && (downloadRanges = downloadBean4.getDownloadRanges()) != null) {
                            downloadRanges.add(downloadRange3);
                        }
                        this.f61100i = downloadRange3;
                        DownloadBean downloadBean5 = this.f61096e;
                        q(downloadBean5 != null ? downloadBean5.getDownloadRanges() : null);
                    }
                }
                DownloadRange downloadRange4 = this.f61100i;
                if (downloadRange4 != null) {
                    Intrinsics.d(downloadRange4);
                    if (downloadRange4.isRangeDownloadSuccess()) {
                        return;
                    }
                    DownloadRange downloadRange5 = this.f61100i;
                    Intrinsics.d(downloadRange5);
                    if (downloadRange5.isDownloading() || !f.f49475a.e()) {
                        return;
                    }
                    b bVar = this.f61098g;
                    if (bVar != null) {
                        DownloadBean downloadBean6 = this.f61096e;
                        String resourceId2 = downloadBean6 != null ? downloadBean6.getResourceId() : null;
                        int i11 = this.f61101j;
                        DownloadRange downloadRange6 = this.f61100i;
                        Intrinsics.d(downloadRange6);
                        bVar.a(resourceId2, i11, downloadRange2, downloadRange6);
                    }
                    for (Map.Entry<String, b> entry : this.f61099h.entrySet()) {
                        String key = entry.getKey();
                        DownloadBean downloadBean7 = this.f61096e;
                        if (downloadBean7 == null || (url = downloadBean7.getResourceId()) == null) {
                            DownloadBean downloadBean8 = this.f61096e;
                            url = downloadBean8 != null ? downloadBean8.getUrl() : null;
                        }
                        if (Intrinsics.b(key, url)) {
                            b value = entry.getValue();
                            DownloadBean downloadBean9 = this.f61096e;
                            String resourceId3 = downloadBean9 != null ? downloadBean9.getResourceId() : null;
                            int i12 = this.f61101j;
                            DownloadRange downloadRange7 = this.f61100i;
                            Intrinsics.d(downloadRange7);
                            value.a(resourceId3, i12, downloadRange2, downloadRange7);
                        }
                    }
                    return;
                }
                return;
            }
        }
    }

    public final DownloadBean h() {
        return this.f61096e;
    }

    public final d i() {
        return this.f61106o;
    }

    @Override // com.danikula.videocache.a
    public boolean isCompleted() {
        DownloadBean downloadBean = this.f61096e;
        return downloadBean != null && downloadBean.getStatus() == 5;
    }

    public final h j() {
        return (h) this.f61094c.getValue();
    }

    public final boolean k() {
        return this.f61105n;
    }

    public final void l(String resourceId) {
        Intrinsics.g(resourceId, "resourceId");
        this.f61099h.remove(resourceId);
    }

    public final void m() {
        this.f61100i = null;
        this.f61101j = 0;
        this.f61102k = "";
        close();
        this.f61095d = null;
        this.f61104m = null;
        this.f61105n = true;
    }

    public final void n(String str) {
        this.f61097f = str;
    }

    public final void o(DownloadBean downloadBean) {
        Intrinsics.g(downloadBean, "downloadBean");
        this.f61105n = false;
        q.e("set new video =  " + downloadBean.getName());
        this.f61096e = downloadBean;
        Long size = downloadBean.getSize();
        long jLongValue = size != null ? size.longValue() / ((long) 120) : this.f61092a;
        long j11 = this.f61092a;
        if (jLongValue > j11) {
            jLongValue = j11;
        }
        this.f61093b = jLongValue;
        DownloadUtil.f61136a.u(downloadBean);
    }

    public final void p(String str, String str2) {
        if (Intrinsics.b(this.f61102k, str)) {
            return;
        }
        this.f61102k = str;
        q.a("================range,  " + str2);
    }

    public final void q(List<DownloadRange> list) {
        List<DownloadRange> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        if (arrayList.size() > 1) {
            j.z(arrayList, new Comparator() { // from class: com.transsnet.downloader.proxy.DownloadFileCache$updateDBRanges$lambda$5$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return kotlin.comparisons.b.d(Long.valueOf(((DownloadRange) t11).getStart()), Long.valueOf(((DownloadRange) t12).getStart()));
                }
            });
        }
        list.clear();
        list.addAll(arrayList);
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new DownloadFileCache$updateDBRanges$1(list, this, null), 3, null);
    }

    @Override // com.danikula.videocache.a
    public String z() {
        String str = this.f61097f;
        if (str != null) {
            return str;
        }
        DownloadBean downloadBean = this.f61096e;
        return (downloadBean == null || downloadBean.getType() != 1) ? MimeTypes.VIDEO_MP4 : MimeTypes.AUDIO_MPEG;
    }
}
