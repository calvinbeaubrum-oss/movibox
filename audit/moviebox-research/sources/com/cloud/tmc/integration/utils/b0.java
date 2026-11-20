package com.cloud.tmc.integration.utils;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static b0 f31026g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ArrayList<b> f31027h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LocationManager f31028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f31029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f31030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Location f31031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f31032e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LocationListener f31033f = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements LocationListener {
        public a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            b0.this.f31031d = location;
            b0.this.l();
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i11, Bundle bundle) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(double d11, double d12);

        void b(String str);
    }

    public b0(Context context) {
        this.f31029b = context;
        f();
    }

    public static synchronized b0 d(Context context) {
        try {
            if (f31026g == null) {
                f31027h = new ArrayList<>();
                f31026g = new b0(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f31026g;
    }

    public static boolean g() {
        return ((LocationManager) com.cloud.tmc.miniutils.util.e0.a().getSystemService(RequestParameters.SUBRESOURCE_LOCATION)).isProviderEnabled("gps");
    }

    public static boolean h() {
        LocationManager locationManager = (LocationManager) com.cloud.tmc.miniutils.util.e0.a().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        return locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }

    public static void i() {
        com.cloud.tmc.miniutils.util.e0.a().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS").addFlags(ASTNode.DEOP));
    }

    public void c() {
        try {
            j();
            ArrayList<b> arrayList = f31027h;
            if (arrayList != null) {
                arrayList.clear();
            }
        } catch (NullPointerException e11) {
            TmcLogger.e(e11.getMessage());
        }
    }

    public final void e() {
        if (z2.a.checkSelfPermission(this.f31029b, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return;
        }
        try {
            if (this.f31028a == null) {
                this.f31028a = (LocationManager) this.f31029b.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            }
            if (this.f31028a.getProviders(true).contains("network")) {
                this.f31028a.requestLocationUpdates("network", 5000L, 10.0f, this.f31033f);
                this.f31031d = this.f31028a.getLastKnownLocation("network");
            }
        } catch (Exception e11) {
            TmcLogger.g("LocationUtils", "Failed to request network location！", e11);
        }
        l();
    }

    public final void f() {
        this.f31028a = (LocationManager) this.f31029b.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        if (z2.a.checkSelfPermission(this.f31029b, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return;
        }
        List<String> providers = this.f31028a.getProviders(true);
        String str = "gps";
        if (!providers.contains("gps")) {
            str = "network";
            if (!providers.contains("network")) {
                c();
                try {
                    Intent intent = new Intent();
                    intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
                    this.f31029b.startActivity(intent);
                    return;
                } catch (Exception e11) {
                    TmcLogger.e(e11.getMessage());
                    return;
                }
            }
        }
        String str2 = str;
        Location lastKnownLocation = this.f31028a.getLastKnownLocation(str2);
        this.f31031d = lastKnownLocation;
        if (lastKnownLocation != null) {
            l();
        } else {
            e();
        }
        this.f31028a.requestLocationUpdates(str2, 5000L, 10.0f, this.f31033f);
    }

    public final void j() {
        LocationManager locationManager = this.f31028a;
        if (locationManager != null) {
            f31026g = null;
            locationManager.removeUpdates(this.f31033f);
            this.f31031d = null;
            this.f31030c = null;
        }
    }

    public void k(b bVar) {
        this.f31030c = bVar;
        l();
    }

    public final void l() {
        Location location = this.f31031d;
        if (location != null) {
            double latitude = location.getLatitude();
            double longitude = this.f31031d.getLongitude();
            b bVar = this.f31030c;
            if (bVar != null) {
                bVar.a(latitude, longitude);
                return;
            }
            return;
        }
        int i11 = this.f31032e + 1;
        this.f31032e = i11;
        if (i11 <= 3) {
            f();
            return;
        }
        this.f31032e = 0;
        String simCountryIso = ((TelephonyManager) this.f31029b.getApplicationContext().getSystemService("phone")).getSimCountryIso();
        if (simCountryIso.isEmpty()) {
            simCountryIso = Locale.getDefault().getCountry().toUpperCase();
        }
        b bVar2 = this.f31030c;
        if (bVar2 != null) {
            bVar2.b(simCountryIso);
        }
    }
}
