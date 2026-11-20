package com.mbridge.msdk.newreward.function.g;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.newreward.function.c.e;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f46489a;

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.function.g.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46490a;

        static {
            int[] iArr = new int[e.values().length];
            f46490a = iArr;
            try {
                iArr[e.REQ_SETTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46490a[e.REQ_CAMPAIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private b() {
    }

    public static b a() {
        if (f46489a == null) {
            synchronized (b.class) {
                try {
                    if (f46489a == null) {
                        f46489a = new b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f46489a;
    }

    public final <T extends a> a a(Object obj, e eVar) {
        int i11 = AnonymousClass1.f46490a[eVar.ordinal()];
        if (i11 == 1) {
            c cVar = new c();
            com.mbridge.msdk.newreward.function.c.b bVar = (com.mbridge.msdk.newreward.function.c.b) obj;
            if (!(bVar.b() instanceof Map)) {
                return cVar;
            }
            Map map = (Map) bVar.b();
            cVar.a(((Integer) map.get("mb_ad_type")).intValue());
            cVar.a((String) map.get("mb_ad_unit_id"));
            return cVar;
        }
        if (i11 != 2) {
            return null;
        }
        Map map2 = (Map) obj;
        com.mbridge.msdk.newreward.a.e eVar2 = (com.mbridge.msdk.newreward.a.e) map2.get("adapter_model");
        MBridgeOffsetManager mBridgeOffsetManager = (MBridgeOffsetManager) ((com.mbridge.msdk.newreward.function.c.c) map2.get("command_manager")).a((Object) null, e.CREATE_OFFSET);
        if (mBridgeOffsetManager == null) {
            eVar2.a(0);
        } else {
            eVar2.a(mBridgeOffsetManager.getOffset());
        }
        d dVar = new d(eVar2.n(), eVar2.u(), eVar2.y(), !TextUtils.isEmpty(eVar2.A()), eVar2.A());
        dVar.a(eVar2.C());
        dVar.e(eVar2.x());
        dVar.c(eVar2.D());
        dVar.b(eVar2.E());
        dVar.a(eVar2.c());
        if (com.mbridge.msdk.f.b.a()) {
            eVar2.y();
            com.mbridge.msdk.foundation.controller.c.m().c();
            TextUtils.isEmpty("");
            dVar.c("");
        }
        String strA = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), eVar2.y());
        if (TextUtils.isEmpty(strA)) {
            strA = "";
        }
        dVar.a(strA);
        dVar.b("");
        dVar.d(TextUtils.isEmpty(MBridgeGlobalCommon.SESSION_ID) ? "" : MBridgeGlobalCommon.SESSION_ID);
        return dVar;
    }
}
