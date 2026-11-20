package dh;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface i0 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f63186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f63187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f63188c;

        public a(String str, int i11, byte[] bArr) {
            this.f63186a = str;
            this.f63187b = i11;
            this.f63188c = bArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f63189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f63190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<a> f63191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f63192d;

        public b(int i11, @Nullable String str, @Nullable List<a> list, byte[] bArr) {
            this.f63189a = i11;
            this.f63190b = str;
            this.f63191c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f63192d = bArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        @Nullable
        i0 a(int i11, b bVar);

        SparseArray<i0> createInitialPayloadReaders();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f63193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f63194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f63195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f63196d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f63197e;

        public d(int i11, int i12) {
            this(Integer.MIN_VALUE, i11, i12);
        }

        public d(int i11, int i12, int i13) {
            String str;
            if (i11 != Integer.MIN_VALUE) {
                str = i11 + "/";
            } else {
                str = "";
            }
            this.f63193a = str;
            this.f63194b = i12;
            this.f63195c = i13;
            this.f63196d = Integer.MIN_VALUE;
            this.f63197e = "";
        }

        public void a() {
            int i11 = this.f63196d;
            this.f63196d = i11 == Integer.MIN_VALUE ? this.f63194b : i11 + this.f63195c;
            this.f63197e = this.f63193a + this.f63196d;
        }

        public String b() {
            d();
            return this.f63197e;
        }

        public int c() {
            d();
            return this.f63196d;
        }

        public final void d() {
            if (this.f63196d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }

    void a(com.google.android.exoplayer2.util.k0 k0Var, tg.n nVar, d dVar);

    void b(com.google.android.exoplayer2.util.c0 c0Var, int i11) throws ParserException;

    void seek();
}
