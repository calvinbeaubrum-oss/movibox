package com.transsion.home.viewmodel;

import com.blankj.utilcode.util.n;
import com.tencent.mmkv.MMKV;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.home.utils.HomeMMKV;
import ip.b;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import okhttp3.RequestBody;
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
@DebugMetadata(c = "com.transsion.home.viewmodel.TrendingViewModel$getTrendingList$1", f = "TrendingViewModel.kt", l = {122}, m = "invokeSuspend")
public final class TrendingViewModel$getTrendingList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $nextPage;
    final /* synthetic */ TrendingRequestEntity $requestEntity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TrendingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingViewModel$getTrendingList$1(TrendingRequestEntity trendingRequestEntity, TrendingViewModel trendingViewModel, String str, Continuation<? super TrendingViewModel$getTrendingList$1> continuation) {
        super(2, continuation);
        this.$requestEntity = trendingRequestEntity;
        this.this$0 = trendingViewModel;
        this.$nextPage = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TrendingViewModel$getTrendingList$1 trendingViewModel$getTrendingList$1 = new TrendingViewModel$getTrendingList$1(this.$requestEntity, this.this$0, this.$nextPage, continuation);
        trendingViewModel$getTrendingList$1.L$0 = obj;
        return trendingViewModel$getTrendingList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TrendingViewModel$getTrendingList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        k0 k0Var;
        TrendingViewModel trendingViewModel;
        String str;
        Integer perRow;
        List<TrendingRespItem> items;
        Object objE = a.e();
        int i11 = this.label;
        boolean z11 = true;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                k0Var = (k0) this.L$0;
                b.a aVar = b.f67591a;
                String strJ = n.j(this.$requestEntity);
                Intrinsics.f(strJ, "toJson(requestEntity)");
                RequestBody requestBodyA = aVar.a(strJ);
                if (requestBodyA != null) {
                    trendingViewModel = this.this$0;
                    String str2 = this.$nextPage;
                    d dVar = trendingViewModel.f52771u;
                    String strA = cp.a.f62775a.a();
                    this.L$0 = k0Var;
                    this.L$1 = trendingViewModel;
                    this.L$2 = str2;
                    this.label = 1;
                    obj = dVar.c(strA, requestBodyA, this);
                    if (obj == objE) {
                        return objE;
                    }
                    str = str2;
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$2;
            trendingViewModel = (TrendingViewModel) this.L$1;
            k0Var = (k0) this.L$0;
            ResultKt.b(obj);
            BaseDto<TrendingRespData> baseDto = (BaseDto) obj;
            if (Intrinsics.b(baseDto.getCode(), "0")) {
                uo.b.a aVar2 = uo.b.f78622a;
                TrendingRespData data = baseDto.getData();
                uo.b.a.f(aVar2, "TrendingViewModel", "success " + ((data == null || (items = data.getItems()) == null) ? null : Boxing.d(items.size())) + " " + k0Var + "@PostListViewModel", false, 4, null);
                trendingViewModel.R().n(baseDto);
                if (Intrinsics.b(str, "1")) {
                    MMKV mmkvA = HomeMMKV.f52664a.a();
                    TrendingRespData data2 = baseDto.getData();
                    if (data2 != null && (perRow = data2.getPerRow()) != null && perRow.intValue() == 1) {
                        z11 = false;
                    }
                    mmkvA.putBoolean("trending_operation_grid_feeds", z11);
                }
            } else {
                uo.b.a.f(uo.b.f78622a, "TrendingViewModel", "code " + baseDto.getCode() + " message " + baseDto.getMsg(), false, 4, null);
                trendingViewModel.R().n(baseDto);
            }
        } catch (Exception e11) {
            uo.b.a.f(uo.b.f78622a, "TrendingViewModel", String.valueOf(e11.getMessage()), false, 4, null);
            e11.printStackTrace();
            this.this$0.R().n(new BaseDto<>("", "", new TrendingRespData(null, null, null, null, 15, null), ""));
        }
        return Unit.f68710a;
    }
}
