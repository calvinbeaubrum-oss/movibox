package com.transsion.publish.viewmodel;

import androidx.media3.container.MdtaMetadataEntry;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.utils.l;
import com.transsion.publish.api.bean.LocationPlaceBean;
import com.transsion.room.api.bean.LocationPlace;
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
import kotlinx.coroutines.flow.c;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.publish.viewmodel.LocationPlaceViewModel$getLocationPlaceList$1", f = "LocationPlaceViewModel.kt", l = {MdtaMetadataEntry.TYPE_INDICATOR_INT32}, m = "invokeSuspend")
public final class LocationPlaceViewModel$getLocationPlaceList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Double $lat;
    final /* synthetic */ Double $lon;
    int label;
    final /* synthetic */ LocationPlaceViewModel this$0;

    /* JADX INFO: renamed from: com.transsion.publish.viewmodel.LocationPlaceViewModel$getLocationPlaceList$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.publish.viewmodel.LocationPlaceViewModel$getLocationPlaceList$1$1", f = "LocationPlaceViewModel.kt", l = {50, 52, 62}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b<? super LocationPlaceBean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Double $lat;
        final /* synthetic */ Double $lon;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LocationPlaceViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LocationPlaceViewModel locationPlaceViewModel, Double d11, Double d12, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = locationPlaceViewModel;
            this.$lat = d11;
            this.$lon = d12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$lat, this.$lon, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(b<? super LocationPlaceBean> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            b bVar;
            Object objA;
            LocationPlaceBean locationPlaceBean;
            List<LocationPlace> items;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    bVar = (b) this.L$0;
                    ResultKt.b(obj);
                    objA = obj;
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
            hw.a aVarL = this.this$0.l();
            String strA = cp.a.f62775a.a();
            Double d11 = this.$lat;
            Double d12 = this.$lon;
            this.L$0 = bVar;
            this.label = 1;
            objA = aVarL.a(strA, d11, d12, this);
            if (objA == objE) {
                return objE;
            }
            BaseDto baseDto = (BaseDto) objA;
            if (Intrinsics.b(baseDto.getCode(), "0")) {
                if (this.$lat != null && this.$lon != null && (locationPlaceBean = (LocationPlaceBean) baseDto.getData()) != null && (items = locationPlaceBean.getItems()) != null) {
                    Double d13 = this.$lat;
                    Double d14 = this.$lon;
                    for (LocationPlace locationPlace : items) {
                        if (locationPlace.getLat() != null && locationPlace.getLon() != null) {
                            l lVar = l.f51319a;
                            double dDoubleValue = d13.doubleValue();
                            double dDoubleValue2 = d14.doubleValue();
                            Double lat = locationPlace.getLat();
                            Intrinsics.d(lat);
                            double dDoubleValue3 = lat.doubleValue();
                            Double lon = locationPlace.getLon();
                            Intrinsics.d(lon);
                            locationPlace.setDistance(lVar.a(dDoubleValue, dDoubleValue2, dDoubleValue3, lon.doubleValue()));
                        }
                    }
                }
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

    /* JADX INFO: renamed from: com.transsion.publish.viewmodel.LocationPlaceViewModel$getLocationPlaceList$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.publish.viewmodel.LocationPlaceViewModel$getLocationPlaceList$1$2", f = "LocationPlaceViewModel.kt", l = {66}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<b<? super LocationPlaceBean>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(b<? super LocationPlaceBean> bVar, Throwable th2, Continuation<? super Unit> continuation) {
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
    public static final class a<T> implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationPlaceViewModel f56808a;

        public a(LocationPlaceViewModel locationPlaceViewModel) {
            this.f56808a = locationPlaceViewModel;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(LocationPlaceBean locationPlaceBean, Continuation<? super Unit> continuation) {
            this.f56808a.f56805c.n(locationPlaceBean != null ? locationPlaceBean.getItems() : null);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationPlaceViewModel$getLocationPlaceList$1(LocationPlaceViewModel locationPlaceViewModel, Double d11, Double d12, Continuation<? super LocationPlaceViewModel$getLocationPlaceList$1> continuation) {
        super(2, continuation);
        this.this$0 = locationPlaceViewModel;
        this.$lat = d11;
        this.$lon = d12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationPlaceViewModel$getLocationPlaceList$1(this.this$0, this.$lat, this.$lon, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocationPlaceViewModel$getLocationPlaceList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = c.e(c.q(c.o(new AnonymousClass1(this.this$0, this.$lat, this.$lon, null)), w0.b()), new AnonymousClass2(null));
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
