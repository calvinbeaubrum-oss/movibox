package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {174, 176, 178, 179, 181}, m = "invokeSuspend")
public final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<b<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StartedWhileSubscribed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation<? super StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
        this.this$0 = startedWhileSubscribed;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(b<? super SharingCommand> bVar, Integer num, Continuation<? super Unit> continuation) {
        return invoke(bVar, num.intValue(), continuation);
    }

    public final Object invoke(b<? super SharingCommand> bVar, int i11, Continuation<? super Unit> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.L$0 = bVar;
        startedWhileSubscribed$command$1.I$0 = i11;
        return startedWhileSubscribed$command$1.invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0070  */
    /* JADX WARN: Code duplicated, block: B:28:0x007c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x008d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x009b A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        b bVar;
        SharingCommand sharingCommand;
        long j11;
        SharingCommand sharingCommand2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 == 2) {
                    bVar = (b) this.L$0;
                    ResultKt.b(obj);
                    if (this.this$0.f69371c > 0) {
                        sharingCommand = SharingCommand.STOP;
                        this.L$0 = bVar;
                        this.label = 3;
                        if (bVar.emit(sharingCommand, this) == objE) {
                            return objE;
                        }
                        j11 = this.this$0.f69371c;
                        this.L$0 = bVar;
                        this.label = 4;
                        if (kotlinx.coroutines.r0.a(j11, this) == objE) {
                            return objE;
                        }
                    }
                } else if (i11 == 3) {
                    bVar = (b) this.L$0;
                    ResultKt.b(obj);
                    j11 = this.this$0.f69371c;
                    this.L$0 = bVar;
                    this.label = 4;
                    if (kotlinx.coroutines.r0.a(j11, this) == objE) {
                        return objE;
                    }
                } else if (i11 == 4) {
                    bVar = (b) this.L$0;
                    ResultKt.b(obj);
                } else if (i11 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sharingCommand2 = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                this.L$0 = null;
                this.label = 5;
                if (bVar.emit(sharingCommand2, this) == objE) {
                    return objE;
                }
            }
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            bVar = (b) this.L$0;
            if (this.I$0 > 0) {
                SharingCommand sharingCommand3 = SharingCommand.START;
                this.label = 1;
                if (bVar.emit(sharingCommand3, this) == objE) {
                    return objE;
                }
            } else {
                long j12 = this.this$0.f69370b;
                this.L$0 = bVar;
                this.label = 2;
                if (kotlinx.coroutines.r0.a(j12, this) == objE) {
                    return objE;
                }
                if (this.this$0.f69371c > 0) {
                    sharingCommand = SharingCommand.STOP;
                    this.L$0 = bVar;
                    this.label = 3;
                    if (bVar.emit(sharingCommand, this) == objE) {
                        return objE;
                    }
                    j11 = this.this$0.f69371c;
                    this.L$0 = bVar;
                    this.label = 4;
                    if (kotlinx.coroutines.r0.a(j11, this) == objE) {
                        return objE;
                    }
                }
                sharingCommand2 = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                this.L$0 = null;
                this.label = 5;
                if (bVar.emit(sharingCommand2, this) == objE) {
                    return objE;
                }
            }
        }
        return Unit.f68710a;
    }
}
