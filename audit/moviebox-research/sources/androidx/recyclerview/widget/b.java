package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView.Adapter f12630a;

    public b(@NonNull RecyclerView.Adapter adapter) {
        this.f12630a = adapter;
    }

    @Override // androidx.recyclerview.widget.j
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i11, int i12, Object obj) {
        this.f12630a.notifyItemRangeChanged(i11, i12, obj);
    }

    @Override // androidx.recyclerview.widget.j
    public void onInserted(int i11, int i12) {
        this.f12630a.notifyItemRangeInserted(i11, i12);
    }

    @Override // androidx.recyclerview.widget.j
    public void onMoved(int i11, int i12) {
        this.f12630a.notifyItemMoved(i11, i12);
    }

    @Override // androidx.recyclerview.widget.j
    public void onRemoved(int i11, int i12) {
        this.f12630a.notifyItemRangeRemoved(i11, i12);
    }
}
