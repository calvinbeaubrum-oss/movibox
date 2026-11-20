package yi;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f81363a;

    public a(float f11) {
        this.f81363a = f11;
    }

    @Override // yi.d
    public float a(@NonNull RectF rectF) {
        return this.f81363a;
    }

    public float b() {
        return this.f81363a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f81363a == ((a) obj).f81363a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f81363a)});
    }
}
