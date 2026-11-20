package h4;

import androidx.annotation.Nullable;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f66292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f66293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f66294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f66295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f66296e;

    public h(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.f66292a = str;
        this.f66293b = str2;
        this.f66294c = str3;
        this.f66295d = str4;
        this.f66296e = str5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return u0.c(this.f66292a, hVar.f66292a) && u0.c(this.f66293b, hVar.f66293b) && u0.c(this.f66294c, hVar.f66294c) && u0.c(this.f66295d, hVar.f66295d) && u0.c(this.f66296e, hVar.f66296e);
    }

    public int hashCode() {
        String str = this.f66292a;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f66293b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f66294c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f66295d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f66296e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
