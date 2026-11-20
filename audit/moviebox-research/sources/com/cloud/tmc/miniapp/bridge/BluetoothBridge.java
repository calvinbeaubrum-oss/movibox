package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.bluetooth.BluetoothCode;
import com.cloud.tmc.miniapp.bluetooth.IBluetooth;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.miniutils.util.l;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.tracking.TrackingKey;
import hd.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class BluetoothBridge implements BridgeExtension {
    public static final a Companion = new a();
    public static final String EXTEA_AVALIABLE = "available";
    public static final String EXTEA_DISCOVERING = "discovering";
    public final String OooO00o = "TmcBluetoothBridge";

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function2<Boolean, Boolean, Unit> {
        public final /* synthetic */ bc.a OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0OO(bc.a aVar) {
            super(2);
            this.OooO0O0 = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Boolean bool, Boolean bool2) {
            boolean zBooleanValue = bool.booleanValue();
            boolean zBooleanValue2 = bool2.booleanValue();
            TmcLogger.c(BluetoothBridge.this.OooO00o, "getBluetoothAdapterState -> discovering: " + zBooleanValue + " ; available: " + zBooleanValue2);
            BluetoothBridge.this.OooO0O0(this.OooO0O0, BluetoothCode.OK.getCode(), s.j(TuplesKt.a(BluetoothBridge.EXTEA_DISCOVERING, String.valueOf(zBooleanValue)), TuplesKt.a(BluetoothBridge.EXTEA_AVALIABLE, String.valueOf(zBooleanValue2))));
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements e.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f31471b;

        public b(bc.a aVar) {
            this.f31471b = aVar;
        }

        @Override // e.d
        public void a(List<? extends Map<String, String>> services) {
            Intrinsics.g(services, "services");
            String str = BluetoothBridge.this.OooO00o;
            StringBuilder sbA = j.a("getBLEDeviceServices notify -> services: ");
            sbA.append(k.j(services));
            TmcLogger.c(str, sbA.toString());
            BluetoothBridge.this.OooO0O0(this.f31471b, BluetoothCode.OK.getCode(), s.j(TuplesKt.a("services", k.j(services))));
        }

        @Override // e.d
        public void b(long j11) {
            String str = BluetoothBridge.this.OooO00o;
            StringBuilder sbA = j.a("getBLEDeviceServices -> code: ");
            BluetoothCode bluetoothCode = BluetoothCode.FAIL;
            sbA.append(bluetoothCode.getCode());
            sbA.append(" ; system_code: ");
            sbA.append(j11);
            TmcLogger.c(str, sbA.toString());
            BluetoothBridge.this.OooO00o(this.f31471b, bluetoothCode.getCode(), s.j(TuplesKt.a("system_code", String.valueOf(j11))));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements e.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f31473b;

        public c(bc.a aVar) {
            this.f31473b = aVar;
        }

        @Override // e.b
        public void a(String callbackId) {
            Intrinsics.g(callbackId, "callbackId");
            TmcLogger.c(BluetoothBridge.this.OooO00o, "onBLECharacteristicValueChange close -> ");
            this.f31473b.close();
        }

        @Override // e.b
        public void b(String serviceUUID, String characteristicUUID, byte[] value) {
            Intrinsics.g(serviceUUID, "serviceUUID");
            Intrinsics.g(characteristicUUID, "characteristicUUID");
            Intrinsics.g(value, "value");
            TmcLogger.c(BluetoothBridge.this.OooO00o, "onBLECharacteristicValueChange notify -> serviceUUID: " + serviceUUID + " ; characteristicUUID: " + characteristicUUID + " ; value: " + l.b(value));
            BluetoothBridge.this.OooO0O0(this.f31473b, BluetoothCode.OK.getCode(), s.j(TuplesKt.a("serviceUUID", serviceUUID), TuplesKt.a("characteristicUUID", characteristicUUID), TuplesKt.a(AppMeasurementSdk.ConditionalUserProperty.VALUE, l.b(value))));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements e.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f31475b;

        public d(bc.a aVar) {
            this.f31475b = aVar;
        }

        @Override // e.c
        public void a(String callbackId) {
            Intrinsics.g(callbackId, "callbackId");
            TmcLogger.c(BluetoothBridge.this.OooO00o, "onBLEConnectionStateChange close -> ");
        }

        @Override // e.c
        public void b(String address, int i11, int i12) {
            Intrinsics.g(address, "address");
            TmcLogger.c(BluetoothBridge.this.OooO00o, "onBLEConnectionStateChange notify -> address: " + address + " ; status: " + i11 + " ; newState: " + i12);
            BluetoothBridge.this.OooO0O0(this.f31475b, BluetoothCode.OK.getCode(), s.j(TuplesKt.a(PlaceTypes.ADDRESS, address), TuplesKt.a(NotificationCompat.CATEGORY_STATUS, String.valueOf(i11)), TuplesKt.a("newState", String.valueOf(i12))));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements e.g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f31477b;

        public e(bc.a aVar) {
            this.f31477b = aVar;
        }

        @Override // e.g
        public void a(String callbackId) {
            Intrinsics.g(callbackId, "callbackId");
            TmcLogger.c(BluetoothBridge.this.OooO00o, "onBluetoothAdapterStateChange close ->");
            this.f31477b.close();
        }

        @Override // e.g
        public void b(boolean z11, boolean z12) {
            TmcLogger.c(BluetoothBridge.this.OooO00o, "onBluetoothAdapterStateChange notify -> discovering: " + z11 + " ; available: " + z12);
            BluetoothBridge.this.OooO0O0(this.f31477b, BluetoothCode.OK.getCode(), s.j(TuplesKt.a(BluetoothBridge.EXTEA_DISCOVERING, String.valueOf(z11)), TuplesKt.a(BluetoothBridge.EXTEA_AVALIABLE, String.valueOf(z12))));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements e.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f31479b;

        public f(bc.a aVar) {
            this.f31479b = aVar;
        }

        @Override // e.h
        public void a(String callbackId) {
            Intrinsics.g(callbackId, "callbackId");
            TmcLogger.c(BluetoothBridge.this.OooO00o, "onBluetoothDeviceFound close -> ");
            this.f31479b.close();
        }

        @Override // e.h
        public void b(long j11) {
            TmcLogger.c(BluetoothBridge.this.OooO00o, "onBluetoothDeviceFound onScanFailed -> code: " + j11);
            BluetoothBridge.this.OooO00o(this.f31479b, BluetoothCode.FAIL.getCode(), s.j(TuplesKt.a("system_code", String.valueOf(j11))));
        }

        @Override // e.h
        public void c(Map<String, String> result) {
            Intrinsics.g(result, "result");
            String str = BluetoothBridge.this.OooO00o;
            StringBuilder sbA = j.a("onBluetoothDeviceFound onScanResult -> result: ");
            sbA.append(k.j(result));
            TmcLogger.c(str, sbA.toString());
            BluetoothBridge.this.OooO0O0(this.f31479b, BluetoothCode.OK.getCode(), s.j(TuplesKt.a("result", k.j(result))));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements e.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f31481b;

        public g(bc.a aVar) {
            this.f31481b = aVar;
        }

        @Override // e.a
        public void b(long j11) {
            TmcLogger.c(BluetoothBridge.this.OooO00o, "openBluetoothAdapter -> code: " + j11);
            if (j11 == BluetoothCode.OK.getCode()) {
                BluetoothBridge.sendSuccess$default(BluetoothBridge.this, this.f31481b, j11, null, 4, null);
            } else {
                BluetoothBridge.sendFail$default(BluetoothBridge.this, this.f31481b, j11, null, 4, null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h implements e.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f31483b;

        public h(bc.a aVar) {
            this.f31483b = aVar;
        }

        @Override // e.e
        public void a(String serviceUUID, String characteristicUUID, byte[] value, int i11) {
            Intrinsics.g(serviceUUID, "serviceUUID");
            Intrinsics.g(characteristicUUID, "characteristicUUID");
            Intrinsics.g(value, "value");
            TmcLogger.c(BluetoothBridge.this.OooO00o, "readBLECharacteristicValue notify -> serviceUUID: " + serviceUUID + " ; characteristicUUID: " + characteristicUUID + " ; value: " + l.b(value) + " ; status: " + i11);
            BluetoothBridge.this.OooO0O0(this.f31483b, BluetoothCode.OK.getCode(), s.j(TuplesKt.a("serviceUUID", serviceUUID), TuplesKt.a("characteristicUUID", characteristicUUID), TuplesKt.a(AppMeasurementSdk.ConditionalUserProperty.VALUE, l.b(value)), TuplesKt.a(NotificationCompat.CATEGORY_STATUS, String.valueOf(i11))));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i implements e.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f31485b;

        public i(bc.a aVar) {
            this.f31485b = aVar;
        }

        @Override // e.e
        public void a(String serviceUUID, String characteristicUUID, byte[] value, int i11) {
            Intrinsics.g(serviceUUID, "serviceUUID");
            Intrinsics.g(characteristicUUID, "characteristicUUID");
            Intrinsics.g(value, "value");
            TmcLogger.c(BluetoothBridge.this.OooO00o, "writeBLECharacteristicValue notify -> serviceUUID: " + serviceUUID + " ; characteristicUUID: " + characteristicUUID + " ; value: " + l.b(value) + " ; status: " + i11);
            BluetoothBridge.this.OooO0O0(this.f31485b, BluetoothCode.OK.getCode(), s.j(TuplesKt.a("serviceUUID", serviceUUID), TuplesKt.a("characteristicUUID", characteristicUUID), TuplesKt.a(AppMeasurementSdk.ConditionalUserProperty.VALUE, l.b(value)), TuplesKt.a(NotificationCompat.CATEGORY_STATUS, String.valueOf(i11))));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendFail$default(BluetoothBridge bluetoothBridge, bc.a aVar, long j11, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = null;
        }
        bluetoothBridge.OooO00o(aVar, j11, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendSuccess$default(BluetoothBridge bluetoothBridge, bc.a aVar, long j11, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = null;
        }
        bluetoothBridge.OooO0O0(aVar, j11, map);
    }

    public final void OooO00o(bc.a aVar, long j11, Map<String, String> map) {
        String descript;
        Set<Map.Entry<String, String>> setEntrySet;
        if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errCode", Long.valueOf(j11));
            BluetoothCode[] bluetoothCodeArrValues = BluetoothCode.values();
            int length = bluetoothCodeArrValues.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    descript = BluetoothCode.FAIL.getDescript();
                    break;
                }
                BluetoothCode bluetoothCode = bluetoothCodeArrValues[i11];
                if (j11 == bluetoothCode.getCode()) {
                    descript = bluetoothCode.getDescript();
                    break;
                }
                i11++;
            }
            jsonObject.addProperty("errMsg", descript);
            Iterator<Map.Entry<String, String>> it = (map == null || (setEntrySet = map.entrySet()) == null) ? null : setEntrySet.iterator();
            while (it != null && it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                jsonObject.addProperty(next.getKey(), next.getValue());
            }
            aVar.e(jsonObject);
        }
    }

    public final void OooO0O0(bc.a aVar, long j11, Map<String, String> map) {
        Set<Map.Entry<String, String>> setEntrySet;
        if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(TrackingKey.CODE, Long.valueOf(j11));
            Iterator<Map.Entry<String, String>> it = (map == null || (setEntrySet = map.entrySet()) == null) ? null : setEntrySet.iterator();
            while (it != null && it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                jsonObject.addProperty(next.getKey(), next.getValue());
            }
            aVar.d(jsonObject);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void closeBLEConnection(@cc.g({PlaceTypes.ADDRESS}) String str, @cc.c bc.a aVar) {
        if (str == null || str.length() <= 0) {
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, aVar, bluetoothCode.getCode(), null, 4, null);
            String str2 = this.OooO00o;
            StringBuilder sbA = j.a("closeBLEConnection -> code: ");
            sbA.append(bluetoothCode.getCode());
            TmcLogger.c(str2, sbA.toString());
            return;
        }
        long jCloseBLEConnection = ((IBluetooth) tc.a.a(IBluetooth.class)).closeBLEConnection(str);
        TmcLogger.c(this.OooO00o, "closeBLEConnection -> code: " + jCloseBLEConnection);
        if (jCloseBLEConnection == BluetoothCode.OK.getCode()) {
            sendSuccess$default(this, aVar, jCloseBLEConnection, null, 4, null);
        } else {
            sendFail$default(this, aVar, jCloseBLEConnection, null, 4, null);
        }
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void closeBluetoothAdapter(@cc.c bc.a aVar) {
        ((IBluetooth) tc.a.a(IBluetooth.class)).closeBluetoothAdapter();
        String str = this.OooO00o;
        StringBuilder sbA = j.a("closeBluetoothAdapter -> code: ");
        BluetoothCode bluetoothCode = BluetoothCode.OK;
        sbA.append(bluetoothCode.getCode());
        TmcLogger.c(str, sbA.toString());
        sendSuccess$default(this, aVar, bluetoothCode.getCode(), null, 4, null);
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void createBLEConnection(@cc.g({PlaceTypes.ADDRESS}) String str, @cc.c bc.a aVar) {
        hd.k.a("createBLEConnection -> address: ", str, this.OooO00o);
        if (str == null || str.length() <= 0) {
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, aVar, bluetoothCode.getCode(), null, 4, null);
            String str2 = this.OooO00o;
            StringBuilder sbA = j.a("createBLEConnection -> code: ");
            sbA.append(bluetoothCode.getCode());
            TmcLogger.c(str2, sbA.toString());
            return;
        }
        long jCreateBLEConnection = ((IBluetooth) tc.a.a(IBluetooth.class)).createBLEConnection(str);
        TmcLogger.c(this.OooO00o, "createBLEConnection -> code: " + jCreateBLEConnection);
        if (jCreateBLEConnection == BluetoothCode.OK.getCode()) {
            sendSuccess$default(this, aVar, jCreateBLEConnection, null, 4, null);
        } else {
            sendFail$default(this, aVar, jCreateBLEConnection, null, 4, null);
        }
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void getBLEDeviceCharacteristics(@cc.g({"serviceUUID"}) String str, @cc.c bc.a aVar) {
        if (str == null || str.length() <= 0) {
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, aVar, bluetoothCode.getCode(), null, 4, null);
            String str2 = this.OooO00o;
            StringBuilder sbA = j.a("getBLEDeviceCharacteristics -> code: ");
            sbA.append(bluetoothCode.getCode());
            TmcLogger.c(str2, sbA.toString());
            return;
        }
        List<Map<String, String>> bLEDeviceCharacteristicsMap = ((IBluetooth) tc.a.a(IBluetooth.class)).getBLEDeviceCharacteristicsMap(str);
        String str3 = this.OooO00o;
        StringBuilder sbA2 = j.a("getBLEDeviceCharacteristics -> characteristics: ");
        sbA2.append(k.j(bLEDeviceCharacteristicsMap));
        TmcLogger.c(str3, sbA2.toString());
        OooO0O0(aVar, BluetoothCode.OK.getCode(), s.j(TuplesKt.a("characteristics", k.j(bLEDeviceCharacteristicsMap))));
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void getBLEDeviceServices(@cc.c bc.a aVar) {
        ((IBluetooth) tc.a.a(IBluetooth.class)).getBLEDeviceServices(new b(aVar));
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void getBluetoothAdapterState(@cc.c bc.a aVar) {
        long bluetoothAdapterState = ((IBluetooth) tc.a.a(IBluetooth.class)).getBluetoothAdapterState(new OooO0OO(aVar));
        if (bluetoothAdapterState != BluetoothCode.OK.getCode()) {
            TmcLogger.c(this.OooO00o, "getBluetoothAdapterState fail -> code: " + bluetoothAdapterState);
            sendFail$default(this, aVar, bluetoothAdapterState, null, 4, null);
        }
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void getConnectedBluetoothDevices(@cc.c bc.a aVar) {
        List<Map<String, String>> connectedBluetoothDevicesMap = ((IBluetooth) tc.a.a(IBluetooth.class)).getConnectedBluetoothDevicesMap();
        String str = this.OooO00o;
        StringBuilder sbA = j.a("getConnectedBluetoothDevices -> devices: ");
        sbA.append(k.j(connectedBluetoothDevicesMap));
        TmcLogger.c(str, sbA.toString());
        OooO0O0(aVar, BluetoothCode.OK.getCode(), s.j(TuplesKt.a("devices", k.j(connectedBluetoothDevicesMap))));
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void notifyBLECharacteristicValueChange(@cc.g({"serviceUUID"}) String str, @cc.g({"characteristicUUID"}) String str2, @cc.g({"enable"}) Boolean bool, @cc.c bc.a aVar) {
        if (str == null || str2 == null || bool == null || str.length() <= 0 || str2.length() <= 0) {
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, aVar, bluetoothCode.getCode(), null, 4, null);
            String str3 = this.OooO00o;
            StringBuilder sbA = j.a("notifyBLECharacteristicValueChange -> code: ");
            sbA.append(bluetoothCode.getCode());
            TmcLogger.c(str3, sbA.toString());
            return;
        }
        long jNotifyBLECharacteristicValueChange = ((IBluetooth) tc.a.a(IBluetooth.class)).notifyBLECharacteristicValueChange(str, str2, bool.booleanValue());
        TmcLogger.c(this.OooO00o, "notifyBLECharacteristicValueChange -> code: " + jNotifyBLECharacteristicValueChange);
        if (jNotifyBLECharacteristicValueChange == BluetoothCode.OK.getCode()) {
            sendSuccess$default(this, aVar, jNotifyBLECharacteristicValueChange, null, 4, null);
        } else {
            sendFail$default(this, aVar, jNotifyBLECharacteristicValueChange, null, 4, null);
        }
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void offBLECharacteristicValueChange(@cc.c bc.a aVar) {
        String strC;
        if (aVar == null || (strC = aVar.c()) == null) {
            return;
        }
        TmcLogger.c(this.OooO00o, "offBLECharacteristicValueChange close -> ");
        ((IBluetooth) tc.a.a(IBluetooth.class)).offBLECharacteristicValueChange(strC);
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void offBLEConnectionStateChange(@cc.c bc.a aVar) {
        String strC;
        if (aVar == null || (strC = aVar.c()) == null) {
            return;
        }
        TmcLogger.c(this.OooO00o, "offBLEConnectionStateChange -> ");
        ((IBluetooth) tc.a.a(IBluetooth.class)).offBLEConnectionStateChange(strC);
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void offBluetoothAdapterStateChange(@cc.c bc.a aVar) {
        String strC;
        if (aVar == null || (strC = aVar.c()) == null) {
            return;
        }
        TmcLogger.c(this.OooO00o, "offBluetoothAdapterStateChange ->");
        ((IBluetooth) tc.a.a(IBluetooth.class)).offBluetoothAdapterStateChange(strC);
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void offBluetoothDeviceFound(@cc.c bc.a aVar) {
        String strC;
        if (aVar == null || (strC = aVar.c()) == null) {
            return;
        }
        TmcLogger.c(this.OooO00o, "offBluetoothDeviceFound -> ");
        ((IBluetooth) tc.a.a(IBluetooth.class)).offBluetoothDeviceFound(strC);
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void onBLECharacteristicValueChange(@cc.c(isSticky = true) bc.a aVar) {
        String strC;
        if (aVar == null || (strC = aVar.c()) == null) {
            return;
        }
        ((IBluetooth) tc.a.a(IBluetooth.class)).onBLECharacteristicValueChange(strC, new c(aVar));
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void onBLEConnectionStateChange(@cc.c(isSticky = true) bc.a aVar) {
        String strC;
        if (aVar == null || (strC = aVar.c()) == null) {
            return;
        }
        ((IBluetooth) tc.a.a(IBluetooth.class)).onBLEConnectionStateChange(strC, new d(aVar));
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void onBluetoothAdapterStateChange(@cc.c(isSticky = true) bc.a aVar) {
        String strC;
        if (aVar == null || (strC = aVar.c()) == null) {
            return;
        }
        ((IBluetooth) tc.a.a(IBluetooth.class)).onBluetoothAdapterStateChange(strC, new e(aVar));
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void onBluetoothDeviceFound(@cc.c(isSticky = true) bc.a aVar) {
        String strC;
        if (aVar == null || (strC = aVar.c()) == null) {
            return;
        }
        ((IBluetooth) tc.a.a(IBluetooth.class)).onBluetoothDeviceFound(strC, new f(aVar));
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void openBluetoothAdapter(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        tb.b appContext;
        if (((app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext()) != null) {
            IBluetooth iBluetooth = (IBluetooth) tc.a.a(IBluetooth.class);
            tb.b appContext2 = app.getAppContext();
            Intrinsics.d(appContext2);
            Context context = appContext2.getContext();
            Intrinsics.f(context, "app.appContext!!.context");
            iBluetooth.openBluetoothAdapter(context, new g(aVar));
            return;
        }
        String str = this.OooO00o;
        StringBuilder sbA = j.a("openBluetoothAdapter fail -> code: ");
        BluetoothCode bluetoothCode = BluetoothCode.SYSTEM_ERROR;
        sbA.append(bluetoothCode.getCode());
        TmcLogger.c(str, sbA.toString());
        sendFail$default(this, aVar, bluetoothCode.getCode(), null, 4, null);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void readBLECharacteristicValue(@cc.g({"serviceUUID"}) String str, @cc.g({"characteristicUUID"}) String str2, @cc.c bc.a aVar) {
        if (str == null || str2 == null || str.length() <= 0 || str2.length() <= 0) {
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, aVar, bluetoothCode.getCode(), null, 4, null);
            String str3 = this.OooO00o;
            StringBuilder sbA = j.a("readBLECharacteristicValue -> code: ");
            sbA.append(bluetoothCode.getCode());
            TmcLogger.c(str3, sbA.toString());
            return;
        }
        long bLECharacteristicValue = ((IBluetooth) tc.a.a(IBluetooth.class)).readBLECharacteristicValue(str, str2, new h(aVar));
        TmcLogger.c(this.OooO00o, "readBLECharacteristicValue -> code: " + bLECharacteristicValue);
        if (bLECharacteristicValue != BluetoothCode.OK.getCode()) {
            sendFail$default(this, aVar, bLECharacteristicValue, null, 4, null);
        }
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void startBluetoothDevicesDiscovery(@cc.g({"serviceUUIDS"}) String str, @cc.g({"powerLevel"}) Integer num, @cc.c bc.a aVar) {
        List<String> arrayList;
        try {
            Object objE = k.e(str, new TypeToken<List<? extends String>>() { // from class: com.cloud.tmc.miniapp.bridge.BluetoothBridge.startBluetoothDevicesDiscovery.1
            }.getType());
            Intrinsics.f(objE, "fromJson(serviceUUIDS, o…ist<String?>?>() {}.type)");
            arrayList = (List) objE;
        } catch (Exception unused) {
            arrayList = new ArrayList<>();
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, aVar, bluetoothCode.getCode(), null, 4, null);
            String str2 = this.OooO00o;
            StringBuilder sbA = j.a("startBluetoothDevicesDiscovery -> code: ");
            sbA.append(bluetoothCode.getCode());
            TmcLogger.c(str2, sbA.toString());
        }
        long jStartBluetoothDevicesDiscovery = ((IBluetooth) tc.a.a(IBluetooth.class)).startBluetoothDevicesDiscovery(arrayList, num != null ? num.intValue() : 0);
        TmcLogger.c(this.OooO00o, "startBluetoothDevicesDiscovery -> code: " + jStartBluetoothDevicesDiscovery);
        if (jStartBluetoothDevicesDiscovery == BluetoothCode.OK.getCode()) {
            sendSuccess$default(this, aVar, jStartBluetoothDevicesDiscovery, null, 4, null);
        } else {
            sendFail$default(this, aVar, jStartBluetoothDevicesDiscovery, null, 4, null);
        }
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void stopBluetoothDevicesDiscovery(@cc.c bc.a aVar) {
        ((IBluetooth) tc.a.a(IBluetooth.class)).stopBluetoothDevicesDiscovery();
        String str = this.OooO00o;
        StringBuilder sbA = j.a("stopBluetoothDevicesDiscovery -> code: ");
        BluetoothCode bluetoothCode = BluetoothCode.OK;
        sbA.append(bluetoothCode.getCode());
        TmcLogger.c(str, sbA.toString());
        sendSuccess$default(this, aVar, bluetoothCode.getCode(), null, 4, null);
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void writeBLECharacteristicValue(@cc.g({"serviceUUID"}) String str, @cc.g({"characteristicUUID"}) String str2, @cc.g({AppMeasurementSdk.ConditionalUserProperty.VALUE}) String str3, @cc.c bc.a aVar) {
        if (str == null || str2 == null || str3 == null || str.length() <= 0 || str2.length() <= 0 || str3.length() <= 0) {
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, aVar, bluetoothCode.getCode(), null, 4, null);
            String str4 = this.OooO00o;
            StringBuilder sbA = j.a("writeBLECharacteristicValue -> code: ");
            sbA.append(bluetoothCode.getCode());
            TmcLogger.c(str4, sbA.toString());
            return;
        }
        IBluetooth iBluetooth = (IBluetooth) tc.a.a(IBluetooth.class);
        byte[] bArrD = l.d(str3);
        Intrinsics.f(bArrD, "hexStringToBytes(value)");
        long jWriteBLECharacteristicValue = iBluetooth.writeBLECharacteristicValue(str, str2, bArrD, new i(aVar));
        TmcLogger.c(this.OooO00o, "writeBLECharacteristicValue -> code: " + jWriteBLECharacteristicValue);
        if (jWriteBLECharacteristicValue != BluetoothCode.OK.getCode()) {
            sendFail$default(this, aVar, jWriteBLECharacteristicValue, null, 4, null);
        }
    }
}
