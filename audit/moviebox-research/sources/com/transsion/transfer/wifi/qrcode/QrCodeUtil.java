package com.transsion.transfer.wifi.qrcode;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.google.logging.type.LogSeverity;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.transfer.wifi.util.e;
import com.transsion.transfer.wifi.util.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class QrCodeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final QrCodeUtil f59192a = new QrCodeUtil();

    public static /* synthetic */ Object g(QrCodeUtil qrCodeUtil, String str, int i11, int i12, Continuation continuation, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = LogSeverity.WARNING_VALUE;
        }
        if ((i13 & 4) != 0) {
            i12 = LogSeverity.WARNING_VALUE;
        }
        return qrCodeUtil.f(str, i11, i12, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:70:0x01a5 A[PHI: r6
  0x01a5: PHI (r6v21 qy.a) = 
  (r6v3 qy.a)
  (r6v4 qy.a)
  (r6v5 qy.a)
  (r6v6 qy.a)
  (r6v7 qy.a)
  (r6v8 qy.a)
  (r6v9 qy.a)
  (r6v10 qy.a)
  (r6v11 qy.a)
  (r6v12 qy.a)
  (r6v13 qy.a)
  (r6v14 qy.a)
  (r6v15 qy.a)
  (r6v16 qy.a)
  (r6v17 qy.a)
  (r6v22 qy.a)
 binds: [B:69:0x01a3, B:65:0x018e, B:61:0x0179, B:57:0x0163, B:53:0x014d, B:49:0x0136, B:45:0x011f, B:41:0x0108, B:37:0x00f1, B:33:0x00da, B:29:0x00c3, B:25:0x00ac, B:21:0x0095, B:17:0x007e, B:13:0x0067, B:7:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Instruction removed from duplicated block: B:70:0x01a5, please report this as an issue */
    public final qy.a a(Map<String, String> map) {
        qy.a aVar;
        qy.a aVar2 = aVar;
        qy.a aVar3 = new qy.a(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 131071, null);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            switch (key.hashCode()) {
                case -1627415939:
                    aVar = aVar2;
                    if (key.equals("mb_wifi_pwd")) {
                        aVar.G(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case -1086077885:
                    aVar = aVar2;
                    if (key.equals("mb_wifi_channel")) {
                        aVar.E(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case -1080938842:
                    aVar = aVar2;
                    if (key.equals("mb_uid")) {
                        aVar.z(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case -72536842:
                    aVar = aVar2;
                    if (key.equals("mb_version_release")) {
                        aVar.C(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case 103677969:
                    aVar = aVar2;
                    if (key.equals("mb_ip")) {
                        aVar.F(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case 103678184:
                    aVar = aVar2;
                    if (key.equals("mb_pn")) {
                        aVar.v(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case 103678359:
                    aVar = aVar2;
                    if (key.equals("mb_vc")) {
                        aVar.A(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case 103678370:
                    aVar = aVar2;
                    if (key.equals("mb_vn")) {
                        aVar.B(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case 426966230:
                    aVar = aVar2;
                    if (key.equals("mb_avatar_index")) {
                        aVar.r(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case 582580317:
                    aVar = aVar2;
                    if (key.equals("mb_brand")) {
                        aVar.s(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case 785242969:
                    aVar = aVar2;
                    if (key.equals("mb_version_sdk_int")) {
                        aVar.D(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case 925994048:
                    aVar = aVar2;
                    if (key.equals("mb_device")) {
                        aVar.u(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case 1066736709:
                    aVar = aVar2;
                    if (key.equals("mb_product")) {
                        aVar.w(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case 1089799227:
                    aVar = aVar2;
                    if (key.equals("mb_wifi_ssid")) {
                        aVar.H(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case 1420622267:
                    aVar = aVar2;
                    if (key.equals("mb_unique")) {
                        aVar.y(entry.getValue());
                    } else {
                        g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    }
                    break;
                case 2115161177:
                    if (key.equals("mb_channel")) {
                        aVar = aVar2;
                        aVar.t(entry.getValue());
                        break;
                    }
                default:
                    aVar = aVar2;
                    g.b(g.f59252a, f59192a.c() + " --> analysis() --> 没有匹配上 --> key = " + ((Object) entry.getKey()) + " --> value = " + ((Object) entry.getValue()), false, 2, null);
                    break;
            }
            aVar2 = aVar;
        }
        qy.a aVar4 = aVar2;
        g.b(g.f59252a, c() + " --> analysis() --> wifiInfoModel = " + aVar4, false, 2, null);
        return aVar4;
    }

    public final String b(qy.a aVar) {
        g gVar = g.f59252a;
        g.b(gVar, c() + " --> createTransferQrStr() --> wifiInfoModel = " + aVar, false, 2, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(d());
        sb2.append("mb_unique");
        sb2.append("=");
        sb2.append("mb_unique");
        sb2.append("&");
        sb2.append("mb_device");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.e() : null);
        sb2.append("&");
        sb2.append("mb_brand");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.c() : null);
        sb2.append("&");
        sb2.append("mb_product");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.g() : null);
        sb2.append("&");
        sb2.append("mb_version_release");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.k() : null);
        sb2.append("&");
        sb2.append("mb_version_sdk_int");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.l() : null);
        sb2.append("&");
        sb2.append("mb_vc");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.i() : null);
        sb2.append("&");
        sb2.append("mb_vn");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.j() : null);
        sb2.append("&");
        sb2.append("mb_pn");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.f() : null);
        sb2.append("&");
        sb2.append("mb_uid");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.h() : null);
        sb2.append("&");
        sb2.append("mb_avatar_index");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.b() : null);
        sb2.append("&");
        sb2.append("mb_channel");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.d() : null);
        sb2.append("&");
        sb2.append("mb_wifi_ssid");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.p() : null);
        sb2.append("&");
        sb2.append("mb_wifi_pwd");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.o() : null);
        sb2.append("&");
        sb2.append("mb_wifi_channel");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.m() : null);
        sb2.append("&");
        sb2.append("mb_ip");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.n() : null);
        String string = sb2.toString();
        Intrinsics.f(string, "builder.toString()");
        g.b(gVar, c() + " --> createTransferQrStr() --> 二维码创建完成 --> qrCode = " + string, false, 2, null);
        return string;
    }

    public final String c() {
        String simpleName = QrCodeUtil.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final String d() {
        Object objM163constructorimpl;
        String value;
        try {
            Result.Companion companion = Result.Companion;
            ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "transfer_share_link_url", false, 2, null);
            if (configBeanC == null || (value = configBeanC.getValue()) == null) {
                value = "https://h5.aoneroom.com/download?type=/transfer/wifi_connect&";
            }
            objM163constructorimpl = Result.m163constructorimpl(value);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        return (String) (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null ? objM163constructorimpl : "https://h5.aoneroom.com/download?type=/transfer/wifi_connect&");
    }

    public final void e(String text, Function1<? super qy.a, Unit> function1) {
        Intrinsics.g(text, "text");
        Map<String, String> mapA = e.f59248a.a(text);
        if (mapA.isEmpty()) {
            if (function1 != null) {
                function1.invoke(null);
            }
        } else if (!TextUtils.equals(mapA.get("mb_unique"), "mb_unique")) {
            if (function1 != null) {
                function1.invoke(null);
            }
        } else {
            qy.a aVarA = a(mapA);
            if (function1 != null) {
                function1.invoke(aVarA);
            }
        }
    }

    public final Object f(String str, int i11, int i12, Continuation<? super Bitmap> continuation) {
        return h.g(w0.b(), new QrCodeUtil$syncEncodeQRCode$2(str, i11, i12, null), continuation);
    }
}
