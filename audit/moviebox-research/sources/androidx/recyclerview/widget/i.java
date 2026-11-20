package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView.a0;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i<T, VH extends RecyclerView.a0> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.a<T> mListener;

    /* JADX INFO: compiled from: source.java */
    public class a implements AsyncListDiffer.a<T> {
        public a() {
        }

        @Override // androidx.recyclerview.widget.AsyncListDiffer.a
        public void a(@NonNull List<T> list, @NonNull List<T> list2) {
            i.this.onCurrentListChanged(list, list2);
        }
    }

    public i(@NonNull DiffUtil.e<T> eVar) {
        a aVar = new a();
        this.mListener = aVar;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new b(this), new c.a(eVar).a());
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.a(aVar);
    }

    public i(@NonNull c<T> cVar) {
        a aVar = new a();
        this.mListener = aVar;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new b(this), cVar);
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.a(aVar);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mDiffer.b();
    }

    public T getItem(int i11) {
        return this.mDiffer.b().get(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.b().size();
    }

    public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
    }

    public void submitList(@Nullable List<T> list) {
        this.mDiffer.e(list);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        this.mDiffer.f(list, runnable);
    }
}
