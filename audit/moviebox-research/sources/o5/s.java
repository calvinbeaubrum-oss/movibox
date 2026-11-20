package o5;

import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface s {

    /* JADX INFO: compiled from: source.java */
    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f72352a = new C0777a();

        /* JADX INFO: renamed from: o5.s$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0777a implements a {
            @Override // o5.s.a
            public boolean a(y yVar) {
                return false;
            }

            @Override // o5.s.a
            public int b(y yVar) {
                return 1;
            }

            @Override // o5.s.a
            public s c(y yVar) {
                throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
            }
        }

        boolean a(y yVar);

        int b(y yVar);

        s c(y yVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f72353c = new b(C.TIME_UNSET, false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f72354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f72355b;

        public b(long j11, boolean z11) {
            this.f72354a = j11;
            this.f72355b = z11;
        }

        public static b b() {
            return f72353c;
        }

        public static b c(long j11) {
            return new b(j11, true);
        }
    }

    void a(byte[] bArr, b bVar, z3.h<e> hVar);

    k b(byte[] bArr, int i11, int i12);

    void c(byte[] bArr, int i11, int i12, b bVar, z3.h<e> hVar);

    int d();

    void reset();
}
