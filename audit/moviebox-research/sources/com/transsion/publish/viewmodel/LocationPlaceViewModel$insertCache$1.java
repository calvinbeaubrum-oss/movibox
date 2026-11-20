package com.transsion.publish.viewmodel;

import com.transsion.baselib.db.place.PlaceDBBean;
import com.transsion.baselib.db.place.PlaceDao;
import com.transsion.room.api.bean.LocationPlace;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import uo.b;

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
@DebugMetadata(c = "com.transsion.publish.viewmodel.LocationPlaceViewModel$insertCache$1", f = "LocationPlaceViewModel.kt", l = {127}, m = "invokeSuspend")
@SourceDebugExtension
public final class LocationPlaceViewModel$insertCache$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<LocationPlace> $list;
    int label;
    final /* synthetic */ LocationPlaceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationPlaceViewModel$insertCache$1(List<LocationPlace> list, LocationPlaceViewModel locationPlaceViewModel, Continuation<? super LocationPlaceViewModel$insertCache$1> continuation) {
        super(2, continuation);
        this.$list = list;
        this.this$0 = locationPlaceViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationPlaceViewModel$insertCache$1(this.$list, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocationPlaceViewModel$insertCache$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            ArrayList arrayList = new ArrayList();
            for (LocationPlace locationPlace : this.$list) {
                Double lat = locationPlace.getLat();
                double dDoubleValue = lat != null ? lat.doubleValue() : 0.0d;
                Double lon = locationPlace.getLon();
                PlaceDBBean placeDBBean = new PlaceDBBean(dDoubleValue, lon != null ? lon.doubleValue() : 0.0d, locationPlace.getName(), locationPlace.getAddress(), locationPlace.getDistance());
                b.a.f(b.f78622a, "SelectLocation", "insertCache latitude:" + placeDBBean.getLatitude() + ", longitude:" + placeDBBean.getLongitude() + ", name:" + placeDBBean.getName(), false, 4, null);
                arrayList.add(placeDBBean);
            }
            PlaceDao placeDaoK = this.this$0.k();
            this.label = 1;
            if (placeDaoK.c(arrayList, this) == objE) {
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
