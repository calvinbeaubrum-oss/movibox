package androidx.media3.exoplayer.upstream;

import androidx.annotation.Nullable;
import androidx.media3.common.f0;
import java.util.regex.Pattern;
import s4.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pattern f11453a = Pattern.compile(".*-.*");

        @Nullable
        public static String b(z zVar) {
            z3.a.a(zVar != null);
            int iK = f0.k(zVar.getSelectedFormat().f9501m);
            if (iK == -1) {
                iK = f0.k(zVar.getSelectedFormat().f9500l);
            }
            if (iK == 1) {
                return "a";
            }
            if (iK == 2) {
                return "v";
            }
            return null;
        }

        public g a() {
            throw null;
        }

        public a c(long j11) {
            throw null;
        }

        public a d(@Nullable String str) {
            throw null;
        }

        public a e(@Nullable String str) {
            throw null;
        }

        public a f(@Nullable String str) {
            throw null;
        }
    }

    public c4.g a(c4.g gVar) {
        throw null;
    }
}
