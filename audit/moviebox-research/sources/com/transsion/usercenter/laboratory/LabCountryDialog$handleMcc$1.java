package com.transsion.usercenter.laboratory;

import com.transsion.ad.db.mcc.LocalMcc;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.usercenter.laboratory.LabCountryDialog$handleMcc$1", f = "LabCountryDialog.kt", l = {73}, m = "invokeSuspend")
public final class LabCountryDialog$handleMcc$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $text;
    Object L$0;
    int label;
    final /* synthetic */ LabCountryDialog this$0;

    /* JADX INFO: renamed from: com.transsion.usercenter.laboratory.LabCountryDialog$handleMcc$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.usercenter.laboratory.LabCountryDialog$handleMcc$1$1", f = "LabCountryDialog.kt", l = {74}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<LocalMcc> $localMcc;
        final /* synthetic */ String $text;
        int label;
        final /* synthetic */ LabCountryDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LabCountryDialog labCountryDialog, String str, Ref.ObjectRef<LocalMcc> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = labCountryDialog;
            this.$text = str;
            this.$localMcc = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$text, this.$localMcc, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Type inference failed for: r4v5, types: [T, com.transsion.ad.db.mcc.LocalMcc] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                qq.a aVarT0 = this.this$0.t0();
                String str = this.$text;
                this.label = 1;
                obj = aVarT0.a(str, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.$localMcc.element = (LocalMcc) obj;
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabCountryDialog$handleMcc$1(LabCountryDialog labCountryDialog, String str, Continuation<? super LabCountryDialog$handleMcc$1> continuation) {
        super(2, continuation);
        this.this$0 = labCountryDialog;
        this.$text = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LabCountryDialog$handleMcc$1(this.this$0, this.$text, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LabCountryDialog$handleMcc$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.ObjectRef objectRef;
        String mcc;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            CoroutineDispatcher coroutineDispatcherB = kotlinx.coroutines.w0.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$text, objectRef2, null);
            this.L$0 = objectRef2;
            this.label = 1;
            if (kotlinx.coroutines.h.g(coroutineDispatcherB, anonymousClass1, this) == objE) {
                return objE;
            }
            objectRef = objectRef2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.b(obj);
        }
        LabCountryDialog labCountryDialog = this.this$0;
        String str = this.$text;
        LocalMcc localMcc = (LocalMcc) objectRef.element;
        if (localMcc == null || (mcc = localMcc.getMcc()) == null) {
            mcc = "";
        }
        labCountryDialog.A0(str, mcc);
        this.this$0.dismiss();
        return Unit.f68710a;
    }
}
