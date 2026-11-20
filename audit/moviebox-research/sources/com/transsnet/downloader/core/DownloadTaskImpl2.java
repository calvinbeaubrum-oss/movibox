package com.transsnet.downloader.core;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsnet.downloader.config.Config;
import com.transsnet.downloader.core.task.DownloadFileInfoTask;
import com.transsnet.downloader.core.task.DownloadTaskUtil;
import com.transsnet.downloader.core.task.b;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.core.thread.DownloadExecutor;
import com.transsnet.downloader.core.thread.DownloadRunnable;
import com.transsnet.downloader.core.thread.c;
import com.transsnet.downloader.report.DownloadReporter;
import com.transsnet.downloader.util.DownloadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.j;
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
public final class DownloadTaskImpl2 implements com.transsnet.downloader.core.task.a, com.transsnet.downloader.core.thread.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f60466n = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.transsnet.downloader.core.a f60467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.transsnet.downloader.proxy.a f60468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadBean f60469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Config f60470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f60471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f60472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicInteger f60473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<c> f60474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AtomicLong f60475i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k0 f60476j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f60477k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f60478l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DownloadTaskImpl2$downloadProxyRangeCallback$1 f60479m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.core.DownloadTaskImpl2$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.core.DownloadTaskImpl2$start$1", f = "DownloadTaskImpl2.kt", l = {106, 113, 132}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadTaskImpl2.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:34:0x00c6  */
        /* JADX WARN: Code duplicated, block: B:36:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:38:0x0111  */
        /* JADX WARN: Code duplicated, block: B:40:0x014a  */
        /* JADX WARN: Code duplicated, block: B:43:0x0167  */
        /* JADX WARN: Code duplicated, block: B:46:0x017d A[RETURN] */
        /* JADX WARN: Instruction removed from duplicated block: B:34:0x00c6, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:38:0x0111, please report this as an issue */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            DownloadTaskImpl2 downloadTaskImpl2;
            List<DownloadRange> arrayList;
            b bVar;
            DownloadTaskImpl2 downloadTaskImpl3;
            b bVar2;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                String resourceId = DownloadTaskImpl2.this.f60469c.getResourceId();
                if (resourceId != null) {
                    downloadTaskImpl2 = DownloadTaskImpl2.this;
                    h hVarQ = downloadTaskImpl2.q();
                    this.L$0 = downloadTaskImpl2;
                    this.label = 1;
                    obj = hVarQ.a(resourceId, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else if (!DownloadTaskImpl2.this.f60469c.getDownloadRanges().isEmpty()) {
                    uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"DownloadTask2 has task, name = " + DownloadTaskImpl2.this.f60469c.getName()}, true);
                    bVar2 = DownloadTaskImpl2.this.f60471e;
                    if (bVar2 != null) {
                        bVar2.c(DownloadTaskImpl2.this.f60469c, false);
                    }
                    DownloadTaskImpl2.this.r();
                    DownloadTaskImpl2.this.f60467a.a(DownloadTaskImpl2.this.f60469c);
                } else {
                    uo.b.f78622a.c(DownloadBaseRunnable.TAG, "DownloadTask2 stat new task, name = " + DownloadTaskImpl2.this.f60469c.getName(), true);
                    DownloadTaskUtil.f60483a.b(DownloadTaskImpl2.this.f60469c);
                    if (DownloadTaskImpl2.this.f60469c.getDownloadHeaderSize() <= 0) {
                        DownloadTaskImpl2.this.f60469c.setDownloadHeaderSize(DownloadUtil.f61136a.f(DownloadTaskImpl2.this.f60469c));
                    }
                    bVar = DownloadTaskImpl2.this.f60471e;
                    if (bVar != null) {
                        bVar.c(DownloadTaskImpl2.this.f60469c, true);
                    }
                    downloadTaskImpl3 = DownloadTaskImpl2.this;
                    this.L$0 = null;
                    this.label = 3;
                    if (downloadTaskImpl3.v(this) == objE) {
                        return objE;
                    }
                }
                return Unit.f68710a;
            }
            if (i11 == 1) {
                downloadTaskImpl2 = (DownloadTaskImpl2) this.L$0;
                ResultKt.b(obj);
            } else if (i11 == 2) {
                downloadTaskImpl2 = (DownloadTaskImpl2) this.L$0;
                ResultKt.b(obj);
                arrayList = (List) obj;
                Boxing.a(downloadTaskImpl2.f60469c.getDownloadRanges().addAll(arrayList));
                if (!DownloadTaskImpl2.this.f60469c.getDownloadRanges().isEmpty()) {
                    uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"DownloadTask2 has task, name = " + DownloadTaskImpl2.this.f60469c.getName()}, true);
                    bVar2 = DownloadTaskImpl2.this.f60471e;
                    if (bVar2 != null) {
                        bVar2.c(DownloadTaskImpl2.this.f60469c, false);
                    }
                    DownloadTaskImpl2.this.r();
                    DownloadTaskImpl2.this.f60467a.a(DownloadTaskImpl2.this.f60469c);
                } else {
                    uo.b.f78622a.c(DownloadBaseRunnable.TAG, "DownloadTask2 stat new task, name = " + DownloadTaskImpl2.this.f60469c.getName(), true);
                    DownloadTaskUtil.f60483a.b(DownloadTaskImpl2.this.f60469c);
                    if (DownloadTaskImpl2.this.f60469c.getDownloadHeaderSize() <= 0) {
                        DownloadTaskImpl2.this.f60469c.setDownloadHeaderSize(DownloadUtil.f61136a.f(DownloadTaskImpl2.this.f60469c));
                    }
                    bVar = DownloadTaskImpl2.this.f60471e;
                    if (bVar != null) {
                        bVar.c(DownloadTaskImpl2.this.f60469c, true);
                    }
                    downloadTaskImpl3 = DownloadTaskImpl2.this;
                    this.L$0 = null;
                    this.label = 3;
                    if (downloadTaskImpl3.v(this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
            List list = (List) obj;
            if (list != null) {
                arrayList = new ArrayList<>();
                arrayList.addAll(list);
                Long size = downloadTaskImpl2.f60469c.getSize();
                long jLongValue = ((size != null ? size.longValue() : 0L) / downloadTaskImpl2.f60472f) + 1;
                int size2 = arrayList.size();
                if ((!arrayList.isEmpty()) && jLongValue > size2) {
                    DownloadTaskUtil downloadTaskUtil = DownloadTaskUtil.f60483a;
                    long j11 = downloadTaskImpl2.f60472f;
                    DownloadBean downloadBean = downloadTaskImpl2.f60469c;
                    this.L$0 = downloadTaskImpl2;
                    this.label = 2;
                    obj = downloadTaskUtil.a(j11, downloadBean, arrayList, this);
                    if (obj == objE) {
                        return objE;
                    }
                    arrayList = (List) obj;
                }
                Boxing.a(downloadTaskImpl2.f60469c.getDownloadRanges().addAll(arrayList));
                if (!DownloadTaskImpl2.this.f60469c.getDownloadRanges().isEmpty()) {
                    uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"DownloadTask2 has task, name = " + DownloadTaskImpl2.this.f60469c.getName()}, true);
                    bVar2 = DownloadTaskImpl2.this.f60471e;
                    if (bVar2 != null) {
                        bVar2.c(DownloadTaskImpl2.this.f60469c, false);
                    }
                    DownloadTaskImpl2.this.r();
                    DownloadTaskImpl2.this.f60467a.a(DownloadTaskImpl2.this.f60469c);
                } else {
                    uo.b.f78622a.c(DownloadBaseRunnable.TAG, "DownloadTask2 stat new task, name = " + DownloadTaskImpl2.this.f60469c.getName(), true);
                    DownloadTaskUtil.f60483a.b(DownloadTaskImpl2.this.f60469c);
                    if (DownloadTaskImpl2.this.f60469c.getDownloadHeaderSize() <= 0) {
                        DownloadTaskImpl2.this.f60469c.setDownloadHeaderSize(DownloadUtil.f61136a.f(DownloadTaskImpl2.this.f60469c));
                    }
                    bVar = DownloadTaskImpl2.this.f60471e;
                    if (bVar != null) {
                        bVar.c(DownloadTaskImpl2.this.f60469c, true);
                    }
                    downloadTaskImpl3 = DownloadTaskImpl2.this;
                    this.L$0 = null;
                    this.label = 3;
                    if (downloadTaskImpl3.v(this) == objE) {
                        return objE;
                    }
                }
            } else if (!DownloadTaskImpl2.this.f60469c.getDownloadRanges().isEmpty()) {
                uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"DownloadTask2 has task, name = " + DownloadTaskImpl2.this.f60469c.getName()}, true);
                bVar2 = DownloadTaskImpl2.this.f60471e;
                if (bVar2 != null) {
                    bVar2.c(DownloadTaskImpl2.this.f60469c, false);
                }
                DownloadTaskImpl2.this.r();
                DownloadTaskImpl2.this.f60467a.a(DownloadTaskImpl2.this.f60469c);
            } else {
                uo.b.f78622a.c(DownloadBaseRunnable.TAG, "DownloadTask2 stat new task, name = " + DownloadTaskImpl2.this.f60469c.getName(), true);
                DownloadTaskUtil.f60483a.b(DownloadTaskImpl2.this.f60469c);
                if (DownloadTaskImpl2.this.f60469c.getDownloadHeaderSize() <= 0) {
                    DownloadTaskImpl2.this.f60469c.setDownloadHeaderSize(DownloadUtil.f61136a.f(DownloadTaskImpl2.this.f60469c));
                }
                bVar = DownloadTaskImpl2.this.f60471e;
                if (bVar != null) {
                    bVar.c(DownloadTaskImpl2.this.f60469c, true);
                }
                downloadTaskImpl3 = DownloadTaskImpl2.this;
                this.L$0 = null;
                this.label = 3;
                if (downloadTaskImpl3.v(this) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.core.DownloadTaskImpl2$start$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.core.DownloadTaskImpl2$start$2", f = "DownloadTaskImpl2.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadTaskImpl2.this.new AnonymousClass2(continuation);
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
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"DownloadTask2 has task, name = " + DownloadTaskImpl2.this.f60469c.getName()}, true);
            b bVar = DownloadTaskImpl2.this.f60471e;
            if (bVar != null) {
                bVar.c(DownloadTaskImpl2.this.f60469c, false);
            }
            DownloadTaskImpl2.this.r();
            DownloadTaskImpl2.this.f60467a.a(DownloadTaskImpl2.this.f60469c);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.transsnet.downloader.core.DownloadTaskImpl2$downloadProxyRangeCallback$1, com.transsnet.downloader.proxy.b] */
    public DownloadTaskImpl2(com.transsnet.downloader.core.a downloadResponse, com.transsnet.downloader.proxy.a proxyHelper, DownloadBean downloadBean, Config config, b bVar) {
        Intrinsics.g(downloadResponse, "downloadResponse");
        Intrinsics.g(proxyHelper, "proxyHelper");
        Intrinsics.g(downloadBean, "downloadBean");
        Intrinsics.g(config, "config");
        this.f60467a = downloadResponse;
        this.f60468b = proxyHelper;
        this.f60469c = downloadBean;
        this.f60470d = config;
        this.f60471e = bVar;
        this.f60472f = config.c();
        this.f60473g = new AtomicInteger(0);
        this.f60474h = new ArrayList();
        this.f60475i = new AtomicLong(System.currentTimeMillis());
        this.f60476j = l0.a(w0.b());
        this.f60477k = LazyKt__LazyJVMKt.b(new Function0<h>() { // from class: com.transsnet.downloader.core.DownloadTaskImpl2$rangeDao$2
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).F0();
            }
        });
        this.f60478l = new AtomicInteger(0);
        ?? r11 = new com.transsnet.downloader.proxy.b() { // from class: com.transsnet.downloader.core.DownloadTaskImpl2$downloadProxyRangeCallback$1
            @Override // com.transsnet.downloader.proxy.b
            public void a(String str, final int i11, final DownloadRange downloadRange, final DownloadRange range) {
                Intrinsics.g(range, "range");
                if (Intrinsics.b(str, this.f60480a.f60469c.getResourceId())) {
                    if (range.isRangeDownloadSuccess()) {
                        uo.b.f78622a.r(DownloadBaseRunnable.TAG, "download&play, range download success， do nothing", true);
                    } else {
                        if (this.f60480a.f60474h.isEmpty()) {
                            uo.b.a.s(uo.b.f78622a, "DownloadThread", "download&play, thread null", false, 4, null);
                            return;
                        }
                        final c cVar = (c) this.f60480a.f60474h.get(this.f60480a.f60474h.size() - 1);
                        final DownloadTaskImpl2 downloadTaskImpl2 = this.f60480a;
                        cVar.pause(new Function0<Unit>() { // from class: com.transsnet.downloader.core.DownloadTaskImpl2$downloadProxyRangeCallback$1$onStartNewRangeThread$1
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
                                downloadTaskImpl2.f60474h.remove(cVar);
                                uo.b.a aVar = uo.b.f78622a;
                                uo.b.a.s(aVar, "DownloadThread", "beak success, start new thread", false, 4, null);
                                long progress = downloadTaskImpl2.f60469c.getProgress();
                                DownloadRange downloadRange2 = downloadRange;
                                Integer numValueOf = downloadRange2 != null ? Integer.valueOf(downloadRange2.getRangeId()) : null;
                                DownloadRange downloadRange3 = downloadRange;
                                Long lValueOf = downloadRange3 != null ? Long.valueOf(downloadRange3.getStart()) : null;
                                DownloadRange downloadRange4 = downloadRange;
                                Long lValueOf2 = downloadRange4 != null ? Long.valueOf(downloadRange4.getEnd()) : null;
                                DownloadRange downloadRange5 = downloadRange;
                                Long lValueOf3 = downloadRange5 != null ? Long.valueOf(downloadRange5.getProgress()) : null;
                                aVar.r(DownloadBaseRunnable.TAG, StringsKt__IndentKt.f("download&play start new thread, totalProgress = " + progress + "\n                        oldRangeId:" + numValueOf + ", start:" + lValueOf + ", end:" + lValueOf2 + ", progress:" + lValueOf3 + " \n                        newRangeId:" + range.getRangeId() + ", start:" + range.getStart() + ", end:" + range.getEnd() + ", progress:" + range.getProgress() + " \n                    "), true);
                                downloadTaskImpl2.u(range, i11);
                            }
                        });
                    }
                }
            }
        };
        this.f60479m = r11;
        String resourceId = downloadBean.getResourceId();
        proxyHelper.a(resourceId == null ? downloadBean.getUrl() : resourceId, r11);
    }

    @Override // com.transsnet.downloader.core.thread.a
    public void a(c runnable, int i11, DownloadRange curRange) {
        Intrinsics.g(runnable, "runnable");
        Intrinsics.g(curRange, "curRange");
        int iDecrementAndGet = this.f60473g.get() > 0 ? this.f60473g.decrementAndGet() : 0;
        curRange.setDownloading(false);
        boolean zRemove = this.f60474h.remove(runnable);
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, DownloadBaseRunnable.TAG, "reDownload，result =" + zRemove, false, 4, null);
        if (iDecrementAndGet <= 0) {
            aVar.n(DownloadBaseRunnable.TAG, new String[]{"重新下载所有线程已经暂停，开始执行新下载"}, true);
            j.d(this.f60476j, null, null, new DownloadTaskImpl2$reDownload$1(this, null), 3, null);
        }
    }

    @Override // com.transsnet.downloader.core.task.a
    public DownloadBean b() {
        return this.f60469c;
    }

    @Override // com.transsnet.downloader.core.thread.a
    public void c(c cVar, int i11, DownloadRange downloadRange) {
        com.transsnet.downloader.core.thread.a.C0616a.a(this, cVar, i11, downloadRange);
    }

    @Override // com.transsnet.downloader.core.thread.a
    public synchronized void d() {
        int status = this.f60469c.getStatus();
        if (status == 1 || status == 2 || this.f60478l.get() != status) {
            this.f60478l.set(status);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f60475i.get() > 1000) {
                long jC = DownloadTaskUtil.f60483a.c(this.f60469c, this, this.f60471e);
                Long size = this.f60469c.getSize();
                if (jC > (size != null ? size.longValue() : 1L)) {
                    e();
                } else {
                    this.f60469c.setUpdateTimeStamp(Long.valueOf(jCurrentTimeMillis));
                    this.f60467a.a(this.f60469c);
                    this.f60475i.set(jCurrentTimeMillis);
                }
            }
        }
    }

    @Override // com.transsnet.downloader.core.thread.a
    public synchronized void e() {
        DownloadTaskUtil.f60483a.c(this.f60469c, this, this.f60471e);
        if (this.f60469c.getStatus() == 5) {
            uo.b.a.f(uo.b.f78622a, DownloadBaseRunnable.TAG, "--------onDownloadSuccess---相同状态，无需重复回调-", false, 4, null);
            return;
        }
        long progress = this.f60469c.getProgress();
        Long size = this.f60469c.getSize();
        if (progress >= (size != null ? size.longValue() : 1L) || p()) {
            DownloadUtil downloadUtil = DownloadUtil.f61136a;
            if (downloadUtil.c(this.f60469c)) {
                DownloadReporter.f61112c.a().g(this.f60469c, null);
                uo.b.a aVar = uo.b.f78622a;
                aVar.c(DownloadBaseRunnable.TAG, "onDownloadSuccess, 资源有问题，需要重新下载，  progress = " + this.f60469c.getProgress(), true);
                this.f60469c.setStatus(0);
                downloadUtil.z(this.f60469c);
                uo.b.a.f(aVar, "ReDownload", "resetProgress， progress = " + this.f60469c.getProgress(), false, 4, null);
                b bVar = this.f60471e;
                if (bVar != null) {
                    bVar.g(this.f60469c);
                }
                return;
            }
            uo.b.f78622a.c(DownloadBaseRunnable.TAG, "------------------------------onDownloadSuccess subjectId=" + this.f60469c.getSubjectId() + ",resourceId=" + this.f60469c.getResourceId() + ", size:" + this.f60469c.getSize() + ", progress:" + this.f60469c.getProgress() + "------------------------------", true);
            this.f60469c.setStatus(5);
            this.f60469c.setReportStatus(5);
            this.f60469c.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
            this.f60467a.a(this.f60469c);
            b bVar2 = this.f60471e;
            if (bVar2 != null) {
                bVar2.b(this.f60469c);
            }
            com.transsnet.downloader.proxy.a aVar2 = this.f60468b;
            String resourceId = this.f60469c.getResourceId();
            if (resourceId == null) {
                resourceId = this.f60469c.getUrl();
            }
            aVar2.i(resourceId);
        }
    }

    @Override // com.transsnet.downloader.core.thread.a
    public synchronized void f(c runnable, int i11, DownloadRange curRange) {
        try {
            Intrinsics.g(runnable, "runnable");
            Intrinsics.g(curRange, "curRange");
            long jC = DownloadTaskUtil.f60483a.c(this.f60469c, this, this.f60471e);
            curRange.setDownloading(false);
            uo.b.a aVar = uo.b.f78622a;
            aVar.r(DownloadBaseRunnable.TAG, "======onRangeSuccess, name:" + this.f60469c.getTitleName() + ",thread = " + Thread.currentThread().getName() + ",rangeId = " + curRange.getRangeId() + ",progress = " + jC + ", resourceId=" + this.f60469c.getResourceId() + ",status:" + this.f60469c.getStatus() + "}", true);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long size = this.f60469c.getSize();
            if (jC > (size != null ? size.longValue() : 1L)) {
                e();
                return;
            }
            this.f60469c.setUpdateTimeStamp(Long.valueOf(jCurrentTimeMillis));
            if (jCurrentTimeMillis - this.f60475i.get() > 1000) {
                this.f60467a.a(this.f60469c);
                this.f60475i.set(jCurrentTimeMillis);
            }
            int iDecrementAndGet = this.f60473g.get() > 0 ? this.f60473g.decrementAndGet() : 0;
            this.f60474h.remove(runnable);
            if (jC < this.f60469c.getDownloadHeaderSize() && iDecrementAndGet > 0) {
                aVar.n(DownloadBaseRunnable.TAG, new String[]{"=======onRangeSuccess header not success, wait, downloadProgress = " + jC}, true);
                return;
            }
            int iB = iDecrementAndGet < this.f60470d.b() ? this.f60470d.b() - iDecrementAndGet : 0;
            aVar.c(DownloadBaseRunnable.TAG, "allSize:" + this.f60470d.b() + ",curThreadSize: " + iDecrementAndGet + ", threadCount：" + this.f60474h.size() + ",newThreadCount = " + iB, true);
            if (iB > 1 && !this.f60469c.isDownloadingPlay()) {
                t(iB);
            } else if (!this.f60469c.isDownloadingPlay() || iDecrementAndGet < 2) {
                s(i11);
            } else {
                aVar.c(DownloadBaseRunnable.TAG, "resourceId=" + this.f60469c.getResourceId() + " 当前边下边播 还是多线程，移除该线程，等待最后还有2个线程下载", true);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized boolean p() {
        if (this.f60469c.getDownloadRanges().isEmpty()) {
            return false;
        }
        Iterator<T> it = this.f60469c.getDownloadRanges().iterator();
        while (it.hasNext()) {
            if (!((DownloadRange) it.next()).isRangeDownloadSuccess()) {
                return false;
            }
        }
        uo.b.f78622a.c(DownloadBaseRunnable.TAG, "checkAllThreadStatus success", true);
        return true;
    }

    public final h q() {
        return (h) this.f60477k.getValue();
    }

    public final void r() {
        int i11;
        DownloadTaskUtil.f60483a.b(this.f60469c);
        if (this.f60469c.getDownloadHeaderSize() <= 0) {
            DownloadBean downloadBean = this.f60469c;
            downloadBean.setDownloadHeaderSize(DownloadUtil.f61136a.f(downloadBean));
        }
        uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"已有任务 开始下载--多线程, isPreDownload:" + this.f60469c.isPreDownload()}, true);
        this.f60469c.setStatus(2);
        ArrayList<DownloadRange> arrayList = new ArrayList();
        int iB = this.f60469c.isDownloadingPlay() ? 2 : this.f60470d.b();
        Iterator<DownloadRange> it = this.f60469c.getDownloadRanges().iterator();
        while (true) {
            if (!it.hasNext()) {
                i11 = 1;
                break;
            }
            DownloadRange next = it.next();
            next.setDownloading(false);
            if (!next.isRangeDownloadSuccess()) {
                uo.b.a aVar = uo.b.f78622a;
                int rangeId = next.getRangeId();
                long start = next.getStart();
                long end = next.getEnd();
                long progress = next.getProgress();
                boolean zIsDownloadingPlay = this.f60469c.isDownloadingPlay();
                StringBuilder sb2 = new StringBuilder();
                Iterator<DownloadRange> it2 = it;
                sb2.append("添加下载分片,rangeId:");
                sb2.append(rangeId);
                sb2.append(", start:");
                sb2.append(start);
                sb2.append(", end:");
                sb2.append(end);
                sb2.append(", progress:");
                sb2.append(progress);
                sb2.append(", dp:");
                sb2.append(zIsDownloadingPlay);
                sb2.append(" ");
                i11 = 1;
                aVar.n(DownloadBaseRunnable.TAG, new String[]{sb2.toString()}, true);
                arrayList.add(next);
                if (arrayList.size() >= iB) {
                    break;
                } else {
                    it = it2;
                }
            }
        }
        int i12 = this.f60473g.get() - i11;
        this.f60473g.addAndGet(arrayList.size());
        for (DownloadRange downloadRange : arrayList) {
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"----多线程下载开始, rangeId:" + downloadRange.getRangeId() + ", curSize:" + i12 + "，status:" + this.f60469c.getStatus()}, true);
            i12++;
            u(downloadRange, i12);
        }
    }

    public final void s(int i11) {
        ArrayList arrayList;
        boolean z11;
        Object next;
        int i12 = i11;
        uo.b.f78622a.c(DownloadBaseRunnable.TAG, "2---handleNextRangeDownload,name:" + this.f60469c.getName() + ", RangesSize:" + this.f60469c.getDownloadRanges().size(), true);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.f60469c.getDownloadRanges());
        long currentOffset = 0;
        if (this.f60469c.getCurrentOffset() > 0) {
            long currentOffset2 = this.f60469c.getCurrentOffset();
            Long size = this.f60469c.getSize();
            if (currentOffset2 < (size != null ? size.longValue() : 0L)) {
                currentOffset = this.f60469c.getCurrentOffset();
            }
        }
        Iterator it = arrayList2.iterator();
        boolean z12 = false;
        while (true) {
            if (!it.hasNext()) {
                arrayList = arrayList2;
                z11 = false;
                break;
            }
            DownloadRange downloadRange = (DownloadRange) it.next();
            if (!downloadRange.isRangeDownloadSuccess()) {
                uo.b.a.f(uo.b.f78622a, DownloadBaseRunnable.TAG, "2---rangeId:" + downloadRange.getRangeId() + ", isDownloading:" + downloadRange.isDownloading() + ",currentOffset:" + currentOffset, false, 4, null);
            }
            if (!downloadRange.isRangeDownloadSuccess() && !downloadRange.isDownloading()) {
                if (downloadRange.getEnd() >= currentOffset) {
                    u(downloadRange, i12);
                    uo.b.a aVar = uo.b.f78622a;
                    int rangeId = downloadRange.getRangeId();
                    long start = downloadRange.getStart();
                    long end = downloadRange.getEnd();
                    long progress = downloadRange.getProgress();
                    StringBuilder sb2 = new StringBuilder();
                    arrayList = arrayList2;
                    sb2.append("2---执行下一个task~ rangeId:");
                    sb2.append(rangeId);
                    sb2.append(", start:");
                    sb2.append(start);
                    sb2.append(",range:");
                    sb2.append(end);
                    sb2.append(",progress:");
                    sb2.append(progress);
                    aVar.c(DownloadBaseRunnable.TAG, sb2.toString(), true);
                    this.f60473g.getAndIncrement();
                    z11 = true;
                    break;
                }
                z12 = true;
            } else {
                i12 = i11;
                arrayList2 = arrayList2;
            }
        }
        if (!z12 || z11) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            DownloadRange downloadRange2 = (DownloadRange) next;
            if (!downloadRange2.isRangeDownloadSuccess() && !downloadRange2.isDownloading()) {
                break;
            }
        }
        DownloadRange downloadRange3 = (DownloadRange) next;
        if (downloadRange3 != null) {
            uo.b.f78622a.c(DownloadBaseRunnable.TAG, "2-2---执行下一个task~ rangeId:" + downloadRange3.getRangeId() + ", start:" + downloadRange3.getStart() + ",range:" + downloadRange3.getEnd() + ",progress:" + downloadRange3.getProgress(), true);
            this.f60473g.getAndIncrement();
            u(downloadRange3, i11);
        }
    }

    @Override // com.transsnet.downloader.core.task.a
    public void start() {
        if (!f.f49475a.e()) {
            this.f60467a.b(this.f60469c, new DownloadException(9, DownloadException.EXCEPTION_MESSAGE_NO_NET));
            return;
        }
        DownloadUtil downloadUtil = DownloadUtil.f61136a;
        if (downloadUtil.c(this.f60469c)) {
            DownloadReporter.f61112c.a().g(this.f60469c, null);
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"startDownload, 资源有问题，需要从头下载"}, true);
            downloadUtil.z(this.f60469c);
        }
        this.f60469c.setRestartDownloadCount(0);
        if (p()) {
            e();
            return;
        }
        this.f60469c.setStatus(2);
        if (this.f60469c.getDownloadRanges().isEmpty()) {
            j.d(this.f60476j, null, null, new AnonymousClass1(null), 3, null);
        } else {
            j.d(this.f60476j, null, null, new AnonymousClass2(null), 3, null);
        }
    }

    public final void t(int i11) {
        uo.b.a aVar = uo.b.f78622a;
        aVar.c(DownloadBaseRunnable.TAG, "1---multithreadingDownload,name:" + this.f60469c.getName() + ", RangesSize:" + this.f60469c.getDownloadRanges().size(), true);
        List<DownloadRange> listF = DownloadTaskUtil.f60483a.f(i11, this.f60469c);
        aVar.c(DownloadBaseRunnable.TAG, "执行多线程下载, 需要启的线程数 =  " + listF.size(), true);
        int i12 = this.f60473g.get() - 1;
        this.f60473g.addAndGet(listF.size());
        for (DownloadRange downloadRange : listF) {
            uo.b.a.f(uo.b.f78622a, DownloadBaseRunnable.TAG, "----多线程下载开始, rangeId =  " + downloadRange.getRangeId() + "， index = " + i12 + "，status = " + this.f60469c.getStatus(), false, 4, null);
            i12++;
            u(downloadRange, i12);
        }
    }

    public final void u(DownloadRange downloadRange, int i11) {
        downloadRange.setDownloading(true);
        if (DownloadTaskUtil.f60483a.d()) {
            com.transsnet.downloader.core.thread.b bVar = new com.transsnet.downloader.core.thread.b(downloadRange, this.f60468b, i11, this.f60467a, this.f60470d, this.f60469c, this);
            this.f60474h.add(bVar);
            j.d(this.f60476j, null, null, new DownloadTaskImpl2$startDownloadInIO$1(bVar, null), 3, null);
        } else {
            DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange, this.f60468b, i11, this.f60467a, this.f60470d, this.f60469c, this);
            this.f60474h.add(downloadRunnable);
            DownloadExecutor.f60487a.b().c(downloadRunnable);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object v(Continuation<? super Unit> continuation) throws Throwable {
        DownloadTaskImpl2$startFirstDownload$1 downloadTaskImpl2$startFirstDownload$1;
        List arrayList;
        int size;
        DownloadTaskImpl2 downloadTaskImpl2;
        DownloadTaskImpl2 downloadTaskImpl3 = this;
        if (continuation instanceof DownloadTaskImpl2$startFirstDownload$1) {
            downloadTaskImpl2$startFirstDownload$1 = (DownloadTaskImpl2$startFirstDownload$1) continuation;
            int i11 = downloadTaskImpl2$startFirstDownload$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadTaskImpl2$startFirstDownload$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadTaskImpl2$startFirstDownload$1 = new DownloadTaskImpl2$startFirstDownload$1(downloadTaskImpl3, continuation);
            }
        } else {
            downloadTaskImpl2$startFirstDownload$1 = new DownloadTaskImpl2$startFirstDownload$1(downloadTaskImpl3, continuation);
        }
        Object obj = downloadTaskImpl2$startFirstDownload$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadTaskImpl2$startFirstDownload$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            new DownloadFileInfoTask().b(downloadTaskImpl3.f60469c);
            int iB = downloadTaskImpl3.f60470d.b();
            arrayList = new ArrayList();
            long downloadHeaderSize = downloadTaskImpl3.f60469c.getDownloadHeaderSize() / ((long) iB);
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = -1L;
            Ref.LongRef longRef2 = new Ref.LongRef();
            longRef2.element = -1L;
            Long size2 = downloadTaskImpl3.f60469c.getSize();
            long jLongValue = size2 != null ? size2.longValue() : 0L;
            int i13 = 0;
            while (true) {
                long j11 = longRef2.element;
                long j12 = jLongValue - 1;
                long j13 = downloadHeaderSize;
                if (j11 >= j12) {
                    break;
                }
                int i14 = i13 + 1;
                long j14 = i13 < iB ? j13 : downloadTaskImpl3.f60472f;
                long j15 = longRef.element < 0 ? 0L : j11 + 1;
                longRef.element = j15;
                long j16 = (j15 + j14) - 1;
                longRef2.element = j16;
                if (j16 >= jLongValue) {
                    longRef2.element = j12;
                }
                uo.b.a aVar = uo.b.f78622a;
                long j17 = longRef.element;
                long j18 = longRef2.element;
                StringBuilder sb2 = new StringBuilder();
                Object obj2 = objE;
                sb2.append("首次多线程下载, rangeCount:");
                sb2.append(i14);
                sb2.append(",resSize:");
                sb2.append(jLongValue);
                sb2.append(" rangeSize:");
                sb2.append(j14);
                sb2.append(",rangeStart:");
                sb2.append(j17);
                sb2.append(",angeEnd:");
                sb2.append(j18);
                aVar.n(DownloadBaseRunnable.TAG, new String[]{sb2.toString()}, true);
                DownloadRange downloadRange = new DownloadRange();
                String resourceId = this.f60469c.getResourceId();
                downloadRange.setThreadId(resourceId != null ? resourceId.hashCode() : 0);
                downloadRange.setRangeId(p.a(longRef.element + longRef2.element));
                downloadRange.setResourceId(this.f60469c.getResourceId());
                downloadRange.setStart(longRef.element);
                downloadRange.setEnd(longRef2.element);
                downloadRange.setProgress(0L);
                arrayList.add(downloadRange);
                downloadTaskImpl3 = this;
                i13 = i14;
                objE = obj2;
                downloadHeaderSize = j13;
                downloadTaskImpl2$startFirstDownload$1 = downloadTaskImpl2$startFirstDownload$1;
                iB = iB;
            }
            int i15 = iB;
            DownloadTaskImpl2$startFirstDownload$1 downloadTaskImpl2$startFirstDownload$2 = downloadTaskImpl2$startFirstDownload$1;
            Object obj3 = objE;
            DownloadTaskImpl2 downloadTaskImpl4 = downloadTaskImpl3;
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"首次多线程下载, , isPreDownload:" + downloadTaskImpl4.f60469c.isPreDownload() + ", rangeListSize:" + arrayList.size() + "，ThreadSize:" + i15 + ", name:" + downloadTaskImpl4.f60469c.getName()}, true);
            downloadTaskImpl4.f60469c.setStatus(2);
            downloadTaskImpl4.f60469c.getDownloadRanges().addAll(arrayList);
            DownloadTaskUtil downloadTaskUtil = DownloadTaskUtil.f60483a;
            List<DownloadRange> downloadRanges = downloadTaskImpl4.f60469c.getDownloadRanges();
            downloadTaskImpl2$startFirstDownload$2.L$0 = downloadTaskImpl4;
            downloadTaskImpl2$startFirstDownload$2.L$1 = arrayList;
            downloadTaskImpl2$startFirstDownload$2.I$0 = i15;
            downloadTaskImpl2$startFirstDownload$2.label = 1;
            if (downloadTaskUtil.h(downloadRanges, downloadTaskImpl2$startFirstDownload$2) == obj3) {
                return obj3;
            }
            size = i15;
            downloadTaskImpl2 = downloadTaskImpl4;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            size = downloadTaskImpl2$startFirstDownload$1.I$0;
            arrayList = (List) downloadTaskImpl2$startFirstDownload$1.L$1;
            downloadTaskImpl2 = (DownloadTaskImpl2) downloadTaskImpl2$startFirstDownload$1.L$0;
            ResultKt.b(obj);
        }
        if (arrayList.size() < size) {
            size = arrayList.size();
        }
        int i16 = 0;
        for (Object obj4 : arrayList.subList(0, size)) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                g.u();
            }
            downloadTaskImpl2.u((DownloadRange) obj4, i16);
            downloadTaskImpl2.f60473g.getAndIncrement();
            i16 = i17;
        }
        return Unit.f68710a;
    }
}
