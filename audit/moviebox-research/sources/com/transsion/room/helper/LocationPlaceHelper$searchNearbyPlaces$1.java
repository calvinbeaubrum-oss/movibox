package com.transsion.room.helper;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.transsion.baselib.utils.l;
import com.transsion.room.api.bean.LocationPlace;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

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
@DebugMetadata(c = "com.transsion.room.helper.LocationPlaceHelper$searchNearbyPlaces$1", f = "LocationPlaceHelper.kt", l = {574, 578}, m = "invokeSuspend")
public final class LocationPlaceHelper$searchNearbyPlaces$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $apiKey;
    final /* synthetic */ Function1<List<LocationPlace>, Unit> $callback;
    final /* synthetic */ Double $curLat;
    final /* synthetic */ Double $curLon;
    final /* synthetic */ String $location;
    final /* synthetic */ int $radius;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: com.transsion.room.helper.LocationPlaceHelper$searchNearbyPlaces$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.room.helper.LocationPlaceHelper$searchNearbyPlaces$1$1", f = "LocationPlaceHelper.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<List<LocationPlace>, Unit> $callback;
        final /* synthetic */ List<LocationPlace> $list;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super List<LocationPlace>, Unit> function1, List<LocationPlace> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$list = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, this.$list, continuation);
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
            this.$callback.invoke(this.$list);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.room.helper.LocationPlaceHelper$searchNearbyPlaces$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.room.helper.LocationPlaceHelper$searchNearbyPlaces$1$2", f = "LocationPlaceHelper.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<List<LocationPlace>, Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super List<LocationPlace>, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$callback, continuation);
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
            this.$callback.invoke(null);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LocationPlaceHelper$searchNearbyPlaces$1(String str, int i11, String str2, Double d11, Double d12, Function1<? super List<LocationPlace>, Unit> function1, Continuation<? super LocationPlaceHelper$searchNearbyPlaces$1> continuation) {
        super(2, continuation);
        this.$location = str;
        this.$radius = i11;
        this.$apiKey = str2;
        this.$curLat = d11;
        this.$curLon = d12;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationPlaceHelper$searchNearbyPlaces$1(this.$location, this.$radius, this.$apiKey, this.$curLat, this.$curLon, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocationPlaceHelper$searchNearbyPlaces$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:62:0x021a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x021b  */
    /* JADX WARN: Code duplicated, block: B:66:0x023c  */
    /* JADX WARN: Code duplicated, block: B:72:0x0246  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Response response;
        String strString;
        Response response2;
        Response response3;
        Response response4;
        a2 a2VarC;
        AnonymousClass2 anonymousClass2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            String str = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + this.$location + "&radius=" + this.$radius + "&key=" + this.$apiKey;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient okHttpClientBuild = builder.connectTimeout(10000L, timeUnit).writeTimeout(10000L, timeUnit).readTimeout(10000L, timeUnit).build();
            Request requestBuild = new Request.Builder().url(str).build();
            uo.b.a.f(uo.b.f78622a, "LocationP", "searchNearbyPlaces url: " + str, false, 4, null);
            try {
                Response responseExecute = FirebasePerfOkHttpClient.execute(okHttpClientBuild.newCall(requestBuild));
                try {
                    try {
                        if (!responseExecute.isSuccessful()) {
                            throw new IOException("Unexpected code " + responseExecute);
                        }
                        ResponseBody responseBodyBody = responseExecute.body();
                        if (responseBodyBody == null || (strString = responseBodyBody.string()) == null) {
                            throw new IOException("Response null");
                        }
                        JSONArray jSONArray = new JSONObject(strString).getJSONArray("results");
                        ArrayList arrayList = new ArrayList();
                        int length = jSONArray.length();
                        int i12 = 0;
                        while (i12 < length) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i12);
                                String string = jSONObject.getString("name");
                                String string2 = jSONObject.getString("vicinity");
                                JSONObject jSONObject2 = jSONObject.getJSONObject("geometry").getJSONObject(RequestParameters.SUBRESOURCE_LOCATION);
                                double d11 = jSONObject2.getDouble("lat");
                                response2 = responseExecute;
                                try {
                                    double d12 = jSONObject2.getDouble("lng");
                                    String strA = l.f51319a.a(this.$curLat.doubleValue(), this.$curLon.doubleValue(), d11, d12);
                                    LocationPlace locationPlace = new LocationPlace(null, null, null, null, 15, null);
                                    locationPlace.setName(string);
                                    locationPlace.setAddress(string2);
                                    locationPlace.setDistance(strA);
                                    locationPlace.setLat(Boxing.b(d11));
                                    locationPlace.setLon(Boxing.b(d12));
                                    uo.b.a.s(uo.b.f78622a, "LocationP", "====place list name: " + string + ", distance: " + strA + ", address: " + string2 + ", lat:" + d11 + ", lng:" + d12 + ")", false, 4, null);
                                    arrayList.add(locationPlace);
                                } catch (Throwable th2) {
                                    th = th2;
                                    uo.b.a.j(uo.b.f78622a, "LocationP", "place error2: " + th, false, 4, null);
                                    th.printStackTrace();
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                response2 = responseExecute;
                            }
                            try {
                                i12++;
                                responseExecute = response2;
                            } catch (Throwable th4) {
                                th = th4;
                                response = response2;
                            }
                        }
                        response2 = responseExecute;
                        a2 a2VarC2 = w0.c();
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$callback, arrayList, null);
                        this.L$0 = response2;
                        this.label = 1;
                        if (kotlinx.coroutines.h.g(a2VarC2, anonymousClass1, this) == objE) {
                            return objE;
                        }
                        response3 = response2;
                        if (response3 != null) {
                            response3.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    response = responseExecute;
                }
            } catch (Throwable th7) {
                th = th7;
                response = null;
            }
            a2VarC = w0.c();
            anonymousClass2 = new AnonymousClass2(this.$callback, null);
            this.L$0 = response;
            this.L$1 = th;
            this.label = 2;
            if (kotlinx.coroutines.h.g(a2VarC, anonymousClass2, this) == objE) {
                return objE;
            }
            response4 = response;
            uo.b.a.j(uo.b.f78622a, "LocationP", "place error: " + th, false, 4, null);
            th.printStackTrace();
            if (response4 != null) {
                response4.close();
            }
        } else if (i11 == 1) {
            response3 = (Response) this.L$0;
            try {
                ResultKt.b(obj);
                if (response3 != null) {
                    response3.close();
                }
            } catch (Throwable th8) {
                th = th8;
                response = response3;
                try {
                    a2VarC = w0.c();
                    anonymousClass2 = new AnonymousClass2(this.$callback, null);
                    this.L$0 = response;
                    this.L$1 = th;
                    this.label = 2;
                    if (kotlinx.coroutines.h.g(a2VarC, anonymousClass2, this) == objE) {
                        return objE;
                    }
                    response4 = response;
                    uo.b.a.j(uo.b.f78622a, "LocationP", "place error: " + th, false, 4, null);
                    th.printStackTrace();
                    if (response4 != null) {
                        response4.close();
                    }
                } catch (Throwable th9) {
                    th = th9;
                    response4 = response;
                    if (response4 != null) {
                        response4.close();
                    }
                    throw th;
                }
            }
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            th = (Throwable) this.L$1;
            response4 = (Response) this.L$0;
            try {
                ResultKt.b(obj);
                uo.b.a.j(uo.b.f78622a, "LocationP", "place error: " + th, false, 4, null);
                th.printStackTrace();
                if (response4 != null) {
                    response4.close();
                }
            } catch (Throwable th10) {
                th = th10;
                if (response4 != null) {
                    response4.close();
                }
                throw th;
            }
        }
        return Unit.f68710a;
    }
}
