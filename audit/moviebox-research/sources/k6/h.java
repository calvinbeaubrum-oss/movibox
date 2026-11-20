package k6;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements TypeEvaluator<Rect> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f68344a;

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f11, Rect rect, Rect rect2) {
        int i11 = rect.left;
        int i12 = i11 + ((int) ((rect2.left - i11) * f11));
        int i13 = rect.top;
        int i14 = i13 + ((int) ((rect2.top - i13) * f11));
        int i15 = rect.right;
        int i16 = i15 + ((int) ((rect2.right - i15) * f11));
        int i17 = rect.bottom;
        int i18 = i17 + ((int) ((rect2.bottom - i17) * f11));
        Rect rect3 = this.f68344a;
        if (rect3 == null) {
            return new Rect(i12, i14, i16, i18);
        }
        rect3.set(i12, i14, i16, i18);
        return this.f68344a;
    }
}
