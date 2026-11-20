package com.transsnet.downloader.viewmodel;

import android.content.res.Resources;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadListManager$getList$1", f = "DownloadListManager.kt", l = {83, ModuleDescriptor.MODULE_VERSION, TsExtractor.TS_STREAM_TYPE_DVBSUBS, 92, 93, 98, 156}, m = "invokeSuspend")
public final class DownloadListManager$getList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hide;
    final /* synthetic */ boolean $isCompletedRefresh;
    final /* synthetic */ com.transsion.ad.bidding.nativead.c $wrapNativeManager;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadListManager this$0;

    /* JADX INFO: renamed from: com.transsnet.downloader.viewmodel.DownloadListManager$getList$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadListManager$getList$1$1", f = "DownloadListManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<DownloadBean> $dataUncomplete;
        int label;
        final /* synthetic */ DownloadListManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DownloadListManager downloadListManager, List<DownloadBean> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = downloadListManager;
            this.$dataUncomplete = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$dataUncomplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.this$0.j(this.$dataUncomplete);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.viewmodel.DownloadListManager$getList$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadListManager$getList$1$2", f = "DownloadListManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<DownloadBean> $dataCompleteAllList;
        int label;
        final /* synthetic */ DownloadListManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(DownloadListManager downloadListManager, List<? extends DownloadBean> list, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = downloadListManager;
            this.$dataCompleteAllList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$dataCompleteAllList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.this$0.j(this.$dataCompleteAllList);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.viewmodel.DownloadListManager$getList$1$5, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadListManager$getList$1$5", f = "DownloadListManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<DownloadBean> $dataList;
        int label;
        final /* synthetic */ DownloadListManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(DownloadListManager downloadListManager, List<DownloadBean> list, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.this$0 = downloadListManager;
            this.$dataList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.this$0, this.$dataList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.this$0.H(this.$dataList);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadListManager$getList$1(boolean z11, DownloadListManager downloadListManager, boolean z12, com.transsion.ad.bidding.nativead.c cVar, Continuation<? super DownloadListManager$getList$1> continuation) {
        super(2, continuation);
        this.$isCompletedRefresh = z11;
        this.this$0 = downloadListManager;
        this.$hide = z12;
        this.$wrapNativeManager = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadListManager$getList$1(this.$isCompletedRefresh, this.this$0, this.$hide, this.$wrapNativeManager, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadListManager$getList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x007c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x009d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x00af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:33:0x00df A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:37:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:42:0x0115  */
    /* JADX WARN: Code duplicated, block: B:45:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:47:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:50:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:54:0x01e4 A[LOOP:0: B:43:0x01c3->B:54:0x01e4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:58:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:61:0x0200  */
    /* JADX WARN: Code duplicated, block: B:63:0x0204  */
    /* JADX WARN: Code duplicated, block: B:66:0x0219  */
    /* JADX WARN: Code duplicated, block: B:67:0x021c  */
    /* JADX WARN: Code duplicated, block: B:69:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:72:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:74:0x0374  */
    /* JADX WARN: Code duplicated, block: B:75:0x0379  */
    /* JADX WARN: Code duplicated, block: B:79:0x03be A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:80:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:83:0x01e6 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objN;
        List<DownloadBean> list;
        CoroutineDispatcher coroutineDispatcherB;
        AnonymousClass1 anonymousClass1;
        Object objW;
        List list2;
        CoroutineDispatcher coroutineDispatcherB2;
        AnonymousClass2 anonymousClass2;
        List<DownloadBean> listSubList;
        List list3;
        Object objM;
        List list4;
        List<DownloadBean> list5;
        ArrayList arrayList;
        List list6;
        a2 a2VarC;
        AnonymousClass5 anonymousClass5;
        List<DownloadBean> list7;
        int size;
        Ref.BooleanRef booleanRef;
        int size2;
        int i11;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        switch (this.label) {
            case 0:
                ResultKt.b(obj);
                if (this.$isCompletedRefresh) {
                    this.label = 1;
                    if (r0.a(800L, this) == objE) {
                        return objE;
                    }
                }
                this.this$0.M(this.$hide);
                DownloadListManager downloadListManager = this.this$0;
                this.label = 2;
                objN = downloadListManager.n(this);
                if (objN == objE) {
                    return objE;
                }
                list = (List) objN;
                this.this$0.v().n(list);
                coroutineDispatcherB = w0.b();
                anonymousClass1 = new AnonymousClass1(this.this$0, list, null);
                this.L$0 = list;
                this.label = 3;
                if (h.g(coroutineDispatcherB, anonymousClass1, this) == objE) {
                    return objE;
                }
                DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
                this.L$0 = list;
                this.label = 4;
                objW = DownloadEsHelper.w(downloadEsHelperA, false, this, 1, null);
                if (objW == objE) {
                    return objE;
                }
                list2 = (List) objW;
                coroutineDispatcherB2 = w0.b();
                anonymousClass2 = new AnonymousClass2(this.this$0, list2, null);
                this.L$0 = list;
                this.L$1 = list2;
                this.label = 5;
                if (h.g(coroutineDispatcherB2, anonymousClass2, this) == objE) {
                    return objE;
                }
                listSubList = list;
                list3 = list2;
                DownloadListManager downloadListManager2 = this.this$0;
                this.L$0 = listSubList;
                this.L$1 = list3;
                this.label = 6;
                objM = downloadListManager2.m(list3, this);
                if (objM == objE) {
                    return objE;
                }
                list4 = (List) objM;
                list5 = listSubList;
                if (!list5.isEmpty()) {
                    this.this$0.I(listSubList, this.$wrapNativeManager);
                } else if (!list4.isEmpty()) {
                    this.this$0.I(list4, this.$wrapNativeManager);
                }
                arrayList = new ArrayList();
                if (!list5.isEmpty()) {
                    String string = Utils.a().getResources().getString(R$string.str_downloading_title);
                    Intrinsics.f(string, "getApp().resources.getSt…ng.str_downloading_title)");
                    DownloadBean downloadBean = new DownloadBean("title1", "titleRes1", string, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean.setStatus(11);
                    downloadBean.setMore(true);
                    booleanRef = new Ref.BooleanRef();
                    for (DownloadBean downloadBean2 : listSubList) {
                        if (downloadBean2.getAdProvide() != null) {
                            booleanRef.element = true;
                        }
                        if (downloadBean2.getWrapNativeManager() != null) {
                            booleanRef.element = true;
                        }
                        if (booleanRef.element) {
                            if (booleanRef.element) {
                                size2 = listSubList.size() - 1;
                            } else {
                                size2 = listSubList.size();
                            }
                            downloadBean.setCount(size2);
                            arrayList.add(downloadBean);
                            if (listSubList.size() > 3) {
                                if (this.$hide) {
                                    listSubList = listSubList.subList(0, 3);
                                }
                                arrayList.addAll(listSubList);
                                Resources resources = Utils.a().getResources();
                                if (this.$hide) {
                                    i11 = com.tn.lib.widget.R$string.player_more;
                                } else {
                                    i11 = com.tn.lib.widget.R$string.player_hide;
                                }
                                String string2 = resources.getString(i11);
                                Intrinsics.f(string2, "getApp().resources.getSt…get.R.string.player_hide)");
                                DownloadBean downloadBean3 = new DownloadBean("title1", "titleRes3", string2, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                                downloadBean3.setStatus(12);
                                downloadBean3.setMore(this.$hide);
                                arrayList.add(downloadBean3);
                            } else {
                                arrayList.addAll(listSubList);
                            }
                        }
                    }
                    if (booleanRef.element) {
                        size2 = listSubList.size() - 1;
                    } else {
                        size2 = listSubList.size();
                    }
                    downloadBean.setCount(size2);
                    arrayList.add(downloadBean);
                    if (listSubList.size() > 3) {
                        if (this.$hide) {
                            listSubList = listSubList.subList(0, 3);
                        }
                        arrayList.addAll(listSubList);
                        Resources resources2 = Utils.a().getResources();
                        if (this.$hide) {
                            i11 = com.tn.lib.widget.R$string.player_more;
                        } else {
                            i11 = com.tn.lib.widget.R$string.player_hide;
                        }
                        String string3 = resources2.getString(i11);
                        Intrinsics.f(string3, "getApp().resources.getSt…get.R.string.player_hide)");
                        DownloadBean downloadBean4 = new DownloadBean("title1", "titleRes3", string3, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                        downloadBean4.setStatus(12);
                        downloadBean4.setMore(this.$hide);
                        arrayList.add(downloadBean4);
                    } else {
                        arrayList.addAll(listSubList);
                    }
                }
                list6 = list4;
                if (!list6.isEmpty()) {
                    String string4 = Utils.a().getResources().getString(R$string.str_downloaded_title);
                    Intrinsics.f(string4, "getApp().resources.getSt…ing.str_downloaded_title)");
                    DownloadBean downloadBean5 = new DownloadBean("title2", "titleRes2", string4, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean5.setStatus(11);
                    if (list3 != null) {
                        size = list3.size();
                    } else {
                        size = list4.size();
                    }
                    downloadBean5.setCount(size);
                    arrayList.add(downloadBean5);
                    arrayList.addAll(list6);
                }
                uo.b.a.g(uo.b.f78622a, "get getListByStatus success" + arrayList.size(), false, 2, null);
                this.this$0.l(arrayList);
                a2VarC = w0.c();
                anonymousClass5 = new AnonymousClass5(this.this$0, arrayList, null);
                this.L$0 = arrayList;
                this.L$1 = null;
                this.label = 7;
                if (h.g(a2VarC, anonymousClass5, this) == objE) {
                    return objE;
                }
                list7 = arrayList;
                this.this$0.q().n(list7);
                return Unit.f68710a;
            case 1:
                ResultKt.b(obj);
                this.this$0.M(this.$hide);
                DownloadListManager downloadListManager3 = this.this$0;
                this.label = 2;
                objN = downloadListManager3.n(this);
                if (objN == objE) {
                    return objE;
                }
                list = (List) objN;
                this.this$0.v().n(list);
                coroutineDispatcherB = w0.b();
                anonymousClass1 = new AnonymousClass1(this.this$0, list, null);
                this.L$0 = list;
                this.label = 3;
                if (h.g(coroutineDispatcherB, anonymousClass1, this) == objE) {
                    return objE;
                }
                DownloadEsHelper downloadEsHelperA2 = DownloadEsHelper.f60994m.a();
                this.L$0 = list;
                this.label = 4;
                objW = DownloadEsHelper.w(downloadEsHelperA2, false, this, 1, null);
                if (objW == objE) {
                    return objE;
                }
                list2 = (List) objW;
                coroutineDispatcherB2 = w0.b();
                anonymousClass2 = new AnonymousClass2(this.this$0, list2, null);
                this.L$0 = list;
                this.L$1 = list2;
                this.label = 5;
                if (h.g(coroutineDispatcherB2, anonymousClass2, this) == objE) {
                    return objE;
                }
                listSubList = list;
                list3 = list2;
                DownloadListManager downloadListManager4 = this.this$0;
                this.L$0 = listSubList;
                this.L$1 = list3;
                this.label = 6;
                objM = downloadListManager4.m(list3, this);
                if (objM == objE) {
                    return objE;
                }
                list4 = (List) objM;
                list5 = listSubList;
                if (!list5.isEmpty()) {
                    this.this$0.I(listSubList, this.$wrapNativeManager);
                } else if (!list4.isEmpty()) {
                    this.this$0.I(list4, this.$wrapNativeManager);
                }
                arrayList = new ArrayList();
                if (!list5.isEmpty()) {
                    String string5 = Utils.a().getResources().getString(R$string.str_downloading_title);
                    Intrinsics.f(string5, "getApp().resources.getSt…ng.str_downloading_title)");
                    DownloadBean downloadBean6 = new DownloadBean("title1", "titleRes1", string5, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean6.setStatus(11);
                    downloadBean6.setMore(true);
                    booleanRef = new Ref.BooleanRef();
                    while (r16.hasNext()) {
                        if (downloadBean2.getAdProvide() != null) {
                            booleanRef.element = true;
                        }
                        if (downloadBean2.getWrapNativeManager() != null) {
                            booleanRef.element = true;
                        }
                        if (booleanRef.element) {
                            if (booleanRef.element) {
                                size2 = listSubList.size() - 1;
                            } else {
                                size2 = listSubList.size();
                            }
                            downloadBean6.setCount(size2);
                            arrayList.add(downloadBean6);
                            if (listSubList.size() > 3) {
                                if (this.$hide) {
                                    listSubList = listSubList.subList(0, 3);
                                }
                                arrayList.addAll(listSubList);
                                Resources resources3 = Utils.a().getResources();
                                if (this.$hide) {
                                    i11 = com.tn.lib.widget.R$string.player_more;
                                } else {
                                    i11 = com.tn.lib.widget.R$string.player_hide;
                                }
                                String string6 = resources3.getString(i11);
                                Intrinsics.f(string6, "getApp().resources.getSt…get.R.string.player_hide)");
                                DownloadBean downloadBean7 = new DownloadBean("title1", "titleRes3", string6, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                                downloadBean7.setStatus(12);
                                downloadBean7.setMore(this.$hide);
                                arrayList.add(downloadBean7);
                            } else {
                                arrayList.addAll(listSubList);
                            }
                        }
                    }
                    if (booleanRef.element) {
                        size2 = listSubList.size() - 1;
                    } else {
                        size2 = listSubList.size();
                    }
                    downloadBean6.setCount(size2);
                    arrayList.add(downloadBean6);
                    if (listSubList.size() > 3) {
                        if (this.$hide) {
                            listSubList = listSubList.subList(0, 3);
                        }
                        arrayList.addAll(listSubList);
                        Resources resources4 = Utils.a().getResources();
                        if (this.$hide) {
                            i11 = com.tn.lib.widget.R$string.player_more;
                        } else {
                            i11 = com.tn.lib.widget.R$string.player_hide;
                        }
                        String string7 = resources4.getString(i11);
                        Intrinsics.f(string7, "getApp().resources.getSt…get.R.string.player_hide)");
                        DownloadBean downloadBean8 = new DownloadBean("title1", "titleRes3", string7, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                        downloadBean8.setStatus(12);
                        downloadBean8.setMore(this.$hide);
                        arrayList.add(downloadBean8);
                    } else {
                        arrayList.addAll(listSubList);
                    }
                }
                list6 = list4;
                if (!list6.isEmpty()) {
                    String string8 = Utils.a().getResources().getString(R$string.str_downloaded_title);
                    Intrinsics.f(string8, "getApp().resources.getSt…ing.str_downloaded_title)");
                    DownloadBean downloadBean9 = new DownloadBean("title2", "titleRes2", string8, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean9.setStatus(11);
                    if (list3 != null) {
                        size = list3.size();
                    } else {
                        size = list4.size();
                    }
                    downloadBean9.setCount(size);
                    arrayList.add(downloadBean9);
                    arrayList.addAll(list6);
                }
                uo.b.a.g(uo.b.f78622a, "get getListByStatus success" + arrayList.size(), false, 2, null);
                this.this$0.l(arrayList);
                a2VarC = w0.c();
                anonymousClass5 = new AnonymousClass5(this.this$0, arrayList, null);
                this.L$0 = arrayList;
                this.L$1 = null;
                this.label = 7;
                if (h.g(a2VarC, anonymousClass5, this) == objE) {
                    return objE;
                }
                list7 = arrayList;
                this.this$0.q().n(list7);
                return Unit.f68710a;
            case 2:
                ResultKt.b(obj);
                objN = obj;
                list = (List) objN;
                this.this$0.v().n(list);
                coroutineDispatcherB = w0.b();
                anonymousClass1 = new AnonymousClass1(this.this$0, list, null);
                this.L$0 = list;
                this.label = 3;
                if (h.g(coroutineDispatcherB, anonymousClass1, this) == objE) {
                    return objE;
                }
                DownloadEsHelper downloadEsHelperA3 = DownloadEsHelper.f60994m.a();
                this.L$0 = list;
                this.label = 4;
                objW = DownloadEsHelper.w(downloadEsHelperA3, false, this, 1, null);
                if (objW == objE) {
                    return objE;
                }
                list2 = (List) objW;
                coroutineDispatcherB2 = w0.b();
                anonymousClass2 = new AnonymousClass2(this.this$0, list2, null);
                this.L$0 = list;
                this.L$1 = list2;
                this.label = 5;
                if (h.g(coroutineDispatcherB2, anonymousClass2, this) == objE) {
                    return objE;
                }
                listSubList = list;
                list3 = list2;
                DownloadListManager downloadListManager5 = this.this$0;
                this.L$0 = listSubList;
                this.L$1 = list3;
                this.label = 6;
                objM = downloadListManager5.m(list3, this);
                if (objM == objE) {
                    return objE;
                }
                list4 = (List) objM;
                list5 = listSubList;
                if (!list5.isEmpty()) {
                    this.this$0.I(listSubList, this.$wrapNativeManager);
                } else if (!list4.isEmpty()) {
                    this.this$0.I(list4, this.$wrapNativeManager);
                }
                arrayList = new ArrayList();
                if (!list5.isEmpty()) {
                    String string9 = Utils.a().getResources().getString(R$string.str_downloading_title);
                    Intrinsics.f(string9, "getApp().resources.getSt…ng.str_downloading_title)");
                    DownloadBean downloadBean10 = new DownloadBean("title1", "titleRes1", string9, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean10.setStatus(11);
                    downloadBean10.setMore(true);
                    booleanRef = new Ref.BooleanRef();
                    while (r16.hasNext()) {
                        if (downloadBean2.getAdProvide() != null) {
                            booleanRef.element = true;
                        }
                        if (downloadBean2.getWrapNativeManager() != null) {
                            booleanRef.element = true;
                        }
                        if (booleanRef.element) {
                            if (booleanRef.element) {
                                size2 = listSubList.size() - 1;
                            } else {
                                size2 = listSubList.size();
                            }
                            downloadBean10.setCount(size2);
                            arrayList.add(downloadBean10);
                            if (listSubList.size() > 3) {
                                if (this.$hide) {
                                    listSubList = listSubList.subList(0, 3);
                                }
                                arrayList.addAll(listSubList);
                                Resources resources5 = Utils.a().getResources();
                                if (this.$hide) {
                                    i11 = com.tn.lib.widget.R$string.player_more;
                                } else {
                                    i11 = com.tn.lib.widget.R$string.player_hide;
                                }
                                String string10 = resources5.getString(i11);
                                Intrinsics.f(string10, "getApp().resources.getSt…get.R.string.player_hide)");
                                DownloadBean downloadBean11 = new DownloadBean("title1", "titleRes3", string10, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                                downloadBean11.setStatus(12);
                                downloadBean11.setMore(this.$hide);
                                arrayList.add(downloadBean11);
                            } else {
                                arrayList.addAll(listSubList);
                            }
                        }
                    }
                    if (booleanRef.element) {
                        size2 = listSubList.size() - 1;
                    } else {
                        size2 = listSubList.size();
                    }
                    downloadBean10.setCount(size2);
                    arrayList.add(downloadBean10);
                    if (listSubList.size() > 3) {
                        if (this.$hide) {
                            listSubList = listSubList.subList(0, 3);
                        }
                        arrayList.addAll(listSubList);
                        Resources resources6 = Utils.a().getResources();
                        if (this.$hide) {
                            i11 = com.tn.lib.widget.R$string.player_more;
                        } else {
                            i11 = com.tn.lib.widget.R$string.player_hide;
                        }
                        String string11 = resources6.getString(i11);
                        Intrinsics.f(string11, "getApp().resources.getSt…get.R.string.player_hide)");
                        DownloadBean downloadBean12 = new DownloadBean("title1", "titleRes3", string11, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                        downloadBean12.setStatus(12);
                        downloadBean12.setMore(this.$hide);
                        arrayList.add(downloadBean12);
                    } else {
                        arrayList.addAll(listSubList);
                    }
                }
                list6 = list4;
                if (!list6.isEmpty()) {
                    String string12 = Utils.a().getResources().getString(R$string.str_downloaded_title);
                    Intrinsics.f(string12, "getApp().resources.getSt…ing.str_downloaded_title)");
                    DownloadBean downloadBean13 = new DownloadBean("title2", "titleRes2", string12, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean13.setStatus(11);
                    if (list3 != null) {
                        size = list3.size();
                    } else {
                        size = list4.size();
                    }
                    downloadBean13.setCount(size);
                    arrayList.add(downloadBean13);
                    arrayList.addAll(list6);
                }
                uo.b.a.g(uo.b.f78622a, "get getListByStatus success" + arrayList.size(), false, 2, null);
                this.this$0.l(arrayList);
                a2VarC = w0.c();
                anonymousClass5 = new AnonymousClass5(this.this$0, arrayList, null);
                this.L$0 = arrayList;
                this.L$1 = null;
                this.label = 7;
                if (h.g(a2VarC, anonymousClass5, this) == objE) {
                    return objE;
                }
                list7 = arrayList;
                this.this$0.q().n(list7);
                return Unit.f68710a;
            case 3:
                list = (List) this.L$0;
                ResultKt.b(obj);
                DownloadEsHelper downloadEsHelperA4 = DownloadEsHelper.f60994m.a();
                this.L$0 = list;
                this.label = 4;
                objW = DownloadEsHelper.w(downloadEsHelperA4, false, this, 1, null);
                if (objW == objE) {
                    return objE;
                }
                list2 = (List) objW;
                coroutineDispatcherB2 = w0.b();
                anonymousClass2 = new AnonymousClass2(this.this$0, list2, null);
                this.L$0 = list;
                this.L$1 = list2;
                this.label = 5;
                if (h.g(coroutineDispatcherB2, anonymousClass2, this) == objE) {
                    return objE;
                }
                listSubList = list;
                list3 = list2;
                DownloadListManager downloadListManager6 = this.this$0;
                this.L$0 = listSubList;
                this.L$1 = list3;
                this.label = 6;
                objM = downloadListManager6.m(list3, this);
                if (objM == objE) {
                    return objE;
                }
                list4 = (List) objM;
                list5 = listSubList;
                if (!list5.isEmpty()) {
                    this.this$0.I(listSubList, this.$wrapNativeManager);
                } else if (!list4.isEmpty()) {
                    this.this$0.I(list4, this.$wrapNativeManager);
                }
                arrayList = new ArrayList();
                if (!list5.isEmpty()) {
                    String string13 = Utils.a().getResources().getString(R$string.str_downloading_title);
                    Intrinsics.f(string13, "getApp().resources.getSt…ng.str_downloading_title)");
                    DownloadBean downloadBean14 = new DownloadBean("title1", "titleRes1", string13, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean14.setStatus(11);
                    downloadBean14.setMore(true);
                    booleanRef = new Ref.BooleanRef();
                    while (r16.hasNext()) {
                        if (downloadBean2.getAdProvide() != null) {
                            booleanRef.element = true;
                        }
                        if (downloadBean2.getWrapNativeManager() != null) {
                            booleanRef.element = true;
                        }
                        if (booleanRef.element) {
                            if (booleanRef.element) {
                                size2 = listSubList.size() - 1;
                            } else {
                                size2 = listSubList.size();
                            }
                            downloadBean14.setCount(size2);
                            arrayList.add(downloadBean14);
                            if (listSubList.size() > 3) {
                                if (this.$hide) {
                                    listSubList = listSubList.subList(0, 3);
                                }
                                arrayList.addAll(listSubList);
                                Resources resources7 = Utils.a().getResources();
                                if (this.$hide) {
                                    i11 = com.tn.lib.widget.R$string.player_more;
                                } else {
                                    i11 = com.tn.lib.widget.R$string.player_hide;
                                }
                                String string14 = resources7.getString(i11);
                                Intrinsics.f(string14, "getApp().resources.getSt…get.R.string.player_hide)");
                                DownloadBean downloadBean15 = new DownloadBean("title1", "titleRes3", string14, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                                downloadBean15.setStatus(12);
                                downloadBean15.setMore(this.$hide);
                                arrayList.add(downloadBean15);
                            } else {
                                arrayList.addAll(listSubList);
                            }
                        }
                    }
                    if (booleanRef.element) {
                        size2 = listSubList.size() - 1;
                    } else {
                        size2 = listSubList.size();
                    }
                    downloadBean14.setCount(size2);
                    arrayList.add(downloadBean14);
                    if (listSubList.size() > 3) {
                        if (this.$hide) {
                            listSubList = listSubList.subList(0, 3);
                        }
                        arrayList.addAll(listSubList);
                        Resources resources8 = Utils.a().getResources();
                        if (this.$hide) {
                            i11 = com.tn.lib.widget.R$string.player_more;
                        } else {
                            i11 = com.tn.lib.widget.R$string.player_hide;
                        }
                        String string15 = resources8.getString(i11);
                        Intrinsics.f(string15, "getApp().resources.getSt…get.R.string.player_hide)");
                        DownloadBean downloadBean16 = new DownloadBean("title1", "titleRes3", string15, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                        downloadBean16.setStatus(12);
                        downloadBean16.setMore(this.$hide);
                        arrayList.add(downloadBean16);
                    } else {
                        arrayList.addAll(listSubList);
                    }
                }
                list6 = list4;
                if (!list6.isEmpty()) {
                    String string16 = Utils.a().getResources().getString(R$string.str_downloaded_title);
                    Intrinsics.f(string16, "getApp().resources.getSt…ing.str_downloaded_title)");
                    DownloadBean downloadBean17 = new DownloadBean("title2", "titleRes2", string16, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean17.setStatus(11);
                    if (list3 != null) {
                        size = list3.size();
                    } else {
                        size = list4.size();
                    }
                    downloadBean17.setCount(size);
                    arrayList.add(downloadBean17);
                    arrayList.addAll(list6);
                }
                uo.b.a.g(uo.b.f78622a, "get getListByStatus success" + arrayList.size(), false, 2, null);
                this.this$0.l(arrayList);
                a2VarC = w0.c();
                anonymousClass5 = new AnonymousClass5(this.this$0, arrayList, null);
                this.L$0 = arrayList;
                this.L$1 = null;
                this.label = 7;
                if (h.g(a2VarC, anonymousClass5, this) == objE) {
                    return objE;
                }
                list7 = arrayList;
                this.this$0.q().n(list7);
                return Unit.f68710a;
            case 4:
                list = (List) this.L$0;
                ResultKt.b(obj);
                objW = obj;
                list2 = (List) objW;
                coroutineDispatcherB2 = w0.b();
                anonymousClass2 = new AnonymousClass2(this.this$0, list2, null);
                this.L$0 = list;
                this.L$1 = list2;
                this.label = 5;
                if (h.g(coroutineDispatcherB2, anonymousClass2, this) == objE) {
                    return objE;
                }
                listSubList = list;
                list3 = list2;
                DownloadListManager downloadListManager7 = this.this$0;
                this.L$0 = listSubList;
                this.L$1 = list3;
                this.label = 6;
                objM = downloadListManager7.m(list3, this);
                if (objM == objE) {
                    return objE;
                }
                list4 = (List) objM;
                list5 = listSubList;
                if (!list5.isEmpty()) {
                    this.this$0.I(listSubList, this.$wrapNativeManager);
                } else if (!list4.isEmpty()) {
                    this.this$0.I(list4, this.$wrapNativeManager);
                }
                arrayList = new ArrayList();
                if (!list5.isEmpty()) {
                    String string17 = Utils.a().getResources().getString(R$string.str_downloading_title);
                    Intrinsics.f(string17, "getApp().resources.getSt…ng.str_downloading_title)");
                    DownloadBean downloadBean18 = new DownloadBean("title1", "titleRes1", string17, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean18.setStatus(11);
                    downloadBean18.setMore(true);
                    booleanRef = new Ref.BooleanRef();
                    while (r16.hasNext()) {
                        if (downloadBean2.getAdProvide() != null) {
                            booleanRef.element = true;
                        }
                        if (downloadBean2.getWrapNativeManager() != null) {
                            booleanRef.element = true;
                        }
                        if (booleanRef.element) {
                            if (booleanRef.element) {
                                size2 = listSubList.size() - 1;
                            } else {
                                size2 = listSubList.size();
                            }
                            downloadBean18.setCount(size2);
                            arrayList.add(downloadBean18);
                            if (listSubList.size() > 3) {
                                if (this.$hide) {
                                    listSubList = listSubList.subList(0, 3);
                                }
                                arrayList.addAll(listSubList);
                                Resources resources9 = Utils.a().getResources();
                                if (this.$hide) {
                                    i11 = com.tn.lib.widget.R$string.player_more;
                                } else {
                                    i11 = com.tn.lib.widget.R$string.player_hide;
                                }
                                String string18 = resources9.getString(i11);
                                Intrinsics.f(string18, "getApp().resources.getSt…get.R.string.player_hide)");
                                DownloadBean downloadBean19 = new DownloadBean("title1", "titleRes3", string18, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                                downloadBean19.setStatus(12);
                                downloadBean19.setMore(this.$hide);
                                arrayList.add(downloadBean19);
                            } else {
                                arrayList.addAll(listSubList);
                            }
                        }
                    }
                    if (booleanRef.element) {
                        size2 = listSubList.size() - 1;
                    } else {
                        size2 = listSubList.size();
                    }
                    downloadBean18.setCount(size2);
                    arrayList.add(downloadBean18);
                    if (listSubList.size() > 3) {
                        if (this.$hide) {
                            listSubList = listSubList.subList(0, 3);
                        }
                        arrayList.addAll(listSubList);
                        Resources resources10 = Utils.a().getResources();
                        if (this.$hide) {
                            i11 = com.tn.lib.widget.R$string.player_more;
                        } else {
                            i11 = com.tn.lib.widget.R$string.player_hide;
                        }
                        String string19 = resources10.getString(i11);
                        Intrinsics.f(string19, "getApp().resources.getSt…get.R.string.player_hide)");
                        DownloadBean downloadBean110 = new DownloadBean("title1", "titleRes3", string19, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                        downloadBean110.setStatus(12);
                        downloadBean110.setMore(this.$hide);
                        arrayList.add(downloadBean110);
                    } else {
                        arrayList.addAll(listSubList);
                    }
                }
                list6 = list4;
                if (!list6.isEmpty()) {
                    String string110 = Utils.a().getResources().getString(R$string.str_downloaded_title);
                    Intrinsics.f(string110, "getApp().resources.getSt…ing.str_downloaded_title)");
                    DownloadBean downloadBean111 = new DownloadBean("title2", "titleRes2", string110, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean111.setStatus(11);
                    if (list3 != null) {
                        size = list3.size();
                    } else {
                        size = list4.size();
                    }
                    downloadBean111.setCount(size);
                    arrayList.add(downloadBean111);
                    arrayList.addAll(list6);
                }
                uo.b.a.g(uo.b.f78622a, "get getListByStatus success" + arrayList.size(), false, 2, null);
                this.this$0.l(arrayList);
                a2VarC = w0.c();
                anonymousClass5 = new AnonymousClass5(this.this$0, arrayList, null);
                this.L$0 = arrayList;
                this.L$1 = null;
                this.label = 7;
                if (h.g(a2VarC, anonymousClass5, this) == objE) {
                    return objE;
                }
                list7 = arrayList;
                this.this$0.q().n(list7);
                return Unit.f68710a;
            case 5:
                list3 = (List) this.L$1;
                listSubList = (List) this.L$0;
                ResultKt.b(obj);
                DownloadListManager downloadListManager8 = this.this$0;
                this.L$0 = listSubList;
                this.L$1 = list3;
                this.label = 6;
                objM = downloadListManager8.m(list3, this);
                if (objM == objE) {
                    return objE;
                }
                list4 = (List) objM;
                list5 = listSubList;
                if (!list5.isEmpty()) {
                    this.this$0.I(listSubList, this.$wrapNativeManager);
                } else if (!list4.isEmpty()) {
                    this.this$0.I(list4, this.$wrapNativeManager);
                }
                arrayList = new ArrayList();
                if (!list5.isEmpty()) {
                    String string111 = Utils.a().getResources().getString(R$string.str_downloading_title);
                    Intrinsics.f(string111, "getApp().resources.getSt…ng.str_downloading_title)");
                    DownloadBean downloadBean112 = new DownloadBean("title1", "titleRes1", string111, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean112.setStatus(11);
                    downloadBean112.setMore(true);
                    booleanRef = new Ref.BooleanRef();
                    while (r16.hasNext()) {
                        if (downloadBean2.getAdProvide() != null) {
                            booleanRef.element = true;
                        }
                        if (downloadBean2.getWrapNativeManager() != null) {
                            booleanRef.element = true;
                        }
                        if (booleanRef.element) {
                            if (booleanRef.element) {
                                size2 = listSubList.size() - 1;
                            } else {
                                size2 = listSubList.size();
                            }
                            downloadBean112.setCount(size2);
                            arrayList.add(downloadBean112);
                            if (listSubList.size() > 3) {
                                if (this.$hide) {
                                    listSubList = listSubList.subList(0, 3);
                                }
                                arrayList.addAll(listSubList);
                                Resources resources11 = Utils.a().getResources();
                                if (this.$hide) {
                                    i11 = com.tn.lib.widget.R$string.player_more;
                                } else {
                                    i11 = com.tn.lib.widget.R$string.player_hide;
                                }
                                String string112 = resources11.getString(i11);
                                Intrinsics.f(string112, "getApp().resources.getSt…get.R.string.player_hide)");
                                DownloadBean downloadBean113 = new DownloadBean("title1", "titleRes3", string112, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                                downloadBean113.setStatus(12);
                                downloadBean113.setMore(this.$hide);
                                arrayList.add(downloadBean113);
                            } else {
                                arrayList.addAll(listSubList);
                            }
                        }
                    }
                    if (booleanRef.element) {
                        size2 = listSubList.size() - 1;
                    } else {
                        size2 = listSubList.size();
                    }
                    downloadBean112.setCount(size2);
                    arrayList.add(downloadBean112);
                    if (listSubList.size() > 3) {
                        if (this.$hide) {
                            listSubList = listSubList.subList(0, 3);
                        }
                        arrayList.addAll(listSubList);
                        Resources resources12 = Utils.a().getResources();
                        if (this.$hide) {
                            i11 = com.tn.lib.widget.R$string.player_more;
                        } else {
                            i11 = com.tn.lib.widget.R$string.player_hide;
                        }
                        String string113 = resources12.getString(i11);
                        Intrinsics.f(string113, "getApp().resources.getSt…get.R.string.player_hide)");
                        DownloadBean downloadBean114 = new DownloadBean("title1", "titleRes3", string113, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                        downloadBean114.setStatus(12);
                        downloadBean114.setMore(this.$hide);
                        arrayList.add(downloadBean114);
                    } else {
                        arrayList.addAll(listSubList);
                    }
                }
                list6 = list4;
                if (!list6.isEmpty()) {
                    String string114 = Utils.a().getResources().getString(R$string.str_downloaded_title);
                    Intrinsics.f(string114, "getApp().resources.getSt…ing.str_downloaded_title)");
                    DownloadBean downloadBean115 = new DownloadBean("title2", "titleRes2", string114, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean115.setStatus(11);
                    if (list3 != null) {
                        size = list3.size();
                    } else {
                        size = list4.size();
                    }
                    downloadBean115.setCount(size);
                    arrayList.add(downloadBean115);
                    arrayList.addAll(list6);
                }
                uo.b.a.g(uo.b.f78622a, "get getListByStatus success" + arrayList.size(), false, 2, null);
                this.this$0.l(arrayList);
                a2VarC = w0.c();
                anonymousClass5 = new AnonymousClass5(this.this$0, arrayList, null);
                this.L$0 = arrayList;
                this.L$1 = null;
                this.label = 7;
                if (h.g(a2VarC, anonymousClass5, this) == objE) {
                    return objE;
                }
                list7 = arrayList;
                this.this$0.q().n(list7);
                return Unit.f68710a;
            case 6:
                list3 = (List) this.L$1;
                listSubList = (List) this.L$0;
                ResultKt.b(obj);
                objM = obj;
                list4 = (List) objM;
                list5 = listSubList;
                if (!list5.isEmpty()) {
                    this.this$0.I(listSubList, this.$wrapNativeManager);
                } else if (!list4.isEmpty()) {
                    this.this$0.I(list4, this.$wrapNativeManager);
                }
                arrayList = new ArrayList();
                if (!list5.isEmpty()) {
                    String string115 = Utils.a().getResources().getString(R$string.str_downloading_title);
                    Intrinsics.f(string115, "getApp().resources.getSt…ng.str_downloading_title)");
                    DownloadBean downloadBean116 = new DownloadBean("title1", "titleRes1", string115, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean116.setStatus(11);
                    downloadBean116.setMore(true);
                    booleanRef = new Ref.BooleanRef();
                    while (r16.hasNext()) {
                        if (downloadBean2.getAdProvide() != null) {
                            booleanRef.element = true;
                        }
                        if (downloadBean2.getWrapNativeManager() != null) {
                            booleanRef.element = true;
                        }
                        if (booleanRef.element) {
                            if (booleanRef.element) {
                                size2 = listSubList.size() - 1;
                            } else {
                                size2 = listSubList.size();
                            }
                            downloadBean116.setCount(size2);
                            arrayList.add(downloadBean116);
                            if (listSubList.size() > 3) {
                                if (this.$hide) {
                                    listSubList = listSubList.subList(0, 3);
                                }
                                arrayList.addAll(listSubList);
                                Resources resources13 = Utils.a().getResources();
                                if (this.$hide) {
                                    i11 = com.tn.lib.widget.R$string.player_more;
                                } else {
                                    i11 = com.tn.lib.widget.R$string.player_hide;
                                }
                                String string116 = resources13.getString(i11);
                                Intrinsics.f(string116, "getApp().resources.getSt…get.R.string.player_hide)");
                                DownloadBean downloadBean117 = new DownloadBean("title1", "titleRes3", string116, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                                downloadBean117.setStatus(12);
                                downloadBean117.setMore(this.$hide);
                                arrayList.add(downloadBean117);
                            } else {
                                arrayList.addAll(listSubList);
                            }
                        }
                    }
                    if (booleanRef.element) {
                        size2 = listSubList.size() - 1;
                    } else {
                        size2 = listSubList.size();
                    }
                    downloadBean116.setCount(size2);
                    arrayList.add(downloadBean116);
                    if (listSubList.size() > 3) {
                        if (this.$hide) {
                            listSubList = listSubList.subList(0, 3);
                        }
                        arrayList.addAll(listSubList);
                        Resources resources14 = Utils.a().getResources();
                        if (this.$hide) {
                            i11 = com.tn.lib.widget.R$string.player_more;
                        } else {
                            i11 = com.tn.lib.widget.R$string.player_hide;
                        }
                        String string117 = resources14.getString(i11);
                        Intrinsics.f(string117, "getApp().resources.getSt…get.R.string.player_hide)");
                        DownloadBean downloadBean118 = new DownloadBean("title1", "titleRes3", string117, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                        downloadBean118.setStatus(12);
                        downloadBean118.setMore(this.$hide);
                        arrayList.add(downloadBean118);
                    } else {
                        arrayList.addAll(listSubList);
                    }
                }
                list6 = list4;
                if (!list6.isEmpty()) {
                    String string118 = Utils.a().getResources().getString(R$string.str_downloaded_title);
                    Intrinsics.f(string118, "getApp().resources.getSt…ing.str_downloaded_title)");
                    DownloadBean downloadBean119 = new DownloadBean("title2", "titleRes2", string118, "", Boxing.e(0L), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
                    downloadBean119.setStatus(11);
                    if (list3 != null) {
                        size = list3.size();
                    } else {
                        size = list4.size();
                    }
                    downloadBean119.setCount(size);
                    arrayList.add(downloadBean119);
                    arrayList.addAll(list6);
                }
                uo.b.a.g(uo.b.f78622a, "get getListByStatus success" + arrayList.size(), false, 2, null);
                this.this$0.l(arrayList);
                a2VarC = w0.c();
                anonymousClass5 = new AnonymousClass5(this.this$0, arrayList, null);
                this.L$0 = arrayList;
                this.L$1 = null;
                this.label = 7;
                if (h.g(a2VarC, anonymousClass5, this) == objE) {
                    return objE;
                }
                list7 = arrayList;
                this.this$0.q().n(list7);
                return Unit.f68710a;
            case 7:
                list7 = (List) this.L$0;
                ResultKt.b(obj);
                this.this$0.q().n(list7);
                return Unit.f68710a;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
