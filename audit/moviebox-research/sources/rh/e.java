package rh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f75421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f75422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f75423c;

    public e(String str, @Nullable String str2, @Nullable String str3) {
        this.f75421a = str;
        this.f75422b = str2;
        this.f75423c = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return o0.c(this.f75421a, eVar.f75421a) && o0.c(this.f75422b, eVar.f75422b) && o0.c(this.f75423c, eVar.f75423c);
    }

    public int hashCode() {
        int iHashCode = this.f75421a.hashCode() * 31;
        String str = this.f75422b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f75423c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
