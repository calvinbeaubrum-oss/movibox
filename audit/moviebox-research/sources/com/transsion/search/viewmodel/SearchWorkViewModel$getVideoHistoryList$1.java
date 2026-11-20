package com.transsion.search.viewmodel;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.MotionEventCompat;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.search.viewmodel.SearchWorkViewModel$getVideoHistoryList$1", f = "SearchWorkViewModel.kt", l = {MotionEventCompat.AXIS_GENERIC_13}, m = "invokeSuspend")
@SourceDebugExtension
public final class SearchWorkViewModel$getVideoHistoryList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefreshAll;
    int label;
    final /* synthetic */ SearchWorkViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchWorkViewModel$getVideoHistoryList$1(boolean z11, SearchWorkViewModel searchWorkViewModel, Continuation<? super SearchWorkViewModel$getVideoHistoryList$1> continuation) {
        super(2, continuation);
        this.$isRefreshAll = z11;
        this.this$0 = searchWorkViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchWorkViewModel$getVideoHistoryList$1(this.$isRefreshAll, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SearchWorkViewModel$getVideoHistoryList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ArrayList arrayList;
        Object objE = a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (this.$isRefreshAll) {
                this.this$0.l(0);
                this.this$0.f57702a = true;
                this.this$0.f57704c.clear();
            }
            VideoDetailPlayDao videoDetailPlayDaoI = this.this$0.i();
            int iH = this.this$0.h();
            int i12 = this.this$0.f57707g;
            this.label = 1;
            obj = videoDetailPlayDaoI.n(iH, i12, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List list = (List) obj;
        List list2 = list;
        if (list2 == null || list2.isEmpty() || list.size() < this.this$0.f57707g) {
            this.this$0.f57702a = false;
        }
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (TextUtils.isDigitsOnly(((VideoDetailPlayBean) obj2).getId())) {
                    arrayList.add(obj2);
                }
            }
        } else {
            arrayList = null;
        }
        Integer numD = arrayList != null ? Boxing.d(arrayList.size()) : null;
        Log.e("SearchWork", "获取视频播放记录 数量： " + numD + "，hasMore:" + this.this$0.f());
        if (arrayList == null) {
            return Unit.f68710a;
        }
        this.this$0.f57704c.addAll(arrayList);
        SearchWorkViewModel searchWorkViewModel = this.this$0;
        searchWorkViewModel.l(searchWorkViewModel.h() + arrayList.size());
        this.this$0.g().n(CollectionsKt___CollectionsKt.M0(this.this$0.f57704c));
        return Unit.f68710a;
    }
}
