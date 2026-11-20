package com.cloud.sdk.commonutil.util;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Location f30278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static double f30279b = 0.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static double f30280c = 0.0d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f30281d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f30282e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f30283f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicInteger f30284g = new AtomicInteger(0);

    public static boolean a() {
        return f30279b == 0.0d && f30280c == 0.0d && f30284g.getAndIncrement() <= 1;
    }

    public static long b() {
        h();
        return f30282e;
    }

    public static String c() {
        h();
        return f30283f;
    }

    public static double d() {
        h();
        return f30279b;
    }

    @SuppressLint({"MissingPermission"})
    public static void e() {
        try {
            if (f.a() != null) {
                LocationManager locationManager = (LocationManager) f.a().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
                boolean zIsProviderEnabled2 = locationManager.isProviderEnabled("network");
                if (!zIsProviderEnabled && !zIsProviderEnabled2) {
                    return;
                }
                if (zIsProviderEnabled) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                    f30278a = lastKnownLocation;
                    g(lastKnownLocation);
                }
                if (zIsProviderEnabled2 && f30278a == null) {
                    Location lastKnownLocation2 = locationManager.getLastKnownLocation("network");
                    f30278a = lastKnownLocation2;
                    g(lastKnownLocation2);
                }
            }
        } catch (Throwable unused) {
            c.Log().d("ssp", "Location Impossible to connect to LocationManager");
        }
        Location location = f30278a;
        if (location != null) {
            g(location);
        }
    }

    public static double f() {
        h();
        return f30280c;
    }

    public static void g(Location location) {
        if (location != null) {
            f30279b = location.getLatitude();
            f30280c = location.getLongitude();
            f30281d = (int) location.getAccuracy();
            f30282e = location.getTime();
            try {
                f30283f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z").format(new Date(f30282e));
            } catch (Exception e11) {
                c.Log().e(Log.getStackTraceString(e11));
            }
        }
    }

    public static void h() {
        if (a()) {
            e();
        }
    }
}
