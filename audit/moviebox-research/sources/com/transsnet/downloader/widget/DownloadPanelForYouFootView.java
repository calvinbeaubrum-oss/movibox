package com.transsnet.downloader.widget;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.StateView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.adapter.f0;
import com.transsnet.downloader.api.DownloadPageType;
import h00.q0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DownloadPanelForYouFootView extends ConstraintLayout implements com.tn.lib.util.networkinfo.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f61307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f61308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f61309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f61310d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.baselib.utils.e f61311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f61312g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadPanelForYouFootView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadPanelForYouFootView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadPanelForYouFootView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f61308b = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.report.a>() { // from class: com.transsnet.downloader.widget.DownloadPanelForYouFootView$downloadReport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsnet.downloader.report.a invoke() {
                return new com.transsnet.downloader.report.a();
            }
        });
        View.inflate(getContext(), R$layout.layout_download_for_you_footview, this);
        q0 q0VarA = q0.a(this);
        Intrinsics.f(q0VarA, "bind(this)");
        this.f61307a = q0VarA;
        Object context2 = getContext();
        setPadding(0, 0, 0, gs.a.a(((context2 instanceof ut.a) && ((ut.a) context2).u()) ? 88 : 80));
        i();
        q0VarA.f66001h.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadPanelForYouFootView.f(this.f61385a, view);
            }
        });
    }

    public static final void f(DownloadPanelForYouFootView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.k();
        Function0<Unit> function0 = this$0.f61310d;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void g() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate = this.f61307a.f65997c.animate();
        if (viewPropertyAnimatorAnimate != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.report.a getDownloadReport() {
        return (com.transsnet.downloader.report.a) this.f61308b.getValue();
    }

    private final View getForYouNoNetView() {
        if (this.f61312g == null) {
            Context context = getContext();
            Intrinsics.f(context, "context");
            StateView stateView = new StateView(context);
            stateView.showData(1, 6, false, "", "");
            stateView.retry(new Function0<Unit>() { // from class: com.transsnet.downloader.widget.DownloadPanelForYouFootView$getForYouNoNetView$1$1
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
                    Function0 function0 = this.this$0.f61310d;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
            this.f61312g = stateView;
        }
        View view = this.f61312g;
        Intrinsics.d(view);
        return view;
    }

    private final void h(Subject subject) {
        Integer subjectType = subject.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType == null || subjectType.intValue() != value) {
            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
            Integer subjectType2 = subject.getSubjectType();
            postcardB.withInt("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).withString("id", subject.getSubjectId()).withString("ops", subject.getOps()).navigation();
        } else {
            DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
            Context context = getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            downloadManagerApiA.a2((FragmentActivity) context, DownloadPageType.DOWNLOAD.getPageName(), (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
        }
    }

    private final void i() {
        RecyclerView recyclerView = this.f61307a.f65998d;
        recyclerView.setNestedScrollingEnabled(false);
        Context context = recyclerView.getContext();
        Context context2 = recyclerView.getContext();
        Intrinsics.f(context2, "context");
        recyclerView.setLayoutManager(new NpaGridLayoutManager(context, com.transsion.baseui.util.b.a(context2) ? 4 : 3));
        recyclerView.addItemDecoration(new ro.a(gs.a.a(8), gs.a.a(12), 0, 0));
        f0 f0Var = new f0(new ArrayList());
        f0Var.B0(new f9.d() { // from class: com.transsnet.downloader.widget.j
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                DownloadPanelForYouFootView.j(this.f61386a, baseQuickAdapter, view, i11);
            }
        });
        this.f61309c = f0Var;
        recyclerView.setAdapter(f0Var);
    }

    public static final void j(DownloadPanelForYouFootView this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            this$0.h(subject);
            this$0.getDownloadReport().b(DownloadPageType.DOWNLOAD.getPageName(), subject, i11);
        }
    }

    private final void k() {
        final AppCompatImageView appCompatImageView = this.f61307a.f65997c;
        appCompatImageView.animate().cancel();
        ViewPropertyAnimator viewPropertyAnimatorAnimate = appCompatImageView.animate();
        viewPropertyAnimatorAnimate.setDuration(1000L);
        viewPropertyAnimatorAnimate.rotation(appCompatImageView.getRotation() + 360.0f);
        viewPropertyAnimatorAnimate.setInterpolator(new AccelerateDecelerateInterpolator());
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction = viewPropertyAnimatorAnimate.withEndAction(new Runnable() { // from class: com.transsnet.downloader.widget.k
            @Override // java.lang.Runnable
            public final void run() {
                DownloadPanelForYouFootView.l(appCompatImageView, this);
            }
        });
        if (viewPropertyAnimatorWithEndAction != null) {
            viewPropertyAnimatorWithEndAction.start();
        }
    }

    public static final void l(AppCompatImageView it, DownloadPanelForYouFootView this$0) {
        Intrinsics.g(it, "$it");
        Intrinsics.g(this$0, "this$0");
        if (it.getRotation() >= 360.0f) {
            it.setRotation(it.getRotation() - 360);
        }
        this$0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$5(DownloadPanelForYouFootView this$0) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baselib.utils.e eVar = this$0.f61311f;
        if (eVar != null) {
            eVar.e();
        }
    }

    public final void configChange() {
        f0 f0Var = this.f61309c;
        if (f0Var != null) {
            f0Var.notifyDataSetChanged();
        }
    }

    public final void initBrowseReport(RecyclerView recyclerView) {
        this.f61311f = new com.transsion.baselib.utils.e(recyclerView, this.f61307a.f65998d, 0.5f, new Function1<Integer, Unit>() { // from class: com.transsnet.downloader.widget.DownloadPanelForYouFootView.initBrowseReport.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11) {
                Subject subjectO;
                f0 f0Var = DownloadPanelForYouFootView.this.f61309c;
                if (f0Var == null || (subjectO = f0Var.O(i11)) == null) {
                    return;
                }
                DownloadPanelForYouFootView.this.getDownloadReport().a(DownloadPageType.DOWNLOAD.getPageName(), subjectO, i11, -1L);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f0 f0Var = this.f61309c;
        if (f0Var == null || !f0Var.Z()) {
            com.tn.lib.util.networkinfo.f.f49475a.l(this);
        }
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected() {
        com.tn.lib.util.networkinfo.g.a.a(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        Function0<Unit> function0 = this.f61310d;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.tn.lib.util.networkinfo.f.f49475a.m(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
    }

    public final void onPageResume() {
        com.transsion.baselib.utils.e eVar = this.f61311f;
        if (eVar != null) {
            eVar.e();
        }
    }

    public final void setData(List<? extends Subject> data) {
        Intrinsics.g(data, "data");
        g();
        int size = data.size();
        Context context = getContext();
        Intrinsics.f(context, "context");
        List listF0 = CollectionsKt___CollectionsKt.F0(data, size - kotlin.ranges.a.d(size % (com.transsion.baseui.util.b.a(context) ? 4 : 3), 0));
        f0 f0Var = this.f61309c;
        if (f0Var != null) {
            f0Var.w0(listF0);
        }
        Group group = this.f61307a.f65996b;
        Intrinsics.f(group, "viewBinding.groupRefresh");
        so.c.k(group);
        com.tn.lib.util.networkinfo.f.f49475a.m(this);
        postDelayed(new Runnable() { // from class: com.transsnet.downloader.widget.h
            @Override // java.lang.Runnable
            public final void run() {
                DownloadPanelForYouFootView.setData$lambda$5(this.f61384a);
            }
        }, 500L);
    }

    public final void setRefreshClickCallback(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f61310d = callback;
    }

    public final void showNoNetView() {
        g();
        f0 f0Var = this.f61309c;
        List<Subject> listD = f0Var != null ? f0Var.D() : null;
        if (listD == null || listD.isEmpty()) {
            com.tn.lib.util.networkinfo.f.f49475a.l(this);
            Group group = this.f61307a.f65996b;
            Intrinsics.f(group, "viewBinding.groupRefresh");
            so.c.g(group);
            f0 f0Var2 = this.f61309c;
            if (f0Var2 != null) {
                f0Var2.r0(getForYouNoNetView());
            }
        }
    }
}
