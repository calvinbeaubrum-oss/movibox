package com.transsion.shorttv;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.shorttv.source.ShortTvInfoEpisodeList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.shorttv.ShortTvViewModel$getShortTvEpisodesInfo$1", f = "ShortTvViewModel.kt", l = {333, 337}, m = "invokeSuspend")
@SourceDebugExtension
public final class ShortTvViewModel$getShortTvEpisodesInfo$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $selectEp;
    final /* synthetic */ int $start;
    final /* synthetic */ String $subjectId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$getShortTvEpisodesInfo$1(int i11, int i12, ShortTvViewModel shortTvViewModel, String str, Continuation<? super ShortTvViewModel$getShortTvEpisodesInfo$1> continuation) {
        super(2, continuation);
        this.$start = i11;
        this.$selectEp = i12;
        this.this$0 = shortTvViewModel;
        this.$subjectId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvViewModel$getShortTvEpisodesInfo$1(this.$start, this.$selectEp, this.this$0, this.$subjectId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvViewModel$getShortTvEpisodesInfo$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:48:0x0107  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        ShortTvViewModel shortTvViewModel;
        ShortTvViewModel shortTvViewModel2;
        String str;
        Object objA;
        ShortTvViewModel shortTvViewModel3;
        List<ShortTVItem> items;
        ShortTVItem shortTVItem;
        Video videoAddress;
        String str2;
        Object objA2;
        Video video;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    String str3 = (String) this.L$1;
                    shortTvViewModel3 = (ShortTvViewModel) this.L$0;
                    ResultKt.b(obj);
                    str = str3;
                    objA = obj;
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    video = (Video) this.L$3;
                    objA = this.L$0;
                    ResultKt.b(obj);
                    objA2 = obj;
                }
                str2 = (String) objA2;
                videoAddress = video;
                videoAddress.setUrl(str2);
                objM163constructorimpl = Result.m163constructorimpl((BaseDto) objA);
                shortTvViewModel = this.this$0;
                if (Result.m170isSuccessimpl(objM163constructorimpl)) {
                    shortTvViewModel.f57799g.q(((BaseDto) objM163constructorimpl).getData());
                }
                shortTvViewModel2 = this.this$0;
                if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                    shortTvViewModel2.f57799g.q(null);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "getShortTvEpisodes start isDataNotComplete：" + this.$start + " ," + this.$selectEp, false, 4, null);
            ShortTvViewModel shortTvViewModel4 = this.this$0;
            str = this.$subjectId;
            int i12 = this.$selectEp;
            Result.Companion companion = Result.Companion;
            com.transsion.shorttv.episode.a aVarY = shortTvViewModel4.y();
            this.L$0 = shortTvViewModel4;
            this.L$1 = str;
            this.label = 1;
            objA = com.transsion.shorttv.episode.a.C0597a.a(aVarY, str, i12, i12, 0, null, this, 24, null);
            if (objA == objE) {
                return objE;
            }
            shortTvViewModel3 = shortTvViewModel4;
            ShortTvInfoEpisodeList shortTvInfoEpisodeList = (ShortTvInfoEpisodeList) ((BaseDto) objA).getData();
            if (shortTvInfoEpisodeList != null && (items = shortTvInfoEpisodeList.getItems()) != null && (shortTVItem = (ShortTVItem) CollectionsKt___CollectionsKt.g0(items)) != null) {
                int ep2 = shortTVItem.getEp();
                Media video2 = shortTVItem.getVideo();
                if (video2 != null && (videoAddress = video2.getVideoAddress()) != null) {
                    String url = videoAddress.getUrl();
                    if (url != null) {
                        ox.a aVarW = shortTvViewModel3.w();
                        this.L$0 = objA;
                        this.L$1 = shortTVItem;
                        this.L$2 = videoAddress;
                        this.L$3 = videoAddress;
                        this.label = 2;
                        objA2 = aVarW.a(str, ep2, url, this);
                        if (objA2 == objE) {
                            return objE;
                        }
                        video = videoAddress;
                        str2 = (String) objA2;
                        videoAddress = video;
                    } else {
                        str2 = null;
                    }
                    videoAddress.setUrl(str2);
                }
            }
            objM163constructorimpl = Result.m163constructorimpl((BaseDto) objA);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        shortTvViewModel = this.this$0;
        if (Result.m170isSuccessimpl(objM163constructorimpl)) {
            shortTvViewModel.f57799g.q(((BaseDto) objM163constructorimpl).getData());
        }
        shortTvViewModel2 = this.this$0;
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            shortTvViewModel2.f57799g.q(null);
        }
        return Unit.f68710a;
    }
}
