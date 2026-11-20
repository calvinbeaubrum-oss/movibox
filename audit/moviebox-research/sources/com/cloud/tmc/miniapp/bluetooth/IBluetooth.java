package com.cloud.tmc.miniapp.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import e.a;
import e.b;
import e.c;
import e.d;
import e.e;
import e.g;
import e.h;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface IBluetooth {
    long closeBLEConnection(String str);

    void closeBluetoothAdapter();

    long createBLEConnection(String str);

    List<BluetoothGattCharacteristic> getBLEDeviceCharacteristics(String str);

    List<Map<String, String>> getBLEDeviceCharacteristicsMap(String str);

    void getBLEDeviceServices(d dVar);

    long getBluetoothAdapterState(Function2<? super Boolean, ? super Boolean, Unit> function2);

    List<BluetoothDevice> getConnectedBluetoothDevices();

    List<Map<String, String>> getConnectedBluetoothDevicesMap();

    long notifyBLECharacteristicValueChange(String str, String str2, boolean z11);

    boolean offBLECharacteristicValueChange(String str);

    boolean offBLEConnectionStateChange(String str);

    boolean offBluetoothAdapterStateChange(String str);

    boolean offBluetoothDeviceFound(String str);

    void onBLECharacteristicValueChange(String str, b bVar);

    void onBLEConnectionStateChange(String str, c cVar);

    void onBluetoothAdapterStateChange(String str, g gVar);

    void onBluetoothDeviceFound(String str, h hVar);

    void openBluetoothAdapter(Context context, a aVar);

    long readBLECharacteristicValue(String str, String str2, e eVar);

    long startBluetoothDevicesDiscovery(List<String> list, int i11);

    void stopBluetoothDevicesDiscovery();

    long writeBLECharacteristicValue(String str, String str2, byte[] bArr, e eVar);
}
