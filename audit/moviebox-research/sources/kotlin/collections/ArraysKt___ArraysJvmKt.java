package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public class ArraysKt___ArraysJvmKt extends c {
    public static <T> T[] A(T[] tArr, T t11) {
        Intrinsics.g(tArr, "<this>");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t11;
        Intrinsics.d(tArr2);
        return tArr2;
    }

    public static <T> void B(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void C(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.g(tArr, "<this>");
        Intrinsics.g(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static <T> void D(T[] tArr, Comparator<? super T> comparator, int i11, int i12) {
        Intrinsics.g(tArr, "<this>");
        Intrinsics.g(comparator, "comparator");
        Arrays.sort(tArr, i11, i12, comparator);
    }

    public static List<Byte> e(byte[] bArr) {
        Intrinsics.g(bArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$1(bArr);
    }

    public static List<Integer> f(int[] iArr) {
        Intrinsics.g(iArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$3(iArr);
    }

    public static <T> List<T> g(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        List<T> listA = e.a(tArr);
        Intrinsics.f(listA, "asList(...)");
        return listA;
    }

    @SinceKotlin
    public static byte[] h(byte[] bArr, byte[] destination, int i11, int i12, int i13) {
        Intrinsics.g(bArr, "<this>");
        Intrinsics.g(destination, "destination");
        System.arraycopy(bArr, i12, destination, i11, i13 - i12);
        return destination;
    }

    @SinceKotlin
    public static float[] i(float[] fArr, float[] destination, int i11, int i12, int i13) {
        Intrinsics.g(fArr, "<this>");
        Intrinsics.g(destination, "destination");
        System.arraycopy(fArr, i12, destination, i11, i13 - i12);
        return destination;
    }

    @SinceKotlin
    public static int[] j(int[] iArr, int[] destination, int i11, int i12, int i13) {
        Intrinsics.g(iArr, "<this>");
        Intrinsics.g(destination, "destination");
        System.arraycopy(iArr, i12, destination, i11, i13 - i12);
        return destination;
    }

    @SinceKotlin
    public static long[] k(long[] jArr, long[] destination, int i11, int i12, int i13) {
        Intrinsics.g(jArr, "<this>");
        Intrinsics.g(destination, "destination");
        System.arraycopy(jArr, i12, destination, i11, i13 - i12);
        return destination;
    }

    @SinceKotlin
    public static <T> T[] l(T[] tArr, T[] destination, int i11, int i12, int i13) {
        Intrinsics.g(tArr, "<this>");
        Intrinsics.g(destination, "destination");
        System.arraycopy(tArr, i12, destination, i11, i13 - i12);
        return destination;
    }

    public static /* synthetic */ byte[] m(byte[] bArr, byte[] bArr2, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i11 = 0;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = bArr.length;
        }
        return h(bArr, bArr2, i11, i12, i13);
    }

    public static /* synthetic */ float[] n(float[] fArr, float[] fArr2, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i11 = 0;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = fArr.length;
        }
        return i(fArr, fArr2, i11, i12, i13);
    }

    public static /* synthetic */ int[] o(int[] iArr, int[] iArr2, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i11 = 0;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = iArr.length;
        }
        return j(iArr, iArr2, i11, i12, i13);
    }

    public static /* synthetic */ Object[] p(Object[] objArr, Object[] objArr2, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i11 = 0;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = objArr.length;
        }
        return l(objArr, objArr2, i11, i12, i13);
    }

    @SinceKotlin
    @PublishedApi
    @JvmName
    public static byte[] q(byte[] bArr, int i11, int i12) {
        Intrinsics.g(bArr, "<this>");
        b.b(i12, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i11, i12);
        Intrinsics.f(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    @SinceKotlin
    @PublishedApi
    @JvmName
    public static <T> T[] r(T[] tArr, int i11, int i12) {
        Intrinsics.g(tArr, "<this>");
        b.b(i12, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i11, i12);
        Intrinsics.f(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    public static void s(int[] iArr, int i11, int i12, int i13) {
        Intrinsics.g(iArr, "<this>");
        Arrays.fill(iArr, i12, i13, i11);
    }

    public static final void t(long[] jArr, long j11, int i11, int i12) {
        Intrinsics.g(jArr, "<this>");
        Arrays.fill(jArr, i11, i12, j11);
    }

    public static <T> void u(T[] tArr, T t11, int i11, int i12) {
        Intrinsics.g(tArr, "<this>");
        Arrays.fill(tArr, i11, i12, t11);
    }

    public static /* synthetic */ void v(int[] iArr, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i12 = 0;
        }
        if ((i14 & 4) != 0) {
            i13 = iArr.length;
        }
        s(iArr, i11, i12, i13);
    }

    public static /* synthetic */ void w(long[] jArr, long j11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = jArr.length;
        }
        t(jArr, j11, i11, i12);
    }

    public static /* synthetic */ void x(Object[] objArr, Object obj, int i11, int i12, int i13, Object obj2) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = objArr.length;
        }
        u(objArr, obj, i11, i12);
    }

    public static int[] y(int[] iArr, int i11) {
        Intrinsics.g(iArr, "<this>");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
        iArrCopyOf[length] = i11;
        Intrinsics.d(iArrCopyOf);
        return iArrCopyOf;
    }

    public static int[] z(int[] iArr, int[] elements) {
        Intrinsics.g(iArr, "<this>");
        Intrinsics.g(elements, "elements");
        int length = iArr.length;
        int length2 = elements.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(elements, 0, iArrCopyOf, length, length2);
        Intrinsics.d(iArrCopyOf);
        return iArrCopyOf;
    }
}
