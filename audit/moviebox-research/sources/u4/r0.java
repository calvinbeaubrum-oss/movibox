package u4;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface r0 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f78380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f78381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f78382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f78383d;

        public a(int i11, byte[] bArr, int i12, int i13) {
            this.f78380a = i11;
            this.f78381b = bArr;
            this.f78382c = i12;
            this.f78383d = i13;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f78380a == aVar.f78380a && this.f78382c == aVar.f78382c && this.f78383d == aVar.f78383d && Arrays.equals(this.f78381b, aVar.f78381b);
        }

        public int hashCode() {
            return (((((this.f78380a * 31) + Arrays.hashCode(this.f78381b)) * 31) + this.f78382c) * 31) + this.f78383d;
        }
    }

    void a(z3.c0 c0Var, int i11, int i12);

    void b(androidx.media3.common.y yVar);

    void c(z3.c0 c0Var, int i11);

    int d(androidx.media3.common.l lVar, int i11, boolean z11) throws IOException;

    int e(androidx.media3.common.l lVar, int i11, boolean z11, int i12) throws IOException;

    void f(long j11, int i11, int i12, int i13, @Nullable a aVar);
}
