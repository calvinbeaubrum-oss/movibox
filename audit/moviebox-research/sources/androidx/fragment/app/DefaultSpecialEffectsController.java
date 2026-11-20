package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8403a;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            f8403a = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8403a[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8403a[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8403a[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f8404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f8405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f8406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f8407d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ e f8408f;

        public b(ViewGroup viewGroup, View view, boolean z11, SpecialEffectsController.Operation operation, e eVar) {
            this.f8404a = viewGroup;
            this.f8405b = view;
            this.f8406c = z11;
            this.f8407d = operation;
            this.f8408f = eVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f8404a.endViewTransition(this.f8405b);
            if (this.f8406c) {
                this.f8407d.e().applyState(this.f8405b);
            }
            this.f8408f.a();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animator from operation " + this.f8407d + " has ended.");
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class c implements androidx.core.os.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator f8410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f8411b;

        public c(Animator animator, SpecialEffectsController.Operation operation) {
            this.f8410a = animator;
            this.f8411b = operation;
        }

        @Override // androidx.core.os.d.a
        public void onCancel() {
            this.f8410a.end();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animator from operation " + this.f8411b + " has been canceled.");
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class d implements androidx.core.os.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f8413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f8414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f8415c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f8416d;

        public d(View view, ViewGroup viewGroup, e eVar, SpecialEffectsController.Operation operation) {
            this.f8413a = view;
            this.f8414b = viewGroup;
            this.f8415c = eVar;
            this.f8416d = operation;
        }

        @Override // androidx.core.os.d.a
        public void onCancel() {
            this.f8413a.clearAnimation();
            this.f8414b.endViewTransition(this.f8413a);
            this.f8415c.a();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animation from operation " + this.f8416d + " has been cancelled.");
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class e extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public FragmentAnim.a f8420e;

        public e(@NonNull SpecialEffectsController.Operation operation, @NonNull androidx.core.os.d dVar, boolean z11) {
            super(operation, dVar);
            this.f8419d = false;
            this.f8418c = z11;
        }

        @Nullable
        public FragmentAnim.a e(@NonNull Context context) {
            if (this.f8419d) {
                return this.f8420e;
            }
            FragmentAnim.a aVarB = FragmentAnim.b(context, b().f(), b().e() == SpecialEffectsController.Operation.State.VISIBLE, this.f8418c);
            this.f8420e = aVarB;
            this.f8419d = true;
            return aVarB;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final SpecialEffectsController.Operation f8421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final androidx.core.os.d f8422b;

        public f(@NonNull SpecialEffectsController.Operation operation, @NonNull androidx.core.os.d dVar) {
            this.f8421a = operation;
            this.f8422b = dVar;
        }

        public void a() {
            this.f8421a.d(this.f8422b);
        }

        @NonNull
        public SpecialEffectsController.Operation b() {
            return this.f8421a;
        }

        @NonNull
        public androidx.core.os.d c() {
            return this.f8422b;
        }

        public boolean d() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State stateFrom = SpecialEffectsController.Operation.State.from(this.f8421a.f().mView);
            SpecialEffectsController.Operation.State stateE = this.f8421a.e();
            return stateFrom == stateE || !(stateFrom == (state = SpecialEffectsController.Operation.State.VISIBLE) || stateE == state);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class g extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Object f8423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f8424d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final Object f8425e;

        public g(@NonNull SpecialEffectsController.Operation operation, @NonNull androidx.core.os.d dVar, boolean z11, boolean z12) {
            super(operation, dVar);
            if (operation.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.f8423c = z11 ? operation.f().getReenterTransition() : operation.f().getEnterTransition();
                this.f8424d = z11 ? operation.f().getAllowReturnTransitionOverlap() : operation.f().getAllowEnterTransitionOverlap();
            } else {
                this.f8423c = z11 ? operation.f().getReturnTransition() : operation.f().getExitTransition();
                this.f8424d = true;
            }
            if (!z12) {
                this.f8425e = null;
            } else if (z11) {
                this.f8425e = operation.f().getSharedElementReturnTransition();
            } else {
                this.f8425e = operation.f().getSharedElementEnterTransition();
            }
        }

        @Nullable
        public FragmentTransitionImpl e() {
            FragmentTransitionImpl fragmentTransitionImplF = f(this.f8423c);
            FragmentTransitionImpl fragmentTransitionImplF2 = f(this.f8425e);
            if (fragmentTransitionImplF == null || fragmentTransitionImplF2 == null || fragmentTransitionImplF == fragmentTransitionImplF2) {
                return fragmentTransitionImplF != null ? fragmentTransitionImplF : fragmentTransitionImplF2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f8423c + " which uses a different Transition  type than its shared element transition " + this.f8425e);
        }

        @Nullable
        public final FragmentTransitionImpl f(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = x.f8630a;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.e(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = x.f8631b;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.e(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        @Nullable
        public Object g() {
            return this.f8425e;
        }

        @Nullable
        public Object h() {
            return this.f8423c;
        }

        public boolean i() {
            return this.f8425e != null;
        }

        public boolean j() {
            return this.f8424d;
        }
    }

    public DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00a8  */
    @Override // androidx.fragment.app.SpecialEffectsController
    public void f(@NonNull List<SpecialEffectsController.Operation> list, boolean z11) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State stateFrom = SpecialEffectsController.Operation.State.from(operation3.f().mView);
            int i11 = a.f8403a[operation3.e().ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                if (stateFrom == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = operation3;
                }
            } else if (i11 == 4 && stateFrom != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = operation3;
            }
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Executing operations from " + operation + " to " + operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList(list);
        y(list);
        for (final SpecialEffectsController.Operation operation4 : list) {
            androidx.core.os.d dVar = new androidx.core.os.d();
            operation4.j(dVar);
            arrayList.add(new e(operation4, dVar, z11));
            androidx.core.os.d dVar2 = new androidx.core.os.d();
            operation4.j(dVar2);
            boolean z12 = false;
            if (z11) {
                if (operation4 == operation) {
                    z12 = true;
                }
            } else if (operation4 == operation2) {
                z12 = true;
            }
            arrayList2.add(new g(operation4, dVar2, z11, z12));
            operation4.a(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                @Override // java.lang.Runnable
                public void run() {
                    if (arrayList3.contains(operation4)) {
                        arrayList3.remove(operation4);
                        DefaultSpecialEffectsController.this.s(operation4);
                    }
                }
            });
        }
        Map<SpecialEffectsController.Operation, Boolean> mapX = x(arrayList2, arrayList3, z11, operation, operation2);
        w(arrayList, arrayList3, mapX.containsValue(Boolean.TRUE), mapX);
        Iterator<SpecialEffectsController.Operation> it = arrayList3.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        arrayList3.clear();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Completed executing operations from " + operation + " to " + operation2);
        }
    }

    public void s(@NonNull SpecialEffectsController.Operation operation) {
        operation.e().applyState(operation.f().mView);
    }

    public void t(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    public void u(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    public void v(@NonNull androidx.collection.a<String, View> aVar, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    public final void w(@NonNull List<e> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z11, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        int i11;
        boolean z12;
        Context context;
        View view;
        SpecialEffectsController.Operation operation;
        final ViewGroup viewGroupM = m();
        Context context2 = viewGroupM.getContext();
        ArrayList<e> arrayList = new ArrayList();
        Iterator<e> it = list.iterator();
        boolean z13 = false;
        while (true) {
            i11 = 2;
            if (!it.hasNext()) {
                break;
            }
            e next = it.next();
            if (next.d()) {
                next.a();
            } else {
                FragmentAnim.a aVarE = next.e(context2);
                if (aVarE == null) {
                    next.a();
                } else {
                    Animator animator = aVarE.f8467b;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        SpecialEffectsController.Operation operationB = next.b();
                        Fragment fragmentF = operationB.f();
                        if (Boolean.TRUE.equals(map.get(operationB))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragmentF + " as this Fragment was involved in a Transition.");
                            }
                            next.a();
                        } else {
                            boolean z14 = operationB.e() == SpecialEffectsController.Operation.State.GONE;
                            if (z14) {
                                list2.remove(operationB);
                            }
                            View view2 = fragmentF.mView;
                            viewGroupM.startViewTransition(view2);
                            animator.addListener(new b(viewGroupM, view2, z14, operationB, next));
                            animator.setTarget(view2);
                            animator.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Animator from operation ");
                                operation = operationB;
                                sb2.append(operation);
                                sb2.append(" has started.");
                                Log.v(FragmentManager.TAG, sb2.toString());
                            } else {
                                operation = operationB;
                            }
                            next.c().b(new c(animator, operation));
                            z13 = true;
                        }
                    }
                }
            }
        }
        for (final e eVar : arrayList) {
            final SpecialEffectsController.Operation operationB2 = eVar.b();
            Fragment fragmentF2 = operationB2.f();
            if (z11) {
                if (FragmentManager.isLoggingEnabled(i11)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Transitions.");
                }
                eVar.a();
            } else if (z13) {
                if (FragmentManager.isLoggingEnabled(i11)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Animators.");
                }
                eVar.a();
            } else {
                final View view3 = fragmentF2.mView;
                Animation animation = (Animation) androidx.core.util.i.g(((FragmentAnim.a) androidx.core.util.i.g(eVar.e(context2))).f8466a);
                if (operationB2.e() != SpecialEffectsController.Operation.State.REMOVED) {
                    view3.startAnimation(animation);
                    eVar.a();
                    z12 = z13;
                    context = context2;
                    view = view3;
                } else {
                    viewGroupM.startViewTransition(view3);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation, viewGroupM, view3);
                    z12 = z13;
                    context = context2;
                    view = view3;
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation2) {
                            viewGroupM.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    viewGroupM.endViewTransition(view3);
                                    eVar.a();
                                }
                            });
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animation from operation " + operationB2 + " has ended.");
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation2) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animation from operation " + operationB2 + " has reached onAnimationStart.");
                            }
                        }
                    });
                    view.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Animation from operation " + operationB2 + " has started.");
                    }
                }
                eVar.c().b(new d(view, viewGroupM, eVar, operationB2));
                z13 = z12;
                context2 = context;
                i11 = 2;
            }
        }
    }

    @NonNull
    public final Map<SpecialEffectsController.Operation, Boolean> x(@NonNull List<g> list, @NonNull List<SpecialEffectsController.Operation> list2, final boolean z11, @Nullable final SpecialEffectsController.Operation operation, @Nullable final SpecialEffectsController.Operation operation2) {
        String str;
        String str2;
        String str3;
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        HashMap map;
        View view2;
        Object objK;
        ArrayList<View> arrayList3;
        SpecialEffectsController.Operation operation3;
        HashMap map2;
        SpecialEffectsController.Operation operation4;
        View view3;
        final View view4;
        SpecialEffectsController.Operation operation5 = operation;
        SpecialEffectsController.Operation operation6 = operation2;
        HashMap map3 = new HashMap();
        final FragmentTransitionImpl fragmentTransitionImpl = null;
        for (g gVar : list) {
            if (!gVar.d()) {
                FragmentTransitionImpl fragmentTransitionImplE = gVar.e();
                if (fragmentTransitionImpl == null) {
                    fragmentTransitionImpl = fragmentTransitionImplE;
                } else if (fragmentTransitionImplE != null && fragmentTransitionImpl != fragmentTransitionImplE) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + gVar.b().f() + " returned Transition " + gVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl == null) {
            for (g gVar2 : list) {
                map3.put(gVar2.b(), Boolean.FALSE);
                gVar2.a();
            }
            return map3;
        }
        View view5 = new View(m().getContext());
        final Rect rect = new Rect();
        ArrayList<View> arrayList4 = new ArrayList<>();
        ArrayList<View> arrayList5 = new ArrayList<>();
        androidx.collection.a aVar = new androidx.collection.a();
        Iterator<g> it = list.iterator();
        Object obj3 = null;
        View view6 = null;
        boolean z12 = false;
        while (true) {
            boolean zHasNext = it.hasNext();
            str = FragmentManager.TAG;
            if (!zHasNext) {
                break;
            }
            g next = it.next();
            if (!next.i() || operation5 == null || operation6 == null) {
                arrayList3 = arrayList5;
                operation3 = operation5;
                map2 = map3;
                View view7 = view5;
                operation4 = operation6;
                view3 = view7;
                view6 = view6;
            } else {
                Object objU = fragmentTransitionImpl.u(fragmentTransitionImpl.f(next.g()));
                ArrayList<String> sharedElementSourceNames = operation2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.f().getSharedElementTargetNames();
                View view8 = view6;
                int i11 = 0;
                while (i11 < sharedElementTargetNames.size()) {
                    int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i11));
                    ArrayList<String> arrayList6 = sharedElementTargetNames;
                    if (iIndexOf != -1) {
                        sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i11));
                    }
                    i11++;
                    sharedElementTargetNames = arrayList6;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.f().getSharedElementTargetNames();
                if (z11 == 0) {
                    operation.f().getExitTransitionCallback();
                    operation2.f().getEnterTransitionCallback();
                } else {
                    operation.f().getEnterTransitionCallback();
                    operation2.f().getExitTransitionCallback();
                }
                int i12 = 0;
                for (int size = sharedElementSourceNames.size(); i12 < size; size = size) {
                    aVar.put(sharedElementSourceNames.get(i12), sharedElementTargetNames2.get(i12));
                    i12++;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, ">>> entering view names <<<");
                    for (Iterator<String> it2 = sharedElementTargetNames2.iterator(); it2.hasNext(); it2 = it2) {
                        Log.v(FragmentManager.TAG, "Name: " + it2.next());
                    }
                    Log.v(FragmentManager.TAG, ">>> exiting view names <<<");
                    for (Iterator<String> it3 = sharedElementSourceNames.iterator(); it3.hasNext(); it3 = it3) {
                        Log.v(FragmentManager.TAG, "Name: " + it3.next());
                    }
                }
                androidx.collection.a<String, View> aVar2 = new androidx.collection.a<>();
                u(aVar2, operation.f().mView);
                aVar2.retainAll(sharedElementSourceNames);
                aVar.retainAll(aVar2.keySet());
                final androidx.collection.a<String, View> aVar3 = new androidx.collection.a<>();
                u(aVar3, operation2.f().mView);
                aVar3.retainAll(sharedElementTargetNames2);
                aVar3.retainAll(aVar.values());
                x.c(aVar, aVar3);
                v(aVar2, aVar.keySet());
                v(aVar3, aVar.values());
                if (aVar.isEmpty()) {
                    arrayList4.clear();
                    arrayList5.clear();
                    arrayList3 = arrayList5;
                    operation3 = operation5;
                    view3 = view5;
                    view6 = view8;
                    obj3 = null;
                    operation4 = operation2;
                    map2 = map3;
                } else {
                    x.a(operation2.f(), operation.f(), z11, aVar2, true);
                    HashMap map4 = map3;
                    View view9 = view5;
                    ArrayList<View> arrayList7 = arrayList5;
                    OneShotPreDrawListener.add(m(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            x.a(operation2.f(), operation.f(), z11, aVar3, false);
                        }
                    });
                    arrayList4.addAll(aVar2.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        view6 = view8;
                    } else {
                        view6 = aVar2.get(sharedElementSourceNames.get(0));
                        fragmentTransitionImpl.p(objU, view6);
                    }
                    arrayList3 = arrayList7;
                    arrayList3.addAll(aVar3.values());
                    if (!sharedElementTargetNames2.isEmpty() && (view4 = aVar3.get(sharedElementTargetNames2.get(0))) != null) {
                        OneShotPreDrawListener.add(m(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                            @Override // java.lang.Runnable
                            public void run() {
                                fragmentTransitionImpl.h(view4, rect);
                            }
                        });
                        z12 = true;
                    }
                    fragmentTransitionImpl.s(objU, view9, arrayList4);
                    view3 = view9;
                    fragmentTransitionImpl.n(objU, null, null, null, null, objU, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    operation3 = operation;
                    map2 = map4;
                    map2.put(operation3, bool);
                    operation4 = operation2;
                    map2.put(operation4, bool);
                    obj3 = objU;
                }
            }
            operation5 = operation3;
            arrayList4 = arrayList4;
            rect = rect;
            map3 = map2;
            aVar = aVar;
            arrayList5 = arrayList3;
            fragmentTransitionImpl = fragmentTransitionImpl;
            SpecialEffectsController.Operation operation7 = operation4;
            view5 = view3;
            operation6 = operation7;
        }
        View view10 = view6;
        androidx.collection.a aVar4 = aVar;
        ArrayList<View> arrayList8 = arrayList5;
        SpecialEffectsController.Operation operation8 = operation5;
        ArrayList<View> arrayList9 = arrayList4;
        Rect rect2 = rect;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        HashMap map5 = map3;
        View view11 = view5;
        SpecialEffectsController.Operation operation9 = operation6;
        View view12 = view11;
        ArrayList arrayList10 = new ArrayList();
        Object obj4 = null;
        Object objK2 = null;
        for (g gVar3 : list) {
            if (gVar3.d()) {
                map5.put(gVar3.b(), Boolean.FALSE);
                gVar3.a();
            } else {
                Object objF = fragmentTransitionImpl2.f(gVar3.h());
                SpecialEffectsController.Operation operationB = gVar3.b();
                boolean z13 = obj3 != null && (operationB == operation8 || operationB == operation9);
                if (objF == null) {
                    if (!z13) {
                        map5.put(operationB, Boolean.FALSE);
                        gVar3.a();
                    }
                    arrayList2 = arrayList8;
                    str3 = str;
                    arrayList = arrayList9;
                    view = view12;
                    objK = obj4;
                    map = map5;
                    view2 = view10;
                } else {
                    str3 = str;
                    final ArrayList<View> arrayList11 = new ArrayList<>();
                    Object obj5 = obj4;
                    t(arrayList11, operationB.f().mView);
                    if (z13) {
                        if (operationB == operation8) {
                            arrayList11.removeAll(arrayList9);
                        } else {
                            arrayList11.removeAll(arrayList8);
                        }
                    }
                    if (arrayList11.isEmpty()) {
                        fragmentTransitionImpl2.a(objF, view12);
                        arrayList2 = arrayList8;
                        arrayList = arrayList9;
                        view = view12;
                        obj2 = objK2;
                        map = map5;
                        obj = obj5;
                    } else {
                        fragmentTransitionImpl2.b(objF, arrayList11);
                        view = view12;
                        obj = obj5;
                        arrayList = arrayList9;
                        obj2 = objK2;
                        arrayList2 = arrayList8;
                        map = map5;
                        fragmentTransitionImpl2.n(objF, objF, arrayList11, null, null, null, null);
                        if (operationB.e() == SpecialEffectsController.Operation.State.GONE) {
                            list2.remove(operationB);
                            ArrayList<View> arrayList12 = new ArrayList<>(arrayList11);
                            arrayList12.remove(operationB.f().mView);
                            fragmentTransitionImpl2.m(objF, operationB.f().mView, arrayList12);
                            OneShotPreDrawListener.add(m(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    x.d(arrayList11, 4);
                                }
                            });
                        }
                    }
                    if (operationB.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList10.addAll(arrayList11);
                        if (z12) {
                            fragmentTransitionImpl2.o(objF, rect2);
                        }
                        view2 = view10;
                    } else {
                        view2 = view10;
                        fragmentTransitionImpl2.p(objF, view2);
                    }
                    map.put(operationB, Boolean.TRUE);
                    if (gVar3.j()) {
                        objK2 = fragmentTransitionImpl2.k(obj2, objF, null);
                        objK = obj;
                    } else {
                        objK = fragmentTransitionImpl2.k(obj, objF, null);
                        objK2 = obj2;
                    }
                }
                operation9 = operation2;
                map5 = map;
                obj4 = objK;
                view10 = view2;
                str = str3;
                view12 = view;
                arrayList9 = arrayList;
                arrayList8 = arrayList2;
            }
        }
        ArrayList<View> arrayList13 = arrayList8;
        String str4 = str;
        ArrayList<View> arrayList14 = arrayList9;
        HashMap map6 = map5;
        Object objJ = fragmentTransitionImpl2.j(objK2, obj4, obj3);
        if (objJ == null) {
            return map6;
        }
        for (final g gVar4 : list) {
            if (!gVar4.d()) {
                Object objH = gVar4.h();
                final SpecialEffectsController.Operation operationB2 = gVar4.b();
                HashMap map7 = map6;
                boolean z14 = obj3 != null && (operationB2 == operation8 || operationB2 == operation2);
                if (objH == null && !z14) {
                    str2 = str4;
                } else if (ViewCompat.isLaidOut(m())) {
                    str2 = str4;
                    fragmentTransitionImpl2.q(gVar4.b().f(), objJ, gVar4.c(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                        @Override // java.lang.Runnable
                        public void run() {
                            gVar4.a();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Transition for operation " + operationB2 + "has completed");
                            }
                        }
                    });
                } else {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        str2 = str4;
                        Log.v(str2, "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + operationB2);
                    } else {
                        str2 = str4;
                    }
                    gVar4.a();
                }
                map6 = map7;
                str4 = str2;
            }
        }
        HashMap map8 = map6;
        String str5 = str4;
        if (!ViewCompat.isLaidOut(m())) {
            return map8;
        }
        x.d(arrayList10, 4);
        ArrayList<String> arrayListL = fragmentTransitionImpl2.l(arrayList13);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(str5, ">>>>> Beginning transition <<<<<");
            Log.v(str5, ">>>>> SharedElementFirstOutViews <<<<<");
            for (View view13 : arrayList14) {
                Log.v(str5, "View: " + view13 + " Name: " + ViewCompat.getTransitionName(view13));
            }
            Log.v(str5, ">>>>> SharedElementLastInViews <<<<<");
            for (View view14 : arrayList13) {
                Log.v(str5, "View: " + view14 + " Name: " + ViewCompat.getTransitionName(view14));
            }
        }
        fragmentTransitionImpl2.c(m(), objJ);
        fragmentTransitionImpl2.r(m(), arrayList14, arrayList13, arrayListL, aVar4);
        x.d(arrayList10, 0);
        fragmentTransitionImpl2.t(obj3, arrayList14, arrayList13);
        return map8;
    }

    public final void y(@NonNull List<SpecialEffectsController.Operation> list) {
        Fragment fragmentF = list.get(list.size() - 1).f();
        for (SpecialEffectsController.Operation operation : list) {
            operation.f().mAnimationInfo.f8447c = fragmentF.mAnimationInfo.f8447c;
            operation.f().mAnimationInfo.f8448d = fragmentF.mAnimationInfo.f8448d;
            operation.f().mAnimationInfo.f8449e = fragmentF.mAnimationInfo.f8449e;
            operation.f().mAnimationInfo.f8450f = fragmentF.mAnimationInfo.f8450f;
        }
    }
}
