package com.mbridge.msdk.foundation.same.net.h;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.same.net.m;
import com.mbridge.msdk.foundation.same.net.n;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.out.CustomInfoManager;
import com.mbridge.msdk.out.MBConfiguration;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {
    private static final String TAG = "c";
    protected Context mContext;

    public c(Context context) {
        if (context == null) {
            this.mContext = com.mbridge.msdk.foundation.controller.c.m().c();
        } else {
            this.mContext = context.getApplicationContext();
        }
    }

    private String asUrlParams(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb2 = new StringBuilder();
            try {
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = map.get(str);
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "";
                        }
                        sb2.append("&");
                        sb2.append(str);
                        sb2.append("=");
                        sb2.append(str2);
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b(TAG, e11.getMessage());
                }
                sb2 = null;
            }
            if (sb2 != null && sb2.length() > 0) {
                return sb2.toString();
            }
        }
        return null;
    }

    public static void downloadFile(File file, String str, com.mbridge.msdk.foundation.same.net.e eVar) {
        ad.c(TAG, "downloadFile url = " + str);
        n.a().a(file, str, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x005f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0073  */
    /* JADX WARN: Code duplicated, block: B:27:0x008c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b3 A[Catch: Exception -> 0x00df, TRY_ENTER, TryCatch #0 {Exception -> 0x00df, blocks: (B:37:0x00b3, B:39:0x00b9, B:43:0x00c4, B:52:0x00e9, B:55:0x0106), top: B:96:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b9 A[Catch: Exception -> 0x00df, TryCatch #0 {Exception -> 0x00df, blocks: (B:37:0x00b3, B:39:0x00b9, B:43:0x00c4, B:52:0x00e9, B:55:0x0106), top: B:96:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:54:0x0104 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x0106 A[Catch: Exception -> 0x00df, TRY_LEAVE, TryCatch #0 {Exception -> 0x00df, blocks: (B:37:0x00b3, B:39:0x00b9, B:43:0x00c4, B:52:0x00e9, B:55:0x0106), top: B:96:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0126  */
    /* JADX WARN: Code duplicated, block: B:60:0x0132  */
    /* JADX WARN: Code duplicated, block: B:68:0x016b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0177 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x0179  */
    /* JADX WARN: Code duplicated, block: B:72:0x0192  */
    /* JADX WARN: Code duplicated, block: B:75:0x019d  */
    /* JADX WARN: Code duplicated, block: B:80:0x01b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x01b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:85:0x01c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:87:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:89:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:93:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:94:0x0202  */
    /* JADX WARN: Code duplicated, block: B:99:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:71:0x0179, please report this as an issue */
    private void post(int i11, String str, e eVar, l lVar, com.mbridge.msdk.foundation.same.net.e eVar2, boolean z11, boolean z12) {
        e eVar3;
        e eVar4;
        String str2;
        JSONArray jSONArrayB;
        String str3;
        com.mbridge.msdk.c.g gVarB;
        com.mbridge.msdk.c.a aVarN;
        i fVar;
        i iVar;
        com.mbridge.msdk.foundation.same.net.e.d dVar;
        com.mbridge.msdk.c.g gVarB2;
        String str4;
        int iAA;
        String strO;
        int iO;
        String str5;
        if (eVar == null) {
            try {
                eVar3 = new e();
            } catch (Exception e11) {
                e = e11;
                eVar3 = eVar;
                ad.a(TAG, e.getMessage());
                eVar4 = eVar3;
                ad.c(TAG, "post url = " + str);
                if (str.contains(com.mbridge.msdk.foundation.same.net.g.d.f().f44626c)) {
                    gVarB2 = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                    str4 = "";
                    if (gVarB2 != null) {
                        iO = gVarB2.O();
                        try {
                            str5 = eVar4.a().get("data");
                            if (!z12) {
                                try {
                                    if (!com.mbridge.msdk.foundation.same.report.f.a(gVarB2, str5)) {
                                        return;
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                    str4 = str5;
                                    e.printStackTrace();
                                }
                            }
                            str4 = str5;
                        } catch (Exception e13) {
                            e = e13;
                        }
                        strO = gVarB2.o();
                        iAA = gVarB2.aA();
                        eVar4.a("a_stid", gVarB2.a());
                    } else {
                        iAA = 0;
                        strO = "UNKNOWN";
                        iO = 1;
                    }
                    eVar4.a("country_code", strO);
                    try {
                        if (iO == 2) {
                            if (!TextUtils.isEmpty(str4)) {
                                return;
                            }
                            if (com.mbridge.msdk.foundation.same.report.f.a(gVarB2, str4)) {
                                if (iAA != 1) {
                                }
                                m.a().a(com.mbridge.msdk.foundation.same.net.g.d.f().f44632i, com.mbridge.msdk.foundation.same.net.g.d.f().f44636m, eVar4.toString(), false, eVar2);
                                return;
                            } else if (z12) {
                                if (iAA != 1) {
                                    return;
                                }
                                m.a().a(com.mbridge.msdk.foundation.same.net.g.d.f().f44632i, com.mbridge.msdk.foundation.same.net.g.d.f().f44636m, eVar4.toString(), false, eVar2);
                                return;
                            }
                        } else if (iO == 1) {
                            m.a().a(com.mbridge.msdk.foundation.same.net.g.d.f().f44632i, com.mbridge.msdk.foundation.same.net.g.d.f().f44636m, eVar4.toString(), false, eVar2);
                            return;
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                } else {
                    if (str.contains(com.mbridge.msdk.foundation.same.net.g.d.f().f44630g)) {
                        if (str.contains(com.mbridge.msdk.foundation.same.net.g.d.f().O)) {
                            if (eVar4 != null) {
                                str2 = str + "?" + eVar4.toString();
                            } else {
                                str2 = str;
                            }
                            jSONArrayB = com.mbridge.msdk.foundation.db.a.a.a().b();
                            if (jSONArrayB != null) {
                                String string = jSONArrayB.toString();
                                eVar4 = new e();
                                eVar4.a(e.f44663h, string);
                            }
                            str3 = str2;
                        }
                        if (i11 != 0) {
                            if (i11 != 1) {
                                if (z11) {
                                    dVar = new com.mbridge.msdk.foundation.same.net.e.d(1, str3, eVar4.toString(), eVar2, true);
                                } else {
                                    dVar = new com.mbridge.msdk.foundation.same.net.e.d(1, str3, eVar4.toString(), eVar2);
                                }
                                dVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                                iVar = dVar;
                            } else if (i11 != 2) {
                                iVar = null;
                            } else {
                                fVar = new com.mbridge.msdk.foundation.same.net.e.c(1, str3, eVar4.toString(), eVar2);
                                fVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                            }
                            if (iVar != null) {
                                iVar.a(lVar);
                                if (z11) {
                                    n.b(iVar);
                                } else {
                                    n.a(iVar);
                                }
                            }
                        }
                        fVar = new com.mbridge.msdk.foundation.same.net.e.f(1, str3, eVar4.toString(), eVar2);
                        fVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                        iVar = fVar;
                        if (iVar != null) {
                            iVar.a(lVar);
                            if (z11) {
                                n.b(iVar);
                            } else {
                                n.a(iVar);
                            }
                        }
                    }
                    gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                    if (gVarB != null) {
                        m.a().a(com.mbridge.msdk.foundation.same.net.g.d.f().f44634k, com.mbridge.msdk.foundation.same.net.g.d.f().f44638o, eVar4.toString(), false, eVar2);
                        return;
                    }
                }
                str3 = str;
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (z11) {
                            dVar = new com.mbridge.msdk.foundation.same.net.e.d(1, str3, eVar4.toString(), eVar2, true);
                        } else {
                            dVar = new com.mbridge.msdk.foundation.same.net.e.d(1, str3, eVar4.toString(), eVar2);
                        }
                        dVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                        iVar = dVar;
                    } else if (i11 != 2) {
                        iVar = null;
                    } else {
                        fVar = new com.mbridge.msdk.foundation.same.net.e.c(1, str3, eVar4.toString(), eVar2);
                        fVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                    }
                    if (iVar != null) {
                        iVar.a(lVar);
                        if (z11) {
                            n.b(iVar);
                        } else {
                            n.a(iVar);
                        }
                    }
                }
                fVar = new com.mbridge.msdk.foundation.same.net.e.f(1, str3, eVar4.toString(), eVar2);
                fVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                iVar = fVar;
                if (iVar != null) {
                    iVar.a(lVar);
                    if (z11) {
                        n.b(iVar);
                    } else {
                        n.a(iVar);
                    }
                }
            }
        } else {
            eVar3 = eVar;
        }
        try {
            addExtraParams(str, eVar3);
            f.f(eVar3);
            k kVarA = com.mbridge.msdk.foundation.same.net.g.c.a().a(eVar3);
            if (kVarA != null && eVar2 != null) {
                eVar2.onSuccess(kVarA);
                return;
            }
        } catch (Exception e15) {
            e = e15;
            ad.a(TAG, e.getMessage());
        }
        eVar4 = eVar3;
        ad.c(TAG, "post url = " + str);
        if (str.contains(com.mbridge.msdk.foundation.same.net.g.d.f().f44626c)) {
            gVarB2 = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            str4 = "";
            if (gVarB2 != null) {
                iO = gVarB2.O();
                str5 = eVar4.a().get("data");
                if (!z12) {
                    if (!com.mbridge.msdk.foundation.same.report.f.a(gVarB2, str5)) {
                        return;
                    }
                }
                str4 = str5;
                strO = gVarB2.o();
                iAA = gVarB2.aA();
                eVar4.a("a_stid", gVarB2.a());
            } else {
                iAA = 0;
                strO = "UNKNOWN";
                iO = 1;
            }
            eVar4.a("country_code", strO);
            if (iO == 2) {
                if (!TextUtils.isEmpty(str4)) {
                    return;
                }
                if (com.mbridge.msdk.foundation.same.report.f.a(gVarB2, str4)) {
                    if (iAA != 1 || iAA == 3) {
                        m.a().a(com.mbridge.msdk.foundation.same.net.g.d.f().f44632i, com.mbridge.msdk.foundation.same.net.g.d.f().f44636m, eVar4.toString(), false, eVar2);
                        return;
                    }
                } else if (z12) {
                    if (iAA != 1 && iAA != 3) {
                        return;
                    }
                    m.a().a(com.mbridge.msdk.foundation.same.net.g.d.f().f44632i, com.mbridge.msdk.foundation.same.net.g.d.f().f44636m, eVar4.toString(), false, eVar2);
                    return;
                }
            } else if (iO == 1) {
                m.a().a(com.mbridge.msdk.foundation.same.net.g.d.f().f44632i, com.mbridge.msdk.foundation.same.net.g.d.f().f44636m, eVar4.toString(), false, eVar2);
                return;
            }
        } else {
            if (str.contains(com.mbridge.msdk.foundation.same.net.g.d.f().f44630g)) {
                if (str.contains(com.mbridge.msdk.foundation.same.net.g.d.f().O)) {
                    if (eVar4 != null) {
                        str2 = str + "?" + eVar4.toString();
                    } else {
                        str2 = str;
                    }
                    jSONArrayB = com.mbridge.msdk.foundation.db.a.a.a().b();
                    if (jSONArrayB != null) {
                        String string2 = jSONArrayB.toString();
                        eVar4 = new e();
                        eVar4.a(e.f44663h, string2);
                    }
                    str3 = str2;
                }
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (z11) {
                            dVar = new com.mbridge.msdk.foundation.same.net.e.d(1, str3, eVar4.toString(), eVar2, true);
                        } else {
                            dVar = new com.mbridge.msdk.foundation.same.net.e.d(1, str3, eVar4.toString(), eVar2);
                        }
                        dVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                        iVar = dVar;
                    } else if (i11 != 2) {
                        iVar = null;
                    } else {
                        fVar = new com.mbridge.msdk.foundation.same.net.e.c(1, str3, eVar4.toString(), eVar2);
                        fVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                    }
                    if (iVar != null) {
                        iVar.a(lVar);
                        if (z11) {
                            n.b(iVar);
                        } else {
                            n.a(iVar);
                        }
                    }
                }
                fVar = new com.mbridge.msdk.foundation.same.net.e.f(1, str3, eVar4.toString(), eVar2);
                fVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                iVar = fVar;
                if (iVar != null) {
                    iVar.a(lVar);
                    if (z11) {
                        n.b(iVar);
                    } else {
                        n.a(iVar);
                    }
                }
            }
            gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB != null && (aVarN = gVarB.n()) != null && aVarN.h() == 1) {
                m.a().a(com.mbridge.msdk.foundation.same.net.g.d.f().f44634k, com.mbridge.msdk.foundation.same.net.g.d.f().f44638o, eVar4.toString(), false, eVar2);
                return;
            }
        }
        str3 = str;
        if (i11 != 0) {
            if (i11 != 1) {
                if (z11) {
                    dVar = new com.mbridge.msdk.foundation.same.net.e.d(1, str3, eVar4.toString(), eVar2, true);
                } else {
                    dVar = new com.mbridge.msdk.foundation.same.net.e.d(1, str3, eVar4.toString(), eVar2);
                }
                dVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                iVar = dVar;
            } else if (i11 != 2) {
                iVar = null;
            } else {
                fVar = new com.mbridge.msdk.foundation.same.net.e.c(1, str3, eVar4.toString(), eVar2);
                fVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            }
            if (iVar != null) {
                iVar.a(lVar);
                if (z11) {
                    n.b(iVar);
                } else {
                    n.a(iVar);
                }
            }
        }
        fVar = new com.mbridge.msdk.foundation.same.net.e.f(1, str3, eVar4.toString(), eVar2);
        fVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
        iVar = fVar;
        if (iVar != null) {
            iVar.a(lVar);
            if (z11) {
                n.b(iVar);
            } else {
                n.a(iVar);
            }
        }
    }

    public void addExtraParams(String str, e eVar) {
        if (eVar == null) {
            ad.b(TAG, "addExtraParams error, params is null,frame work error");
            return;
        }
        String strA = Aa.a();
        if (strA == null) {
            strA = "";
        }
        eVar.a("channel", strA);
        eVar.a("band_width", com.mbridge.msdk.foundation.same.net.a.a().d() + "");
        eVar.a("open", com.mbridge.msdk.foundation.same.a.R);
        if (com.mbridge.msdk.f.b.a() && !TextUtils.isEmpty(str) && str.contains("setting")) {
            String strB = Aa.b();
            if (!TextUtils.isEmpty(strB)) {
                eVar.a("keyword", strB);
            }
        }
        String str2 = eVar.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        if (str2 != null) {
            String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str2, str);
            if (!TextUtils.isEmpty(customInfoByUnitId)) {
                eVar.a("ch_info", customInfoByUnitId);
            }
            com.mbridge.msdk.c.k kVarD = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), str2);
            if (kVarD != null && !TextUtils.isEmpty(kVarD.a())) {
                eVar.a("u_stid", kVarD.a());
            }
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
            eVar.a("dev_source", "2");
        }
        if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
            eVar.a("re_domain", "1");
        }
    }

    public void choiceV3OrV5BySetting(int i11, e eVar, com.mbridge.msdk.foundation.same.net.e eVar2, String str) {
        choiceV3OrV5BySetting(i11, eVar, eVar2, str, new com.mbridge.msdk.foundation.same.net.b());
    }

    public void choiceV3OrV5BySetting(int i11, e eVar, com.mbridge.msdk.foundation.same.net.e eVar2, String str, l lVar) {
        com.mbridge.msdk.c.g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        int iAr = TextUtils.isEmpty(str) ? gVarA.ar() : gVarA.F();
        String strA = com.mbridge.msdk.foundation.same.net.g.d.f().a(str, iAr);
        if (iAr < 2) {
            if (lVar == null) {
                postV5(i11, strA, eVar, eVar2);
                return;
            } else {
                postV5(i11, strA, eVar, eVar2, lVar, false);
                return;
            }
        }
        if (iAr % 2 == 0) {
            if (eVar == null) {
                eVar = new e();
            }
            JSONArray jSONArrayB = com.mbridge.msdk.foundation.db.a.a.a().b();
            if (jSONArrayB != null) {
                String string = jSONArrayB.toString();
                int iD = com.mbridge.msdk.foundation.same.net.g.d.f().d();
                if (iD > 0 && string.length() > iD) {
                    post(i11, strA, eVar, eVar2);
                    return;
                }
                eVar.a(e.f44663h, string);
            }
        }
        e eVar3 = eVar;
        if (lVar == null) {
            getLoadOrSetting(i11, strA, eVar3, eVar2);
        } else {
            getLoadOrSetting(i11, strA, eVar3, lVar, eVar2, true);
        }
    }

    public void get(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.e eVar2) {
        get(i11, str, eVar, new com.mbridge.msdk.foundation.same.net.b(), eVar2, false, false);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0193  */
    /* JADX WARN: Code duplicated, block: B:55:0x0196  */
    /* JADX WARN: Code duplicated, block: B:58:0x019a  */
    /* JADX WARN: Code duplicated, block: B:60:0x01a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x01be  */
    /* JADX WARN: Code duplicated, block: B:66:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:68:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:69:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    public void get(int i11, String str, e eVar, l lVar, com.mbridge.msdk.foundation.same.net.e eVar2, boolean z11, boolean z12) {
        e eVar3;
        e eVar4;
        String str2;
        com.mbridge.msdk.c.g gVarA;
        i iVar;
        i fVar;
        com.mbridge.msdk.foundation.same.net.e.d dVar;
        if (eVar == null) {
            try {
                eVar3 = new e();
            } catch (Exception e11) {
                e = e11;
                eVar3 = eVar;
                ad.a(TAG, e.getMessage());
                eVar4 = eVar3;
                if (str.contains(com.mbridge.msdk.foundation.same.net.g.d.f().f44631h)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("uri", com.mbridge.msdk.foundation.same.net.g.d.f().f44635l + Uri.parse(str).getPath());
                            jSONObject.put("data", eVar4.b());
                        } catch (Throwable th2) {
                            ad.b(TAG, th2.getMessage());
                        }
                        m.a().a(com.mbridge.msdk.foundation.same.net.g.d.f().f44635l, com.mbridge.msdk.foundation.same.net.g.d.f().f44639p, jSONObject.toString(), true, eVar2);
                        return;
                    } catch (Throwable th3) {
                        ad.b(TAG, th3.getMessage());
                    }
                }
                str2 = str + "?" + eVar4.toString();
                gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
                if (str2.length() < gVarA.ao()) {
                }
                if (str2.length() < gVarA.P()) {
                }
                ad.c(TAG, "get url = " + str2);
                iVar = null;
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (z12) {
                            dVar = new com.mbridge.msdk.foundation.same.net.e.d(0, str2, null, eVar2, true);
                        } else {
                            dVar = new com.mbridge.msdk.foundation.same.net.e.d(0, str2, null, eVar2, false);
                        }
                        iVar = dVar;
                    } else if (i11 == 2) {
                        fVar = new com.mbridge.msdk.foundation.same.net.e.c(0, str2, null, eVar2);
                    }
                    if (iVar != null) {
                        iVar.a(lVar);
                        iVar.a(iVar.b());
                        if (z12) {
                            n.b(iVar);
                        } else {
                            n.a(iVar);
                        }
                    }
                }
                fVar = new com.mbridge.msdk.foundation.same.net.e.f(0, str2, null, eVar2);
                iVar = fVar;
                if (iVar != null) {
                    iVar.a(lVar);
                    iVar.a(iVar.b());
                    if (z12) {
                        n.b(iVar);
                    } else {
                        n.a(iVar);
                    }
                }
            }
        } else {
            eVar3 = eVar;
        }
        try {
            addExtraParams(str, eVar3);
            f.f(eVar3);
            String str3 = eVar3.a().get("sign");
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            eVar3.a("ts", jCurrentTimeMillis + "");
            if (com.mbridge.msdk.f.b.a()) {
                eVar3.a("st", SameMD5.getMD5(str3 + jCurrentTimeMillis));
            } else {
                eVar3.a("st", SameMD5.getMD5(jCurrentTimeMillis + str3));
            }
            k kVarA = com.mbridge.msdk.foundation.same.net.g.c.a().a(eVar3);
            if (kVarA != null && eVar2 != null) {
                eVar2.onSuccess(kVarA);
                return;
            }
        } catch (Exception e12) {
            e = e12;
            ad.a(TAG, e.getMessage());
        }
        eVar4 = eVar3;
        if (str.contains(com.mbridge.msdk.foundation.same.net.g.d.f().f44631h) && com.mbridge.msdk.foundation.same.net.g.d.f().f44641r) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uri", com.mbridge.msdk.foundation.same.net.g.d.f().f44635l + Uri.parse(str).getPath());
            jSONObject2.put("data", eVar4.b());
            m.a().a(com.mbridge.msdk.foundation.same.net.g.d.f().f44635l, com.mbridge.msdk.foundation.same.net.g.d.f().f44639p, jSONObject2.toString(), true, eVar2);
            return;
        }
        str2 = str + "?" + eVar4.toString();
        gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        if (str2.length() < gVarA.ao() && str2.contains(com.mbridge.msdk.foundation.same.net.g.d.f().f44631h)) {
            post(i11, str, eVar4, lVar, eVar2, z12, false);
            return;
        }
        if (str2.length() < gVarA.P() && z11) {
            post(i11, str, eVar4, lVar, eVar2, z12, false);
            return;
        }
        ad.c(TAG, "get url = " + str2);
        iVar = null;
        if (i11 != 0) {
            if (i11 != 1) {
                if (z12) {
                    dVar = new com.mbridge.msdk.foundation.same.net.e.d(0, str2, null, eVar2, true);
                } else {
                    dVar = new com.mbridge.msdk.foundation.same.net.e.d(0, str2, null, eVar2, false);
                }
                iVar = dVar;
            } else if (i11 == 2) {
                fVar = new com.mbridge.msdk.foundation.same.net.e.c(0, str2, null, eVar2);
            }
            if (iVar != null) {
                iVar.a(lVar);
                iVar.a(iVar.b());
                if (z12) {
                    n.b(iVar);
                } else {
                    n.a(iVar);
                }
            }
        }
        fVar = new com.mbridge.msdk.foundation.same.net.e.f(0, str2, null, eVar2);
        iVar = fVar;
        if (iVar != null) {
            iVar.a(lVar);
            iVar.a(iVar.b());
            if (z12) {
                n.b(iVar);
            } else {
                n.a(iVar);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    public void get(int i11, String str, Map<String, String> map, l lVar, com.mbridge.msdk.foundation.same.net.e eVar) {
        i fVar;
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("app_id", com.mbridge.msdk.foundation.controller.c.m().k());
        map.put("sdk_version", MBConfiguration.SDK_VERSION);
        map.put(TrackingKey.PLATFORM, "1");
        String strAsUrlParams = asUrlParams(map);
        if (!TextUtils.isEmpty(strAsUrlParams)) {
            str = str + "?" + strAsUrlParams;
        }
        if (MBridgeConstans.DEBUG) {
            ad.a("AppletsModel", "get wx scheme url = " + str);
        }
        i iVar = null;
        try {
            if (i11 == 0) {
                fVar = new com.mbridge.msdk.foundation.same.net.e.f(0, str, null, eVar);
            } else {
                if (i11 != 1) {
                    if (i11 == 2) {
                        fVar = new com.mbridge.msdk.foundation.same.net.e.c(0, str, null, eVar);
                    }
                    if (iVar != null) {
                        try {
                            iVar.a(lVar);
                            iVar.a(iVar.b());
                            n.a(iVar);
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
                fVar = new com.mbridge.msdk.foundation.same.net.e.d(0, str, null, eVar);
            }
            iVar = fVar;
        } catch (Exception unused2) {
        }
        if (iVar != null) {
            iVar.a(lVar);
            iVar.a(iVar.b());
            n.a(iVar);
        }
    }

    public void getCampaign(int i11, String str, e eVar, l lVar, com.mbridge.msdk.foundation.same.net.e eVar2) {
        e eVar3;
        try {
            com.mbridge.msdk.c.g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
            int iAr = TextUtils.isEmpty(str) ? gVarA.ar() : gVarA.F();
            String strA = com.mbridge.msdk.foundation.same.net.g.d.f().a(str, iAr);
            if (lVar == null) {
                lVar = new com.mbridge.msdk.foundation.same.net.b();
            }
            if (iAr < 2) {
                postV5(i11, strA, eVar, eVar2, lVar, true);
                return;
            }
            if (iAr % 2 == 0) {
                if (eVar == null) {
                    eVar = new e();
                }
                eVar3 = eVar;
                JSONArray jSONArrayB = com.mbridge.msdk.foundation.db.a.a.a().b();
                if (jSONArrayB != null) {
                    String string = jSONArrayB.toString();
                    int iD = com.mbridge.msdk.foundation.same.net.g.d.f().d();
                    if (iD > 0 && string.length() > iD) {
                        post(i11, strA, eVar3, lVar, eVar2, true, false);
                        return;
                    }
                    eVar3.a(e.f44663h, string);
                }
            } else {
                eVar3 = eVar;
            }
            get(i11, strA, eVar3, lVar, eVar2, true, true);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b(TAG, e11.getMessage());
            }
        }
    }

    public void getLoadOrSetting(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.e eVar2) {
        getLoadOrSetting(i11, str, eVar, new com.mbridge.msdk.foundation.same.net.b(), eVar2, true);
    }

    public void getLoadOrSetting(int i11, String str, e eVar, l lVar, com.mbridge.msdk.foundation.same.net.e eVar2, boolean z11) {
        get(i11, str, eVar, lVar, eVar2, z11, false);
    }

    public void post(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.e eVar2) {
        post(i11, str, eVar, new com.mbridge.msdk.foundation.same.net.b(), eVar2, false, false);
    }

    public void postFocusReport(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.e eVar2) {
        post(i11, str, eVar, new com.mbridge.msdk.foundation.same.net.b(), eVar2, false, true);
    }

    public void postV5(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.e eVar2) {
        String str2 = eVar.a().get("sign");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        eVar.a("ts", jCurrentTimeMillis + "");
        eVar.a("st", SameMD5.getMD5(jCurrentTimeMillis + str2));
        post(i11, str, eVar, new com.mbridge.msdk.foundation.same.net.b(), eVar2, false, false);
    }

    public void postV5(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.e eVar2, l lVar, boolean z11) {
        String str2 = eVar.a().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        eVar.a("ts", jCurrentTimeMillis + "");
        eVar.a("st", SameMD5.getMD5(jCurrentTimeMillis + str2));
        if (lVar != null) {
            post(i11, str, eVar, lVar, eVar2, z11, false);
        } else {
            post(i11, str, eVar, new com.mbridge.msdk.foundation.same.net.b(), eVar2, z11, false);
        }
    }
}
