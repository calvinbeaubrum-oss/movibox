package com.cloud.tmc.integration.bridge;

import android.R;
import android.content.Context;
import androidx.annotation.NonNull;
import com.cloud.tmc.integration.R$string;
import com.cloud.tmc.integration.proxy.DialogProxy;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.b0;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.cloud.tmc.miniutils.util.e0;
import com.google.android.gms.stats.CodePackage;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class LocationBridge implements BridgeExtension {

    /* JADX INFO: compiled from: source.java */
    public class a implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f30490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f30491b;

        /* JADX INFO: renamed from: com.cloud.tmc.integration.bridge.LocationBridge$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0337a implements ua.a {
            public C0337a() {
            }

            @Override // ua.a
            public void a() {
                bc.a aVar = a.this.f30491b;
                if (aVar != null) {
                    aVar.e(z.a().d("errMsg", "not open GPS,go setting:LB002").e());
                }
                b0.i();
            }

            @Override // ua.a
            public void b() {
                bc.a aVar = a.this.f30491b;
                if (aVar != null) {
                    aVar.e(z.a().d("errMsg", "not open GPS:LB001").e());
                }
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b implements b0.b {
            public b() {
            }

            @Override // com.cloud.tmc.integration.utils.b0.b
            public void a(double d11, double d12) {
                JsonObject jsonObjectA = LocationBridge.this.a("", d11 + "", d12 + "");
                bc.a aVar = a.this.f30491b;
                if (aVar != null) {
                    aVar.d(jsonObjectA);
                }
                b0.d(e0.a()).c();
            }

            @Override // com.cloud.tmc.integration.utils.b0.b
            public void b(String str) {
                JsonObject jsonObjectA = LocationBridge.this.a(str, "", "");
                bc.a aVar = a.this.f30491b;
                if (aVar != null) {
                    aVar.d(jsonObjectA);
                }
                b0.d(e0.a()).c();
            }
        }

        public a(Context context, bc.a aVar) {
            this.f30490a = context;
            this.f30491b = aVar;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            bc.a aVar = this.f30491b;
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Location Permission denied :LB003").e());
            }
            ((DialogProxy) tc.a.a(DialogProxy.class)).showLocationPermissionDialog(this.f30490a);
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            if (!b0.h() && !b0.g()) {
                try {
                    ((ToastProxy) tc.a.a(ToastProxy.class)).showCommonDialog("", this.f30490a.getString(R$string.mini_setting_open_gps), 2, Boolean.TRUE, this.f30490a.getString(R.string.cancel), "", this.f30490a.getString(R.string.ok), "", this.f30490a, new C0337a());
                } catch (Throwable th2) {
                    TmcLogger.g("LocationBridge", "getLocation", th2);
                }
            }
            b0.d(e0.a()).k(new b());
        }
    }

    public final JsonObject a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("countryCode", str);
        jsonObject.addProperty("latitude", str2);
        jsonObject.addProperty("longitude", str3);
        return jsonObject;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void getLocation(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            aVar.b();
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            aVar.b();
            return;
        }
        Context context = appContext.getContext();
        if (context == null) {
            aVar.b();
        } else {
            PermissionUtils.y(CodePackage.LOCATION).m(new a(context, aVar)).z();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        b0.d(e0.a()).c();
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }
}
