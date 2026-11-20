package x6;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.v;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements e, y6.a.b, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f80320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f80321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f80322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v<LinearGradient> f80323d = new v<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v<RadialGradient> f80324e = new v<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f80325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f80326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f80327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<m> f80328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GradientType f80329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y6.a<c7.d, c7.d> f80330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final y6.a<Integer, Integer> f80331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final y6.a<PointF, PointF> f80332m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final y6.a<PointF, PointF> f80333n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public y6.a<ColorFilter, ColorFilter> f80334o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public y6.q f80335p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LottieDrawable f80336q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f80337r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public y6.a<Float, Float> f80338s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f80339t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public y6.c f80340u;

    public h(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, c7.e eVar) {
        Path path = new Path();
        this.f80325f = path;
        this.f80326g = new w6.a(1);
        this.f80327h = new RectF();
        this.f80328i = new ArrayList();
        this.f80339t = 0.0f;
        this.f80322c = aVar;
        this.f80320a = eVar.f();
        this.f80321b = eVar.i();
        this.f80336q = lottieDrawable;
        this.f80329j = eVar.e();
        path.setFillType(eVar.c());
        this.f80337r = (int) (hVar.d() / 32.0f);
        y6.a<c7.d, c7.d> aVarA = eVar.d().a();
        this.f80330k = aVarA;
        aVarA.a(this);
        aVar.i(aVarA);
        y6.a<Integer, Integer> aVarA2 = eVar.g().a();
        this.f80331l = aVarA2;
        aVarA2.a(this);
        aVar.i(aVarA2);
        y6.a<PointF, PointF> aVarA3 = eVar.h().a();
        this.f80332m = aVarA3;
        aVarA3.a(this);
        aVar.i(aVarA3);
        y6.a<PointF, PointF> aVarA4 = eVar.b().a();
        this.f80333n = aVarA4;
        aVarA4.a(this);
        aVar.i(aVarA4);
        if (aVar.w() != null) {
            y6.d dVarA = aVar.w().a().a();
            this.f80338s = dVarA;
            dVarA.a(this);
            aVar.i(this.f80338s);
        }
        if (aVar.y() != null) {
            this.f80340u = new y6.c(this, aVar, aVar.y());
        }
    }

    private int[] g(int[] iArr) {
        y6.q qVar = this.f80335p;
        if (qVar != null) {
            Integer[] numArr = (Integer[]) qVar.h();
            int i11 = 0;
            if (iArr.length == numArr.length) {
                while (i11 < iArr.length) {
                    iArr[i11] = numArr[i11].intValue();
                    i11++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i11 < numArr.length) {
                    iArr[i11] = numArr[i11].intValue();
                    i11++;
                }
            }
        }
        return iArr;
    }

    private int i() {
        int iRound = Math.round(this.f80332m.f() * this.f80337r);
        int iRound2 = Math.round(this.f80333n.f() * this.f80337r);
        int iRound3 = Math.round(this.f80330k.f() * this.f80337r);
        int i11 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i11 = i11 * 31 * iRound2;
        }
        return iRound3 != 0 ? i11 * 31 * iRound3 : i11;
    }

    private LinearGradient j() {
        long jI = i();
        LinearGradient linearGradientF = this.f80323d.f(jI);
        if (linearGradientF != null) {
            return linearGradientF;
        }
        PointF pointFH = this.f80332m.h();
        PointF pointFH2 = this.f80333n.h();
        c7.d dVarH = this.f80330k.h();
        LinearGradient linearGradient = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, g(dVarH.d()), dVarH.e(), Shader.TileMode.CLAMP);
        this.f80323d.l(jI, linearGradient);
        return linearGradient;
    }

    private RadialGradient k() {
        long jI = i();
        RadialGradient radialGradientF = this.f80324e.f(jI);
        if (radialGradientF != null) {
            return radialGradientF;
        }
        PointF pointFH = this.f80332m.h();
        PointF pointFH2 = this.f80333n.h();
        c7.d dVarH = this.f80330k.h();
        int[] iArrG = g(dVarH.d());
        float[] fArrE = dVarH.e();
        float f11 = pointFH.x;
        float f12 = pointFH.y;
        float fHypot = (float) Math.hypot(pointFH2.x - f11, pointFH2.y - f12);
        RadialGradient radialGradient = new RadialGradient(f11, f12, fHypot <= 0.0f ? 0.001f : fHypot, iArrG, fArrE, Shader.TileMode.CLAMP);
        this.f80324e.l(jI, radialGradient);
        return radialGradient;
    }

    @Override // y6.a.b
    public void b() {
        this.f80336q.invalidateSelf();
    }

    @Override // x6.c
    public void c(List<c> list, List<c> list2) {
        for (int i11 = 0; i11 < list2.size(); i11++) {
            c cVar = list2.get(i11);
            if (cVar instanceof m) {
                this.f80328i.add((m) cVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a7.e
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        y6.c cVar2;
        y6.c cVar3;
        y6.c cVar4;
        y6.c cVar5;
        y6.c cVar6;
        if (t11 == p0.f15270d) {
            this.f80331l.o(cVar);
            return;
        }
        if (t11 == p0.K) {
            y6.a<ColorFilter, ColorFilter> aVar = this.f80334o;
            if (aVar != null) {
                this.f80322c.H(aVar);
            }
            if (cVar == null) {
                this.f80334o = null;
                return;
            }
            y6.q qVar = new y6.q(cVar);
            this.f80334o = qVar;
            qVar.a(this);
            this.f80322c.i(this.f80334o);
            return;
        }
        if (t11 == p0.L) {
            y6.q qVar2 = this.f80335p;
            if (qVar2 != null) {
                this.f80322c.H(qVar2);
            }
            if (cVar == null) {
                this.f80335p = null;
                return;
            }
            this.f80323d.b();
            this.f80324e.b();
            y6.q qVar3 = new y6.q(cVar);
            this.f80335p = qVar3;
            qVar3.a(this);
            this.f80322c.i(this.f80335p);
            return;
        }
        if (t11 == p0.f15276j) {
            y6.a<Float, Float> aVar2 = this.f80338s;
            if (aVar2 != null) {
                aVar2.o(cVar);
                return;
            }
            y6.q qVar4 = new y6.q(cVar);
            this.f80338s = qVar4;
            qVar4.a(this);
            this.f80322c.i(this.f80338s);
            return;
        }
        if (t11 == p0.f15271e && (cVar6 = this.f80340u) != null) {
            cVar6.c(cVar);
            return;
        }
        if (t11 == p0.G && (cVar5 = this.f80340u) != null) {
            cVar5.f(cVar);
            return;
        }
        if (t11 == p0.H && (cVar4 = this.f80340u) != null) {
            cVar4.d(cVar);
            return;
        }
        if (t11 == p0.I && (cVar3 = this.f80340u) != null) {
            cVar3.e(cVar);
        } else {
            if (t11 != p0.J || (cVar2 = this.f80340u) == null) {
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
        this.f80325f.reset();
        for (int i11 = 0; i11 < this.f80328i.size(); i11++) {
            this.f80325f.addPath(this.f80328i.get(i11).getPath(), matrix);
        }
        this.f80325f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // x6.c
    public String getName() {
        return this.f80320a;
    }

    @Override // x6.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        if (this.f80321b) {
            return;
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("GradientFillContent#draw");
        }
        this.f80325f.reset();
        for (int i12 = 0; i12 < this.f80328i.size(); i12++) {
            this.f80325f.addPath(this.f80328i.get(i12).getPath(), matrix);
        }
        this.f80325f.computeBounds(this.f80327h, false);
        Shader shaderJ = this.f80329j == GradientType.LINEAR ? j() : k();
        shaderJ.setLocalMatrix(matrix);
        this.f80326g.setShader(shaderJ);
        y6.a<ColorFilter, ColorFilter> aVar = this.f80334o;
        if (aVar != null) {
            this.f80326g.setColorFilter(aVar.h());
        }
        y6.a<Float, Float> aVar2 = this.f80338s;
        if (aVar2 != null) {
            float fFloatValue = aVar2.h().floatValue();
            if (fFloatValue == 0.0f) {
                this.f80326g.setMaskFilter(null);
            } else if (fFloatValue != this.f80339t) {
                this.f80326g.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f80339t = fFloatValue;
        }
        int iIntValue = (int) ((((i11 / 255.0f) * this.f80331l.h().intValue()) / 100.0f) * 255.0f);
        this.f80326g.setAlpha(g7.k.c(iIntValue, 0, 255));
        y6.c cVar = this.f80340u;
        if (cVar != null) {
            cVar.a(this.f80326g, matrix, g7.l.l(i11, iIntValue));
        }
        canvas.drawPath(this.f80325f, this.f80326g);
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("GradientFillContent#draw");
        }
    }
}
