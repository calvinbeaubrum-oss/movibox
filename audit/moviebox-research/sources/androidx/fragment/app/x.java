package androidx.fragment.app;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FragmentTransitionImpl f8630a = new y();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FragmentTransitionImpl f8631b = b();

    public static void a(Fragment fragment, Fragment fragment2, boolean z11, androidx.collection.a<String, View> aVar, boolean z12) {
        if (z11) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    public static FragmentTransitionImpl b() {
        try {
            return (FragmentTransitionImpl) k6.e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void c(@NonNull androidx.collection.a<String, String> aVar, @NonNull androidx.collection.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.valueAt(size))) {
                aVar.removeAt(size);
            }
        }
    }

    public static void d(ArrayList<View> arrayList, int i11) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i11);
        }
    }

    public static boolean e() {
        return (f8630a == null && f8631b == null) ? false : true;
    }
}
