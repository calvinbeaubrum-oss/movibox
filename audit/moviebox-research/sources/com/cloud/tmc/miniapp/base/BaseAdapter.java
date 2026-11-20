package com.cloud.tmc.miniapp.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.miniapp.base.BaseAdapter.a;
import id.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseAdapter<VH extends BaseAdapter<VH>.a> extends RecyclerView.Adapter<VH> implements h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f31380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView f31381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f31382k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f31383l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f31384m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f31385n;

    /* JADX INFO: compiled from: source.java */
    public abstract class a extends RecyclerView.a0 implements View.OnClickListener, View.OnLongClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseAdapter<VH> f31386b;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(BaseAdapter baseAdapter, int i11) {
            View viewInflate = LayoutInflater.from(baseAdapter.getContext()).inflate(i11, (ViewGroup) baseAdapter.f31381j, false);
            Intrinsics.f(viewInflate, "from(getContext()).infla…(id, recyclerView, false)");
            this(baseAdapter, viewInflate);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseAdapter baseAdapter, View itemView) {
            super(itemView);
            Intrinsics.g(itemView, "itemView");
            this.f31386b = baseAdapter;
            if (baseAdapter.f31382k != null) {
                itemView.setOnClickListener(this);
            }
            BaseAdapter.g(baseAdapter);
            int size = baseAdapter.l().size();
            for (int i11 = 0; i11 < size; i11++) {
                View viewFindViewById = findViewById(this.f31386b.l().keyAt(i11));
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(this);
                }
            }
            int size2 = this.f31386b.m().size();
            for (int i12 = 0; i12 < size2; i12++) {
                View viewFindViewById2 = findViewById(this.f31386b.m().keyAt(i12));
                if (viewFindViewById2 != null) {
                    viewFindViewById2.setOnLongClickListener(this);
                }
            }
        }

        public View e() {
            View itemView = this.itemView;
            Intrinsics.f(itemView, "itemView");
            return itemView;
        }

        public int f() {
            return this.f31386b.f31385n + getLayoutPosition();
        }

        public <V extends View> V findViewById(int i11) {
            return (V) e().findViewById(i11);
        }

        public abstract void g(int i11);

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.g(view, "view");
            int iF = f();
            if (iF < 0 || iF >= this.f31386b.getItemCount()) {
                return;
            }
            if (view == e()) {
                d dVar = this.f31386b.f31382k;
                if (dVar != null) {
                    dVar.onItemClick(this.f31386b.f31381j, view, iF);
                    return;
                }
                return;
            }
            b bVar = (b) this.f31386b.l().get(view.getId());
            if (bVar != null) {
                bVar.onChildClick(this.f31386b.f31381j, view, iF);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Intrinsics.g(view, "view");
            int iF = f();
            if (iF >= 0 && iF < this.f31386b.getItemCount()) {
                if (view == e()) {
                    BaseAdapter.g(this.f31386b);
                    return false;
                }
                c cVar = (c) this.f31386b.m().get(view.getId());
                if (cVar != null) {
                    return cVar.a(this.f31386b.f31381j, view, iF);
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void onChildClick(RecyclerView recyclerView, View view, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        boolean a(RecyclerView recyclerView, View view, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void onItemClick(RecyclerView recyclerView, View view, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
    }

    public BaseAdapter(Context context) {
        Intrinsics.g(context, "context");
        this.f31380i = context;
        this.f31383l = LazyKt__LazyJVMKt.b(new Function0<SparseArray<b>>() { // from class: com.cloud.tmc.miniapp.base.BaseAdapter$childClickListeners$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SparseArray<BaseAdapter.b> invoke() {
                return new SparseArray<>();
            }
        });
        this.f31384m = LazyKt__LazyJVMKt.b(new Function0<SparseArray<c>>() { // from class: com.cloud.tmc.miniapp.base.BaseAdapter$childLongClickListeners$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SparseArray<BaseAdapter.c> invoke() {
                return new SparseArray<>();
            }
        });
    }

    public static final /* synthetic */ e g(BaseAdapter baseAdapter) {
        baseAdapter.getClass();
        return null;
    }

    @Override // id.h
    public Context getContext() {
        return this.f31380i;
    }

    public final void j() {
        if (this.f31381j != null) {
            throw new IllegalStateException("are you ok?");
        }
    }

    public RecyclerView.m k(Context context) {
        Intrinsics.g(context, "context");
        return new LinearLayoutManager(context);
    }

    public final SparseArray<b> l() {
        return (SparseArray) this.f31383l.getValue();
    }

    public final SparseArray<c> m() {
        return (SparseArray) this.f31384m.getValue();
    }

    public int n(int i11) {
        return h.a.a(this, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(VH holder, int i11) {
        Intrinsics.g(holder, "holder");
        this.f31385n = i11 - holder.getAdapterPosition();
        holder.g(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2;
        Intrinsics.g(recyclerView, "recyclerView");
        this.f31381j = recyclerView;
        if ((recyclerView != null ? recyclerView.getLayoutManager() : null) != null || (recyclerView2 = this.f31381j) == null) {
            return;
        }
        recyclerView2.setLayoutManager(k(this.f31380i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.g(recyclerView, "recyclerView");
        this.f31381j = null;
    }

    public void p(int i11, b bVar) {
        j();
        l().put(i11, bVar);
    }

    public void q(d dVar) {
        j();
        this.f31382k = dVar;
    }
}
