package com.cloud.hisavana.sdk;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q1 f30002a = new q1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Integer f30003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Integer f30004c;

    @JvmStatic
    public static final void b(Integer num, Integer num2) {
        if (num != null) {
            f30003b = num;
            da.a.d().n("show_data_sync_time_interval", num.intValue());
        }
        if (num2 != null) {
            f30004c = num2;
            da.a.d().n("click_data_sync_time_interval", num2.intValue());
        }
        z.a().i("AttrDataManager", "showDataSyncTimeInterval = " + num + "，clickDataSyncTimeInterval = " + num2);
        n.f29890a.h();
    }

    public final int a() {
        if (f30004c == null) {
            f30004c = Integer.valueOf(da.a.d().f("click_data_sync_time_interval", -1));
        }
        Integer num = f30004c;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public final void c(Function1<? super Integer, Unit> function1, Function0<Unit> function0, Function0<Unit> function2) {
        int iA = a();
        z.a().i("AttrDataManager", "clickDataSyncAction timeInterval = " + iA);
        if (iA > 0) {
            if (function1 != null) {
                function1.invoke(Integer.valueOf(iA));
            }
        } else if (iA == 0) {
            if (function0 != null) {
                function0.invoke();
            }
        } else if (function2 != null) {
            function2.invoke();
        }
    }

    public final int d() {
        if (f30003b == null) {
            f30003b = Integer.valueOf(da.a.d().f("show_data_sync_time_interval", -1));
        }
        Integer num = f30003b;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
