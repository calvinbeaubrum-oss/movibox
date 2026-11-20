package x6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements e, m, y6.a.b, a7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f80288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f80289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f80290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f80291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f80292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f80293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f80294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<c> f80295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LottieDrawable f80296i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public List<m> f80297j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public y6.p f80298k;

    public d(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, c7.k kVar, com.airbnb.lottie.h hVar) {
        this(lottieDrawable, aVar, kVar.c(), kVar.d(), g(lottieDrawable, hVar, aVar, kVar.b()), i(kVar.b()));
    }

    public d(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, String str, boolean z11, List<c> list, @Nullable b7.n nVar) {
        this.f80288a = new w6.a();
        this.f80289b = new RectF();
        this.f80290c = new Matrix();
        this.f80291d = new Path();
        this.f80292e = new RectF();
        this.f80293f = str;
        this.f80296i = lottieDrawable;
        this.f80294g = z11;
        this.f80295h = list;
        if (nVar != null) {
            y6.p pVarB = nVar.b();
            this.f80298k = pVarB;
            pVarB.a(aVar);
            this.f80298k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).g(list.listIterator(list.size()));
        }
    }

    public static List<c> g(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, List<c7.c> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            c cVarA = list.get(i11).a(lottieDrawable, hVar, aVar);
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return arrayList;
    }

    @Nullable
    public static b7.n i(List<c7.c> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            c7.c cVar = list.get(i11);
            if (cVar instanceof b7.n) {
                return (b7.n) cVar;
            }
        }
        return null;
    }

    @Override // y6.a.b
    public void b() {
        this.f80296i.invalidateSelf();
    }

    @Override // x6.c
    public void c(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f80295h.size());
        arrayList.addAll(list);
        for (int size = this.f80295h.size() - 1; size >= 0; size--) {
            c cVar = this.f80295h.get(size);
            cVar.c(arrayList, this.f80295h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // a7.e
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        y6.p pVar = this.f80298k;
        if (pVar != null) {
            pVar.c(t11, cVar);
        }
    }

    @Override // a7.e
    public void e(a7.d dVar, int i11, List<a7.d> list, a7.d dVar2) {
        if (dVar.g(getName(), i11) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.a(getName());
                if (dVar.c(getName(), i11)) {
                    list.add(dVar2.i(this));
                }
            }
            if (dVar.h(getName(), i11)) {
                int iE = i11 + dVar.e(getName(), i11);
                for (int i12 = 0; i12 < this.f80295h.size(); i12++) {
                    c cVar = this.f80295h.get(i12);
                    if (cVar instanceof a7.e) {
                        ((a7.e) cVar).e(dVar, iE, list, dVar2);
                    }
                }
            }
        }
    }

    @Override // x6.e
    public void f(RectF rectF, Matrix matrix, boolean z11) {
        this.f80290c.set(matrix);
        y6.p pVar = this.f80298k;
        if (pVar != null) {
            this.f80290c.preConcat(pVar.f());
        }
        this.f80292e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f80295h.size() - 1; size >= 0; size--) {
            c cVar = this.f80295h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).f(this.f80292e, this.f80290c, z11);
                rectF.union(this.f80292e);
            }
        }
    }

    @Override // x6.c
    public String getName() {
        return this.f80293f;
    }

    @Override // x6.m
    public Path getPath() {
        this.f80290c.reset();
        y6.p pVar = this.f80298k;
        if (pVar != null) {
            this.f80290c.set(pVar.f());
        }
        this.f80291d.reset();
        if (this.f80294g) {
            return this.f80291d;
        }
        for (int size = this.f80295h.size() - 1; size >= 0; size--) {
            c cVar = this.f80295h.get(size);
            if (cVar instanceof m) {
                this.f80291d.addPath(((m) cVar).getPath(), this.f80290c);
            }
        }
        return this.f80291d;
    }

    @Override // x6.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        if (this.f80294g) {
            return;
        }
        this.f80290c.set(matrix);
        y6.p pVar = this.f80298k;
        if (pVar != null) {
            this.f80290c.preConcat(pVar.f());
            i11 = (int) (((((this.f80298k.h() == null ? 100 : this.f80298k.h().h().intValue()) / 100.0f) * i11) / 255.0f) * 255.0f);
        }
        boolean z11 = this.f80296i.m0() && m() && i11 != 255;
        if (z11) {
            this.f80289b.set(0.0f, 0.0f, 0.0f, 0.0f);
            f(this.f80289b, this.f80290c, true);
            this.f80288a.setAlpha(i11);
            g7.l.n(canvas, this.f80289b, this.f80288a);
        }
        if (z11) {
            i11 = 255;
        }
        for (int size = this.f80295h.size() - 1; size >= 0; size--) {
            c cVar = this.f80295h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).h(canvas, this.f80290c, i11);
            }
        }
        if (z11) {
            canvas.restore();
        }
    }

    public List<c> j() {
        return this.f80295h;
    }

    public List<m> k() {
        if (this.f80297j == null) {
            this.f80297j = new ArrayList();
            for (int i11 = 0; i11 < this.f80295h.size(); i11++) {
                c cVar = this.f80295h.get(i11);
                if (cVar instanceof m) {
                    this.f80297j.add((m) cVar);
                }
            }
        }
        return this.f80297j;
    }

    public Matrix l() {
        y6.p pVar = this.f80298k;
        if (pVar != null) {
            return pVar.f();
        }
        this.f80290c.reset();
        return this.f80290c;
    }

    public final boolean m() {
        int i11 = 0;
        for (int i12 = 0; i12 < this.f80295h.size(); i12++) {
            if ((this.f80295h.get(i12) instanceof e) && (i11 = i11 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }
}
