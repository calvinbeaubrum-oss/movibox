package com.mbridge.msdk.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f43924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f43925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f43926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f43927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f43928e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f43932i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicInteger f43929f = new AtomicInteger(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicInteger f43930g = new AtomicInteger(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f43931h = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f43933j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f43934k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f43935l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile boolean f43936m = false;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f43937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final r f43938b;

        public a(Handler handler, r rVar) {
            this.f43937a = handler;
            this.f43938b = rVar;
        }

        @Override // com.mbridge.msdk.e.q
        public final void a(s sVar) {
            r.a(this.f43938b, sVar.a());
            r.i(this.f43938b);
            this.f43938b.f43934k = 0L;
            if (this.f43938b.e()) {
                Handler handler = this.f43937a;
                handler.sendMessage(Message.obtain(handler, 2));
            }
            if (com.mbridge.msdk.e.a.f43738a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f43938b.f43928e.c());
                sb2.append(" report success ");
                sb2.append(sVar.a().size());
                sb2.append(" 剩余事件数：");
                sb2.append(this.f43938b.f43930g.addAndGet(0));
                sb2.append(" 个，数据库记录数：");
                sb2.append(this.f43938b.f43924a.a());
                sb2.append(" 个");
            }
        }

        @Override // com.mbridge.msdk.e.q
        public final void a(s sVar, int i11, String str) {
            r.b(this.f43938b, sVar.a());
            this.f43938b.f43934k = System.currentTimeMillis();
            int iJ = r.j(this.f43938b);
            if (iJ <= 10) {
                Handler handler = this.f43937a;
                handler.sendMessageDelayed(Message.obtain(handler, 3), ((long) iJ) * 1000);
            }
            if (com.mbridge.msdk.e.a.f43738a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f43938b.f43928e.c());
                sb2.append(" report failed ");
                sb2.append(sVar.a().size());
                sb2.append(" 剩余事件数：");
                sb2.append(this.f43938b.f43930g.addAndGet(0));
                sb2.append(" 个，数据库记录数：");
                sb2.append(this.f43938b.f43924a.a());
                sb2.append(" 个 连续失败次数： ");
                sb2.append(iJ);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f43939a;

        public b(Looper looper, r rVar) {
            super(looper);
            this.f43939a = rVar;
        }

        private synchronized void a() {
            try {
                r.e(this.f43939a);
            } catch (Exception e11) {
                if (com.mbridge.msdk.e.a.f43738a) {
                    Log.e("TrackManager", this.f43939a.f43928e.c() + " report failed ", e11);
                }
            }
        }

        private void a(String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f43939a.f43928e.c());
            sb2.append(" ");
            sb2.append(str);
            sb2.append(this.f43939a.f43930g.addAndGet(0));
            sb2.append(" 数据库记录数：");
            sb2.append(this.f43939a.f43924a.a());
        }

        private void b() {
            try {
                removeMessages(1);
                removeMessages(6);
                removeMessages(2);
                removeMessages(3);
            } catch (Exception e11) {
                if (com.mbridge.msdk.e.a.f43738a) {
                    Log.e("TrackManager", this.f43939a.f43928e.c() + " removeMessages failed ", e11);
                }
            }
            if (this.f43939a.f()) {
                return;
            }
            try {
                sendMessageDelayed(Message.obtain(this, 1), y.a(this.f43939a.f43929f.get(), this.f43939a.f43934k, this.f43939a.f43926c));
            } catch (Exception e12) {
                if (com.mbridge.msdk.e.a.f43738a) {
                    Log.e("TrackManager", this.f43939a.f43928e.c() + " sendMessageDelayed failed ", e12);
                }
            }
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            int i11 = message.what;
            if (i11 == 2 || i11 == 3) {
                b();
                if (com.mbridge.msdk.e.a.f43738a) {
                    a("触发上报（report result）当前 Event 数量：");
                }
                a();
                return;
            }
            if (i11 == 5) {
                if (com.mbridge.msdk.e.a.f43738a) {
                    a("触发删除 当前 Event 数量：");
                }
                r.a(this.f43939a);
                sendMessageDelayed(Message.obtain(this, 5), 120000L);
                return;
            }
            if (i11 != 6) {
                if (i11 != 7) {
                    b();
                    if (com.mbridge.msdk.e.a.f43738a) {
                        a("触发上报（timer）当前 Event 数量：");
                    }
                    a();
                    return;
                }
                this.f43939a.c();
                b();
                if (com.mbridge.msdk.e.a.f43738a) {
                    a("触发上报（flush）当前 Event 数量：");
                }
                a();
                return;
            }
            Object obj = message.obj;
            e eVar = obj instanceof e ? (e) obj : null;
            if (com.mbridge.msdk.e.a.f43738a && !y.a(eVar)) {
                a(String.format("收到 Event( %s )，当前 Event 数量：", eVar.a()));
            }
            if ((y.b(eVar) && eVar.c() == 1) || this.f43939a.e()) {
                b();
                if (com.mbridge.msdk.e.a.f43738a) {
                    a("触发上报（notice check）当前 Event 数量：");
                }
                a();
            }
        }
    }

    public r(k kVar) {
        this.f43924a = kVar.g();
        this.f43925b = kVar.l();
        this.f43926c = kVar.m();
        this.f43927d = kVar.n();
        this.f43928e = kVar;
    }

    public static /* synthetic */ void a(r rVar) {
        if (com.mbridge.msdk.e.a.f43738a && com.mbridge.msdk.f.e.f43984b) {
            return;
        }
        int iB = rVar.f43924a.b();
        if (com.mbridge.msdk.e.a.f43738a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(rVar.f43928e.c());
            sb2.append(" 删除无效数据的数量 = ");
            sb2.append(iB);
            sb2.append(" 当前剩余事件数 = ");
            sb2.append(rVar.f43930g.addAndGet(0));
            sb2.append(" 数据库中剩余事件数 = ");
            sb2.append(rVar.f43924a.a());
        }
    }

    public static /* synthetic */ void a(r rVar, List list) {
        if (y.a((List<?>) list)) {
            return;
        }
        rVar.f43924a.b((List<i>) list);
    }

    public static /* synthetic */ void b(r rVar, List list) {
        if (y.a((List<?>) list)) {
            return;
        }
        Iterator it = list.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!y.a(iVar)) {
                boolean z11 = !iVar.b() && iVar.d() >= rVar.f43927d;
                boolean z12 = !iVar.a() && iVar.g() < System.currentTimeMillis();
                if (z11 || z12) {
                    iVar.b(-1);
                } else {
                    iVar.a(iVar.d() + (y.a(rVar.f43928e.e()) ? 1 : 0));
                    iVar.b(3);
                    i11++;
                }
            }
        }
        rVar.f43924a.c((List<i>) list);
        rVar.f43930g.addAndGet(i11);
    }

    public static /* synthetic */ void e(r rVar) {
        List<i> listA = rVar.f43924a.a(rVar.f43925b);
        if (y.a((List<?>) listA)) {
            if (com.mbridge.msdk.e.a.f43738a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(rVar.f43928e.c());
                sb2.append(" report: 没有可以上报的数据");
                return;
            }
            return;
        }
        rVar.f43924a.a(listA);
        int size = listA.size();
        rVar.f43930g.addAndGet(-size);
        if (com.mbridge.msdk.e.a.f43738a) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(rVar.f43928e.c());
            sb3.append(" report: 上报的数量 = ");
            sb3.append(size);
            sb3.append(" 当前剩余事件数 = ");
            sb3.append(rVar.f43930g.addAndGet(0));
            sb3.append(" 数据库中剩余事件数 = ");
            sb3.append(rVar.f43924a.a());
        }
        try {
            if (rVar.f43928e.p()) {
                n nVarQ = rVar.f43928e.q();
                nVarQ.a(new a(rVar.f43932i, rVar));
                Map<String, String> map = new HashMap<>();
                try {
                    map = rVar.f43928e.j().a(rVar.f43928e.k(), listA, rVar.f43928e.f());
                } catch (Exception e11) {
                    if (com.mbridge.msdk.e.a.f43738a) {
                        Log.e("TrackManager", rVar.f43928e.c() + " report decorate request params failed ", e11);
                    }
                }
                nVarQ.a(new s(listA), map, y.b(listA));
                return;
            }
        } catch (IllegalStateException e12) {
            if (com.mbridge.msdk.e.a.f43738a) {
                Log.e("TrackManager", rVar.f43928e.c() + " report environment check failed ", e12);
            }
        }
        if (com.mbridge.msdk.e.a.f43738a) {
            Log.e("TrackManager", rVar.f43928e.c() + " report 失败，请检查 TrackConfig 配置是否正确");
        }
    }

    public static /* synthetic */ void i(r rVar) {
        rVar.f43929f.set(0);
    }

    public static /* synthetic */ int j(r rVar) {
        return rVar.f43929f.getAndIncrement();
    }

    public final void a() {
        HandlerThread handlerThread = new HandlerThread("report_timer");
        handlerThread.start();
        b bVar = new b(handlerThread.getLooper(), this);
        this.f43932i = bVar;
        bVar.sendMessageDelayed(Message.obtain(bVar, 5), 5000L);
        Handler handler = this.f43932i;
        handler.sendMessageDelayed(Message.obtain(handler, 1), this.f43926c);
        this.f43933j = false;
    }

    public final void a(e eVar) {
        Handler handler = this.f43932i;
        handler.sendMessage(Message.obtain(handler, 6, eVar));
    }

    public final void b() {
        this.f43932i.removeMessages(1);
        Handler handler = this.f43932i;
        handler.sendMessage(Message.obtain(handler, 7));
    }

    public final void c() {
        synchronized (this.f43931h) {
            try {
                if (!this.f43935l) {
                    this.f43935l = true;
                    this.f43924a.c();
                }
                if (!this.f43936m) {
                    this.f43936m = true;
                    this.f43930g.addAndGet(this.f43924a.a());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void d() {
        this.f43930g.incrementAndGet();
    }

    public final boolean e() {
        return this.f43930g.addAndGet(0) >= this.f43925b;
    }

    public final boolean f() {
        return this.f43933j;
    }
}
