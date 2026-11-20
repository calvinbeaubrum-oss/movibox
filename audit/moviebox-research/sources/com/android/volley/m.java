package com.android.volley;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class m implements Request.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f16535b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final CacheDispatcher f16537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final BlockingQueue<Request<?>> f16538e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<Request<?>>> f16534a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final h f16536c = null;

    public m(@NonNull CacheDispatcher cacheDispatcher, @NonNull BlockingQueue<Request<?>> blockingQueue, j jVar) {
        this.f16535b = jVar;
        this.f16537d = cacheDispatcher;
        this.f16538e = blockingQueue;
    }

    @Override // com.android.volley.Request.a
    public void a(Request<?> request, i<?> iVar) {
        List<Request<?>> listRemove;
        c.a aVar = iVar.f16522b;
        if (aVar == null || aVar.a()) {
            b(request);
            return;
        }
        String cacheKey = request.getCacheKey();
        synchronized (this) {
            listRemove = this.f16534a.remove(cacheKey);
        }
        if (listRemove != null) {
            if (l.f16526b) {
                l.e("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(listRemove.size()), cacheKey);
            }
            Iterator<Request<?>> it = listRemove.iterator();
            while (it.hasNext()) {
                this.f16535b.a(it.next(), iVar);
            }
        }
    }

    @Override // com.android.volley.Request.a
    public synchronized void b(Request<?> request) {
        BlockingQueue<Request<?>> blockingQueue;
        try {
            String cacheKey = request.getCacheKey();
            List<Request<?>> listRemove = this.f16534a.remove(cacheKey);
            if (listRemove != null && !listRemove.isEmpty()) {
                if (l.f16526b) {
                    l.e("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(listRemove.size()), cacheKey);
                }
                Request<?> requestRemove = listRemove.remove(0);
                this.f16534a.put(cacheKey, listRemove);
                requestRemove.setNetworkRequestCompleteListener(this);
                h hVar = this.f16536c;
                if (hVar != null) {
                    hVar.f(requestRemove);
                } else if (this.f16537d != null && (blockingQueue = this.f16538e) != null) {
                    try {
                        blockingQueue.put(requestRemove);
                    } catch (InterruptedException e11) {
                        l.c("Couldn't add request to queue. %s", e11.toString());
                        Thread.currentThread().interrupt();
                        this.f16537d.quit();
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean c(Request<?> request) {
        try {
            String cacheKey = request.getCacheKey();
            if (!this.f16534a.containsKey(cacheKey)) {
                this.f16534a.put(cacheKey, null);
                request.setNetworkRequestCompleteListener(this);
                if (l.f16526b) {
                    l.b("new request, sending to network %s", cacheKey);
                }
                return false;
            }
            List<Request<?>> arrayList = this.f16534a.get(cacheKey);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            request.addMarker("waiting-for-response");
            arrayList.add(request);
            this.f16534a.put(cacheKey, arrayList);
            if (l.f16526b) {
                l.b("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
            }
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
