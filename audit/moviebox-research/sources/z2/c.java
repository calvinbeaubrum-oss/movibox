package z2;

import android.content.LocusId;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.i;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f81726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocusId f81727b;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class a {
        @NonNull
        public static LocusId a(@NonNull String str) {
            return new LocusId(str);
        }

        @NonNull
        public static String b(@NonNull LocusId locusId) {
            return locusId.getId();
        }
    }

    public c(@NonNull String str) {
        this.f81726a = (String) i.j(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f81727b = a.a(str);
        } else {
            this.f81727b = null;
        }
    }

    @NonNull
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static c c(@NonNull LocusId locusId) {
        i.h(locusId, "locusId cannot be null");
        return new c((String) i.j(a.b(locusId), "id cannot be empty"));
    }

    @NonNull
    public final String a() {
        return this.f81726a.length() + "_chars";
    }

    @NonNull
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public LocusId b() {
        return this.f81727b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.f81726a;
        if (str == null) {
            return cVar.f81726a == null;
        }
        return str.equals(cVar.f81726a);
    }

    public int hashCode() {
        String str = this.f81726a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    @NonNull
    public String toString() {
        return "LocusIdCompat[" + a() + "]";
    }
}
