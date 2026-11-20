package com.transsion.videodetail.music.data;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$getMusicLiked$1", f = "MusicLikedFragmentViewModel.kt", l = {PsExtractor.PRIVATE_STREAM_1, 193, 195}, m = "invokeSuspend")
public final class MusicLikedFragmentViewModel$getMusicLiked$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $from;
    int label;
    final /* synthetic */ MusicLikedFragmentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicLikedFragmentViewModel$getMusicLiked$1(MusicLikedFragmentViewModel musicLikedFragmentViewModel, String str, Continuation<? super MusicLikedFragmentViewModel$getMusicLiked$1> continuation) {
        super(2, continuation);
        this.this$0 = musicLikedFragmentViewModel;
        this.$from = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MusicLikedFragmentViewModel$getMusicLiked$1(this.this$0, this.$from, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MusicLikedFragmentViewModel$getMusicLiked$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else {
                if (i11 != 2 && i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        vr.a aVarW = this.this$0.w();
        this.label = 1;
        obj = aVarW.a(this);
        if (obj == objE) {
            return objE;
        }
        int iIntValue = ((Number) obj).intValue();
        this.this$0.f59919b.clear();
        sz.a.f76638a.a(this.this$0.p() + " --> getMusicLiked() --> 加载音乐收藏数据 --> count = " + iIntValue + " --> from = " + this.$from);
        if (iIntValue > 0) {
            MusicLikedFragmentViewModel musicLikedFragmentViewModel = this.this$0;
            this.label = 2;
            if (musicLikedFragmentViewModel.D(this) == objE) {
                return objE;
            }
        } else {
            MusicLikedFragmentViewModel musicLikedFragmentViewModel2 = this.this$0;
            this.label = 3;
            if (musicLikedFragmentViewModel2.E(this) == objE) {
                return objE;
            }
        }
        return Unit.f68710a;
    }
}
