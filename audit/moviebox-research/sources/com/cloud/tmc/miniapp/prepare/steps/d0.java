package com.cloud.tmc.miniapp.prepare.steps;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool;
import com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.constants.PageType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prestrategy.PreStrategyManager;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d0 extends com.cloud.tmc.miniapp.prepare.steps.a {

    /* JADX INFO: compiled from: source.java */
    public class a implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ lb.g f31606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f31607b;

        public a(d0 d0Var, lb.g gVar, String str) {
            this.f31606a = gVar;
            this.f31607b = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            if (!bool.booleanValue() || this.f31606a.a() == null) {
                return null;
            }
            TmcLogger.c("nevermore", "startWarmup 常规小程序 首页是H5 预热webview 开启离屏渲染");
            OffScreenWebviewPool.f30871a.k(this.f31607b, PageType.H5, this.f31606a.a(), this.f31606a);
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ lb.g f31608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppModel f31609b;

        public b(d0 d0Var, lb.g gVar, AppModel appModel) {
            this.f31608a = gVar;
            this.f31609b = appModel;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            if (!bool.booleanValue()) {
                return null;
            }
            Activity activityA = this.f31608a.a();
            String h5Url = this.f31609b.getExtend() != null ? this.f31609b.getExtend().getH5Url() : "";
            Bundle bundleQ = this.f31608a.q();
            if (activityA == null || TextUtils.isEmpty(h5Url) || bundleQ == null) {
                return null;
            }
            TmcLogger.c("nevermore", "startWarmup 独立站 开启离屏渲染");
            OffScreenWebviewPool.f30871a.k(com.cloud.tmc.kernel.utils.i.b(h5Url, com.cloud.tmc.kernel.utils.a.a(bundleQ)), PageType.H5_SHELL, activityA, this.f31608a);
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, lb.g gVar, c0 c0Var) throws PrepareException {
        super.a(prepareController, gVar, c0Var);
        TmcLogger.c("nevermore", "WarmupAndOffScreenStep");
        try {
            if (gVar.d() != null) {
                d(gVar, this.f31600b.getAppModel(gVar.p(), gVar.d()));
            }
        } catch (Throwable th2) {
            TmcLogger.c("nevermore", "WarmupAndOffScreenStep:" + th2);
        }
    }

    public final void d(lb.g gVar, AppModel appModel) {
        TmcLogger.c("nevermore", "startWarmup");
        if (gVar.r()) {
            TmcLogger.c("nevermore", "startWarmup 虚拟启动 return");
            return;
        }
        if (gVar.s().get()) {
            TmcLogger.c("nevermore", "startWarmup 已经预热过了 return");
            return;
        }
        if (appModel == null) {
            TmcLogger.c("nevermore", "startWarmup appModel是空的 return");
            return;
        }
        int appinfoCategoryType = appModel.getAppinfoCategoryType();
        String str = "[{\"appId\":\"" + (!TextUtils.isEmpty(gVar.c()) ? gVar.c() : "") + "\"}]";
        if (appinfoCategoryType != MiniAppType.NORMAL.getType()) {
            if (appinfoCategoryType == MiniAppType.SHELL.getType() || appinfoCategoryType == MiniAppType.SHELL_GAME.getType()) {
                TmcLogger.c("nevermore", "startWarmup 独立站");
                gVar.s().set(true);
                ((IInnerH5WebviewPool) tc.a.a(IInnerH5WebviewPool.class)).createWebview();
                PreStrategyManager.f31651a.a(gVar.p(), "keyMiniAppStart", str, new b(this, gVar, appModel));
                return;
            }
            return;
        }
        TmcLogger.c("nevermore", "startWarmup 常规小程序");
        Bundle bundleQ = gVar.q();
        Bundle bundleO = gVar.o();
        String string = bundleQ.getString("page");
        boolean z11 = !TextUtils.isEmpty(string) && string.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && AppUtils.t(bundleO, string);
        gVar.s().set(true);
        if (z11) {
            TmcLogger.c("nevermore", "startWarmup 常规小程序 首页是H5");
            ((IInnerH5WebviewPool) tc.a.a(IInnerH5WebviewPool.class)).createWebview();
            PreStrategyManager.f31651a.a(gVar.p(), "keyMiniAppStart", str, new a(this, gVar, string));
        } else {
            TmcLogger.c("nevermore", "startWarmup 常规小程序 首页是Normal 预热render&worker");
            ((IInnerRenderPool) tc.a.a(IInnerRenderPool.class)).createRender(false);
            ((IInnerWorkerPool) tc.a.a(IInnerWorkerPool.class)).createWorker(false);
        }
    }
}
