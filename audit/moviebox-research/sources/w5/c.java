package w5;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f79298f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f79300h;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f79307o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f79293a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f79294b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f79295c = Collections.emptySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f79296d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public String f79297e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f79299g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f79301i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f79302j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f79303k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f79304l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f79305m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f79306n = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f79308p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f79309q = false;

    public static int B(int i11, String str, @Nullable String str2, int i12) {
        if (str.isEmpty() || i11 == -1) {
            return i11;
        }
        if (str.equals(str2)) {
            return i11 + i12;
        }
        return -1;
    }

    public c A(boolean z11) {
        this.f79303k = z11 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f79301i) {
            return this.f79300h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f79309q;
    }

    public int c() {
        if (this.f79299g) {
            return this.f79298f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    @Nullable
    public String d() {
        return this.f79297e;
    }

    public float e() {
        return this.f79307o;
    }

    public int f() {
        return this.f79306n;
    }

    public int g() {
        return this.f79308p;
    }

    public int h(@Nullable String str, @Nullable String str2, Set<String> set, @Nullable String str3) {
        if (this.f79293a.isEmpty() && this.f79294b.isEmpty() && this.f79295c.isEmpty() && this.f79296d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iB = B(B(B(0, this.f79293a, str, 1073741824), this.f79294b, str2, 2), this.f79296d, str3, 4);
        if (iB == -1 || !set.containsAll(this.f79295c)) {
            return 0;
        }
        return iB + (this.f79295c.size() * 4);
    }

    public int i() {
        int i11 = this.f79304l;
        if (i11 == -1 && this.f79305m == -1) {
            return -1;
        }
        return (i11 == 1 ? 1 : 0) | (this.f79305m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f79301i;
    }

    public boolean k() {
        return this.f79299g;
    }

    public boolean l() {
        return this.f79302j == 1;
    }

    public boolean m() {
        return this.f79303k == 1;
    }

    public c n(int i11) {
        this.f79300h = i11;
        this.f79301i = true;
        return this;
    }

    public c o(boolean z11) {
        this.f79304l = z11 ? 1 : 0;
        return this;
    }

    public c p(boolean z11) {
        this.f79309q = z11;
        return this;
    }

    public c q(int i11) {
        this.f79298f = i11;
        this.f79299g = true;
        return this;
    }

    public c r(@Nullable String str) {
        this.f79297e = str == null ? null : com.google.common.base.a.e(str);
        return this;
    }

    public c s(float f11) {
        this.f79307o = f11;
        return this;
    }

    public c t(int i11) {
        this.f79306n = i11;
        return this;
    }

    public c u(boolean z11) {
        this.f79305m = z11 ? 1 : 0;
        return this;
    }

    public c v(int i11) {
        this.f79308p = i11;
        return this;
    }

    public void w(String[] strArr) {
        this.f79295c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f79293a = str;
    }

    public void y(String str) {
        this.f79294b = str;
    }

    public void z(String str) {
        this.f79296d = str;
    }
}
