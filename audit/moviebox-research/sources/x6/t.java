package x6;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.p0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f80408r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f80409s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f80410t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final y6.a<Integer, Integer> f80411u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public y6.a<ColorFilter, ColorFilter> f80412v;

    public t(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(lottieDrawable, aVar, shapeStroke.b().toPaintCap(), shapeStroke.e().toPaintJoin(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.f80408r = aVar;
        this.f80409s = shapeStroke.h();
        this.f80410t = shapeStroke.k();
        y6.a<Integer, Integer> aVarA = shapeStroke.c().a();
        this.f80411u = aVarA;
        aVarA.a(this);
        aVar.i(aVarA);
    }

    @Override // x6.a, a7.e
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        super.d(t11, cVar);
        if (t11 == p0.f15268b) {
            this.f80411u.o(cVar);
            return;
        }
        if (t11 == p0.K) {
            y6.a<ColorFilter, ColorFilter> aVar = this.f80412v;
            if (aVar != null) {
                this.f80408r.H(aVar);
            }
            if (cVar == null) {
                this.f80412v = null;
                return;
            }
            y6.q qVar = new y6.q(cVar);
            this.f80412v = qVar;
            qVar.a(this);
            this.f80408r.i(this.f80411u);
        }
    }

    @Override // x6.c
    public String getName() {
        return this.f80409s;
    }

    @Override // x6.a, x6.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        if (this.f80410t) {
            return;
        }
        this.f80276i.setColor(((y6.b) this.f80411u).q());
        y6.a<ColorFilter, ColorFilter> aVar = this.f80412v;
        if (aVar != null) {
            this.f80276i.setColorFilter(aVar.h());
        }
        super.h(canvas, matrix, i11);
    }
}
