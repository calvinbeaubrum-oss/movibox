package androidx.compose.foundation;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.g4;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.z0;
import kotlin.Metadata;
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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g4 f2259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o1 f2260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z1.a f2261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f2262d;

    public c() {
        this(null, null, null, null, 15, null);
    }

    public c(g4 g4Var, o1 o1Var, z1.a aVar, Path path) {
        this.f2259a = g4Var;
        this.f2260b = o1Var;
        this.f2261c = aVar;
        this.f2262d = path;
    }

    public /* synthetic */ c(g4 g4Var, o1 o1Var, z1.a aVar, Path path, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : g4Var, (i11 & 2) != 0 ? null : o1Var, (i11 & 4) != 0 ? null : aVar, (i11 & 8) != 0 ? null : path);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.b(this.f2259a, cVar.f2259a) && Intrinsics.b(this.f2260b, cVar.f2260b) && Intrinsics.b(this.f2261c, cVar.f2261c) && Intrinsics.b(this.f2262d, cVar.f2262d);
    }

    public final Path g() {
        Path path = this.f2262d;
        if (path != null) {
            return path;
        }
        Path pathA = z0.a();
        this.f2262d = pathA;
        return pathA;
    }

    public int hashCode() {
        g4 g4Var = this.f2259a;
        int iHashCode = (g4Var == null ? 0 : g4Var.hashCode()) * 31;
        o1 o1Var = this.f2260b;
        int iHashCode2 = (iHashCode + (o1Var == null ? 0 : o1Var.hashCode())) * 31;
        z1.a aVar = this.f2261c;
        int iHashCode3 = (iHashCode2 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        Path path = this.f2262d;
        return iHashCode3 + (path != null ? path.hashCode() : 0);
    }

    public String toString() {
        return "BorderCache(imageBitmap=" + this.f2259a + ", canvas=" + this.f2260b + ", canvasDrawScope=" + this.f2261c + ", borderPath=" + this.f2262d + ')';
    }
}
