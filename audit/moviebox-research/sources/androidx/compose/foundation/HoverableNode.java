package androidx.compose.foundation;

import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.node.d1;
import androidx.compose.ui.node.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

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
public final class HoverableNode extends androidx.compose.ui.f.c implements e1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public o1.i f2246o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public o1.d f2247p;

    public HoverableNode(o1.i iVar) {
        this.f2246o = iVar;
    }

    @Override // androidx.compose.ui.node.e1
    public void D0() {
        L1();
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void J0() {
        d1.b(this);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object J1(Continuation<? super Unit> continuation) throws Throwable {
        HoverableNode$emitEnter$1 hoverableNode$emitEnter$1;
        HoverableNode hoverableNode;
        o1.d dVar;
        if (continuation instanceof HoverableNode$emitEnter$1) {
            hoverableNode$emitEnter$1 = (HoverableNode$emitEnter$1) continuation;
            int i11 = hoverableNode$emitEnter$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                hoverableNode$emitEnter$1.label = i11 - Integer.MIN_VALUE;
            } else {
                hoverableNode$emitEnter$1 = new HoverableNode$emitEnter$1(this, continuation);
            }
        } else {
            hoverableNode$emitEnter$1 = new HoverableNode$emitEnter$1(this, continuation);
        }
        Object obj = hoverableNode$emitEnter$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = hoverableNode$emitEnter$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            if (this.f2247p == null) {
                o1.d dVar2 = new o1.d();
                o1.i iVar = this.f2246o;
                hoverableNode$emitEnter$1.L$0 = this;
                hoverableNode$emitEnter$1.L$1 = dVar2;
                hoverableNode$emitEnter$1.label = 1;
                if (iVar.b(dVar2, hoverableNode$emitEnter$1) == objE) {
                    return objE;
                }
                hoverableNode = this;
                dVar = dVar2;
            }
            return Unit.f68710a;
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        dVar = (o1.d) hoverableNode$emitEnter$1.L$1;
        hoverableNode = (HoverableNode) hoverableNode$emitEnter$1.L$0;
        ResultKt.b(obj);
        hoverableNode.f2247p = dVar;
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object K1(Continuation<? super Unit> continuation) throws Throwable {
        HoverableNode$emitExit$1 hoverableNode$emitExit$1;
        HoverableNode hoverableNode;
        if (continuation instanceof HoverableNode$emitExit$1) {
            hoverableNode$emitExit$1 = (HoverableNode$emitExit$1) continuation;
            int i11 = hoverableNode$emitExit$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                hoverableNode$emitExit$1.label = i11 - Integer.MIN_VALUE;
            } else {
                hoverableNode$emitExit$1 = new HoverableNode$emitExit$1(this, continuation);
            }
        } else {
            hoverableNode$emitExit$1 = new HoverableNode$emitExit$1(this, continuation);
        }
        Object obj = hoverableNode$emitExit$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = hoverableNode$emitExit$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            o1.d dVar = this.f2247p;
            if (dVar != null) {
                o1.e eVar = new o1.e(dVar);
                o1.i iVar = this.f2246o;
                hoverableNode$emitExit$1.L$0 = this;
                hoverableNode$emitExit$1.label = 1;
                if (iVar.b(eVar, hoverableNode$emitExit$1) == objE) {
                    return objE;
                }
                hoverableNode = this;
            }
            return Unit.f68710a;
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        hoverableNode = (HoverableNode) hoverableNode$emitExit$1.L$0;
        ResultKt.b(obj);
        hoverableNode.f2247p = null;
        return Unit.f68710a;
    }

    public final void L1() {
        o1.d dVar = this.f2247p;
        if (dVar != null) {
            this.f2246o.a(new o1.e(dVar));
            this.f2247p = null;
        }
    }

    public final void M1(o1.i iVar) {
        if (Intrinsics.b(this.f2246o, iVar)) {
            return;
        }
        L1();
        this.f2246o = iVar;
    }

    @Override // androidx.compose.ui.node.e1
    public void T(androidx.compose.ui.input.pointer.q qVar, PointerEventPass pointerEventPass, long j11) {
        if (pointerEventPass == PointerEventPass.Main) {
            int iF = qVar.f();
            androidx.compose.ui.input.pointer.s.a aVar = androidx.compose.ui.input.pointer.s.f4737a;
            if (androidx.compose.ui.input.pointer.s.i(iF, aVar.a())) {
                kotlinx.coroutines.j.d(h1(), null, null, new HoverableNode$onPointerEvent$1(this, null), 3, null);
            } else if (androidx.compose.ui.input.pointer.s.i(iF, aVar.b())) {
                kotlinx.coroutines.j.d(h1(), null, null, new HoverableNode$onPointerEvent$2(this, null), 3, null);
            }
        }
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean U0() {
        return d1.d(this);
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void X0() {
        d1.c(this);
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean Y() {
        return d1.a(this);
    }

    @Override // androidx.compose.ui.f.c
    public void s1() {
        L1();
    }
}
