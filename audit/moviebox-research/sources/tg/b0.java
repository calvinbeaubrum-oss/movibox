package tg;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface b0 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f76991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c0 f76992b;

        public a(c0 c0Var) {
            this(c0Var, c0Var);
        }

        public a(c0 c0Var, c0 c0Var2) {
            this.f76991a = (c0) com.google.android.exoplayer2.util.a.e(c0Var);
            this.f76992b = (c0) com.google.android.exoplayer2.util.a.e(c0Var2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f76991a.equals(aVar.f76991a) && this.f76992b.equals(aVar.f76992b);
        }

        public int hashCode() {
            return (this.f76991a.hashCode() * 31) + this.f76992b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(this.f76991a);
            if (this.f76991a.equals(this.f76992b)) {
                str = "";
            } else {
                str = ", " + this.f76992b;
            }
            sb2.append(str);
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f76993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f76994b;

        public b(long j11) {
            this(j11, 0L);
        }

        public b(long j11, long j12) {
            this.f76993a = j11;
            this.f76994b = new a(j12 == 0 ? c0.f76995c : new c0(0L, j12));
        }

        @Override // tg.b0
        public long getDurationUs() {
            return this.f76993a;
        }

        @Override // tg.b0
        public a getSeekPoints(long j11) {
            return this.f76994b;
        }

        @Override // tg.b0
        public boolean isSeekable() {
            return false;
        }
    }

    long getDurationUs();

    a getSeekPoints(long j11);

    boolean isSeekable();
}
