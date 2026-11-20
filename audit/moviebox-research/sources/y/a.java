package y;

import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import hd.k;
import i0.q;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import lb.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements wc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f81010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f81011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppModel f81012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f81013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PrepareController f81014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c0 f81015f;

    public a(boolean z11, b bVar, AppModel appModel, g gVar, PrepareController prepareController, c0 c0Var) {
        this.f81010a = z11;
        this.f81011b = bVar;
        this.f81012c = appModel;
        this.f81013d = gVar;
        this.f81014e = prepareController;
        this.f81015f = c0Var;
    }

    @Override // wc.f
    public /* synthetic */ void a(String str, int i11, String str2, long j11, long j12) {
        wc.e.a(this, str, i11, str2, j11, j12);
    }

    @Override // wc.f
    public void b(String url, String errorCode, String errorMsg, IOException e11, String str) {
        Intrinsics.g(url, "url");
        Intrinsics.g(errorCode, "errorCode");
        Intrinsics.g(errorMsg, "errorMsg");
        Intrinsics.g(e11, "e");
        h.f31061a.n(this.f81013d.p(), this.f81012c, false);
        try {
            this.f81011b.f31601c.removeDownloadAppMap(this.f81012c.getPackageUrl_MD5());
        } catch (Throwable unused) {
        }
        if (!this.f81010a) {
            this.f81015f.g(this.f81012c, false);
            return;
        }
        k.a("Step_Download_资源包下载失败，", errorMsg, this.f81011b.f31599a);
        PrepareController prepareController = this.f81014e;
        if (prepareController != null) {
            prepareController.moveToError(new PrepareException("4", "download error:" + errorMsg + "   url:" + this.f81012c.getPackageUrl()));
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
    public void c(String str, String str2) {
        TmcLogger.c(this.f81011b.f31599a, "Step_Download_资源包下载完成，进行解压");
        h.f31061a.n(this.f81013d.p(), this.f81012c, true);
        try {
            this.f81011b.f31601c.removeDownloadAppMap(this.f81012c.getPackageUrl_MD5());
        } catch (Throwable unused) {
        }
        if (!this.f81010a) {
            try {
                if (MiniAppLaunch.f31784a.s()) {
                    q.e(q.f66855a, this.f81013d.p(), this.f81012c, false, false, 12);
                }
            } catch (Throwable unused2) {
            }
            this.f81015f.g(this.f81012c, true);
            return;
        }
        PrepareController prepareController = this.f81014e;
        if (prepareController != null) {
            prepareController.unlock(prepareController);
        }
        PrepareController prepareController2 = this.f81014e;
        if (prepareController2 != null) {
            prepareController2.moveToNext();
        }
    }

    @Override // wc.f
    public void f(String url, int i11, String str) {
        Intrinsics.g(url, "url");
        if (this.f81010a) {
            TmcLogger.c(this.f81011b.f31599a, "Step_Download_下载资源包" + i11);
        }
    }

    @Override // wc.f
    public void g(String url, String str) {
        Intrinsics.g(url, "url");
        try {
            this.f81011b.f31601c.removeDownloadAppMap(this.f81012c.getPackageUrl_MD5());
        } catch (Throwable unused) {
        }
    }
}
