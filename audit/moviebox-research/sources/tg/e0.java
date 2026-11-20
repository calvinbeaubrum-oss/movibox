package tg;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface e0 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f77011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f77012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f77013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f77014d;

        public a(int i11, byte[] bArr, int i12, int i13) {
            this.f77011a = i11;
            this.f77012b = bArr;
            this.f77013c = i12;
            this.f77014d = i13;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f77011a == aVar.f77011a && this.f77013c == aVar.f77013c && this.f77014d == aVar.f77014d && Arrays.equals(this.f77012b, aVar.f77012b);
        }

        public int hashCode() {
            return (((((this.f77011a * 31) + Arrays.hashCode(this.f77012b)) * 31) + this.f77013c) * 31) + this.f77014d;
        }
    }

    int a(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z11, int i12) throws IOException;

    int b(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z11) throws IOException;

    void c(com.google.android.exoplayer2.util.c0 c0Var, int i11);

    void d(long j11, int i11, int i12, int i13, @Nullable a aVar);

    void e(m1 m1Var);

    void f(com.google.android.exoplayer2.util.c0 c0Var, int i11, int i12);
}
