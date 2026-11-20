package h4;

import androidx.annotation.Nullable;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f66279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f66280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f66281c;

    public e(String str, @Nullable String str2, @Nullable String str3) {
        this.f66279a = str;
        this.f66280b = str2;
        this.f66281c = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return u0.c(this.f66279a, eVar.f66279a) && u0.c(this.f66280b, eVar.f66280b) && u0.c(this.f66281c, eVar.f66281c);
    }

    public int hashCode() {
        int iHashCode = this.f66279a.hashCode() * 31;
        String str = this.f66280b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f66281c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
