package h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PermissionDialogModel;
import com.cloud.tmc.integration.model.ScopeModel;
import com.cloud.tmc.integration.permission.AppPermissionUtils;
import com.cloud.tmc.integration.point.PermissionDialogPoint;
import com.cloud.tmc.integration.proxy.DialogProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.f0;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.permission.PermissionModel;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.ui.OooO0OO;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.cloud.tmc.miniutils.util.y;
import com.google.gson.JsonObject;
import hd.j;
import hd.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ua.l;
import ua.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f65650c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ScopeModel> f65651d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, List<PermissionDialogModel>> f65652e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f65653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<String, List<C0692b>> f65654b = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: source.java */
    public class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f65655a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f65656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f65657c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f65658d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f65659e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f65660f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Page f65661g;

        public a(String str, String str2, String str3, String str4, String str5, Page page) {
            this.f65656b = str;
            this.f65657c = str2;
            this.f65658d = str3;
            this.f65659e = str4;
            this.f65660f = str5;
            this.f65661g = page;
        }

        @Override // ua.k
        public void a() {
            b.this.g(this.f65656b, this.f65657c);
            TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "checkShowPermissionDialog...cancel");
            ScopeUtils scopeUtils = ScopeUtils.f31808a;
            Context context = b.this.f65653a;
            String scopeName = this.f65657c;
            String appId = this.f65658d;
            String str = this.f65659e;
            String str2 = this.f65660f;
            Intrinsics.g(context, "context");
            Intrinsics.g(scopeName, "scopeName");
            Intrinsics.g(appId, "appId");
            scopeUtils.f(context, scopeName, appId, false, str, str2, true, false);
            b.this.f65654b.remove(this.f65657c);
            b bVar = b.this;
            b.e(bVar, bVar.f65653a, this.f65658d, this.f65655a, this.f65657c);
        }

        @Override // ua.l
        public void b(boolean z11) {
            this.f65655a = z11;
        }

        @Override // ua.k
        public void c(@Nullable Object obj) {
            ScopeUtils scopeUtils = ScopeUtils.f31808a;
            Context context = b.this.f65653a;
            String scopeName = this.f65657c;
            String appId = this.f65658d;
            String str = this.f65659e;
            String str2 = this.f65660f;
            Intrinsics.g(context, "context");
            Intrinsics.g(scopeName, "scopeName");
            Intrinsics.g(appId, "appId");
            scopeUtils.f(context, scopeName, appId, true, str, str2, true, false);
            b bVar = b.this;
            Page page = this.f65661g;
            String str3 = this.f65656b;
            String str4 = this.f65657c;
            bVar.getClass();
            if (page != null && page.getApp() != null && page.getApp().getEngineProxy() != null) {
                List<C0692b> list = bVar.f65654b.get(str4);
                bVar.f65654b.remove(str4);
                if (list != null) {
                    for (C0692b c0692b : list) {
                        k.a("sendResult...action=", str3, "Tmcintegration:LocalAuthPermissionManager");
                        try {
                            page.getApp().getEngineProxy().getBridge().sendToNative(c0692b.f65663a, c0692b.f65664b.f(), false);
                        } catch (Exception e11) {
                            StringBuilder sbA = j.a("use local permission send result error:\t");
                            sbA.append(e11.getMessage());
                            TmcLogger.f("Tmcintegration:LocalAuthPermissionManager", sbA.toString());
                        }
                    }
                }
            }
            b bVar2 = b.this;
            b.e(bVar2, bVar2.f65653a, this.f65658d, this.f65655a, this.f65657c);
        }
    }

    /* JADX INFO: renamed from: h.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0692b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NativeCallContext f65663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public mc.a f65664b;

        public C0692b(b bVar, String str, NativeCallContext nativeCallContext, mc.a aVar) {
            this.f65663a = nativeCallContext;
            this.f65664b = aVar;
        }
    }

    public b(Context context) {
        this.f65653a = context;
        ScopeUtils.f31808a.g(f65651d, f65650c);
        ((PermissionDialogPoint) ib.a.b(PermissionDialogPoint.class).d()).registerCallback(this);
    }

    public static void e(b bVar, Context context, String appId, boolean z11, String str) {
        bVar.getClass();
        if (str.equals("notifyMessage") && z11) {
            ScopeUtils scopeUtils = ScopeUtils.f31808a;
            Intrinsics.g(context, "context");
            Intrinsics.g(appId, "appId");
            try {
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "scope_storageV2", "notifyMessage" + appId, z11);
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, "scope_storageV2", "notifyMessage" + appId + "_time", System.currentTimeMillis());
            } catch (Throwable th2) {
                TmcLogger.h("ScopeUtils", th2);
            }
        }
    }

    @Override // ua.p
    public void a(String str, long j11) {
        TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "privacyDismiss -> appId:" + str + " , startToken:" + j11);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ConcurrentHashMap<String, List<PermissionDialogModel>> concurrentHashMap = f65652e;
            List<PermissionDialogModel> list = concurrentHashMap.get(str);
            if (list != null && !list.isEmpty()) {
                Iterator<PermissionDialogModel> it = list.iterator();
                if (it.hasNext()) {
                    PermissionDialogModel next = it.next();
                    if (next == null) {
                        it.remove();
                        TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "privacyDismiss -> permissionDialogModel == null, continue");
                        a(str, j11);
                        return;
                    }
                    if (next.getStartToken() != j11) {
                        it.remove();
                        TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "privacyDismiss -> cacheStartToken: " + next.getStartToken() + " 不匹配, continue");
                        a(str, j11);
                        return;
                    }
                    String strE = next.getResponseHelper().e();
                    next.getPage().getApp().updateInterectCallbackId(strE);
                    TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "update currentCallbackId -> " + strE);
                    f(next.getPage(), next.getAppId(), next.getAction(), next.getBridgeContext(), next.getResponseHelper(), next.getModel(), true);
                    it.remove();
                }
                if (it.hasNext()) {
                    return;
                }
                concurrentHashMap.remove(str);
                f0.f31050a.o(str, true);
                return;
            }
            concurrentHashMap.remove(str);
            f0.f31050a.o(str, true);
        } catch (Throwable th2) {
            TmcLogger.g("Tmcintegration:LocalAuthPermissionManager", b.class.getSimpleName(), th2);
        }
    }

    public final String b(String str) {
        String str2 = f65650c.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    public final String c(String str, String str2) {
        return "_" + str + "_" + str2.substring(str2.indexOf(InstructionFileId.DOT) + 1, str2.length());
    }

    public final void d(NativeCallContext nativeCallContext, mc.a aVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0692b(this, str, nativeCallContext, aVar));
        this.f65654b.put(str2, arrayList);
        try {
            nativeCallContext.getRender().getAppId();
        } catch (Throwable th2) {
            TmcLogger.g("Tmcintegration:LocalAuthPermissionManager", "cancelAuth", th2);
        }
        g(str, str2);
        this.f65654b.remove(str2);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005d A[PHI: r3
  0x005d: PHI (r3v11 com.google.gson.JsonObject) = (r3v8 com.google.gson.JsonObject), (r3v12 com.google.gson.JsonObject) binds: [B:13:0x005a, B:8:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    public final boolean f(Page page, String str, String str2, NativeCallContext nativeCallContext, mc.a aVar, PermissionModel permissionModel, boolean z11) {
        String str3;
        String logo;
        App app;
        Boolean bool;
        Context context;
        JsonObject asJsonObject;
        String scopeName = b(str2);
        ScopeUtils scopeUtils = ScopeUtils.f31808a;
        ConcurrentHashMap<String, ScopeModel> SHOW_SCOPE_MAP = f65651d;
        Intrinsics.g(scopeName, "scopeName");
        Intrinsics.g(SHOW_SCOPE_MAP, "SHOW_SCOPE_MAP");
        ScopeModel scopeModel = SHOW_SCOPE_MAP.get(scopeName);
        Pair pair = null;
        if (scopeModel != null) {
            String language = Locale.getDefault().getLanguage();
            Intrinsics.f(language, "getDefault().language");
            Locale ROOT = Locale.ROOT;
            Intrinsics.f(ROOT, "ROOT");
            String lowerCase = language.toLowerCase(ROOT);
            Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            JsonObject language2 = scopeModel.getLanguage();
            if (language2 == null || (asJsonObject = language2.getAsJsonObject(lowerCase)) == null) {
                JsonObject language3 = scopeModel.getLanguage();
                asJsonObject = language3 != null ? language3.getAsJsonObject("en") : null;
                if (asJsonObject != null) {
                    String strC = y.c(R$string.mini_permission_dialog_title);
                    Intrinsics.f(strC, "getString(R.string.mini_permission_dialog_title)");
                    pair = new Pair(strC, scopeUtils.b(scopeName, asJsonObject.get(AppLovinEventTypes.USER_VIEWED_CONTENT).getAsString()));
                }
            } else {
                String strC2 = y.c(R$string.mini_permission_dialog_title);
                Intrinsics.f(strC2, "getString(R.string.mini_permission_dialog_title)");
                pair = new Pair(strC2, scopeUtils.b(scopeName, asJsonObject.get(AppLovinEventTypes.USER_VIEWED_CONTENT).getAsString()));
            }
        }
        if (pair == null) {
            return false;
        }
        String str4 = (String) pair.getSecond();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("doShowPermissionDialog -> action:");
        sb2.append(str2);
        sb2.append(", appId: ");
        sb2.append(str);
        sb2.append(", scope: ");
        kd.k.a(sb2, scopeName, "Tmcintegration:LocalAuthPermissionManager");
        if (page == null || page.getApp() == null) {
            str3 = "";
            logo = str3;
        } else {
            AppModel appModel = page.getApp().getAppModel();
            AppPermissionUtils.getAggregationMainAppId(appModel);
            String name = appModel.getName();
            logo = appModel.getLogo();
            str3 = name;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(logo)) {
            TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "doShowPermissionDialog not show icon or title null");
            return false;
        }
        if (z11 || TextUtils.isEmpty(str) || page == null || (app = page.getApp()) == null || app.getAppContext() == null || app.getAppContext().getContext() == null || (context = app.getAppContext().getContext()) == null || !(context instanceof OooO0OO) || !f0.f31050a.e(str)) {
            bool = Boolean.TRUE;
        } else {
            String strB = b(str2);
            if (TextUtils.isEmpty(strB)) {
                bool = Boolean.TRUE;
            } else {
                ConcurrentHashMap<String, List<PermissionDialogModel>> concurrentHashMap = f65652e;
                List<PermissionDialogModel> arrayList = concurrentHashMap.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    concurrentHashMap.put(str, arrayList);
                }
                List<PermissionDialogModel> list = arrayList;
                Iterator<PermissionDialogModel> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        PermissionDialogModel next = it.next();
                        if (next != null) {
                            String strB2 = b(next.getAction());
                            TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "checkRealShowPermissionDialog -> 遍历缓存, appId: " + str + ", scope: " + strB + ", cacheScope: " + strB2);
                            if (!TextUtils.isEmpty(strB2) && strB2.equals(strB)) {
                                if (app.getStartToken() == next.getStartToken()) {
                                    TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "checkRealShowPermissionDialog -> 遍历缓存, appId: " + str + ", scope: " + strB + " startToken一致，则丢弃该请求");
                                    break;
                                }
                                TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "checkRealShowPermissionDialog -> 遍历缓存, appId: " + str + ", scope: " + strB + " startToken不一致，判定缓存是失效的，进行剔除");
                                it.remove();
                            }
                        }
                    }
                    TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "checkRealShowPermissionDialog -> 添加入缓存, appId: " + str + ", scope: " + strB + ", startToken: " + app.getStartToken());
                    list.add(new PermissionDialogModel(page, str, str2, nativeCallContext, aVar, permissionModel, app.getStartToken()));
                    break;
                }
                bool = Boolean.FALSE;
            }
        }
        boolean zBooleanValue = bool.booleanValue();
        TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "doShowPermissionDialog -> showPermissionDialogAble:" + zBooleanValue + ", scope: " + scopeName);
        if (!zBooleanValue) {
            return true;
        }
        TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "doShowPermissionDialog -> showPermissionDialog, appId: " + str + ", scope: " + scopeName);
        ((DialogProxy) tc.a.a(DialogProxy.class)).showPermissionDialog(this.f65653a, scopeName, str4, str3, logo, new a(str2, scopeName, str, str3, logo, page));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new C0692b(this, str2, nativeCallContext, aVar));
        this.f65654b.put(scopeName, arrayList2);
        return true;
    }

    public final void g(String str, String str2) {
        List<C0692b> list = this.f65654b.get(str2);
        if (list != null) {
            for (C0692b c0692b : list) {
                if (c0692b.f65664b != null) {
                    k.a("cancelAuth...action=", str, "Tmcintegration:LocalAuthPermissionManager");
                    c0692b.f65664b.o();
                }
            }
        }
    }
}
