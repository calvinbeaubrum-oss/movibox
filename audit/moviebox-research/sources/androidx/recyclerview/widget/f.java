package androidx.recyclerview.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements k.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcatAdapter f12649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f12650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<WeakReference<RecyclerView>> f12651c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IdentityHashMap<RecyclerView.a0, k> f12652d = new IdentityHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<k> f12653e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f12654f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ConcatAdapter.Config.StableIdMode f12655g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r f12656h;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public k f12657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12659c;
    }

    public f(ConcatAdapter concatAdapter, ConcatAdapter.Config config) {
        this.f12649a = concatAdapter;
        if (config.f12401a) {
            this.f12650b = new u.a();
        } else {
            this.f12650b = new u.b();
        }
        ConcatAdapter.Config.StableIdMode stableIdMode = config.f12402b;
        this.f12655g = stableIdMode;
        if (stableIdMode == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            this.f12656h = new r.b();
        } else if (stableIdMode == ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) {
            this.f12656h = new r.a();
        } else {
            if (stableIdMode != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) {
                throw new IllegalArgumentException("unknown stable id mode");
            }
            this.f12656h = new r.c();
        }
    }

    public void A(RecyclerView.a0 a0Var) {
        r(a0Var).f12680c.onViewAttachedToWindow(a0Var);
    }

    public void B(RecyclerView.a0 a0Var) {
        r(a0Var).f12680c.onViewDetachedFromWindow(a0Var);
    }

    public void C(RecyclerView.a0 a0Var) {
        k kVar = this.f12652d.get(a0Var);
        if (kVar != null) {
            kVar.f12680c.onViewRecycled(a0Var);
            this.f12652d.remove(a0Var);
            return;
        }
        throw new IllegalStateException("Cannot find wrapper for " + a0Var + ", seems like it is not bound by this adapter: " + this);
    }

    public final void D(a aVar) {
        aVar.f12659c = false;
        aVar.f12657a = null;
        aVar.f12658b = -1;
        this.f12654f = aVar;
    }

    @Override // androidx.recyclerview.widget.k.b
    public void a(@NonNull k kVar, int i11, int i12, @Nullable Object obj) {
        this.f12649a.notifyItemRangeChanged(i11 + k(kVar), i12, obj);
    }

    @Override // androidx.recyclerview.widget.k.b
    public void b(@NonNull k kVar, int i11, int i12) {
        this.f12649a.notifyItemRangeInserted(i11 + k(kVar), i12);
    }

    @Override // androidx.recyclerview.widget.k.b
    public void c(@NonNull k kVar, int i11, int i12) {
        int iK = k(kVar);
        this.f12649a.notifyItemMoved(i11 + iK, i12 + iK);
    }

    @Override // androidx.recyclerview.widget.k.b
    public void d(k kVar) {
        i();
    }

    @Override // androidx.recyclerview.widget.k.b
    public void e(@NonNull k kVar) {
        this.f12649a.notifyDataSetChanged();
        i();
    }

    @Override // androidx.recyclerview.widget.k.b
    public void f(@NonNull k kVar, int i11, int i12) {
        this.f12649a.notifyItemRangeRemoved(i11 + k(kVar), i12);
    }

    public boolean g(int i11, RecyclerView.Adapter<RecyclerView.a0> adapter) {
        if (i11 < 0 || i11 > this.f12653e.size()) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + this.f12653e.size() + ". Given:" + i11);
        }
        if (s()) {
            androidx.core.util.i.b(adapter.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
        } else if (adapter.hasStableIds()) {
            Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
        }
        if (m(adapter) != null) {
            return false;
        }
        k kVar = new k(adapter, this, this.f12650b, this.f12656h.a());
        this.f12653e.add(i11, kVar);
        Iterator<WeakReference<RecyclerView>> it = this.f12651c.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = it.next().get();
            if (recyclerView != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
            }
        }
        if (kVar.a() > 0) {
            this.f12649a.notifyItemRangeInserted(k(kVar), kVar.a());
        }
        i();
        return true;
    }

    public boolean h(RecyclerView.Adapter<RecyclerView.a0> adapter) {
        return g(this.f12653e.size(), adapter);
    }

    public final void i() {
        RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicyJ = j();
        if (stateRestorationPolicyJ != this.f12649a.getStateRestorationPolicy()) {
            this.f12649a.e(stateRestorationPolicyJ);
        }
    }

    public final RecyclerView.Adapter.StateRestorationPolicy j() {
        for (k kVar : this.f12653e) {
            RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy = kVar.f12680c.getStateRestorationPolicy();
            RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy2 = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
            if (stateRestorationPolicy == stateRestorationPolicy2) {
                return stateRestorationPolicy2;
            }
            if (stateRestorationPolicy == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY && kVar.a() == 0) {
                return stateRestorationPolicy2;
            }
        }
        return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
    }

    public final int k(k kVar) {
        k next;
        Iterator<k> it = this.f12653e.iterator();
        int iA = 0;
        while (it.hasNext() && (next = it.next()) != kVar) {
            iA += next.a();
        }
        return iA;
    }

    @NonNull
    public final a l(int i11) {
        a aVar = this.f12654f;
        if (aVar.f12659c) {
            aVar = new a();
        } else {
            aVar.f12659c = true;
        }
        int iA = i11;
        for (k kVar : this.f12653e) {
            if (kVar.a() > iA) {
                aVar.f12657a = kVar;
                aVar.f12658b = iA;
                break;
            }
            iA -= kVar.a();
        }
        if (aVar.f12657a != null) {
            return aVar;
        }
        throw new IllegalArgumentException("Cannot find wrapper for " + i11);
    }

    @Nullable
    public final k m(RecyclerView.Adapter<RecyclerView.a0> adapter) {
        int iT = t(adapter);
        if (iT == -1) {
            return null;
        }
        return this.f12653e.get(iT);
    }

    public long n(int i11) {
        a aVarL = l(i11);
        long jB = aVarL.f12657a.b(aVarL.f12658b);
        D(aVarL);
        return jB;
    }

    public int o(int i11) {
        a aVarL = l(i11);
        int iC = aVarL.f12657a.c(aVarL.f12658b);
        D(aVarL);
        return iC;
    }

    public int p(RecyclerView.Adapter<? extends RecyclerView.a0> adapter, RecyclerView.a0 a0Var, int i11) {
        k kVar = this.f12652d.get(a0Var);
        if (kVar == null) {
            return -1;
        }
        int iK = i11 - k(kVar);
        int itemCount = kVar.f12680c.getItemCount();
        if (iK >= 0 && iK < itemCount) {
            return kVar.f12680c.findRelativeAdapterPositionIn(adapter, a0Var, iK);
        }
        throw new IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + iK + " which is out of bounds for the adapter with size " + itemCount + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + a0Var + "adapter:" + adapter);
    }

    public int q() {
        Iterator<k> it = this.f12653e.iterator();
        int iA = 0;
        while (it.hasNext()) {
            iA += it.next().a();
        }
        return iA;
    }

    @NonNull
    public final k r(RecyclerView.a0 a0Var) {
        k kVar = this.f12652d.get(a0Var);
        if (kVar != null) {
            return kVar;
        }
        throw new IllegalStateException("Cannot find wrapper for " + a0Var + ", seems like it is not bound by this adapter: " + this);
    }

    public boolean s() {
        return this.f12655g != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS;
    }

    public final int t(RecyclerView.Adapter<RecyclerView.a0> adapter) {
        int size = this.f12653e.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f12653e.get(i11).f12680c == adapter) {
                return i11;
            }
        }
        return -1;
    }

    public final boolean u(RecyclerView recyclerView) {
        Iterator<WeakReference<RecyclerView>> it = this.f12651c.iterator();
        while (it.hasNext()) {
            if (it.next().get() == recyclerView) {
                return true;
            }
        }
        return false;
    }

    public void v(RecyclerView recyclerView) {
        if (u(recyclerView)) {
            return;
        }
        this.f12651c.add(new WeakReference<>(recyclerView));
        Iterator<k> it = this.f12653e.iterator();
        while (it.hasNext()) {
            it.next().f12680c.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void w(RecyclerView.a0 a0Var, int i11) {
        a aVarL = l(i11);
        this.f12652d.put(a0Var, aVarL.f12657a);
        aVarL.f12657a.d(a0Var, aVarL.f12658b);
        D(aVarL);
    }

    public RecyclerView.a0 x(ViewGroup viewGroup, int i11) {
        return this.f12650b.a(i11).e(viewGroup, i11);
    }

    public void y(RecyclerView recyclerView) {
        for (int size = this.f12651c.size() - 1; size >= 0; size--) {
            WeakReference<RecyclerView> weakReference = this.f12651c.get(size);
            if (weakReference.get() != null) {
                if (weakReference.get() == recyclerView) {
                    this.f12651c.remove(size);
                    break;
                }
            } else {
                this.f12651c.remove(size);
            }
        }
        Iterator<k> it = this.f12653e.iterator();
        while (it.hasNext()) {
            it.next().f12680c.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public boolean z(RecyclerView.a0 a0Var) {
        k kVar = this.f12652d.get(a0Var);
        if (kVar != null) {
            boolean zOnFailedToRecycleView = kVar.f12680c.onFailedToRecycleView(a0Var);
            this.f12652d.remove(a0Var);
            return zOnFailedToRecycleView;
        }
        throw new IllegalStateException("Cannot find wrapper for " + a0Var + ", seems like it is not bound by this adapter: " + this);
    }
}
