package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
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
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f4530a = new float[64];

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArrayList b(g gVar, String str, ArrayList arrayList, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            arrayList = new ArrayList();
        }
        return gVar.a(str, arrayList);
    }

    public final ArrayList<e> a(String str, ArrayList<e> arrayList) {
        int i11;
        char cCharAt;
        int i12;
        int length = str.length();
        int i13 = 0;
        while (i13 < length && Intrinsics.i(str.charAt(i13), 32) <= 0) {
            i13++;
        }
        while (length > i13 && Intrinsics.i(str.charAt(length - 1), 32) <= 0) {
            length--;
        }
        int i14 = 0;
        while (i13 < length) {
            while (true) {
                i11 = i13 + 1;
                cCharAt = str.charAt(i13);
                int i15 = cCharAt | ' ';
                if ((i15 - 97) * (i15 - 122) <= 0 && i15 != 101) {
                    break;
                }
                if (i11 >= length) {
                    cCharAt = 0;
                    break;
                }
                i13 = i11;
            }
            if (cCharAt != 0) {
                if ((cCharAt | ' ') != 122) {
                    i14 = 0;
                    while (true) {
                        if (i11 >= length || Intrinsics.i(str.charAt(i11), 32) > 0) {
                            long jA = b.a(str, i11, length);
                            i12 = (int) (jA >>> 32);
                            float fIntBitsToFloat = Float.intBitsToFloat((int) (jA & 4294967295L));
                            if (!Float.isNaN(fIntBitsToFloat)) {
                                float[] fArr = this.f4530a;
                                int i16 = i14 + 1;
                                fArr[i14] = fIntBitsToFloat;
                                if (i16 >= fArr.length) {
                                    float[] fArr2 = new float[i16 * 2];
                                    this.f4530a = fArr2;
                                    ArraysKt___ArraysJvmKt.i(fArr, fArr2, 0, 0, fArr.length);
                                }
                                i14 = i16;
                            }
                            while (i12 < length && str.charAt(i12) == ',') {
                                i12++;
                            }
                            if (i12 >= length || Float.isNaN(fIntBitsToFloat)) {
                                break;
                            }
                            i11 = i12;
                        } else {
                            i11++;
                        }
                    }
                    i11 = i12;
                }
                f.a(cCharAt, arrayList, this.f4530a, i14);
            }
            i13 = i11;
        }
        return arrayList;
    }
}
