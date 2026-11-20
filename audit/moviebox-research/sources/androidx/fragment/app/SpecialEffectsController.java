package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class SpecialEffectsController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f8557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Operation> f8558b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Operation> f8559c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8560d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8561e = false;

    /* JADX INFO: compiled from: source.java */
    public static class Operation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public State f8562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public LifecycleImpact f8563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public final Fragment f8564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        public final List<Runnable> f8565d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NonNull
        public final HashSet<androidx.core.os.d> f8566e = new HashSet<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8567f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f8568g = false;

        /* JADX INFO: compiled from: source.java */
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX INFO: compiled from: source.java */
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            @NonNull
            public static State from(int i11) {
                if (i11 == 0) {
                    return VISIBLE;
                }
                if (i11 == 4) {
                    return INVISIBLE;
                }
                if (i11 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i11);
            }

            @NonNull
            public static State from(@NonNull View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : from(view.getVisibility());
            }

            public void applyState(@NonNull View view) {
                int i11 = a.f8570a[ordinal()];
                if (i11 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i11 == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i11 == 3) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i11 != 4) {
                    return;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        public class a implements androidx.core.os.d.a {
            public a() {
            }

            @Override // androidx.core.os.d.a
            public void onCancel() {
                Operation.this.b();
            }
        }

        public Operation(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact, @NonNull Fragment fragment, @NonNull androidx.core.os.d dVar) {
            this.f8562a = state;
            this.f8563b = lifecycleImpact;
            this.f8564c = fragment;
            dVar.b(new a());
        }

        public final void a(@NonNull Runnable runnable) {
            this.f8565d.add(runnable);
        }

        public final void b() {
            if (h()) {
                return;
            }
            this.f8567f = true;
            if (this.f8566e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f8566e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.d) it.next()).a();
            }
        }

        @CallSuper
        public void c() {
            if (this.f8568g) {
                return;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f8568g = true;
            Iterator<Runnable> it = this.f8565d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        public final void d(@NonNull androidx.core.os.d dVar) {
            if (this.f8566e.remove(dVar) && this.f8566e.isEmpty()) {
                c();
            }
        }

        @NonNull
        public State e() {
            return this.f8562a;
        }

        @NonNull
        public final Fragment f() {
            return this.f8564c;
        }

        @NonNull
        public LifecycleImpact g() {
            return this.f8563b;
        }

        public final boolean h() {
            return this.f8567f;
        }

        public final boolean i() {
            return this.f8568g;
        }

        public final void j(@NonNull androidx.core.os.d dVar) {
            l();
            this.f8566e.add(dVar);
        }

        public final void k(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact) {
            int i11 = a.f8571b[lifecycleImpact.ordinal()];
            if (i11 == 1) {
                if (this.f8562a == State.REMOVED) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.f8564c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f8563b + " to ADDING.");
                    }
                    this.f8562a = State.VISIBLE;
                    this.f8563b = LifecycleImpact.ADDING;
                    return;
                }
                return;
            }
            if (i11 == 2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.f8564c + " mFinalState = " + this.f8562a + " -> REMOVED. mLifecycleImpact  = " + this.f8563b + " to REMOVING.");
                }
                this.f8562a = State.REMOVED;
                this.f8563b = LifecycleImpact.REMOVING;
                return;
            }
            if (i11 == 3 && this.f8562a != State.REMOVED) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.f8564c + " mFinalState = " + this.f8562a + " -> " + state + ". ");
                }
                this.f8562a = state;
            }
        }

        public void l() {
        }

        @NonNull
        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f8562a + "} {mLifecycleImpact = " + this.f8563b + "} {mFragment = " + this.f8564c + "}";
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f8571b;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            f8571b = iArr;
            try {
                iArr[Operation.LifecycleImpact.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8571b[Operation.LifecycleImpact.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8571b[Operation.LifecycleImpact.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Operation.State.values().length];
            f8570a = iArr2;
            try {
                iArr2[Operation.State.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8570a[Operation.State.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8570a[Operation.State.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8570a[Operation.State.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class b extends Operation {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NonNull
        public final v f8572h;

        public b(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull v vVar, @NonNull androidx.core.os.d dVar) {
            super(state, lifecycleImpact, vVar.k(), dVar);
            this.f8572h = vVar;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void c() {
            super.c();
            this.f8572h.m();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void l() {
            if (g() != Operation.LifecycleImpact.ADDING) {
                if (g() == Operation.LifecycleImpact.REMOVING) {
                    Fragment fragmentK = this.f8572h.k();
                    View viewRequireView = fragmentK.requireView();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + fragmentK);
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragmentK2 = this.f8572h.k();
            View viewFindFocus = fragmentK2.mView.findFocus();
            if (viewFindFocus != null) {
                fragmentK2.setFocusedView(viewFindFocus);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK2);
                }
            }
            View viewRequireView2 = f().requireView();
            if (viewRequireView2.getParent() == null) {
                this.f8572h.b();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(fragmentK2.getPostOnViewCreatedAlpha());
        }
    }

    public SpecialEffectsController(@NonNull ViewGroup viewGroup) {
        this.f8557a = viewGroup;
    }

    @NonNull
    public static SpecialEffectsController n(@NonNull ViewGroup viewGroup, @NonNull FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
    }

    @NonNull
    public static SpecialEffectsController o(@NonNull ViewGroup viewGroup, @NonNull b0 b0Var) {
        Object tag = viewGroup.getTag(R$id.special_effects_controller_view_tag);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController specialEffectsControllerA = b0Var.a(viewGroup);
        viewGroup.setTag(R$id.special_effects_controller_view_tag, specialEffectsControllerA);
        return specialEffectsControllerA;
    }

    public final void a(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull v vVar) {
        synchronized (this.f8558b) {
            try {
                androidx.core.os.d dVar = new androidx.core.os.d();
                Operation operationH = h(vVar.k());
                if (operationH != null) {
                    operationH.k(state, lifecycleImpact);
                    return;
                }
                final b bVar = new b(state, lifecycleImpact, vVar, dVar);
                this.f8558b.add(bVar);
                bVar.a(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SpecialEffectsController.this.f8558b.contains(bVar)) {
                            bVar.e().applyState(bVar.f().mView);
                        }
                    }
                });
                bVar.a(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SpecialEffectsController.this.f8558b.remove(bVar);
                        SpecialEffectsController.this.f8559c.remove(bVar);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(@NonNull Operation.State state, @NonNull v vVar) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing add operation for fragment " + vVar.k());
        }
        a(state, Operation.LifecycleImpact.ADDING, vVar);
    }

    public void c(@NonNull v vVar) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing hide operation for fragment " + vVar.k());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, vVar);
    }

    public void d(@NonNull v vVar) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing remove operation for fragment " + vVar.k());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, vVar);
    }

    public void e(@NonNull v vVar) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing show operation for fragment " + vVar.k());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, vVar);
    }

    public abstract void f(@NonNull List<Operation> list, boolean z11);

    public void g() {
        if (this.f8561e) {
            return;
        }
        if (!ViewCompat.isAttachedToWindow(this.f8557a)) {
            j();
            this.f8560d = false;
            return;
        }
        synchronized (this.f8558b) {
            try {
                if (!this.f8558b.isEmpty()) {
                    ArrayList<Operation> arrayList = new ArrayList(this.f8559c);
                    this.f8559c.clear();
                    for (Operation operation : arrayList) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Cancelling operation " + operation);
                        }
                        operation.b();
                        if (!operation.i()) {
                            this.f8559c.add(operation);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f8558b);
                    this.f8558b.clear();
                    this.f8559c.addAll(arrayList2);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Operation) it.next()).l();
                    }
                    f(arrayList2, this.f8560d);
                    this.f8560d = false;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    public final Operation h(@NonNull Fragment fragment) {
        for (Operation operation : this.f8558b) {
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    @Nullable
    public final Operation i(@NonNull Fragment fragment) {
        for (Operation operation : this.f8559c) {
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    public void j() {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = ViewCompat.isAttachedToWindow(this.f8557a);
        synchronized (this.f8558b) {
            try {
                q();
                Iterator<Operation> it = this.f8558b.iterator();
                while (it.hasNext()) {
                    it.next().l();
                }
                for (Operation operation : new ArrayList(this.f8559c)) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        sb2.append(zIsAttachedToWindow ? "" : "Container " + this.f8557a + " is not attached to window. ");
                        sb2.append("Cancelling running operation ");
                        sb2.append(operation);
                        Log.v(FragmentManager.TAG, sb2.toString());
                    }
                    operation.b();
                }
                for (Operation operation2 : new ArrayList(this.f8558b)) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: ");
                        sb3.append(zIsAttachedToWindow ? "" : "Container " + this.f8557a + " is not attached to window. ");
                        sb3.append("Cancelling pending operation ");
                        sb3.append(operation2);
                        Log.v(FragmentManager.TAG, sb3.toString());
                    }
                    operation2.b();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void k() {
        if (this.f8561e) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing postponed operations");
            }
            this.f8561e = false;
            g();
        }
    }

    @Nullable
    public Operation.LifecycleImpact l(@NonNull v vVar) {
        Operation operationH = h(vVar.k());
        Operation.LifecycleImpact lifecycleImpactG = operationH != null ? operationH.g() : null;
        Operation operationI = i(vVar.k());
        return (operationI == null || !(lifecycleImpactG == null || lifecycleImpactG == Operation.LifecycleImpact.NONE)) ? lifecycleImpactG : operationI.g();
    }

    @NonNull
    public ViewGroup m() {
        return this.f8557a;
    }

    public void p() {
        synchronized (this.f8558b) {
            try {
                q();
                this.f8561e = false;
                for (int size = this.f8558b.size() - 1; size >= 0; size--) {
                    Operation operation = this.f8558b.get(size);
                    Operation.State stateFrom = Operation.State.from(operation.f().mView);
                    Operation.State stateE = operation.e();
                    Operation.State state = Operation.State.VISIBLE;
                    if (stateE == state && stateFrom != state) {
                        this.f8561e = operation.f().isPostponed();
                        break;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void q() {
        for (Operation operation : this.f8558b) {
            if (operation.g() == Operation.LifecycleImpact.ADDING) {
                operation.k(Operation.State.from(operation.f().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public void r(boolean z11) {
        this.f8560d = z11;
    }
}
