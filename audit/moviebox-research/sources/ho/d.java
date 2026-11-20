package ho;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends p007do.n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f66659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConnectivityManager f66660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TelephonyManager f66661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IdentityHashMap f66662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f66663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o[] f66664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ho.a f66665i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.google.common.util.concurrent.s f66666j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.google.common.util.concurrent.t f66667k;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends do.n.a<d> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f66668b;

        public a() {
            super(d.class);
            this.f66668b = 30L;
        }

        public /* synthetic */ a(int i11) {
            this();
        }

        @Override // do.n.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public d b(p007do.m mVar, Context context) {
            return new d(mVar, context, this, 0);
        }
    }

    public d(p007do.m mVar, Context context, a aVar) {
        super("connectivity", mVar);
        this.f66659c = aVar.f66668b;
        this.f66660d = (ConnectivityManager) io.a.e(context, ConnectivityManager.class, "connectivity");
        this.f66661e = io.a.d(context, "android.hardware.telephony") ? (TelephonyManager) io.a.e(context, TelephonyManager.class, "phone") : null;
        this.f66662f = new IdentityHashMap();
        this.f66663g = new LinkedHashMap();
    }

    public /* synthetic */ d(p007do.m mVar, Context context, a aVar, int i11) {
        this(mVar, context, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        synchronized (this) {
            try {
                Iterator it = this.f66662f.keySet().iterator();
                while (it.hasNext()) {
                    k((o) it.next());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static a ofProvider() {
        return new a(0);
    }

    @Override // p007do.n
    public void a() {
        o[] oVarArr;
        ArrayList arrayList = new ArrayList(2);
        synchronized (this) {
            try {
                oVarArr = this.f66664h;
                this.f66662f.clear();
                this.f66663g.clear();
                this.f66664h = null;
                com.google.common.util.concurrent.s sVar = this.f66666j;
                if (sVar != null) {
                    arrayList.add(sVar);
                    this.f66666j = null;
                }
                com.google.common.util.concurrent.t tVar = this.f66667k;
                if (tVar != null) {
                    arrayList.add(tVar);
                    this.f66667k = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        io.g.d(arrayList);
        if (oVarArr != null) {
            for (o oVar : oVarArr) {
                try {
                    oVar.close();
                } catch (Exception e11) {
                    Log.w("ConnectivityModule", "failed to close updater", e11);
                }
            }
        }
    }

    @Override // p007do.n
    public void e(Context context) {
        ArrayList<o> arrayList = new ArrayList();
        if (this.f66660d != null) {
            arrayList.add(Build.VERSION.SDK_INT >= 24 ? new u(this) : new r(this));
        }
        if (this.f66661e != null) {
            int i11 = Build.VERSION.SDK_INT;
            arrayList.add(i11 >= 31 ? new n1(this, context) : i11 >= 22 ? new l1(this, context) : new q0(this));
        }
        for (o oVar : arrayList) {
        }
        this.f66664h = (o[]) arrayList.toArray(new o[0]);
        ho.a.AbstractC0700a abstractC0700aI = ho.a.i();
        for (o oVar2 : this.f66664h) {
            j(abstractC0700aI, context, oVar2, false);
        }
        if (this.f66661e != null && io.a.c(context, "android.permission.READ_PHONE_STATE")) {
            abstractC0700aI.i(com.google.common.base.p.e(this.f66661e.getMmsUserAgent()));
        }
        ho.a aVarE = abstractC0700aI.l(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())).e();
        this.f66665i = aVarE;
        c(aVarE);
        com.google.common.util.concurrent.v vVarN = d().n();
        Runnable runnable = new Runnable() { // from class: ho.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f66657a.l();
            }
        };
        long j11 = this.f66659c;
        this.f66667k = vVarN.scheduleWithFixedDelay(runnable, j11, j11, TimeUnit.SECONDS);
    }

    public final ConnectivityManager h() {
        return this.f66660d;
    }

    public final void i(Context context) {
        o oVar;
        boolean zContainsKey;
        ho.a.AbstractC0700a abstractC0700aL = this.f66665i.l();
        while (true) {
            synchronized (this) {
                try {
                    if (this.f66666j != null) {
                        Iterator it = this.f66663g.keySet().iterator();
                        if (it.hasNext()) {
                            oVar = (o) it.next();
                            this.f66663g.remove(oVar);
                            zContainsKey = this.f66662f.containsKey(oVar);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            j(abstractC0700aL, context, oVar, zContainsKey);
        }
        ho.a aVarE = abstractC0700aL.l(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())).e();
        this.f66665i = aVarE;
        c(aVarE);
    }

    public final void j(ho.a.AbstractC0700a abstractC0700a, Context context, o oVar, boolean z11) {
        boolean zV;
        try {
            zV = oVar.v(abstractC0700a, context);
        } catch (Throwable th2) {
            Log.w("ConnectivityModule", "descriptor updater failed", th2);
            zV = false;
        }
        if (z11 && zV) {
            synchronized (this) {
                this.f66662f.remove(oVar);
            }
        } else {
            if (z11 || zV) {
                return;
            }
            synchronized (this) {
                this.f66662f.put(oVar, Boolean.TRUE);
            }
        }
    }

    public final void k(o oVar) {
        synchronized (this) {
            try {
                if (this.f66664h == null) {
                    return;
                }
                if (this.f66666j != null) {
                    return;
                }
                try {
                    this.f66666j = d().H(new c(this));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final TelephonyManager m() {
        return this.f66661e;
    }

    public final void n() {
        if (this.f66665i == null) {
            synchronized (this) {
                try {
                    if (this.f66666j != null) {
                        this.f66666j = d().n().schedule((Runnable) new c(this), 10L, TimeUnit.MILLISECONDS);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return;
        }
        try {
            try {
                i(d().q());
            } catch (Throwable th3) {
                try {
                    Log.w("ConnectivityModule", "descriptor update failed", th3);
                } finally {
                    this.f66666j = null;
                }
            }
        } catch (IllegalStateException unused) {
            this.f66666j = null;
        }
    }

    public ho.a o() {
        return this.f66665i;
    }
}
