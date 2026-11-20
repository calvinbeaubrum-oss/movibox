package androidx.media3.exoplayer.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.StreamKey;
import androidx.media3.common.b0;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.exoplayer.offline.q;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SegmentDownloader<M extends q<M>> implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c4.g f10872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.o.a<M> f10873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<StreamKey> f10874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.media3.datasource.cache.a.c f10875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Cache f10876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.media3.datasource.cache.g f10877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final PriorityTaskManager f10878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f10879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f10880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<RunnableFutureTask<?, ?>> f10881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f10882k;

    /* JADX INFO: compiled from: source.java */
    public static final class SegmentDownloadRunnable extends RunnableFutureTask<Void, IOException> {
        private final androidx.media3.datasource.cache.i cacheWriter;
        public final androidx.media3.datasource.cache.a dataSource;

        @Nullable
        private final a progressNotifier;
        public final b segment;
        public final byte[] temporaryBuffer;

        public SegmentDownloadRunnable(b bVar, androidx.media3.datasource.cache.a aVar, @Nullable a aVar2, byte[] bArr) {
            this.segment = bVar;
            this.dataSource = aVar;
            this.progressNotifier = aVar2;
            this.temporaryBuffer = bArr;
            this.cacheWriter = new androidx.media3.datasource.cache.i(aVar, bVar.f10889b, bArr, aVar2);
        }

        @Override // androidx.media3.common.util.RunnableFutureTask
        public void cancelWork() {
            this.cacheWriter.b();
        }

        @Override // androidx.media3.common.util.RunnableFutureTask
        public Void doWork() throws IOException {
            this.cacheWriter.a();
            a aVar = this.progressNotifier;
            if (aVar == null) {
                return null;
            }
            aVar.c();
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements androidx.media3.datasource.cache.i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o.a f10883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f10884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f10886d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10887e;

        public a(o.a aVar, long j11, int i11, long j12, int i12) {
            this.f10883a = aVar;
            this.f10884b = j11;
            this.f10885c = i11;
            this.f10886d = j12;
            this.f10887e = i12;
        }

        @Override // androidx.media3.datasource.cache.i.a
        public void a(long j11, long j12, long j13) {
            long j14 = this.f10886d + j13;
            this.f10886d = j14;
            this.f10883a.onProgress(this.f10884b, j14, b());
        }

        public final float b() {
            long j11 = this.f10884b;
            if (j11 != -1 && j11 != 0) {
                return (this.f10886d * 100.0f) / j11;
            }
            int i11 = this.f10885c;
            if (i11 != 0) {
                return (this.f10887e * 100.0f) / i11;
            }
            return -1.0f;
        }

        public void c() {
            this.f10887e++;
            this.f10883a.onProgress(this.f10884b, this.f10886d, b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f10888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c4.g f10889b;

        public b(long j11, c4.g gVar) {
            this.f10888a = j11;
            this.f10889b = gVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return u0.n(this.f10888a, bVar.f10888a);
        }
    }

    public SegmentDownloader(b0 b0Var, androidx.media3.exoplayer.upstream.o.a<M> aVar, androidx.media3.datasource.cache.a.c cVar, Executor executor, long j11) {
        z3.a.e(b0Var.f8951b);
        this.f10872a = f(b0Var.f8951b.f9047a);
        this.f10873b = aVar;
        this.f10874c = new ArrayList<>(b0Var.f8951b.f9050d);
        this.f10875d = cVar;
        this.f10879h = executor;
        this.f10876e = (Cache) z3.a.e(cVar.e());
        this.f10877f = cVar.f();
        this.f10878g = cVar.g();
        this.f10881j = new ArrayList<>();
        this.f10880i = u0.S0(j11);
    }

    public static boolean d(c4.g gVar, c4.g gVar2) {
        if (gVar.f14598a.equals(gVar2.f14598a)) {
            long j11 = gVar.f14605h;
            if (j11 != -1 && gVar.f14604g + j11 == gVar2.f14604g && u0.c(gVar.f14606i, gVar2.f14606i) && gVar.f14607j == gVar2.f14607j && gVar.f14600c == gVar2.f14600c && gVar.f14602e.equals(gVar2.f14602e)) {
                return true;
            }
        }
        return false;
    }

    public static c4.g f(Uri uri) {
        return new c4.g.b().i(uri).b(1).a();
    }

    public static void i(List<b> list, androidx.media3.datasource.cache.g gVar, long j11) {
        HashMap map = new HashMap();
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            b bVar = list.get(i12);
            String strA = gVar.a(bVar.f10889b);
            Integer num = (Integer) map.get(strA);
            b bVar2 = num == null ? null : list.get(num.intValue());
            if (bVar2 == null || bVar.f10888a > bVar2.f10888a + j11 || !d(bVar2.f10889b, bVar.f10889b)) {
                map.put(strA, Integer.valueOf(i11));
                list.set(i11, bVar);
                i11++;
            } else {
                long j12 = bVar.f10889b.f14605h;
                list.set(((Integer) z3.a.e(num)).intValue(), new b(bVar2.f10888a, bVar2.f10889b.f(0L, j12 != -1 ? bVar2.f10889b.f14605h + j12 : -1L)));
            }
        }
        u0.d1(list, i11, list.size());
    }

    @Override // androidx.media3.exoplayer.offline.o
    public final void a(@Nullable o.a aVar) throws InterruptedException, IOException {
        androidx.media3.datasource.cache.a aVarB;
        byte[] bArr;
        int i11;
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        PriorityTaskManager priorityTaskManager = this.f10878g;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-1000);
        }
        try {
            androidx.media3.datasource.cache.a aVarB2 = this.f10875d.b();
            q qVarG = g(aVarB2, this.f10872a, false);
            if (!this.f10874c.isEmpty()) {
                qVarG = (q) qVarG.copy(this.f10874c);
            }
            List<b> listH = h(aVarB2, qVarG, false);
            Collections.sort(listH);
            i(listH, this.f10877f, this.f10880i);
            int size = listH.size();
            long j11 = 0;
            long j12 = 0;
            int i12 = 0;
            for (int size2 = listH.size() - 1; size2 >= 0; size2 = i11 - 1) {
                c4.g gVar = listH.get(size2).f10889b;
                String strA = this.f10877f.a(gVar);
                long j13 = gVar.f14605h;
                if (j13 == -1) {
                    long jA = androidx.media3.datasource.cache.l.a(this.f10876e.getContentMetadata(strA));
                    if (jA != -1) {
                        j13 = jA - gVar.f14604g;
                    }
                }
                int i13 = size2;
                long jA2 = this.f10876e.a(strA, gVar.f14604g, j13);
                j12 += jA2;
                if (j13 != -1) {
                    if (j13 == jA2) {
                        i12++;
                        i11 = i13;
                        listH.remove(i11);
                    } else {
                        i11 = i13;
                    }
                    if (j11 != -1) {
                        j11 += j13;
                    }
                } else {
                    i11 = i13;
                    j11 = -1;
                }
            }
            a aVar2 = aVar != null ? new a(aVar, j11, size, j12, i12) : null;
            arrayDeque.addAll(listH);
            while (!this.f10882k && !arrayDeque.isEmpty()) {
                PriorityTaskManager priorityTaskManager2 = this.f10878g;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.b(-1000);
                }
                if (arrayDeque2.isEmpty()) {
                    aVarB = this.f10875d.b();
                    bArr = new byte[131072];
                } else {
                    SegmentDownloadRunnable segmentDownloadRunnable = (SegmentDownloadRunnable) arrayDeque2.removeFirst();
                    aVarB = segmentDownloadRunnable.dataSource;
                    bArr = segmentDownloadRunnable.temporaryBuffer;
                }
                SegmentDownloadRunnable segmentDownloadRunnable2 = new SegmentDownloadRunnable((b) arrayDeque.removeFirst(), aVarB, aVar2, bArr);
                c(segmentDownloadRunnable2);
                this.f10879h.execute(segmentDownloadRunnable2);
                for (int size3 = this.f10881j.size() - 1; size3 >= 0; size3--) {
                    SegmentDownloadRunnable segmentDownloadRunnable3 = (SegmentDownloadRunnable) this.f10881j.get(size3);
                    if (arrayDeque.isEmpty() || segmentDownloadRunnable3.isDone()) {
                        try {
                            segmentDownloadRunnable3.get();
                            j(size3);
                            arrayDeque2.addLast(segmentDownloadRunnable3);
                        } catch (ExecutionException e11) {
                            Throwable th2 = (Throwable) z3.a.e(e11.getCause());
                            if (th2 instanceof PriorityTaskManager.PriorityTooLowException) {
                                arrayDeque.addFirst(segmentDownloadRunnable3.segment);
                                j(size3);
                                arrayDeque2.addLast(segmentDownloadRunnable3);
                            } else {
                                if (th2 instanceof IOException) {
                                    throw ((IOException) th2);
                                }
                                u0.m1(th2);
                            }
                        }
                    }
                }
                segmentDownloadRunnable2.blockUntilStarted();
            }
            for (int i14 = 0; i14 < this.f10881j.size(); i14++) {
                this.f10881j.get(i14).cancel(true);
            }
            for (int size4 = this.f10881j.size() - 1; size4 >= 0; size4--) {
                this.f10881j.get(size4).blockUntilFinished();
                j(size4);
            }
            PriorityTaskManager priorityTaskManager3 = this.f10878g;
            if (priorityTaskManager3 != null) {
                priorityTaskManager3.d(-1000);
            }
        } catch (Throwable th3) {
            for (int i15 = 0; i15 < this.f10881j.size(); i15++) {
                this.f10881j.get(i15).cancel(true);
            }
            for (int size5 = this.f10881j.size() - 1; size5 >= 0; size5--) {
                this.f10881j.get(size5).blockUntilFinished();
                j(size5);
            }
            PriorityTaskManager priorityTaskManager4 = this.f10878g;
            if (priorityTaskManager4 != null) {
                priorityTaskManager4.d(-1000);
            }
            throw th3;
        }
    }

    public final <T> void c(RunnableFutureTask<T, ?> runnableFutureTask) throws InterruptedException {
        synchronized (this.f10881j) {
            try {
                if (this.f10882k) {
                    throw new InterruptedException();
                }
                this.f10881j.add(runnableFutureTask);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.media3.exoplayer.offline.o
    public void cancel() {
        synchronized (this.f10881j) {
            try {
                this.f10882k = true;
                for (int i11 = 0; i11 < this.f10881j.size(); i11++) {
                    this.f10881j.get(i11).cancel(true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final <T> T e(RunnableFutureTask<T, ?> runnableFutureTask, boolean z11) throws Throwable {
        if (z11) {
            runnableFutureTask.run();
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e11) {
                Throwable th2 = (Throwable) z3.a.e(e11.getCause());
                if (th2 instanceof IOException) {
                    throw ((IOException) th2);
                }
                u0.m1(e11);
            }
        }
        while (!this.f10882k) {
            PriorityTaskManager priorityTaskManager = this.f10878g;
            if (priorityTaskManager != null) {
                priorityTaskManager.b(-1000);
            }
            c(runnableFutureTask);
            this.f10879h.execute(runnableFutureTask);
            try {
                T t11 = runnableFutureTask.get();
                runnableFutureTask.blockUntilFinished();
                k(runnableFutureTask);
                return t11;
            } catch (ExecutionException e12) {
                try {
                    Throwable th3 = (Throwable) z3.a.e(e12.getCause());
                    if (!(th3 instanceof PriorityTaskManager.PriorityTooLowException)) {
                        if (th3 instanceof IOException) {
                            throw ((IOException) th3);
                        }
                        u0.m1(e12);
                    }
                    runnableFutureTask.blockUntilFinished();
                    k(runnableFutureTask);
                } catch (Throwable th4) {
                    runnableFutureTask.blockUntilFinished();
                    k(runnableFutureTask);
                    throw th4;
                }
            }
        }
        throw new InterruptedException();
    }

    public final M g(final androidx.media3.datasource.a aVar, final c4.g gVar, boolean z11) throws InterruptedException, IOException {
        return (M) e(new RunnableFutureTask<M, IOException>() { // from class: androidx.media3.exoplayer.offline.SegmentDownloader.1
            @Override // androidx.media3.common.util.RunnableFutureTask
            public M doWork() throws IOException {
                return (M) androidx.media3.exoplayer.upstream.o.e(aVar, SegmentDownloader.this.f10873b, gVar, 4);
            }
        }, z11);
    }

    public abstract List<b> h(androidx.media3.datasource.a aVar, M m11, boolean z11) throws InterruptedException, IOException;

    public final void j(int i11) {
        synchronized (this.f10881j) {
            this.f10881j.remove(i11);
        }
    }

    public final void k(RunnableFutureTask<?, ?> runnableFutureTask) {
        synchronized (this.f10881j) {
            this.f10881j.remove(runnableFutureTask);
        }
    }

    @Override // androidx.media3.exoplayer.offline.o
    public final void remove() {
        androidx.media3.datasource.cache.a aVarC = this.f10875d.c();
        try {
            List<b> listH = h(aVarC, g(aVarC, this.f10872a, true), true);
            for (int i11 = 0; i11 < listH.size(); i11++) {
                this.f10876e.e(this.f10877f.a(listH.get(i11).f10889b));
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        } catch (Exception unused2) {
        } finally {
            this.f10876e.e(this.f10877f.a(this.f10872a));
        }
    }
}
