package go;

import android.location.Location;
import android.os.Build;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import io.l;
import io.o;
import io.r;
import java.util.concurrent.TimeUnit;
import l.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f65573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f65574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f65575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f65576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f65577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f65578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f65579g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f65580h;

    public f(long j11, double d11, double d12, double d13, float f11, float f12, float f13, float f14) {
        this.f65573a = j11;
        this.f65574b = d11;
        this.f65575c = d12;
        this.f65576d = d13;
        this.f65577e = f11;
        this.f65578f = f12;
        this.f65579g = f13;
        this.f65580h = f14;
    }

    public static f e() {
        return new f(0L, Double.NaN, Double.NaN, Double.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN);
    }

    public static f f(Location location) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i11 = Build.VERSION.SDK_INT;
        return new f(TimeUnit.MILLISECONDS.toSeconds(jCurrentTimeMillis - (i11 >= 33 ? location.getElapsedRealtimeAgeMillis(SystemClock.elapsedRealtime()) : TimeUnit.NANOSECONDS.toMillis(SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos()))), location.getLatitude(), location.getLongitude(), location.hasAltitude() ? location.getAltitude() : Double.NaN, location.hasSpeed() ? location.getSpeed() : Float.NaN, location.hasAccuracy() ? location.getAccuracy() : Float.NaN, (i11 < 26 || !location.hasVerticalAccuracy()) ? Float.NaN : location.getVerticalAccuracyMeters(), (i11 < 26 || !location.hasSpeedAccuracy()) ? Float.NaN : location.getSpeedAccuracyMetersPerSecond());
    }

    @Override // io.l
    public void a(r rVar) {
        rVar.n(1, this.f65573a).k(2, this.f65574b).k(3, this.f65575c).k(4, this.f65576d).l(5, this.f65577e).l(6, this.f65578f).l(7, this.f65579g).l(8, this.f65580h);
    }

    public boolean c() {
        return equals(e());
    }

    @Override // io.l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public f b(o oVar) {
        long j11 = this.f65573a;
        double d11 = this.f65574b;
        double d12 = this.f65575c;
        double d13 = this.f65576d;
        float f11 = this.f65577e;
        float f12 = this.f65578f;
        long j12 = j11;
        double dG = d11;
        double dG2 = d12;
        double dG3 = d13;
        float fH = f11;
        float fH2 = f12;
        float fH3 = this.f65579g;
        float fH4 = this.f65580h;
        while (oVar.b()) {
            switch (oVar.n()) {
                case 1:
                    j12 = oVar.j();
                    break;
                case 2:
                    dG = oVar.g();
                    break;
                case 3:
                    dG2 = oVar.g();
                    break;
                case 4:
                    dG3 = oVar.g();
                    break;
                case 5:
                    fH = oVar.h();
                    break;
                case 6:
                    fH2 = oVar.h();
                    break;
                case 7:
                    fH3 = oVar.h();
                    break;
                case 8:
                    fH4 = oVar.h();
                    break;
                default:
                    oVar.c();
                    break;
            }
        }
        return new f(j12, dG, dG2, dG3, fH, fH2, fH3, fH4);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f65573a == fVar.f65573a && Double.doubleToLongBits(this.f65574b) == Double.doubleToLongBits(fVar.f65574b) && Double.doubleToLongBits(this.f65575c) == Double.doubleToLongBits(fVar.f65575c) && Double.doubleToLongBits(this.f65576d) == Double.doubleToLongBits(fVar.f65576d) && Float.floatToIntBits(this.f65577e) == Float.floatToIntBits(fVar.f65577e) && Float.floatToIntBits(this.f65578f) == Float.floatToIntBits(fVar.f65578f) && Float.floatToIntBits(this.f65579g) == Float.floatToIntBits(fVar.f65579g) && Float.floatToIntBits(this.f65580h) == Float.floatToIntBits(fVar.f65580h);
    }

    public long g() {
        return this.f65573a;
    }

    public int hashCode() {
        return p.a(this.f65573a);
    }

    public String toString() {
        return super.toString();
    }
}
