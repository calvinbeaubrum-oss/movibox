package com.transsion.baselib.net;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f51224a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f51225b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f51226c = new AtomicBoolean(true);

    public static final boolean d(Ref.ObjectRef rawCallback, Message msg) {
        Intrinsics.g(rawCallback, "$rawCallback");
        Intrinsics.g(msg, "msg");
        uo.b.a.o(uo.b.f78622a, "hook", new String[]{"msg= " + msg.what}, false, 4, null);
        AtomicBoolean atomicBoolean = f51225b;
        if (!atomicBoolean.get()) {
            atomicBoolean.set(true);
            int i11 = msg.what;
            int i12 = Build.VERSION.SDK_INT;
            boolean z11 = i12 >= 35 && i11 == 164;
            boolean z12 = i12 >= 28 && i11 == 159;
            boolean z13 = i12 < 28 && i11 == 100;
            if (z12 || z13 || z11) {
                f51226c.set(true);
            } else {
                f51226c.set(false);
            }
        }
        Handler.Callback callback = (Handler.Callback) rawCallback.element;
        if (callback != null) {
            return callback.handleMessage(msg);
        }
        return false;
    }

    public final AtomicBoolean b() {
        return f51226c;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, android.os.Handler$Callback] */
    public final void c() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = cls.getDeclaredField("mH");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Field declaredField3 = obj2.getClass().getSuperclass().getDeclaredField("mCallback");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj2);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            if (obj3 != null) {
                objectRef.element = (Handler.Callback) obj3;
            }
            declaredField3.set(obj2, new Handler.Callback() { // from class: com.transsion.baselib.net.b
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return c.d(objectRef, message);
                }
            });
        } catch (Exception e11) {
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("exception= ");
            sb2.append(message);
        }
    }
}
