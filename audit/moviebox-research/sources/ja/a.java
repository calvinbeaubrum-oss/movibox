package ja;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.kernel.utils.p;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Location f67962a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static double f67963b = 0.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static double f67964c = 0.0d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f67965d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f67966e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f67967f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicInteger f67968g = new AtomicInteger(0);

    public static boolean a() {
        return f67963b == 0.0d && f67964c == 0.0d && f67968g.getAndIncrement() <= 1;
    }

    public static long b() {
        g();
        return f67966e;
    }

    public static double c() {
        g();
        return f67963b;
    }

    @SuppressLint({"MissingPermission"})
    public static void d() {
        try {
            if (ws.a.a() != null) {
                LocationManager locationManager = (LocationManager) ws.a.a().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
                boolean zIsProviderEnabled2 = locationManager.isProviderEnabled("network");
                if (!zIsProviderEnabled && !zIsProviderEnabled2) {
                    return;
                }
                if (zIsProviderEnabled) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                    f67962a = lastKnownLocation;
                    f(lastKnownLocation);
                }
                if (zIsProviderEnabled2 && f67962a == null) {
                    p.a("ssp", "Positioning through the network");
                    Location lastKnownLocation2 = locationManager.getLastKnownLocation("network");
                    f67962a = lastKnownLocation2;
                    f(lastKnownLocation2);
                }
            }
        } catch (Throwable unused) {
            p.a("ssp", "Location Impossible to connect to LocationManager");
        }
        Location location = f67962a;
        if (location != null) {
            f(location);
        }
    }

    public static double e() {
        g();
        return f67964c;
    }

    public static void f(Location location) {
        if (location != null) {
            f67963b = location.getLatitude();
            f67964c = location.getLongitude();
            f67965d = (int) location.getAccuracy();
            f67966e = location.getTime();
            try {
                f67967f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z").format(new Date(f67966e));
            } catch (Exception e11) {
                p.c("ad", Log.getStackTraceString(e11));
            }
        }
    }

    public static void g() {
        if (a()) {
            d();
        }
    }
}
