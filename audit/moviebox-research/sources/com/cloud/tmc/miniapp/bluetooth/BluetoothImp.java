package com.cloud.tmc.miniapp.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelUuid;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.cloud.tmc.miniutils.util.k;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.tracking.TrackingKey;
import e.b;
import e.c;
import e.d;
import e.e;
import e.f;
import e.g;
import e.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class BluetoothImp implements IBluetooth {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public e.c f31454OooO;
    public Context OooO0O0;
    public Intent OooO0OO;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public e.a f31456OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public BLEService f31457OooO0o0;
    public g OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public h f31458OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public e.b f31459OooOO0;
    public final String OooO00o = "BluetoothImp";

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public AtomicBoolean f31455OooO0Oo = new AtomicBoolean(false);
    public final ConcurrentLinkedDeque<d> OooOO0O = new ConcurrentLinkedDeque<>();

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public final ConcurrentLinkedDeque<e> f31460OooOO0o = new ConcurrentLinkedDeque<>();
    public final ConcurrentLinkedDeque<e> OooOOO0 = new ConcurrentLinkedDeque<>();
    public BroadcastReceiver OooOOO = new OooO00o();
    public BroadcastReceiver OooOOOO = new BroadcastReceiver() { // from class: com.cloud.tmc.miniapp.bluetooth.BluetoothImp$mGattUpdateReceiver$1
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            b bVar;
            String str;
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                switch (action.hashCode()) {
                    case -987019949:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_NOTIFY_CHARACTERISTIC") && (bVar = this.f31469a.f31459OooOO0) != null) {
                            String stringExtra = intent.getStringExtra("data_serviceUUID");
                            if (stringExtra == null) {
                                stringExtra = "";
                            }
                            String stringExtra2 = intent.getStringExtra("data_characteristicUUID");
                            str = stringExtra2 != null ? stringExtra2 : "";
                            byte[] byteArrayExtra = intent.getByteArrayExtra("data_characteristic");
                            if (byteArrayExtra == null) {
                                byteArrayExtra = new byte[0];
                            }
                            bVar.b(stringExtra, str, byteArrayExtra);
                        }
                        break;
                    case 251958246:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_READ_CHARACTERISTIC")) {
                            Iterator it = this.f31469a.f31460OooOO0o.iterator();
                            Intrinsics.f(it, "readListeners.iterator()");
                            while (it.hasNext()) {
                                e eVar = (e) it.next();
                                String stringExtra3 = intent.getStringExtra("data_serviceUUID");
                                if (stringExtra3 == null) {
                                    stringExtra3 = "";
                                }
                                String stringExtra4 = intent.getStringExtra("data_characteristicUUID");
                                if (stringExtra4 == null) {
                                    stringExtra4 = "";
                                }
                                byte[] byteArrayExtra2 = intent.getByteArrayExtra("data_characteristic");
                                if (byteArrayExtra2 == null) {
                                    byteArrayExtra2 = new byte[0];
                                }
                                eVar.a(stringExtra3, stringExtra4, byteArrayExtra2, intent.getIntExtra("data_status", -1));
                                it.remove();
                            }
                            break;
                        }
                        break;
                    case 284486225:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_DEVICE_CONNECT_STATE")) {
                            TmcLogger.k(this.f31469a.OooO00o, "mGattUpdateReceiver -> ACTION_DEVICE_CONNECT_STATE");
                            String stringExtra5 = intent.getStringExtra(PlaceTypes.ADDRESS);
                            str = stringExtra5 != null ? stringExtra5 : "";
                            int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                            int intExtra2 = intent.getIntExtra("newState", -1);
                            TmcLogger.k(this.f31469a.OooO00o, "mGattUpdateReceiver -> address:" + str + ",status:" + intExtra + ",newState:" + intExtra2);
                            c cVar = this.f31469a.f31454OooO;
                            if (cVar != null) {
                                cVar.b(str, intExtra, intExtra2);
                            }
                            break;
                        }
                        break;
                    case 344915417:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_WRITE_CHARACTERISTIC")) {
                            Iterator it2 = this.f31469a.OooOOO0.iterator();
                            Intrinsics.f(it2, "writeListeners.iterator()");
                            while (it2.hasNext()) {
                                e eVar2 = (e) it2.next();
                                String stringExtra6 = intent.getStringExtra("data_serviceUUID");
                                if (stringExtra6 == null) {
                                    stringExtra6 = "";
                                }
                                String stringExtra7 = intent.getStringExtra("data_characteristicUUID");
                                if (stringExtra7 == null) {
                                    stringExtra7 = "";
                                }
                                byte[] byteArrayExtra3 = intent.getByteArrayExtra("data_characteristic");
                                if (byteArrayExtra3 == null) {
                                    byteArrayExtra3 = new byte[0];
                                }
                                eVar2.a(stringExtra6, stringExtra7, byteArrayExtra3, intent.getIntExtra("data_status", -1));
                                it2.remove();
                            }
                            break;
                        }
                        break;
                    case 655074071:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_NOTIFY_BLUETOOTH_ADAPTER_STATE_CHANGE")) {
                            TmcLogger.k(this.f31469a.OooO00o, "mGattUpdateReceiver -> ACTION_NOTIFT_BLUETOOTH_ADAPTER_STATE_CHANGE");
                            Bundle extras = intent.getExtras();
                            boolean z11 = extras != null ? extras.getBoolean("scan") : false;
                            Bundle extras2 = intent.getExtras();
                            boolean z12 = extras2 != null ? extras2.getBoolean("avaliable") : false;
                            TmcLogger.k(this.f31469a.OooO00o, "mGattUpdateReceiver -> getBluetoothAdapterState:" + z11 + ',' + z12);
                            g gVar = this.f31469a.OooO0oO;
                            if (gVar != null) {
                                gVar.b(z11, z12);
                            }
                        }
                        break;
                    case 709515595:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_SERVICES_DISCOVERED")) {
                            TmcLogger.k(this.f31469a.OooO00o, "mGattUpdateReceiver -> ACTION_SERVICES_DISCOVERED");
                            Bundle extras3 = intent.getExtras();
                            long j11 = extras3 != null ? extras3.getLong(TrackingKey.CODE) : BluetoothCode.SYSTEM_ERROR.getCode();
                            if (j11 == BluetoothCode.OK.getCode()) {
                                ArrayList arrayList = new ArrayList();
                                BLEService bLEService = this.f31469a.f31457OooO0o0;
                                if (bLEService != null) {
                                    BluetoothGatt bluetoothGatt = bLEService.f31447g;
                                    List<BluetoothGattService> services = bluetoothGatt != null ? bluetoothGatt.getServices() : null;
                                    if (services == null) {
                                        services = new ArrayList<>();
                                    }
                                    BluetoothImp bluetoothImp = this.f31469a;
                                    for (BluetoothGattService bluetoothGattService : services) {
                                        String string = bluetoothGattService.getUuid().toString();
                                        Intrinsics.f(string, "it.uuid.toString()");
                                        boolean z13 = bluetoothGattService.getType() == 0;
                                        TmcLogger.k(bluetoothImp.OooO00o, "mGattUpdateReceiver -> SUCCESS uuid:" + string + ",isPrimary:" + z13);
                                        arrayList.add(s.k(TuplesKt.a("uuid", string), TuplesKt.a("isPrimary", String.valueOf(z13))));
                                    }
                                }
                                Iterator it3 = this.f31469a.OooOO0O.iterator();
                                Intrinsics.f(it3, "deviceServicesListeners.iterator()");
                                while (it3.hasNext()) {
                                    ((d) it3.next()).a(arrayList);
                                    it3.remove();
                                }
                            } else {
                                TmcLogger.k(this.f31469a.OooO00o, "mGattUpdateReceiver -> FAIL:" + j11);
                                Iterator it4 = this.f31469a.OooOO0O.iterator();
                                Intrinsics.f(it4, "deviceServicesListeners.iterator()");
                                while (it4.hasNext()) {
                                    ((d) it4.next()).b(j11);
                                    it4.remove();
                                }
                            }
                            break;
                        }
                        break;
                    case 1591015073:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_SCAN_RESULT")) {
                            TmcLogger.k(this.f31469a.OooO00o, "mGattUpdateReceiver -> ACTION_SCAN_RESULT");
                            Bundle extras4 = intent.getExtras();
                            long j12 = extras4 != null ? extras4.getLong(TrackingKey.CODE) : BluetoothCode.SYSTEM_ERROR.getCode();
                            if (j12 != BluetoothCode.OK.getCode()) {
                                TmcLogger.k(this.f31469a.OooO00o, "mGattUpdateReceiver -> SCAN_FAIL:" + j12);
                                h hVar = this.f31469a.f31458OooO0oo;
                                if (hVar != null) {
                                    hVar.b(j12);
                                }
                                break;
                            } else {
                                Bundle extras5 = intent.getExtras();
                                if (extras5 != null && extras5.containsKey("scan_result")) {
                                    Bundle extras6 = intent.getExtras();
                                    Object objE = k.e(extras6 != null ? extras6.getString("scan_result") : null, new TypeToken<Map<String, ? extends String>>() { // from class: com.cloud.tmc.miniapp.bluetooth.BluetoothImp$mGattUpdateReceiver$1$onReceive$scanRsultData$1
                                    }.getType());
                                    Intrinsics.f(objE, "fromJson(\n              …                        )");
                                    Map<String, String> map = (Map) objE;
                                    TmcLogger.k(this.f31469a.OooO00o, "mGattUpdateReceiver -> SCAN_SUCCESS:" + map);
                                    h hVar2 = this.f31469a.f31458OooO0oo;
                                    if (hVar2 != null) {
                                        hVar2.c(map);
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        }
    };
    public final c OooOOOo = new c();

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends BroadcastReceiver {

        /* JADX INFO: renamed from: com.cloud.tmc.miniapp.bluetooth.BluetoothImp$OooO00o$OooO00o, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0342OooO00o extends Lambda implements Function2<Boolean, Boolean, Unit> {
            public final /* synthetic */ BluetoothImp OooO00o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0342OooO00o(BluetoothImp bluetoothImp) {
                super(2);
                this.OooO00o = bluetoothImp;
            }

            @Override // kotlin.jvm.functions.Function2
            public Unit invoke(Boolean bool, Boolean bool2) {
                boolean zBooleanValue = bool.booleanValue();
                boolean zBooleanValue2 = bool2.booleanValue();
                TmcLogger.k(this.OooO00o.OooO00o, "bluetoothSwitchReceiver -> getBluetoothAdapterState:" + zBooleanValue + ',' + zBooleanValue2);
                g gVar = this.OooO00o.OooO0oO;
                if (gVar != null) {
                    gVar.b(zBooleanValue, zBooleanValue2);
                }
                return Unit.f68710a;
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class OooO0O0 extends Lambda implements Function2<Boolean, Boolean, Unit> {
            public final /* synthetic */ BluetoothImp OooO00o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OooO0O0(BluetoothImp bluetoothImp) {
                super(2);
                this.OooO00o = bluetoothImp;
            }

            @Override // kotlin.jvm.functions.Function2
            public Unit invoke(Boolean bool, Boolean bool2) {
                boolean zBooleanValue = bool.booleanValue();
                boolean zBooleanValue2 = bool2.booleanValue();
                TmcLogger.k(this.OooO00o.OooO00o, "bluetoothSwitchReceiver -> getBluetoothAdapterState:" + zBooleanValue + ',' + zBooleanValue2);
                g gVar = this.OooO00o.OooO0oO;
                if (gVar != null) {
                    gVar.b(zBooleanValue, zBooleanValue2);
                }
                return Unit.f68710a;
            }
        }

        public OooO00o() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Integer numValueOf = intent != null ? Integer.valueOf(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)) : null;
            if ((numValueOf != null && numValueOf.intValue() == 10) || (numValueOf != null && numValueOf.intValue() == 13)) {
                TmcLogger.k(BluetoothImp.this.OooO00o, "bluetoothSwitchReceiver -> STATE_OFF | STATE_TURNING_OFF");
                BLEService bLEService = BluetoothImp.this.f31457OooO0o0;
                if (bLEService != null) {
                    bLEService.k();
                }
                BLEService bLEService2 = BluetoothImp.this.f31457OooO0o0;
                if (bLEService2 != null) {
                    bLEService2.h(new C0342OooO00o(BluetoothImp.this));
                    return;
                }
                return;
            }
            if ((numValueOf != null && numValueOf.intValue() == 12) || (numValueOf != null && numValueOf.intValue() == 11)) {
                TmcLogger.k(BluetoothImp.this.OooO00o, "bluetoothSwitchReceiver -> STATE_ON | STATE_TURNING_ON");
                BLEService bLEService3 = BluetoothImp.this.f31457OooO0o0;
                if (bLEService3 != null) {
                    bLEService3.h(new OooO0O0(BluetoothImp.this));
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements PermissionUtils.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f31463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e.a f31464c;

        public a(Context context, e.a aVar) {
            this.f31463b = context;
            this.f31464c = aVar;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            TmcLogger.f(BluetoothImp.this.OooO00o, "> Build.VERSION_CODES.S Permission denied");
            this.f31464c.b(BluetoothCode.NOT_PERMISSION.getCode());
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            BluetoothImp.access$init(BluetoothImp.this, this.f31463b, this.f31464c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements PermissionUtils.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f31466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e.a f31467c;

        public b(Context context, e.a aVar) {
            this.f31466b = context;
            this.f31467c = aVar;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            TmcLogger.f(BluetoothImp.this.OooO00o, "<= Build.VERSION_CODES.S Permission denied");
            this.f31467c.b(BluetoothCode.NOT_PERMISSION.getCode());
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            BluetoothImp.access$init(BluetoothImp.this, this.f31466b, this.f31467c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            long code;
            BluetoothAdapter bluetoothAdapter;
            BluetoothImp bluetoothImp = BluetoothImp.this;
            Intrinsics.e(iBinder, "null cannot be cast to non-null type com.cloud.tmc.miniapp.bluetooth.BLEService.LocalBinder");
            bluetoothImp.f31457OooO0o0 = BLEService.this;
            e.a aVar = BluetoothImp.this.f31456OooO0o;
            if (aVar != null) {
                BLEService bLEService = BluetoothImp.this.f31457OooO0o0;
                if (bLEService != null) {
                    Object systemService = bLEService.getSystemService("bluetooth");
                    BluetoothManager bluetoothManager = systemService instanceof BluetoothManager ? (BluetoothManager) systemService : null;
                    bLEService.f31442a = bluetoothManager;
                    BluetoothAdapter adapter = bluetoothManager != null ? bluetoothManager.getAdapter() : null;
                    bLEService.f31443b = adapter;
                    bLEService.f31444c = adapter != null ? adapter.getBluetoothLeScanner() : null;
                    bLEService.f31445d = new f(bLEService);
                    if (bLEService.f31442a == null || (bluetoothAdapter = bLEService.f31443b) == null || bLEService.f31444c == null) {
                        code = BluetoothCode.NOT_INIT.getCode();
                    } else if (bluetoothAdapter.isEnabled()) {
                        bLEService.j();
                        code = BluetoothCode.OK.getCode();
                    } else {
                        code = BluetoothCode.NOT_AVALIABLE.getCode();
                    }
                } else {
                    code = BluetoothCode.FAIL.getCode();
                }
                aVar.b(code);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            BluetoothImp.this.f31457OooO0o0 = null;
        }
    }

    public static final void access$init(BluetoothImp bluetoothImp, Context context, e.a aVar) {
        if (bluetoothImp.f31455OooO0Oo.get()) {
            TmcLogger.c(bluetoothImp.OooO00o, "BluetoothManager already init");
            aVar.b(BluetoothCode.ALREADY_INIT.getCode());
            return;
        }
        bluetoothImp.f31455OooO0Oo.set(true);
        bluetoothImp.OooO0O0 = context;
        bluetoothImp.f31456OooO0o = aVar;
        Intent intent = new Intent(context, (Class<?>) BLEService.class);
        bluetoothImp.OooO0OO = intent;
        com.cloud.tmc.integration.utils.h.f31061a.a(intent, context);
        Intent intent2 = bluetoothImp.OooO0OO;
        if (intent2 != null) {
            context.bindService(intent2, bluetoothImp.OooOOOo, 1);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_NOTIFY_BLUETOOTH_ADAPTER_STATE_CHANGE");
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_SCAN_RESULT");
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_DEVICE_CONNECT_STATE");
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_SERVICES_DISCOVERED");
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_READ_CHARACTERISTIC");
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_WRITE_CHARACTERISTIC");
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_NOTIFY_CHARACTERISTIC");
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(bluetoothImp.OooOOOO, intentFilter, 4);
        } else {
            context.registerReceiver(bluetoothImp.OooOOOO, intentFilter);
        }
        context.registerReceiver(bluetoothImp.OooOOO, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long closeBLEConnection(String address) {
        Intrinsics.g(address, "address");
        if (TextUtils.isEmpty(address)) {
            return BluetoothCode.INVALID_DATA.getCode();
        }
        BLEService bLEService = this.f31457OooO0o0;
        return bLEService != null ? bLEService.b(address) : BluetoothCode.SYSTEM_ERROR.getCode();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void closeBluetoothAdapter() {
        this.f31455OooO0Oo.set(false);
        BLEService bLEService = this.f31457OooO0o0;
        if (bLEService != null && (Build.VERSION.SDK_INT <= 31 || z2.a.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") == 0)) {
            String str = bLEService.f31448h;
            if (str == null) {
                str = "";
            }
            bLEService.b(str);
            bLEService.k();
            bLEService.f31445d = null;
            bLEService.f31444c = null;
            bLEService.f31443b = null;
            bLEService.f31442a = null;
            bLEService.j();
        }
        Context context = this.OooO0O0;
        if (context != null) {
            context.unbindService(this.OooOOOo);
        }
        Context context2 = this.OooO0O0;
        if (context2 != null) {
            context2.unregisterReceiver(this.OooOOOO);
        }
        Context context3 = this.OooO0O0;
        if (context3 != null) {
            context3.unregisterReceiver(this.OooOOO);
        }
        this.OooO0O0 = null;
        this.f31457OooO0o0 = null;
        this.f31456OooO0o = null;
        this.OooO0oO = null;
        this.f31458OooO0oo = null;
        this.f31454OooO = null;
        this.f31459OooOO0 = null;
        this.OooOO0O.clear();
        this.f31460OooOO0o.clear();
        this.OooOOO0.clear();
        TmcLogger.c(this.OooO00o, "closeBluetoothAdapter  -> ");
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long createBLEConnection(String address) {
        BluetoothGatt bluetoothGatt;
        Intrinsics.g(address, "address");
        if (TextUtils.isEmpty(address)) {
            return BluetoothCode.INVALID_DATA.getCode();
        }
        BLEService bLEService = this.f31457OooO0o0;
        if (bLEService == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        Intrinsics.g(address, "address");
        if (!bLEService.i()) {
            return BluetoothCode.NOT_AVALIABLE.getCode();
        }
        if (bLEService.f31442a == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        if (bLEService.f31449i.get()) {
            return BluetoothCode.ALREADY_CONNECION.getCode();
        }
        if (Build.VERSION.SDK_INT > 31 && z2.a.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BluetoothCode.NOT_PERMISSION.getCode();
        }
        if (Intrinsics.b(address, bLEService.f31448h) && (bluetoothGatt = bLEService.f31447g) != null) {
            return bluetoothGatt.connect() ? BluetoothCode.OK.getCode() : BluetoothCode.CONNECTION_FAIL.getCode();
        }
        BluetoothAdapter bluetoothAdapter = bLEService.f31443b;
        BluetoothDevice remoteDevice = bluetoothAdapter != null ? bluetoothAdapter.getRemoteDevice(address) : null;
        bLEService.f31447g = remoteDevice != null ? remoteDevice.connectGatt(bLEService, false, bLEService.f31451k) : null;
        bLEService.f31448h = address;
        return BluetoothCode.OK.getCode();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public List<BluetoothGattCharacteristic> getBLEDeviceCharacteristics(String serviceUUID) {
        BLEService bLEService;
        Intrinsics.g(serviceUUID, "serviceUUID");
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(serviceUUID) && (bLEService = this.f31457OooO0o0) != null) {
            BluetoothGatt bluetoothGatt = bLEService.f31447g;
            List<BluetoothGattService> services = bluetoothGatt != null ? bluetoothGatt.getServices() : null;
            if (services == null) {
                services = new ArrayList<>();
            }
            for (BluetoothGattService bluetoothGattService : services) {
                if (l.v(serviceUUID, bluetoothGattService.getUuid().toString(), true)) {
                    List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                    Intrinsics.f(characteristics, "it.characteristics");
                    arrayList.addAll(characteristics);
                }
            }
        }
        return arrayList;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public List<Map<String, String>> getBLEDeviceCharacteristicsMap(String serviceUUID) {
        Intrinsics.g(serviceUUID, "serviceUUID");
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(serviceUUID)) {
            return arrayList;
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : getBLEDeviceCharacteristics(serviceUUID)) {
            arrayList.add(s.k(TuplesKt.a("uuid", bluetoothGattCharacteristic.getUuid().toString()), TuplesKt.a("properties", String.valueOf(bluetoothGattCharacteristic.getProperties()))));
        }
        return arrayList;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void getBLEDeviceServices(d listener) {
        long code;
        Intrinsics.g(listener, "listener");
        BLEService bLEService = this.f31457OooO0o0;
        if (bLEService == null) {
            code = BluetoothCode.SYSTEM_ERROR.getCode();
        } else if (Build.VERSION.SDK_INT <= 31 || z2.a.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") == 0) {
            BluetoothGatt bluetoothGatt = bLEService.f31447g;
            if (bluetoothGatt != null) {
                code = bluetoothGatt.discoverServices() ? BluetoothCode.OK.getCode() : BluetoothCode.FAIL.getCode();
            } else {
                code = BluetoothCode.SYSTEM_ERROR.getCode();
            }
        } else {
            code = BluetoothCode.NOT_PERMISSION.getCode();
        }
        if (code != BluetoothCode.OK.getCode()) {
            listener.b(code);
        } else {
            this.OooOO0O.add(listener);
        }
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long getBluetoothAdapterState(Function2<? super Boolean, ? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        BLEService bLEService = this.f31457OooO0o0;
        if (bLEService == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        bLEService.h(callback);
        return BluetoothCode.OK.getCode();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public List<BluetoothDevice> getConnectedBluetoothDevices() {
        BLEService bLEService = this.f31457OooO0o0;
        return bLEService != null ? bLEService.e() : new ArrayList();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public List<Map<String, String>> getConnectedBluetoothDevicesMap() {
        BLEService bLEService = this.f31457OooO0o0;
        if (bLEService == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT > 31 && z2.a.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") != 0) {
            return arrayList;
        }
        for (BluetoothDevice bluetoothDevice : bLEService.e()) {
            arrayList.add(s.k(TuplesKt.a("name", bluetoothDevice.getName()), TuplesKt.a(PlaceTypes.ADDRESS, bluetoothDevice.getAddress())));
        }
        return arrayList;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long notifyBLECharacteristicValueChange(String serviceUUID, String characteristicUUID, boolean z11) {
        Intrinsics.g(serviceUUID, "serviceUUID");
        Intrinsics.g(characteristicUUID, "characteristicUUID");
        if (TextUtils.isEmpty(serviceUUID) || TextUtils.isEmpty(characteristicUUID)) {
            return BluetoothCode.INVALID_DATA.getCode();
        }
        BluetoothGattCharacteristic characteristic = null;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : getBLEDeviceCharacteristics(serviceUUID)) {
            if (l.v(characteristicUUID, bluetoothGattCharacteristic.getUuid().toString(), true)) {
                characteristic = bluetoothGattCharacteristic;
            }
        }
        if (characteristic == null) {
            return BluetoothCode.N0_CHARACTERISTIC.getCode();
        }
        BLEService bLEService = this.f31457OooO0o0;
        if (bLEService == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        Intrinsics.g(characteristic, "characteristic");
        if (Build.VERSION.SDK_INT > 31 && z2.a.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BluetoothCode.NOT_PERMISSION.getCode();
        }
        BluetoothGatt bluetoothGatt = bLEService.f31447g;
        if (bluetoothGatt == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        if (!bluetoothGatt.setCharacteristicNotification(characteristic, z11)) {
            return BluetoothCode.FAIL.getCode();
        }
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
        if (descriptor == null) {
            return BluetoothCode.N0_CHARACTERISTIC_DESCRIPTOR.getCode();
        }
        Intrinsics.f(descriptor, "getDescriptor(UUID.fromS…T_CHARACTERISTIC_CONFIG))");
        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        bluetoothGatt.writeDescriptor(descriptor);
        return BluetoothCode.OK.getCode();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public boolean offBLECharacteristicValueChange(String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
        e.b bVar = this.f31459OooOO0;
        if (bVar != null) {
            bVar.a(callbackId);
        }
        this.f31459OooOO0 = null;
        return true;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public boolean offBLEConnectionStateChange(String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
        e.c cVar = this.f31454OooO;
        if (cVar != null) {
            cVar.a(callbackId);
        }
        this.f31454OooO = null;
        return true;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public boolean offBluetoothAdapterStateChange(String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
        g gVar = this.OooO0oO;
        if (gVar != null) {
            gVar.a(callbackId);
        }
        this.OooO0oO = null;
        return true;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public boolean offBluetoothDeviceFound(String callbackId) {
        Intrinsics.g(callbackId, "callbackId");
        h hVar = this.f31458OooO0oo;
        if (hVar != null) {
            hVar.a(callbackId);
        }
        this.f31458OooO0oo = null;
        return true;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void onBLECharacteristicValueChange(String callbackId, e.b listener) {
        Intrinsics.g(callbackId, "callbackId");
        Intrinsics.g(listener, "listener");
        this.f31459OooOO0 = listener;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void onBLEConnectionStateChange(String callbackId, e.c listener) {
        Intrinsics.g(callbackId, "callbackId");
        Intrinsics.g(listener, "listener");
        this.f31454OooO = listener;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void onBluetoothAdapterStateChange(String callbackId, g bluetoothAdapterStateListener) {
        Intrinsics.g(callbackId, "callbackId");
        Intrinsics.g(bluetoothAdapterStateListener, "bluetoothAdapterStateListener");
        this.OooO0oO = bluetoothAdapterStateListener;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void onBluetoothDeviceFound(String callbackId, h listener) {
        Intrinsics.g(callbackId, "callbackId");
        Intrinsics.g(listener, "listener");
        this.f31458OooO0oo = listener;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void openBluetoothAdapter(Context context, e.a callback) {
        Intrinsics.g(context, "context");
        Intrinsics.g(callback, "callback");
        if (Build.VERSION.SDK_INT >= 31) {
            PermissionUtils.x("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.ACCESS_COARSE_LOCATION").m(new a(context, callback)).z();
        } else {
            PermissionUtils.x("android.permission.ACCESS_COARSE_LOCATION").m(new b(context, callback)).z();
        }
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long readBLECharacteristicValue(String serviceUUID, String characteristicUUID, e listener) {
        Intrinsics.g(serviceUUID, "serviceUUID");
        Intrinsics.g(characteristicUUID, "characteristicUUID");
        Intrinsics.g(listener, "listener");
        if (TextUtils.isEmpty(serviceUUID) || TextUtils.isEmpty(characteristicUUID)) {
            return BluetoothCode.INVALID_DATA.getCode();
        }
        BluetoothGattCharacteristic characteristic = null;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : getBLEDeviceCharacteristics(serviceUUID)) {
            if (l.v(characteristicUUID, bluetoothGattCharacteristic.getUuid().toString(), true)) {
                characteristic = bluetoothGattCharacteristic;
            }
        }
        if (characteristic == null) {
            return BluetoothCode.N0_CHARACTERISTIC.getCode();
        }
        this.f31460OooOO0o.add(listener);
        BLEService bLEService = this.f31457OooO0o0;
        if (bLEService == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        Intrinsics.g(characteristic, "characteristic");
        if (Build.VERSION.SDK_INT > 31 && z2.a.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BluetoothCode.NOT_PERMISSION.getCode();
        }
        BluetoothGatt bluetoothGatt = bLEService.f31447g;
        if (bluetoothGatt != null) {
            return bluetoothGatt.readCharacteristic(characteristic) ? BluetoothCode.OK.getCode() : BluetoothCode.FAIL.getCode();
        }
        return BluetoothCode.SYSTEM_ERROR.getCode();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long startBluetoothDevicesDiscovery(List<String> serviceUUIDS, int i11) {
        Intrinsics.g(serviceUUIDS, "serviceUUIDS");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startBluetoothDevicesDiscovery -> serviceUUIDS:");
        sb2.append(serviceUUIDS);
        sb2.append("powerLevel:");
        sb2.append(i11);
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.OooO0O0;
            LocationManager locationManager = (LocationManager) (context != null ? context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION) : null);
            if (locationManager == null || !locationManager.isProviderEnabled("gps")) {
                return BluetoothCode.NO_POSITION_FUNCTION.getCode();
            }
        }
        BLEService bLEService = this.f31457OooO0o0;
        if (bLEService == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        Intrinsics.g(serviceUUIDS, "serviceUUIDS");
        if (!bLEService.i()) {
            return BluetoothCode.NOT_AVALIABLE.getCode();
        }
        if (bLEService.f31444c == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = serviceUUIDS.iterator();
        while (it.hasNext()) {
            ScanFilter scanFilterBuild = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString((String) it.next())).build();
            Intrinsics.f(scanFilterBuild, "Builder().setServiceUuid…d.fromString(it)).build()");
            arrayList.add(scanFilterBuild);
        }
        if (Build.VERSION.SDK_INT > 31 && z2.a.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BluetoothCode.NOT_PERMISSION.getCode();
        }
        BluetoothLeScanner bluetoothLeScanner = bLEService.f31444c;
        if (bluetoothLeScanner == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        bluetoothLeScanner.startScan(arrayList, new ScanSettings.Builder().setScanMode(i11).build(), bLEService.f31445d);
        bLEService.f31446f.set(true);
        return BluetoothCode.OK.getCode();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void stopBluetoothDevicesDiscovery() {
        BLEService bLEService = this.f31457OooO0o0;
        if (bLEService != null) {
            bLEService.k();
        }
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long writeBLECharacteristicValue(String serviceUUID, String characteristicUUID, byte[] value, e listener) {
        Intrinsics.g(serviceUUID, "serviceUUID");
        Intrinsics.g(characteristicUUID, "characteristicUUID");
        Intrinsics.g(value, "value");
        Intrinsics.g(listener, "listener");
        if (TextUtils.isEmpty(serviceUUID) || TextUtils.isEmpty(characteristicUUID)) {
            return BluetoothCode.INVALID_DATA.getCode();
        }
        BluetoothGattCharacteristic characteristic = null;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : getBLEDeviceCharacteristics(serviceUUID)) {
            if (l.v(characteristicUUID, bluetoothGattCharacteristic.getUuid().toString(), true)) {
                characteristic = bluetoothGattCharacteristic;
            }
        }
        if (characteristic == null) {
            return BluetoothCode.N0_CHARACTERISTIC.getCode();
        }
        this.OooOOO0.add(listener);
        BLEService bLEService = this.f31457OooO0o0;
        if (bLEService == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        Intrinsics.g(characteristic, "characteristic");
        Intrinsics.g(value, "value");
        characteristic.setValue(value);
        if (Build.VERSION.SDK_INT > 31 && z2.a.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BluetoothCode.NOT_PERMISSION.getCode();
        }
        BluetoothGatt bluetoothGatt = bLEService.f31447g;
        if (bluetoothGatt != null) {
            return bluetoothGatt.writeCharacteristic(characteristic) ? BluetoothCode.OK.getCode() : BluetoothCode.FAIL.getCode();
        }
        return BluetoothCode.SYSTEM_ERROR.getCode();
    }
}
