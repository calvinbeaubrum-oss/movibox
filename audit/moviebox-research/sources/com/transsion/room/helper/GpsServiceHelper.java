package com.transsion.room.helper;

import android.app.Activity;
import android.app.PendingIntent;
import android.location.LocationManager;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class GpsServiceHelper implements rw.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f57281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f57282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b1.b<IntentSenderRequest> f57283c;

    public GpsServiceHelper(Fragment fragment) {
        Intrinsics.g(fragment, "fragment");
        this.f57281a = fragment;
        b1.b<IntentSenderRequest> bVarRegisterForActivityResult = fragment.registerForActivityResult(new c1.k(), new b1.a() { // from class: com.transsion.room.helper.b
            @Override // b1.a
            public final void a(Object obj) {
                GpsServiceHelper.f(this.f57292a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "fragment.registerForActi…    callback = null\n    }");
        this.f57283c = bVarRegisterForActivityResult;
    }

    public static final void f(GpsServiceHelper this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        Function1<? super Boolean, Unit> function1 = this$0.f57282b;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(activityResult.getResultCode() == -1));
        }
        this$0.f57282b = null;
    }

    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void h(GpsServiceHelper this$0, Exception exception) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(exception, "exception");
        if (exception instanceof ResolvableApiException) {
            try {
                PendingIntent resolution = ((ResolvableApiException) exception).getResolution();
                Intrinsics.f(resolution, "exception.resolution");
                this$0.f57283c.a(new IntentSenderRequest.a(resolution).a());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // rw.a
    public void a(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f57282b = callback;
        LocationRequest locationRequestCreate = LocationRequest.create();
        locationRequestCreate.setPriority(100);
        Intrinsics.f(locationRequestCreate, "create().apply {\n       …Y_HIGH_ACCURACY\n        }");
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(locationRequestCreate);
        Intrinsics.f(builderAddLocationRequest, "Builder()\n            .a…nRequest(locationRequest)");
        FragmentActivity activity = this.f57281a.getActivity();
        if (activity == null) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        SettingsClient settingsClient = LocationServices.getSettingsClient((Activity) activity);
        Intrinsics.f(settingsClient, "getSettingsClient(activity)");
        Task<LocationSettingsResponse> taskCheckLocationSettings = settingsClient.checkLocationSettings(builderAddLocationRequest.build());
        Intrinsics.f(taskCheckLocationSettings, "settingsClient.checkLoca…Settings(builder.build())");
        final Function1<LocationSettingsResponse, Unit> function1 = new Function1<LocationSettingsResponse, Unit>() { // from class: com.transsion.room.helper.GpsServiceHelper$openGPS$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LocationSettingsResponse locationSettingsResponse) {
                invoke2(locationSettingsResponse);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LocationSettingsResponse locationSettingsResponse) {
                callback.invoke(Boolean.TRUE);
            }
        };
        taskCheckLocationSettings.addOnSuccessListener(new OnSuccessListener() { // from class: com.transsion.room.helper.c
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GpsServiceHelper.g(function1, obj);
            }
        });
        taskCheckLocationSettings.addOnFailureListener(new OnFailureListener() { // from class: com.transsion.room.helper.d
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GpsServiceHelper.h(this.f57294a, exc);
            }
        });
    }

    @Override // rw.a
    public boolean b() {
        LocationManager locationManager = (LocationManager) Utils.a().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        Intrinsics.d(locationManager);
        return locationManager.isProviderEnabled("gps");
    }
}
