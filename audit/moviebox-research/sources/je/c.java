package je;

import com.cloud.tmc.miniapp.utils.athena.AthenaConstants;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f67998a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AtomicBoolean f67999b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AtomicInteger f68000c = new AtomicInteger(-1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ThreadPoolExecutor f68001d = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(28), new ie.b(), new ie.a());

    public static void a() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getInitAthenaStatus -> currentProcessIsInitAthena:");
            sb2.append(f67998a.get());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("getInitAthenaStatus -> mainProcessIsInitAthena:");
            sb3.append(f67999b.get());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("getInitAthenaStatus -> delayStatus:");
            sb4.append(f68000c.get());
            if (!f67998a.get()) {
                AtomicBoolean atomicBoolean = AthenaConstants.currentProcessIsInitAthena;
                f67998a.set(((AtomicBoolean) AthenaConstants.class.getField("currentProcessIsInitAthena").get(null)).get());
            }
            if (!f67999b.get()) {
                AtomicBoolean atomicBoolean2 = AthenaConstants.currentProcessIsInitAthena;
                f67999b.set(((AtomicBoolean) AthenaConstants.class.getField("mainProcessIsInitAthena").get(null)).get());
            }
            if (f68000c.get() == -1) {
                AtomicBoolean atomicBoolean3 = AthenaConstants.currentProcessIsInitAthena;
                if (((AtomicBoolean) AthenaConstants.class.getField("delay").get(null)).get()) {
                    f68000c.set(1);
                } else {
                    f68000c.set(0);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
