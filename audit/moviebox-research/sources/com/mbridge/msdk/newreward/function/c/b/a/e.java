package com.mbridge.msdk.newreward.function.c.b.a;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements com.mbridge.msdk.newreward.function.c.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.mbridge.msdk.newreward.a.e f46186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.mbridge.msdk.newreward.function.c.c f46187b;

    @Override // com.mbridge.msdk.newreward.function.c.b.a
    public final void a(com.mbridge.msdk.newreward.function.c.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        com.mbridge.msdk.newreward.function.f.e eVarP;
        com.mbridge.msdk.videocommon.d.c cVarB;
        Queue<Integer> queueB;
        Integer numPoll;
        try {
            Map map = (Map) bVar.b();
            this.f46186a = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
            this.f46187b = (com.mbridge.msdk.newreward.function.c.c) map.get("command_manager");
            try {
                Map<String, Long> map2 = com.mbridge.msdk.foundation.same.a.d.f44407k;
                if (map2 != null && map2.size() > 0) {
                    com.mbridge.msdk.foundation.same.a.d.f44407k.clear();
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
            try {
                com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(this.f46186a.y());
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    e12.printStackTrace();
                }
            }
            try {
                com.mbridge.msdk.newreward.a.e eVar = this.f46186a;
                if (eVar.s() == 2 && TextUtils.isEmpty(eVar.A())) {
                    com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880035, "errorCode: 3507 errorMessage: data load failed, errorMsg is bidToken null");
                    throw new MBridgeError(bVarB.a(), bVarB.b());
                }
                if (com.mbridge.msdk.system.a.map == null) {
                    com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is not init sdk");
                    throw new MBridgeError(bVarB2.a(), bVarB2.b());
                }
                if (((MBridgeDailyPlayModel) this.f46187b.a(new HashMap(), com.mbridge.msdk.newreward.function.c.e.CREATE_DAILY)).isOverDailyCap()) {
                    bVar2.a(new com.mbridge.msdk.foundation.c.b(880019));
                    return;
                }
                com.mbridge.msdk.newreward.a.e eVar2 = this.f46186a;
                eVar2.e((eVar2 == null || (eVarP = eVar2.p()) == null || (cVarB = eVarP.b()) == null || (queueB = cVarB.B()) == null || queueB.size() == 0 || (numPoll = queueB.poll()) == null) ? 25000 : numPoll.intValue() * 1000);
                bVar2.a((Object) null);
            } catch (MBridgeError e13) {
                bVar2.a(new com.mbridge.msdk.foundation.c.b(e13.getErrorCode(), e13.getErrorMessage()));
            }
        } catch (Exception e14) {
            bVar2.a(new com.mbridge.msdk.foundation.c.b(880020, e14.getMessage()));
        }
    }
}
