package com.amazonaws.util;

import com.amazonaws.logging.LogFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class TimingInfoFullSupport extends TimingInfo {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<TimingInfo>> f16276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Number> f16277e;

    public TimingInfoFullSupport(Long l11, long j11, Long l12) {
        super(l11, j11, l12);
        this.f16276d = new HashMap();
        this.f16277e = new HashMap();
    }

    @Override // com.amazonaws.util.TimingInfo
    public void a(String str, TimingInfo timingInfo) {
        List<TimingInfo> arrayList = this.f16276d.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f16276d.put(str, arrayList);
        }
        if (timingInfo.k()) {
            arrayList.add(timingInfo);
            return;
        }
        LogFactory.b(getClass()).a("Skip submeasurement timing info with no end time for " + str);
    }

    @Override // com.amazonaws.util.TimingInfo
    public Map<String, Number> d() {
        return this.f16277e;
    }

    @Override // com.amazonaws.util.TimingInfo
    public Map<String, List<TimingInfo>> g() {
        return this.f16276d;
    }

    @Override // com.amazonaws.util.TimingInfo
    public void j(String str) {
        Number numberQ = q(str);
        l(str, (numberQ != null ? numberQ.intValue() : 0) + 1);
    }

    @Override // com.amazonaws.util.TimingInfo
    public void l(String str, long j11) {
        this.f16277e.put(str, Long.valueOf(j11));
    }

    public Number q(String str) {
        return this.f16277e.get(str);
    }
}
