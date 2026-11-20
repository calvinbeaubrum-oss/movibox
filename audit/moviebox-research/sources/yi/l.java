package yi;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class l implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f81421a;

    public l(float f11) {
        this.f81421a = f11;
    }

    private static float b(@NonNull RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    @Override // yi.d
    public float a(@NonNull RectF rectF) {
        return this.f81421a * b(rectF);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && this.f81421a == ((l) obj).f81421a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f81421a)});
    }
}
