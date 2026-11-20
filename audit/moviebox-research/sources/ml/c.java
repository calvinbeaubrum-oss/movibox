package ml;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.metrics.h;
import com.google.firebase.perf.util.e;
import java.util.WeakHashMap;
import vl.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c extends FragmentManager.m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ql.a f71132f = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<Fragment, Trace> f71133a = new WeakHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.firebase.perf.util.a f71134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f71135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f71136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f71137e;

    public c(com.google.firebase.perf.util.a aVar, k kVar, a aVar2, d dVar) {
        this.f71134b = aVar;
        this.f71135c = kVar;
        this.f71136d = aVar2;
        this.f71137e = dVar;
    }

    public String a(Fragment fragment) {
        return "_st_" + fragment.getClass().getSimpleName();
    }

    @Override // androidx.fragment.app.FragmentManager.m
    public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        super.onFragmentPaused(fragmentManager, fragment);
        ql.a aVar = f71132f;
        aVar.b("FragmentMonitor %s.onFragmentPaused ", fragment.getClass().getSimpleName());
        if (!this.f71133a.containsKey(fragment)) {
            aVar.k("FragmentMonitor: missed a fragment trace from %s", fragment.getClass().getSimpleName());
            return;
        }
        Trace trace = this.f71133a.get(fragment);
        this.f71133a.remove(fragment);
        e<h.a> eVarF = this.f71137e.f(fragment);
        if (!eVarF.d()) {
            aVar.k("onFragmentPaused: recorder failed to trace %s", fragment.getClass().getSimpleName());
        } else {
            com.google.firebase.perf.util.h.a(trace, eVarF.c());
            trace.stop();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.m
    public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
        f71132f.b("FragmentMonitor %s.onFragmentResumed", fragment.getClass().getSimpleName());
        Trace trace = new Trace(a(fragment), this.f71135c, this.f71134b, this.f71136d);
        trace.start();
        trace.putAttribute("Parent_fragment", fragment.getParentFragment() == null ? "No parent" : fragment.getParentFragment().getClass().getSimpleName());
        if (fragment.getActivity() != null) {
            trace.putAttribute("Hosting_activity", fragment.getActivity().getClass().getSimpleName());
        }
        this.f71133a.put(fragment, trace);
        this.f71137e.d(fragment);
    }
}
