package x6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class p implements e, m, j, y6.a.b, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f80387a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f80388b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieDrawable f80389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f80390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f80391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f80392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y6.a<Float, Float> f80393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y6.a<Float, Float> f80394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final y6.p f80395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f80396j;

    public p(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, c7.g gVar) {
        this.f80389c = lottieDrawable;
        this.f80390d = aVar;
        this.f80391e = gVar.c();
        this.f80392f = gVar.f();
        y6.d dVarA = gVar.b().a();
        this.f80393g = dVarA;
        aVar.i(dVarA);
        dVarA.a(this);
        y6.d dVarA2 = gVar.d().a();
        this.f80394h = dVarA2;
        aVar.i(dVarA2);
        dVarA2.a(this);
        y6.p pVarB = gVar.e().b();
        this.f80395i = pVarB;
        pVarB.a(aVar);
        pVarB.b(this);
    }

    @Override // y6.a.b
    public void b() {
        this.f80389c.invalidateSelf();
    }

    @Override // x6.c
    public void c(List<c> list, List<c> list2) {
        this.f80396j.c(list, list2);
    }

    @Override // a7.e
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        if (this.f80395i.c(t11, cVar)) {
            return;
        }
        if (t11 == p0.f15287u) {
            this.f80393g.o(cVar);
        } else if (t11 == p0.f15288v) {
            this.f80394h.o(cVar);
        }
    }

    @Override // a7.e
    public void e(a7.d dVar, int i11, List<a7.d> list, a7.d dVar2) {
        g7.k.k(dVar, i11, list, dVar2, this);
        for (int i12 = 0; i12 < this.f80396j.j().size(); i12++) {
            c cVar = this.f80396j.j().get(i12);
            if (cVar instanceof k) {
                g7.k.k(dVar, i11, list, dVar2, (k) cVar);
            }
        }
    }

    @Override // x6.e
    public void f(RectF rectF, Matrix matrix, boolean z11) {
        this.f80396j.f(rectF, matrix, z11);
    }

    @Override // x6.j
    public void g(ListIterator<c> listIterator) {
        if (this.f80396j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f80396j = new d(this.f80389c, this.f80390d, "Repeater", this.f80392f, arrayList, null);
    }

    @Override // x6.c
    public String getName() {
        return this.f80391e;
    }

    @Override // x6.m
    public Path getPath() {
        Path path = this.f80396j.getPath();
        this.f80388b.reset();
        float fFloatValue = this.f80393g.h().floatValue();
        float fFloatValue2 = this.f80394h.h().floatValue();
        for (int i11 = ((int) fFloatValue) - 1; i11 >= 0; i11--) {
            this.f80387a.set(this.f80395i.g(i11 + fFloatValue2));
            this.f80388b.addPath(path, this.f80387a);
        }
        return this.f80388b;
    }

    @Override // x6.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        float fFloatValue = this.f80393g.h().floatValue();
        float fFloatValue2 = this.f80394h.h().floatValue();
        float fFloatValue3 = this.f80395i.i().h().floatValue() / 100.0f;
        float fFloatValue4 = this.f80395i.e().h().floatValue() / 100.0f;
        for (int i12 = ((int) fFloatValue) - 1; i12 >= 0; i12--) {
            this.f80387a.set(matrix);
            float f11 = i12;
            this.f80387a.preConcat(this.f80395i.g(f11 + fFloatValue2));
            this.f80396j.h(canvas, this.f80387a, (int) (i11 * g7.k.i(fFloatValue3, fFloatValue4, f11 / fFloatValue)));
        }
    }
}
