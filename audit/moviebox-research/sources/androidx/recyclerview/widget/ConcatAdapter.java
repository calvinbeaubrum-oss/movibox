package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.a0> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f12399i;

    /* JADX INFO: compiled from: source.java */
    public static final class Config {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public static final Config f12400c = new Config(true, StableIdMode.NO_STABLE_IDS);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f12401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final StableIdMode f12402b;

        /* JADX INFO: compiled from: source.java */
        public enum StableIdMode {
            NO_STABLE_IDS,
            ISOLATED_STABLE_IDS,
            SHARED_STABLE_IDS
        }

        public Config(boolean z11, @NonNull StableIdMode stableIdMode) {
            this.f12401a = z11;
            this.f12402b = stableIdMode;
        }
    }

    public ConcatAdapter(@NonNull Config config, @NonNull List<? extends RecyclerView.Adapter<? extends RecyclerView.a0>> list) {
        this.f12399i = new f(this, config);
        Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.a0>> it = list.iterator();
        while (it.hasNext()) {
            d(it.next());
        }
        super.setHasStableIds(this.f12399i.s());
    }

    @SafeVarargs
    public ConcatAdapter(@NonNull Config config, @NonNull RecyclerView.Adapter<? extends RecyclerView.a0>... adapterArr) {
        this(config, (List<? extends RecyclerView.Adapter<? extends RecyclerView.a0>>) Arrays.asList(adapterArr));
    }

    @SafeVarargs
    public ConcatAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.a0>... adapterArr) {
        this(Config.f12400c, adapterArr);
    }

    public boolean d(@NonNull RecyclerView.Adapter<? extends RecyclerView.a0> adapter) {
        return this.f12399i.h(adapter);
    }

    public void e(@NonNull RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        super.setStateRestorationPolicy(stateRestorationPolicy);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int findRelativeAdapterPositionIn(@NonNull RecyclerView.Adapter<? extends RecyclerView.a0> adapter, @NonNull RecyclerView.a0 a0Var, int i11) {
        return this.f12399i.p(adapter, a0Var, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12399i.q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i11) {
        return this.f12399i.n(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        return this.f12399i.o(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.f12399i.v(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.a0 a0Var, int i11) {
        this.f12399i.w(a0Var, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.a0 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        return this.f12399i.x(viewGroup, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.f12399i.y(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RecyclerView.a0 a0Var) {
        return this.f12399i.z(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.a0 a0Var) {
        this.f12399i.A(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.a0 a0Var) {
        this.f12399i.B(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.a0 a0Var) {
        this.f12399i.C(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z11) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(@NonNull RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }
}
