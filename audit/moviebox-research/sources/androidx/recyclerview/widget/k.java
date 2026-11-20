package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final u.c f12678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final r.d f12679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView.Adapter<RecyclerView.a0> f12680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f12681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView.g f12683f = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends RecyclerView.g {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onChanged() {
            k kVar = k.this;
            kVar.f12682e = kVar.f12680c.getItemCount();
            k kVar2 = k.this;
            kVar2.f12681d.e(kVar2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeChanged(int i11, int i12) {
            k kVar = k.this;
            kVar.f12681d.a(kVar, i11, i12, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeChanged(int i11, int i12, @Nullable Object obj) {
            k kVar = k.this;
            kVar.f12681d.a(kVar, i11, i12, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeInserted(int i11, int i12) {
            k kVar = k.this;
            kVar.f12682e += i12;
            kVar.f12681d.b(kVar, i11, i12);
            k kVar2 = k.this;
            if (kVar2.f12682e <= 0 || kVar2.f12680c.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                return;
            }
            k kVar3 = k.this;
            kVar3.f12681d.d(kVar3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeMoved(int i11, int i12, int i13) {
            androidx.core.util.i.b(i13 == 1, "moving more than 1 item is not supported in RecyclerView");
            k kVar = k.this;
            kVar.f12681d.c(kVar, i11, i12);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeRemoved(int i11, int i12) {
            k kVar = k.this;
            kVar.f12682e -= i12;
            kVar.f12681d.f(kVar, i11, i12);
            k kVar2 = k.this;
            if (kVar2.f12682e >= 1 || kVar2.f12680c.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                return;
            }
            k kVar3 = k.this;
            kVar3.f12681d.d(kVar3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onStateRestorationPolicyChanged() {
            k kVar = k.this;
            kVar.f12681d.d(kVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(@NonNull k kVar, int i11, int i12, @Nullable Object obj);

        void b(@NonNull k kVar, int i11, int i12);

        void c(@NonNull k kVar, int i11, int i12);

        void d(k kVar);

        void e(@NonNull k kVar);

        void f(@NonNull k kVar, int i11, int i12);
    }

    public k(RecyclerView.Adapter<RecyclerView.a0> adapter, b bVar, u uVar, r.d dVar) {
        this.f12680c = adapter;
        this.f12681d = bVar;
        this.f12678a = uVar.b(this);
        this.f12679b = dVar;
        this.f12682e = adapter.getItemCount();
        adapter.registerAdapterDataObserver(this.f12683f);
    }

    public int a() {
        return this.f12682e;
    }

    public long b(int i11) {
        return this.f12679b.a(this.f12680c.getItemId(i11));
    }

    public int c(int i11) {
        return this.f12678a.b(this.f12680c.getItemViewType(i11));
    }

    public void d(RecyclerView.a0 a0Var, int i11) {
        this.f12680c.bindViewHolder(a0Var, i11);
    }

    public RecyclerView.a0 e(ViewGroup viewGroup, int i11) {
        return this.f12680c.onCreateViewHolder(viewGroup, this.f12678a.a(i11));
    }
}
