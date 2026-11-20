package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class i0 {
    public static final void a(long j11, Function1<? super MotionEvent, Unit> function1) {
        MotionEvent motionEventObtain = MotionEvent.obtain(j11, j11, 3, 0.0f, 0.0f, 0);
        motionEventObtain.setSource(0);
        function1.invoke(motionEventObtain);
        motionEventObtain.recycle();
    }

    public static final void b(q qVar, long j11, Function1<? super MotionEvent, Unit> function1) {
        d(qVar, j11, function1, true);
    }

    public static final void c(q qVar, long j11, Function1<? super MotionEvent, Unit> function1) {
        d(qVar, j11, function1, false);
    }

    public static final void d(q qVar, long j11, Function1<? super MotionEvent, Unit> function1, boolean z11) {
        MotionEvent motionEventE = qVar.e();
        if (motionEventE == null) {
            throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.".toString());
        }
        int action = motionEventE.getAction();
        if (z11) {
            motionEventE.setAction(3);
        }
        motionEventE.offsetLocation(-y1.g.m(j11), -y1.g.n(j11));
        function1.invoke(motionEventE);
        motionEventE.offsetLocation(y1.g.m(j11), y1.g.n(j11));
        motionEventE.setAction(action);
    }
}
