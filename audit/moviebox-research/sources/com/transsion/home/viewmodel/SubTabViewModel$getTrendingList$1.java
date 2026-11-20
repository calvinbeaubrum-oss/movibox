package com.transsion.home.viewmodel;

import com.blankj.utilcode.util.n;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.home.bean.TrendingRespItemType;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PlayListItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import ip.b;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.internal.SourceDebugExtension;
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
@DebugMetadata(c = "com.transsion.home.viewmodel.SubTabViewModel$getTrendingList$1", f = "SubTabViewModel.kt", l = {172}, m = "invokeSuspend")
@SourceDebugExtension
public final class SubTabViewModel$getTrendingList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ TrendingRequestEntity $requestEntity;
    final /* synthetic */ int $tabId;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SubTabViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubTabViewModel$getTrendingList$1(TrendingRequestEntity trendingRequestEntity, int i11, SubTabViewModel subTabViewModel, Continuation<? super SubTabViewModel$getTrendingList$1> continuation) {
        super(2, continuation);
        this.$requestEntity = trendingRequestEntity;
        this.$tabId = i11;
        this.this$0 = subTabViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SubTabViewModel$getTrendingList$1 subTabViewModel$getTrendingList$1 = new SubTabViewModel$getTrendingList$1(this.$requestEntity, this.$tabId, this.this$0, continuation);
        subTabViewModel$getTrendingList$1.L$0 = obj;
        return subTabViewModel$getTrendingList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubTabViewModel$getTrendingList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        k0 k0Var;
        Object objC;
        SubTabViewModel subTabViewModel;
        List<TrendingRespItem> items;
        List<TrendingRespItem> items2;
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                k0Var = (k0) this.L$0;
                this.$requestEntity.setTabId(this.$tabId);
                this.$requestEntity.setDisablePlaylist(Boxing.a(false));
                b.a aVar = b.f67591a;
                String strJ = n.j(this.$requestEntity);
                Intrinsics.f(strJ, "toJson(requestEntity)");
                RequestBody requestBodyA = aVar.a(strJ);
                if (requestBodyA != null) {
                    SubTabViewModel subTabViewModel2 = this.this$0;
                    d dVar = subTabViewModel2.f52758f;
                    String strA = cp.a.f62775a.a();
                    this.L$0 = k0Var;
                    this.L$1 = subTabViewModel2;
                    this.label = 1;
                    objC = dVar.c(strA, requestBodyA, this);
                    if (objC == objE) {
                        return objE;
                    }
                    subTabViewModel = subTabViewModel2;
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            subTabViewModel = (SubTabViewModel) this.L$1;
            k0Var = (k0) this.L$0;
            ResultKt.b(obj);
            objC = obj;
            BaseDto<TrendingRespData> baseDto = (BaseDto) objC;
            if (Intrinsics.b(baseDto.getCode(), "0")) {
                uo.b.a aVar2 = uo.b.f78622a;
                TrendingRespData data = baseDto.getData();
                uo.b.a.f(aVar2, "SubTabViewModel", "success " + ((data == null || (items2 = data.getItems()) == null) ? null : Boxing.d(items2.size())) + " " + k0Var + "@PostListViewModel", false, 4, null);
                ArrayList arrayList = new ArrayList();
                TrendingRespData data2 = baseDto.getData();
                if (data2 != null && (items = data2.getItems()) != null) {
                    for (TrendingRespItem trendingRespItem : items) {
                        Integer type = trendingRespItem.getType();
                        int value = TrendingRespItemType.SUBJECT.getValue();
                        if (type == null || type.intValue() != value || trendingRespItem.getSubject() == null) {
                            Integer type2 = trendingRespItem.getType();
                            int value2 = TrendingRespItemType.PLAY_LIST.getValue();
                            if (type2 != null && type2.intValue() == value2 && trendingRespItem.getPlaylist() != null) {
                                OperateItem playlist = trendingRespItem.getPlaylist();
                                Intrinsics.d(playlist);
                                List<AppointSubject> subjects = playlist.getSubjects();
                                if (subjects != null && subjects.size() >= 3) {
                                    OperateItem operateItem = new OperateItem(null, PostItemType.PLAY_LIST.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097149, null);
                                    OperateItem playlist2 = trendingRespItem.getPlaylist();
                                    Intrinsics.d(playlist2);
                                    operateItem.setPlayListData(playlist2.getPlayListData());
                                    PlayListItem playListData = operateItem.getPlayListData();
                                    if (playListData != null) {
                                        OperateItem playlist3 = trendingRespItem.getPlaylist();
                                        Intrinsics.d(playlist3);
                                        playListData.setId(playlist3.getOpId());
                                    }
                                    OperateItem playlist4 = trendingRespItem.getPlaylist();
                                    Intrinsics.d(playlist4);
                                    operateItem.setTitle(playlist4.getTitle());
                                    ArrayList arrayList2 = new ArrayList();
                                    OperateItem playlist5 = trendingRespItem.getPlaylist();
                                    Intrinsics.d(playlist5);
                                    List<AppointSubject> subjects2 = playlist5.getSubjects();
                                    if (subjects2 != null) {
                                        Iterator<T> it = subjects2.iterator();
                                        while (it.hasNext()) {
                                            arrayList2.add((AppointSubject) it.next());
                                        }
                                    }
                                    operateItem.setSubjects(arrayList2);
                                    arrayList.add(operateItem);
                                }
                            }
                        } else {
                            OperateItem operateItem2 = new OperateItem(null, PostItemType.SUBJECT.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097149, null);
                            operateItem2.setFeedsSubject(trendingRespItem.getSubject());
                            arrayList.add(operateItem2);
                        }
                    }
                }
                TrendingRespData data3 = baseDto.getData();
                if (data3 != null) {
                    data3.setTransferData(arrayList);
                }
                subTabViewModel.l().n(baseDto);
            } else {
                uo.b.a.f(uo.b.f78622a, "SubTabViewModel", "code " + baseDto.getCode() + " message " + baseDto.getMsg(), false, 4, null);
            }
        } catch (Exception e11) {
            uo.b.a.f(uo.b.f78622a, "SubTabViewModel", String.valueOf(e11.getMessage()), false, 4, null);
            e11.printStackTrace();
            this.this$0.l().n(new BaseDto<>("", "", new TrendingRespData(null, null, null, null, 15, null), ""));
        }
        return Unit.f68710a;
    }
}
