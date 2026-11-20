package com.transsion.shorttv.utils;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.shorttv.source.ShortTvInfoEpisodeList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "com.transsion.shorttv.utils.ShortTVFloatManager$getShortTvEpisodeList$1$2$1", f = "ShortTVFloatManager.kt", l = {}, m = "invokeSuspend")
public final class ShortTVFloatManager$getShortTvEpisodeList$1$2$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ShortTvInfoEpisodeList, Unit> $callback;
    final /* synthetic */ BaseDto<ShortTvInfoEpisodeList> $it;
    final /* synthetic */ int $start;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShortTVFloatManager$getShortTvEpisodeList$1$2$1(int i11, BaseDto<ShortTvInfoEpisodeList> baseDto, Function1<? super ShortTvInfoEpisodeList, Unit> function1, Continuation<? super ShortTVFloatManager$getShortTvEpisodeList$1$2$1> continuation) {
        super(2, continuation);
        this.$start = i11;
        this.$it = baseDto;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVFloatManager$getShortTvEpisodeList$1$2$1(this.$start, this.$it, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTVFloatManager$getShortTvEpisodeList$1$2$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<ShortTVItem> items;
        ShortTVItem shortTVItem;
        List<ShortTVItem> items2;
        ShortTVItem shortTVItem2;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        uo.b.a aVar = uo.b.f78622a;
        int i11 = this.$start;
        ShortTvInfoEpisodeList data = this.$it.getData();
        Integer numD = null;
        Integer numD2 = (data == null || (items2 = data.getItems()) == null || (shortTVItem2 = (ShortTVItem) CollectionsKt___CollectionsKt.g0(items2)) == null) ? null : Boxing.d(shortTVItem2.getEp());
        ShortTvInfoEpisodeList data2 = this.$it.getData();
        if (data2 != null && (items = data2.getItems()) != null && (shortTVItem = (ShortTVItem) CollectionsKt___CollectionsKt.r0(items)) != null) {
            numD = Boxing.d(shortTVItem.getEp());
        }
        aVar.c("VideoFloat", "shorttv-----getShortTvEpisodeList success, start:" + i11 + ", startEp:" + numD2 + ", lastEp:" + numD, true);
        this.$callback.invoke(this.$it.getData());
        return Unit.f68710a;
    }
}
