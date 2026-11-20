package com.cloud.tmc.offline.download.task;

import android.os.SystemClock;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.PreloadResource;
import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.h5update.utils.l;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.proxy.OfflineAppProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.OfflineDownloadAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.miniutils.util.j;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflineZipDownloadInfo;
import com.cloud.tmc.offline.download.model.OfflineZipFileInfo;
import com.cloud.tmc.offline.download.utils.OfflineStoreCache;
import com.cloud.tmc.offline.download.utils.OfflineUtils;
import com.cloud.tmc.offline.download.utils.f;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xb.e;

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
public final class a extends ce.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C0349a f32037o = new C0349a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OffPkgConfig f32038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f32039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f32040j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function2<? super ce.b, ? super yd.a<?>, Unit> f32041k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f32042l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f32043m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f32044n;

    /* JADX INFO: renamed from: com.cloud.tmc.offline.download.task.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0349a {
        public C0349a() {
        }

        public /* synthetic */ C0349a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements vd.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f32046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Set<String> f32047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Set<String> f32048d;

        public b(CountDownLatch countDownLatch, Set<String> set, Set<String> set2) {
            this.f32046b = countDownLatch;
            this.f32047c = set;
            this.f32048d = set2;
        }

        @Override // vd.b
        public void a(String url) {
            Intrinsics.g(url, "url");
            this.f32047c.add(url);
            this.f32046b.countDown();
        }

        @Override // vd.b
        public void b(String url, long j11, long j12) {
            Intrinsics.g(url, "url");
            if (a.this.f32042l.containsKey(url)) {
                return;
            }
            a.this.f32042l.put(url, Long.valueOf(System.currentTimeMillis()));
        }

        @Override // vd.b
        public void c(String url) {
            Intrinsics.g(url, "url");
            OfflineStoreCache.f32077a.s(a.this.h(), new OfflineZipDownloadInfo(url, null, 2, null, 10, null));
        }

        @Override // vd.b
        public void d(String url) {
            Intrinsics.g(url, "url");
            OfflineStoreCache.f32077a.s(a.this.h(), new OfflineZipDownloadInfo(url, null, 3, null, 10, null));
            a.this.f32043m.put(url, Long.valueOf(System.currentTimeMillis()));
        }

        @Override // vd.b
        public void e(String url, String zipUnCompressPath, File zipFile) {
            String appId;
            String logo;
            Intrinsics.g(url, "url");
            Intrinsics.g(zipUnCompressPath, "zipUnCompressPath");
            Intrinsics.g(zipFile, "zipFile");
            OfflineUtils offlineUtils = OfflineUtils.f32081a;
            OffPkgConfig offPkgConfigL = offlineUtils.L(zipUnCompressPath);
            if (offPkgConfigL == null) {
                OfflineStoreCache.f32077a.s(a.this.h(), new OfflineZipDownloadInfo(url, null, 5, null, 8, null));
                StringBuilder sb2 = new StringBuilder();
                String group = a.this.h().getGroup();
                if (group == null) {
                    group = "The";
                }
                sb2.append(group);
                sb2.append(" downloaded offline package is not legal! zipUnCompressPath: ");
                sb2.append(zipUnCompressPath);
                TmcLogger.c("TmcOfflineDownload: DownloadTask", sb2.toString());
                this.f32046b.countDown();
                return;
            }
            this.f32047c.add(url);
            OfflineStoreCache.f32077a.s(a.this.h(), new OfflineZipDownloadInfo(url, zipUnCompressPath, 4, offPkgConfigL));
            String str = "";
            offlineUtils.u(e.a(offPkgConfigL != null ? offPkgConfigL.getGroup() : null, e.a(a.this.h().getGroup(), "")), zipUnCompressPath);
            Long lValueOf = (Long) a.this.f32043m.remove(url);
            if (lValueOf == null) {
                lValueOf = Long.valueOf(System.currentTimeMillis());
            }
            long jLongValue = lValueOf.longValue();
            Long lValueOf2 = (Long) a.this.f32042l.remove(url);
            if (lValueOf2 == null) {
                lValueOf2 = Long.valueOf(jLongValue);
            }
            f.f32092a.e(a.this.h().getGroup(), url, true, 200, "success", jLongValue - lValueOf2.longValue());
            this.f32046b.countDown();
            OfflineAppProxy offlineAppProxy = (OfflineAppProxy) tc.a.a(OfflineAppProxy.class);
            AppInfoModel appInfo = a.this.h().getAppInfo();
            if (appInfo == null || (appId = appInfo.getAppId()) == null) {
                appId = "";
            }
            AppInfoModel appInfo2 = a.this.h().getAppInfo();
            if (appInfo2 != null && (logo = appInfo2.getLogo()) != null) {
                str = logo;
            }
            offlineAppProxy.downloadIcon(appId, str);
            ((OfflineAppProxy) tc.a.a(OfflineAppProxy.class)).scanForOfflineDownloadSuccess();
        }

        @Override // vd.b
        public void f(String url) {
            Intrinsics.g(url, "url");
            OfflineStoreCache.f32077a.s(a.this.h(), new OfflineZipDownloadInfo(url, null, 1, null, 10, null));
            a.this.f32042l.put(url, Long.valueOf(System.currentTimeMillis()));
        }

        @Override // vd.b
        public void g(String url) {
            Intrinsics.g(url, "url");
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long lValueOf = (Long) a.this.f32042l.remove(url);
            if (lValueOf == null) {
                lValueOf = Long.valueOf(jCurrentTimeMillis);
            }
            f.f32092a.e(a.this.h().getGroup(), url, false, 1000, "cancel", jCurrentTimeMillis - lValueOf.longValue());
            OfflineStoreCache.f32077a.s(a.this.h(), new OfflineZipDownloadInfo(url, null, 0, null, 10, null));
            this.f32048d.add(url);
            this.f32046b.countDown();
        }

        @Override // vd.b
        public void onError(String url, int i11, String errMsg) {
            Intrinsics.g(url, "url");
            Intrinsics.g(errMsg, "errMsg");
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long lValueOf = (Long) a.this.f32042l.remove(url);
            if (lValueOf == null) {
                lValueOf = Long.valueOf(jCurrentTimeMillis);
            }
            f.f32092a.e(a.this.h().getGroup(), url, false, Integer.valueOf(i11), errMsg, jCurrentTimeMillis - lValueOf.longValue());
            OfflineStoreCache.f32077a.s(a.this.h(), new OfflineZipDownloadInfo(url, null, 0, null, 10, null));
            this.f32048d.add(url);
            this.f32046b.countDown();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(OffPkgConfig offPkgConfig, String trigger, boolean z11, Function2<? super ce.b, ? super yd.a<?>, Unit> function2) {
        super("DownloadTask-" + offPkgConfig.getGroup(), 0L, 2, null);
        Intrinsics.g(offPkgConfig, "offPkgConfig");
        Intrinsics.g(trigger, "trigger");
        this.f32038h = offPkgConfig;
        this.f32039i = trigger;
        this.f32040j = z11;
        this.f32041k = function2;
        this.f32042l = new ConcurrentHashMap<>();
        this.f32043m = new ConcurrentHashMap<>();
        this.f32044n = offPkgConfig.getPriority();
    }

    public /* synthetic */ a(OffPkgConfig offPkgConfig, String str, boolean z11, Function2 function2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(offPkgConfig, str, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? null : function2);
    }

    @Override // ce.b
    public String I() {
        return this.f32039i;
    }

    @Override // ce.a, ce.b
    public Function2<ce.b, yd.a<?>, Unit> J() {
        return this.f32041k;
    }

    @Override // ce.a, ce.b
    public boolean M() {
        return this.f32040j;
    }

    @Override // ce.b
    public void P(Function1<? super yd.a<?>, Unit> function1) {
        yd.a c0915a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jL = jElapsedRealtime - L();
        OfflineUtils offlineUtils = OfflineUtils.f32081a;
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(null, OfflineDownloadAnalyseType.QUEUE_TIME, this + "，耗时：" + jL + "ms", offlineUtils.P(this.f32038h, I(), Boolean.valueOf(M()), Long.valueOf(jL), this));
        TmcLogger.c("TmcOfflineDownload: DownloadTask", "DownloadTask::run() " + o.a(this.f32038h));
        if (!com.cloud.tmc.offline.download.utils.e.a()) {
            TmcLogger.c("TmcOfflineDownload: DownloadTask", "Network connection is not connected!");
            if (function1 != null) {
                function1.invoke(new yd.a.C0915a(107, "Network connection is not connected!", true));
                return;
            }
            return;
        }
        String group = this.f32038h.getGroup();
        if (group == null || group.length() == 0) {
            if (function1 != null) {
                StringBuilder sb2 = new StringBuilder();
                String group2 = this.f32038h.getGroup();
                if (group2 == null) {
                    group2 = "The";
                }
                sb2.append(group2);
                sb2.append(" offline package download group is empty");
                function1.invoke(new yd.a.C0915a(105, sb2.toString(), true));
                return;
            }
            return;
        }
        OfflineZipFileInfo offlineZipFileInfoQ = offlineUtils.q(this.f32038h);
        TmcLogger.c("TmcOfflineDownload: DownloadTask", "fileInfo: " + offlineZipFileInfoQ);
        String zipCacheAbsolutePath = offlineZipFileInfoQ.getZipCacheAbsolutePath();
        try {
            if (j.j(zipCacheAbsolutePath)) {
                TH5Update.f28868c.o(zipCacheAbsolutePath);
                UpdateEntity updateEntityT = offlineUtils.t(this.f32038h);
                if (updateEntityT == null) {
                    if (function1 != null) {
                        function1.invoke(new yd.a.C0915a(0, "Offline cache extra config is null or empty", false, 5, null));
                        return;
                    }
                    return;
                }
                List<PreloadResource> preloadResource = updateEntityT.getPreloadResource();
                List<PreloadResource> list = preloadResource;
                if (list == null || list.isEmpty()) {
                    if (function1 != null) {
                        function1.invoke(new yd.a.C0915a(0, "Offline resource is null or empty", false, 5, null));
                        return;
                    }
                    return;
                }
                OfflineManager offlineManager = OfflineManager.f32003a;
                if (offlineManager.L() != null) {
                    if (function1 != null) {
                        function1.invoke(new yd.a.C0915a(0, "Offline has downloadTask is running...", false, 5, null));
                        return;
                    }
                    return;
                }
                CountDownLatch countDownLatch = new CountDownLatch(preloadResource.size());
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                offlineManager.h0(new b(countDownLatch, linkedHashSet, new LinkedHashSet()));
                try {
                    l.f28923a.p(updateEntityT);
                    TmcLogger.c("TmcOfflineDownload: DownloadTask", "await: " + countDownLatch.await(preloadResource.size(), TimeUnit.MINUTES));
                    f.f32092a.a(this.f32038h.getGroup());
                    offlineManager.h0(null);
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(null, OfflineDownloadAnalyseType.DOWNLOAD_TIME, this + "，耗时：" + jElapsedRealtime2 + "ms", offlineUtils.P(this.f32038h, I(), Boolean.valueOf(M()), Long.valueOf(jElapsedRealtime2), this));
                    if (!linkedHashSet.isEmpty()) {
                        c0915a = new yd.a.b("Download completed. offPkgConfig: " + o.a(this.f32038h), true);
                    } else {
                        c0915a = new yd.a.C0915a(113, "Download failed", true);
                    }
                    if (function1 != null) {
                        function1.invoke(c0915a);
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    TmcLogger.g("TmcOfflineDownload: DownloadTask", "Error processing update entity", th2);
                    if (function1 != null) {
                        function1.invoke(new yd.a.C0915a(0, th2.getMessage(), true, 1, null));
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e11) {
            TmcLogger.g("TmcOfflineDownload: DownloadTask", "Unable to create zip directory", e11);
        }
        if (function1 != null) {
            function1.invoke(new yd.a.C0915a(0, "Offline cache file deletion failed", false, 5, null));
        }
    }

    @Override // ce.a, ce.b
    public int getPriority() {
        return this.f32044n;
    }

    public final OffPkgConfig h() {
        return this.f32038h;
    }
}
