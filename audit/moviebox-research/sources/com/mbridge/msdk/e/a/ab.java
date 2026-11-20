package com.mbridge.msdk.e.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class ab implements p.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f43765b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f43767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BlockingQueue<p<?>> f43768e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, List<p<?>>> f43764a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q f43766c = null;

    public ab(c cVar, BlockingQueue<p<?>> blockingQueue, t tVar) {
        this.f43765b = tVar;
        this.f43767d = cVar;
        this.f43768e = blockingQueue;
    }

    @Override // com.mbridge.msdk.e.a.p.a
    public final synchronized void a(p<?> pVar) {
        BlockingQueue<p<?>> blockingQueue;
        try {
            String strJ = pVar.j();
            List<p<?>> listRemove = this.f43764a.remove(strJ);
            if (listRemove != null && !listRemove.isEmpty()) {
                p<?> pVarRemove = listRemove.remove(0);
                this.f43764a.put(strJ, listRemove);
                pVarRemove.a((p.a) this);
                q qVar = this.f43766c;
                if (qVar != null) {
                    qVar.c(pVarRemove);
                } else if (this.f43767d != null && (blockingQueue = this.f43768e) != null) {
                    try {
                        blockingQueue.put(pVarRemove);
                    } catch (InterruptedException e11) {
                        aa.c("Couldn't add request to queue. %s", e11.toString());
                        Thread.currentThread().interrupt();
                        this.f43767d.a();
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.mbridge.msdk.e.a.p.a
    public final void a(p<?> pVar, r<?> rVar) {
        List<p<?>> listRemove;
        b.a aVar = rVar.f43844b;
        if (aVar == null || aVar.a(System.currentTimeMillis())) {
            a(pVar);
            return;
        }
        String strJ = pVar.j();
        synchronized (this) {
            listRemove = this.f43764a.remove(strJ);
        }
        if (listRemove != null) {
            Iterator<p<?>> it = listRemove.iterator();
            while (it.hasNext()) {
                this.f43765b.a(it.next(), rVar);
            }
        }
    }

    public final synchronized boolean b(p<?> pVar) {
        try {
            String strJ = pVar.j();
            if (!this.f43764a.containsKey(strJ)) {
                this.f43764a.put(strJ, null);
                pVar.a((p.a) this);
                return false;
            }
            List<p<?>> arrayList = this.f43764a.get(strJ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(pVar);
            this.f43764a.put(strJ, arrayList);
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
