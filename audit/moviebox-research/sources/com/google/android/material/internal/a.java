package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.internal.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a<T extends l<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, T> f36972a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Integer> f36973b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f36974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f36975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f36976e;

    /* JADX INFO: renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0384a implements l.a<T> {
        public C0384a() {
        }

        @Override // com.google.android.material.internal.l.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(T t11, boolean z11) {
            if (!z11) {
                a aVar = a.this;
                if (!aVar.s(t11, aVar.f36976e)) {
                    return;
                }
            } else if (!a.this.g(t11)) {
                return;
            }
            a.this.n();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(@NonNull Set<Integer> set);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e(T t11) {
        this.f36972a.put(Integer.valueOf(t11.getId()), t11);
        if (t11.isChecked()) {
            g(t11);
        }
        t11.setInternalOnCheckedChangeListener(new C0384a());
    }

    public void f(int i11) {
        T t11 = this.f36972a.get(Integer.valueOf(i11));
        if (t11 != null && g(t11)) {
            n();
        }
    }

    public final boolean g(@NonNull l<T> lVar) {
        int id2 = lVar.getId();
        if (this.f36973b.contains(Integer.valueOf(id2))) {
            return false;
        }
        T t11 = this.f36972a.get(Integer.valueOf(k()));
        if (t11 != null) {
            s(t11, false);
        }
        boolean zAdd = this.f36973b.add(Integer.valueOf(id2));
        if (!lVar.isChecked()) {
            lVar.setChecked(true);
        }
        return zAdd;
    }

    public void h() {
        boolean z11 = !this.f36973b.isEmpty();
        Iterator<T> it = this.f36972a.values().iterator();
        while (it.hasNext()) {
            s(it.next(), false);
        }
        if (z11) {
            n();
        }
    }

    @NonNull
    public Set<Integer> i() {
        return new HashSet(this.f36973b);
    }

    @NonNull
    public List<Integer> j(@NonNull ViewGroup viewGroup) {
        Set<Integer> setI = i();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof l) && setI.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int k() {
        if (!this.f36975d || this.f36973b.isEmpty()) {
            return -1;
        }
        return this.f36973b.iterator().next().intValue();
    }

    public boolean l() {
        return this.f36976e;
    }

    public boolean m() {
        return this.f36975d;
    }

    public final void n() {
        b bVar = this.f36974c;
        if (bVar != null) {
            bVar.a(i());
        }
    }

    public void o(T t11) {
        t11.setInternalOnCheckedChangeListener(null);
        this.f36972a.remove(Integer.valueOf(t11.getId()));
        this.f36973b.remove(Integer.valueOf(t11.getId()));
    }

    public void p(@Nullable b bVar) {
        this.f36974c = bVar;
    }

    public void q(boolean z11) {
        this.f36976e = z11;
    }

    public void r(boolean z11) {
        if (this.f36975d != z11) {
            this.f36975d = z11;
            h();
        }
    }

    public final boolean s(@NonNull l<T> lVar, boolean z11) {
        int id2 = lVar.getId();
        if (!this.f36973b.contains(Integer.valueOf(id2))) {
            return false;
        }
        if (z11 && this.f36973b.size() == 1 && this.f36973b.contains(Integer.valueOf(id2))) {
            lVar.setChecked(true);
            return false;
        }
        boolean zRemove = this.f36973b.remove(Integer.valueOf(id2));
        if (lVar.isChecked()) {
            lVar.setChecked(false);
        }
        return zRemove;
    }
}
