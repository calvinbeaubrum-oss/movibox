package androidx.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import e4.p3;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(18)
    public static final class a {
        public static boolean a(@Nullable Throwable th2) {
            return th2 instanceof DeniedByServerException;
        }

        public static boolean b(@Nullable Throwable th2) {
            return th2 instanceof DefaultDrmSessionManager.MissingSchemeDataException;
        }

        public static boolean c(@Nullable Throwable th2) {
            return th2 instanceof NotProvisionedException;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static final class b {
        public static boolean a(@Nullable Throwable th2) {
            return th2 instanceof MediaDrm.MediaDrmStateException;
        }

        public static int b(Throwable th2) {
            return u0.b0(u0.c0(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static final class c {
        public static boolean a(@Nullable Throwable th2) {
            return p3.a(th2);
        }
    }

    public static int a(Throwable th2, int i11) {
        int i12 = u0.f81838a;
        if (i12 >= 21 && b.a(th2)) {
            return b.b(th2);
        }
        if (i12 >= 23 && c.a(th2)) {
            return 6006;
        }
        if ((i12 >= 18 && a.c(th2)) || b(th2)) {
            return 6002;
        }
        if (i12 >= 18 && a.a(th2)) {
            return 6007;
        }
        if (th2 instanceof UnsupportedDrmException) {
            return 6001;
        }
        if (i12 >= 18 && a.b(th2)) {
            return 6003;
        }
        if (th2 instanceof KeysExpiredException) {
            return 6008;
        }
        if (i11 == 1) {
            return 6006;
        }
        if (i11 == 2) {
            return 6004;
        }
        if (i11 == 3) {
            return 6002;
        }
        throw new IllegalArgumentException();
    }

    public static boolean b(@Nullable Throwable th2) {
        return u0.f81838a == 34 && (th2 instanceof NoSuchMethodError) && th2.getMessage() != null && th2.getMessage().contains("Landroid/media/NotProvisionedException;.<init>(");
    }

    public static boolean c(@Nullable Throwable th2) {
        return u0.f81838a == 34 && (th2 instanceof NoSuchMethodError) && th2.getMessage() != null && th2.getMessage().contains("Landroid/media/ResourceBusyException;.<init>(");
    }
}
