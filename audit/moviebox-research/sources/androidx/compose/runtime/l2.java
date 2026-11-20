package androidx.compose.runtime;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;

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
public final class l2 {
    public static final int B(int[] iArr, int i11) {
        int i12 = i11 * 5;
        if (i12 >= iArr.length) {
            return iArr.length;
        }
        return E(iArr[i12 + 1] >> 29) + iArr[i12 + 4];
    }

    public static final boolean C(int[] iArr, int i11) {
        return (iArr[(i11 * 5) + 1] & 201326592) != 0;
    }

    public static final boolean D(int[] iArr, int i11) {
        return (iArr[(i11 * 5) + 1] & 67108864) != 0;
    }

    public static final int E(int i11) {
        switch (i11) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 4:
                return 1;
            case 3:
            case 5:
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static final int F(int[] iArr, int i11) {
        return iArr[(i11 * 5) + 4];
    }

    public static final c G(ArrayList<c> arrayList, int i11, int i12) {
        int iU = U(arrayList, i11, i12);
        if (iU >= 0) {
            return arrayList.get(iU);
        }
        return null;
    }

    public static final int H(int[] iArr, int i11) {
        return iArr[(i11 * 5) + 1];
    }

    public static final int I(int[] iArr, int i11) {
        return iArr[(i11 * 5) + 3];
    }

    public static final boolean J(int[] iArr, int i11) {
        return (iArr[(i11 * 5) + 1] & ASTNode.DEOP) != 0;
    }

    public static final boolean K(int[] iArr, int i11) {
        return (iArr[(i11 * 5) + 1] & ASTNode.NOJIT) != 0;
    }

    public static final boolean L(int[] iArr, int i11) {
        return (iArr[(i11 * 5) + 1] & ASTNode.DISCARD) != 0;
    }

    public static final void M(int[] iArr, int i11, int i12, boolean z11, boolean z12, boolean z13, int i13, int i14) {
        int i15 = z11 ? 1073741824 : 0;
        int i16 = z12 ? ASTNode.DISCARD : 0;
        int i17 = z13 ? ASTNode.DEOP : 0;
        int i18 = i11 * 5;
        iArr[i18] = i12;
        iArr[i18 + 1] = i15 | i16 | i17;
        iArr[i18 + 2] = i13;
        iArr[i18 + 3] = 0;
        iArr[i18 + 4] = i14;
    }

    public static final boolean N(int[] iArr, int i11) {
        return (iArr[(i11 * 5) + 1] & 1073741824) != 0;
    }

    public static final int O(int[] iArr, int i11) {
        return iArr[i11 * 5];
    }

    public static final int P(ArrayList<c> arrayList, int i11, int i12) {
        int iU = U(arrayList, i11, i12);
        return iU >= 0 ? iU : -(iU + 1);
    }

    public static final int Q(int[] iArr, int i11) {
        return iArr[(i11 * 5) + 1] & 67108863;
    }

    public static final int R(int[] iArr, int i11) {
        return iArr[(i11 * 5) + 4];
    }

    public static final int S(int[] iArr, int i11) {
        int i12 = i11 * 5;
        return iArr[i12 + 4] + E(iArr[i12 + 1] >> 30);
    }

    public static final int T(int[] iArr, int i11) {
        return iArr[(i11 * 5) + 2];
    }

    public static final int U(ArrayList<c> arrayList, int i11, int i12) {
        int size = arrayList.size() - 1;
        int i13 = 0;
        while (i13 <= size) {
            int i14 = (i13 + size) >>> 1;
            int iA = arrayList.get(i14).a();
            if (iA < 0) {
                iA += i12;
            }
            int i15 = Intrinsics.i(iA, i11);
            if (i15 < 0) {
                i13 = i14 + 1;
            } else {
                if (i15 <= 0) {
                    return i14;
                }
                size = i14 - 1;
            }
        }
        return -(i13 + 1);
    }

    public static final int V(int[] iArr, int i11) {
        int i12 = i11 * 5;
        return iArr[i12 + 4] + E(iArr[i12 + 1] >> 28);
    }

    public static final void W(int[] iArr, int i11, boolean z11) {
        int i12 = (i11 * 5) + 1;
        if (z11) {
            iArr[i12] = iArr[i12] | 67108864;
        } else {
            iArr[i12] = iArr[i12] & (-67108865);
        }
    }

    public static final void X(int[] iArr, int i11, int i12) {
        iArr[(i11 * 5) + 4] = i12;
    }

    public static final void Y(int[] iArr, int i11, int i12) {
        k.Q(i12 >= 0);
        iArr[(i11 * 5) + 3] = i12;
    }

    public static final void Z(int[] iArr, int i11, boolean z11) {
        int i12 = (i11 * 5) + 1;
        if (z11) {
            iArr[i12] = iArr[i12] | ASTNode.NOJIT;
        } else {
            iArr[i12] = iArr[i12] & (-134217729);
        }
    }

    public static final void a0(int[] iArr, int i11, int i12) {
        k.Q(i12 >= 0 && i12 < 67108863);
        int i13 = (i11 * 5) + 1;
        iArr[i13] = i12 | (iArr[i13] & (-67108864));
    }

    public static final void b0(int[] iArr, int i11, int i12) {
        iArr[(i11 * 5) + 2] = i12;
    }
}
