package yi;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f81366a;

    public c(float f11) {
        this.f81366a = f11;
    }

    @NonNull
    public static c b(@NonNull a aVar) {
        return new c(aVar.b());
    }

    public static float c(@NonNull RectF rectF) {
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // yi.d
    public float a(@NonNull RectF rectF) {
        return Math.min(this.f81366a, c(rectF));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f81366a == ((c) obj).f81366a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f81366a)});
    }
}
