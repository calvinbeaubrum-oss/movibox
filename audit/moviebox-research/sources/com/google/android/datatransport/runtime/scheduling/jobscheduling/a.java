package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends SchedulerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final og.a f32659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Priority, SchedulerConfig.b> f32660b;

    public a(og.a aVar, Map<Priority, SchedulerConfig.b> map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f32659a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f32660b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public og.a e() {
        return this.f32659a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        return this.f32659a.equals(schedulerConfig.e()) && this.f32660b.equals(schedulerConfig.h());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public Map<Priority, SchedulerConfig.b> h() {
        return this.f32660b;
    }

    public int hashCode() {
        return ((this.f32659a.hashCode() ^ 1000003) * 1000003) ^ this.f32660b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f32659a + ", values=" + this.f32660b + "}";
    }
}
