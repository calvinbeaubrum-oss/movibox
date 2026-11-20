package com.bykv.vk.openvk.sc.sc.pFF.pFF;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.zY;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile We f25947k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f25948a = 163840;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<Map<String, com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF>> f25949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pFF<Runnable> f25950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f25951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile zY f25952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY f25953f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashSet<c> f25954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.a f25955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f25956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f25957j;

    /* JADX INFO: compiled from: source.java */
    public class a implements com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.a {
        public a() {
        }

        @Override // com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.a
        public void a(com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF pff) {
            int iTRI = pff.TRI();
            synchronized (We.this.f25949b) {
                try {
                    Map map = (Map) We.this.f25949b.get(iTRI);
                    if (map != null) {
                        map.remove(pff.Qj);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                new StringBuilder("afterExecute, key: ").append(pff.Qj);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements RejectedExecutionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pFF f25962a;

        public b(pFF pff) {
            this.f25962a = pff;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                this.f25962a.offerFirst(runnable);
                com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f25963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f25964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f25965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f25966d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, String> f25967e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String[] f25968f;

        public c(boolean z11, boolean z12, int i11, String str, Map<String, String> map, String[] strArr) {
            this.f25963a = z11;
            this.f25964b = z12;
            this.f25965c = i11;
            this.f25966d = str;
            this.f25967e = map;
            this.f25968f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f25963a == cVar.f25963a && this.f25964b == cVar.f25964b && this.f25965c == cVar.f25965c) {
                return this.f25966d.equals(cVar.f25966d);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.f25963a ? 1 : 0) * 31) + (this.f25964b ? 1 : 0)) * 31) + this.f25965c) * 31) + this.f25966d.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class pFF<T> extends LinkedBlockingDeque<T> {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private ThreadPoolExecutor f25969sc;

        private pFF() {
        }

        public /* synthetic */ pFF(a aVar) {
            this();
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t11) {
            synchronized (this) {
                int poolSize = this.f25969sc.getPoolSize();
                int activeCount = this.f25969sc.getActiveCount();
                int maximumPoolSize = this.f25969sc.getMaximumPoolSize();
                if (activeCount < poolSize || poolSize >= maximumPoolSize) {
                    return offerFirst(t11);
                }
                com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
                return false;
            }
        }

        public void sc(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                try {
                    if (this.f25969sc != null) {
                        throw new IllegalStateException("You can only call setExecutor() once!");
                    }
                    if (threadPoolExecutor == null) {
                        throw new NullPointerException("executor argument can't be null!");
                    }
                    this.f25969sc = threadPoolExecutor;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public We() {
        SparseArray<Map<String, com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF>> sparseArray = new SparseArray<>(2);
        this.f25949b = sparseArray;
        this.f25954g = new HashSet<>();
        this.f25955h = new a();
        pFF<Runnable> pff = new pFF<>(null);
        this.f25950c = pff;
        ExecutorService executorServiceF = f(pff);
        this.f25951d = executorServiceF;
        pff.sc((ThreadPoolExecutor) executorServiceF);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    public static ExecutorService f(pFF<Runnable> pff) {
        int i11;
        int iF = p8.a.f();
        if (iF <= 0) {
            i11 = 1;
        } else {
            i11 = iF > 4 ? 4 : iF;
        }
        return new ThreadPoolExecutor(0, i11, 60L, TimeUnit.SECONDS, pff, new ThreadFactory() { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.We.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable) { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.We.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable unused) {
                        }
                        super.run();
                    }
                };
                thread.setName("csj_video_preload_" + thread.getId());
                thread.setDaemon(true);
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    new StringBuilder("new preload thead: ").append(thread.getName());
                }
                return thread;
            }
        }, new b(pff));
    }

    public static We o() {
        if (f25947k == null) {
            synchronized (We.class) {
                try {
                    if (f25947k == null) {
                        f25947k = new We();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f25947k;
    }

    public void a() {
        p8.a.q(new com.bytedance.sdk.component.Qj.Qj("cancelAll") { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.We.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF> arrayList = new ArrayList();
                synchronized (We.this.f25949b) {
                    try {
                        int size = We.this.f25949b.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            Map map = (Map) We.this.f25949b.get(We.this.f25949b.keyAt(i11));
                            if (map != null) {
                                arrayList.addAll(map.values());
                                map.clear();
                            }
                        }
                        We.this.f25950c.clear();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                for (com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF pff : arrayList) {
                    pff.sc();
                    if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                        Log.w("TAG_PROXY_Preloader", "PreloadTask: " + pff + ", canceled!!!");
                    }
                }
            }
        });
    }

    public d c() {
        return null;
    }

    public d e() {
        return null;
    }

    public void g(int i11) {
        if (i11 > 0) {
            this.f25948a = i11;
        }
        if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
            "MaxPreloadSize: ".concat(String.valueOf(i11));
        }
    }

    public void h(zY zYVar) {
        this.f25952e = zYVar;
    }

    public void i(com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar) {
        this.f25953f = zYVar;
    }

    public void j(String str) {
        n(false, false, str);
    }

    public void k(boolean z11, String str) throws Throwable {
        com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF pffRemove;
        this.f25956i = str;
        this.f25957j = z11;
        if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
            "setCurrentPlayKey, ".concat(String.valueOf(str));
        }
        HashSet<com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF> hashSet = null;
        HashSet<c> hashSet2 = null;
        if (str == null) {
            synchronized (this.f25954g) {
                try {
                    if (!this.f25954g.isEmpty()) {
                        hashSet2 = new HashSet(this.f25954g);
                        this.f25954g.clear();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (hashSet2 != null) {
                for (c cVar : hashSet2) {
                    l(cVar.f25963a, cVar.f25964b, cVar.f25965c, cVar.f25966d, cVar.f25967e, cVar.f25968f);
                    if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                        new StringBuilder("setCurrentPlayKey, resume preload: ").append(cVar.f25966d);
                    }
                }
                return;
            }
            return;
        }
        int i11 = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25978i;
        if (i11 != 3 && i11 != 2) {
            if (i11 == 1) {
                synchronized (this.f25949b) {
                    try {
                        Map<String, com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF> map = this.f25949b.get(com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.d.a(z11));
                        pffRemove = map != null ? map.remove(str) : null;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (pffRemove != null) {
                    pffRemove.sc();
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this.f25949b) {
            try {
                int size = this.f25949b.size();
                for (int i12 = 0; i12 < size; i12++) {
                    SparseArray<Map<String, com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF>> sparseArray = this.f25949b;
                    Map<String, com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF> map2 = sparseArray.get(sparseArray.keyAt(i12));
                    if (map2 != null) {
                        Collection<com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF> collectionValues = map2.values();
                        if (collectionValues != null && !collectionValues.isEmpty()) {
                            if (hashSet == null) {
                                hashSet = new HashSet();
                            }
                            hashSet.addAll(collectionValues);
                        }
                        map2.clear();
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        for (com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF pff : hashSet) {
            pff.sc();
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                new StringBuilder("setCurrentPlayKey, cancel preload: ").append(pff.f26025qr);
            }
        }
        if (i11 == 3) {
            synchronized (this.f25954g) {
                try {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        c cVar2 = (c) ((com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF) it.next()).SR;
                        if (cVar2 != null) {
                            this.f25954g.add(cVar2);
                        }
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:76:0x012a  */
    public void l(boolean z11, boolean z12, int i11, String str, Map<String, String> map, String... strArr) throws Throwable {
        SparseArray<Map<String, com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF>> sparseArray;
        String str2;
        ArrayList arrayList;
        boolean z13 = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c;
        com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar = z11 ? null : this.f25953f;
        zY zYVar2 = this.f25952e;
        if (zYVar == null || zYVar2 == null) {
            if (z13) {
                Log.e("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        int i12 = i11 <= 0 ? this.f25948a : i11;
        String strA = z12 ? str : v8.a.a(str);
        File fileA = zYVar.a(strA);
        if (fileA != null && fileA.length() >= i12) {
            if (z13) {
                StringBuilder sb2 = new StringBuilder("no need preload, file size: ");
                sb2.append(fileA.length());
                sb2.append(", need preload size: ");
                sb2.append(i12);
                return;
            }
            return;
        }
        if (TRI.q().w(com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.d.a(z11), strA)) {
            if (z13) {
                Log.w("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: ".concat(String.valueOf(str)));
                return;
            }
            return;
        }
        SparseArray<Map<String, com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF>> sparseArray2 = this.f25949b;
        synchronized (sparseArray2) {
            try {
                Map<String, com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF> map2 = this.f25949b.get(z11 ? 1 : 0);
                if (!map2.containsKey(strA)) {
                    sparseArray = sparseArray2;
                    String str3 = strA;
                    try {
                        c cVar = new c(z11, z12, i12, str, map, strArr);
                        String str4 = this.f25956i;
                        if (str4 == null) {
                            str2 = str3;
                        } else {
                            int i13 = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25978i;
                            if (i13 == 3) {
                                synchronized (this.f25954g) {
                                    this.f25954g.add(cVar);
                                }
                                if (z13) {
                                    Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                                }
                                return;
                            }
                            if (i13 == 2) {
                                if (z13) {
                                    Log.w("TAG_PROXY_Preloader", "cancel preload: ".concat(String.valueOf(str)));
                                }
                                return;
                            } else if (i13 == 1 && this.f25957j == z11) {
                                str2 = str3;
                                if (str4.equals(str2)) {
                                    if (z13) {
                                        Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                                    }
                                    return;
                                }
                            } else {
                                str2 = str3;
                            }
                        }
                        List<Ol.a> listN = p8.a.n(p8.a.o(map));
                        if (listN != null) {
                            arrayList = new ArrayList(listN.size());
                            int size = listN.size();
                            for (int i14 = 0; i14 < size; i14++) {
                                Ol.a aVar = listN.get(i14);
                                if (aVar != null) {
                                    arrayList.add(new Ol.a(aVar.f25907a, aVar.f25908b));
                                }
                            }
                        } else {
                            arrayList = null;
                        }
                        com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF pffK = new com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.b().g(zYVar).f(zYVar2).i(str).a(str2).d(new com.bykv.vk.openvk.sc.sc.pFF.pFF.b(p8.a.p(strArr))).j(arrayList).b(i12).e(this.f25955h).h(cVar).k();
                        map2.put(str2, pffK);
                        this.f25951d.execute(pffK);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                sparseArray = sparseArray2;
            }
        }
    }

    public void m(boolean z11, boolean z12, int i11, String str, String... strArr) throws Throwable {
        l(z11, z12, i11, str, null, strArr);
    }

    public void n(final boolean z11, final boolean z12, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p8.a.q(new com.bytedance.sdk.component.Qj.Qj("cancel b b S") { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.We.2
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF pff;
                synchronized (We.this.f25949b) {
                    try {
                        Map map = (Map) We.this.f25949b.get(com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.d.a(z11));
                        if (map != null) {
                            pff = (com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF) map.remove(z12 ? str : v8.a.a(str));
                        } else {
                            pff = null;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (pff != null) {
                    pff.sc();
                }
            }
        });
    }
}
