package fg;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        public abstract e a();

        public abstract a b(Iterable<com.google.android.datatransport.runtime.i> iterable);

        public abstract a c(@Nullable byte[] bArr);
    }

    public static a a() {
        return new fg.a.b();
    }

    public abstract Iterable<com.google.android.datatransport.runtime.i> b();

    @Nullable
    public abstract byte[] c();
}
