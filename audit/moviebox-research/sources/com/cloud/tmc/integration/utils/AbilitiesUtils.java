package com.cloud.tmc.integration.utils;

import android.content.Context;
import com.cloud.tmc.integration.model.AbilityConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class AbilitiesUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbilitiesUtils f30983a = new AbilitiesUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f30984b = kotlin.collections.g.q("1000391591855976448", "1000550440273772544");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f30985c = "[{\n\t\"miniappId\": \"1000886706715795456\",\n\t\"miniappName\": \"小程序中心\",\n\t\"abilities\": [{\n\t\t\"ability\": \"title_bar_add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"title_bar_add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_home\",\n\t\t\"enable\": true\n\t}, {\n\t\t\"ability\": \"latest_use\",\n\t\t\"enable\": true\n\t}, {\n\t\t\"ability\": \"title_bar_share\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"shareGroup\",\n\t\t\"enable\": false\n\t}]\n}, {\n\t\"miniappId\": \"1000083312531542016\",\n\t\"miniappName\": \"记事本\",\n\t\"abilities\": [{\n\t\t\"ability\": \"title_bar_add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"title_bar_add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"latest_use\",\n\t\t\"enable\": false\n\t}]\n}, {\n\t\"miniappId\": \"1000391591855976448\",\n\t\"miniappName\": \"MiniApp Setting\",\n\t\"abilities\": [{\n\t\t\"ability\": \"title_bar_add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"title_bar_add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"latest_use\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"feedback\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"permission\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"share_url\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"share_friends\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"title_bar_share\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"shareGroup\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"message\",\n\t\t\"enable\": false\n\t}]\n}, {\n\t\"miniappId\": \"1000497027976413184\",\n\t\"miniappName\": \"SharpNews\",\n\t\"abilities\": [{\n\t\t\"ability\": \"refresh\",\n\t\t\"enable\": false\n\t}]\n},{\n\t\"miniappId\": \"1000550440273772544\",\n\t\"miniappName\": \"反馈小程序\",\n\t\"abilities\": [{\n\t\t\"ability\": \"title_bar_add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"title_bar_add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"latest_use\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"feedback\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"permission\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"share_url\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"share_friends\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"title_bar_share\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"shareGroup\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"message\",\n\t\t\"enable\": false\n\t}]\n}]";

    public final ArrayList<AbilityConfig> a() {
        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(c(), "miniSdkAbilities", "ability_config");
        if (string == null) {
            string = f30985c;
        }
        Intrinsics.f(string, "TmcProxy.get(KVStoragePr…         ?: defaultConfig");
        try {
            Object objE = com.cloud.tmc.miniutils.util.k.e(string, new TypeToken<ArrayList<AbilityConfig>>() { // from class: com.cloud.tmc.integration.utils.AbilitiesUtils$getAbilitiesConfig$1
            }.getType());
            Intrinsics.f(objE, "{\n            GsonUtils.…e\n            )\n        }");
            return (ArrayList) objE;
        } catch (Exception e11) {
            TmcLogger.h("Failed to parse menu config", e11);
            return new ArrayList<>();
        }
    }

    public final boolean b(String appId, String ability) {
        Object obj;
        Object next;
        ArrayList<AbilityConfig.Ability> abilities;
        Boolean enable;
        Intrinsics.g(appId, "appId");
        Intrinsics.g(ability, "ability");
        ArrayList<AbilityConfig> arrayListA = a();
        if (arrayListA.isEmpty() && Intrinsics.b(ability, "latest_use")) {
            return !f30984b.contains(appId);
        }
        Iterator<T> it = arrayListA.iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((AbilityConfig) next).getMiniappId(), appId));
        AbilityConfig abilityConfig = (AbilityConfig) next;
        if (abilityConfig == null || (abilities = abilityConfig.getAbilities()) == null) {
            return true;
        }
        for (Object obj2 : abilities) {
            if (Intrinsics.b(((AbilityConfig.Ability) obj2).getAbility(), ability)) {
                obj = obj2;
                break;
            }
        }
        AbilityConfig.Ability ability2 = (AbilityConfig.Ability) obj;
        if (ability2 == null || (enable = ability2.getEnable()) == null) {
            return true;
        }
        return enable.booleanValue();
    }

    public final Context c() {
        Context applicationContext = ((IApplicationContextGetter) tc.a.a(IApplicationContextGetter.class)).getApplicationContext();
        Intrinsics.f(applicationContext, "get(IApplicationContextG….java).applicationContext");
        return applicationContext;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0023  */
    public final boolean d() {
        boolean z11;
        long jE = e();
        long jCurrentTimeMillis = System.currentTimeMillis() - jE;
        if (jE <= 0) {
            z11 = true;
        } else {
            if (jCurrentTimeMillis > (AppDynamicBuildConfig.v() ? 120000L : 604800000L)) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        if (!z11) {
            long jB = com.cloud.tmc.miniutils.util.c0.b();
            TmcLogger.c("AbilitiesUtils", "It has only been " + com.cloud.tmc.miniutils.util.c0.a(jB, jB - jCurrentTimeMillis, 5) + " since the last update or check, which does not meet the 7 days update policy");
        }
        return z11;
    }

    public final long e() {
        return ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(c(), "miniSdkAbilities", "ability_config_update_date_v3");
    }

    public final void f(String data) {
        Intrinsics.g(data, "data");
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(c(), "miniSdkAbilities", "ability_config", data);
        h();
        g(data);
    }

    public final void g(String str) {
        try {
            Object objE = com.cloud.tmc.miniutils.util.k.e(str, new TypeToken<ArrayList<AbilityConfig>>() { // from class: com.cloud.tmc.integration.utils.AbilitiesUtils$updateMMKVConfig$abilitiesConfigList$1
            }.getType());
            Intrinsics.f(objE, "fromJson(data, object : …bilityConfig>>() {}.type)");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (AbilityConfig abilityConfig : (ArrayList) objE) {
                ArrayList<AbilityConfig.Ability> abilities = abilityConfig.getAbilities();
                if (abilities != null) {
                    for (AbilityConfig.Ability ability : abilities) {
                        if (Intrinsics.b(ability.getAbility(), "add_favorites") && Intrinsics.b(ability.getEnable(), Boolean.FALSE)) {
                            arrayList.add(abilityConfig.getMiniappId());
                        } else if (Intrinsics.b(ability.getAbility(), "latest_use") && Intrinsics.b(ability.getEnable(), Boolean.FALSE)) {
                            arrayList2.add(abilityConfig.getMiniappId());
                        }
                    }
                }
            }
            LatestUseUtils.e(arrayList2);
        } catch (Throwable th2) {
            TmcLogger.h("updateMMKVConfig failed!", th2);
        }
    }

    public final void h() {
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(c(), "miniSdkAbilities", "ability_config_update_date_v3", System.currentTimeMillis());
    }
}
