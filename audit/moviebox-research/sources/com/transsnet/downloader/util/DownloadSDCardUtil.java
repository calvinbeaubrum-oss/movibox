package com.transsnet.downloader.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import com.blankj.utilcode.util.Utils;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsnet.downloader.R$string;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class DownloadSDCardUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownloadSDCardUtil f61130a = new DownloadSDCardUtil();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f61131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f61132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f61133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DownloadSDCardUtil$sdcardBroadcastReceiver$1 f61134e;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.transsnet.downloader.util.DownloadSDCardUtil$sdcardBroadcastReceiver$1] */
    static {
        String string = Utils.a().getString(R$string.sdcard_name);
        Intrinsics.f(string, "getApp().getString(R.string.sdcard_name)");
        f61131b = string;
        f61134e = new BroadcastReceiver() { // from class: com.transsnet.downloader.util.DownloadSDCardUtil$sdcardBroadcastReceiver$1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.g(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    switch (action.hashCode()) {
                        case -1665311200:
                            if (!action.equals("android.intent.action.MEDIA_REMOVED")) {
                                return;
                            }
                            break;
                        case -1514214344:
                            if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
                                DownloadSDCardUtil.f61130a.d(true);
                                uo.b.f78622a.c("DownloadSDCard", "SD/TF卡已插入", true);
                                DownloadRefreshEvent downloadRefreshEvent = new DownloadRefreshEvent("", "", false, false, 12, null);
                                AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
                                FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
                                String name = DownloadRefreshEvent.class.getName();
                                Intrinsics.f(name, "T::class.java.name");
                                flowEventBus.postEvent(name, downloadRefreshEvent, 0L);
                                f00.d dVar = new f00.d(true, false);
                                FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
                                String name2 = f00.d.class.getName();
                                Intrinsics.f(name2, "T::class.java.name");
                                flowEventBus2.postEvent(name2, dVar, 0L);
                                return;
                            }
                            return;
                        case -963871873:
                            if (!action.equals("android.intent.action.MEDIA_UNMOUNTED")) {
                                return;
                            }
                            break;
                        case 2045140818:
                            if (!action.equals("android.intent.action.MEDIA_BAD_REMOVAL")) {
                                return;
                            }
                            break;
                        default:
                            return;
                    }
                    DownloadSDCardUtil.f61130a.d(false);
                    uo.b.f78622a.c("DownloadSDCard", "SD/TF卡已拔出", true);
                    DownloadRefreshEvent downloadRefreshEvent2 = new DownloadRefreshEvent("", "", false, false, 12, null);
                    AppScopeVMlProvider appScopeVMlProvider2 = AppScopeVMlProvider.INSTANCE;
                    FlowEventBus flowEventBus3 = (FlowEventBus) appScopeVMlProvider2.getApplicationScopeViewModel(FlowEventBus.class);
                    String name3 = DownloadRefreshEvent.class.getName();
                    Intrinsics.f(name3, "T::class.java.name");
                    flowEventBus3.postEvent(name3, downloadRefreshEvent2, 0L);
                    f00.d dVar2 = new f00.d(true, false);
                    FlowEventBus flowEventBus4 = (FlowEventBus) appScopeVMlProvider2.getApplicationScopeViewModel(FlowEventBus.class);
                    String name4 = f00.d.class.getName();
                    Intrinsics.f(name4, "T::class.java.name");
                    flowEventBus4.postEvent(name4, dVar2, 0L);
                }
            }
        };
    }

    public final List<f00.b> a() {
        ArrayList arrayList = new ArrayList();
        try {
            List<f00.e> listB = b();
            if (listB.size() < 2) {
                return arrayList;
            }
            String strB = "";
            for (f00.e eVar : listB) {
                if (!eVar.c()) {
                    strB = eVar.b();
                    break;
                }
            }
            if (strB.length() == 0) {
                return arrayList;
            }
            int i11 = 0;
            boolean z11 = listB.size() > 2;
            for (f00.e eVar2 : listB) {
                if (eVar2.c()) {
                    i11++;
                    String strB2 = eVar2.b();
                    String str = File.separator;
                    tr.b.a aVar = tr.b.f77264a;
                    arrayList.add(new f00.b(strB2 + str + aVar.e(), str + aVar.e(), z11 ? f61131b + " " + i11 + " " : f61131b, 2, eVar2.a(), 3));
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public final List<f00.e> b() {
        String str = "null cannot be cast to non-null type kotlin.Boolean";
        Object systemService = Utils.a().getSystemService(PlaceTypes.STORAGE);
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.os.storage.StorageManager");
        StorageManager storageManager = (StorageManager) systemService;
        ArrayList arrayList = new ArrayList();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23) {
            return arrayList;
        }
        int i12 = 0;
        if (i11 >= 24) {
            List storageVolumes = storageManager.getStorageVolumes();
            Intrinsics.f(storageVolumes, "sm.storageVolumes");
            try {
                Iterator it = storageVolumes.iterator();
                while (it.hasNext()) {
                    StorageVolume storageVolumeA = g.a(it.next());
                    boolean zIsRemovable = storageVolumeA.isRemovable();
                    boolean zIsEmulated = storageVolumeA.isEmulated();
                    String state = storageVolumeA.getState();
                    if (zIsRemovable) {
                        f61133d = true;
                    }
                    try {
                        Class<?> cls = Class.forName(storageVolumeA.getClass().getName());
                        try {
                            Method declaredMethod = cls.getDeclaredMethod("getPath", null);
                            declaredMethod.setAccessible(true);
                            Object objInvoke = declaredMethod.invoke(storageVolumeA, new Object[0]);
                            Intrinsics.e(objInvoke, "null cannot be cast to non-null type kotlin.String");
                            Intrinsics.f(state, "state");
                            arrayList.add(new f00.e((String) objInvoke, state, zIsRemovable, zIsEmulated));
                        } catch (Throwable unused) {
                            Field declaredField = cls.getDeclaredField("mPath");
                            declaredField.setAccessible(true);
                            Object obj = declaredField.get(storageVolumeA);
                            if (obj != null) {
                                String string = obj.toString();
                                Intrinsics.f(state, "state");
                                arrayList.add(new f00.e(string, state, zIsRemovable, zIsEmulated));
                            }
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        } else {
            try {
                Class<?> cls2 = Class.forName("android.os.storage.StorageVolume");
                Method method = cls2.getMethod("getPath", new Class[0]);
                Method method2 = cls2.getMethod("isRemovable", new Class[0]);
                Method method3 = cls2.getMethod("isEmulated", new Class[0]);
                Method method4 = StorageManager.class.getMethod("getVolumeState", String.class);
                Object objInvoke2 = StorageManager.class.getMethod("getVolumeList", new Class[0]).invoke(storageManager, new Object[0]);
                int length = Array.getLength(objInvoke2);
                int i13 = 0;
                while (i13 < length) {
                    Object obj2 = Array.get(objInvoke2, i13);
                    Object objInvoke3 = method.invoke(obj2, new Object[i12]);
                    Intrinsics.e(objInvoke3, "null cannot be cast to non-null type kotlin.String");
                    String str2 = (String) objInvoke3;
                    Object objInvoke4 = method2.invoke(obj2, new Object[i12]);
                    Intrinsics.e(objInvoke4, str);
                    boolean zBooleanValue = ((Boolean) objInvoke4).booleanValue();
                    Object objInvoke5 = method3.invoke(obj2, new Object[i12]);
                    Intrinsics.e(objInvoke5, str);
                    boolean zBooleanValue2 = ((Boolean) objInvoke5).booleanValue();
                    String str3 = str;
                    Object[] objArr = new Object[1];
                    objArr[i12] = str2;
                    Object objInvoke6 = method4.invoke(storageManager, objArr);
                    Intrinsics.e(objInvoke6, "null cannot be cast to non-null type kotlin.String");
                    arrayList.add(new f00.e(str2, (String) objInvoke6, zBooleanValue, zBooleanValue2));
                    i13++;
                    str = str3;
                    i12 = 0;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        }
        return arrayList;
    }

    public final void c() {
        if (f61132c) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        intentFilter.addDataScheme("file");
        if (Build.VERSION.SDK_INT >= 33) {
            Utils.a().registerReceiver(f61134e, intentFilter, 2);
        } else {
            Utils.a().registerReceiver(f61134e, intentFilter);
        }
        f61132c = true;
    }

    public final void d(boolean z11) {
        f61133d = z11;
    }

    public final void e() {
        try {
            if (f61132c) {
                f61132c = false;
                Utils.a().unregisterReceiver(f61134e);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
