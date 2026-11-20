package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.k0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public class j0<T extends k0 & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f69471b = AtomicIntegerFieldUpdater.newUpdater(j0.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T[] f69472a;

    @PublishedApi
    public final void a(T t11) {
        t11.setHeap(this);
        k0[] k0VarArrG = g();
        int iC = c();
        k(iC + 1);
        k0VarArrG[iC] = t11;
        t11.setIndex(iC);
        m(iC);
    }

    @PublishedApi
    public final T b() {
        T[] tArr = this.f69472a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return f69471b.get(this);
    }

    public final boolean e() {
        return c() == 0;
    }

    public final T f() {
        T t11;
        synchronized (this) {
            t11 = (T) b();
        }
        return t11;
    }

    public final T[] g() {
        T[] tArr = this.f69472a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new k0[4];
            this.f69472a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, c() * 2);
        Intrinsics.f(objArrCopyOf, "copyOf(...)");
        T[] tArr3 = (T[]) ((k0[]) objArrCopyOf);
        this.f69472a = tArr3;
        return tArr3;
    }

    public final boolean h(T t11) {
        boolean z11;
        synchronized (this) {
            if (t11.getHeap() == null) {
                z11 = false;
            } else {
                i(t11.getIndex());
                z11 = true;
            }
        }
        return z11;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003a  */
    @PublishedApi
    public final T i(int i11) {
        T[] tArr = this.f69472a;
        Intrinsics.d(tArr);
        k(c() - 1);
        if (i11 < c()) {
            n(i11, c());
            int i12 = (i11 - 1) / 2;
            if (i11 > 0) {
                T t11 = tArr[i11];
                Intrinsics.d(t11);
                T t12 = tArr[i12];
                Intrinsics.d(t12);
                if (((Comparable) t11).compareTo(t12) < 0) {
                    n(i11, i12);
                    m(i12);
                } else {
                    l(i11);
                }
            } else {
                l(i11);
            }
        }
        T t13 = tArr[c()];
        Intrinsics.d(t13);
        t13.setHeap(null);
        t13.setIndex(-1);
        tArr[c()] = null;
        return t13;
    }

    public final T j() {
        T t11;
        synchronized (this) {
            t11 = c() > 0 ? (T) i(0) : null;
        }
        return t11;
    }

    public final void k(int i11) {
        f69471b.set(this, i11);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    public final void l(int i11) {
        while (true) {
            int i12 = i11 * 2;
            int i13 = i12 + 1;
            if (i13 >= c()) {
                return;
            }
            T[] tArr = this.f69472a;
            Intrinsics.d(tArr);
            int i14 = i12 + 2;
            if (i14 < c()) {
                T t11 = tArr[i14];
                Intrinsics.d(t11);
                T t12 = tArr[i13];
                Intrinsics.d(t12);
                if (((Comparable) t11).compareTo(t12) >= 0) {
                    i14 = i13;
                }
            } else {
                i14 = i13;
            }
            T t13 = tArr[i11];
            Intrinsics.d(t13);
            T t14 = tArr[i14];
            Intrinsics.d(t14);
            if (((Comparable) t13).compareTo(t14) <= 0) {
                return;
            }
            n(i11, i14);
            i11 = i14;
        }
    }

    public final void m(int i11) {
        while (i11 > 0) {
            T[] tArr = this.f69472a;
            Intrinsics.d(tArr);
            int i12 = (i11 - 1) / 2;
            T t11 = tArr[i12];
            Intrinsics.d(t11);
            T t12 = tArr[i11];
            Intrinsics.d(t12);
            if (((Comparable) t11).compareTo(t12) <= 0) {
                return;
            }
            n(i11, i12);
            i11 = i12;
        }
    }

    public final void n(int i11, int i12) {
        T[] tArr = this.f69472a;
        Intrinsics.d(tArr);
        T t11 = tArr[i12];
        Intrinsics.d(t11);
        T t12 = tArr[i11];
        Intrinsics.d(t12);
        tArr[i11] = t11;
        tArr[i12] = t12;
        t11.setIndex(i11);
        t12.setIndex(i12);
    }
}
