package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public int[] f1942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public int f1943b;

    public l(int i11) {
        this.f1942a = i11 == 0 ? q.a() : new int[i11];
    }

    public /* synthetic */ l(int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11);
    }

    public static /* synthetic */ String e(l lVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i12 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i12 & 4) == 0 ? charSequence3 : "";
        int i13 = (i12 & 8) != 0 ? -1 : i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        return lVar.d(charSequence, charSequence5, charSequence6, i13, charSequence4);
    }

    public final int a(int i11) {
        if (i11 >= 0 && i11 < this.f1943b) {
            return this.f1942a[i11];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Index ");
        sb2.append(i11);
        sb2.append(" must be in 0..");
        sb2.append(this.f1943b - 1);
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    public final int b() {
        return this.f1943b;
    }

    public final int c(int i11) {
        int[] iArr = this.f1942a;
        int i12 = this.f1943b;
        for (int i13 = 0; i13 < i12; i13++) {
            if (i11 == iArr[i13]) {
                return i13;
            }
        }
        return -1;
    }

    @JvmOverloads
    public final String d(CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated) {
        Intrinsics.g(separator, "separator");
        Intrinsics.g(prefix, "prefix");
        Intrinsics.g(postfix, "postfix");
        Intrinsics.g(truncated, "truncated");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        int[] iArr = this.f1942a;
        int i12 = this.f1943b;
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = iArr[i13];
            if (i13 == i11) {
                sb2.append(truncated);
                String string = sb2.toString();
                Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i13 != 0) {
                sb2.append(separator);
            }
            sb2.append(i14);
        }
        sb2.append(postfix);
        String string2 = sb2.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            int i11 = lVar.f1943b;
            int i12 = this.f1943b;
            if (i11 == i12) {
                int[] iArr = this.f1942a;
                int[] iArr2 = lVar.f1942a;
                IntRange intRangeR = kotlin.ranges.a.r(0, i12);
                int iG = intRangeR.g();
                int i13 = intRangeR.i();
                if (iG > i13) {
                    return true;
                }
                while (iArr[iG] == iArr2[iG]) {
                    if (iG == i13) {
                        return true;
                    }
                    iG++;
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.f1942a;
        int i11 = this.f1943b;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += iArr[i13] * 31;
        }
        return i12;
    }

    public String toString() {
        return e(this, null, "[", "]", 0, null, 25, null);
    }
}
