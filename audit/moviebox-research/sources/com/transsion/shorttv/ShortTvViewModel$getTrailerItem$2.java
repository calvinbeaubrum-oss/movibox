package com.transsion.shorttv;

import com.google.gson.Gson;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PreVideoAddress;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.moviedetailapi.bean.Video;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "com.transsion.shorttv.ShortTvViewModel$getTrailerItem$2", f = "ShortTvViewModel.kt", l = {}, m = "invokeSuspend")
public final class ShortTvViewModel$getTrailerItem$2 extends SuspendLambda implements Function2<k0, Continuation<? super qx.d>, Object> {
    final /* synthetic */ Subject $subject;
    final /* synthetic */ String $subjectId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$getTrailerItem$2(Subject subject, String str, Continuation<? super ShortTvViewModel$getTrailerItem$2> continuation) {
        super(2, continuation);
        this.$subject = subject;
        this.$subjectId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvViewModel$getTrailerItem$2(this.$subject, this.$subjectId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super qx.d> continuation) {
        return ((ShortTvViewModel$getTrailerItem$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Subject subject = this.$subject;
        Trailer trailer = subject != null ? subject.getTrailer() : null;
        qx.d dVar = new qx.d(this.$subjectId, 0, null, 0, 12, null);
        Subject subject2 = this.$subject;
        dVar.g(true);
        dVar.f(0);
        ShortTVItem shortTVItem = (ShortTVItem) new Gson().fromJson(new Gson().toJson(subject2 != null ? subject2.getShortTVFirstEp() : null), ShortTVItem.class);
        if (shortTVItem != null) {
            shortTVItem.setId("0");
        }
        Intrinsics.d(trailer);
        PreVideoAddress videoAddress = trailer.getVideoAddress();
        Video videoA = videoAddress != null ? xu.b.a(videoAddress) : null;
        Media video = shortTVItem != null ? shortTVItem.getVideo() : null;
        if (video != null) {
            video.setVideoAddress(videoA);
        }
        if (shortTVItem != null) {
            shortTVItem.setLockStatus(1);
        }
        if (shortTVItem != null) {
            shortTVItem.setEp(0);
        }
        dVar.h(shortTVItem);
        return dVar;
    }
}
