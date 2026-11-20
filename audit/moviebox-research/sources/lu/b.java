package lu;

import android.os.Looper;
import androidx.lifecycle.c0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.q1;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f70539a = getClass().getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile T f70540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile c0<T> f70541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile h10.b f70542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile q1 f70543e;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(b bVar, c0 c0Var, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
        }
        if ((i11 & 1) != 0) {
            c0Var = null;
        }
        bVar.f(c0Var);
    }

    public final synchronized T a() {
        T t11;
        t11 = this.f70540b;
        this.f70540b = null;
        return t11;
    }

    public final String b() {
        return this.f70539a;
    }

    public final void c(T t11) {
        if (this.f70541c == null) {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = this.f70539a;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "load data handleFailureResult :", false, 4, null);
        } else {
            uo.b.a aVar2 = uo.b.f78622a;
            String TAG2 = this.f70539a;
            Intrinsics.f(TAG2, "TAG");
            uo.b.a.f(aVar2, TAG2, "load data handleFailureResult : return to ui", false, 4, null);
            if (Intrinsics.b(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                c0<T> c0Var = this.f70541c;
                if (c0Var != null) {
                    c0Var.q(t11);
                }
            } else {
                c0<T> c0Var2 = this.f70541c;
                if (c0Var2 != null) {
                    c0Var2.n(t11);
                }
            }
        }
        h10.b bVar = this.f70542d;
        if (bVar != null) {
            d.a(bVar);
        }
    }

    public final void d(T t11) {
        if (this.f70541c == null) {
            this.f70540b = t11;
            uo.b.a aVar = uo.b.f78622a;
            String TAG = this.f70539a;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "load data handleSuccessResult : cache data", false, 4, null);
        } else {
            uo.b.a aVar2 = uo.b.f78622a;
            String TAG2 = this.f70539a;
            Intrinsics.f(TAG2, "TAG");
            uo.b.a.f(aVar2, TAG2, "load data handleSuccessResult : return to ui", false, 4, null);
            if (Intrinsics.b(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                c0<T> c0Var = this.f70541c;
                if (c0Var != null) {
                    c0Var.q(t11);
                }
            } else {
                c0<T> c0Var2 = this.f70541c;
                if (c0Var2 != null) {
                    c0Var2.n(t11);
                }
            }
        }
        h10.b bVar = this.f70542d;
        if (bVar != null) {
            d.a(bVar);
        }
    }

    public final boolean e(c0<T> c0Var) {
        if (this.f70540b == null) {
            this.f70541c = c0Var;
            return true;
        }
        if (c0Var == null) {
            return false;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f70539a;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "load data from preload", false, 4, null);
        c0Var.q(this.f70540b);
        this.f70540b = null;
        return false;
    }

    public final void f(c0<T> c0Var) {
        q1 q1Var;
        if (e(c0Var)) {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = this.f70539a;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "loadData  disposable:" + this.f70542d + "  this:" + this, false, 4, null);
            h10.b bVar = this.f70542d;
            if ((bVar != null && !bVar.isDisposed()) || ((q1Var = this.f70543e) != null && q1Var.isActive())) {
                String TAG2 = this.f70539a;
                Intrinsics.f(TAG2, "TAG");
                uo.b.a.f(aVar, TAG2, "load data ing .. wait", false, 4, null);
            } else {
                String TAG3 = this.f70539a;
                Intrinsics.f(TAG3, "TAG");
                uo.b.a.f(aVar, TAG3, "loadDataFromService", false, 4, null);
                h(c0Var);
            }
        }
    }

    public abstract void h(c0<T> c0Var);

    public final void i(h10.b bVar) {
        this.f70542d = bVar;
    }

    public final void j(q1 q1Var) {
        this.f70543e = q1Var;
    }
}
