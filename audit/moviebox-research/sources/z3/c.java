package z3;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static void a(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) u0.i(c.class.getClassLoader()));
        }
    }

    public static <T> ImmutableList<T> b(com.google.common.base.f<Bundle, T> fVar, List<Bundle> list) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            aVarBuilder.a(fVar.apply((Bundle) a.e(list.get(i11))));
        }
        return aVarBuilder.m();
    }

    public static <T> ArrayList<Bundle> c(Collection<T> collection, com.google.common.base.f<T, Bundle> fVar) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(fVar.apply(it.next()));
        }
        return arrayList;
    }
}
