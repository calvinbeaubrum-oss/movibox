package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.o0;
import androidx.compose.ui.input.pointer.q0;
import androidx.compose.ui.input.pointer.z;
import androidx.compose.ui.node.d1;
import androidx.compose.ui.node.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public abstract class DragGestureNode extends androidx.compose.ui.node.i implements e1, androidx.compose.ui.node.d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Orientation f2305q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function1<? super z, Boolean> f2306r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2307s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public o1.i f2308t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function1<z, Boolean> f2309u = new Function1<z, Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$_canDrag$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(z zVar) {
            return this.this$0.X1().invoke(zVar);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public kotlinx.coroutines.channels.a<e> f2310v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public o1.a.b f2311w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2312x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public q0 f2313y;

    public DragGestureNode(Function1<? super z, Boolean> function1, boolean z11, o1.i iVar, Orientation orientation) {
        this.f2305q = orientation;
        this.f2306r = function1;
        this.f2307s = z11;
        this.f2308t = iVar;
    }

    @Override // androidx.compose.ui.node.e1
    public void D0() {
        q0 q0Var = this.f2313y;
        if (q0Var != null) {
            q0Var.D0();
        }
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void J0() {
        d1.b(this);
    }

    @Override // androidx.compose.ui.node.e1
    public void T(androidx.compose.ui.input.pointer.q qVar, PointerEventPass pointerEventPass, long j11) {
        if (this.f2307s && this.f2313y == null) {
            this.f2313y = (q0) H1(Z1());
        }
        q0 q0Var = this.f2313y;
        if (q0Var != null) {
            q0Var.T(qVar, pointerEventPass, j11);
        }
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean U0() {
        return d1.d(this);
    }

    public final void V1() {
        o1.a.b bVar = this.f2311w;
        if (bVar != null) {
            o1.i iVar = this.f2308t;
            if (iVar != null) {
                iVar.a(new o1.a.C0776a(bVar));
            }
            this.f2311w = null;
        }
    }

    public abstract Object W1(Function2<? super Function1<? super e.b, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void X0() {
        d1.c(this);
    }

    public final Function1<z, Boolean> X1() {
        return this.f2306r;
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean Y() {
        return d1.a(this);
    }

    public final boolean Y1() {
        return this.f2307s;
    }

    public final q0 Z1() {
        return o0.a(new DragGestureNode$initializePointerInputNode$1(this, null));
    }

    public abstract void a2(long j11);

    public abstract void b2(long j11);

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c2(Continuation<? super Unit> continuation) throws Throwable {
        DragGestureNode$processDragCancel$1 dragGestureNode$processDragCancel$1;
        DragGestureNode dragGestureNode;
        if (continuation instanceof DragGestureNode$processDragCancel$1) {
            dragGestureNode$processDragCancel$1 = (DragGestureNode$processDragCancel$1) continuation;
            int i11 = dragGestureNode$processDragCancel$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                dragGestureNode$processDragCancel$1.label = i11 - Integer.MIN_VALUE;
            } else {
                dragGestureNode$processDragCancel$1 = new DragGestureNode$processDragCancel$1(this, continuation);
            }
        } else {
            dragGestureNode$processDragCancel$1 = new DragGestureNode$processDragCancel$1(this, continuation);
        }
        Object obj = dragGestureNode$processDragCancel$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = dragGestureNode$processDragCancel$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            o1.a.b bVar = this.f2311w;
            if (bVar != null) {
                o1.i iVar = this.f2308t;
                if (iVar != null) {
                    o1.a.C0776a c0776a = new o1.a.C0776a(bVar);
                    dragGestureNode$processDragCancel$1.L$0 = this;
                    dragGestureNode$processDragCancel$1.label = 1;
                    if (iVar.b(c0776a, dragGestureNode$processDragCancel$1) == objE) {
                        return objE;
                    }
                }
                dragGestureNode = this;
            } else {
                dragGestureNode = this;
            }
            dragGestureNode.b2(q2.z.f74266b.a());
            return Unit.f68710a;
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        dragGestureNode = (DragGestureNode) dragGestureNode$processDragCancel$1.L$0;
        ResultKt.b(obj);
        dragGestureNode.f2311w = null;
        dragGestureNode.b2(q2.z.f74266b.a());
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d2(e.c cVar, Continuation<? super Unit> continuation) throws Throwable {
        DragGestureNode$processDragStart$1 dragGestureNode$processDragStart$1;
        DragGestureNode dragGestureNode;
        o1.i iVar;
        o1.a.b bVar;
        e.c cVar2;
        o1.a.b bVar2;
        DragGestureNode dragGestureNode2;
        if (continuation instanceof DragGestureNode$processDragStart$1) {
            dragGestureNode$processDragStart$1 = (DragGestureNode$processDragStart$1) continuation;
            int i11 = dragGestureNode$processDragStart$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                dragGestureNode$processDragStart$1.label = i11 - Integer.MIN_VALUE;
            } else {
                dragGestureNode$processDragStart$1 = new DragGestureNode$processDragStart$1(this, continuation);
            }
        } else {
            dragGestureNode$processDragStart$1 = new DragGestureNode$processDragStart$1(this, continuation);
        }
        Object obj = dragGestureNode$processDragStart$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = dragGestureNode$processDragStart$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                cVar = (e.c) dragGestureNode$processDragStart$1.L$1;
                dragGestureNode = (DragGestureNode) dragGestureNode$processDragStart$1.L$0;
                ResultKt.b(obj);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar2 = (o1.a.b) dragGestureNode$processDragStart$1.L$2;
                cVar2 = (e.c) dragGestureNode$processDragStart$1.L$1;
                dragGestureNode2 = (DragGestureNode) dragGestureNode$processDragStart$1.L$0;
                ResultKt.b(obj);
            }
            bVar = bVar2;
            dragGestureNode = dragGestureNode2;
            cVar = cVar2;
            dragGestureNode.f2311w = bVar;
            dragGestureNode.a2(cVar.a());
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        o1.a.b bVar3 = this.f2311w;
        if (bVar3 != null && (iVar = this.f2308t) != null) {
            o1.a.C0776a c0776a = new o1.a.C0776a(bVar3);
            dragGestureNode$processDragStart$1.L$0 = this;
            dragGestureNode$processDragStart$1.L$1 = cVar;
            dragGestureNode$processDragStart$1.label = 1;
            if (iVar.b(c0776a, dragGestureNode$processDragStart$1) == objE) {
                return objE;
            }
        }
        dragGestureNode = this;
        bVar = new o1.a.b();
        o1.i iVar2 = dragGestureNode.f2308t;
        if (iVar2 != null) {
            dragGestureNode$processDragStart$1.L$0 = dragGestureNode;
            dragGestureNode$processDragStart$1.L$1 = cVar;
            dragGestureNode$processDragStart$1.L$2 = bVar;
            dragGestureNode$processDragStart$1.label = 2;
            if (iVar2.b(bVar, dragGestureNode$processDragStart$1) == objE) {
                return objE;
            }
            cVar2 = cVar;
            bVar2 = bVar;
            dragGestureNode2 = dragGestureNode;
            bVar = bVar2;
            dragGestureNode = dragGestureNode2;
            cVar = cVar2;
        }
        dragGestureNode.f2311w = bVar;
        dragGestureNode.a2(cVar.a());
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e2(e.d dVar, Continuation<? super Unit> continuation) throws Throwable {
        DragGestureNode$processDragStop$1 dragGestureNode$processDragStop$1;
        DragGestureNode dragGestureNode;
        if (continuation instanceof DragGestureNode$processDragStop$1) {
            dragGestureNode$processDragStop$1 = (DragGestureNode$processDragStop$1) continuation;
            int i11 = dragGestureNode$processDragStop$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                dragGestureNode$processDragStop$1.label = i11 - Integer.MIN_VALUE;
            } else {
                dragGestureNode$processDragStop$1 = new DragGestureNode$processDragStop$1(this, continuation);
            }
        } else {
            dragGestureNode$processDragStop$1 = new DragGestureNode$processDragStop$1(this, continuation);
        }
        Object obj = dragGestureNode$processDragStop$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = dragGestureNode$processDragStop$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            o1.a.b bVar = this.f2311w;
            if (bVar != null) {
                o1.i iVar = this.f2308t;
                if (iVar != null) {
                    o1.a.c cVar = new o1.a.c(bVar);
                    dragGestureNode$processDragStop$1.L$0 = this;
                    dragGestureNode$processDragStop$1.L$1 = dVar;
                    dragGestureNode$processDragStop$1.label = 1;
                    if (iVar.b(cVar, dragGestureNode$processDragStop$1) == objE) {
                        return objE;
                    }
                }
                dragGestureNode = this;
            } else {
                dragGestureNode = this;
            }
            dragGestureNode.b2(dVar.a());
            return Unit.f68710a;
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        dVar = (e.d) dragGestureNode$processDragStop$1.L$1;
        dragGestureNode = (DragGestureNode) dragGestureNode$processDragStop$1.L$0;
        ResultKt.b(obj);
        dragGestureNode.f2311w = null;
        dragGestureNode.b2(dVar.a());
        return Unit.f68710a;
    }

    public abstract boolean f2();

    public final void g2() {
        this.f2312x = true;
        kotlinx.coroutines.j.d(h1(), null, null, new DragGestureNode$startListeningForEvents$1(this, null), 3, null);
    }

    public final void h2(Function1<? super z, Boolean> function1, boolean z11, o1.i iVar, Orientation orientation, boolean z12) {
        this.f2306r = function1;
        if (this.f2307s != z11) {
            this.f2307s = z11;
            if (!z11) {
                V1();
                q0 q0Var = this.f2313y;
                if (q0Var != null) {
                    K1(q0Var);
                }
                this.f2313y = null;
            }
            z12 = true;
        }
        if (!Intrinsics.b(this.f2308t, iVar)) {
            V1();
            this.f2308t = iVar;
        }
        if (this.f2305q != orientation) {
            this.f2305q = orientation;
        } else if (!z12) {
            return;
        }
        q0 q0Var2 = this.f2313y;
        if (q0Var2 != null) {
            q0Var2.r0();
        }
    }

    @Override // androidx.compose.ui.f.c
    public void s1() {
        this.f2312x = false;
        V1();
    }
}
