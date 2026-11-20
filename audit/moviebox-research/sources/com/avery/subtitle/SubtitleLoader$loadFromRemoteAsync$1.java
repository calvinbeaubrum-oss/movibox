package com.avery.subtitle;

import a8.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "com.avery.subtitle.SubtitleLoader$loadFromRemoteAsync$1", f = "SubtitleLoader.kt", l = {55, 60}, m = "invokeSuspend")
public final class SubtitleLoader$loadFromRemoteAsync$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubtitleLoader.a $callback;
    final /* synthetic */ String $remoteSubtitlePath;
    final /* synthetic */ String $unicode;
    int label;

    /* JADX INFO: renamed from: com.avery.subtitle.SubtitleLoader$loadFromRemoteAsync$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.avery.subtitle.SubtitleLoader$loadFromRemoteAsync$1$1", f = "SubtitleLoader.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubtitleLoader.a $callback;
        final /* synthetic */ d $timedTextObject;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SubtitleLoader.a aVar, d dVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = aVar;
            this.$timedTextObject = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, this.$timedTextObject, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.$callback.b(this.$timedTextObject);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.avery.subtitle.SubtitleLoader$loadFromRemoteAsync$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.avery.subtitle.SubtitleLoader$loadFromRemoteAsync$1$2", f = "SubtitleLoader.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubtitleLoader.a $callback;
        final /* synthetic */ Exception $e;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SubtitleLoader.a aVar, Exception exc, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$callback = aVar;
            this.$e = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$callback, this.$e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.$callback.a(this.$e);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleLoader$loadFromRemoteAsync$1(String str, String str2, SubtitleLoader.a aVar, Continuation<? super SubtitleLoader$loadFromRemoteAsync$1> continuation) {
        super(2, continuation);
        this.$remoteSubtitlePath = str;
        this.$unicode = str2;
        this.$callback = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubtitleLoader$loadFromRemoteAsync$1(this.$remoteSubtitlePath, this.$unicode, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubtitleLoader$loadFromRemoteAsync$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            d dVarF = SubtitleLoader.f25098a.f(this.$remoteSubtitlePath, this.$unicode);
            a2 a2VarC = w0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$callback, dVarF, null);
            this.label = 1;
            if (h.g(a2VarC, anonymousClass1, this) == objE) {
                return objE;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            a2 a2VarC2 = w0.c();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$callback, e11, null);
            this.label = 2;
            if (h.g(a2VarC2, anonymousClass2, this) == objE) {
                return objE;
            }
        }
        return Unit.f68710a;
    }
}
