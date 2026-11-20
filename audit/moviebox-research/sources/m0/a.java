package m0;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.integration.utils.AddHomeToScreenUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.R$anim;
import com.cloud.tmc.miniapp.ui.OooO0OO;
import com.cloud.tmc.miniapp.widget.popupview.MiniAddHomeTipDialogView;
import kotlin.jvm.internal.Intrinsics;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements qb.a {
    @Override // qb.a
    public String a() {
        return "BackToShowAddHomeDialogIntercept";
    }

    @Override // qb.a
    public qb.a.d b(App app, boolean z11, qb.a aVar, boolean z12) {
        return qb.a.b.a(this, app, z11, aVar, z12);
    }

    @Override // qb.a
    public qb.a.d c(qb.a.InterfaceC0816a chain) {
        AppNode appNodeA;
        MiniAddHomeTipDialogView miniAddHomeTipDialogViewQ0;
        Intrinsics.g(chain, "chain");
        TmcLogger.k("BackToShowAddHomeDialogIntercept", "BackToShowAddHomeDialogIntercept: " + chain.a());
        String strB = chain.a().b();
        if (strB != null && (appNodeA = chain.a().a()) != null) {
            appNodeA.getMiniAppAutoPopover();
            Context contextC = chain.a().c();
            if (contextC != null && Build.VERSION.SDK_INT >= 26 && !AppUtils.f31011a.v(contextC, strB) && !AddHomeToScreenUtils.f30986a.i(83, appNodeA)) {
                OooO0OO oooO0OO = contextC instanceof OooO0OO ? (OooO0OO) contextC : null;
                if (oooO0OO != null) {
                    int iD = chain.a().d();
                    String appId = oooO0OO.H;
                    if (appId != null && (miniAddHomeTipDialogViewQ0 = oooO0OO.q0()) != null) {
                        Intrinsics.g(appId, "appId");
                        miniAddHomeTipDialogViewQ0.OooOOO0 = iD;
                        Context context = miniAddHomeTipDialogViewQ0.getContext();
                        Intrinsics.f(context, "context");
                        miniAddHomeTipDialogViewQ0.OooO00o(context, appId, false);
                        Context context2 = miniAddHomeTipDialogViewQ0.getContext();
                        Intrinsics.f(context2, "context");
                        Intrinsics.g(context2, "context");
                        Intrinsics.g(appId, "appId");
                        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context2, "miniappAddHomeToastData", miniAddHomeTipDialogViewQ0.f31928OooO0oo + '_' + appId, System.currentTimeMillis());
                        miniAddHomeTipDialogViewQ0.startAnimation(AnimationUtils.loadAnimation(miniAddHomeTipDialogViewQ0.getContext(), R$anim.mini_view_toast_enter));
                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).recordForCommon(appId, "quit_pop_ex", new Bundle());
                        i.e(miniAddHomeTipDialogViewQ0);
                    }
                }
                appNodeA.updateAddHomeShowStatus(83);
                return qb.a.b.b(this, chain.a().a(), true, this, false, 8, null);
            }
            return qb.a.b.b(this, chain.a().a(), false, this, false, 8, null);
        }
        return qb.a.b.b(this, chain.a().a(), false, this, false, 8, null);
    }

    @Override // qb.a
    public int getPriority() {
        return 30;
    }
}
