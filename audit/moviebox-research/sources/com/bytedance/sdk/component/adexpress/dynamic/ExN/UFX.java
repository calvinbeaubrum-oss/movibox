package com.bytedance.sdk.component.adexpress.dynamic.ExN;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.pFF.Ql;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.component.utils.Tf;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UFX {
    private static String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final Set<String> f26739sc = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", CampaignEx.JSON_NATIVE_VIDEO_CLOSE, "close-fill", "webview-close")));

    public static double pFF(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString(TtmlNode.ATTR_TTS_FONT_SIZE));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static boolean pFF() {
        return !TextUtils.isEmpty(pFF);
    }

    public static int[] pFF(String str, float f11, boolean z11) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.We.sc());
            textView.setTextSize(f11);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z11) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    private static pFF.zY sc(pFF.zY zYVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            zYVar.f26744sc = 0.0f;
            zYVar.pFF = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = sc(str);
            }
            if (!TextUtils.isEmpty(str3)) {
                return sc(str3, str2);
            }
            zYVar.f26744sc = 0.0f;
            zYVar.pFF = 0.0f;
        }
        return zYVar;
    }

    public static pFF.zY sc(String str, String str2) {
        return sc(str, str2, false);
    }

    /* JADX WARN: Code duplicated, block: B:217:0x046f  */
    /* JADX WARN: Code duplicated, block: B:220:0x047d A[Catch: Exception -> 0x048f, TryCatch #0 {Exception -> 0x048f, blocks: (B:218:0x0473, B:220:0x047d, B:225:0x0487), top: B:269:0x0473 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x0483 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:224:0x0486  */
    public static pFF.zY sc(String str, String str2, String str3, boolean z11, boolean z12, int i11, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2, double d11, int i12, double d12, String str4, Ql ql2) {
        int i13;
        int i14;
        float f11;
        float f12;
        pFF.zY zYVarSc;
        int i15;
        com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN;
        String strOptString = str;
        int i16 = i11;
        String strWe = ql2.We();
        int iQr = ql2.qr();
        if (com.bytedance.sdk.component.adexpress.We.pFF() && i12 != 4 && (TextUtils.equals(str2, "text_star") || TextUtils.equals(str2, "score-count") || TextUtils.equals(str2, "score-count-type-1") || TextUtils.equals(str2, "score-count-type-2"))) {
            return new pFF.zY(0.0f, 0.0f);
        }
        pFF.zY zYVar = new pFF.zY();
        if (strOptString.startsWith("<svg") || f26739sc.contains(str2)) {
            try {
                if (CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equals(str2) || (com.bytedance.sdk.component.adexpress.We.pFF() && "close-fill".equals(str2))) {
                    float fOptDouble = (float) new JSONObject(str3).optDouble(TtmlNode.ATTR_TTS_FONT_SIZE);
                    zYVar.f26744sc = fOptDouble;
                    zYVar.pFF = fOptDouble;
                    return zYVar;
                }
            } catch (Exception unused) {
            }
            zYVar.f26744sc = 10.0f;
            zYVar.pFF = 10.0f;
            return zYVar;
        }
        if ("logo".equals(str2)) {
            if (!com.bytedance.sdk.component.adexpress.We.pFF() && ((!TextUtils.isEmpty(str) && strOptString.contains("adx:")) || pFF())) {
                return pFF() ? sc(zYVar, strOptString, str3, pFF) : sc(zYVar, strOptString, str3, "");
            }
            zYVar.f26744sc = "union".equals(strOptString) ? 10.0f : 20.0f;
            zYVar.pFF = 10.0f;
            if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                String str5 = str2 + strOptString;
                float fPFF = (float) pFF(str3);
                if (str5.contains("logoad")) {
                    return sc(Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_logo_en"), str3);
                }
                zYVar.pFF = fPFF;
            }
            return zYVar;
        }
        if ("development-name".equals(str2)) {
            strOptString = Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_text_privacy_development") + strOptString;
        }
        if ("app-version".equals(str2)) {
            strOptString = Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_text_privacy_app_version") + strOptString;
        }
        if ("score-count".equals(str2)) {
            try {
                i13 = Integer.parseInt(strOptString);
            } catch (NumberFormatException unused2) {
                i13 = 0;
            }
            if (com.bytedance.sdk.component.adexpress.We.pFF() && i13 < 0) {
                return new pFF.zY(0.0f, 0.0f);
            }
            return sc("(" + String.format(Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_comment_num"), Integer.valueOf(i13)) + ")", str3);
        }
        if ("score-count-type-2".equals(str2)) {
            try {
                i14 = Integer.parseInt(strOptString);
            } catch (NumberFormatException unused3) {
                i14 = 0;
            }
            if (com.bytedance.sdk.component.adexpress.We.pFF() && i14 < 0) {
                return new pFF.zY(0.0f, 0.0f);
            }
            return sc("(" + String.format(new DecimalFormat("###,###,###").format(i14), Integer.valueOf(i14)) + ")", str3);
        }
        if ("feedback-dislike".equals(str2)) {
            if (!com.bytedance.sdk.component.adexpress.We.pFF()) {
                return sc(Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_reward_feedback"), str3);
            }
            pFF.zY zYVar2 = new pFF.zY();
            float fPFF2 = (float) pFF(str3);
            zYVar2.f26744sc = fPFF2;
            zYVar2.pFF = fPFF2;
            return zYVar2;
        }
        if ("skip-with-time-countdown".equals(str2) || TextUtils.equals("skip-with-countdowns-video-countdown", str2)) {
            if (!ql2.sc() || !com.bytedance.sdk.component.adexpress.We.qr.pFF(strWe)) {
                return d11 < 10.0d ? sc("0S", str3) : sc("00S", str3);
            }
            if (((int) (d11 + 0.5d)) - iQr < 10) {
                return com.bytedance.sdk.component.adexpress.We.pFF() ? sc("0s", str3) : sc(String.format(Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_reward_full_skip"), "0"), str3);
            }
            return com.bytedance.sdk.component.adexpress.We.pFF() ? sc("00s", str3) : sc(String.format(Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_reward_full_skip"), "00"), str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-btn", str2)) {
            return sc("| " + Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_reward_screen_skip_tx"), str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-countdown", str2)) {
            return sc("| ".concat(String.valueOf(String.format(Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_reward_full_skip_count_down"), "00"))), str3);
        }
        if ("skip-with-time-skip-btn".equals(str2)) {
            pFF.zY zYVarSc2 = sc("| " + Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_reward_screen_skip_tx"), str3);
            if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                try {
                    zYVarSc2.pFF = (float) ((((double) zYVarSc2.pFF) * new JSONObject(str3).optDouble("lineHeight")) / 1.2d);
                } catch (Throwable unused4) {
                }
                zYVarSc2.f26744sc = zYVarSc2.pFF;
            }
            return zYVarSc2;
        }
        if ("skip".equals(str2)) {
            return sc(Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_reward_screen_skip_tx"), str3);
        }
        if ("timedown".equals(str2)) {
            return sc("0.0", str3);
        }
        if ("text_star".equals(str2)) {
            return (!com.bytedance.sdk.component.adexpress.We.pFF() || (d12 >= 0.0d && d12 <= 5.0d)) ? sc("0.0", str3) : new pFF.zY(0.0f, 0.0f);
        }
        if (TextUtils.equals("privacy-detail", str2)) {
            return sc("Permission list | Privacy policy", str3);
        }
        if ("arrowButton".equals(str2)) {
            return sc("Download", str3);
        }
        if (MimeTypes.BASE_TYPE_TEXT.equals(str2) && com.bytedance.sdk.component.adexpress.We.pFF() && TextUtils.isEmpty(strOptString) && (triExN = qj2.WH().ExN()) != null) {
            strOptString = triExN.DNB() != null ? qj2.WH().ExN().DNB().optString(com.bytedance.sdk.component.adexpress.We.Qj.zY(com.bytedance.sdk.component.adexpress.We.sc())) : "";
        }
        if ("fillButton".equals(str2) || MimeTypes.BASE_TYPE_TEXT.equals(str2) || "button".equals(str2) || "downloadWithIcon".equals(str2) || "downloadButton".equals(str2) || "laceButton".equals(str2) || "cardButton".equals(str2) || "colourMixtureButton".equals(str2) || "arrowButton".equals(str2) || (("source".equals(str2) && !(com.bytedance.sdk.component.adexpress.We.pFF() && "open_ad".equals(strWe))) || TextUtils.equals("app-version", str2) || TextUtils.equals("development-name", str2))) {
            return sc(strOptString, str3);
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int length = strOptString.length();
            float fOptDouble2 = (float) jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE);
            float fOptDouble3 = (float) jSONObject.optDouble("letterSpacing");
            float fOptDouble4 = (float) jSONObject.optDouble("lineHeight");
            float fOptDouble5 = (float) jSONObject.optDouble("maxWidth");
            float f13 = (length * (fOptDouble2 + fOptDouble3)) - fOptDouble3;
            Tf.sc("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + fOptDouble3 + ",lineHeight==" + fOptDouble4 + ",maxWidth ==" + fOptDouble5 + ",totalStrLength" + f13);
            if ("muted".equals(str2)) {
                zYVar.f26744sc = fOptDouble2;
                zYVar.pFF = fOptDouble2;
                return zYVar;
            }
            if ("star".equals(str2)) {
                if (com.bytedance.sdk.component.adexpress.We.pFF() && (d12 < 0.0d || d12 > 5.0d || i12 != 4)) {
                    return new pFF.zY(0.0f, 0.0f);
                }
                pFF.zY zYVarSc3 = sc("str", str3);
                zYVarSc3.f26744sc = fOptDouble2 * 5.0f;
                return zYVarSc3;
            }
            if (RewardPlus.ICON.equals(str2)) {
                zYVar.f26744sc = fOptDouble2;
                zYVar.pFF = fOptDouble2;
                return zYVar;
            }
            if (!z11) {
                f11 = (float) (((double) (fOptDouble4 * fOptDouble2)) * 1.2d);
                if (f13 <= fOptDouble5) {
                    f12 = f13;
                }
                if (CampaignEx.JSON_KEY_TITLE.equals(str2) || (com.bytedance.sdk.component.adexpress.We.pFF() && "open_ad".equals(strWe) && "source".equals(str2))) {
                    try {
                        zYVarSc = sc(strOptString.replace('\n', ' '), str3, false);
                        if (z11) {
                            i15 = ((int) (f13 / fOptDouble5)) + 1;
                            if (z12 || i15 < i16) {
                                i16 = i15;
                            }
                            zYVarSc.pFF *= i16;
                        }
                        return zYVarSc;
                    } catch (Exception unused5) {
                    }
                }
                zYVar.f26744sc = f12;
                zYVar.pFF = f11;
                return zYVar;
            }
            int i17 = ((int) (f13 / fOptDouble5)) + 1;
            if (z12 && i17 >= i16) {
                i17 = i16;
            }
            f11 = (float) (((double) (fOptDouble4 * fOptDouble2 * i17)) * 1.2d);
            f12 = fOptDouble5;
            if (CampaignEx.JSON_KEY_TITLE.equals(str2)) {
                zYVarSc = sc(strOptString.replace('\n', ' '), str3, false);
                if (z11) {
                    i15 = ((int) (f13 / fOptDouble5)) + 1;
                    if (z12) {
                        i16 = i15;
                    } else {
                        i16 = i15;
                    }
                    zYVarSc.pFF *= i16;
                }
                return zYVarSc;
            }
            zYVarSc = sc(strOptString.replace('\n', ' '), str3, false);
            if (z11) {
                i15 = ((int) (f13 / fOptDouble5)) + 1;
                if (z12) {
                    i16 = i15;
                } else {
                    i16 = i15;
                }
                zYVarSc.pFF *= i16;
            }
            return zYVarSc;
            return zYVar;
        } catch (JSONException unused6) {
        }
    }

    public static pFF.zY sc(String str, String str2, boolean z11) {
        pFF.zY zYVar = new pFF.zY();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] iArrSc = sc(str, (float) pFF(str2), z11);
            zYVar.f26744sc = iArrSc[0];
            zYVar.pFF = iArrSc[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                zYVar.pFF = 0.0f;
            }
        } catch (Exception unused) {
        }
        return zYVar;
    }

    public static String sc() {
        return pFF;
    }

    public static String sc(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    public static int[] sc(String str, float f11, boolean z11) {
        int[] iArrPFF = pFF(str, f11, z11);
        return new int[]{com.bytedance.sdk.component.adexpress.We.Qj.pFF(com.bytedance.sdk.component.adexpress.We.sc(), iArrPFF[0]), com.bytedance.sdk.component.adexpress.We.Qj.pFF(com.bytedance.sdk.component.adexpress.We.sc(), iArrPFF[1])};
    }
}
