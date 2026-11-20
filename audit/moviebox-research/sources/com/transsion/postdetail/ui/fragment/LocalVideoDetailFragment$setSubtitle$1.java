package com.transsion.postdetail.ui.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.subtitle.VideoSubtitleManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;

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
@DebugMetadata(c = "com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$setSubtitle$1", f = "LocalVideoDetailFragment.kt", l = {1433, 1439}, m = "invokeSuspend")
public final class LocalVideoDetailFragment$setSubtitle$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LocalVideoDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoDetailFragment$setSubtitle$1(LocalVideoDetailFragment localVideoDetailFragment, Continuation<? super LocalVideoDetailFragment$setSubtitle$1> continuation) {
        super(2, continuation);
        this.this$0 = localVideoDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoDetailFragment$setSubtitle$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoDetailFragment$setSubtitle$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0062  */
    /* JADX WARN: Code duplicated, block: B:18:0x006b  */
    /* JADX WARN: Code duplicated, block: B:21:0x00a8 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DownloadBean downloadBean;
        LocalVideoDetailFragment localVideoDetailFragment;
        List list;
        Integer numD;
        a2 a2VarC;
        LocalVideoDetailFragment$setSubtitle$1$1$1 localVideoDetailFragment$setSubtitle$1$1$1;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            downloadBean = this.this$0.B;
            if (downloadBean != null) {
                localVideoDetailFragment = this.this$0;
                VideoSubtitleManager videoSubtitleManagerA = VideoSubtitleManager.f58109a.a();
                String subtitleResId = downloadBean.getSubtitleResId();
                this.L$0 = localVideoDetailFragment;
                this.L$1 = downloadBean;
                this.label = 1;
                obj = videoSubtitleManagerA.a(subtitleResId, this);
                if (obj == objE) {
                    return objE;
                }
                list = (List) obj;
                uo.b.a aVar = uo.b.f78622a;
                String strA = com.transsion.baselib.report.a.f51248a.a();
                String[] strArr = new String[1];
                String totalTitleName = downloadBean.getTotalTitleName();
                String subtitleResId2 = downloadBean.getSubtitleResId();
                if (list != null) {
                    numD = Boxing.d(list.size());
                } else {
                    numD = null;
                }
                strArr[0] = "----- setSubtitle, name:" + totalTitleName + ", subtitleResId:" + subtitleResId2 + ", size = " + numD;
                aVar.n(strA, strArr, true);
                a2VarC = kotlinx.coroutines.w0.c();
                localVideoDetailFragment$setSubtitle$1$1$1 = new LocalVideoDetailFragment$setSubtitle$1$1$1(list, localVideoDetailFragment, downloadBean, null);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (kotlinx.coroutines.h.g(a2VarC, localVideoDetailFragment$setSubtitle$1$1$1, this) == objE) {
                    return objE;
                }
            }
        } else if (i11 == 1) {
            downloadBean = (DownloadBean) this.L$1;
            localVideoDetailFragment = (LocalVideoDetailFragment) this.L$0;
            ResultKt.b(obj);
            list = (List) obj;
            uo.b.a aVar2 = uo.b.f78622a;
            String strA2 = com.transsion.baselib.report.a.f51248a.a();
            String[] strArr2 = new String[1];
            String totalTitleName2 = downloadBean.getTotalTitleName();
            String subtitleResId3 = downloadBean.getSubtitleResId();
            if (list != null) {
                numD = Boxing.d(list.size());
            } else {
                numD = null;
            }
            strArr2[0] = "----- setSubtitle, name:" + totalTitleName2 + ", subtitleResId:" + subtitleResId3 + ", size = " + numD;
            aVar2.n(strA2, strArr2, true);
            a2VarC = kotlinx.coroutines.w0.c();
            localVideoDetailFragment$setSubtitle$1$1$1 = new LocalVideoDetailFragment$setSubtitle$1$1$1(list, localVideoDetailFragment, downloadBean, null);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (kotlinx.coroutines.h.g(a2VarC, localVideoDetailFragment$setSubtitle$1$1$1, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
