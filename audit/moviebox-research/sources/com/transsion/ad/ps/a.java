package com.transsion.ad.ps;

import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.c;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.mmkv.MMKV;
import com.tn.lib.util.device.TNDeviceHelper;
import com.tn.lib.util.networkinfo.f;
import com.transsion.ad.ps.model.PsLinkDto;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import y30.i;
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
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0548a f50553a = C0548a.f50554a;

    /* JADX INFO: renamed from: com.transsion.ad.ps.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0548a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0548a f50554a = new C0548a();

        public final Map<String, Object> a(long j11) {
            String upperCase;
            String string;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String strA = qp.a.f74869a.a("Transsion" + j11);
            linkedHashMap.put("curClientVersionCode", Long.valueOf(b.f50555a.h()));
            linkedHashMap.put("channel", "Transsion");
            linkedHashMap.put("brand", Build.BRAND);
            linkedHashMap.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(j11));
            linkedHashMap.put("sign", strA);
            TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
            linkedHashMap.put("gaid", tNDeviceHelper.h());
            linkedHashMap.put("systemVersionCode", Integer.valueOf(Build.VERSION.SDK_INT));
            linkedHashMap.put("netType", f.f49475a.d());
            linkedHashMap.put("lan", tNDeviceHelper.i());
            MMKV mmkvC = ip.a.f67589a.c();
            String upperCase2 = null;
            if (mmkvC == null || (string = mmkvC.getString("custom_local_iso", "")) == null) {
                upperCase = null;
            } else {
                upperCase = string.toUpperCase(Locale.ROOT);
                Intrinsics.f(upperCase, "toUpperCase(...)");
            }
            if (TextUtils.isEmpty(upperCase)) {
                String strF = tNDeviceHelper.f();
                if (strF != null) {
                    upperCase2 = strF.toUpperCase(Locale.ROOT);
                    Intrinsics.f(upperCase2, "toUpperCase(...)");
                }
                upperCase = upperCase2;
            }
            if (upperCase == null) {
                upperCase = "";
            }
            linkedHashMap.put("countyrCode", upperCase);
            linkedHashMap.put("ua", Build.MODEL);
            linkedHashMap.put("curVersionName", c.f());
            linkedHashMap.put("cpu", tNDeviceHelper.d());
            linkedHashMap.put("android_version", tNDeviceHelper.m());
            linkedHashMap.put("imei", "");
            linkedHashMap.put("imsi", "");
            linkedHashMap.put("sessionID", "");
            linkedHashMap.put("lastPage", "");
            linkedHashMap.put("curPage", "");
            linkedHashMap.put("shareChannel", "");
            linkedHashMap.put(TrackingKey.PLATFORM, "");
            return linkedHashMap;
        }
    }

    @o("/distribute/candidate")
    Object a(@y30.a RequestBody requestBody, @i("multiple_base_url") String str, Continuation<? super PsLinkDto> continuation);
}
