package u7;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f78489a;

        public b(Context context) {
            this.f78489a = context;
        }

        public a a() {
            Context context = this.f78489a;
            if (context != null) {
                return new u7.b(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
    }

    public static b c(Context context) {
        return new b(context);
    }

    public abstract void a();

    public abstract d b() throws RemoteException;

    public abstract void d(c cVar);
}
