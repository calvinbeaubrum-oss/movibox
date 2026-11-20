package m2;

import kotlin.Metadata;

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
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s1 f70597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f70598b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f70599c;

    public e0(s1 s1Var) {
        this.f70597a = s1Var;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    public final float a(int i11, boolean z11, boolean z12, boolean z13) {
        boolean z14;
        int i12 = 1;
        if (z11) {
            int iA = g0.a(this.f70597a.h(), i11, z11);
            int iU = this.f70597a.u(iA);
            int iO = this.f70597a.o(iA);
            if (i11 == iU || i11 == iO) {
                z14 = true;
            } else {
                z14 = false;
            }
        } else {
            z14 = false;
        }
        int i13 = i11 * 4;
        if (!z13) {
            i12 = z14 ? 2 : 3;
        } else if (z14) {
            i12 = 0;
        }
        int i14 = i13 + i12;
        if (this.f70598b == i14) {
            return this.f70599c;
        }
        float fY = z13 ? this.f70597a.y(i11, z11) : this.f70597a.A(i11, z11);
        if (z12) {
            this.f70598b = i14;
            this.f70599c = fY;
        }
        return fY;
    }

    public final float b(int i11) {
        return a(i11, false, false, true);
    }

    public final float c(int i11) {
        return a(i11, true, true, true);
    }

    public final float d(int i11) {
        return a(i11, false, false, false);
    }

    public final float e(int i11) {
        return a(i11, true, true, false);
    }
}
