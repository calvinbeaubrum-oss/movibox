package OooO;

import OooO.OooO0OO;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.cloud.tmc.component_api_ps.ipc.MiniAppProtocolIpcProcessor;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.o;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import pd.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class OooO0OO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OooO0OO f3a = new OooO0OO();

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function2<a, String, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ String OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO(String str, String str2) {
            super(2);
            this.OooO00o = str;
            this.OooO0O0 = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(a aVar, String str) throws RemoteException {
            a aVar2 = aVar;
            if (aVar2 != null) {
                String str2 = this.OooO00o;
                Bundle bundle = new Bundle();
                bundle.putString("resultJsonData", this.OooO0O0);
                Unit unit = Unit.f68710a;
                aVar2.G("typeMiniAppShortcut", str2, bundle);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function2<a, String, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ String OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO00o(String str, String str2) {
            super(2);
            this.OooO00o = str;
            this.OooO0O0 = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(a aVar, String str) throws RemoteException {
            a aVar2 = aVar;
            if (aVar2 != null) {
                String str2 = this.OooO00o;
                Bundle bundle = new Bundle();
                bundle.putString("resultJsonData", this.OooO0O0);
                Unit unit = Unit.f68710a;
                aVar2.G("typeMiniAppCleanAllStorage", str2, bundle);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function2<a, String, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ long OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(String str, String str2, long j11) {
            super(2);
            this.OooO00o = str;
            this.OooO0O0 = str2;
            this.OooO0OO = j11;
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(a aVar, String str) throws RemoteException {
            a aVar2 = aVar;
            if (aVar2 != null) {
                String str2 = this.OooO00o;
                Bundle bundle = new Bundle();
                bundle.putString("resultJsonData", "{\"appId\":\"" + this.OooO0O0 + "\",\"size\":" + this.OooO0OO + '}');
                Unit unit = Unit.f68710a;
                aVar2.G("typeMiniAppCleanStorage", str2, bundle);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: OooO.OooO0OO$OooO0OO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0001OooO0OO extends Lambda implements Function2<a, String, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ String OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0001OooO0OO(String str, String str2) {
            super(2);
            this.OooO00o = str;
            this.OooO0O0 = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(a aVar, String str) throws RemoteException {
            a aVar2 = aVar;
            if (aVar2 != null) {
                String str2 = this.OooO00o;
                Bundle bundle = new Bundle();
                bundle.putString("resultJsonData", this.OooO0O0);
                Unit unit = Unit.f68710a;
                aVar2.G("typeMiniAppAllShortcut", str2, bundle);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function2<a, String, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ long OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0o(String str, String str2, long j11) {
            super(2);
            this.OooO00o = str;
            this.OooO0O0 = str2;
            this.OooO0OO = j11;
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(a aVar, String str) throws RemoteException {
            a aVar2 = aVar;
            if (aVar2 != null) {
                String str2 = this.OooO00o;
                Bundle bundle = new Bundle();
                bundle.putString("resultJsonData", "{\"appId\":\"" + this.OooO0O0 + "\",\"size\":" + this.OooO0OO + '}');
                Unit unit = Unit.f68710a;
                aVar2.G("typeMiniAppStorage", str2, bundle);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void b(String str, Bundle bundle, String str2) {
        String string;
        try {
            Context applicationContext = ((IApplicationContextGetter) tc.a.a(IApplicationContextGetter.class)).getApplicationContext();
            Intrinsics.f(applicationContext, "get(IApplicationContextG….java).applicationContext");
            if (str != null) {
                switch (str.hashCode()) {
                    case -1225344574:
                        if (str.equals("typeMiniAppCleanStorage")) {
                            f3a.d(bundle, applicationContext, str2);
                            return;
                        }
                        return;
                    case -1017194837:
                        if (str.equals("typeMiniAppStorage")) {
                            f3a.f(bundle, applicationContext, str2);
                            return;
                        }
                        return;
                    case -891583177:
                        if (str.equals("typeMiniAppAllShortcut")) {
                            f3a.e(bundle, applicationContext, str2);
                            return;
                        }
                        return;
                    case 730412906:
                        if (str.equals("typeMiniAppAllStorage")) {
                            if (bundle != null) {
                                try {
                                    string = bundle.getString("miniAppPSChannelIpcPkg", "com.transsnet.store");
                                } catch (Throwable th2) {
                                    TmcLogger.g("MiniAppDataSyncHelper", "querySDKVersion error:", th2);
                                    return;
                                }
                            } else {
                                string = null;
                            }
                            String str3 = string;
                            Context applicationContext2 = applicationContext.getApplicationContext();
                            Intrinsics.f(applicationContext2, "context.applicationContext");
                            MiniAppProtocolIpcProcessor.f30350a.j(applicationContext, str3, null, (16 & 8) != 0 ? null : new OooO.OooO0o(str2, FileUtil.C(applicationContext2)), (16 & 16) != 0 ? null : null);
                            return;
                        }
                        return;
                    case 767151638:
                        if (str.equals("typeMiniAppShortcut")) {
                            f3a.g(bundle, applicationContext, str2);
                            return;
                        }
                        return;
                    case 1674373363:
                        if (str.equals("typeMiniAppCleanAllStorage")) {
                            f3a.a(bundle, applicationContext, str2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
                TmcLogger.g("MiniAppDataSyncHelper", "protocolInvoke error:", th);
            }
        } catch (Throwable th3) {
            TmcLogger.g("MiniAppDataSyncHelper", "protocolInvoke error:", th3);
        }
    }

    public final void a(Bundle bundle, Context context, String str) {
        String string;
        if (bundle != null) {
            try {
                string = bundle.getString("miniAppPSChannelIpcPkg", "com.transsnet.store");
            } catch (Throwable th2) {
                TmcLogger.g("MiniAppDataSyncHelper", "querySDKVersion error:", th2);
                return;
            }
        } else {
            string = null;
        }
        MiniAppProtocolIpcProcessor.f30350a.j(context, string, null, (16 & 8) != 0 ? null : new OooO00o(str, FileUtil.f31012a.q(context, bundle != null ? Long.valueOf(bundle.getLong("removeStoregeSize", 0L)) : null)), (16 & 16) != 0 ? null : null);
    }

    public void c(final String str, final String str2, final Bundle bundle) {
        try {
            e.a(ExecutorType.IO, new Runnable() { // from class: b.d
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0OO.b(str, bundle, str2);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppDataSyncHelper", "protocolInvoke error:", th2);
        }
    }

    public final void d(Bundle bundle, Context context, String str) {
        String string;
        if (bundle != null) {
            try {
                string = bundle.getString("miniAppPSChannelIpcPkg", "com.transsnet.store");
            } catch (Throwable th2) {
                TmcLogger.g("MiniAppDataSyncHelper", "querySDKVersion error:", th2);
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
        long jM = FileUtil.M(context, str2);
        FileUtil.e0(context, str2);
        MiniAppProtocolIpcProcessor.f30350a.j(context, string, null, (16 & 8) != 0 ? null : new OooO0O0(str, str2, jM), (16 & 16) != 0 ? null : null);
    }

    public final void e(Bundle bundle, Context context, String str) {
        String string;
        ArrayList<String> arrayList;
        if (bundle != null) {
            try {
                string = bundle.getString("miniAppPSChannelIpcPkg", "com.transsnet.store");
            } catch (Throwable th2) {
                TmcLogger.g("MiniAppDataSyncHelper", "queryMiniShortcuts error:", th2);
                return;
            }
        } else {
            string = null;
        }
        String string2 = bundle != null ? bundle.getString("queryAppId", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) : null;
        if (string2 == null || (arrayList = (ArrayList) TmcGsonUtils.d(string2, ArrayList.class)) == null) {
            arrayList = new ArrayList();
        }
        JsonArray jsonArray = new JsonArray();
        for (String str2 : arrayList) {
            JsonObject jsonObjectE = z.a().d(PushConstants.PROVIDER_FIELD_APP_ID, str2).b("exist", Boolean.valueOf(AppUtils.f31011a.v(context, str2))).e();
            Intrinsics.f(jsonObjectE, "create()\n               …                 .build()");
            jsonArray.add(jsonObjectE);
        }
        MiniAppProtocolIpcProcessor.f30350a.j(context, string, null, (16 & 8) != 0 ? null : new C0001OooO0OO(str, o.a(jsonArray)), (16 & 16) != 0 ? null : null);
    }

    public final void f(Bundle bundle, Context context, String str) {
        String string;
        long jM;
        if (bundle != null) {
            try {
                string = bundle.getString("miniAppPSChannelIpcPkg", "com.transsnet.store");
            } catch (Throwable th2) {
                TmcLogger.g("MiniAppDataSyncHelper", "querySDKVersion error:", th2);
                return;
            }
        } else {
            string = null;
        }
        String string2 = bundle != null ? bundle.getString("queryAppId", "") : null;
        if (string2 == null || string2.length() <= 0) {
            jM = 0;
        } else {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.f(applicationContext, "context.applicationContext");
            jM = FileUtil.M(applicationContext, string2);
        }
        MiniAppProtocolIpcProcessor.f30350a.j(context, string, null, (16 & 8) != 0 ? null : new OooO0o(str, string2, jM), (16 & 16) != 0 ? null : null);
    }

    public final void g(Bundle bundle, Context context, String str) {
        String string;
        if (bundle != null) {
            try {
                string = bundle.getString("miniAppPSChannelIpcPkg", "com.transsnet.store");
            } catch (Throwable th2) {
                TmcLogger.g("MiniAppDataSyncHelper", "querySingleMiniShortcut error:", th2);
                return;
            }
        } else {
            string = null;
        }
        String string2 = bundle != null ? bundle.getString("queryAppId", "") : null;
        JsonObject jsonObjectE = z.a().d(PushConstants.PROVIDER_FIELD_APP_ID, string2).b("exist", Boolean.valueOf(AppUtils.f31011a.v(context, string2))).e();
        Intrinsics.f(jsonObjectE, "create()\n               …\n                .build()");
        MiniAppProtocolIpcProcessor.f30350a.j(context, string, null, (16 & 8) != 0 ? null : new OooO(str, o.a(jsonObjectE)), (16 & 16) != 0 ? null : null);
    }
}
