package fg;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable<com.google.android.datatransport.runtime.i> f64859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f64860b;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterable<com.google.android.datatransport.runtime.i> f64861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f64862b;

        @Override // fg.e.a
        public e a() {
            String str = "";
            if (this.f64861a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f64861a, this.f64862b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // fg.e.a
        public e.a b(Iterable<com.google.android.datatransport.runtime.i> iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f64861a = iterable;
            return this;
        }

        @Override // fg.e.a
        public e.a c(@Nullable byte[] bArr) {
            this.f64862b = bArr;
            return this;
        }
    }

    public a(Iterable<com.google.android.datatransport.runtime.i> iterable, @Nullable byte[] bArr) {
        this.f64859a = iterable;
        this.f64860b = bArr;
    }

    @Override // fg.e
    public Iterable<com.google.android.datatransport.runtime.i> b() {
        return this.f64859a;
    }

    @Override // fg.e
    @Nullable
    public byte[] c() {
        return this.f64860b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f64859a.equals(eVar.b())) {
            if (Arrays.equals(this.f64860b, eVar instanceof a ? ((a) eVar).f64860b : eVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f64859a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f64860b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f64859a + ", extras=" + Arrays.toString(this.f64860b) + "}";
    }
}
