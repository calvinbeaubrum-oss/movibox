package com.transsion.videofloat.manager;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.transsion.videofloat.manager.VideoPipManagerImp$closePip$1$1", f = "VideoPipManagerImp.kt", l = {}, m = "invokeSuspend")
public final class VideoPipManagerImp$closePip$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $addCache;
    int label;
    final /* synthetic */ VideoPipManagerImp this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPipManagerImp$closePip$1$1(VideoPipManagerImp videoPipManagerImp, boolean z11, Continuation<? super VideoPipManagerImp$closePip$1$1> continuation) {
        super(2, continuation);
        this.this$0 = videoPipManagerImp;
        this.$addCache = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPipManagerImp$closePip$1$1(this.this$0, this.$addCache, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((VideoPipManagerImp$closePip$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        vz.a aVar = this.this$0.f60048d;
        if (aVar != null) {
            VideoPipManagerImp videoPipManagerImp = this.this$0;
            boolean z11 = this.$addCache;
            uo.b.f78622a.r("VideoFloat-pip", videoPipManagerImp.f60046b + " 手动打开播放页，closePip--- " + aVar.j() + "， activity:" + videoPipManagerImp.f60047c, true);
            if (z11) {
                v.f60111a.a(aVar.j(), aVar.e());
            }
        }
        this.this$0.g();
        this.this$0.G();
        this.this$0.f60058n = false;
        this.this$0.f60050f = null;
        this.this$0.f60051g = null;
        this.this$0.f60052h = null;
        this.this$0.f60053i = null;
        this.this$0.f60054j = null;
        this.this$0.f60048d = null;
        return Unit.f68710a;
    }
}
