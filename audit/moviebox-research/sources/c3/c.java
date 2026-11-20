package c3;

import android.graphics.Insets;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public static final c f14553e = new c(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14557d;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class a {
        public static Insets a(int i11, int i12, int i13, int i14) {
            return Insets.of(i11, i12, i13, i14);
        }
    }

    public c(int i11, int i12, int i13, int i14) {
        this.f14554a = i11;
        this.f14555b = i12;
        this.f14556c = i13;
        this.f14557d = i14;
    }

    @NonNull
    public static c a(@NonNull c cVar, @NonNull c cVar2) {
        return b(Math.max(cVar.f14554a, cVar2.f14554a), Math.max(cVar.f14555b, cVar2.f14555b), Math.max(cVar.f14556c, cVar2.f14556c), Math.max(cVar.f14557d, cVar2.f14557d));
    }

    @NonNull
    public static c b(int i11, int i12, int i13, int i14) {
        return (i11 == 0 && i12 == 0 && i13 == 0 && i14 == 0) ? f14553e : new c(i11, i12, i13, i14);
    }

    @NonNull
    public static c c(@NonNull Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    @NonNull
    public static c d(@NonNull c cVar, @NonNull c cVar2) {
        return b(cVar.f14554a - cVar2.f14554a, cVar.f14555b - cVar2.f14555b, cVar.f14556c - cVar2.f14556c, cVar.f14557d - cVar2.f14557d);
    }

    @NonNull
    @RequiresApi(api = VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static c e(@NonNull Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f14557d == cVar.f14557d && this.f14554a == cVar.f14554a && this.f14556c == cVar.f14556c && this.f14555b == cVar.f14555b;
    }

    @NonNull
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public Insets f() {
        return a.a(this.f14554a, this.f14555b, this.f14556c, this.f14557d);
    }

    public int hashCode() {
        return (((((this.f14554a * 31) + this.f14555b) * 31) + this.f14556c) * 31) + this.f14557d;
    }

    @NonNull
    public String toString() {
        return "Insets{left=" + this.f14554a + ", top=" + this.f14555b + ", right=" + this.f14556c + ", bottom=" + this.f14557d + '}';
    }
}
