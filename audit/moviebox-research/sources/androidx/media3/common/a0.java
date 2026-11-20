package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.Nullable;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8904c = u0.E0(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8905d = u0.E0(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f8906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8907b;

    public a0(@Nullable String str, String str2) {
        this.f8906a = u0.U0(str);
        this.f8907b = str2;
    }

    public static a0 a(Bundle bundle) {
        return new a0(bundle.getString(f8904c), (String) z3.a.e(bundle.getString(f8905d)));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f8906a;
        if (str != null) {
            bundle.putString(f8904c, str);
        }
        bundle.putString(f8905d, this.f8907b);
        return bundle;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return u0.c(this.f8906a, a0Var.f8906a) && u0.c(this.f8907b, a0Var.f8907b);
    }

    public int hashCode() {
        int iHashCode = this.f8907b.hashCode() * 31;
        String str = this.f8906a;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
