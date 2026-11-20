package rh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f75434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f75435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f75436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f75437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f75438e;

    public h(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.f75434a = str;
        this.f75435b = str2;
        this.f75436c = str3;
        this.f75437d = str4;
        this.f75438e = str5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return o0.c(this.f75434a, hVar.f75434a) && o0.c(this.f75435b, hVar.f75435b) && o0.c(this.f75436c, hVar.f75436c) && o0.c(this.f75437d, hVar.f75437d) && o0.c(this.f75438e, hVar.f75438e);
    }

    public int hashCode() {
        String str = this.f75434a;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f75435b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f75436c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f75437d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f75438e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
