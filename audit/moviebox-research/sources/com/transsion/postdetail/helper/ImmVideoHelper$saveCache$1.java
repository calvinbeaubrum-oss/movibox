package com.transsion.postdetail.helper;

import com.blankj.utilcode.util.n;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.List;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.transsion.postdetail.helper.ImmVideoHelper$saveCache$1", f = "ImmVideoHelper.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
public final class ImmVideoHelper$saveCache$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PostSubjectItem> $videoList;
    int label;
    final /* synthetic */ ImmVideoHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmVideoHelper$saveCache$1(List<PostSubjectItem> list, ImmVideoHelper immVideoHelper, Continuation<? super ImmVideoHelper$saveCache$1> continuation) {
        super(2, continuation);
        this.$videoList = list;
        this.this$0 = immVideoHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImmVideoHelper$saveCache$1(this.$videoList, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ImmVideoHelper$saveCache$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        try {
            List<PostSubjectItem> list = this.$videoList;
            List<PostSubjectItem> listSubList = list.subList(list.size() - 1, this.$videoList.size());
            ImmVideoHelper immVideoHelper = this.this$0;
            for (PostSubjectItem postSubjectItem : listSubList) {
                if (postSubjectItem.isCache()) {
                    return Unit.f68710a;
                }
                postSubjectItem.setCache(true);
                uo.b.a.f(uo.b.f78622a, "postdetail_video", "save cache " + postSubjectItem.getTitle(), false, 4, null);
                Media media = postSubjectItem.getMedia();
                immVideoHelper.m(media != null ? media.getVideo() : null);
            }
            RoomAppMMKV.f51271a.a().putString("k_save_video", n.j(listSubList));
        } catch (Exception unused) {
        }
        return Unit.f68710a;
    }
}
