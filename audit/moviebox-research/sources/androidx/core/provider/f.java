package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.v0;
import androidx.collection.x;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x<String, Typeface> f7818a = new x<>(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f7819b = RequestExecutor.a("fonts-androidx", 10, 10000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f7820c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v0<String, ArrayList<androidx.core.util.a<e>>> f7821d = new v0<>();

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f7823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ androidx.core.provider.e f7824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f7825d;

        public a(String str, Context context, androidx.core.provider.e eVar, int i11) {
            this.f7822a = str;
            this.f7823b = context;
            this.f7824c = eVar;
            this.f7825d = i11;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return f.c(this.f7822a, this.f7823b, this.f7824c, this.f7825d);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements androidx.core.util.a<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CallbackWithHandler f7826a;

        public b(CallbackWithHandler callbackWithHandler) {
            this.f7826a = callbackWithHandler;
        }

        @Override // androidx.core.util.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f7826a.b(eVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Callable<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f7828b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ androidx.core.provider.e f7829c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f7830d;

        public c(String str, Context context, androidx.core.provider.e eVar, int i11) {
            this.f7827a = str;
            this.f7828b = context;
            this.f7829c = eVar;
            this.f7830d = i11;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return f.c(this.f7827a, this.f7828b, this.f7829c, this.f7830d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements androidx.core.util.a<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7831a;

        public d(String str) {
            this.f7831a = str;
        }

        @Override // androidx.core.util.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (f.f7820c) {
                try {
                    v0<String, ArrayList<androidx.core.util.a<e>>> v0Var = f.f7821d;
                    ArrayList<androidx.core.util.a<e>> arrayList = v0Var.get(this.f7831a);
                    if (arrayList == null) {
                        return;
                    }
                    v0Var.remove(this.f7831a);
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        arrayList.get(i11).accept(eVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f7832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7833b;

        public e(int i11) {
            this.f7832a = null;
            this.f7833b = i11;
        }

        @SuppressLint({"WrongConstant"})
        public e(@NonNull Typeface typeface) {
            this.f7832a = typeface;
            this.f7833b = 0;
        }

        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.f7833b == 0;
        }
    }

    public static String a(@NonNull androidx.core.provider.e eVar, int i11) {
        return eVar.d() + "-" + i11;
    }

    @SuppressLint({"WrongConstant"})
    public static int b(@NonNull g.a aVar) {
        int i11 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        g.b[] bVarArrB = aVar.b();
        if (bVarArrB != null && bVarArrB.length != 0) {
            i11 = 0;
            for (g.b bVar : bVarArrB) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i11;
    }

    @NonNull
    public static e c(@NonNull String str, @NonNull Context context, @NonNull androidx.core.provider.e eVar, int i11) {
        x<String, Typeface> xVar = f7818a;
        Typeface typeface = xVar.get(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            g.a aVarE = androidx.core.provider.d.e(context, eVar, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = c3.f.b(context, null, aVarE.b(), i11);
            if (typefaceB == null) {
                return new e(-3);
            }
            xVar.put(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    public static Typeface d(@NonNull Context context, @NonNull androidx.core.provider.e eVar, int i11, @Nullable Executor executor, @NonNull CallbackWithHandler callbackWithHandler) {
        String strA = a(eVar, i11);
        Typeface typeface = f7818a.get(strA);
        if (typeface != null) {
            callbackWithHandler.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(callbackWithHandler);
        synchronized (f7820c) {
            try {
                v0<String, ArrayList<androidx.core.util.a<e>>> v0Var = f7821d;
                ArrayList<androidx.core.util.a<e>> arrayList = v0Var.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList<androidx.core.util.a<e>> arrayList2 = new ArrayList<>();
                arrayList2.add(bVar);
                v0Var.put(strA, arrayList2);
                c cVar = new c(strA, context, eVar, i11);
                if (executor == null) {
                    executor = f7819b;
                }
                RequestExecutor.b(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static Typeface e(@NonNull Context context, @NonNull androidx.core.provider.e eVar, @NonNull CallbackWithHandler callbackWithHandler, int i11, int i12) {
        String strA = a(eVar, i11);
        Typeface typeface = f7818a.get(strA);
        if (typeface != null) {
            callbackWithHandler.b(new e(typeface));
            return typeface;
        }
        if (i12 == -1) {
            e eVarC = c(strA, context, eVar, i11);
            callbackWithHandler.b(eVarC);
            return eVarC.f7832a;
        }
        try {
            e eVar2 = (e) RequestExecutor.c(f7819b, new a(strA, context, eVar, i11), i12);
            callbackWithHandler.b(eVar2);
            return eVar2.f7832a;
        } catch (InterruptedException unused) {
            callbackWithHandler.b(new e(-3));
            return null;
        }
    }
}
