package p011Oooo00o;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PrepareData;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.integration.utils.k0;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.bridge.MiniAppUpdateBridge;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.proxy.IClientStarter;
import h.c;
import i0.s;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.l;
import lb.g;
import p011Oooo00o.o00Ooo;
import ua.j;
import w.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class o00Ooo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o00Ooo f223a = new o00Ooo();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f224b = LazyKt__LazyJVMKt.b(OooO0O0.OooO00o);

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<ConcurrentHashMap<String, String>> {
        public static final OooO0O0 OooO00o = new OooO0O0();

        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ConcurrentHashMap<String, String> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a extends z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f226b;

        public a(b bVar, String str) {
            this.f225a = bVar;
            this.f226b = str;
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void c() {
            this.f225a.OooO00o();
            o00Ooo.f223a.a().remove(this.f226b);
        }

        /* JADX WARN: Code duplicated, block: B:36:0x005b  */
        /* JADX WARN: Code duplicated, block: B:40:0x0067  */
        /* JADX WARN: Code duplicated, block: B:41:0x006a  */
        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void f(PrepareData prepareData, PrepareException prepareException) {
            String str;
            b bVar = this.f225a;
            o00Ooo o00ooo = o00Ooo.f223a;
            String code = prepareException != null ? prepareException.getCode() : null;
            if (code == null) {
                str = MiniAppUpdateBridge.ERROR_MSG_100013;
            } else {
                int iHashCode = code.hashCode();
                if (iHashCode != 52) {
                    if (iHashCode != 53) {
                        if (iHashCode != 55) {
                            if (iHashCode != 1568) {
                                if (iHashCode == 1571 ? code.equals(PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION) : iHashCode == 1572 && code.equals(PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION)) {
                                    str = MiniAppUpdateBridge.ERROR_MSG_100012;
                                }
                            } else if (code.equals(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY)) {
                                str = MiniAppUpdateBridge.ERROR_MSG_100010;
                            }
                        } else if (code.equals("7")) {
                            str = MiniAppUpdateBridge.ERROR_MSG_100011;
                        }
                        str = MiniAppUpdateBridge.ERROR_MSG_100013;
                    } else if (code.equals("5")) {
                        str = MiniAppUpdateBridge.ERROR_MSG_100011;
                    } else {
                        str = MiniAppUpdateBridge.ERROR_MSG_100013;
                    }
                } else if (code.equals("4")) {
                    str = MiniAppUpdateBridge.ERROR_MSG_100010;
                } else {
                    str = MiniAppUpdateBridge.ERROR_MSG_100013;
                }
            }
            bVar.a(str);
            o00ooo.a().remove(this.f226b);
        }
    }

    public static final void b(String path, AppModel appModel, String root, Bundle startParams, Bundle sceneParams, Context context, j loadCheckCallback) {
        String str;
        String str2;
        Intrinsics.g(path, "$path");
        Intrinsics.g(appModel, "$appModel");
        Intrinsics.g(root, "$root");
        Intrinsics.g(startParams, "$startParams");
        Intrinsics.g(sceneParams, "$sceneParams");
        Intrinsics.g(context, "$context");
        Intrinsics.g(loadCheckCallback, "$loadCheckCallback");
        o00Ooo o00ooo = f223a;
        if (appModel != null) {
            try {
                String appId = appModel.getAppId();
                if (appId == null) {
                    return;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                String str3 = String.format("%s_%s", Arrays.copyOf(new Object[]{appId, root}, 2));
                Intrinsics.f(str3, "format(format, *args)");
                if (o00ooo.a().containsKey(str3)) {
                    return;
                }
                o00ooo.a().put(str3, root);
                try {
                    g gVar = new g(context, appId, startParams, sceneParams, false, null, null, null, 240, null);
                    gVar.u(appModel);
                    String string = context.getString(R$string.dialog_loading_tv);
                    Intrinsics.f(string, "context.getString(R.string.dialog_loading_tv)");
                    n0.j.d(string, o0.a.b.f72240b, 0, 0L, false, null, null, 124);
                    try {
                        str2 = str3;
                        try {
                            ((IClientStarter) tc.a.a(IClientStarter.class)).createSubpackagePrepareController(gVar, new c(gVar, new s(str2, loadCheckCallback, path)), 1, root).start();
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            f223a.a().remove(str2);
                            str = "";
                            try {
                                TmcLogger.h(str, th);
                                return;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str2 = str3;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str = "";
                }
            } catch (Throwable th6) {
                th = th6;
                str = "";
            }
            TmcLogger.h(str, th);
        }
    }

    @JvmStatic
    public static final void c(String appId, String openSubpackageRoot, Bundle startParams, Bundle sceneParams, Context context, b preloadCallback) {
        String str;
        List<SubPackageInfo> subPackagePages;
        Intrinsics.g(appId, "appId");
        Intrinsics.g(openSubpackageRoot, "openSubpackageRoot");
        Intrinsics.g(startParams, "startParams");
        Intrinsics.g(sceneParams, "sceneParams");
        Intrinsics.g(context, "context");
        Intrinsics.g(preloadCallback, "preloadCallback");
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            boolean z11 = false;
            String str2 = String.format("%s_%s", Arrays.copyOf(new Object[]{appId, openSubpackageRoot}, 2));
            Intrinsics.f(str2, "format(format, *args)");
            o00Ooo o00ooo = f223a;
            if (o00ooo.a().containsKey(str2)) {
                ((MiniAppUpdateBridge.b) preloadCallback).a(MiniAppUpdateBridge.ERROR_MSG_10009);
                return;
            }
            o00ooo.a().put(str2, openSubpackageRoot);
            App appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(appId);
            AppModel appModel = appFindApp != null ? appFindApp.getAppModel() : null;
            try {
                if (appModel != null && (subPackagePages = appModel.getSubPackagePages()) != null && !subPackagePages.isEmpty()) {
                    if (d(context, appModel)) {
                        ((MiniAppUpdateBridge.b) preloadCallback).a(MiniAppUpdateBridge.ERROR_MSG_100013);
                        o00ooo.a().remove(str2);
                        return;
                    }
                    List<SubPackageInfo> subPackagePages2 = appModel.getSubPackagePages();
                    if (subPackagePages2 != null) {
                        for (SubPackageInfo subPackageInfo : subPackagePages2) {
                            if (TextUtils.equals(openSubpackageRoot, subPackageInfo.getRoot())) {
                                String subPackageUrlMD5 = subPackageInfo.getSubPackageUrlMD5();
                                if (Intrinsics.b(subPackageUrlMD5 != null ? Boolean.valueOf(k0.f31068a.q(context, appId, subPackageUrlMD5)) : null, Boolean.TRUE)) {
                                    ((MiniAppUpdateBridge.b) preloadCallback).OooO00o();
                                    f223a.a().remove(str2);
                                    return;
                                }
                                z11 = true;
                            }
                        }
                        if (z11) {
                            AppModel appModel2 = appModel;
                            g gVar = new g(context, appId, startParams, sceneParams, false, null, null, null, 240, null);
                            gVar.u(appModel2);
                            ((IClientStarter) tc.a.a(IClientStarter.class)).createSubpackagePrepareController(gVar, new c(gVar, new a(preloadCallback, str2)), 3, openSubpackageRoot).start();
                            return;
                        }
                    }
                    ((MiniAppUpdateBridge.b) preloadCallback).a(MiniAppUpdateBridge.ERROR_MSG_100014);
                    f223a.a().remove(str2);
                    return;
                }
                ((MiniAppUpdateBridge.b) preloadCallback).a(MiniAppUpdateBridge.ERROR_MSG_100013);
                o00ooo.a().remove(str2);
            } catch (Throwable th2) {
                th = th2;
                try {
                    f223a.a().remove(str2);
                    str = "";
                    try {
                        TmcLogger.h(str, th);
                    } catch (Throwable th3) {
                        th = th3;
                        TmcLogger.h(str, th);
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = "";
                }
            }
        } catch (Throwable th5) {
            th = th5;
            str = "";
        }
    }

    @JvmStatic
    public static final boolean d(Context context, AppModel appModel) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        if (!AppUtils.C()) {
            TmcLogger.c("Subpackage::", "检查是否为全量包：true（云控开关未开）");
            return true;
        }
        String mainPackageUrl = appModel.getMainPackageUrl();
        if (mainPackageUrl == null || mainPackageUrl.length() == 0) {
            StringBuilder sbA = hd.j.a("检查是否为全量包：true（appInfo主包地址为空），appVersion：");
            sbA.append(appModel.getDeployVersion());
            TmcLogger.c("Subpackage::", sbA.toString());
            return true;
        }
        if (!h.f31061a.r(context, appModel)) {
            return false;
        }
        StringBuilder sbA2 = hd.j.a("检查是否为全量包：true（本地已有整包资源下载），appVersion：");
        sbA2.append(appModel.getDeployVersion());
        TmcLogger.c("Subpackage::", sbA2.toString());
        return true;
    }

    @JvmStatic
    public static final boolean e(AppModel appModel) {
        String mainPackageUrl;
        return (!AppUtils.C() || appModel == null || (mainPackageUrl = appModel.getMainPackageUrl()) == null || mainPackageUrl.length() == 0) ? false : true;
    }

    @JvmStatic
    public static final boolean f(final String path, final AppModel appModel, final Context context, final Bundle startParams, final Bundle sceneParams, final j loadCheckCallback) {
        List<SubPackageInfo> subPackagePages;
        List<SubPackageInfo> subPackagePages2;
        String subPackageUrlMD5;
        Intrinsics.g(path, "path");
        Intrinsics.g(appModel, "appModel");
        Intrinsics.g(context, "context");
        Intrinsics.g(startParams, "startParams");
        Intrinsics.g(sceneParams, "sceneParams");
        Intrinsics.g(loadCheckCallback, "loadCheckCallback");
        try {
            if (!d(context, appModel) && path.length() != 0 && (subPackagePages = appModel.getSubPackagePages()) != null && !subPackagePages.isEmpty() && (subPackagePages2 = appModel.getSubPackagePages()) != null) {
                for (SubPackageInfo subPackageInfo : subPackagePages2) {
                    final String root = subPackageInfo.getRoot();
                    if (root != null && l.L(path, root, false, 2, null) && (subPackageUrlMD5 = subPackageInfo.getSubPackageUrlMD5()) != null) {
                        if (!k0.f31068a.q(context, appModel.getAppId(), subPackageUrlMD5)) {
                            e.a(ExecutorType.IO, new Runnable() { // from class: i0.n
                                @Override // java.lang.Runnable
                                public final void run() {
                                    o00Ooo.b(path, appModel, root, startParams, sceneParams, context, loadCheckCallback);
                                }
                            });
                            return true;
                        }
                        return false;
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.h("", th2);
        }
        return false;
    }

    public final ConcurrentHashMap<String, String> a() {
        return (ConcurrentHashMap) f224b.getValue();
    }
}
