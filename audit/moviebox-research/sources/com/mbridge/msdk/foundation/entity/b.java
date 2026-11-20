package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.out.Frame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {
    public static final String JSON_KEY_ADS = "ads";
    public static final String JSON_KEY_AD_HTML = "cam_html";
    public static final String JSON_KEY_AD_TYPE = "ad_type";
    public static final String JSON_KEY_AD_ZIP = "cam_tpl_url";
    public static final String JSON_KEY_BANNER_HTML = "cam_html";
    public static final String JSON_KEY_BANNER_URL = "cam_tpl_url";
    public static final String JSON_KEY_CSP = "csp";
    public static final String JSON_KEY_DO = "do";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_END_SCREEN_URL = "end_screen_url";
    public static final String JSON_KEY_FRAME_ADS = "frames";
    public static final String JSON_KEY_HTML_URL = "html_url";
    public static final String JSON_KEY_IA_EXT1 = "ia_all_ext1";
    public static final String JSON_KEY_IA_EXT2 = "ia_all_ext2";
    public static final String JSON_KEY_IA_ICON = "ia_icon";
    public static final String JSON_KEY_IA_ORI = "ia_ori";
    public static final String JSON_KEY_IA_RST = "ia_rst";
    public static final String JSON_KEY_IA_URL = "ia_url";
    public static final String JSON_KEY_JM_DO = "jm_do";
    public static final String JSON_KEY_MOF_TEMPLATE_URL = "mof_template_url";
    public static final String JSON_KEY_MOF_TPLID = "mof_tplid";
    public static final String JSON_KEY_NSCPT = "nscpt";
    public static final String JSON_KEY_ONLY_IMPRESSION_URL = "only_impression_url";
    public static final String JSON_KEY_PARENT_SESSION_ID = "parent_session_id";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_REPLACE_TMP = "replace_tmp";
    public static final String JSON_KEY_REQ_EXT_DATA = "req_ext_data";
    public static final String JSON_KEY_RKS = "rks";
    public static final String JSON_KEY_SESSION_ID = "a";
    public static final String JSON_KEY_SH = "sh";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TK_TCP_PORT = "tk_tcp_port";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_UNIT_SIZE = "unit_size";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String KEY_IRLFA = "irlfa";
    private static final String TAG = "b";
    private String adHtml;
    private int adType;
    private String adZip;
    public ArrayList<CampaignEx> ads;
    private String bannerHtml;
    private String bannerUrl;
    private String csp;
    private String domain;
    private double ecppv;
    private HashMap<String, String> epMap;
    private String htmlUrl;
    private String ia_all_ext1;
    private String ia_all_ext2;
    private String ia_icon;
    private int ia_ori;
    private int ia_rst;
    private String ia_url;
    private int jmDo;
    private List<Frame> listFrames;
    private String localRequestId;
    private com.mbridge.msdk.foundation.same.report.d.b metricsData;
    private String onlyImpressionUrl;
    private String parentSessionId;
    private String requestId;
    private HashMap<String, String> rks;
    private String sessionId;

    /* JADX INFO: renamed from: sh, reason: collision with root package name */
    private String f44243sh;
    private int template;
    private int tokenRule;
    private String unitSize;
    private int vcn;
    protected StringBuffer cParams = new StringBuffer();
    private String encryptPrice = "";
    private String msg = "";

    private static void getSysIDAndBKUPID(JSONObject jSONObject) {
        FastKV fastKVBuild;
        com.mbridge.msdk.foundation.controller.d.a();
        try {
            fastKVBuild = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), x.a("H+tU+FeXHM==")).build();
        } catch (Exception unused) {
            fastKVBuild = null;
        }
        if (fastKVBuild != null) {
            try {
                Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                if (jSONObject == null || contextC == null) {
                    return;
                }
                String strOptString = jSONObject.optString("b");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.U, strOptString)) {
                    com.mbridge.msdk.foundation.same.a.U = strOptString;
                    com.mbridge.msdk.foundation.a.a.a.a().a("b", com.mbridge.msdk.foundation.same.a.U);
                    try {
                        fastKVBuild.putString(x.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.U);
                    } catch (Exception unused2) {
                    }
                }
                String strOptString2 = jSONObject.optString("c");
                if (TextUtils.isEmpty(strOptString2) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.f44371g, strOptString2)) {
                    return;
                }
                com.mbridge.msdk.foundation.same.a.f44371g = strOptString2;
                com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f44371g);
                try {
                    fastKVBuild.putString(x.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f44371g);
                    return;
                } catch (Exception unused3) {
                    return;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
        try {
            Context contextC2 = com.mbridge.msdk.foundation.controller.c.m().c();
            if (jSONObject == null || contextC2 == null) {
                return;
            }
            String strOptString3 = jSONObject.optString("b");
            if (!TextUtils.isEmpty(strOptString3) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.U, strOptString3)) {
                com.mbridge.msdk.foundation.same.a.U = strOptString3;
                com.mbridge.msdk.foundation.a.a.a.a().a("b", com.mbridge.msdk.foundation.same.a.U);
                SharedPreferences sharedPreferences = contextC2.getSharedPreferences(x.a("H+tU+FeXHM=="), 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString(x.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.U);
                    editorEdit.apply();
                }
            }
            String strOptString4 = jSONObject.optString("c");
            if (TextUtils.isEmpty(strOptString4) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.f44371g, strOptString4)) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.f44371g = strOptString4;
            com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f44371g);
            SharedPreferences sharedPreferences2 = contextC2.getSharedPreferences(x.a("H+tU+FeXHM=="), 0);
            if (sharedPreferences2 != null) {
                SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
                editorEdit2.putString(x.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f44371g);
                editorEdit2.apply();
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject) {
        return parseCampaignUnit(jSONObject, "");
    }

    /* JADX WARN: Code duplicated, block: B:58:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:62:0x02fb A[Catch: Exception -> 0x038e, TryCatch #1 {Exception -> 0x038e, blocks: (B:60:0x02f5, B:62:0x02fb, B:63:0x0301, B:65:0x0307), top: B:85:0x02f5 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0307 A[Catch: Exception -> 0x038e, TRY_LEAVE, TryCatch #1 {Exception -> 0x038e, blocks: (B:60:0x02f5, B:62:0x02fb, B:63:0x0301, B:65:0x0307), top: B:85:0x02f5 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0346 A[Catch: Exception -> 0x0372, TryCatch #8 {Exception -> 0x0372, blocks: (B:67:0x0340, B:69:0x0346, B:72:0x037b, B:71:0x0374, B:74:0x0390), top: B:99:0x0340 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0374 A[Catch: Exception -> 0x0372, TryCatch #8 {Exception -> 0x0372, blocks: (B:67:0x0340, B:69:0x0346, B:72:0x037b, B:71:0x0374, B:74:0x0390), top: B:99:0x0340 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x038e A[PHI: r12
  0x038e: PHI (r12v20 com.mbridge.msdk.foundation.entity.CampaignUnit) = 
  (r12v9 com.mbridge.msdk.foundation.entity.CampaignUnit)
  (r12v21 com.mbridge.msdk.foundation.entity.CampaignUnit)
  (r12v22 com.mbridge.msdk.foundation.entity.CampaignUnit)
  (r12v21 com.mbridge.msdk.foundation.entity.CampaignUnit)
 binds: [B:56:0x02dc, B:59:0x02f3, B:80:0x038e, B:61:0x02f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:85:0x02f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject, String str) {
        CampaignUnit campaignUnit;
        ArrayList arrayList;
        CampaignUnit campaignUnit2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        ArrayList<CampaignEx> arrayList2;
        int i11;
        String str11;
        String str12;
        String str13;
        CampaignEx campaign;
        String str14;
        String str15;
        JSONObject jSONObject2 = jSONObject;
        String str16 = JSON_KEY_ADS;
        String str17 = "template";
        String str18 = CampaignEx.JSON_KEY_ECPPV;
        String str19 = JSON_KEY_ONLY_IMPRESSION_URL;
        String str20 = JSON_KEY_HTML_URL;
        if (jSONObject2 != null) {
            try {
                CampaignUnit campaignUnit3 = new CampaignUnit();
                try {
                    String strOptString = jSONObject2.optString(JSON_KEY_RKS);
                    if (!TextUtils.isEmpty(strOptString)) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(strOptString);
                            Iterator<String> itKeys = jSONObject3.keys();
                            HashMap<String, String> map = new HashMap<>();
                            while (itKeys != null && itKeys.hasNext()) {
                                String next = itKeys.next();
                                map.put(next, jSONObject3.optString(next));
                            }
                            campaignUnit3.setRks(map);
                        } catch (Exception unused) {
                            return campaignUnit3;
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        HashMap<String, String> map2 = new HashMap<>();
                        map2.put("encrypt_p", "");
                        map2.put(KEY_IRLFA, "");
                        campaignUnit3.setEpMap(map2);
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(JSON_KEY_REQ_EXT_DATA);
                    int iOptInt = jSONObject2.optInt(JSON_KEY_NSCPT, 1);
                    String strOptString2 = jSONObject2.optString(JSON_KEY_MOF_TEMPLATE_URL, "");
                    int iOptInt2 = jSONObject2.optInt(JSON_KEY_MOF_TPLID, 0);
                    String string = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : "";
                    new JSONArray();
                    JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("pv_urls");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                        for (int i12 = 0; i12 < jSONArrayOptJSONArray.length(); i12++) {
                            arrayList.add(jSONArrayOptJSONArray.getString(i12));
                        }
                    }
                    com.mbridge.msdk.foundation.db.a.a.a().a(jSONObject2.optJSONObject(JSON_KEY_REPLACE_TMP), true);
                    getSysIDAndBKUPID(jSONObject);
                    campaignUnit3.setSessionId(jSONObject2.optString("a"));
                    campaignUnit3.setParentSessionId(jSONObject2.optString(JSON_KEY_PARENT_SESSION_ID));
                    campaignUnit3.setAdType(jSONObject2.optInt("ad_type"));
                    campaignUnit3.setUnitSize(jSONObject2.optString(JSON_KEY_UNIT_SIZE));
                    campaignUnit3.setHtmlUrl(jSONObject2.optString(JSON_KEY_HTML_URL));
                    campaignUnit3.setOnlyImpressionUrl(jSONObject2.optString(JSON_KEY_ONLY_IMPRESSION_URL));
                    campaignUnit3.setEcppv(jSONObject2.optDouble(CampaignEx.JSON_KEY_ECPPV));
                    campaignUnit3.setTemplate(jSONObject2.optInt("template"));
                    campaignUnit3.setJmDo(jSONObject2.optInt(JSON_KEY_JM_DO));
                    campaignUnit3.setIa_icon(jSONObject2.optString("ia_icon"));
                    campaignUnit3.setIa_rst(jSONObject2.optInt("ia_rst"));
                    campaignUnit3.setIa_url(jSONObject2.optString("ia_url"));
                    campaignUnit3.setIa_ori(jSONObject2.optInt("ia_ori"));
                    campaignUnit3.setIa_all_ext1(jSONObject2.optString(JSON_KEY_IA_EXT1));
                    campaignUnit3.setIa_all_ext2(jSONObject2.optString(JSON_KEY_IA_EXT2));
                    campaignUnit3.setVcn(jSONObject2.optInt("vcn"));
                    campaignUnit3.setTokenRule(jSONObject2.optInt("token_r"));
                    campaignUnit3.setEncryptPrice(jSONObject2.optString("encrypt_p"));
                    JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray(JSON_KEY_ADS);
                    JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray(JSON_KEY_FRAME_ADS);
                    String str21 = "web env is not support";
                    String str22 = JSON_KEY_END_SCREEN_URL;
                    if (jSONArrayOptJSONArray3 != null) {
                        try {
                            if (jSONArrayOptJSONArray3.length() > 0) {
                                ArrayList arrayList3 = new ArrayList();
                                String str23 = "web env is not support";
                                int i13 = iOptInt2;
                                int i14 = 0;
                                while (i14 < jSONArrayOptJSONArray3.length()) {
                                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray3.optJSONObject(i14);
                                    int i15 = i14;
                                    JSONArray jSONArray = jSONObjectOptJSONObject2.getJSONArray(str16);
                                    String str24 = str16;
                                    ArrayList arrayList4 = new ArrayList();
                                    String str25 = str17;
                                    JSONObject jSONObject4 = jSONObjectOptJSONObject2;
                                    int i16 = 0;
                                    while (i16 < jSONArray.length()) {
                                        JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i16);
                                        String strOptString3 = jSONObject2.optString(str19);
                                        String strOptString4 = jSONObject2.optString(str20);
                                        String strOptString5 = jSONObject2.optString(str22);
                                        String strOptString6 = jSONObject2.optString(str18);
                                        String str26 = str22;
                                        String str27 = str23;
                                        JSONObject jSONObject5 = jSONObject4;
                                        String str28 = string;
                                        JSONArray jSONArray2 = jSONArrayOptJSONArray3;
                                        String str29 = str18;
                                        int i17 = iOptInt;
                                        String str30 = str20;
                                        ArrayList arrayList5 = arrayList3;
                                        String str31 = str19;
                                        JSONArray jSONArray3 = jSONArray;
                                        int i18 = i13;
                                        CampaignUnit campaignUnit4 = campaignUnit3;
                                        try {
                                            CampaignEx campaign2 = CampaignEx.parseCampaign(jSONObjectOptJSONObject3, strOptString3, strOptString4, strOptString5, false, campaignUnit3, str, strOptString6);
                                            if (campaign2 != null) {
                                                try {
                                                    campaign2.setKeyIaUrl(campaignUnit4.getIa_url());
                                                    campaign2.setKeyIaOri(campaignUnit4.getIa_ori());
                                                    campaign2.setKeyIaRst(campaignUnit4.getIa_rst());
                                                    campaign2.setKeyIaIcon(campaignUnit4.getIa_icon());
                                                    campaign2.setAdType(jSONObject2.optInt("ad_type"));
                                                    campaign2.setIa_ext1(jSONObject2.optString(CampaignEx.KEY_IA_EXT1));
                                                    campaign2.setIa_ext2(jSONObject2.optString(CampaignEx.KEY_IA_EXT2));
                                                    campaign2.setVcn(campaignUnit4.getVcn());
                                                    campaign2.setTokenRule(campaignUnit4.getTokenRule());
                                                    campaign2.setEncryptPrice(campaignUnit4.getEncryptPrice());
                                                    campaign2.setMof_tplid(i18);
                                                    str2 = strOptString2;
                                                    campaign2.setMof_template_url(str2);
                                                    campaign2.setNscpt(i17);
                                                    campaign2.setPv_urls(arrayList);
                                                    str3 = str28;
                                                    campaign2.setReq_ext_data(str3);
                                                    arrayList4.add(campaign2);
                                                    campaignUnit2 = campaignUnit4;
                                                    str4 = str27;
                                                } catch (Exception unused2) {
                                                    return campaignUnit4;
                                                }
                                            } else {
                                                str2 = strOptString2;
                                                campaignUnit2 = campaignUnit4;
                                                str4 = str27;
                                                str3 = str28;
                                                campaignUnit2.setMsg(str4);
                                            }
                                            try {
                                                i16++;
                                                i13 = i18;
                                                arrayList3 = arrayList5;
                                                str23 = str4;
                                                strOptString2 = str2;
                                                str20 = str30;
                                                str19 = str31;
                                                str22 = str26;
                                                iOptInt = i17;
                                                campaignUnit3 = campaignUnit2;
                                                jSONArrayOptJSONArray3 = jSONArray2;
                                                str18 = str29;
                                                jSONObject4 = jSONObject5;
                                                string = str3;
                                                jSONArray = jSONArray3;
                                            } catch (Exception unused3) {
                                                return campaignUnit2;
                                            }
                                        } catch (Exception unused4) {
                                            campaignUnit2 = campaignUnit4;
                                            return campaignUnit2;
                                        }
                                    }
                                    String str32 = string;
                                    JSONObject jSONObject6 = jSONObject4;
                                    String str33 = str18;
                                    int i19 = iOptInt;
                                    String str34 = str20;
                                    ArrayList arrayList6 = arrayList3;
                                    Frame frame = new Frame();
                                    frame.setParentSessionId(jSONObject2.optString(JSON_KEY_PARENT_SESSION_ID));
                                    frame.setSessionId(jSONObject2.optString("a"));
                                    frame.setCampaigns(arrayList4);
                                    frame.setTemplate(jSONObject6.optInt(str25));
                                    arrayList6.add(frame);
                                    i13 = i13;
                                    arrayList3 = arrayList6;
                                    str23 = str23;
                                    strOptString2 = strOptString2;
                                    str20 = str34;
                                    str19 = str19;
                                    str22 = str22;
                                    iOptInt = i19;
                                    campaignUnit3 = campaignUnit3;
                                    jSONArrayOptJSONArray3 = jSONArrayOptJSONArray3;
                                    str18 = str33;
                                    string = str32;
                                    i14 = i15 + 1;
                                    str17 = str25;
                                    str16 = str24;
                                }
                                campaignUnit2 = campaignUnit3;
                                campaignUnit2.setListFrames(arrayList3);
                            } else {
                                str5 = CampaignEx.JSON_KEY_ECPPV;
                                str6 = JSON_KEY_ONLY_IMPRESSION_URL;
                                str7 = JSON_KEY_END_SCREEN_URL;
                                campaignUnit2 = campaignUnit3;
                                str8 = strOptString2;
                                str9 = string;
                                str10 = JSON_KEY_HTML_URL;
                                if (jSONArrayOptJSONArray2 == null) {
                                    try {
                                        if (jSONArrayOptJSONArray2.length() > 0) {
                                            arrayList2 = new ArrayList<>();
                                            i11 = 0;
                                            while (i11 < jSONArrayOptJSONArray2.length()) {
                                                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i11);
                                                String str35 = str6;
                                                String strOptString7 = jSONObject2.optString(str35);
                                                String str36 = str10;
                                                String strOptString8 = jSONObject2.optString(str36);
                                                str11 = str9;
                                                String str37 = str7;
                                                String strOptString9 = jSONObject2.optString(str37);
                                                String str38 = str5;
                                                str12 = str21;
                                                campaignUnit = campaignUnit2;
                                                JSONArray jSONArray4 = jSONArrayOptJSONArray2;
                                                str13 = str8;
                                                try {
                                                    campaign = CampaignEx.parseCampaign(jSONObjectOptJSONObject4, strOptString7, strOptString8, strOptString9, false, campaignUnit, str, jSONObject2.optString(str38));
                                                    if (campaign != null) {
                                                        campaign.setMof_tplid(iOptInt2);
                                                        str15 = str13;
                                                        campaign.setMof_template_url(str15);
                                                        campaign.setNscpt(iOptInt);
                                                        campaign.setPv_urls(arrayList);
                                                        campaign.setReq_ext_data(str11);
                                                        campaign.setVcn(campaignUnit.getVcn());
                                                        campaign.setTokenRule(campaignUnit.getTokenRule());
                                                        campaign.setEncryptPrice(campaignUnit.getEncryptPrice());
                                                        arrayList2.add(campaign);
                                                        str14 = str12;
                                                    } else {
                                                        str14 = str12;
                                                        str15 = str13;
                                                        campaignUnit.setMsg(str14);
                                                    }
                                                    i11++;
                                                    str9 = str11;
                                                    str6 = str35;
                                                    campaignUnit2 = campaignUnit;
                                                    str10 = str36;
                                                    jSONArrayOptJSONArray2 = jSONArray4;
                                                    str8 = str15;
                                                    str5 = str38;
                                                    str7 = str37;
                                                    jSONObject2 = jSONObject;
                                                    str21 = str14;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            campaignUnit = campaignUnit2;
                                            campaignUnit.setAds(arrayList2);
                                        }
                                    } catch (Exception unused6) {
                                    }
                                }
                            }
                            campaignUnit = campaignUnit2;
                        } catch (Exception unused7) {
                            campaignUnit2 = campaignUnit3;
                        }
                    } else {
                        str5 = CampaignEx.JSON_KEY_ECPPV;
                        str6 = JSON_KEY_ONLY_IMPRESSION_URL;
                        str7 = JSON_KEY_END_SCREEN_URL;
                        campaignUnit2 = campaignUnit3;
                        str8 = strOptString2;
                        str9 = string;
                        str10 = JSON_KEY_HTML_URL;
                        if (jSONArrayOptJSONArray2 == null) {
                            campaignUnit = campaignUnit2;
                        } else if (jSONArrayOptJSONArray2.length() > 0) {
                            arrayList2 = new ArrayList<>();
                            i11 = 0;
                            while (i11 < jSONArrayOptJSONArray2.length()) {
                                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i11);
                                String str39 = str6;
                                String strOptString10 = jSONObject2.optString(str39);
                                String str310 = str10;
                                String strOptString11 = jSONObject2.optString(str310);
                                str11 = str9;
                                String str311 = str7;
                                String strOptString12 = jSONObject2.optString(str311);
                                String str312 = str5;
                                str12 = str21;
                                campaignUnit = campaignUnit2;
                                JSONArray jSONArray5 = jSONArrayOptJSONArray2;
                                str13 = str8;
                                campaign = CampaignEx.parseCampaign(jSONObjectOptJSONObject5, strOptString10, strOptString11, strOptString12, false, campaignUnit, str, jSONObject2.optString(str312));
                                if (campaign != null) {
                                    campaign.setMof_tplid(iOptInt2);
                                    str15 = str13;
                                    campaign.setMof_template_url(str15);
                                    campaign.setNscpt(iOptInt);
                                    campaign.setPv_urls(arrayList);
                                    campaign.setReq_ext_data(str11);
                                    campaign.setVcn(campaignUnit.getVcn());
                                    campaign.setTokenRule(campaignUnit.getTokenRule());
                                    campaign.setEncryptPrice(campaignUnit.getEncryptPrice());
                                    arrayList2.add(campaign);
                                    str14 = str12;
                                } else {
                                    str14 = str12;
                                    str15 = str13;
                                    campaignUnit.setMsg(str14);
                                }
                                i11++;
                                str9 = str11;
                                str6 = str39;
                                campaignUnit2 = campaignUnit;
                                str10 = str310;
                                jSONArrayOptJSONArray2 = jSONArray5;
                                str8 = str15;
                                str5 = str312;
                                str7 = str311;
                                jSONObject2 = jSONObject;
                                str21 = str14;
                            }
                            campaignUnit = campaignUnit2;
                            campaignUnit.setAds(arrayList2);
                        } else {
                            campaignUnit = campaignUnit2;
                        }
                    }
                } catch (Exception unused8) {
                    campaignUnit = campaignUnit3;
                }
                return campaignUnit;
            } catch (Exception unused9) {
            }
        }
        return null;
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject) {
        return parseV5CampaignUnit(jSONObject, "");
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject, String str) {
        return parseCampaignUnit(jSONObject, str);
    }

    public abstract String assembCParams();

    public String getAdHtml() {
        return this.adHtml;
    }

    public int getAdType() {
        return this.adType;
    }

    public String getAdZip() {
        return this.adZip;
    }

    public ArrayList<CampaignEx> getAds() {
        return this.ads;
    }

    public String getBannerHtml() {
        return this.bannerHtml;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getCsp() {
        return this.csp;
    }

    public String getDomain() {
        return this.domain;
    }

    public double getEcppv() {
        return this.ecppv;
    }

    public String getEncryptPrice() {
        return this.encryptPrice;
    }

    public HashMap<String, String> getEpMap() {
        return this.epMap;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public String getIa_all_ext1() {
        return this.ia_all_ext1;
    }

    public String getIa_all_ext2() {
        return this.ia_all_ext2;
    }

    public String getIa_icon() {
        return this.ia_icon;
    }

    public int getIa_ori() {
        return this.ia_ori;
    }

    public int getIa_rst() {
        return this.ia_rst;
    }

    public String getIa_url() {
        return this.ia_url;
    }

    public int getJmDo() {
        return this.jmDo;
    }

    public List<Frame> getListFrames() {
        return this.listFrames;
    }

    public String getLocalRequestId() {
        return this.localRequestId;
    }

    public com.mbridge.msdk.foundation.same.report.d.b getMetricsData() {
        return this.metricsData;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getOnlyImpressionUrl() {
        return this.onlyImpressionUrl;
    }

    public String getParentSessionId() {
        return this.parentSessionId;
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionUrl)) {
                return "";
            }
            Uri uri = Uri.parse(this.onlyImpressionUrl);
            if (uri != null) {
                this.requestId = uri.getQueryParameter(CampaignEx.JSON_KEY_AD_K);
            }
            return this.requestId;
        } catch (Exception unused) {
            return "";
        }
    }

    public HashMap<String, String> getRks() {
        return this.rks;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSh() {
        return this.f44243sh;
    }

    public int getTemplate() {
        return this.template;
    }

    public int getTokenRule() {
        int i11 = this.tokenRule;
        if (i11 == 1) {
            return i11;
        }
        return 0;
    }

    public String getUnitSize() {
        return this.unitSize;
    }

    public int getVcn() {
        int i11 = this.vcn;
        if (i11 > 1) {
            return i11;
        }
        return 1;
    }

    public Object nullToEmpty(Object obj) {
        return obj == null ? "" : obj;
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public void setAdType(int i11) {
        this.adType = i11;
    }

    public void setAdZip(String str) {
        this.adZip = str;
    }

    public void setAds(ArrayList<CampaignEx> arrayList) {
        this.ads = arrayList;
    }

    public void setBannerHtml(String str) {
        this.bannerHtml = str;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setCsp(String str) {
        this.csp = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setEcppv(double d11) {
        this.ecppv = d11;
    }

    public void setEncryptPrice(String str) {
        this.encryptPrice = str;
    }

    public void setEpMap(HashMap<String, String> map) {
        this.epMap = map;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public void setIa_all_ext1(String str) {
        this.ia_all_ext1 = str;
    }

    public void setIa_all_ext2(String str) {
        this.ia_all_ext2 = str;
    }

    public void setIa_icon(String str) {
        this.ia_icon = str;
    }

    public void setIa_ori(int i11) {
        this.ia_ori = i11;
    }

    public void setIa_rst(int i11) {
        this.ia_rst = i11;
    }

    public void setIa_url(String str) {
        this.ia_url = str;
    }

    public void setJmDo(int i11) {
        this.jmDo = i11;
    }

    public void setListFrames(List<Frame> list) {
        this.listFrames = list;
    }

    public void setLocalRequestId(String str) {
        this.localRequestId = str;
        Iterator<CampaignEx> it = getAds().iterator();
        while (it.hasNext()) {
            it.next().setLocalRequestId(str);
        }
    }

    public void setMetricsData(com.mbridge.msdk.foundation.same.report.d.b bVar) {
        this.metricsData = bVar;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setOnlyImpressionUrl(String str) {
        this.onlyImpressionUrl = str;
    }

    public void setParentSessionId(String str) {
        this.parentSessionId = str;
    }

    public void setRks(HashMap<String, String> map) {
        this.rks = map;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSh(String str) {
        this.f44243sh = str;
    }

    public void setTemplate(int i11) {
        this.template = i11;
    }

    public void setTokenRule(int i11) {
        this.tokenRule = i11;
    }

    public void setUnitSize(String str) {
        this.unitSize = str;
    }

    public void setVcn(int i11) {
        this.vcn = i11;
    }
}
