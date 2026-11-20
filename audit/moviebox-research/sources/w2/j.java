package w2;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f79185g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f79187b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f79189d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f79186a = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f79188c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<a> f79190e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f79191f = -1;

    /* JADX INFO: compiled from: source.java */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<ConstraintWidget> f79192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f79193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f79194c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f79195d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f79196e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f79197f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f79198g;

        public a(ConstraintWidget constraintWidget, androidx.constraintlayout.core.d dVar, int i11) {
            this.f79192a = new WeakReference<>(constraintWidget);
            this.f79193b = dVar.y(constraintWidget.Q);
            this.f79194c = dVar.y(constraintWidget.R);
            this.f79195d = dVar.y(constraintWidget.S);
            this.f79196e = dVar.y(constraintWidget.T);
            this.f79197f = dVar.y(constraintWidget.U);
            this.f79198g = i11;
        }
    }

    public j(int i11) {
        int i12 = f79185g;
        f79185g = i12 + 1;
        this.f79187b = i12;
        this.f79189d = i11;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f79186a.contains(constraintWidget)) {
            return false;
        }
        this.f79186a.add(constraintWidget);
        return true;
    }

    public void b(ArrayList<j> arrayList) {
        int size = this.f79186a.size();
        if (this.f79191f != -1 && size > 0) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                j jVar = arrayList.get(i11);
                if (this.f79191f == jVar.f79187b) {
                    g(this.f79189d, jVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f79187b;
    }

    public int d() {
        return this.f79189d;
    }

    public final String e() {
        int i11 = this.f79189d;
        if (i11 == 0) {
            return "Horizontal";
        }
        if (i11 == 1) {
            return "Vertical";
        }
        return i11 == 2 ? "Both" : "Unknown";
    }

    public int f(androidx.constraintlayout.core.d dVar, int i11) {
        if (this.f79186a.size() == 0) {
            return 0;
        }
        return j(dVar, this.f79186a, i11);
    }

    public void g(int i11, j jVar) {
        for (ConstraintWidget constraintWidget : this.f79186a) {
            jVar.a(constraintWidget);
            if (i11 == 0) {
                constraintWidget.S0 = jVar.c();
            } else {
                constraintWidget.T0 = jVar.c();
            }
        }
        this.f79191f = jVar.f79187b;
    }

    public void h(boolean z11) {
        this.f79188c = z11;
    }

    public void i(int i11) {
        this.f79189d = i11;
    }

    public final int j(androidx.constraintlayout.core.d dVar, ArrayList<ConstraintWidget> arrayList, int i11) {
        int iY;
        int iY2;
        androidx.constraintlayout.core.widgets.d dVar2 = (androidx.constraintlayout.core.widgets.d) arrayList.get(0).M();
        dVar.E();
        dVar2.g(dVar, false);
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            arrayList.get(i12).g(dVar, false);
        }
        if (i11 == 0 && dVar2.f6641g1 > 0) {
            androidx.constraintlayout.core.widgets.b.b(dVar2, dVar, arrayList, 0);
        }
        if (i11 == 1 && dVar2.f6642h1 > 0) {
            androidx.constraintlayout.core.widgets.b.b(dVar2, dVar, arrayList, 1);
        }
        try {
            dVar.A();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f79190e = new ArrayList<>();
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            this.f79190e.add(new a(arrayList.get(i13), dVar, i11));
        }
        if (i11 == 0) {
            iY = dVar.y(dVar2.Q);
            iY2 = dVar.y(dVar2.S);
            dVar.E();
        } else {
            iY = dVar.y(dVar2.R);
            iY2 = dVar.y(dVar2.T);
            dVar.E();
        }
        return iY2 - iY;
    }

    public String toString() {
        String str = e() + " [" + this.f79187b + "] <";
        Iterator<ConstraintWidget> it = this.f79186a.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().v();
        }
        return str + " >";
    }
}
