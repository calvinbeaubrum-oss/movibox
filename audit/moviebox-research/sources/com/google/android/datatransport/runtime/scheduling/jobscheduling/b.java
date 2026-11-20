package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends SchedulerConfig.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f32661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<SchedulerConfig.Flag> f32663c;

    /* JADX INFO: renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0356b extends SchedulerConfig.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f32664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f32665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set<SchedulerConfig.Flag> f32666c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b a() {
            String str = "";
            if (this.f32664a == null) {
                str = " delta";
            }
            if (this.f32665b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f32666c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new b(this.f32664a.longValue(), this.f32665b.longValue(), this.f32666c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a b(long j11) {
            this.f32664a = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a c(Set<SchedulerConfig.Flag> set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f32666c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a d(long j11) {
            this.f32665b = Long.valueOf(j11);
            return this;
        }
    }

    public b(long j11, long j12, Set<SchedulerConfig.Flag> set) {
        this.f32661a = j11;
        this.f32662b = j12;
        this.f32663c = set;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public long b() {
        return this.f32661a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public Set<SchedulerConfig.Flag> c() {
        return this.f32663c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public long d() {
        return this.f32662b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.b)) {
            return false;
        }
        SchedulerConfig.b bVar = (SchedulerConfig.b) obj;
        return this.f32661a == bVar.b() && this.f32662b == bVar.d() && this.f32663c.equals(bVar.c());
    }

    public int hashCode() {
        long j11 = this.f32661a;
        int i11 = (((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003;
        long j12 = this.f32662b;
        return this.f32663c.hashCode() ^ ((i11 ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f32661a + ", maxAllowedDelay=" + this.f32662b + ", flags=" + this.f32663c + "}";
    }
}
