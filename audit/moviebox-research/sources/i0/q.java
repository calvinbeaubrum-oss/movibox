package i0;

import android.app.Application;
import android.content.Context;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.proxy.FileProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.a0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.e0;
import com.transsion.push.PushConstants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f66855a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f66856b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PathProxy f66857c = (PathProxy) tc.a.a(PathProxy.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FileProxy f66858d = (FileProxy) tc.a.a(FileProxy.class);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TmcAppInfoManager f66859e = (TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class);

    public static final void d(AppModel appModel, Context context, boolean z11, boolean z12, boolean z13, String str) {
        Intrinsics.g(appModel, "$appModel");
        Intrinsics.g(context, "$context");
        if (!z13) {
            if (!z11) {
                f66856b.add(appModel.getAppId());
            }
            if (z12) {
                f66855a.b(context, appModel);
                return;
            }
            return;
        }
        q qVar = f66855a;
        TmcLogger.c("PreUnzipUtil", ':' + appModel.getAppId() + ": tar 包解压完成");
        try {
            com.cloud.tmc.integration.utils.h hVar = com.cloud.tmc.integration.utils.h.f31061a;
            if (!Intrinsics.b(a0.f31025a.b(hVar.t(appModel), PushConstants.PROVIDER_FIELD_APP_ID), appModel.getAppId())) {
                qVar.b(context, appModel);
                return;
            }
            TmcLogger.c("PreUnzipUtil", ':' + appModel.getAppId() + ": manifest 内容校验成功");
            hVar.m(context, appModel, true);
            f66858d.delectDownloadFileForVersion(appModel);
            TmcAppInfoManager tmcAppInfoManager = f66859e;
            tmcAppInfoManager.delectOldVersionFilesAndUpdate(context, appModel);
            TmcLogger.c("PreUnzipUtil", "存入 的 used" + MiniAppLaunch.f31784a.O(appModel));
            tmcAppInfoManager.updateAppModel(context, appModel, appModel.getAppId() + "_used");
            String appId = appModel.getAppId();
            if (appId != null) {
                tmcAppInfoManager.updatePreUnzipStatus(context, appId, true);
            }
            f66856b.remove(appModel.getAppId());
        } catch (Throwable unused) {
            f66855a.b(context, appModel);
        }
    }

    public static /* synthetic */ void e(q qVar, Context context, AppModel appModel, boolean z11, boolean z12, int i11) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        if ((i11 & 8) != 0) {
            z12 = true;
        }
        qVar.f(context, appModel, z11, z12);
    }

    public static final void g(AppModel appModel, Context context, boolean z11, boolean z12, boolean z13, String str) {
        Intrinsics.g(appModel, "$appModel");
        Intrinsics.g(context, "$context");
        if (!z13) {
            q qVar = f66855a;
            TmcLogger.c("PreUnzipUtil", appModel.getAppId() + " unzip error ");
            if (z11) {
                return;
            }
            TmcLogger.c("PreUnzipUtil", appModel.getAppId() + " unzip retry");
            f66856b.add(appModel.getAppId());
            qVar.b(context, appModel);
            return;
        }
        q qVar2 = f66855a;
        StringBuilder sbA = hd.j.a("pre unzip :");
        sbA.append(appModel.getAppId());
        sbA.append(" zip 包解压完成");
        TmcLogger.c("PreUnzipUtil", sbA.toString());
        com.cloud.tmc.integration.utils.h hVar = com.cloud.tmc.integration.utils.h.f31061a;
        if (!hVar.p(appModel)) {
            StringBuilder sbA2 = hd.j.a(" :");
            sbA2.append(appModel.getAppId());
            sbA2.append(" sha256 校验不一致，删除所有缓存");
            TmcLogger.c("PreUnzipUtil", sbA2.toString());
            hVar.s(context, appModel);
            return;
        }
        TmcLogger.c("PreUnzipUtil", ':' + appModel.getAppId() + " sha256 校验正确，解压 tar 包");
        qVar2.c(context, appModel, z11, z12);
    }

    public final void a(Application application, List preUnzipList) {
        Unit unit;
        Intrinsics.g(application, "application");
        Intrinsics.g(preUnzipList, "preUnzipList");
        TmcAppInfoManager tmcAppInfoManager = (TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class);
        TmcResourceManager tmcResourceManager = (TmcResourceManager) tc.a.a(TmcResourceManager.class);
        Iterator it = preUnzipList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            AppModel appModel = tmcAppInfoManager.getAppModel(application, lb.a.f70163b.a(str));
            if (appModel != null) {
                Intrinsics.f(appModel, "appModel");
                if (com.cloud.tmc.integration.utils.h.f31061a.q(application, appModel)) {
                    hd.k.a(str, " 已解压，跳过预解压步骤", "PreUnzipUtil");
                } else {
                    int fromCacheType = appModel.getFromCacheType();
                    if (fromCacheType == 3) {
                        MiniAppLaunch.f31784a.o(appModel);
                        if (tmcResourceManager.getNativeCache(application, appModel)) {
                            q qVar = f66855a;
                            TmcLogger.c("PreUnzipUtil", "CACHE_TYPE_NATIVE_unzip");
                            e(qVar, application, appModel, false, false, 12);
                        }
                    } else if (fromCacheType == 4) {
                        MiniAppLaunch.f31784a.o(appModel);
                        if (tmcResourceManager.getOfflineCache(application, appModel)) {
                            q qVar2 = f66855a;
                            TmcLogger.c("PreUnzipUtil", "CACHE_TYPE_OFFLINE_unzip");
                            e(qVar2, application, appModel, false, false, 12);
                        }
                    } else if (tmcResourceManager.isDownloaded(application, appModel)) {
                        q qVar3 = f66855a;
                        TmcLogger.c("PreUnzipUtil", "CACHE_TYPE_DOWNLOAD_unzip");
                        e(qVar3, application, appModel, false, false, 12);
                    }
                }
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            if (unit == null) {
                TmcLogger.c("PreUnzipUtil", "it-> " + str + " appmodel is null");
            }
        }
    }

    public final void b(Context context, AppModel appModel) {
        String appId = appModel.getAppId();
        if (appId != null) {
            try {
                if (appModel.getFromCacheType() == 3) {
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(e0.a(), appId, "isReadAssets_" + appId + '_' + AppDynamicBuildConfig.s(), false);
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(e0.a(), appId, appId + "_native_" + AppDynamicBuildConfig.s(), "");
                }
                com.cloud.tmc.integration.utils.h hVar = com.cloud.tmc.integration.utils.h.f31061a;
                hVar.o(context, appModel, false);
                hVar.m(context, appModel, false);
                PathProxy pathProxy = f66857c;
                com.cloud.tmc.miniutils.util.j.n(pathProxy.getTarUnCompressPath(appModel));
                com.cloud.tmc.miniutils.util.j.n(pathProxy.getZipUnCompressPath(appModel));
            } catch (Throwable unused) {
                TmcLogger.f("PreUnzipUtil", "native assets remove error " + appId);
                Unit unit = Unit.f68710a;
            }
        }
    }

    public final void c(final Context context, final AppModel appModel, final boolean z11, final boolean z12) {
        ((TmcResourceManager) tc.a.a(TmcResourceManager.class)).installApp(appModel, new ua.o() { // from class: i0.p
            @Override // ua.o
            public final void a(boolean z13, String str) {
                q.d(appModel, context, z11, z12, z13, str);
            }
        });
    }

    @JvmOverloads
    public final void f(final Context context, final AppModel appModel, final boolean z11, final boolean z12) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        ((TmcResourceManager) tc.a.a(TmcResourceManager.class)).installZip(context, appModel, new ua.o() { // from class: i0.o
            @Override // ua.o
            public final void a(boolean z13, String str) {
                q.g(appModel, context, z11, z12, z13, str);
            }
        });
    }
}
