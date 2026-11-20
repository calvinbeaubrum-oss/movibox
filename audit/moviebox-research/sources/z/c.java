package z;

import android.content.Context;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.utils.a0;
import com.cloud.tmc.integration.utils.k0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.transsion.push.PushConstants;
import hd.j;
import kotlin.jvm.internal.Intrinsics;
import ua.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f81654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppModel f81655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f81656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f81657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PrepareController f81658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ lb.g f81659f;

    public c(d dVar, AppModel appModel, String str, Context context, PrepareController prepareController, lb.g gVar) {
        this.f81654a = dVar;
        this.f81655b = appModel;
        this.f81656c = str;
        this.f81657d = context;
        this.f81658e = prepareController;
        this.f81659f = gVar;
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
    @Override // ua.o
    public void a(boolean z11, String str) {
        if (!z11) {
            this.f81654a.e(this.f81659f, this.f81655b, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "INSTALL_APP_FAIL");
            d dVar = this.f81654a;
            lb.g gVar = this.f81659f;
            PrepareController prepareController = this.f81658e;
            AppModel appModel = this.f81655b;
            StringBuilder sbA = j.a(MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR);
            sbA.append(this.f81655b.getPackageUrl());
            dVar.g(gVar, prepareController, appModel, "5", sbA.toString());
            return;
        }
        TmcLogger.c(this.f81654a.f31599a, "Step_LoadStep: tar 包解压完成");
        try {
            k0 k0Var = k0.f31068a;
            if (!Intrinsics.b(a0.f31025a.b(k0Var.u(this.f81655b, this.f81656c), PushConstants.PROVIDER_FIELD_APP_ID), this.f81655b.getAppId())) {
                k0Var.r(this.f81657d, this.f81655b, this.f81656c);
                this.f81658e.moveToError(new PrepareException(PrepareException.ERROR_MANIFEST_INFO, "manifest error"));
                this.f81654a.e(this.f81659f, this.f81655b, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "MANIFEST_FAIL");
                return;
            }
            this.f81654a.e(this.f81659f, this.f81655b, PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS, null);
            TmcLogger.c(this.f81654a.f31599a, "Step_LoadStep: manifest 内容校验成功");
            k0Var.b(this.f81657d, this.f81655b.getAppId(), this.f81656c, true);
            this.f81654a.f31603e.deleteDownloadFileForVersion(this.f81655b, this.f81656c);
            d dVar2 = this.f81654a;
            if (!dVar2.f81662k.f81688b) {
                TmcAppInfoManager tmcAppInfoManager = dVar2.f31600b;
                Context context = this.f81657d;
                AppModel appModel2 = this.f81655b;
                Integer num = dVar2.f81661j;
                tmcAppInfoManager.deleteOldVersionFiles(context, appModel2, num != null && num.intValue() == 1);
                d dVar3 = this.f81654a;
                dVar3.f31600b.updateOldVersion(this.f81657d, this.f81655b, dVar3.f81660i);
            }
            PrepareController prepareController2 = this.f81658e;
            prepareController2.unlock(prepareController2);
            this.f81658e.moveToNext();
        } catch (Throwable unused) {
            this.f81654a.e(this.f81659f, this.f81655b, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "MANIFEST_FAIL");
            this.f81654a.g(this.f81659f, this.f81658e, this.f81655b, PrepareException.ERROR_MANIFEST_INFO, "manifest error");
        }
    }
}
