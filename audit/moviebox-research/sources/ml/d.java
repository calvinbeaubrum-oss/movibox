package ml;

import android.app.Activity;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.core.app.f;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.metrics.h;
import com.google.firebase.perf.util.e;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ql.a f71138e = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f71139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f71140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Fragment, h.a> f71141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f71142d;

    public d(Activity activity) {
        this(activity, new f(), new HashMap());
    }

    @VisibleForTesting
    public d(Activity activity, f fVar, Map<Fragment, h.a> map) {
        this.f71142d = false;
        this.f71139a = activity;
        this.f71140b = fVar;
        this.f71141c = map;
    }

    public static boolean a() {
        return true;
    }

    public final e<h.a> b() {
        if (!this.f71142d) {
            f71138e.a("No recording has been started.");
            return e.a();
        }
        SparseIntArray[] sparseIntArrayArrB = this.f71140b.b();
        if (sparseIntArrayArrB == null) {
            f71138e.a("FrameMetricsAggregator.mMetrics is uninitialized.");
            return e.a();
        }
        if (sparseIntArrayArrB[0] != null) {
            return e.e(h.a(sparseIntArrayArrB));
        }
        f71138e.a("FrameMetricsAggregator.mMetrics[TOTAL_INDEX] is uninitialized.");
        return e.a();
    }

    public void c() {
        if (this.f71142d) {
            f71138e.b("FrameMetricsAggregator is already recording %s", this.f71139a.getClass().getSimpleName());
        } else {
            this.f71140b.a(this.f71139a);
            this.f71142d = true;
        }
    }

    public void d(Fragment fragment) {
        if (!this.f71142d) {
            f71138e.a("Cannot start sub-recording because FrameMetricsAggregator is not recording");
            return;
        }
        if (this.f71141c.containsKey(fragment)) {
            f71138e.b("Cannot start sub-recording because one is already ongoing with the key %s", fragment.getClass().getSimpleName());
            return;
        }
        e<h.a> eVarB = b();
        if (eVarB.d()) {
            this.f71141c.put(fragment, eVarB.c());
        } else {
            f71138e.b("startFragment(%s): snapshot() failed", fragment.getClass().getSimpleName());
        }
    }

    public e<h.a> e() {
        if (!this.f71142d) {
            f71138e.a("Cannot stop because no recording was started");
            return e.a();
        }
        if (!this.f71141c.isEmpty()) {
            f71138e.a("Sub-recordings are still ongoing! Sub-recordings should be stopped first before stopping Activity screen trace.");
            this.f71141c.clear();
        }
        e<h.a> eVarB = b();
        try {
            this.f71140b.c(this.f71139a);
        } catch (IllegalArgumentException | NullPointerException e11) {
            if ((e11 instanceof NullPointerException) && Build.VERSION.SDK_INT > 28) {
                throw e11;
            }
            f71138e.k("View not hardware accelerated. Unable to collect FrameMetrics. %s", e11.toString());
            eVarB = e.a();
        }
        this.f71140b.d();
        this.f71142d = false;
        return eVarB;
    }

    public e<h.a> f(Fragment fragment) {
        if (!this.f71142d) {
            f71138e.a("Cannot stop sub-recording because FrameMetricsAggregator is not recording");
            return e.a();
        }
        if (!this.f71141c.containsKey(fragment)) {
            f71138e.b("Sub-recording associated with key %s was not started or does not exist", fragment.getClass().getSimpleName());
            return e.a();
        }
        h.a aVarRemove = this.f71141c.remove(fragment);
        e<h.a> eVarB = b();
        if (eVarB.d()) {
            return e.e(eVarB.c().a(aVarRemove));
        }
        f71138e.b("stopFragment(%s): snapshot() failed", fragment.getClass().getSimpleName());
        return e.a();
    }
}
