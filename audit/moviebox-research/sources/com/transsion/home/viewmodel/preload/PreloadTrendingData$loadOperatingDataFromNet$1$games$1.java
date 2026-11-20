package com.transsion.home.viewmodel.preload;

import com.transsion.bean.AhaGameAllGames;
import com.transsion.bean.AhaGameData;
import com.transsion.bean.AhaGameResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.home.viewmodel.preload.PreloadTrendingData$loadOperatingDataFromNet$1$games$1", f = "PreloadTrendingData.kt", l = {125}, m = "invokeSuspend")
public final class PreloadTrendingData$loadOperatingDataFromNet$1$games$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PreloadTrendingData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadTrendingData$loadOperatingDataFromNet$1$games$1(PreloadTrendingData preloadTrendingData, Continuation<? super PreloadTrendingData$loadOperatingDataFromNet$1$games$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadTrendingData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreloadTrendingData$loadOperatingDataFromNet$1$games$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PreloadTrendingData$loadOperatingDataFromNet$1$games$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<AhaGameAllGames> allGames;
        AhaGameData data;
        Object objE = a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            PreloadTrendingData preloadTrendingData = this.this$0;
            this.label = 1;
            obj = preloadTrendingData.z(this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        AhaGameResponse ahaGameResponse = (AhaGameResponse) obj;
        if (((ahaGameResponse == null || (data = ahaGameResponse.getData()) == null) ? null : data.getAllGames()) != null) {
            b.a aVar = b.f78622a;
            AhaGameData data2 = ahaGameResponse.getData();
            b.a.f(aVar, "PreloadTrending", "preload: gameList " + ((data2 == null || (allGames = data2.getAllGames()) == null) ? null : Boxing.d(allGames.size())), false, 4, null);
            AhaGameData data3 = ahaGameResponse.getData();
            this.this$0.A().n(data3 != null ? data3.getAllGames() : null);
        } else {
            this.this$0.A().n(null);
        }
        return Unit.f68710a;
    }
}
