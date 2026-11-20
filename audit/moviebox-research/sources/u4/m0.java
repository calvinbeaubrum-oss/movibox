package u4;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface m0 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n0 f78345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n0 f78346b;

        public a(n0 n0Var) {
            this(n0Var, n0Var);
        }

        public a(n0 n0Var, n0 n0Var2) {
            this.f78345a = (n0) z3.a.e(n0Var);
            this.f78346b = (n0) z3.a.e(n0Var2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f78345a.equals(aVar.f78345a) && this.f78346b.equals(aVar.f78346b);
        }

        public int hashCode() {
            return (this.f78345a.hashCode() * 31) + this.f78346b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(this.f78345a);
            if (this.f78345a.equals(this.f78346b)) {
                str = "";
            } else {
                str = ", " + this.f78346b;
            }
            sb2.append(str);
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f78347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f78348b;

        public b(long j11) {
            this(j11, 0L);
        }

        public b(long j11, long j12) {
            this.f78347a = j11;
            this.f78348b = new a(j12 == 0 ? n0.f78352c : new n0(0L, j12));
        }

        @Override // u4.m0
        public long getDurationUs() {
            return this.f78347a;
        }

        @Override // u4.m0
        public a getSeekPoints(long j11) {
            return this.f78348b;
        }

        @Override // u4.m0
        public boolean isSeekable() {
            return false;
        }
    }

    long getDurationUs();

    a getSeekPoints(long j11);

    boolean isSeekable();
}
