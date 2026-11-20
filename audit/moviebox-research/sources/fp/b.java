package fp;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mmkv.MMKV;
import com.tn.lib.util.device.TNDeviceHelper;
import com.tn.lib.util.networkinfo.f;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f65208a = new a(0 == true ? 1 : 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f65209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f65210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f65211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Boolean f65212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f65213f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Bundle bundle) {
            Intrinsics.g(bundle, "bundle");
            bundle.putString("session_id", h());
            bundle.putString("device_id", TNDeviceHelper.f49455a.g());
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            bundle.putString("install_store", e(applicationA));
            ip.a.C0714a c0714a = ip.a.f67589a;
            String strA = c0714a.a();
            if (!TextUtils.isEmpty(strA)) {
                bundle.putString("install_ch", strA);
            }
            String strB = c0714a.b();
            if (!TextUtils.isEmpty(strB)) {
                bundle.putString("install_id", strB);
            }
            String strD = c0714a.d();
            if (!TextUtils.isEmpty(strD)) {
                bundle.putString("install_share_uid", strD);
            }
            bundle.putString("net_state", String.valueOf(f.f49475a.b()));
        }

        public final void b(String key, String value) {
            Intrinsics.g(key, "key");
            Intrinsics.g(value, "value");
            b.f65210c.put(key, value);
        }

        public final String c() {
            String strC;
            String string;
            wo.b bVarB = wo.a.f79569a.b();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                String strC2 = com.blankj.utilcode.util.c.c();
                Intrinsics.f(strC2, "getAppPackageName()");
                linkedHashMap.put("package_name", strC2);
                String strB = bVarB != null ? bVarB.b() : null;
                String strN = "";
                if (!TextUtils.isEmpty(strB)) {
                    if (strB == null) {
                        strB = "";
                    }
                    linkedHashMap.put("version_name", strB);
                }
                int iD = com.blankj.utilcode.util.c.d();
                if (iD > 0) {
                    linkedHashMap.put("version_code", Integer.valueOf(iD));
                }
                linkedHashMap.put("os", "android");
                TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
                linkedHashMap.put("os_version", tNDeviceHelper.m());
                ip.a.C0714a c0714a = ip.a.f67589a;
                if (!TextUtils.isEmpty(c0714a.a())) {
                    linkedHashMap.put("install_ch", c0714a.a());
                }
                linkedHashMap.put("device_id", tNDeviceHelper.g());
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                linkedHashMap.put("install_store", String.valueOf(e(applicationA)));
                String strH = tNDeviceHelper.h();
                if (!TextUtils.isEmpty(strH)) {
                    linkedHashMap.put("gaid", strH);
                }
                MMKV mmkvC = c0714a.c();
                if (mmkvC == null || (strC = mmkvC.getString("phone_brand", "")) == null) {
                    strC = "";
                }
                if (TextUtils.isEmpty(strC)) {
                    strC = tNDeviceHelper.c();
                }
                if (!TextUtils.isEmpty(strC)) {
                    linkedHashMap.put("brand", strC);
                }
                linkedHashMap.put("model", tNDeviceHelper.k());
                String strG = g();
                if (strG == null) {
                    strG = Locale.getDefault().getLanguage();
                }
                Intrinsics.f(strG, "localLanguage ?: Locale.getDefault().language");
                linkedHashMap.put("system_language", strG);
                linkedHashMap.put("net", f.f49475a.d());
                String country = Locale.getDefault().getCountry();
                Intrinsics.f(country, "getDefault().country");
                linkedHashMap.put(TtmlNode.TAG_REGION, country);
                String id2 = TimeZone.getDefault().getID();
                Intrinsics.f(id2, "getDefault().id");
                linkedHashMap.put("timezone", id2);
                MMKV mmkvC2 = c0714a.c();
                if (mmkvC2 != null && (string = mmkvC2.getString("sp_code", "")) != null) {
                    strN = string;
                }
                if (TextUtils.isEmpty(strN)) {
                    strN = tNDeviceHelper.n();
                }
                linkedHashMap.put("sp_code", strN);
                if (!b.f65210c.isEmpty()) {
                    linkedHashMap.putAll(b.f65210c);
                }
                String jSONString = com.alibaba.fastjson.a.toJSONString(linkedHashMap);
                Intrinsics.f(jSONString, "toJSONString(headMap)");
                return jSONString;
            } catch (Exception unused) {
                String jSONString2 = com.alibaba.fastjson.a.toJSONString(linkedHashMap, SerializerFeature.BrowserCompatible);
                Intrinsics.f(jSONString2, "toJSONString(headMap, Se…eature.BrowserCompatible)");
                return jSONString2;
            }
        }

        public final Boolean d() {
            return b.f65212e;
        }

        public final String e(Context context) {
            Intrinsics.g(context, "context");
            MMKV mmkvC = ip.a.f67589a.c();
            String string = mmkvC != null ? mmkvC.getString("install_store", "") : null;
            if (TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(b.f65213f)) {
                    String strB = yn.f.b(context);
                    if (TextUtils.isEmpty(strB)) {
                        strB = "gp";
                    }
                    b.f65213f = strB;
                }
                string = b.f65213f;
            }
            b.f65213f = string;
            return b.f65213f;
        }

        public final Map<String, String> f() {
            return b.f65210c;
        }

        public final String g() {
            return b.f65211d;
        }

        public final String h() {
            return b.f65209b;
        }

        public final void i(Boolean bool) {
            b.f65212e = bool;
        }

        public final void j(String channel) {
            Intrinsics.g(channel, "channel");
            MMKV mmkvC = ip.a.f67589a.c();
            if (mmkvC != null) {
                mmkvC.putString("install_store", channel);
            }
        }

        public final void k(String str) {
            b.f65211d = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String string = UUID.randomUUID().toString();
        Intrinsics.f(string, "randomUUID().toString()");
        f65209b = string;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f65210c = linkedHashMap;
        f65212e = Boolean.TRUE;
        MMKV mmkvC = ip.a.f67589a.c();
        String string2 = mmkvC != null ? mmkvC.getString("x-md-global-color", "") : null;
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        linkedHashMap.put("x-md-global-color", String.valueOf(string2));
    }
}
