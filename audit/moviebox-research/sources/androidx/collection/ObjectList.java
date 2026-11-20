package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public abstract class ObjectList<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public Object[] f1895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public int f1896b;

    public ObjectList(int i11) {
        this.f1895a = i11 == 0 ? p0.f1967a : new Object[i11];
    }

    public /* synthetic */ ObjectList(int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String d(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, Function1 function1, int i12, Object obj) {
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
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            function1 = null;
        }
        return objectList.c(charSequence, charSequence5, charSequence6, i13, charSequence7, function1);
    }

    public final boolean a(E e11) {
        return b(e11) >= 0;
    }

    public final int b(E e11) {
        int i11 = 0;
        if (e11 == null) {
            Object[] objArr = this.f1895a;
            int i12 = this.f1896b;
            while (i11 < i12) {
                if (objArr[i11] == null) {
                    return i11;
                }
                i11++;
            }
            return -1;
        }
        Object[] objArr2 = this.f1895a;
        int i13 = this.f1896b;
        while (i11 < i13) {
            if (e11.equals(objArr2[i11])) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    @JvmOverloads
    public final String c(CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated, Function1<? super E, ? extends CharSequence> function1) {
        Intrinsics.g(separator, "separator");
        Intrinsics.g(prefix, "prefix");
        Intrinsics.g(postfix, "postfix");
        Intrinsics.g(truncated, "truncated");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        Object[] objArr = this.f1895a;
        int i12 = this.f1896b;
        for (int i13 = 0; i13 < i12; i13++) {
            Object obj = objArr[i13];
            if (i13 == i11) {
                sb2.append(truncated);
                String string = sb2.toString();
                Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i13 != 0) {
                sb2.append(separator);
            }
            if (function1 == null) {
                sb2.append(obj);
            } else {
                sb2.append(function1.invoke(obj));
            }
        }
        sb2.append(postfix);
        String string2 = sb2.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectList) {
            ObjectList objectList = (ObjectList) obj;
            int i11 = objectList.f1896b;
            int i12 = this.f1896b;
            if (i11 == i12) {
                Object[] objArr = this.f1895a;
                Object[] objArr2 = objectList.f1895a;
                IntRange intRangeR = kotlin.ranges.a.r(0, i12);
                int iG = intRangeR.g();
                int i13 = intRangeR.i();
                if (iG > i13) {
                    return true;
                }
                while (Intrinsics.b(objArr[iG], objArr2[iG])) {
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
        Object[] objArr = this.f1895a;
        int i11 = this.f1896b;
        int iHashCode = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            Object obj = objArr[i12];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public String toString() {
        return d(this, null, "[", "]", 0, null, new Function1<E, CharSequence>(this) { // from class: androidx.collection.ObjectList.toString.1
            final /* synthetic */ ObjectList<E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(E e11) {
                return e11 == this.this$0 ? "(this)" : String.valueOf(e11);
            }
        }, 25, null);
    }
}
