package com.transsion.postdetail.viewmodel;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.utils.l;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;
import xv.c;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostNearby$1", f = "RoomPostViewModel.kt", l = {141}, m = "invokeSuspend")
public final class RoomPostViewModel$getPostNearby$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ double $lat;
    final /* synthetic */ double $lon;
    final /* synthetic */ String $page;
    final /* synthetic */ int $perPage;
    int label;
    final /* synthetic */ RoomPostViewModel this$0;

    /* JADX INFO: renamed from: com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostNearby$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostNearby$1$1", f = "RoomPostViewModel.kt", l = {133, TsExtractor.TS_STREAM_TYPE_E_AC3, 137}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b<? super PostSubjectBean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $lat;
        final /* synthetic */ double $lon;
        final /* synthetic */ String $page;
        final /* synthetic */ int $perPage;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RoomPostViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RoomPostViewModel roomPostViewModel, String str, int i11, double d11, double d12, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = roomPostViewModel;
            this.$page = str;
            this.$perPage = i11;
            this.$lon = d11;
            this.$lat = d12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$page, this.$perPage, this.$lon, this.$lat, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(b<? super PostSubjectBean> bVar, Continuation<? super Unit> continuation) {
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
                    if (i11 != 2 && i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            bVar = (b) this.L$0;
            c cVarY = this.this$0.y();
            String strA = cp.a.f62775a.a();
            String str = this.$page;
            int i12 = this.$perPage;
            double d11 = this.$lon;
            double d12 = this.$lat;
            this.L$0 = bVar;
            this.label = 1;
            obj = cVarY.c(strA, str, i12, d11, d12, this);
            if (obj == objE) {
                return objE;
            }
            BaseDto baseDto = (BaseDto) obj;
            if (Intrinsics.b(baseDto.getCode(), "0")) {
                Object data = baseDto.getData();
                this.L$0 = null;
                this.label = 3;
                if (bVar.emit(data, this) == objE) {
                    return objE;
                }
            } else {
                this.L$0 = null;
                this.label = 2;
                if (bVar.emit(null, this) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostNearby$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostNearby$1$2", f = "RoomPostViewModel.kt", l = {140}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<b<? super PostSubjectBean>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(b<? super PostSubjectBean> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = bVar;
            return anonymousClass2.invokeSuspend(Unit.f68710a);
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
    @SourceDebugExtension
    public static final class a<T> implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f56307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RoomPostViewModel f56308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ double f56309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ double f56310d;

        public a(boolean z11, RoomPostViewModel roomPostViewModel, double d11, double d12) {
            this.f56307a = z11;
            this.f56308b = roomPostViewModel;
            this.f56309c = d11;
            this.f56310d = d12;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(PostSubjectBean postSubjectBean, Continuation<? super Unit> continuation) {
            List<PostSubjectItem> items;
            if (postSubjectBean != null) {
                postSubjectBean.setRefresh(this.f56307a);
            }
            if (postSubjectBean != null && (items = postSubjectBean.getItems()) != null) {
                double d11 = this.f56309c;
                double d12 = this.f56310d;
                for (Iterator<T> it = items.iterator(); it.hasNext(); it = it) {
                    PostSubjectItem postSubjectItem = (PostSubjectItem) it.next();
                    if (postSubjectItem.getLat() != null && postSubjectItem.getLon() != null) {
                        l lVar = l.f51319a;
                        Float lat = postSubjectItem.getLat();
                        Intrinsics.d(lat);
                        double dFloatValue = lat.floatValue();
                        Float lon = postSubjectItem.getLon();
                        Intrinsics.d(lon);
                        postSubjectItem.setDistanceStr(lVar.a(d11, d12, dFloatValue, lon.floatValue()));
                    }
                }
            }
            this.f56308b.f56297f.n(postSubjectBean);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomPostViewModel$getPostNearby$1(RoomPostViewModel roomPostViewModel, String str, int i11, double d11, double d12, boolean z11, Continuation<? super RoomPostViewModel$getPostNearby$1> continuation) {
        super(2, continuation);
        this.this$0 = roomPostViewModel;
        this.$page = str;
        this.$perPage = i11;
        this.$lon = d11;
        this.$lat = d12;
        this.$isRefresh = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomPostViewModel$getPostNearby$1(this.this$0, this.$page, this.$perPage, this.$lon, this.$lat, this.$isRefresh, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((RoomPostViewModel$getPostNearby$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.o(new AnonymousClass1(this.this$0, this.$page, this.$perPage, this.$lon, this.$lat, null)), new AnonymousClass2(null));
            a aVar = new a(this.$isRefresh, this.this$0, this.$lat, this.$lon);
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
