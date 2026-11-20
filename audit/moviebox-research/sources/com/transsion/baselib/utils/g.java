package com.transsion.baselib.utils;

import android.app.Application;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f51315a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f51316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f51317c;

    public final boolean a() {
        Boolean bool = f51316b;
        if (bool != null) {
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        if (Build.VERSION.SDK_INT <= 26) {
            f51316b = Boolean.TRUE;
        }
        TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        if (tNDeviceHelper.j(applicationA).totalMem <= 4294967296L) {
            f51316b = Boolean.TRUE;
        }
        Boolean bool2 = f51316b;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }

    public final boolean b() {
        String value;
        Boolean bool = f51317c;
        if (bool != null) {
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        try {
            TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            long j11 = tNDeviceHelper.j(applicationA).totalMem;
            ConfigBean configBeanB = ConfigManager.f53111c.a().b("lowMemoryValue", true);
            if (configBeanB == null || (value = configBeanB.getValue()) == null) {
                value = "1.0";
            }
            if (j11 <= ((double) 1073741824) * Double.parseDouble(value)) {
                f51317c = Boolean.TRUE;
            }
            Boolean bool2 = f51317c;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
