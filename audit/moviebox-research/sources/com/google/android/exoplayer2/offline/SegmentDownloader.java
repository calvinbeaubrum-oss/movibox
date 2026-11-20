package com.google.android.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.c;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.g;
import com.google.android.exoplayer2.upstream.cache.i;
import com.google.android.exoplayer2.upstream.cache.l;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SegmentDownloader<M extends c<M>> implements com.google.android.exoplayer2.offline.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f33646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0.a<M> f33647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<StreamKey> f33648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.cache.a.c f33649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Cache f33650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f33651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final PriorityTaskManager f33652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f33653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<RunnableFutureTask<?, ?>> f33654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f33655j;

    /* JADX INFO: compiled from: source.java */
    public static final class SegmentDownloadRunnable extends RunnableFutureTask<Void, IOException> {
        private final i cacheWriter;
        public final com.google.android.exoplayer2.upstream.cache.a dataSource;

        @Nullable
        private final a progressNotifier;
        public final b segment;
        public final byte[] temporaryBuffer;

        public SegmentDownloadRunnable(b bVar, com.google.android.exoplayer2.upstream.cache.a aVar, @Nullable a aVar2, byte[] bArr) {
            this.segment = bVar;
            this.dataSource = aVar;
            this.progressNotifier = aVar2;
            this.temporaryBuffer = bArr;
            this.cacheWriter = new i(aVar, bVar.f33662b, bArr, aVar2);
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public void cancelWork() {
            this.cacheWriter.b();
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
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
    public static final class a implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.offline.b.a f33656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f33657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f33658c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f33659d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f33660e;

        public a(com.google.android.exoplayer2.offline.b.a aVar, long j11, int i11, long j12, int i12) {
            this.f33656a = aVar;
            this.f33657b = j11;
            this.f33658c = i11;
            this.f33659d = j12;
            this.f33660e = i12;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.i.a
        public void a(long j11, long j12, long j13) {
            long j14 = this.f33659d + j13;
            this.f33659d = j14;
            this.f33656a.onProgress(this.f33657b, j14, b());
        }

        public final float b() {
            long j11 = this.f33657b;
            if (j11 != -1 && j11 != 0) {
                return (this.f33659d * 100.0f) / j11;
            }
            int i11 = this.f33658c;
            if (i11 != 0) {
                return (this.f33660e * 100.0f) / i11;
            }
            return -1.0f;
        }

        public void c() {
            this.f33660e++;
            this.f33656a.onProgress(this.f33657b, this.f33659d, b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f33661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f33662b;

        public b(long j11, n nVar) {
            this.f33661a = j11;
            this.f33662b = nVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return o0.o(this.f33661a, bVar.f33661a);
        }
    }

    public SegmentDownloader(u1 u1Var, b0.a<M> aVar, com.google.android.exoplayer2.upstream.cache.a.c cVar, Executor executor) {
        com.google.android.exoplayer2.util.a.e(u1Var.f34776b);
        this.f33646a = f(u1Var.f34776b.f34839a);
        this.f33647b = aVar;
        this.f33648c = new ArrayList<>(u1Var.f34776b.f34842d);
        this.f33649d = cVar;
        this.f33653h = executor;
        this.f33650e = (Cache) com.google.android.exoplayer2.util.a.e(cVar.e());
        this.f33651f = cVar.f();
        this.f33652g = cVar.g();
        this.f33654i = new ArrayList<>();
    }

    public static boolean d(n nVar, n nVar2) {
        if (nVar.f35422a.equals(nVar2.f35422a)) {
            long j11 = nVar.f35429h;
            if (j11 != -1 && nVar.f35428g + j11 == nVar2.f35428g && o0.c(nVar.f35430i, nVar2.f35430i) && nVar.f35431j == nVar2.f35431j && nVar.f35424c == nVar2.f35424c && nVar.f35426e.equals(nVar2.f35426e)) {
                return true;
            }
        }
        return false;
    }

    public static n f(Uri uri) {
        return new n.b().i(uri).b(1).a();
    }

    public static void i(List<b> list, g gVar) {
        HashMap map = new HashMap();
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            b bVar = list.get(i12);
            String strA = gVar.a(bVar.f33662b);
            Integer num = (Integer) map.get(strA);
            b bVar2 = num == null ? null : list.get(num.intValue());
            if (bVar2 == null || bVar.f33661a > bVar2.f33661a + 20000000 || !d(bVar2.f33662b, bVar.f33662b)) {
                map.put(strA, Integer.valueOf(i11));
                list.set(i11, bVar);
                i11++;
            } else {
                long j11 = bVar.f33662b.f35429h;
                list.set(((Integer) com.google.android.exoplayer2.util.a.e(num)).intValue(), new b(bVar2.f33661a, bVar2.f33662b.f(0L, j11 != -1 ? bVar2.f33662b.f35429h + j11 : -1L)));
            }
        }
        o0.N0(list, i11, list.size());
    }

    /* JADX WARN: Code duplicated, block: B:87:0x01ad A[LOOP:1: B:85:0x01a5->B:87:0x01ad, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:90:0x01c6 A[LOOP:2: B:89:0x01c4->B:90:0x01c6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:93:0x01db  */
    @Override // com.google.android.exoplayer2.offline.b
    public final void a(@Nullable com.google.android.exoplayer2.offline.b.a aVar) throws Throwable {
        SegmentDownloader<M> segmentDownloader;
        int i11;
        int size;
        PriorityTaskManager priorityTaskManager;
        com.google.android.exoplayer2.upstream.cache.a aVarB;
        byte[] bArr;
        SegmentDownloader<M> segmentDownloader2 = this;
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        PriorityTaskManager priorityTaskManager2 = segmentDownloader2.f33652g;
        if (priorityTaskManager2 != null) {
            priorityTaskManager2.a(-1000);
        }
        try {
            com.google.android.exoplayer2.upstream.cache.a aVarB2 = segmentDownloader2.f33649d.b();
            c cVarG = segmentDownloader2.g(aVarB2, segmentDownloader2.f33646a, false);
            if (!segmentDownloader2.f33648c.isEmpty()) {
                cVarG = (c) cVarG.copy(segmentDownloader2.f33648c);
            }
            List<b> listH = segmentDownloader2.h(aVarB2, cVarG, false);
            Collections.sort(listH);
            i(listH, segmentDownloader2.f33651f);
            int size2 = listH.size();
            int size3 = listH.size() - 1;
            long j11 = 0;
            long j12 = 0;
            int i12 = 0;
            while (size3 >= 0) {
                try {
                    n nVar = listH.get(size3).f33662b;
                    String strA = segmentDownloader2.f33651f.a(nVar);
                    long j13 = nVar.f35429h;
                    if (j13 == -1) {
                        long jA = l.a(segmentDownloader2.f33650e.getContentMetadata(strA));
                        if (jA != -1) {
                            j13 = jA - nVar.f35428g;
                        }
                    }
                    ArrayDeque arrayDeque3 = arrayDeque;
                    long jA2 = segmentDownloader2.f33650e.a(strA, nVar.f35428g, j13);
                    j12 += jA2;
                    if (j13 != -1) {
                        if (j13 == jA2) {
                            i12++;
                            listH.remove(size3);
                        }
                        if (j11 != -1) {
                            j11 += j13;
                        }
                    } else {
                        j11 = -1;
                    }
                    size3--;
                    segmentDownloader2 = this;
                    arrayDeque = arrayDeque3;
                } catch (Throwable th2) {
                    th = th2;
                    segmentDownloader = this;
                    for (i11 = 0; i11 < segmentDownloader.f33654i.size(); i11++) {
                        segmentDownloader.f33654i.get(i11).cancel(true);
                    }
                    for (size = segmentDownloader.f33654i.size() - 1; size >= 0; size--) {
                        segmentDownloader.f33654i.get(size).blockUntilFinished();
                        segmentDownloader.j(size);
                    }
                    priorityTaskManager = segmentDownloader.f33652g;
                    if (priorityTaskManager != null) {
                        priorityTaskManager.d(-1000);
                    }
                    throw th;
                }
            }
            ArrayDeque arrayDeque4 = arrayDeque;
            a aVar2 = aVar != null ? new a(aVar, j11, size2, j12, i12) : null;
            arrayDeque4.addAll(listH);
            segmentDownloader = this;
            while (!segmentDownloader.f33655j && !arrayDeque4.isEmpty()) {
                try {
                    PriorityTaskManager priorityTaskManager3 = segmentDownloader.f33652g;
                    if (priorityTaskManager3 != null) {
                        priorityTaskManager3.b(-1000);
                    }
                    if (arrayDeque2.isEmpty()) {
                        aVarB = segmentDownloader.f33649d.b();
                        bArr = new byte[131072];
                    } else {
                        SegmentDownloadRunnable segmentDownloadRunnable = (SegmentDownloadRunnable) arrayDeque2.removeFirst();
                        aVarB = segmentDownloadRunnable.dataSource;
                        bArr = segmentDownloadRunnable.temporaryBuffer;
                    }
                    SegmentDownloadRunnable segmentDownloadRunnable2 = new SegmentDownloadRunnable((b) arrayDeque4.removeFirst(), aVarB, aVar2, bArr);
                    segmentDownloader.c(segmentDownloadRunnable2);
                    segmentDownloader.f33653h.execute(segmentDownloadRunnable2);
                    for (int size4 = segmentDownloader.f33654i.size() - 1; size4 >= 0; size4--) {
                        SegmentDownloadRunnable segmentDownloadRunnable3 = (SegmentDownloadRunnable) segmentDownloader.f33654i.get(size4);
                        if (arrayDeque4.isEmpty() || segmentDownloadRunnable3.isDone()) {
                            try {
                                segmentDownloadRunnable3.get();
                                segmentDownloader.j(size4);
                                arrayDeque2.addLast(segmentDownloadRunnable3);
                            } catch (ExecutionException e11) {
                                Throwable th3 = (Throwable) com.google.android.exoplayer2.util.a.e(e11.getCause());
                                if (th3 instanceof PriorityTaskManager.PriorityTooLowException) {
                                    arrayDeque4.addFirst(segmentDownloadRunnable3.segment);
                                    segmentDownloader.j(size4);
                                    arrayDeque2.addLast(segmentDownloadRunnable3);
                                } else {
                                    if (th3 instanceof IOException) {
                                        throw ((IOException) th3);
                                    }
                                    o0.R0(th3);
                                }
                            }
                        }
                    }
                    segmentDownloadRunnable2.blockUntilStarted();
                } catch (Throwable th4) {
                    th = th4;
                    while (i11 < segmentDownloader.f33654i.size()) {
                        segmentDownloader.f33654i.get(i11).cancel(true);
                    }
                    while (size >= 0) {
                        segmentDownloader.f33654i.get(size).blockUntilFinished();
                        segmentDownloader.j(size);
                    }
                    priorityTaskManager = segmentDownloader.f33652g;
                    if (priorityTaskManager != null) {
                        priorityTaskManager.d(-1000);
                    }
                    throw th;
                }
            }
            for (int i13 = 0; i13 < segmentDownloader.f33654i.size(); i13++) {
                segmentDownloader.f33654i.get(i13).cancel(true);
            }
            for (int size5 = segmentDownloader.f33654i.size() - 1; size5 >= 0; size5--) {
                segmentDownloader.f33654i.get(size5).blockUntilFinished();
                segmentDownloader.j(size5);
            }
            PriorityTaskManager priorityTaskManager4 = segmentDownloader.f33652g;
            if (priorityTaskManager4 != null) {
                priorityTaskManager4.d(-1000);
            }
        } catch (Throwable th5) {
            th = th5;
            segmentDownloader = segmentDownloader2;
        }
    }

    public final <T> void c(RunnableFutureTask<T, ?> runnableFutureTask) throws InterruptedException {
        synchronized (this.f33654i) {
            try {
                if (this.f33655j) {
                    throw new InterruptedException();
                }
                this.f33654i.add(runnableFutureTask);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.offline.b
    public void cancel() {
        synchronized (this.f33654i) {
            try {
                this.f33655j = true;
                for (int i11 = 0; i11 < this.f33654i.size(); i11++) {
                    this.f33654i.get(i11).cancel(true);
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
                Throwable th2 = (Throwable) com.google.android.exoplayer2.util.a.e(e11.getCause());
                if (th2 instanceof IOException) {
                    throw ((IOException) th2);
                }
                o0.R0(e11);
            }
        }
        while (!this.f33655j) {
            PriorityTaskManager priorityTaskManager = this.f33652g;
            if (priorityTaskManager != null) {
                priorityTaskManager.b(-1000);
            }
            c(runnableFutureTask);
            this.f33653h.execute(runnableFutureTask);
            try {
                T t11 = runnableFutureTask.get();
                runnableFutureTask.blockUntilFinished();
                k(runnableFutureTask);
                return t11;
            } catch (ExecutionException e12) {
                try {
                    Throwable th3 = (Throwable) com.google.android.exoplayer2.util.a.e(e12.getCause());
                    if (!(th3 instanceof PriorityTaskManager.PriorityTooLowException)) {
                        if (th3 instanceof IOException) {
                            throw ((IOException) th3);
                        }
                        o0.R0(e12);
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

    public final M g(final k kVar, final n nVar, boolean z11) throws InterruptedException, IOException {
        return (M) e(new RunnableFutureTask<M, IOException>() { // from class: com.google.android.exoplayer2.offline.SegmentDownloader.1
            @Override // com.google.android.exoplayer2.util.RunnableFutureTask
            public M doWork() throws IOException {
                return (M) b0.e(kVar, SegmentDownloader.this.f33647b, nVar, 4);
            }
        }, z11);
    }

    public abstract List<b> h(k kVar, M m11, boolean z11) throws InterruptedException, IOException;

    public final void j(int i11) {
        synchronized (this.f33654i) {
            this.f33654i.remove(i11);
        }
    }

    public final void k(RunnableFutureTask<?, ?> runnableFutureTask) {
        synchronized (this.f33654i) {
            this.f33654i.remove(runnableFutureTask);
        }
    }

    @Override // com.google.android.exoplayer2.offline.b
    public final void remove() {
        com.google.android.exoplayer2.upstream.cache.a aVarC = this.f33649d.c();
        try {
            List<b> listH = h(aVarC, g(aVarC, this.f33646a, true), true);
            for (int i11 = 0; i11 < listH.size(); i11++) {
                this.f33650e.e(this.f33651f.a(listH.get(i11).f33662b));
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        } catch (Exception unused2) {
        } finally {
            this.f33650e.e(this.f33651f.a(this.f33646a));
        }
    }
}
