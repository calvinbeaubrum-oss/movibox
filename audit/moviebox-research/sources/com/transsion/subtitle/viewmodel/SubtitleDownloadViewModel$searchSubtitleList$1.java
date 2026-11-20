package com.transsion.subtitle.viewmodel;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import com.transsion.moviedetailapi.bean.SubtitleItem;
import com.transsion.subtitle.bean.SubtitleSearchListBean;
import com.transsion.subtitle.fragment.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.k0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1", f = "SubtitleDownloadViewModel.kt", l = {152}, m = "invokeSuspend")
@SourceDebugExtension
public final class SubtitleDownloadViewModel$searchSubtitleList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $downloadBean;
    final /* synthetic */ g $keyword;
    final /* synthetic */ List<SubtitleLanguageMapBean> $languageList;
    final /* synthetic */ String $languages;
    final /* synthetic */ String $nextPage;
    final /* synthetic */ int $perPage;
    int label;
    final /* synthetic */ SubtitleDownloadViewModel this$0;

    /* JADX INFO: renamed from: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$1", f = "SubtitleDownloadViewModel.kt", l = {141, 141}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b<? super SubtitleSearchListBean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ DownloadBean $downloadBean;
        final /* synthetic */ g $keyword;
        final /* synthetic */ List<SubtitleLanguageMapBean> $languageList;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SubtitleDownloadViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SubtitleDownloadViewModel subtitleDownloadViewModel, DownloadBean downloadBean, g gVar, List<SubtitleLanguageMapBean> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = subtitleDownloadViewModel;
            this.$downloadBean = downloadBean;
            this.$keyword = gVar;
            this.$languageList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$downloadBean, this.$keyword, this.$languageList, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(b<? super SubtitleSearchListBean> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            b bVar;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    bVar = (b) this.L$0;
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            bVar = (b) this.L$0;
            SubtitleDownloadViewModel subtitleDownloadViewModel = this.this$0;
            DownloadBean downloadBean = this.$downloadBean;
            g gVar = this.$keyword;
            List<SubtitleLanguageMapBean> list = this.$languageList;
            this.L$0 = bVar;
            this.label = 1;
            obj = subtitleDownloadViewModel.q(downloadBean, gVar, list, this);
            if (obj == objE) {
                return objE;
            }
            this.L$0 = null;
            this.label = 2;
            if (bVar.emit(obj, this) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$3", f = "SubtitleDownloadViewModel.kt", l = {151}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<b<? super SubtitleSearchListBean>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(b<? super SubtitleSearchListBean> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = bVar;
            return anonymousClass3.invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                b bVar = (b) this.L$0;
                this.label = 1;
                if (bVar.emit(null, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubtitleDownloadViewModel f58332a;

        public a(SubtitleDownloadViewModel subtitleDownloadViewModel) {
            this.f58332a = subtitleDownloadViewModel;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(SubtitleSearchListBean subtitleSearchListBean, Continuation<? super Unit> continuation) {
            this.f58332a.m().n(subtitleSearchListBean);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleDownloadViewModel$searchSubtitleList$1(SubtitleDownloadViewModel subtitleDownloadViewModel, DownloadBean downloadBean, g gVar, List<SubtitleLanguageMapBean> list, String str, String str2, int i11, Continuation<? super SubtitleDownloadViewModel$searchSubtitleList$1> continuation) {
        super(2, continuation);
        this.this$0 = subtitleDownloadViewModel;
        this.$downloadBean = downloadBean;
        this.$keyword = gVar;
        this.$languageList = list;
        this.$languages = str;
        this.$nextPage = str2;
        this.$perPage = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubtitleDownloadViewModel$searchSubtitleList$1(this.this$0, this.$downloadBean, this.$keyword, this.$languageList, this.$languages, this.$nextPage, this.$perPage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubtitleDownloadViewModel$searchSubtitleList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            final kotlinx.coroutines.flow.a aVarO = c.o(new AnonymousClass1(this.this$0, this.$downloadBean, this.$keyword, this.$languageList, null));
            final SubtitleDownloadViewModel subtitleDownloadViewModel = this.this$0;
            final g gVar = this.$keyword;
            final String str = this.$languages;
            final DownloadBean downloadBean = this.$downloadBean;
            final String str2 = this.$nextPage;
            final int i12 = this.$perPage;
            kotlinx.coroutines.flow.a aVarE = c.e(new kotlinx.coroutines.flow.a<SubtitleSearchListBean>() { // from class: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1

                /* JADX INFO: renamed from: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @SourceDebugExtension
                public static final class AnonymousClass2<T> implements b {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ b f58340a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ SubtitleDownloadViewModel f58341b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ g f58342c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    public final /* synthetic */ String f58343d;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    public final /* synthetic */ DownloadBean f58344f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    public final /* synthetic */ String f58345g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    public final /* synthetic */ int f58346h;

                    /* JADX INFO: renamed from: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @DebugMetadata(c = "com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1$2", f = "SubtitleDownloadViewModel.kt", l = {221, 219}, m = "emit")
                    @SourceDebugExtension
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(b bVar, SubtitleDownloadViewModel subtitleDownloadViewModel, g gVar, String str, DownloadBean downloadBean, String str2, int i11) {
                        this.f58340a = bVar;
                        this.f58341b = subtitleDownloadViewModel;
                        this.f58342c = gVar;
                        this.f58343d = str;
                        this.f58344f = downloadBean;
                        this.f58345g = str2;
                        this.f58346h = i11;
                    }

                    /* JADX WARN: Code duplicated, block: B:31:0x007f A[RETURN] */
                    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.b
                    public final Object emit(Object obj, Continuation continuation) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        b bVar;
                        b bVar2;
                        Object obj2;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i11 = anonymousClass1.label;
                            if ((i11 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i11 - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                        Object obj3 = anonymousClass1.result;
                        Object objE = a.e();
                        int i12 = anonymousClass1.label;
                        if (i12 != 0) {
                            if (i12 == 1) {
                                b bVar3 = (b) anonymousClass1.L$0;
                                ResultKt.b(obj3);
                                bVar = bVar3;
                            } else {
                                if (i12 != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.b(obj3);
                            }
                            return Unit.f68710a;
                        }
                        ResultKt.b(obj3);
                        b bVar4 = this.f58340a;
                        SubtitleSearchListBean subtitleSearchListBean = (SubtitleSearchListBean) obj;
                        List<SubtitleItem> items = subtitleSearchListBean != null ? subtitleSearchListBean.getItems() : null;
                        if (items == null || items.isEmpty()) {
                            obj2 = subtitleSearchListBean;
                            bVar2 = bVar4;
                            SubtitleDownloadViewModel subtitleDownloadViewModel = this.f58341b;
                            g gVar = this.f58342c;
                            String str = this.f58343d;
                            DownloadBean downloadBean = this.f58344f;
                            String str2 = this.f58345g;
                            int i13 = this.f58346h;
                            anonymousClass1.L$0 = bVar4;
                            anonymousClass1.label = 1;
                            Object objP = subtitleDownloadViewModel.p(gVar, str, downloadBean, str2, i13, anonymousClass1);
                            if (objP == objE) {
                                return objE;
                            }
                            obj3 = objP;
                            bVar = bVar4;
                        }
                        obj2 = subtitleSearchListBean;
                        bVar2 = bVar4;
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 2;
                        if (bVar2.emit(obj2, anonymousClass1) == objE) {
                            return objE;
                        }
                        return Unit.f68710a;
                        Object obj4 = obj3;
                        bVar2 = bVar;
                        obj2 = obj4;
                        obj2 = subtitleSearchListBean;
                        bVar2 = bVar4;
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 2;
                        if (bVar2.emit(obj2, anonymousClass1) == objE) {
                            return objE;
                        }
                        return Unit.f68710a;
                    }
                }

                @Override // kotlinx.coroutines.flow.a
                public Object a(b<? super SubtitleSearchListBean> bVar, Continuation continuation) {
                    Object objA = aVarO.a(new AnonymousClass2(bVar, subtitleDownloadViewModel, gVar, str, downloadBean, str2, i12), continuation);
                    return objA == a.e() ? objA : Unit.f68710a;
                }
            }, new AnonymousClass3(null));
            a aVar = new a(this.this$0);
            this.label = 1;
            if (aVarE.a(aVar, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
