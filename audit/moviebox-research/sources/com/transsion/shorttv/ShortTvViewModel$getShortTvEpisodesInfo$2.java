package com.transsion.shorttv;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.shorttv.source.ShortTvInfoEpisodeList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
@DebugMetadata(c = "com.transsion.shorttv.ShortTvViewModel$getShortTvEpisodesInfo$2", f = "ShortTvViewModel.kt", l = {359, 364}, m = "invokeSuspend")
@SourceDebugExtension
public final class ShortTvViewModel$getShortTvEpisodesInfo$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $start;
    final /* synthetic */ String $subjectId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$getShortTvEpisodesInfo$2(int i11, ShortTvViewModel shortTvViewModel, String str, Continuation<? super ShortTvViewModel$getShortTvEpisodesInfo$2> continuation) {
        super(2, continuation);
        this.$start = i11;
        this.this$0 = shortTvViewModel;
        this.$subjectId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvViewModel$getShortTvEpisodesInfo$2(this.$start, this.this$0, this.$subjectId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvViewModel$getShortTvEpisodesInfo$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00bd A[Catch: all -> 0x0106, TryCatch #1 {all -> 0x0106, blocks: (B:46:0x0109, B:27:0x00b7, B:29:0x00bd, B:31:0x00cd, B:33:0x00d3, B:35:0x00d9), top: B:80:0x0109 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x012d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0138  */
    /* JADX WARN: Code duplicated, block: B:58:0x013d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0146  */
    /* JADX WARN: Code duplicated, block: B:62:0x014b  */
    /* JADX WARN: Code duplicated, block: B:65:0x0157  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:83:0x010d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x00b7 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00f4 -> B:78:0x00fa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0108 -> B:80:0x0109). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ShortTvViewModel$getShortTvEpisodesInfo$2 shortTvViewModel$getShortTvEpisodesInfo$2;
        Object objM163constructorimpl;
        ShortTvViewModel$getShortTvEpisodesInfo$2 shortTvViewModel$getShortTvEpisodesInfo$3;
        ShortTvViewModel shortTvViewModel;
        int i11;
        ShortTvViewModel shortTvViewModel2;
        int i12;
        ShortTvInfoEpisodeList shortTvInfoEpisodeList;
        List<ShortTVItem> items;
        ShortTvInfoEpisodeList shortTvInfoEpisodeList2;
        Subject info;
        List<ShortTVItem> list;
        String str;
        Object objA;
        ShortTvViewModel shortTvViewModel3;
        List<ShortTVItem> items2;
        ShortTvViewModel shortTvViewModel4;
        Iterator it;
        String str2;
        Object obj2;
        Media video;
        Object objA2;
        ShortTvViewModel shortTvViewModel5;
        String str3;
        Object obj3;
        Iterator it2;
        Video video2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = this.label;
        try {
            if (i13 != 0) {
                if (i13 == 1) {
                    String str4 = (String) this.L$1;
                    shortTvViewModel3 = (ShortTvViewModel) this.L$0;
                    ResultKt.b(obj);
                    str = str4;
                    objA = obj;
                } else {
                    if (i13 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    video2 = (Video) this.L$6;
                    Iterator it3 = (Iterator) this.L$3;
                    Object obj4 = this.L$2;
                    String str5 = (String) this.L$1;
                    ShortTvViewModel shortTvViewModel6 = (ShortTvViewModel) this.L$0;
                    ResultKt.b(obj);
                    objA2 = obj;
                    shortTvViewModel5 = shortTvViewModel6;
                    str3 = str5;
                    obj3 = obj4;
                    it2 = it3;
                    shortTvViewModel$getShortTvEpisodesInfo$3 = this;
                }
                try {
                    try {
                        String str6 = (String) objA2;
                        Video videoAddress = video2;
                        shortTvViewModel$getShortTvEpisodesInfo$2 = shortTvViewModel$getShortTvEpisodesInfo$3;
                        it = it2;
                        obj2 = obj3;
                        str2 = str3;
                        shortTvViewModel4 = shortTvViewModel5;
                        videoAddress.setUrl(str6);
                        while (true) {
                            if (it.hasNext()) {
                                shortTvViewModel$getShortTvEpisodesInfo$3 = shortTvViewModel$getShortTvEpisodesInfo$2;
                                objA = obj2;
                                objM163constructorimpl = Result.m163constructorimpl((BaseDto) objA);
                                shortTvViewModel = shortTvViewModel$getShortTvEpisodesInfo$3.this$0;
                                i11 = shortTvViewModel$getShortTvEpisodesInfo$3.$start;
                                if (Result.m170isSuccessimpl(objM163constructorimpl)) {
                                    BaseDto baseDto = (BaseDto) objM163constructorimpl;
                                    shortTvInfoEpisodeList = (ShortTvInfoEpisodeList) baseDto.getData();
                                    if (shortTvInfoEpisodeList != null) {
                                        items = shortTvInfoEpisodeList.getItems();
                                    } else {
                                        items = null;
                                    }
                                    shortTvInfoEpisodeList2 = (ShortTvInfoEpisodeList) baseDto.getData();
                                    if (shortTvInfoEpisodeList2 != null) {
                                        info = shortTvInfoEpisodeList2.getInfo();
                                    } else {
                                        info = null;
                                    }
                                    if (shortTvViewModel.v().f() == null) {
                                        shortTvViewModel.N(info, items.get(0), 0L);
                                        uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "没有历史", false, 4, null);
                                    }
                                    shortTvViewModel.f57799g.q(baseDto.getData());
                                    shortTvViewModel.F.put(Boxing.d(i11), Boxing.d(0));
                                }
                                shortTvViewModel2 = shortTvViewModel$getShortTvEpisodesInfo$3.this$0;
                                i12 = shortTvViewModel$getShortTvEpisodesInfo$3.$start;
                                if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                                    shortTvViewModel2.f57799g.q(null);
                                    shortTvViewModel2.F.put(Boxing.d(i12), Boxing.d(-1));
                                }
                                return Unit.f68710a;
                            }
                            ShortTVItem shortTVItem = (ShortTVItem) it.next();
                            int ep2 = shortTVItem.getEp();
                            video = shortTVItem.getVideo();
                            if (video == null && (videoAddress = video.getVideoAddress()) != null) {
                                String url = videoAddress.getUrl();
                                if (url != null) {
                                    ox.a aVarW = shortTvViewModel4.w();
                                    shortTvViewModel$getShortTvEpisodesInfo$2.L$0 = shortTvViewModel4;
                                    shortTvViewModel$getShortTvEpisodesInfo$2.L$1 = str2;
                                    shortTvViewModel$getShortTvEpisodesInfo$2.L$2 = obj2;
                                    shortTvViewModel$getShortTvEpisodesInfo$2.L$3 = it;
                                    shortTvViewModel$getShortTvEpisodesInfo$2.L$4 = shortTVItem;
                                    shortTvViewModel$getShortTvEpisodesInfo$2.L$5 = videoAddress;
                                    shortTvViewModel$getShortTvEpisodesInfo$2.L$6 = videoAddress;
                                    shortTvViewModel$getShortTvEpisodesInfo$2.label = 2;
                                    objA2 = aVarW.a(str2, ep2, url, shortTvViewModel$getShortTvEpisodesInfo$2);
                                    if (objA2 == objE) {
                                        return objE;
                                    }
                                    shortTvViewModel5 = shortTvViewModel4;
                                    str3 = str2;
                                    obj3 = obj2;
                                    it2 = it;
                                    shortTvViewModel$getShortTvEpisodesInfo$3 = shortTvViewModel$getShortTvEpisodesInfo$2;
                                    video2 = videoAddress;
                                    String str7 = (String) objA2;
                                    Video videoAddress2 = video2;
                                    shortTvViewModel$getShortTvEpisodesInfo$2 = shortTvViewModel$getShortTvEpisodesInfo$3;
                                    it = it2;
                                    obj2 = obj3;
                                    str2 = str3;
                                    shortTvViewModel4 = shortTvViewModel5;
                                } else {
                                    str7 = null;
                                }
                                videoAddress2.setUrl(str7);
                                if (it.hasNext()) {
                                    shortTvViewModel$getShortTvEpisodesInfo$3 = shortTvViewModel$getShortTvEpisodesInfo$2;
                                    objA = obj2;
                                    objM163constructorimpl = Result.m163constructorimpl((BaseDto) objA);
                                    shortTvViewModel = shortTvViewModel$getShortTvEpisodesInfo$3.this$0;
                                    i11 = shortTvViewModel$getShortTvEpisodesInfo$3.$start;
                                    if (Result.m170isSuccessimpl(objM163constructorimpl)) {
                                        BaseDto baseDto2 = (BaseDto) objM163constructorimpl;
                                        shortTvInfoEpisodeList = (ShortTvInfoEpisodeList) baseDto2.getData();
                                        if (shortTvInfoEpisodeList != null) {
                                            items = shortTvInfoEpisodeList.getItems();
                                        } else {
                                            items = null;
                                        }
                                        shortTvInfoEpisodeList2 = (ShortTvInfoEpisodeList) baseDto2.getData();
                                        if (shortTvInfoEpisodeList2 != null) {
                                            info = shortTvInfoEpisodeList2.getInfo();
                                        } else {
                                            info = null;
                                        }
                                        if (shortTvViewModel.v().f() == null && (list = items) != null && !list.isEmpty() && info != null) {
                                            shortTvViewModel.N(info, items.get(0), 0L);
                                            uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "没有历史", false, 4, null);
                                        }
                                        shortTvViewModel.f57799g.q(baseDto2.getData());
                                        shortTvViewModel.F.put(Boxing.d(i11), Boxing.d(0));
                                    }
                                    shortTvViewModel2 = shortTvViewModel$getShortTvEpisodesInfo$3.this$0;
                                    i12 = shortTvViewModel$getShortTvEpisodesInfo$3.$start;
                                    if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                                        shortTvViewModel2.f57799g.q(null);
                                        shortTvViewModel2.F.put(Boxing.d(i12), Boxing.d(-1));
                                    }
                                    return Unit.f68710a;
                                }
                                ShortTVItem shortTVItem2 = (ShortTVItem) it.next();
                                int ep3 = shortTVItem2.getEp();
                                video = shortTVItem2.getVideo();
                                if (video == null) {
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        shortTvViewModel$getShortTvEpisodesInfo$2 = shortTvViewModel$getShortTvEpisodesInfo$3;
                        Result.Companion companion = Result.Companion;
                        objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                        shortTvViewModel$getShortTvEpisodesInfo$3 = shortTvViewModel$getShortTvEpisodesInfo$2;
                        shortTvViewModel = shortTvViewModel$getShortTvEpisodesInfo$3.this$0;
                        i11 = shortTvViewModel$getShortTvEpisodesInfo$3.$start;
                        if (Result.m170isSuccessimpl(objM163constructorimpl)) {
                            BaseDto baseDto3 = (BaseDto) objM163constructorimpl;
                            shortTvInfoEpisodeList = (ShortTvInfoEpisodeList) baseDto3.getData();
                            if (shortTvInfoEpisodeList != null) {
                                items = shortTvInfoEpisodeList.getItems();
                            } else {
                                items = null;
                            }
                            shortTvInfoEpisodeList2 = (ShortTvInfoEpisodeList) baseDto3.getData();
                            if (shortTvInfoEpisodeList2 != null) {
                                info = shortTvInfoEpisodeList2.getInfo();
                            } else {
                                info = null;
                            }
                            if (shortTvViewModel.v().f() == null) {
                                shortTvViewModel.N(info, items.get(0), 0L);
                                uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "没有历史", false, 4, null);
                            }
                            shortTvViewModel.f57799g.q(baseDto3.getData());
                            shortTvViewModel.F.put(Boxing.d(i11), Boxing.d(0));
                        }
                        shortTvViewModel2 = shortTvViewModel$getShortTvEpisodesInfo$3.this$0;
                        i12 = shortTvViewModel$getShortTvEpisodesInfo$3.$start;
                        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                            shortTvViewModel2.f57799g.q(null);
                            shortTvViewModel2.F.put(Boxing.d(i12), Boxing.d(-1));
                        }
                        return Unit.f68710a;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    Result.Companion companion2 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                    shortTvViewModel$getShortTvEpisodesInfo$3 = shortTvViewModel$getShortTvEpisodesInfo$2;
                }
            } else {
                ResultKt.b(obj);
                uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "getShortTvEpisodes start：" + this.$start + "  ", false, 4, null);
                ShortTvViewModel shortTvViewModel7 = this.this$0;
                str = this.$subjectId;
                int i14 = this.$start;
                Result.Companion companion3 = Result.Companion;
                this.L$0 = shortTvViewModel7;
                this.L$1 = str;
                this.label = 1;
                objA = com.transsion.shorttv.episode.a.C0597a.a(shortTvViewModel7.y(), str, i14, i14 + 19, 0, null, this, 24, null);
                if (objA == objE) {
                    return objE;
                }
                shortTvViewModel3 = shortTvViewModel7;
            }
            ShortTvInfoEpisodeList shortTvInfoEpisodeList3 = (ShortTvInfoEpisodeList) ((BaseDto) objA).getData();
            if (shortTvInfoEpisodeList3 == null || (items2 = shortTvInfoEpisodeList3.getItems()) == null) {
                shortTvViewModel$getShortTvEpisodesInfo$3 = this;
            } else {
                shortTvViewModel4 = shortTvViewModel3;
                it = items2.iterator();
                str2 = str;
                obj2 = objA;
                shortTvViewModel$getShortTvEpisodesInfo$2 = this;
                while (true) {
                    if (it.hasNext()) {
                        ShortTVItem shortTVItem3 = (ShortTVItem) it.next();
                        int ep4 = shortTVItem3.getEp();
                        video = shortTVItem3.getVideo();
                        if (video == null) {
                        }
                    } else {
                        shortTvViewModel$getShortTvEpisodesInfo$3 = shortTvViewModel$getShortTvEpisodesInfo$2;
                        objA = obj2;
                    }
                }
            }
            objM163constructorimpl = Result.m163constructorimpl((BaseDto) objA);
        } catch (Throwable th4) {
            th = th4;
            shortTvViewModel$getShortTvEpisodesInfo$2 = this;
        }
        shortTvViewModel = shortTvViewModel$getShortTvEpisodesInfo$3.this$0;
        i11 = shortTvViewModel$getShortTvEpisodesInfo$3.$start;
        if (Result.m170isSuccessimpl(objM163constructorimpl)) {
            BaseDto baseDto4 = (BaseDto) objM163constructorimpl;
            shortTvInfoEpisodeList = (ShortTvInfoEpisodeList) baseDto4.getData();
            if (shortTvInfoEpisodeList != null) {
                items = shortTvInfoEpisodeList.getItems();
            } else {
                items = null;
            }
            shortTvInfoEpisodeList2 = (ShortTvInfoEpisodeList) baseDto4.getData();
            if (shortTvInfoEpisodeList2 != null) {
                info = shortTvInfoEpisodeList2.getInfo();
            } else {
                info = null;
            }
            if (shortTvViewModel.v().f() == null) {
                shortTvViewModel.N(info, items.get(0), 0L);
                uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "没有历史", false, 4, null);
            }
            shortTvViewModel.f57799g.q(baseDto4.getData());
            shortTvViewModel.F.put(Boxing.d(i11), Boxing.d(0));
        }
        shortTvViewModel2 = shortTvViewModel$getShortTvEpisodesInfo$3.this$0;
        i12 = shortTvViewModel$getShortTvEpisodesInfo$3.$start;
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            shortTvViewModel2.f57799g.q(null);
            shortTvViewModel2.F.put(Boxing.d(i12), Boxing.d(-1));
        }
        return Unit.f68710a;
    }
}
