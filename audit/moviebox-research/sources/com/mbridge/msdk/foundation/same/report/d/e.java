package com.mbridge.msdk.foundation.same.report.d;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.e.m;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e {
    private com.mbridge.msdk.e.e a(String str, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        com.mbridge.msdk.e.e eVar = new com.mbridge.msdk.e.e(str);
        try {
            eVar.a(new JSONObject(map));
            eVar.a(0);
            eVar.b(0);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return eVar;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0070 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:4:0x0007, B:6:0x0020, B:8:0x0026, B:10:0x0036, B:20:0x004e, B:22:0x0054, B:25:0x005f, B:27:0x0065, B:23:0x0059, B:15:0x0041, B:17:0x0045, B:28:0x0069, B:30:0x006d, B:31:0x0070, B:33:0x0076, B:34:0x007e, B:36:0x0084, B:39:0x008f, B:41:0x0095, B:37:0x0089), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0076 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:4:0x0007, B:6:0x0020, B:8:0x0026, B:10:0x0036, B:20:0x004e, B:22:0x0054, B:25:0x005f, B:27:0x0065, B:23:0x0059, B:15:0x0041, B:17:0x0045, B:28:0x0069, B:30:0x006d, B:31:0x0070, B:33:0x0076, B:34:0x007e, B:36:0x0084, B:39:0x008f, B:41:0x0095, B:37:0x0089), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x007e A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:4:0x0007, B:6:0x0020, B:8:0x0026, B:10:0x0036, B:20:0x004e, B:22:0x0054, B:25:0x005f, B:27:0x0065, B:23:0x0059, B:15:0x0041, B:17:0x0045, B:28:0x0069, B:30:0x006d, B:31:0x0070, B:33:0x0076, B:34:0x007e, B:36:0x0084, B:39:0x008f, B:41:0x0095, B:37:0x0089), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0084 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:4:0x0007, B:6:0x0020, B:8:0x0026, B:10:0x0036, B:20:0x004e, B:22:0x0054, B:25:0x005f, B:27:0x0065, B:23:0x0059, B:15:0x0041, B:17:0x0045, B:28:0x0069, B:30:0x006d, B:31:0x0070, B:33:0x0076, B:34:0x007e, B:36:0x0084, B:39:0x008f, B:41:0x0095, B:37:0x0089), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0089 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:4:0x0007, B:6:0x0020, B:8:0x0026, B:10:0x0036, B:20:0x004e, B:22:0x0054, B:25:0x005f, B:27:0x0065, B:23:0x0059, B:15:0x0041, B:17:0x0045, B:28:0x0069, B:30:0x006d, B:31:0x0070, B:33:0x0076, B:34:0x007e, B:36:0x0084, B:39:0x008f, B:41:0x0095, B:37:0x0089), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x008f A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:4:0x0007, B:6:0x0020, B:8:0x0026, B:10:0x0036, B:20:0x004e, B:22:0x0054, B:25:0x005f, B:27:0x0065, B:23:0x0059, B:15:0x0041, B:17:0x0045, B:28:0x0069, B:30:0x006d, B:31:0x0070, B:33:0x0076, B:34:0x007e, B:36:0x0084, B:39:0x008f, B:41:0x0095, B:37:0x0089), top: B:47:0x0007, inners: #1 }] */
    private List<CampaignEx> a(b bVar, String str) {
        List<CampaignEx> listE;
        int iIntValue;
        ArrayList arrayList = new ArrayList();
        if (bVar != null) {
            try {
                String str2 = bVar.f() + str;
                Map<String, Map<String, String>> mapP = bVar.p();
                if (mapP != null && mapP.containsKey(str2)) {
                    try {
                        Object obj = mapP.get(str2).get("resource_type");
                        if (obj instanceof String) {
                            iIntValue = Integer.parseInt((String) obj);
                        } else if (obj instanceof Integer) {
                            iIntValue = ((Integer) obj).intValue();
                        } else if (bVar.g() != null) {
                            arrayList.add(bVar.g());
                        } else {
                            if (bVar.h() != null) {
                                listE = bVar.h();
                            } else {
                                listE = bVar.e();
                            }
                            if (listE != null) {
                                arrayList.addAll(listE);
                            }
                        }
                        if (iIntValue == 1) {
                            List<CampaignEx> listH = bVar.h() != null ? bVar.h() : bVar.e();
                            if (listH != null && listH.size() > 0) {
                                arrayList.addAll(listH);
                            }
                        } else if (bVar.g() != null) {
                            arrayList.add(bVar.g());
                        } else {
                            if (bVar.h() != null) {
                                listE = bVar.h();
                            } else {
                                listE = bVar.e();
                            }
                            if (listE != null) {
                                arrayList.addAll(listE);
                            }
                        }
                    } catch (NumberFormatException e11) {
                        if (MBridgeConstans.DEBUG) {
                            e11.printStackTrace();
                        }
                    }
                } else if (bVar.g() != null) {
                    arrayList.add(bVar.g());
                } else {
                    if (bVar.h() != null) {
                        listE = bVar.h();
                    } else {
                        listE = bVar.e();
                    }
                    if (listE != null && listE.size() > 0) {
                        arrayList.addAll(listE);
                    }
                }
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    e12.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private Map<String, String> a(String str, b bVar) {
        return (bVar == null || TextUtils.isEmpty(str)) ? new HashMap() : bVar.j(str);
    }

    private Map<String, String> a(String str, String str2, m mVar) {
        d dVar = new d();
        try {
            g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                h.a();
                gVarB = i.a();
            }
            if (!TextUtils.isEmpty(gVarB.am())) {
                dVar.a("as_rid", gVarB.am());
            }
            String strN = gVarB.N();
            JSONArray jSONArrayM = gVarB.M();
            if (jSONArrayM != null) {
                for (int i11 = 0; i11 < jSONArrayM.length(); i11++) {
                    if (str.equals(jSONArrayM.getString(i11))) {
                        strN = "1.0";
                        break;
                    }
                }
            }
            if (TextUtils.isEmpty(strN)) {
                dVar.a("log_rate", -1);
            } else {
                dVar.a("log_rate", strN);
            }
            if (!TextUtils.isEmpty(str2)) {
                k kVarC = h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), str2);
                if (kVarC != null && !TextUtils.isEmpty(kVarC.s())) {
                    dVar.a("us_rid", kVarC.s());
                }
                if (kVarC != null && !TextUtils.isEmpty(kVarC.a())) {
                    dVar.a("u_stid", kVarC.a());
                }
                d dVarA = c.a().a(str2);
                if (dVarA != null) {
                    if (mVar != null && mVar.f() != null) {
                        try {
                            mVar.f().put("r_stid", dVarA.b("r_stid"));
                            dVarA.c("r_stid");
                        } catch (JSONException unused) {
                        }
                    }
                    dVar.a(dVarA);
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return dVar.a();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0055  */
    /* JADX WARN: Code duplicated, block: B:201:0x0532  */
    /* JADX WARN: Code duplicated, block: B:236:0x05dd A[Catch: Exception -> 0x00a3, TryCatch #2 {Exception -> 0x00a3, blocks: (B:41:0x00a6, B:43:0x00ac, B:46:0x00b7, B:48:0x00bd, B:57:0x00e2, B:60:0x00ea, B:61:0x00ee, B:63:0x00f4, B:66:0x00fd, B:68:0x0107, B:70:0x011a, B:71:0x0123, B:73:0x0136, B:75:0x0145, B:76:0x0152, B:79:0x015a, B:81:0x0160, B:83:0x0166, B:86:0x0196, B:88:0x01a0, B:90:0x01a6, B:91:0x01c4, B:92:0x01cf, B:94:0x01d7, B:96:0x01dd, B:97:0x01fb, B:98:0x0206, B:100:0x020e, B:102:0x0214, B:103:0x0232, B:104:0x023d, B:106:0x0245, B:108:0x024b, B:109:0x0269, B:110:0x0274, B:113:0x0297, B:115:0x02a1, B:116:0x02a6, B:118:0x02ac, B:120:0x02ca, B:123:0x02da, B:139:0x0364, B:141:0x036e, B:143:0x037d, B:144:0x039d, B:145:0x03a6, B:148:0x03af, B:150:0x03b5, B:156:0x03f0, B:160:0x03fb, B:162:0x0411, B:164:0x0436, B:166:0x043c, B:168:0x0461, B:170:0x0465, B:172:0x0475, B:173:0x047a, B:175:0x0484, B:176:0x048d, B:178:0x0493, B:179:0x04a0, B:181:0x04be, B:183:0x04c5, B:184:0x04d2, B:186:0x04dc, B:187:0x04e5, B:189:0x04ed, B:191:0x04f4, B:192:0x0501, B:194:0x050b, B:195:0x0514, B:196:0x0521, B:198:0x0529, B:202:0x0535, B:205:0x0543, B:207:0x0565, B:211:0x056e, B:212:0x0575, B:214:0x057d, B:218:0x0586, B:219:0x058d, B:221:0x0599, B:249:0x0620, B:226:0x05a9, B:228:0x05b5, B:230:0x05bf, B:235:0x05d4, B:237:0x05e4, B:240:0x05eb, B:236:0x05dd, B:231:0x05c8, B:233:0x05ce, B:241:0x05f3, B:243:0x0601, B:245:0x0612, B:248:0x0619, B:244:0x060a, B:167:0x045a, B:163:0x042f, B:151:0x03cc, B:152:0x03d0, B:154:0x03d6, B:155:0x03ed, B:124:0x02f2, B:126:0x030b, B:127:0x030f, B:119:0x02c5, B:128:0x0313, B:130:0x031f, B:131:0x0324, B:133:0x032a, B:135:0x0344, B:137:0x034a, B:138:0x0361, B:134:0x0341, B:84:0x0186, B:72:0x012d, B:251:0x0656, B:49:0x00c1, B:51:0x00c7, B:52:0x00cf, B:53:0x00d3, B:55:0x00d9, B:44:0x00b1, B:38:0x009e), top: B:261:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:239:0x05ea  */
    /* JADX WARN: Code duplicated, block: B:255:0x065f  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ac A[Catch: Exception -> 0x00a3, TryCatch #2 {Exception -> 0x00a3, blocks: (B:41:0x00a6, B:43:0x00ac, B:46:0x00b7, B:48:0x00bd, B:57:0x00e2, B:60:0x00ea, B:61:0x00ee, B:63:0x00f4, B:66:0x00fd, B:68:0x0107, B:70:0x011a, B:71:0x0123, B:73:0x0136, B:75:0x0145, B:76:0x0152, B:79:0x015a, B:81:0x0160, B:83:0x0166, B:86:0x0196, B:88:0x01a0, B:90:0x01a6, B:91:0x01c4, B:92:0x01cf, B:94:0x01d7, B:96:0x01dd, B:97:0x01fb, B:98:0x0206, B:100:0x020e, B:102:0x0214, B:103:0x0232, B:104:0x023d, B:106:0x0245, B:108:0x024b, B:109:0x0269, B:110:0x0274, B:113:0x0297, B:115:0x02a1, B:116:0x02a6, B:118:0x02ac, B:120:0x02ca, B:123:0x02da, B:139:0x0364, B:141:0x036e, B:143:0x037d, B:144:0x039d, B:145:0x03a6, B:148:0x03af, B:150:0x03b5, B:156:0x03f0, B:160:0x03fb, B:162:0x0411, B:164:0x0436, B:166:0x043c, B:168:0x0461, B:170:0x0465, B:172:0x0475, B:173:0x047a, B:175:0x0484, B:176:0x048d, B:178:0x0493, B:179:0x04a0, B:181:0x04be, B:183:0x04c5, B:184:0x04d2, B:186:0x04dc, B:187:0x04e5, B:189:0x04ed, B:191:0x04f4, B:192:0x0501, B:194:0x050b, B:195:0x0514, B:196:0x0521, B:198:0x0529, B:202:0x0535, B:205:0x0543, B:207:0x0565, B:211:0x056e, B:212:0x0575, B:214:0x057d, B:218:0x0586, B:219:0x058d, B:221:0x0599, B:249:0x0620, B:226:0x05a9, B:228:0x05b5, B:230:0x05bf, B:235:0x05d4, B:237:0x05e4, B:240:0x05eb, B:236:0x05dd, B:231:0x05c8, B:233:0x05ce, B:241:0x05f3, B:243:0x0601, B:245:0x0612, B:248:0x0619, B:244:0x060a, B:167:0x045a, B:163:0x042f, B:151:0x03cc, B:152:0x03d0, B:154:0x03d6, B:155:0x03ed, B:124:0x02f2, B:126:0x030b, B:127:0x030f, B:119:0x02c5, B:128:0x0313, B:130:0x031f, B:131:0x0324, B:133:0x032a, B:135:0x0344, B:137:0x034a, B:138:0x0361, B:134:0x0341, B:84:0x0186, B:72:0x012d, B:251:0x0656, B:49:0x00c1, B:51:0x00c7, B:52:0x00cf, B:53:0x00d3, B:55:0x00d9, B:44:0x00b1, B:38:0x009e), top: B:261:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b1 A[Catch: Exception -> 0x00a3, TryCatch #2 {Exception -> 0x00a3, blocks: (B:41:0x00a6, B:43:0x00ac, B:46:0x00b7, B:48:0x00bd, B:57:0x00e2, B:60:0x00ea, B:61:0x00ee, B:63:0x00f4, B:66:0x00fd, B:68:0x0107, B:70:0x011a, B:71:0x0123, B:73:0x0136, B:75:0x0145, B:76:0x0152, B:79:0x015a, B:81:0x0160, B:83:0x0166, B:86:0x0196, B:88:0x01a0, B:90:0x01a6, B:91:0x01c4, B:92:0x01cf, B:94:0x01d7, B:96:0x01dd, B:97:0x01fb, B:98:0x0206, B:100:0x020e, B:102:0x0214, B:103:0x0232, B:104:0x023d, B:106:0x0245, B:108:0x024b, B:109:0x0269, B:110:0x0274, B:113:0x0297, B:115:0x02a1, B:116:0x02a6, B:118:0x02ac, B:120:0x02ca, B:123:0x02da, B:139:0x0364, B:141:0x036e, B:143:0x037d, B:144:0x039d, B:145:0x03a6, B:148:0x03af, B:150:0x03b5, B:156:0x03f0, B:160:0x03fb, B:162:0x0411, B:164:0x0436, B:166:0x043c, B:168:0x0461, B:170:0x0465, B:172:0x0475, B:173:0x047a, B:175:0x0484, B:176:0x048d, B:178:0x0493, B:179:0x04a0, B:181:0x04be, B:183:0x04c5, B:184:0x04d2, B:186:0x04dc, B:187:0x04e5, B:189:0x04ed, B:191:0x04f4, B:192:0x0501, B:194:0x050b, B:195:0x0514, B:196:0x0521, B:198:0x0529, B:202:0x0535, B:205:0x0543, B:207:0x0565, B:211:0x056e, B:212:0x0575, B:214:0x057d, B:218:0x0586, B:219:0x058d, B:221:0x0599, B:249:0x0620, B:226:0x05a9, B:228:0x05b5, B:230:0x05bf, B:235:0x05d4, B:237:0x05e4, B:240:0x05eb, B:236:0x05dd, B:231:0x05c8, B:233:0x05ce, B:241:0x05f3, B:243:0x0601, B:245:0x0612, B:248:0x0619, B:244:0x060a, B:167:0x045a, B:163:0x042f, B:151:0x03cc, B:152:0x03d0, B:154:0x03d6, B:155:0x03ed, B:124:0x02f2, B:126:0x030b, B:127:0x030f, B:119:0x02c5, B:128:0x0313, B:130:0x031f, B:131:0x0324, B:133:0x032a, B:135:0x0344, B:137:0x034a, B:138:0x0361, B:134:0x0341, B:84:0x0186, B:72:0x012d, B:251:0x0656, B:49:0x00c1, B:51:0x00c7, B:52:0x00cf, B:53:0x00d3, B:55:0x00d9, B:44:0x00b1, B:38:0x009e), top: B:261:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00b7 A[Catch: Exception -> 0x00a3, TryCatch #2 {Exception -> 0x00a3, blocks: (B:41:0x00a6, B:43:0x00ac, B:46:0x00b7, B:48:0x00bd, B:57:0x00e2, B:60:0x00ea, B:61:0x00ee, B:63:0x00f4, B:66:0x00fd, B:68:0x0107, B:70:0x011a, B:71:0x0123, B:73:0x0136, B:75:0x0145, B:76:0x0152, B:79:0x015a, B:81:0x0160, B:83:0x0166, B:86:0x0196, B:88:0x01a0, B:90:0x01a6, B:91:0x01c4, B:92:0x01cf, B:94:0x01d7, B:96:0x01dd, B:97:0x01fb, B:98:0x0206, B:100:0x020e, B:102:0x0214, B:103:0x0232, B:104:0x023d, B:106:0x0245, B:108:0x024b, B:109:0x0269, B:110:0x0274, B:113:0x0297, B:115:0x02a1, B:116:0x02a6, B:118:0x02ac, B:120:0x02ca, B:123:0x02da, B:139:0x0364, B:141:0x036e, B:143:0x037d, B:144:0x039d, B:145:0x03a6, B:148:0x03af, B:150:0x03b5, B:156:0x03f0, B:160:0x03fb, B:162:0x0411, B:164:0x0436, B:166:0x043c, B:168:0x0461, B:170:0x0465, B:172:0x0475, B:173:0x047a, B:175:0x0484, B:176:0x048d, B:178:0x0493, B:179:0x04a0, B:181:0x04be, B:183:0x04c5, B:184:0x04d2, B:186:0x04dc, B:187:0x04e5, B:189:0x04ed, B:191:0x04f4, B:192:0x0501, B:194:0x050b, B:195:0x0514, B:196:0x0521, B:198:0x0529, B:202:0x0535, B:205:0x0543, B:207:0x0565, B:211:0x056e, B:212:0x0575, B:214:0x057d, B:218:0x0586, B:219:0x058d, B:221:0x0599, B:249:0x0620, B:226:0x05a9, B:228:0x05b5, B:230:0x05bf, B:235:0x05d4, B:237:0x05e4, B:240:0x05eb, B:236:0x05dd, B:231:0x05c8, B:233:0x05ce, B:241:0x05f3, B:243:0x0601, B:245:0x0612, B:248:0x0619, B:244:0x060a, B:167:0x045a, B:163:0x042f, B:151:0x03cc, B:152:0x03d0, B:154:0x03d6, B:155:0x03ed, B:124:0x02f2, B:126:0x030b, B:127:0x030f, B:119:0x02c5, B:128:0x0313, B:130:0x031f, B:131:0x0324, B:133:0x032a, B:135:0x0344, B:137:0x034a, B:138:0x0361, B:134:0x0341, B:84:0x0186, B:72:0x012d, B:251:0x0656, B:49:0x00c1, B:51:0x00c7, B:52:0x00cf, B:53:0x00d3, B:55:0x00d9, B:44:0x00b1, B:38:0x009e), top: B:261:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00d3 A[Catch: Exception -> 0x00a3, TryCatch #2 {Exception -> 0x00a3, blocks: (B:41:0x00a6, B:43:0x00ac, B:46:0x00b7, B:48:0x00bd, B:57:0x00e2, B:60:0x00ea, B:61:0x00ee, B:63:0x00f4, B:66:0x00fd, B:68:0x0107, B:70:0x011a, B:71:0x0123, B:73:0x0136, B:75:0x0145, B:76:0x0152, B:79:0x015a, B:81:0x0160, B:83:0x0166, B:86:0x0196, B:88:0x01a0, B:90:0x01a6, B:91:0x01c4, B:92:0x01cf, B:94:0x01d7, B:96:0x01dd, B:97:0x01fb, B:98:0x0206, B:100:0x020e, B:102:0x0214, B:103:0x0232, B:104:0x023d, B:106:0x0245, B:108:0x024b, B:109:0x0269, B:110:0x0274, B:113:0x0297, B:115:0x02a1, B:116:0x02a6, B:118:0x02ac, B:120:0x02ca, B:123:0x02da, B:139:0x0364, B:141:0x036e, B:143:0x037d, B:144:0x039d, B:145:0x03a6, B:148:0x03af, B:150:0x03b5, B:156:0x03f0, B:160:0x03fb, B:162:0x0411, B:164:0x0436, B:166:0x043c, B:168:0x0461, B:170:0x0465, B:172:0x0475, B:173:0x047a, B:175:0x0484, B:176:0x048d, B:178:0x0493, B:179:0x04a0, B:181:0x04be, B:183:0x04c5, B:184:0x04d2, B:186:0x04dc, B:187:0x04e5, B:189:0x04ed, B:191:0x04f4, B:192:0x0501, B:194:0x050b, B:195:0x0514, B:196:0x0521, B:198:0x0529, B:202:0x0535, B:205:0x0543, B:207:0x0565, B:211:0x056e, B:212:0x0575, B:214:0x057d, B:218:0x0586, B:219:0x058d, B:221:0x0599, B:249:0x0620, B:226:0x05a9, B:228:0x05b5, B:230:0x05bf, B:235:0x05d4, B:237:0x05e4, B:240:0x05eb, B:236:0x05dd, B:231:0x05c8, B:233:0x05ce, B:241:0x05f3, B:243:0x0601, B:245:0x0612, B:248:0x0619, B:244:0x060a, B:167:0x045a, B:163:0x042f, B:151:0x03cc, B:152:0x03d0, B:154:0x03d6, B:155:0x03ed, B:124:0x02f2, B:126:0x030b, B:127:0x030f, B:119:0x02c5, B:128:0x0313, B:130:0x031f, B:131:0x0324, B:133:0x032a, B:135:0x0344, B:137:0x034a, B:138:0x0361, B:134:0x0341, B:84:0x0186, B:72:0x012d, B:251:0x0656, B:49:0x00c1, B:51:0x00c7, B:52:0x00cf, B:53:0x00d3, B:55:0x00d9, B:44:0x00b1, B:38:0x009e), top: B:261:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00d9 A[Catch: Exception -> 0x00a3, TryCatch #2 {Exception -> 0x00a3, blocks: (B:41:0x00a6, B:43:0x00ac, B:46:0x00b7, B:48:0x00bd, B:57:0x00e2, B:60:0x00ea, B:61:0x00ee, B:63:0x00f4, B:66:0x00fd, B:68:0x0107, B:70:0x011a, B:71:0x0123, B:73:0x0136, B:75:0x0145, B:76:0x0152, B:79:0x015a, B:81:0x0160, B:83:0x0166, B:86:0x0196, B:88:0x01a0, B:90:0x01a6, B:91:0x01c4, B:92:0x01cf, B:94:0x01d7, B:96:0x01dd, B:97:0x01fb, B:98:0x0206, B:100:0x020e, B:102:0x0214, B:103:0x0232, B:104:0x023d, B:106:0x0245, B:108:0x024b, B:109:0x0269, B:110:0x0274, B:113:0x0297, B:115:0x02a1, B:116:0x02a6, B:118:0x02ac, B:120:0x02ca, B:123:0x02da, B:139:0x0364, B:141:0x036e, B:143:0x037d, B:144:0x039d, B:145:0x03a6, B:148:0x03af, B:150:0x03b5, B:156:0x03f0, B:160:0x03fb, B:162:0x0411, B:164:0x0436, B:166:0x043c, B:168:0x0461, B:170:0x0465, B:172:0x0475, B:173:0x047a, B:175:0x0484, B:176:0x048d, B:178:0x0493, B:179:0x04a0, B:181:0x04be, B:183:0x04c5, B:184:0x04d2, B:186:0x04dc, B:187:0x04e5, B:189:0x04ed, B:191:0x04f4, B:192:0x0501, B:194:0x050b, B:195:0x0514, B:196:0x0521, B:198:0x0529, B:202:0x0535, B:205:0x0543, B:207:0x0565, B:211:0x056e, B:212:0x0575, B:214:0x057d, B:218:0x0586, B:219:0x058d, B:221:0x0599, B:249:0x0620, B:226:0x05a9, B:228:0x05b5, B:230:0x05bf, B:235:0x05d4, B:237:0x05e4, B:240:0x05eb, B:236:0x05dd, B:231:0x05c8, B:233:0x05ce, B:241:0x05f3, B:243:0x0601, B:245:0x0612, B:248:0x0619, B:244:0x060a, B:167:0x045a, B:163:0x042f, B:151:0x03cc, B:152:0x03d0, B:154:0x03d6, B:155:0x03ed, B:124:0x02f2, B:126:0x030b, B:127:0x030f, B:119:0x02c5, B:128:0x0313, B:130:0x031f, B:131:0x0324, B:133:0x032a, B:135:0x0344, B:137:0x034a, B:138:0x0361, B:134:0x0341, B:84:0x0186, B:72:0x012d, B:251:0x0656, B:49:0x00c1, B:51:0x00c7, B:52:0x00cf, B:53:0x00d3, B:55:0x00d9, B:44:0x00b1, B:38:0x009e), top: B:261:0x0043 }] */
    private Map<String, String> b(String str, b bVar) {
        boolean zContains;
        List<CampaignEx> listE;
        String str2 = CampaignEx.JSON_KEY_EC_TEMP_ID;
        String str3 = "endcard_crid";
        String str4 = "video_crid";
        String str5 = "crid";
        String str6 = "vtid";
        d dVar = new d();
        try {
            if (Arrays.asList(a.f44815g).contains(str)) {
                return dVar.a();
            }
            if (bVar == null) {
                dVar.a("metrics_data_reason", "metrics 上报时意外为空");
                return dVar.a();
            }
            List arrayList = new ArrayList();
            try {
                try {
                    if (bVar.g() != null && bVar.g().getAdType() == 295) {
                        if (bVar.h() != null) {
                            listE = bVar.h();
                        } else {
                            listE = bVar.e();
                        }
                        if (listE != null) {
                            if (listE.size() == 1) {
                                arrayList.addAll(listE);
                            } else {
                                arrayList.add(bVar.g());
                            }
                        } else if (bVar.g() != null) {
                            arrayList.add(bVar.g());
                        }
                    } else if (!Arrays.asList(a.f44814f).contains(str)) {
                        if (bVar.h() != null) {
                            listE = bVar.h();
                        } else {
                            listE = bVar.e();
                        }
                        if (listE != null) {
                            if (listE.size() == 1 && bVar.g() != null) {
                                arrayList.add(bVar.g());
                            } else {
                                arrayList.addAll(listE);
                            }
                        } else if (bVar.g() != null) {
                            arrayList.add(bVar.g());
                        }
                    } else if ("m_download_start".equals(str) || "m_download_end".equals(str)) {
                        arrayList = a(bVar, str);
                    } else {
                        List<CampaignEx> listH = bVar.h() != null ? bVar.h() : bVar.e();
                        if (listH != null && listH.size() > 0) {
                            arrayList.addAll(listH);
                        }
                    }
                } catch (Throwable th2) {
                    ad.b("SameMetricsReport", th2.getMessage());
                }
                if (arrayList != null && arrayList.size() != 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        CampaignEx campaignEx = (CampaignEx) it.next();
                        if (campaignEx != null) {
                            if (TextUtils.isEmpty(campaignEx.getNLRid())) {
                                dVar.a("lrid", campaignEx.getLocalRequestId());
                            } else {
                                dVar.a("n_lrid", campaignEx.getNLRid());
                                if (!TextUtils.isEmpty(campaignEx.getNRid())) {
                                    dVar.a("n_rid", campaignEx.getNRid());
                                }
                                dVar.a("lrid", campaignEx.getLocalRequestId());
                            }
                            dVar.a("rid", campaignEx.getRequestId());
                            if (campaignEx.getMof_tplid() != 0) {
                                dVar.a("stid", Integer.valueOf(campaignEx.getMof_tplid()));
                            }
                            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                            if (rewardTemplateMode != null && rewardTemplateMode.f() != 0) {
                                if (dVar.a(str6)) {
                                    dVar.a(str6, dVar.b(str6) + "," + rewardTemplateMode.f());
                                } else {
                                    dVar.a(str6, Integer.valueOf(rewardTemplateMode.f()));
                                }
                            }
                            if (campaignEx.getCreativeId() != 0) {
                                if (dVar.a(str5)) {
                                    dVar.a(str5, dVar.b(str5) + "," + campaignEx.getCreativeId());
                                } else {
                                    dVar.a(str5, Long.valueOf(campaignEx.getCreativeId()));
                                }
                            }
                            if (campaignEx.getVidCrtvId() != 0) {
                                if (dVar.a(str4)) {
                                    dVar.a(str4, dVar.b(str4) + "," + campaignEx.getVidCrtvId());
                                } else {
                                    dVar.a(str4, Long.valueOf(campaignEx.getVidCrtvId()));
                                }
                            }
                            if (campaignEx.getEcCrtvId() != 0) {
                                if (dVar.a(str3)) {
                                    dVar.a(str3, dVar.b(str3) + "," + campaignEx.getEcCrtvId());
                                } else {
                                    dVar.a(str3, Long.valueOf(campaignEx.getEcCrtvId()));
                                }
                            }
                            if (campaignEx.getEcTemplateId() != 0) {
                                if (dVar.a(str2)) {
                                    dVar.a(str2, dVar.b(str2) + "," + campaignEx.getEcTemplateId());
                                } else {
                                    dVar.a(str2, Long.valueOf(campaignEx.getEcTemplateId()));
                                }
                            }
                            dVar.a("bid_tk", campaignEx.getBidToken());
                            String str7 = str2;
                            String str8 = str3;
                            Object obj = "1";
                            String str9 = str4;
                            String str10 = str5;
                            if (campaignEx.isDynamicView()) {
                                if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                                    dVar.a("sdyv", "1");
                                }
                                if (dVar.a("vdyv")) {
                                    dVar.a("vdyv", dVar.b("vdyv") + ",1");
                                } else {
                                    dVar.a("vdyv", "1");
                                }
                                boolean zL = ai.l(campaignEx.getendcard_url());
                                if (dVar.a("edyv")) {
                                    if (zL) {
                                        dVar.a("edyv", dVar.b("edyv") + ",2");
                                    } else {
                                        dVar.a("edyv", dVar.b("edyv") + ",1");
                                    }
                                } else if (zL) {
                                    dVar.a("edyv", "2");
                                } else {
                                    dVar.a("edyv", "1");
                                }
                            } else {
                                str6 = str6;
                                if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                                    dVar.a("sdyv", "2");
                                }
                                if (dVar.a("vdyv")) {
                                    dVar.a("vdyv", dVar.b("vdyv") + ",2");
                                } else {
                                    dVar.a("vdyv", "2");
                                }
                                if (dVar.a("edyv")) {
                                    dVar.a("edyv", dVar.b("edyv") + ",2");
                                } else {
                                    dVar.a("edyv", "2");
                                }
                            }
                            if (!TextUtils.isEmpty(campaignEx.getExt_data())) {
                                JSONObject jSONObject = new JSONObject(campaignEx.getExt_data());
                                if (dVar.a("dspid")) {
                                    dVar.a("dspid", dVar.b("dspid") + "," + jSONObject.optString("par_dspid"));
                                } else {
                                    dVar.a("dspid", jSONObject.optString("par_dspid"));
                                }
                            }
                            if (campaignEx.getPlayable_ads_without_video() == 2) {
                                if (dVar.a("only_ec")) {
                                    dVar.a("only_ec", dVar.b("only_ec") + ",2");
                                } else {
                                    dVar.a("only_ec", "2");
                                }
                            } else if (dVar.a("only_ec")) {
                                dVar.a("only_ec", dVar.b("only_ec") + ",1");
                            } else {
                                dVar.a("only_ec", "1");
                            }
                            if (!campaignEx.isBidCampaign()) {
                                obj = "0";
                            }
                            dVar.a(CampaignEx.JSON_KEY_HB, obj);
                            dVar.a(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
                            if (dVar.a(BidResponsedEx.KEY_CID)) {
                                dVar.a(BidResponsedEx.KEY_CID, dVar.b(BidResponsedEx.KEY_CID) + "," + campaignEx.getId());
                            } else {
                                dVar.a(BidResponsedEx.KEY_CID, campaignEx.getId());
                            }
                            if (dVar.a("rid_n")) {
                                dVar.a("rid_n", dVar.b("rid_n") + "," + campaignEx.getRequestIdNotice());
                            } else {
                                dVar.a("rid_n", campaignEx.getRequestIdNotice());
                            }
                            HashMap<String, String> map = com.mbridge.msdk.foundation.controller.a.f44041b;
                            if (map != null) {
                                String str11 = map.get(campaignEx.getCampaignUnitId());
                                if (!TextUtils.isEmpty(str11)) {
                                    dVar.a("u_stid", str11);
                                }
                            }
                            if (!TextUtils.isEmpty(campaignEx.getCampaignUnitId())) {
                                dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, campaignEx.getCampaignUnitId());
                            }
                            if (campaignEx.getAdType() != 0) {
                                dVar.a("adtp", Integer.valueOf(campaignEx.getAdType()));
                            }
                            dVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(campaignEx.isBidCampaign() ? 1 : 0));
                            dVar.a(CampaignEx.URL_KEY_EXP_IDS, campaignEx.getExpIds());
                            if ("2000047".contains(str)) {
                                if (campaignEx.getTyped() != -1) {
                                    dVar.a("type_d", Integer.valueOf(campaignEx.getTyped()));
                                }
                                if (!TextUtils.isEmpty(campaignEx.getReasond())) {
                                    dVar.a("reason_d", campaignEx.getReasond());
                                }
                            }
                            if ("2000048".contains(str)) {
                                if (campaignEx.getTyped() != -1) {
                                    dVar.a("type", Integer.valueOf(campaignEx.getTyped()));
                                }
                                if (!TextUtils.isEmpty(campaignEx.getReasond())) {
                                    dVar.a("reason", campaignEx.getReasond());
                                }
                                dVar.a(CampaignEx.JSON_KEY_RETARGET_TYPE, Integer.valueOf(campaignEx.getRtinsType()));
                            }
                            if (campaignEx.getAdType() == 94 || campaignEx.getAdType() == 287) {
                                if (Arrays.asList(a.f44818j).contains(str)) {
                                    dVar.a(CampaignEx.KEY_SHOW_INDEX, Integer.valueOf(campaignEx.getShowIndex()));
                                    dVar.a("trigger_show_type", Integer.valueOf(campaignEx.getShowType()));
                                    if (str.equals("2000136")) {
                                        dVar.a("temp_display_type", Integer.valueOf(campaignEx.isTemplateRenderSucc() ? 1 : 2));
                                    }
                                    if (str.equals("2000147")) {
                                        dVar.a("temp_display_type", Integer.valueOf(campaignEx.isECTemplateRenderSucc() ? 1 : 2));
                                    }
                                }
                                if (Arrays.asList(a.f44819k).contains(str)) {
                                    int clickTempSource = campaignEx.getClickTempSource();
                                    if (clickTempSource == 1) {
                                        if (campaignEx.getRewardTemplateMode().e().contains("alecfc=1")) {
                                            dVar.a("full_screen_click", 1);
                                        } else {
                                            dVar.a("full_screen_click", 2);
                                        }
                                        dVar.a("temp_display_type", Integer.valueOf(campaignEx.isTemplateRenderSucc() ? 1 : 2));
                                    } else if (clickTempSource == 2) {
                                        String str12 = campaignEx.getendcard_url();
                                        if (campaignEx.getMof_tplid() != 501 || TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                                            if (TextUtils.isEmpty(str12)) {
                                                dVar.a("full_screen_click", 2);
                                            } else {
                                                zContains = str12.contains("alecfc=1");
                                            }
                                            dVar.a("temp_display_type", Integer.valueOf(campaignEx.isECTemplateRenderSucc() ? 1 : 2));
                                        } else {
                                            zContains = campaignEx.getMof_template_url().contains("alecfc=1");
                                        }
                                        if (zContains) {
                                            dVar.a("full_screen_click", 1);
                                        } else {
                                            dVar.a("full_screen_click", 2);
                                        }
                                        dVar.a("temp_display_type", Integer.valueOf(campaignEx.isECTemplateRenderSucc() ? 1 : 2));
                                    }
                                    dVar.a(CampaignEx.KEY_CLICK_TEMP_SOURCE, Integer.valueOf(campaignEx.getClickTempSource()));
                                    dVar.a("trigger_click_type", Integer.valueOf(campaignEx.getClickType()));
                                    dVar.a(CampaignEx.KEY_TRIGGER_CLICK_SOURCE, Integer.valueOf(campaignEx.getTriggerClickSource()));
                                }
                            }
                            it = it;
                            str2 = str7;
                            str3 = str8;
                            str4 = str9;
                            str5 = str10;
                            str6 = str6;
                        }
                    }
                    return dVar.a();
                }
                return dVar.a();
            } catch (Exception e11) {
                e = e11;
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e12) {
            e = e12;
        }
        if (MBridgeConstans.DEBUG) {
            e.printStackTrace();
        }
        return dVar.a();
    }

    private Map<String, String> c(String str, b bVar) {
        d dVar = new d();
        try {
            if (str.equals("2000125")) {
                dVar.a("duration", Long.valueOf(bVar.l("2000123")));
            } else if (str.equals("2000126")) {
                dVar.a("duration", Long.valueOf(bVar.l("2000125")));
            } else if (str.equals("2000127")) {
                dVar.a("duration", Long.valueOf(bVar.l("2000123")));
            } else if (str.equals("2000154")) {
                dVar.a("duration", Long.valueOf(bVar.l("2000126")));
            } else if (str.equals("2000047") || str.equals("2000048")) {
                dVar.a("duration", Long.valueOf(bVar.l("2000123")));
            } else if (str.equals("2000155")) {
                dVar.a("duration", Long.valueOf(bVar.l("2000154")));
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return dVar.a();
    }

    private Map<String, String> d(String str, b bVar) {
        HashMap map = new HashMap();
        try {
            if (Arrays.asList(a.f44813e).contains(str)) {
                map.put("auto_load", bVar != null ? bVar.d() : "");
            }
            if (bVar != null) {
                Map<String, Map<String, String>> mapP = bVar.p();
                String str2 = bVar.f() + str;
                if (mapP.containsKey(str2) && mapP.get(str2) != null) {
                    map.putAll(mapP.get(str2));
                }
                try {
                    Map<String, Map<String, String>> mapQ = bVar.q();
                    String str3 = bVar.f() + "_" + bVar.b() + "_" + str;
                    if (mapQ.containsKey(str3) && mapQ.get(str3) != null) {
                        map.putAll(mapQ.get(str3));
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        } catch (Exception e12) {
            if (MBridgeConstans.DEBUG) {
                e12.printStackTrace();
            }
        }
        return map;
    }

    public final void a(String str, m mVar, b bVar, com.mbridge.msdk.foundation.same.report.d.a.a aVar) {
        Map<String, String> mapC;
        HashMap map = new HashMap();
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            bVar.a(str);
            if (str.equals("2000146")) {
                bVar.j();
            }
            Map<String, String> mapB = b(str, bVar);
            if (mapB != null) {
                map.putAll(mapB);
            }
            Map<String, String> mapA = a(str, bVar.i(), mVar);
            if (mapA != null) {
                map.putAll(mapA);
            }
            if (Arrays.asList(a.f44812d).contains(str) && (mapC = c(str, bVar)) != null) {
                map.putAll(mapC);
            }
            Map<String, String> mapD = d(str, bVar);
            if (mapD != null) {
                map.putAll(mapD);
            }
            if (!map.containsKey("lrid") || TextUtils.isEmpty(map.get("lrid"))) {
                map.put("lrid", bVar.f());
            }
            Map<String, String> mapA2 = a(str, bVar);
            if (mapA2 != null) {
                map.putAll(mapA2);
            }
            if (bVar.d() != null && bVar.d().equals("1") && Arrays.asList(a.f44810b).contains(str)) {
                return;
            }
            if (MBridgeConstans.DEBUG) {
                ad.b("MetricsRefactor", "reportkey: " + str + " 详细数据 " + map.toString());
            }
            com.mbridge.msdk.e.e eVarA = a(str, map);
            if (mVar != null && eVarA != null) {
                mVar.a(eVarA);
            }
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void b(String str, m mVar, b bVar, com.mbridge.msdk.foundation.same.report.d.a.a aVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap map = new HashMap();
            bVar.a(str);
            Map<String, String> mapA = a(str, bVar.i(), mVar);
            if (mapA != null) {
                map.putAll(mapA);
            }
            Map<String, String> mapD = d(str, bVar);
            if (mapD != null) {
                map.putAll(mapD);
            }
            Map<String, String> mapA2 = a(str, bVar);
            if (mapA2 != null) {
                map.putAll(mapA2);
            }
            if (MBridgeConstans.DEBUG) {
                ad.b("MetricsRefactor", "reportkey: " + str + " 详细数据 " + map.toString());
            }
            com.mbridge.msdk.e.e eVarA = a(str, map);
            if (mVar != null && eVarA != null) {
                mVar.a(eVarA);
            }
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }
}
