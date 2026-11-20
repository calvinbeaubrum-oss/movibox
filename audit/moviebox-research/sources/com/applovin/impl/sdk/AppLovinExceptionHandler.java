package com.applovin.impl.sdk;

import android.os.Process;
import com.applovin.impl.la;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sj;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AppLovinExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AppLovinExceptionHandler f22364d = new AppLovinExceptionHandler();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f22365a = new HashSet(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f22366b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f22367c;

    public static AppLovinExceptionHandler shared() {
        return f22364d;
    }

    public void addSdk(j jVar) {
        if (this.f22365a.contains(jVar)) {
            return;
        }
        this.f22365a.add(jVar);
    }

    public void enable() {
        if (this.f22366b.compareAndSet(false, true)) {
            this.f22367c = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        long jLongValue = 500;
        for (j jVar : this.f22365a) {
            jVar.J();
            if (n.a()) {
                jVar.J().a("AppLovinExceptionHandler", "Detected unhandled exception");
            }
            jVar.E().a(la.J, CollectionUtils.map("top_main_method", th2.toString()));
            jVar.A().trackEventSynchronously("paused");
            jLongValue = ((Long) jVar.a(sj.f23104y3)).longValue();
        }
        try {
            Thread.sleep(jLongValue);
        } catch (InterruptedException unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f22367c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }
}
