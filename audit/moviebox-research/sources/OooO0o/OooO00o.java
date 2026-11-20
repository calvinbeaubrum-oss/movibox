package OooO0o;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.l;
import hd.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class OooO00o extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5a = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    public String a() {
        return "Tmcintegration:IpcMiniClientService";
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        TmcLogger.c(a(), "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        String strA = a();
        StringBuilder sbA = j.a("onCreate, processName: ");
        sbA.append(l.c());
        TmcLogger.c(strA, sbA.toString());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        TmcLogger.c(a(), "onDestroy");
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        TmcLogger.c(a(), "onLowMemory");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        TmcLogger.c(a(), "onStartCommand");
        return 2;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i11) {
        super.onTrimMemory(i11);
        TmcLogger.c(a(), "onTrimMemory: " + i11);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        TmcLogger.c(a(), "onUnbind");
        return super.onUnbind(intent);
    }
}
