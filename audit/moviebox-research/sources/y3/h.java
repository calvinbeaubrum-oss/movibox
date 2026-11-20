package y3;

import android.os.Bundle;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f81158d = u0.E0(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f81159e = u0.E0(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f81160f = u0.E0(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f81161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f81162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f81163c;

    public h(int i11, int i12, int i13) {
        this.f81161a = i11;
        this.f81162b = i12;
        this.f81163c = i13;
    }

    public static h a(Bundle bundle) {
        return new h(bundle.getInt(f81158d), bundle.getInt(f81159e), bundle.getInt(f81160f));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(f81158d, this.f81161a);
        bundle.putInt(f81159e, this.f81162b);
        bundle.putInt(f81160f, this.f81163c);
        return bundle;
    }
}
