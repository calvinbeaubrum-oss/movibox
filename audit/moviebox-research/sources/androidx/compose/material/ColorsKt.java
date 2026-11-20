package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.s1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.tools.zip.UnixStat;

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
public final class ColorsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1<b> f3025a = CompositionLocalKt.f(new Function0<b>() { // from class: androidx.compose.material.ColorsKt$LocalColors$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return ColorsKt.d((UnixStat.PERM_MASK & 1) != 0 ? y1.d(4284612846L) : 0L, (UnixStat.PERM_MASK & 2) != 0 ? y1.d(4281794739L) : 0L, (UnixStat.PERM_MASK & 4) != 0 ? y1.d(4278442694L) : 0L, (UnixStat.PERM_MASK & 8) != 0 ? y1.d(4278290310L) : 0L, (UnixStat.PERM_MASK & 16) != 0 ? w1.f4564b.f() : 0L, (UnixStat.PERM_MASK & 32) != 0 ? w1.f4564b.f() : 0L, (UnixStat.PERM_MASK & 64) != 0 ? y1.d(4289724448L) : 0L, (UnixStat.PERM_MASK & 128) != 0 ? w1.f4564b.f() : 0L, (UnixStat.PERM_MASK & 256) != 0 ? w1.f4564b.a() : 0L, (UnixStat.PERM_MASK & 512) != 0 ? w1.f4564b.a() : 0L, (UnixStat.PERM_MASK & 1024) != 0 ? w1.f4564b.a() : 0L, (UnixStat.PERM_MASK & 2048) != 0 ? w1.f4564b.f() : 0L);
        }
    });

    public static final long a(b bVar, long j11) {
        if (!w1.m(j11, bVar.h()) && !w1.m(j11, bVar.i())) {
            if (!w1.m(j11, bVar.j()) && !w1.m(j11, bVar.k())) {
                if (w1.m(j11, bVar.a())) {
                    return bVar.c();
                }
                if (w1.m(j11, bVar.l())) {
                    return bVar.g();
                }
                return w1.m(j11, bVar.b()) ? bVar.d() : w1.f4564b.e();
            }
            return bVar.f();
        }
        return bVar.e();
    }

    public static final long b(long j11, androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(441849991, i11, -1, "androidx.compose.material.contentColorFor (Colors.kt:296)");
        }
        iVar.R(-702395103);
        long jA = a(e.f3086a.a(iVar, 6), j11);
        if (jA == 16) {
            jA = ((w1) iVar.l(ContentColorKt.a())).u();
        }
        iVar.L();
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return jA;
    }

    public static final s1<b> c() {
        return f3025a;
    }

    public static final b d(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23) {
        return new b(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, true, null);
    }
}
