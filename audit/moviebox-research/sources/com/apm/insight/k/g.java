package com.apm.insight.k;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.Npth;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.n;
import com.apm.insight.runtime.r;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Object, ConcurrentLinkedQueue<com.apm.insight.entity.c>> f16909a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<Object, HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>>> f16910b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile g f16911c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f16913e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f16914f = new Runnable() { // from class: com.apm.insight.k.g.1
        @Override // java.lang.Runnable
        public final void run() {
            if (Npth.isStopUpload()) {
                return;
            }
            if (!g.f16910b.isEmpty() && m.e()) {
                g.f();
            }
            g.this.c();
            g.this.f16912d.a(g.this.f16914f, 30000L);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r f16912d = n.a();

    private g() {
    }

    public static g a() {
        if (f16911c == null) {
            synchronized (g.class) {
                try {
                    if (f16911c == null) {
                        f16911c = new g();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f16911c;
    }

    public static void a(@NonNull com.apm.insight.entity.c cVar) {
        a(com.apm.insight.d.a(), cVar);
    }

    public static void a(@Nullable final Object obj, @NonNull final com.apm.insight.entity.c cVar) {
        String string;
        Handler handlerA = n.a().a();
        if (handlerA == null || handlerA.getLooper() != Looper.myLooper()) {
            n.a().a(new Runnable() { // from class: com.apm.insight.k.g.2
                @Override // java.lang.Runnable
                public final void run() {
                    g.a(obj, cVar);
                }
            });
            return;
        }
        if (obj == null) {
            obj = com.apm.insight.d.a();
        }
        if (!m.e()) {
            com.apm.insight.a.a("EventUploadQueue", "enqueue before init.");
            c(obj, cVar);
            return;
        }
        if (!com.apm.insight.runtime.a.a(obj)) {
            a.b();
        }
        f();
        try {
            string = cVar.c().getString("log_type");
        } catch (JSONException e11) {
            e11.printStackTrace();
            string = null;
        }
        if (TextUtils.isEmpty(string) || !com.apm.insight.runtime.a.b(obj)) {
            com.apm.insight.a.a("EventUploadQueue", "logType " + string + " not sampled");
            return;
        }
        com.apm.insight.a.a("EventUploadQueue", "logType " + string + " enqueued");
        b(obj, cVar);
    }

    private static void b(Object obj, com.apm.insight.entity.c cVar) {
        ConcurrentHashMap<Object, ConcurrentLinkedQueue<com.apm.insight.entity.c>> concurrentHashMap;
        ConcurrentLinkedQueue<com.apm.insight.entity.c> concurrentLinkedQueue;
        synchronized (obj) {
            try {
                concurrentHashMap = f16909a;
                concurrentLinkedQueue = concurrentHashMap.get(obj);
                if (concurrentLinkedQueue == null) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                    concurrentHashMap.put(obj, concurrentLinkedQueue);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        concurrentLinkedQueue.add(cVar);
        int size = concurrentHashMap.size();
        boolean z11 = size >= 30;
        com.apm.insight.a.b((Object) "[enqueue] size=".concat(String.valueOf(size)));
        if (z11) {
            g();
        }
    }

    private static void c(Object obj, com.apm.insight.entity.c cVar) {
        ConcurrentLinkedQueue<com.apm.insight.entity.c> concurrentLinkedQueue;
        try {
            String string = cVar.c().getString("log_type");
            HashMap<Object, HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>>> map = f16910b;
            synchronized (map) {
                try {
                    HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>> map2 = map.get(string);
                    if (map2 == null) {
                        map2 = new HashMap<>();
                        map.put(obj, map2);
                    }
                    concurrentLinkedQueue = map2.get(string);
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        map2.put(string, concurrentLinkedQueue);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            concurrentLinkedQueue.add(cVar);
            if (concurrentLinkedQueue.size() > 100) {
                concurrentLinkedQueue.poll();
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        HashMap map;
        HashMap<Object, HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>>> map2 = f16910b;
        synchronized (map2) {
            map = new HashMap(map2);
            map2.clear();
        }
        if (!com.apm.insight.runtime.a.a()) {
            com.apm.insight.a.a("EventUploadQueue", "ApmConfig not inited, clear cache.");
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            for (Map.Entry entry2 : ((HashMap) entry.getValue()).entrySet()) {
                String str = (String) entry2.getKey();
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) entry2.getValue();
                if (concurrentLinkedQueue == null || (com.apm.insight.runtime.a.a() && !com.apm.insight.runtime.a.b(entry.getKey()))) {
                    com.apm.insight.a.a("EventUploadQueue", "logType " + str + " not sampled");
                } else {
                    while (!concurrentLinkedQueue.isEmpty()) {
                        try {
                            com.apm.insight.entity.c cVar = (com.apm.insight.entity.c) concurrentLinkedQueue.poll();
                            if (cVar == null) {
                                break;
                            } else {
                                b(entry.getKey(), cVar);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    private static void g() {
        if (!m.e() || Npth.isStopUpload()) {
            return;
        }
        try {
            n.a().a(new Runnable() { // from class: com.apm.insight.k.g.3
                @Override // java.lang.Runnable
                public final void run() {
                    g.a().c();
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        if (f16909a.isEmpty()) {
            this.f16912d.a(this.f16914f, 30000L);
        } else {
            this.f16912d.a(this.f16914f);
        }
    }

    public final void c() {
        synchronized (this.f16912d) {
            try {
                if (this.f16913e) {
                    return;
                }
                this.f16913e = true;
                LinkedList linkedList = new LinkedList();
                for (Map.Entry<Object, ConcurrentLinkedQueue<com.apm.insight.entity.c>> entry : f16909a.entrySet()) {
                    ConcurrentLinkedQueue<com.apm.insight.entity.c> value = entry.getValue();
                    Object key = entry.getKey();
                    while (!value.isEmpty()) {
                        for (int i11 = 0; i11 < 30; i11++) {
                            try {
                                if (value.isEmpty()) {
                                    break;
                                }
                                linkedList.add(value.poll());
                            } catch (Throwable th2) {
                                com.apm.insight.a.b(th2);
                            }
                        }
                        if (linkedList.isEmpty()) {
                            break;
                        }
                        com.apm.insight.entity.a aVarA = com.apm.insight.runtime.a.f.a().a(linkedList, com.apm.insight.entity.b.a(key));
                        if (aVarA != null) {
                            com.apm.insight.a.a((Object) "upload events");
                            d.a().b(aVarA.c());
                        }
                        linkedList.clear();
                    }
                }
                this.f16913e = false;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
