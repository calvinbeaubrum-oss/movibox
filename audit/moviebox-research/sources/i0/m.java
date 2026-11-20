package i0;

import android.content.Context;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.proxy.FileProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.a0;
import com.cloud.tmc.integration.utils.k0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.e0;
import com.transsion.push.PushConstants;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f66835a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f66836b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PathProxy f66837c = (PathProxy) tc.a.a(PathProxy.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FileProxy f66838d = (FileProxy) tc.a.a(FileProxy.class);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TmcAppInfoManager f66839e = (TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class);

    public static final void c(AppModel appModel, Context context, SubPackageInfo subPackageInfo, boolean z11, boolean z12, boolean z13, String str) {
        Intrinsics.g(appModel, "$appModel");
        Intrinsics.g(context, "$context");
        if (z13) {
            StringBuilder sbA = hd.j.a("pre unzip :");
            sbA.append(appModel.getAppId());
            sbA.append(" zip 包解压完成");
            TmcLogger.c("SubpackagePreUnzipUtil", sbA.toString());
            f66835a.b(context, appModel, subPackageInfo, z11, z12);
            return;
        }
        TmcLogger.c("SubpackagePreUnzipUtil", appModel.getAppId() + " unzip error ");
        if (z11) {
            return;
        }
        TmcLogger.c("SubpackagePreUnzipUtil", appModel.getAppId() + " unzip retry");
        f66836b.add(AppUtils.p(AppUtils.f31011a, appModel, subPackageInfo, null, 4, null));
        f66835a.a(context, appModel, subPackageInfo);
    }

    public static final void d(AppModel appModel, SubPackageInfo subPackageInfo, Context context, boolean z11, boolean z12, boolean z13, String str) {
        Intrinsics.g(appModel, "$appModel");
        Intrinsics.g(context, "$context");
        AppUtils appUtils = AppUtils.f31011a;
        String strM = AppUtils.m(appUtils, appModel, subPackageInfo, null, 4, null);
        String strK = AppUtils.k(appUtils, appModel, subPackageInfo, null, 4, null);
        String strP = AppUtils.p(appUtils, appModel, subPackageInfo, null, 4, null);
        if (!z13) {
            if (!z11) {
                f66836b.add(strP);
            }
            if (z12) {
                f66835a.a(context, appModel, subPackageInfo);
                return;
            }
            return;
        }
        TmcLogger.c("SubpackagePreUnzipUtil", ':' + strM + ": tar 包解压完成");
        try {
            k0 k0Var = k0.f31068a;
            if (!Intrinsics.b(a0.f31025a.b(k0Var.u(appModel, strK), PushConstants.PROVIDER_FIELD_APP_ID), appModel.getAppId())) {
                f66835a.a(context, appModel, subPackageInfo);
                return;
            }
            TmcLogger.c("SubpackagePreUnzipUtil", ':' + appModel.getAppId() + ": manifest 内容校验成功");
            k0Var.b(context, appModel.getAppId(), strK, true);
            f66838d.deleteDownloadFileForVersion(appModel, strK);
            TmcAppInfoManager tmcAppInfoManager = f66839e;
            tmcAppInfoManager.deleteOldVersionFiles(context, appModel, false);
            tmcAppInfoManager.updateOldVersion(context, appModel, subPackageInfo != null ? subPackageInfo.getRoot() : null);
            TmcLogger.c("SubpackagePreUnzipUtil", "存入 的 used" + MiniAppLaunch.f31784a.O(appModel));
            TmcLogger.c("Subpackage::", "backgroundUnZip:finish update used;deployVersion:" + appModel.getDeployVersion() + ";mainPkgUrl:" + appModel.getMainPackageUrl() + ";fullPkgUrl:" + appModel.getPackageUrl());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(appModel.getAppId());
            sb2.append("_used");
            tmcAppInfoManager.updateAppModel(context, appModel, sb2.toString());
            if (appModel.getAppId() != null) {
                tmcAppInfoManager.updatePreUnzipStatus(context, strP, true);
            }
            f66836b.remove(strP);
            k0Var.m(context, appModel.getAppId(), strK, true);
        } catch (Throwable unused) {
            f66835a.a(context, appModel, subPackageInfo);
        }
    }

    public static final void f(AppModel appModel, Context context, SubPackageInfo subPackageInfo, boolean z11, boolean z12, boolean z13, String str) {
        Intrinsics.g(appModel, "$appModel");
        Intrinsics.g(context, "$context");
        if (z13) {
            StringBuilder sbA = hd.j.a("pre unzip :");
            sbA.append(appModel.getAppId());
            sbA.append(" zip 包解压完成");
            TmcLogger.c("SubpackagePreUnzipUtil", sbA.toString());
            f66835a.b(context, appModel, subPackageInfo, z11, z12);
            return;
        }
        TmcLogger.c("SubpackagePreUnzipUtil", appModel.getAppId() + " unzip error ");
        if (z11) {
            return;
        }
        TmcLogger.c("SubpackagePreUnzipUtil", appModel.getAppId() + " unzip retry");
        f66836b.add(AppUtils.p(AppUtils.f31011a, appModel, subPackageInfo, null, 4, null));
        f66835a.a(context, appModel, subPackageInfo);
    }

    public final void a(Context context, AppModel appModel, SubPackageInfo subPackageInfo) {
        String appId = appModel.getAppId();
        if (appId != null) {
            try {
                String strK = AppUtils.k(AppUtils.f31011a, appModel, subPackageInfo, null, 4, null);
                if (appModel.getFromCacheType() == 3) {
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(e0.a(), appId, "isReadAssets_" + appId + '_' + AppDynamicBuildConfig.s(), false);
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(e0.a(), appId, appId + "_native_" + AppDynamicBuildConfig.s(), "");
                }
                k0 k0Var = k0.f31068a;
                k0Var.d(context, appId, strK, false);
                k0Var.b(context, appId, strK, false);
                PathProxy pathProxy = f66837c;
                com.cloud.tmc.miniutils.util.j.n(pathProxy.getTarUnCompressPath(appModel, strK));
                com.cloud.tmc.miniutils.util.j.n(pathProxy.getZipUnCompressPath(appId, strK));
            } catch (Throwable unused) {
                TmcLogger.f("SubpackagePreUnzipUtil", "native assets remove error " + appId);
                Unit unit = Unit.f68710a;
            }
        }
    }

    public final void b(Context context, AppModel appModel, SubPackageInfo subPackageInfo, boolean z11, boolean z12) {
        k0 k0Var = k0.f31068a;
        if (!k0Var.p(appModel, subPackageInfo)) {
            StringBuilder sbA = hd.j.a(" :");
            sbA.append(appModel.getAppId());
            sbA.append(" sha256 校验不一致，删除所有缓存");
            TmcLogger.c("SubpackagePreUnzipUtil", sbA.toString());
            k0Var.r(context, appModel, AppUtils.k(AppUtils.f31011a, appModel, subPackageInfo, null, 4, null));
            return;
        }
        TmcLogger.c("SubpackagePreUnzipUtil", ':' + appModel.getAppId() + " sha256 校验正确，解压 tar 包");
        g(context, appModel, subPackageInfo, z11, z12);
    }

    @JvmOverloads
    public final void e(final Context context, final AppModel appModel, final SubPackageInfo subPackageInfo, final boolean z11, final boolean z12) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        ((TmcResourceManager) tc.a.a(TmcResourceManager.class)).installZip(context, appModel, false, subPackageInfo, new ua.o() { // from class: i0.l
            @Override // ua.o
            public final void a(boolean z13, String str) {
                m.c(appModel, context, subPackageInfo, z11, z12, z13, str);
            }
        });
    }

    public final void g(final Context context, final AppModel appModel, final SubPackageInfo subPackageInfo, final boolean z11, final boolean z12) {
        ((TmcResourceManager) tc.a.a(TmcResourceManager.class)).installApp(appModel, false, subPackageInfo, new ua.o() { // from class: i0.k
            @Override // ua.o
            public final void a(boolean z13, String str) {
                m.d(appModel, subPackageInfo, context, z11, z12, z13, str);
            }
        });
    }

    @JvmOverloads
    public final void h(final Context context, final AppModel appModel, final SubPackageInfo subPackageInfo, final boolean z11, final boolean z12) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        ((TmcResourceManager) tc.a.a(TmcResourceManager.class)).installZip(context, appModel, false, subPackageInfo, new ua.o() { // from class: i0.j
            @Override // ua.o
            public final void a(boolean z13, String str) {
                m.f(appModel, context, subPackageInfo, z11, z12, z13, str);
            }
        });
    }
}
