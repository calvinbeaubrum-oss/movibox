package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ij {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kj f19729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final kj f19730b;

        public a(kj kjVar) {
            this(kjVar, kjVar);
        }

        public a(kj kjVar, kj kjVar2) {
            this.f19729a = (kj) b1.a(kjVar);
            this.f19730b = (kj) b1.a(kjVar2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f19729a.equals(aVar.f19729a) && this.f19730b.equals(aVar.f19730b);
        }

        public int hashCode() {
            return (this.f19729a.hashCode() * 31) + this.f19730b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(this.f19729a);
            if (this.f19729a.equals(this.f19730b)) {
                str = "";
            } else {
                str = ", " + this.f19730b;
            }
            sb2.append(str);
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements ij {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f19731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f19732b;

        public b(long j11) {
            this(j11, 0L);
        }

        public b(long j11, long j12) {
            this.f19731a = j11;
            this.f19732b = new a(j12 == 0 ? kj.f20255c : new kj(0L, j12));
        }

        @Override // com.applovin.impl.ij
        public a b(long j11) {
            return this.f19732b;
        }

        @Override // com.applovin.impl.ij
        public boolean b() {
            return false;
        }

        @Override // com.applovin.impl.ij
        public long d() {
            return this.f19731a;
        }
    }

    a b(long j11);

    boolean b();

    long d();
}
