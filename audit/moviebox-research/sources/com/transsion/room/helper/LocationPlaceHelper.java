package com.transsion.room.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Looper;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.PermissionDialogClickType;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.room.api.bean.LocationPlace;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.l;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class LocationPlaceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocationPlaceHelper f57284a = new LocationPlaceHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PlacesClient f57285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static LocationCallback f57286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f57287d;

    public static final void B(FusedLocationProviderClient fusedClient, Task task) {
        Intrinsics.g(fusedClient, "$fusedClient");
        Intrinsics.g(task, "task");
        if (task.isSuccessful()) {
            f57286c = null;
            uo.b.a.u(uo.b.f78622a, "LocationP", "Location--update----成功移除监听", false, 4, null);
        } else {
            uo.b.a.j(uo.b.f78622a, "LocationP", "Location--update----移除监听失败", false, 4, null);
            f57284a.A(fusedClient);
        }
    }

    public static final void o(FusedLocationProviderClient fusedLocationProviderClient, Function1 callback, Task task) {
        Intrinsics.g(fusedLocationProviderClient, "$fusedLocationProviderClient");
        Intrinsics.g(callback, "$callback");
        Intrinsics.g(task, "task");
        if (!task.isSuccessful()) {
            uo.b.f78622a.h("LocationP", "Location-------------- fail: " + task.getException() + ", do update", true);
            f57284a.y(fusedLocationProviderClient, callback);
            return;
        }
        Location location = (Location) task.getResult();
        if (location == null) {
            uo.b.f78622a.h("LocationP", "Location-------------- fail: location null---do update", true);
            f57284a.y(fusedLocationProviderClient, callback);
            return;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        uo.b.f78622a.c("LocationP", "Location--------------1 success " + longitude + ", :" + latitude, true);
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new LocationPlaceHelper$getCurrentLocation$2$1(latitude, longitude, callback, null), 3, null);
    }

    public static final void u(boolean z11, com.permissionx.guolindev.request.d scope, List deniedList, boolean z12, boolean z13) {
        Intrinsics.g(scope, "scope");
        Intrinsics.g(deniedList, "deniedList");
        if (!z12) {
            uo.b.a.f(uo.b.f78622a, "LocationP", "location 请求权限之后，", false, 4, null);
            return;
        }
        if (!z13) {
            uo.b.a.f(uo.b.f78622a, "LocationP", "直接请求权限", false, 4, null);
            scope.b(deniedList);
        } else if (!z11) {
            scope.a(deniedList);
        } else {
            uo.b.a.f(uo.b.f78622a, "LocationP", "请求权限，需要跳到设置页，先展示提示弹窗", false, 4, null);
            scope.c(deniedList, new co.a(null, Utils.a().getString(R$string.location_permission_dialog_tips), Utils.a().getString(R$string.Enable), Integer.valueOf(R$drawable.ic_location_permission_tips), Integer.valueOf(R$color.white_20), 1, null));
        }
    }

    public static final void v(BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
    }

    public static final void w(FragmentActivity activity, Function1 callback, boolean z11, List grantedList, List deniedList) {
        Intrinsics.g(activity, "$activity");
        Intrinsics.g(callback, "$callback");
        Intrinsics.g(grantedList, "grantedList");
        Intrinsics.g(deniedList, "deniedList");
        if (z11 && grantedList.size() == 1 && !ActivityCompat.j(activity, (String) grantedList.get(0))) {
            PermissionX.f48641a.c().putBoolean((String) grantedList.get(0), false);
        }
        uo.b.a.f(uo.b.f78622a, "LocationP", "location 请求权限结果:" + z11, false, 4, null);
        callback.invoke(Boolean.valueOf(z11));
    }

    public static final void z(Exception e11) {
        Intrinsics.g(e11, "e");
        uo.b.a.j(uo.b.f78622a, "LocationP", "Updates request failed: " + e11.getMessage(), false, 4, null);
    }

    public final void A(final FusedLocationProviderClient fusedLocationProviderClient) {
        int i11 = f57287d;
        if (i11 >= 3) {
            uo.b.f78622a.r("LocationP", "Location--update---- removeLocationUpdates, 超过上限3次，不再移除", true);
            return;
        }
        f57287d = i11 + 1;
        LocationCallback locationCallback = f57286c;
        if (locationCallback != null) {
            uo.b.f78622a.r("LocationP", "Location--update---- removeLocationUpdates", true);
            fusedLocationProviderClient.removeLocationUpdates(locationCallback).addOnCompleteListener(new OnCompleteListener() { // from class: com.transsion.room.helper.j
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    LocationPlaceHelper.B(fusedLocationProviderClient, task);
                }
            });
        }
    }

    public final LocationPlace l(double d11, double d12, Address address) {
        String addressLine;
        Integer numValueOf;
        boolean z11 = false;
        if (address == null || address.getMaxAddressLineIndex() >= 0) {
            addressLine = address != null ? address.getAddressLine(0) : null;
        } else {
            addressLine = "";
        }
        if (addressLine == null || addressLine.length() == 0) {
            if (addressLine != null) {
                String countryName = address != null ? address.getCountryName() : null;
                if (countryName == null) {
                    countryName = "-";
                }
                numValueOf = Integer.valueOf(StringsKt__StringsKt.d0(addressLine, countryName, 0, false, 6, null));
            } else {
                numValueOf = null;
            }
            if (numValueOf == null || numValueOf.intValue() < 5) {
                z11 = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        if ((address != null ? address.getLocality() : null) != null) {
            String locality = address.getLocality();
            Intrinsics.f(locality, "address.locality");
            if (locality.length() > 0) {
                String locality2 = address.getLocality();
                Intrinsics.f(locality2, "address.locality");
                arrayList.add(locality2);
            }
        }
        if ((address != null ? address.getSubLocality() : null) != null) {
            String subLocality = address.getSubLocality();
            Intrinsics.f(subLocality, "address.subLocality");
            if (subLocality.length() > 0) {
                String subLocality2 = address.getSubLocality();
                Intrinsics.f(subLocality2, "address.subLocality");
                arrayList.add(subLocality2);
            }
        }
        if ((address != null ? address.getThoroughfare() : null) != null) {
            String thoroughfare = address.getThoroughfare();
            Intrinsics.f(thoroughfare, "address.thoroughfare");
            if (thoroughfare.length() > 0) {
                String thoroughfare2 = address.getThoroughfare();
                Intrinsics.f(thoroughfare2, "address.thoroughfare");
                arrayList.add(thoroughfare2);
            }
        }
        if ((address != null ? address.getFeatureName() : null) != null) {
            String featureName = address.getFeatureName();
            Intrinsics.f(featureName, "address.featureName");
            if (featureName.length() > 0) {
                String featureName2 = address.getFeatureName();
                Intrinsics.f(featureName2, "address.featureName");
                arrayList.add(featureName2);
            }
        }
        String strO0 = z11 ? CollectionsKt___CollectionsKt.o0(arrayList, " ", null, null, 0, null, null, 62, null) : CollectionsKt___CollectionsKt.o0(l.Q(arrayList), " ", null, null, 0, null, null, 62, null);
        LocationPlace locationPlace = new LocationPlace(null, null, null, null, 15, null);
        locationPlace.setName(strO0);
        locationPlace.setDistance("<1m");
        locationPlace.setAddress(addressLine);
        locationPlace.setLocationAddress(address);
        locationPlace.setCountryCode(address != null ? address.getCountryCode() : null);
        locationPlace.setLat(Double.valueOf(d11));
        locationPlace.setLon(Double.valueOf(d12));
        return locationPlace;
    }

    public final Address m(double d11, double d12) {
        try {
            List<Address> fromLocation = new Geocoder(Utils.a(), Locale.getDefault()).getFromLocation(d11, d12, 1);
            List<Address> list = fromLocation;
            if (list != null && !list.isEmpty()) {
                return fromLocation.get(0);
            }
            return null;
        } catch (Throwable th2) {
            uo.b.a.j(uo.b.f78622a, "LocationP", "Location-------------- ll2address error:" + th2, false, 4, null);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void n(FragmentActivity activity, final Function1<? super LocationPlace, Unit> callback) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(callback, "callback");
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "LocationP", "Location-------------- start getCurrentLocation", false, 4, null);
        String string = RoomAppMMKV.f51271a.a().getString("key_lo_mock_test_lab_lat", "");
        if (string != null && string.length() != 0 && StringsKt__StringsKt.Q(string, "|", false, 2, null)) {
            try {
                Result.Companion companion = Result.Companion;
                List listE0 = StringsKt__StringsKt.E0(string, new String[]{"|"}, false, 0, 6, null);
                Double dJ = kotlin.text.j.j((String) listE0.get(0));
                if (dJ != null) {
                    double dDoubleValue = dJ.doubleValue();
                    Double dJ2 = kotlin.text.j.j((String) listE0.get(1));
                    if (dJ2 != null) {
                        double dDoubleValue2 = dJ2.doubleValue();
                        String str = (String) listE0.get(2);
                        String str2 = (String) listE0.get(3);
                        LocationPlace locationPlace = new LocationPlace(null, null, null, null, 15, null);
                        locationPlace.setName(str);
                        locationPlace.setDistance("<1m");
                        locationPlace.setAddress(str2);
                        locationPlace.setLat(Double.valueOf(dDoubleValue));
                        locationPlace.setLon(Double.valueOf(dDoubleValue2));
                        aVar.c("LocationP", "Location-------------- mock 的定位数据 name:" + str + ",address:" + str2 + ".不使用实际定位,需要真实定位请求清楚mock数据", true);
                        callback.invoke(locationPlace);
                        return;
                    }
                }
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
        final FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient((Activity) activity);
        Intrinsics.f(fusedLocationProviderClient, "getFusedLocationProviderClient(activity)");
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.transsion.room.helper.e
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                LocationPlaceHelper.o(fusedLocationProviderClient, callback, task);
            }
        });
    }

    public final void p(double d11, double d12, Function1<? super List<LocationPlace>, Unit> callback) {
        Intrinsics.g(callback, "callback");
        int iS = s();
        if (iS == 0) {
            uo.b.f78622a.c("LocationP", "place api use detail", true);
            q(d11, d12, callback);
        } else {
            if (iS == 1) {
                uo.b.f78622a.c("LocationP", "place api use search", true);
                x(Double.valueOf(d11), Double.valueOf(d12), callback);
                return;
            }
            uo.b.f78622a.c("LocationP", "place api ,null " + iS, true);
            callback.invoke(null);
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void q(double d11, double d12, Function1<? super List<LocationPlace>, Unit> function1) {
        String strR = r();
        if (strR == null || strR.length() == 0) {
            uo.b.a.f(uo.b.f78622a, "LocationP", "getNearbyPlaces apiKey isNullOrEmpty", false, 4, null);
            function1.invoke(null);
            return;
        }
        if (!Places.isInitialized()) {
            uo.b.a.o(uo.b.f78622a, "LocationP", new String[]{"getNearbyPlaces initialize place"}, false, 4, null);
            Places.initialize(Utils.a(), strR);
        }
        if (f57285b == null) {
            f57285b = Places.createClient(Utils.a());
        }
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new LocationPlaceHelper$getNearbyPlacesWithDetailApi$1(function1, FindCurrentPlaceRequest.newInstance(kotlin.collections.g.o(Place.Field.NAME, Place.Field.ADDRESS, Place.Field.LAT_LNG)), new LatLng(d11, d12), null), 3, null);
    }

    public final String r() {
        String string;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("sa_lo_place_key", true);
        String value = configBeanB != null ? configBeanB.getValue() : null;
        if (value == null || value.length() == 0 || (string = value.toString()) == null) {
            return null;
        }
        return string;
    }

    public final int s() {
        Integer numL;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("sa_lo_place_api", true);
        String value = configBeanB != null ? configBeanB.getValue() : null;
        if (value == null || value.length() == 0 || (numL = kotlin.text.k.l(value)) == null) {
            return 1;
        }
        return numL.intValue();
    }

    public final void t(final FragmentActivity activity, final boolean z11, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(callback, "callback");
        PermissionX.f48641a.d(activity).b("android.permission.ACCESS_FINE_LOCATION").a().c(new ao.b() { // from class: com.transsion.room.helper.f
            @Override // ao.b
            public final void a(com.permissionx.guolindev.request.d dVar, List list, boolean z12, boolean z13) {
                LocationPlaceHelper.u(z11, dVar, list, z12, z13);
            }
        }).d(new ao.a() { // from class: com.transsion.room.helper.g
            @Override // ao.a
            public final void a(BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
                LocationPlaceHelper.v(baseDialog, bool, permissionDialogClickType);
            }
        }).b(new ao.c() { // from class: com.transsion.room.helper.h
            @Override // ao.c
            public final void a(boolean z12, List list, List list2) {
                LocationPlaceHelper.w(activity, callback, z12, list, list2);
            }
        });
    }

    public final void x(Double d11, Double d12, Function1<? super List<LocationPlace>, Unit> function1) {
        if (d11 == null || d12 == null) {
            function1.invoke(null);
            return;
        }
        String strR = r();
        if (strR == null || strR.length() == 0) {
            function1.invoke(null);
            return;
        }
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new LocationPlaceHelper$searchNearbyPlaces$1(d11 + "," + d12, 20000, strR, d11, d12, function1, null), 3, null);
    }

    @SuppressLint({"MissingPermission"})
    public final void y(final FusedLocationProviderClient fusedLocationProviderClient, final Function1<? super LocationPlace, Unit> function1) {
        LocationRequest locationRequestBuild = new LocationRequest.Builder(100, 10000L).setWaitForAccurateLocation(true).setMinUpdateIntervalMillis(5000L).build();
        Intrinsics.f(locationRequestBuild, "Builder(PRIORITY_HIGH_AC…000)\n            .build()");
        LocationCallback locationCallback = new LocationCallback() { // from class: com.transsion.room.helper.LocationPlaceHelper$startRealTimeUpdates$1
            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationAvailability(LocationAvailability availability) {
                Intrinsics.g(availability, "availability");
                if (availability.isLocationAvailable()) {
                    return;
                }
                uo.b.f78622a.t("LocationP", "Location services unavailable", true);
            }

            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult result) {
                Intrinsics.g(result, "result");
                Location lastLocation = result.getLastLocation();
                if (lastLocation != null) {
                    FusedLocationProviderClient fusedLocationProviderClient2 = fusedLocationProviderClient;
                    Function1<LocationPlace, Unit> function2 = function1;
                    LocationPlaceHelper.f57287d = 0;
                    LocationPlaceHelper.f57284a.A(fusedLocationProviderClient2);
                    double latitude = lastLocation.getLatitude();
                    double longitude = lastLocation.getLongitude();
                    uo.b.f78622a.c("LocationP", "Location--update--------------1 success " + latitude + ", :" + longitude, true);
                    if (kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$1$1(latitude, longitude, function2, null), 3, null) != null) {
                        return;
                    }
                }
                kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$2$1(function1, null), 3, null);
            }
        };
        f57286c = locationCallback;
        Intrinsics.e(locationCallback, "null cannot be cast to non-null type com.google.android.gms.location.LocationCallback");
        fusedLocationProviderClient.requestLocationUpdates(locationRequestBuild, locationCallback, Looper.getMainLooper()).addOnFailureListener(new OnFailureListener() { // from class: com.transsion.room.helper.i
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                LocationPlaceHelper.z(exc);
            }
        });
    }
}
