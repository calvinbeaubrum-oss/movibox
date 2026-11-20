package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends RecyclerView.j {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations = true;

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateAdd(RecyclerView.a0 a0Var);

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean animateAppearance(@NonNull RecyclerView.a0 a0Var, @Nullable RecyclerView.j.c cVar, @NonNull RecyclerView.j.c cVar2) {
        int i11;
        int i12;
        return (cVar == null || ((i11 = cVar.f12538a) == (i12 = cVar2.f12538a) && cVar.f12539b == cVar2.f12539b)) ? animateAdd(a0Var) : animateMove(a0Var, i11, cVar.f12539b, i12, cVar2.f12539b);
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateChange(RecyclerView.a0 a0Var, RecyclerView.a0 a0Var2, int i11, int i12, int i13, int i14);

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean animateChange(@NonNull RecyclerView.a0 a0Var, @NonNull RecyclerView.a0 a0Var2, @NonNull RecyclerView.j.c cVar, @NonNull RecyclerView.j.c cVar2) {
        int i11;
        int i12;
        int i13 = cVar.f12538a;
        int i14 = cVar.f12539b;
        if (a0Var2.shouldIgnore()) {
            int i15 = cVar.f12538a;
            i12 = cVar.f12539b;
            i11 = i15;
        } else {
            i11 = cVar2.f12538a;
            i12 = cVar2.f12539b;
        }
        return animateChange(a0Var, a0Var2, i13, i14, i11, i12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean animateDisappearance(@NonNull RecyclerView.a0 a0Var, @NonNull RecyclerView.j.c cVar, @Nullable RecyclerView.j.c cVar2) {
        int i11 = cVar.f12538a;
        int i12 = cVar.f12539b;
        View view = a0Var.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f12538a;
        int top = cVar2 == null ? view.getTop() : cVar2.f12539b;
        if (a0Var.isRemoved() || (i11 == left && i12 == top)) {
            return animateRemove(a0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return animateMove(a0Var, i11, i12, left, top);
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateMove(RecyclerView.a0 a0Var, int i11, int i12, int i13, int i14);

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean animatePersistence(@NonNull RecyclerView.a0 a0Var, @NonNull RecyclerView.j.c cVar, @NonNull RecyclerView.j.c cVar2) {
        int i11 = cVar.f12538a;
        int i12 = cVar2.f12538a;
        if (i11 != i12 || cVar.f12539b != cVar2.f12539b) {
            return animateMove(a0Var, i11, cVar.f12539b, i12, cVar2.f12539b);
        }
        dispatchMoveFinished(a0Var);
        return false;
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateRemove(RecyclerView.a0 a0Var);

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.a0 a0Var) {
        return !this.mSupportsChangeAnimations || a0Var.isInvalid();
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchAddFinished(RecyclerView.a0 a0Var) {
        onAddFinished(a0Var);
        dispatchAnimationFinished(a0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchAddStarting(RecyclerView.a0 a0Var) {
        onAddStarting(a0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchChangeFinished(RecyclerView.a0 a0Var, boolean z11) {
        onChangeFinished(a0Var, z11);
        dispatchAnimationFinished(a0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchChangeStarting(RecyclerView.a0 a0Var, boolean z11) {
        onChangeStarting(a0Var, z11);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchMoveFinished(RecyclerView.a0 a0Var) {
        onMoveFinished(a0Var);
        dispatchAnimationFinished(a0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchMoveStarting(RecyclerView.a0 a0Var) {
        onMoveStarting(a0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchRemoveFinished(RecyclerView.a0 a0Var) {
        onRemoveFinished(a0Var);
        dispatchAnimationFinished(a0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchRemoveStarting(RecyclerView.a0 a0Var) {
        onRemoveStarting(a0Var);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    @SuppressLint({"UnknownNullness"})
    public void onAddFinished(RecyclerView.a0 a0Var) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onAddStarting(RecyclerView.a0 a0Var) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onChangeFinished(RecyclerView.a0 a0Var, boolean z11) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onChangeStarting(RecyclerView.a0 a0Var, boolean z11) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onMoveFinished(RecyclerView.a0 a0Var) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onMoveStarting(RecyclerView.a0 a0Var) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onRemoveFinished(RecyclerView.a0 a0Var) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onRemoveStarting(RecyclerView.a0 a0Var) {
    }

    public void setSupportsChangeAnimations(boolean z11) {
        this.mSupportsChangeAnimations = z11;
    }
}
