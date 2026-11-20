package androidx.media;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8890c;

    public i(String str, int i11, int i12) {
        this.f8888a = str;
        this.f8889b = i11;
        this.f8890c = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f8889b < 0 || iVar.f8889b < 0) {
            return TextUtils.equals(this.f8888a, iVar.f8888a) && this.f8890c == iVar.f8890c;
        }
        return TextUtils.equals(this.f8888a, iVar.f8888a) && this.f8889b == iVar.f8889b && this.f8890c == iVar.f8890c;
    }

    public int hashCode() {
        return androidx.core.util.d.b(this.f8888a, Integer.valueOf(this.f8890c));
    }
}
