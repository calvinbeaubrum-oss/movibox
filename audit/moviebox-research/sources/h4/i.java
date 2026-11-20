package h4;

import android.net.Uri;
import androidx.annotation.Nullable;
import z3.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f66297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f66298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f66299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f66300d;

    public i(@Nullable String str, long j11, long j12) {
        this.f66299c = str == null ? "" : str;
        this.f66297a = j11;
        this.f66298b = j12;
    }

    @Nullable
    public i a(@Nullable i iVar, String str) {
        String strC = c(str);
        if (iVar != null && strC.equals(iVar.c(str))) {
            long j11 = this.f66298b;
            if (j11 != -1) {
                long j12 = this.f66297a;
                if (j12 + j11 == iVar.f66297a) {
                    long j13 = iVar.f66298b;
                    return new i(strC, j12, j13 != -1 ? j11 + j13 : -1L);
                }
            }
            long j14 = iVar.f66298b;
            if (j14 != -1) {
                long j15 = iVar.f66297a;
                if (j15 + j14 == this.f66297a) {
                    return new i(strC, j15, j11 != -1 ? j14 + j11 : -1L);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return k0.f(str, this.f66299c);
    }

    public String c(String str) {
        return k0.e(str, this.f66299c);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f66297a == iVar.f66297a && this.f66298b == iVar.f66298b && this.f66299c.equals(iVar.f66299c);
    }

    public int hashCode() {
        if (this.f66300d == 0) {
            this.f66300d = ((((527 + ((int) this.f66297a)) * 31) + ((int) this.f66298b)) * 31) + this.f66299c.hashCode();
        }
        return this.f66300d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f66299c + ", start=" + this.f66297a + ", length=" + this.f66298b + ")";
    }
}
