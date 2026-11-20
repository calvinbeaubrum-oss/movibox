package y3;

import android.os.Bundle;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f81154c = u0.E0(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f81155d = u0.E0(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f81156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f81157b;

    public f(String str, int i11) {
        this.f81156a = str;
        this.f81157b = i11;
    }

    public static f a(Bundle bundle) {
        return new f((String) z3.a.e(bundle.getString(f81154c)), bundle.getInt(f81155d));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(f81154c, this.f81156a);
        bundle.putInt(f81155d, this.f81157b);
        return bundle;
    }
}
