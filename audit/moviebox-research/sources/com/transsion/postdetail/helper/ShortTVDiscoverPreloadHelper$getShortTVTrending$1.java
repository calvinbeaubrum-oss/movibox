package com.transsion.postdetail.helper;

import androidx.lifecycle.c0;
import com.blankj.utilcode.util.n;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.viewmodel.ImmVideoRequestEntity;
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
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;
import okhttp3.RequestBody;

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
@DebugMetadata(c = "com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$getShortTVTrending$1", f = "ShortTVDiscoverPreloadHelper.kt", l = {222}, m = "invokeSuspend")
public final class ShortTVDiscoverPreloadHelper$getShortTVTrending$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ ImmVideoRequestEntity $requestEntity;
    int label;
    final /* synthetic */ ShortTVDiscoverPreloadHelper this$0;

    /* JADX INFO: renamed from: com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$getShortTVTrending$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$getShortTVTrending$1$1", f = "ShortTVDiscoverPreloadHelper.kt", l = {217, 218}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b<? super ShortTVRespData>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImmVideoRequestEntity $requestEntity;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ShortTVDiscoverPreloadHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ImmVideoRequestEntity immVideoRequestEntity, ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelper, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$requestEntity = immVideoRequestEntity;
            this.this$0 = shortTVDiscoverPreloadHelper;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$requestEntity, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.b<? super ShortTVRespData> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0065 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlinx.coroutines.flow.b bVar;
            Object data;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ip.b.a aVar = ip.b.f67591a;
                String strJ = n.j(this.$requestEntity);
                Intrinsics.f(strJ, "toJson(requestEntity)");
                RequestBody requestBodyA = aVar.a(strJ);
                if (requestBodyA != null) {
                    xv.b bVarA = this.this$0.A();
                    String strA = cp.a.f62775a.a();
                    this.L$0 = bVar;
                    this.label = 1;
                    obj = bVarA.f(strA, requestBodyA, this);
                    if (obj == objE) {
                        return objE;
                    }
                    data = ((BaseDto) obj).getData();
                    this.L$0 = null;
                    this.label = 2;
                    if (bVar.emit(data, this) == objE) {
                        return objE;
                    }
                }
            } else if (i11 == 1) {
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
                data = ((BaseDto) obj).getData();
                this.L$0 = null;
                this.label = 2;
                if (bVar.emit(data, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$getShortTVTrending$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$getShortTVTrending$1$2", f = "ShortTVDiscoverPreloadHelper.kt", l = {221}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b<? super ShortTVRespData>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.b<? super ShortTVRespData> bVar, Throwable th2, Continuation<? super Unit> continuation) {
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
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
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
    public static final class a<T> implements kotlinx.coroutines.flow.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShortTVDiscoverPreloadHelper f55049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f55050b;

        public a(ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelper, boolean z11) {
            this.f55049a = shortTVDiscoverPreloadHelper;
            this.f55050b = z11;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(ShortTVRespData shortTVRespData, Continuation<? super Unit> continuation) {
            List<Subject> items;
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, "DiscoverPreload", "Trending 接口返回 " + shortTVRespData, false, 4, null);
            if (shortTVRespData != null && (items = shortTVRespData.getItems()) != null && !items.isEmpty()) {
                this.f55049a.f55044k.set(true);
            }
            this.f55049a.f55041h = true;
            if (this.f55049a.D() == null) {
                this.f55049a.N(new c0<>());
                this.f55049a.s();
            }
            if (shortTVRespData != null) {
                shortTVRespData.setRefresh(this.f55050b);
            }
            uo.b.a.f(aVar, "DiscoverPreload", "设置 TrendingLiveData, " + this.f55049a.D(), false, 4, null);
            c0<ShortTVRespData> c0VarD = this.f55049a.D();
            if (c0VarD != null) {
                c0VarD.q(shortTVRespData);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverPreloadHelper$getShortTVTrending$1(ImmVideoRequestEntity immVideoRequestEntity, ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelper, boolean z11, Continuation<? super ShortTVDiscoverPreloadHelper$getShortTVTrending$1> continuation) {
        super(2, continuation);
        this.$requestEntity = immVideoRequestEntity;
        this.this$0 = shortTVDiscoverPreloadHelper;
        this.$isRefresh = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVDiscoverPreloadHelper$getShortTVTrending$1(this.$requestEntity, this.this$0, this.$isRefresh, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTVDiscoverPreloadHelper$getShortTVTrending$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.q(kotlinx.coroutines.flow.c.o(new AnonymousClass1(this.$requestEntity, this.this$0, null)), w0.b()), new AnonymousClass2(null));
            a aVar = new a(this.this$0, this.$isRefresh);
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
