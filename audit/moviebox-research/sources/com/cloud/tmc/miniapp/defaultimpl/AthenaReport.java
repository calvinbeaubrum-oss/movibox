package com.cloud.tmc.miniapp.defaultimpl;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.cloud.tmc.ad.IAdManagerProxy;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.UniqueIdBean;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.VirtualAppManager;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.MiniRequestUtils;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.proxy.worker.IWorkerFactory;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.defaultimpl.AthenaReport;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.ZipFileInfo;
import com.cloud.tmc.render.proxy.SessionUtilProxy;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import hd.j;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import mb.c;
import p011Oooo00o.o00Ooo;
import rc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class AthenaReport implements ReportProxy {
    public static final a Companion = new a();
    public static AtomicBoolean OooO0OO = new AtomicBoolean(false);

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public static AtomicBoolean f31503OooO0Oo = new AtomicBoolean(false);

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public static AtomicBoolean f31504OooO0o0 = new AtomicBoolean(false);
    public final ConcurrentHashMap<String, UniqueIdBean> OooO00o = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, LazyGetPkgInfoBean> OooO0O0 = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: source.java */
    public static final class LazyGetPkgInfoBean extends b {
        private String info;
        private AtomicBoolean requesting;

        /* JADX WARN: Multi-variable type inference failed */
        public LazyGetPkgInfoBean() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public LazyGetPkgInfoBean(AtomicBoolean requesting, String info) {
            Intrinsics.g(requesting, "requesting");
            Intrinsics.g(info, "info");
            this.requesting = requesting;
            this.info = info;
        }

        public /* synthetic */ LazyGetPkgInfoBean(AtomicBoolean atomicBoolean, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? new AtomicBoolean(false) : atomicBoolean, (i11 & 2) != 0 ? "" : str);
        }

        public static /* synthetic */ LazyGetPkgInfoBean copy$default(LazyGetPkgInfoBean lazyGetPkgInfoBean, AtomicBoolean atomicBoolean, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                atomicBoolean = lazyGetPkgInfoBean.requesting;
            }
            if ((i11 & 2) != 0) {
                str = lazyGetPkgInfoBean.info;
            }
            return lazyGetPkgInfoBean.copy(atomicBoolean, str);
        }

        public final AtomicBoolean component1() {
            return this.requesting;
        }

        public final String component2() {
            return this.info;
        }

        public final LazyGetPkgInfoBean copy(AtomicBoolean requesting, String info) {
            Intrinsics.g(requesting, "requesting");
            Intrinsics.g(info, "info");
            return new LazyGetPkgInfoBean(requesting, info);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LazyGetPkgInfoBean)) {
                return false;
            }
            LazyGetPkgInfoBean lazyGetPkgInfoBean = (LazyGetPkgInfoBean) obj;
            return Intrinsics.b(this.requesting, lazyGetPkgInfoBean.requesting) && Intrinsics.b(this.info, lazyGetPkgInfoBean.info);
        }

        public final String getInfo() {
            return this.info;
        }

        public final AtomicBoolean getRequesting() {
            return this.requesting;
        }

        public int hashCode() {
            return this.info.hashCode() + (this.requesting.hashCode() * 31);
        }

        public final void setInfo(String str) {
            Intrinsics.g(str, "<set-?>");
            this.info = str;
        }

        public final void setRequesting(AtomicBoolean atomicBoolean) {
            Intrinsics.g(atomicBoolean, "<set-?>");
            this.requesting = atomicBoolean;
        }

        public String toString() {
            StringBuilder sbA = j.a("LazyGetPkgInfoBean(requesting=");
            sbA.append(this.requesting);
            sbA.append(", info=");
            sbA.append(this.info);
            sbA.append(')');
            return sbA.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class UniqueIdBean extends b {
        private AtomicBoolean requesting;
        private String uniqueId;

        /* JADX WARN: Multi-variable type inference failed */
        public UniqueIdBean() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public UniqueIdBean(AtomicBoolean requesting, String uniqueId) {
            Intrinsics.g(requesting, "requesting");
            Intrinsics.g(uniqueId, "uniqueId");
            this.requesting = requesting;
            this.uniqueId = uniqueId;
        }

        public /* synthetic */ UniqueIdBean(AtomicBoolean atomicBoolean, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? new AtomicBoolean(false) : atomicBoolean, (i11 & 2) != 0 ? "" : str);
        }

        public static /* synthetic */ UniqueIdBean copy$default(UniqueIdBean uniqueIdBean, AtomicBoolean atomicBoolean, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                atomicBoolean = uniqueIdBean.requesting;
            }
            if ((i11 & 2) != 0) {
                str = uniqueIdBean.uniqueId;
            }
            return uniqueIdBean.copy(atomicBoolean, str);
        }

        public final AtomicBoolean component1() {
            return this.requesting;
        }

        public final String component2() {
            return this.uniqueId;
        }

        public final UniqueIdBean copy(AtomicBoolean requesting, String uniqueId) {
            Intrinsics.g(requesting, "requesting");
            Intrinsics.g(uniqueId, "uniqueId");
            return new UniqueIdBean(requesting, uniqueId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UniqueIdBean)) {
                return false;
            }
            UniqueIdBean uniqueIdBean = (UniqueIdBean) obj;
            return Intrinsics.b(this.requesting, uniqueIdBean.requesting) && Intrinsics.b(this.uniqueId, uniqueIdBean.uniqueId);
        }

        public final AtomicBoolean getRequesting() {
            return this.requesting;
        }

        public final String getUniqueId() {
            return this.uniqueId;
        }

        public int hashCode() {
            return this.uniqueId.hashCode() + (this.requesting.hashCode() * 31);
        }

        public final void setRequesting(AtomicBoolean atomicBoolean) {
            Intrinsics.g(atomicBoolean, "<set-?>");
            this.requesting = atomicBoolean;
        }

        public final void setUniqueId(String str) {
            Intrinsics.g(str, "<set-?>");
            this.uniqueId = str;
        }

        public String toString() {
            StringBuilder sbA = j.a("UniqueIdBean(requesting=");
            sbA.append(this.requesting);
            sbA.append(", uniqueId=");
            sbA.append(this.uniqueId);
            sbA.append(')');
            return sbA.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void OooO00o(AthenaReport this$0, App app, Ref.ObjectRef lazyGetPkgInfoBean) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(lazyGetPkgInfoBean, "$lazyGetPkgInfoBean");
        this$0.OooO00o(app, (LazyGetPkgInfoBean) lazyGetPkgInfoBean.element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.cloud.tmc.miniapp.defaultimpl.AthenaReport$LazyGetPkgInfoBean, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void OooO00o(final App app) {
        try {
            AtomicBoolean atomicBoolean = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (h.f31061a.l(app != null ? app.getAppModel() : null)) {
                String appId = app != null ? app.getAppId() : null;
                if (appId == null) {
                    return;
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? r11 = this.OooO0O0.get(appId);
                objectRef.element = r11;
                if (r11 == 0) {
                    ?? lazyGetPkgInfoBean = new LazyGetPkgInfoBean(atomicBoolean, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0);
                    objectRef.element = lazyGetPkgInfoBean;
                    this.OooO0O0.put(appId, (LazyGetPkgInfoBean) lazyGetPkgInfoBean);
                }
                if (TextUtils.isEmpty(((LazyGetPkgInfoBean) objectRef.element).getInfo()) && !((LazyGetPkgInfoBean) objectRef.element).getRequesting().get()) {
                    ((LazyGetPkgInfoBean) objectRef.element).getRequesting().set(true);
                    if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                        e.a(ExecutorType.IO, new Runnable() { // from class: md.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                AthenaReport.OooO00o(this.f70974a, app, objectRef);
                            }
                        });
                    } else {
                        OooO00o(app, (LazyGetPkgInfoBean) objectRef.element);
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g("AthenaReport", "getOfflinePackageInfo", th2);
        }
    }

    public final void OooO00o(App app, LazyGetPkgInfoBean lazyGetPkgInfoBean) {
        String appId;
        AtomicBoolean requesting;
        if (app != null) {
            try {
                appId = app.getAppId();
            } catch (Throwable unused) {
                return;
            }
        } else {
            appId = null;
        }
        List<ZipFileInfo> listG = OfflineManager.G(appId);
        if (listG == null) {
            if (lazyGetPkgInfoBean == null || (requesting = lazyGetPkgInfoBean.getRequesting()) == null) {
                return;
            }
            requesting.set(false);
            return;
        }
        boolean booleanValue = app != null ? app.getBooleanValue("disable_offline_processor") : false;
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(listG, 10));
        Iterator<T> it = listG.iterator();
        while (it.hasNext()) {
            arrayList.add(s.j(TuplesKt.a("key", ((ZipFileInfo) it.next()).getUrl()), TuplesKt.a("useStatus", Boolean.valueOf(!booleanValue))));
        }
        if (lazyGetPkgInfoBean != null) {
            lazyGetPkgInfoBean.setInfo(o.a(arrayList));
            lazyGetPkgInfoBean.getRequesting().set(false);
            TmcLogger.c("seven", "info:" + lazyGetPkgInfoBean.getInfo());
        }
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public /* bridge */ /* synthetic */ Triple checkReportIntercept(String str, Boolean bool) {
        return checkReportIntercept(str, bool.booleanValue());
    }

    public Triple<Boolean, Boolean, Boolean> checkReportIntercept(String str, boolean z11) {
        j0.a aVarA = g0.e.f65310a.a(str, z11);
        return new Triple<>(Boolean.valueOf(aVarA != null ? aVarA.f67800a : false), Boolean.valueOf(aVarA != null ? aVarA.f67801b : false), Boolean.valueOf(aVarA != null ? aVarA.f67802c : false));
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public void forceAthenaReport(String appId, String tag, int i11, Bundle bundle) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(tag, "tag");
        Intrinsics.g(bundle, "bundle");
        try {
            g0.e.f65310a.g(tag, i11, getAthenaCommonBundle(appId, bundle, tag));
        } catch (Throwable th2) {
            TmcLogger.g("AthenaReport", "forceAthenaReport", th2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:196:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:199:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:203:0x0407  */
    /* JADX WARN: Code duplicated, block: B:209:0x041a  */
    public final Bundle getAthenaCommonBundle(String str, Bundle bundle, String str2) {
        final App app;
        String appId;
        String str3;
        AppUtils appUtils;
        Integer miniappSubtype;
        String templateMiniappId;
        String currentUseCommonResVersion;
        AppModel appModel;
        AppModel appModel2;
        AppModel appModel3;
        String strSubstring;
        String string;
        String string2;
        String uniqueId;
        AtomicBoolean requesting;
        Context context;
        Bundle bundle2 = new Bundle();
        bundle2.putString("miniapp_id", str);
        App appFindApp = TextUtils.isEmpty(str) ? null : ((AppManager) tc.a.a(AppManager.class)).findApp(str);
        if (appFindApp != null) {
            app = appFindApp;
        } else if (TextUtils.isEmpty(str)) {
            app = null;
        } else {
            appFindApp = ((VirtualAppManager) tc.a.a(VirtualAppManager.class)).findApp(str);
            app = appFindApp;
        }
        String str4 = "";
        if (app != null) {
            q qVar = q.f31091a;
            tb.b appContext = app.getAppContext();
            qVar.l(appContext != null ? appContext.getContext() : null, bundle2);
            AppModel appModel4 = app.getAppModel();
            bundle2.putString("miniapp_categorType", String.valueOf(appModel4 != null ? Integer.valueOf(appModel4.getAppinfoCategoryType()) : null));
            bundle2.putString("miniapp_version", app.getAppVersion());
            if (bundle == null || !bundle.containsKey("page_path")) {
                Page activePage = app.getActivePage();
                bundle2.putString("page_path", activePage != null ? activePage.getPagePath() : null);
                if (bundle == null || !bundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0)) {
                    String str5 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0;
                    Page activePage2 = app.getActivePage();
                    String pagePath = activePage2 != null ? activePage2.getPagePath() : null;
                    if (pagePath == null) {
                        pagePath = "";
                    }
                    bundle2.putString(str5, String.valueOf(app.getPageType(pagePath)));
                }
            } else if (bundle == null || !bundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0)) {
                bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0, String.valueOf(app.getPageType(bundle.getString("page_path", ""))));
            }
            if (bundle == null || !bundle.containsKey("scene")) {
                Bundle sceneParams = app.getSceneParams();
                if (sceneParams == null || (string = sceneParams.getString(TrackingKey.SCENE_ID)) == null) {
                    string = "100000";
                }
                bundle2.putString("scene", string);
            }
            if (bundle == null || !bundle.containsKey("start_session_id")) {
                Bundle sceneParams2 = app.getSceneParams();
                bundle2.putString("start_session_id", sceneParams2 != null ? sceneParams2.getString("massid") : null);
            }
            if (bundle == null || !bundle.containsKey("fis_type")) {
                Bundle sceneParams3 = app.getSceneParams();
                if (sceneParams3 == null || (string2 = sceneParams3.getString("fis_type")) == null) {
                    string2 = "0";
                }
                bundle2.putString("fis_type", string2);
            }
            if (bundle == null || !bundle.containsKey("uniqueid")) {
                UniqueIdBean uniqueIdBean = this.OooO00o.get(app.getAppId());
                if (uniqueIdBean == null || (uniqueId = uniqueIdBean.getUniqueId()) == null || TextUtils.isEmpty(uniqueId)) {
                    UniqueIdBean uniqueIdBean2 = this.OooO00o.get(app.getAppId());
                    if (uniqueIdBean2 == null || (requesting = uniqueIdBean2.getRequesting()) == null || !requesting.get()) {
                        String strD = q.d();
                        if (TextUtils.isEmpty(strD)) {
                            TmcLogger.f("AthenaReport", "埋点getUniqueId fail: gaid is empty");
                        } else {
                            ConcurrentHashMap<String, UniqueIdBean> concurrentHashMap = this.OooO00o;
                            String appId2 = app.getAppId();
                            Intrinsics.f(appId2, "app.appId");
                            concurrentHashMap.put(appId2, new UniqueIdBean(new AtomicBoolean(true), ""));
                            String appId3 = app.getAppId();
                            Intrinsics.f(appId3, "app.appId");
                            MiniRequestUtils.a(strD, appId3, new c<com.cloud.tmc.integration.model.UniqueIdBean>() { // from class: com.cloud.tmc.miniapp.defaultimpl.AthenaReport$getUniqueId$2
                                @Override // mb.c
                                public Type d() {
                                    Type type = new TypeToken<BaseResponse<? extends UniqueIdBean>>() { // from class: com.cloud.tmc.miniapp.defaultimpl.AthenaReport$getUniqueId$2$getType$1
                                    }.getType();
                                    Intrinsics.f(type, "object :\n               …niqueIdBean?>?>() {}.type");
                                    return type;
                                }

                                @Override // mb.c
                                public void e(BaseResponse<? extends Object> fail, Map<String, String> map) {
                                    AtomicBoolean requesting2;
                                    Intrinsics.g(fail, "fail");
                                    AthenaReport.UniqueIdBean uniqueIdBean3 = (AthenaReport.UniqueIdBean) this.f31505a.OooO00o.get(app.getAppId());
                                    if (uniqueIdBean3 == null || (requesting2 = uniqueIdBean3.getRequesting()) == null) {
                                        return;
                                    }
                                    requesting2.set(false);
                                }

                                @Override // mb.c
                                public void g(BaseResponse<? extends UniqueIdBean> bean, Map<String, String> map) {
                                    String uniqueId2;
                                    AtomicBoolean requesting2;
                                    Intrinsics.g(bean, "bean");
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("埋点getUniqueId success: ");
                                    UniqueIdBean data = bean.getData();
                                    sb2.append(data != null ? data.getUniqueId() : null);
                                    TmcLogger.f("AthenaReport", sb2.toString());
                                    AthenaReport.UniqueIdBean uniqueIdBean3 = (AthenaReport.UniqueIdBean) this.f31505a.OooO00o.get(app.getAppId());
                                    if (uniqueIdBean3 != null && (requesting2 = uniqueIdBean3.getRequesting()) != null) {
                                        requesting2.set(false);
                                    }
                                    UniqueIdBean data2 = bean.getData();
                                    if (data2 == null || (uniqueId2 = data2.getUniqueId()) == null) {
                                        return;
                                    }
                                    AthenaReport.UniqueIdBean uniqueIdBean4 = (AthenaReport.UniqueIdBean) this.f31505a.OooO00o.get(app.getAppId());
                                    if (uniqueIdBean4 == null) {
                                        return;
                                    }
                                    uniqueIdBean4.setUniqueId(uniqueId2);
                                }
                            });
                        }
                    }
                    uniqueId = "";
                }
                bundle2.putString("uniqueid", uniqueId);
            }
            bundle2.putString("improveTags", ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).getPerformanceImproves(app.getAppId()));
            if (bundle == null || !bundle.containsKey("isForeground")) {
                tb.b appContext2 = app.getAppContext();
                Context context2 = appContext2 != null ? appContext2.getContext() : null;
                BaseActivity baseActivity = context2 instanceof BaseActivity ? (BaseActivity) context2 : null;
                bundle2.putString("isForeground", String.valueOf(baseActivity != null ? Boolean.valueOf(baseActivity.getMStarted()) : null));
            }
            try {
                tb.b appContext3 = app.getAppContext();
                if (appContext3 != null && (context = appContext3.getContext()) != null) {
                    AppModel appModel5 = app.getAppModel();
                    Intrinsics.f(appModel5, "app.appModel");
                    bundle2.putInt("packageSource", o00Ooo.d(context, appModel5) ? 1 : 2);
                }
            } catch (Throwable th2) {
                TmcLogger.g("AthenaReport", "", th2);
            }
        }
        bundle2.putString("sessionId", String.valueOf(((SessionUtilProxy) tc.a.a(SessionUtilProxy.class)).getId(str)));
        IWorkerFactory iWorkerFactory = (IWorkerFactory) tc.a.a(IWorkerFactory.class);
        bundle2.putInt("worker_type", iWorkerFactory != null ? iWorkerFactory.workerType() : -100);
        bundle2.putString("sdk_version", ((IPackageConfig) tc.a.a(IPackageConfig.class)).getSDKVersion());
        bundle2.putString("framework_version", ((IPackageConfig) tc.a.a(IPackageConfig.class)).getFrameworkVersion());
        bundle2.putString(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        Boolean tctpStatus = ByteAppManager.INSTANCE.getTctpStatus();
        bundle2.putString("TCTP", String.valueOf(tctpStatus != null ? tctpStatus.booleanValue() : AppDynamicBuildConfig.u()));
        bundle2.putString("NetworkIsConnected", String.valueOf(NetworkUtils.n() == 1));
        bundle2.putString("NetworkType", String.valueOf(NetworkUtils.m()));
        bundle2.putInt("screen_width", ha.a.i());
        bundle2.putInt("screen_height", ha.a.h());
        bundle2.putInt("networkStatus", NetworkUtils.n());
        bundle2.putString("miniapp_gaid", String.valueOf(q.d()));
        if (app != null) {
            try {
                appId = app.getAppId();
            } catch (Throwable th3) {
                TmcLogger.g("AthenaReport", "getOfflinePackageInfo", th3);
            }
        } else {
            appId = null;
        }
        if (appId != null) {
            OooO00o(app);
            LazyGetPkgInfoBean lazyGetPkgInfoBean = this.OooO0O0.get(appId);
            bundle2.putString("offlinePkgList", String.valueOf(lazyGetPkgInfoBean != null ? lazyGetPkgInfoBean.getInfo() : null));
        }
        q.f31091a.c(bundle2);
        bundle2.putAll(bundle);
        String realPagePath = bundle2.getString("page_path", "");
        bundle2.putString("real_page_path", realPagePath);
        Intrinsics.f(realPagePath, "realPagePath");
        try {
            TmcLogger.c("AthenaReport", "realPagePath:" + realPagePath);
            if (!TextUtils.isEmpty(realPagePath)) {
                int iD0 = StringsKt__StringsKt.d0(realPagePath, "?", 0, false, 6, null);
                if (iD0 > 0) {
                    try {
                        strSubstring = realPagePath.substring(0, iD0);
                        Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    } catch (Throwable unused) {
                    }
                } else {
                    strSubstring = realPagePath;
                }
                if (TextUtils.isEmpty(strSubstring)) {
                    str4 = realPagePath;
                } else {
                    try {
                        if (StringsKt__StringsKt.Q(strSubstring, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
                            Object objE = k.e(MiniAppConfigHelper.f30370a.e("athenaReportPaths", "{\"testPath\": \"www.test.com\"}"), new TypeToken<Map<String, ? extends String>>() { // from class: com.cloud.tmc.miniapp.defaultimpl.AthenaReport$getMatchPagePath$pathMap$1
                            }.getType());
                            Intrinsics.f(objE, "fromJson(paths, object :…ring, String>>() {}.type)");
                            Iterator it = ((Map) objE).entrySet().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it.next();
                                    str3 = null;
                                    try {
                                        if (StringsKt__StringsKt.Q(strSubstring, (CharSequence) entry.getKey(), false, 2, null)) {
                                            str4 = (String) entry.getValue();
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                } else {
                                    str3 = null;
                                    str4 = strSubstring;
                                }
                            }
                        } else {
                            str3 = null;
                            str4 = strSubstring;
                        }
                    } catch (Throwable unused3) {
                        str3 = null;
                    }
                }
                TmcLogger.c("AthenaReport", "reportPagePath:" + str4);
                bundle2.putString("page_path", str4);
                p.e("reportData", bundle2 + " =====> " + str2);
                appUtils = AppUtils.f31011a;
                if (app != null || (appModel3 = app.getAppModel()) == null) {
                    miniappSubtype = str3;
                } else {
                    miniappSubtype = appModel3.getMiniappSubtype();
                }
                if (appUtils.g(miniappSubtype)) {
                    if (app != null || (appModel2 = app.getAppModel()) == null) {
                        templateMiniappId = str3;
                    } else {
                        templateMiniappId = appModel2.getTemplateMiniappId();
                    }
                    bundle2.putString("mini_template_id", templateMiniappId);
                    if (app != null || (appModel = app.getAppModel()) == null) {
                        currentUseCommonResVersion = str3;
                    } else {
                        currentUseCommonResVersion = appModel.getCurrentUseCommonResVersion();
                    }
                    bundle2.putString("mini_template_ver", currentUseCommonResVersion);
                }
                return bundle2;
            }
            str3 = null;
        } catch (Throwable unused4) {
            str3 = null;
        }
        TmcLogger.c("AthenaReport", "reportPagePath:" + str4);
        bundle2.putString("page_path", str4);
        p.e("reportData", bundle2 + " =====> " + str2);
        appUtils = AppUtils.f31011a;
        if (app != null) {
            miniappSubtype = str3;
        } else {
            miniappSubtype = str3;
        }
        if (appUtils.g(miniappSubtype)) {
            if (app != null) {
                templateMiniappId = str3;
            } else {
                templateMiniappId = str3;
            }
            bundle2.putString("mini_template_id", templateMiniappId);
            if (app != null) {
                currentUseCommonResVersion = str3;
            } else {
                currentUseCommonResVersion = str3;
            }
            bundle2.putString("mini_template_ver", currentUseCommonResVersion);
        }
        return bundle2;
    }

    public final Bundle getBundle(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("session_id", ha.a.j());
            bundle.putString("sdk_version", ((IAdManagerProxy) tc.a.a(IAdManagerProxy.class)).getAdSdkFrameworkVersion());
            bundle.putLong("sdk_version_int", ((IAdManagerProxy) tc.a.a(IAdManagerProxy.class)).getAdSdkFrameworkVersionInt());
            bundle.putString("user_agent", ha.a.l());
            bundle.putInt("type", ha.a.k());
            bundle.putString("make", ha.a.b());
            bundle.putString("ostype", "Android");
            bundle.putInt("screen_width", ha.a.i());
            bundle.putInt("screen_height", ha.a.h());
            bundle.putInt("screen_density", ha.a.g());
            q qVar = q.f31091a;
            bundle.putString("base_station", qVar.g());
            bundle.putDouble("latitude", ja.a.c());
            bundle.putDouble("longitude", ja.a.e());
            bundle.putLong("coordtime", ja.a.b());
            bundle.putString("oneid", "");
            bundle.putInt("turn_off_per_ads", qVar.f());
        } catch (Throwable th2) {
            TmcLogger.f("AthenaReport", "getBundle fail: " + th2);
        }
        return bundle;
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public String getVaid() {
        try {
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(ByteAppManager.getSApplication(), "miniLauncherGlobal", "athenaVaid");
            return string == null ? "0000-0000-0000-0000" : string;
        } catch (Exception unused) {
            return "0000-0000-0000-0000";
        }
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public void mfahCacheDataReport(String str) {
        Unit unit;
        if (str != null) {
            try {
                g0.e.f65310a.c(str);
                unit = Unit.f68710a;
            } catch (Throwable th2) {
                TmcLogger.h("AthenaReport", th2);
                return;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            TmcLogger.c("AthenaReport", "mfahCacheDataReport: appId is null");
        }
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public void report(String str, String str2, Bundle bundle) {
        report(str, str2, bundle, 3755);
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public void report(String str, String str2, Bundle bundle, Integer num) {
        int iIntValue;
        if (str2 != null) {
            try {
                Bundle athenaCommonBundle = getAthenaCommonBundle(str, bundle, str2);
                if (num == null || (iIntValue = num.intValue()) == 0) {
                    iIntValue = 3755;
                }
                g0.e.f65310a.e(str2, iIntValue, athenaCommonBundle, str);
            } catch (Throwable th2) {
                TmcLogger.g("AthenaReport", "report: ", th2);
            }
        }
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public void reportAd(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            try {
                Bundle bundle2 = new Bundle();
                App appFindApp = null;
                App appFindApp2 = TextUtils.isEmpty(str) ? null : ((AppManager) tc.a.a(AppManager.class)).findApp(str);
                if (appFindApp2 != null) {
                    appFindApp = appFindApp2;
                } else if (!TextUtils.isEmpty(str)) {
                    appFindApp = ((VirtualAppManager) tc.a.a(VirtualAppManager.class)).findApp(str);
                }
                if (appFindApp != null) {
                    String appId = appFindApp.getAppId();
                    if (appId == null) {
                        appId = "";
                    }
                    bundle2.putString("mini_program_id", appId);
                }
                bundle2.putString("host_package_name", String.valueOf(ByteAppManager.getSApplication().getPackageName()));
                bundle2.putAll(bundle);
                Bundle bundle3 = getBundle(bundle2);
                p.e("reportBussinessData", bundle3 + " =====> " + str2);
                g0.e.f65310a.e(str2, 2411, bundle3, str);
            } catch (Throwable th2) {
                TmcLogger.g("AthenaReport", "reportAd: ", th2);
            }
        }
    }
}
