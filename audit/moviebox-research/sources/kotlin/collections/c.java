package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
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
public class c extends b {
    @SinceKotlin
    @PublishedApi
    @JvmName
    public static <T> String c(T[] tArr) {
        if (tArr == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder((kotlin.ranges.a.g(tArr.length, 429496729) * 5) + 2);
        d(tArr, sb2, new ArrayList());
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void d(T[] tArr, StringBuilder sb2, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb2.append("[...]");
            return;
        }
        list.add(tArr);
        sb2.append('[');
        int length = tArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 != 0) {
                sb2.append(", ");
            }
            Object[] objArr = tArr[i11];
            if (objArr == 0) {
                sb2.append("null");
            } else if (objArr instanceof Object[]) {
                d(objArr, sb2, list);
            } else if (objArr instanceof byte[]) {
                String string = Arrays.toString((byte[]) objArr);
                Intrinsics.f(string, "toString(...)");
                sb2.append(string);
            } else if (objArr instanceof short[]) {
                String string2 = Arrays.toString((short[]) objArr);
                Intrinsics.f(string2, "toString(...)");
                sb2.append(string2);
            } else if (objArr instanceof int[]) {
                String string3 = Arrays.toString((int[]) objArr);
                Intrinsics.f(string3, "toString(...)");
                sb2.append(string3);
            } else if (objArr instanceof long[]) {
                String string4 = Arrays.toString((long[]) objArr);
                Intrinsics.f(string4, "toString(...)");
                sb2.append(string4);
            } else if (objArr instanceof float[]) {
                String string5 = Arrays.toString((float[]) objArr);
                Intrinsics.f(string5, "toString(...)");
                sb2.append(string5);
            } else if (objArr instanceof double[]) {
                String string6 = Arrays.toString((double[]) objArr);
                Intrinsics.f(string6, "toString(...)");
                sb2.append(string6);
            } else if (objArr instanceof char[]) {
                String string7 = Arrays.toString((char[]) objArr);
                Intrinsics.f(string7, "toString(...)");
                sb2.append(string7);
            } else if (objArr instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) objArr);
                Intrinsics.f(string8, "toString(...)");
                sb2.append(string8);
            } else if (objArr instanceof UByteArray) {
                sb2.append(w10.b.a(((UByteArray) objArr).y()));
            } else if (objArr instanceof UShortArray) {
                sb2.append(w10.b.c(((UShortArray) objArr).y()));
            } else if (objArr instanceof UIntArray) {
                sb2.append(w10.b.b(((UIntArray) objArr).y()));
            } else if (objArr instanceof ULongArray) {
                sb2.append(w10.b.d(((ULongArray) objArr).y()));
            } else {
                sb2.append(objArr.toString());
            }
        }
        sb2.append(']');
        list.remove(g.n(list));
    }
}
