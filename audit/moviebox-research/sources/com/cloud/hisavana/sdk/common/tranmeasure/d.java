package com.cloud.hisavana.sdk.common.tranmeasure;

import android.view.View;
import com.cloud.hisavana.sdk.b2;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.t;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f29479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b<T> f29480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<View> f29481c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b2 f29483e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.cloud.hisavana.sdk.common.tranmeasure.c f29486h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29482d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f29484f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicBoolean f29485g = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c().f(d.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T> {
        void a(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class c<T> implements Preconditions.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<d<T>> f29488a;

        public c(d<T> dVar) {
            this.f29488a = new WeakReference<>(dVar);
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            d<T> dVar;
            WeakReference<d<T>> weakReference = this.f29488a;
            if (weakReference == null || (dVar = weakReference.get()) == null) {
                return;
            }
            b<T> bVar = dVar.f29480b;
            T tG = dVar.g();
            if (bVar == null || tG == null) {
                return;
            }
            z.a().d("ssp", "----------------> 曝光回调");
            bVar.a(tG);
        }
    }

    public d(T t11) {
        b2 b2Var = new b2();
        this.f29483e = b2Var;
        b2Var.f29199c = 1000;
        b2Var.f29197a = 50.0f;
        b2Var.f29198b = 0;
        this.f29479a = t11;
        this.f29486h = new com.cloud.hisavana.sdk.common.tranmeasure.c(this);
    }

    public void a() {
        WeakReference<View> weakReference = this.f29481c;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f29480b = null;
        t.a().b(new a());
    }

    public void b(View view, b<T> bVar) {
        z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "MeasureSession registerView,isImpression = " + this.f29482d);
        if (this.f29482d) {
            return;
        }
        this.f29481c = new WeakReference<>(view);
        this.f29480b = bVar;
        e.c().d(this);
        com.cloud.hisavana.sdk.common.tranmeasure.c cVar = this.f29486h;
        if (cVar == null || cVar.d() <= 0 || this.f29482d) {
            return;
        }
        if (this.f29480b != null) {
            AdsDTO adsDTOE = e();
            if (adsDTOE != null && view != null) {
                adsDTOE.setImageWidth(Integer.valueOf(view.getMeasuredWidth()));
                adsDTOE.setImageHeight(Integer.valueOf(view.getMeasuredHeight()));
            }
            Preconditions.d(new c(this));
            this.f29482d = true;
        }
        AdsDTO adsDTOE2 = e();
        if (adsDTOE2 != null) {
            adsDTOE2.setShowReportTimeType(1);
            com.cloud.hisavana.sdk.f.a(adsDTOE2);
        }
    }

    public void c(boolean z11) {
        this.f29482d = z11;
    }

    public boolean d(T t11) {
        return this.f29479a == t11;
    }

    public AdsDTO e() {
        T t11 = this.f29479a;
        if (t11 instanceof AdsDTO) {
            return (AdsDTO) t11;
        }
        if (t11 instanceof TaNativeInfo) {
            return ((TaNativeInfo) t11).getAdItem();
        }
        return null;
    }

    public View f() {
        WeakReference<View> weakReference = this.f29481c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public T g() {
        return this.f29479a;
    }

    public boolean h() {
        return this.f29482d;
    }

    public boolean i() {
        return this.f29485g.get();
    }

    public void j() {
        com.cloud.hisavana.sdk.common.tranmeasure.c cVar = this.f29486h;
        if (cVar != null) {
            cVar.c();
        }
    }
}
