package com.cloud.hisavana.sdk.api.config;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.cloud.hisavana.net.CommonOkHttpClient;
import com.cloud.hisavana.sdk.a0;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.http.AdServerRequest;
import com.cloud.hisavana.sdk.common.util.PolyGammaUtil;
import com.cloud.hisavana.sdk.d0;
import com.cloud.hisavana.sdk.database.HisavanaContentProvider;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.hisavana.sdk.n;
import com.cloud.hisavana.sdk.v;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.sdk.commonutil.util.i;
import com.cloud.sdk.commonutil.util.l;
import com.cloud.sdk.commonutil.util.p;
import iq.k;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class AdManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f29116a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f29117b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f29118c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static AtomicLong f29119d = new AtomicLong(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f29120e = -1;

    /* JADX INFO: compiled from: source.java */
    public class a implements AdServerRequest.b {
        @Override // com.cloud.hisavana.sdk.common.http.AdServerRequest.b
        public String a() {
            return "{}";
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f29121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f29122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f29123c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f29124d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f29125e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f29126f;

        public b(c cVar) {
            this.f29122b = false;
            this.f29123c = "";
            this.f29124d = "";
            this.f29126f = false;
            this.f29121a = cVar.f29127a;
            this.f29122b = cVar.f29128b;
            this.f29123c = cVar.f29129c;
            this.f29124d = cVar.f29130d;
            this.f29125e = cVar.f29131e;
            this.f29126f = cVar.f29132f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f29128b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f29127a = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f29129c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f29130d = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f29131e = 200;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f29132f = false;

        public b c() {
            return new b(this);
        }

        public c h(String str) {
            AdManager.f29117b = str;
            return this;
        }

        public c i(boolean z11) {
            this.f29127a = z11;
            f.i(z11);
            z.a().setLogSwitch(this.f29127a);
            com.cloud.sdk.commonutil.util.c.NET_LOG.m().q(this.f29127a);
            return this;
        }

        public c j(int i11) {
            this.f29131e = i11;
            return this;
        }

        public c k(long j11) {
            AdManager.f29119d.set(j11);
            return this;
        }

        public c l(boolean z11) {
            this.f29132f = z11;
            return this;
        }

        public c m(String str) {
            this.f29129c = str;
            return this;
        }

        public c n(boolean z11) {
            this.f29128b = z11;
            return this;
        }
    }

    public static void b(@NonNull b bVar) {
        if (f29116a != null || bVar == null) {
            return;
        }
        if (!bVar.f29121a) {
            com.cloud.sdk.commonutil.util.c.NET_LOG.m().q(Log.isLoggable("AD_NET_LOG", 3));
        }
        if (!bVar.f29121a) {
            bVar.f29121a = Log.isLoggable("TA_SDK", 3) || Log.isLoggable("ADSDK", 3);
        }
        f29116a = bVar;
        d0.f29612a.c(f29116a.f29125e);
        DeviceUtil.e();
        AthenaTracker.n(f29116a.f29121a, f.a());
        NetStateManager.registerMonitorBroadcast();
        z.a().setLogSwitch(f29116a.f29121a);
        AthenaTracker.T();
        d();
        i iVar = i.f30292a;
        iVar.e(new Runnable() { // from class: com.cloud.hisavana.sdk.api.config.AdManager.1
            @Override // java.lang.Runnable
            public void run() {
                AdManager.e();
            }
        });
        v.p().g(1);
        l.c();
        iVar.e(new Runnable() { // from class: com.cloud.hisavana.sdk.api.config.AdManager.2
            @Override // java.lang.Runnable
            public void run() {
                p.n();
                ca.b.s0();
            }
        });
        a0.f29085a.g(f29119d.get());
        PolyGammaUtil.f29515a.e();
        n.f29890a.M();
    }

    public static void d() {
        try {
            if (f.a().getApplicationContext() instanceof Application) {
                k.c((Application) f.a().getApplicationContext(), false);
                CommonOkHttpClient.f28925a = h();
            }
        } catch (Exception unused) {
            z.a().e("init NetworkMonitor failure!");
        }
    }

    public static void e() {
        if (da.a.d().c("preLoadNet", false)) {
            AdServerRequest adServerRequestR = new AdServerRequest().p(new a()).l(h()).r(aa.a.i() + aa.a.g());
            if (adServerRequestR != null) {
                adServerRequestR.c();
            }
        }
    }

    public static int f() {
        return f29120e;
    }

    public static void g(Context context, @NonNull b bVar) {
        f.f(context);
        HisavanaContentProvider.f();
        b(bVar);
    }

    public static boolean h() {
        b bVar = f29116a;
        if (bVar != null) {
            return bVar.f29121a;
        }
        return false;
    }

    public static boolean i() {
        b bVar = f29116a;
        if (bVar != null) {
            return bVar.f29122b;
        }
        return false;
    }

    public static boolean j() {
        return f29118c;
    }

    public static void k(boolean z11) {
        f29118c = z11;
    }

    public static boolean l() {
        b bVar = f29116a;
        if (bVar != null) {
            return bVar.f29126f;
        }
        return false;
    }
}
