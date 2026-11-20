package com.cloud.tmc.miniapp.ipc;

import android.app.Application;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.cloud.tmc.component_api_ps.async.MiniAppIpcAsyncManager;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.l;
import com.cloud.tmc.miniapp.ipc.IpcMiniLauncherService;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.e0;
import hd.g;
import hd.j;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class IpcMiniLauncherService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31538a = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: com.cloud.tmc.miniapp.ipc.IpcMiniLauncherService$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class ServiceConnectionC0343a implements ServiceConnection {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f31539a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Bundle f31540b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Context f31541c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ i.a f31542d;

            public ServiceConnectionC0343a(String str, Bundle bundle, Context context, i.a aVar) {
                this.f31539a = str;
                this.f31540b = bundle;
                this.f31541c = context;
                this.f31542d = aVar;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    g gVarE0 = g.a.e0(iBinder);
                    if (gVarE0 != null) {
                        String str = this.f31539a;
                        Bundle bundle = this.f31540b;
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        gVarE0.A(str, bundle);
                    }
                    try {
                        this.f31541c.unbindService(this);
                    } catch (Throwable th2) {
                        TmcLogger.h(":IpcTaskManagerService", th2);
                    }
                } catch (Throwable th3) {
                    TmcLogger.g(":IpcTaskManagerService", "Exception startService", th3);
                    i.a aVar = this.f31542d;
                    if (aVar != null) {
                        aVar.a(0, th3);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                System.out.println((Object) "connect fail");
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class b implements ServiceConnection {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f31543a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f31544b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ i.a f31545c;

            public b(boolean z11, Context context, i.a aVar) {
                this.f31543a = z11;
                this.f31544b = context;
                this.f31545c = aVar;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    TmcLogger.c(":IpcTaskManagerService", "warmupWebview iMiniLauncherChannel");
                    g gVarE0 = g.a.e0(iBinder);
                    if (gVarE0 != null) {
                        gVarE0.p(this.f31543a);
                    }
                    try {
                        this.f31544b.unbindService(this);
                    } catch (Throwable th2) {
                        TmcLogger.h(":IpcTaskManagerService", th2);
                    }
                } catch (Throwable th3) {
                    TmcLogger.g(":IpcTaskManagerService", "Exception startService", th3);
                    i.a aVar = this.f31545c;
                    if (aVar != null) {
                        aVar.a(0, th3);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                System.out.println((Object) "connect fail");
            }
        }

        public static final void c(Context context, String str, Bundle bundle, i.a aVar) {
            try {
                a aVar2 = IpcMiniLauncherService.f31538a;
                Intent intent = new Intent(context, (Class<?>) IpcMiniLauncherService.class);
                h.f31061a.a(intent, context);
                if (context != null) {
                    context.bindService(intent, new ServiceConnectionC0343a(str, bundle, context, aVar), 1);
                }
            } catch (Throwable unused) {
            }
        }

        @JvmStatic
        public final void a(final Context context, final String str, final Bundle bundle, final i.a aVar) {
            StringBuilder sbA = j.a("startService: ");
            sbA.append(Log.getStackTraceString(new Throwable("Just print")));
            TmcLogger.c(":IpcTaskManagerService", sbA.toString());
            try {
                if (!l.e()) {
                    MiniAppIpcAsyncManager.f30347a.d(new Runnable() { // from class: nd.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            IpcMiniLauncherService.a.c(context, str, bundle, aVar);
                        }
                    });
                    return;
                }
                Context applicationContext = context != null ? context.getApplicationContext() : null;
                e0.c(applicationContext instanceof Application ? (Application) applicationContext : null);
                ((MiniAppLaunch.c) aVar).b(false);
            } catch (Throwable th2) {
                TmcLogger.h(":IpcTaskManagerService", th2);
                ((MiniAppLaunch.c) aVar).a(0, th2);
            }
        }

        @JvmStatic
        public final void b(Context context, boolean z11, i.a aVar) {
            try {
                TmcLogger.c(":IpcTaskManagerService", "warmupWebview");
                if (l.e()) {
                    TmcLogger.c(":IpcTaskManagerService", "warmupWebview isMiniProcess");
                    Context applicationContext = context != null ? context.getApplicationContext() : null;
                    e0.c(applicationContext instanceof Application ? (Application) applicationContext : null);
                    ((MiniAppLaunch.e) aVar).b(false);
                    return;
                }
                Intent intent = new Intent(context, (Class<?>) IpcMiniLauncherService.class);
                h.f31061a.a(intent, context);
                if (context != null) {
                    context.bindService(intent, new b(z11, context, aVar), 1);
                }
            } catch (Throwable th2) {
                TmcLogger.h(":IpcTaskManagerService", th2);
                TmcLogger.h(MiniAppLaunch.f31785b, th2);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        TmcLogger.c(":IpcTaskManagerService", "onBind");
        return new k.a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        TmcLogger.c(":IpcTaskManagerService", "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        TmcLogger.c(":IpcTaskManagerService", "onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        TmcLogger.c(":IpcTaskManagerService", "onStartCommand");
        return super.onStartCommand(intent, i11, i12);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        TmcLogger.c(":IpcTaskManagerService", "onUnbind");
        return super.onUnbind(intent);
    }
}
