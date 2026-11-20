package t3;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.w0;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends t3.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f76777c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final u f76778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final c f76779b;

    /* JADX INFO: compiled from: source.java */
    public static class a<D> extends c0<D> implements androidx.loader.content.a.b<D> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f76780l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Nullable
        public final Bundle f76781m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @NonNull
        public final androidx.loader.content.a<D> f76782n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public u f76783o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public C0848b<D> f76784p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public androidx.loader.content.a<D> f76785q;

        public a(int i11, @Nullable Bundle bundle, @NonNull androidx.loader.content.a<D> aVar, @Nullable androidx.loader.content.a<D> aVar2) {
            this.f76780l = i11;
            this.f76781m = bundle;
            this.f76782n = aVar;
            this.f76785q = aVar2;
            aVar.registerListener(i11, this);
        }

        @Override // androidx.loader.content.a.b
        public void a(@NonNull androidx.loader.content.a<D> aVar, @Nullable D d11) {
            if (b.f76777c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                q(d11);
                return;
            }
            if (b.f76777c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            n(d11);
        }

        @Override // androidx.lifecycle.LiveData
        public void l() {
            if (b.f76777c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f76782n.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public void m() {
            if (b.f76777c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f76782n.stopLoading();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void o(@NonNull d0<? super D> d0Var) {
            super.o(d0Var);
            this.f76783o = null;
            this.f76784p = null;
        }

        @Override // androidx.lifecycle.c0, androidx.lifecycle.LiveData
        public void q(D d11) {
            super.q(d11);
            androidx.loader.content.a<D> aVar = this.f76785q;
            if (aVar != null) {
                aVar.reset();
                this.f76785q = null;
            }
        }

        public androidx.loader.content.a<D> r(boolean z11) {
            if (b.f76777c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f76782n.cancelLoad();
            this.f76782n.abandon();
            C0848b<D> c0848b = this.f76784p;
            if (c0848b != null) {
                o(c0848b);
                if (z11) {
                    c0848b.c();
                }
            }
            this.f76782n.unregisterListener(this);
            if ((c0848b == null || c0848b.b()) && !z11) {
                return this.f76782n;
            }
            this.f76782n.reset();
            return this.f76785q;
        }

        public void s(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f76780l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f76781m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f76782n);
            this.f76782n.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f76784p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f76784p);
                this.f76784p.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(t().dataToString(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(h());
        }

        @NonNull
        public androidx.loader.content.a<D> t() {
            return this.f76782n;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.f76780l);
            sb2.append(" : ");
            androidx.core.util.b.a(this.f76782n, sb2);
            sb2.append("}}");
            return sb2.toString();
        }

        public void u() {
            u uVar = this.f76783o;
            C0848b<D> c0848b = this.f76784p;
            if (uVar == null || c0848b == null) {
                return;
            }
            super.o(c0848b);
            j(uVar, c0848b);
        }

        @NonNull
        public androidx.loader.content.a<D> v(@NonNull u uVar, @NonNull t3.a.InterfaceC0847a<D> interfaceC0847a) {
            C0848b<D> c0848b = new C0848b<>(this.f76782n, interfaceC0847a);
            j(uVar, c0848b);
            C0848b<D> c0848b2 = this.f76784p;
            if (c0848b2 != null) {
                o(c0848b2);
            }
            this.f76783o = uVar;
            this.f76784p = c0848b;
            return this.f76782n;
        }
    }

    /* JADX INFO: renamed from: t3.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0848b<D> implements d0<D> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final androidx.loader.content.a<D> f76786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final t3.a.InterfaceC0847a<D> f76787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f76788c = false;

        public C0848b(@NonNull androidx.loader.content.a<D> aVar, @NonNull t3.a.InterfaceC0847a<D> interfaceC0847a) {
            this.f76786a = aVar;
            this.f76787b = interfaceC0847a;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f76788c);
        }

        public boolean b() {
            return this.f76788c;
        }

        public void c() {
            if (this.f76788c) {
                if (b.f76777c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f76786a);
                }
                this.f76787b.onLoaderReset(this.f76786a);
            }
        }

        @Override // androidx.lifecycle.d0
        public void onChanged(@Nullable D d11) {
            if (b.f76777c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f76786a + ": " + this.f76786a.dataToString(d11));
            }
            this.f76787b.onLoadFinished(this.f76786a, d11);
            this.f76788c = true;
        }

        public String toString() {
            return this.f76787b.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends t0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final v0.c f76789c = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w0<a> f76790a = new w0<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f76791b = false;

        /* JADX INFO: compiled from: source.java */
        public static class a implements v0.c {
            @Override // androidx.lifecycle.v0.c
            @NonNull
            public <T extends t0> T create(@NonNull Class<T> cls) {
                return new c();
            }

            @Override // androidx.lifecycle.v0.c
            public /* synthetic */ t0 create(Class cls, r3.a aVar) {
                return androidx.lifecycle.w0.b(this, cls, aVar);
            }

            @Override // androidx.lifecycle.v0.c
            public /* synthetic */ t0 create(KClass kClass, r3.a aVar) {
                return androidx.lifecycle.w0.c(this, kClass, aVar);
            }
        }

        @NonNull
        public static c d(x0 x0Var) {
            return (c) new v0(x0Var, f76789c).a(c.class);
        }

        public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f76790a.q() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i11 = 0; i11 < this.f76790a.q(); i11++) {
                    a aVarR = this.f76790a.r(i11);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f76790a.l(i11));
                    printWriter.print(": ");
                    printWriter.println(aVarR.toString());
                    aVarR.s(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void c() {
            this.f76791b = false;
        }

        public <D> a<D> e(int i11) {
            return this.f76790a.g(i11);
        }

        public boolean f() {
            return this.f76791b;
        }

        public void g() {
            int iQ = this.f76790a.q();
            for (int i11 = 0; i11 < iQ; i11++) {
                this.f76790a.r(i11).u();
            }
        }

        public void h(int i11, @NonNull a aVar) {
            this.f76790a.m(i11, aVar);
        }

        public void i() {
            this.f76791b = true;
        }

        @Override // androidx.lifecycle.t0
        public void onCleared() {
            super.onCleared();
            int iQ = this.f76790a.q();
            for (int i11 = 0; i11 < iQ; i11++) {
                this.f76790a.r(i11).r(true);
            }
            this.f76790a.b();
        }
    }

    public b(@NonNull u uVar, @NonNull x0 x0Var) {
        this.f76778a = uVar;
        this.f76779b = c.d(x0Var);
    }

    @Override // t3.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f76779b.b(str, fileDescriptor, printWriter, strArr);
    }

    @Override // t3.a
    @NonNull
    public <D> androidx.loader.content.a<D> c(int i11, @Nullable Bundle bundle, @NonNull t3.a.InterfaceC0847a<D> interfaceC0847a) {
        if (this.f76779b.f()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a<D> aVarE = this.f76779b.e(i11);
        if (f76777c) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (aVarE == null) {
            return e(i11, bundle, interfaceC0847a, null);
        }
        if (f76777c) {
            Log.v("LoaderManager", "  Re-using existing loader " + aVarE);
        }
        return aVarE.v(this.f76778a, interfaceC0847a);
    }

    @Override // t3.a
    public void d() {
        this.f76779b.g();
    }

    @NonNull
    public final <D> androidx.loader.content.a<D> e(int i11, @Nullable Bundle bundle, @NonNull t3.a.InterfaceC0847a<D> interfaceC0847a, @Nullable androidx.loader.content.a<D> aVar) {
        try {
            this.f76779b.i();
            androidx.loader.content.a<D> aVarOnCreateLoader = interfaceC0847a.onCreateLoader(i11, bundle);
            if (aVarOnCreateLoader == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (aVarOnCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(aVarOnCreateLoader.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + aVarOnCreateLoader);
            }
            a aVar2 = new a(i11, bundle, aVarOnCreateLoader, aVar);
            if (f76777c) {
                Log.v("LoaderManager", "  Created new loader " + aVar2);
            }
            this.f76779b.h(i11, aVar2);
            this.f76779b.c();
            return aVar2.v(this.f76778a, interfaceC0847a);
        } catch (Throwable th2) {
            this.f76779b.c();
            throw th2;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        androidx.core.util.b.a(this.f76778a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
