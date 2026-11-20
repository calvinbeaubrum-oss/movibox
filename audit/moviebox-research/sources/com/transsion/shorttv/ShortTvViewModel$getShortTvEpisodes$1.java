package com.transsion.shorttv;

import androidx.lifecycle.c0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.ShortTVPlayBean;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.shorttv.favorite.IShortTvFavoriteProvider;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DownloadUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "com.transsion.shorttv.ShortTvViewModel$getShortTvEpisodes$1", f = "ShortTvViewModel.kt", l = {152, 171, 193, 213, 215, 230, 250, 256, 289}, m = "invokeSuspend")
@SourceDebugExtension
public final class ShortTvViewModel$getShortTvEpisodes$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $dataSource;
    final /* synthetic */ int $ep;
    final /* synthetic */ boolean $isHistoryFirst;
    final /* synthetic */ Subject $subject;
    final /* synthetic */ String $subjectId;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$getShortTvEpisodes$1(ShortTvViewModel shortTvViewModel, Integer num, String str, Subject subject, int i11, boolean z11, Continuation<? super ShortTvViewModel$getShortTvEpisodes$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTvViewModel;
        this.$dataSource = num;
        this.$subjectId = str;
        this.$subject = subject;
        this.$ep = i11;
        this.$isHistoryFirst = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvViewModel$getShortTvEpisodes$1(this.this$0, this.$dataSource, this.$subjectId, this.$subject, this.$ep, this.$isHistoryFirst, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvViewModel$getShortTvEpisodes$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0309  */
    /* JADX WARN: Code duplicated, block: B:102:0x030d  */
    /* JADX WARN: Code duplicated, block: B:104:0x0326 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:107:0x0331  */
    /* JADX WARN: Code duplicated, block: B:108:0x0338  */
    /* JADX WARN: Code duplicated, block: B:110:0x033b  */
    /* JADX WARN: Code duplicated, block: B:112:0x0347  */
    /* JADX WARN: Code duplicated, block: B:114:0x0357  */
    /* JADX WARN: Code duplicated, block: B:116:0x036c  */
    /* JADX WARN: Code duplicated, block: B:117:0x0375  */
    /* JADX WARN: Code duplicated, block: B:121:0x0398 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:122:0x0399  */
    /* JADX WARN: Code duplicated, block: B:125:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:127:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:137:0x0401  */
    /* JADX WARN: Code duplicated, block: B:141:0x040f  */
    /* JADX WARN: Code duplicated, block: B:147:0x0424  */
    /* JADX WARN: Code duplicated, block: B:149:0x0441  */
    /* JADX WARN: Code duplicated, block: B:150:0x0446  */
    /* JADX WARN: Code duplicated, block: B:154:0x0453  */
    /* JADX WARN: Code duplicated, block: B:157:0x045d  */
    /* JADX WARN: Code duplicated, block: B:158:0x045f  */
    /* JADX WARN: Code duplicated, block: B:160:0x0467  */
    /* JADX WARN: Code duplicated, block: B:162:0x047a  */
    /* JADX WARN: Code duplicated, block: B:163:0x047f  */
    /* JADX WARN: Code duplicated, block: B:166:0x0489  */
    /* JADX WARN: Code duplicated, block: B:167:0x048c  */
    /* JADX WARN: Code duplicated, block: B:170:0x0492  */
    /* JADX WARN: Code duplicated, block: B:171:0x0494  */
    /* JADX WARN: Code duplicated, block: B:174:0x049d A[LOOP:0: B:138:0x0402->B:174:0x049d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:177:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:179:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:182:0x04c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:183:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:186:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:189:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:196:0x0510 A[LOOP:2: B:194:0x050a->B:196:0x0510, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:202:0x04a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x041d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:37:0x014b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0150  */
    /* JADX WARN: Code duplicated, block: B:49:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:51:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:52:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:54:0x01f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:57:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:59:0x0229  */
    /* JADX WARN: Code duplicated, block: B:61:0x0244 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x0245  */
    /* JADX WARN: Code duplicated, block: B:65:0x026f  */
    /* JADX WARN: Code duplicated, block: B:68:0x028b  */
    /* JADX WARN: Code duplicated, block: B:70:0x028f  */
    /* JADX WARN: Code duplicated, block: B:71:0x0294  */
    /* JADX WARN: Code duplicated, block: B:74:0x0299  */
    /* JADX WARN: Code duplicated, block: B:80:0x02bd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x02de A[Catch: Exception -> 0x0060, TryCatch #0 {Exception -> 0x0060, blocks: (B:11:0x0059, B:86:0x02da, B:88:0x02de, B:91:0x02e7, B:93:0x02eb, B:95:0x02f1, B:96:0x0300, B:83:0x02c1, B:16:0x0065, B:81:0x02be, B:78:0x02a4), top: B:200:0x000e, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x02eb A[Catch: Exception -> 0x0060, TryCatch #0 {Exception -> 0x0060, blocks: (B:11:0x0059, B:86:0x02da, B:88:0x02de, B:91:0x02e7, B:93:0x02eb, B:95:0x02f1, B:96:0x0300, B:83:0x02c1, B:16:0x0065, B:81:0x02be, B:78:0x02a4), top: B:200:0x000e, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x02f0  */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x00c8, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objA;
        BaseDto baseDto;
        ?? r11;
        Subject subjectP;
        Subject subject;
        String ops;
        ?? r12;
        boolean z11;
        int totalEpisode;
        Object objC;
        boolean z12;
        int i11;
        Subject subject2;
        ShortTVFavInfo shortTVFavInfo;
        Boolean boolA;
        List list;
        List arrayList;
        Integer num;
        String str;
        Object objI;
        Subject subject3;
        List list2;
        int iB;
        String subjectId;
        Object objD;
        Subject subject4;
        int i12;
        Iterator it;
        Object next;
        ShortTVItem shortTVFirstEp;
        int i13;
        qx.d dVar;
        int downloadStatus;
        ShortTVItem shortTVItem;
        boolean z13;
        qx.d dVar2;
        int downloadStatus2;
        boolean z14;
        boolean zA;
        Object objD2;
        boolean z15;
        ShortTVPlayBean shortTVPlayBean;
        Integer numF;
        int iH;
        uo.b.a aVar;
        List arrayList2;
        Subject subject5;
        Trailer trailer;
        Subject subject6;
        ShortTVItem shortTVFirstEp2;
        qx.d dVar3;
        Subject subject7;
        Object objD3;
        List list3;
        Subject subject8;
        Object objI2;
        boolean z16;
        Object objQ;
        Subject subject9;
        List<Integer> unlockedEps;
        List<Integer> list4;
        Object objA2;
        boolean z17;
        boolean z18;
        DownloadBean downloadBean;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        boolean z19 = this.label;
        int i14 = 1;
        try {
            try {
                switch (z19) {
                    case 0:
                        ResultKt.b(obj);
                        zA = tp.e.f77259a.a(this.this$0.b());
                        Integer num2 = this.$dataSource;
                        z16 = zA;
                        if (num2 != null && num2.intValue() == -1) {
                            com.transsion.shorttv.episode.a aVarY = this.this$0.y();
                            String str2 = this.$subjectId;
                            this.Z$0 = zA;
                            this.label = 1;
                            objD2 = aVarY.d(str2, this);
                            if (objD2 == objE) {
                                z16 = zA;
                                z15 = zA;
                                return objE;
                            }
                            z16 = zA;
                            z15 = zA;
                            shortTVPlayBean = (ShortTVPlayBean) objD2;
                            if (shortTVPlayBean != null) {
                                uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "获取到历史：" + shortTVPlayBean, false, 4, null);
                                this.this$0.f57811s.q(shortTVPlayBean);
                            }
                            numF = this.this$0.v().f();
                            if (numF == null) {
                                numF = Boxing.d(-1);
                            }
                            int iIntValue = numF.intValue();
                            iH = this.this$0.y().h(iIntValue, shortTVPlayBean, this.$subject, this.$ep, this.$isHistoryFirst);
                            aVar = uo.b.f78622a;
                            uo.b.a.f(aVar, "ShortTvViewModel", "lastEp: " + iIntValue + ", historyItem: " + shortTVPlayBean + ", firstSelectEp:" + iH, false, 4, null);
                            arrayList2 = new ArrayList();
                            subject5 = this.$subject;
                            if (subject5 != null) {
                                trailer = subject5.getTrailer();
                            } else {
                                trailer = null;
                            }
                            if (trailer != null || this.$subject.getShortTVFirstEp() == null || !z15) {
                                this.this$0.f57813u.q(Boxing.a(false));
                                uo.b.a.f(aVar, "ShortTvViewModel", "不存在预告片", false, 4, null);
                                subject6 = this.$subject;
                                if (subject6 != null) {
                                    shortTVFirstEp2 = subject6.getShortTVFirstEp();
                                } else {
                                    shortTVFirstEp2 = null;
                                }
                                if (shortTVFirstEp2 != null && z15) {
                                    if (shortTVFirstEp2.getEp() == iH) {
                                        uo.b.a.f(aVar, "ShortTvViewModel", "需要预加载第一集", false, 4, null);
                                        dVar3 = new qx.d(this.$subjectId, shortTVFirstEp2.getEp(), shortTVFirstEp2, 0, 8, null);
                                        dVar3.g(true);
                                        if (this.$subject.getShortTVFavInfo() == null) {
                                            subject7 = this.$subject;
                                            IShortTvFavoriteProvider iShortTvFavoriteProviderB = this.this$0.B();
                                            String str3 = this.$subjectId;
                                            this.L$0 = arrayList2;
                                            this.L$1 = dVar3;
                                            this.L$2 = subject7;
                                            this.Z$0 = z15;
                                            this.label = 3;
                                            objD3 = iShortTvFavoriteProviderB.d(str3, this);
                                            if (objD3 == objE) {
                                                z15 = z15;
                                                return objE;
                                            }
                                            z15 = z15;
                                            list3 = arrayList2;
                                            subject8 = subject7;
                                            z17 = z15;
                                            subject8.setShortTVFavInfo((ShortTVFavInfo) objD3);
                                            arrayList2 = list3;
                                            z15 = z17;
                                        }
                                        z15 = z15;
                                        arrayList2.add(dVar3);
                                        this.this$0.f57795b.q(this.$subject);
                                        this.this$0.f57797d.q(arrayList2);
                                        this.this$0.A(this.$subjectId, 2);
                                    } else {
                                        uo.b.a.f(aVar, "ShortTvViewModel", "不需要预加载第一集", false, 4, null);
                                    }
                                }
                            } else if (iH == 0) {
                                uo.b.a.f(aVar, "ShortTvViewModel", "存在预告片 " + this.$subject.getTrailer(), false, 4, null);
                                ShortTvViewModel shortTvViewModel = this.this$0;
                                String str4 = this.$subjectId;
                                Subject subject10 = this.$subject;
                                this.L$0 = arrayList2;
                                this.Z$0 = z15;
                                this.label = 2;
                                objI2 = shortTvViewModel.I(str4, subject10, this);
                                if (objI2 == objE) {
                                    z15 = z15;
                                    return objE;
                                }
                                z15 = z15;
                                arrayList2.add((qx.d) objI2);
                                this.this$0.f57813u.q(Boxing.a(true));
                                this.this$0.f57795b.q(this.$subject);
                                this.this$0.f57797d.q(arrayList2);
                            } else {
                                uo.b.a.f(aVar, "ShortTvViewModel", "不需要加载预告片", false, 4, null);
                            }
                            this.this$0.D.q(Boxing.d(0));
                            z16 = z15;
                            if (z16) {
                                subject9 = this.$subject;
                                if (subject9 != null) {
                                    unlockedEps = subject9.getUnlockedEps();
                                } else {
                                    unlockedEps = null;
                                }
                                list4 = unlockedEps;
                                if (list4 != null || list4.isEmpty()) {
                                    qx.b bVarD = this.this$0.D();
                                    String str5 = this.$subjectId;
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.Z$0 = z16;
                                    this.label = 4;
                                    objA2 = bVarD.a(str5, this);
                                    z19 = z16;
                                    if (objA2 == objE) {
                                        return objE;
                                    }
                                    baseDto = (BaseDto) objA2;
                                    r11 = z19;
                                    if (baseDto != null && (subjectP = (Subject) baseDto.getData()) != null) {
                                        subject = this.$subject;
                                        if (subject != null) {
                                            ops = subject.getOps();
                                        } else {
                                            ops = null;
                                        }
                                        subjectP.setOps(ops);
                                        this.this$0.R(this.$subjectId, subjectP.getShortTVFavInfo());
                                        z11 = r11;
                                    }
                                    return Unit.f68710a;
                                }
                                subjectP = this.$subject;
                            } else {
                                subjectP = this.$subject;
                                if (subjectP == null) {
                                    DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
                                    String str6 = this.$subjectId;
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.Z$0 = z16;
                                    this.label = 6;
                                    objQ = downloadEsHelperA.q(str6, this);
                                    if (objQ == objE) {
                                        z11 = z16;
                                        z18 = z16;
                                        return objE;
                                    }
                                    z11 = z16;
                                    z18 = z16;
                                    downloadBean = (DownloadBean) CollectionsKt___CollectionsKt.g0((List) objQ);
                                    if (downloadBean != null) {
                                        subjectP = DownloadUtil.f61136a.p(downloadBean);
                                    } else {
                                        subjectP = null;
                                    }
                                }
                            }
                        } else {
                            if (z16) {
                                subject9 = this.$subject;
                                if (subject9 != null) {
                                    unlockedEps = subject9.getUnlockedEps();
                                } else {
                                    unlockedEps = null;
                                }
                                list4 = unlockedEps;
                                if (list4 != null) {
                                }
                                qx.b bVarD2 = this.this$0.D();
                                String str7 = this.$subjectId;
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.Z$0 = z16;
                                this.label = 4;
                                objA2 = bVarD2.a(str7, this);
                                z19 = z16;
                                if (objA2 == objE) {
                                    return objE;
                                }
                                baseDto = (BaseDto) objA2;
                                r11 = z19;
                                if (baseDto != null) {
                                    subject = this.$subject;
                                    if (subject != null) {
                                        ops = subject.getOps();
                                    } else {
                                        ops = null;
                                    }
                                    subjectP.setOps(ops);
                                    this.this$0.R(this.$subjectId, subjectP.getShortTVFavInfo());
                                    z11 = r11;
                                }
                                return Unit.f68710a;
                            }
                            subjectP = this.$subject;
                            if (subjectP == null) {
                                DownloadEsHelper downloadEsHelperA2 = DownloadEsHelper.f60994m.a();
                                String str8 = this.$subjectId;
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.Z$0 = z16;
                                this.label = 6;
                                objQ = downloadEsHelperA2.q(str8, this);
                                if (objQ == objE) {
                                    z11 = z16;
                                    z18 = z16;
                                    return objE;
                                }
                                z11 = z16;
                                z18 = z16;
                                downloadBean = (DownloadBean) CollectionsKt___CollectionsKt.g0((List) objQ);
                                if (downloadBean != null) {
                                    subjectP = DownloadUtil.f61136a.p(downloadBean);
                                } else {
                                    subjectP = null;
                                }
                            }
                        }
                        if (subjectP == null) {
                            z11 = z16;
                            z11 = z18;
                            z11 = z18;
                            this.this$0.f57795b.q(null);
                            return Unit.f68710a;
                        }
                        z11 = z16;
                        z11 = z18;
                        if (!Intrinsics.b(subjectP, this.this$0.f57795b.f())) {
                            this.this$0.f57795b.q(subjectP);
                            c0 c0Var = this.this$0.f57805m;
                            shortTVFavInfo = subjectP.getShortTVFavInfo();
                            if (shortTVFavInfo != null) {
                                z11 = z18;
                                boolA = Boxing.a(shortTVFavInfo.getHasFavorite());
                            } else {
                                z11 = z18;
                                boolA = null;
                            }
                            c0Var.q(boolA);
                        }
                        z11 = z18;
                        totalEpisode = subjectP.getTotalEpisode();
                        ox.a aVarW = this.this$0.w();
                        String str9 = this.$subjectId;
                        this.L$0 = subjectP;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.Z$0 = z11;
                        this.I$0 = totalEpisode;
                        this.label = 7;
                        objC = aVarW.c(str9, this);
                        if (objC == objE) {
                            return objE;
                        }
                        Subject subject11 = subjectP;
                        z12 = z11;
                        i11 = totalEpisode;
                        subject2 = subject11;
                        list = (List) objC;
                        arrayList = new ArrayList();
                        if (z12) {
                            if (subject2.getTrailer() != null || subject2.getShortTVFirstEp() == null) {
                                this.this$0.f57813u.q(Boxing.a(false));
                            } else {
                                this.this$0.f57813u.q(Boxing.a(true));
                                ShortTvViewModel shortTvViewModel2 = this.this$0;
                                String str10 = this.$subjectId;
                                this.L$0 = subject2;
                                this.L$1 = list;
                                this.L$2 = arrayList;
                                this.I$0 = i11;
                                this.label = 8;
                                objI = shortTvViewModel2.I(str10, subject2, this);
                                if (objI == objE) {
                                    return objE;
                                }
                                subject3 = subject2;
                                list2 = list;
                                arrayList.add((qx.d) objI);
                                Subject subject12 = subject3;
                                list = list2;
                                subject2 = subject12;
                            }
                            iB = this.this$0.E().b(subject2);
                            if (1 <= i11) {
                                i12 = 1;
                                while (true) {
                                    it = list.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = it.next();
                                        } else {
                                            next = null;
                                        }
                                        shortTVFirstEp = (ShortTVItem) next;
                                        if (i12 == i14) {
                                            i13 = i12;
                                            dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus2 = 0;
                                            }
                                            dVar2.f(downloadStatus2);
                                            if (dVar2.a() != 5) {
                                                shortTVFirstEp = subject2.getShortTVFirstEp();
                                            }
                                            dVar2.h(shortTVFirstEp);
                                            if (i13 <= iB) {
                                                z14 = true;
                                            } else {
                                                z14 = false;
                                            }
                                            dVar2.g(z14);
                                            arrayList.add(dVar2);
                                        } else {
                                            i13 = i12;
                                            dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus = 0;
                                            }
                                            dVar.f(downloadStatus);
                                            if (dVar.a() == 5) {
                                                shortTVItem = shortTVFirstEp;
                                            } else {
                                                shortTVItem = null;
                                            }
                                            dVar.h(shortTVItem);
                                            if (i13 <= iB) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            dVar.g(z13);
                                            arrayList.add(dVar);
                                        }
                                        if (i13 != i11) {
                                            i12 = i13 + 1;
                                            i14 = 1;
                                        }
                                    } while (((ShortTVItem) next).getEp() != i12);
                                    shortTVFirstEp = (ShortTVItem) next;
                                    if (i12 == i14) {
                                        i13 = i12;
                                        dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus2 = 0;
                                        }
                                        dVar2.f(downloadStatus2);
                                        if (dVar2.a() != 5) {
                                            shortTVFirstEp = subject2.getShortTVFirstEp();
                                        }
                                        dVar2.h(shortTVFirstEp);
                                        if (i13 <= iB) {
                                            z14 = true;
                                        } else {
                                            z14 = false;
                                        }
                                        dVar2.g(z14);
                                        arrayList.add(dVar2);
                                    } else {
                                        i13 = i12;
                                        dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus = 0;
                                        }
                                        dVar.f(downloadStatus);
                                        if (dVar.a() == 5) {
                                            shortTVItem = shortTVFirstEp;
                                        } else {
                                            shortTVItem = null;
                                        }
                                        dVar.h(shortTVItem);
                                        if (i13 <= iB) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        dVar.g(z13);
                                        arrayList.add(dVar);
                                    }
                                    if (i13 != i11) {
                                        i12 = i13 + 1;
                                        i14 = 1;
                                    }
                                }
                            }
                            if (subject2.getShortTVFavInfo() == null) {
                                IShortTvFavoriteProvider iShortTvFavoriteProviderB2 = this.this$0.B();
                                subjectId = subject2.getSubjectId();
                                if (subjectId == null) {
                                    subjectId = "";
                                }
                                this.L$0 = arrayList;
                                this.L$1 = subject2;
                                this.L$2 = null;
                                this.label = 9;
                                objD = iShortTvFavoriteProviderB2.d(subjectId, this);
                                if (objD == objE) {
                                    return objE;
                                }
                                subject4 = subject2;
                                subject4.setShortTVFavInfo((ShortTVFavInfo) objD);
                            }
                            this.this$0.D.q(Boxing.d(2));
                        } else {
                            num = this.$dataSource;
                            if (num != null && num.intValue() == 1) {
                                return Unit.f68710a;
                            }
                            uo.b.a.f(uo.b.f78622a, "getShortTvEpisodes", "无网，显示下载数据", false, 4, null);
                            List<ShortTVItem> listE0 = CollectionsKt___CollectionsKt.E0(list, new Comparator() { // from class: com.transsion.shorttv.ShortTvViewModel$getShortTvEpisodes$1$invokeSuspend$$inlined$sortedBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t11, T t12) {
                                    return kotlin.comparisons.b.d(Integer.valueOf(((ShortTVItem) t11).getEp()), Integer.valueOf(((ShortTVItem) t12).getEp()));
                                }
                            });
                            str = this.$subjectId;
                            for (ShortTVItem shortTVItem2 : listE0) {
                                qx.d dVar4 = new qx.d(str, shortTVItem2.getEp(), null, 0, 12, null);
                                dVar4.f(shortTVItem2.getDownloadStatus());
                                dVar4.h(shortTVItem2);
                                dVar4.g(true);
                                arrayList.add(dVar4);
                            }
                            this.this$0.D.q(Boxing.d(1));
                        }
                        this.this$0.f57797d.q(arrayList);
                        return Unit.f68710a;
                    case 1:
                        boolean z21 = this.Z$0;
                        ResultKt.b(obj);
                        objD2 = obj;
                        z15 = z21;
                        z16 = zA;
                        z15 = zA;
                        shortTVPlayBean = (ShortTVPlayBean) objD2;
                        if (shortTVPlayBean != null) {
                            uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "获取到历史：" + shortTVPlayBean, false, 4, null);
                            this.this$0.f57811s.q(shortTVPlayBean);
                        }
                        numF = this.this$0.v().f();
                        if (numF == null) {
                            numF = Boxing.d(-1);
                        }
                        int iIntValue2 = numF.intValue();
                        iH = this.this$0.y().h(iIntValue2, shortTVPlayBean, this.$subject, this.$ep, this.$isHistoryFirst);
                        aVar = uo.b.f78622a;
                        uo.b.a.f(aVar, "ShortTvViewModel", "lastEp: " + iIntValue2 + ", historyItem: " + shortTVPlayBean + ", firstSelectEp:" + iH, false, 4, null);
                        arrayList2 = new ArrayList();
                        subject5 = this.$subject;
                        if (subject5 != null) {
                            trailer = subject5.getTrailer();
                        } else {
                            trailer = null;
                        }
                        if (trailer != null) {
                            this.this$0.f57813u.q(Boxing.a(false));
                            uo.b.a.f(aVar, "ShortTvViewModel", "不存在预告片", false, 4, null);
                            subject6 = this.$subject;
                            if (subject6 != null) {
                                shortTVFirstEp2 = subject6.getShortTVFirstEp();
                            } else {
                                shortTVFirstEp2 = null;
                            }
                            if (shortTVFirstEp2 != null) {
                                if (shortTVFirstEp2.getEp() == iH) {
                                    uo.b.a.f(aVar, "ShortTvViewModel", "需要预加载第一集", false, 4, null);
                                    dVar3 = new qx.d(this.$subjectId, shortTVFirstEp2.getEp(), shortTVFirstEp2, 0, 8, null);
                                    dVar3.g(true);
                                    if (this.$subject.getShortTVFavInfo() == null) {
                                        subject7 = this.$subject;
                                        IShortTvFavoriteProvider iShortTvFavoriteProviderB3 = this.this$0.B();
                                        String str11 = this.$subjectId;
                                        this.L$0 = arrayList2;
                                        this.L$1 = dVar3;
                                        this.L$2 = subject7;
                                        this.Z$0 = z15;
                                        this.label = 3;
                                        objD3 = iShortTvFavoriteProviderB3.d(str11, this);
                                        if (objD3 == objE) {
                                            z15 = z15;
                                            return objE;
                                        }
                                        z15 = z15;
                                        list3 = arrayList2;
                                        subject8 = subject7;
                                        z17 = z15;
                                        subject8.setShortTVFavInfo((ShortTVFavInfo) objD3);
                                        arrayList2 = list3;
                                        z15 = z17;
                                    }
                                    z15 = z15;
                                    arrayList2.add(dVar3);
                                    this.this$0.f57795b.q(this.$subject);
                                    this.this$0.f57797d.q(arrayList2);
                                    this.this$0.A(this.$subjectId, 2);
                                } else {
                                    uo.b.a.f(aVar, "ShortTvViewModel", "不需要预加载第一集", false, 4, null);
                                }
                            }
                        } else {
                            this.this$0.f57813u.q(Boxing.a(false));
                            uo.b.a.f(aVar, "ShortTvViewModel", "不存在预告片", false, 4, null);
                            subject6 = this.$subject;
                            if (subject6 != null) {
                                shortTVFirstEp2 = subject6.getShortTVFirstEp();
                            } else {
                                shortTVFirstEp2 = null;
                            }
                            if (shortTVFirstEp2 != null) {
                                if (shortTVFirstEp2.getEp() == iH) {
                                    uo.b.a.f(aVar, "ShortTvViewModel", "需要预加载第一集", false, 4, null);
                                    dVar3 = new qx.d(this.$subjectId, shortTVFirstEp2.getEp(), shortTVFirstEp2, 0, 8, null);
                                    dVar3.g(true);
                                    if (this.$subject.getShortTVFavInfo() == null) {
                                        subject7 = this.$subject;
                                        IShortTvFavoriteProvider iShortTvFavoriteProviderB4 = this.this$0.B();
                                        String str12 = this.$subjectId;
                                        this.L$0 = arrayList2;
                                        this.L$1 = dVar3;
                                        this.L$2 = subject7;
                                        this.Z$0 = z15;
                                        this.label = 3;
                                        objD3 = iShortTvFavoriteProviderB4.d(str12, this);
                                        if (objD3 == objE) {
                                            z15 = z15;
                                            return objE;
                                        }
                                        z15 = z15;
                                        list3 = arrayList2;
                                        subject8 = subject7;
                                        z17 = z15;
                                        subject8.setShortTVFavInfo((ShortTVFavInfo) objD3);
                                        arrayList2 = list3;
                                        z15 = z17;
                                    }
                                    z15 = z15;
                                    arrayList2.add(dVar3);
                                    this.this$0.f57795b.q(this.$subject);
                                    this.this$0.f57797d.q(arrayList2);
                                    this.this$0.A(this.$subjectId, 2);
                                } else {
                                    uo.b.a.f(aVar, "ShortTvViewModel", "不需要预加载第一集", false, 4, null);
                                }
                            }
                        }
                        this.this$0.D.q(Boxing.d(0));
                        z16 = z15;
                        if (z16) {
                            subject9 = this.$subject;
                            if (subject9 != null) {
                                unlockedEps = subject9.getUnlockedEps();
                            } else {
                                unlockedEps = null;
                            }
                            list4 = unlockedEps;
                            if (list4 != null) {
                                break;
                            }
                            qx.b bVarD3 = this.this$0.D();
                            String str13 = this.$subjectId;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.Z$0 = z16;
                            this.label = 4;
                            objA2 = bVarD3.a(str13, this);
                            z19 = z16;
                            if (objA2 == objE) {
                                return objE;
                            }
                            baseDto = (BaseDto) objA2;
                            r11 = z19;
                            if (baseDto != null) {
                                subject = this.$subject;
                                if (subject != null) {
                                    ops = subject.getOps();
                                } else {
                                    ops = null;
                                }
                                subjectP.setOps(ops);
                                this.this$0.R(this.$subjectId, subjectP.getShortTVFavInfo());
                                z11 = r11;
                            }
                            return Unit.f68710a;
                        }
                        subjectP = this.$subject;
                        if (subjectP == null) {
                            DownloadEsHelper downloadEsHelperA3 = DownloadEsHelper.f60994m.a();
                            String str14 = this.$subjectId;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.Z$0 = z16;
                            this.label = 6;
                            objQ = downloadEsHelperA3.q(str14, this);
                            if (objQ == objE) {
                                z11 = z16;
                                z18 = z16;
                                return objE;
                            }
                            z11 = z16;
                            z18 = z16;
                            downloadBean = (DownloadBean) CollectionsKt___CollectionsKt.g0((List) objQ);
                            if (downloadBean != null) {
                                subjectP = DownloadUtil.f61136a.p(downloadBean);
                            } else {
                                subjectP = null;
                            }
                        }
                        if (subjectP == null) {
                            z11 = z16;
                            z11 = z18;
                            z11 = z18;
                            this.this$0.f57795b.q(null);
                            return Unit.f68710a;
                        }
                        z11 = z16;
                        z11 = z18;
                        if (!Intrinsics.b(subjectP, this.this$0.f57795b.f())) {
                            this.this$0.f57795b.q(subjectP);
                            c0 c0Var2 = this.this$0.f57805m;
                            shortTVFavInfo = subjectP.getShortTVFavInfo();
                            if (shortTVFavInfo != null) {
                                z11 = z18;
                                boolA = Boxing.a(shortTVFavInfo.getHasFavorite());
                            } else {
                                z11 = z18;
                                boolA = null;
                            }
                            c0Var2.q(boolA);
                        }
                        z11 = z18;
                        totalEpisode = subjectP.getTotalEpisode();
                        ox.a aVarW2 = this.this$0.w();
                        String str15 = this.$subjectId;
                        this.L$0 = subjectP;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.Z$0 = z11;
                        this.I$0 = totalEpisode;
                        this.label = 7;
                        objC = aVarW2.c(str15, this);
                        if (objC == objE) {
                            return objE;
                        }
                        Subject subject13 = subjectP;
                        z12 = z11;
                        i11 = totalEpisode;
                        subject2 = subject13;
                        list = (List) objC;
                        arrayList = new ArrayList();
                        if (z12) {
                            if (subject2.getTrailer() != null) {
                            }
                            this.this$0.f57813u.q(Boxing.a(false));
                            iB = this.this$0.E().b(subject2);
                            if (1 <= i11) {
                                i12 = 1;
                                while (true) {
                                    it = list.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = it.next();
                                        } else {
                                            next = null;
                                        }
                                        shortTVFirstEp = (ShortTVItem) next;
                                        if (i12 == i14) {
                                            i13 = i12;
                                            dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus2 = 0;
                                            }
                                            dVar2.f(downloadStatus2);
                                            if (dVar2.a() != 5) {
                                                shortTVFirstEp = subject2.getShortTVFirstEp();
                                            }
                                            dVar2.h(shortTVFirstEp);
                                            if (i13 <= iB) {
                                                z14 = true;
                                            } else {
                                                z14 = false;
                                            }
                                            dVar2.g(z14);
                                            arrayList.add(dVar2);
                                        } else {
                                            i13 = i12;
                                            dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus = 0;
                                            }
                                            dVar.f(downloadStatus);
                                            if (dVar.a() == 5) {
                                                shortTVItem = shortTVFirstEp;
                                            } else {
                                                shortTVItem = null;
                                            }
                                            dVar.h(shortTVItem);
                                            if (i13 <= iB) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            dVar.g(z13);
                                            arrayList.add(dVar);
                                        }
                                        if (i13 != i11) {
                                            i12 = i13 + 1;
                                            i14 = 1;
                                        }
                                    } while (((ShortTVItem) next).getEp() != i12);
                                    shortTVFirstEp = (ShortTVItem) next;
                                    if (i12 == i14) {
                                        i13 = i12;
                                        dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus2 = 0;
                                        }
                                        dVar2.f(downloadStatus2);
                                        if (dVar2.a() != 5) {
                                            shortTVFirstEp = subject2.getShortTVFirstEp();
                                        }
                                        dVar2.h(shortTVFirstEp);
                                        if (i13 <= iB) {
                                            z14 = true;
                                        } else {
                                            z14 = false;
                                        }
                                        dVar2.g(z14);
                                        arrayList.add(dVar2);
                                    } else {
                                        i13 = i12;
                                        dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus = 0;
                                        }
                                        dVar.f(downloadStatus);
                                        if (dVar.a() == 5) {
                                            shortTVItem = shortTVFirstEp;
                                        } else {
                                            shortTVItem = null;
                                        }
                                        dVar.h(shortTVItem);
                                        if (i13 <= iB) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        dVar.g(z13);
                                        arrayList.add(dVar);
                                    }
                                    if (i13 != i11) {
                                        i12 = i13 + 1;
                                        i14 = 1;
                                    }
                                }
                            }
                            if (subject2.getShortTVFavInfo() == null) {
                                IShortTvFavoriteProvider iShortTvFavoriteProviderB5 = this.this$0.B();
                                subjectId = subject2.getSubjectId();
                                if (subjectId == null) {
                                    subjectId = "";
                                }
                                this.L$0 = arrayList;
                                this.L$1 = subject2;
                                this.L$2 = null;
                                this.label = 9;
                                objD = iShortTvFavoriteProviderB5.d(subjectId, this);
                                if (objD == objE) {
                                    return objE;
                                }
                                subject4 = subject2;
                                subject4.setShortTVFavInfo((ShortTVFavInfo) objD);
                            }
                            this.this$0.D.q(Boxing.d(2));
                            break;
                        } else {
                            num = this.$dataSource;
                            if (num != null) {
                                return Unit.f68710a;
                            }
                            uo.b.a.f(uo.b.f78622a, "getShortTvEpisodes", "无网，显示下载数据", false, 4, null);
                            List<ShortTVItem> listE1 = CollectionsKt___CollectionsKt.E0(list, new Comparator() { // from class: com.transsion.shorttv.ShortTvViewModel$getShortTvEpisodes$1$invokeSuspend$$inlined$sortedBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t11, T t12) {
                                    return kotlin.comparisons.b.d(Integer.valueOf(((ShortTVItem) t11).getEp()), Integer.valueOf(((ShortTVItem) t12).getEp()));
                                }
                            });
                            str = this.$subjectId;
                            while (r0.hasNext()) {
                                qx.d dVar5 = new qx.d(str, shortTVItem2.getEp(), null, 0, 12, null);
                                dVar5.f(shortTVItem2.getDownloadStatus());
                                dVar5.h(shortTVItem2);
                                dVar5.g(true);
                                arrayList.add(dVar5);
                            }
                            this.this$0.D.q(Boxing.d(1));
                        }
                        this.this$0.f57797d.q(arrayList);
                        return Unit.f68710a;
                    case 2:
                        boolean z22 = this.Z$0;
                        arrayList2 = (List) this.L$0;
                        ResultKt.b(obj);
                        objI2 = obj;
                        z15 = z22;
                        z15 = z15;
                        arrayList2.add((qx.d) objI2);
                        this.this$0.f57813u.q(Boxing.a(true));
                        this.this$0.f57795b.q(this.$subject);
                        this.this$0.f57797d.q(arrayList2);
                        this.this$0.D.q(Boxing.d(0));
                        z16 = z15;
                        if (z16) {
                            subject9 = this.$subject;
                            if (subject9 != null) {
                                unlockedEps = subject9.getUnlockedEps();
                            } else {
                                unlockedEps = null;
                            }
                            list4 = unlockedEps;
                            if (list4 != null) {
                                break;
                            }
                            qx.b bVarD4 = this.this$0.D();
                            String str16 = this.$subjectId;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.Z$0 = z16;
                            this.label = 4;
                            objA2 = bVarD4.a(str16, this);
                            z19 = z16;
                            if (objA2 == objE) {
                                return objE;
                            }
                            baseDto = (BaseDto) objA2;
                            r11 = z19;
                            if (baseDto != null) {
                                subject = this.$subject;
                                if (subject != null) {
                                    ops = subject.getOps();
                                } else {
                                    ops = null;
                                }
                                subjectP.setOps(ops);
                                this.this$0.R(this.$subjectId, subjectP.getShortTVFavInfo());
                                z11 = r11;
                            }
                            return Unit.f68710a;
                        }
                        subjectP = this.$subject;
                        if (subjectP == null) {
                            DownloadEsHelper downloadEsHelperA4 = DownloadEsHelper.f60994m.a();
                            String str17 = this.$subjectId;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.Z$0 = z16;
                            this.label = 6;
                            objQ = downloadEsHelperA4.q(str17, this);
                            if (objQ == objE) {
                                z11 = z16;
                                z18 = z16;
                                return objE;
                            }
                            z11 = z16;
                            z18 = z16;
                            downloadBean = (DownloadBean) CollectionsKt___CollectionsKt.g0((List) objQ);
                            if (downloadBean != null) {
                                subjectP = DownloadUtil.f61136a.p(downloadBean);
                            } else {
                                subjectP = null;
                            }
                        }
                        if (subjectP == null) {
                            z11 = z16;
                            z11 = z18;
                            z11 = z18;
                            this.this$0.f57795b.q(null);
                            return Unit.f68710a;
                        }
                        z11 = z16;
                        z11 = z18;
                        if (!Intrinsics.b(subjectP, this.this$0.f57795b.f())) {
                            this.this$0.f57795b.q(subjectP);
                            c0 c0Var3 = this.this$0.f57805m;
                            shortTVFavInfo = subjectP.getShortTVFavInfo();
                            if (shortTVFavInfo != null) {
                                z11 = z18;
                                boolA = Boxing.a(shortTVFavInfo.getHasFavorite());
                            } else {
                                z11 = z18;
                                boolA = null;
                            }
                            c0Var3.q(boolA);
                        }
                        z11 = z18;
                        totalEpisode = subjectP.getTotalEpisode();
                        ox.a aVarW3 = this.this$0.w();
                        String str18 = this.$subjectId;
                        this.L$0 = subjectP;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.Z$0 = z11;
                        this.I$0 = totalEpisode;
                        this.label = 7;
                        objC = aVarW3.c(str18, this);
                        if (objC == objE) {
                            return objE;
                        }
                        Subject subject14 = subjectP;
                        z12 = z11;
                        i11 = totalEpisode;
                        subject2 = subject14;
                        list = (List) objC;
                        arrayList = new ArrayList();
                        if (z12) {
                            if (subject2.getTrailer() != null) {
                            }
                            this.this$0.f57813u.q(Boxing.a(false));
                            iB = this.this$0.E().b(subject2);
                            if (1 <= i11) {
                                i12 = 1;
                                while (true) {
                                    it = list.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = it.next();
                                        } else {
                                            next = null;
                                        }
                                        shortTVFirstEp = (ShortTVItem) next;
                                        if (i12 == i14) {
                                            i13 = i12;
                                            dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus2 = 0;
                                            }
                                            dVar2.f(downloadStatus2);
                                            if (dVar2.a() != 5) {
                                                shortTVFirstEp = subject2.getShortTVFirstEp();
                                            }
                                            dVar2.h(shortTVFirstEp);
                                            if (i13 <= iB) {
                                                z14 = true;
                                            } else {
                                                z14 = false;
                                            }
                                            dVar2.g(z14);
                                            arrayList.add(dVar2);
                                        } else {
                                            i13 = i12;
                                            dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus = 0;
                                            }
                                            dVar.f(downloadStatus);
                                            if (dVar.a() == 5) {
                                                shortTVItem = shortTVFirstEp;
                                            } else {
                                                shortTVItem = null;
                                            }
                                            dVar.h(shortTVItem);
                                            if (i13 <= iB) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            dVar.g(z13);
                                            arrayList.add(dVar);
                                        }
                                        if (i13 != i11) {
                                            i12 = i13 + 1;
                                            i14 = 1;
                                        }
                                    } while (((ShortTVItem) next).getEp() != i12);
                                    shortTVFirstEp = (ShortTVItem) next;
                                    if (i12 == i14) {
                                        i13 = i12;
                                        dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus2 = 0;
                                        }
                                        dVar2.f(downloadStatus2);
                                        if (dVar2.a() != 5) {
                                            shortTVFirstEp = subject2.getShortTVFirstEp();
                                        }
                                        dVar2.h(shortTVFirstEp);
                                        if (i13 <= iB) {
                                            z14 = true;
                                        } else {
                                            z14 = false;
                                        }
                                        dVar2.g(z14);
                                        arrayList.add(dVar2);
                                    } else {
                                        i13 = i12;
                                        dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus = 0;
                                        }
                                        dVar.f(downloadStatus);
                                        if (dVar.a() == 5) {
                                            shortTVItem = shortTVFirstEp;
                                        } else {
                                            shortTVItem = null;
                                        }
                                        dVar.h(shortTVItem);
                                        if (i13 <= iB) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        dVar.g(z13);
                                        arrayList.add(dVar);
                                    }
                                    if (i13 != i11) {
                                        i12 = i13 + 1;
                                        i14 = 1;
                                    }
                                }
                            }
                            if (subject2.getShortTVFavInfo() == null) {
                                IShortTvFavoriteProvider iShortTvFavoriteProviderB6 = this.this$0.B();
                                subjectId = subject2.getSubjectId();
                                if (subjectId == null) {
                                    subjectId = "";
                                }
                                this.L$0 = arrayList;
                                this.L$1 = subject2;
                                this.L$2 = null;
                                this.label = 9;
                                objD = iShortTvFavoriteProviderB6.d(subjectId, this);
                                if (objD == objE) {
                                    return objE;
                                }
                                subject4 = subject2;
                                subject4.setShortTVFavInfo((ShortTVFavInfo) objD);
                            }
                            this.this$0.D.q(Boxing.d(2));
                            break;
                        } else {
                            num = this.$dataSource;
                            if (num != null) {
                                return Unit.f68710a;
                            }
                            uo.b.a.f(uo.b.f78622a, "getShortTvEpisodes", "无网，显示下载数据", false, 4, null);
                            List<ShortTVItem> listE2 = CollectionsKt___CollectionsKt.E0(list, new Comparator() { // from class: com.transsion.shorttv.ShortTvViewModel$getShortTvEpisodes$1$invokeSuspend$$inlined$sortedBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t11, T t12) {
                                    return kotlin.comparisons.b.d(Integer.valueOf(((ShortTVItem) t11).getEp()), Integer.valueOf(((ShortTVItem) t12).getEp()));
                                }
                            });
                            str = this.$subjectId;
                            while (r0.hasNext()) {
                                qx.d dVar6 = new qx.d(str, shortTVItem2.getEp(), null, 0, 12, null);
                                dVar6.f(shortTVItem2.getDownloadStatus());
                                dVar6.h(shortTVItem2);
                                dVar6.g(true);
                                arrayList.add(dVar6);
                            }
                            this.this$0.D.q(Boxing.d(1));
                        }
                        this.this$0.f57797d.q(arrayList);
                        return Unit.f68710a;
                    case 3:
                        boolean z23 = this.Z$0;
                        subject8 = (Subject) this.L$2;
                        dVar3 = (qx.d) this.L$1;
                        list3 = (List) this.L$0;
                        ResultKt.b(obj);
                        objD3 = obj;
                        z17 = z23;
                        subject8.setShortTVFavInfo((ShortTVFavInfo) objD3);
                        arrayList2 = list3;
                        z15 = z17;
                        z15 = z15;
                        arrayList2.add(dVar3);
                        this.this$0.f57795b.q(this.$subject);
                        this.this$0.f57797d.q(arrayList2);
                        this.this$0.A(this.$subjectId, 2);
                        this.this$0.D.q(Boxing.d(0));
                        z16 = z15;
                        if (z16) {
                            subject9 = this.$subject;
                            if (subject9 != null) {
                                unlockedEps = subject9.getUnlockedEps();
                            } else {
                                unlockedEps = null;
                            }
                            list4 = unlockedEps;
                            if (list4 != null) {
                                break;
                            }
                            qx.b bVarD5 = this.this$0.D();
                            String str19 = this.$subjectId;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.Z$0 = z16;
                            this.label = 4;
                            objA2 = bVarD5.a(str19, this);
                            z19 = z16;
                            if (objA2 == objE) {
                                return objE;
                            }
                            baseDto = (BaseDto) objA2;
                            r11 = z19;
                            if (baseDto != null) {
                                subject = this.$subject;
                                if (subject != null) {
                                    ops = subject.getOps();
                                } else {
                                    ops = null;
                                }
                                subjectP.setOps(ops);
                                this.this$0.R(this.$subjectId, subjectP.getShortTVFavInfo());
                                z11 = r11;
                            }
                            return Unit.f68710a;
                        }
                        subjectP = this.$subject;
                        if (subjectP == null) {
                            DownloadEsHelper downloadEsHelperA5 = DownloadEsHelper.f60994m.a();
                            String str110 = this.$subjectId;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.Z$0 = z16;
                            this.label = 6;
                            objQ = downloadEsHelperA5.q(str110, this);
                            if (objQ == objE) {
                                z11 = z16;
                                z18 = z16;
                                return objE;
                            }
                            z11 = z16;
                            z18 = z16;
                            downloadBean = (DownloadBean) CollectionsKt___CollectionsKt.g0((List) objQ);
                            if (downloadBean != null) {
                                subjectP = DownloadUtil.f61136a.p(downloadBean);
                            } else {
                                subjectP = null;
                            }
                        }
                        if (subjectP == null) {
                            z11 = z16;
                            z11 = z18;
                            z11 = z18;
                            this.this$0.f57795b.q(null);
                            return Unit.f68710a;
                        }
                        z11 = z16;
                        z11 = z18;
                        if (!Intrinsics.b(subjectP, this.this$0.f57795b.f())) {
                            this.this$0.f57795b.q(subjectP);
                            c0 c0Var4 = this.this$0.f57805m;
                            shortTVFavInfo = subjectP.getShortTVFavInfo();
                            if (shortTVFavInfo != null) {
                                z11 = z18;
                                boolA = Boxing.a(shortTVFavInfo.getHasFavorite());
                            } else {
                                z11 = z18;
                                boolA = null;
                            }
                            c0Var4.q(boolA);
                        }
                        z11 = z18;
                        totalEpisode = subjectP.getTotalEpisode();
                        ox.a aVarW4 = this.this$0.w();
                        String str111 = this.$subjectId;
                        this.L$0 = subjectP;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.Z$0 = z11;
                        this.I$0 = totalEpisode;
                        this.label = 7;
                        objC = aVarW4.c(str111, this);
                        if (objC == objE) {
                            return objE;
                        }
                        Subject subject15 = subjectP;
                        z12 = z11;
                        i11 = totalEpisode;
                        subject2 = subject15;
                        list = (List) objC;
                        arrayList = new ArrayList();
                        if (z12) {
                            if (subject2.getTrailer() != null) {
                            }
                            this.this$0.f57813u.q(Boxing.a(false));
                            iB = this.this$0.E().b(subject2);
                            if (1 <= i11) {
                                i12 = 1;
                                while (true) {
                                    it = list.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = it.next();
                                        } else {
                                            next = null;
                                        }
                                        shortTVFirstEp = (ShortTVItem) next;
                                        if (i12 == i14) {
                                            i13 = i12;
                                            dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus2 = 0;
                                            }
                                            dVar2.f(downloadStatus2);
                                            if (dVar2.a() != 5) {
                                                shortTVFirstEp = subject2.getShortTVFirstEp();
                                            }
                                            dVar2.h(shortTVFirstEp);
                                            if (i13 <= iB) {
                                                z14 = true;
                                            } else {
                                                z14 = false;
                                            }
                                            dVar2.g(z14);
                                            arrayList.add(dVar2);
                                        } else {
                                            i13 = i12;
                                            dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus = 0;
                                            }
                                            dVar.f(downloadStatus);
                                            if (dVar.a() == 5) {
                                                shortTVItem = shortTVFirstEp;
                                            } else {
                                                shortTVItem = null;
                                            }
                                            dVar.h(shortTVItem);
                                            if (i13 <= iB) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            dVar.g(z13);
                                            arrayList.add(dVar);
                                        }
                                        if (i13 != i11) {
                                            i12 = i13 + 1;
                                            i14 = 1;
                                        }
                                    } while (((ShortTVItem) next).getEp() != i12);
                                    shortTVFirstEp = (ShortTVItem) next;
                                    if (i12 == i14) {
                                        i13 = i12;
                                        dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus2 = 0;
                                        }
                                        dVar2.f(downloadStatus2);
                                        if (dVar2.a() != 5) {
                                            shortTVFirstEp = subject2.getShortTVFirstEp();
                                        }
                                        dVar2.h(shortTVFirstEp);
                                        if (i13 <= iB) {
                                            z14 = true;
                                        } else {
                                            z14 = false;
                                        }
                                        dVar2.g(z14);
                                        arrayList.add(dVar2);
                                    } else {
                                        i13 = i12;
                                        dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus = 0;
                                        }
                                        dVar.f(downloadStatus);
                                        if (dVar.a() == 5) {
                                            shortTVItem = shortTVFirstEp;
                                        } else {
                                            shortTVItem = null;
                                        }
                                        dVar.h(shortTVItem);
                                        if (i13 <= iB) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        dVar.g(z13);
                                        arrayList.add(dVar);
                                    }
                                    if (i13 != i11) {
                                        i12 = i13 + 1;
                                        i14 = 1;
                                    }
                                }
                            }
                            if (subject2.getShortTVFavInfo() == null) {
                                IShortTvFavoriteProvider iShortTvFavoriteProviderB7 = this.this$0.B();
                                subjectId = subject2.getSubjectId();
                                if (subjectId == null) {
                                    subjectId = "";
                                }
                                this.L$0 = arrayList;
                                this.L$1 = subject2;
                                this.L$2 = null;
                                this.label = 9;
                                objD = iShortTvFavoriteProviderB7.d(subjectId, this);
                                if (objD == objE) {
                                    return objE;
                                }
                                subject4 = subject2;
                                subject4.setShortTVFavInfo((ShortTVFavInfo) objD);
                            }
                            this.this$0.D.q(Boxing.d(2));
                            break;
                        } else {
                            num = this.$dataSource;
                            if (num != null) {
                                return Unit.f68710a;
                            }
                            uo.b.a.f(uo.b.f78622a, "getShortTvEpisodes", "无网，显示下载数据", false, 4, null);
                            List<ShortTVItem> listE3 = CollectionsKt___CollectionsKt.E0(list, new Comparator() { // from class: com.transsion.shorttv.ShortTvViewModel$getShortTvEpisodes$1$invokeSuspend$$inlined$sortedBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t11, T t12) {
                                    return kotlin.comparisons.b.d(Integer.valueOf(((ShortTVItem) t11).getEp()), Integer.valueOf(((ShortTVItem) t12).getEp()));
                                }
                            });
                            str = this.$subjectId;
                            while (r0.hasNext()) {
                                qx.d dVar7 = new qx.d(str, shortTVItem2.getEp(), null, 0, 12, null);
                                dVar7.f(shortTVItem2.getDownloadStatus());
                                dVar7.h(shortTVItem2);
                                dVar7.g(true);
                                arrayList.add(dVar7);
                            }
                            this.this$0.D.q(Boxing.d(1));
                        }
                        this.this$0.f57797d.q(arrayList);
                        return Unit.f68710a;
                    case 4:
                        boolean z24 = this.Z$0;
                        ResultKt.b(obj);
                        objA2 = obj;
                        z19 = z24;
                        baseDto = (BaseDto) objA2;
                        r11 = z19;
                        if (baseDto != null) {
                            subject = this.$subject;
                            if (subject != null) {
                                ops = subject.getOps();
                            } else {
                                ops = null;
                            }
                            subjectP.setOps(ops);
                            this.this$0.R(this.$subjectId, subjectP.getShortTVFavInfo());
                            z11 = r11;
                            if (subjectP == null) {
                                z11 = z16;
                                z11 = z18;
                                z11 = z18;
                                this.this$0.f57795b.q(null);
                                return Unit.f68710a;
                            }
                            z11 = z16;
                            z11 = z18;
                            if (!Intrinsics.b(subjectP, this.this$0.f57795b.f())) {
                                this.this$0.f57795b.q(subjectP);
                                c0 c0Var5 = this.this$0.f57805m;
                                shortTVFavInfo = subjectP.getShortTVFavInfo();
                                if (shortTVFavInfo != null) {
                                    z11 = z18;
                                    boolA = Boxing.a(shortTVFavInfo.getHasFavorite());
                                } else {
                                    z11 = z18;
                                    boolA = null;
                                }
                                c0Var5.q(boolA);
                            }
                            z11 = z18;
                            totalEpisode = subjectP.getTotalEpisode();
                            ox.a aVarW5 = this.this$0.w();
                            String str112 = this.$subjectId;
                            this.L$0 = subjectP;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.Z$0 = z11;
                            this.I$0 = totalEpisode;
                            this.label = 7;
                            objC = aVarW5.c(str112, this);
                            if (objC == objE) {
                                return objE;
                            }
                            Subject subject16 = subjectP;
                            z12 = z11;
                            i11 = totalEpisode;
                            subject2 = subject16;
                            list = (List) objC;
                            arrayList = new ArrayList();
                            if (z12) {
                                if (subject2.getTrailer() != null) {
                                }
                                this.this$0.f57813u.q(Boxing.a(false));
                                iB = this.this$0.E().b(subject2);
                                if (1 <= i11) {
                                    i12 = 1;
                                    while (true) {
                                        it = list.iterator();
                                        do {
                                            if (it.hasNext()) {
                                                next = it.next();
                                            } else {
                                                next = null;
                                            }
                                            shortTVFirstEp = (ShortTVItem) next;
                                            if (i12 == i14) {
                                                i13 = i12;
                                                dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                                if (shortTVFirstEp != null) {
                                                    downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                                } else {
                                                    downloadStatus2 = 0;
                                                }
                                                dVar2.f(downloadStatus2);
                                                if (dVar2.a() != 5) {
                                                    shortTVFirstEp = subject2.getShortTVFirstEp();
                                                }
                                                dVar2.h(shortTVFirstEp);
                                                if (i13 <= iB) {
                                                    z14 = true;
                                                } else {
                                                    z14 = false;
                                                }
                                                dVar2.g(z14);
                                                arrayList.add(dVar2);
                                            } else {
                                                i13 = i12;
                                                dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                                if (shortTVFirstEp != null) {
                                                    downloadStatus = shortTVFirstEp.getDownloadStatus();
                                                } else {
                                                    downloadStatus = 0;
                                                }
                                                dVar.f(downloadStatus);
                                                if (dVar.a() == 5) {
                                                    shortTVItem = shortTVFirstEp;
                                                } else {
                                                    shortTVItem = null;
                                                }
                                                dVar.h(shortTVItem);
                                                if (i13 <= iB) {
                                                    z13 = true;
                                                } else {
                                                    z13 = false;
                                                }
                                                dVar.g(z13);
                                                arrayList.add(dVar);
                                            }
                                            if (i13 != i11) {
                                                i12 = i13 + 1;
                                                i14 = 1;
                                            }
                                        } while (((ShortTVItem) next).getEp() != i12);
                                        shortTVFirstEp = (ShortTVItem) next;
                                        if (i12 == i14) {
                                            i13 = i12;
                                            dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus2 = 0;
                                            }
                                            dVar2.f(downloadStatus2);
                                            if (dVar2.a() != 5) {
                                                shortTVFirstEp = subject2.getShortTVFirstEp();
                                            }
                                            dVar2.h(shortTVFirstEp);
                                            if (i13 <= iB) {
                                                z14 = true;
                                            } else {
                                                z14 = false;
                                            }
                                            dVar2.g(z14);
                                            arrayList.add(dVar2);
                                        } else {
                                            i13 = i12;
                                            dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus = 0;
                                            }
                                            dVar.f(downloadStatus);
                                            if (dVar.a() == 5) {
                                                shortTVItem = shortTVFirstEp;
                                            } else {
                                                shortTVItem = null;
                                            }
                                            dVar.h(shortTVItem);
                                            if (i13 <= iB) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            dVar.g(z13);
                                            arrayList.add(dVar);
                                        }
                                        if (i13 != i11) {
                                            i12 = i13 + 1;
                                            i14 = 1;
                                        }
                                    }
                                }
                                if (subject2.getShortTVFavInfo() == null) {
                                    IShortTvFavoriteProvider iShortTvFavoriteProviderB8 = this.this$0.B();
                                    subjectId = subject2.getSubjectId();
                                    if (subjectId == null) {
                                        subjectId = "";
                                    }
                                    this.L$0 = arrayList;
                                    this.L$1 = subject2;
                                    this.L$2 = null;
                                    this.label = 9;
                                    objD = iShortTvFavoriteProviderB8.d(subjectId, this);
                                    if (objD == objE) {
                                        return objE;
                                    }
                                    subject4 = subject2;
                                    subject4.setShortTVFavInfo((ShortTVFavInfo) objD);
                                }
                                this.this$0.D.q(Boxing.d(2));
                                break;
                            } else {
                                num = this.$dataSource;
                                if (num != null) {
                                    return Unit.f68710a;
                                }
                                uo.b.a.f(uo.b.f78622a, "getShortTvEpisodes", "无网，显示下载数据", false, 4, null);
                                List<ShortTVItem> listE4 = CollectionsKt___CollectionsKt.E0(list, new Comparator() { // from class: com.transsion.shorttv.ShortTvViewModel$getShortTvEpisodes$1$invokeSuspend$$inlined$sortedBy$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t11, T t12) {
                                        return kotlin.comparisons.b.d(Integer.valueOf(((ShortTVItem) t11).getEp()), Integer.valueOf(((ShortTVItem) t12).getEp()));
                                    }
                                });
                                str = this.$subjectId;
                                while (r0.hasNext()) {
                                    qx.d dVar8 = new qx.d(str, shortTVItem2.getEp(), null, 0, 12, null);
                                    dVar8.f(shortTVItem2.getDownloadStatus());
                                    dVar8.h(shortTVItem2);
                                    dVar8.g(true);
                                    arrayList.add(dVar8);
                                }
                                this.this$0.D.q(Boxing.d(1));
                            }
                            this.this$0.f57797d.q(arrayList);
                            return Unit.f68710a;
                        }
                        return Unit.f68710a;
                    case 5:
                        boolean z25 = this.Z$0;
                        ResultKt.b(obj);
                        objA = obj;
                        r12 = z25;
                        baseDto = (BaseDto) objA;
                        r11 = r12;
                        if (baseDto != null) {
                            subject = this.$subject;
                            if (subject != null) {
                                ops = subject.getOps();
                            } else {
                                ops = null;
                            }
                            subjectP.setOps(ops);
                            this.this$0.R(this.$subjectId, subjectP.getShortTVFavInfo());
                            z11 = r11;
                            if (subjectP == null) {
                                z11 = z16;
                                z11 = z18;
                                z11 = z18;
                                this.this$0.f57795b.q(null);
                                return Unit.f68710a;
                            }
                            z11 = z16;
                            z11 = z18;
                            if (!Intrinsics.b(subjectP, this.this$0.f57795b.f())) {
                                this.this$0.f57795b.q(subjectP);
                                c0 c0Var6 = this.this$0.f57805m;
                                shortTVFavInfo = subjectP.getShortTVFavInfo();
                                if (shortTVFavInfo != null) {
                                    z11 = z18;
                                    boolA = Boxing.a(shortTVFavInfo.getHasFavorite());
                                } else {
                                    z11 = z18;
                                    boolA = null;
                                }
                                c0Var6.q(boolA);
                            }
                            z11 = z18;
                            totalEpisode = subjectP.getTotalEpisode();
                            ox.a aVarW6 = this.this$0.w();
                            String str113 = this.$subjectId;
                            this.L$0 = subjectP;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.Z$0 = z11;
                            this.I$0 = totalEpisode;
                            this.label = 7;
                            objC = aVarW6.c(str113, this);
                            if (objC == objE) {
                                return objE;
                            }
                            Subject subject17 = subjectP;
                            z12 = z11;
                            i11 = totalEpisode;
                            subject2 = subject17;
                            list = (List) objC;
                            arrayList = new ArrayList();
                            if (z12) {
                                if (subject2.getTrailer() != null) {
                                }
                                this.this$0.f57813u.q(Boxing.a(false));
                                iB = this.this$0.E().b(subject2);
                                if (1 <= i11) {
                                    i12 = 1;
                                    while (true) {
                                        it = list.iterator();
                                        do {
                                            if (it.hasNext()) {
                                                next = it.next();
                                            } else {
                                                next = null;
                                            }
                                            shortTVFirstEp = (ShortTVItem) next;
                                            if (i12 == i14) {
                                                i13 = i12;
                                                dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                                if (shortTVFirstEp != null) {
                                                    downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                                } else {
                                                    downloadStatus2 = 0;
                                                }
                                                dVar2.f(downloadStatus2);
                                                if (dVar2.a() != 5) {
                                                    shortTVFirstEp = subject2.getShortTVFirstEp();
                                                }
                                                dVar2.h(shortTVFirstEp);
                                                if (i13 <= iB) {
                                                    z14 = true;
                                                } else {
                                                    z14 = false;
                                                }
                                                dVar2.g(z14);
                                                arrayList.add(dVar2);
                                            } else {
                                                i13 = i12;
                                                dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                                if (shortTVFirstEp != null) {
                                                    downloadStatus = shortTVFirstEp.getDownloadStatus();
                                                } else {
                                                    downloadStatus = 0;
                                                }
                                                dVar.f(downloadStatus);
                                                if (dVar.a() == 5) {
                                                    shortTVItem = shortTVFirstEp;
                                                } else {
                                                    shortTVItem = null;
                                                }
                                                dVar.h(shortTVItem);
                                                if (i13 <= iB) {
                                                    z13 = true;
                                                } else {
                                                    z13 = false;
                                                }
                                                dVar.g(z13);
                                                arrayList.add(dVar);
                                            }
                                            if (i13 != i11) {
                                                i12 = i13 + 1;
                                                i14 = 1;
                                            }
                                        } while (((ShortTVItem) next).getEp() != i12);
                                        shortTVFirstEp = (ShortTVItem) next;
                                        if (i12 == i14) {
                                            i13 = i12;
                                            dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus2 = 0;
                                            }
                                            dVar2.f(downloadStatus2);
                                            if (dVar2.a() != 5) {
                                                shortTVFirstEp = subject2.getShortTVFirstEp();
                                            }
                                            dVar2.h(shortTVFirstEp);
                                            if (i13 <= iB) {
                                                z14 = true;
                                            } else {
                                                z14 = false;
                                            }
                                            dVar2.g(z14);
                                            arrayList.add(dVar2);
                                        } else {
                                            i13 = i12;
                                            dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus = 0;
                                            }
                                            dVar.f(downloadStatus);
                                            if (dVar.a() == 5) {
                                                shortTVItem = shortTVFirstEp;
                                            } else {
                                                shortTVItem = null;
                                            }
                                            dVar.h(shortTVItem);
                                            if (i13 <= iB) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            dVar.g(z13);
                                            arrayList.add(dVar);
                                        }
                                        if (i13 != i11) {
                                            i12 = i13 + 1;
                                            i14 = 1;
                                        }
                                    }
                                }
                                if (subject2.getShortTVFavInfo() == null) {
                                    IShortTvFavoriteProvider iShortTvFavoriteProviderB9 = this.this$0.B();
                                    subjectId = subject2.getSubjectId();
                                    if (subjectId == null) {
                                        subjectId = "";
                                    }
                                    this.L$0 = arrayList;
                                    this.L$1 = subject2;
                                    this.L$2 = null;
                                    this.label = 9;
                                    objD = iShortTvFavoriteProviderB9.d(subjectId, this);
                                    if (objD == objE) {
                                        return objE;
                                    }
                                    subject4 = subject2;
                                    subject4.setShortTVFavInfo((ShortTVFavInfo) objD);
                                }
                                this.this$0.D.q(Boxing.d(2));
                                break;
                            } else {
                                num = this.$dataSource;
                                if (num != null) {
                                    return Unit.f68710a;
                                }
                                uo.b.a.f(uo.b.f78622a, "getShortTvEpisodes", "无网，显示下载数据", false, 4, null);
                                List<ShortTVItem> listE5 = CollectionsKt___CollectionsKt.E0(list, new Comparator() { // from class: com.transsion.shorttv.ShortTvViewModel$getShortTvEpisodes$1$invokeSuspend$$inlined$sortedBy$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t11, T t12) {
                                        return kotlin.comparisons.b.d(Integer.valueOf(((ShortTVItem) t11).getEp()), Integer.valueOf(((ShortTVItem) t12).getEp()));
                                    }
                                });
                                str = this.$subjectId;
                                while (r0.hasNext()) {
                                    qx.d dVar9 = new qx.d(str, shortTVItem2.getEp(), null, 0, 12, null);
                                    dVar9.f(shortTVItem2.getDownloadStatus());
                                    dVar9.h(shortTVItem2);
                                    dVar9.g(true);
                                    arrayList.add(dVar9);
                                }
                                this.this$0.D.q(Boxing.d(1));
                            }
                            this.this$0.f57797d.q(arrayList);
                            return Unit.f68710a;
                        }
                        return Unit.f68710a;
                    case 6:
                        boolean z26 = this.Z$0;
                        ResultKt.b(obj);
                        objQ = obj;
                        z18 = z26;
                        z11 = z16;
                        z18 = z16;
                        downloadBean = (DownloadBean) CollectionsKt___CollectionsKt.g0((List) objQ);
                        if (downloadBean != null) {
                            subjectP = DownloadUtil.f61136a.p(downloadBean);
                        } else {
                            subjectP = null;
                        }
                        if (subjectP == null) {
                            z11 = z16;
                            z11 = z18;
                            z11 = z18;
                            this.this$0.f57795b.q(null);
                            return Unit.f68710a;
                        }
                        z11 = z16;
                        z11 = z18;
                        if (!Intrinsics.b(subjectP, this.this$0.f57795b.f())) {
                            this.this$0.f57795b.q(subjectP);
                            c0 c0Var7 = this.this$0.f57805m;
                            shortTVFavInfo = subjectP.getShortTVFavInfo();
                            if (shortTVFavInfo != null) {
                                z11 = z18;
                                boolA = Boxing.a(shortTVFavInfo.getHasFavorite());
                            } else {
                                z11 = z18;
                                boolA = null;
                            }
                            c0Var7.q(boolA);
                        }
                        z11 = z18;
                        totalEpisode = subjectP.getTotalEpisode();
                        ox.a aVarW7 = this.this$0.w();
                        String str114 = this.$subjectId;
                        this.L$0 = subjectP;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.Z$0 = z11;
                        this.I$0 = totalEpisode;
                        this.label = 7;
                        objC = aVarW7.c(str114, this);
                        if (objC == objE) {
                            return objE;
                        }
                        Subject subject18 = subjectP;
                        z12 = z11;
                        i11 = totalEpisode;
                        subject2 = subject18;
                        list = (List) objC;
                        arrayList = new ArrayList();
                        if (z12) {
                            if (subject2.getTrailer() != null) {
                            }
                            this.this$0.f57813u.q(Boxing.a(false));
                            iB = this.this$0.E().b(subject2);
                            if (1 <= i11) {
                                i12 = 1;
                                while (true) {
                                    it = list.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = it.next();
                                        } else {
                                            next = null;
                                        }
                                        shortTVFirstEp = (ShortTVItem) next;
                                        if (i12 == i14) {
                                            i13 = i12;
                                            dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus2 = 0;
                                            }
                                            dVar2.f(downloadStatus2);
                                            if (dVar2.a() != 5) {
                                                shortTVFirstEp = subject2.getShortTVFirstEp();
                                            }
                                            dVar2.h(shortTVFirstEp);
                                            if (i13 <= iB) {
                                                z14 = true;
                                            } else {
                                                z14 = false;
                                            }
                                            dVar2.g(z14);
                                            arrayList.add(dVar2);
                                        } else {
                                            i13 = i12;
                                            dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus = 0;
                                            }
                                            dVar.f(downloadStatus);
                                            if (dVar.a() == 5) {
                                                shortTVItem = shortTVFirstEp;
                                            } else {
                                                shortTVItem = null;
                                            }
                                            dVar.h(shortTVItem);
                                            if (i13 <= iB) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            dVar.g(z13);
                                            arrayList.add(dVar);
                                        }
                                        if (i13 != i11) {
                                            i12 = i13 + 1;
                                            i14 = 1;
                                        }
                                    } while (((ShortTVItem) next).getEp() != i12);
                                    shortTVFirstEp = (ShortTVItem) next;
                                    if (i12 == i14) {
                                        i13 = i12;
                                        dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus2 = 0;
                                        }
                                        dVar2.f(downloadStatus2);
                                        if (dVar2.a() != 5) {
                                            shortTVFirstEp = subject2.getShortTVFirstEp();
                                        }
                                        dVar2.h(shortTVFirstEp);
                                        if (i13 <= iB) {
                                            z14 = true;
                                        } else {
                                            z14 = false;
                                        }
                                        dVar2.g(z14);
                                        arrayList.add(dVar2);
                                    } else {
                                        i13 = i12;
                                        dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus = 0;
                                        }
                                        dVar.f(downloadStatus);
                                        if (dVar.a() == 5) {
                                            shortTVItem = shortTVFirstEp;
                                        } else {
                                            shortTVItem = null;
                                        }
                                        dVar.h(shortTVItem);
                                        if (i13 <= iB) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        dVar.g(z13);
                                        arrayList.add(dVar);
                                    }
                                    if (i13 != i11) {
                                        i12 = i13 + 1;
                                        i14 = 1;
                                    }
                                }
                            }
                            if (subject2.getShortTVFavInfo() == null) {
                                IShortTvFavoriteProvider iShortTvFavoriteProviderB10 = this.this$0.B();
                                subjectId = subject2.getSubjectId();
                                if (subjectId == null) {
                                    subjectId = "";
                                }
                                this.L$0 = arrayList;
                                this.L$1 = subject2;
                                this.L$2 = null;
                                this.label = 9;
                                objD = iShortTvFavoriteProviderB10.d(subjectId, this);
                                if (objD == objE) {
                                    return objE;
                                }
                                subject4 = subject2;
                                subject4.setShortTVFavInfo((ShortTVFavInfo) objD);
                            }
                            this.this$0.D.q(Boxing.d(2));
                            break;
                        } else {
                            num = this.$dataSource;
                            if (num != null) {
                                return Unit.f68710a;
                            }
                            uo.b.a.f(uo.b.f78622a, "getShortTvEpisodes", "无网，显示下载数据", false, 4, null);
                            List<ShortTVItem> listE6 = CollectionsKt___CollectionsKt.E0(list, new Comparator() { // from class: com.transsion.shorttv.ShortTvViewModel$getShortTvEpisodes$1$invokeSuspend$$inlined$sortedBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t11, T t12) {
                                    return kotlin.comparisons.b.d(Integer.valueOf(((ShortTVItem) t11).getEp()), Integer.valueOf(((ShortTVItem) t12).getEp()));
                                }
                            });
                            str = this.$subjectId;
                            while (r0.hasNext()) {
                                qx.d dVar10 = new qx.d(str, shortTVItem2.getEp(), null, 0, 12, null);
                                dVar10.f(shortTVItem2.getDownloadStatus());
                                dVar10.h(shortTVItem2);
                                dVar10.g(true);
                                arrayList.add(dVar10);
                            }
                            this.this$0.D.q(Boxing.d(1));
                        }
                        this.this$0.f57797d.q(arrayList);
                        return Unit.f68710a;
                    case 7:
                        i11 = this.I$0;
                        boolean z27 = this.Z$0;
                        subject2 = (Subject) this.L$0;
                        ResultKt.b(obj);
                        objC = obj;
                        z12 = z27;
                        list = (List) objC;
                        arrayList = new ArrayList();
                        if (z12) {
                            if (subject2.getTrailer() != null) {
                            }
                            this.this$0.f57813u.q(Boxing.a(false));
                            iB = this.this$0.E().b(subject2);
                            if (1 <= i11) {
                                i12 = 1;
                                while (true) {
                                    it = list.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = it.next();
                                        } else {
                                            next = null;
                                        }
                                        shortTVFirstEp = (ShortTVItem) next;
                                        if (i12 == i14) {
                                            i13 = i12;
                                            dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus2 = 0;
                                            }
                                            dVar2.f(downloadStatus2);
                                            if (dVar2.a() != 5) {
                                                shortTVFirstEp = subject2.getShortTVFirstEp();
                                            }
                                            dVar2.h(shortTVFirstEp);
                                            if (i13 <= iB) {
                                                z14 = true;
                                            } else {
                                                z14 = false;
                                            }
                                            dVar2.g(z14);
                                            arrayList.add(dVar2);
                                        } else {
                                            i13 = i12;
                                            dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                            if (shortTVFirstEp != null) {
                                                downloadStatus = shortTVFirstEp.getDownloadStatus();
                                            } else {
                                                downloadStatus = 0;
                                            }
                                            dVar.f(downloadStatus);
                                            if (dVar.a() == 5) {
                                                shortTVItem = shortTVFirstEp;
                                            } else {
                                                shortTVItem = null;
                                            }
                                            dVar.h(shortTVItem);
                                            if (i13 <= iB) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            dVar.g(z13);
                                            arrayList.add(dVar);
                                        }
                                        if (i13 != i11) {
                                            i12 = i13 + 1;
                                            i14 = 1;
                                        }
                                    } while (((ShortTVItem) next).getEp() != i12);
                                    shortTVFirstEp = (ShortTVItem) next;
                                    if (i12 == i14) {
                                        i13 = i12;
                                        dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus2 = 0;
                                        }
                                        dVar2.f(downloadStatus2);
                                        if (dVar2.a() != 5) {
                                            shortTVFirstEp = subject2.getShortTVFirstEp();
                                        }
                                        dVar2.h(shortTVFirstEp);
                                        if (i13 <= iB) {
                                            z14 = true;
                                        } else {
                                            z14 = false;
                                        }
                                        dVar2.g(z14);
                                        arrayList.add(dVar2);
                                    } else {
                                        i13 = i12;
                                        dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus = 0;
                                        }
                                        dVar.f(downloadStatus);
                                        if (dVar.a() == 5) {
                                            shortTVItem = shortTVFirstEp;
                                        } else {
                                            shortTVItem = null;
                                        }
                                        dVar.h(shortTVItem);
                                        if (i13 <= iB) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        dVar.g(z13);
                                        arrayList.add(dVar);
                                    }
                                    if (i13 != i11) {
                                        i12 = i13 + 1;
                                        i14 = 1;
                                    }
                                }
                            }
                            if (subject2.getShortTVFavInfo() == null) {
                                IShortTvFavoriteProvider iShortTvFavoriteProviderB11 = this.this$0.B();
                                subjectId = subject2.getSubjectId();
                                if (subjectId == null) {
                                    subjectId = "";
                                }
                                this.L$0 = arrayList;
                                this.L$1 = subject2;
                                this.L$2 = null;
                                this.label = 9;
                                objD = iShortTvFavoriteProviderB11.d(subjectId, this);
                                if (objD == objE) {
                                    return objE;
                                }
                                subject4 = subject2;
                                subject4.setShortTVFavInfo((ShortTVFavInfo) objD);
                            }
                            this.this$0.D.q(Boxing.d(2));
                            break;
                        } else {
                            num = this.$dataSource;
                            if (num != null) {
                                return Unit.f68710a;
                            }
                            uo.b.a.f(uo.b.f78622a, "getShortTvEpisodes", "无网，显示下载数据", false, 4, null);
                            List<ShortTVItem> listE7 = CollectionsKt___CollectionsKt.E0(list, new Comparator() { // from class: com.transsion.shorttv.ShortTvViewModel$getShortTvEpisodes$1$invokeSuspend$$inlined$sortedBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t11, T t12) {
                                    return kotlin.comparisons.b.d(Integer.valueOf(((ShortTVItem) t11).getEp()), Integer.valueOf(((ShortTVItem) t12).getEp()));
                                }
                            });
                            str = this.$subjectId;
                            while (r0.hasNext()) {
                                qx.d dVar11 = new qx.d(str, shortTVItem2.getEp(), null, 0, 12, null);
                                dVar11.f(shortTVItem2.getDownloadStatus());
                                dVar11.h(shortTVItem2);
                                dVar11.g(true);
                                arrayList.add(dVar11);
                            }
                            this.this$0.D.q(Boxing.d(1));
                        }
                        this.this$0.f57797d.q(arrayList);
                        return Unit.f68710a;
                    case 8:
                        i11 = this.I$0;
                        List list5 = (List) this.L$2;
                        list2 = (List) this.L$1;
                        subject3 = (Subject) this.L$0;
                        ResultKt.b(obj);
                        arrayList = list5;
                        objI = obj;
                        arrayList.add((qx.d) objI);
                        Subject subject19 = subject3;
                        list = list2;
                        subject2 = subject19;
                        iB = this.this$0.E().b(subject2);
                        if (1 <= i11) {
                            i12 = 1;
                            while (true) {
                                it = list.iterator();
                                do {
                                    if (it.hasNext()) {
                                        next = it.next();
                                    } else {
                                        next = null;
                                    }
                                    shortTVFirstEp = (ShortTVItem) next;
                                    if (i12 == i14) {
                                        i13 = i12;
                                        dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus2 = 0;
                                        }
                                        dVar2.f(downloadStatus2);
                                        if (dVar2.a() != 5) {
                                            shortTVFirstEp = subject2.getShortTVFirstEp();
                                        }
                                        dVar2.h(shortTVFirstEp);
                                        if (i13 <= iB) {
                                            z14 = true;
                                        } else {
                                            z14 = false;
                                        }
                                        dVar2.g(z14);
                                        arrayList.add(dVar2);
                                    } else {
                                        i13 = i12;
                                        dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                        if (shortTVFirstEp != null) {
                                            downloadStatus = shortTVFirstEp.getDownloadStatus();
                                        } else {
                                            downloadStatus = 0;
                                        }
                                        dVar.f(downloadStatus);
                                        if (dVar.a() == 5) {
                                            shortTVItem = shortTVFirstEp;
                                        } else {
                                            shortTVItem = null;
                                        }
                                        dVar.h(shortTVItem);
                                        if (i13 <= iB) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        dVar.g(z13);
                                        arrayList.add(dVar);
                                    }
                                    if (i13 != i11) {
                                        i12 = i13 + 1;
                                        i14 = 1;
                                    }
                                } while (((ShortTVItem) next).getEp() != i12);
                                shortTVFirstEp = (ShortTVItem) next;
                                if (i12 == i14) {
                                    i13 = i12;
                                    dVar2 = new qx.d(this.$subjectId, i12, null, 0, 12, null);
                                    if (shortTVFirstEp != null) {
                                        downloadStatus2 = shortTVFirstEp.getDownloadStatus();
                                    } else {
                                        downloadStatus2 = 0;
                                    }
                                    dVar2.f(downloadStatus2);
                                    if (dVar2.a() != 5) {
                                        shortTVFirstEp = subject2.getShortTVFirstEp();
                                    }
                                    dVar2.h(shortTVFirstEp);
                                    if (i13 <= iB) {
                                        z14 = true;
                                    } else {
                                        z14 = false;
                                    }
                                    dVar2.g(z14);
                                    arrayList.add(dVar2);
                                } else {
                                    i13 = i12;
                                    dVar = new qx.d(this.$subjectId, i13, null, 0, 12, null);
                                    if (shortTVFirstEp != null) {
                                        downloadStatus = shortTVFirstEp.getDownloadStatus();
                                    } else {
                                        downloadStatus = 0;
                                    }
                                    dVar.f(downloadStatus);
                                    if (dVar.a() == 5) {
                                        shortTVItem = shortTVFirstEp;
                                    } else {
                                        shortTVItem = null;
                                    }
                                    dVar.h(shortTVItem);
                                    if (i13 <= iB) {
                                        z13 = true;
                                    } else {
                                        z13 = false;
                                    }
                                    dVar.g(z13);
                                    arrayList.add(dVar);
                                }
                                if (i13 != i11) {
                                    i12 = i13 + 1;
                                    i14 = 1;
                                }
                            }
                        }
                        if (subject2.getShortTVFavInfo() == null) {
                            IShortTvFavoriteProvider iShortTvFavoriteProviderB12 = this.this$0.B();
                            subjectId = subject2.getSubjectId();
                            if (subjectId == null) {
                                subjectId = "";
                            }
                            this.L$0 = arrayList;
                            this.L$1 = subject2;
                            this.L$2 = null;
                            this.label = 9;
                            objD = iShortTvFavoriteProviderB12.d(subjectId, this);
                            if (objD == objE) {
                                return objE;
                            }
                            subject4 = subject2;
                            subject4.setShortTVFavInfo((ShortTVFavInfo) objD);
                        }
                        this.this$0.D.q(Boxing.d(2));
                        this.this$0.f57797d.q(arrayList);
                        return Unit.f68710a;
                    case 9:
                        subject4 = (Subject) this.L$1;
                        List list6 = (List) this.L$0;
                        ResultKt.b(obj);
                        arrayList = list6;
                        objD = obj;
                        subject4.setShortTVFavInfo((ShortTVFavInfo) objD);
                        this.this$0.D.q(Boxing.d(2));
                        this.this$0.f57797d.q(arrayList);
                        return Unit.f68710a;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception unused) {
                qx.b bVarD6 = this.this$0.D();
                String str20 = this.$subjectId;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.Z$0 = z19;
                this.label = 5;
                objA = bVarD6.a(str20, this);
                r12 = z19;
                if (objA == objE) {
                    return objE;
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            return Unit.f68710a;
        }
    }
}
