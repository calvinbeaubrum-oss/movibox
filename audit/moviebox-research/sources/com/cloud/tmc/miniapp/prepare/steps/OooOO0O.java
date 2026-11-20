package com.cloud.tmc.miniapp.prepare.steps;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class OooOO0O implements wc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OooO0o0.o000oOoO f31573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ lb.g f31574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f31575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f31576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AppModel f31577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ PrepareController f31578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f31579g;

    /* JADX INFO: compiled from: source.java */
    public class OooO00o implements Runnable {
        public OooO00o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OooO0o0.o000oOoO o000oooo = OooOO0O.this.f31573a;
            if (o000oooo != null) {
                o000oooo.w(100);
                OooOO0O.this.f31573a.l();
            }
        }
    }

    public OooOO0O(h hVar, OooO0o0.o000oOoO o000oooo, lb.g gVar, String str, String str2, AppModel appModel, PrepareController prepareController) {
        this.f31579g = hVar;
        this.f31573a = o000oooo;
        this.f31574b = gVar;
        this.f31575c = str;
        this.f31576d = str2;
        this.f31577e = appModel;
        this.f31578f = prepareController;
    }

    @Override // wc.f
    public /* synthetic */ void a(String str, int i11, String str2, long j11, long j12) {
        wc.e.a(this, str, i11, str2, j11, j12);
    }

    @Override // wc.f
    public void b(String str, String str2, String str3, IOException iOException, String str4) {
        OooO0o0.o000oOoO o000oooo = this.f31573a;
        if (o000oooo != null) {
            o000oooo.l();
            MiniAppLaunch.f31784a.f0(this.f31574b.p());
        }
        com.cloud.tmc.integration.utils.h.f31061a.n(this.f31574b.p().getApplicationContext(), this.f31577e, false);
        TmcLogger.c(this.f31579g.f31599a, "Step_FW_Download_资源包下载失败，" + str3);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f31574b.c(), f.a(this.f31574b, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_DOWNLOAD_FAILED.putData("mpu_download_type", this.f31579g.f31615h ? "sync" : "async").putData("mpu_appId", "100000").putData("mpu_old_v", this.f31575c).putData("mpu_new_v", this.f31576d).putData("mpu_result", iOException.getClass().getSimpleName()).putData("mpu_error_code", str2).putData("mpu_error_msg", iOException.getMessage()), "mpu_chain_uniqueId"), "");
        try {
            this.f31579g.f31601c.removeDownloadAppMap(this.f31577e.getPackageUrl_MD5());
        } catch (Throwable th2) {
            TmcLogger.h("Tmc", th2);
        }
        if (this.f31579g.f31615h) {
            if (!TextUtils.isEmpty(this.f31575c) && !TextUtils.isEmpty(this.f31576d) && MiniAppLaunch.f31784a.u(this.f31575c, this.f31576d)) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f31574b.c(), f.a(this.f31574b, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL.putData("mpu_appId", this.f31577e.getAppId()).putData("mpu_old_v", this.f31575c).putData("mpu_new_v", this.f31576d).putData("mpu_result", "DOWNLOAD_FAIL"), "mpu_chain_uniqueId"), "");
            }
            this.f31578f.moveToError(new PrepareException("4", "download error:" + str3 + "   url:" + this.f31577e.getPackageUrl()));
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // wc.f
    public void c(@Nullable String str, String str2) {
        TmcLogger.c(this.f31579g.f31599a, "Step_FW_Download_资源包下载完成");
        com.cloud.tmc.kernel.utils.e.f(new OooO00o());
        com.cloud.tmc.integration.utils.h.f31061a.n(this.f31574b.p().getApplicationContext(), this.f31577e, true);
        this.f31574b.A(this.f31577e);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f31574b.c(), f.a(this.f31574b, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_DOWNLOAD_SUCCESS.putData("mpu_download_type", this.f31579g.f31615h ? "sync" : "async").putData("mpu_appId", "100000").putData("mpu_old_v", this.f31575c).putData("mpu_new_v", this.f31576d), "mpu_chain_uniqueId"), "");
        try {
            this.f31579g.f31601c.removeDownloadAppMap(this.f31577e.getPackageUrl_MD5());
        } catch (Throwable th2) {
            TmcLogger.h("Tmc", th2);
        }
        h hVar = this.f31579g;
        if (hVar.f31615h) {
            TmcLogger.c(hVar.f31599a, "Step_FW_Download_跳转到下一流程");
            PrepareController prepareController = this.f31578f;
            prepareController.unlock(prepareController);
            this.f31578f.moveToNext();
            return;
        }
        try {
            if (MiniAppLaunch.f31784a.s()) {
                i0.q qVar = i0.q.f66855a;
                Context context = this.f31574b.p();
                AppModel appModel = this.f31577e;
                Intrinsics.g(context, "context");
                Intrinsics.g(appModel, "appModel");
                i0.q.e(qVar, context, appModel, false, false, 12);
            }
        } catch (Throwable th3) {
            TmcLogger.h("Tmc", th3);
        }
    }

    @Override // wc.f
    public void f(String str, int i11, String str2) {
        if (this.f31579g.f31615h) {
            OooO0o0.o000oOoO o000oooo = this.f31573a;
            if (o000oooo != null) {
                o000oooo.w(i11);
            }
            if (i11 % 5 == 0) {
                TmcLogger.c(this.f31579g.f31599a, "Step_FW_Download_下载资源包" + i11);
            }
        }
    }

    @Override // wc.f
    public void g(String str, String str2) {
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f31574b.c(), f.a(this.f31574b, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_DOWNLOAD_USER_EXIT.putData("mpu_download_type", this.f31579g.f31615h ? "sync" : "async").putData("mpu_appId", "100000").putData("mpu_old_v", this.f31575c).putData("mpu_new_v", this.f31576d).putData("mpu_result", "IOException").putData("mpu_error_code", "D006").putData("mpu_error_msg", "Canceled"), "mpu_chain_uniqueId"), "");
        try {
            this.f31579g.f31601c.removeDownloadAppMap(this.f31577e.getPackageUrl_MD5());
        } catch (Throwable th2) {
            TmcLogger.h("Tmc", th2);
        }
    }
}
