package com.android.volley;

import android.os.SystemClock;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AsyncRequestQueue extends h {

    /* JADX INFO: renamed from: com.android.volley.AsyncRequestQueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ AsyncRequestQueue this$0;

        /* JADX INFO: renamed from: com.android.volley.AsyncRequestQueue$1$a */
        /* JADX INFO: compiled from: source.java */
        public class a {
            public a() {
            }
        }

        public AnonymousClass1(AsyncRequestQueue asyncRequestQueue) {
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncRequestQueue.j(null);
            new a();
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.android.volley.AsyncRequestQueue$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ AsyncRequestQueue this$0;

        /* JADX INFO: renamed from: com.android.volley.AsyncRequestQueue$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.getClass();
                AsyncRequestQueue.i(null);
            }
        }

        public AnonymousClass2(AsyncRequestQueue asyncRequestQueue) {
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.android.volley.AsyncRequestQueue$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass3 implements Comparator<Runnable> {
        @Override // java.util.Comparator
        public int compare(Runnable runnable, Runnable runnable2) {
            if (!(runnable instanceof RequestTask)) {
                return runnable2 instanceof RequestTask ? -1 : 0;
            }
            if (runnable2 instanceof RequestTask) {
                return ((RequestTask) runnable).compareTo((RequestTask) runnable2);
            }
            return 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class CacheParseTask<T> extends RequestTask<T> {
        c.a entry;
        long startTimeMillis;
        final /* synthetic */ AsyncRequestQueue this$0;

        /* JADX INFO: renamed from: com.android.volley.AsyncRequestQueue$CacheParseTask$1, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CacheParseTask.this.getClass();
                Request<T> request = CacheParseTask.this.mRequest;
                throw null;
            }
        }

        public CacheParseTask(AsyncRequestQueue asyncRequestQueue, Request<T> request, c.a aVar, long j11) {
            super(request);
            this.entry = aVar;
            this.startTimeMillis = j11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRequest.addMarker("cache-hit");
            Request<T> request = this.mRequest;
            c.a aVar = this.entry;
            i<T> networkResponse = request.parseNetworkResponse(new g(200, aVar.f16490a, false, 0L, aVar.f16497h));
            this.mRequest.addMarker("cache-hit-parsed");
            if (!this.entry.c(this.startTimeMillis)) {
                throw null;
            }
            this.mRequest.addMarker("cache-hit-refresh-needed");
            this.mRequest.setCacheEntry(this.entry);
            networkResponse.f16524d = true;
            if (!AsyncRequestQueue.k(null).c(this.mRequest)) {
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class CachePutTask<T> extends RequestTask<T> {
        i<?> response;
        final /* synthetic */ AsyncRequestQueue this$0;

        /* JADX INFO: compiled from: source.java */
        public class a {
            public a() {
            }
        }

        public CachePutTask(AsyncRequestQueue asyncRequestQueue, Request<T> request, i<?> iVar) {
            super(request);
            this.response = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = null;
            AsyncRequestQueue.j(null);
            obj.getClass();
            AsyncRequestQueue.j(null);
            this.mRequest.getCacheKey();
            c.a aVar = this.response.f16522b;
            new a();
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class CacheTask<T> extends RequestTask<T> {
        final /* synthetic */ AsyncRequestQueue this$0;

        /* JADX INFO: compiled from: source.java */
        public class a {
            public a() {
            }
        }

        public CacheTask(AsyncRequestQueue asyncRequestQueue, Request<T> request) {
            super(request);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mRequest.isCanceled()) {
                this.mRequest.finish("cache-discard-canceled");
                return;
            }
            this.mRequest.addMarker("cache-queue-take");
            Object obj = null;
            AsyncRequestQueue.j(null);
            obj.getClass();
            AsyncRequestQueue.j(null);
            this.mRequest.getCacheKey();
            new a();
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class NetworkParseTask<T> extends RequestTask<T> {
        g networkResponse;
        final /* synthetic */ AsyncRequestQueue this$0;

        public NetworkParseTask(AsyncRequestQueue asyncRequestQueue, Request<T> request, g gVar) {
            super(request);
            this.networkResponse = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            i<T> networkResponse = this.mRequest.parseNetworkResponse(this.networkResponse);
            this.mRequest.addMarker("network-parse-complete");
            if (!this.mRequest.shouldCache() || networkResponse.f16522b == null) {
                AsyncRequestQueue.n(null, this.mRequest, networkResponse, false);
            } else {
                AsyncRequestQueue.j(null);
                AsyncRequestQueue.l(null).execute(new CachePutTask(null, this.mRequest, networkResponse));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class NetworkTask<T> extends RequestTask<T> {
        final /* synthetic */ AsyncRequestQueue this$0;

        /* JADX INFO: compiled from: source.java */
        public class a implements b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f16485a;

            public a(long j11) {
                this.f16485a = j11;
            }

            @Override // com.android.volley.b.a
            public void a(VolleyError volleyError) {
                volleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - this.f16485a);
                NetworkTask.this.getClass();
                ExecutorService executorServiceL = AsyncRequestQueue.l(null);
                NetworkTask.this.getClass();
                executorServiceL.execute(new ParseErrorTask(null, NetworkTask.this.mRequest, volleyError));
            }
        }

        public NetworkTask(AsyncRequestQueue asyncRequestQueue, Request<T> request) {
            super(request);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mRequest.isCanceled()) {
                this.mRequest.finish("network-discard-cancelled");
                this.mRequest.notifyListenerResponseNotUsable();
            } else {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.mRequest.addMarker("network-queue-take");
                AsyncRequestQueue.m(null);
                new a(jElapsedRealtime);
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class ParseErrorTask<T> extends RequestTask<T> {
        final /* synthetic */ AsyncRequestQueue this$0;
        VolleyError volleyError;

        public ParseErrorTask(AsyncRequestQueue asyncRequestQueue, Request<T> request, VolleyError volleyError) {
            super(request);
            this.volleyError = volleyError;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRequest.parseNetworkError(this.volleyError);
            throw null;
        }
    }

    public static /* synthetic */ void i(AsyncRequestQueue asyncRequestQueue) {
        throw null;
    }

    public static /* synthetic */ a j(AsyncRequestQueue asyncRequestQueue) {
        throw null;
    }

    public static /* synthetic */ m k(AsyncRequestQueue asyncRequestQueue) {
        throw null;
    }

    public static /* synthetic */ ExecutorService l(AsyncRequestQueue asyncRequestQueue) {
        throw null;
    }

    public static /* synthetic */ b m(AsyncRequestQueue asyncRequestQueue) {
        throw null;
    }

    public static /* synthetic */ void n(AsyncRequestQueue asyncRequestQueue, Request request, i iVar, boolean z11) {
        throw null;
    }
}
