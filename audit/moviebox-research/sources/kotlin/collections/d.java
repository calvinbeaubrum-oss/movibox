package kotlin.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;

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
public class d extends ArraysKt___ArraysJvmKt {
    public static <T> List<T> A0(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? D0(tArr) : f.e(tArr[0]);
        }
        return g.l();
    }

    public static final List<Integer> B0(int[] iArr) {
        Intrinsics.g(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i11 : iArr) {
            arrayList.add(Integer.valueOf(i11));
        }
        return arrayList;
    }

    public static final List<Long> C0(long[] jArr) {
        Intrinsics.g(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j11 : jArr) {
            arrayList.add(Long.valueOf(j11));
        }
        return arrayList;
    }

    public static <T> List<T> D0(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        return new ArrayList(g.i(tArr));
    }

    public static boolean E(byte[] bArr, byte b11) {
        Intrinsics.g(bArr, "<this>");
        return W(bArr, b11) >= 0;
    }

    public static final <T> Set<T> E0(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? (Set) x0(tArr, new LinkedHashSet(r.e(tArr.length))) : v.d(tArr[0]);
        }
        return w.f();
    }

    public static boolean F(char[] cArr, char c11) {
        Intrinsics.g(cArr, "<this>");
        return X(cArr, c11) >= 0;
    }

    public static boolean G(int[] iArr, int i11) {
        Intrinsics.g(iArr, "<this>");
        return Y(iArr, i11) >= 0;
    }

    public static boolean H(long[] jArr, long j11) {
        Intrinsics.g(jArr, "<this>");
        return Z(jArr, j11) >= 0;
    }

    public static <T> boolean I(T[] tArr, T t11) {
        Intrinsics.g(tArr, "<this>");
        return a0(tArr, t11) >= 0;
    }

    public static boolean J(short[] sArr, short s11) {
        Intrinsics.g(sArr, "<this>");
        return b0(sArr, s11) >= 0;
    }

    public static final boolean K(boolean[] zArr, boolean z11) {
        Intrinsics.g(zArr, "<this>");
        return c0(zArr, z11) >= 0;
    }

    public static <T> List<T> L(T[] tArr, int i11) {
        Intrinsics.g(tArr, "<this>");
        if (i11 >= 0) {
            return w0(tArr, kotlin.ranges.a.d(tArr.length - i11, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
    }

    public static <T> List<T> M(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        return (List) N(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C N(T[] tArr, C destination) {
        Intrinsics.g(tArr, "<this>");
        Intrinsics.g(destination, "destination");
        for (T t11 : tArr) {
            if (t11 != null) {
                destination.add(t11);
            }
        }
        return destination;
    }

    public static <T> T O(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T P(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static IntRange Q(int[] iArr) {
        Intrinsics.g(iArr, "<this>");
        return new IntRange(0, S(iArr));
    }

    public static <T> IntRange R(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        return new IntRange(0, U(tArr));
    }

    public static int S(int[] iArr) {
        Intrinsics.g(iArr, "<this>");
        return iArr.length - 1;
    }

    public static int T(long[] jArr) {
        Intrinsics.g(jArr, "<this>");
        return jArr.length - 1;
    }

    public static <T> int U(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        return tArr.length - 1;
    }

    public static <T> T V(T[] tArr, int i11) {
        Intrinsics.g(tArr, "<this>");
        if (i11 < 0 || i11 > U(tArr)) {
            return null;
        }
        return tArr[i11];
    }

    public static int W(byte[] bArr, byte b11) {
        Intrinsics.g(bArr, "<this>");
        int length = bArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (b11 == bArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static final int X(char[] cArr, char c11) {
        Intrinsics.g(cArr, "<this>");
        int length = cArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (c11 == cArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static int Y(int[] iArr, int i11) {
        Intrinsics.g(iArr, "<this>");
        int length = iArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (i11 == iArr[i12]) {
                return i12;
            }
        }
        return -1;
    }

    public static int Z(long[] jArr, long j11) {
        Intrinsics.g(jArr, "<this>");
        int length = jArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (j11 == jArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static <T> int a0(T[] tArr, T t11) {
        Intrinsics.g(tArr, "<this>");
        int i11 = 0;
        if (t11 == null) {
            int length = tArr.length;
            while (i11 < length) {
                if (tArr[i11] == null) {
                    return i11;
                }
                i11++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i11 < length2) {
            if (Intrinsics.b(t11, tArr[i11])) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static int b0(short[] sArr, short s11) {
        Intrinsics.g(sArr, "<this>");
        int length = sArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (s11 == sArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static final int c0(boolean[] zArr, boolean z11) {
        Intrinsics.g(zArr, "<this>");
        int length = zArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (z11 == zArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static final <A extends Appendable> A d0(byte[] bArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated, Function1<? super Byte, ? extends CharSequence> function1) throws IOException {
        Intrinsics.g(bArr, "<this>");
        Intrinsics.g(buffer, "buffer");
        Intrinsics.g(separator, "separator");
        Intrinsics.g(prefix, "prefix");
        Intrinsics.g(postfix, "postfix");
        Intrinsics.g(truncated, "truncated");
        buffer.append(prefix);
        int i12 = 0;
        for (byte b11 : bArr) {
            i12++;
            if (i12 > 1) {
                buffer.append(separator);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Byte.valueOf(b11)));
            } else {
                buffer.append(String.valueOf((int) b11));
            }
        }
        if (i11 >= 0 && i12 > i11) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T, A extends Appendable> A e0(T[] tArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics.g(tArr, "<this>");
        Intrinsics.g(buffer, "buffer");
        Intrinsics.g(separator, "separator");
        Intrinsics.g(prefix, "prefix");
        Intrinsics.g(postfix, "postfix");
        Intrinsics.g(truncated, "truncated");
        buffer.append(prefix);
        int i12 = 0;
        for (T t11 : tArr) {
            i12++;
            if (i12 > 1) {
                buffer.append(separator);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            kotlin.text.e.a(buffer, t11, function1);
        }
        if (i11 >= 0 && i12 > i11) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String f0(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated, Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.g(bArr, "<this>");
        Intrinsics.g(separator, "separator");
        Intrinsics.g(prefix, "prefix");
        Intrinsics.g(postfix, "postfix");
        Intrinsics.g(truncated, "truncated");
        String string = ((StringBuilder) d0(bArr, new StringBuilder(), separator, prefix, postfix, i11, truncated, function1)).toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    public static final <T> String g0(T[] tArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.g(tArr, "<this>");
        Intrinsics.g(separator, "separator");
        Intrinsics.g(prefix, "prefix");
        Intrinsics.g(postfix, "postfix");
        Intrinsics.g(truncated, "truncated");
        String string = ((StringBuilder) e0(tArr, new StringBuilder(), separator, prefix, postfix, i11, truncated, function1)).toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String h0(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, Function1 function1, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i12 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i12 & 4) == 0 ? charSequence3 : "";
        int i13 = (i12 & 8) != 0 ? -1 : i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            function1 = null;
        }
        return f0(bArr, charSequence, charSequence5, charSequence6, i13, charSequence7, function1);
    }

    public static /* synthetic */ String i0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, Function1 function1, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i12 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i12 & 4) == 0 ? charSequence3 : "";
        int i13 = (i12 & 8) != 0 ? -1 : i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            function1 = null;
        }
        return g0(objArr, charSequence, charSequence5, charSequence6, i13, charSequence7, function1);
    }

    public static <T> T j0(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[U(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static int k0(byte[] bArr, byte b11) {
        Intrinsics.g(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (b11 == bArr[length]) {
                    return length;
                }
                if (i11 >= 0) {
                    length = i11;
                }
            }
        }
        return -1;
    }

    public static final int l0(char[] cArr, char c11) {
        Intrinsics.g(cArr, "<this>");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (c11 == cArr[length]) {
                    return length;
                }
                if (i11 >= 0) {
                    length = i11;
                }
            }
        }
        return -1;
    }

    public static int m0(int[] iArr, int i11) {
        Intrinsics.g(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i12 = length - 1;
                if (i11 == iArr[length]) {
                    return length;
                }
                if (i12 >= 0) {
                    length = i12;
                }
            }
        }
        return -1;
    }

    public static int n0(long[] jArr, long j11) {
        Intrinsics.g(jArr, "<this>");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (j11 == jArr[length]) {
                    return length;
                }
                if (i11 >= 0) {
                    length = i11;
                }
            }
        }
        return -1;
    }

    public static <T> int o0(T[] tArr, T t11) {
        Intrinsics.g(tArr, "<this>");
        if (t11 == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i11 = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i11 >= 0) {
                        length = i11;
                    }
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i12 = length2 - 1;
                    if (Intrinsics.b(t11, tArr[length2])) {
                        return length2;
                    }
                    if (i12 < 0) {
                        break;
                    }
                    length2 = i12;
                }
            }
        }
        return -1;
    }

    public static int p0(short[] sArr, short s11) {
        Intrinsics.g(sArr, "<this>");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (s11 == sArr[length]) {
                    return length;
                }
                if (i11 >= 0) {
                    length = i11;
                }
            }
        }
        return -1;
    }

    public static final int q0(boolean[] zArr, boolean z11) {
        Intrinsics.g(zArr, "<this>");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (z11 == zArr[length]) {
                    return length;
                }
                if (i11 >= 0) {
                    length = i11;
                }
            }
        }
        return -1;
    }

    @SinceKotlin
    public static <T> T r0(T[] tArr, Random random) {
        Intrinsics.g(tArr, "<this>");
        Intrinsics.g(random, "random");
        if (tArr.length != 0) {
            return tArr[random.nextInt(tArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static char s0(char[] cArr) {
        Intrinsics.g(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T t0(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static <T extends Comparable<? super T>> List<T> u0(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        return ArraysKt___ArraysJvmKt.g(v0(tArr));
    }

    public static final <T extends Comparable<? super T>> T[] v0(T[] tArr) {
        Intrinsics.g(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.f(objArrCopyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        ArraysKt___ArraysJvmKt.B(tArr2);
        return tArr2;
    }

    public static final <T> List<T> w0(T[] tArr, int i11) {
        Intrinsics.g(tArr, "<this>");
        if (i11 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
        }
        if (i11 == 0) {
            return g.l();
        }
        int length = tArr.length;
        if (i11 >= length) {
            return A0(tArr);
        }
        if (i11 == 1) {
            return f.e(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = length - i11; i12 < length; i12++) {
            arrayList.add(tArr[i12]);
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C x0(T[] tArr, C destination) {
        Intrinsics.g(tArr, "<this>");
        Intrinsics.g(destination, "destination");
        for (T t11 : tArr) {
            destination.add(t11);
        }
        return destination;
    }

    public static List<Integer> y0(int[] iArr) {
        Intrinsics.g(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            return length != 1 ? B0(iArr) : f.e(Integer.valueOf(iArr[0]));
        }
        return g.l();
    }

    public static List<Long> z0(long[] jArr) {
        Intrinsics.g(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            return length != 1 ? C0(jArr) : f.e(Long.valueOf(jArr[0]));
        }
        return g.l();
    }
}
