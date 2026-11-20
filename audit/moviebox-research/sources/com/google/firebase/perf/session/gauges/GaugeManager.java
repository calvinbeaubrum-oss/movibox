package com.google.firebase.perf.session.gauges;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import bl.b;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.e;
import com.google.firebase.perf.v1.f;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import rj.u;
import ul.c;
import ul.i;
import ul.l;
import vl.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class GaugeManager {
    private static final long APPROX_NUMBER_OF_DATA_POINTS_PER_GAUGE_METRIC = 20;
    private static final long INVALID_GAUGE_COLLECTION_FREQUENCY = -1;
    private static final long TIME_TO_WAIT_BEFORE_FLUSHING_GAUGES_QUEUE_MS = 20;
    private ApplicationProcessState applicationProcessState;
    private final nl.a configResolver;
    private final u<c> cpuGaugeCollector;

    @Nullable
    private ScheduledFuture gaugeManagerDataCollectionJob;
    private final u<ScheduledExecutorService> gaugeManagerExecutor;

    @Nullable
    private i gaugeMetadataManager;
    private final u<l> memoryGaugeCollector;

    @Nullable
    private String sessionId;
    private final k transportManager;
    private static final ql.a logger = ql.a.e();
    private static final GaugeManager instance = new GaugeManager();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41016a;

        static {
            int[] iArr = new int[ApplicationProcessState.values().length];
            f41016a = iArr;
            try {
                iArr[ApplicationProcessState.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41016a[ApplicationProcessState.FOREGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private GaugeManager() {
        this(new u(new b() { // from class: ul.f
            @Override // bl.b
            public final Object get() {
                return Executors.newSingleThreadScheduledExecutor();
            }
        }), k.k(), nl.a.g(), null, new u(new b() { // from class: ul.g
            @Override // bl.b
            public final Object get() {
                return GaugeManager.lambda$new$1();
            }
        }), new u(new b() { // from class: ul.h
            @Override // bl.b
            public final Object get() {
                return GaugeManager.lambda$new$2();
            }
        }));
    }

    public GaugeManager(u<ScheduledExecutorService> uVar, k kVar, nl.a aVar, i iVar, u<c> uVar2, u<l> uVar3) {
        this.gaugeManagerDataCollectionJob = null;
        this.sessionId = null;
        this.applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.gaugeManagerExecutor = uVar;
        this.transportManager = kVar;
        this.configResolver = aVar;
        this.gaugeMetadataManager = iVar;
        this.cpuGaugeCollector = uVar2;
        this.memoryGaugeCollector = uVar3;
    }

    private static void collectGaugeMetricOnce(c cVar, l lVar, Timer timer) {
        cVar.c(timer);
        lVar.c(timer);
    }

    private long getCpuGaugeCollectionFrequencyMs(ApplicationProcessState applicationProcessState) {
        long jY;
        int i11 = a.f41016a[applicationProcessState.ordinal()];
        if (i11 != 1) {
            jY = i11 != 2 ? -1L : this.configResolver.z();
        } else {
            jY = this.configResolver.y();
        }
        if (c.f(jY)) {
            return -1L;
        }
        return jY;
    }

    private e getGaugeMetadata() {
        return e.W().K(this.gaugeMetadataManager.a()).L(this.gaugeMetadataManager.b()).M(this.gaugeMetadataManager.c()).build();
    }

    public static synchronized GaugeManager getInstance() {
        return instance;
    }

    private long getMemoryGaugeCollectionFrequencyMs(ApplicationProcessState applicationProcessState) {
        long jB;
        int i11 = a.f41016a[applicationProcessState.ordinal()];
        if (i11 != 1) {
            jB = i11 != 2 ? -1L : this.configResolver.C();
        } else {
            jB = this.configResolver.B();
        }
        if (l.e(jB)) {
            return -1L;
        }
        return jB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c lambda$new$1() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l lambda$new$2() {
        return new l();
    }

    private boolean startCollectingCpuMetrics(long j11, Timer timer) {
        if (j11 == -1) {
            logger.a("Invalid Cpu Metrics collection frequency. Did not collect Cpu Metrics.");
            return false;
        }
        this.cpuGaugeCollector.get().k(j11, timer);
        return true;
    }

    private long startCollectingGauges(ApplicationProcessState applicationProcessState, Timer timer) {
        long cpuGaugeCollectionFrequencyMs = getCpuGaugeCollectionFrequencyMs(applicationProcessState);
        if (!startCollectingCpuMetrics(cpuGaugeCollectionFrequencyMs, timer)) {
            cpuGaugeCollectionFrequencyMs = -1;
        }
        long memoryGaugeCollectionFrequencyMs = getMemoryGaugeCollectionFrequencyMs(applicationProcessState);
        if (startCollectingMemoryMetrics(memoryGaugeCollectionFrequencyMs, timer)) {
            return cpuGaugeCollectionFrequencyMs == -1 ? memoryGaugeCollectionFrequencyMs : Math.min(cpuGaugeCollectionFrequencyMs, memoryGaugeCollectionFrequencyMs);
        }
        return cpuGaugeCollectionFrequencyMs;
    }

    private boolean startCollectingMemoryMetrics(long j11, Timer timer) {
        if (j11 == -1) {
            logger.a("Invalid Memory Metrics collection frequency. Did not collect Memory Metrics.");
            return false;
        }
        this.memoryGaugeCollector.get().j(j11, timer);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: syncFlush, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$stopCollectingGauges$4(String str, ApplicationProcessState applicationProcessState) {
        f.b bVarF0 = f.f0();
        while (!this.cpuGaugeCollector.get().f78575a.isEmpty()) {
            bVarF0.L(this.cpuGaugeCollector.get().f78575a.poll());
        }
        while (!this.memoryGaugeCollector.get().f78598b.isEmpty()) {
            bVarF0.K(this.memoryGaugeCollector.get().f78598b.poll());
        }
        bVarF0.N(str);
        this.transportManager.A(bVarF0.build(), applicationProcessState);
    }

    public void collectGaugeMetricOnce(Timer timer) {
        collectGaugeMetricOnce(this.cpuGaugeCollector.get(), this.memoryGaugeCollector.get(), timer);
    }

    public void initializeGaugeMetadataManager(Context context) {
        this.gaugeMetadataManager = new i(context);
    }

    public boolean logGaugeMetadata(String str, ApplicationProcessState applicationProcessState) {
        if (this.gaugeMetadataManager == null) {
            return false;
        }
        this.transportManager.A(f.f0().N(str).M(getGaugeMetadata()).build(), applicationProcessState);
        return true;
    }

    public void startCollectingGauges(PerfSession perfSession, final ApplicationProcessState applicationProcessState) {
        if (this.sessionId != null) {
            stopCollectingGauges();
        }
        long jStartCollectingGauges = startCollectingGauges(applicationProcessState, perfSession.getTimer());
        if (jStartCollectingGauges == -1) {
            logger.j("Invalid gauge collection frequency. Unable to start collecting Gauges.");
            return;
        }
        final String strSessionId = perfSession.sessionId();
        this.sessionId = strSessionId;
        this.applicationProcessState = applicationProcessState;
        try {
            long j11 = jStartCollectingGauges * 20;
            this.gaugeManagerDataCollectionJob = this.gaugeManagerExecutor.get().scheduleAtFixedRate(new Runnable() { // from class: ul.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f78584a.lambda$startCollectingGauges$3(strSessionId, applicationProcessState);
                }
            }, j11, j11, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e11) {
            logger.j("Unable to start collecting Gauges: " + e11.getMessage());
        }
    }

    public void stopCollectingGauges() {
        final String str = this.sessionId;
        if (str == null) {
            return;
        }
        final ApplicationProcessState applicationProcessState = this.applicationProcessState;
        this.cpuGaugeCollector.get().l();
        this.memoryGaugeCollector.get().k();
        ScheduledFuture scheduledFuture = this.gaugeManagerDataCollectionJob;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.gaugeManagerExecutor.get().schedule(new Runnable() { // from class: ul.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f78581a.lambda$stopCollectingGauges$4(str, applicationProcessState);
            }
        }, 20L, TimeUnit.MILLISECONDS);
        this.sessionId = null;
        this.applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
    }
}
