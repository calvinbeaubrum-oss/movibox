package com.transsion.subtitle;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.subtitle.helper.SubtitleSearchHelper;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.k;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import tr.m;

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
public final class VideoSubtitleManagerImp implements VideoSubtitleManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f58112g = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f58113b = LazyKt__LazyJVMKt.b(new Function0<m>() { // from class: com.transsion.subtitle.VideoSubtitleManagerImp$oldSubtitleDao$2
        @Override // kotlin.jvm.functions.Function0
        public final m invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).M0();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<xx.c> f58114c = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f58115d = VideoSubtitleManagerImp.class.getSimpleName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k0 f58116e = l0.a(w0.c());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VideoSubtitleManagerImp$resDownloadListener$1 f58117f = new VideoSubtitleManagerImp$resDownloadListener$1(this);

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void p(VideoSubtitleManagerImp videoSubtitleManagerImp, DownloadBean downloadBean, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        videoSubtitleManagerImp.o(downloadBean, function1);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.transsion.subtitle.VideoSubtitleManager
    public Object a(String str, Continuation<? super List<vx.a>> continuation) throws Throwable {
        VideoSubtitleManagerImp$getSubtitleList$1 videoSubtitleManagerImp$getSubtitleList$1;
        List list;
        if (continuation instanceof VideoSubtitleManagerImp$getSubtitleList$1) {
            videoSubtitleManagerImp$getSubtitleList$1 = (VideoSubtitleManagerImp$getSubtitleList$1) continuation;
            int i11 = videoSubtitleManagerImp$getSubtitleList$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                videoSubtitleManagerImp$getSubtitleList$1.label = i11 - Integer.MIN_VALUE;
            } else {
                videoSubtitleManagerImp$getSubtitleList$1 = new VideoSubtitleManagerImp$getSubtitleList$1(this, continuation);
            }
        } else {
            videoSubtitleManagerImp$getSubtitleList$1 = new VideoSubtitleManagerImp$getSubtitleList$1(this, continuation);
        }
        Object obj = videoSubtitleManagerImp$getSubtitleList$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = videoSubtitleManagerImp$getSubtitleList$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            ArrayList arrayList = new ArrayList();
            SubtitleDownloadManager subtitleDownloadManager = SubtitleDownloadManager.f58349a;
            videoSubtitleManagerImp$getSubtitleList$1.L$0 = arrayList;
            videoSubtitleManagerImp$getSubtitleList$1.label = 1;
            Object objG = subtitleDownloadManager.g(str, videoSubtitleManagerImp$getSubtitleList$1);
            if (objG == objE) {
                return objE;
            }
            obj = objG;
            list = arrayList;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) videoSubtitleManagerImp$getSubtitleList$1.L$0;
            ResultKt.b(obj);
        }
        List list2 = (List) obj;
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                list.add(new vx.a((SubtitleDownloadTable) it.next()));
            }
        }
        return list;
    }

    @Override // com.transsion.subtitle.VideoSubtitleManager
    public void b(vx.a bean) {
        Intrinsics.g(bean, "bean");
        Iterator<T> it = this.f58114c.iterator();
        while (it.hasNext()) {
            ((xx.c) it.next()).b(bean);
        }
    }

    @Override // com.transsion.subtitle.VideoSubtitleManager
    public void c(DownloadBean bean) {
        Intrinsics.g(bean, "bean");
        uo.b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), this.f58115d + " 打开字幕弹窗检测字幕，subjectId:" + bean.getSubjectId() + " subtitleResId:" + bean.getSubtitleResId(), true);
        p(this, bean, null, 2, null);
    }

    @Override // com.transsion.subtitle.VideoSubtitleManager
    public void d(DownloadBean bean, Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(bean, "bean");
        o(bean, function1);
    }

    @Override // com.transsion.subtitle.VideoSubtitleManager
    public void destroy() {
    }

    @Override // com.transsion.subtitle.VideoSubtitleManager
    public void e(com.transsion.subtitle_download.a listener) {
        Intrinsics.g(listener, "listener");
        SubtitleDownloadManager.f58349a.b(listener);
    }

    @Override // com.transsion.subtitle.VideoSubtitleManager
    public void f(vx.a bean) {
        Intrinsics.g(bean, "bean");
        SubtitleDownloadManager.f58349a.d(bean.b());
    }

    @Override // com.transsion.subtitle.VideoSubtitleManager
    public void g(vx.a bean) {
        Intrinsics.g(bean, "bean");
        SubtitleDownloadManager.f58349a.d(bean.b());
    }

    @Override // com.transsion.subtitle.VideoSubtitleManager
    public void h(xx.c listener) {
        Intrinsics.g(listener, "listener");
        this.f58114c.remove(listener);
    }

    @Override // com.transsion.subtitle.VideoSubtitleManager
    public void i(xx.c listener) {
        Intrinsics.g(listener, "listener");
        this.f58114c.add(listener);
    }

    @Override // com.transsion.subtitle.VideoSubtitleManager
    public void init() {
        SubtitleSearchHelper.f58255c.a().h();
        SubtitleDownloadManager.f58349a.h();
        com.transsnet.downloader.manager.b.f61062a.a(Utils.a()).B(this.f58117f);
        r();
    }

    @Override // com.transsion.subtitle.VideoSubtitleManager
    public void j(com.transsion.subtitle_download.a listener) {
        Intrinsics.g(listener, "listener");
        SubtitleDownloadManager.f58349a.o(listener);
    }

    public final void o(final DownloadBean downloadBean, final Function1<? super Boolean, Unit> function1) {
        if (!downloadBean.isVideo() || downloadBean.isMusic()) {
            return;
        }
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null || resourceId.length() == 0) {
            uo.b.a.f(uo.b.f78622a, com.transsion.baselib.report.a.f51248a.a(), this.f58115d + " checkDownloadSubtitle fail， has no resourceId", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        String resourceId2 = downloadBean.getResourceId();
        if ((resourceId2 != null ? k.n(resourceId2) : null) == null) {
            uo.b.a.u(uo.b.f78622a, com.transsion.baselib.report.a.f51248a.a(), this.f58115d + " checkDownloadSubtitle ,resourceId is abnormal", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        if (!f.f49475a.e()) {
            uo.b.f78622a.t(com.transsion.baselib.report.a.f51248a.a(), this.f58115d + " checkDownloadSubtitle ,无网络不做检测", true);
            return;
        }
        uo.b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), this.f58115d + " checkDownloadSubtitle, name = " + downloadBean.getName() + " subjectId:" + downloadBean.getSubjectId() + " subtitleResId:" + downloadBean.getSubtitleResId(), true);
        SubtitleDownloadManager.f58349a.e(downloadBean.getSubjectId(), downloadBean.getSubtitleResId(), downloadBean.getResourceId(), downloadBean.getSubjectName(), downloadBean.isStream() ? 2 : 1, downloadBean.isStream(), downloadBean.getEpse(), downloadBean.getEp(), downloadBean.getSe(), new Function1<Boolean, Unit>() { // from class: com.transsion.subtitle.VideoSubtitleManagerImp$checkDownloadSubtitle$1

            /* JADX INFO: renamed from: com.transsion.subtitle.VideoSubtitleManagerImp$checkDownloadSubtitle$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.transsion.subtitle.VideoSubtitleManagerImp$checkDownloadSubtitle$1$1", f = "VideoSubtitleManagerImp.kt", l = {}, m = "invokeSuspend")
            @SourceDebugExtension
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                final /* synthetic */ DownloadBean $bean;
                final /* synthetic */ boolean $hasSubtitle;
                final /* synthetic */ Function1<Boolean, Unit> $resultCallback;
                int label;
                final /* synthetic */ VideoSubtitleManagerImp this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass1(Function1<? super Boolean, Unit> function1, boolean z11, VideoSubtitleManagerImp videoSubtitleManagerImp, DownloadBean downloadBean, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$resultCallback = function1;
                    this.$hasSubtitle = z11;
                    this.this$0 = videoSubtitleManagerImp;
                    this.$bean = downloadBean;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$resultCallback, this.$hasSubtitle, this.this$0, this.$bean, continuation);
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
                    Function1<Boolean, Unit> function1 = this.$resultCallback;
                    if (function1 != null) {
                        function1.invoke(Boxing.a(this.$hasSubtitle));
                    }
                    Set set = this.this$0.f58114c;
                    boolean z11 = this.$hasSubtitle;
                    DownloadBean downloadBean = this.$bean;
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        ((xx.c) it.next()).T(z11, downloadBean);
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
                j.d(this.this$0.f58116e, null, null, new AnonymousClass1(function1, z11, this.this$0, downloadBean, null), 3, null);
            }
        });
    }

    public final m q() {
        return (m) this.f58113b.getValue();
    }

    public final void r() {
        if (!RoomAppMMKV.f51271a.a().getBoolean("subtitle_old_db_move", false)) {
            j.d(l0.a(w0.b()), null, null, new VideoSubtitleManagerImp$initOldSubtitleMoveDB$1(this, null), 3, null);
            return;
        }
        uo.b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), this.f58115d + " 转移数据库, 已转移过，不再处理", true);
    }

    @Override // com.transsion.subtitle.VideoSubtitleManager
    public void reset() {
    }
}
