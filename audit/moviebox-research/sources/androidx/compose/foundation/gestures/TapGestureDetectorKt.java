package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.h0;
import androidx.compose.ui.input.pointer.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;

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
public final class TapGestureDetectorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function3<i, y1.g, Continuation<? super Unit>, Object> f2348a = new TapGestureDetectorKt$NoPressGesture$1(null);

    /* JADX WARN: Code duplicated, block: B:17:0x0050 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x005f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0067  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0073 A[LOOP:0: B:19:0x005d->B:26:0x0073, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:18:0x0051). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:20:0x005f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object d(androidx.compose.ui.input.pointer.e r9, boolean r10, androidx.compose.ui.input.pointer.PointerEventPass r11, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.z> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            if (r0 == 0) goto L13
            r0 = r12
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            boolean r9 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r10 = (androidx.compose.ui.input.pointer.PointerEventPass) r10
            java.lang.Object r11 = r0.L$0
            androidx.compose.ui.input.pointer.e r11 = (androidx.compose.ui.input.pointer.e) r11
            kotlin.ResultKt.b(r12)
            r8 = r10
            r10 = r9
            r9 = r11
            r11 = r8
            goto L51
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3f:
            kotlin.ResultKt.b(r12)
        L42:
            r0.L$0 = r9
            r0.L$1 = r11
            r0.Z$0 = r10
            r0.label = r3
            java.lang.Object r12 = r9.v0(r11, r0)
            if (r12 != r1) goto L51
            return r1
        L51:
            androidx.compose.ui.input.pointer.q r12 = (androidx.compose.ui.input.pointer.q) r12
            java.util.List r2 = r12.c()
            int r4 = r2.size()
            r5 = 0
            r6 = 0
        L5d:
            if (r6 >= r4) goto L76
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.z r7 = (androidx.compose.ui.input.pointer.z) r7
            if (r10 == 0) goto L6c
            boolean r7 = androidx.compose.ui.input.pointer.r.a(r7)
            goto L70
        L6c:
            boolean r7 = androidx.compose.ui.input.pointer.r.b(r7)
        L70:
            if (r7 != 0) goto L73
            goto L42
        L73:
            int r6 = r6 + 1
            goto L5d
        L76:
            java.util.List r9 = r12.c()
            java.lang.Object r9 = r9.get(r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.d(androidx.compose.ui.input.pointer.e, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object e(androidx.compose.ui.input.pointer.e eVar, boolean z11, PointerEventPass pointerEventPass, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        if ((i11 & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return d(eVar, z11, pointerEventPass, continuation);
    }

    public static final Object f(androidx.compose.ui.input.pointer.e eVar, z zVar, Continuation<? super z> continuation) {
        return eVar.U(eVar.getViewConfiguration().a(), new TapGestureDetectorKt$awaitSecondDown$2(zVar, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0052 A[LOOP:0: B:19:0x0050->B:20:0x0052, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    /* JADX WARN: Code duplicated, block: B:26:0x0075 A[LOOP:1: B:22:0x0066->B:26:0x0075, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:23:0x0068
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object g(androidx.compose.ui.input.pointer.e r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.e r8 = (androidx.compose.ui.input.pointer.e) r8
            kotlin.ResultKt.b(r9)
            goto L44
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            kotlin.ResultKt.b(r9)
        L38:
            r0.L$0 = r8
            r0.label = r3
            r9 = 0
            java.lang.Object r9 = androidx.compose.ui.input.pointer.d.a(r8, r9, r0, r3, r9)
            if (r9 != r1) goto L44
            return r1
        L44:
            androidx.compose.ui.input.pointer.q r9 = (androidx.compose.ui.input.pointer.q) r9
            java.util.List r2 = r9.c()
            int r4 = r2.size()
            r5 = 0
            r6 = 0
        L50:
            if (r6 >= r4) goto L5e
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.z r7 = (androidx.compose.ui.input.pointer.z) r7
            r7.a()
            int r6 = r6 + 1
            goto L50
        L5e:
            java.util.List r9 = r9.c()
            int r2 = r9.size()
        L66:
            if (r5 >= r2) goto L78
            java.lang.Object r4 = r9.get(r5)
            androidx.compose.ui.input.pointer.z r4 = (androidx.compose.ui.input.pointer.z) r4
            boolean r4 = r4.i()
            if (r4 == 0) goto L75
            goto L38
        L75:
            int r5 = r5 + 1
            goto L66
        L78:
            kotlin.Unit r8 = kotlin.Unit.f68710a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.g(androidx.compose.ui.input.pointer.e, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object h(h0 h0Var, Function3<? super i, ? super y1.g, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super y1.g, Unit> function1, Continuation<? super Unit> continuation) {
        Object objE = l0.e(new TapGestureDetectorKt$detectTapAndPress$2(h0Var, function3, function1, new PressGestureScopeImpl(h0Var), null), continuation);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }

    public static final Object i(h0 h0Var, Function1<? super y1.g, Unit> function1, Function1<? super y1.g, Unit> function2, Function3<? super i, ? super y1.g, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super y1.g, Unit> function4, Continuation<? super Unit> continuation) {
        Object objE = l0.e(new TapGestureDetectorKt$detectTapGestures$2(h0Var, function3, function2, function1, function4, null), continuation);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0081  */
    /* JADX WARN: Code duplicated, block: B:28:0x0098  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x00e6 A[LOOP:1: B:23:0x007f->B:45:0x00e6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:51:0x008d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00b6 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c3 -> B:13:0x0037). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object j(androidx.compose.ui.input.pointer.e r18, androidx.compose.ui.input.pointer.PointerEventPass r19, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.z> r20) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.j(androidx.compose.ui.input.pointer.e, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object k(androidx.compose.ui.input.pointer.e eVar, PointerEventPass pointerEventPass, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return j(eVar, pointerEventPass, continuation);
    }
}
