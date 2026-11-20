package com.cloud.tmc.miniapp.bluetooth;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanResult;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.k;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.hisavana.common.tracking.TrackingKey;
import e.f;
import hd.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class BLEService extends Service implements f.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f31441l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothManager f31442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothAdapter f31443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothLeScanner f31444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f31445d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BluetoothGatt f31447g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f31448h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AtomicBoolean f31446f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AtomicBoolean f31449i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IBinder f31450j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BluetoothGattCallback f31451k = new b();

    /* JADX INFO: compiled from: source.java */
    public final class a extends Binder {
        public a() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends BluetoothGattCallback {
        public b() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            UUID uuid;
            BluetoothGattService service;
            UUID uuid2;
            byte[] value;
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            j.a("onCharacteristicChanged:").append((bluetoothGattCharacteristic == null || (value = bluetoothGattCharacteristic.getValue()) == null) ? null : ArraysKt___ArraysJvmKt.e(value));
            BLEService bLEService = BLEService.this;
            long code = BluetoothCode.OK.getCode();
            Bundle bundle = new Bundle();
            bundle.putString("data_serviceUUID", (bluetoothGattCharacteristic == null || (service = bluetoothGattCharacteristic.getService()) == null || (uuid2 = service.getUuid()) == null) ? null : uuid2.toString());
            bundle.putString("data_characteristicUUID", (bluetoothGattCharacteristic == null || (uuid = bluetoothGattCharacteristic.getUuid()) == null) ? null : uuid.toString());
            bundle.putByteArray("data_characteristic", bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null);
            Unit unit = Unit.f68710a;
            int i11 = BLEService.f31441l;
            bLEService.g("com.cloud.tmc.bluetooth.le.ACTION_NOTIFY_CHARACTERISTIC", code, bundle);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i11) {
            UUID uuid;
            BluetoothGattService service;
            UUID uuid2;
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i11);
            StringBuilder sbA = j.a("onCharacteristicRead:");
            byte[] value = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null;
            if (value == null) {
                value = new byte[0];
            }
            sbA.append(new String(value, Charsets.f69091b));
            BLEService bLEService = BLEService.this;
            long code = BluetoothCode.OK.getCode();
            Bundle bundle = new Bundle();
            bundle.putString("data_serviceUUID", (bluetoothGattCharacteristic == null || (service = bluetoothGattCharacteristic.getService()) == null || (uuid2 = service.getUuid()) == null) ? null : uuid2.toString());
            bundle.putString("data_characteristicUUID", (bluetoothGattCharacteristic == null || (uuid = bluetoothGattCharacteristic.getUuid()) == null) ? null : uuid.toString());
            bundle.putByteArray("data_characteristic", bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null);
            bundle.putInt("data_status", i11);
            Unit unit = Unit.f68710a;
            int i12 = BLEService.f31441l;
            bLEService.g("com.cloud.tmc.bluetooth.le.ACTION_READ_CHARACTERISTIC", code, bundle);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i11) {
            UUID uuid;
            BluetoothGattService service;
            UUID uuid2;
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i11);
            StringBuilder sbA = j.a("onCharacteristicWrite:");
            byte[] value = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null;
            if (value == null) {
                value = new byte[0];
            }
            sbA.append(new String(value, Charsets.f69091b));
            BLEService bLEService = BLEService.this;
            long code = BluetoothCode.OK.getCode();
            Bundle bundle = new Bundle();
            bundle.putString("data_serviceUUID", (bluetoothGattCharacteristic == null || (service = bluetoothGattCharacteristic.getService()) == null || (uuid2 = service.getUuid()) == null) ? null : uuid2.toString());
            bundle.putString("data_characteristicUUID", (bluetoothGattCharacteristic == null || (uuid = bluetoothGattCharacteristic.getUuid()) == null) ? null : uuid.toString());
            bundle.putByteArray("data_characteristic", bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null);
            bundle.putInt("data_status", i11);
            Unit unit = Unit.f68710a;
            int i12 = BLEService.f31441l;
            bLEService.g("com.cloud.tmc.bluetooth.le.ACTION_WRITE_CHARACTERISTIC", code, bundle);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt gatt, int i11, int i12) {
            Intrinsics.g(gatt, "gatt");
            super.onConnectionStateChange(gatt, i11, i12);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onConnectionStateChange -> status:");
            sb2.append(i11);
            sb2.append(" , newState:");
            sb2.append(i12);
            if (i12 == 0) {
                BLEService.this.f31449i.set(false);
            } else if (i12 == 2) {
                BLEService.this.f31449i.set(true);
            }
            if (Build.VERSION.SDK_INT <= 31 || z2.a.checkSelfPermission(BLEService.this, "android.permission.BLUETOOTH_SCAN") == 0) {
                BLEService bLEService = BLEService.this;
                long code = BluetoothCode.OK.getCode();
                Bundle bundle = new Bundle();
                bundle.putInt("newState", i12);
                bundle.putInt(NotificationCompat.CATEGORY_STATUS, i11);
                bundle.putString(PlaceTypes.ADDRESS, gatt.getDevice().getAddress());
                Unit unit = Unit.f68710a;
                int i13 = BLEService.f31441l;
                bLEService.g("com.cloud.tmc.bluetooth.le.ACTION_DEVICE_CONNECT_STATE", code, bundle);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i11, int i12) {
            super.onMtuChanged(bluetoothGatt, i11, i12);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i11, int i12) {
            super.onReadRemoteRssi(bluetoothGatt, i11, i12);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServiceChanged(BluetoothGatt gatt) {
            Intrinsics.g(gatt, "gatt");
            super.onServiceChanged(gatt);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt gatt, int i11) {
            Intrinsics.g(gatt, "gatt");
            super.onServicesDiscovered(gatt, i11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onServicesDiscovered -> status:");
            sb2.append(i11);
            if (i11 == 0) {
                BLEService.f(BLEService.this, "com.cloud.tmc.bluetooth.le.ACTION_SERVICES_DISCOVERED", BluetoothCode.OK.getCode(), null, 4);
            } else {
                BLEService.f(BLEService.this, "com.cloud.tmc.bluetooth.le.ACTION_SERVICES_DISCOVERED", i11, null, 4);
            }
        }
    }

    public static /* synthetic */ void f(BLEService bLEService, String str, long j11, Bundle bundle, int i11) {
        bLEService.g(str, j11, (i11 & 4) != 0 ? new Bundle() : null);
    }

    @Override // e.f.a
    public void a(List<ScanResult> list) {
    }

    public final long b(String address) {
        BluetoothDevice device;
        Intrinsics.g(address, "address");
        if (!i()) {
            return BluetoothCode.NOT_AVALIABLE.getCode();
        }
        if (Build.VERSION.SDK_INT > 31 && z2.a.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BluetoothCode.NOT_PERMISSION.getCode();
        }
        BluetoothGatt bluetoothGatt = this.f31447g;
        if (!Intrinsics.b(address, (bluetoothGatt == null || (device = bluetoothGatt.getDevice()) == null) ? null : device.getAddress())) {
            return BluetoothCode.NO_DEVICE.getCode();
        }
        BluetoothGatt bluetoothGatt2 = this.f31447g;
        if (bluetoothGatt2 != null) {
            bluetoothGatt2.disconnect();
        }
        this.f31447g = null;
        this.f31448h = null;
        return BluetoothCode.OK.getCode();
    }

    @Override // e.f.a
    public void c(int i11) {
        TmcLogger.f("TmcBluetooth", "onScanFailed:" + i11);
        f(this, "com.cloud.tmc.bluetooth.le.ACTION_SCAN_RESULT", (long) i11, null, 4);
    }

    @Override // e.f.a
    public void d(int i11, ScanResult scanResult) {
        BluetoothDevice device;
        BluetoothDevice device2;
        TmcLogger.k("TmcBluetooth", "onScanResult:" + scanResult);
        long code = BluetoothCode.OK.getCode();
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT <= 31 || z2.a.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") == 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String address = (scanResult == null || (device2 = scanResult.getDevice()) == null) ? null : device2.getAddress();
            String str = "";
            if (address == null) {
                address = "";
            } else {
                Intrinsics.f(address, "result?.device?.address ?: \"\"");
            }
            linkedHashMap.put(PlaceTypes.ADDRESS, address);
            String name = (scanResult == null || (device = scanResult.getDevice()) == null) ? null : device.getName();
            if (name != null) {
                Intrinsics.f(name, "result?.device?.name ?: \"\"");
                str = name;
            }
            linkedHashMap.put("name", str);
            linkedHashMap.put("RSSI", String.valueOf(scanResult != null ? Integer.valueOf(scanResult.getRssi()) : null));
            bundle.putString("scan_result", k.j(linkedHashMap));
            Unit unit = Unit.f68710a;
            g("com.cloud.tmc.bluetooth.le.ACTION_SCAN_RESULT", code, bundle);
        }
    }

    public final List<BluetoothDevice> e() {
        if (!i()) {
            return new ArrayList();
        }
        if (Build.VERSION.SDK_INT > 31 && z2.a.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") != 0) {
            return new ArrayList();
        }
        BluetoothManager bluetoothManager = this.f31442a;
        List<BluetoothDevice> connectedDevices = bluetoothManager != null ? bluetoothManager.getConnectedDevices(8) : null;
        return connectedDevices == null ? new ArrayList() : connectedDevices;
    }

    public final void g(String str, long j11, Bundle bundle) {
        Intent intent = new Intent(str);
        Bundle bundle2 = new Bundle();
        bundle2.putLong(TrackingKey.CODE, j11);
        bundle2.putAll(bundle);
        intent.putExtras(bundle2);
        sendBroadcast(intent);
    }

    public final void h(Function2<? super Boolean, ? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        Boolean boolValueOf = Boolean.valueOf(this.f31446f.get());
        BluetoothAdapter bluetoothAdapter = this.f31443b;
        callback.invoke(boolValueOf, Boolean.valueOf(bluetoothAdapter != null ? bluetoothAdapter.isEnabled() : false));
    }

    public final boolean i() {
        BluetoothAdapter bluetoothAdapter = this.f31443b;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public final void j() {
        long code = BluetoothCode.OK.getCode();
        Bundle bundle = new Bundle();
        bundle.putBoolean("scan", this.f31446f.get());
        BluetoothAdapter bluetoothAdapter = this.f31443b;
        bundle.putBoolean("avaliable", bluetoothAdapter != null ? bluetoothAdapter.isEnabled() : false);
        Unit unit = Unit.f68710a;
        g("com.cloud.tmc.bluetooth.le.ACTION_NOTIFY_BLUETOOTH_ADAPTER_STATE_CHANGE", code, bundle);
    }

    public final void k() {
        BluetoothLeScanner bluetoothLeScanner;
        this.f31446f.set(false);
        if (i()) {
            if ((Build.VERSION.SDK_INT <= 31 || z2.a.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") == 0) && (bluetoothLeScanner = this.f31444c) != null) {
                bluetoothLeScanner.stopScan(this.f31445d);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f31450j;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
