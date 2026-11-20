package com.transsion.baseui.music;

import android.text.TextUtils;
import com.blankj.utilcode.util.n;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.baseui.music.MusicReport$saveLocal$1", f = "MusicReport.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
public final class MusicReport$saveLocal$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ k $musicPlayDurationBean;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicReport$saveLocal$1(k kVar, Continuation<? super MusicReport$saveLocal$1> continuation) {
        super(2, continuation);
        this.$musicPlayDurationBean = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MusicReport$saveLocal$1(this.$musicPlayDurationBean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MusicReport$saveLocal$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        k kVar = this.$musicPlayDurationBean;
        try {
            Result.Companion companion = Result.Companion;
            List<k> listB = MusicReport.f51422a.b();
            for (k kVar2 : listB) {
                if (TextUtils.equals(kVar2.d(), kVar.d())) {
                    kVar2.m(kVar2.c() + kVar.c());
                    kVar2.l(kVar2.b() + kVar.b());
                    kVar2.o(kVar2.f() + kVar.f());
                }
            }
            if (listB.isEmpty()) {
                listB.add(kVar);
            }
            RoomAppMMKV.f51271a.a().putString("music_play_duration", n.j(listB));
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            com.transsion.player.mediasession.d.f54622a.b("MusicReport --> saveLocal() --> it = " + thM166exceptionOrNullimpl);
        }
        return Unit.f68710a;
    }
}
