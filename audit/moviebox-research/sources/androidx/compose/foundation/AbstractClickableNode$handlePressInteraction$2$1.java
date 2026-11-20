package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.t1;

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
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1", f = "Clickable.kt", l = {1139, 1141, 1148, 1149, 1158}, m = "invokeSuspend")
public final class AbstractClickableNode$handlePressInteraction$2$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ o1.i $interactionSource;
    final /* synthetic */ long $offset;
    final /* synthetic */ androidx.compose.foundation.gestures.i $this_handlePressInteraction;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ AbstractClickableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClickableNode$handlePressInteraction$2$1(androidx.compose.foundation.gestures.i iVar, long j11, o1.i iVar2, AbstractClickableNode abstractClickableNode, Continuation<? super AbstractClickableNode$handlePressInteraction$2$1> continuation) {
        super(2, continuation);
        this.$this_handlePressInteraction = iVar;
        this.$offset = j11;
        this.$interactionSource = iVar2;
        this.this$0 = abstractClickableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AbstractClickableNode$handlePressInteraction$2$1 abstractClickableNode$handlePressInteraction$2$1 = new AbstractClickableNode$handlePressInteraction$2$1(this.$this_handlePressInteraction, this.$offset, this.$interactionSource, this.this$0, continuation);
        abstractClickableNode$handlePressInteraction$2$1.L$0 = obj;
        return abstractClickableNode$handlePressInteraction$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((AbstractClickableNode$handlePressInteraction$2$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x008a  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b0 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        q1 q1VarD;
        Object objN0;
        boolean z11;
        o1.k.b bVar;
        o1.k.c cVar;
        o1.i iVar;
        o1.k.c cVar2;
        o1.i iVar2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                q1VarD = (q1) this.L$0;
                ResultKt.b(obj);
                objN0 = obj;
            } else if (i11 == 2) {
                z11 = this.Z$0;
                ResultKt.b(obj);
                if (z11) {
                    bVar = new o1.k.b(this.$offset, null);
                    cVar = new o1.k.c(bVar);
                    iVar = this.$interactionSource;
                    this.L$0 = cVar;
                    this.label = 3;
                    if (iVar.b(bVar, this) == objE) {
                        return objE;
                    }
                    cVar2 = cVar;
                    iVar2 = this.$interactionSource;
                    this.L$0 = null;
                    this.label = 4;
                    if (iVar2.b(cVar2, this) == objE) {
                        return objE;
                    }
                }
            } else if (i11 == 3) {
                cVar2 = (o1.k.c) this.L$0;
                ResultKt.b(obj);
                iVar2 = this.$interactionSource;
                this.L$0 = null;
                this.label = 4;
                if (iVar2.b(cVar2, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 4 && i11 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.this$0.B = null;
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        q1VarD = kotlinx.coroutines.j.d((k0) this.L$0, null, null, new AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(this.this$0, this.$offset, this.$interactionSource, null), 3, null);
        androidx.compose.foundation.gestures.i iVar3 = this.$this_handlePressInteraction;
        this.L$0 = q1VarD;
        this.label = 1;
        objN0 = iVar3.n0(this);
        if (objN0 == objE) {
            return objE;
        }
        boolean zBooleanValue = ((Boolean) objN0).booleanValue();
        if (q1VarD.isActive()) {
            this.L$0 = null;
            this.Z$0 = zBooleanValue;
            this.label = 2;
            if (t1.g(q1VarD, this) == objE) {
                return objE;
            }
            z11 = zBooleanValue;
            if (z11) {
                bVar = new o1.k.b(this.$offset, null);
                cVar = new o1.k.c(bVar);
                iVar = this.$interactionSource;
                this.L$0 = cVar;
                this.label = 3;
                if (iVar.b(bVar, this) == objE) {
                    return objE;
                }
                cVar2 = cVar;
                iVar2 = this.$interactionSource;
                this.L$0 = null;
                this.label = 4;
                if (iVar2.b(cVar2, this) == objE) {
                    return objE;
                }
            }
        } else {
            o1.k.b bVar2 = this.this$0.B;
            if (bVar2 != null) {
                o1.i iVar4 = this.$interactionSource;
                o1.f cVar3 = zBooleanValue ? new o1.k.c(bVar2) : new o1.k.a(bVar2);
                this.L$0 = null;
                this.label = 5;
                if (iVar4.b(cVar3, this) == objE) {
                    return objE;
                }
            }
        }
        this.this$0.B = null;
        return Unit.f68710a;
    }
}
