package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.Calendar;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c0 f842d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocationManager f844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f845c = new a();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f847b;
    }

    public c0(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.f843a = context;
        this.f844b = locationManager;
    }

    public static c0 a(@NonNull Context context) {
        if (f842d == null) {
            Context applicationContext = context.getApplicationContext();
            f842d = new c0(applicationContext, (LocationManager) applicationContext.getSystemService(RequestParameters.SUBRESOURCE_LOCATION));
        }
        return f842d;
    }

    @SuppressLint({"MissingPermission"})
    public final Location b() {
        Location locationC = z2.f.c(this.f843a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = z2.f.c(this.f843a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        if (locationC2 == null || locationC == null) {
            return locationC2 != null ? locationC2 : locationC;
        }
        return locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public final Location c(String str) {
        try {
            if (this.f844b.isProviderEnabled(str)) {
                return this.f844b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean d() {
        a aVar = this.f845c;
        if (e()) {
            return aVar.f846a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.f846a;
        }
        int i11 = Calendar.getInstance().get(11);
        return i11 < 6 || i11 >= 22;
    }

    public final boolean e() {
        return this.f845c.f847b > System.currentTimeMillis();
    }

    public final void f(@NonNull Location location) {
        long j11;
        a aVar = this.f845c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        b0 b0VarB = b0.b();
        b0VarB.a(jCurrentTimeMillis - ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED, location.getLatitude(), location.getLongitude());
        b0VarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z11 = b0VarB.f838c == 1;
        long j12 = b0VarB.f837b;
        long j13 = b0VarB.f836a;
        b0VarB.a(jCurrentTimeMillis + ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED, location.getLatitude(), location.getLongitude());
        long j14 = b0VarB.f837b;
        if (j12 == -1 || j13 == -1) {
            j11 = jCurrentTimeMillis + 43200000;
        } else {
            if (jCurrentTimeMillis <= j13) {
                j14 = jCurrentTimeMillis > j12 ? j13 : j12;
            }
            j11 = j14 + ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        }
        aVar.f846a = z11;
        aVar.f847b = j11;
    }
}
