package ii;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class h implements TypeEvaluator<Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f67211a = new float[9];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f67212b = new float[9];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f67213c = new Matrix();

    @NonNull
    public Matrix a(float f11, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.f67211a);
        matrix2.getValues(this.f67212b);
        for (int i11 = 0; i11 < 9; i11++) {
            float[] fArr = this.f67212b;
            float f12 = fArr[i11];
            float f13 = this.f67211a[i11];
            fArr[i11] = f13 + ((f12 - f13) * f11);
        }
        this.f67213c.setValues(this.f67212b);
        return this.f67213c;
    }
}
