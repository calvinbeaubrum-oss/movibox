package com.transsion.postdetail.helper;

import android.content.Context;
import androidx.lifecycle.c0;
import com.blankj.utilcode.util.n;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.OperatingResp;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$loadCache$1", f = "ShortTVDiscoverPreloadHelper.kt", l = {}, m = "invokeSuspend")
public final class ShortTVDiscoverPreloadHelper$loadCache$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ShortTVDiscoverPreloadHelper this$0;

    /* JADX INFO: renamed from: com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$loadCache$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$loadCache$1$1", f = "ShortTVDiscoverPreloadHelper.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ ShortTVDiscoverPreloadHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelper, Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = shortTVDiscoverPreloadHelper;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$context, continuation);
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
            ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelper = this.this$0;
            Context context = this.$context;
            try {
                Result.Companion companion = Result.Companion;
                String string = RoomAppMMKV.f51271a.a().getString("short_tv_operating_data", "");
                if (string == null || string.length() == 0) {
                    string = shortTVDiscoverPreloadHelper.z().a(context);
                }
                OperatingResp operatingResp = (OperatingResp) n.d(string, OperatingResp.class);
                Unit unit = null;
                if (operatingResp != null) {
                    Intrinsics.f(operatingResp, "fromJson(gsonBanner, OperatingResp::class.java)");
                    operatingResp.setSourceFrom("from_cache");
                    shortTVDiscoverPreloadHelper.u(operatingResp);
                    if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                        uo.b.a.f(uo.b.f78622a, "DiscoverPreload", "1---Operating 缓存已加载好，预存缓存", false, 4, null);
                        if (shortTVDiscoverPreloadHelper.f55037d == null) {
                            shortTVDiscoverPreloadHelper.f55037d = new c0();
                        }
                        c0 c0Var = shortTVDiscoverPreloadHelper.f55037d;
                        if (c0Var != null) {
                            c0Var.n(operatingResp);
                            unit = Unit.f68710a;
                        }
                    } else {
                        uo.b.a.f(uo.b.f78622a, "DiscoverPreload", "1---Operating 缓存已加载好，无网直接设置", false, 4, null);
                        List<BannerData> banners = operatingResp.getBanners();
                        if (banners == null || !(!banners.isEmpty())) {
                            unit = Unit.f68710a;
                        } else {
                            if (shortTVDiscoverPreloadHelper.y() == null) {
                                shortTVDiscoverPreloadHelper.L(new c0<>());
                            }
                            c0<OperatingResp> c0VarY = shortTVDiscoverPreloadHelper.y();
                            if (c0VarY != null) {
                                c0VarY.n(operatingResp);
                                unit = Unit.f68710a;
                            }
                        }
                    }
                }
                Result.m163constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$loadCache$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$loadCache$1$2", f = "ShortTVDiscoverPreloadHelper.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ ShortTVDiscoverPreloadHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelper, Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = shortTVDiscoverPreloadHelper;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$context, continuation);
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
            ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelper = this.this$0;
            Context context = this.$context;
            try {
                Result.Companion companion = Result.Companion;
                String string = RoomAppMMKV.f51271a.a().getString("k_cache_short_tv_trending", "");
                if (string == null || string.length() == 0) {
                    string = shortTVDiscoverPreloadHelper.z().b(context);
                }
                Unit unit = null;
                Object objE = (string == null || string.length() <= 0) ? null : n.e(string, n.g(Subject.class));
                ArrayList arrayList = new ArrayList();
                List list = (List) objE;
                if (list != null) {
                    arrayList.addAll(list);
                }
                ShortTVRespData shortTVRespData = new ShortTVRespData(arrayList, new Pager(Boxing.a(true), null, null, null, null), true);
                if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                    uo.b.a.f(uo.b.f78622a, "DiscoverPreload", "Trending 缓存已加载好， 预存缓存", false, 4, null);
                    if (shortTVDiscoverPreloadHelper.f55038e == null) {
                        shortTVDiscoverPreloadHelper.f55038e = new c0();
                    }
                    c0 c0Var = shortTVDiscoverPreloadHelper.f55038e;
                    if (c0Var != null) {
                        c0Var.n(shortTVRespData);
                        unit = Unit.f68710a;
                    }
                } else {
                    uo.b.a.f(uo.b.f78622a, "DiscoverPreload", "Trending 缓存已加载好， 无网直接设置", false, 4, null);
                    List<Subject> items = shortTVRespData.getItems();
                    if (items == null || !(!items.isEmpty())) {
                        unit = Unit.f68710a;
                    } else {
                        if (shortTVDiscoverPreloadHelper.D() == null) {
                            shortTVDiscoverPreloadHelper.N(new c0<>());
                        }
                        c0<ShortTVRespData> c0VarD = shortTVDiscoverPreloadHelper.D();
                        if (c0VarD != null) {
                            c0VarD.n(shortTVRespData);
                            unit = Unit.f68710a;
                        }
                    }
                }
                Result.m163constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverPreloadHelper$loadCache$1(ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelper, Context context, Continuation<? super ShortTVDiscoverPreloadHelper$loadCache$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTVDiscoverPreloadHelper;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShortTVDiscoverPreloadHelper$loadCache$1 shortTVDiscoverPreloadHelper$loadCache$1 = new ShortTVDiscoverPreloadHelper$loadCache$1(this.this$0, this.$context, continuation);
        shortTVDiscoverPreloadHelper$loadCache$1.L$0 = obj;
        return shortTVDiscoverPreloadHelper$loadCache$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTVDiscoverPreloadHelper$loadCache$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        k0 k0Var = (k0) this.L$0;
        j.d(k0Var, null, null, new AnonymousClass1(this.this$0, this.$context, null), 3, null);
        j.d(k0Var, null, null, new AnonymousClass2(this.this$0, this.$context, null), 3, null);
        return Unit.f68710a;
    }
}
