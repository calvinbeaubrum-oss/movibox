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
public class v<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public /* synthetic */ boolean f1996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public /* synthetic */ long[] f1997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public /* synthetic */ Object[] f1998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public /* synthetic */ int f1999d;

    @JvmOverloads
    public v() {
        this(0, 1, null);
    }

    @JvmOverloads
    public v(int i11) {
        if (i11 == 0) {
            this.f1997b = m1.a.f70586b;
            this.f1998c = m1.a.f70587c;
        } else {
            int iF = m1.a.f(i11);
            this.f1997b = new long[iF];
            this.f1998c = new Object[iF];
        }
    }

    public /* synthetic */ v(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 10 : i11);
    }

    public void a(long j11, E e11) {
        int i11 = this.f1999d;
        if (i11 != 0 && j11 <= this.f1997b[i11 - 1]) {
            l(j11, e11);
            return;
        }
        if (this.f1996a) {
            long[] jArr = this.f1997b;
            if (i11 >= jArr.length) {
                Object[] objArr = this.f1998c;
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    Object obj = objArr[i13];
                    if (obj != w.f2000a) {
                        if (i13 != i12) {
                            jArr[i12] = jArr[i13];
                            objArr[i12] = obj;
                            objArr[i13] = null;
                        }
                        i12++;
                    }
                }
                this.f1996a = false;
                this.f1999d = i12;
            }
        }
        int i14 = this.f1999d;
        if (i14 >= this.f1997b.length) {
            int iF = m1.a.f(i14 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.f1997b, iF);
            Intrinsics.f(jArrCopyOf, "copyOf(this, newSize)");
            this.f1997b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f1998c, iF);
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f1998c = objArrCopyOf;
        }
        this.f1997b[i14] = j11;
        this.f1998c[i14] = e11;
        this.f1999d = i14 + 1;
    }

    public void b() {
        int i11 = this.f1999d;
        Object[] objArr = this.f1998c;
        for (int i12 = 0; i12 < i11; i12++) {
            objArr[i12] = null;
        }
        this.f1999d = 0;
        this.f1996a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public v<E> clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        Intrinsics.e(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        v<E> vVar = (v) objClone;
        vVar.f1997b = (long[]) this.f1997b.clone();
        vVar.f1998c = (Object[]) this.f1998c.clone();
        return vVar;
    }

    public boolean d(long j11) {
        return h(j11) >= 0;
    }

    public E f(long j11) {
        int iB = m1.a.b(this.f1997b, this.f1999d, j11);
        if (iB < 0 || this.f1998c[iB] == w.f2000a) {
            return null;
        }
        return (E) this.f1998c[iB];
    }

    public E g(long j11, E e11) {
        int iB = m1.a.b(this.f1997b, this.f1999d, j11);
        return (iB < 0 || this.f1998c[iB] == w.f2000a) ? e11 : (E) this.f1998c[iB];
    }

    public int h(long j11) {
        if (this.f1996a) {
            int i11 = this.f1999d;
            long[] jArr = this.f1997b;
            Object[] objArr = this.f1998c;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != w.f2000a) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.f1996a = false;
            this.f1999d = i12;
        }
        return m1.a.b(this.f1997b, this.f1999d, j11);
    }

    public boolean j() {
        return o() == 0;
    }

    public long k(int i11) {
        if (!(i11 >= 0 && i11 < this.f1999d)) {
            m1.d.a("Expected index to be within 0..size()-1, but was " + i11);
        }
        if (this.f1996a) {
            int i12 = this.f1999d;
            long[] jArr = this.f1997b;
            Object[] objArr = this.f1998c;
            int i13 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                Object obj = objArr[i14];
                if (obj != w.f2000a) {
                    if (i14 != i13) {
                        jArr[i13] = jArr[i14];
                        objArr[i13] = obj;
                        objArr[i14] = null;
                    }
                    i13++;
                }
            }
            this.f1996a = false;
            this.f1999d = i13;
        }
        return this.f1997b[i11];
    }

    public void l(long j11, E e11) {
        int iB = m1.a.b(this.f1997b, this.f1999d, j11);
        if (iB >= 0) {
            this.f1998c[iB] = e11;
            return;
        }
        int i11 = ~iB;
        if (i11 < this.f1999d && this.f1998c[i11] == w.f2000a) {
            this.f1997b[i11] = j11;
            this.f1998c[i11] = e11;
            return;
        }
        if (this.f1996a) {
            int i12 = this.f1999d;
            long[] jArr = this.f1997b;
            if (i12 >= jArr.length) {
                Object[] objArr = this.f1998c;
                int i13 = 0;
                for (int i14 = 0; i14 < i12; i14++) {
                    Object obj = objArr[i14];
                    if (obj != w.f2000a) {
                        if (i14 != i13) {
                            jArr[i13] = jArr[i14];
                            objArr[i13] = obj;
                            objArr[i14] = null;
                        }
                        i13++;
                    }
                }
                this.f1996a = false;
                this.f1999d = i13;
                i11 = ~m1.a.b(this.f1997b, i13, j11);
            }
        }
        int i15 = this.f1999d;
        if (i15 >= this.f1997b.length) {
            int iF = m1.a.f(i15 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.f1997b, iF);
            Intrinsics.f(jArrCopyOf, "copyOf(this, newSize)");
            this.f1997b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f1998c, iF);
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f1998c = objArrCopyOf;
        }
        int i16 = this.f1999d;
        if (i16 - i11 != 0) {
            long[] jArr2 = this.f1997b;
            int i17 = i11 + 1;
            ArraysKt___ArraysJvmKt.k(jArr2, jArr2, i17, i11, i16);
            Object[] objArr2 = this.f1998c;
            ArraysKt___ArraysJvmKt.l(objArr2, objArr2, i17, i11, this.f1999d);
        }
        this.f1997b[i11] = j11;
        this.f1998c[i11] = e11;
        this.f1999d++;
    }

    public void m(long j11) {
        int iB = m1.a.b(this.f1997b, this.f1999d, j11);
        if (iB < 0 || this.f1998c[iB] == w.f2000a) {
            return;
        }
        this.f1998c[iB] = w.f2000a;
        this.f1996a = true;
    }

    public void n(int i11) {
        if (this.f1998c[i11] != w.f2000a) {
            this.f1998c[i11] = w.f2000a;
            this.f1996a = true;
        }
    }

    public int o() {
        if (this.f1996a) {
            int i11 = this.f1999d;
            long[] jArr = this.f1997b;
            Object[] objArr = this.f1998c;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != w.f2000a) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.f1996a = false;
            this.f1999d = i12;
        }
        return this.f1999d;
    }

    public E p(int i11) {
        if (!(i11 >= 0 && i11 < this.f1999d)) {
            m1.d.a("Expected index to be within 0..size()-1, but was " + i11);
        }
        if (this.f1996a) {
            int i12 = this.f1999d;
            long[] jArr = this.f1997b;
            Object[] objArr = this.f1998c;
            int i13 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                Object obj = objArr[i14];
                if (obj != w.f2000a) {
                    if (i14 != i13) {
                        jArr[i13] = jArr[i14];
                        objArr[i13] = obj;
                        objArr[i14] = null;
                    }
                    i13++;
                }
            }
            this.f1996a = false;
            this.f1999d = i13;
        }
        return (E) this.f1998c[i11];
    }

    public String toString() {
        if (o() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f1999d * 28);
        sb2.append('{');
        int i11 = this.f1999d;
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            sb2.append(k(i12));
            sb2.append('=');
            E eP = p(i12);
            if (eP != sb2) {
                sb2.append(eP);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }
}
