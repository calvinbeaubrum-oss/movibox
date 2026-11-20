package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c extends ScheduledThreadPoolExecutor {

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f73920a = new c();
    }

    public c() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }

    public static c a() {
        return b.f73920a;
    }
}
