package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.Priority;
import com.hisavana.common.constant.ComConstants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class SchedulerConfig {

    /* JADX INFO: compiled from: source.java */
    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public og.a f32657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<Priority, b> f32658b = new HashMap();

        public a a(Priority priority, b bVar) {
            this.f32658b.put(priority, bVar);
            return this;
        }

        public SchedulerConfig b() {
            if (this.f32657a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f32658b.keySet().size() < Priority.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map<Priority, b> map = this.f32658b;
            this.f32658b = new HashMap();
            return SchedulerConfig.d(this.f32657a, map);
        }

        public a c(og.a aVar) {
            this.f32657a = aVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static abstract class b {

        /* JADX INFO: compiled from: source.java */
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j11);

            public abstract a c(Set<Flag> set);

            public abstract a d(long j11);
        }

        public static a a() {
            return new com.google.android.datatransport.runtime.scheduling.jobscheduling.b.C0356b().c(Collections.emptySet());
        }

        public abstract long b();

        public abstract Set<Flag> c();

        public abstract long d();
    }

    public static a b() {
        return new a();
    }

    public static SchedulerConfig d(og.a aVar, Map<Priority, b> map) {
        return new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(aVar, map);
    }

    public static SchedulerConfig f(og.a aVar) {
        return b().a(Priority.DEFAULT, b.a().b(30000L).d(ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED).a()).a(Priority.HIGHEST, b.a().b(1000L).d(ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED).a()).a(Priority.VERY_LOW, b.a().b(ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED).d(ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED).c(i(Flag.DEVICE_IDLE)).a()).c(aVar).b();
    }

    public static <T> Set<T> i(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    public final long a(int i11, long j11) {
        int i12 = i11 - 1;
        return (long) (Math.pow(3.0d, i12) * j11 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j11 > 1 ? j11 : 2L) * ((long) i12))));
    }

    @RequiresApi(api = 21)
    public JobInfo.Builder c(JobInfo.Builder builder, Priority priority, long j11, int i11) {
        builder.setMinimumLatency(g(priority, j11, i11));
        j(builder, h().get(priority).c());
        return builder;
    }

    public abstract og.a e();

    public long g(Priority priority, long j11, int i11) {
        long jA = j11 - e().a();
        b bVar = h().get(priority);
        return Math.min(Math.max(a(i11, bVar.b()), jA), bVar.d());
    }

    public abstract Map<Priority, b> h();

    @RequiresApi(api = 21)
    public final void j(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }
}
