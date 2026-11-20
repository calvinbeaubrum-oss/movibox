package com.transsnet.downloader.core;

import android.app.Application;
import android.support.v4.media.session.PlaybackStateCompat;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsnet.downloader.config.Config;
import com.transsnet.downloader.core.task.DownloadFileInfoTask;
import com.transsnet.downloader.core.task.b;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.core.thread.DownloadExecutor;
import com.transsnet.downloader.core.thread.DownloadRunnable;
import com.transsnet.downloader.core.thread.c;
import com.transsnet.downloader.report.DownloadReporter;
import com.transsnet.downloader.util.DownloadUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.j;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import l.p;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadTaskImpl implements com.transsnet.downloader.core.task.a, com.transsnet.downloader.core.thread.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f60449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.transsnet.downloader.proxy.a f60450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadBean f60451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Config f60452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<c> f60453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f60454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f60455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f60456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.transsnet.downloader.proxy.b f60457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AtomicInteger f60458j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public k0 f60459k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f60460l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f60461m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicInteger f60462n;

    /* JADX INFO: renamed from: com.transsnet.downloader.core.DownloadTaskImpl$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.core.DownloadTaskImpl$start$1", f = "DownloadTaskImpl.kt", l = {ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend")
    public static final class C20251 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public C20251(Continuation<? super C20251> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadTaskImpl.this.new C20251(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C20251) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            DownloadTaskImpl downloadTaskImpl;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                String resourceId = DownloadTaskImpl.this.f60451c.getResourceId();
                if (resourceId != null) {
                    DownloadTaskImpl downloadTaskImpl2 = DownloadTaskImpl.this;
                    h hVar = downloadTaskImpl2.f60456h;
                    this.L$0 = downloadTaskImpl2;
                    this.label = 1;
                    obj = hVar.a(resourceId, this);
                    if (obj == objE) {
                        return objE;
                    }
                    downloadTaskImpl = downloadTaskImpl2;
                }
                DownloadTaskImpl.this.B();
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            downloadTaskImpl = (DownloadTaskImpl) this.L$0;
            ResultKt.b(obj);
            List list = (List) obj;
            uo.b.a.f(uo.b.f78622a, "Download_VideoCache", "ranges size = " + (list != null ? Boxing.d(list.size()) : null), false, 4, null);
            if (list != null) {
                downloadTaskImpl.f60451c.getDownloadRanges().clear();
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                downloadTaskImpl.r(arrayList);
                Boxing.a(downloadTaskImpl.f60451c.getDownloadRanges().addAll(arrayList));
            }
            DownloadTaskImpl.this.B();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.core.DownloadTaskImpl$start$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.core.DownloadTaskImpl$start$2", f = "DownloadTaskImpl.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadTaskImpl.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            DownloadTaskImpl.this.B();
            return Unit.f68710a;
        }
    }

    public DownloadTaskImpl(a downloadResponse, com.transsnet.downloader.proxy.a proxyHelper, final DownloadBean downloadInfo, final Config config, b bVar) {
        Intrinsics.g(downloadResponse, "downloadResponse");
        Intrinsics.g(proxyHelper, "proxyHelper");
        Intrinsics.g(downloadInfo, "downloadInfo");
        Intrinsics.g(config, "config");
        this.f60449a = downloadResponse;
        this.f60450b = proxyHelper;
        this.f60455g = System.currentTimeMillis();
        this.f60458j = new AtomicInteger(0);
        this.f60459k = l0.a(w0.b());
        this.f60460l = "DownloadThread_TaskImpl";
        this.f60461m = LazyKt__LazyJVMKt.b(new Function0<h>() { // from class: com.transsnet.downloader.core.DownloadTaskImpl$rangeDao$2
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).F0();
            }
        });
        this.f60462n = new AtomicInteger(0);
        this.f60451c = downloadInfo;
        this.f60452d = config;
        this.f60454f = bVar;
        this.f60453e = new ArrayList();
        AppDatabase.v0 v0Var = AppDatabase.f51036p;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        this.f60456h = v0Var.b(applicationA).F0();
        com.transsnet.downloader.proxy.b bVar2 = new com.transsnet.downloader.proxy.b() { // from class: com.transsnet.downloader.core.DownloadTaskImpl.1
            @Override // com.transsnet.downloader.proxy.b
            public void a(String str, final int i11, final DownloadRange downloadRange, final DownloadRange range) {
                Intrinsics.g(range, "range");
                if (!Intrinsics.b(str, downloadInfo.getResourceId()) || range.isRangeDownloadSuccess() || this.f60453e.isEmpty()) {
                    return;
                }
                final c cVar = (c) this.f60453e.get(this.f60453e.size() - 1);
                final DownloadTaskImpl downloadTaskImpl = this;
                final Config config2 = config;
                final DownloadBean downloadBean = downloadInfo;
                cVar.pause(new Function0<Unit>() { // from class: com.transsnet.downloader.core.DownloadTaskImpl$1$onStartNewRangeThread$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        cVar.removeBreakCallback();
                        downloadTaskImpl.f60453e.remove(cVar);
                        uo.b.a aVar = uo.b.f78622a;
                        uo.b.a.s(aVar, "DownloadThread", "beak success, start new thread", false, 4, null);
                        range.setDownloading(true);
                        DownloadRunnable downloadRunnable = new DownloadRunnable(range, downloadTaskImpl.f60450b, i11, downloadTaskImpl.f60449a, config2, downloadBean, downloadTaskImpl);
                        downloadTaskImpl.f60453e.add(downloadRunnable);
                        DownloadRange downloadRange2 = downloadRange;
                        Integer numValueOf = downloadRange2 != null ? Integer.valueOf(downloadRange2.getRangeId()) : null;
                        DownloadRange downloadRange3 = downloadRange;
                        Long lValueOf = downloadRange3 != null ? Long.valueOf(downloadRange3.getStart()) : null;
                        DownloadRange downloadRange4 = downloadRange;
                        Long lValueOf2 = downloadRange4 != null ? Long.valueOf(downloadRange4.getEnd()) : null;
                        aVar.r(DownloadBaseRunnable.TAG, "download&play start new thread,oldRangeId:" + numValueOf + ",start:" + lValueOf + ",end:" + lValueOf2 + ", rangeId: " + range.getRangeId() + ", start:" + range.getStart() + ",end:" + range.getEnd(), true);
                        DownloadExecutor.f60487a.b().c(downloadRunnable);
                    }
                });
            }
        };
        this.f60457i = bVar2;
        String resourceId = downloadInfo.getResourceId();
        proxyHelper.a(resourceId == null ? downloadInfo.getUrl() : resourceId, bVar2);
    }

    private final synchronized boolean q() {
        if (this.f60451c.getDownloadRanges().isEmpty()) {
            return false;
        }
        Iterator<T> it = this.f60451c.getDownloadRanges().iterator();
        while (it.hasNext()) {
            if (!((DownloadRange) it.next()).isRangeDownloadSuccess()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h u() {
        return (h) this.f60461m.getValue();
    }

    private final void v() {
        uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"开始下载--多线程"}, true);
        ArrayList<DownloadRange> arrayList = new ArrayList();
        List<DownloadRange> downloadRanges = this.f60451c.getDownloadRanges();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(downloadRanges);
        if (arrayList2.size() > 1) {
            j.z(arrayList2, new Comparator() { // from class: com.transsnet.downloader.core.DownloadTaskImpl$handleMultithreadingDownloadOnly$lambda$2$lambda$1$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return kotlin.comparisons.b.d(Long.valueOf(((DownloadRange) t11).getStart()), Long.valueOf(((DownloadRange) t12).getStart()));
                }
            });
        }
        downloadRanges.clear();
        downloadRanges.addAll(arrayList2);
        for (DownloadRange downloadRange : this.f60451c.getDownloadRanges()) {
            downloadRange.setDownloading(false);
            if (arrayList.size() < this.f60452d.b() && !downloadRange.isRangeDownloadSuccess() && downloadRange.getRangeSize() <= this.f60452d.c()) {
                uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"添加下载分片,rangeId = " + downloadRange.getRangeId() + ",start =  " + downloadRange.getStart() + ",end = " + downloadRange.getEnd() + "， progress = " + downloadRange.getProgress() + " "}, true);
                arrayList.add(downloadRange);
            }
        }
        if (arrayList.size() < this.f60452d.b()) {
            arrayList.addAll(t(this.f60452d.b() - arrayList.size(), arrayList));
        }
        int i11 = this.f60458j.get() - 1;
        this.f60458j.addAndGet(arrayList.size());
        for (DownloadRange downloadRange2 : arrayList) {
            i11++;
            DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange2, this.f60450b, i11, this.f60449a, this.f60452d, this.f60451c, this);
            uo.b.f78622a.n(this.f60460l, new String[]{"----多线程下载开始, rangeId =  " + downloadRange2.getRangeId() + ", curSize= " + i11 + "，status = " + this.f60451c.getStatus()}, true);
            downloadRange2.setDownloading(true);
            DownloadExecutor.f60487a.b().c(downloadRunnable);
            this.f60453e.add(downloadRunnable);
        }
    }

    private final void w(int i11) {
        uo.b.a.f(uo.b.f78622a, this.f60460l, "2---handleNextRangeDownload", false, 4, null);
        ArrayList<DownloadRange> arrayList = new ArrayList();
        arrayList.addAll(this.f60451c.getDownloadRanges());
        for (DownloadRange downloadRange : arrayList) {
            if (!downloadRange.isRangeDownloadSuccess()) {
                uo.b.a.f(uo.b.f78622a, this.f60460l, "2---rangeId = " + downloadRange.getRangeId() + ", isDownloading = " + downloadRange.isDownloading(), false, 4, null);
            }
            if (!downloadRange.isDownloading() && !downloadRange.isRangeDownloadSuccess()) {
                if (!this.f60451c.isDownloadingPlay() && downloadRange.getRangeSize() - downloadRange.getProgress() > this.f60452d.c()) {
                    uo.b.f78622a.c(this.f60460l, "onRangeSuccess 这个分片太大，需要切成小分片", true);
                    long progress = downloadRange.getProgress() + downloadRange.getStart() + this.f60452d.c() + 1;
                    long end = downloadRange.getEnd();
                    DownloadRange downloadRange2 = new DownloadRange();
                    downloadRange2.setThreadId(downloadRange.getThreadId());
                    downloadRange2.setRangeId(p.a(progress + end));
                    downloadRange2.setResourceId(downloadRange.getResourceId());
                    downloadRange2.setStart(progress);
                    downloadRange2.setEnd(end);
                    downloadRange2.setProgress(0L);
                    downloadRange.setEnd(downloadRange2.getStart() - 1);
                    this.f60451c.getDownloadRanges().add(downloadRange2);
                    C(this.f60451c.getDownloadRanges());
                }
                DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange, this.f60450b, i11, this.f60449a, this.f60452d, this.f60451c, this);
                downloadRange.setDownloading(true);
                uo.b.a.f(uo.b.f78622a, this.f60460l, "2---start single new range tread~ rangeId = " + downloadRange.getRangeId() + ", range.start = " + downloadRange.getStart() + ",range.end = " + downloadRange.getEnd(), false, 4, null);
                this.f60453e.add(downloadRunnable);
                this.f60458j.getAndIncrement();
                DownloadExecutor.f60487a.b().c(downloadRunnable);
                return;
            }
        }
    }

    private final void y(int i11) {
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, this.f60460l, "1---multithreadingDownload", false, 4, null);
        List<DownloadRange> listT = t(i11, null);
        aVar.c(DownloadBaseRunnable.TAG, "执行多线程下载, 需要启的线程数 =  " + listT.size(), true);
        int i12 = this.f60458j.get() - 1;
        this.f60458j.addAndGet(listT.size());
        for (DownloadRange downloadRange : listT) {
            int i13 = i12 + 1;
            DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange, this.f60450b, i13, this.f60449a, this.f60452d, this.f60451c, this);
            uo.b.a.f(uo.b.f78622a, this.f60460l, "----多线程下载开始, rangeId =  " + downloadRange.getRangeId() + "， index = " + i13 + "，status = " + this.f60451c.getStatus(), false, 4, null);
            downloadRange.setDownloading(true);
            this.f60453e.add(downloadRunnable);
            DownloadExecutor.f60487a.b().c(downloadRunnable);
            i12 = i13;
        }
    }

    public final void A() {
        long jC = this.f60452d.c();
        Long size = this.f60451c.getSize();
        boolean z11 = jC < (size != null ? size.longValue() : 0L);
        this.f60451c.setStatus(2);
        this.f60449a.a(this.f60451c);
        this.f60451c.setSupportRanges(z11);
        new DownloadFileInfoTask().b(this.f60451c);
        int iB = this.f60452d.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isSupportRanges ");
        sb2.append(z11);
        sb2.append(" config.eachDownloadThread ");
        sb2.append(iB);
        b bVar = this.f60454f;
        if (bVar != null) {
            bVar.c(this.f60451c, true);
        }
        if (z11) {
            long downloadHeaderSize = this.f60451c.getDownloadHeaderSize();
            int iB2 = this.f60452d.b();
            long j11 = downloadHeaderSize / ((long) iB2);
            int i11 = 0;
            while (i11 < iB2) {
                long j12 = ((long) i11) * j11;
                long j13 = i11 == iB2 + (-1) ? downloadHeaderSize - 1 : (j12 + j11) - 1;
                DownloadRange downloadRange = new DownloadRange();
                String resourceId = this.f60451c.getResourceId();
                downloadRange.setThreadId(resourceId != null ? resourceId.hashCode() : 0);
                downloadRange.setRangeId(p.a(j12 + j13));
                downloadRange.setResourceId(this.f60451c.getResourceId());
                downloadRange.setStart(j12);
                downloadRange.setEnd(j13);
                downloadRange.setDownloading(true);
                this.f60451c.getDownloadRanges().add(downloadRange);
                DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange, this.f60450b, i11, this.f60449a, this.f60452d, this.f60451c, this);
                DownloadExecutor.f60487a.b().c(downloadRunnable);
                this.f60453e.add(downloadRunnable);
                this.f60458j.getAndIncrement();
                i11++;
                iB2 = iB2;
            }
            Long size2 = this.f60451c.getSize();
            long jLongValue = (size2 != null ? size2.longValue() : 1L) - 1;
            DownloadRange downloadRange2 = new DownloadRange();
            String resourceId2 = this.f60451c.getResourceId();
            downloadRange2.setThreadId(resourceId2 != null ? resourceId2.hashCode() : 0);
            downloadRange2.setRangeId(p.a(downloadHeaderSize + jLongValue));
            downloadRange2.setResourceId(this.f60451c.getResourceId());
            downloadRange2.setStart(downloadHeaderSize);
            downloadRange2.setEnd(jLongValue);
            this.f60451c.getDownloadRanges().add(downloadRange2);
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"首次多线程下载,  allSize= " + this.f60452d.b() + "，curThreadSize = " + this.f60458j + ", curThreadListSize = " + this.f60453e.size()}, true);
        } else {
            DownloadRange downloadRange3 = new DownloadRange();
            String resourceId3 = this.f60451c.getResourceId();
            downloadRange3.setThreadId(resourceId3 != null ? resourceId3.hashCode() : 0);
            Long size3 = this.f60451c.getSize();
            downloadRange3.setRangeId(p.a(size3 != null ? size3.longValue() : 1L));
            downloadRange3.setResourceId(this.f60451c.getResourceId());
            downloadRange3.setStart(0L);
            Long size4 = this.f60451c.getSize();
            downloadRange3.setEnd((size4 != null ? size4.longValue() : 1L) - 1);
            this.f60451c.getDownloadRanges().add(downloadRange3);
            DownloadRunnable downloadRunnable2 = new DownloadRunnable(downloadRange3, this.f60450b, 0, this.f60449a, this.f60452d, this.f60451c, this);
            downloadRange3.setDownloading(true);
            DownloadExecutor.f60487a.b().c(downloadRunnable2);
            this.f60453e.add(downloadRunnable2);
            this.f60458j.getAndIncrement();
        }
        this.f60451c.setStatus(2);
        this.f60449a.a(this.f60451c);
    }

    public final void B() {
        DownloadUtil downloadUtil = DownloadUtil.f61136a;
        if (downloadUtil.c(this.f60451c)) {
            DownloadReporter.f61112c.a().g(this.f60451c, null);
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"startDownload, 资源有问题，需要从头下载"}, true);
            downloadUtil.z(this.f60451c);
        }
        this.f60451c.setRestartDownloadCount(0);
        if (q()) {
            e();
            return;
        }
        if (!this.f60451c.getDownloadRanges().isEmpty()) {
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"DownloadTaskImpl has task, do not check, name = " + this.f60451c.getName()}, true);
            b bVar = this.f60454f;
            if (bVar != null) {
                bVar.c(this.f60451c, false);
            }
            if (this.f60451c.isDownloadingPlay()) {
                x();
            } else {
                v();
            }
            this.f60451c.setStatus(2);
            this.f60449a.a(this.f60451c);
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        aVar.c(DownloadBaseRunnable.TAG, "stat new task, name = " + this.f60451c.getName(), true);
        String path = this.f60451c.getPath();
        if (path == null || path.length() == 0) {
            DownloadBean downloadBean = this.f60451c;
            downloadBean.setPath(downloadUtil.j(downloadBean));
            aVar.n(DownloadBaseRunnable.TAG, new String[]{"DownloadTaskImpl 新任务, set download path, path = " + this.f60451c.getPath()}, true);
        }
        if (this.f60451c.getDownloadHeaderSize() <= 0) {
            DownloadBean downloadBean2 = this.f60451c;
            downloadBean2.setDownloadHeaderSize(downloadUtil.f(downloadBean2));
        }
        A();
    }

    public final void C(List<DownloadRange> list) {
        r(list);
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new DownloadTaskImpl$updateDBRanges$1(this, list, null), 3, null);
    }

    @Override // com.transsnet.downloader.core.thread.a
    public synchronized void a(c runnable, int i11, DownloadRange curRange) {
        try {
            Intrinsics.g(runnable, "runnable");
            Intrinsics.g(curRange, "curRange");
            int iDecrementAndGet = this.f60458j.get() > 0 ? this.f60458j.decrementAndGet() : 0;
            curRange.setDownloading(false);
            boolean zRemove = this.f60453e.remove(runnable);
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, this.f60460l, "reDownload，result =" + zRemove, false, 4, null);
            if (iDecrementAndGet <= 0) {
                aVar.n(DownloadBaseRunnable.TAG, new String[]{"重新下载所有线程已经暂停，开始执行新下载"}, true);
                kotlinx.coroutines.j.d(this.f60459k, null, null, new DownloadTaskImpl$reDownload$1(this, null), 3, null);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.transsnet.downloader.core.task.a
    public DownloadBean b() {
        return this.f60451c;
    }

    @Override // com.transsnet.downloader.core.thread.a
    public synchronized void c(c runnable, int i11, DownloadRange curRange) {
        try {
            Intrinsics.g(runnable, "runnable");
            Intrinsics.g(curRange, "curRange");
            int iDecrementAndGet = this.f60458j.get() > 0 ? this.f60458j.decrementAndGet() : 0;
            curRange.setDownloading(false);
            this.f60453e.remove(runnable);
            int iB = this.f60452d.b() - iDecrementAndGet;
            uo.b.f78622a.c(DownloadBaseRunnable.TAG, "边下边播 退出-------执行多线程， threadSize = " + iB, true);
            if (iB > 0) {
                y(iB);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.transsnet.downloader.core.thread.a
    public synchronized void d() {
        int status = this.f60451c.getStatus();
        if (status == 1 || status == 2 || this.f60462n.get() != status) {
            this.f60462n.set(status);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f60455g > 1000) {
                long jS = s();
                Long size = this.f60451c.getSize();
                if (jS > (size != null ? size.longValue() : 1L)) {
                    e();
                } else {
                    this.f60451c.setUpdateTimeStamp(Long.valueOf(jCurrentTimeMillis));
                    this.f60449a.a(this.f60451c);
                    this.f60455g = jCurrentTimeMillis;
                }
            }
        }
    }

    @Override // com.transsnet.downloader.core.thread.a
    public synchronized void e() {
        s();
        if (this.f60451c.getStatus() == 5) {
            uo.b.a.f(uo.b.f78622a, this.f60460l, "--------onDownloadSuccess---相同状态，无需重复回调-", false, 4, null);
            return;
        }
        long progress = this.f60451c.getProgress();
        Long size = this.f60451c.getSize();
        if (progress >= (size != null ? size.longValue() : 1L) || q()) {
            DownloadUtil downloadUtil = DownloadUtil.f61136a;
            if (downloadUtil.c(this.f60451c)) {
                DownloadReporter.f61112c.a().g(this.f60451c, null);
                uo.b.a aVar = uo.b.f78622a;
                aVar.c(DownloadBaseRunnable.TAG, "onDownloadSuccess, 资源有问题，需要重新下载，  progress = " + this.f60451c.getProgress(), true);
                this.f60451c.setStatus(0);
                downloadUtil.z(this.f60451c);
                uo.b.a.f(aVar, "ReDownload", "resetProgress， progress = " + this.f60451c.getProgress(), false, 4, null);
                b bVar = this.f60454f;
                if (bVar != null) {
                    bVar.g(this.f60451c);
                }
                return;
            }
            uo.b.f78622a.c(DownloadBaseRunnable.TAG, "------------------------------onDownloadSuccess subjectId=" + this.f60451c.getResourceId() + ",resourceId=" + this.f60451c.getResourceId() + "------------------------------", true);
            this.f60451c.setStatus(5);
            this.f60451c.setReportStatus(5);
            this.f60451c.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
            this.f60449a.a(this.f60451c);
            b bVar2 = this.f60454f;
            if (bVar2 != null) {
                bVar2.b(this.f60451c);
            }
            com.transsnet.downloader.proxy.a aVar2 = this.f60450b;
            String resourceId = this.f60451c.getResourceId();
            if (resourceId == null) {
                resourceId = this.f60451c.getUrl();
            }
            aVar2.i(resourceId);
        }
    }

    @Override // com.transsnet.downloader.core.thread.a
    public synchronized void f(c runnable, int i11, DownloadRange curRange) {
        try {
            Intrinsics.g(runnable, "runnable");
            Intrinsics.g(curRange, "curRange");
            long jS = s();
            curRange.setDownloading(false);
            uo.b.a aVar = uo.b.f78622a;
            aVar.r(DownloadBaseRunnable.TAG, "======onRangeSuccess, thread = " + Thread.currentThread().getName() + ",rangeId = " + curRange.getRangeId() + ",progress = " + jS + ", resourceId=" + this.f60451c.getResourceId() + ",HeaderSize= " + this.f60451c.getDownloadHeaderSize(), true);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long size = this.f60451c.getSize();
            if (jS > (size != null ? size.longValue() : 1L)) {
                e();
                return;
            }
            this.f60451c.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
            this.f60449a.a(this.f60451c);
            this.f60455g = jCurrentTimeMillis;
            int iDecrementAndGet = this.f60458j.get() > 0 ? this.f60458j.decrementAndGet() : 0;
            this.f60453e.remove(runnable);
            if (jS < this.f60451c.getDownloadHeaderSize() && iDecrementAndGet > 0) {
                aVar.n(DownloadBaseRunnable.TAG, new String[]{"=======onRangeSuccess header not success, wait, downloadProgress = " + jS}, true);
                return;
            }
            if (Math.abs(jS - this.f60451c.getDownloadHeaderSize()) < PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                aVar.c(DownloadBaseRunnable.TAG, "onRangeSuccess,  文件头下载完成，执行多线程", true);
            }
            int iB = iDecrementAndGet < this.f60452d.b() ? this.f60452d.b() - iDecrementAndGet : 0;
            aVar.c(DownloadBaseRunnable.TAG, "allSize= " + this.f60452d.b() + ",curThreadSize = " + iDecrementAndGet + ",resourceId=" + this.f60451c.getResourceId() + "," + this.f60453e.size() + ",threadSize = " + iB, true);
            if (iB > 1 && !this.f60451c.isDownloadingPlay()) {
                y(iB);
            } else if (this.f60451c.isDownloadingPlay() && iDecrementAndGet > 2) {
                aVar.c(DownloadBaseRunnable.TAG, "resourceId=" + this.f60451c.getResourceId() + " 当前边下边播 还是多线程，移除该线程，等待最后一个单线程下载", true);
            } else if (this.f60451c.isDownloadingPlay()) {
                aVar.c(DownloadBaseRunnable.TAG, "resourceId=" + this.f60451c.getResourceId() + " 当前边下边播 ,单线程下载，不去切分片---", true);
                z(i11);
            } else {
                w(i11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void r(List<DownloadRange> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        if (arrayList.size() > 1) {
            j.z(arrayList, new Comparator() { // from class: com.transsnet.downloader.core.DownloadTaskImpl$checkLastRange$lambda$16$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return kotlin.comparisons.b.d(Long.valueOf(((DownloadRange) t11).getStart()), Long.valueOf(((DownloadRange) t12).getStart()));
                }
            });
        }
        list.clear();
        list.addAll(arrayList);
        if (!list.isEmpty()) {
            DownloadRange downloadRange = (DownloadRange) CollectionsKt___CollectionsKt.q0(list);
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, this.f60460l, "----checkLastRange, lastEnd =  " + downloadRange.getEnd() + "， end = " + this.f60451c.getSize(), false, 4, null);
            long end = downloadRange.getEnd();
            Long size = this.f60451c.getSize();
            if (end < (size != null ? size.longValue() : 1L) - 1) {
                uo.b.a.f(aVar, this.f60460l, "----checkLastRange, lost, add new range", false, 4, null);
                long end2 = downloadRange.getEnd() + 1;
                Long size2 = this.f60451c.getSize();
                long jLongValue = (size2 != null ? size2.longValue() : 1L) - 1;
                DownloadRange downloadRange2 = new DownloadRange();
                downloadRange2.setThreadId(downloadRange.getThreadId());
                downloadRange2.setRangeId(p.a(end2 + jLongValue));
                downloadRange2.setResourceId(downloadRange.getResourceId());
                downloadRange2.setStart(end2);
                downloadRange2.setEnd(jLongValue);
                downloadRange2.setProgress(0L);
                list.add(downloadRange2);
            }
        }
    }

    public final long s() {
        b bVar;
        ArrayList<DownloadRange> arrayList = new ArrayList();
        if (!this.f60451c.getDownloadRanges().isEmpty()) {
            arrayList.addAll(this.f60451c.getDownloadRanges());
        }
        AtomicLong atomicLong = new AtomicLong(0L);
        for (DownloadRange downloadRange : arrayList) {
            if (!downloadRange.getReDownload() && downloadRange.getProgress() > 0) {
                atomicLong.getAndAdd(downloadRange.getProgress());
            }
        }
        long j11 = atomicLong.get();
        synchronized (this) {
            try {
                this.f60451c.setProgress(j11);
                if (this.f60451c.isPreDownload() && j11 >= 5242880 && (bVar = this.f60454f) != null) {
                    bVar.H(this.f60451c);
                }
                uo.b.a.f(uo.b.f78622a, "DownloadThread", "------------total size =" + this.f60451c.getSize() + " progress " + j11 + ", isPreDownload = " + this.f60451c.isPreDownload(), false, 4, null);
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j11;
    }

    @Override // com.transsnet.downloader.core.task.a
    public void start() {
        if (!f.f49475a.e()) {
            this.f60449a.b(this.f60451c, new DownloadException(9, DownloadException.EXCEPTION_MESSAGE_NO_NET));
        } else if (this.f60451c.getDownloadRanges().isEmpty()) {
            kotlinx.coroutines.j.d(this.f60459k, null, null, new C20251(null), 3, null);
        } else {
            kotlinx.coroutines.j.d(this.f60459k, null, null, new AnonymousClass2(null), 3, null);
        }
    }

    public final List<DownloadRange> t(int i11, List<DownloadRange> list) {
        long j11;
        boolean z11;
        boolean z12;
        long j12;
        DownloadRange downloadRange;
        ArrayList arrayList;
        long j13;
        long j14;
        long j15;
        long jLongValue;
        DownloadTaskImpl downloadTaskImpl = this;
        int i12 = i11;
        ArrayList arrayList2 = new ArrayList();
        ArrayList<DownloadRange> arrayList3 = new ArrayList();
        arrayList3.addAll(downloadTaskImpl.f60451c.getDownloadRanges());
        for (DownloadRange downloadRange2 : arrayList3) {
            if (!downloadRange2.isRangeDownloadSuccess() && !downloadRange2.isDownloading()) {
                if (list == null || !list.contains(downloadRange2)) {
                    if (downloadRange2.getEnd() > downloadTaskImpl.f60451c.getDownloadHeaderSize() && downloadRange2.getRangeSize() - downloadRange2.getProgress() > downloadTaskImpl.f60452d.c()) {
                        uo.b.a aVar = uo.b.f78622a;
                        aVar.c(DownloadBaseRunnable.TAG, "分片不够,切多个,count = " + i12 + "， rangeId = " + downloadRange2.getRangeId() + ",start =  " + downloadRange2.getStart() + ",end = " + downloadRange2.getEnd() + "，progress = " + downloadRange2.getProgress(), true);
                        long progress = downloadRange2.getProgress();
                        long start = downloadRange2.getStart() + progress;
                        ArrayList arrayList4 = new ArrayList();
                        String str = ", start = ";
                        if (progress > 0) {
                            long start2 = downloadRange2.getStart();
                            long j16 = start - 1;
                            DownloadRange downloadRange3 = new DownloadRange();
                            downloadRange3.setThreadId(downloadRange2.getThreadId());
                            downloadRange3.setRangeId(p.a(start2 + j16));
                            downloadRange3.setResourceId(downloadRange2.getResourceId());
                            downloadRange3.setStart(start2);
                            downloadRange3.setEnd(j16);
                            j11 = progress;
                            downloadRange3.setProgress(j11);
                            aVar.n(DownloadBaseRunnable.TAG, new String[]{"当前分片已有下载内容 downloadedSize = " + j11 + " 直接将已下载的生成一个独立分片，rangeId = " + downloadRange3.getRangeId() + ", start = " + downloadRange3.getStart() + ",end = " + downloadRange3.getEnd() + ",success = " + downloadRange3.isRangeDownloadSuccess()}, true);
                            arrayList4.add(downloadRange3);
                        } else {
                            j11 = progress;
                        }
                        int i13 = i11;
                        long rangeSize = (downloadRange2.getRangeSize() - j11) / ((long) i13);
                        DownloadTaskImpl downloadTaskImpl2 = this;
                        if (rangeSize > downloadTaskImpl2.f60452d.c()) {
                            rangeSize = downloadTaskImpl2.f60452d.c();
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        long end = downloadRange2.getEnd();
                        int i14 = 0;
                        long j17 = 0;
                        while (i14 < i13) {
                            long j18 = start + (((long) i14) * rangeSize);
                            long j19 = (j18 + rangeSize) - 1;
                            if (z11) {
                                j12 = rangeSize;
                                if (i14 == i13 - 1 && j19 < end) {
                                    j19 = end;
                                }
                            } else {
                                j12 = rangeSize;
                            }
                            Long size = downloadTaskImpl2.f60451c.getSize();
                            if (j19 >= (size != null ? size.longValue() : 1L)) {
                                Long size2 = downloadTaskImpl2.f60451c.getSize();
                                if (size2 != null) {
                                    jLongValue = size2.longValue();
                                    j15 = 1;
                                } else {
                                    j15 = 1;
                                    jLongValue = 1;
                                }
                                j19 = jLongValue - j15;
                            }
                            if (!z11) {
                                downloadRange = downloadRange2;
                                long j21 = end;
                                arrayList = arrayList2;
                                j13 = start;
                                j14 = j21;
                                DownloadRange downloadRange4 = new DownloadRange();
                                downloadRange4.setThreadId(downloadRange.getThreadId());
                                downloadRange4.setRangeId(p.a(j18 + j19));
                                downloadRange4.setResourceId(downloadRange.getResourceId());
                                downloadRange4.setStart(j18);
                                downloadRange4.setEnd(j19);
                                downloadRange4.setProgress(0L);
                                uo.b.f78622a.c(DownloadBaseRunnable.TAG, "分片不够, 没瓜分完 新分片------rangeId = " + downloadRange4.getRangeId() + ",start = " + j18 + ",end = " + j19, true);
                                arrayList.add(downloadRange4);
                                arrayList4.add(downloadRange4);
                            } else if (i14 == 0) {
                                uo.b.a aVar2 = uo.b.f78622a;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("分片不够, 瓜分完了 第一个使用原始分片，更改 start = ");
                                long j22 = start;
                                sb2.append(j22);
                                j14 = end;
                                sb2.append(" end1 = ");
                                sb2.append(j19);
                                aVar2.c(DownloadBaseRunnable.TAG, sb2.toString(), true);
                                downloadRange = downloadRange2;
                                downloadRange.setStart(j22);
                                downloadRange.setEnd(j19);
                                downloadRange.setProgress(0L);
                                downloadRange.setDownloading(false);
                                arrayList = arrayList2;
                                arrayList.add(downloadRange);
                                j13 = j22;
                            } else {
                                downloadRange = downloadRange2;
                                long j23 = end;
                                arrayList = arrayList2;
                                j13 = start;
                                j14 = j23;
                                DownloadRange downloadRange5 = new DownloadRange();
                                downloadRange5.setThreadId(downloadRange.getThreadId());
                                downloadRange5.setRangeId(p.a(j18 + j19));
                                downloadRange5.setResourceId(downloadRange.getResourceId());
                                downloadRange5.setStart(j18);
                                downloadRange5.setEnd(j19);
                                downloadRange5.setProgress(0L);
                                uo.b.f78622a.c(DownloadBaseRunnable.TAG, "分片不够, 瓜分完了 新分片------rangeId = " + downloadRange5.getRangeId() + ",start = " + j18 + ",end = " + j19, true);
                                arrayList.add(downloadRange5);
                                arrayList4.add(downloadRange5);
                            }
                            i14++;
                            downloadTaskImpl2 = this;
                            i13 = i11;
                            z11 = z11;
                            j17 = j19;
                            str = str;
                            long j24 = j13;
                            downloadRange2 = downloadRange;
                            arrayList2 = arrayList;
                            end = j14;
                            start = j24;
                            rangeSize = j12;
                        }
                        String str2 = str;
                        ArrayList arrayList5 = arrayList2;
                        DownloadRange downloadRange6 = downloadRange2;
                        if (z11) {
                            z12 = true;
                        } else {
                            downloadRange6.setStart(j17 + 1);
                            downloadRange6.setDownloading(false);
                            downloadRange6.setProgress(0L);
                            z12 = true;
                            uo.b.f78622a.c(DownloadBaseRunnable.TAG, "原始分片 =  id = " + downloadRange6.getRangeId() + str2 + downloadRange6.getStart(), true);
                        }
                        if (arrayList4.isEmpty() ^ z12) {
                            this.f60451c.getDownloadRanges().addAll(arrayList4);
                        }
                        C(this.f60451c.getDownloadRanges());
                        return arrayList5;
                    }
                    ArrayList arrayList6 = arrayList2;
                    DownloadTaskImpl downloadTaskImpl3 = downloadTaskImpl;
                    if (arrayList6.size() >= i11) {
                        return arrayList6;
                    }
                    uo.b.f78622a.c(DownloadBaseRunnable.TAG, "---多线程, 分片小于range大小， 头文件 = " + (downloadRange2.getEnd() <= downloadTaskImpl3.f60451c.getDownloadHeaderSize()), true);
                    arrayList6.add(downloadRange2);
                    downloadTaskImpl = downloadTaskImpl3;
                    arrayList2 = arrayList6;
                    i12 = i11;
                }
            }
        }
        return arrayList2;
    }

    public final void x() {
        DownloadRange next;
        DownloadRange downloadRange;
        long currentOffset = 0;
        if (this.f60451c.getCurrentOffset() > 0) {
            long currentOffset2 = this.f60451c.getCurrentOffset();
            Long size = this.f60451c.getSize();
            if (currentOffset2 < (size != null ? size.longValue() : 0L) - 1) {
                currentOffset = this.f60451c.getCurrentOffset();
            }
        }
        uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"开始下载--边下边播，单线程 subjectId=" + this.f60451c.getSubjectId() + ",resourceId=" + this.f60451c.getResourceId() + ",name=" + this.f60451c.getName() + ",---readProgress = " + this.f60451c.getReadProgress() + ", currentOffset = " + currentOffset + ", ranges size = " + this.f60451c.getDownloadRanges().size()}, true);
        Iterator<DownloadRange> it = this.f60451c.getDownloadRanges().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            uo.b.a aVar = uo.b.f78622a;
            String str = this.f60460l;
            int rangeId = next.getRangeId();
            long start = next.getStart();
            long end = next.getEnd();
            long progress = next.getProgress();
            StringBuilder sb2 = new StringBuilder();
            Iterator<DownloadRange> it2 = it;
            sb2.append("---rangeId = ");
            sb2.append(rangeId);
            sb2.append(", range.start = ");
            sb2.append(start);
            sb2.append(",range.end = ");
            sb2.append(end);
            sb2.append(", range.progress = ");
            sb2.append(progress);
            uo.b.a.f(aVar, str, sb2.toString(), false, 4, null);
            next.setDownloading(false);
            long start2 = next.getStart();
            if (currentOffset <= next.getEnd() && start2 <= currentOffset) {
                uo.b.a.f(aVar, this.f60460l, "0-- get range , rangeId =  " + next.getRangeId(), false, 4, null);
                break;
            }
            it = it2;
        }
        if (next != null && !next.isRangeDownloadSuccess()) {
            downloadRange = next;
            break;
        }
        uo.b.a.f(uo.b.f78622a, this.f60460l, "1--  播放进度的分片已下载完成，则取一个问下载的分片执行下载", false, 4, null);
        Iterator<DownloadRange> it3 = this.f60451c.getDownloadRanges().iterator();
        while (true) {
            if (!it3.hasNext()) {
                downloadRange = next;
                break;
            }
            DownloadRange next2 = it3.next();
            if (!next2.isRangeDownloadSuccess()) {
                uo.b.a.f(uo.b.f78622a, this.f60460l, "2--  取一个问下载的分片执行下载, get range", false, 4, null);
                downloadRange = next2;
                break;
            }
        }
        if (downloadRange == null || downloadRange.isRangeDownloadSuccess()) {
            return;
        }
        uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"----------执行未下载的线程"}, true);
        DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange, this.f60450b, 0, this.f60449a, this.f60452d, this.f60451c, this);
        downloadRange.setDownloading(true);
        DownloadExecutor.f60487a.b().c(downloadRunnable);
        this.f60453e.add(downloadRunnable);
        this.f60458j.getAndIncrement();
    }

    public final void z(int i11) {
        ArrayList<DownloadRange> arrayList = new ArrayList();
        arrayList.addAll(this.f60451c.getDownloadRanges());
        for (DownloadRange downloadRange : arrayList) {
            if (!downloadRange.isDownloading() && !downloadRange.isRangeDownloadSuccess()) {
                downloadRange.setDownloading(true);
                DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange, this.f60450b, i11, this.f60449a, this.f60452d, this.f60451c, this);
                uo.b.f78622a.c(DownloadBaseRunnable.TAG, "singleThread------onRangeSuccess , start new range~ rangeId = " + downloadRange.getRangeId() + ", range.start = " + downloadRange.getStart() + ",range.end = " + downloadRange.getEnd() + ",progress = " + downloadRange.getProgress(), true);
                this.f60453e.add(downloadRunnable);
                DownloadExecutor.f60487a.b().c(downloadRunnable);
                return;
            }
        }
    }
}
