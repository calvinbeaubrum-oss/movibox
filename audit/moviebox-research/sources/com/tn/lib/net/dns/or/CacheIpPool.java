package com.tn.lib.net.dns.or;

import android.text.TextUtils;
import com.blankj.utilcode.util.n;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wo.a;
import wo.c;

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
@SourceDebugExtension
public final class CacheIpPool {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ArrayList<AddressItem> f49385b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CacheIpPool f49384a = new CacheIpPool();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, AddressItem> f49386c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f49387d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile String f49388e = "api6.aoneroom.com";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile String f49389f = "https";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f49390g = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.tn.lib.net.dns.or.CacheIpPool$defaultRelease$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "[\n{\n\"host\": \"" + CacheIpPool.f49388e + "\",\n\"ip\": \"\",\n\"scheme\": \"https\"\n}\n]";
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f49391h = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.tn.lib.net.dns.or.CacheIpPool$defaultTest$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "[{\n    \"host\": \"test-mse-api.aoneroom.com\",\n    \"ip\": \"8.219.92.106\",\n    \"scheme\": \"https\"\n}]";
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f49392i = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.tn.lib.net.dns.or.CacheIpPool$defaultBaseUrl$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            if (a.f79569a.d()) {
                return "https://test-mse-api.aoneroom.com";
            }
            return AgentPageJsBridge.HTTPS + CacheIpPool.f49388e;
        }
    });

    public final String b() {
        if (TextUtils.isEmpty(f49387d)) {
            f49387d = d();
        }
        return f49387d;
    }

    public final void c() {
        String str;
        AddressItem addressItem;
        AddressItem addressItem2;
        try {
            ArrayList<AddressItem> arrayList = (ArrayList) n.e(c.f79578a.a("key_ip_list", a.f79569a.d() ? f() : e()), new TypeToken<ArrayList<AddressItem>>() { // from class: com.tn.lib.net.dns.or.CacheIpPool$getCacheUrlList$type$1
            }.getType());
            f49385b = arrayList;
            if (arrayList != null) {
                for (AddressItem addressItem3 : arrayList) {
                    String host = addressItem3.getHost();
                    if (host != null && host.length() > 0) {
                        addressItem3.setIpEnable(true);
                        f49386c.put(addressItem3.getHost(), addressItem3);
                    }
                }
            }
            ArrayList<AddressItem> arrayList2 = f49385b;
            if (arrayList2 == null || !(!arrayList2.isEmpty())) {
                str = f49387d;
            } else {
                ArrayList<AddressItem> arrayList3 = f49385b;
                String host2 = null;
                f49389f = String.valueOf((arrayList3 == null || (addressItem2 = arrayList3.get(0)) == null) ? null : addressItem2.getScheme());
                ArrayList<AddressItem> arrayList4 = f49385b;
                if (arrayList4 != null && (addressItem = arrayList4.get(0)) != null) {
                    host2 = addressItem.getHost();
                }
                f49388e = String.valueOf(host2);
                str = f49389f + "://" + f49388e;
            }
            f49387d = str;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final String d() {
        return (String) f49392i.getValue();
    }

    public final String e() {
        return (String) f49390g.getValue();
    }

    public final String f() {
        return (String) f49391h.getValue();
    }

    public final String g() {
        MMKV mmkvC = ip.a.f67589a.c();
        String string = mmkvC != null ? mmkvC.getString("mock_host_key", "") : null;
        if (!TextUtils.isEmpty(string)) {
            f49388e = String.valueOf(string);
        }
        return f49388e;
    }

    public final String h() {
        return f49389f;
    }

    public final void i(String str) {
        if (!TextUtils.isEmpty(str)) {
            c.f79578a.b("key_ip_list", String.valueOf(str));
        }
        c();
    }

    public final void j(String host) {
        Intrinsics.g(host, "host");
        f49388e = host;
    }
}
