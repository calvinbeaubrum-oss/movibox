package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.input.pointer.k0;
import androidx.compose.ui.input.pointer.o0;
import androidx.compose.ui.input.pointer.q;
import androidx.compose.ui.input.pointer.r;
import androidx.compose.ui.input.pointer.z;
import androidx.compose.ui.platform.r2;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
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
public final class SelectionGesturesKt {
    /* JADX WARN: Code duplicated, block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0052  */
    /* JADX WARN: Code duplicated, block: B:23:0x005f A[LOOP:0: B:19:0x0050->B:23:0x005f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object e(androidx.compose.ui.input.pointer.e r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.q> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.e r7 = (androidx.compose.ui.input.pointer.e) r7
            kotlin.ResultKt.b(r8)
            goto L45
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.b(r8)
        L38:
            androidx.compose.ui.input.pointer.PointerEventPass r8 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r7.v0(r8, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            androidx.compose.ui.input.pointer.q r8 = (androidx.compose.ui.input.pointer.q) r8
            java.util.List r2 = r8.c()
            int r4 = r2.size()
            r5 = 0
        L50:
            if (r5 >= r4) goto L62
            java.lang.Object r6 = r2.get(r5)
            androidx.compose.ui.input.pointer.z r6 = (androidx.compose.ui.input.pointer.z) r6
            boolean r6 = androidx.compose.ui.input.pointer.r.b(r6)
            if (r6 != 0) goto L5f
            goto L38
        L5f:
            int r5 = r5 + 1
            goto L50
        L62:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.e(androidx.compose.ui.input.pointer.e, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final boolean f(r2 r2Var, z zVar, z zVar2) {
        return y1.g.k(y1.g.q(zVar.h(), zVar2.h())) < DragGestureDetectorKt.h(r2Var, zVar.n());
    }

    public static final boolean g(q qVar) {
        List<z> listC = qVar.c();
        int size = listC.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (!k0.g(listC.get(i11).n(), k0.f4712a.b())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0098  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:47:0x0100  */
    /* JADX WARN: Code duplicated, block: B:49:0x010c  */
    /* JADX WARN: Code duplicated, block: B:56:0x010f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object h(androidx.compose.ui.input.pointer.e eVar, final b bVar, a aVar, q qVar, Continuation<? super Unit> continuation) throws Throwable {
        SelectionGesturesKt$mouseSelection$1 selectionGesturesKt$mouseSelection$1;
        final g gVarA;
        List<z> listC;
        int size;
        z zVar;
        List<z> listC2;
        int size2;
        z zVar2;
        if (continuation instanceof SelectionGesturesKt$mouseSelection$1) {
            selectionGesturesKt$mouseSelection$1 = (SelectionGesturesKt$mouseSelection$1) continuation;
            int i11 = selectionGesturesKt$mouseSelection$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$mouseSelection$1.label = i11 - Integer.MIN_VALUE;
            } else {
                selectionGesturesKt$mouseSelection$1 = new SelectionGesturesKt$mouseSelection$1(continuation);
            }
        } else {
            selectionGesturesKt$mouseSelection$1 = new SelectionGesturesKt$mouseSelection$1(continuation);
        }
        Object objE = selectionGesturesKt$mouseSelection$1.result;
        Object objE2 = kotlin.coroutines.intrinsics.a.e();
        int i12 = selectionGesturesKt$mouseSelection$1.label;
        int i13 = 0;
        if (i12 == 0) {
            ResultKt.b(objE);
            aVar.d(qVar);
            z zVar3 = qVar.c().get(0);
            if (!l.a(qVar)) {
                int iA = aVar.a();
                if (iA != 1) {
                    gVarA = iA != 2 ? g.f3012a.b() : g.f3012a.c();
                } else {
                    gVarA = g.f3012a.a();
                }
                if (bVar.c(zVar3.h(), gVarA)) {
                    long jF = zVar3.f();
                    Function1<z, Unit> function1 = new Function1<z, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(z zVar4) {
                            invoke2(zVar4);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(z zVar4) {
                            if (bVar.d(zVar4.h(), gVarA)) {
                                zVar4.a();
                            }
                        }
                    };
                    selectionGesturesKt$mouseSelection$1.L$0 = eVar;
                    selectionGesturesKt$mouseSelection$1.L$1 = bVar;
                    selectionGesturesKt$mouseSelection$1.label = 2;
                    objE = DragGestureDetectorKt.e(eVar, jF, function1, selectionGesturesKt$mouseSelection$1);
                    if (objE == objE2) {
                        return objE2;
                    }
                    if (((Boolean) objE).booleanValue()) {
                        listC2 = eVar.w0().c();
                        size2 = listC2.size();
                        while (i13 < size2) {
                            zVar2 = listC2.get(i13);
                            if (r.c(zVar2)) {
                                zVar2.a();
                            }
                            i13++;
                        }
                    }
                    bVar.a();
                }
            } else if (bVar.e(zVar3.h())) {
                long jF2 = zVar3.f();
                Function1<z, Unit> function2 = new Function1<z, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(z zVar4) {
                        invoke2(zVar4);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(z zVar4) {
                        if (bVar.b(zVar4.h())) {
                            zVar4.a();
                        }
                    }
                };
                selectionGesturesKt$mouseSelection$1.L$0 = eVar;
                selectionGesturesKt$mouseSelection$1.L$1 = bVar;
                selectionGesturesKt$mouseSelection$1.label = 1;
                objE = DragGestureDetectorKt.e(eVar, jF2, function2, selectionGesturesKt$mouseSelection$1);
                if (objE == objE2) {
                    return objE2;
                }
                if (((Boolean) objE).booleanValue()) {
                    listC = eVar.w0().c();
                    size = listC.size();
                    while (i13 < size) {
                        zVar = listC.get(i13);
                        if (r.c(zVar)) {
                            zVar.a();
                        }
                        i13++;
                    }
                }
                bVar.a();
            }
        } else if (i12 == 1) {
            bVar = (b) selectionGesturesKt$mouseSelection$1.L$1;
            eVar = (androidx.compose.ui.input.pointer.e) selectionGesturesKt$mouseSelection$1.L$0;
            ResultKt.b(objE);
            if (((Boolean) objE).booleanValue()) {
                listC = eVar.w0().c();
                size = listC.size();
                while (i13 < size) {
                    zVar = listC.get(i13);
                    if (r.c(zVar)) {
                        zVar.a();
                    }
                    i13++;
                }
            }
            bVar.a();
        } else {
            if (i12 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bVar = (b) selectionGesturesKt$mouseSelection$1.L$1;
            eVar = (androidx.compose.ui.input.pointer.e) selectionGesturesKt$mouseSelection$1.L$0;
            ResultKt.b(objE);
            if (((Boolean) objE).booleanValue()) {
                listC2 = eVar.w0().c();
                size2 = listC2.size();
                while (i13 < size2) {
                    zVar2 = listC2.get(i13);
                    if (r.c(zVar2)) {
                        zVar2.a();
                    }
                    i13++;
                }
            }
            bVar.a();
        }
        return Unit.f68710a;
    }

    public static final androidx.compose.ui.f i(androidx.compose.ui.f fVar, b bVar, androidx.compose.foundation.text.c cVar) {
        return o0.c(fVar, bVar, cVar, new SelectionGesturesKt$selectionGestureInput$1(bVar, cVar, null));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a9 A[Catch: CancellationException -> 0x0035, TryCatch #0 {CancellationException -> 0x0035, blocks: (B:13:0x0031, B:33:0x00a1, B:35:0x00a9, B:37:0x00b8, B:39:0x00c4, B:40:0x00c7, B:41:0x00ca, B:42:0x00ce, B:20:0x004c, B:26:0x0073, B:28:0x0077, B:30:0x0081, B:23:0x0056), top: B:47:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b8 A[Catch: CancellationException -> 0x0035, TryCatch #0 {CancellationException -> 0x0035, blocks: (B:13:0x0031, B:33:0x00a1, B:35:0x00a9, B:37:0x00b8, B:39:0x00c4, B:40:0x00c7, B:41:0x00ca, B:42:0x00ce, B:20:0x004c, B:26:0x0073, B:28:0x0077, B:30:0x0081, B:23:0x0056), top: B:47:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00c4 A[Catch: CancellationException -> 0x0035, TryCatch #0 {CancellationException -> 0x0035, blocks: (B:13:0x0031, B:33:0x00a1, B:35:0x00a9, B:37:0x00b8, B:39:0x00c4, B:40:0x00c7, B:41:0x00ca, B:42:0x00ce, B:20:0x004c, B:26:0x0073, B:28:0x0077, B:30:0x0081, B:23:0x0056), top: B:47:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ce A[Catch: CancellationException -> 0x0035, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0035, blocks: (B:13:0x0031, B:33:0x00a1, B:35:0x00a9, B:37:0x00b8, B:39:0x00c4, B:40:0x00c7, B:41:0x00ca, B:42:0x00ce, B:20:0x004c, B:26:0x0073, B:28:0x0077, B:30:0x0081, B:23:0x0056), top: B:47:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object j(androidx.compose.ui.input.pointer.e eVar, final androidx.compose.foundation.text.c cVar, q qVar, Continuation<? super Unit> continuation) throws Throwable {
        SelectionGesturesKt$touchSelection$1 selectionGesturesKt$touchSelection$1;
        z zVar;
        List<z> listC;
        int size;
        int i11;
        z zVar2;
        if (continuation instanceof SelectionGesturesKt$touchSelection$1) {
            selectionGesturesKt$touchSelection$1 = (SelectionGesturesKt$touchSelection$1) continuation;
            int i12 = selectionGesturesKt$touchSelection$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$touchSelection$1.label = i12 - Integer.MIN_VALUE;
            } else {
                selectionGesturesKt$touchSelection$1 = new SelectionGesturesKt$touchSelection$1(continuation);
            }
        } else {
            selectionGesturesKt$touchSelection$1 = new SelectionGesturesKt$touchSelection$1(continuation);
        }
        Object objC = selectionGesturesKt$touchSelection$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = selectionGesturesKt$touchSelection$1.label;
        try {
            if (i13 != 0) {
                if (i13 == 1) {
                    z zVar3 = (z) selectionGesturesKt$touchSelection$1.L$2;
                    cVar = (androidx.compose.foundation.text.c) selectionGesturesKt$touchSelection$1.L$1;
                    androidx.compose.ui.input.pointer.e eVar2 = (androidx.compose.ui.input.pointer.e) selectionGesturesKt$touchSelection$1.L$0;
                    ResultKt.b(objC);
                    zVar = zVar3;
                    eVar = eVar2;
                } else {
                    if (i13 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cVar = (androidx.compose.foundation.text.c) selectionGesturesKt$touchSelection$1.L$1;
                    eVar = (androidx.compose.ui.input.pointer.e) selectionGesturesKt$touchSelection$1.L$0;
                    ResultKt.b(objC);
                }
                if (((Boolean) objC).booleanValue()) {
                    listC = eVar.w0().c();
                    size = listC.size();
                    for (i11 = 0; i11 < size; i11++) {
                        zVar2 = listC.get(i11);
                        if (r.c(zVar2)) {
                            zVar2.a();
                        }
                    }
                    cVar.onStop();
                } else {
                    cVar.onCancel();
                }
                return Unit.f68710a;
            }
            ResultKt.b(objC);
            zVar = (z) CollectionsKt___CollectionsKt.e0(qVar.c());
            long jF = zVar.f();
            selectionGesturesKt$touchSelection$1.L$0 = eVar;
            selectionGesturesKt$touchSelection$1.L$1 = cVar;
            selectionGesturesKt$touchSelection$1.L$2 = zVar;
            selectionGesturesKt$touchSelection$1.label = 1;
            objC = DragGestureDetectorKt.c(eVar, jF, selectionGesturesKt$touchSelection$1);
            if (objC == objE) {
                return objE;
            }
            z zVar4 = (z) objC;
            if (zVar4 != null && f(eVar.getViewConfiguration(), zVar, zVar4)) {
                cVar.a(zVar4.h());
                long jF2 = zVar4.f();
                Function1<z, Unit> function1 = new Function1<z, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(z zVar5) {
                        invoke2(zVar5);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(z zVar5) {
                        cVar.b(r.g(zVar5));
                        zVar5.a();
                    }
                };
                selectionGesturesKt$touchSelection$1.L$0 = eVar;
                selectionGesturesKt$touchSelection$1.L$1 = cVar;
                selectionGesturesKt$touchSelection$1.L$2 = null;
                selectionGesturesKt$touchSelection$1.label = 2;
                objC = DragGestureDetectorKt.e(eVar, jF2, function1, selectionGesturesKt$touchSelection$1);
                if (objC == objE) {
                    return objE;
                }
                if (((Boolean) objC).booleanValue()) {
                    listC = eVar.w0().c();
                    size = listC.size();
                    while (i11 < size) {
                        zVar2 = listC.get(i11);
                        if (r.c(zVar2)) {
                            zVar2.a();
                        }
                    }
                    cVar.onStop();
                } else {
                    cVar.onCancel();
                }
            }
            return Unit.f68710a;
        } catch (CancellationException e11) {
            cVar.onCancel();
            throw e11;
        }
    }
}
