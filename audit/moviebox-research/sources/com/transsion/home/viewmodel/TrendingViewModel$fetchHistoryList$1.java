package com.transsion.home.viewmodel;

import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.j;
import kotlin.comparisons.b;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
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
@DebugMetadata(c = "com.transsion.home.viewmodel.TrendingViewModel$fetchHistoryList$1", f = "TrendingViewModel.kt", l = {223, 231}, m = "invokeSuspend")
@SourceDebugExtension
public final class TrendingViewModel$fetchHistoryList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TrendingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingViewModel$fetchHistoryList$1(TrendingViewModel trendingViewModel, Continuation<? super TrendingViewModel$fetchHistoryList$1> continuation) {
        super(2, continuation);
        this.this$0 = trendingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrendingViewModel$fetchHistoryList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TrendingViewModel$fetchHistoryList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:35:0x00db  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:50:0x010a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0116  */
    /* JADX WARN: Code duplicated, block: B:53:0x011b  */
    /* JADX WARN: Code duplicated, block: B:65:0x013e  */
    /* JADX WARN: Code duplicated, block: B:66:0x014c  */
    /* JADX WARN: Code duplicated, block: B:69:0x015b  */
    /* JADX WARN: Code duplicated, block: B:71:0x0167  */
    /* JADX WARN: Code duplicated, block: B:73:0x0173  */
    /* JADX WARN: Code duplicated, block: B:74:0x0178  */
    /* JADX WARN: Code duplicated, block: B:85:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f8 A[EDGE_INSN: B:88:0x00f8->B:47:0x00f8 BREAK  A[LOOP:0: B:31:0x00c7->B:92:0x00c7], SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list;
        List list2;
        ArrayList arrayList;
        Iterator it;
        String str;
        Subject subjectB;
        Cover cover;
        VideoDetailPlayBean videoDetailPlayBeanA;
        Cover cover2;
        String url;
        VideoDetailPlayBean videoDetailPlayBeanA2;
        String coverUrl;
        Object objE = a.e();
        int i11 = this.label;
        String averageHueLight = null;
        if (i11 != 0) {
            if (i11 == 1) {
                list = (List) this.L$0;
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list2 = (List) this.L$0;
                ResultKt.b(obj);
            }
            this.this$0.f52769s.clear();
            this.this$0.f52769s.addAll((List) obj);
            list = list2;
            arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            it = list.iterator();
            while (true) {
                str = "";
                if (it.hasNext()) {
                    break;
                }
                jt.a aVar = (jt.a) it.next();
                videoDetailPlayBeanA2 = aVar.a();
                if (videoDetailPlayBeanA2 != null) {
                    coverUrl = videoDetailPlayBeanA2.getCoverUrl();
                } else {
                    coverUrl = null;
                }
                if (coverUrl == null && coverUrl.length() != 0) {
                    if (linkedHashSet.add(coverUrl != null ? coverUrl : "")) {
                        arrayList.add(aVar);
                    }
                }
            }
            for (Subject subject : this.this$0.f52769s) {
                cover2 = subject.getCover();
                if (cover2 != null) {
                    url = cover2.getUrl();
                } else {
                    url = null;
                }
                if (url == null && url.length() != 0) {
                    if (url == null) {
                        url = "";
                    }
                    if (linkedHashSet.add(url)) {
                        arrayList.add(new jt.a(null, subject, 1, null));
                    }
                }
            }
            if (arrayList.size() > 10) {
                this.this$0.P().n(arrayList.subList(0, 10));
            } else {
                this.this$0.P().n(arrayList);
            }
            if (list.size() > 0) {
                if (((jt.a) list.get(0)).a() != null) {
                    videoDetailPlayBeanA = ((jt.a) list.get(0)).a();
                    if (videoDetailPlayBeanA != null) {
                        averageHueLight = videoDetailPlayBeanA.getAverageHueLight();
                    }
                } else {
                    subjectB = ((jt.a) list.get(0)).b();
                    if (subjectB != null && (cover = subjectB.getCover()) != null) {
                        averageHueLight = cover.getAverageHueLight();
                    }
                }
                str = averageHueLight;
            }
            if (str != null || str.length() == 0) {
                this.this$0.L().n("#323645");
            } else {
                this.this$0.L().n(str);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        long jO = this.this$0.O();
        ArrayList arrayList2 = new ArrayList();
        VideoDetailPlayDao videoDetailPlayDaoT = this.this$0.T();
        this.L$0 = arrayList2;
        this.label = 1;
        Object objM = videoDetailPlayDaoT.m(jO, this);
        if (objM == objE) {
            return objE;
        }
        list = arrayList2;
        obj = objM;
        List list3 = (List) obj;
        if (list3 != null) {
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                list.add(new jt.a((VideoDetailPlayBean) it2.next(), null, 2, null));
            }
        }
        if (list.size() > 1) {
            j.z(list, new Comparator() { // from class: com.transsion.home.viewmodel.TrendingViewModel$fetchHistoryList$1$invokeSuspend$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    VideoDetailPlayBean videoDetailPlayBeanA3 = ((jt.a) t12).a();
                    Long lValueOf = videoDetailPlayBeanA3 != null ? Long.valueOf(videoDetailPlayBeanA3.getTimeStamp()) : null;
                    VideoDetailPlayBean videoDetailPlayBeanA4 = ((jt.a) t11).a();
                    return b.d(lValueOf, videoDetailPlayBeanA4 != null ? Long.valueOf(videoDetailPlayBeanA4.getTimeStamp()) : null);
                }
            });
        }
        if (10 - list.size() > this.this$0.f52769s.size()) {
            TrendingViewModel trendingViewModel = this.this$0;
            int size = 10 - list.size();
            this.L$0 = list;
            this.label = 2;
            obj = trendingViewModel.K(size, this);
            if (obj == objE) {
                return objE;
            }
            list2 = list;
            this.this$0.f52769s.clear();
            this.this$0.f52769s.addAll((List) obj);
            list = list2;
        }
        arrayList = new ArrayList();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        it = list.iterator();
        while (true) {
            str = "";
            if (it.hasNext()) {
                break;
                break;
            }
            jt.a aVar2 = (jt.a) it.next();
            videoDetailPlayBeanA2 = aVar2.a();
            if (videoDetailPlayBeanA2 != null) {
                coverUrl = videoDetailPlayBeanA2.getCoverUrl();
            } else {
                coverUrl = null;
            }
            if (coverUrl == null) {
            }
        }
        while (r2.hasNext()) {
            cover2 = subject.getCover();
            if (cover2 != null) {
                url = cover2.getUrl();
            } else {
                url = null;
            }
            if (url == null) {
            }
        }
        if (arrayList.size() > 10) {
            this.this$0.P().n(arrayList.subList(0, 10));
        } else {
            this.this$0.P().n(arrayList);
        }
        if (list.size() > 0) {
            if (((jt.a) list.get(0)).a() != null) {
                videoDetailPlayBeanA = ((jt.a) list.get(0)).a();
                if (videoDetailPlayBeanA != null) {
                    averageHueLight = videoDetailPlayBeanA.getAverageHueLight();
                }
            } else {
                subjectB = ((jt.a) list.get(0)).b();
                if (subjectB != null) {
                    averageHueLight = cover.getAverageHueLight();
                }
            }
            str = averageHueLight;
        }
        if (str != null) {
            this.this$0.L().n("#323645");
        } else {
            this.this$0.L().n("#323645");
        }
        return Unit.f68710a;
    }
}
