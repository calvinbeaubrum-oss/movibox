package d7;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c7.k;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.Layer;
import f7.j;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends com.airbnb.lottie.model.layer.a {
    public final x6.d E;
    public final com.airbnb.lottie.model.layer.b F;

    public d(LottieDrawable lottieDrawable, Layer layer, com.airbnb.lottie.model.layer.b bVar, h hVar) {
        super(lottieDrawable, layer);
        this.F = bVar;
        x6.d dVar = new x6.d(lottieDrawable, this, new k("__container", layer.o(), false), hVar);
        this.E = dVar;
        dVar.c(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void I(a7.d dVar, int i11, List<a7.d> list, a7.d dVar2) {
        this.E.e(dVar, i11, list, dVar2);
    }

    @Override // com.airbnb.lottie.model.layer.a, x6.e
    public void f(RectF rectF, Matrix matrix, boolean z11) {
        super.f(rectF, matrix, z11);
        this.E.f(rectF, this.f15245o, z11);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void t(@NonNull Canvas canvas, Matrix matrix, int i11) {
        this.E.h(canvas, matrix, i11);
    }

    @Override // com.airbnb.lottie.model.layer.a
    @Nullable
    public c7.a w() {
        c7.a aVarW = super.w();
        return aVarW != null ? aVarW : this.F.w();
    }

    @Override // com.airbnb.lottie.model.layer.a
    @Nullable
    public j y() {
        j jVarY = super.y();
        return jVarY != null ? jVarY : this.F.y();
    }
}
