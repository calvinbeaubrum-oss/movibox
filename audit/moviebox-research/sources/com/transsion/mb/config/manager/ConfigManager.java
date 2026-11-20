package com.transsion.mb.config.manager;

import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.n;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.transsion.baselib.report.m;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import yl.f;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class ConfigManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f53111c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<ConfigManager> f53112d = LazyKt__LazyJVMKt.b(new Function0<ConfigManager>() { // from class: com.transsion.mb.config.manager.ConfigManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConfigManager invoke() {
            return new ConfigManager();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, ConfigBean> f53113a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f53114b = new HashSet<>();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ConfigManager a() {
            return (ConfigManager) ConfigManager.f53112d.getValue();
        }
    }

    public static /* synthetic */ ConfigBean c(ConfigManager configManager, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return configManager.b(str, z11);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    public final ConfigBean b(String key, boolean z11) {
        ConfigBean configBean;
        Exception e11;
        ConfigBean configBean2;
        Intrinsics.g(key, "key");
        if (this.f53113a.containsKey(key)) {
            configBean = this.f53113a.get(key);
            if (z11 && configBean != null && configBean.getHasUpdate()) {
                configBean = null;
            }
        } else {
            configBean = null;
        }
        if (configBean == null) {
            String string = ConfigMMKV.f53109a.a().getString(key, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    configBean2 = (ConfigBean) n.d(string, ConfigBean.class);
                    try {
                        this.f53113a.put(key, configBean2);
                    } catch (Exception e12) {
                        e11 = e12;
                        e11.printStackTrace();
                    }
                } catch (Exception e13) {
                    ConfigBean configBean3 = configBean;
                    e11 = e13;
                    configBean2 = configBean3;
                }
                configBean = configBean2;
            }
        }
        String str = key + d();
        if (configBean != null && !this.f53114b.contains(str)) {
            e(configBean);
            this.f53114b.add(str);
        }
        return configBean;
    }

    public final String d() {
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance().getTime());
        Intrinsics.f(str, "formatter.format(currentDate)");
        return str;
    }

    public final void e(ConfigBean configBean) {
        if (TextUtils.isEmpty(configBean.getOps())) {
            return;
        }
        HashMap map = new HashMap();
        map.put("key", configBean.getKey());
        map.put("ops", configBean.getOps());
        map.put("isFirebase", String.valueOf(configBean.isFirebase()));
        m.f51277a.n("config_ab_result", map);
    }

    public final void f(f firebaseRemoteConfig) {
        Intrinsics.g(firebaseRemoteConfig, "firebaseRemoteConfig");
        Set<String> setM = firebaseRemoteConfig.m("");
        Intrinsics.f(setM, "firebaseRemoteConfig.getKeysByPrefix(\"\")");
        for (String str : setM) {
            ConfigBean configBean = new ConfigBean();
            configBean.setKey(str);
            configBean.setValue(firebaseRemoteConfig.o(str));
            configBean.setFirebase(true);
            ConfigMMKV.f53109a.a().putString(str, n.j(configBean));
        }
    }

    public final void g(JsonArray items) {
        Intrinsics.g(items, "items");
        Iterator<JsonElement> it = items.iterator();
        while (it.hasNext()) {
            JsonObject asJsonObject = it.next().getAsJsonObject();
            Intrinsics.f(asJsonObject, "it.getAsJsonObject()");
            String asString = asJsonObject.get("key").getAsString();
            ConfigMMKV configMMKV = ConfigMMKV.f53109a;
            String string = configMMKV.a().getString(asString, null);
            if (string == null || string.length() == 0 || !StringsKt__StringsKt.Q(string, "\"isFirebase\":true", false, 2, null)) {
                configMMKV.a().putString(asString, asJsonObject.toString());
            }
            if (Intrinsics.b(asString, "ad_scene_config")) {
                Log.w("co_non", "ConfigManager --> updateConfig --> ad_scene_config = " + asJsonObject);
            }
            if (Intrinsics.b(asString, "business_guide_config")) {
                Log.w("co_non", "ConfigManager --> updateConfig --> business_guide_config = " + asJsonObject);
            }
        }
        Iterator<Map.Entry<String, ConfigBean>> it2 = this.f53113a.entrySet().iterator();
        while (it2.hasNext()) {
            ConfigBean value = it2.next().getValue();
            if (value != null) {
                value.setHasUpdate(true);
            }
        }
    }
}
