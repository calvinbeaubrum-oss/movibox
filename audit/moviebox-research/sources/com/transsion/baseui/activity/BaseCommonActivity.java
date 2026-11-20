package com.transsion.baseui.activity;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.e0;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.h2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.s;
import androidx.compose.runtime.v1;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.u;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.blankj.utilcode.util.f0;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.android.material.card.MaterialCardView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.util.device.TNDeviceHelper;
import com.tn.lib.util.networkinfo.g;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.report.m;
import com.transsion.baseui.R$mipmap;
import java.util.HashMap;
import java.util.Set;
import k2.f;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import n6.a;
import o1.h;
import q2.x;

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
public abstract class BaseCommonActivity<T extends n6.a> extends AppCompatActivity implements g {
    public static final String EXTRA_SHOW_HOME_BUTTON = "show_enter_home";
    public static final String TAG = "BaseCommonActivity";
    public T mViewBinding;
    public static final a Companion = new a(null);
    public static final int $stable = 8;

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

    private final View getEnterHomeView() {
        ComposeView composeView = new ComposeView(this, null, 0, 6, null);
        ViewTreeLifecycleOwner.b(composeView, this);
        ViewTreeViewModelStoreOwner.b(composeView, this);
        ViewTreeSavedStateRegistryOwner.b(composeView, this);
        composeView.setContent(androidx.compose.runtime.internal.b.c(-541145127, true, new Function2<i, Integer, Unit>(this) { // from class: com.transsion.baseui.activity.BaseCommonActivity$getEnterHomeView$composeView$1$1
            final /* synthetic */ BaseCommonActivity<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i iVar, Integer num) {
                invoke(iVar, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(i iVar, int i11) {
                if ((i11 & 11) == 2 && iVar.h()) {
                    iVar.H();
                    return;
                }
                if (k.J()) {
                    k.S(-541145127, i11, -1, "com.transsion.baseui.activity.BaseCommonActivity.getEnterHomeView.<anonymous>.<anonymous> (BaseCommonActivity.kt:186)");
                }
                this.this$0.EnterHomeView(iVar, 8);
                if (k.J()) {
                    k.R();
                }
            }
        }));
        return composeView;
    }

    private final void showBackHomeButton() {
        if (getIntent().getBooleanExtra(EXTRA_SHOW_HOME_BUTTON, false)) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
            layoutParams.y = f0.a(120.0f);
            layoutParams.flags = 136;
            layoutParams.format = -3;
            getWindowManager().addView(getEnterHomeView(), layoutParams);
            m mVar = m.f51277a;
            String pageName = getPageName();
            HashMap map = new HashMap();
            map.put("event_type", "deeplink_enter_home_browse");
            Unit unit = Unit.f68710a;
            mVar.t(pageName, "browse", map);
        }
    }

    public final void EnterHomeView(i iVar, final int i11) {
        i iVarG = iVar.g(976578532);
        if (k.J()) {
            k.S(976578532, i11, -1, "com.transsion.baseui.activity.BaseCommonActivity.EnterHomeView (BaseCommonActivity.kt:195)");
        }
        Painter painterC = f.c(R$mipmap.ic_tab_home, iVarG, 0);
        androidx.compose.ui.b.c cVarH = androidx.compose.ui.b.f3770a.h();
        androidx.compose.ui.f.a aVar = androidx.compose.ui.f.f3863a;
        float f11 = 0;
        float f12 = 20;
        androidx.compose.ui.f fVarA = BackgroundKt.a(SizeKt.e(aVar, q2.i.h(36)), k2.c.a(R$color.bg_01_70_reverse, iVarG, 0), p1.g.d(q2.i.h(f11), q2.i.h(f12), q2.i.h(f12), q2.i.h(f11)));
        iVarG.x(-492369756);
        Object objY = iVarG.y();
        if (objY == i.f3413a.a()) {
            objY = h.a();
            iVarG.p(objY);
        }
        iVarG.P();
        androidx.compose.ui.f fVarA2 = ClickableKt.a(fVarA, (o1.i) objY, null, (28 & 4) != 0, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null, new Function0<Unit>(this) { // from class: com.transsion.baseui.activity.BaseCommonActivity.EnterHomeView.2
            final /* synthetic */ BaseCommonActivity<T> this$0;

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
                if (com.transsion.baseui.util.c.f51452a.a(R$mipmap.ic_tab_home, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
                    return;
                }
                com.alibaba.android.arouter.launcher.a.d().b("/main/tab").withInt("tabIndex", 0).navigation();
                m mVar = m.f51277a;
                String pageName = this.this$0.getPageName();
                HashMap map = new HashMap();
                map.put("event_type", "deeplink_enter_home_click");
                Unit unit = Unit.f68710a;
                mVar.m(pageName, "click", map);
            }
        });
        iVarG.x(693286680);
        u uVarB = a0.b(androidx.compose.foundation.layout.b.f2478a.c(), cVarH, iVarG, 48);
        iVarG.x(-1323940314);
        int iA = androidx.compose.runtime.g.a(iVarG, 0);
        s sVarN = iVarG.n();
        ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
        Function0<ComposeUiNode> function0A = companion.a();
        Function3<h2<ComposeUiNode>, i, Integer, Unit> function3A = LayoutKt.a(fVarA2);
        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
            androidx.compose.runtime.g.b();
        }
        iVarG.D();
        if (iVarG.e()) {
            iVarG.G(function0A);
        } else {
            iVarG.o();
        }
        i iVarA = f3.a(iVarG);
        f3.b(iVarA, uVarB, companion.c());
        f3.b(iVarA, sVarN, companion.e());
        Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
        if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
            iVarA.p(Integer.valueOf(iA));
            iVarA.k(Integer.valueOf(iA), function2B);
        }
        function3A.invoke(h2.a(h2.b(iVarG)), iVarG, 0);
        iVarG.x(2058660585);
        d0 d0Var = d0.f2491a;
        e0.a(SizeKt.l(aVar, q2.i.h(8)), iVarG, 6);
        ImageKt.a(painterC, null, SizeKt.j(aVar, q2.i.h(18)), null, null, 0.0f, x1.a.b(x1.f4581b, k2.c.a(R$color.bg_01, iVarG, 0), 0, 2, null), iVarG, 440, 56);
        e0.a(SizeKt.l(aVar, q2.i.h(4)), iVarG, 6);
        TextKt.a(k2.i.a(R$string.tab_home, iVarG, 0), null, k2.c.a(R$color.bg_01, iVarG, 0), x.c(14), null, androidx.compose.ui.text.font.u.f5860b.c(), androidx.compose.ui.text.font.i.f5821b.b(), 0L, null, null, 0L, 0, false, 0, 0, null, null, iVarG, 199680, 0, 130962);
        e0.a(SizeKt.l(aVar, q2.i.h(12)), iVarG, 6);
        iVarG.P();
        iVarG.r();
        iVarG.P();
        iVarG.P();
        if (k.J()) {
            k.R();
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ == null) {
            return;
        }
        g2VarJ.a(new Function2<i, Integer, Unit>(this) { // from class: com.transsion.baseui.activity.BaseCommonActivity.EnterHomeView.4
            final /* synthetic */ BaseCommonActivity<T> $tmp0_rcvr;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$tmp0_rcvr = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                invoke(iVar2, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(i iVar2, int i12) {
                this.$tmp0_rcvr.EnterHomeView(iVar2, v1.a(i11 | 1));
            }
        });
    }

    @Override // android.app.Activity
    public void finish() {
        if (getIntent().getBooleanExtra(EXTRA_SHOW_HOME_BUTTON, false)) {
            finishAffinity();
        }
        super.finish();
    }

    public final String getClassTag() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final T getMViewBinding() {
        T t11 = this.mViewBinding;
        if (t11 != null) {
            return t11;
        }
        Intrinsics.y("mViewBinding");
        return null;
    }

    public String getPageName() {
        return "";
    }

    public abstract T getViewBinding();

    public final void intercept(Context context, Bundle bundle) {
        Object objM163constructorimpl;
        Set<String> setKeySet;
        try {
            Result.Companion companion = Result.Companion;
            if (bundle == null) {
                return;
            }
            String strM = TNDeviceHelper.f49455a.m();
            boolean z11 = TextUtils.equals(strM, PrepareException.ERROR_MINI_APP_CLOSE) || TextUtils.equals(strM, PrepareException.ERROR_MINI_APPID);
            if (context != null && z11) {
                bundle.setClassLoader(context.getClass().getClassLoader());
                Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                if (bundle2 != null && (setKeySet = bundle2.keySet()) != null) {
                    Intrinsics.f(setKeySet, "keySet()");
                    for (String str : setKeySet) {
                        Object obj = bundle2.get(str);
                        Bundle bundle3 = obj instanceof Bundle ? (Bundle) obj : null;
                        ClassLoader classLoader = bundle3 != null ? bundle3.getClassLoader() : null;
                        uo.b.f78622a.i("BaseCommonActivity --> intercept() --> classLoader = " + classLoader, true);
                        Object obj2 = bundle2.get(str);
                        Bundle bundle4 = obj2 instanceof Bundle ? (Bundle) obj2 : null;
                        if (bundle4 != null) {
                            bundle4.setClassLoader(context.getClass().getClassLoader());
                        }
                    }
                }
                uo.b.f78622a.i("BaseCommonActivity --> intercept() --> 当前系统版本9、10 替换BootClassLoader -- ClassLoader", true);
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        uo.b.f78622a.i("BaseCommonActivity --> intercept() --> it = " + thM166exceptionOrNullimpl, true);
    }

    public boolean isMonitorNetworkState() {
        return true;
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected() {
        g.a.a(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        intercept(this, bundle);
        super.onCreate(bundle);
        if (isMonitorNetworkState()) {
            com.tn.lib.util.networkinfo.f.f49475a.l(this);
        }
        setMViewBinding(getViewBinding());
        setView();
        showBackHomeButton();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isMonitorNetworkState()) {
            com.tn.lib.util.networkinfo.f.f49475a.m(this);
        }
        d.f(null, this, 1, null);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        d.k(null, this, 1, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d.o(null, this, 1, null);
    }

    public final void setMViewBinding(T t11) {
        Intrinsics.g(t11, "<set-?>");
        this.mViewBinding = t11;
    }

    public abstract void setView();
}
