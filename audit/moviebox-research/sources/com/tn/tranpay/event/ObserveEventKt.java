package com.tn.tranpay.event;

import androidx.annotation.Keep;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import androidx.lifecycle.v0;
import androidx.lifecycle.y0;
import com.google.android.gms.ads.RequestConfiguration;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.q1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ObserveEventKt {

    /* JADX INFO: renamed from: com.tn.tranpay.event.ObserveEventKt$observeEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.tn.tranpay.event.ObserveEventKt$observeEvent$1", f = "ObserveEvent.kt", l = {106}, m = "invokeSuspend")
    @SourceDebugExtension
    public final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isSticky;
        final /* synthetic */ Function1<Object, Unit> $onReceived;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z11, Function1<Object, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isSticky = z11;
            this.$onReceived = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$isSticky, this.$onReceived, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                Intrinsics.m(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
                String name = Object.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                boolean z11 = this.$isSticky;
                Function1<Object, Unit> function1 = this.$onReceived;
                this.label = 1;
                if (flowEventBus.observeWithoutLifecycle(name, z11, function1, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.tn.tranpay.event.ObserveEventKt$observeEvent$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.tn.tranpay.event.ObserveEventKt$observeEvent$2", f = "ObserveEvent.kt", l = {123}, m = "invokeSuspend")
    @SourceDebugExtension
    public final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isSticky;
        final /* synthetic */ Function1<Object, Unit> $onReceived;
        final /* synthetic */ y0 $scope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(y0 y0Var, boolean z11, Function1<Object, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$scope = y0Var;
            this.$isSticky = z11;
            this.$onReceived = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$scope, this.$isSticky, this.$onReceived, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                FlowEventBus flowEventBus = (FlowEventBus) new v0(this.$scope).a(FlowEventBus.class);
                Intrinsics.m(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
                String name = Object.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                boolean z11 = this.$isSticky;
                Function1<Object, Unit> function1 = this.$onReceived;
                this.label = 1;
                if (flowEventBus.observeWithoutLifecycle(name, z11, function1, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    @Keep
    public static final /* synthetic */ <T> q1 observeEvent(u uVar, Function1<? super T, Unit> onReceived) {
        Intrinsics.g(uVar, "<this>");
        Intrinsics.g(onReceived, "onReceived");
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        Intrinsics.m(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        String name = Object.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        return flowEventBus.observeEvent(uVar, name, Lifecycle.State.CREATED, w0.c().q(), false, onReceived);
    }
}
