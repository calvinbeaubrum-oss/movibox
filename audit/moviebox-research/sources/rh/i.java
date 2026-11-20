package rh;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.m0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f75439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f75440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f75441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f75442d;

    public i(@Nullable String str, long j11, long j12) {
        this.f75441c = str == null ? "" : str;
        this.f75439a = j11;
        this.f75440b = j12;
    }

    @Nullable
    public i a(@Nullable i iVar, String str) {
        String strC = c(str);
        if (iVar != null && strC.equals(iVar.c(str))) {
            long j11 = this.f75440b;
            if (j11 != -1) {
                long j12 = this.f75439a;
                if (j12 + j11 == iVar.f75439a) {
                    long j13 = iVar.f75440b;
                    return new i(strC, j12, j13 != -1 ? j11 + j13 : -1L);
                }
            }
            long j14 = iVar.f75440b;
            if (j14 != -1) {
                long j15 = iVar.f75439a;
                if (j15 + j14 == this.f75439a) {
                    return new i(strC, j15, j11 != -1 ? j14 + j11 : -1L);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return m0.e(str, this.f75441c);
    }

    public String c(String str) {
        return m0.d(str, this.f75441c);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f75439a == iVar.f75439a && this.f75440b == iVar.f75440b && this.f75441c.equals(iVar.f75441c);
    }

    public int hashCode() {
        if (this.f75442d == 0) {
            this.f75442d = ((((527 + ((int) this.f75439a)) * 31) + ((int) this.f75440b)) * 31) + this.f75441c.hashCode();
        }
        return this.f75442d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f75441c + ", start=" + this.f75439a + ", length=" + this.f75440b + ")";
    }
}
