package dr;

import android.os.Bundle;
import androidx.annotation.RequiresApi;
import athena.a0;
import com.transsion.athena.data.TrackData;
import com.transsion.ga.AthenaAnalytics;
import cr.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(api = 3)
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TrackData f63529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f63530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f63531c;

    public a(String str) {
        long jD = b.d();
        this.f63531c = jD;
        if (jD == 0) {
            a0.c("FAILED! You should init Athena first before track the event " + str);
        }
        this.f63530b = str;
        this.f63529a = new TrackData();
    }

    public a(String str, int i11) {
        this.f63531c = i11;
        this.f63530b = str;
        this.f63529a = new TrackData();
    }

    public final void a(String str, Bundle bundle) {
        if (bundle != null) {
            this.f63529a.add(str, bundle);
        }
    }

    public void b() {
        AthenaAnalytics.A(this.f63531c).R(this.f63530b, this.f63529a, this.f63531c);
    }

    public a c(Bundle bundle, Bundle bundle2) {
        a("eparam", bundle);
        a("ext", bundle2);
        return this;
    }
}
