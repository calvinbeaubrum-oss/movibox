package com.transsion.room.helper;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.transsion.baselib.utils.l;
import com.transsion.room.api.bean.LocationPlace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "com.transsion.room.helper.LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1", f = "LocationPlaceHelper.kt", l = {TTAdConstant.IMAGE_CODE}, m = "invokeSuspend")
public final class LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1 extends SuspendLambda implements Function2<k0, Continuation<? super List<LocationPlace>>, Object> {
    final /* synthetic */ LatLng $currentLatLng;
    final /* synthetic */ FindCurrentPlaceRequest $request;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<TResult> implements OnCompleteListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<LocationPlace>> f57288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LatLng f57289b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Continuation<? super List<LocationPlace>> continuation, LatLng latLng) {
            this.f57288a = continuation;
            this.f57289b = latLng;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task<FindCurrentPlaceResponse> task) {
            Iterator<PlaceLikelihood> it;
            String strA;
            Intrinsics.g(task, "task");
            if (!task.isSuccessful()) {
                Exception exception = task.getException();
                if (exception != null) {
                    Continuation<List<LocationPlace>> continuation = this.f57288a;
                    uo.b.a.f(uo.b.f78622a, "LocationP", "place fail: " + exception.getMessage(), false, 4, null);
                    continuation.resumeWith(Result.m163constructorimpl(null));
                    return;
                }
                return;
            }
            FindCurrentPlaceResponse result = task.getResult();
            if (result == null) {
                uo.b.a.f(uo.b.f78622a, "LocationP", "place fail:response null", false, 4, null);
                this.f57288a.resumeWith(Result.m163constructorimpl(null));
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                uo.b.a.f(uo.b.f78622a, "LocationP", "getNearbyPlaces --size:" + result.getPlaceLikelihoods().size(), false, 4, null);
                Iterator<PlaceLikelihood> it2 = result.getPlaceLikelihoods().iterator();
                while (it2.hasNext()) {
                    try {
                        Place place = it2.next().getPlace();
                        LatLng latLng = place.getLatLng();
                        String name = place.getName();
                        String address = place.getAddress();
                        if (latLng != null) {
                            l lVar = l.f51319a;
                            LatLng latLng2 = this.f57289b;
                            it = it2;
                            try {
                                strA = lVar.a(latLng2.latitude, latLng2.longitude, latLng.latitude, latLng.longitude);
                            } catch (Throwable th2) {
                                th = th2;
                                uo.b.a.j(uo.b.f78622a, "LocationP", "place error2 :" + th, false, 4, null);
                                th.printStackTrace();
                            }
                        } else {
                            it = it2;
                            strA = "<0.1m";
                        }
                        uo.b.a.f(uo.b.f78622a, "LocationP", "place list 名称: " + name + ", 距离: " + strA + ", 地址: " + address + ",lat:" + (latLng != null ? Double.valueOf(latLng.latitude) : null), false, 4, null);
                        LocationPlace locationPlace = new LocationPlace(null, null, null, null, 15, null);
                        locationPlace.setName(name);
                        locationPlace.setAddress(address);
                        locationPlace.setDistance(strA);
                        locationPlace.setLat(latLng != null ? Double.valueOf(latLng.latitude) : null);
                        locationPlace.setLon(latLng != null ? Double.valueOf(latLng.longitude) : null);
                        arrayList.add(locationPlace);
                    } catch (Throwable th3) {
                        th = th3;
                        it = it2;
                    }
                    it2 = it;
                }
                this.f57288a.resumeWith(Result.m163constructorimpl(arrayList));
            } catch (Throwable th4) {
                uo.b.a.j(uo.b.f78622a, "LocationP", "place error1 :" + th4, false, 4, null);
                this.f57288a.resumeWith(Result.m163constructorimpl(null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1(FindCurrentPlaceRequest findCurrentPlaceRequest, LatLng latLng, Continuation<? super LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1> continuation) {
        super(2, continuation);
        this.$request = findCurrentPlaceRequest;
        this.$currentLatLng = latLng;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1(this.$request, this.$currentLatLng, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super List<LocationPlace>> continuation) {
        return ((LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            FindCurrentPlaceRequest findCurrentPlaceRequest = this.$request;
            LatLng latLng = this.$currentLatLng;
            this.L$0 = findCurrentPlaceRequest;
            this.L$1 = latLng;
            this.label = 1;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.c(this));
            PlacesClient placesClient = LocationPlaceHelper.f57285b;
            Task<FindCurrentPlaceResponse> taskFindCurrentPlace = placesClient != null ? placesClient.findCurrentPlace(findCurrentPlaceRequest) : null;
            uo.b.a.f(uo.b.f78622a, "LocationP", "getNearbyPlaces --findCurrentPlace", false, 4, null);
            if (taskFindCurrentPlace != null) {
                taskFindCurrentPlace.addOnCompleteListener(new a(safeContinuation, latLng));
            }
            obj = safeContinuation.a();
            if (obj == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(this);
            }
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return obj;
    }
}
