package athena;

import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13742f;

    public r0() {
    }

    public r0(String str, String str2, int i11, int i12, int i13, boolean z11) {
        this.f13737a = str;
        this.f13738b = str2;
        this.f13739c = i11;
        this.f13740d = i12;
        this.f13741e = i13;
        this.f13742f = z11;
    }

    public String a() {
        return this.f13737a + "-" + this.f13738b + "-" + this.f13740d + "-" + this.f13739c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r0) {
            return TextUtils.equals(a(), ((r0) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f13737a, this.f13738b, Integer.valueOf(this.f13739c), Integer.valueOf(this.f13740d), Integer.valueOf(this.f13741e), Boolean.valueOf(this.f13742f));
    }
}
