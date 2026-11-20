package com.transsion.shorttv;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.shorttv.favorite.IShortTvFavoriteProvider;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
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
@DebugMetadata(c = "com.transsion.shorttv.ShortTvViewModel$favorite$1", f = "ShortTvViewModel.kt", l = {459}, m = "invokeSuspend")
public final class ShortTvViewModel$favorite$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $favorite;
    final /* synthetic */ ShortTVFavInfo $favoriteInfo;
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$favorite$1(String str, boolean z11, ShortTvViewModel shortTvViewModel, ShortTVFavInfo shortTVFavInfo, Continuation<? super ShortTvViewModel$favorite$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$favorite = z11;
        this.this$0 = shortTvViewModel;
        this.$favoriteInfo = shortTVFavInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvViewModel$favorite$1(this.$subjectId, this.$favorite, this.this$0, this.$favoriteInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvViewModel$favorite$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                String str = this.$subjectId;
                boolean z11 = this.$favorite;
                ShortTvViewModel shortTvViewModel = this.this$0;
                Result.Companion companion = Result.Companion;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("subjectId", str);
                jSONObject.put("action", !z11 ? 1 : 0);
                IShortTvFavoriteProvider iShortTvFavoriteProviderB = shortTvViewModel.B();
                this.label = 1;
                obj = iShortTvFavoriteProviderB.c(jSONObject, this);
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
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        ShortTVFavInfo shortTVFavInfo = this.$favoriteInfo;
        boolean z12 = this.$favorite;
        ShortTvViewModel shortTvViewModel2 = this.this$0;
        String str2 = this.$subjectId;
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
                shortTvViewModel2.f57805m.q(Boxing.a(!z12));
                shortTvViewModel2.f57807o.q(!z12 ? com.transsion.shorttv.favorite.b.f57874a : com.transsion.shorttv.favorite.c.f57875a);
                shortTvViewModel2.B().b(str2, shortTVFavInfo.getHasFavorite(), String.valueOf(shortTVFavInfo.getFavoriteNum()));
                shortTvViewModel2.R(str2, shortTVFavInfo);
            }
        }
        ShortTvViewModel shortTvViewModel3 = this.this$0;
        boolean z13 = this.$favorite;
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            shortTvViewModel3.f57805m.q(Boxing.a(z13));
            shortTvViewModel3.f57807o.q(com.transsion.shorttv.favorite.d.f57876a);
        }
        return Unit.f68710a;
    }
}
