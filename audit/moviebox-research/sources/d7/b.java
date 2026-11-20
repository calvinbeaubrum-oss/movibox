package d7;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.l0;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.p0;
import g7.l;
import y6.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends com.airbnb.lottie.model.layer.a {
    public final Paint E;
    public final Rect F;
    public final Rect G;

    @Nullable
    public final l0 H;

    @Nullable
    public y6.a<ColorFilter, ColorFilter> I;

    @Nullable
    public y6.a<Bitmap, Bitmap> J;

    @Nullable
    public y6.c K;

    public b(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.E = new w6.a(3);
        this.F = new Rect();
        this.G = new Rect();
        this.H = lottieDrawable.U(layer.n());
        if (y() != null) {
            this.K = new y6.c(this, this, y());
        }
    }

    @Nullable
    public final Bitmap P() {
        Bitmap bitmapH;
        y6.a<Bitmap, Bitmap> aVar = this.J;
        if (aVar != null && (bitmapH = aVar.h()) != null) {
            return bitmapH;
        }
        Bitmap bitmapL = this.f15246p.L(this.f15247q.n());
        if (bitmapL != null) {
            return bitmapL;
        }
        l0 l0Var = this.H;
        if (l0Var != null) {
            return l0Var.b();
        }
        return null;
    }

    @Override // com.airbnb.lottie.model.layer.a, a7.e
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        super.d(t11, cVar);
        if (t11 == p0.K) {
            if (cVar == null) {
                this.I = null;
                return;
            } else {
                this.I = new q(cVar);
                return;
            }
        }
        if (t11 == p0.N) {
            if (cVar == null) {
                this.J = null;
            } else {
                this.J = new q(cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, x6.e
    public void f(RectF rectF, Matrix matrix, boolean z11) {
        super.f(rectF, matrix, z11);
        if (this.H != null) {
            float fE = l.e();
            rectF.set(0.0f, 0.0f, this.H.f() * fE, this.H.d() * fE);
            this.f15245o.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void t(@NonNull Canvas canvas, Matrix matrix, int i11) {
        Bitmap bitmapP = P();
        if (bitmapP == null || bitmapP.isRecycled() || this.H == null) {
            return;
        }
        float fE = l.e();
        this.E.setAlpha(i11);
        y6.a<ColorFilter, ColorFilter> aVar = this.I;
        if (aVar != null) {
            this.E.setColorFilter(aVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.F.set(0, 0, bitmapP.getWidth(), bitmapP.getHeight());
        if (this.f15246p.V()) {
            this.G.set(0, 0, (int) (this.H.f() * fE), (int) (this.H.d() * fE));
        } else {
            this.G.set(0, 0, (int) (bitmapP.getWidth() * fE), (int) (bitmapP.getHeight() * fE));
        }
        y6.c cVar = this.K;
        if (cVar != null) {
            cVar.a(this.E, matrix, i11);
        }
        canvas.drawBitmap(bitmapP, this.F, this.G, this.E);
        canvas.restore();
    }
}
