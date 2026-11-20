package com.mbridge.msdk.newreward.function.c.a;

import com.mbridge.msdk.newreward.function.c.b.a.g;
import com.mbridge.msdk.newreward.function.c.b.a.i;
import com.mbridge.msdk.newreward.function.c.b.c;
import com.mbridge.msdk.newreward.function.c.d;
import com.mbridge.msdk.newreward.function.c.e;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.mbridge.msdk.newreward.function.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f46165a = new HashMap();

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.function.c.a.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46166a;

        static {
            int[] iArr = new int[e.values().length];
            f46166a = iArr;
            try {
                iArr[e.CHECK_IS_READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46166a[e.CHECK_CAMPAIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46166a[e.HANDLER_ALREADY_INSTALL_CAMPAIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46166a[e.CREATE_OFFSET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46166a[e.CREATE_DAILY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46166a[e.CREATE_BIDS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f46166a[e.SHOW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f46166a[e.CHECK_IS_REQUEST_CONTROL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f46166a[e.UPDATE_CAM_TOKEN_RULE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f46166a[e.START_LOAD_CHECK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f46166a[e.CANDIDATE_LOAD_ACTION.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f46166a[e.REQ_SETTING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f46166a[e.REQ_CAMPAIGN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f46166a[e.REQ_DOWN_CAMPAIGN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f46166a[e.RESTORE_DB.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f46166a[e.SMART_LOAD.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f46166a[e.NORMAL_LOAD.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f46166a[e.PRE_HANDLE_LOAD.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f46166a[e.UNIT_INIT.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    private void a(com.mbridge.msdk.newreward.function.c.b bVar, d dVar, String str) {
        if (bVar == null) {
            return;
        }
        com.mbridge.msdk.newreward.function.c.b.a.b bVar2 = new com.mbridge.msdk.newreward.function.c.b.a.b();
        Map map = (Map) bVar.b();
        if (map == null) {
            map = new HashMap();
        }
        map.put("obj_map", this.f46165a);
        map.put("result", dVar);
        map.put("type", str);
        bVar2.a(map);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.mbridge.msdk.newreward.function.c.a
    public final d a(com.mbridge.msdk.newreward.function.c.b bVar) {
        d dVar = new d();
        switch (AnonymousClass1.f46166a[bVar.a().ordinal()]) {
            case 1:
                dVar.a(((com.mbridge.msdk.newreward.a.e) bVar.b()).v().c());
                return dVar;
            case 2:
                Map map = (Map) bVar.b();
                com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
                try {
                    eVar.v().b((com.mbridge.msdk.newreward.function.d.a.b) map.get("campaign"));
                    dVar.a(true);
                    break;
                } catch (MBridgeError e11) {
                    dVar.a(false);
                    dVar.a(e11);
                }
                return dVar;
            case 3:
                Map map2 = (Map) bVar.b();
                com.mbridge.msdk.newreward.a.e eVar2 = (com.mbridge.msdk.newreward.a.e) map2.get("adapter_model");
                eVar2.v().c((com.mbridge.msdk.newreward.function.d.a.b) map2.get("campaign"));
                return dVar;
            case 4:
                a(bVar, dVar, "offset");
                return dVar;
            case 5:
                a(bVar, dVar, "daily");
                return dVar;
            case 6:
                a(bVar, dVar, "bridge_ids");
                return dVar;
            case 7:
                new i().a(bVar);
                return dVar;
            case 8:
                g gVar = (g) c.a().b(e.CHECK_IS_REQUEST_CONTROL);
                if (gVar != null) {
                    try {
                        dVar.a(gVar.a(bVar.b()));
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                    break;
                }
                return dVar;
            case 9:
                c.a().b(e.UPDATE_CAM_TOKEN_RULE);
                return dVar;
            case 10:
                ((com.mbridge.msdk.newreward.function.c.b.a.c) c.a().b(e.START_LOAD_CHECK)).a(bVar.b());
                return dVar;
            case 11:
                dVar.a(((com.mbridge.msdk.newreward.function.c.b.a.a) c.a().b(e.CANDIDATE_LOAD_ACTION)).a(bVar.b()));
                return dVar;
            default:
                return dVar;
        }
    }

    @Override // com.mbridge.msdk.newreward.function.c.a
    public final void a(com.mbridge.msdk.newreward.function.c.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        com.mbridge.msdk.newreward.a.e eVar = bVar.b() instanceof com.mbridge.msdk.newreward.a.e ? (com.mbridge.msdk.newreward.a.e) bVar.b() : null;
        switch (AnonymousClass1.f46166a[bVar.a().ordinal()]) {
            case 12:
                if (eVar != null) {
                    eVar.p().a(com.mbridge.msdk.newreward.function.g.b.a().a(bVar, bVar.a()), bVar2);
                } else {
                    new com.mbridge.msdk.newreward.function.f.e().a(com.mbridge.msdk.newreward.function.g.b.a().a(bVar, bVar.a()), bVar2);
                }
                break;
            case 13:
                com.mbridge.msdk.newreward.a.e eVar2 = (com.mbridge.msdk.newreward.a.e) ((Map) bVar.b()).get("adapter_model");
                eVar2.v().a(eVar2, com.mbridge.msdk.newreward.function.g.b.a().a(bVar.b(), bVar.a()), bVar2);
                break;
            case 14:
                Map<? extends String, ? extends Object> map = (Map) bVar.b();
                com.mbridge.msdk.newreward.a.e eVar3 = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
                com.mbridge.msdk.newreward.function.d.a.b bVar3 = (com.mbridge.msdk.newreward.function.d.a.b) map.get("campaign");
                bVar3.F().putAll(map);
                eVar3.w().a(bVar3, bVar2);
                break;
            case 15:
                c.a().a(e.RESTORE_DB).a(bVar, bVar2);
                break;
            case 16:
                bVar.b();
                c.a().a(e.SMART_LOAD).a(bVar, bVar2);
                break;
            case 17:
                com.mbridge.msdk.newreward.function.c.b.a.d dVar = (com.mbridge.msdk.newreward.function.c.b.a.d) c.a().a(e.NORMAL_LOAD);
                dVar.a(this);
                dVar.a(bVar, bVar2);
                break;
            case 18:
                c.a().a(e.PRE_HANDLE_LOAD).a(bVar, bVar2);
                break;
            case 19:
                c.a().a(e.UNIT_INIT).a(bVar, bVar2);
                break;
        }
    }
}
