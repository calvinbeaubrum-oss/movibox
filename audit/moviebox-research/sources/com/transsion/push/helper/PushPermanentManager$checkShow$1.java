package com.transsion.push.helper;

import com.transsion.push.db.PermanentRoom;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import uo.b;

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
@DebugMetadata(c = "com.transsion.push.helper.PushPermanentManager$checkShow$1", f = "PushPermanentManager.kt", l = {59}, m = "invokeSuspend")
public final class PushPermanentManager$checkShow$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;

    public PushPermanentManager$checkShow$1(Continuation<? super PushPermanentManager$checkShow$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushPermanentManager$checkShow$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PushPermanentManager$checkShow$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00f6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PushPermanentManager pushPermanentManager;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            b.a.f(b.f78622a, "PUSH_SHOW", "checkShow mPage:" + PushPermanentManager.f56899e + ",size:" + PushPermanentManager.f56897c.size() + ",lastRequestTime:" + PushPermanentManager.f56902h + ", mTitle:" + PushPermanentManager.f56895a.s(), false, 4, null);
            if (PushPermanentManager.f56899e == null) {
                PermanentRoom permanentRoom = PermanentRoom.f56861a;
                PushPermanentManager.f56899e = permanentRoom.f();
                PushPermanentManager.f56898d = permanentRoom.e();
                PushPermanentManager.f56901g = permanentRoom.h();
                PushPermanentManager.f56902h = permanentRoom.g();
                this.label = 1;
                obj = permanentRoom.d(this);
                if (obj == objE) {
                    return objE;
                }
            }
            b.a aVar = b.f78622a;
            String str = PushPermanentManager.f56899e;
            int size = PushPermanentManager.f56897c.size();
            long j11 = PushPermanentManager.f56902h;
            pushPermanentManager = PushPermanentManager.f56895a;
            b.a.j(aVar, "PUSH_SHOW", "checkShow== mPage:" + str + ", size:" + size + ",lastRequestTime:" + j11 + ", mTitle:" + pushPermanentManager.s(), false, 4, null);
            if (PushPermanentManager.f56897c.size() >= 10 || !pushPermanentManager.t()) {
                pushPermanentManager.q();
            } else {
                pushPermanentManager.v();
            }
            return Unit.f68710a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        PushPermanentManager.f56897c = CollectionsKt___CollectionsKt.M0((Collection) obj);
        b.a aVar2 = b.f78622a;
        String str2 = PushPermanentManager.f56899e;
        int size2 = PushPermanentManager.f56897c.size();
        long j12 = PushPermanentManager.f56902h;
        pushPermanentManager = PushPermanentManager.f56895a;
        b.a.j(aVar2, "PUSH_SHOW", "checkShow== mPage:" + str2 + ", size:" + size2 + ",lastRequestTime:" + j12 + ", mTitle:" + pushPermanentManager.s(), false, 4, null);
        if (PushPermanentManager.f56897c.size() >= 10) {
            pushPermanentManager.q();
        } else {
            pushPermanentManager.q();
        }
        return Unit.f68710a;
    }
}
