package com.permissionx.guolindev.request;

import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import com.permissionx.guolindev.PermissionX;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseTask implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public PermissionBuilder f48647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f48648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public c f48649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f48650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f48651e;

    public BaseTask(PermissionBuilder pb2) {
        Intrinsics.g(pb2, "pb");
        this.f48647a = pb2;
        this.f48648b = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.permissionx.guolindev.request.BaseTask$mmkv$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MMKV invoke() {
                return MMKV.z("kv_permission_x");
            }
        });
        this.f48650d = new d(this.f48647a, this);
        this.f48651e = new e(this.f48647a, this);
        this.f48650d = new d(this.f48647a, this);
        this.f48651e = new e(this.f48647a, this);
    }

    @Override // com.permissionx.guolindev.request.c
    public d b() {
        return this.f48650d;
    }

    public final MMKV c() {
        Object value = this.f48648b.getValue();
        Intrinsics.f(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }

    @Override // com.permissionx.guolindev.request.c
    public void finish() {
        Unit unit;
        c cVar = this.f48649c;
        if (cVar != null) {
            cVar.request();
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f48647a.f48676k);
            arrayList.addAll(this.f48647a.f48677l);
            arrayList.addAll(this.f48647a.f48674i);
            if (this.f48647a.B()) {
                if (PermissionX.f48641a.e(this.f48647a.i(), "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    this.f48647a.f48675j.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                } else {
                    arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                }
            }
            if (this.f48647a.H() && Build.VERSION.SDK_INT >= 23 && this.f48647a.l() >= 23) {
                if (Settings.canDrawOverlays(this.f48647a.i())) {
                    this.f48647a.f48675j.add("android.permission.SYSTEM_ALERT_WINDOW");
                } else {
                    arrayList.add("android.permission.SYSTEM_ALERT_WINDOW");
                }
            }
            if (this.f48647a.I() && Build.VERSION.SDK_INT >= 23 && this.f48647a.l() >= 23) {
                if (Settings.System.canWrite(this.f48647a.i())) {
                    this.f48647a.f48675j.add("android.permission.WRITE_SETTINGS");
                } else {
                    arrayList.add("android.permission.WRITE_SETTINGS");
                }
            }
            if (this.f48647a.E()) {
                if (Build.VERSION.SDK_INT < 30 || !Environment.isExternalStorageManager()) {
                    arrayList.add("android.permission.MANAGE_EXTERNAL_STORAGE");
                } else {
                    this.f48647a.f48675j.add("android.permission.MANAGE_EXTERNAL_STORAGE");
                }
            }
            if (this.f48647a.D()) {
                if (Build.VERSION.SDK_INT < 26 || this.f48647a.l() < 26 || !this.f48647a.i().getPackageManager().canRequestPackageInstalls()) {
                    arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
                } else {
                    this.f48647a.f48675j.add("android.permission.REQUEST_INSTALL_PACKAGES");
                }
            }
            if (this.f48647a.F()) {
                if (PermissionX.f48641a.a(this.f48647a.i())) {
                    this.f48647a.f48675j.add("android.permission.POST_NOTIFICATIONS");
                } else {
                    arrayList.add("android.permission.POST_NOTIFICATIONS");
                }
            }
            if (this.f48647a.G()) {
                if (PermissionX.f48641a.b(this.f48647a.i())) {
                    this.f48647a.f48675j.add("android.permission.PICTURE_IN_PICTURE");
                } else {
                    arrayList.add("android.permission.PICTURE_IN_PICTURE");
                }
            }
            if (this.f48647a.C()) {
                if (PermissionX.f48641a.e(this.f48647a.i(), "android.permission.BODY_SENSORS_BACKGROUND")) {
                    this.f48647a.f48675j.add("android.permission.BODY_SENSORS_BACKGROUND");
                } else {
                    arrayList.add("android.permission.BODY_SENSORS_BACKGROUND");
                }
            }
            ao.c cVar2 = this.f48647a.f48681p;
            if (cVar2 != null) {
                Intrinsics.d(cVar2);
                cVar2.a(arrayList.isEmpty(), new ArrayList(this.f48647a.f48675j), arrayList);
            }
            this.f48647a.f();
        }
    }
}
