package x6;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements y6.a.b, k, e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LottieDrawable f80272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f80273f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f80275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f80276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final y6.a<?, Float> f80277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y6.a<?, Integer> f80278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<y6.a<?, Float>> f80279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final y6.a<?, Float> f80280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public y6.a<ColorFilter, ColorFilter> f80281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public y6.a<Float, Float> f80282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f80283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public y6.c f80284q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PathMeasure f80268a = new PathMeasure();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f80269b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f80270c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f80271d = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<b> f80274g = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<m> f80285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final u f80286b;

        public b(@Nullable u uVar) {
            this.f80285a = new ArrayList();
            this.f80286b = uVar;
        }
    }

    public a(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f11, b7.d dVar, b7.b bVar, List<b7.b> list, b7.b bVar2) {
        w6.a aVar2 = new w6.a(1);
        this.f80276i = aVar2;
        this.f80283p = 0.0f;
        this.f80272e = lottieDrawable;
        this.f80273f = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f11);
        this.f80278k = dVar.a();
        this.f80277j = bVar.a();
        if (bVar2 == null) {
            this.f80280m = null;
        } else {
            this.f80280m = bVar2.a();
        }
        this.f80279l = new ArrayList(list.size());
        this.f80275h = new float[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f80279l.add(list.get(i11).a());
        }
        aVar.i(this.f80278k);
        aVar.i(this.f80277j);
        for (int i12 = 0; i12 < this.f80279l.size(); i12++) {
            aVar.i(this.f80279l.get(i12));
        }
        y6.a<?, Float> aVar3 = this.f80280m;
        if (aVar3 != null) {
            aVar.i(aVar3);
        }
        this.f80278k.a(this);
        this.f80277j.a(this);
        for (int i13 = 0; i13 < list.size(); i13++) {
            this.f80279l.get(i13).a(this);
        }
        y6.a<?, Float> aVar4 = this.f80280m;
        if (aVar4 != null) {
            aVar4.a(this);
        }
        if (aVar.w() != null) {
            y6.d dVarA = aVar.w().a().a();
            this.f80282o = dVarA;
            dVarA.a(this);
            aVar.i(this.f80282o);
        }
        if (aVar.y() != null) {
            this.f80284q = new y6.c(this, aVar, aVar.y());
        }
    }

    @Override // y6.a.b
    public void b() {
        this.f80272e.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[SYNTHETIC] */
    @Override // x6.c
    public void c(List<c> list, List<c> list2) {
        u uVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof u) {
                u uVar2 = (u) cVar;
                if (uVar2.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    uVar = uVar2;
                }
            }
        }
        if (uVar != null) {
            uVar.d(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof u) {
                u uVar3 = (u) cVar2;
                if (uVar3.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f80274g.add(bVar);
                    }
                    bVar = new b(uVar3);
                    uVar3.d(this);
                } else if (!(cVar2 instanceof m)) {
                    if (bVar == null) {
                        bVar = new b(uVar);
                    }
                    bVar.f80285a.add((m) cVar2);
                }
            } else if (!(cVar2 instanceof m)) {
                if (bVar == null) {
                    bVar = new b(uVar);
                }
                bVar.f80285a.add((m) cVar2);
            }
        }
        if (bVar != null) {
            this.f80274g.add(bVar);
        }
    }

    @Override // a7.e
    @CallSuper
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        y6.c cVar2;
        y6.c cVar3;
        y6.c cVar4;
        y6.c cVar5;
        y6.c cVar6;
        if (t11 == p0.f15270d) {
            this.f80278k.o(cVar);
            return;
        }
        if (t11 == p0.f15285s) {
            this.f80277j.o(cVar);
            return;
        }
        if (t11 == p0.K) {
            y6.a<ColorFilter, ColorFilter> aVar = this.f80281n;
            if (aVar != null) {
                this.f80273f.H(aVar);
            }
            if (cVar == null) {
                this.f80281n = null;
                return;
            }
            y6.q qVar = new y6.q(cVar);
            this.f80281n = qVar;
            qVar.a(this);
            this.f80273f.i(this.f80281n);
            return;
        }
        if (t11 == p0.f15276j) {
            y6.a<Float, Float> aVar2 = this.f80282o;
            if (aVar2 != null) {
                aVar2.o(cVar);
                return;
            }
            y6.q qVar2 = new y6.q(cVar);
            this.f80282o = qVar2;
            qVar2.a(this);
            this.f80273f.i(this.f80282o);
            return;
        }
        if (t11 == p0.f15271e && (cVar6 = this.f80284q) != null) {
            cVar6.c(cVar);
            return;
        }
        if (t11 == p0.G && (cVar5 = this.f80284q) != null) {
            cVar5.f(cVar);
            return;
        }
        if (t11 == p0.H && (cVar4 = this.f80284q) != null) {
            cVar4.d(cVar);
            return;
        }
        if (t11 == p0.I && (cVar3 = this.f80284q) != null) {
            cVar3.e(cVar);
        } else {
            if (t11 != p0.J || (cVar2 = this.f80284q) == null) {
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
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("StrokeContent#getBounds");
        }
        this.f80269b.reset();
        for (int i11 = 0; i11 < this.f80274g.size(); i11++) {
            b bVar = this.f80274g.get(i11);
            for (int i12 = 0; i12 < bVar.f80285a.size(); i12++) {
                this.f80269b.addPath(((m) bVar.f80285a.get(i12)).getPath(), matrix);
            }
        }
        this.f80269b.computeBounds(this.f80271d, false);
        float fQ = ((y6.d) this.f80277j).q();
        RectF rectF2 = this.f80271d;
        float f11 = fQ / 2.0f;
        rectF2.set(rectF2.left - f11, rectF2.top - f11, rectF2.right + f11, rectF2.bottom + f11);
        rectF.set(this.f80271d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("StrokeContent#getBounds");
        }
    }

    public final void g(Matrix matrix) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("StrokeContent#applyDashPattern");
        }
        if (this.f80279l.isEmpty()) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("StrokeContent#applyDashPattern");
                return;
            }
            return;
        }
        float fG = g7.l.g(matrix);
        for (int i11 = 0; i11 < this.f80279l.size(); i11++) {
            this.f80275h[i11] = this.f80279l.get(i11).h().floatValue();
            if (i11 % 2 == 0) {
                float[] fArr = this.f80275h;
                if (fArr[i11] < 1.0f) {
                    fArr[i11] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f80275h;
                if (fArr2[i11] < 0.1f) {
                    fArr2[i11] = 0.1f;
                }
            }
            float[] fArr3 = this.f80275h;
            fArr3[i11] = fArr3[i11] * fG;
        }
        y6.a<?, Float> aVar = this.f80280m;
        this.f80276i.setPathEffect(new DashPathEffect(this.f80275h, aVar == null ? 0.0f : fG * aVar.h().floatValue()));
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("StrokeContent#applyDashPattern");
        }
    }

    @Override // x6.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("StrokeContent#draw");
        }
        if (g7.l.h(matrix)) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("StrokeContent#draw");
                return;
            }
            return;
        }
        int iQ = (int) ((((i11 / 255.0f) * ((y6.f) this.f80278k).q()) / 100.0f) * 255.0f);
        this.f80276i.setAlpha(g7.k.c(iQ, 0, 255));
        this.f80276i.setStrokeWidth(((y6.d) this.f80277j).q() * g7.l.g(matrix));
        if (this.f80276i.getStrokeWidth() <= 0.0f) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("StrokeContent#draw");
                return;
            }
            return;
        }
        g(matrix);
        y6.a<ColorFilter, ColorFilter> aVar = this.f80281n;
        if (aVar != null) {
            this.f80276i.setColorFilter(aVar.h());
        }
        y6.a<Float, Float> aVar2 = this.f80282o;
        if (aVar2 != null) {
            float fFloatValue = aVar2.h().floatValue();
            if (fFloatValue == 0.0f) {
                this.f80276i.setMaskFilter(null);
            } else if (fFloatValue != this.f80283p) {
                this.f80276i.setMaskFilter(this.f80273f.x(fFloatValue));
            }
            this.f80283p = fFloatValue;
        }
        y6.c cVar = this.f80284q;
        if (cVar != null) {
            cVar.a(this.f80276i, matrix, g7.l.l(i11, iQ));
        }
        for (int i12 = 0; i12 < this.f80274g.size(); i12++) {
            b bVar = this.f80274g.get(i12);
            if (bVar.f80286b != null) {
                i(canvas, bVar, matrix);
            } else {
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.b("StrokeContent#buildPath");
                }
                this.f80269b.reset();
                for (int size = bVar.f80285a.size() - 1; size >= 0; size--) {
                    this.f80269b.addPath(((m) bVar.f80285a.get(size)).getPath(), matrix);
                }
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.c("StrokeContent#buildPath");
                    com.airbnb.lottie.d.b("StrokeContent#drawPath");
                }
                canvas.drawPath(this.f80269b, this.f80276i);
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.c("StrokeContent#drawPath");
                }
            }
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("StrokeContent#draw");
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0131  */
    public final void i(Canvas canvas, b bVar, Matrix matrix) {
        float f11;
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("StrokeContent#applyTrimPath");
        }
        if (bVar.f80286b == null) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("StrokeContent#applyTrimPath");
                return;
            }
            return;
        }
        this.f80269b.reset();
        for (int size = bVar.f80285a.size() - 1; size >= 0; size--) {
            this.f80269b.addPath(((m) bVar.f80285a.get(size)).getPath(), matrix);
        }
        float fFloatValue = bVar.f80286b.i().h().floatValue() / 100.0f;
        float fFloatValue2 = bVar.f80286b.e().h().floatValue() / 100.0f;
        float fFloatValue3 = bVar.f80286b.g().h().floatValue() / 360.0f;
        if (fFloatValue < 0.01f && fFloatValue2 > 0.99f) {
            canvas.drawPath(this.f80269b, this.f80276i);
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("StrokeContent#applyTrimPath");
                return;
            }
            return;
        }
        this.f80268a.setPath(this.f80269b, false);
        float length = this.f80268a.getLength();
        while (this.f80268a.nextContour()) {
            length += this.f80268a.getLength();
        }
        float f12 = fFloatValue3 * length;
        float f13 = (fFloatValue * length) + f12;
        float fMin = Math.min((fFloatValue2 * length) + f12, (f13 + length) - 1.0f);
        float f14 = 0.0f;
        for (int size2 = bVar.f80285a.size() - 1; size2 >= 0; size2--) {
            this.f80270c.set(((m) bVar.f80285a.get(size2)).getPath());
            this.f80270c.transform(matrix);
            this.f80268a.setPath(this.f80270c, false);
            float length2 = this.f80268a.getLength();
            if (fMin > length) {
                float f15 = fMin - length;
                if (f15 >= f14 + length2 || f14 >= f15) {
                    f11 = f14 + length2;
                    if (f11 < f13 && f14 <= fMin) {
                        if (f11 > fMin || f13 >= f14) {
                            g7.l.a(this.f80270c, f13 < f14 ? 0.0f : (f13 - f14) / length2, fMin > f11 ? 1.0f : (fMin - f14) / length2, 0.0f);
                            canvas.drawPath(this.f80270c, this.f80276i);
                        } else {
                            canvas.drawPath(this.f80270c, this.f80276i);
                        }
                    }
                } else {
                    g7.l.a(this.f80270c, f13 > length ? (f13 - length) / length2 : 0.0f, Math.min(f15 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f80270c, this.f80276i);
                }
            } else {
                f11 = f14 + length2;
                if (f11 < f13) {
                }
            }
            f14 += length2;
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("StrokeContent#applyTrimPath");
        }
    }
}
