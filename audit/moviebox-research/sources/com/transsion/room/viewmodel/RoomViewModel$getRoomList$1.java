package com.transsion.room.viewmodel;

import android.location.Address;
import com.blankj.utilcode.util.n;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.room.api.bean.RoomGeo;
import com.transsion.room.api.bean.RoomRequestEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;
import okhttp3.MediaType;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.room.viewmodel.RoomViewModel$getRoomList$1", f = "RoomViewModel.kt", l = {259}, m = "invokeSuspend")
public final class RoomViewModel$getRoomList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Address $address;
    final /* synthetic */ int $cid;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ Double $lat;
    final /* synthetic */ Double $lon;
    final /* synthetic */ String $page;
    final /* synthetic */ int $perPage;
    int label;
    final /* synthetic */ RoomViewModel this$0;

    /* JADX INFO: renamed from: com.transsion.room.viewmodel.RoomViewModel$getRoomList$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.room.viewmodel.RoomViewModel$getRoomList$1$1", f = "RoomViewModel.kt", l = {250, 252, 254}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b<? super RoomBean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Address $address;
        final /* synthetic */ int $cid;
        final /* synthetic */ Double $lat;
        final /* synthetic */ Double $lon;
        final /* synthetic */ String $page;
        final /* synthetic */ int $perPage;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RoomViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Double d11, Double d12, Address address, String str, int i11, int i12, RoomViewModel roomViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$lon = d11;
            this.$lat = d12;
            this.$address = address;
            this.$page = str;
            this.$perPage = i11;
            this.$cid = i12;
            this.this$0 = roomViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$lon, this.$lat, this.$address, this.$page, this.$perPage, this.$cid, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(b<? super RoomBean> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            b bVar;
            RoomGeo roomGeo;
            Object objK;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    bVar = (b) this.L$0;
                    ResultKt.b(obj);
                    objK = obj;
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
            if (this.$lon == null || this.$lat == null) {
                roomGeo = null;
            } else {
                double dDoubleValue = this.$lon.doubleValue();
                double dDoubleValue2 = this.$lat.doubleValue();
                Address address = this.$address;
                String countryCode = address != null ? address.getCountryCode() : null;
                Address address2 = this.$address;
                String adminArea = address2 != null ? address2.getAdminArea() : null;
                Address address3 = this.$address;
                roomGeo = new RoomGeo(dDoubleValue, dDoubleValue2, countryCode, adminArea, address3 != null ? address3.getLocality() : null, null, null, 96, null);
            }
            RequestBody.Companion companion = RequestBody.Companion;
            String strJ = n.j(new RoomRequestEntity(this.$page, this.$perPage, 0, Boxing.d(this.$cid), roomGeo, null, 32, null));
            Intrinsics.f(strJ, "toJson(\n                …      )\n                )");
            RequestBody requestBodyCreate = companion.create(strJ, MediaType.Companion.parse("application/json"));
            uw.a aVarA = this.this$0.A();
            String strA = cp.a.f62775a.a();
            this.L$0 = bVar;
            this.label = 1;
            objK = aVarA.k(strA, requestBodyCreate, this);
            if (objK == objE) {
                return objE;
            }
            BaseDto baseDto = (BaseDto) objK;
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

    /* JADX INFO: renamed from: com.transsion.room.viewmodel.RoomViewModel$getRoomList$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.room.viewmodel.RoomViewModel$getRoomList$1$2", f = "RoomViewModel.kt", l = {258}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<b<? super RoomBean>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(b<? super RoomBean> bVar, Throwable th2, Continuation<? super Unit> continuation) {
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
        public final /* synthetic */ boolean f57350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RoomViewModel f57351b;

        public a(boolean z11, RoomViewModel roomViewModel) {
            this.f57350a = z11;
            this.f57351b = roomViewModel;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(RoomBean roomBean, Continuation<? super Unit> continuation) {
            if (roomBean != null) {
                roomBean.setRefresh(this.f57350a);
            }
            this.f57351b.f57340i.n(roomBean);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomViewModel$getRoomList$1(Double d11, Double d12, Address address, String str, int i11, int i12, RoomViewModel roomViewModel, boolean z11, Continuation<? super RoomViewModel$getRoomList$1> continuation) {
        super(2, continuation);
        this.$lon = d11;
        this.$lat = d12;
        this.$address = address;
        this.$page = str;
        this.$perPage = i11;
        this.$cid = i12;
        this.this$0 = roomViewModel;
        this.$isRefresh = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomViewModel$getRoomList$1(this.$lon, this.$lat, this.$address, this.$page, this.$perPage, this.$cid, this.this$0, this.$isRefresh, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((RoomViewModel$getRoomList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = c.e(c.q(c.o(new AnonymousClass1(this.$lon, this.$lat, this.$address, this.$page, this.$perPage, this.$cid, this.this$0, null)), w0.b()), new AnonymousClass2(null));
            a aVar = new a(this.$isRefresh, this.this$0);
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
