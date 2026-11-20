package com.transsion.shorttv.utils;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.shorttv.source.ShortTvInfoEpisodeList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;

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
@DebugMetadata(c = "com.transsion.shorttv.utils.ShortTVFloatManager$getShortTvEpisodeList$1", f = "ShortTVFloatManager.kt", l = {125, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 137, 146}, m = "invokeSuspend")
@SourceDebugExtension
public final class ShortTVFloatManager$getShortTvEpisodeList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ShortTvInfoEpisodeList, Unit> $callback;
    final /* synthetic */ int $selectEp;
    final /* synthetic */ String $subjectId;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShortTVFloatManager$getShortTvEpisodeList$1(int i11, String str, Function1<? super ShortTvInfoEpisodeList, Unit> function1, Continuation<? super ShortTVFloatManager$getShortTvEpisodeList$1> continuation) {
        super(2, continuation);
        this.$selectEp = i11;
        this.$subjectId = str;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVFloatManager$getShortTvEpisodeList$1(this.$selectEp, this.$subjectId, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTVFloatManager$getShortTvEpisodeList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00d6 A[Catch: all -> 0x0112, TryCatch #0 {all -> 0x0112, blocks: (B:44:0x010f, B:48:0x0115, B:33:0x00d0, B:35:0x00d6, B:37:0x00e6, B:39:0x00ec, B:41:0x00f2, B:51:0x011c), top: B:70:0x010f }] */
    /* JADX WARN: Code duplicated, block: B:60:0x013e  */
    /* JADX WARN: Code duplicated, block: B:62:0x015e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0167  */
    /* JADX WARN: Code duplicated, block: B:67:0x0184 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:77:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00d0 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x010c -> B:70:0x010f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0114 -> B:48:0x0115). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ShortTVFloatManager$getShortTvEpisodeList$1 shortTVFloatManager$getShortTvEpisodeList$1;
        Object objM163constructorimpl;
        Function1<ShortTvInfoEpisodeList, Unit> function1;
        a2 a2VarC;
        ShortTVFloatManager$getShortTvEpisodeList$1$2$1 shortTVFloatManager$getShortTvEpisodeList$1$2$1;
        Function1<ShortTvInfoEpisodeList, Unit> function2;
        a2 a2VarC2;
        ShortTVFloatManager$getShortTvEpisodeList$1$3$1 shortTVFloatManager$getShortTvEpisodeList$1$3$1;
        int i11;
        String str;
        Object objA;
        List<ShortTVItem> items;
        Iterator it;
        Object obj2;
        String str2;
        Media video;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = this.label;
        int i13 = 1;
        try {
            if (i12 != 0) {
                if (i12 == 1) {
                    i13 = this.I$0;
                    String str3 = (String) this.L$0;
                    ResultKt.b(obj);
                    str = str3;
                    objA = obj;
                } else if (i12 == 2) {
                    i13 = this.I$0;
                    Video video2 = (Video) this.L$5;
                    it = (Iterator) this.L$2;
                    obj2 = this.L$1;
                    str2 = (String) this.L$0;
                    ResultKt.b(obj);
                    Video videoAddress = video2;
                    shortTVFloatManager$getShortTvEpisodeList$1 = this;
                    Object objA2 = obj;
                    try {
                        String str4 = (String) objA2;
                        videoAddress.setUrl(str4);
                        while (true) {
                            if (it.hasNext()) {
                                ShortTVItem shortTVItem = (ShortTVItem) it.next();
                                int ep2 = shortTVItem.getEp();
                                video = shortTVItem.getVideo();
                                if (video == null && (videoAddress = video.getVideoAddress()) != null) {
                                    String url = videoAddress.getUrl();
                                    if (url != null) {
                                        ox.a aVarI = ShortTVFloatManager.f57884b.i();
                                        shortTVFloatManager$getShortTvEpisodeList$1.L$0 = str2;
                                        shortTVFloatManager$getShortTvEpisodeList$1.L$1 = obj2;
                                        shortTVFloatManager$getShortTvEpisodeList$1.L$2 = it;
                                        shortTVFloatManager$getShortTvEpisodeList$1.L$3 = shortTVItem;
                                        shortTVFloatManager$getShortTvEpisodeList$1.L$4 = videoAddress;
                                        shortTVFloatManager$getShortTvEpisodeList$1.L$5 = videoAddress;
                                        shortTVFloatManager$getShortTvEpisodeList$1.I$0 = i13;
                                        shortTVFloatManager$getShortTvEpisodeList$1.label = 2;
                                        objA2 = aVarI.a(str2, ep2, url, shortTVFloatManager$getShortTvEpisodeList$1);
                                        if (objA2 == objE) {
                                            return objE;
                                        }
                                        String str5 = (String) objA2;
                                    } else {
                                        str5 = null;
                                    }
                                    videoAddress.setUrl(str5);
                                    if (it.hasNext()) {
                                        ShortTVItem shortTVItem2 = (ShortTVItem) it.next();
                                        int ep3 = shortTVItem2.getEp();
                                        video = shortTVItem2.getVideo();
                                        if (video == null) {
                                        }
                                    } else {
                                        objA = obj2;
                                        objM163constructorimpl = Result.m163constructorimpl((BaseDto) objA);
                                        function1 = shortTVFloatManager$getShortTvEpisodeList$1.$callback;
                                        if (Result.m170isSuccessimpl(objM163constructorimpl)) {
                                            a2VarC = w0.c();
                                            shortTVFloatManager$getShortTvEpisodeList$1$2$1 = new ShortTVFloatManager$getShortTvEpisodeList$1$2$1(i13, (BaseDto) objM163constructorimpl, function1, null);
                                            shortTVFloatManager$getShortTvEpisodeList$1.L$0 = objM163constructorimpl;
                                            shortTVFloatManager$getShortTvEpisodeList$1.L$1 = null;
                                            shortTVFloatManager$getShortTvEpisodeList$1.L$2 = null;
                                            shortTVFloatManager$getShortTvEpisodeList$1.L$3 = null;
                                            shortTVFloatManager$getShortTvEpisodeList$1.L$4 = null;
                                            shortTVFloatManager$getShortTvEpisodeList$1.L$5 = null;
                                            shortTVFloatManager$getShortTvEpisodeList$1.label = 3;
                                            if (h.g(a2VarC, shortTVFloatManager$getShortTvEpisodeList$1$2$1, shortTVFloatManager$getShortTvEpisodeList$1) == objE) {
                                                return objE;
                                            }
                                        }
                                        function2 = shortTVFloatManager$getShortTvEpisodeList$1.$callback;
                                        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                                            a2VarC2 = w0.c();
                                            shortTVFloatManager$getShortTvEpisodeList$1$3$1 = new ShortTVFloatManager$getShortTvEpisodeList$1$3$1(function2, null);
                                            shortTVFloatManager$getShortTvEpisodeList$1.L$0 = objM163constructorimpl;
                                            shortTVFloatManager$getShortTvEpisodeList$1.L$1 = null;
                                            shortTVFloatManager$getShortTvEpisodeList$1.L$2 = null;
                                            shortTVFloatManager$getShortTvEpisodeList$1.L$3 = null;
                                            shortTVFloatManager$getShortTvEpisodeList$1.L$4 = null;
                                            shortTVFloatManager$getShortTvEpisodeList$1.L$5 = null;
                                            shortTVFloatManager$getShortTvEpisodeList$1.label = 4;
                                            if (h.g(a2VarC2, shortTVFloatManager$getShortTvEpisodeList$1$3$1, shortTVFloatManager$getShortTvEpisodeList$1) == objE) {
                                                return objE;
                                            }
                                        }
                                    }
                                }
                            } else {
                                objA = obj2;
                                objM163constructorimpl = Result.m163constructorimpl((BaseDto) objA);
                                function1 = shortTVFloatManager$getShortTvEpisodeList$1.$callback;
                                if (Result.m170isSuccessimpl(objM163constructorimpl)) {
                                    a2VarC = w0.c();
                                    shortTVFloatManager$getShortTvEpisodeList$1$2$1 = new ShortTVFloatManager$getShortTvEpisodeList$1$2$1(i13, (BaseDto) objM163constructorimpl, function1, null);
                                    shortTVFloatManager$getShortTvEpisodeList$1.L$0 = objM163constructorimpl;
                                    shortTVFloatManager$getShortTvEpisodeList$1.L$1 = null;
                                    shortTVFloatManager$getShortTvEpisodeList$1.L$2 = null;
                                    shortTVFloatManager$getShortTvEpisodeList$1.L$3 = null;
                                    shortTVFloatManager$getShortTvEpisodeList$1.L$4 = null;
                                    shortTVFloatManager$getShortTvEpisodeList$1.L$5 = null;
                                    shortTVFloatManager$getShortTvEpisodeList$1.label = 3;
                                    if (h.g(a2VarC, shortTVFloatManager$getShortTvEpisodeList$1$2$1, shortTVFloatManager$getShortTvEpisodeList$1) == objE) {
                                        return objE;
                                    }
                                }
                                function2 = shortTVFloatManager$getShortTvEpisodeList$1.$callback;
                                if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                                    a2VarC2 = w0.c();
                                    shortTVFloatManager$getShortTvEpisodeList$1$3$1 = new ShortTVFloatManager$getShortTvEpisodeList$1$3$1(function2, null);
                                    shortTVFloatManager$getShortTvEpisodeList$1.L$0 = objM163constructorimpl;
                                    shortTVFloatManager$getShortTvEpisodeList$1.L$1 = null;
                                    shortTVFloatManager$getShortTvEpisodeList$1.L$2 = null;
                                    shortTVFloatManager$getShortTvEpisodeList$1.L$3 = null;
                                    shortTVFloatManager$getShortTvEpisodeList$1.L$4 = null;
                                    shortTVFloatManager$getShortTvEpisodeList$1.L$5 = null;
                                    shortTVFloatManager$getShortTvEpisodeList$1.label = 4;
                                    if (h.g(a2VarC2, shortTVFloatManager$getShortTvEpisodeList$1$3$1, shortTVFloatManager$getShortTvEpisodeList$1) == objE) {
                                        return objE;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion = Result.Companion;
                        objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                    }
                } else if (i12 == 3) {
                    objM163constructorimpl = this.L$0;
                    ResultKt.b(obj);
                    shortTVFloatManager$getShortTvEpisodeList$1 = this;
                    function2 = shortTVFloatManager$getShortTvEpisodeList$1.$callback;
                    if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                        a2VarC2 = w0.c();
                        shortTVFloatManager$getShortTvEpisodeList$1$3$1 = new ShortTVFloatManager$getShortTvEpisodeList$1$3$1(function2, null);
                        shortTVFloatManager$getShortTvEpisodeList$1.L$0 = objM163constructorimpl;
                        shortTVFloatManager$getShortTvEpisodeList$1.L$1 = null;
                        shortTVFloatManager$getShortTvEpisodeList$1.L$2 = null;
                        shortTVFloatManager$getShortTvEpisodeList$1.L$3 = null;
                        shortTVFloatManager$getShortTvEpisodeList$1.L$4 = null;
                        shortTVFloatManager$getShortTvEpisodeList$1.L$5 = null;
                        shortTVFloatManager$getShortTvEpisodeList$1.label = 4;
                        if (h.g(a2VarC2, shortTVFloatManager$getShortTvEpisodeList$1$3$1, shortTVFloatManager$getShortTvEpisodeList$1) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i12 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            int i14 = ((this.$selectEp - 1) / 20) * 20;
            int i15 = i14 + 1;
            uo.b.f78622a.c("VideoFloat", "getShortTvEpisodes start：" + i15 + "  ", true);
            String str6 = this.$subjectId;
            try {
                Result.Companion companion2 = Result.Companion;
                com.transsion.shorttv.episode.a aVarK = ShortTVFloatManager.f57884b.k();
                int i16 = i14 + 20;
                this.L$0 = str6;
                this.I$0 = i15;
                this.label = 1;
                str = str6;
                i11 = i15;
                try {
                    objA = com.transsion.shorttv.episode.a.C0597a.a(aVarK, str6, i15, i16, 0, null, this, 24, null);
                    if (objA == objE) {
                        return objE;
                    }
                    i13 = i11;
                } catch (Throwable th3) {
                    th = th3;
                    shortTVFloatManager$getShortTvEpisodeList$1 = this;
                    i13 = i11;
                    Result.Companion companion3 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                }
            } catch (Throwable th4) {
                th = th4;
                i11 = i15;
            }
            ShortTvInfoEpisodeList shortTvInfoEpisodeList = (ShortTvInfoEpisodeList) ((BaseDto) objA).getData();
            if (shortTvInfoEpisodeList == null || (items = shortTvInfoEpisodeList.getItems()) == null) {
                shortTVFloatManager$getShortTvEpisodeList$1 = this;
            } else {
                it = items.iterator();
                obj2 = objA;
                shortTVFloatManager$getShortTvEpisodeList$1 = this;
                str2 = str;
                while (true) {
                    if (it.hasNext()) {
                        ShortTVItem shortTVItem3 = (ShortTVItem) it.next();
                        int ep4 = shortTVItem3.getEp();
                        video = shortTVItem3.getVideo();
                        if (video == null) {
                        }
                    } else {
                        objA = obj2;
                    }
                }
            }
            objM163constructorimpl = Result.m163constructorimpl((BaseDto) objA);
        } catch (Throwable th5) {
            th = th5;
            shortTVFloatManager$getShortTvEpisodeList$1 = this;
        }
        function1 = shortTVFloatManager$getShortTvEpisodeList$1.$callback;
        if (Result.m170isSuccessimpl(objM163constructorimpl)) {
            a2VarC = w0.c();
            shortTVFloatManager$getShortTvEpisodeList$1$2$1 = new ShortTVFloatManager$getShortTvEpisodeList$1$2$1(i13, (BaseDto) objM163constructorimpl, function1, null);
            shortTVFloatManager$getShortTvEpisodeList$1.L$0 = objM163constructorimpl;
            shortTVFloatManager$getShortTvEpisodeList$1.L$1 = null;
            shortTVFloatManager$getShortTvEpisodeList$1.L$2 = null;
            shortTVFloatManager$getShortTvEpisodeList$1.L$3 = null;
            shortTVFloatManager$getShortTvEpisodeList$1.L$4 = null;
            shortTVFloatManager$getShortTvEpisodeList$1.L$5 = null;
            shortTVFloatManager$getShortTvEpisodeList$1.label = 3;
            if (h.g(a2VarC, shortTVFloatManager$getShortTvEpisodeList$1$2$1, shortTVFloatManager$getShortTvEpisodeList$1) == objE) {
                return objE;
            }
        }
        function2 = shortTVFloatManager$getShortTvEpisodeList$1.$callback;
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            a2VarC2 = w0.c();
            shortTVFloatManager$getShortTvEpisodeList$1$3$1 = new ShortTVFloatManager$getShortTvEpisodeList$1$3$1(function2, null);
            shortTVFloatManager$getShortTvEpisodeList$1.L$0 = objM163constructorimpl;
            shortTVFloatManager$getShortTvEpisodeList$1.L$1 = null;
            shortTVFloatManager$getShortTvEpisodeList$1.L$2 = null;
            shortTVFloatManager$getShortTvEpisodeList$1.L$3 = null;
            shortTVFloatManager$getShortTvEpisodeList$1.L$4 = null;
            shortTVFloatManager$getShortTvEpisodeList$1.L$5 = null;
            shortTVFloatManager$getShortTvEpisodeList$1.label = 4;
            if (h.g(a2VarC2, shortTVFloatManager$getShortTvEpisodeList$1$3$1, shortTVFloatManager$getShortTvEpisodeList$1) == objE) {
                return objE;
            }
        }
        return Unit.f68710a;
    }
}
