package n;

import hd.j;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicLong f71316a = new AtomicLong(0);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        StringBuilder sbA = j.a("Tmc#IconDownloadThreadFactory_");
        sbA.append(this.f71316a.addAndGet(1L));
        return new Thread(runnable, sbA.toString());
    }
}
