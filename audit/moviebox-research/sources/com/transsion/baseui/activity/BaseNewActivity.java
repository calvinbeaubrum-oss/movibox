package com.transsion.baseui.activity;

import android.app.Activity;
import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.v;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.StateView;
import com.tn.lib.view.l;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.locale.LocaleManager;
import com.transsion.baselib.report.e;
import com.transsion.baselib.report.h;
import com.transsion.baseui.R$id;
import com.transsion.baseui.R$layout;
import com.transsion.room.api.IFloatingApi;
import java.lang.ref.WeakReference;
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
public abstract class BaseNewActivity<T extends n6.a> extends BaseMusicFloatActivity<T> implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f51328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f51329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProgressBar f51330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f51331d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f51332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f51333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f51334h = LazyKt__LazyJVMKt.b(new Function0<h>(this) { // from class: com.transsion.baseui.activity.BaseNewActivity$logViewConfig$2
        final /* synthetic */ BaseNewActivity<T> this$0;

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

    /* JADX INFO: renamed from: com.transsion.baseui.activity.BaseNewActivity$onConnected$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    @DebugMetadata(c = "com.transsion.baseui.activity.BaseNewActivity$onConnected$1", f = "BaseNewActivity.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BaseNewActivity<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BaseNewActivity<T> baseNewActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = baseNewActivity;
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
            this.this$0.g0();
            BaseNewActivity<T> baseNewActivity = this.this$0;
            try {
                Result.Companion companion = Result.Companion;
                baseNewActivity.retryLoadData();
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
            return Unit.f68710a;
        }
    }

    public static final void T(BaseNewActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    public static final void l0(BaseNewActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.j0();
    }

    private final void setStatusBar() {
        if (setImmersionStatusBar()) {
            ImmersionBar with = ImmersionBar.with(this);
            if (isChangeStatusBar()) {
                with.statusBarColor(statusColor());
            }
            if (isTranslucent()) {
                with.statusBarAlpha(0.0f);
            } else {
                with.statusBarAlpha(1.0f);
            }
            if (isStatusDark()) {
                with.statusBarDarkFont(true);
            } else {
                with.statusBarDarkFont(false);
            }
            with.fitsSystemWindows(b0());
            Intrinsics.f(with, "with");
            n0(with);
            with.init();
        }
    }

    public String O() {
        return "";
    }

    public View Q() {
        StateView stateView = new StateView(this);
        if (m0()) {
            stateView.setFitsSystemWindows(true);
        }
        stateView.showData(2, 1, true, U(), O());
        return stateView;
    }

    public final FrameLayout R() {
        return this.f51328a;
    }

    public View S() {
        if (this.f51331d == null) {
            View viewInflate = LayoutInflater.from(this).inflate(R$layout.default_base_loading_layout, (ViewGroup) this.f51329b, false);
            ((AppCompatImageView) viewInflate.findViewById(R$id.ivBack)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.baseui.activity.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseNewActivity.T(this.f51338a, view);
                }
            });
            this.f51331d = viewInflate;
        }
        return this.f51331d;
    }

    public abstract String U();

    public View V() {
        NoNetworkBigView noNetworkBigView = new NoNetworkBigView(this);
        noNetworkBigView.showTitle(true, U());
        noNetworkBigView.retry(new Function0<Unit>(this) { // from class: com.transsion.baseui.activity.BaseNewActivity$getNoNetworkView$1$1
            final /* synthetic */ BaseNewActivity<T> this$0;

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
                this.this$0.retryLoadData();
                l.b(this.this$0.getPageName());
            }
        });
        noNetworkBigView.goToSetting(new Function0<Unit>(this) { // from class: com.transsion.baseui.activity.BaseNewActivity$getNoNetworkView$1$2
            final /* synthetic */ BaseNewActivity<T> this$0;

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
                l.c(this.this$0.getPageName());
            }
        });
        l.a(getPageName());
        return noNetworkBigView;
    }

    public void W(Activity activity) {
        try {
            Result.Companion companion = Result.Companion;
            Object systemService = activity != null ? activity.getSystemService("input_method") : null;
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            Result.m163constructorimpl(Boolean.valueOf(((InputMethodManager) systemService).hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public abstract void X();

    public abstract void Y();

    public abstract void Z();

    public boolean a0() {
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Unit unit;
        if (context != null) {
            LocaleManager.b bVar = LocaleManager.f51198f;
            super.attachBaseContext(bVar.k(context, bVar.e().i()));
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.attachBaseContext(context);
        }
    }

    public boolean b0() {
        return true;
    }

    public abstract void c0();

    public void d0() {
    }

    @Override // com.transsion.baseui.activity.BaseMusicFloatActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            this.f51332f = motionEvent.getRawY();
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            float rawY = motionEvent.getRawY();
            this.f51333g = rawY;
            if (Math.abs(rawY - this.f51332f) > 50.0f) {
                ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).X();
                W(this);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e0() {
        FrameLayout frameLayout = this.f51329b;
        if (frameLayout != null) {
            so.c.e(frameLayout);
        }
    }

    public final void f0() {
        setStatusBar();
    }

    public final void g0() {
        FrameLayout frameLayout = this.f51329b;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.transsion.baselib.report.e
    public h getLogViewConfig() {
        return (h) this.f51334h.getValue();
    }

    public final void h0() {
        FrameLayout frameLayout = this.f51329b;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(Q());
        }
    }

    public final void i0() {
        FrameLayout frameLayout = this.f51329b;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(S());
        }
    }

    public boolean isAttach() {
        return true;
    }

    public boolean isChangeStatusBar() {
        return false;
    }

    public boolean isStatusDark() {
        return true;
    }

    public boolean isTranslucent() {
        return false;
    }

    public final void j0() {
        FrameLayout frameLayout = this.f51329b;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(V());
        }
    }

    public final void k0() {
        getMViewBinding().getRoot().postDelayed(new Runnable() { // from class: com.transsion.baseui.activity.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseNewActivity.l0(this.f51337a);
            }
        }, 200L);
    }

    public boolean m0() {
        return false;
    }

    public void n0(ImmersionBar with) {
        Intrinsics.g(with, "with");
    }

    public h newLogViewConfig() {
        return e.a.a(this);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        super.onConnected(network, networkCapabilities);
        v.a(this).b(new AnonymousClass1(this, null));
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStatusBar();
        Y();
        Z();
        X();
        if (f.f49475a.e()) {
            c0();
        }
        d0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
        super.onDisconnected();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        e.a.b(this);
    }

    @Override // com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        e.a.c(this);
        if (isAttach()) {
            ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).r0(new WeakReference<>(this));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (isAttach()) {
            ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).W0(new WeakReference<>(this));
        }
    }

    public abstract void retryLoadData();

    public boolean setImmersionStatusBar() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public void setView() {
        setContentView(R$layout.default_base_layout);
        this.f51328a = (FrameLayout) findViewById(R$id.llRootView);
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.flContent);
        if (frameLayout != null) {
            frameLayout.addView(getMViewBinding().getRoot());
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.flStateView);
        if (frameLayout2 == null) {
            frameLayout2 = null;
        } else if (a0() && !f.f49475a.e()) {
            frameLayout2.setVisibility(0);
            frameLayout2.addView(V());
        }
        this.f51329b = frameLayout2;
        this.f51330c = (ProgressBar) findViewById(R$id.progressBar);
    }

    public int statusColor() {
        return R$color.bg_01;
    }
}
