package go;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.common.util.concurrent.t;
import com.google.common.util.concurrent.v;
import java.util.concurrent.TimeUnit;
import p007do.m;
import p007do.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f65585g = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LocationManager f65586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f65587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t f65588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f65589f;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends n.a<i> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f65590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f65591c;

        public a() {
            super(i.class);
            this.f65591c = i.f65585g;
        }

        public /* synthetic */ a(int i11) {
            this();
        }

        @Override // do.n.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public i b(m mVar, Context context) {
            return new i(mVar, context, this, 0);
        }
    }

    public i(m mVar, Context context, a aVar) {
        super("locations", mVar);
        this.f65586c = aVar.f65590b ? null : (LocationManager) io.a.e(context, LocationManager.class, RequestParameters.SUBRESOURCE_LOCATION);
        this.f65587d = aVar.f65591c;
    }

    public /* synthetic */ i(m mVar, Context context, a aVar, int i11) {
        this(mVar, context, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        f fVarF;
        Location lastKnownLocation;
        LocationManager locationManager = this.f65586c;
        if (locationManager == null) {
            h(f.e(), f.e());
            return;
        }
        String[] strArr = {"gps", "network"};
        f[] fVarArr = new f[2];
        for (int i11 = 0; i11 < 2; i11++) {
            try {
                fVarF = (!locationManager.isProviderEnabled(strArr[i11]) || (lastKnownLocation = locationManager.getLastKnownLocation(strArr[i11])) == null) ? null : f.f(lastKnownLocation);
            } catch (Throwable unused) {
                String str = strArr[i11];
            }
            if (fVarF == null) {
                fVarF = f.e();
            }
            fVarArr[i11] = fVarF;
        }
        h(fVarArr[0], fVarArr[1]);
    }

    public static a ofProvider() {
        return new a(0);
    }

    @Override // p007do.n
    public void a() {
        t tVar = this.f65588e;
        this.f65588e = null;
        io.g.c(tVar);
    }

    @Override // p007do.n
    public void e(Context context) {
        i();
        if (this.f65586c != null) {
            v vVarN = d().n();
            Runnable runnable = new Runnable() { // from class: go.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f65584a.i();
                }
            };
            long j11 = this.f65587d;
            this.f65588e = vVarN.scheduleWithFixedDelay(runnable, j11, j11, TimeUnit.MILLISECONDS);
        }
    }

    public final void h(f fVar, f fVar2) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        g gVar = this.f65589f;
        if (gVar != null) {
            if (Long.compare(fVar.g() ^ Long.MIN_VALUE, gVar.c().g() ^ Long.MIN_VALUE) < 0) {
                fVar = gVar.c();
            }
            if (Long.compare(fVar2.g() ^ Long.MIN_VALUE, gVar.e().g() ^ Long.MIN_VALUE) < 0) {
                fVar2 = gVar.e();
            }
        }
        g gVar2 = new g(seconds, fVar, fVar2);
        this.f65589f = gVar2;
        c(gVar2);
    }

    public g j() {
        return this.f65589f;
    }
}
