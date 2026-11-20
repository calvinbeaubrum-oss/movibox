package fo;

import android.content.Context;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends p007do.n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f65173g = TimeUnit.MINUTES.toSeconds(5);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h[] f65174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f65175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.google.common.util.concurrent.s f65176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f65177f;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends do.n.a<f> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f65178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HashMap f65179c;

        public a() {
            super(f.class);
            this.f65178b = f.f65173g;
            this.f65179c = new HashMap();
        }

        public /* synthetic */ a(int i11) {
            this();
        }

        @Override // do.n.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public f b(p007do.m mVar, Context context) {
            return new f(mVar, context, this, 0);
        }
    }

    public f(p007do.m mVar, Context context, a aVar) {
        super("device", mVar);
        h[] hVarArr = (h[]) aVar.f65179c.values().toArray(new h[0]);
        if (hVarArr.length == 0) {
            try {
                hVarArr = new h[]{g.a(context)};
            } catch (UnsupportedOperationException unused) {
            }
        }
        this.f65174c = hVarArr;
        this.f65175d = aVar.f65178b;
    }

    public /* synthetic */ f(p007do.m mVar, Context context, a aVar, int i11) {
        this(mVar, context, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            Context contextQ = d().q();
            d.a aVarO = this.f65177f.o();
            u.m(aVarO, contextQ);
            u.j(aVarO, contextQ);
            u.h(aVarO, contextQ);
            u.l(aVarO, contextQ);
            u.k(aVarO, contextQ);
            h(aVarO, contextQ);
            d dVarF = aVarO.n(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())).f();
            this.f65177f = dVarF;
            c(dVarF);
        } catch (IllegalStateException unused) {
        }
    }

    public static a ofProvider() {
        return new a(0);
    }

    @Override // p007do.n
    public void a() {
        com.google.common.util.concurrent.s sVar = this.f65176e;
        this.f65176e = null;
        io.g.c(sVar);
    }

    @Override // p007do.n
    public void e(Context context) {
        d.a aVarI = u.i(context);
        h(aVarI, context);
        d dVarF = aVarI.n(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())).f();
        this.f65177f = dVarF;
        c(dVarF);
        p007do.m mVarD = d();
        Runnable runnable = new Runnable() { // from class: fo.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f65172a.i();
            }
        };
        long j11 = this.f65175d;
        this.f65176e = mVarD.I(runnable, j11, j11, TimeUnit.SECONDS);
    }

    public final void h(d.a aVar, Context context) {
        h.a aVarB;
        ArrayList arrayList = new ArrayList();
        boolean zB = false;
        for (h hVar : this.f65174c) {
            try {
                aVarB = hVar.b(d(), context);
            } catch (Exception unused) {
                aVarB = null;
            }
            if (aVarB != null) {
                zB |= aVarB.b();
                if (!aVarB.a().isEmpty()) {
                    arrayList.add(new Pair(hVar.a(), aVarB.a()));
                }
            }
        }
        aVar.g(4, zB).h(arrayList);
    }

    public d j() {
        return this.f65177f;
    }
}
