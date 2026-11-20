package com.transsnet.downloader.manager;

import android.app.Application;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.util.networkinfo.g;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.download.SubtitleBean;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsnet.downloader.callback.DownloadTaskStat;
import com.transsnet.downloader.config.Config;
import com.transsnet.downloader.core.DownloadOkHttpGenerator;
import com.transsnet.downloader.core.DownloadResponseImpl;
import com.transsnet.downloader.core.DownloadTaskImpl;
import com.transsnet.downloader.core.DownloadTaskImpl2;
import com.transsnet.downloader.core.task.DownloadTaskUtil;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.notification.DownloadNotificationUtils;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import tr.h;
import tr.j;

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
public final class DownloadManagerImpl implements com.transsnet.downloader.manager.a, com.transsnet.downloader.core.task.b {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f61018y = new a(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Lazy<DownloadManagerImpl> f61019z = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<DownloadManagerImpl>() { // from class: com.transsnet.downloader.manager.DownloadManagerImpl$Companion$getInstance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadManagerImpl invoke() {
            return new DownloadManagerImpl(null);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.transsnet.downloader.core.a f61023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Config f61024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f61025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f61026g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g00.b f61029j;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.transsnet.downloader.proxy.a f61039t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f61020a = "DownloadImp";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> f61021b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<DownloadBean> f61022c = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> f61027h = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap<String, DownloadBean> f61028i = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<String> f61030k = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<String> f61031l = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<String> f61032m = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Set<String> f61033n = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f61034o = LazyKt__LazyJVMKt.b(new Function0<rr.a>() { // from class: com.transsnet.downloader.manager.DownloadManagerImpl$audioDao$2
        @Override // kotlin.jvm.functions.Function0
        public final rr.a invoke() {
            Application applicationA = com.tn.lib.util.a.f49452a.a();
            if (applicationA != null) {
                return AppDatabase.f51036p.b(applicationA).D0();
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DownloadTaskStat f61035p = new DownloadTaskStat(0, 0, 0, 0);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Set<tr.g> f61036q = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Set<j> f61037r = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f61038s = LazyKt__LazyJVMKt.b(new Function0<i00.a>() { // from class: com.transsnet.downloader.manager.DownloadManagerImpl$serviceDownload$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final i00.a invoke() {
            return (i00.a) NetServiceGenerator.f49399d.a().i(i00.a.class);
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k0 f61040u = l0.a(w0.c());

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k0 f61041v = l0.a(w0.b());

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f61042w = LazyKt__LazyJVMKt.b(new Function0<h>() { // from class: com.transsnet.downloader.manager.DownloadManagerImpl$rangeDao$2
        @Override // kotlin.jvm.functions.Function0
        public final h invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).F0();
        }
    });

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f61043x = LazyKt__LazyJVMKt.b(new Function0<IPostDetailApi>() { // from class: com.transsnet.downloader.manager.DownloadManagerImpl$postDetailApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IPostDetailApi invoke() {
            return (IPostDetailApi) com.alibaba.android.arouter.launcher.a.d().h(IPostDetailApi.class);
        }
    });

    /* JADX INFO: renamed from: com.transsnet.downloader.manager.DownloadManagerImpl$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$3", f = "DownloadManagerImpl.kt", l = {1266}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadManagerImpl.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                DownloadManagerImpl downloadManagerImpl = DownloadManagerImpl.this;
                this.label = 1;
                if (downloadManagerImpl.C(this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.transsnet.downloader.manager.a a() {
            return (com.transsnet.downloader.manager.a) DownloadManagerImpl.f61019z.getValue();
        }
    }

    public DownloadManagerImpl(Config config) {
        if (config == null) {
            this.f61024e = new Config();
        } else {
            this.f61024e = config;
        }
        com.transsnet.downloader.proxy.a aVar = new com.transsnet.downloader.proxy.a();
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        aVar.g(applicationA);
        tr.g gVarE = aVar.e();
        if (gVarE != null) {
            f(gVarE);
        }
        this.f61039t = aVar;
        DownloadEsHelper.f60994m.a();
        this.f61023d = new DownloadResponseImpl(this, this.f61036q, this.f61024e);
        DownloadNotificationUtils.f61068a.B();
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new AnonymousClass3(null), 3, null);
        A0();
        DownloadListManager.x(DownloadListManager.f61186m.a(), false, false, null, 7, null);
        f(new FinishDownloadHelper());
    }

    public static /* synthetic */ void t0(DownloadManagerImpl downloadManagerImpl, DownloadBean downloadBean, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        downloadManagerImpl.s0(downloadBean, z11);
    }

    @Override // com.transsnet.downloader.manager.a
    public void A() {
        u0(null);
    }

    public final void A0() {
        g gVar = new g() { // from class: com.transsnet.downloader.manager.DownloadManagerImpl$registerNetwork$1
            public final void a() {
                uo.b.a aVar = uo.b.f78622a;
                uo.b.a.f(aVar, this.f61044a.f61020a, "---------Download, Network onConnected", false, 4, null);
                DownloadBean downloadBeanD = this.f61044a.f61039t.d();
                if (downloadBeanD != null) {
                    DownloadManagerImpl downloadManagerImpl = this.f61044a;
                    if (!downloadBeanD.isRemoved()) {
                        uo.b.a.f(aVar, downloadManagerImpl.f61020a, "onConnected, start DownloadingPlay, name = " + downloadBeanD.getName() + ",epse = " + downloadBeanD.getEpse() + ",  cur status = " + downloadBeanD.getStatus(), false, 4, null);
                        downloadManagerImpl.s(downloadBeanD, true);
                    }
                }
                List<DownloadBean> list = this.f61044a.f61022c;
                DownloadManagerImpl downloadManagerImpl2 = this.f61044a;
                for (DownloadBean downloadBean : list) {
                    if (downloadBean.getStatus() == 6 || downloadBean.getStatus() == 3 || downloadBean.isDownloading()) {
                        uo.b.f78622a.c(downloadManagerImpl2.f61020a, "onConnected, caches, name = " + downloadBean.getName() + ",epse = " + downloadBean.getEpse() + ",  cur status = " + downloadBean.getStatus(), true);
                        if (downloadBean.isDownloading()) {
                            downloadBean.setPreDownload(false);
                            downloadBean.setStatus(3);
                        }
                        downloadManagerImpl2.s(downloadBean, true);
                    }
                }
                kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new DownloadManagerImpl$registerNetwork$1$netConnected$3(this.f61044a, null), 3, null);
            }

            @Override // com.tn.lib.util.networkinfo.g
            public void onConnected() {
                a();
            }

            @Override // com.tn.lib.util.networkinfo.g
            public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
                Intrinsics.g(network, "network");
                Intrinsics.g(networkCapabilities, "networkCapabilities");
                a();
            }

            @Override // com.tn.lib.util.networkinfo.g
            public void onDisconnected() {
                uo.b.a.f(uo.b.f78622a, this.f61044a.f61020a, "---------Download, Network onDisconnected, cancel all request---------", false, 4, null);
                try {
                    DownloadOkHttpGenerator.f60434c.a().b().dispatcher().cancelAll();
                } catch (Throwable unused) {
                }
                this.f61044a.f61021b.clear();
                this.f61044a.f61028i.clear();
                this.f61044a.f61027h.clear();
            }
        };
        this.f61026g = gVar;
        f.f49475a.l(gVar);
    }

    @Override // com.transsnet.downloader.manager.a
    public void B(j listener) {
        Intrinsics.g(listener, "listener");
        this.f61037r.add(listener);
    }

    public final void B0(DownloadBean downloadBean) {
        Set<String> set = this.f61031l;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        set.remove(resourceId);
        Set<String> set2 = this.f61032m;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        set2.remove(resourceId2);
        Set<String> set3 = this.f61030k;
        String resourceId3 = downloadBean.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadBean.getUrl();
        }
        set3.remove(resourceId3);
        Set<String> set4 = this.f61033n;
        String resourceId4 = downloadBean.getResourceId();
        if (resourceId4 == null) {
            resourceId4 = downloadBean.getUrl();
        }
        set4.remove(resourceId4);
        H0();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Code duplicated, block: B:29:0x007e  */
    /* JADX WARN: Code duplicated, block: B:31:0x008a  */
    /* JADX WARN: Code duplicated, block: B:33:0x0092  */
    /* JADX WARN: Code duplicated, block: B:40:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.transsnet.downloader.manager.a
    public Object C(Continuation<? super Unit> continuation) throws Throwable {
        DownloadManagerImpl$scheduleDownloadTask$1 downloadManagerImpl$scheduleDownloadTask$1;
        DownloadManagerImpl downloadManagerImpl;
        DownloadManagerImpl downloadManagerImpl2;
        List<DownloadBean> list;
        String resourceId;
        if (continuation instanceof DownloadManagerImpl$scheduleDownloadTask$1) {
            downloadManagerImpl$scheduleDownloadTask$1 = (DownloadManagerImpl$scheduleDownloadTask$1) continuation;
            int i11 = downloadManagerImpl$scheduleDownloadTask$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadManagerImpl$scheduleDownloadTask$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadManagerImpl$scheduleDownloadTask$1 = new DownloadManagerImpl$scheduleDownloadTask$1(this, continuation);
            }
        } else {
            downloadManagerImpl$scheduleDownloadTask$1 = new DownloadManagerImpl$scheduleDownloadTask$1(this, continuation);
        }
        Object objX = downloadManagerImpl$scheduleDownloadTask$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadManagerImpl$scheduleDownloadTask$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                downloadManagerImpl = (DownloadManagerImpl) downloadManagerImpl$scheduleDownloadTask$1.L$0;
                ResultKt.b(objX);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                downloadManagerImpl2 = (DownloadManagerImpl) downloadManagerImpl$scheduleDownloadTask$1.L$0;
                ResultKt.b(objX);
            }
            list = (List) objX;
            if (list != null) {
                for (DownloadBean downloadBean : list) {
                    if (downloadBean.isRead() != 1) {
                        Set<String> set = downloadManagerImpl2.f61033n;
                        resourceId = downloadBean.getResourceId();
                        if (resourceId == null) {
                            resourceId = downloadBean.getUrl();
                        }
                        set.remove(resourceId);
                    }
                    uo.b.a.f(uo.b.f78622a, "DownloadStatus", "init add doneSet, resId = " + downloadBean.getResourceId() + "， it.isRead = " + downloadBean.isRead(), false, 4, null);
                }
            }
            return Unit.f68710a;
        }
        ResultKt.b(objX);
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        downloadManagerImpl$scheduleDownloadTask$1.L$0 = this;
        downloadManagerImpl$scheduleDownloadTask$1.label = 1;
        objX = downloadEsHelperA.x(downloadManagerImpl$scheduleDownloadTask$1);
        if (objX == objE) {
            return objE;
        }
        downloadManagerImpl = this;
        downloadManagerImpl.F0((List) objX);
        DownloadEsHelper downloadEsHelperA2 = DownloadEsHelper.f60994m.a();
        downloadManagerImpl$scheduleDownloadTask$1.L$0 = downloadManagerImpl;
        downloadManagerImpl$scheduleDownloadTask$1.label = 2;
        objX = DownloadEsHelper.w(downloadEsHelperA2, false, downloadManagerImpl$scheduleDownloadTask$1, 1, null);
        if (objX == objE) {
            return objE;
        }
        downloadManagerImpl2 = downloadManagerImpl;
        list = (List) objX;
        if (list != null) {
            while (r12.hasNext()) {
                if (downloadBean.isRead() != 1) {
                    Set<String> set2 = downloadManagerImpl2.f61033n;
                    resourceId = downloadBean.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean.getUrl();
                    }
                    set2.remove(resourceId);
                }
                uo.b.a.f(uo.b.f78622a, "DownloadStatus", "init add doneSet, resId = " + downloadBean.getResourceId() + "， it.isRead = " + downloadBean.isRead(), false, 4, null);
            }
        }
        return Unit.f68710a;
    }

    public final void C0(final List<? extends DownloadBean> list, final int i11, final Function1<? super Boolean, Unit> function1) {
        final DownloadBean downloadBean = list.get(i11);
        final String path = downloadBean.getPath();
        h0(downloadBean, false, new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.manager.DownloadManagerImpl$removeDownload$1

            /* JADX INFO: renamed from: com.transsnet.downloader.manager.DownloadManagerImpl$removeDownload$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$removeDownload$1$1", f = "DownloadManagerImpl.kt", l = {}, m = "invokeSuspend")
            @SourceDebugExtension
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                final /* synthetic */ DownloadBean $bean;
                final /* synthetic */ String $path;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(String str, DownloadBean downloadBean, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$path = str;
                    this.$bean = downloadBean;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$path, this.$bean, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    kotlin.coroutines.intrinsics.a.e();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    String str = this.$path;
                    if (str != null) {
                        int rootPathType = this.$bean.getRootPathType();
                        if (rootPathType != 2) {
                            if (rootPathType == 3 && Build.VERSION.SDK_INT >= 29) {
                                com.transsnet.downloader.e eVar = com.transsnet.downloader.e.f60605a;
                                Application applicationA = Utils.a();
                                Intrinsics.f(applicationA, "getApp()");
                                eVar.d(applicationA, str);
                            }
                        } else if (Build.VERSION.SDK_INT >= 29) {
                            com.transsnet.downloader.e eVar2 = com.transsnet.downloader.e.f60605a;
                            Application applicationA2 = Utils.a();
                            Intrinsics.f(applicationA2, "getApp()");
                            eVar2.e(applicationA2, str);
                        }
                        if (l.L(str, AppLovinEventTypes.USER_VIEWED_CONTENT, false, 2, null)) {
                            l3.a aVarG = l3.a.g(Utils.a(), Uri.parse(str));
                            if (aVarG != null) {
                                Boxing.a(aVarG.d());
                            }
                        } else {
                            Boxing.a(new File(str).delete());
                        }
                    }
                    Iterator<T> it = this.$bean.getSubtitleList().iterator();
                    while (it.hasNext()) {
                        File file = new File(String.valueOf(((SubtitleBean) it.next()).getPath()));
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    return Unit.f68710a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                uo.b.f78622a.r(DownloadBaseRunnable.TAG, "removeDownload ,db success, remove file, name = " + downloadBean.getName() + ", resourceId：" + downloadBean.getResourceId(), true);
                this.B0(downloadBean);
                ConcurrentHashMap concurrentHashMap = this.f61021b;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                concurrentHashMap.remove(resourceId);
                ConcurrentHashMap concurrentHashMap2 = this.f61028i;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                concurrentHashMap2.remove(resourceId2);
                ConcurrentHashMap concurrentHashMap3 = this.f61027h;
                String resourceId3 = downloadBean.getResourceId();
                if (resourceId3 == null) {
                    resourceId3 = downloadBean.getUrl();
                }
                concurrentHashMap3.remove(resourceId3);
                this.f61022c.remove(downloadBean);
                com.transsnet.downloader.core.a aVar = this.f61023d;
                if (aVar != null) {
                    aVar.a(downloadBean);
                }
                kotlinx.coroutines.j.d(this.f61041v, null, null, new AnonymousClass1(path, downloadBean, null), 3, null);
                if (i11 < list.size() - 1) {
                    this.C0(list, i11 + 1, function1);
                    return;
                }
                f00.d dVar = new f00.d(true, false);
                AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
                FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
                String name = f00.d.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, dVar, 0L);
                f00.a aVar2 = new f00.a();
                FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
                String name2 = f00.a.class.getName();
                Intrinsics.f(name2, "T::class.java.name");
                flowEventBus2.postEvent(name2, aVar2, 0L);
                Function1<Boolean, Unit> function2 = function1;
                if (function2 != null) {
                    function2.invoke(Boolean.TRUE);
                }
            }
        });
    }

    @Override // com.transsnet.downloader.manager.a
    public void D(List<? extends DownloadBean> list) {
        Intrinsics.g(list, "list");
        if (list.isEmpty()) {
            return;
        }
        if (list.size() == 1) {
            p(list.get(0));
            return;
        }
        Config config = this.f61024e;
        int iA = config != null ? config.a() : 1;
        for (int i11 = 0; i11 < iA; i11++) {
            if (i11 < list.size()) {
                p(list.get(i11));
            }
        }
        int i12 = 0;
        for (Object obj : list) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                kotlin.collections.g.u();
            }
            DownloadBean downloadBean = (DownloadBean) obj;
            long j11 = i12;
            downloadBean.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis() + j11));
            downloadBean.setCreateAt(System.currentTimeMillis() + j11);
            if (i12 >= iA && i12 != list.size() - 1) {
                ConcurrentHashMap<String, DownloadBean> concurrentHashMap = this.f61028i;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                concurrentHashMap.put(resourceId, downloadBean);
                ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap2 = this.f61027h;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                concurrentHashMap2.remove(resourceId2);
                if (!this.f61022c.contains(downloadBean)) {
                    this.f61022c.add(downloadBean);
                }
                downloadBean.setPreDownload(false);
                downloadBean.setStatus(3);
                com.transsnet.downloader.core.a aVar = this.f61023d;
                if (aVar != null) {
                    aVar.a(downloadBean);
                }
                Set<String> set = this.f61030k;
                String resourceId3 = downloadBean.getResourceId();
                if (resourceId3 == null) {
                    resourceId3 = downloadBean.getUrl();
                }
                set.add(resourceId3);
                H0();
            }
            i12 = i13;
        }
        int size = list.size() - 1;
        if (size >= iA - 1) {
            DownloadBean downloadBean2 = list.get(size);
            if (!this.f61022c.contains(downloadBean2)) {
                this.f61022c.add(downloadBean2);
            }
            if (!v0(downloadBean2)) {
                downloadBean2.setStatus(3);
                com.transsnet.downloader.core.a aVar2 = this.f61023d;
                if (aVar2 != null) {
                    aVar2.a(downloadBean2);
                }
            }
            Set<String> set2 = this.f61030k;
            String resourceId4 = downloadBean2.getResourceId();
            if (resourceId4 == null) {
                resourceId4 = downloadBean2.getUrl();
            }
            set2.add(resourceId4);
        }
        H0();
    }

    public final void D0(DownloadBean downloadBean) {
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new DownloadManagerImpl$requestNewSource$1(this, downloadBean, null), 3, null);
    }

    @Override // com.transsnet.downloader.manager.a
    public void E() {
        H0();
    }

    public final void E0(boolean z11) {
        if (q0()) {
            uo.b.f78622a.c(DownloadBaseRunnable.TAG, "resumeAll, " + z11, true);
            for (DownloadBean downloadBean : this.f61022c) {
                uo.b.f78622a.c(DownloadBaseRunnable.TAG, "resumeAll, " + z11 + ", pauseInner:" + downloadBean.getTotalTitleName() + ", isAutoPause:" + downloadBean.isAutoPause(), true);
                if (!z11) {
                    x0(downloadBean);
                } else if (downloadBean.isAutoPause() && !downloadBean.isDownloading()) {
                    if (!this.f61021b.isEmpty()) {
                        downloadBean.setStatus(3);
                        com.transsnet.downloader.core.a aVar = this.f61023d;
                        if (aVar != null) {
                            aVar.a(downloadBean);
                        }
                    } else {
                        x0(downloadBean);
                    }
                }
            }
        }
    }

    @Override // com.transsnet.downloader.manager.a
    public void F(DownloadBean downloadInfo) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        if (q0()) {
            t0(this, downloadInfo, false, 2, null);
        }
    }

    public final void F0(List<? extends DownloadBean> list) {
        boolean z11;
        DownloadBean downloadBean;
        DownloadBean downloadBean2;
        uo.b.a.f(uo.b.f78622a, this.f61020a, "resumeAllDownloading , uncomplete size = " + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
        int i11 = 4;
        int i12 = 2;
        int i13 = 3;
        int i14 = 1;
        if (list != null) {
            Iterator it = list.iterator();
            z11 = false;
            downloadBean = null;
            downloadBean2 = null;
            while (it.hasNext()) {
                DownloadBean downloadBean3 = (DownloadBean) it.next();
                int status = downloadBean3.getStatus();
                if (status == i14 || status == i12) {
                    Iterator<T> it2 = this.f61022c.iterator();
                    boolean z12 = false;
                    while (it2.hasNext()) {
                        if (Intrinsics.b(downloadBean3.getResourceId(), ((DownloadBean) it2.next()).getResourceId())) {
                            z12 = true;
                        }
                    }
                    ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap = this.f61021b;
                    String resourceId = downloadBean3.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean3.getUrl();
                    }
                    if (!concurrentHashMap.containsKey(resourceId)) {
                        z12 = false;
                    }
                    if (downloadBean3.isPreDownload() || !z12) {
                        uo.b.a aVar = uo.b.f78622a;
                        String resourceId2 = downloadBean3.getResourceId();
                        if (resourceId2 == null) {
                            resourceId2 = downloadBean3.getUrl();
                        }
                        uo.b.a.f(aVar, "DownloadStatus", "init resume , resId = " + resourceId2, false, 4, null);
                        String str = this.f61020a;
                        String resourceId3 = downloadBean3.getResourceId();
                        if (resourceId3 == null) {
                            resourceId3 = downloadBean3.getUrl();
                        }
                        aVar.c(str, "resumeAllDownloading init resume  , resId = " + resourceId3 + ", name = " + downloadBean3.getName(), true);
                        downloadBean3.setStatus(3);
                        s(downloadBean3, true);
                    }
                    z11 = true;
                } else if (status == i13 || status == i11) {
                    if (downloadBean == null) {
                        downloadBean = downloadBean3;
                    }
                    if (downloadBean3.getStatus() == i13 && downloadBean3.getProgress() < 5242880) {
                        uo.b.a.f(uo.b.f78622a, this.f61020a, "init-----preDownload ，add to pool, name = " + downloadBean3.getName() + ", epse = " + downloadBean3.getEpse(), false, 4, null);
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = this.f61028i;
                        String resourceId4 = downloadBean3.getResourceId();
                        if (resourceId4 == null) {
                            resourceId4 = downloadBean3.getUrl();
                        }
                        concurrentHashMap2.put(resourceId4, downloadBean3);
                    }
                    uo.b.a aVar2 = uo.b.f78622a;
                    uo.b.a.f(aVar2, "DownloadStatus", "init add waitSet , resId = " + downloadBean3.getResourceId() + ", name = " + downloadBean3.getName(), false, 4, null);
                    String str2 = this.f61020a;
                    String resourceId5 = downloadBean3.getResourceId();
                    int epse = downloadBean3.getEpse();
                    String name = downloadBean3.getName();
                    int status2 = downloadBean3.getStatus();
                    long progress = downloadBean3.getProgress();
                    StringBuilder sb2 = new StringBuilder();
                    boolean z13 = z11;
                    sb2.append("init add waitSet , resId = ");
                    sb2.append(resourceId5);
                    sb2.append(", epse = ");
                    sb2.append(epse);
                    sb2.append(", name = ");
                    sb2.append(name);
                    sb2.append(", status = ");
                    sb2.append(status2);
                    sb2.append(",progress = ");
                    sb2.append(progress);
                    uo.b.a.f(aVar2, str2, sb2.toString(), false, 4, null);
                    Set<String> set = this.f61030k;
                    String resourceId6 = downloadBean3.getResourceId();
                    if (resourceId6 == null) {
                        resourceId6 = downloadBean3.getUrl();
                    }
                    set.add(resourceId6);
                    z11 = z13;
                } else if (status == 6) {
                    if (downloadBean2 == null) {
                        downloadBean2 = downloadBean3;
                    }
                    uo.b.a aVar3 = uo.b.f78622a;
                    uo.b.a.f(aVar3, "DownloadStatus", "init add errorSet , resId = " + downloadBean3.getResourceId() + ", name = " + downloadBean3.getName() + ", name = " + downloadBean3.getName(), false, 4, null);
                    String str3 = this.f61020a;
                    String resourceId7 = downloadBean3.getResourceId();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("init add errorSet , resId = ");
                    sb3.append(resourceId7);
                    uo.b.a.f(aVar3, str3, sb3.toString(), false, 4, null);
                    Set<String> set2 = this.f61032m;
                    String resourceId8 = downloadBean3.getResourceId();
                    if (resourceId8 == null) {
                        resourceId8 = downloadBean3.getUrl();
                    }
                    set2.add(resourceId8);
                }
                H0();
                if (!this.f61022c.contains(downloadBean3)) {
                    uo.b.f78622a.c(this.f61020a, "resumeAllDownloading， add 2 cache, name = " + downloadBean3.getName(), true);
                    this.f61022c.add(downloadBean3);
                }
                it = it;
                i11 = 4;
                i12 = 2;
                i13 = 3;
                i14 = 1;
            }
        } else {
            z11 = false;
            downloadBean = null;
            downloadBean2 = null;
        }
        if (z11) {
            return;
        }
        if (downloadBean != null && downloadBean.getStatus() != 4) {
            uo.b.f78622a.c(this.f61020a, "------ has no loading, use wait, name = " + downloadBean.getName(), true);
            Set<String> set3 = this.f61030k;
            String resourceId9 = downloadBean.getResourceId();
            if (resourceId9 == null) {
                resourceId9 = downloadBean.getUrl();
            }
            set3.remove(resourceId9);
            downloadBean.setStatus(3);
            com.transsnet.downloader.manager.a.C0624a.a(this, downloadBean, false, 2, null);
            H0();
            return;
        }
        if (downloadBean2 != null) {
            uo.b.f78622a.c(this.f61020a, "------ has no loading, use error, name = " + downloadBean2.getName(), true);
            Set<String> set4 = this.f61032m;
            String resourceId10 = downloadBean2.getResourceId();
            if (resourceId10 == null) {
                resourceId10 = downloadBean2.getUrl();
            }
            set4.remove(resourceId10);
            downloadBean2.setStatus(3);
            com.transsnet.downloader.manager.a.C0624a.a(this, downloadBean2, false, 2, null);
            H0();
        }
    }

    @Override // com.transsnet.downloader.manager.a
    public void G() {
        this.f61039t.c();
    }

    public final void G0() {
        String key;
        int size = this.f61021b.size();
        Config config = this.f61024e;
        if (size >= (config != null ? config.a() : 2)) {
            Iterator<Map.Entry<String, com.transsnet.downloader.core.task.a>> it = this.f61021b.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, com.transsnet.downloader.core.task.a> next = it.next();
                key = next.getKey();
                DownloadBean downloadBeanB = next.getValue().b();
                downloadBeanB.setStatus(3);
                com.transsnet.downloader.core.a aVar = this.f61023d;
                if (aVar != null) {
                    aVar.a(downloadBeanB);
                }
                Set<String> set = this.f61031l;
                String resourceId = downloadBeanB.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBeanB.getUrl();
                }
                set.remove(resourceId);
                Set<String> set2 = this.f61030k;
                String resourceId2 = downloadBeanB.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBeanB.getUrl();
                }
                set2.add(resourceId2);
                uo.b.f78622a.c(DownloadBaseRunnable.TAG, "有其他资源进入边下边播 当前资源转换为waiting setCurDownloadingToWait() --> 2--downloading2wait,resourceId=" + downloadBeanB.getResourceId() + ",name = " + downloadBeanB.getTotalTitleName() + " ", true);
                H0();
            } else {
                key = null;
            }
            if (key != null) {
                this.f61021b.remove(key);
            }
        }
    }

    @Override // com.transsnet.downloader.core.task.b
    public void H(DownloadBean downloadInfo) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        kotlinx.coroutines.j.d(this.f61040u, null, null, new DownloadManagerImpl$onPreDownloadSuccess$1(this, downloadInfo, null), 3, null);
    }

    public final void H0() {
        g00.b bVar = this.f61029j;
        if (bVar != null) {
            this.f61035p.setWaitCount(this.f61030k.size());
            this.f61035p.setLoadingCount(this.f61031l.size());
            this.f61035p.setErrorCount(this.f61032m.size());
            this.f61035p.setDoneCount(this.f61033n.size());
            uo.b.a.f(uo.b.f78622a, this.f61020a, "-------- statChange, downloadStat = " + this.f61035p + " ", false, 4, null);
            bVar.a(this.f61035p);
        }
    }

    public final void I0(DownloadBean downloadBean) {
        if (downloadBean.getRootPathType() == 1) {
            downloadBean.setTransferFailed(false);
        } else {
            if (downloadBean.getType() == 1) {
                return;
            }
            kotlinx.coroutines.j.d(this.f61041v, null, null, new DownloadManagerImpl$transferFile$1(downloadBean, null), 3, null);
        }
    }

    public final void J0(DownloadBean downloadBean) {
        Set<String> set = this.f61032m;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        set.add(resourceId);
        Set<String> set2 = this.f61031l;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        set2.remove(resourceId2);
        H0();
        z0();
    }

    public final void K0(DownloadBean downloadBean) {
        Set<String> set = this.f61030k;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        set.remove(resourceId);
        Set<String> set2 = this.f61032m;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        set2.remove(resourceId2);
        x0(downloadBean);
    }

    public final void L0(DownloadBean downloadBean) {
        DownloadBean next;
        com.transsnet.downloader.core.a aVar;
        if (downloadBean.isCompleted() || downloadBean.isRemoved()) {
            return;
        }
        uo.b.a aVar2 = uo.b.f78622a;
        uo.b.a.s(aVar2, this.f61020a, "1- waitDownloadingAndStartNewTask,进入边下边播 subjectId=" + downloadBean.getSubjectId() + ",resourceId=" + downloadBean.getResourceId() + ",name = " + downloadBean.getTotalTitleName() + ",status = " + downloadBean.getStatus(), false, 4, null);
        downloadBean.setDownloadingPlay(true);
        boolean z11 = false;
        if (downloadBean.getStatus() == 2 || downloadBean.getStatus() == 1) {
            aVar2.n(DownloadBaseRunnable.TAG, new String[]{"下载中的 变成当前边下边播的 waitDownloadingAndStartNewTask, subjectId=" + downloadBean.getSubjectId() + ",resourceId=" + downloadBean.getResourceId() + ",status-- name = " + downloadBean.getName() + " "}, true);
            if (downloadBean.isPreDownload()) {
                downloadBean.setPreDownload(false);
                aVar2.n(DownloadBaseRunnable.TAG, new String[]{"preDownload 预下载的 转正变成当前边下边播的 subjectId=" + downloadBean.getSubjectId() + ",resourceId=" + downloadBean.getResourceId() + ",name= " + downloadBean.getName() + " , epse = " + downloadBean.getEpse()}, true);
                Set<String> set = this.f61030k;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                set.remove(resourceId);
                Set<String> set2 = this.f61032m;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                set2.remove(resourceId2);
                Set<String> set3 = this.f61031l;
                String resourceId3 = downloadBean.getResourceId();
                if (resourceId3 == null) {
                    resourceId3 = downloadBean.getUrl();
                }
                set3.add(resourceId3);
                downloadBean.setStatus(2);
                com.transsnet.downloader.core.a aVar3 = this.f61023d;
                if (aVar3 != null) {
                    aVar3.a(downloadBean);
                }
                H0();
                ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap = this.f61027h;
                String resourceId4 = downloadBean.getResourceId();
                if (resourceId4 == null) {
                    resourceId4 = downloadBean.getUrl();
                }
                com.transsnet.downloader.core.task.a aVar4 = concurrentHashMap.get(resourceId4);
                if (aVar4 != null) {
                    G0();
                    ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap2 = this.f61021b;
                    String resourceId5 = downloadBean.getResourceId();
                    if (resourceId5 == null) {
                        resourceId5 = downloadBean.getUrl();
                    }
                    concurrentHashMap2.put(resourceId5, aVar4);
                    ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap3 = this.f61027h;
                    String resourceId6 = downloadBean.getResourceId();
                    if (resourceId6 == null) {
                        resourceId6 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.remove(resourceId6);
                    return;
                }
                return;
            }
            return;
        }
        ConcurrentHashMap<String, DownloadBean> concurrentHashMap4 = this.f61028i;
        String resourceId7 = downloadBean.getResourceId();
        if (resourceId7 == null) {
            resourceId7 = downloadBean.getUrl();
        }
        concurrentHashMap4.remove(resourceId7);
        ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap5 = this.f61027h;
        String resourceId8 = downloadBean.getResourceId();
        if (resourceId8 == null) {
            resourceId8 = downloadBean.getUrl();
        }
        concurrentHashMap5.remove(resourceId8);
        downloadBean.setPreDownload(false);
        ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap6 = this.f61021b;
        String resourceId9 = downloadBean.getResourceId();
        if (resourceId9 == null) {
            resourceId9 = downloadBean.getUrl();
        }
        if (concurrentHashMap6.containsKey(resourceId9)) {
            if (downloadBean.isDownloading()) {
                aVar2.n(DownloadBaseRunnable.TAG, new String[]{"waitDownloadingAndStartNewTask, isDownloading name = " + downloadBean.getName() + " "}, true);
                return;
            }
            ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap7 = this.f61021b;
            String resourceId10 = downloadBean.getResourceId();
            if (resourceId10 == null) {
                resourceId10 = downloadBean.getUrl();
            }
            concurrentHashMap7.remove(resourceId10);
            uo.b.a.f(aVar2, this.f61020a, "waitDownloadingAndStartNewTask, isDownloading,error status , remove  name = " + downloadBean.getName(), false, 4, null);
        }
        G0();
        Iterator<DownloadBean> it = this.f61022c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = downloadBean;
                break;
            }
            next = it.next();
            if (Intrinsics.b(next.getResourceId(), downloadBean.getResourceId())) {
                z11 = true;
                break;
            }
        }
        if (!z11) {
            this.f61022c.add(next);
        }
        Config config = this.f61024e;
        com.transsnet.downloader.core.task.a aVarG0 = null;
        if (config != null && (aVar = this.f61023d) != null) {
            aVarG0 = g0(config, aVar, downloadBean);
        }
        if (aVarG0 != null) {
            ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap8 = this.f61021b;
            String resourceId11 = next.getResourceId();
            if (resourceId11 == null) {
                resourceId11 = next.getUrl();
            }
            concurrentHashMap8.put(resourceId11, aVarG0);
        }
        next.setStatus(1);
        com.transsnet.downloader.core.a aVar5 = this.f61023d;
        if (aVar5 != null) {
            aVar5.a(next);
        }
        f0(next);
        Set<String> set4 = this.f61030k;
        String resourceId12 = next.getResourceId();
        if (resourceId12 == null) {
            resourceId12 = next.getUrl();
        }
        set4.remove(resourceId12);
        Set<String> set5 = this.f61032m;
        String resourceId13 = next.getResourceId();
        if (resourceId13 == null) {
            resourceId13 = next.getUrl();
        }
        set5.remove(resourceId13);
        Set<String> set6 = this.f61031l;
        String resourceId14 = next.getResourceId();
        if (resourceId14 == null) {
            resourceId14 = next.getUrl();
        }
        set6.add(resourceId14);
        uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"由边下边播触发的下载要开始了 2--prepareDownload, name = " + next.getName() + ", add loading, loading  = " + this.f61031l.size() + ", error  = " + this.f61032m.size() + " , wait  = " + this.f61030k.size() + " "}, true);
        H0();
        if (aVarG0 != null) {
            aVarG0.start();
        }
    }

    @Override // com.transsnet.downloader.manager.a
    public Object a(String str, int i11, String str2, Continuation<? super String> continuation) {
        return kotlinx.coroutines.h.g(w0.b(), new DownloadManagerImpl$transformDownloadPlayUrl$3(str, i11, str2, this, null), continuation);
    }

    @Override // com.transsnet.downloader.core.task.b
    public void b(DownloadBean downloadInfo) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        I0(downloadInfo);
        ConcurrentHashMap<String, DownloadBean> concurrentHashMap = this.f61028i;
        String resourceId = downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = downloadInfo.getUrl();
        }
        concurrentHashMap.remove(resourceId);
        ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap2 = this.f61021b;
        String resourceId2 = downloadInfo.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadInfo.getUrl();
        }
        concurrentHashMap2.remove(resourceId2);
        ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap3 = this.f61027h;
        String resourceId3 = downloadInfo.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadInfo.getUrl();
        }
        concurrentHashMap3.remove(resourceId3);
        boolean zRemove = this.f61022c.remove(downloadInfo);
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, this.f61020a, "remove index " + zRemove, false, 4, null);
        Set<String> set = this.f61033n;
        String resourceId4 = downloadInfo.getResourceId();
        if (resourceId4 == null) {
            resourceId4 = downloadInfo.getUrl();
        }
        set.add(resourceId4);
        Set<String> set2 = this.f61030k;
        String resourceId5 = downloadInfo.getResourceId();
        if (resourceId5 == null) {
            resourceId5 = downloadInfo.getUrl();
        }
        set2.remove(resourceId5);
        DownloadStatusIconManager.f61047h.a().s(false);
        Set<String> set3 = this.f61031l;
        String resourceId6 = downloadInfo.getResourceId();
        if (resourceId6 == null) {
            resourceId6 = downloadInfo.getUrl();
        }
        set3.remove(resourceId6);
        aVar.n(DownloadBaseRunnable.TAG, new String[]{"onDownloadSuccess, name = " + downloadInfo.getName() + " subjectId=" + downloadInfo.getSubjectId() + " resourceId=" + downloadInfo.getResourceId() + ", status = " + downloadInfo.getStatus() + " "}, true);
        Iterator<T> it = this.f61037r.iterator();
        while (it.hasNext()) {
            ((j) it.next()).b(downloadInfo);
        }
        H0();
        z0();
    }

    @Override // com.transsnet.downloader.core.task.b
    public void c(DownloadBean downloadInfo, boolean z11) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        Iterator<T> it = this.f61037r.iterator();
        while (it.hasNext()) {
            ((j) it.next()).c(downloadInfo, z11);
        }
    }

    @Override // com.transsnet.downloader.manager.a
    public void d() {
        w0();
    }

    @Override // com.transsnet.downloader.manager.a
    public Object e(String str, Continuation<? super List<? extends DownloadBean>> continuation) {
        return DownloadEsHelper.f60994m.a().j(str, continuation);
    }

    @Override // com.transsnet.downloader.manager.a
    public void f(tr.g listener) {
        Intrinsics.g(listener, "listener");
        this.f61036q.add(listener);
    }

    public final void f0(DownloadBean downloadBean) {
        DownloadNotificationUtils.f61068a.l(downloadBean);
    }

    @Override // com.transsnet.downloader.core.task.b
    public void g(DownloadBean downloadInfo) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        Set<String> set = this.f61030k;
        String resourceId = downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = downloadInfo.getUrl();
        }
        set.remove(resourceId);
        Set<String> set2 = this.f61032m;
        String resourceId2 = downloadInfo.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadInfo.getUrl();
        }
        set2.remove(resourceId2);
        x0(downloadInfo);
    }

    public final com.transsnet.downloader.core.task.a g0(Config config, com.transsnet.downloader.core.a aVar, DownloadBean downloadBean) {
        return DownloadTaskUtil.f60483a.e() ? new DownloadTaskImpl2(aVar, this.f61039t, downloadBean, config, this) : new DownloadTaskImpl(aVar, this.f61039t, downloadBean, config, this);
    }

    @Override // com.transsnet.downloader.manager.a
    public String h(DownloadBean bean) {
        Intrinsics.g(bean, "bean");
        return this.f61039t.f(bean);
    }

    public final void h0(DownloadBean downloadBean, boolean z11, Function1<? super Boolean, Unit> function1) {
        kotlinx.coroutines.j.d(this.f61041v, null, null, new DownloadManagerImpl$deleteItem$1(downloadBean, this, function1, null), 3, null);
    }

    @Override // com.transsnet.downloader.manager.a
    public boolean i() {
        return !this.f61021b.isEmpty();
    }

    public final rr.a i0() {
        return (rr.a) this.f61034o.getValue();
    }

    @Override // com.transsnet.downloader.manager.a
    public void j(DownloadBean downloadInfo) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        if (ThreadUtils.i()) {
            L0(downloadInfo);
        } else {
            kotlinx.coroutines.j.d(this.f61040u, null, null, new DownloadManagerImpl$waitDownloadingAndStartNewTask$1(this, downloadInfo, null), 3, null);
        }
    }

    public final String j0() {
        return DownloadManagerImpl.class.getSimpleName();
    }

    @Override // com.transsnet.downloader.manager.a
    public void k(final DownloadBean downloadInfo, final Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        final String path = downloadInfo.getPath();
        h0(downloadInfo, true, new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.manager.DownloadManagerImpl$remove$1

            /* JADX INFO: renamed from: com.transsnet.downloader.manager.DownloadManagerImpl$remove$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$remove$1$1", f = "DownloadManagerImpl.kt", l = {}, m = "invokeSuspend")
            @SourceDebugExtension
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                final /* synthetic */ DownloadBean $downloadInfo;
                final /* synthetic */ String $path;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(String str, DownloadBean downloadBean, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$path = str;
                    this.$downloadInfo = downloadBean;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$path, this.$downloadInfo, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    kotlin.coroutines.intrinsics.a.e();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    String str = this.$path;
                    if (str != null) {
                        int rootPathType = this.$downloadInfo.getRootPathType();
                        if (rootPathType != 2) {
                            if (rootPathType == 3 && Build.VERSION.SDK_INT >= 29) {
                                com.transsnet.downloader.e eVar = com.transsnet.downloader.e.f60605a;
                                Application applicationA = Utils.a();
                                Intrinsics.f(applicationA, "getApp()");
                                eVar.d(applicationA, str);
                            }
                        } else if (Build.VERSION.SDK_INT >= 29) {
                            com.transsnet.downloader.e eVar2 = com.transsnet.downloader.e.f60605a;
                            Application applicationA2 = Utils.a();
                            Intrinsics.f(applicationA2, "getApp()");
                            eVar2.e(applicationA2, str);
                        }
                        if (l.L(str, AppLovinEventTypes.USER_VIEWED_CONTENT, false, 2, null)) {
                            l3.a aVarG = l3.a.g(Utils.a(), Uri.parse(str));
                            if (aVarG != null) {
                                Boxing.a(aVarG.d());
                            }
                        } else {
                            Boxing.a(new File(str).delete());
                        }
                    }
                    Iterator<T> it = this.$downloadInfo.getSubtitleList().iterator();
                    while (it.hasNext()) {
                        File file = new File(String.valueOf(((SubtitleBean) it.next()).getPath()));
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    return Unit.f68710a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                this.this$0.B0(downloadInfo);
                ConcurrentHashMap concurrentHashMap = this.this$0.f61021b;
                String resourceId = downloadInfo.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadInfo.getUrl();
                }
                concurrentHashMap.remove(resourceId);
                ConcurrentHashMap concurrentHashMap2 = this.this$0.f61028i;
                String resourceId2 = downloadInfo.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadInfo.getUrl();
                }
                concurrentHashMap2.remove(resourceId2);
                ConcurrentHashMap concurrentHashMap3 = this.this$0.f61027h;
                String resourceId3 = downloadInfo.getResourceId();
                if (resourceId3 == null) {
                    resourceId3 = downloadInfo.getUrl();
                }
                concurrentHashMap3.remove(resourceId3);
                for (DownloadBean downloadBean : this.this$0.f61022c) {
                    if (Intrinsics.b(downloadBean.getResourceId(), downloadInfo.getResourceId())) {
                        this.this$0.f61022c.remove(downloadBean);
                        uo.b.a.f(uo.b.f78622a, this.this$0.f61020a, "remove ~~", false, 4, null);
                        break;
                    }
                }
                com.transsnet.downloader.core.a aVar = this.this$0.f61023d;
                if (aVar != null) {
                    aVar.a(downloadInfo);
                }
                kotlinx.coroutines.j.d(this.this$0.f61041v, null, null, new AnonymousClass1(path, downloadInfo, null), 3, null);
                this.this$0.z0();
                f00.d dVar = new f00.d(true, false);
                AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
                FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
                String name = f00.d.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, dVar, 0L);
                f00.a aVar2 = new f00.a();
                FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
                String name2 = f00.a.class.getName();
                Intrinsics.f(name2, "T::class.java.name");
                flowEventBus2.postEvent(name2, aVar2, 0L);
                if (z11) {
                    this.this$0.o0(downloadInfo.getSubjectId() + downloadInfo.getSe() + downloadInfo.getEp());
                }
                Function1<Boolean, Unit> function2 = function1;
                if (function2 != null) {
                    function2.invoke(Boolean.valueOf(z11));
                }
            }
        });
    }

    public Object k0(Continuation<? super List<? extends DownloadBean>> continuation) {
        return DownloadEsHelper.f60994m.a().t(continuation);
    }

    @Override // com.transsnet.downloader.manager.a
    public void l(Config config) {
        Intrinsics.g(config, "config");
        Config config2 = this.f61024e;
        if (config2 == null || config2 == null || config2.a() != config.a()) {
            if (config.a() > 1 && this.f61021b.size() < config.a()) {
                for (DownloadBean downloadBean : this.f61022c) {
                    if (!downloadBean.isDownloading() && downloadBean.getStatus() != 4 && config.a() - this.f61021b.size() > 0) {
                        uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{j0() + " --> set new config, start other task, task:" + config.a() + ", cur:" + this.f61021b.size() + " "}, true);
                        p(downloadBean);
                    }
                }
            } else if (this.f61021b.size() > 1 && this.f61021b.size() > config.a()) {
                for (int size = this.f61022c.size() - 1; size > 0; size--) {
                    DownloadBean downloadBean2 = this.f61022c.get(size);
                    if (downloadBean2.isDownloading() && config.a() <= this.f61021b.size()) {
                        s0(downloadBean2, false);
                        uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{j0() + " --> set new config, pause task, task:" + config.a() + ", cur:" + this.f61021b.size() + " "}, true);
                    }
                }
            }
        }
        this.f61024e = config;
    }

    public final IPostDetailApi l0() {
        return (IPostDetailApi) this.f61043x.getValue();
    }

    @Override // com.transsnet.downloader.manager.a
    public void m(g00.b listener) {
        Intrinsics.g(listener, "listener");
        this.f61035p.setWaitCount(this.f61030k.size());
        this.f61035p.setLoadingCount(this.f61031l.size());
        this.f61035p.setErrorCount(this.f61032m.size());
        this.f61035p.setDoneCount(this.f61033n.size());
        listener.a(this.f61035p);
        this.f61029j = listener;
    }

    public final h m0() {
        return (h) this.f61042w.getValue();
    }

    @Override // com.transsnet.downloader.manager.a
    public void n() {
        r0(false);
    }

    public final i00.a n0() {
        return (i00.a) this.f61038s.getValue();
    }

    @Override // com.transsnet.downloader.manager.a
    public void o() {
        this.f61039t.h();
    }

    public final void o0(String str) {
        l0().l1(str);
    }

    @Override // com.transsnet.downloader.manager.a
    public void p(DownloadBean downloadInfo) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        uo.b.a aVar = uo.b.f78622a;
        aVar.c(DownloadBaseRunnable.TAG, j0() + " --> download() --> downloadInfo = " + downloadInfo, false);
        if (z(downloadInfo)) {
            uo.b.a.f(aVar, DownloadBaseRunnable.TAG, j0() + " --> download() --> 任务已存在", false, 4, null);
            return;
        }
        DownloadEsHelper.f60994m.a().d();
        if (!this.f61022c.contains(downloadInfo)) {
            this.f61022c.add(downloadInfo);
        }
        aVar.n(DownloadBaseRunnable.TAG, new String[]{j0() + " --> download() -->, 添加新的任务 -- name = " + downloadInfo.getName() + " "}, true);
        x0(downloadInfo);
    }

    public final boolean p0() {
        String key;
        int size = this.f61021b.size();
        Config config = this.f61024e;
        boolean zIsDownloading = false;
        if (size >= (config != null ? config.a() : 2)) {
            Iterator<Map.Entry<String, com.transsnet.downloader.core.task.a>> it = this.f61021b.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, com.transsnet.downloader.core.task.a> next = it.next();
                key = next.getKey();
                DownloadBean downloadBeanB = next.getValue().b();
                uo.b.a.f(uo.b.f78622a, this.f61020a, "curTask, name = " + downloadBeanB.getTotalTitleName() + ",status = " + downloadBeanB.getStatus(), false, 4, null);
                zIsDownloading = downloadBeanB.isDownloading();
            } else {
                key = "";
            }
            if (!zIsDownloading && key.length() > 0) {
                this.f61021b.remove(key);
            }
        }
        return zIsDownloading;
    }

    @Override // com.transsnet.downloader.manager.a
    public void q() {
        this.f61039t.b();
    }

    public final boolean q0() {
        if (SystemClock.elapsedRealtime() - this.f61025f <= 500) {
            return false;
        }
        this.f61025f = SystemClock.elapsedRealtime();
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, com.transsion.baselib.db.download.DownloadBean, java.lang.Object] */
    @Override // com.transsnet.downloader.manager.a
    public void r(String str, Function1<? super DownloadBean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        for (DownloadBean downloadBean : this.f61022c) {
            if (TextUtils.equals(downloadBean.getResourceId(), str)) {
                objectRef.element = downloadBean;
                callback.invoke(downloadBean);
                break;
            }
        }
        if (objectRef.element == 0) {
            kotlinx.coroutines.j.d(this.f61040u, null, null, new DownloadManagerImpl$getDownloadByResId$2(objectRef, str, callback, this, null), 3, null);
        }
    }

    public final void r0(boolean z11) {
        uo.b.a aVar = uo.b.f78622a;
        aVar.c(this.f61020a, "isAutoPause, isAutoPause:" + z11, true);
        if (q0()) {
            aVar.c(DownloadBaseRunnable.TAG, "pauseAll, " + z11, true);
            for (DownloadBean downloadBean : this.f61022c) {
                if (!z11) {
                    s0(downloadBean, false);
                } else if (downloadBean.getStatus() != 4) {
                    uo.b.f78622a.c(DownloadBaseRunnable.TAG, "pauseAll, pauseInner:" + downloadBean.getTotalTitleName(), true);
                    downloadBean.setAutoPause(true);
                    s0(downloadBean, false);
                }
            }
        }
    }

    @Override // com.transsnet.downloader.manager.a
    public void s(DownloadBean downloadInfo, boolean z11) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        if (q0() || z11) {
            if (!this.f61022c.contains(downloadInfo)) {
                this.f61022c.add(downloadInfo);
            }
            uo.b.f78622a.c(this.f61020a, "resume, name = " + downloadInfo.getTotalTitleName() + ", cur status = " + downloadInfo.getStatus() + ", " + downloadInfo, true);
            Set<String> set = this.f61030k;
            String resourceId = downloadInfo.getResourceId();
            if (resourceId == null) {
                resourceId = downloadInfo.getUrl();
            }
            set.remove(resourceId);
            Set<String> set2 = this.f61032m;
            String resourceId2 = downloadInfo.getResourceId();
            if (resourceId2 == null) {
                resourceId2 = downloadInfo.getUrl();
            }
            set2.remove(resourceId2);
            x0(downloadInfo);
        }
    }

    public final void s0(DownloadBean downloadBean, boolean z11) {
        DownloadBean next;
        downloadBean.setPreDownload(false);
        Iterator<DownloadBean> it = this.f61022c.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(next.getResourceId(), downloadBean.getResourceId()));
        if (next == null) {
            this.f61022c.add(downloadBean);
            next = downloadBean;
        }
        com.transsnet.downloader.core.task.a aVar = this.f61021b.get(downloadBean.getResourceId());
        if (aVar != null && !Intrinsics.b(aVar.b(), next)) {
            uo.b.f78622a.c(this.f61020a, "------pause, name: " + next.getTotalTitleName() + ", info:" + aVar.b(), true);
            aVar.b().setStatus(4);
        }
        Set<String> set = this.f61031l;
        String resourceId = next.getResourceId();
        if (resourceId == null) {
            resourceId = next.getUrl();
        }
        set.remove(resourceId);
        Set<String> set2 = this.f61032m;
        String resourceId2 = next.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = next.getUrl();
        }
        set2.remove(resourceId2);
        Set<String> set3 = this.f61030k;
        String resourceId3 = next.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = next.getUrl();
        }
        set3.add(resourceId3);
        uo.b.f78622a.c(this.f61020a, "pause, name: " + next.getTotalTitleName() + ", downloadNext:" + z11 + "， info:" + next, true);
        H0();
        next.setStatus(4);
        ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap = this.f61021b;
        String resourceId4 = next.getResourceId();
        if (resourceId4 == null) {
            resourceId4 = next.getUrl();
        }
        concurrentHashMap.remove(resourceId4);
        ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap2 = this.f61027h;
        String resourceId5 = next.getResourceId();
        if (resourceId5 == null) {
            resourceId5 = next.getUrl();
        }
        concurrentHashMap2.remove(resourceId5);
        ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = this.f61028i;
        String resourceId6 = next.getResourceId();
        if (resourceId6 == null) {
            resourceId6 = next.getUrl();
        }
        concurrentHashMap3.remove(resourceId6);
        com.transsnet.downloader.core.a aVar2 = this.f61023d;
        if (aVar2 != null) {
            aVar2.a(next);
        }
        if (z11) {
            z0();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.transsnet.downloader.manager.a
    public Object t(String str, int i11, int i12, Continuation<? super DownloadBean> continuation) throws Throwable {
        DownloadManagerImpl$getDownloadedPlayBean$1 downloadManagerImpl$getDownloadedPlayBean$1;
        DownloadBean downloadBeanF;
        String path;
        if (continuation instanceof DownloadManagerImpl$getDownloadedPlayBean$1) {
            downloadManagerImpl$getDownloadedPlayBean$1 = (DownloadManagerImpl$getDownloadedPlayBean$1) continuation;
            int i13 = downloadManagerImpl$getDownloadedPlayBean$1.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                downloadManagerImpl$getDownloadedPlayBean$1.label = i13 - Integer.MIN_VALUE;
            } else {
                downloadManagerImpl$getDownloadedPlayBean$1 = new DownloadManagerImpl$getDownloadedPlayBean$1(this, continuation);
            }
        } else {
            downloadManagerImpl$getDownloadedPlayBean$1 = new DownloadManagerImpl$getDownloadedPlayBean$1(this, continuation);
        }
        Object objE = downloadManagerImpl$getDownloadedPlayBean$1.result;
        Object objE2 = kotlin.coroutines.intrinsics.a.e();
        int i14 = downloadManagerImpl$getDownloadedPlayBean$1.label;
        if (i14 == 0) {
            ResultKt.b(objE);
            DownloadEsHelper.a aVar = DownloadEsHelper.f60994m;
            downloadBeanF = aVar.a().F(str, i11, i12);
            if (downloadBeanF == null) {
                DownloadEsHelper downloadEsHelperA = aVar.a();
                downloadManagerImpl$getDownloadedPlayBean$1.label = 1;
                objE = downloadEsHelperA.E(str, i11, i12, downloadManagerImpl$getDownloadedPlayBean$1);
                if (objE == objE2) {
                    return objE2;
                }
            }
            if (downloadBeanF != null || !downloadBeanF.isCompleted() || (path = downloadBeanF.getPath()) == null || path.length() <= 0) {
                return null;
            }
            return downloadBeanF;
        }
        if (i14 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(objE);
        downloadBeanF = (DownloadBean) objE;
        if (downloadBeanF != null) {
        }
        return null;
    }

    @Override // com.transsnet.downloader.manager.a
    public void u(DownloadBean downloadInfo) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        downloadInfo.setPreDownload(false);
        ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap = this.f61021b;
        String resourceId = downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = downloadInfo.getUrl();
        }
        concurrentHashMap.remove(resourceId);
        com.transsnet.downloader.core.a aVar = this.f61023d;
        if (aVar != null) {
            aVar.a(downloadInfo);
        }
        ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = this.f61028i;
        String resourceId2 = downloadInfo.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadInfo.getUrl();
        }
        concurrentHashMap2.remove(resourceId2);
        ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap3 = this.f61027h;
        String resourceId3 = downloadInfo.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadInfo.getUrl();
        }
        concurrentHashMap3.remove(resourceId3);
        if (DownloadUtil.f61136a.x(downloadInfo)) {
            D0(downloadInfo);
            return;
        }
        Set<String> set = this.f61032m;
        String resourceId4 = downloadInfo.getResourceId();
        if (resourceId4 == null) {
            resourceId4 = downloadInfo.getUrl();
        }
        set.add(resourceId4);
        Set<String> set2 = this.f61031l;
        String resourceId5 = downloadInfo.getResourceId();
        if (resourceId5 == null) {
            resourceId5 = downloadInfo.getUrl();
        }
        set2.remove(resourceId5);
        uo.b.f78622a.h(DownloadBaseRunnable.TAG, "Download Failed, name = " + downloadInfo.getName() + ", resourceId = " + downloadInfo.getResourceId() + "，subjectId = " + downloadInfo.getSubjectId() + "，remove from loading, add to error， loading  = " + this.f61031l.size() + ", error  = " + this.f61032m.size() + " , wait  = " + this.f61030k.size() + " ", true);
        H0();
        z0();
    }

    public final void u0(DownloadBean downloadBean) {
        if (!this.f61027h.isEmpty()) {
            for (Map.Entry<String, com.transsnet.downloader.core.task.a> entry : this.f61027h.entrySet()) {
                String key = entry.getKey();
                DownloadBean downloadBeanB = entry.getValue().b();
                uo.b.f78622a.c(DownloadBaseRunnable.TAG, "pause current preDownload, add to pool, name = " + downloadBeanB.getTotalTitleName() + "，HashCode = " + System.identityHashCode(downloadBean) + " ", true);
                this.f61028i.put(key, downloadBeanB);
                if (!Intrinsics.b(downloadBeanB.getResourceId(), downloadBean != null ? downloadBean.getResourceId() : null)) {
                    downloadBeanB.setStatus(3);
                }
                this.f61027h.remove(key);
            }
        }
    }

    @Override // com.transsnet.downloader.manager.a
    public void v(tr.g listener) {
        Intrinsics.g(listener, "listener");
        if (this.f61036q.contains(listener)) {
            this.f61036q.remove(listener);
        }
    }

    public final boolean v0(DownloadBean downloadBean) {
        com.transsnet.downloader.core.a aVar;
        if (z(downloadBean) || downloadBean.isDownloading()) {
            uo.b.f78622a.n(this.f61020a, new String[]{"preDownload, isDownloading name = " + downloadBean.getName() + " "}, true);
            return false;
        }
        if (f.f49475a.e() && downloadBean.isVideo()) {
            Long size = downloadBean.getSize();
            if ((size != null ? size.longValue() : 0L) >= 52428800) {
                if (downloadBean.getProgress() >= 5242880) {
                    uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"preDownload, is downloaded do nothing, name = " + downloadBean.getTotalTitleName()}, true);
                    return false;
                }
                if (this.f61027h.size() > 0) {
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap = this.f61028i;
                    String resourceId = downloadBean.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean.getUrl();
                    }
                    concurrentHashMap.put(resourceId, downloadBean);
                    uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"preDownload, 当前已有任务在预下载，加入等待队列, name = " + downloadBean.getTotalTitleName()}, true);
                    return false;
                }
                u0(downloadBean);
                downloadBean.setPreDownload(true);
                ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = this.f61028i;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                concurrentHashMap2.remove(resourceId2);
                Config config = this.f61024e;
                com.transsnet.downloader.core.task.a aVarG0 = null;
                if (config != null && (aVar = this.f61023d) != null) {
                    aVarG0 = g0(config, aVar, downloadBean);
                }
                uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"start preDownload, name = " + downloadBean.getTotalTitleName()}, true);
                if (aVarG0 != null) {
                    ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap3 = this.f61027h;
                    String resourceId3 = downloadBean.getResourceId();
                    if (resourceId3 == null) {
                        resourceId3 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.put(resourceId3, aVarG0);
                }
                downloadBean.setStatus(1);
                com.transsnet.downloader.core.a aVar2 = this.f61023d;
                if (aVar2 != null) {
                    aVar2.a(downloadBean);
                }
                if (aVarG0 != null) {
                    aVarG0.start();
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.transsnet.downloader.manager.a
    public void w() {
        E0(false);
    }

    public final void w0() {
        if (f.f49475a.e()) {
            uo.b.a.f(uo.b.f78622a, this.f61020a, "preDownloadNextTask, pool size = " + this.f61028i.size(), false, 4, null);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, DownloadBean> entry : this.f61028i.entrySet()) {
                String key = entry.getKey();
                DownloadBean value = entry.getValue();
                if (value.getProgress() < 5242880) {
                    if (value.getStatus() == 6) {
                        if (value.getErrorCount() < 3) {
                            value.setErrorCount(value.getErrorCount() + 1);
                        }
                    }
                    uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"preDownloadNextTask, try start, name = " + value.getTotalTitleName()}, true);
                    v0(value);
                    break;
                }
                uo.b.a.f(uo.b.f78622a, this.f61020a, "preDownloadNextTask, is downloaded do nothing, name = " + value.getName(), false, 4, null);
                arrayList.add(key);
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f61028i.remove((String) it.next());
                }
            }
        }
    }

    @Override // com.transsnet.downloader.manager.a
    public Long x() {
        Iterator<DownloadBean> it = this.f61022c.iterator();
        long progress = 0;
        while (it.hasNext()) {
            progress += it.next().getProgress();
        }
        return Long.valueOf(progress);
    }

    public final void x0(DownloadBean downloadBean) {
        if (ThreadUtils.i()) {
            y0(downloadBean);
        } else {
            kotlinx.coroutines.j.d(this.f61040u, null, null, new DownloadManagerImpl$prepareDownload$1(this, downloadBean, null), 3, null);
        }
    }

    @Override // com.transsnet.downloader.manager.a
    public void y(List<? extends DownloadBean> list, final Function1<? super Boolean, Unit> function1) {
        uo.b.a.f(uo.b.f78622a, this.f61020a, "remove list ,size = " + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
        if (list != null) {
            C0(list, 0, new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.manager.DownloadManagerImpl$remove$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    Function1<Boolean, Unit> function2 = function1;
                    if (function2 != null) {
                        function2.invoke(Boolean.valueOf(z11));
                    }
                    uo.b.a.f(uo.b.f78622a, this.f61020a, "remove success ,prepareDownloadNextTask", false, 4, null);
                    this.H0();
                    this.z0();
                }
            });
        }
    }

    public final void y0(DownloadBean downloadBean) {
        com.transsnet.downloader.core.a aVar;
        uo.b.a aVar2 = uo.b.f78622a;
        aVar2.c(DownloadBaseRunnable.TAG, j0() + " --> prepareDownloadNext() --> 2- prepareDownload,name = " + downloadBean.getTotalTitleName() + ",resourceId = " + downloadBean.getResourceId() + "，subjectId = " + downloadBean.getSubjectId() + ", status = " + downloadBean.getStatus(), true);
        if (downloadBean.getStatus() == 2 || downloadBean.getStatus() == 1) {
            uo.b.a.f(aVar2, DownloadBaseRunnable.TAG, j0() + " --> prepareDownloadNext() --> prepareDownload, status-- name = " + downloadBean.getName() + " ", false, 4, null);
            if (downloadBean.isPreDownload()) {
                downloadBean.setPreDownload(false);
                uo.b.a.f(aVar2, DownloadBaseRunnable.TAG, j0() + " --> prepareDownloadNext() --> preDownload 预下载转正变成当前下载 = " + downloadBean.getName() + " , epse = " + downloadBean.getEpse(), false, 4, null);
                ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap = this.f61027h;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                com.transsnet.downloader.core.task.a aVar3 = concurrentHashMap.get(resourceId);
                Set<String> set = this.f61030k;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                set.remove(resourceId2);
                Set<String> set2 = this.f61032m;
                String resourceId3 = downloadBean.getResourceId();
                if (resourceId3 == null) {
                    resourceId3 = downloadBean.getUrl();
                }
                set2.remove(resourceId3);
                Set<String> set3 = this.f61031l;
                String resourceId4 = downloadBean.getResourceId();
                if (resourceId4 == null) {
                    resourceId4 = downloadBean.getUrl();
                }
                set3.add(resourceId4);
                downloadBean.setStatus(2);
                com.transsnet.downloader.core.a aVar4 = this.f61023d;
                if (aVar4 != null) {
                    aVar4.a(downloadBean);
                }
                H0();
                if (aVar3 != null) {
                    G0();
                    ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap2 = this.f61021b;
                    String resourceId5 = downloadBean.getResourceId();
                    if (resourceId5 == null) {
                        resourceId5 = downloadBean.getUrl();
                    }
                    concurrentHashMap2.put(resourceId5, aVar3);
                    ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap3 = this.f61027h;
                    String resourceId6 = downloadBean.getResourceId();
                    if (resourceId6 == null) {
                        resourceId6 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.remove(resourceId6);
                }
            }
            if (f.f49475a.e()) {
                return;
            }
            aVar2.n(DownloadBaseRunnable.TAG, new String[]{j0() + " --> prepareDownloadNext() --> not net， 2 error"}, true);
            downloadBean.setStatus(6);
            downloadBean.setException(new DownloadException(9, DownloadException.EXCEPTION_MESSAGE_NO_NET));
            u(downloadBean);
            return;
        }
        downloadBean.setPreDownload(false);
        ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap4 = this.f61021b;
        String resourceId7 = downloadBean.getResourceId();
        if (resourceId7 == null) {
            resourceId7 = downloadBean.getUrl();
        }
        if (concurrentHashMap4.containsKey(resourceId7)) {
            if (downloadBean.isDownloading()) {
                aVar2.n(DownloadBaseRunnable.TAG, new String[]{j0() + " --> prepareDownloadNext() --> prepareDownload, isDownloading name = " + downloadBean.getName()}, true);
                return;
            }
            ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap5 = this.f61021b;
            String resourceId8 = downloadBean.getResourceId();
            if (resourceId8 == null) {
                resourceId8 = downloadBean.getUrl();
            }
            concurrentHashMap5.remove(resourceId8);
            uo.b.a.f(aVar2, DownloadBaseRunnable.TAG, j0() + " --> prepareDownloadNext() --> prepareDownload, isDownloading, error status , remove  name = " + downloadBean.getName(), false, 4, null);
        }
        if (p0()) {
            if (!v0(downloadBean)) {
                downloadBean.setStatus(3);
                com.transsnet.downloader.core.a aVar5 = this.f61023d;
                if (aVar5 != null) {
                    aVar5.a(downloadBean);
                }
            }
            Set<String> set4 = this.f61030k;
            String resourceId9 = downloadBean.getResourceId();
            if (resourceId9 == null) {
                resourceId9 = downloadBean.getUrl();
            }
            set4.add(resourceId9);
            aVar2.c(DownloadBaseRunnable.TAG, j0() + " --> prepareDownloadNext() --> 1--prepareDownload, name = " + downloadBean.getName() + ", add wait, status = " + downloadBean.getStatus() + ",loading  = " + this.f61031l.size() + ", error  = " + this.f61032m.size() + " , wait  = " + this.f61030k.size() + " ", true);
            H0();
            return;
        }
        ConcurrentHashMap<String, DownloadBean> concurrentHashMap6 = this.f61028i;
        String resourceId10 = downloadBean.getResourceId();
        if (resourceId10 == null) {
            resourceId10 = downloadBean.getUrl();
        }
        concurrentHashMap6.remove(resourceId10);
        ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap7 = this.f61027h;
        String resourceId11 = downloadBean.getResourceId();
        if (resourceId11 == null) {
            resourceId11 = downloadBean.getUrl();
        }
        concurrentHashMap7.remove(resourceId11);
        if (this.f61027h.isEmpty() && (!this.f61028i.isEmpty())) {
            w0();
        }
        Config config = this.f61024e;
        com.transsnet.downloader.core.task.a aVarG0 = null;
        if (config != null && (aVar = this.f61023d) != null) {
            aVarG0 = g0(config, aVar, downloadBean);
        }
        com.transsnet.downloader.core.task.a aVar6 = aVarG0;
        if (aVar6 != null) {
            ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap8 = this.f61021b;
            String resourceId12 = downloadBean.getResourceId();
            if (resourceId12 == null) {
                resourceId12 = downloadBean.getUrl();
            }
            concurrentHashMap8.put(resourceId12, aVar6);
        }
        downloadBean.setStatus(1);
        com.transsnet.downloader.core.a aVar7 = this.f61023d;
        if (aVar7 != null) {
            aVar7.a(downloadBean);
        }
        f0(downloadBean);
        Set<String> set5 = this.f61030k;
        String resourceId13 = downloadBean.getResourceId();
        if (resourceId13 == null) {
            resourceId13 = downloadBean.getUrl();
        }
        set5.remove(resourceId13);
        Set<String> set6 = this.f61032m;
        String resourceId14 = downloadBean.getResourceId();
        if (resourceId14 == null) {
            resourceId14 = downloadBean.getUrl();
        }
        set6.remove(resourceId14);
        Set<String> set7 = this.f61031l;
        String resourceId15 = downloadBean.getResourceId();
        if (resourceId15 == null) {
            resourceId15 = downloadBean.getUrl();
        }
        set7.add(resourceId15);
        uo.b.a.s(aVar2, DownloadBaseRunnable.TAG, j0() + " --> prepareDownloadNext() --> 1--prepareDownload, name = " + downloadBean.getName() + ", add loading, loading  = " + this.f61031l.size() + ", error  = " + this.f61032m.size() + " , wait  = " + this.f61030k.size() + " ", false, 4, null);
        H0();
        if (aVar6 != null) {
            aVar6.start();
        }
    }

    @Override // com.transsnet.downloader.manager.a
    public boolean z(DownloadBean downloadInfo) {
        Intrinsics.g(downloadInfo, "downloadInfo");
        ConcurrentHashMap<String, com.transsnet.downloader.core.task.a> concurrentHashMap = this.f61021b;
        String resourceId = downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = downloadInfo.getUrl();
        }
        return concurrentHashMap.containsKey(resourceId);
    }

    public final void z0() {
        for (DownloadBean downloadBean : this.f61022c) {
            if (downloadBean.getStatus() == 3 || downloadBean.getStatus() == 6 || (downloadBean.isDownloading() && downloadBean.isPreDownload())) {
                if (downloadBean.getStatus() == 6) {
                    if (!f.f49475a.e() || downloadBean.isNoNetError()) {
                        uo.b.a.f(uo.b.f78622a, this.f61020a, "prepareDownloadNextTask, no net，continue, name = " + downloadBean.getName(), false, 4, null);
                    } else if (downloadBean.getErrorCount() >= 3) {
                        uo.b.f78622a.c(DownloadBaseRunnable.TAG, "prepareDownloadNextTask, 失败超限~不再执行，name = " + downloadBean.getName(), true);
                    } else {
                        downloadBean.setErrorCount(downloadBean.getErrorCount() + 1);
                    }
                }
                uo.b.f78622a.c(DownloadBaseRunnable.TAG, "prepareDownloadNextTask, name = " + downloadBean.getName() + ", from next, status: " + downloadBean.getStatus() + ",isPreDownload:" + downloadBean.isPreDownload() + ", progress: " + downloadBean.getProgress() + ",size:" + downloadBean.getSize(), true);
                Set<String> set = this.f61030k;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                set.remove(resourceId);
                Set<String> set2 = this.f61032m;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                set2.remove(resourceId2);
                x0(downloadBean);
                return;
            }
        }
    }
}
