package x6;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.v;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.p0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends a {
    public final y6.a<PointF, PointF> A;

    @Nullable
    public y6.q B;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f80341r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f80342s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final v<LinearGradient> f80343t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final v<RadialGradient> f80344u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f80345v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final GradientType f80346w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f80347x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final y6.a<c7.d, c7.d> f80348y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final y6.a<PointF, PointF> f80349z;

    public i(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        super(lottieDrawable, aVar, aVar2.b().toPaintCap(), aVar2.g().toPaintJoin(), aVar2.i(), aVar2.k(), aVar2.m(), aVar2.h(), aVar2.c());
        this.f80343t = new v<>();
        this.f80344u = new v<>();
        this.f80345v = new RectF();
        this.f80341r = aVar2.j();
        this.f80346w = aVar2.f();
        this.f80342s = aVar2.n();
        this.f80347x = (int) (lottieDrawable.O().d() / 32.0f);
        y6.a<c7.d, c7.d> aVarA = aVar2.e().a();
        this.f80348y = aVarA;
        aVarA.a(this);
        aVar.i(aVarA);
        y6.a<PointF, PointF> aVarA2 = aVar2.l().a();
        this.f80349z = aVarA2;
        aVarA2.a(this);
        aVar.i(aVarA2);
        y6.a<PointF, PointF> aVarA3 = aVar2.d().a();
        this.A = aVarA3;
        aVarA3.a(this);
        aVar.i(aVarA3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x6.a, a7.e
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        super.d(t11, cVar);
        if (t11 == p0.L) {
            y6.q qVar = this.B;
            if (qVar != null) {
                this.f80273f.H(qVar);
            }
            if (cVar == null) {
                this.B = null;
                return;
            }
            y6.q qVar2 = new y6.q(cVar);
            this.B = qVar2;
            qVar2.a(this);
            this.f80273f.i(this.B);
        }
    }

    @Override // x6.c
    public String getName() {
        return this.f80341r;
    }

    @Override // x6.a, x6.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        if (this.f80342s) {
            return;
        }
        f(this.f80345v, matrix, false);
        Shader shaderL = this.f80346w == GradientType.LINEAR ? l() : m();
        shaderL.setLocalMatrix(matrix);
        this.f80276i.setShader(shaderL);
        super.h(canvas, matrix, i11);
    }

    public final int[] j(int[] iArr) {
        y6.q qVar = this.B;
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

    public final int k() {
        int iRound = Math.round(this.f80349z.f() * this.f80347x);
        int iRound2 = Math.round(this.A.f() * this.f80347x);
        int iRound3 = Math.round(this.f80348y.f() * this.f80347x);
        int i11 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i11 = i11 * 31 * iRound2;
        }
        return iRound3 != 0 ? i11 * 31 * iRound3 : i11;
    }

    public final LinearGradient l() {
        long jK = k();
        LinearGradient linearGradientF = this.f80343t.f(jK);
        if (linearGradientF != null) {
            return linearGradientF;
        }
        PointF pointFH = this.f80349z.h();
        PointF pointFH2 = this.A.h();
        c7.d dVarH = this.f80348y.h();
        LinearGradient linearGradient = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, j(dVarH.d()), dVarH.e(), Shader.TileMode.CLAMP);
        this.f80343t.l(jK, linearGradient);
        return linearGradient;
    }

    public final RadialGradient m() {
        long jK = k();
        RadialGradient radialGradientF = this.f80344u.f(jK);
        if (radialGradientF != null) {
            return radialGradientF;
        }
        PointF pointFH = this.f80349z.h();
        PointF pointFH2 = this.A.h();
        c7.d dVarH = this.f80348y.h();
        int[] iArrJ = j(dVarH.d());
        float[] fArrE = dVarH.e();
        float f11 = pointFH.x;
        float f12 = pointFH.y;
        RadialGradient radialGradient = new RadialGradient(f11, f12, (float) Math.hypot(pointFH2.x - f11, pointFH2.y - f12), iArrJ, fArrE, Shader.TileMode.CLAMP);
        this.f80344u.l(jK, radialGradient);
        return radialGradient;
    }
}
