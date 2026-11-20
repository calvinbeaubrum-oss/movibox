package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13311a = j.i("InputMerger");

    @Nullable
    public static g a(@NonNull String str) {
        try {
            return (g) Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e11) {
            j.e().d(f13311a, "Trouble instantiating + " + str, e11);
            return null;
        }
    }

    @NonNull
    public abstract d b(@NonNull List<d> list);
}
