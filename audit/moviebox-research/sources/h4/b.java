package h4;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f66248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f66249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f66250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f66251d;

    public b(String str, String str2, int i11, int i12) {
        this.f66248a = str;
        this.f66249b = str2;
        this.f66250c = i11;
        this.f66251d = i12;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f66250c == bVar.f66250c && this.f66251d == bVar.f66251d && com.google.common.base.j.a(this.f66248a, bVar.f66248a) && com.google.common.base.j.a(this.f66249b, bVar.f66249b);
    }

    public int hashCode() {
        return com.google.common.base.j.b(this.f66248a, this.f66249b, Integer.valueOf(this.f66250c), Integer.valueOf(this.f66251d));
    }
}
