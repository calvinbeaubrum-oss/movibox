package com.transsion.baseui.fragment;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.v;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.util.networkinfo.g;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.StateView;
import com.tn.lib.view.l;
import com.transsion.baselib.report.e;
import com.transsion.baselib.report.h;
import com.transsion.baselib.utils.DeviceKeyMonitor;
import com.transsion.baseui.R$id;
import com.transsion.baseui.R$layout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import n6.a;

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
public abstract class PageStatusFragment<T extends n6.a> extends Fragment implements e, g, DeviceKeyMonitor.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f51357i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f51358j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProgressBar f51359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f51360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f51361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f51362d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DeviceKeyMonitor f51363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f51364g = LazyKt__LazyJVMKt.b(new Function0<h>(this) { // from class: com.transsion.baseui.fragment.PageStatusFragment$logViewConfig$2
        final /* synthetic */ PageStatusFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final h invoke() {
            return this.this$0.newLogViewConfig();
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f51365h = new Runnable() { // from class: com.transsion.baseui.fragment.c
        @Override // java.lang.Runnable
        public final void run() {
            PageStatusFragment.P0(this.f51368a);
        }
    };

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.transsion.baseui.fragment.PageStatusFragment$onConnected$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    @DebugMetadata(c = "com.transsion.baseui.fragment.PageStatusFragment$onConnected$1", f = "PageStatusFragment.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PageStatusFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PageStatusFragment<T> pageStatusFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = pageStatusFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
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
            this.this$0.F0();
            PageStatusFragment<T> pageStatusFragment = this.this$0;
            try {
                Result.Companion companion = Result.Companion;
                pageStatusFragment.E0();
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
            return Unit.f68710a;
        }
    }

    public static /* synthetic */ void H0(PageStatusFragment pageStatusFragment, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showEmptyView");
        }
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        pageStatusFragment.G0(z11);
    }

    public static /* synthetic */ void J0(PageStatusFragment pageStatusFragment, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorView");
        }
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        pageStatusFragment.I0(z11);
    }

    public static /* synthetic */ void N0(PageStatusFragment pageStatusFragment, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNoNetworkView");
        }
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        pageStatusFragment.M0(z11);
    }

    public static final void P0(PageStatusFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        N0(this$0, false, 1, null);
    }

    public static /* synthetic */ View m0(PageStatusFragment pageStatusFragment, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEmptyView");
        }
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return pageStatusFragment.l0(z11);
    }

    public static final void q0(PageStatusFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    public boolean A0() {
        return true;
    }

    public void B0() {
    }

    public final void C0() {
        FrameLayout frameLayout = this.f51361c;
        if (frameLayout != null) {
            so.c.e(frameLayout);
        }
    }

    public void D0() {
    }

    public abstract void E0();

    public final void F0() {
        FrameLayout frameLayout = this.f51361c;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    public final void G0(boolean z11) {
        FrameLayout frameLayout = this.f51361c;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(l0(z11));
        }
    }

    public final void I0(boolean z11) {
        FrameLayout frameLayout = this.f51361c;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(n0(z11));
        }
    }

    public final void K0() {
        FrameLayout frameLayout = this.f51361c;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(p0());
        }
    }

    public final void L0(boolean z11) {
        FrameLayout frameLayout = this.f51361c;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(r0(z11));
        }
    }

    public final void M0(boolean z11) {
        FrameLayout frameLayout;
        if (getContext() == null || (frameLayout = this.f51361c) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(0);
        View viewS0 = s0();
        if (viewS0 instanceof NoNetworkBigView) {
            NoNetworkBigView.showTitle$default((NoNetworkBigView) viewS0, z11, null, 2, null);
        }
        frameLayout.addView(viewS0);
    }

    public final void O0() {
        View root;
        T t11 = this.f51360b;
        if (t11 == null || (root = t11.getRoot()) == null) {
            return;
        }
        root.postDelayed(this.f51365h, 200L);
    }

    @Override // com.transsion.baselib.utils.DeviceKeyMonitor.b
    public void V() {
    }

    @Override // com.transsion.baselib.report.e
    public h getLogViewConfig() {
        return (h) this.f51364g.getValue();
    }

    public final T getMViewBinding() {
        return this.f51360b;
    }

    public abstract T getViewBinding(LayoutInflater layoutInflater);

    @Override // com.transsion.baselib.utils.DeviceKeyMonitor.b
    public void h() {
    }

    public final void i0(boolean z11) {
        ProgressBar progressBar = this.f51359a;
        if (progressBar != null) {
            so.c.j(progressBar, z11);
        }
    }

    public abstract void initListener();

    public abstract void initViewModel();

    public final String j0() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public String k0() {
        return "";
    }

    public View l0(boolean z11) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        StateView stateView = new StateView(contextRequireContext);
        stateView.showData(2, u0(), z11, t0(), k0());
        return stateView;
    }

    public void logPause() {
        e.a.b(this);
    }

    public void logResume() {
        e.a.c(this);
    }

    public View n0(boolean z11) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        StateView stateView = new StateView(contextRequireContext);
        stateView.showData(3, u0(), z11, t0(), k0());
        stateView.retry(new Function0<Unit>(this) { // from class: com.transsion.baseui.fragment.PageStatusFragment$getErrorView$1$1
            final /* synthetic */ PageStatusFragment<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.E0();
            }
        });
        return stateView;
    }

    public h newLogViewConfig() {
        return e.a.a(this);
    }

    public final FrameLayout o0() {
        return this.f51361c;
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected() {
        g.a.a(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        v.a(this).b(new AnonymousClass1(this, null));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Context context;
        super.onCreate(bundle);
        D0();
        if (y0()) {
            f.f49475a.l(this);
        }
        if (!z0() || (context = getContext()) == null) {
            return;
        }
        this.f51363f = new DeviceKeyMonitor(context, this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        Intrinsics.g(inflater, "inflater");
        super.onCreateView(inflater, viewGroup, bundle);
        View viewInflate = inflater.inflate(R$layout.fragment_default_base_layout, viewGroup, false);
        this.f51360b = (T) getViewBinding(inflater);
        if (viewInflate != null && (frameLayout2 = (FrameLayout) viewInflate.findViewById(R$id.flContent)) != null) {
            T t11 = this.f51360b;
            frameLayout2.addView(t11 != null ? t11.getRoot() : null);
        }
        if (viewInflate == null || (frameLayout = (FrameLayout) viewInflate.findViewById(R$id.flStateView)) == null) {
            frameLayout = null;
        } else if (x0() && !f.f49475a.e()) {
            frameLayout.setVisibility(0);
            frameLayout.addView(s0());
        }
        this.f51361c = frameLayout;
        this.f51359a = viewInflate != null ? (ProgressBar) viewInflate.findViewById(R$id.progressBar) : null;
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (y0()) {
            f.f49475a.m(this);
        }
        DeviceKeyMonitor deviceKeyMonitor = this.f51363f;
        if (deviceKeyMonitor != null) {
            deviceKeyMonitor.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        View root;
        super.onDestroyView();
        T t11 = this.f51360b;
        if (t11 != null && (root = t11.getRoot()) != null) {
            root.removeCallbacks(this.f51365h);
        }
        this.f51365h = null;
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isHidden()) {
            return;
        }
        logPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        logResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        v0();
        w0(view, bundle);
        initViewModel();
        initListener();
        B0();
    }

    public View p0() {
        if (this.f51362d == null) {
            View viewInflate = LayoutInflater.from(requireContext()).inflate(R$layout.default_base_loading_layout, (ViewGroup) this.f51361c, false);
            ((AppCompatImageView) viewInflate.findViewById(R$id.ivBack)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.baseui.fragment.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PageStatusFragment.q0(this.f51369a, view);
                }
            });
            this.f51362d = viewInflate;
        }
        return this.f51362d;
    }

    public View r0(boolean z11) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        StateView stateView = new StateView(contextRequireContext);
        stateView.showData(1, u0(), z11, "", "");
        stateView.retry(new Function0<Unit>(this) { // from class: com.transsion.baseui.fragment.PageStatusFragment$getLocalNoNetworkView$1$1
            final /* synthetic */ PageStatusFragment<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.E0();
            }
        });
        return stateView;
    }

    public View s0() {
        String strF;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        NoNetworkBigView noNetworkBigView = new NoNetworkBigView(contextRequireContext, A0());
        noNetworkBigView.retry(new Function0<Unit>(this) { // from class: com.transsion.baseui.fragment.PageStatusFragment$getNoNetworkView$1$1
            final /* synthetic */ PageStatusFragment<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String strF2;
                this.this$0.E0();
                h logViewConfig = this.this$0.getLogViewConfig();
                if (logViewConfig == null || (strF2 = logViewConfig.f()) == null) {
                    return;
                }
                l.b(strF2);
            }
        });
        noNetworkBigView.goToSetting(new Function0<Unit>(this) { // from class: com.transsion.baseui.fragment.PageStatusFragment$getNoNetworkView$1$2
            final /* synthetic */ PageStatusFragment<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String strF2;
                h logViewConfig = this.this$0.getLogViewConfig();
                if (logViewConfig == null || (strF2 = logViewConfig.f()) == null) {
                    return;
                }
                l.c(strF2);
            }
        });
        h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (strF = logViewConfig.f()) != null) {
            l.a(strF);
        }
        return noNetworkBigView;
    }

    public abstract String t0();

    public int u0() {
        return 1;
    }

    public abstract void v0();

    public void w0(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
    }

    public boolean x0() {
        return true;
    }

    public boolean y0() {
        return true;
    }

    public boolean z0() {
        return false;
    }
}
