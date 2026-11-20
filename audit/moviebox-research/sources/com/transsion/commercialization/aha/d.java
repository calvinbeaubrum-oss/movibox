package com.transsion.commercialization.aha;

import android.os.Build;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.bean.AhaGameResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import y30.j;
import y30.o;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f51622a = a.f51623a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f51623a = new a();

        public final Map<String, Object> a() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("multiple_base_url", b());
            TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
            linkedHashMap.put("X-Country", tNDeviceHelper.e());
            linkedHashMap.put("X-Gaid", tNDeviceHelper.h());
            linkedHashMap.put("X-Language", tNDeviceHelper.i());
            linkedHashMap.put("X-Model", Build.MODEL);
            linkedHashMap.put("X-VersionCode", Integer.valueOf(com.blankj.utilcode.util.c.d()));
            linkedHashMap.put("X-CPU", tNDeviceHelper.d());
            return linkedHashMap;
        }

        public final String b() {
            return "https://api.ahagamecenter.com/bff/game.moviebox";
        }
    }

    @o("/bff/game.moviebox")
    Object a(@j Map<String, Object> map, @y30.a RequestBody requestBody, Continuation<? super AhaGameResponse> continuation);
}
