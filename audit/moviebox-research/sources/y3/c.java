package y3;

import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f81149a = u0.E0(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f81150b = u0.E0(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f81151c = u0.E0(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f81152d = u0.E0(3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f81153e = u0.E0(4);

    public static ArrayList<Bundle> a(Spanned spanned) {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        for (f fVar : (f[]) spanned.getSpans(0, spanned.length(), f.class)) {
            arrayList.add(b(spanned, fVar, 1, fVar.b()));
        }
        for (h hVar : (h[]) spanned.getSpans(0, spanned.length(), h.class)) {
            arrayList.add(b(spanned, hVar, 2, hVar.b()));
        }
        for (d dVar : (d[]) spanned.getSpans(0, spanned.length(), d.class)) {
            arrayList.add(b(spanned, dVar, 3, null));
        }
        return arrayList;
    }

    public static Bundle b(Spanned spanned, Object obj, int i11, @Nullable Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f81149a, spanned.getSpanStart(obj));
        bundle2.putInt(f81150b, spanned.getSpanEnd(obj));
        bundle2.putInt(f81151c, spanned.getSpanFlags(obj));
        bundle2.putInt(f81152d, i11);
        if (bundle != null) {
            bundle2.putBundle(f81153e, bundle);
        }
        return bundle2;
    }

    public static void c(Bundle bundle, Spannable spannable) {
        int i11 = bundle.getInt(f81149a);
        int i12 = bundle.getInt(f81150b);
        int i13 = bundle.getInt(f81151c);
        int i14 = bundle.getInt(f81152d, -1);
        Bundle bundle2 = bundle.getBundle(f81153e);
        if (i14 == 1) {
            spannable.setSpan(f.a((Bundle) z3.a.e(bundle2)), i11, i12, i13);
        } else if (i14 == 2) {
            spannable.setSpan(h.a((Bundle) z3.a.e(bundle2)), i11, i12, i13);
        } else {
            if (i14 != 3) {
                return;
            }
            spannable.setSpan(new d(), i11, i12, i13);
        }
    }
}
