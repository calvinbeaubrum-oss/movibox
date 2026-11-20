package com.transsion.postdetail.shorttv;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import okhttp3.MediaType;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.postdetail.shorttv.ShortTvPlayListViewModel$favorite$1", f = "ShortTvPlayListViewModel.kt", l = {251}, m = "invokeSuspend")
@SourceDebugExtension
public final class ShortTvPlayListViewModel$favorite$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $favorite;
    final /* synthetic */ ShortTVFavInfo $favoriteInfo;
    final /* synthetic */ Subject $shortTvInfo;
    int label;
    final /* synthetic */ ShortTvPlayListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvPlayListViewModel$favorite$1(Subject subject, boolean z11, ShortTvPlayListViewModel shortTvPlayListViewModel, ShortTVFavInfo shortTVFavInfo, Continuation<? super ShortTvPlayListViewModel$favorite$1> continuation) {
        super(2, continuation);
        this.$shortTvInfo = subject;
        this.$favorite = z11;
        this.this$0 = shortTvPlayListViewModel;
        this.$favoriteInfo = shortTVFavInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvPlayListViewModel$favorite$1(this.$shortTvInfo, this.$favorite, this.this$0, this.$favoriteInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvPlayListViewModel$favorite$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                Subject subject = this.$shortTvInfo;
                boolean z11 = this.$favorite;
                ShortTvPlayListViewModel shortTvPlayListViewModel = this.this$0;
                Result.Companion companion = Result.Companion;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("subjectId", subject.getSubjectId());
                jSONObject.put("action", !z11 ? 1 : 0);
                a aVarG = shortTvPlayListViewModel.g();
                RequestBody.Companion companion2 = RequestBody.Companion;
                String string = jSONObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyCreate = companion2.create(string, MediaType.Companion.parse("application/json"));
                this.label = 1;
                obj = a.C0589a.a(aVarG, requestBodyCreate, null, this, 2, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            objM163constructorimpl = Result.m163constructorimpl((BaseDto) obj);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        ShortTVFavInfo shortTVFavInfo = this.$favoriteInfo;
        boolean z12 = this.$favorite;
        ShortTvPlayListViewModel shortTvPlayListViewModel2 = this.this$0;
        Subject subject2 = this.$shortTvInfo;
        if (Result.m170isSuccessimpl(objM163constructorimpl)) {
            if (shortTVFavInfo.getHasFavorite() != (!z12)) {
                shortTVFavInfo.setHasFavorite(!z12);
                if (z12) {
                    String favoriteNum = shortTVFavInfo.getFavoriteNum();
                    shortTVFavInfo.setFavoriteNum(String.valueOf((favoriteNum != null ? Long.parseLong(favoriteNum) : 1L) - 1));
                } else {
                    String favoriteNum2 = shortTVFavInfo.getFavoriteNum();
                    shortTVFavInfo.setFavoriteNum(String.valueOf((favoriteNum2 != null ? Long.parseLong(favoriteNum2) : 0L) + 1));
                }
                shortTvPlayListViewModel2.e().q(Boxing.a(!z12));
                shortTvPlayListViewModel2.f().q(!z12 ? "favorite_add" : "favorite_cancel");
                String subjectId = subject2.getSubjectId();
                if (subjectId == null) {
                    subjectId = "";
                }
                j00.c cVar = new j00.c(subjectId, !z12, String.valueOf(shortTVFavInfo.getFavoriteNum()));
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = j00.c.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, cVar, 0L);
                shortTvPlayListViewModel2.k(subject2);
            }
        }
        ShortTvPlayListViewModel shortTvPlayListViewModel3 = this.this$0;
        boolean z13 = this.$favorite;
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            shortTvPlayListViewModel3.e().q(Boxing.a(z13));
            shortTvPlayListViewModel3.f().q("favorite_fail");
        }
        return Unit.f68710a;
    }
}
