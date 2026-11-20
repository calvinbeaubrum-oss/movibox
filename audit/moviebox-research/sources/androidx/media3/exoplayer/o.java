package androidx.media3.exoplayer;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.common.y f10790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.media3.common.y f10791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10793e;

    public o(String str, androidx.media3.common.y yVar, androidx.media3.common.y yVar2, int i11, int i12) {
        z3.a.a(i11 == 0 || i12 == 0);
        this.f10789a = z3.a.d(str);
        this.f10790b = (androidx.media3.common.y) z3.a.e(yVar);
        this.f10791c = (androidx.media3.common.y) z3.a.e(yVar2);
        this.f10792d = i11;
        this.f10793e = i12;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f10792d == oVar.f10792d && this.f10793e == oVar.f10793e && this.f10789a.equals(oVar.f10789a) && this.f10790b.equals(oVar.f10790b) && this.f10791c.equals(oVar.f10791c);
    }

    public int hashCode() {
        return ((((((((527 + this.f10792d) * 31) + this.f10793e) * 31) + this.f10789a.hashCode()) * 31) + this.f10790b.hashCode()) * 31) + this.f10791c.hashCode();
    }
}
