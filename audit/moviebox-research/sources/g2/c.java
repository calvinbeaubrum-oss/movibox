package g2;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import l.p;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f65384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f65385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f65386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f65387d;

    public c(float f11, float f12, long j11, int i11) {
        this.f65384a = f11;
        this.f65385b = f12;
        this.f65386c = j11;
        this.f65387d = i11;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.f65384a == this.f65384a && cVar.f65385b == this.f65385b && cVar.f65386c == this.f65386c && cVar.f65387d == this.f65387d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f65384a) * 31) + Float.floatToIntBits(this.f65385b)) * 31) + p.a(this.f65386c)) * 31) + this.f65387d;
    }

    public String toString() {
        return "RotaryScrollEvent(verticalScrollPixels=" + this.f65384a + ",horizontalScrollPixels=" + this.f65385b + ",uptimeMillis=" + this.f65386c + ",deviceId=" + this.f65387d + ')';
    }
}
