package androidx.collection;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public class w0<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public /* synthetic */ boolean f2001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public /* synthetic */ int[] f2002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public /* synthetic */ Object[] f2003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public /* synthetic */ int f2004d;

    @JvmOverloads
    public w0() {
        this(0, 1, null);
    }

    @JvmOverloads
    public w0(int i11) {
        if (i11 == 0) {
            this.f2002b = m1.a.f70585a;
            this.f2003c = m1.a.f70587c;
        } else {
            int iE = m1.a.e(i11);
            this.f2002b = new int[iE];
            this.f2003c = new Object[iE];
        }
    }

    public /* synthetic */ w0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 10 : i11);
    }

    public void a(int i11, E e11) {
        int i12 = this.f2004d;
        if (i12 != 0 && i11 <= this.f2002b[i12 - 1]) {
            m(i11, e11);
            return;
        }
        if (this.f2001a && i12 >= this.f2002b.length) {
            x0.f(this);
        }
        int i13 = this.f2004d;
        if (i13 >= this.f2002b.length) {
            int iE = m1.a.e(i13 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f2002b, iE);
            Intrinsics.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f2002b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f2003c, iE);
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f2003c = objArrCopyOf;
        }
        this.f2002b[i13] = i11;
        this.f2003c[i13] = e11;
        this.f2004d = i13 + 1;
    }

    public void b() {
        int i11 = this.f2004d;
        Object[] objArr = this.f2003c;
        for (int i12 = 0; i12 < i11; i12++) {
            objArr[i12] = null;
        }
        this.f2004d = 0;
        this.f2001a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public w0<E> clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        Intrinsics.e(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        w0<E> w0Var = (w0) objClone;
        w0Var.f2002b = (int[]) this.f2002b.clone();
        w0Var.f2003c = (Object[]) this.f2003c.clone();
        return w0Var;
    }

    public boolean d(int i11) {
        return j(i11) >= 0;
    }

    public boolean f(E e11) {
        if (this.f2001a) {
            x0.f(this);
        }
        int i11 = this.f2004d;
        int i12 = 0;
        while (i12 < i11) {
            if (this.f2003c[i12] == e11) {
                return i12 >= 0;
            }
            i12++;
        }
        return false;
    }

    public E g(int i11) {
        return (E) x0.c(this, i11);
    }

    public E h(int i11, E e11) {
        return (E) x0.d(this, i11, e11);
    }

    public int j(int i11) {
        if (this.f2001a) {
            x0.f(this);
        }
        return m1.a.a(this.f2002b, this.f2004d, i11);
    }

    public int k(E e11) {
        if (this.f2001a) {
            x0.f(this);
        }
        int i11 = this.f2004d;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.f2003c[i12] == e11) {
                return i12;
            }
        }
        return -1;
    }

    public int l(int i11) {
        if (this.f2001a) {
            x0.f(this);
        }
        return this.f2002b[i11];
    }

    public void m(int i11, E e11) {
        int iA = m1.a.a(this.f2002b, this.f2004d, i11);
        if (iA >= 0) {
            this.f2003c[iA] = e11;
            return;
        }
        int i12 = ~iA;
        if (i12 < this.f2004d && this.f2003c[i12] == x0.f2005a) {
            this.f2002b[i12] = i11;
            this.f2003c[i12] = e11;
            return;
        }
        if (this.f2001a && this.f2004d >= this.f2002b.length) {
            x0.f(this);
            i12 = ~m1.a.a(this.f2002b, this.f2004d, i11);
        }
        int i13 = this.f2004d;
        if (i13 >= this.f2002b.length) {
            int iE = m1.a.e(i13 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f2002b, iE);
            Intrinsics.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f2002b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f2003c, iE);
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f2003c = objArrCopyOf;
        }
        int i14 = this.f2004d;
        if (i14 - i12 != 0) {
            int[] iArr = this.f2002b;
            int i15 = i12 + 1;
            ArraysKt___ArraysJvmKt.j(iArr, iArr, i15, i12, i14);
            Object[] objArr = this.f2003c;
            ArraysKt___ArraysJvmKt.l(objArr, objArr, i15, i12, this.f2004d);
        }
        this.f2002b[i12] = i11;
        this.f2003c[i12] = e11;
        this.f2004d++;
    }

    public void n(int i11) {
        x0.e(this, i11);
    }

    public void o(int i11) {
        if (this.f2003c[i11] != x0.f2005a) {
            this.f2003c[i11] = x0.f2005a;
            this.f2001a = true;
        }
    }

    public E p(int i11, E e11) {
        int iJ = j(i11);
        if (iJ < 0) {
            return null;
        }
        Object[] objArr = this.f2003c;
        E e12 = (E) objArr[iJ];
        objArr[iJ] = e11;
        return e12;
    }

    public int q() {
        if (this.f2001a) {
            x0.f(this);
        }
        return this.f2004d;
    }

    public E r(int i11) {
        if (this.f2001a) {
            x0.f(this);
        }
        return (E) this.f2003c[i11];
    }

    public String toString() {
        if (q() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f2004d * 28);
        sb2.append('{');
        int i11 = this.f2004d;
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            sb2.append(l(i12));
            sb2.append('=');
            E eR = r(i12);
            if (eR != this) {
                sb2.append(eR);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        Intrinsics.f(string, "buffer.toString()");
        return string;
    }
}
