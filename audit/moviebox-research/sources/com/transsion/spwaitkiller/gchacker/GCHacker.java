package com.transsion.spwaitkiller.gchacker;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uo.b;

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
public final class GCHacker {
    public static final GCHacker INSTANCE = new GCHacker();
    private static final String TAG = "GCHacker";

    private GCHacker() {
    }

    public final void hookGCTimeout() {
        try {
            Class<?> cls = Class.forName("java.lang.Daemons$FinalizerWatchdogDaemon");
            Field declaredField = cls.getDeclaredField("INSTANCE");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            try {
                Field declaredField2 = cls.getSuperclass().getDeclaredField("thread");
                Intrinsics.f(declaredField2, "clazz.superclass.getDeclaredField(\"thread\")");
                declaredField2.setAccessible(true);
                declaredField2.set(obj, null);
            } catch (Throwable th2) {
                b.a.f(b.f78622a, TAG, "stopWatchDog, set null occur error:" + th2, false, 4, null);
                th2.printStackTrace();
                try {
                    Method declaredMethod = cls.getSuperclass().getDeclaredMethod("stop", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(obj, new Object[0]);
                } catch (Throwable unused) {
                    b.a.f(b.f78622a, TAG, "stopWatchDog, stop occur error:" + th2, false, 4, null);
                    th2.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            b.a.f(b.f78622a, TAG, "stopWatchDog, get object occur error:" + th3, false, 4, null);
            th3.printStackTrace();
        }
    }
}
