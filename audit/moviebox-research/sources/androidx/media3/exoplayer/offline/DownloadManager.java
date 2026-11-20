package androidx.media3.exoplayer.offline;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.scheduler.Requirements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class DownloadManager {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Requirements f10798q = new Requirements(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f10800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f10801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f10802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o4.e.c f10803e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10806h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10807i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10811m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10812n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public o4.e f10814p;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10809k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10810l = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10808j = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<androidx.media3.exoplayer.offline.c> f10813o = Collections.emptyList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArraySet<d> f10804f = new CopyOnWriteArraySet<>();

    /* JADX INFO: compiled from: source.java */
    public static class Task extends Thread implements o.a {
        private long contentLength;
        private final l downloadProgress;
        private final o downloader;

        @Nullable
        private Exception finalException;

        @Nullable
        private volatile c internalHandler;
        private volatile boolean isCanceled;
        private final boolean isRemove;
        private final int minRetryCount;
        private final DownloadRequest request;

        private Task(DownloadRequest downloadRequest, o oVar, l lVar, boolean z11, int i11, c cVar) {
            this.request = downloadRequest;
            this.downloader = oVar;
            this.downloadProgress = lVar;
            this.isRemove = z11;
            this.minRetryCount = i11;
            this.internalHandler = cVar;
            this.contentLength = -1L;
        }

        private static int getRetryDelayMillis(int i11) {
            return Math.min((i11 - 1) * 1000, 5000);
        }

        public void cancel(boolean z11) {
            if (z11) {
                this.internalHandler = null;
            }
            if (this.isCanceled) {
                return;
            }
            this.isCanceled = true;
            this.downloader.cancel();
            interrupt();
        }

        @Override // androidx.media3.exoplayer.offline.o.a
        public void onProgress(long j11, long j12, float f11) {
            this.downloadProgress.f10912a = j12;
            this.downloadProgress.f10913b = f11;
            if (j11 != this.contentLength) {
                this.contentLength = j11;
                c cVar = this.internalHandler;
                if (cVar != null) {
                    cVar.obtainMessage(10, (int) (j11 >> 32), (int) j11, this).sendToTarget();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (this.isRemove) {
                    this.downloader.remove();
                } else {
                    long j11 = -1;
                    int i11 = 0;
                    while (!this.isCanceled) {
                        try {
                            this.downloader.a(this);
                            break;
                        } catch (IOException e11) {
                            if (!this.isCanceled) {
                                long j12 = this.downloadProgress.f10912a;
                                if (j12 != j11) {
                                    j11 = j12;
                                    i11 = 0;
                                }
                                i11++;
                                if (i11 > this.minRetryCount) {
                                    throw e11;
                                }
                                Thread.sleep(getRetryDelayMillis(i11));
                            }
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e12) {
                this.finalException = e12;
            }
            c cVar = this.internalHandler;
            if (cVar != null) {
                cVar.obtainMessage(9, this).sendToTarget();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.exoplayer.offline.c f10815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f10816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<androidx.media3.exoplayer.offline.c> f10817c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final Exception f10818d;

        public b(androidx.media3.exoplayer.offline.c cVar, boolean z11, List<androidx.media3.exoplayer.offline.c> list, @Nullable Exception exc) {
            this.f10815a = cVar;
            this.f10816b = z11;
            this.f10817c = list;
            this.f10818d = exc;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f10819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerThread f10820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final t f10821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final p f10822d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Handler f10823e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArrayList<androidx.media3.exoplayer.offline.c> f10824f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final HashMap<String, Task> f10825g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f10826h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f10827i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f10828j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f10829k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f10830l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f10831m;

        public c(HandlerThread handlerThread, t tVar, p pVar, Handler handler, int i11, int i12, boolean z11) {
            super(handlerThread.getLooper());
            this.f10820b = handlerThread;
            this.f10821c = tVar;
            this.f10822d = pVar;
            this.f10823e = handler;
            this.f10828j = i11;
            this.f10829k = i12;
            this.f10827i = z11;
            this.f10824f = new ArrayList<>();
            this.f10825g = new HashMap<>();
        }

        public static int d(androidx.media3.exoplayer.offline.c cVar, androidx.media3.exoplayer.offline.c cVar2) {
            return u0.n(cVar.f10903c, cVar2.f10903c);
        }

        public static androidx.media3.exoplayer.offline.c e(androidx.media3.exoplayer.offline.c cVar, int i11, int i12) {
            return new androidx.media3.exoplayer.offline.c(cVar.f10901a, i11, cVar.f10903c, System.currentTimeMillis(), cVar.f10905e, i12, 0, cVar.f10908h);
        }

        public final void A(@Nullable Task task) {
            if (task != null) {
                z3.a.g(!task.isRemove);
                task.cancel(false);
            }
        }

        public final void B() {
            int i11 = 0;
            for (int i12 = 0; i12 < this.f10824f.size(); i12++) {
                androidx.media3.exoplayer.offline.c cVar = this.f10824f.get(i12);
                Task taskY = this.f10825g.get(cVar.f10901a.f10832id);
                int i13 = cVar.f10902b;
                if (i13 == 0) {
                    taskY = y(taskY, cVar);
                } else if (i13 == 1) {
                    A(taskY);
                } else if (i13 == 2) {
                    z3.a.e(taskY);
                    x(taskY, cVar, i11);
                } else {
                    if (i13 != 5 && i13 != 7) {
                        throw new IllegalStateException();
                    }
                    z(taskY, cVar);
                }
                if (taskY != null && !taskY.isRemove) {
                    i11++;
                }
            }
        }

        public final void C() {
            for (int i11 = 0; i11 < this.f10824f.size(); i11++) {
                androidx.media3.exoplayer.offline.c cVar = this.f10824f.get(i11);
                if (cVar.f10902b == 2) {
                    try {
                        this.f10821c.b(cVar);
                    } catch (IOException e11) {
                        z3.o.d("DownloadManager", "Failed to update index.", e11);
                    }
                }
            }
            sendEmptyMessageDelayed(11, 5000L);
        }

        public final void b(DownloadRequest downloadRequest, int i11) {
            androidx.media3.exoplayer.offline.c cVarF = f(downloadRequest.f10832id, true);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (cVarF != null) {
                m(DownloadManager.n(cVarF, downloadRequest, i11, jCurrentTimeMillis));
            } else {
                m(new androidx.media3.exoplayer.offline.c(downloadRequest, i11 != 0 ? 1 : 0, jCurrentTimeMillis, jCurrentTimeMillis, -1L, i11, 0));
            }
            B();
        }

        public final boolean c() {
            return !this.f10827i && this.f10826h == 0;
        }

        @Nullable
        public final androidx.media3.exoplayer.offline.c f(String str, boolean z11) {
            int iG = g(str);
            if (iG != -1) {
                return this.f10824f.get(iG);
            }
            if (!z11) {
                return null;
            }
            try {
                return this.f10821c.h(str);
            } catch (IOException e11) {
                z3.o.d("DownloadManager", "Failed to load download: " + str, e11);
                return null;
            }
        }

        public final int g(String str) {
            for (int i11 = 0; i11 < this.f10824f.size(); i11++) {
                if (this.f10824f.get(i11).f10901a.f10832id.equals(str)) {
                    return i11;
                }
            }
            return -1;
        }

        public final void h(int i11) {
            this.f10826h = i11;
            e eVarE = null;
            try {
                try {
                    this.f10821c.g();
                    eVarE = this.f10821c.e(0, 1, 2, 5, 7);
                    while (eVarE.moveToNext()) {
                        this.f10824f.add(eVarE.N());
                    }
                } catch (IOException e11) {
                    z3.o.d("DownloadManager", "Failed to load index.", e11);
                    this.f10824f.clear();
                }
                u0.m(eVarE);
                this.f10823e.obtainMessage(0, new ArrayList(this.f10824f)).sendToTarget();
                B();
            } catch (Throwable th2) {
                u0.m(eVarE);
                throw th2;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i11 = 0;
            switch (message.what) {
                case 0:
                    h(message.arg1);
                    i11 = 1;
                    this.f10823e.obtainMessage(1, i11, this.f10825g.size()).sendToTarget();
                    return;
                case 1:
                    r(message.arg1 != 0);
                    i11 = 1;
                    this.f10823e.obtainMessage(1, i11, this.f10825g.size()).sendToTarget();
                    return;
                case 2:
                    u(message.arg1);
                    i11 = 1;
                    this.f10823e.obtainMessage(1, i11, this.f10825g.size()).sendToTarget();
                    return;
                case 3:
                    w((String) message.obj, message.arg1);
                    i11 = 1;
                    this.f10823e.obtainMessage(1, i11, this.f10825g.size()).sendToTarget();
                    return;
                case 4:
                    s(message.arg1);
                    i11 = 1;
                    this.f10823e.obtainMessage(1, i11, this.f10825g.size()).sendToTarget();
                    return;
                case 5:
                    t(message.arg1);
                    i11 = 1;
                    this.f10823e.obtainMessage(1, i11, this.f10825g.size()).sendToTarget();
                    return;
                case 6:
                    b((DownloadRequest) message.obj, message.arg1);
                    i11 = 1;
                    this.f10823e.obtainMessage(1, i11, this.f10825g.size()).sendToTarget();
                    return;
                case 7:
                    q((String) message.obj);
                    i11 = 1;
                    this.f10823e.obtainMessage(1, i11, this.f10825g.size()).sendToTarget();
                    return;
                case 8:
                    p();
                    i11 = 1;
                    this.f10823e.obtainMessage(1, i11, this.f10825g.size()).sendToTarget();
                    return;
                case 9:
                    l((Task) message.obj);
                    this.f10823e.obtainMessage(1, i11, this.f10825g.size()).sendToTarget();
                    return;
                case 10:
                    i((Task) message.obj, u0.y1(message.arg1, message.arg2));
                    return;
                case 11:
                    C();
                    return;
                case 12:
                    o();
                    return;
                default:
                    throw new IllegalStateException();
            }
        }

        public final void i(Task task, long j11) {
            androidx.media3.exoplayer.offline.c cVar = (androidx.media3.exoplayer.offline.c) z3.a.e(f(task.request.f10832id, false));
            if (j11 == cVar.f10905e || j11 == -1) {
                return;
            }
            m(new androidx.media3.exoplayer.offline.c(cVar.f10901a, cVar.f10902b, cVar.f10903c, System.currentTimeMillis(), j11, cVar.f10906f, cVar.f10907g, cVar.f10908h));
        }

        public final void j(androidx.media3.exoplayer.offline.c cVar, @Nullable Exception exc) {
            androidx.media3.exoplayer.offline.c cVar2 = new androidx.media3.exoplayer.offline.c(cVar.f10901a, exc == null ? 3 : 4, cVar.f10903c, System.currentTimeMillis(), cVar.f10905e, cVar.f10906f, exc == null ? 0 : 1, cVar.f10908h);
            this.f10824f.remove(g(cVar2.f10901a.f10832id));
            try {
                this.f10821c.b(cVar2);
            } catch (IOException e11) {
                z3.o.d("DownloadManager", "Failed to update index.", e11);
            }
            this.f10823e.obtainMessage(2, new b(cVar2, false, new ArrayList(this.f10824f), exc)).sendToTarget();
        }

        public final void k(androidx.media3.exoplayer.offline.c cVar) {
            if (cVar.f10902b == 7) {
                int i11 = cVar.f10906f;
                n(cVar, i11 == 0 ? 0 : 1, i11);
                B();
            } else {
                this.f10824f.remove(g(cVar.f10901a.f10832id));
                try {
                    this.f10821c.c(cVar.f10901a.f10832id);
                } catch (IOException unused) {
                    z3.o.c("DownloadManager", "Failed to remove from database");
                }
                this.f10823e.obtainMessage(2, new b(cVar, true, new ArrayList(this.f10824f), null)).sendToTarget();
            }
        }

        public final void l(Task task) {
            String str = task.request.f10832id;
            this.f10825g.remove(str);
            boolean z11 = task.isRemove;
            if (z11) {
                this.f10831m = false;
            } else {
                int i11 = this.f10830l - 1;
                this.f10830l = i11;
                if (i11 == 0) {
                    removeMessages(11);
                }
            }
            if (task.isCanceled) {
                B();
                return;
            }
            Exception exc = task.finalException;
            if (exc != null) {
                z3.o.d("DownloadManager", "Task failed: " + task.request + ", " + z11, exc);
            }
            androidx.media3.exoplayer.offline.c cVar = (androidx.media3.exoplayer.offline.c) z3.a.e(f(str, false));
            int i12 = cVar.f10902b;
            if (i12 == 2) {
                z3.a.g(!z11);
                j(cVar, exc);
            } else {
                if (i12 != 5 && i12 != 7) {
                    throw new IllegalStateException();
                }
                z3.a.g(z11);
                k(cVar);
            }
            B();
        }

        public final androidx.media3.exoplayer.offline.c m(androidx.media3.exoplayer.offline.c cVar) {
            int i11 = cVar.f10902b;
            z3.a.g((i11 == 3 || i11 == 4) ? false : true);
            int iG = g(cVar.f10901a.f10832id);
            if (iG == -1) {
                this.f10824f.add(cVar);
                Collections.sort(this.f10824f, new i());
            } else {
                boolean z11 = cVar.f10903c != this.f10824f.get(iG).f10903c;
                this.f10824f.set(iG, cVar);
                if (z11) {
                    Collections.sort(this.f10824f, new i());
                }
            }
            try {
                this.f10821c.b(cVar);
            } catch (IOException e11) {
                z3.o.d("DownloadManager", "Failed to update index.", e11);
            }
            this.f10823e.obtainMessage(2, new b(cVar, false, new ArrayList(this.f10824f), null)).sendToTarget();
            return cVar;
        }

        public final androidx.media3.exoplayer.offline.c n(androidx.media3.exoplayer.offline.c cVar, int i11, int i12) {
            z3.a.g((i11 == 3 || i11 == 4) ? false : true);
            return m(e(cVar, i11, i12));
        }

        public final void o() {
            Iterator<Task> it = this.f10825g.values().iterator();
            while (it.hasNext()) {
                it.next().cancel(true);
            }
            try {
                this.f10821c.g();
            } catch (IOException e11) {
                z3.o.d("DownloadManager", "Failed to update index.", e11);
            }
            this.f10824f.clear();
            this.f10820b.quit();
            synchronized (this) {
                this.f10819a = true;
                notifyAll();
            }
        }

        public final void p() {
            ArrayList arrayList = new ArrayList();
            try {
                e eVarE = this.f10821c.e(3, 4);
                while (eVarE.moveToNext()) {
                    try {
                        arrayList.add(eVarE.N());
                    } catch (Throwable th2) {
                        if (eVarE != null) {
                            try {
                                eVarE.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
                eVarE.close();
            } catch (IOException unused) {
                z3.o.c("DownloadManager", "Failed to load downloads.");
            }
            for (int i11 = 0; i11 < this.f10824f.size(); i11++) {
                ArrayList<androidx.media3.exoplayer.offline.c> arrayList2 = this.f10824f;
                arrayList2.set(i11, e(arrayList2.get(i11), 5, 0));
            }
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                this.f10824f.add(e((androidx.media3.exoplayer.offline.c) arrayList.get(i12), 5, 0));
            }
            Collections.sort(this.f10824f, new i());
            try {
                this.f10821c.f();
            } catch (IOException e11) {
                z3.o.d("DownloadManager", "Failed to update index.", e11);
            }
            ArrayList arrayList3 = new ArrayList(this.f10824f);
            for (int i13 = 0; i13 < this.f10824f.size(); i13++) {
                this.f10823e.obtainMessage(2, new b(this.f10824f.get(i13), false, arrayList3, null)).sendToTarget();
            }
            B();
        }

        public final void q(String str) {
            androidx.media3.exoplayer.offline.c cVarF = f(str, true);
            if (cVarF != null) {
                n(cVarF, 5, 0);
                B();
            } else {
                z3.o.c("DownloadManager", "Failed to remove nonexistent download: " + str);
            }
        }

        public final void r(boolean z11) {
            this.f10827i = z11;
            B();
        }

        public final void s(int i11) {
            this.f10828j = i11;
            B();
        }

        public final void t(int i11) {
            this.f10829k = i11;
        }

        public final void u(int i11) {
            this.f10826h = i11;
            B();
        }

        public final void v(androidx.media3.exoplayer.offline.c cVar, int i11) {
            if (i11 == 0) {
                if (cVar.f10902b == 1) {
                    n(cVar, 0, 0);
                }
            } else if (i11 != cVar.f10906f) {
                int i12 = cVar.f10902b;
                if (i12 == 0 || i12 == 2) {
                    i12 = 1;
                }
                m(new androidx.media3.exoplayer.offline.c(cVar.f10901a, i12, cVar.f10903c, System.currentTimeMillis(), cVar.f10905e, i11, 0, cVar.f10908h));
            }
        }

        public final void w(@Nullable String str, int i11) {
            if (str == null) {
                for (int i12 = 0; i12 < this.f10824f.size(); i12++) {
                    v(this.f10824f.get(i12), i11);
                }
                try {
                    this.f10821c.d(i11);
                } catch (IOException e11) {
                    z3.o.d("DownloadManager", "Failed to set manual stop reason", e11);
                }
            } else {
                androidx.media3.exoplayer.offline.c cVarF = f(str, false);
                if (cVarF != null) {
                    v(cVarF, i11);
                } else {
                    try {
                        this.f10821c.a(str, i11);
                    } catch (IOException e12) {
                        z3.o.d("DownloadManager", "Failed to set manual stop reason: " + str, e12);
                    }
                }
            }
            B();
        }

        public final void x(Task task, androidx.media3.exoplayer.offline.c cVar, int i11) {
            z3.a.g(!task.isRemove);
            if (!c() || i11 >= this.f10828j) {
                n(cVar, 0, 0);
                task.cancel(false);
            }
        }

        @Nullable
        @CheckResult
        public final Task y(@Nullable Task task, androidx.media3.exoplayer.offline.c cVar) {
            if (task != null) {
                z3.a.g(!task.isRemove);
                task.cancel(false);
                return task;
            }
            if (!c() || this.f10830l >= this.f10828j) {
                return null;
            }
            androidx.media3.exoplayer.offline.c cVarN = n(cVar, 2, 0);
            Task task2 = new Task(cVarN.f10901a, this.f10822d.a(cVarN.f10901a), cVarN.f10908h, false, this.f10829k, this);
            this.f10825g.put(cVarN.f10901a.f10832id, task2);
            int i11 = this.f10830l;
            this.f10830l = i11 + 1;
            if (i11 == 0) {
                sendEmptyMessageDelayed(11, 5000L);
            }
            task2.start();
            return task2;
        }

        public final void z(@Nullable Task task, androidx.media3.exoplayer.offline.c cVar) {
            if (task != null) {
                if (task.isRemove) {
                    return;
                }
                task.cancel(false);
            } else {
                if (this.f10831m) {
                    return;
                }
                Task task2 = new Task(cVar.f10901a, this.f10822d.a(cVar.f10901a), cVar.f10908h, true, this.f10829k, this);
                this.f10825g.put(cVar.f10901a.f10832id, task2);
                this.f10831m = true;
                task2.start();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(DownloadManager downloadManager, boolean z11);

        void b(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c cVar);

        void c(DownloadManager downloadManager, boolean z11);

        void d(DownloadManager downloadManager);

        void e(DownloadManager downloadManager, Requirements requirements, int i11);

        void f(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c cVar, @Nullable Exception exc);

        void g(DownloadManager downloadManager);
    }

    public DownloadManager(Context context, t tVar, p pVar) {
        this.f10799a = context.getApplicationContext();
        this.f10800b = tVar;
        Handler handlerD = u0.D(new Handler.Callback() { // from class: androidx.media3.exoplayer.offline.g
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f10909a.j(message);
            }
        });
        this.f10801c = handlerD;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        c cVar = new c(handlerThread, tVar, pVar, handlerD, this.f10809k, this.f10810l, this.f10808j);
        this.f10802d = cVar;
        o4.e.c cVar2 = new o4.e.c() { // from class: androidx.media3.exoplayer.offline.h
            @Override // o4.e.c
            public final void a(o4.e eVar, int i11) {
                this.f10910a.s(eVar, i11);
            }
        };
        this.f10803e = cVar2;
        o4.e eVar = new o4.e(context, cVar2, f10798q);
        this.f10814p = eVar;
        int i11 = eVar.i();
        this.f10811m = i11;
        this.f10805g = 1;
        cVar.obtainMessage(0, i11, 0).sendToTarget();
    }

    public static androidx.media3.exoplayer.offline.c n(androidx.media3.exoplayer.offline.c cVar, DownloadRequest downloadRequest, int i11, long j11) {
        int i12;
        int i13 = cVar.f10902b;
        long j12 = (i13 == 5 || cVar.c()) ? j11 : cVar.f10903c;
        if (i13 == 5 || i13 == 7) {
            i12 = 7;
        } else {
            i12 = i11 != 0 ? 1 : 0;
        }
        return new androidx.media3.exoplayer.offline.c(cVar.f10901a.copyWithMergedRequest(downloadRequest), i12, j12, j11, -1L, i11, 0);
    }

    public void A(@Nullable String str, int i11) {
        this.f10805g++;
        this.f10802d.obtainMessage(3, i11, 0, str).sendToTarget();
    }

    public final boolean B() {
        boolean z11;
        if (!this.f10808j && this.f10811m != 0) {
            int i11 = 0;
            while (true) {
                if (i11 >= this.f10813o.size()) {
                    z11 = false;
                    break;
                }
                if (this.f10813o.get(i11).f10902b == 0) {
                    z11 = true;
                    break;
                }
                i11++;
            }
        } else {
            z11 = false;
            break;
        }
        boolean z12 = this.f10812n != z11;
        this.f10812n = z11;
        return z12;
    }

    public void c(DownloadRequest downloadRequest, int i11) {
        this.f10805g++;
        this.f10802d.obtainMessage(6, i11, 0, downloadRequest).sendToTarget();
    }

    public void d(d dVar) {
        z3.a.e(dVar);
        this.f10804f.add(dVar);
    }

    public List<androidx.media3.exoplayer.offline.c> e() {
        return this.f10813o;
    }

    public f f() {
        return this.f10800b;
    }

    public boolean g() {
        return this.f10808j;
    }

    public int h() {
        return this.f10811m;
    }

    public Requirements i() {
        return this.f10814p.f();
    }

    public final boolean j(Message message) {
        int i11 = message.what;
        if (i11 == 0) {
            q((List) message.obj);
        } else if (i11 == 1) {
            r(message.arg1, message.arg2);
        } else {
            if (i11 != 2) {
                throw new IllegalStateException();
            }
            p((b) message.obj);
        }
        return true;
    }

    public boolean k() {
        return this.f10806h == 0 && this.f10805g == 0;
    }

    public boolean l() {
        return this.f10807i;
    }

    public boolean m() {
        return this.f10812n;
    }

    public final void o() {
        Iterator<d> it = this.f10804f.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f10812n);
        }
    }

    public final void p(b bVar) {
        this.f10813o = Collections.unmodifiableList(bVar.f10817c);
        androidx.media3.exoplayer.offline.c cVar = bVar.f10815a;
        boolean zB = B();
        if (bVar.f10816b) {
            Iterator<d> it = this.f10804f.iterator();
            while (it.hasNext()) {
                it.next().b(this, cVar);
            }
        } else {
            Iterator<d> it2 = this.f10804f.iterator();
            while (it2.hasNext()) {
                it2.next().f(this, cVar, bVar.f10818d);
            }
        }
        if (zB) {
            o();
        }
    }

    public final void q(List<androidx.media3.exoplayer.offline.c> list) {
        this.f10807i = true;
        this.f10813o = Collections.unmodifiableList(list);
        boolean zB = B();
        Iterator<d> it = this.f10804f.iterator();
        while (it.hasNext()) {
            it.next().g(this);
        }
        if (zB) {
            o();
        }
    }

    public final void r(int i11, int i12) {
        this.f10805g -= i11;
        this.f10806h = i12;
        if (k()) {
            Iterator<d> it = this.f10804f.iterator();
            while (it.hasNext()) {
                it.next().d(this);
            }
        }
    }

    public final void s(o4.e eVar, int i11) {
        Requirements requirementsF = eVar.f();
        if (this.f10811m != i11) {
            this.f10811m = i11;
            this.f10805g++;
            this.f10802d.obtainMessage(2, i11, 0).sendToTarget();
        }
        boolean zB = B();
        Iterator<d> it = this.f10804f.iterator();
        while (it.hasNext()) {
            it.next().e(this, requirementsF, i11);
        }
        if (zB) {
            o();
        }
    }

    public void t() {
        y(true);
    }

    public void u() {
        this.f10805g++;
        this.f10802d.obtainMessage(8).sendToTarget();
    }

    public void v(String str) {
        this.f10805g++;
        this.f10802d.obtainMessage(7, str).sendToTarget();
    }

    public void w(d dVar) {
        this.f10804f.remove(dVar);
    }

    public void x() {
        y(false);
    }

    public final void y(boolean z11) {
        if (this.f10808j == z11) {
            return;
        }
        this.f10808j = z11;
        this.f10805g++;
        this.f10802d.obtainMessage(1, z11 ? 1 : 0, 0).sendToTarget();
        boolean zB = B();
        Iterator<d> it = this.f10804f.iterator();
        while (it.hasNext()) {
            it.next().c(this, z11);
        }
        if (zB) {
            o();
        }
    }

    public void z(Requirements requirements) {
        if (requirements.equals(this.f10814p.f())) {
            return;
        }
        this.f10814p.j();
        o4.e eVar = new o4.e(this.f10799a, this.f10803e, requirements);
        this.f10814p = eVar;
        s(this.f10814p, eVar.i());
    }
}
