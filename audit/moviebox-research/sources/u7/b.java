package u7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends u7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f78490a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f78491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public hi.a f78492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ServiceConnection f78493d;

    /* JADX INFO: renamed from: u7.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public final class ServiceConnectionC0865b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f78494a;

        public ServiceConnectionC0865b(c cVar) {
            if (cVar == null) {
                throw new RuntimeException("Please specify a listener to know when setup is done.");
            }
            this.f78494a = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            v7.a.a("InstallReferrerClient", "Install Referrer service connected.");
            b.this.f78492c = hi.a.AbstractBinderC0696a.e0(iBinder);
            b.this.f78490a = 2;
            this.f78494a.a(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            v7.a.b("InstallReferrerClient", "Install Referrer service disconnected.");
            b.this.f78492c = null;
            b.this.f78490a = 0;
            this.f78494a.b();
        }
    }

    public b(Context context) {
        this.f78491b = context.getApplicationContext();
    }

    @Override // u7.a
    public void a() {
        this.f78490a = 3;
        if (this.f78493d != null) {
            v7.a.a("InstallReferrerClient", "Unbinding from service.");
            this.f78491b.unbindService(this.f78493d);
            this.f78493d = null;
        }
        this.f78492c = null;
    }

    @Override // u7.a
    public d b() throws RemoteException {
        if (!h()) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.f78491b.getPackageName());
        try {
            return new d(this.f78492c.k(bundle));
        } catch (RemoteException e11) {
            v7.a.b("InstallReferrerClient", "RemoteException getting install referrer information");
            this.f78490a = 0;
            throw e11;
        }
    }

    @Override // u7.a
    public void d(c cVar) {
        ServiceInfo serviceInfo;
        if (h()) {
            v7.a.a("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            cVar.a(0);
            return;
        }
        int i11 = this.f78490a;
        if (i11 == 1) {
            v7.a.b("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            cVar.a(3);
            return;
        }
        if (i11 == 3) {
            v7.a.b("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            cVar.a(3);
            return;
        }
        v7.a.a("InstallReferrerClient", "Starting install referrer service setup.");
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        List<ResolveInfo> listQueryIntentServices = this.f78491b.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty() || (serviceInfo = listQueryIntentServices.get(0).serviceInfo) == null) {
            this.f78490a = 0;
            v7.a.a("InstallReferrerClient", "Install Referrer service unavailable on device.");
            cVar.a(2);
            return;
        }
        String str = serviceInfo.packageName;
        String str2 = serviceInfo.name;
        if (!"com.android.vending".equals(str) || str2 == null || !g()) {
            v7.a.b("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
            this.f78490a = 0;
            cVar.a(2);
            return;
        }
        Intent intent2 = new Intent(intent);
        ServiceConnectionC0865b serviceConnectionC0865b = new ServiceConnectionC0865b(cVar);
        this.f78493d = serviceConnectionC0865b;
        try {
            if (this.f78491b.bindService(intent2, serviceConnectionC0865b, 1)) {
                v7.a.a("InstallReferrerClient", "Service was bonded successfully.");
                return;
            }
            v7.a.b("InstallReferrerClient", "Connection to service is blocked.");
            this.f78490a = 0;
            cVar.a(1);
        } catch (SecurityException unused) {
            v7.a.b("InstallReferrerClient", "No permission to connect to service.");
            this.f78490a = 0;
            cVar.a(4);
        }
    }

    public final boolean g() {
        try {
            return this.f78491b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public boolean h() {
        return (this.f78490a != 2 || this.f78492c == null || this.f78493d == null) ? false : true;
    }
}
