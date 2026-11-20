package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f12701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f12702b = new a();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12703a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12706d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12707e;

        public void a(int i11) {
            this.f12703a = i11 | this.f12703a;
        }

        public boolean b() {
            int i11 = this.f12703a;
            if ((i11 & 7) != 0 && (i11 & c(this.f12706d, this.f12704b)) == 0) {
                return false;
            }
            int i12 = this.f12703a;
            if ((i12 & 112) != 0 && (i12 & (c(this.f12706d, this.f12705c) << 4)) == 0) {
                return false;
            }
            int i13 = this.f12703a;
            if ((i13 & 1792) != 0 && (i13 & (c(this.f12707e, this.f12704b) << 8)) == 0) {
                return false;
            }
            int i14 = this.f12703a;
            return (i14 & 28672) == 0 || (i14 & (c(this.f12707e, this.f12705c) << 12)) != 0;
        }

        public int c(int i11, int i12) {
            if (i11 > i12) {
                return 1;
            }
            return i11 == i12 ? 2 : 4;
        }

        public void d() {
            this.f12703a = 0;
        }

        public void e(int i11, int i12, int i13, int i14) {
            this.f12704b = i11;
            this.f12705c = i12;
            this.f12706d = i13;
            this.f12707e = i14;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        int a(View view);

        int b();

        int c();

        int d(View view);

        View getChildAt(int i11);
    }

    public s(b bVar) {
        this.f12701a = bVar;
    }

    public View a(int i11, int i12, int i13, int i14) {
        int iB = this.f12701a.b();
        int iC = this.f12701a.c();
        int i15 = i12 > i11 ? 1 : -1;
        View view = null;
        while (i11 != i12) {
            View childAt = this.f12701a.getChildAt(i11);
            this.f12702b.e(iB, iC, this.f12701a.a(childAt), this.f12701a.d(childAt));
            if (i13 != 0) {
                this.f12702b.d();
                this.f12702b.a(i13);
                if (this.f12702b.b()) {
                    return childAt;
                }
            }
            if (i14 != 0) {
                this.f12702b.d();
                this.f12702b.a(i14);
                if (this.f12702b.b()) {
                    view = childAt;
                }
            }
            i11 += i15;
        }
        return view;
    }

    public boolean b(View view, int i11) {
        this.f12702b.e(this.f12701a.b(), this.f12701a.c(), this.f12701a.a(view), this.f12701a.d(view));
        if (i11 == 0) {
            return false;
        }
        this.f12702b.d();
        this.f12702b.a(i11);
        return this.f12702b.b();
    }
}
