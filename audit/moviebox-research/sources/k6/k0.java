package k6;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
public class k0 extends j0 {
    @Override // k6.c0
    public float c(@NonNull View view) {
        return view.getTransitionAlpha();
    }

    @Override // k6.h0, k6.c0
    public void e(@NonNull View view, int i11, int i12, int i13, int i14) {
        view.setLeftTopRightBottom(i11, i12, i13, i14);
    }

    @Override // k6.c0
    public void f(@NonNull View view, float f11) {
        view.setTransitionAlpha(f11);
    }

    @Override // k6.j0, k6.c0
    public void g(@NonNull View view, int i11) {
        view.setTransitionVisibility(i11);
    }

    @Override // k6.f0, k6.c0
    public void h(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // k6.f0, k6.c0
    public void i(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
