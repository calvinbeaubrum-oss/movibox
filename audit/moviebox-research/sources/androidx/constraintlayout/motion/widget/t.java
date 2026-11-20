package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionLayout f7149a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashSet<View> f7151c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<s.b> f7153e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<s> f7150b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7152d = "ViewTransitionController";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<s.b> f7154f = new ArrayList<>();

    /* JADX INFO: compiled from: source.java */
    public class a implements androidx.constraintlayout.widget.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f7155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f7157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f7158d;

        public a(s sVar, int i11, boolean z11, int i12) {
            this.f7155a = sVar;
            this.f7156b = i11;
            this.f7157c = z11;
            this.f7158d = i12;
        }
    }

    public t(MotionLayout motionLayout) {
        this.f7149a = motionLayout;
    }

    public void a(s sVar) {
        this.f7150b.add(sVar);
        this.f7151c = null;
        if (sVar.i() == 4) {
            h(sVar, true);
        } else if (sVar.i() == 5) {
            h(sVar, false);
        }
    }

    public void b(s.b bVar) {
        if (this.f7153e == null) {
            this.f7153e = new ArrayList<>();
        }
        this.f7153e.add(bVar);
    }

    public void c() {
        ArrayList<s.b> arrayList = this.f7153e;
        if (arrayList == null) {
            return;
        }
        Iterator<s.b> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f7153e.removeAll(this.f7154f);
        this.f7154f.clear();
        if (this.f7153e.isEmpty()) {
            this.f7153e = null;
        }
    }

    public boolean d(int i11, m mVar) {
        for (s sVar : this.f7150b) {
            if (sVar.e() == i11) {
                sVar.f7116f.a(mVar);
                return true;
            }
        }
        return false;
    }

    public void e(int i11, boolean z11) {
        for (s sVar : this.f7150b) {
            if (sVar.e() == i11) {
                sVar.n(z11);
                return;
            }
        }
    }

    public void f() {
        this.f7149a.invalidate();
    }

    public boolean g(int i11) {
        for (s sVar : this.f7150b) {
            if (sVar.e() == i11) {
                return sVar.j();
            }
        }
        return false;
    }

    public final void h(s sVar, boolean z11) {
        ConstraintLayout.getSharedValues().a(sVar.h(), new a(sVar, sVar.h(), z11, sVar.g()));
    }

    public void i(s.b bVar) {
        this.f7154f.add(bVar);
    }

    public void j(MotionEvent motionEvent) {
        int currentState = this.f7149a.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.f7151c == null) {
            this.f7151c = new HashSet<>();
            for (s sVar : this.f7150b) {
                int childCount = this.f7149a.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = this.f7149a.getChildAt(i11);
                    if (sVar.l(childAt)) {
                        childAt.getId();
                        this.f7151c.add(childAt);
                    }
                }
            }
        }
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        ArrayList<s.b> arrayList = this.f7153e;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<s.b> it = this.f7153e.iterator();
            while (it.hasNext()) {
                it.next().d(action, x11, y11);
            }
        }
        if (action == 0 || action == 1) {
            androidx.constraintlayout.widget.b constraintSet = this.f7149a.getConstraintSet(currentState);
            Iterator<s> it2 = this.f7150b.iterator();
            while (it2.hasNext()) {
                s next = it2.next();
                if (next.o(action)) {
                    for (View view : this.f7151c) {
                        if (next.l(view)) {
                            view.getHitRect(rect);
                            if (rect.contains((int) x11, (int) y11)) {
                                next.c(this, this.f7149a, currentState, constraintSet, view);
                            }
                            next = next;
                        }
                    }
                }
            }
        }
    }

    public void k(int i11, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        s sVar = null;
        for (s sVar2 : this.f7150b) {
            if (sVar2.e() == i11) {
                for (View view : viewArr) {
                    if (sVar2.d(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    l(sVar2, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                sVar = sVar2;
            }
        }
        if (sVar == null) {
            Log.e(this.f7152d, " Could not find ViewTransition");
        }
    }

    public final void l(s sVar, View... viewArr) {
        int currentState = this.f7149a.getCurrentState();
        if (sVar.f7115e == 2) {
            sVar.c(this, this.f7149a, currentState, null, viewArr);
            return;
        }
        if (currentState != -1) {
            androidx.constraintlayout.widget.b constraintSet = this.f7149a.getConstraintSet(currentState);
            if (constraintSet == null) {
                return;
            }
            sVar.c(this, this.f7149a, currentState, constraintSet, viewArr);
            return;
        }
        Log.w(this.f7152d, "No support for ViewTransition within transition yet. Currently: " + this.f7149a.toString());
    }
}
