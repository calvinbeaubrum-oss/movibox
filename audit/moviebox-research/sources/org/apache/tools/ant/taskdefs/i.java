package org.apache.tools.ant.taskdefs;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.util.Watchdog;
import org.apache.tools.ant.util.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class i implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Process f72797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f72798b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Exception f72799c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f72800d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Watchdog f72801f;

    public i(long j11) {
        Watchdog watchdog = new Watchdog(j11);
        this.f72801f = watchdog;
        watchdog.addTimeoutObserver(this);
    }

    public synchronized void a() throws BuildException {
        if (this.f72799c != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Exception in ExecuteWatchdog.run: ");
            stringBuffer.append(this.f72799c.getMessage());
            throw new BuildException(stringBuffer.toString(), this.f72799c);
        }
    }

    public synchronized void b() {
        this.f72798b = false;
        this.f72797a = null;
    }

    public boolean c() {
        return this.f72800d;
    }

    public synchronized void d(Process process) {
        try {
            if (process == null) {
                throw new NullPointerException("process is null.");
            }
            if (this.f72797a != null) {
                throw new IllegalStateException("Already running.");
            }
            this.f72799c = null;
            this.f72800d = false;
            this.f72798b = true;
            this.f72797a = process;
            this.f72801f.start();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void e() {
        this.f72801f.stop();
        b();
    }

    @Override // org.apache.tools.ant.util.r
    public synchronized void timeoutOccured(Watchdog watchdog) {
        try {
            try {
                try {
                    this.f72797a.exitValue();
                } catch (IllegalThreadStateException unused) {
                    if (this.f72798b) {
                        this.f72800d = true;
                        this.f72797a.destroy();
                    }
                }
            } catch (Exception e11) {
                this.f72799c = e11;
            }
            b();
        } catch (Throwable th2) {
            b();
            throw th2;
        }
    }
}
