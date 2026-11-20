package com.transsion.home.viewmodel;

import com.blankj.utilcode.util.n;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.utils.HomeMMKV;
import com.transsion.moviedetailapi.bean.RoomItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import rt.d;

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
@DebugMetadata(c = "com.transsion.home.viewmodel.TrendingViewModel$fetchGroupInfo$1", f = "TrendingViewModel.kt", l = {170}, m = "invokeSuspend")
public final class TrendingViewModel$fetchGroupInfo$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $useCache;
    int label;
    final /* synthetic */ TrendingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingViewModel$fetchGroupInfo$1(TrendingViewModel trendingViewModel, Function0<Unit> function0, Continuation<? super TrendingViewModel$fetchGroupInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = trendingViewModel;
        this.$useCache = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrendingViewModel$fetchGroupInfo$1(this.this$0, this.$useCache, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TrendingViewModel$fetchGroupInfo$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<RoomItem> groups;
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                d dVar = this.this$0.f52771u;
                this.label = 1;
                obj = d.a.c(dVar, null, 6, this, 1, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            RoomEntranceResponse roomEntranceResponse = (RoomEntranceResponse) baseDto.getData();
            if (roomEntranceResponse == null || (groups = roomEntranceResponse.getGroups()) == null || !(!groups.isEmpty())) {
                this.$useCache.invoke();
            } else {
                this.this$0.Q().n(baseDto.getData());
                HomeMMKV.f52664a.a().putString("trending_room_entrance_cache_v2", n.j(baseDto.getData()));
            }
        } catch (Exception e11) {
            this.$useCache.invoke();
            e11.printStackTrace();
        }
        return Unit.f68710a;
    }
}
