package com.transsnet.downloader;

import android.R;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.m;
import com.transsion.downloadapi.IDownloadApiProvider;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.fragment.DownloadReDetectorMainDialog;
import com.transsnet.downloader.fragment.TransferInnerMainFragment;
import com.transsnet.downloader.manager.DownloadInterceptManager;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.view.DownloadingTipsDialogFragment;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
@Route(path = "/download/provider")
@Metadata
@SourceDebugExtension
public final class DownloadManagerApi implements IDownloadApiProvider {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f60274j = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy<DownloadManagerApi> f60275k = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<DownloadManagerApi>() { // from class: com.transsnet.downloader.DownloadManagerApi$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadManagerApi invoke() {
            Object objH = com.alibaba.android.arouter.launcher.a.d().h(IDownloadApiProvider.class);
            Intrinsics.e(objH, "null cannot be cast to non-null type com.transsnet.downloader.DownloadManagerApi");
            return (DownloadManagerApi) objH;
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DownloadBean f60280e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f60276a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f60277b = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f60278c = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f60279d = LazyKt__LazyJVMKt.b(new Function0<i00.a>() { // from class: com.transsnet.downloader.DownloadManagerApi$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final i00.a invoke() {
            return (i00.a) NetServiceGenerator.f49399d.a().i(i00.a.class);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f60281f = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsnet.downloader.DownloadManagerApi$downloadManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.manager.a invoke() {
            return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f60282g = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsnet.downloader.DownloadManagerApi$mAudioApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IAudioApi invoke() {
            return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f60283h = LazyKt__LazyJVMKt.b(new Function0<IFloatingApi>() { // from class: com.transsnet.downloader.DownloadManagerApi$mFloatApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IFloatingApi invoke() {
            return (IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class);
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f60284i = LazyKt__LazyJVMKt.b(new Function0<rr.a>() { // from class: com.transsnet.downloader.DownloadManagerApi$audioDao$2
        @Override // kotlin.jvm.functions.Function0
        public final rr.a invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).D0();
        }
    });

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadManagerApi a() {
            return (DownloadManagerApi) DownloadManagerApi.f60275k.getValue();
        }
    }

    public static /* synthetic */ void S1(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z11, int i11, boolean z12, int i12, Object obj) {
        downloadManagerApi.Q1(fragmentActivity, subject, str, (i12 & 8) != 0 ? "" : str2, str3, str4, (i12 & 64) != 0 ? "" : str5, (i12 & 128) != 0 ? null : str6, (i12 & 256) != 0 ? null : str7, (i12 & 512) != 0 ? false : z11, (i12 & 1024) != 0 ? 0 : i11, (i12 & 2048) != 0 ? true : z12);
    }

    public static /* synthetic */ void U1(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, DownloadBean downloadBean, String str, String str2, String str3, Subject subject, String str4, int i11, Object obj) {
        downloadManagerApi.T1(fragmentActivity, downloadBean, str, str2, str3, (i11 & 32) != 0 ? null : subject, (i11 & 64) != 0 ? null : str4);
    }

    public static /* synthetic */ void Z1(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        downloadManagerApi.Y1(fragmentActivity, subject, str, str2, str3, str4, (i11 & 64) != 0 ? null : str5, (i11 & 128) != 0 ? null : str6);
    }

    public static /* synthetic */ boolean n2(DownloadManagerApi downloadManagerApi, String str, String str2, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        if ((i11 & 8) != 0) {
            z12 = false;
        }
        return downloadManagerApi.m2(str, str2, z11, z12);
    }

    public static /* synthetic */ void p2(DownloadManagerApi downloadManagerApi, String str, Context context, String str2, String str3, int i11, Object obj) throws InterruptedException {
        if ((i11 & 8) != 0) {
            str3 = null;
        }
        downloadManagerApi.o2(str, context, str2, str3);
    }

    public static final void t2(DownloadBean downloadBean, String str, int i11, FragmentActivity activity) {
        Intrinsics.g(downloadBean, "$downloadBean");
        Intrinsics.g(activity, "$activity");
        downloadBean.setPageFrom(str);
        DownloadingTipsDialogFragment downloadingTipsDialogFragmentA = DownloadingTipsDialogFragment.f61172l.a(i11);
        downloadingTipsDialogFragmentA.J0(downloadBean);
        downloadingTipsDialogFragmentA.j0(activity, "DownloadingTipsDialogFragment");
    }

    public final void O1(final FragmentActivity fragmentActivity, final Subject subject, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, String str7, boolean z11, final int i11, final boolean z12) {
        Integer type;
        final FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "activity.supportFragmentManager");
        final String strF = m.f51277a.f();
        ResourceDetectors resourceDetector = subject.getResourceDetector();
        if (resourceDetector == null || (type = resourceDetector.getType()) == null || type.intValue() != 1) {
            DownloadInterceptManager.f61008a.a().h(fragmentActivity, subject, new Function0<Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$addDownloadListDialogFromSubject$2
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
                    DownloadReDetectorMainDialog downloadReDetectorMainDialogA = DownloadReDetectorMainDialog.f60720w.a(str, strF, subject, str2, str3, str4, str5, str6, i11, z12);
                    downloadReDetectorMainDialogA.show(supportFragmentManager, "download_anima");
                    final DownloadManagerApi downloadManagerApi = this;
                    final FragmentActivity fragmentActivity2 = fragmentActivity;
                    final String str8 = str;
                    downloadReDetectorMainDialogA.v0(new Function4<Integer, String, DownloadBean, Boolean, Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$addDownloadListDialogFromSubject$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str9, DownloadBean downloadBean, Boolean bool) {
                            invoke(num.intValue(), str9, downloadBean, bool.booleanValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(int i12, String formatSize, DownloadBean bean, boolean z13) {
                            Intrinsics.g(formatSize, "formatSize");
                            Intrinsics.g(bean, "bean");
                            downloadManagerApi.s2(fragmentActivity2, i12, formatSize, bean, z13, str8);
                        }
                    });
                }
            });
            return;
        }
        DownloadReDetectorMainDialog downloadReDetectorMainDialogA = DownloadReDetectorMainDialog.f60720w.a(str, strF, subject, str2, str3, str4, str5, str6, i11, z12);
        downloadReDetectorMainDialogA.show(supportFragmentManager, DownloadBaseRunnable.TAG);
        downloadReDetectorMainDialogA.v0(new Function4<Integer, String, DownloadBean, Boolean, Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$addDownloadListDialogFromSubject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str8, DownloadBean downloadBean, Boolean bool) {
                invoke(num.intValue(), str8, downloadBean, bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(int i12, String formatSize, DownloadBean downloadBean, boolean z13) {
                Intrinsics.g(formatSize, "formatSize");
                Intrinsics.g(downloadBean, "downloadBean");
                this.this$0.s2(fragmentActivity, i12, formatSize, downloadBean, z13, str);
                uo.b.a.f(uo.b.f78622a, "downloadAna", "group get success, show anima", false, 4, null);
            }
        });
    }

    public final void P1(FragmentActivity activity, Subject subject, String str, String str2, String str3, String resource, String str4, String str5, String str6, boolean z11) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(resource, "resource");
        S1(this, activity, subject, str, str2, str3, resource, str4, str5, str6, z11, 0, false, 2048, null);
    }

    public final void Q1(FragmentActivity activity, Subject subject, String str, String str2, String str3, String resource, String str4, String str5, String str6, boolean z11, int i11, boolean z12) {
        String string;
        Intrinsics.g(activity, "activity");
        Intrinsics.g(resource, "resource");
        if (subject == null) {
            return;
        }
        com.transsion.baseui.util.c cVar = com.transsion.baseui.util.c.f51452a;
        String subjectId = subject.getSubjectId();
        if (cVar.a(subjectId != null ? subjectId.hashCode() : 9527, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        if (str3 == null || str3.length() == 0) {
            Bundle extras = activity.getIntent().getExtras();
            string = extras != null ? extras.getString("ops") : null;
        } else {
            string = str3;
        }
        if (f.f49475a.e()) {
            O1(activity, subject, str, str2, string, resource, str4, str5, str6, z11, i11, z12);
        } else {
            zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T1(final FragmentActivity activity, final DownloadBean downloadBean, final String str, String str2, final String resource, Subject subject, final String str3) {
        String resourceId;
        Intrinsics.g(activity, "activity");
        Intrinsics.g(resource, "resource");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = str2;
        String str4 = str2;
        if (str4 == null || str4.length() == 0) {
            Bundle extras = activity.getIntent().getExtras();
            objectRef.element = extras != null ? extras.getString("ops") : 0;
        }
        if (com.transsion.baseui.util.c.f51452a.a((downloadBean == null || (resourceId = downloadBean.getResourceId()) == null) ? 9526 : resourceId.hashCode(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        if (!f.f49475a.e()) {
            zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
        } else if (subject != null) {
            DownloadInterceptManager.f61008a.a().h(activity, subject, new Function0<Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$addDownloadWithDialog$1
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
                    final DownloadManagerApi downloadManagerApi = this.this$0;
                    final FragmentActivity fragmentActivity = activity;
                    final DownloadBean downloadBean2 = downloadBean;
                    final String str5 = str;
                    final Ref.ObjectRef<String> objectRef2 = objectRef;
                    final String str6 = resource;
                    final String str7 = str3;
                    downloadManagerApi.X1(fragmentActivity, new Function0<Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$addDownloadWithDialog$1.1
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
                            downloadManagerApi.c2(fragmentActivity, downloadBean2, str5, objectRef2.element, str6, str7);
                        }
                    });
                }
            });
        } else {
            X1(activity, new Function0<Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$addDownloadWithDialog$2
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
                    this.this$0.c2(activity, downloadBean, str, objectRef.element, resource, str3);
                }
            });
        }
    }

    public final void V1(String str, String str2, boolean z11, int i11, boolean z12, boolean z13) throws InterruptedException {
        if (z13 && str != null) {
            this.f60278c.add(str);
        }
        if (z11) {
            if (str2 != null) {
                this.f60276a.add(str2);
                AddToDownloadEvent addToDownloadEvent = new AddToDownloadEvent(null, str2, true, z11);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = AddToDownloadEvent.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, addToDownloadEvent, 0L);
            }
            if (!CollectionsKt___CollectionsKt.X(this.f60277b, str) || z12) {
                i.b(null, new DownloadManagerApi$addPlayAvailable$1(str, i11, this, z12, str2, null), 1, null);
                return;
            }
            return;
        }
        if (str2 != null) {
            this.f60276a.add(str2);
            if (str != null) {
                this.f60277b.add(str);
            }
            if (z12) {
                AddToDownloadEvent addToDownloadEvent2 = new AddToDownloadEvent(str, str2, true, z11);
                FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name2 = AddToDownloadEvent.class.getName();
                Intrinsics.f(name2, "T::class.java.name");
                flowEventBus2.postEvent(name2, addToDownloadEvent2, 0L);
            }
        }
    }

    public final void W1(final FragmentActivity activity, final Subject subject, final String linkUrl, final String str, final String str2, final String resource, final String str3) {
        Bundle extras;
        String subjectId;
        Intrinsics.g(activity, "activity");
        Intrinsics.g(linkUrl, "linkUrl");
        Intrinsics.g(resource, "resource");
        if (com.transsion.baseui.util.c.f51452a.a((subject == null || (subjectId = subject.getSubjectId()) == null) ? 9528 : subjectId.hashCode(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        if ((str2 == null || str2.length() == 0) && (extras = activity.getIntent().getExtras()) != null) {
            extras.getString("ops");
        }
        if (!f.f49475a.e()) {
            zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
        } else if (subject != null) {
            DownloadInterceptManager.f61008a.a().h(activity, subject, new Function0<Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$addUrlDownload$1
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
                    DownloadManagerApi.Z1(this.this$0, activity, subject, linkUrl, str, str2, resource, str3, null, 128, null);
                }
            });
        } else {
            Z1(this, activity, subject, linkUrl, str, str2, resource, str3, null, 128, null);
        }
    }

    public final void X1(FragmentActivity fragmentActivity, Function0<Unit> function0) {
        function0.invoke();
    }

    public final void Y1(final FragmentActivity fragmentActivity, final Subject subject, final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        X1(fragmentActivity, new Function0<Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$checkPermissionAndDownload$1
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
                String strF = m.f51277a.f();
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                Intrinsics.f(supportFragmentManager, "activity.supportFragmentManager");
                DownloadReDetectorMainDialog downloadReDetectorMainDialogB = DownloadReDetectorMainDialog.f60720w.b(str, str2, strF, subject, str3, str4, str5);
                downloadReDetectorMainDialogB.show(supportFragmentManager, "download_anima");
                final DownloadManagerApi downloadManagerApi = this;
                final FragmentActivity fragmentActivity2 = fragmentActivity;
                final String str7 = str2;
                downloadReDetectorMainDialogB.v0(new Function4<Integer, String, DownloadBean, Boolean, Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$checkPermissionAndDownload$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str8, DownloadBean downloadBean, Boolean bool) {
                        invoke(num.intValue(), str8, downloadBean, bool.booleanValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(int i11, String formatSize, DownloadBean downloadBean, boolean z11) {
                        Intrinsics.g(formatSize, "formatSize");
                        Intrinsics.g(downloadBean, "downloadBean");
                        downloadManagerApi.s2(fragmentActivity2, i11, formatSize, downloadBean, z11, str7);
                    }
                });
                DownloadListManager.f61186m.a().i(DownloadUtil.f61136a.d(subject, str2, strF, str3, "", str6));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a2(final FragmentActivity activity, final String str, String str2, String str3, String str4, boolean z11, Subject subject, String str5, Boolean bool) {
        Subject subject2;
        String string = str3;
        Intrinsics.g(activity, "activity");
        if (!z11 && Intrinsics.b(bool, Boolean.FALSE)) {
            if (subject == null) {
                subject2 = new Subject(str5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0 == true ? 1 : 0, null, null, null, str3, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -524290, 4194303, null);
            } else {
                subject2 = subject;
            }
            String ops = subject2.getOps();
            if (ops == null || ops.length() == 0) {
                subject2.setOps(str3);
            }
            com.alibaba.android.arouter.launcher.a.d().b("/shorts/detail").withSerializable("item_object", subject2).withSerializable(DownloadBaseRunnable.TAG, Boolean.TRUE).navigation();
            return;
        }
        if (string == null || str3.length() == 0) {
            Bundle extras = activity.getIntent().getExtras();
            string = extras != null ? extras.getString("ops") : null;
        }
        String str6 = string;
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "activity.supportFragmentManager");
        DownloadReDetectorMainDialog downloadReDetectorMainDialogE = DownloadReDetectorMainDialog.f60720w.e(str, m.f51277a.f(), subject, str5, str2, str6, str4, z11);
        downloadReDetectorMainDialogE.show(supportFragmentManager, DownloadBaseRunnable.TAG);
        downloadReDetectorMainDialogE.v0(new Function4<Integer, String, DownloadBean, Boolean, Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$downloadShortTV$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str7, DownloadBean downloadBean, Boolean bool2) {
                invoke(num.intValue(), str7, downloadBean, bool2.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11, String formatSize, DownloadBean downloadBean, boolean z12) {
                Intrinsics.g(formatSize, "formatSize");
                Intrinsics.g(downloadBean, "downloadBean");
                this.this$0.s2(activity, i11, formatSize, downloadBean, z12, str);
                uo.b.a.f(uo.b.f78622a, "downloadAna", "group get success, show anima", false, 4, null);
            }
        });
    }

    @Override // com.transsion.downloadapi.IDownloadApiProvider
    public void c(FragmentActivity activity, String pageFrom, String str, String str2, long j11, String sourceUrl) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(pageFrom, "pageFrom");
        Intrinsics.g(sourceUrl, "sourceUrl");
        U1(this, activity, str != null ? new DownloadBean(str, str, str2, "", Long.valueOf(j11), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null) : null, pageFrom, null, sourceUrl, null, null, 96, null);
    }

    public final void c2(final FragmentActivity fragmentActivity, final DownloadBean downloadBean, final String str, final String str2, final String str3, final String str4) {
        com.transsnet.downloader.manager.b.f61062a.a(Utils.a()).r(downloadBean != null ? downloadBean.getResourceId() : null, new Function1<DownloadBean, Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$downloadWithDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean2) {
                invoke2(downloadBean2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadBean downloadBean2) {
                if (downloadBean2 != null) {
                    zp.b.f82110a.d(R$string.already_in_downloads);
                    return;
                }
                String strF = m.f51277a.f();
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                Intrinsics.f(supportFragmentManager, "activity.supportFragmentManager");
                DownloadReDetectorMainDialog downloadReDetectorMainDialogD = DownloadReDetectorMainDialog.f60720w.d(str3, str4);
                downloadReDetectorMainDialogD.show(supportFragmentManager, "download_anima");
                final DownloadManagerApi downloadManagerApi = this;
                final FragmentActivity fragmentActivity2 = fragmentActivity;
                final String str5 = str;
                downloadReDetectorMainDialogD.v0(new Function4<Integer, String, DownloadBean, Boolean, Unit>() { // from class: com.transsnet.downloader.DownloadManagerApi$downloadWithDialog$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str6, DownloadBean downloadBean3, Boolean bool) {
                        invoke(num.intValue(), str6, downloadBean3, bool.booleanValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(int i11, String formatSize, DownloadBean downloadBean3, boolean z11) {
                        Intrinsics.g(formatSize, "formatSize");
                        Intrinsics.g(downloadBean3, "downloadBean");
                        downloadManagerApi.s2(fragmentActivity2, i11, formatSize, downloadBean3, z11, str5);
                    }
                });
                DownloadBean downloadBean3 = downloadBean;
                if (downloadBean3 != null) {
                    String str6 = str;
                    String str7 = str2;
                    downloadBean3.setPageFrom(str6);
                    downloadBean3.setLastPageFrom(strF);
                    downloadBean3.setOps(str7);
                    DownloadListManager.f61186m.a().i(downloadBean3);
                }
            }
        });
    }

    public final Object d2(Continuation<? super Pair<Integer, ? extends List<? extends DownloadBean>>> continuation) {
        return h.g(w0.b(), new DownloadManagerApi$fetchLatestDownloadData$2(null), continuation);
    }

    public final rr.a e2() {
        return (rr.a) this.f60284i.getValue();
    }

    public final com.transsnet.downloader.manager.a f2() {
        return (com.transsnet.downloader.manager.a) this.f60281f.getValue();
    }

    public final IAudioApi g2() {
        Object value = this.f60282g.getValue();
        Intrinsics.f(value, "<get-mAudioApi>(...)");
        return (IAudioApi) value;
    }

    public final IFloatingApi h2() {
        Object value = this.f60283h.getValue();
        Intrinsics.f(value, "<get-mFloatApi>(...)");
        return (IFloatingApi) value;
    }

    public final void i2(FragmentActivity activity, DownloadBean downloadBean, String str) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(downloadBean, "downloadBean");
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        j2(activity, resourceId, str);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    public final void j2(FragmentActivity activity, String resourceId, String str) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(resourceId, "resourceId");
        j.d(l0.a(w0.c()), null, null, new DownloadManagerApi$openDownloadVideo$1(resourceId, str, activity, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a0  */
    public final void k2(Context context, String str) {
        boolean z11;
        if (this.f60280e == null) {
            return;
        }
        com.transsnet.downloader.manager.a aVarF2 = f2();
        DownloadBean downloadBean = this.f60280e;
        Intrinsics.d(downloadBean);
        aVarF2.j(downloadBean);
        com.transsnet.downloader.manager.a aVarA = com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        DownloadBean downloadBean2 = this.f60280e;
        Intrinsics.d(downloadBean2);
        String strH = aVarA.h(downloadBean2);
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/video/detail");
        DownloadBean downloadBean3 = this.f60280e;
        Postcard postcardWithString = postcardB.withString("extra_local_path", downloadBean3 != null ? downloadBean3.getPath() : null);
        DownloadBean downloadBean4 = this.f60280e;
        Postcard postcardWithString2 = postcardWithString.withString("extra_url", downloadBean4 != null ? downloadBean4.getUrl() : null).withString("extra_proxy_url", strH);
        DownloadBean downloadBean5 = this.f60280e;
        Postcard postcardWithString3 = postcardWithString2.withString("extra_resource_id", downloadBean5 != null ? downloadBean5.getResourceId() : null);
        DownloadBean downloadBean6 = this.f60280e;
        Postcard postcardWithString4 = postcardWithString3.withString("extra_subject_id", downloadBean6 != null ? downloadBean6.getSubjectId() : null);
        DownloadBean downloadBean7 = this.f60280e;
        Postcard postcardWithString5 = postcardWithString4.withString("extra_name", downloadBean7 != null ? downloadBean7.getName() : null);
        DownloadBean downloadBean8 = this.f60280e;
        Postcard postcardWithString6 = postcardWithString5.withString("extra_post_id", downloadBean8 != null ? downloadBean8.getPostId() : null);
        DownloadBean downloadBean9 = this.f60280e;
        if (downloadBean9 != null) {
            z11 = downloadBean9.isCompleted();
        }
        Postcard postcardWithBoolean = postcardWithString6.withBoolean("extra_completed", z11);
        DownloadBean downloadBean10 = this.f60280e;
        postcardWithBoolean.withBoolean("extra_is_series", downloadBean10 != null ? downloadBean10.isSeries() : false).withString("extra_page_from", str).navigation(context);
    }

    public final void l2(Context context) {
        j.d(l0.a(w0.c()), null, null, new DownloadManagerApi$opnAudio$1(this, context, null), 3, null);
    }

    public final boolean m2(String str, String str2, boolean z11, boolean z12) {
        boolean z13 = CollectionsKt___CollectionsKt.X(this.f60276a, str2) || CollectionsKt___CollectionsKt.X(this.f60277b, str);
        if (z11) {
            return str != null ? this.f60277b.contains(str) : z13;
        }
        return (!z12 || str == null) ? z13 : this.f60278c.contains(str);
    }

    public final void o2(String str, Context context, String str2, String str3) throws InterruptedException {
        Intrinsics.g(context, "context");
        i.b(null, new DownloadManagerApi$playNow$1(str, this, context, str2, str3, null), 1, null);
    }

    public final void q2(String str, String str2, boolean z11, boolean z12, boolean z13) throws InterruptedException {
        TypeIntrinsics.a(this.f60276a).remove(str2);
        TypeIntrinsics.a(this.f60277b).remove(str);
        if (z12) {
            AddToDownloadEvent addToDownloadEvent = new AddToDownloadEvent(str, str2, false, z11);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = AddToDownloadEvent.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, addToDownloadEvent, 0L);
        }
        if (z13) {
            i.b(null, new DownloadManagerApi$removePlayAvailable$1(str, this, z12, str2, z11, null), 1, null);
        }
    }

    @Override // com.transsion.downloadapi.IDownloadApiProvider
    public Fragment s() {
        return TransferInnerMainFragment.f60851w.a();
    }

    public final void s2(final FragmentActivity fragmentActivity, final int i11, String str, final DownloadBean downloadBean, boolean z11, final String str2) {
        if (((FrameLayout) fragmentActivity.findViewById(R.id.content)) != null) {
            uo.b.a.f(uo.b.f78622a, "downloadAna", "downloadBean.size = " + downloadBean.getSize() + "， formatSize = " + str + ", fileCount = " + i11, false, 4, null);
            if (!z11) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsnet.downloader.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        DownloadManagerApi.t2(downloadBean, str2, i11, fragmentActivity);
                    }
                }, 300L);
                return;
            }
            View childAt = ((ViewGroup) fragmentActivity.getWindow().getDecorView().findViewById(R.id.content)).getChildAt(0);
            if (childAt instanceof ViewGroup) {
            }
        }
    }
}
