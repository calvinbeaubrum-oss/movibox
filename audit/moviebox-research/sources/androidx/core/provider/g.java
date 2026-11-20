package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b[] f7835b;

        @Deprecated
        public a(int i11, @Nullable b[] bVarArr) {
            this.f7834a = i11;
            this.f7835b = bVarArr;
        }

        public static a a(int i11, @Nullable b[] bVarArr) {
            return new a(i11, bVarArr);
        }

        public b[] b() {
            return this.f7835b;
        }

        public int c() {
            return this.f7834a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f7836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f7839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f7840e;

        @Deprecated
        public b(@NonNull Uri uri, int i11, int i12, boolean z11, int i13) {
            this.f7836a = (Uri) i.g(uri);
            this.f7837b = i11;
            this.f7838c = i12;
            this.f7839d = z11;
            this.f7840e = i13;
        }

        public static b a(@NonNull Uri uri, int i11, int i12, boolean z11, int i13) {
            return new b(uri, i11, i12, z11, i13);
        }

        public int b() {
            return this.f7840e;
        }

        public int c() {
            return this.f7837b;
        }

        @NonNull
        public Uri d() {
            return this.f7836a;
        }

        public int e() {
            return this.f7838c;
        }

        public boolean f() {
            return this.f7839d;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {
        public void a(int i11) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    @Nullable
    public static Typeface a(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull b[] bVarArr) {
        return c3.f.b(context, cancellationSignal, bVarArr, 0);
    }

    @NonNull
    public static a b(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull e eVar) throws PackageManager.NameNotFoundException {
        return d.e(context, eVar, cancellationSignal);
    }

    @Nullable
    public static Typeface c(@NonNull Context context, @NonNull e eVar, int i11, boolean z11, int i12, @NonNull Handler handler, @NonNull c cVar) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler(cVar, handler);
        return z11 ? f.e(context, eVar, callbackWithHandler, i11, i12) : f.d(context, eVar, i11, null, callbackWithHandler);
    }
}
