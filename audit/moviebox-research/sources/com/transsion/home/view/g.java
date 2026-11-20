package com.transsion.home.view;

import com.applovin.sdk.AppLovinEventTypes;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.m;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import java.util.HashMap;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f52731b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f52730a = new g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f52732c = 8;

    public static /* synthetic */ void d(g gVar, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        gVar.c(z11);
    }

    public final boolean a() {
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("sa_search_guide", true);
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "SearchGuideDialogManager", "search_guide config: " + configBeanB + ", " + (configBeanB != null ? configBeanB.getValue() : null) + "}", false, 4, null);
        String value = configBeanB != null ? configBeanB.getValue() : null;
        if (value != null && value.length() != 0) {
            if (!Intrinsics.b(configBeanB != null ? configBeanB.getValue() : null, "false")) {
                if (RoomAppMMKV.f51271a.a().getBoolean("search_guide", false)) {
                    uo.b.a.o(aVar, "SearchGuideDialogManager", new String[]{"RoomAppMMKV SEARCH_GUIDE has clicked"}, false, 4, null);
                    return false;
                }
                if (f52731b) {
                    uo.b.a.o(aVar, "SearchGuideDialogManager", new String[]{"markHasClicked"}, false, 4, null);
                    return false;
                }
                if (!SearchGuideDialog.f52680g.a()) {
                    return true;
                }
                uo.b.a.o(aVar, "SearchGuideDialogManager", new String[]{"SearchGuideDialog has shown"}, false, 4, null);
                return false;
            }
        }
        uo.b.a.o(aVar, "SearchGuideDialogManager", new String[]{"search_guide config is false"}, false, 4, null);
        return false;
    }

    public final boolean b() {
        return f52731b;
    }

    public final void c(boolean z11) {
        RoomAppMMKV.f51271a.a().putBoolean("search_guide", true);
        if (z11) {
            e();
        }
    }

    public final void e() {
        HashMap map = new HashMap();
        map.put("click", AppLovinEventTypes.USER_EXECUTED_SEARCH);
        m.f51277a.m("guide", "click", map);
    }

    public final void f() {
        f52731b = false;
    }

    public final void g(boolean z11) {
        f52731b = z11;
    }
}
