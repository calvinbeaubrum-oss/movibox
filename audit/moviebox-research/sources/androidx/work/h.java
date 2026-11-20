package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: compiled from: source.java */
    public class a extends h {
        @Override // androidx.work.h
        @Nullable
        public g a(@NonNull String str) {
            return null;
        }
    }

    @NonNull
    public static h c() {
        return new a();
    }

    @Nullable
    public abstract g a(@NonNull String str);

    @Nullable
    public final g b(@NonNull String str) {
        g gVarA = a(str);
        return gVarA == null ? g.a(str) : gVarA;
    }
}
