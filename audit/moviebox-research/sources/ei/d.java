package ei;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f64224f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f64226h;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f64233o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f64219a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f64220b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f64221c = Collections.emptySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f64222d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public String f64223e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f64225g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f64227i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f64228j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f64229k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f64230l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f64231m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f64232n = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f64234p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f64235q = false;

    public static int B(int i11, String str, @Nullable String str2, int i12) {
        if (str.isEmpty() || i11 == -1) {
            return i11;
        }
        if (str.equals(str2)) {
            return i11 + i12;
        }
        return -1;
    }

    public d A(boolean z11) {
        this.f64229k = z11 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f64227i) {
            return this.f64226h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f64235q;
    }

    public int c() {
        if (this.f64225g) {
            return this.f64224f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    @Nullable
    public String d() {
        return this.f64223e;
    }

    public float e() {
        return this.f64233o;
    }

    public int f() {
        return this.f64232n;
    }

    public int g() {
        return this.f64234p;
    }

    public int h(@Nullable String str, @Nullable String str2, Set<String> set, @Nullable String str3) {
        if (this.f64219a.isEmpty() && this.f64220b.isEmpty() && this.f64221c.isEmpty() && this.f64222d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iB = B(B(B(0, this.f64219a, str, 1073741824), this.f64220b, str2, 2), this.f64222d, str3, 4);
        if (iB == -1 || !set.containsAll(this.f64221c)) {
            return 0;
        }
        return iB + (this.f64221c.size() * 4);
    }

    public int i() {
        int i11 = this.f64230l;
        if (i11 == -1 && this.f64231m == -1) {
            return -1;
        }
        return (i11 == 1 ? 1 : 0) | (this.f64231m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f64227i;
    }

    public boolean k() {
        return this.f64225g;
    }

    public boolean l() {
        return this.f64228j == 1;
    }

    public boolean m() {
        return this.f64229k == 1;
    }

    public d n(int i11) {
        this.f64226h = i11;
        this.f64227i = true;
        return this;
    }

    public d o(boolean z11) {
        this.f64230l = z11 ? 1 : 0;
        return this;
    }

    public d p(boolean z11) {
        this.f64235q = z11;
        return this;
    }

    public d q(int i11) {
        this.f64224f = i11;
        this.f64225g = true;
        return this;
    }

    public d r(@Nullable String str) {
        this.f64223e = str == null ? null : com.google.common.base.a.e(str);
        return this;
    }

    public d s(float f11) {
        this.f64233o = f11;
        return this;
    }

    public d t(int i11) {
        this.f64232n = i11;
        return this;
    }

    public d u(boolean z11) {
        this.f64231m = z11 ? 1 : 0;
        return this;
    }

    public d v(int i11) {
        this.f64234p = i11;
        return this;
    }

    public void w(String[] strArr) {
        this.f64221c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f64219a = str;
    }

    public void y(String str) {
        this.f64220b = str;
    }

    public void z(String str) {
        this.f64222d = str;
    }
}
