package com.transsion.wrapperad.view;

import android.content.Context;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.wrapperad.view.NativeSlideshowView$loadBottomAd$1$onBiddingLoad$1$1", f = "NativeSlideshowView.kt", l = {232}, m = "invokeSuspend")
public final class NativeSlideshowView$loadBottomAd$1$onBiddingLoad$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    int label;
    final /* synthetic */ NativeSlideshowView this$0;

    /* JADX INFO: renamed from: com.transsion.wrapperad.view.NativeSlideshowView$loadBottomAd$1$onBiddingLoad$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.wrapperad.view.NativeSlideshowView$loadBottomAd$1$onBiddingLoad$1$1$1", f = "NativeSlideshowView.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $ctx;
        int label;
        final /* synthetic */ NativeSlideshowView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, NativeSlideshowView nativeSlideshowView, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$ctx = context;
            this.this$0 = nativeSlideshowView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$ctx, this.this$0, continuation);
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
            d00.b bVar = d00.b.f62855a;
            Context context = this.$ctx;
            com.transsion.ad.bidding.nativead.c cVar = this.this$0.f60259f;
            zq.b bVarA = bVar.a(context, cVar != null ? cVar.Q() : null);
            NativeWrapperAdView nativeWrapperAdView = this.this$0.f60263j;
            if (nativeWrapperAdView != null) {
                nativeWrapperAdView.bindNativeView(this.this$0.f60259f, bVarA);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeSlideshowView$loadBottomAd$1$onBiddingLoad$1$1(Context context, NativeSlideshowView nativeSlideshowView, Continuation<? super NativeSlideshowView$loadBottomAd$1$onBiddingLoad$1$1> continuation) {
        super(2, continuation);
        this.$ctx = context;
        this.this$0 = nativeSlideshowView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NativeSlideshowView$loadBottomAd$1$onBiddingLoad$1$1(this.$ctx, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((NativeSlideshowView$loadBottomAd$1$onBiddingLoad$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            a2 a2VarC = w0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$ctx, this.this$0, null);
            this.label = 1;
            if (h.g(a2VarC, anonymousClass1, this) == objE) {
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
