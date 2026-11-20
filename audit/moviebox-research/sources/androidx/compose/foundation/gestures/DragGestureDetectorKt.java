package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.h0;
import androidx.compose.ui.input.pointer.k0;
import androidx.compose.ui.input.pointer.y;
import androidx.compose.ui.input.pointer.z;
import androidx.compose.ui.platform.r2;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
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
public final class DragGestureDetectorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f2302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f2303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f2304c;

    static {
        float fH = q2.i.h((float) 0.125d);
        f2302a = fH;
        float fH2 = q2.i.h(18);
        f2303b = fH2;
        f2304c = fH / fH2;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007a  */
    /* JADX WARN: Code duplicated, block: B:27:0x008e A[LOOP:0: B:23:0x0078->B:27:0x008e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x0092 A[EDGE_INSN: B:54:0x0092->B:29:0x0092 BREAK  A[LOOP:0: B:23:0x0078->B:27:0x008e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object b(androidx.compose.ui.input.pointer.e r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.z> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.b(androidx.compose.ui.input.pointer.e, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, androidx.compose.ui.input.pointer.z, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    public static final Object c(androidx.compose.ui.input.pointer.e eVar, long j11, Continuation<? super z> continuation) throws Throwable {
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 dragGestureDetectorKt$awaitLongPressOrCancellation$1;
        z zVar;
        Ref.ObjectRef objectRef;
        ?? r11;
        if (continuation instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1) {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = (DragGestureDetectorKt$awaitLongPressOrCancellation$1) continuation;
            int i11 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = i11 - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(continuation);
            }
        } else {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(continuation);
        }
        Object obj = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            if (g(eVar.w0(), j11)) {
                return null;
            }
            List<z> listC = eVar.w0().c();
            int size = listC.size();
            int i13 = 0;
            while (true) {
                if (i13 >= size) {
                    zVar = null;
                    break;
                }
                zVar = listC.get(i13);
                if (y.d(zVar.f(), j11)) {
                    break;
                }
                i13++;
            }
            z zVar2 = zVar;
            if (zVar2 == 0) {
                return null;
            }
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = zVar2;
            long jC = eVar.getViewConfiguration().c();
            try {
                DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(objectRef3, objectRef2, null);
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0 = zVar2;
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1 = objectRef2;
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = 1;
                if (eVar.m0(jC, dragGestureDetectorKt$awaitLongPressOrCancellation$2, dragGestureDetectorKt$awaitLongPressOrCancellation$1) == objE) {
                    return objE;
                }
                return null;
            } catch (PointerEventTimeoutCancellationException unused) {
                objectRef = objectRef2;
                r11 = zVar2;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1;
            z zVar3 = (z) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0;
            try {
                ResultKt.b(obj);
                return null;
            } catch (PointerEventTimeoutCancellationException unused2) {
                r11 = zVar3;
            }
        }
        z zVar4 = (z) objectRef.element;
        return zVar4 == null ? r11 : zVar4;
    }

    public static final Object d(h0 h0Var, Function3<? super z, ? super z, ? super y1.g, Unit> function3, Function1<? super z, Unit> function1, Function0<Unit> function0, Function0<Boolean> function2, Orientation orientation, Function2<? super z, ? super y1.g, Unit> function4, Continuation<? super Unit> continuation) {
        Object objC = ForEachGestureKt.c(h0Var, new DragGestureDetectorKt$detectDragGestures$9(function2, new Ref.LongRef(), orientation, function3, function4, function0, function1, null), continuation);
        return objC == kotlin.coroutines.intrinsics.a.e() ? objC : Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0055  */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0060  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0048 -> B:18:0x004b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object e(androidx.compose.ui.input.pointer.e r4, long r5, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.z, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.e r5 = (androidx.compose.ui.input.pointer.e) r5
            kotlin.ResultKt.b(r8)
            r7 = r4
            r4 = r5
            goto L4b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.ResultKt.b(r8)
        L3e:
            r0.L$0 = r4
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = b(r4, r5, r0)
            if (r8 != r1) goto L4b
            return r1
        L4b:
            androidx.compose.ui.input.pointer.z r8 = (androidx.compose.ui.input.pointer.z) r8
            if (r8 != 0) goto L55
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r4
        L55:
            boolean r5 = androidx.compose.ui.input.pointer.r.d(r8)
            if (r5 == 0) goto L60
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r4
        L60:
            r7.invoke(r8)
            long r5 = r8.f()
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.e(androidx.compose.ui.input.pointer.e, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0098  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ae A[LOOP:0: B:24:0x0096->B:28:0x00ae, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x00b8 A[EDGE_INSN: B:75:0x00b8->B:30:0x00b8 BREAK  A[LOOP:0: B:24:0x0096->B:28:0x00ae], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0085 -> B:23:0x008b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object f(androidx.compose.ui.input.pointer.e r17, long r18, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.z, kotlin.Unit> r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.f(androidx.compose.ui.input.pointer.e, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final boolean g(androidx.compose.ui.input.pointer.q qVar, long j11) {
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

    public static final float h(r2 r2Var, int i11) {
        return k0.g(i11, k0.f4712a.b()) ? r2Var.f() * f2304c : r2Var.f();
    }
}
