package bh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.c0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14100a;

    /* JADX INFO: renamed from: bh.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0144a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f14101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<b> f14102c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<C0144a> f14103d;

        public C0144a(int i11, long j11) {
            super(i11);
            this.f14101b = j11;
            this.f14102c = new ArrayList();
            this.f14103d = new ArrayList();
        }

        public void d(C0144a c0144a) {
            this.f14103d.add(c0144a);
        }

        public void e(b bVar) {
            this.f14102c.add(bVar);
        }

        @Nullable
        public C0144a f(int i11) {
            int size = this.f14103d.size();
            for (int i12 = 0; i12 < size; i12++) {
                C0144a c0144a = this.f14103d.get(i12);
                if (c0144a.f14100a == i11) {
                    return c0144a;
                }
            }
            return null;
        }

        @Nullable
        public b g(int i11) {
            int size = this.f14102c.size();
            for (int i12 = 0; i12 < size; i12++) {
                b bVar = this.f14102c.get(i12);
                if (bVar.f14100a == i11) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // bh.a
        public String toString() {
            return a.a(this.f14100a) + " leaves: " + Arrays.toString(this.f14102c.toArray()) + " containers: " + Arrays.toString(this.f14103d.toArray());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c0 f14104b;

        public b(int i11, c0 c0Var) {
            super(i11);
            this.f14104b = c0Var;
        }
    }

    public a(int i11) {
        this.f14100a = i11;
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
        return a(this.f14100a);
    }
}
