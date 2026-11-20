package com.transsion.videodetail.music.data;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.videodetail.music.bean.LikeListActionEnum;
import com.transsion.videodetail.music.bean.MusicLikedRemoteActionBean;
import ip.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import okhttp3.RequestBody;
import org.json.JSONObject;

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
@DebugMetadata(c = "com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$likedMusic$1", f = "MusicLikedFragmentViewModel.kt", l = {66}, m = "invokeSuspend")
public final class MusicLikedFragmentViewModel$likedMusic$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ LikeListActionEnum $action;
    final /* synthetic */ String $subjectId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MusicLikedFragmentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicLikedFragmentViewModel$likedMusic$1(String str, LikeListActionEnum likeListActionEnum, MusicLikedFragmentViewModel musicLikedFragmentViewModel, Continuation<? super MusicLikedFragmentViewModel$likedMusic$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$action = likeListActionEnum;
        this.this$0 = musicLikedFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MusicLikedFragmentViewModel$likedMusic$1 musicLikedFragmentViewModel$likedMusic$1 = new MusicLikedFragmentViewModel$likedMusic$1(this.$subjectId, this.$action, this.this$0, continuation);
        musicLikedFragmentViewModel$likedMusic$1.L$0 = obj;
        return musicLikedFragmentViewModel$likedMusic$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MusicLikedFragmentViewModel$likedMusic$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0083  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        MusicLikedFragmentViewModel musicLikedFragmentViewModel;
        String str;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                String str2 = this.$subjectId;
                LikeListActionEnum likeListActionEnum = this.$action;
                MusicLikedFragmentViewModel musicLikedFragmentViewModel2 = this.this$0;
                Result.Companion companion = Result.Companion;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("subjectId", str2);
                jSONObject.put("action", likeListActionEnum.getValue());
                a aVarV = musicLikedFragmentViewModel2.v();
                b.a aVar = b.f67591a;
                String string = jSONObject.toString();
                Intrinsics.f(string, "jsonObject.toString()");
                RequestBody requestBodyA = aVar.a(string);
                this.L$0 = musicLikedFragmentViewModel2;
                this.label = 1;
                obj = a.C0614a.b(aVarV, requestBodyA, null, this, 2, null);
                if (obj == objE) {
                    return objE;
                }
                musicLikedFragmentViewModel = musicLikedFragmentViewModel2;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                musicLikedFragmentViewModel = (MusicLikedFragmentViewModel) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            MusicLikedRemoteActionBean musicLikedRemoteActionBean = (MusicLikedRemoteActionBean) baseDto.getData();
            if (musicLikedRemoteActionBean != null) {
                Integer action = musicLikedRemoteActionBean.getAction();
                int value = LikeListActionEnum.ADD.getValue();
                if (action != null && action.intValue() == value) {
                    str = "收藏";
                } else {
                    str = "取消";
                }
            } else {
                str = "取消";
            }
            sz.a.f76638a.a(musicLikedFragmentViewModel.p() + " --> likedMusic() --> " + str + "成功,同步本地数据库 --> likeMusic = " + baseDto.getData());
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        MusicLikedFragmentViewModel musicLikedFragmentViewModel3 = this.this$0;
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            sz.a.f76638a.b(musicLikedFragmentViewModel3.p() + " --> likedMusic() --> it = " + thM166exceptionOrNullimpl);
        }
        return Unit.f68710a;
    }
}
