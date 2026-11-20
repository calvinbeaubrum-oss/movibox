package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.core.util.f<b> f12618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f12619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<b> f12620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0115a f12621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f12622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f12624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12625h;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0115a {
        void a(int i11, int i12);

        void b(b bVar);

        void c(b bVar);

        void d(int i11, int i12);

        void e(int i11, int i12, Object obj);

        RecyclerView.a0 f(int i11);

        void g(int i11, int i12);

        void h(int i11, int i12);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f12628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12629d;

        public b(int i11, int i12, int i13, Object obj) {
            this.f12626a = i11;
            this.f12627b = i12;
            this.f12629d = i13;
            this.f12628c = obj;
        }

        public String a() {
            int i11 = this.f12626a;
            if (i11 == 1) {
                return "add";
            }
            if (i11 == 2) {
                return "rm";
            }
            if (i11 != 4) {
                return i11 != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i11 = this.f12626a;
            if (i11 != bVar.f12626a) {
                return false;
            }
            if (i11 == 8 && Math.abs(this.f12629d - this.f12627b) == 1 && this.f12629d == bVar.f12627b && this.f12627b == bVar.f12629d) {
                return true;
            }
            if (this.f12629d != bVar.f12629d || this.f12627b != bVar.f12627b) {
                return false;
            }
            Object obj2 = this.f12628c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f12628c)) {
                    return false;
                }
            } else if (bVar.f12628c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f12626a * 31) + this.f12627b) * 31) + this.f12629d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f12627b + "c:" + this.f12629d + ",p:" + this.f12628c + "]";
        }
    }

    public a(InterfaceC0115a interfaceC0115a) {
        this(interfaceC0115a, false);
    }

    public a(InterfaceC0115a interfaceC0115a, boolean z11) {
        this.f12618a = new androidx.core.util.g(30);
        this.f12619b = new ArrayList<>();
        this.f12620c = new ArrayList<>();
        this.f12625h = 0;
        this.f12621d = interfaceC0115a;
        this.f12623f = z11;
        this.f12624g = new l(this);
    }

    @Override // androidx.recyclerview.widget.l.a
    public b a(int i11, int i12, int i13, Object obj) {
        b bVarAcquire = this.f12618a.acquire();
        if (bVarAcquire == null) {
            return new b(i11, i12, i13, obj);
        }
        bVarAcquire.f12626a = i11;
        bVarAcquire.f12627b = i12;
        bVarAcquire.f12629d = i13;
        bVarAcquire.f12628c = obj;
        return bVarAcquire;
    }

    @Override // androidx.recyclerview.widget.l.a
    public void b(b bVar) {
        if (this.f12623f) {
            return;
        }
        bVar.f12628c = null;
        this.f12618a.release(bVar);
    }

    public final void c(b bVar) {
        v(bVar);
    }

    public final void d(b bVar) {
        v(bVar);
    }

    public int e(int i11) {
        int size = this.f12619b.size();
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = this.f12619b.get(i12);
            int i13 = bVar.f12626a;
            if (i13 != 1) {
                if (i13 == 2) {
                    int i14 = bVar.f12627b;
                    if (i14 <= i11) {
                        int i15 = bVar.f12629d;
                        if (i14 + i15 > i11) {
                            return -1;
                        }
                        i11 -= i15;
                    } else {
                        continue;
                    }
                } else if (i13 == 8) {
                    int i16 = bVar.f12627b;
                    if (i16 == i11) {
                        i11 = bVar.f12629d;
                    } else {
                        if (i16 < i11) {
                            i11--;
                        }
                        if (bVar.f12629d <= i11) {
                            i11++;
                        }
                    }
                }
            } else if (bVar.f12627b <= i11) {
                i11 += bVar.f12629d;
            }
        }
        return i11;
    }

    public final void f(b bVar) {
        boolean z11;
        byte b11;
        int i11 = bVar.f12627b;
        int i12 = bVar.f12629d + i11;
        byte b12 = -1;
        int i13 = i11;
        int i14 = 0;
        while (i13 < i12) {
            if (this.f12621d.f(i13) != null || h(i13)) {
                if (b12 == 0) {
                    k(a(2, i11, i14, null));
                    z11 = true;
                } else {
                    z11 = false;
                }
                b11 = 1;
            } else {
                if (b12 == 1) {
                    v(a(2, i11, i14, null));
                    z11 = true;
                } else {
                    z11 = false;
                }
                b11 = 0;
            }
            if (z11) {
                i13 -= i14;
                i12 -= i14;
                i14 = 1;
            } else {
                i14++;
            }
            i13++;
            b12 = b11;
        }
        if (i14 != bVar.f12629d) {
            b(bVar);
            bVar = a(2, i11, i14, null);
        }
        if (b12 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final void g(b bVar) {
        int i11 = bVar.f12627b;
        int i12 = bVar.f12629d + i11;
        int i13 = i11;
        byte b11 = -1;
        int i14 = 0;
        while (i11 < i12) {
            if (this.f12621d.f(i11) != null || h(i11)) {
                if (b11 == 0) {
                    k(a(4, i13, i14, bVar.f12628c));
                    i13 = i11;
                    i14 = 0;
                }
                b11 = 1;
            } else {
                if (b11 == 1) {
                    v(a(4, i13, i14, bVar.f12628c));
                    i13 = i11;
                    i14 = 0;
                }
                b11 = 0;
            }
            i14++;
            i11++;
        }
        if (i14 != bVar.f12629d) {
            Object obj = bVar.f12628c;
            b(bVar);
            bVar = a(4, i13, i14, obj);
        }
        if (b11 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final boolean h(int i11) {
        int size = this.f12620c.size();
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = this.f12620c.get(i12);
            int i13 = bVar.f12626a;
            if (i13 == 8) {
                if (n(bVar.f12629d, i12 + 1) == i11) {
                    return true;
                }
            } else if (i13 == 1) {
                int i14 = bVar.f12627b;
                int i15 = bVar.f12629d + i14;
                while (i14 < i15) {
                    if (n(i14, i12 + 1) == i11) {
                        return true;
                    }
                    i14++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void i() {
        int size = this.f12620c.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f12621d.c(this.f12620c.get(i11));
        }
        x(this.f12620c);
        this.f12625h = 0;
    }

    public void j() {
        i();
        int size = this.f12619b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f12619b.get(i11);
            int i12 = bVar.f12626a;
            if (i12 == 1) {
                this.f12621d.c(bVar);
                this.f12621d.g(bVar.f12627b, bVar.f12629d);
            } else if (i12 == 2) {
                this.f12621d.c(bVar);
                this.f12621d.h(bVar.f12627b, bVar.f12629d);
            } else if (i12 == 4) {
                this.f12621d.c(bVar);
                this.f12621d.e(bVar.f12627b, bVar.f12629d, bVar.f12628c);
            } else if (i12 == 8) {
                this.f12621d.c(bVar);
                this.f12621d.a(bVar.f12627b, bVar.f12629d);
            }
            Runnable runnable = this.f12622e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f12619b);
        this.f12625h = 0;
    }

    public final void k(b bVar) {
        int i11;
        int i12 = bVar.f12626a;
        if (i12 == 1 || i12 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iZ = z(bVar.f12627b, i12);
        int i13 = bVar.f12627b;
        int i14 = bVar.f12626a;
        if (i14 == 2) {
            i11 = 0;
        } else {
            if (i14 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i11 = 1;
        }
        int i15 = 1;
        for (int i16 = 1; i16 < bVar.f12629d; i16++) {
            int iZ2 = z(bVar.f12627b + (i11 * i16), bVar.f12626a);
            int i17 = bVar.f12626a;
            if (i17 == 2 ? iZ2 != iZ : !(i17 == 4 && iZ2 == iZ + 1)) {
                b bVarA = a(i17, iZ, i15, bVar.f12628c);
                l(bVarA, i13);
                b(bVarA);
                if (bVar.f12626a == 4) {
                    i13 += i15;
                }
                iZ = iZ2;
                i15 = 1;
            } else {
                i15++;
            }
        }
        Object obj = bVar.f12628c;
        b(bVar);
        if (i15 > 0) {
            b bVarA2 = a(bVar.f12626a, iZ, i15, obj);
            l(bVarA2, i13);
            b(bVarA2);
        }
    }

    public void l(b bVar, int i11) {
        this.f12621d.b(bVar);
        int i12 = bVar.f12626a;
        if (i12 == 2) {
            this.f12621d.h(i11, bVar.f12629d);
        } else {
            if (i12 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f12621d.e(i11, bVar.f12629d, bVar.f12628c);
        }
    }

    public int m(int i11) {
        return n(i11, 0);
    }

    public int n(int i11, int i12) {
        int size = this.f12620c.size();
        while (i12 < size) {
            b bVar = this.f12620c.get(i12);
            int i13 = bVar.f12626a;
            if (i13 == 8) {
                int i14 = bVar.f12627b;
                if (i14 == i11) {
                    i11 = bVar.f12629d;
                } else {
                    if (i14 < i11) {
                        i11--;
                    }
                    if (bVar.f12629d <= i11) {
                        i11++;
                    }
                }
            } else {
                int i15 = bVar.f12627b;
                if (i15 > i11) {
                    continue;
                } else if (i13 == 2) {
                    int i16 = bVar.f12629d;
                    if (i11 < i15 + i16) {
                        return -1;
                    }
                    i11 -= i16;
                } else if (i13 == 1) {
                    i11 += bVar.f12629d;
                }
            }
            i12++;
        }
        return i11;
    }

    public boolean o(int i11) {
        return (i11 & this.f12625h) != 0;
    }

    public boolean p() {
        return this.f12619b.size() > 0;
    }

    public boolean q() {
        return (this.f12620c.isEmpty() || this.f12619b.isEmpty()) ? false : true;
    }

    public boolean r(int i11, int i12, Object obj) {
        if (i12 < 1) {
            return false;
        }
        this.f12619b.add(a(4, i11, i12, obj));
        this.f12625h |= 4;
        return this.f12619b.size() == 1;
    }

    public boolean s(int i11, int i12) {
        if (i12 < 1) {
            return false;
        }
        this.f12619b.add(a(1, i11, i12, null));
        this.f12625h |= 1;
        return this.f12619b.size() == 1;
    }

    public boolean t(int i11, int i12, int i13) {
        if (i11 == i12) {
            return false;
        }
        if (i13 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f12619b.add(a(8, i11, i12, null));
        this.f12625h |= 8;
        return this.f12619b.size() == 1;
    }

    public boolean u(int i11, int i12) {
        if (i12 < 1) {
            return false;
        }
        this.f12619b.add(a(2, i11, i12, null));
        this.f12625h |= 2;
        return this.f12619b.size() == 1;
    }

    public final void v(b bVar) {
        this.f12620c.add(bVar);
        int i11 = bVar.f12626a;
        if (i11 == 1) {
            this.f12621d.g(bVar.f12627b, bVar.f12629d);
            return;
        }
        if (i11 == 2) {
            this.f12621d.d(bVar.f12627b, bVar.f12629d);
            return;
        }
        if (i11 == 4) {
            this.f12621d.e(bVar.f12627b, bVar.f12629d, bVar.f12628c);
        } else {
            if (i11 == 8) {
                this.f12621d.a(bVar.f12627b, bVar.f12629d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void w() {
        this.f12624g.b(this.f12619b);
        int size = this.f12619b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f12619b.get(i11);
            int i12 = bVar.f12626a;
            if (i12 == 1) {
                c(bVar);
            } else if (i12 == 2) {
                f(bVar);
            } else if (i12 == 4) {
                g(bVar);
            } else if (i12 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f12622e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f12619b.clear();
    }

    public void x(List<b> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            b(list.get(i11));
        }
        list.clear();
    }

    public void y() {
        x(this.f12619b);
        x(this.f12620c);
        this.f12625h = 0;
    }

    public final int z(int i11, int i12) {
        int i13;
        int i14;
        for (int size = this.f12620c.size() - 1; size >= 0; size--) {
            b bVar = this.f12620c.get(size);
            int i15 = bVar.f12626a;
            if (i15 == 8) {
                int i16 = bVar.f12627b;
                int i17 = bVar.f12629d;
                if (i16 < i17) {
                    i14 = i16;
                    i13 = i17;
                } else {
                    i13 = i16;
                    i14 = i17;
                }
                if (i11 < i14 || i11 > i13) {
                    if (i11 < i16) {
                        if (i12 == 1) {
                            bVar.f12627b = i16 + 1;
                            bVar.f12629d = i17 + 1;
                        } else if (i12 == 2) {
                            bVar.f12627b = i16 - 1;
                            bVar.f12629d = i17 - 1;
                        }
                    }
                } else if (i14 == i16) {
                    if (i12 == 1) {
                        bVar.f12629d = i17 + 1;
                    } else if (i12 == 2) {
                        bVar.f12629d = i17 - 1;
                    }
                    i11++;
                } else {
                    if (i12 == 1) {
                        bVar.f12627b = i16 + 1;
                    } else if (i12 == 2) {
                        bVar.f12627b = i16 - 1;
                    }
                    i11--;
                }
            } else {
                int i18 = bVar.f12627b;
                if (i18 <= i11) {
                    if (i15 == 1) {
                        i11 -= bVar.f12629d;
                    } else if (i15 == 2) {
                        i11 += bVar.f12629d;
                    }
                } else if (i12 == 1) {
                    bVar.f12627b = i18 + 1;
                } else if (i12 == 2) {
                    bVar.f12627b = i18 - 1;
                }
            }
        }
        for (int size2 = this.f12620c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f12620c.get(size2);
            if (bVar2.f12626a == 8) {
                int i19 = bVar2.f12629d;
                if (i19 == bVar2.f12627b || i19 < 0) {
                    this.f12620c.remove(size2);
                    b(bVar2);
                }
            } else if (bVar2.f12629d <= 0) {
                this.f12620c.remove(size2);
                b(bVar2);
            }
        }
        return i11;
    }
}
