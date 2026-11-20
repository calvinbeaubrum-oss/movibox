package g0;

import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.logging.type.LogSeverity;
import hd.j;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f65305b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f65304a = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<a> f65306c = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> f65307d = new ConcurrentHashMap<>();

    public final void a() {
        try {
            ConcurrentLinkedQueue<a> concurrentLinkedQueue = f65306c;
            if (concurrentLinkedQueue.size() >= b()) {
                concurrentLinkedQueue.poll();
                a();
            }
        } catch (Throwable th2) {
            TmcLogger.g("AthenaUtil", "checkOverFlow Fail:", th2);
        }
    }

    public final int b() {
        if (f65305b == -1) {
            f65305b = MiniAppConfigHelper.f30370a.c("athenaCacheSize", LogSeverity.NOTICE_VALUE);
        }
        StringBuilder sbA = j.a("CACHE_MAX_COUNT:");
        sbA.append(f65305b);
        TmcLogger.c("AthenaUtil", sbA.toString());
        return f65305b;
    }
}
