package x6;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements e, y6.a.b, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f80307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f80308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f80309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f80310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f80311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<m> f80312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y6.a<Integer, Integer> f80313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y6.a<Integer, Integer> f80314h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public y6.a<ColorFilter, ColorFilter> f80315i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LottieDrawable f80316j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public y6.a<Float, Float> f80317k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f80318l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public y6.c f80319m;

    public g(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, c7.j jVar) {
        Path path = new Path();
        this.f80307a = path;
        this.f80308b = new w6.a(1);
        this.f80312f = new ArrayList();
        this.f80309c = aVar;
        this.f80310d = jVar.d();
        this.f80311e = jVar.f();
        this.f80316j = lottieDrawable;
        if (aVar.w() != null) {
            y6.d dVarA = aVar.w().a().a();
            this.f80317k = dVarA;
            dVarA.a(this);
            aVar.i(this.f80317k);
        }
        if (aVar.y() != null) {
            this.f80319m = new y6.c(this, aVar, aVar.y());
        }
        if (jVar.b() == null || jVar.e() == null) {
            this.f80313g = null;
            this.f80314h = null;
            return;
        }
        path.setFillType(jVar.c());
        y6.a<Integer, Integer> aVarA = jVar.b().a();
        this.f80313g = aVarA;
        aVarA.a(this);
        aVar.i(aVarA);
        y6.a<Integer, Integer> aVarA2 = jVar.e().a();
        this.f80314h = aVarA2;
        aVarA2.a(this);
        aVar.i(aVarA2);
    }

    @Override // y6.a.b
    public void b() {
        this.f80316j.invalidateSelf();
    }

    @Override // x6.c
    public void c(List<c> list, List<c> list2) {
        for (int i11 = 0; i11 < list2.size(); i11++) {
            c cVar = list2.get(i11);
            if (cVar instanceof m) {
                this.f80312f.add((m) cVar);
            }
        }
    }

    @Override // a7.e
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        y6.c cVar2;
        y6.c cVar3;
        y6.c cVar4;
        y6.c cVar5;
        y6.c cVar6;
        if (t11 == p0.f15267a) {
            this.f80313g.o(cVar);
            return;
        }
        if (t11 == p0.f15270d) {
            this.f80314h.o(cVar);
            return;
        }
        if (t11 == p0.K) {
            y6.a<ColorFilter, ColorFilter> aVar = this.f80315i;
            if (aVar != null) {
                this.f80309c.H(aVar);
            }
            if (cVar == null) {
                this.f80315i = null;
                return;
            }
            y6.q qVar = new y6.q(cVar);
            this.f80315i = qVar;
            qVar.a(this);
            this.f80309c.i(this.f80315i);
            return;
        }
        if (t11 == p0.f15276j) {
            y6.a<Float, Float> aVar2 = this.f80317k;
            if (aVar2 != null) {
                aVar2.o(cVar);
                return;
            }
            y6.q qVar2 = new y6.q(cVar);
            this.f80317k = qVar2;
            qVar2.a(this);
            this.f80309c.i(this.f80317k);
            return;
        }
        if (t11 == p0.f15271e && (cVar6 = this.f80319m) != null) {
            cVar6.c(cVar);
            return;
        }
        if (t11 == p0.G && (cVar5 = this.f80319m) != null) {
            cVar5.f(cVar);
            return;
        }
        if (t11 == p0.H && (cVar4 = this.f80319m) != null) {
            cVar4.d(cVar);
            return;
        }
        if (t11 == p0.I && (cVar3 = this.f80319m) != null) {
            cVar3.e(cVar);
        } else {
            if (t11 != p0.J || (cVar2 = this.f80319m) == null) {
                return;
            }
            cVar2.g(cVar);
        }
    }

    @Override // a7.e
    public void e(a7.d dVar, int i11, List<a7.d> list, a7.d dVar2) {
        g7.k.k(dVar, i11, list, dVar2, this);
    }

    @Override // x6.e
    public void f(RectF rectF, Matrix matrix, boolean z11) {
        this.f80307a.reset();
        for (int i11 = 0; i11 < this.f80312f.size(); i11++) {
            this.f80307a.addPath(this.f80312f.get(i11).getPath(), matrix);
        }
        this.f80307a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // x6.c
    public String getName() {
        return this.f80310d;
    }

    @Override // x6.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        if (this.f80311e) {
            return;
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("FillContent#draw");
        }
        int iQ = ((y6.b) this.f80313g).q();
        int iIntValue = (int) ((((i11 / 255.0f) * this.f80314h.h().intValue()) / 100.0f) * 255.0f);
        this.f80308b.setColor((iQ & 16777215) | (g7.k.c(iIntValue, 0, 255) << 24));
        y6.a<ColorFilter, ColorFilter> aVar = this.f80315i;
        if (aVar != null) {
            this.f80308b.setColorFilter(aVar.h());
        }
        y6.a<Float, Float> aVar2 = this.f80317k;
        if (aVar2 != null) {
            float fFloatValue = aVar2.h().floatValue();
            if (fFloatValue == 0.0f) {
                this.f80308b.setMaskFilter(null);
            } else if (fFloatValue != this.f80318l) {
                this.f80308b.setMaskFilter(this.f80309c.x(fFloatValue));
            }
            this.f80318l = fFloatValue;
        }
        y6.c cVar = this.f80319m;
        if (cVar != null) {
            cVar.a(this.f80308b, matrix, g7.l.l(i11, iIntValue));
        }
        this.f80307a.reset();
        for (int i12 = 0; i12 < this.f80312f.size(); i12++) {
            this.f80307a.addPath(this.f80312f.get(i12).getPath(), matrix);
        }
        canvas.drawPath(this.f80307a, this.f80308b);
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("FillContent#draw");
        }
    }
}
