package l5;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f69797a;

    /* JADX INFO: renamed from: l5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0749a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f69798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<b> f69799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<C0749a> f69800d;

        public C0749a(int i11, long j11) {
            super(i11);
            this.f69798b = j11;
            this.f69799c = new ArrayList();
            this.f69800d = new ArrayList();
        }

        public void d(C0749a c0749a) {
            this.f69800d.add(c0749a);
        }

        public void e(b bVar) {
            this.f69799c.add(bVar);
        }

        @Nullable
        public C0749a f(int i11) {
            int size = this.f69800d.size();
            for (int i12 = 0; i12 < size; i12++) {
                C0749a c0749a = this.f69800d.get(i12);
                if (c0749a.f69797a == i11) {
                    return c0749a;
                }
            }
            return null;
        }

        @Nullable
        public b g(int i11) {
            int size = this.f69799c.size();
            for (int i12 = 0; i12 < size; i12++) {
                b bVar = this.f69799c.get(i12);
                if (bVar.f69797a == i11) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // l5.a
        public String toString() {
            return a.a(this.f69797a) + " leaves: " + Arrays.toString(this.f69799c.toArray()) + " containers: " + Arrays.toString(this.f69800d.toArray());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c0 f69801b;

        public b(int i11, c0 c0Var) {
            super(i11);
            this.f69801b = c0Var;
        }
    }

    public a(int i11) {
        this.f69797a = i11;
    }

    public static String a(int i11) {
        return "" + ((char) ((i11 >> 24) & 255)) + ((char) ((i11 >> 16) & 255)) + ((char) ((i11 >> 8) & 255)) + ((char) (i11 & 255));
    }

    public static int b(int i11) {
        return i11 & 16777215;
    }

    public static int c(int i11) {
        return (i11 >> 24) & 255;
    }

    public String toString() {
        return a(this.f69797a);
    }
}
