package rl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.v1.i;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ql.a f75618b = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f75619a;

    public d(@NonNull i iVar) {
        this.f75619a = iVar;
    }

    @Override // rl.e
    public boolean c() {
        if (!o(this.f75619a, 0)) {
            f75618b.j("Invalid Trace:" + this.f75619a.o0());
            return false;
        }
        if (!j(this.f75619a) || h(this.f75619a)) {
            return true;
        }
        f75618b.j("Invalid Counters for Trace:" + this.f75619a.o0());
        return false;
    }

    public final boolean g(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                e.d(entry.getKey(), entry.getValue());
            } catch (IllegalArgumentException e11) {
                f75618b.j(e11.getLocalizedMessage());
                return false;
            }
        }
        return true;
    }

    public final boolean h(@NonNull i iVar) {
        return i(iVar, 0);
    }

    public final boolean i(@Nullable i iVar, int i11) {
        if (iVar == null) {
            return false;
        }
        if (i11 > 1) {
            f75618b.j("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        }
        for (Map.Entry<String, Long> entry : iVar.i0().entrySet()) {
            if (!l(entry.getKey())) {
                f75618b.j("invalid CounterId:" + entry.getKey());
                return false;
            }
            if (!m(entry.getValue())) {
                f75618b.j("invalid CounterValue:" + entry.getValue());
                return false;
            }
        }
        Iterator<i> it = iVar.q0().iterator();
        while (it.hasNext()) {
            if (!i(it.next(), i11 + 1)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(@NonNull i iVar) {
        if (iVar.h0() > 0) {
            return true;
        }
        Iterator<i> it = iVar.q0().iterator();
        while (it.hasNext()) {
            if (it.next().h0() > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean k(@NonNull i iVar) {
        return iVar.o0().startsWith("_st_");
    }

    public final boolean l(@Nullable String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            f75618b.j("counterId is empty");
            return false;
        }
        if (strTrim.length() <= 100) {
            return true;
        }
        f75618b.j("counterId exceeded max length 100");
        return false;
    }

    public final boolean m(@Nullable Long l11) {
        return l11 != null;
    }

    public final boolean n(@NonNull i iVar) {
        Long l11 = iVar.i0().get(Constants$CounterNames.FRAMES_TOTAL.toString());
        return l11 != null && l11.compareTo((Long) 0L) > 0;
    }

    public final boolean o(@Nullable i iVar, int i11) {
        if (iVar == null) {
            f75618b.j("TraceMetric is null");
            return false;
        }
        if (i11 > 1) {
            f75618b.j("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        }
        if (!q(iVar.o0())) {
            f75618b.j("invalid TraceId:" + iVar.o0());
            return false;
        }
        if (!p(iVar)) {
            f75618b.j("invalid TraceDuration:" + iVar.l0());
            return false;
        }
        if (!iVar.r0()) {
            f75618b.j("clientStartTimeUs is null.");
            return false;
        }
        if (!k(iVar) || n(iVar)) {
            Iterator<i> it = iVar.q0().iterator();
            while (it.hasNext()) {
                if (!o(it.next(), i11 + 1)) {
                    return false;
                }
            }
            return g(iVar.j0());
        }
        f75618b.j("non-positive totalFrames in screen trace " + iVar.o0());
        return false;
    }

    public final boolean p(@Nullable i iVar) {
        return iVar != null && iVar.l0() > 0;
    }

    public final boolean q(@Nullable String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        return !strTrim.isEmpty() && strTrim.length() <= 100;
    }
}
