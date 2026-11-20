package com.cloud.tmc.integration.utils;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.hisavana.sdk.r2;
import com.cloud.hisavana.sdk.x2;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.R$string;
import com.cloud.tmc.integration.broadcast.ShortCutBroadcast;
import com.cloud.tmc.integration.model.AddToHomeScreenStore;
import com.cloud.tmc.integration.model.MiniAddHomeDataModel;
import com.cloud.tmc.integration.model.MiniAddHomeModel;
import com.cloud.tmc.integration.proxy.DialogProxy;
import com.cloud.tmc.integration.proxy.ITaskQueueProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.proxy.StartActivityProxy;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniutils.util.ImageUtils;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.push.PushConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class AddHomeToScreenUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AddHomeToScreenUtils f30986a = new AddHomeToScreenUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f30987b = "AddHomeToScreenUtils";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f30988c = new CopyOnWriteArraySet();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f30989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30991c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ShortcutManager f30992d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f30993e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ bc.a f30994f;

        public a(Context context, String str, String str2, ShortcutManager shortcutManager, String str3, bc.a aVar) {
            this.f30989a = context;
            this.f30990b = str;
            this.f30991c = str2;
            this.f30992d = shortcutManager;
            this.f30993e = str3;
            this.f30994f = aVar;
        }

        @Override // com.cloud.tmc.integration.utils.o.a
        public void onFail() {
            TmcLogger.c(AddHomeToScreenUtils.f30987b, "add shortcut fail,appId:" + this.f30990b);
            bc.a aVar = this.f30994f;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.cloud.tmc.integration.utils.o.a
        public void onSuccess(String path) {
            Intrinsics.g(path, "path");
            AddHomeToScreenUtils addHomeToScreenUtils = AddHomeToScreenUtils.f30986a;
            Context context = this.f30989a;
            String str = this.f30990b;
            String str2 = this.f30991c;
            ShortcutManager sm2 = this.f30992d;
            Intrinsics.f(sm2, "sm");
            addHomeToScreenUtils.x(context, str, str2, path, sm2, this.f30993e, this.f30994f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ua.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MiniAddHomeDataModel f30995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f30997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f30998d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Class<?> f30999e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f31000f;

        public b(MiniAddHomeDataModel miniAddHomeDataModel, String str, int i11, Context context, Class<?> cls, boolean z11) {
            this.f30995a = miniAddHomeDataModel;
            this.f30996b = str;
            this.f30997c = i11;
            this.f30998d = context;
            this.f30999e = cls;
            this.f31000f = z11;
        }

        @Override // ua.k
        public void a() {
            AddToHomeScreenStore addToHomeScreenStore;
            HashMap<String, bc.a> store;
            bc.a aVarRemove;
            try {
                App app = o.f31082a.f().get(this.f30995a.getAppId());
                if (app == null || (addToHomeScreenStore = (AddToHomeScreenStore) app.getData(AddToHomeScreenStore.class)) == null || (store = addToHomeScreenStore.getStore()) == null || (aVarRemove = store.remove(this.f30995a.getAppId())) == null) {
                    return;
                }
                JsonObject jsonObject = new JsonObject();
                Context context = this.f30998d;
                MiniAddHomeDataModel miniAddHomeDataModel = this.f30995a;
                TmcLogger.c(AddHomeToScreenUtils.f30987b, "发送 addHomeToScreen callback received");
                jsonObject.addProperty("isExist", Boolean.valueOf(AppUtils.f31011a.v(context, miniAddHomeDataModel.getAppId())));
                aVarRemove.d(jsonObject);
            } catch (Throwable th2) {
                TmcLogger.h(AddHomeToScreenUtils.f30987b, th2);
            }
        }

        @Override // ua.k
        public void c(Object obj) {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            String appId = this.f30995a.getAppId();
            Bundle bundle = new Bundle();
            bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, this.f30996b);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.recordForCommon(appId, "second_add_cl", bundle);
            AddHomeToScreenUtils.f30986a.w(this.f30995a, this.f30996b, this.f30997c, this.f30998d, this.f30999e, this.f31000f);
        }
    }

    public static /* synthetic */ void B(AddHomeToScreenUtils addHomeToScreenUtils, Context context, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            str4 = "";
        }
        addHomeToScreenUtils.A(context, str, str2, str3, str4);
    }

    public static final void C(String appId, String appLogoMd5, String appName, Context context, String appLogoUrl) {
        Intrinsics.g(appId, "$appId");
        Intrinsics.g(appLogoMd5, "$appLogoMd5");
        Intrinsics.g(appName, "$appName");
        Intrinsics.g(context, "$context");
        Intrinsics.g(appLogoUrl, "$appLogoUrl");
        try {
            if (appId.length() == 0) {
                TmcLogger.c(f30987b, "updateAddHomeNameAndIcon appId is empty");
                return;
            }
            if (appLogoMd5.length() == 0) {
                appLogoMd5 = com.cloud.tmc.miniutils.util.h.b(appLogoUrl);
            }
            TmcLogger.c(f30987b, "updateAddHomeNameAndIcon -> appid: " + appId + ",appName:" + appName + ",appLogoMd5:" + appLogoMd5);
            KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("addHomeName_");
            sb2.append(appId);
            kVStorageProxy.putString(context, "miniKeyStorageAddHome", sb2.toString(), appName);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, "miniKeyStorageAddHome", "addHomeLogo_" + appId, appLogoMd5);
        } catch (Throwable th2) {
            TmcLogger.g(f30987b, "updateAddHomeNameAndIcon", th2);
        }
    }

    public static /* synthetic */ void p(AddHomeToScreenUtils addHomeToScreenUtils, Context context, MiniAddHomeDataModel miniAddHomeDataModel, String str, boolean z11, boolean z12, App app, int i11, Object obj) {
        boolean z13 = (i11 & 8) != 0 ? false : z11;
        boolean z14 = (i11 & 16) != 0 ? true : z12;
        if ((i11 & 32) != 0) {
            app = null;
        }
        addHomeToScreenUtils.o(context, miniAddHomeDataModel, str, z13, z14, app);
    }

    public static final void r(MiniAddHomeDataModel miniAddHomeDataModel, String miniAppIconPath, o.a aVar, Context context) {
        Intrinsics.g(miniAppIconPath, "$miniAppIconPath");
        Intrinsics.g(context, "$context");
        String strB = com.cloud.tmc.miniutils.util.h.b(miniAddHomeDataModel.getAppLogoUrl());
        Intrinsics.f(strB, "encryptMD5ToString(bean.appLogoUrl)");
        String lowerCase = strB.toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        try {
            if (com.cloud.tmc.miniutils.util.u.a("mini_offline/miniapp_addhome/" + o.f31082a.g() + lowerCase + ".png", miniAppIconPath)) {
                TmcLogger.c(f30987b, "use assets icon ->" + miniAddHomeDataModel.getAppId());
                f30988c.remove(miniAddHomeDataModel.getAppId());
                if (aVar != null) {
                    aVar.onSuccess(miniAppIconPath);
                    return;
                }
                return;
            }
        } catch (Throwable th2) {
            TmcLogger.h(f30987b, th2);
        }
        TmcLogger.c(f30987b, "download icon ->" + miniAddHomeDataModel.getAppId());
        f30986a.s(context, miniAddHomeDataModel, miniAppIconPath, aVar);
    }

    public static final void t(Context context, MiniAddHomeDataModel appModel, o.a aVar, String miniAppIconPath) {
        Unit unit;
        Intrinsics.g(context, "$context");
        Intrinsics.g(appModel, "$appModel");
        Intrinsics.g(miniAppIconPath, "$miniAppIconPath");
        boolean zI = o.f31082a.i(context, xb.e.a(appModel.getAppLogoUrl(), ""), aVar);
        try {
            try {
                File fileLoadImgFile = ((ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class)).loadImgFile(context, xb.e.a(appModel.getAppLogoUrl(), ""));
                if (fileLoadImgFile != null) {
                    boolean zH = xb.b.h(fileLoadImgFile, new File(miniAppIconPath), false, false, 6, null);
                    if (!zI) {
                        if (zH) {
                            if (aVar != null) {
                                aVar.onSuccess(miniAppIconPath);
                            }
                        } else if (aVar != null) {
                            aVar.onFail();
                        }
                    }
                    unit = Unit.f68710a;
                } else {
                    unit = null;
                }
                if (unit == null && !zI && aVar != null) {
                    aVar.onFail();
                }
                Set<String> set = f30988c;
                if (set.contains(appModel.getAppId())) {
                    set.remove(appModel.getAppId());
                }
            } catch (Throwable th2) {
                TmcLogger.g(f30987b, "downloadMiniAppIconFile", th2);
            }
        } catch (Throwable th3) {
            try {
                TmcLogger.g(f30987b, "downloadMiniAppIconFile", th3);
                if (!zI && aVar != null) {
                    aVar.onFail();
                }
                Set<String> set2 = f30988c;
                if (set2.contains(appModel.getAppId())) {
                    set2.remove(appModel.getAppId());
                }
            } catch (Throwable th4) {
                try {
                    Set<String> set3 = f30988c;
                    if (set3.contains(appModel.getAppId())) {
                        set3.remove(appModel.getAppId());
                    }
                } catch (Throwable th5) {
                    TmcLogger.g(f30987b, "downloadMiniAppIconFile", th5);
                }
                throw th4;
            }
        }
    }

    public final void A(final Context context, final String appId, final String appName, final String appLogoMd5, final String appLogoUrl) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(appName, "appName");
        Intrinsics.g(appLogoMd5, "appLogoMd5");
        Intrinsics.g(appLogoUrl, "appLogoUrl");
        try {
            com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.utils.e
                @Override // java.lang.Runnable
                public final void run() {
                    AddHomeToScreenUtils.C(appId, appLogoMd5, appName, context, appLogoUrl);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g(f30987b, "updateAddHomeNameAndIcon", th2);
        }
    }

    public final boolean i(int i11, App app) {
        if (app == null) {
            return false;
        }
        boolean addHomeShowStatus = i11 <= 100 ? app.getAddHomeShowStatus(100) : false;
        if (addHomeShowStatus) {
            return true;
        }
        if (i11 <= 90) {
            addHomeShowStatus = app.getAddHomeShowStatus(90);
        }
        if (addHomeShowStatus) {
            return true;
        }
        if (i11 <= 83) {
            addHomeShowStatus = app.getAddHomeShowStatus(83);
        }
        if (addHomeShowStatus) {
            return true;
        }
        if (i11 <= 82) {
            addHomeShowStatus = app.getAddHomeShowStatus(82);
        }
        if (addHomeShowStatus) {
            return true;
        }
        if (i11 <= 81) {
            addHomeShowStatus = app.getAddHomeShowStatus(82);
        }
        return addHomeShowStatus;
    }

    @RequiresApi(26)
    public final void j(Context context, String appId, String appName, String appLogoUrl, String currentLogoUrlMd5, bc.a aVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(appName, "appName");
        Intrinsics.g(appLogoUrl, "appLogoUrl");
        Intrinsics.g(currentLogoUrlMd5, "currentLogoUrlMd5");
        ShortcutManager shortcutManagerA = com.bytedance.sdk.openadsdk.api.init.b.a(context.getSystemService(com.bytedance.sdk.openadsdk.api.init.a.a()));
        if (shortcutManagerA == null || !shortcutManagerA.isRequestPinShortcutSupported()) {
            TmcLogger.c(f30987b, "checkAndUpdateScreenIcon: not support");
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        String str = ((PathProxy) tc.a.a(PathProxy.class)).getBaseMiniAppPath(appId) + File.separator + Uri.parse(appLogoUrl).getLastPathSegment();
        if (new File(str).exists()) {
            x(context, appId, appName, str, shortcutManagerA, currentLogoUrlMd5, aVar);
        } else {
            s(context, new MiniAddHomeDataModel(appId, appName, appLogoUrl), str, new a(context, appId, appName, shortcutManagerA, currentLogoUrlMd5, aVar));
        }
    }

    public final void k(Context context, String appId, String appName, String appLogoUrl, bc.a aVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(appName, "appName");
        Intrinsics.g(appLogoUrl, "appLogoUrl");
        try {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 < 26) {
                TmcLogger.c(f30987b, "checkAndUpdateScreenIcon: api < 26");
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            if (!AppUtils.f31011a.w(context, appId)) {
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "miniKeyStorageAddHome", "addHomeStatus_" + appId, false);
                if (aVar != null) {
                    aVar.b();
                }
                TmcLogger.c(f30987b, "checkAndUpdateScreenIcon -> " + appId + " is not add to home screen");
                return;
            }
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "miniKeyStorageAddHome", "addHomeStatus_" + appId, true);
            if (!MiniAppConfigHelper.f30370a.b("enableUpdateAddHome", true)) {
                TmcLogger.c(f30987b, "updateScreenIcon: enable is false, return");
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            if (appId.length() == 0) {
                if (aVar != null) {
                    aVar.b();
                }
                TmcLogger.c(f30987b, "checkAndUpdateScreenIcon -> appId is null");
                return;
            }
            String currentLogoUrlMd5 = com.cloud.tmc.miniutils.util.h.b(appLogoUrl);
            if (appName.length() != 0 && appLogoUrl.length() != 0) {
                if (!m(context, appId, appName)) {
                    Intrinsics.f(currentLogoUrlMd5, "currentLogoUrlMd5");
                    if (!l(context, appId, currentLogoUrlMd5)) {
                        return;
                    }
                }
                if (i11 >= 26) {
                    Intrinsics.f(currentLogoUrlMd5, "currentLogoUrlMd5");
                    j(context, appId, appName, appLogoUrl, currentLogoUrlMd5, aVar);
                    return;
                }
                return;
            }
            TmcLogger.c(f30987b, "checkAndUpdateScreenIcon -> appName or logo is null,appName->" + appName + ",appLogoUrl->" + appLogoUrl);
            if (aVar != null) {
                aVar.b();
            }
        } catch (Throwable th2) {
            TmcLogger.g(f30987b, "checkAndUpdateScreenIcon", th2);
        }
    }

    public final boolean l(Context context, String str, String str2) {
        try {
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniKeyStorageAddHome", "addHomeLogo_" + str);
            if (string == null) {
                string = "";
            }
            boolean z11 = !Intrinsics.b(str2, string);
            TmcLogger.c(f30987b, "checkAppLogoIsChanged return " + z11);
            return z11;
        } catch (Throwable th2) {
            TmcLogger.g(f30987b, "checkAppLogoIsChanged:", th2);
            return false;
        }
    }

    public final boolean m(Context context, String str, String str2) {
        try {
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniKeyStorageAddHome", "addHomeName_" + str);
            if (string == null) {
                string = "";
            }
            boolean z11 = !Intrinsics.b(string, str2);
            TmcLogger.c(f30987b, "checkAppNameIsChanged -> return " + z11);
            return z11;
        } catch (Throwable th2) {
            TmcLogger.g(f30987b, "checkAppNameIsChanged", th2);
            return false;
        }
    }

    public final Bitmap n(String str) {
        return ImageUtils.b(str);
    }

    public final void o(Context context, MiniAddHomeDataModel bean, String fromLocation, boolean z11, boolean z12, App app) {
        AddToHomeScreenStore addToHomeScreenStore;
        HashMap<String, bc.a> store;
        bc.a aVarRemove;
        Intrinsics.g(context, "context");
        Intrinsics.g(bean, "bean");
        Intrinsics.g(fromLocation, "fromLocation");
        AppUtils appUtils = AppUtils.f31011a;
        boolean zE = appUtils.e(context, z11);
        String str = f30987b;
        TmcLogger.c(str, "showAddHomeCustomDialog = " + zE);
        Class<?> launcherShortCutActivity = ((StartActivityProxy) tc.a.a(StartActivityProxy.class)).getLauncherShortCutActivity();
        Intrinsics.f(launcherShortCutActivity, "get(StartActivityProxy::….launcherShortCutActivity");
        if (!zE) {
            w(bean, fromLocation, -1, context, launcherShortCutActivity, z12);
            return;
        }
        if (!i(90, app)) {
            ((DialogProxy) tc.a.a(DialogProxy.class)).showAddHomeConfirmDialog(context, bean.getAppName(), bean.getAppLogoUrl(), bean.getAppId(), fromLocation, new b(bean, fromLocation, -1, context, launcherShortCutActivity, z12));
            if (app != null) {
                app.updateAddHomeShowStatus(90);
                return;
            }
            return;
        }
        App app2 = o.f31082a.f().get(bean.getAppId());
        if (app2 == null || (addToHomeScreenStore = (AddToHomeScreenStore) app2.getData(AddToHomeScreenStore.class)) == null || (store = addToHomeScreenStore.getStore()) == null || (aVarRemove = store.remove(bean.getAppId())) == null) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        TmcLogger.c(str, "发送 addHomeToScreen callback received");
        jsonObject.addProperty("isExist", Boolean.valueOf(appUtils.v(context, bean.getAppId())));
        aVarRemove.d(jsonObject);
    }

    public final void q(final Context context, final MiniAddHomeDataModel miniAddHomeDataModel, final o.a aVar) {
        try {
            if (miniAddHomeDataModel == null) {
                if (aVar != null) {
                    aVar.onFail();
                    return;
                }
                return;
            }
            final String str = ((PathProxy) tc.a.a(PathProxy.class)).getBaseMiniAppPath(miniAddHomeDataModel.getAppId()) + File.separator + Uri.parse(miniAddHomeDataModel.getAppLogoUrl()).getLastPathSegment();
            if (new File(str).exists()) {
                if (aVar != null) {
                    aVar.onSuccess(str);
                    return;
                }
                return;
            }
            if (miniAddHomeDataModel.getAppId().length() == 0) {
                if (aVar != null) {
                    aVar.onFail();
                    return;
                }
                return;
            }
            Set<String> set = f30988c;
            if (set.contains(miniAddHomeDataModel.getAppId())) {
                return;
            }
            set.add(miniAddHomeDataModel.getAppId());
            if (MiniAppConfigHelper.f30370a.b("enableAddHomeUseAssets", true)) {
                com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.utils.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        AddHomeToScreenUtils.r(miniAddHomeDataModel, str, aVar, context);
                    }
                });
                return;
            }
            TmcLogger.c(f30987b, "Not the default appId, download icon ->" + miniAddHomeDataModel.getAppId());
            s(context, miniAddHomeDataModel, str, aVar);
        } catch (Exception e11) {
            TmcLogger.g(f30987b, "Download icon file fail", e11);
            if (aVar != null) {
                aVar.onFail();
            }
        }
    }

    public final void s(final Context context, final MiniAddHomeDataModel miniAddHomeDataModel, final String str, final o.a aVar) {
        com.cloud.tmc.kernel.utils.e.a(ExecutorType.NETWORK, new Runnable() { // from class: com.cloud.tmc.integration.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                AddHomeToScreenUtils.t(context, miniAddHomeDataModel, aVar, str);
            }
        });
    }

    public final String u(Context context, String str) {
        return str;
    }

    @RequiresApi(26)
    public final void v(final Context context, Class<?> cls, final MiniAddHomeDataModel miniAddHomeDataModel, final int i11, final String str, final boolean z11) {
        final ShortcutManager shortcutManagerA;
        AddToHomeScreenStore addToHomeScreenStore;
        HashMap<String, bc.a> store;
        bc.a aVarRemove;
        final String appId = miniAddHomeDataModel.getAppId();
        if (Build.VERSION.SDK_INT < 26 || (shortcutManagerA = com.bytedance.sdk.openadsdk.api.init.b.a(context.getSystemService(com.bytedance.sdk.openadsdk.api.init.a.a()))) == null || !shortcutManagerA.isRequestPinShortcutSupported()) {
            return;
        }
        AppUtils appUtils = AppUtils.f31011a;
        if (!appUtils.w(context, appId)) {
            final Intent intent = new Intent("com.cloud.tmc.miniapp.shortcut");
            intent.setComponent(new ComponentName(context, (Class<?>) ShortCutBroadcast.class));
            intent.putExtra(NotificationCompat.CATEGORY_MESSAGE, "approve");
            intent.putExtra("miniAppId", miniAddHomeDataModel.getAppId());
            final boolean zF = AppUtils.f(appUtils, context, false, 2, null);
            final Intent intent2 = new Intent(context, cls);
            intent2.setAction(appId);
            z(intent2, miniAddHomeDataModel.getAppId());
            q(context, miniAddHomeDataModel, new o.a() { // from class: com.cloud.tmc.integration.utils.AddHomeToScreenUtils$postApi26CreateShortcut$2
                @Override // com.cloud.tmc.integration.utils.o.a
                public void onFail() {
                    AddToHomeScreenStore addToHomeScreenStore2;
                    HashMap<String, bc.a> store2;
                    bc.a aVarRemove2;
                    ((ToastProxy) tc.a.a(ToastProxy.class)).toast(context.getResources().getString(R$string.smallapp_create_fail_no_icon));
                    o oVar = o.f31082a;
                    oVar.h(appId, 2, "trigger failed");
                    try {
                        App app = oVar.f().get(miniAddHomeDataModel.getAppId());
                        if (app == null || (addToHomeScreenStore2 = (AddToHomeScreenStore) app.getData(AddToHomeScreenStore.class)) == null || (store2 = addToHomeScreenStore2.getStore()) == null || (aVarRemove2 = store2.remove(miniAddHomeDataModel.getAppId())) == null) {
                            return;
                        }
                        JsonObject jsonObject = new JsonObject();
                        Context context2 = context;
                        String str2 = appId;
                        TmcLogger.c(AddHomeToScreenUtils.f30987b, "发送 addHomeToScreen callback received");
                        jsonObject.addProperty("isExist", Boolean.valueOf(AppUtils.f31011a.v(context2, str2)));
                        aVarRemove2.d(jsonObject);
                    } catch (Throwable th2) {
                        TmcLogger.g(AddHomeToScreenUtils.f30987b, "", th2);
                    }
                }

                @Override // com.cloud.tmc.integration.utils.o.a
                public void onSuccess(String path) {
                    AddToHomeScreenStore addToHomeScreenStore2;
                    HashMap<String, bc.a> store2;
                    bc.a aVarRemove2;
                    Intrinsics.g(path, "path");
                    try {
                        x2.a();
                        ShortcutInfo.Builder builderA = r2.a(context, appId);
                        String appName = miniAddHomeDataModel.getAppName();
                        String str2 = "";
                        if (appName == null) {
                            appName = "";
                        }
                        ShortcutInfo.Builder shortLabel = builderA.setShortLabel(appName);
                        AddHomeToScreenUtils addHomeToScreenUtils = AddHomeToScreenUtils.f30986a;
                        ShortcutInfo.Builder icon = shortLabel.setIcon(Icon.createWithBitmap(addHomeToScreenUtils.n(path)));
                        Context context2 = context;
                        String appName2 = miniAddHomeDataModel.getAppName();
                        if (appName2 != null) {
                            str2 = appName2;
                        }
                        ShortcutInfo.Builder intent3 = icon.setLongLabel(addHomeToScreenUtils.u(context2, str2)).setIntent(intent2);
                        PersistableBundle persistableBundle = new PersistableBundle();
                        MiniAddHomeDataModel miniAddHomeDataModel2 = miniAddHomeDataModel;
                        int i12 = i11;
                        boolean z12 = zF;
                        String str3 = str;
                        boolean z13 = z11;
                        persistableBundle.putString(PushConstants.PROVIDER_FIELD_APP_ID, miniAddHomeDataModel2.getAppId());
                        persistableBundle.putString(TrackingKey.SCENE_ID, "200008");
                        persistableBundle.putInt("extraAddHomeType", i12);
                        persistableBundle.putBoolean("extraAddHomeShowDialog", !z12);
                        persistableBundle.putString("extraAddHomeFromLocation", str3);
                        persistableBundle.putBoolean("extraShowSuccessToast", z13);
                        ShortcutInfo shortcutInfoBuild = intent3.setExtras(persistableBundle).build();
                        Intrinsics.f(shortcutInfoBuild, "Builder(context, appId)\n…               }).build()");
                        shortcutManagerA.requestPinShortcut(shortcutInfoBuild, PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, ASTNode.PCTX_STORED).getIntentSender());
                        boolean zS = AppUtils.f31011a.s(context);
                        TmcLogger.c(AddHomeToScreenUtils.f30987b, "添加桌面快捷方式，是否为 isLauncher: " + zS);
                        if (!zS && z11) {
                            ITaskQueueProxy iTaskQueueProxy = (ITaskQueueProxy) tc.a.a(ITaskQueueProxy.class);
                            final Context context3 = context;
                            iTaskQueueProxy.addAppTask("addHomeToScreen", new Function0<Unit>() { // from class: com.cloud.tmc.integration.utils.AddHomeToScreenUtils$postApi26CreateShortcut$2$onSuccess$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    ((ToastProxy) tc.a.a(ToastProxy.class)).toast(context3.getResources().getString(R$string.smallapp_create_success));
                                }
                            });
                        }
                        o.f31082a.h(appId, 1, "trigger success");
                    } catch (Throwable th2) {
                        o oVar = o.f31082a;
                        oVar.h(appId, 3, "trigger happened exception:" + th2);
                        TmcLogger.f(AddHomeToScreenUtils.f30987b, "downloadMiniAppIconFile ->" + th2);
                        try {
                            App app = oVar.f().get(appId);
                            if (app == null || (addToHomeScreenStore2 = (AddToHomeScreenStore) app.getData(AddToHomeScreenStore.class)) == null || (store2 = addToHomeScreenStore2.getStore()) == null || (aVarRemove2 = store2.remove(appId)) == null) {
                                return;
                            }
                            JsonObject jsonObject = new JsonObject();
                            Context context4 = context;
                            String str4 = appId;
                            TmcLogger.c(AddHomeToScreenUtils.f30987b, "发送 addHomeToScreen callback received");
                            jsonObject.addProperty("isExist", Boolean.valueOf(AppUtils.f31011a.v(context4, str4)));
                            aVarRemove2.d(jsonObject);
                        } catch (Throwable th3) {
                            TmcLogger.g(AddHomeToScreenUtils.f30987b, "onDenied", th3);
                        }
                    }
                }
            });
            return;
        }
        ((ToastProxy) tc.a.a(ToastProxy.class)).toast(context.getResources().getString(R$string.smallapp_already_exist, miniAddHomeDataModel.getAppName()));
        App app = o.f31082a.f().get(miniAddHomeDataModel.getAppId());
        if (app == null || (addToHomeScreenStore = (AddToHomeScreenStore) app.getData(AddToHomeScreenStore.class)) == null || (store = addToHomeScreenStore.getStore()) == null || (aVarRemove = store.remove(miniAddHomeDataModel.getAppId())) == null) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        TmcLogger.c(f30987b, "发送 addHomeToScreen callback received");
        jsonObject.addProperty("isExist", Boolean.TRUE);
        aVarRemove.d(jsonObject);
    }

    public final void w(MiniAddHomeDataModel miniAddHomeDataModel, String str, int i11, Context context, Class<?> cls, boolean z11) {
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            String appId = miniAddHomeDataModel.getAppId();
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_SHORT_CUT;
            Bundle bundle = new Bundle();
            bundle.putString("object_id", PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION);
            bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, str);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.record(appId, pointAnalyseType, "", bundle);
            o.f31082a.d().put(miniAddHomeDataModel.getAppId(), new MiniAddHomeModel(str, i11, z11));
            y(context, miniAddHomeDataModel.getAppId());
            if (Build.VERSION.SDK_INT >= 26) {
                v(context, cls, miniAddHomeDataModel, i11, str, z11);
            }
        } catch (Throwable th2) {
            TmcLogger.f(f30987b, "createShortcut ->" + th2);
        }
    }

    @RequiresApi(26)
    public final void x(Context context, String str, String str2, String str3, ShortcutManager shortcutManager, String str4, bc.a aVar) {
        Class<?> launcherShortCutActivity = ((StartActivityProxy) tc.a.a(StartActivityProxy.class)).getLauncherShortCutActivity();
        Intrinsics.f(launcherShortCutActivity, "get(StartActivityProxy::….launcherShortCutActivity");
        Intent intent = new Intent(context, launcherShortCutActivity);
        intent.setAction(str);
        z(intent, str);
        ShortcutInfo.Builder intent2 = r2.a(context, str).setShortLabel(str2).setIcon(Icon.createWithBitmap(n(str3))).setLongLabel(u(context, str2)).setIntent(intent);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(PushConstants.PROVIDER_FIELD_APP_ID, str);
        persistableBundle.putString(TrackingKey.SCENE_ID, "200008");
        persistableBundle.putBoolean("extraAddHomeShowDialog", false);
        ShortcutInfo shortcutInfoBuild = intent2.setExtras(persistableBundle).build();
        Intrinsics.f(shortcutInfoBuild, "Builder(context, appId)\n… )\n            }).build()");
        if (Build.VERSION.SDK_INT >= 26) {
            shortcutManager.updateShortcuts(kotlin.collections.g.h(shortcutInfoBuild));
            B(this, context, str, str2, str4, null, 16, null);
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public final void y(Context context, String str) {
        if (AppUtils.f31011a.s(context) || str == null || str.length() == 0) {
            return;
        }
        try {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, str, "showAddHome", true);
        } catch (Throwable th2) {
            TmcLogger.h(f30987b, th2);
        }
    }

    public final void z(Intent intent, String str) {
        intent.putExtra(PushConstants.PROVIDER_FIELD_APP_ID, str);
        intent.putExtra(TrackingKey.SCENE_ID, "200008");
    }
}
