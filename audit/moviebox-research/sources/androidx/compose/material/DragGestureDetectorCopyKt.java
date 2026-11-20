package androidx.compose.material;

import androidx.compose.ui.input.pointer.k0;
import androidx.compose.ui.input.pointer.y;
import androidx.compose.ui.input.pointer.z;
import androidx.compose.ui.platform.r2;
import java.util.List;
import kotlin.Metadata;
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
public final class DragGestureDetectorCopyKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f3033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f3034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f3035c;

    static {
        float fH = q2.i.h((float) 0.125d);
        f3033a = fH;
        float fH2 = q2.i.h(18);
        f3034b = fH2;
        f3035c = fH / fH2;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:29:0x00dd A[LOOP:0: B:25:0x00c6->B:29:0x00dd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x00e5 A[EDGE_INSN: B:64:0x00e5->B:31:0x00e5 BREAK  A[LOOP:0: B:25:0x00c6->B:29:0x00dd], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x011c -> B:47:0x0128). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x015e -> B:54:0x0161). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0182 -> B:47:0x0128). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(androidx.compose.ui.input.pointer.e r19, long r20, int r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.z, ? super java.lang.Float, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.z> r24) {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DragGestureDetectorCopyKt.a(androidx.compose.ui.input.pointer.e, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final boolean b(androidx.compose.ui.input.pointer.q qVar, long j11) {
        z zVar;
        List<z> listC = qVar.c();
        int size = listC.size();
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                zVar = null;
                break;
            }
            zVar = listC.get(i11);
            if (y.d(zVar.f(), j11)) {
                break;
            }
            i11++;
        }
        z zVar2 = zVar;
        if (zVar2 != null && zVar2.i()) {
            z11 = true;
        }
        return true ^ z11;
    }

    public static final float c(r2 r2Var, int i11) {
        return k0.g(i11, k0.f4712a.b()) ? r2Var.f() * f3035c : r2Var.f();
    }
}
