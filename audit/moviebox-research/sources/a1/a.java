package a1;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {
    public static final String U7 = "android$support$customtabs$trusted$ITrustedWebActivityCallback".replace('$', '.');

    /* JADX INFO: renamed from: a1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractBinderC0015a extends Binder implements a {

        /* JADX INFO: renamed from: a1.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0016a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f357a;

            public C0016a(IBinder iBinder) {
                this.f357a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f357a;
            }
        }

        public static a e0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.U7);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0016a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
