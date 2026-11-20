package com.transsnet.downloader.fragment;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Lifecycle;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.commercializationapi.IInterceptReportApi;
import com.transsion.memberapi.IMemberApi;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.api.DownloadPageType;
import com.transsnet.downloader.dialog.DownloadTaskControlManagerDialog;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.popup.PopupManager;
import com.transsnet.downloader.util.BatteryPermissionUtils;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class DownloadingListFragment extends DownloadListBaseFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f60809u = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h00.y0 f60810n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f60811o = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsnet.downloader.fragment.DownloadingListFragment$mHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f60812p = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsnet.downloader.fragment.DownloadingListFragment$downloadManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.manager.a invoke() {
            return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f60813q = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsnet.downloader.fragment.DownloadingListFragment$mAudioApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IAudioApi invoke() {
            return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f60814r = LazyKt__LazyJVMKt.b(new Function0<IFloatingApi>() { // from class: com.transsnet.downloader.fragment.DownloadingListFragment$mFloatApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IFloatingApi invoke() {
            return (IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class);
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f60815s = LazyKt__LazyJVMKt.b(new Function0<rr.a>() { // from class: com.transsnet.downloader.fragment.DownloadingListFragment$audioDao$2
        @Override // kotlin.jvm.functions.Function0
        public final rr.a invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).D0();
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f60816t = new b();

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
    @SourceDebugExtension
    public static final class b extends g00.d {
        public b() {
        }

        public static final void j(DownloadingListFragment this$0) {
            Intrinsics.g(this$0, "this$0");
            this$0.W0().j();
        }

        @Override // g00.d
        public void h(DownloadBean bean, int i11) {
            List<DownloadBean> listD;
            Intrinsics.g(bean, "bean");
            if (i11 == 5) {
                uo.b.f78622a.h(DownloadingListFragment.this.X0(), "onRefresh,getList status=" + i11 + ",bean=" + bean.getName() + " subjectId=" + bean.getSubjectId() + ",resourceId=" + bean.getResourceId(), true);
                Handler handlerT1 = DownloadingListFragment.this.t1();
                final DownloadingListFragment downloadingListFragment = DownloadingListFragment.this;
                handlerT1.postDelayed(new Runnable() { // from class: com.transsnet.downloader.fragment.j1
                    @Override // java.lang.Runnable
                    public final void run() {
                        DownloadingListFragment.b.j(downloadingListFragment);
                    }
                }, 500L);
                return;
            }
            com.transsnet.downloader.adapter.g gVarV0 = DownloadingListFragment.this.V0();
            int i12 = -1;
            if (gVarV0 != null && (listD = gVarV0.D()) != null) {
                Iterator<DownloadBean> it = listD.iterator();
                int i13 = 0;
                while (it.hasNext()) {
                    if (Intrinsics.b(it.next().getResourceId(), bean.getResourceId())) {
                        i12 = i13;
                        break;
                    }
                    i13++;
                }
            }
            if (i12 >= 0) {
                com.transsnet.downloader.adapter.g gVarV1 = DownloadingListFragment.this.V0();
                if (gVarV1 != null) {
                    gVarV1.notifyItemChanged(i12, bean);
                    return;
                }
                return;
            }
            uo.b.f78622a.h(DownloadingListFragment.this.X0(), "onRefresh position=" + i12 + ",status=" + i11 + ",bean=" + bean.getName() + " subjectId=" + bean.getSubjectId() + ",resourceId=" + bean.getResourceId(), true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements com.transsnet.downloader.adapter.d0.b {
        @Override // com.transsnet.downloader.adapter.d0.b
        public void a(int i11, int i12) {
        }

        @Override // com.transsnet.downloader.adapter.d0.b
        public void b(int i11, int i12, int i13, boolean z11) {
            com.transsnet.downloader.adapter.d0.b.a.a(this, i11, i12, i13, z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60818a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60818a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60818a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f60818a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rr.a p1() {
        return (rr.a) this.f60815s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.a q1() {
        return (com.transsnet.downloader.manager.a) this.f60812p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAudioApi r1() {
        Object value = this.f60813q.getValue();
        Intrinsics.f(value, "<get-mAudioApi>(...)");
        return (IAudioApi) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFloatingApi s1() {
        Object value = this.f60814r.getValue();
        Intrinsics.f(value, "<get-mFloatApi>(...)");
        return (IFloatingApi) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler t1() {
        return (Handler) this.f60811o.getValue();
    }

    private final void u1() {
        Function1<f00.a, Unit> function1 = new Function1<f00.a, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadingListFragment$initDeleteObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(f00.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(f00.a it) {
                Intrinsics.g(it, "it");
                try {
                    this.this$0.W0().p();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = f00.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }

    public static final void w1(DownloadingListFragment this$0, boolean z11, boolean z12, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.y1(z11, z12);
    }

    public final void A1(DownloadBean downloadBean) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.c()), null, null, new DownloadingListFragment$openAudio$1(this, downloadBean, null), 3, null);
    }

    public final void B1(DownloadBean downloadBean, View view, int i11) {
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
        if (downloadBeanL != null) {
            downloadBean = downloadBeanL;
        }
        if (downloadBean.isVideo()) {
            C1(downloadBean);
        } else {
            A1(downloadBean);
        }
    }

    public final void C1(DownloadBean downloadBean) {
        if (downloadBean.isShotTV()) {
            com.alibaba.android.arouter.launcher.a.d().b("/shorts/detail").withSerializable("item_object", DownloadUtil.f61136a.p(downloadBean)).withInt("ep", downloadBean.getEp()).withLong("ms", downloadBean.getReadProgress()).navigation();
            return;
        }
        q1().j(downloadBean);
        String strH = q1().h(downloadBean);
        com.danikula.videocache.q.a("proxyUrl = " + strH);
        View view = getView();
        Context context = view != null ? view.getContext() : null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return;
        }
        com.alibaba.android.arouter.launcher.a.d().b("/video/detail").withString("extra_local_path", downloadBean.getPath()).withString("extra_url", downloadBean.getUrl()).withString("extra_proxy_url", strH).withString("extra_resource_id", downloadBean.getResourceId()).withString("extra_subject_id", downloadBean.getSubjectId()).withString("extra_name", downloadBean.getName()).withString("extra_post_id", downloadBean.getPostId()).withBoolean("extra_completed", false).withBoolean("extra_is_series", downloadBean.isSeries()).withString("extra_page_from", DownloadPageType.DOWNLOAD.getPageName()).withInt("extra_height", downloadBean.getVideoHeight()).withInt("extra_width", downloadBean.getVideoWidth()).navigation(appCompatActivity);
    }

    public final void D1(List<? extends DownloadBean> list) {
        h00.y0 y0Var = this.f60810n;
        AppCompatTextView appCompatTextView = y0Var != null ? y0Var.f66101b : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(Utils.a().getString(R$string.downloading_title_count, Integer.valueOf(list.size())));
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void T0(com.transsnet.downloader.adapter.g adapter) {
        Intrinsics.g(adapter, "adapter");
        adapter.i(R$id.iv_more, R$id.iv_cover);
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void d1(com.transsnet.downloader.adapter.g adapter, View view, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        DownloadBean item = adapter.getItem(i11);
        int id2 = view.getId();
        if (id2 == R$id.iv_more) {
            z1(item, view, i11);
        } else if (id2 == R$id.iv_cover) {
            B1(item, view, i11);
        }
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void e1(com.transsnet.downloader.adapter.g adapter, View view, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        DownloadBean item = adapter.getItem(i11);
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        String resourceId = item.getResourceId();
        if (resourceId == null) {
            resourceId = item.getUrl();
        }
        DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
        if (downloadBeanL != null) {
            item = downloadBeanL;
        }
        int status = item.getStatus();
        if (status == 1 || status == 2 || status == 3) {
            q1().F(item);
        } else {
            if (x1(item)) {
                return;
            }
            com.transsnet.downloader.manager.a.C0624a.a(q1(), item, false, 2, null);
        }
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void f1(com.transsnet.downloader.adapter.g adapter, View view, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        z1(adapter.getItem(i11), view, i11);
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public String getPageName() {
        return "";
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        super.initListener();
        q1().f(this.f60816t);
        u1();
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        super.initViewModel();
        W0().q().j(this, new d(new Function1<List<? extends DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadingListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends DownloadBean> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends DownloadBean> list) {
                List<? extends DownloadBean> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                DownloadingListFragment.this.D1(list);
                DownloadingListFragment.this.g1(list);
            }
        }));
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return null;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t1().removeCallbacksAndMessages(null);
        q1().v(this.f60816t);
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        LinearLayout linearLayout;
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_downloading_title, (ViewGroup) null);
        this.f60810n = h00.y0.a(viewInflate);
        h00.w mViewBinding = getMViewBinding();
        if (mViewBinding != null && (linearLayout = mViewBinding.f66069d) != null) {
            linearLayout.addView(viewInflate, 0);
        }
        super.v0();
        v1();
    }

    public final void v1() {
        final boolean zG;
        GradientTextView gradientTextView;
        if (Build.VERSION.SDK_INT < 23) {
            zG = false;
        } else {
            BatteryPermissionUtils batteryPermissionUtils = BatteryPermissionUtils.f61124a;
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            zG = batteryPermissionUtils.g(contextRequireContext);
        }
        final boolean zE1 = ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e1();
        h00.y0 y0Var = this.f60810n;
        GradientTextView gradientTextView2 = y0Var != null ? y0Var.f66102c : null;
        if (gradientTextView2 != null) {
            gradientTextView2.setVisibility(zE1 || !zG ? 0 : 8);
        }
        h00.y0 y0Var2 = this.f60810n;
        if (y0Var2 == null || (gradientTextView = y0Var2.f66102c) == null) {
            return;
        }
        gradientTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadingListFragment.w1(this.f60925a, zG, zE1, view);
            }
        });
    }

    public final boolean x1(DownloadBean downloadBean) {
        long jA;
        String rootPath = downloadBean.getRootPath();
        if (rootPath == null || rootPath.length() <= 0) {
            jA = com.blankj.utilcode.util.b0.a();
        } else {
            try {
                jA = com.blankj.utilcode.util.m.l(downloadBean.getRootPath());
            } catch (Throwable unused) {
                return false;
            }
        }
        Long size = downloadBean.getSize();
        if ((size != null ? size.longValue() : 0L) - downloadBean.getProgress() < jA) {
            return false;
        }
        zp.b.f82110a.d(com.transsion.baseui.R$string.insufficient_storage_available);
        return true;
    }

    public final void y1(boolean z11, boolean z12) {
        DownloadTaskControlManagerDialog downloadTaskControlManagerDialog = new DownloadTaskControlManagerDialog(z11, z12);
        downloadTaskControlManagerDialog.r0(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadingListFragment$onManageClick$1$1
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
                this.this$0.v1();
            }
        });
        downloadTaskControlManagerDialog.j0(com.blankj.utilcode.util.a.b(), "DownloadTaskControlManagerDialog");
        ((IInterceptReportApi) com.alibaba.android.arouter.launcher.a.d().h(IInterceptReportApi.class)).o();
    }

    public final void z1(DownloadBean downloadBean, View view, int i11) {
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
        if (downloadBeanL != null) {
            downloadBean = downloadBeanL;
        }
        PopupManager popupManager = new PopupManager(i11, downloadBean);
        popupManager.z(view, 2);
        popupManager.u(new c());
    }
}
