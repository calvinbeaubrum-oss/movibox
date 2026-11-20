package com.elvishew.xlog.printer.file;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class FilePrinter implements nf.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qf.b f32383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final of.a f32384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pf.a f32385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public af.c f32386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public rf.b f32387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Worker f32388g = new Worker();

    /* JADX INFO: compiled from: source.java */
    public class Worker implements Runnable {
        private BlockingQueue<c> logs;
        private volatile boolean started;

        private Worker() {
            this.logs = new LinkedBlockingQueue();
        }

        public void enqueue(c cVar) {
            try {
                this.logs.put(cVar);
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
        }

        public boolean isStarted() {
            boolean z11;
            synchronized (this) {
                z11 = this.started;
            }
            return z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    c cVarTake = this.logs.take();
                    if (cVarTake == null) {
                        return;
                    } else {
                        FilePrinter.this.e(cVarTake.f32395a, cVarTake.f32396b, cVarTake.f32397c, cVarTake.f32398d);
                    }
                } catch (InterruptedException e11) {
                    e11.printStackTrace();
                    synchronized (this) {
                        this.started = false;
                        return;
                    }
                }
            }
        }

        public void start() {
            synchronized (this) {
                try {
                    if (this.started) {
                        return;
                    }
                    new Thread(this).start();
                    this.started = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f32389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public qf.b f32390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public of.a f32391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public pf.a f32392d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public af.c f32393e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public rf.b f32394f;

        public b(String str) {
            this.f32389a = str;
        }

        public b a(of.b bVar) {
            if (!(bVar instanceof of.a)) {
                bVar = new lf.a(bVar);
            }
            of.a aVar = (of.a) bVar;
            this.f32391c = aVar;
            lf.b.b(aVar);
            return this;
        }

        public FilePrinter b() {
            e();
            return new FilePrinter(this);
        }

        public b c(pf.a aVar) {
            this.f32392d = aVar;
            return this;
        }

        public b d(qf.b bVar) {
            this.f32390b = bVar;
            return this;
        }

        public final void e() {
            if (this.f32390b == null) {
                this.f32390b = kf.a.e();
            }
            if (this.f32391c == null) {
                this.f32391c = kf.a.b();
            }
            if (this.f32392d == null) {
                this.f32392d = kf.a.d();
            }
            if (this.f32393e == null) {
                this.f32393e = kf.a.g();
            }
            if (this.f32394f == null) {
                this.f32394f = kf.a.m();
            }
        }

        public b f(af.c cVar) {
            this.f32393e = cVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f32395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f32396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f32397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f32398d;

        public c(long j11, int i11, String str, String str2) {
            this.f32395a = j11;
            this.f32396b = i11;
            this.f32397c = str;
            this.f32398d = str2;
        }
    }

    public FilePrinter(b bVar) {
        this.f32382a = bVar.f32389a;
        this.f32383b = bVar.f32390b;
        this.f32384c = bVar.f32391c;
        this.f32385d = bVar.f32392d;
        this.f32386e = bVar.f32393e;
        this.f32387f = bVar.f32394f;
        c();
    }

    @Override // nf.c
    public void a(int i11, String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.f32388g.isStarted()) {
            this.f32388g.start();
        }
        this.f32388g.enqueue(new c(jCurrentTimeMillis, i11, str, str2));
    }

    public final void c() {
        File file = new File(this.f32382a);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public final void d() {
        File[] fileArrListFiles = new File(this.f32382a).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f32385d.a(file)) {
                file.delete();
            }
        }
    }

    public final void e(long j11, int i11, String str, String str2) {
        String strD = this.f32387f.d();
        boolean z11 = !this.f32387f.e();
        if (strD == null || z11 || this.f32383b.b()) {
            String strA = this.f32383b.a(i11, System.currentTimeMillis());
            if (strA == null || strA.trim().length() == 0) {
                kf.b.e().c("File name should not be empty, ignore log: " + str2);
                return;
            }
            if (!strA.equals(strD) || z11) {
                this.f32387f.b();
                d();
                if (!this.f32387f.f(new File(this.f32382a, strA))) {
                    return;
                } else {
                    strD = strA;
                }
            }
        }
        File fileC = this.f32387f.c();
        if (this.f32384c.b(fileC)) {
            this.f32387f.b();
            lf.b.a(fileC, this.f32384c);
            if (!this.f32387f.f(new File(this.f32382a, strD))) {
                return;
            }
        }
        this.f32387f.a(this.f32386e.a(j11, i11, str, str2).toString());
    }
}
