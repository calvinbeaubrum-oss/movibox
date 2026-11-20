package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f12644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f12645b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<View> f12646c = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f12647a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f12648b;

        public void a(int i11) {
            if (i11 < 64) {
                this.f12647a &= ~(1 << i11);
                return;
            }
            a aVar = this.f12648b;
            if (aVar != null) {
                aVar.a(i11 - 64);
            }
        }

        public int b(int i11) {
            a aVar = this.f12648b;
            if (aVar == null) {
                return i11 >= 64 ? Long.bitCount(this.f12647a) : Long.bitCount(this.f12647a & ((1 << i11) - 1));
            }
            return i11 < 64 ? Long.bitCount(this.f12647a & ((1 << i11) - 1)) : aVar.b(i11 - 64) + Long.bitCount(this.f12647a);
        }

        public final void c() {
            if (this.f12648b == null) {
                this.f12648b = new a();
            }
        }

        public boolean d(int i11) {
            if (i11 < 64) {
                return (this.f12647a & (1 << i11)) != 0;
            }
            c();
            return this.f12648b.d(i11 - 64);
        }

        public void e(int i11, boolean z11) {
            if (i11 >= 64) {
                c();
                this.f12648b.e(i11 - 64, z11);
                return;
            }
            long j11 = this.f12647a;
            boolean z12 = (Long.MIN_VALUE & j11) != 0;
            long j12 = (1 << i11) - 1;
            this.f12647a = ((j11 & (~j12)) << 1) | (j11 & j12);
            if (z11) {
                h(i11);
            } else {
                a(i11);
            }
            if (z12 || this.f12648b != null) {
                c();
                this.f12648b.e(0, z12);
            }
        }

        public boolean f(int i11) {
            if (i11 >= 64) {
                c();
                return this.f12648b.f(i11 - 64);
            }
            long j11 = 1 << i11;
            long j12 = this.f12647a;
            boolean z11 = (j12 & j11) != 0;
            long j13 = j12 & (~j11);
            this.f12647a = j13;
            long j14 = j11 - 1;
            this.f12647a = (j13 & j14) | Long.rotateRight((~j14) & j13, 1);
            a aVar = this.f12648b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f12648b.f(0);
            }
            return z11;
        }

        public void g() {
            this.f12647a = 0L;
            a aVar = this.f12648b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i11) {
            if (i11 < 64) {
                this.f12647a |= 1 << i11;
            } else {
                c();
                this.f12648b.h(i11 - 64);
            }
        }

        public String toString() {
            if (this.f12648b == null) {
                return Long.toBinaryString(this.f12647a);
            }
            return this.f12648b.toString() + "xx" + Long.toBinaryString(this.f12647a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(View view);

        void addView(View view, int i11);

        RecyclerView.a0 b(View view);

        void c(int i11);

        void d();

        int e(View view);

        void f(View view);

        void g(int i11);

        View getChildAt(int i11);

        int getChildCount();

        void h(View view, int i11, ViewGroup.LayoutParams layoutParams);
    }

    public e(b bVar) {
        this.f12644a = bVar;
    }

    public void a(View view, int i11, boolean z11) {
        int childCount = i11 < 0 ? this.f12644a.getChildCount() : h(i11);
        this.f12645b.e(childCount, z11);
        if (z11) {
            l(view);
        }
        this.f12644a.addView(view, childCount);
    }

    public void b(View view, boolean z11) {
        a(view, -1, z11);
    }

    public void c(View view, int i11, ViewGroup.LayoutParams layoutParams, boolean z11) {
        int childCount = i11 < 0 ? this.f12644a.getChildCount() : h(i11);
        this.f12645b.e(childCount, z11);
        if (z11) {
            l(view);
        }
        this.f12644a.h(view, childCount, layoutParams);
    }

    public void d(int i11) {
        int iH = h(i11);
        this.f12645b.f(iH);
        this.f12644a.c(iH);
    }

    public View e(int i11) {
        int size = this.f12646c.size();
        for (int i12 = 0; i12 < size; i12++) {
            View view = this.f12646c.get(i12);
            RecyclerView.a0 a0VarB = this.f12644a.b(view);
            if (a0VarB.getLayoutPosition() == i11 && !a0VarB.isInvalid() && !a0VarB.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View f(int i11) {
        return this.f12644a.getChildAt(h(i11));
    }

    public int g() {
        return this.f12644a.getChildCount() - this.f12646c.size();
    }

    public final int h(int i11) {
        if (i11 < 0) {
            return -1;
        }
        int childCount = this.f12644a.getChildCount();
        int i12 = i11;
        while (i12 < childCount) {
            int iB = i11 - (i12 - this.f12645b.b(i12));
            if (iB == 0) {
                while (this.f12645b.d(i12)) {
                    i12++;
                }
                return i12;
            }
            i12 += iB;
        }
        return -1;
    }

    public View i(int i11) {
        return this.f12644a.getChildAt(i11);
    }

    public int j() {
        return this.f12644a.getChildCount();
    }

    public void k(View view) {
        int iE = this.f12644a.e(view);
        if (iE >= 0) {
            this.f12645b.h(iE);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void l(View view) {
        this.f12646c.add(view);
        this.f12644a.a(view);
    }

    public int m(View view) {
        int iE = this.f12644a.e(view);
        if (iE == -1 || this.f12645b.d(iE)) {
            return -1;
        }
        return iE - this.f12645b.b(iE);
    }

    public boolean n(View view) {
        return this.f12646c.contains(view);
    }

    public void o() {
        this.f12645b.g();
        for (int size = this.f12646c.size() - 1; size >= 0; size--) {
            this.f12644a.f(this.f12646c.get(size));
            this.f12646c.remove(size);
        }
        this.f12644a.d();
    }

    public void p(View view) {
        int iE = this.f12644a.e(view);
        if (iE < 0) {
            return;
        }
        if (this.f12645b.f(iE)) {
            t(view);
        }
        this.f12644a.g(iE);
    }

    public void q(int i11) {
        int iH = h(i11);
        View childAt = this.f12644a.getChildAt(iH);
        if (childAt == null) {
            return;
        }
        if (this.f12645b.f(iH)) {
            t(childAt);
        }
        this.f12644a.g(iH);
    }

    public boolean r(View view) {
        int iE = this.f12644a.e(view);
        if (iE == -1) {
            t(view);
            return true;
        }
        if (!this.f12645b.d(iE)) {
            return false;
        }
        this.f12645b.f(iE);
        t(view);
        this.f12644a.g(iE);
        return true;
    }

    public void s(View view) {
        int iE = this.f12644a.e(view);
        if (iE < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f12645b.d(iE)) {
            this.f12645b.a(iE);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean t(View view) {
        if (!this.f12646c.remove(view)) {
            return false;
        }
        this.f12644a.f(view);
        return true;
    }

    public String toString() {
        return this.f12645b.toString() + ", hidden list:" + this.f12646c.size();
    }
}
