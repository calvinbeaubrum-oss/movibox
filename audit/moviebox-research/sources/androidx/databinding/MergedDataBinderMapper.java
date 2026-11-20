package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class MergedDataBinderMapper extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<Class<? extends e>> f8148a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<e> f8149b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f8150c = new CopyOnWriteArrayList();

    @Override // androidx.databinding.e
    public ViewDataBinding b(f fVar, View view, int i11) {
        Iterator<e> it = this.f8149b.iterator();
        while (it.hasNext()) {
            ViewDataBinding viewDataBindingB = it.next().b(fVar, view, i11);
            if (viewDataBindingB != null) {
                return viewDataBindingB;
            }
        }
        if (e()) {
            return b(fVar, view, i11);
        }
        return null;
    }

    @Override // androidx.databinding.e
    public int c(String str) {
        Iterator<e> it = this.f8149b.iterator();
        while (it.hasNext()) {
            int iC = it.next().c(str);
            if (iC != 0) {
                return iC;
            }
        }
        if (e()) {
            return c(str);
        }
        return 0;
    }

    public void d(e eVar) {
        if (this.f8148a.add((Class<? extends e>) eVar.getClass())) {
            this.f8149b.add(eVar);
            Iterator<e> it = eVar.a().iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    public final boolean e() {
        boolean z11 = false;
        for (String str : this.f8150c) {
            try {
                Class<?> cls = Class.forName(str);
                if (e.class.isAssignableFrom(cls)) {
                    d((e) cls.newInstance());
                    this.f8150c.remove(str);
                    z11 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e11) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e11);
            } catch (InstantiationException e12) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e12);
            }
        }
        return z11;
    }
}
