package com.google.firebase.perf.metrics;

import androidx.annotation.NonNull;
import com.google.firebase.perf.session.PerfSession;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Trace f41015a;

    public k(@NonNull Trace trace) {
        this.f41015a = trace;
    }

    public com.google.firebase.perf.v1.i a() {
        com.google.firebase.perf.v1.i.b bVarS = com.google.firebase.perf.v1.i.w0().T(this.f41015a.getName()).R(this.f41015a.getStartTime().getMicros()).S(this.f41015a.getStartTime().getDurationMicros(this.f41015a.getEndTime()));
        for (Counter counter : this.f41015a.getCounters().values()) {
            bVarS.Q(counter.getName(), counter.getCount());
        }
        List<Trace> subtraces = this.f41015a.getSubtraces();
        if (!subtraces.isEmpty()) {
            Iterator<Trace> it = subtraces.iterator();
            while (it.hasNext()) {
                bVarS.N(new k(it.next()).a());
            }
        }
        bVarS.P(this.f41015a.getAttributes());
        com.google.firebase.perf.v1.h[] hVarArrBuildAndSort = PerfSession.buildAndSort(this.f41015a.getSessions());
        if (hVarArrBuildAndSort != null) {
            bVarS.K(Arrays.asList(hVarArrBuildAndSort));
        }
        return bVarS.build();
    }
}
