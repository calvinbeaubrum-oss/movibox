package com.bykv.vk.openvk.sc.sc.pFF.pFF.TRI;

import android.text.TextUtils;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.TRI;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.We;
import com.bykv.vk.openvk.sc.sc.sc.zY.zY;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import v8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f25935c = c.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, Boolean> f25936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0217sc f25937b;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final sc f25938a = new sc();
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.sc.sc.pFF.pFF.TRI.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0217sc extends Thread {
        private final Queue<a> We = new ArrayBlockingQueue(10);
        private Queue<a> pFF = new LinkedBlockingQueue();
        private boolean zY = true;
        private Queue<a> ExN = new LinkedBlockingQueue();

        /* JADX INFO: renamed from: com.bykv.vk.openvk.sc.sc.pFF.pFF.TRI.sc$sc$a */
        /* JADX INFO: compiled from: source.java */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f25940a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f25941b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String[] f25942c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f25943d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f25944e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public zY f25945f;

            public a() {
            }
        }

        public C0217sc() {
        }

        private synchronized void pFF(a aVar) {
            this.ExN.add(aVar);
            notify();
        }

        private a sc(int i11, zY zYVar) {
            this.We.size();
            a aVarPoll = this.We.poll();
            if (aVarPoll == null) {
                aVarPoll = new a();
            }
            aVarPoll.f25940a = i11;
            aVarPoll.f25945f = zYVar;
            return aVarPoll;
        }

        private void sc() {
            while (true) {
                a aVarPoll = this.ExN.poll();
                if (aVarPoll == null) {
                    return;
                }
                aVarPoll.f25941b = aVarPoll.f25945f.Ql();
                aVarPoll.f25942c = new String[]{aVarPoll.f25945f.Ql()};
                int iSc = aVarPoll.f25945f.sc();
                if (iSc <= 0) {
                    iSc = aVarPoll.f25945f.zY();
                }
                aVarPoll.f25943d = iSc;
                aVarPoll.f25944e = aVarPoll.f25945f.SR();
                if (!TextUtils.isEmpty(aVarPoll.f25945f.SR())) {
                    aVarPoll.f25941b = aVarPoll.f25945f.SR();
                }
                aVarPoll.f25945f = null;
                zY(aVarPoll);
            }
        }

        private void sc(a aVar) {
            aVar.f25942c = null;
            aVar.f25941b = null;
            aVar.f25940a = -1;
            aVar.f25945f = null;
            this.We.offer(aVar);
        }

        private void zY(a aVar) {
            if (aVar == null) {
                return;
            }
            this.pFF.offer(aVar);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.zY) {
                synchronized (this) {
                    try {
                        if (!this.ExN.isEmpty()) {
                            sc();
                        }
                        while (!this.pFF.isEmpty()) {
                            a aVarPoll = this.pFF.poll();
                            if (aVarPoll != null) {
                                int i11 = aVarPoll.f25940a;
                                if (i11 == 0) {
                                    String[] strArr = aVarPoll.f25942c;
                                    if (strArr != null && strArr.length > 0) {
                                        ArrayList arrayList = new ArrayList();
                                        for (String str : aVarPoll.f25942c) {
                                            if (p8.a.w(str)) {
                                                arrayList.add(str);
                                            }
                                        }
                                        We.o().m(false, !TextUtils.isEmpty(aVarPoll.f25944e), aVarPoll.f25943d, aVarPoll.f25941b, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                    }
                                } else if (i11 == 1) {
                                    We.o().j(aVarPoll.f25941b);
                                } else if (i11 == 2) {
                                    We.o().a();
                                } else if (i11 == 3) {
                                    We.o().a();
                                    com.bykv.vk.openvk.sc.sc.pFF.pFF.a.h();
                                    if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.b() != null) {
                                        com.bykv.vk.openvk.sc.sc.pFF.pFF.a.b().j();
                                    }
                                } else if (i11 == 4) {
                                    We.o().a();
                                    this.zY = false;
                                }
                                sc(aVarPoll);
                            }
                        }
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        public void sc(zY zYVar) {
            pFF(sc(0, zYVar));
        }
    }

    public sc() {
        this.f25936a = new HashMap<>();
        b();
    }

    public static sc c() {
        return b.f25938a;
    }

    public static com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY e() {
        File file = new File(q8.c.e().getCacheDir(), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar = new com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY(file);
            try {
                zYVar.k(104857600L);
                return zYVar;
            } catch (IOException unused) {
                return zYVar;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public String a(zY zYVar) {
        if (zYVar == null) {
            return null;
        }
        boolean z11 = !TextUtils.isEmpty(zYVar.SR());
        return TRI.q().r(false, z11, z11 ? zYVar.SR() : zYVar.Ql(), zYVar.Ql());
    }

    public boolean b() {
        if (this.f25937b != null) {
            return true;
        }
        com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVarE = e();
        if (zYVarE == null) {
            return false;
        }
        com.bykv.vk.openvk.sc.sc.pFF.pFF.a.g(true);
        com.bykv.vk.openvk.sc.sc.pFF.pFF.a.c(true);
        com.bykv.vk.openvk.sc.sc.pFF.pFF.a.e(1);
        TRI.q().j();
        try {
            C0217sc c0217sc = new C0217sc();
            this.f25937b = c0217sc;
            c0217sc.setName("csj_video_cache_preloader");
            this.f25937b.start();
            com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f(zYVarE, q8.c.e());
            We.o();
            We.o().g(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean d(zY zYVar) {
        if (!b()) {
            return false;
        }
        this.f25937b.sc(zYVar);
        return true;
    }
}
