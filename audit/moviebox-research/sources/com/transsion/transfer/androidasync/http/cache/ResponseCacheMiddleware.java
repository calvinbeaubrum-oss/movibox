package com.transsion.transfer.androidasync.http.cache;

import com.transsion.transfer.androidasync.http.c0;
import com.transsion.transfer.androidasync.http.g;
import com.transsion.transfer.androidasync.l;
import com.transsion.transfer.androidasync.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ResponseCacheMiddleware extends c0 {

    /* JADX INFO: renamed from: com.transsion.transfer.androidasync.http.cache.ResponseCacheMiddleware$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ResponseCacheMiddleware this$0;
        final /* synthetic */ g.a val$data;
        final /* synthetic */ a val$socket;

        public AnonymousClass1(ResponseCacheMiddleware responseCacheMiddleware, g.a aVar, a aVar2) {
            this.val$data = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$data.f58660c.a(null, null);
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class CachedBodyEmitter extends v {

        /* JADX INFO: renamed from: com.transsion.transfer.androidasync.http.cache.ResponseCacheMiddleware$CachedBodyEmitter$1, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ CachedBodyEmitter this$0;

            public AnonymousClass1(CachedBodyEmitter cachedBodyEmitter) {
            }

            @Override // java.lang.Runnable
            public void run() {
                throw null;
            }
        }

        /* JADX INFO: renamed from: com.transsion.transfer.androidasync.http.cache.ResponseCacheMiddleware$CachedBodyEmitter$2, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ CachedBodyEmitter this$0;

            public AnonymousClass2(CachedBodyEmitter cachedBodyEmitter) {
            }

            @Override // java.lang.Runnable
            public void run() {
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends CachedBodyEmitter implements l {
    }
}
