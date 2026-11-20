package androidx.recyclerview.widget;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ItemTouchHelper extends RecyclerView.l implements RecyclerView.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView.a0 f12506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public a f12507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f12508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f12509d;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.ItemTouchHelper$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ ItemTouchHelper this$0;

        public AnonymousClass1(ItemTouchHelper itemTouchHelper) {
        }

        @Override // java.lang.Runnable
        public void run() {
            ItemTouchHelper itemTouchHelper = this.this$0;
            if (itemTouchHelper.f12506a == null || !itemTouchHelper.f()) {
                return;
            }
            ItemTouchHelper itemTouchHelper2 = this.this$0;
            RecyclerView.a0 a0Var = itemTouchHelper2.f12506a;
            if (a0Var != null) {
                itemTouchHelper2.e(a0Var);
            }
            ItemTouchHelper itemTouchHelper3 = this.this$0;
            itemTouchHelper3.f12508c.removeCallbacks(itemTouchHelper3.f12509d);
            ViewCompat.postOnAnimation(this.this$0.f12508c, this);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.ItemTouchHelper$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ ItemTouchHelper this$0;
        final /* synthetic */ b val$anim;
        final /* synthetic */ int val$swipeDir;

        public AnonymousClass4(ItemTouchHelper itemTouchHelper, b bVar, int i11) {
            this.val$swipeDir = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = this.this$0.f12508c;
            if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            b bVar = this.val$anim;
            if (bVar.f12511b || bVar.f12510a.getAbsoluteAdapterPosition() == -1) {
                return;
            }
            RecyclerView.j itemAnimator = this.this$0.f12508c.getItemAnimator();
            if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !this.this$0.d()) {
                this.this$0.f12507b.a(this.val$anim.f12510a, this.val$swipeDir);
            } else {
                this.this$0.f12508c.post(this);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        public abstract void a(@NonNull RecyclerView.a0 a0Var, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.a0 f12510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12511b;
    }

    public boolean d() {
        throw null;
    }

    public void e(RecyclerView.a0 a0Var) {
        throw null;
    }

    public boolean f() {
        throw null;
    }
}
