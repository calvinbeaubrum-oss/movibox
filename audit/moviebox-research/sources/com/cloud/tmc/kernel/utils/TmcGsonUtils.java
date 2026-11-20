package com.cloud.tmc.kernel.utils;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class TmcGsonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TmcGsonUtils f31280a = new TmcGsonUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f31281b = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<Gson>() { // from class: com.cloud.tmc.kernel.utils.TmcGsonUtils$gson$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Gson invoke() {
            return TmcGsonUtils.f31280a.c();
        }
    });

    @JvmStatic
    public static final Map<String, String> a(String str) {
        try {
            return (Map) f31280a.f().fromJson(str, new TypeToken<Map<String, ? extends String>>() { // from class: com.cloud.tmc.kernel.utils.TmcGsonUtils$JsonToMapValueIsString$1
            }.getType());
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            Log.e("GsonUtils", message);
            return null;
        }
    }

    @JvmStatic
    public static final <T> T d(String str, Class<T> cls) {
        Intrinsics.g(cls, "cls");
        try {
            return (T) f31280a.f().fromJson(str, (Class) cls);
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            Log.e("GsonUtils", message);
            return null;
        }
    }

    @JvmStatic
    public static final <T> T e(String str, Type typeOfT) {
        Intrinsics.g(typeOfT, "typeOfT");
        return (T) f31280a.f().fromJson(str, typeOfT);
    }

    @JvmStatic
    public static final <T> Map<String, T> g(String str) {
        try {
            return (Map) f31280a.f().fromJson(str, new TypeToken<Map<String, ? extends T>>() { // from class: com.cloud.tmc.kernel.utils.TmcGsonUtils$mapFromJson$1
            }.getType());
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            Log.e("GsonUtils", message);
            return null;
        }
    }

    @JvmStatic
    public static final String h(Object obj) {
        String json = f31280a.f().toJson(obj);
        Intrinsics.f(json, "gson.toJson(`object`)");
        return json;
    }

    public final Gson c() {
        Gson gsonF = com.cloud.tmc.miniutils.util.k.f();
        Intrinsics.f(gsonF, "getGson()");
        return gsonF;
    }

    public final Gson f() {
        return (Gson) f31281b.getValue();
    }
}
