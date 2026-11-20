package OooO;

import OooO.OooO00o;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.component_api_ps.ipc.MiniAppProtocolIpcProcessor;
import com.cloud.tmc.integration.model.MiniAddHomeDataModel;
import com.cloud.tmc.integration.utils.AddHomeToScreenUtils;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.miniapp.GlobalPackageConfig;
import com.cloud.tmc.miniapp.offlineapps.OfflineAppBean;
import com.cloud.tmc.offline.download.OfflineManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import p.d;
import pd.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class OooO00o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OooO00o f2a = new OooO00o();

    /* JADX INFO: renamed from: OooO.OooO00o$OooO00o, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0000OooO00o extends Lambda implements Function2<a, String, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ JsonArray OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0000OooO00o(String str, JsonArray jsonArray) {
            super(2);
            this.OooO00o = str;
            this.OooO0O0 = jsonArray;
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(a aVar, String str) throws RemoteException {
            a aVar2 = aVar;
            if (aVar2 != null) {
                String str2 = this.OooO00o;
                Bundle bundle = new Bundle();
                bundle.putString("resultJsonData", o.a(this.OooO0O0));
                Unit unit = Unit.f68710a;
                aVar2.J("typeMiniAppOffline", str2, bundle);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function2<a, String, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ z.a OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(String str, z.a aVar) {
            super(2);
            this.OooO00o = str;
            this.OooO0O0 = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(a aVar, String str) throws RemoteException {
            a aVar2 = aVar;
            if (aVar2 != null) {
                String str2 = this.OooO00o;
                Bundle bundle = new Bundle();
                JsonObject jsonObjectE = this.OooO0O0.e();
                Intrinsics.f(jsonObjectE, "resultObj.build()");
                bundle.putString("resultJsonData", o.a(jsonObjectE));
                Unit unit = Unit.f68710a;
                aVar2.J("typeSingleMiniAppOffline", str2, bundle);
            }
            return Unit.f68710a;
        }
    }

    public static final void c(Context context, String appId, String name, String logoUrl) {
        Intrinsics.g(context, "$context");
        Intrinsics.g(appId, "$appId");
        Intrinsics.g(name, "$name");
        Intrinsics.g(logoUrl, "$logoUrl");
        AddHomeToScreenUtils.p(AddHomeToScreenUtils.f30986a, context, new MiniAddHomeDataModel(appId, name, logoUrl), "", false, false, null, 56, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void f(String str, String str2, Bundle bundle) {
        String string;
        try {
            Context applicationContext = ((IApplicationContextGetter) tc.a.a(IApplicationContextGetter.class)).getApplicationContext();
            Intrinsics.f(applicationContext, "get(IApplicationContextG….java).applicationContext");
            if (str != null) {
                switch (str.hashCode()) {
                    case -2135366643:
                        if (str.equals("typePreloadOfflineApp")) {
                            OfflineManager.v(bundle != null ? bundle.getString("queryAppId", "") : null, false, null, 4, null);
                            return;
                        }
                        return;
                    case -2039708617:
                        if (str.equals("typeMiniAppAddShortcut")) {
                            f2a.a(applicationContext, bundle);
                            return;
                        }
                        return;
                    case -1827174149:
                        if (str.equals("typeSingleMiniAppOffline")) {
                            f2a.e(applicationContext, str2, bundle);
                            return;
                        }
                        return;
                    case -681532909:
                        if (str.equals("typeMiniAppOffline")) {
                            f2a.b(applicationContext, str2, bundle);
                            return;
                        }
                        return;
                    case 1218687240:
                        if (str.equals("typeMiniAppVersion")) {
                            if (bundle != null) {
                                try {
                                    string = bundle.getString("miniAppPSChannelIpcPkg", "com.transsnet.store");
                                } catch (Throwable th2) {
                                    TmcLogger.g("MiniAppAbilityHelper", "querySDKVersion error:", th2);
                                    return;
                                }
                            } else {
                                string = null;
                            }
                            MiniAppProtocolIpcProcessor.f30350a.j(applicationContext, string, null, (16 & 8) != 0 ? null : new OooO.OooO0O0(str2, GlobalPackageConfig.Companion.b()), (16 & 16) != 0 ? null : null);
                            return;
                        }
                        return;
                    default:
                        return;
                }
                TmcLogger.g("MiniAppAbilityHelper", "protocolInvoke error:", th);
            }
        } catch (Throwable th3) {
            TmcLogger.g("MiniAppAbilityHelper", "protocolInvoke error:", th3);
        }
    }

    public final void a(final Context context, Bundle bundle) {
        final String string;
        final String string2;
        final String string3 = bundle != null ? bundle.getString("queryAppId", "") : null;
        if (string3 == null || (string = bundle.getString("appName", "")) == null || (string2 = bundle.getString("logoUrl", "")) == null) {
            return;
        }
        e.f(new Runnable() { // from class: b.c
            @Override // java.lang.Runnable
            public final void run() {
                OooO00o.c(context, string3, string, string2);
            }
        });
    }

    public final void b(Context context, String str, Bundle bundle) {
        String string;
        ArrayList<String> arrayList;
        if (bundle != null) {
            try {
                string = bundle.getString("miniAppPSChannelIpcPkg", "com.transsnet.store");
            } catch (Throwable th2) {
                TmcLogger.g("MiniAppAbilityHelper", "querySDKVersion error:", th2);
                return;
            }
        } else {
            string = null;
        }
        String str2 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        String string2 = bundle != null ? bundle.getString("queryAppId", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) : null;
        if (string2 != null) {
            str2 = string2;
        }
        try {
            arrayList = (ArrayList) TmcGsonUtils.d(str2, ArrayList.class);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
        } catch (Throwable unused) {
            arrayList = new ArrayList();
        }
        JsonArray jsonArray = new JsonArray();
        Map<String, OfflineAppBean> map = d.f73470d;
        if (arrayList.isEmpty()) {
            Iterator it = ((LinkedHashMap) map).keySet().iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
        }
        for (String str3 : arrayList) {
            OfflineAppBean offlineAppBean = (OfflineAppBean) ((LinkedHashMap) map).get(str3);
            z.a aVarA = z.a();
            Intrinsics.f(aVarA, "create()");
            if (offlineAppBean != null) {
                aVarA.d(PushConstants.PROVIDER_FIELD_APP_ID, offlineAppBean.getAppId());
                aVarA.d("logoUrl", offlineAppBean.getLogoUrl());
                aVarA.d("appName", offlineAppBean.getName());
                aVarA.d("version", offlineAppBean.getVersion());
                aVarA.b(NotificationCompat.CATEGORY_STATUS, Boolean.TRUE);
                jsonArray.add(aVarA.e());
            } else {
                aVarA.d(PushConstants.PROVIDER_FIELD_APP_ID, str3);
                aVarA.b(NotificationCompat.CATEGORY_STATUS, Boolean.FALSE);
                jsonArray.add(aVarA.e());
            }
        }
        MiniAppProtocolIpcProcessor.f30350a.j(context, string, null, (16 & 8) != 0 ? null : new C0000OooO00o(str, jsonArray), (16 & 16) != 0 ? null : null);
    }

    public void d(final String str, final String str2, final Bundle bundle) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("protocolInvoke: ");
        sb2.append(str);
        sb2.append(" callbackId ->");
        sb2.append(str2);
        try {
            e.a(ExecutorType.IO, new Runnable() { // from class: b.b
                @Override // java.lang.Runnable
                public final void run() {
                    OooO00o.f(str, str2, bundle);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppAbilityHelper", "protocolInvoke error:", th2);
        }
    }

    public final void e(Context context, String str, Bundle bundle) {
        String string;
        if (bundle != null) {
            try {
                string = bundle.getString("miniAppPSChannelIpcPkg", "com.transsnet.store");
            } catch (Throwable th2) {
                TmcLogger.g("MiniAppAbilityHelper", "querySDKVersion error:", th2);
                return;
            }
        } else {
            string = null;
        }
        String str2 = "";
        String string2 = bundle != null ? bundle.getString("queryAppId", "") : null;
        if (string2 != null) {
            str2 = string2;
        }
        OfflineAppBean offlineAppBean = (OfflineAppBean) ((LinkedHashMap) d.f73470d).get(str2);
        z.a aVarA = z.a();
        Intrinsics.f(aVarA, "create()");
        if (offlineAppBean != null) {
            aVarA.d(PushConstants.PROVIDER_FIELD_APP_ID, offlineAppBean.getAppId());
            aVarA.d("logoUrl", offlineAppBean.getLogoUrl());
            aVarA.d("appName", offlineAppBean.getName());
            aVarA.d("version", offlineAppBean.getVersion());
            aVarA.b(NotificationCompat.CATEGORY_STATUS, Boolean.TRUE);
        } else {
            aVarA.d(PushConstants.PROVIDER_FIELD_APP_ID, str2);
            aVarA.b(NotificationCompat.CATEGORY_STATUS, Boolean.FALSE);
        }
        MiniAppProtocolIpcProcessor.f30350a.j(context, string, null, (16 & 8) != 0 ? null : new OooO0O0(str, aVarA), (16 & 16) != 0 ? null : null);
    }
}
