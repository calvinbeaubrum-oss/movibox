package com.transsion.usercenter.laboratory;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.db.mcc.LocalMcc;
import com.transsion.ad.strategy.NationalInformationManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

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
@DebugMetadata(c = "com.transsion.usercenter.laboratory.MccActivity$loadData$1", f = "MccActivity.kt", l = {123, TsExtractor.TS_STREAM_TYPE_DTS}, m = "invokeSuspend")
@SourceDebugExtension
public final class MccActivity$loadData$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MccActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MccActivity$loadData$1(MccActivity mccActivity, Continuation<? super MccActivity$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = mccActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MccActivity$loadData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MccActivity$loadData$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String string;
        xy.f fVar;
        RecyclerView recyclerView;
        RecyclerView.m layoutManager;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            fVar = this.this$0.f59362b;
            if (fVar != null && (recyclerView = fVar.f80801g) != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
                layoutManager.scrollToPosition(this.this$0.f59363c);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        NationalInformationManager nationalInformationManager = NationalInformationManager.f50580a;
        this.label = 1;
        obj = nationalInformationManager.b(this);
        if (obj == objE) {
            return objE;
        }
        List list = (List) obj;
        ArrayList arrayList = new ArrayList();
        MMKV mmkvC = ip.a.f67589a.c();
        String str = "";
        if (mmkvC != null && (string = mmkvC.getString("sp_code", "")) != null) {
            str = string;
        }
        this.this$0.d0(null);
        MccActivity mccActivity = this.this$0;
        int i12 = 0;
        for (Object obj2 : list) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                kotlin.collections.g.u();
            }
            LocalMcc localMcc = (LocalMcc) obj2;
            if (TextUtils.equals(localMcc.getMcc(), str)) {
                arrayList.add(new a1(true, localMcc));
                mccActivity.d0(localMcc);
                mccActivity.f59363c = i12;
            } else {
                arrayList.add(new a1(false, localMcc));
            }
            i12 = i13;
        }
        z0 z0Var = this.this$0.f59361a;
        if (z0Var != null) {
            z0Var.w0(arrayList);
        }
        this.label = 2;
        if (kotlinx.coroutines.r0.a(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, this) == objE) {
            return objE;
        }
        fVar = this.this$0.f59362b;
        if (fVar != null) {
            layoutManager.scrollToPosition(this.this$0.f59363c);
        }
        return Unit.f68710a;
    }
}
