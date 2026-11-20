package x5;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface i0 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f80033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f80034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f80035c;

        public a(String str, int i11, byte[] bArr) {
            this.f80033a = str;
            this.f80034b = i11;
            this.f80035c = bArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f80036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f80037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f80038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<a> f80039d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f80040e;

        public b(int i11, @Nullable String str, int i12, @Nullable List<a> list, byte[] bArr) {
            this.f80036a = i11;
            this.f80037b = str;
            this.f80038c = i12;
            this.f80039d = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f80040e = bArr;
        }

        public int a() {
            int i11 = this.f80038c;
            if (i11 != 2) {
                return i11 != 3 ? 0 : 512;
            }
            return 2048;
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
        public final String f80041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f80042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f80043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f80044d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f80045e;

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
            this.f80041a = str;
            this.f80042b = i12;
            this.f80043c = i13;
            this.f80044d = Integer.MIN_VALUE;
            this.f80045e = "";
        }

        public void a() {
            int i11 = this.f80044d;
            this.f80044d = i11 == Integer.MIN_VALUE ? this.f80042b : i11 + this.f80043c;
            this.f80045e = this.f80041a + this.f80044d;
        }

        public String b() {
            d();
            return this.f80045e;
        }

        public int c() {
            d();
            return this.f80044d;
        }

        public final void d() {
            if (this.f80044d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }

    void a(z3.i0 i0Var, u4.u uVar, d dVar);

    void b(z3.c0 c0Var, int i11) throws ParserException;

    void seek();
}
