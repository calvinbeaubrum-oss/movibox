package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultItemAnimator extends p {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    private ArrayList<RecyclerView.a0> mPendingRemovals = new ArrayList<>();
    private ArrayList<RecyclerView.a0> mPendingAdditions = new ArrayList<>();
    private ArrayList<g> mPendingMoves = new ArrayList<>();
    private ArrayList<f> mPendingChanges = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.a0>> mAdditionsList = new ArrayList<>();
    ArrayList<ArrayList<g>> mMovesList = new ArrayList<>();
    ArrayList<ArrayList<f>> mChangesList = new ArrayList<>();
    ArrayList<RecyclerView.a0> mAddAnimations = new ArrayList<>();
    ArrayList<RecyclerView.a0> mMoveAnimations = new ArrayList<>();
    ArrayList<RecyclerView.a0> mRemoveAnimations = new ArrayList<>();
    ArrayList<RecyclerView.a0> mChangeAnimations = new ArrayList<>();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.a0 f12403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f12404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f12405c;

        public a(RecyclerView.a0 a0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f12403a = a0Var;
            this.f12404b = viewPropertyAnimator;
            this.f12405c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f12404b.setListener(null);
            this.f12405c.setAlpha(1.0f);
            DefaultItemAnimator.this.dispatchRemoveFinished(this.f12403a);
            DefaultItemAnimator.this.mRemoveAnimations.remove(this.f12403a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchRemoveStarting(this.f12403a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.a0 f12407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f12408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f12409c;

        public b(RecyclerView.a0 a0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f12407a = a0Var;
            this.f12408b = view;
            this.f12409c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f12408b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f12409c.setListener(null);
            DefaultItemAnimator.this.dispatchAddFinished(this.f12407a);
            DefaultItemAnimator.this.mAddAnimations.remove(this.f12407a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchAddStarting(this.f12407a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.a0 f12411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f12413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f12414d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f12415f;

        public c(RecyclerView.a0 a0Var, int i11, View view, int i12, ViewPropertyAnimator viewPropertyAnimator) {
            this.f12411a = a0Var;
            this.f12412b = i11;
            this.f12413c = view;
            this.f12414d = i12;
            this.f12415f = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f12412b != 0) {
                this.f12413c.setTranslationX(0.0f);
            }
            if (this.f12414d != 0) {
                this.f12413c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f12415f.setListener(null);
            DefaultItemAnimator.this.dispatchMoveFinished(this.f12411a);
            DefaultItemAnimator.this.mMoveAnimations.remove(this.f12411a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchMoveStarting(this.f12411a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f12417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f12418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f12419c;

        public d(f fVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f12417a = fVar;
            this.f12418b = viewPropertyAnimator;
            this.f12419c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f12418b.setListener(null);
            this.f12419c.setAlpha(1.0f);
            this.f12419c.setTranslationX(0.0f);
            this.f12419c.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.f12417a.f12425a, true);
            DefaultItemAnimator.this.mChangeAnimations.remove(this.f12417a.f12425a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.f12417a.f12425a, true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f12421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f12422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f12423c;

        public e(f fVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f12421a = fVar;
            this.f12422b = viewPropertyAnimator;
            this.f12423c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f12422b.setListener(null);
            this.f12423c.setAlpha(1.0f);
            this.f12423c.setTranslationX(0.0f);
            this.f12423c.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.f12421a.f12426b, false);
            DefaultItemAnimator.this.mChangeAnimations.remove(this.f12421a.f12426b);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.f12421a.f12426b, false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.a0 f12425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.a0 f12426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12428d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12429e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12430f;

        public f(RecyclerView.a0 a0Var, RecyclerView.a0 a0Var2) {
            this.f12425a = a0Var;
            this.f12426b = a0Var2;
        }

        public f(RecyclerView.a0 a0Var, RecyclerView.a0 a0Var2, int i11, int i12, int i13, int i14) {
            this(a0Var, a0Var2);
            this.f12427c = i11;
            this.f12428d = i12;
            this.f12429e = i13;
            this.f12430f = i14;
        }

        @SuppressLint({"UnknownNullness"})
        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f12425a + ", newHolder=" + this.f12426b + ", fromX=" + this.f12427c + ", fromY=" + this.f12428d + ", toX=" + this.f12429e + ", toY=" + this.f12430f + '}';
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.a0 f12431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12434d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12435e;

        public g(RecyclerView.a0 a0Var, int i11, int i12, int i13, int i14) {
            this.f12431a = a0Var;
            this.f12432b = i11;
            this.f12433c = i12;
            this.f12434d = i13;
            this.f12435e = i14;
        }
    }

    private void animateRemoveImpl(RecyclerView.a0 a0Var) {
        View view = a0Var.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mRemoveAnimations.add(a0Var);
        viewPropertyAnimatorAnimate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new a(a0Var, viewPropertyAnimatorAnimate, view)).start();
    }

    private void endChangeAnimation(List<f> list, RecyclerView.a0 a0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            f fVar = list.get(size);
            if (endChangeAnimationIfNecessary(fVar, a0Var) && fVar.f12425a == null && fVar.f12426b == null) {
                list.remove(fVar);
            }
        }
    }

    private void endChangeAnimationIfNecessary(f fVar) {
        RecyclerView.a0 a0Var = fVar.f12425a;
        if (a0Var != null) {
            endChangeAnimationIfNecessary(fVar, a0Var);
        }
        RecyclerView.a0 a0Var2 = fVar.f12426b;
        if (a0Var2 != null) {
            endChangeAnimationIfNecessary(fVar, a0Var2);
        }
    }

    private boolean endChangeAnimationIfNecessary(f fVar, RecyclerView.a0 a0Var) {
        boolean z11 = false;
        if (fVar.f12426b == a0Var) {
            fVar.f12426b = null;
        } else {
            if (fVar.f12425a != a0Var) {
                return false;
            }
            fVar.f12425a = null;
            z11 = true;
        }
        a0Var.itemView.setAlpha(1.0f);
        a0Var.itemView.setTranslationX(0.0f);
        a0Var.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(a0Var, z11);
        return true;
    }

    private void resetAnimation(RecyclerView.a0 a0Var) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        a0Var.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(a0Var);
    }

    @Override // androidx.recyclerview.widget.p
    @SuppressLint({"UnknownNullness"})
    public boolean animateAdd(RecyclerView.a0 a0Var) {
        resetAnimation(a0Var);
        a0Var.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(a0Var);
        return true;
    }

    public void animateAddImpl(RecyclerView.a0 a0Var) {
        View view = a0Var.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mAddAnimations.add(a0Var);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(getAddDuration()).setListener(new b(a0Var, view, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.widget.p
    @SuppressLint({"UnknownNullness"})
    public boolean animateChange(RecyclerView.a0 a0Var, RecyclerView.a0 a0Var2, int i11, int i12, int i13, int i14) {
        if (a0Var == a0Var2) {
            return animateMove(a0Var, i11, i12, i13, i14);
        }
        float translationX = a0Var.itemView.getTranslationX();
        float translationY = a0Var.itemView.getTranslationY();
        float alpha = a0Var.itemView.getAlpha();
        resetAnimation(a0Var);
        int i15 = (int) ((i13 - i11) - translationX);
        int i16 = (int) ((i14 - i12) - translationY);
        a0Var.itemView.setTranslationX(translationX);
        a0Var.itemView.setTranslationY(translationY);
        a0Var.itemView.setAlpha(alpha);
        if (a0Var2 != null) {
            resetAnimation(a0Var2);
            a0Var2.itemView.setTranslationX(-i15);
            a0Var2.itemView.setTranslationY(-i16);
            a0Var2.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new f(a0Var, a0Var2, i11, i12, i13, i14));
        return true;
    }

    public void animateChangeImpl(f fVar) {
        RecyclerView.a0 a0Var = fVar.f12425a;
        View view = a0Var == null ? null : a0Var.itemView;
        RecyclerView.a0 a0Var2 = fVar.f12426b;
        View view2 = a0Var2 != null ? a0Var2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(fVar.f12425a);
            duration.translationX(fVar.f12429e - fVar.f12427c);
            duration.translationY(fVar.f12430f - fVar.f12428d);
            duration.alpha(0.0f).setListener(new d(fVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.mChangeAnimations.add(fVar.f12426b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new e(fVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    @Override // androidx.recyclerview.widget.p
    @SuppressLint({"UnknownNullness"})
    public boolean animateMove(RecyclerView.a0 a0Var, int i11, int i12, int i13, int i14) {
        View view = a0Var.itemView;
        int translationX = i11 + ((int) view.getTranslationX());
        int translationY = i12 + ((int) a0Var.itemView.getTranslationY());
        resetAnimation(a0Var);
        int i15 = i13 - translationX;
        int i16 = i14 - translationY;
        if (i15 == 0 && i16 == 0) {
            dispatchMoveFinished(a0Var);
            return false;
        }
        if (i15 != 0) {
            view.setTranslationX(-i15);
        }
        if (i16 != 0) {
            view.setTranslationY(-i16);
        }
        this.mPendingMoves.add(new g(a0Var, translationX, translationY, i13, i14));
        return true;
    }

    public void animateMoveImpl(RecyclerView.a0 a0Var, int i11, int i12, int i13, int i14) {
        View view = a0Var.itemView;
        int i15 = i13 - i11;
        int i16 = i14 - i12;
        if (i15 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i16 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mMoveAnimations.add(a0Var);
        viewPropertyAnimatorAnimate.setDuration(getMoveDuration()).setListener(new c(a0Var, i15, view, i16, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.widget.p
    @SuppressLint({"UnknownNullness"})
    public boolean animateRemove(RecyclerView.a0 a0Var) {
        resetAnimation(a0Var);
        this.mPendingRemovals.add(a0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.a0 a0Var, @NonNull List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(a0Var, list);
    }

    public void cancelAll(List<RecyclerView.a0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    public void dispatchFinishedWhenDone() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    @SuppressLint({"UnknownNullness"})
    public void endAnimation(RecyclerView.a0 a0Var) {
        View view = a0Var.itemView;
        view.animate().cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.mPendingMoves.get(size).f12431a == a0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(a0Var);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, a0Var);
        if (this.mPendingRemovals.remove(a0Var)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(a0Var);
        }
        if (this.mPendingAdditions.remove(a0Var)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(a0Var);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList<f> arrayList = this.mChangesList.get(size2);
            endChangeAnimation(arrayList, a0Var);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList<g> arrayList2 = this.mMovesList.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (arrayList2.get(size4).f12431a == a0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(a0Var);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.mMovesList.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.a0> arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(a0Var)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(a0Var);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(a0Var);
        this.mAddAnimations.remove(a0Var);
        this.mChangeAnimations.remove(a0Var);
        this.mMoveAnimations.remove(a0Var);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            g gVar = this.mPendingMoves.get(size);
            View view = gVar.f12431a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(gVar.f12431a);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2));
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.a0 a0Var = this.mPendingAdditions.get(size3);
            a0Var.itemView.setAlpha(1.0f);
            dispatchAddFinished(a0Var);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList<g> arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    g gVar2 = arrayList.get(size6);
                    View view2 = gVar2.f12431a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(gVar2.f12431a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.a0> arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.a0 a0Var2 = arrayList2.get(size8);
                    a0Var2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(a0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList<f> arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    endChangeAnimationIfNecessary(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean isRunning() {
        return (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void runPendingAnimations() {
        boolean z11 = !this.mPendingRemovals.isEmpty();
        boolean z12 = !this.mPendingMoves.isEmpty();
        boolean z13 = !this.mPendingChanges.isEmpty();
        boolean z14 = !this.mPendingAdditions.isEmpty();
        if (z11 || z12 || z14 || z13) {
            Iterator<RecyclerView.a0> it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.mPendingRemovals.clear();
            if (z12) {
                final ArrayList<g> arrayList = new ArrayList<>();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (g gVar : arrayList) {
                            DefaultItemAnimator.this.animateMoveImpl(gVar.f12431a, gVar.f12432b, gVar.f12433c, gVar.f12434d, gVar.f12435e);
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.mMovesList.remove(arrayList);
                    }
                };
                if (z11) {
                    ViewCompat.postOnAnimationDelayed(arrayList.get(0).f12431a.itemView, runnable, getRemoveDuration());
                } else {
                    runnable.run();
                }
            }
            if (z13) {
                final ArrayList<f> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList2);
                this.mPendingChanges.clear();
                Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.animateChangeImpl((f) it2.next());
                        }
                        arrayList2.clear();
                        DefaultItemAnimator.this.mChangesList.remove(arrayList2);
                    }
                };
                if (z11) {
                    ViewCompat.postOnAnimationDelayed(arrayList2.get(0).f12425a.itemView, runnable2, getRemoveDuration());
                } else {
                    runnable2.run();
                }
            }
            if (z14) {
                final ArrayList<RecyclerView.a0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList3);
                this.mPendingAdditions.clear();
                Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.animateAddImpl((RecyclerView.a0) it2.next());
                        }
                        arrayList3.clear();
                        DefaultItemAnimator.this.mAdditionsList.remove(arrayList3);
                    }
                };
                if (z11 || z12 || z13) {
                    ViewCompat.postOnAnimationDelayed(arrayList3.get(0).itemView, runnable3, (z11 ? getRemoveDuration() : 0L) + Math.max(z12 ? getMoveDuration() : 0L, z13 ? getChangeDuration() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }
}
