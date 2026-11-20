package yi;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f81364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f81365b;

    public b(float f11, @NonNull d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f81364a;
            f11 += ((b) dVar).f81365b;
        }
        this.f81364a = dVar;
        this.f81365b = f11;
    }

    @Override // yi.d
    public float a(@NonNull RectF rectF) {
        return Math.max(0.0f, this.f81364a.a(rectF) + this.f81365b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f81364a.equals(bVar.f81364a) && this.f81365b == bVar.f81365b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f81364a, Float.valueOf(this.f81365b)});
    }
}
