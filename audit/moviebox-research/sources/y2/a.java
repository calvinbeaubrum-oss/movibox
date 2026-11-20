package y2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public static final String f81095n8 = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', '.');

    /* JADX INFO: renamed from: y2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractBinderC0909a extends Binder implements a {

        /* JADX INFO: renamed from: y2.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0910a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f81096a;

            public C0910a(IBinder iBinder) {
                this.f81096a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f81096a;
            }
        }

        public static a e0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f81095n8);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0910a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
