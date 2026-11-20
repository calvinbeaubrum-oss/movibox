package k1;

import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a1.a f68202a;

    public k(@NonNull a1.a aVar) {
        this.f68202a = aVar;
    }

    @Nullable
    public static k a(@Nullable IBinder iBinder) {
        a1.a aVarE0 = iBinder == null ? null : a1.a.AbstractBinderC0015a.e0(iBinder);
        if (aVarE0 == null) {
            return null;
        }
        return new k(aVarE0);
    }
}
