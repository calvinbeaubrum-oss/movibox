package com.bytedance.sdk.component.adexpress.dynamic.We;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final Map<String, Integer> f26747sc;
    private TRI ExN;
    private String TRI;
    private TRI We;
    private String pFF;
    private String zY;

    static {
        HashMap map = new HashMap();
        f26747sc = map;
        map.put("root", 8);
        map.put("footer", 6);
        map.put("empty", 6);
        map.put(CampaignEx.JSON_KEY_TITLE, 0);
        map.put("subtitle", 0);
        map.put("source", 0);
        map.put("score-count", 0);
        map.put("text_star", 0);
        map.put(MimeTypes.BASE_TYPE_TEXT, 0);
        map.put("tag-group", 17);
        map.put("app-version", 0);
        map.put("development-name", 0);
        map.put("privacy-detail", 23);
        map.put("image", 1);
        map.put("image-wide", 1);
        map.put("image-square", 1);
        map.put("image-long", 1);
        map.put("image-splash", 1);
        map.put("image-cover", 1);
        map.put("app-icon", 1);
        map.put("icon-download", 1);
        map.put("logoad", 4);
        map.put("logounion", 5);
        map.put("logo-union", 9);
        map.put("dislike", 3);
        map.put(CampaignEx.JSON_NATIVE_VIDEO_CLOSE, 3);
        map.put("close-fill", 3);
        map.put("webview-close", 22);
        map.put("feedback-dislike", 12);
        map.put("button", 2);
        map.put("downloadWithIcon", 2);
        map.put("downloadButton", 2);
        map.put("fillButton", 2);
        map.put("laceButton", 2);
        map.put("cardButton", 2);
        map.put("colourMixtureButton", 2);
        map.put("arrowButton", 1);
        map.put("download-progress-button", 2);
        map.put("vessel", 6);
        map.put("image-group", 6);
        map.put("custom-component-vessel", 6);
        map.put("carousel", 24);
        map.put("carousel-vessel", 26);
        map.put("leisure-interact", 25);
        map.put("video-hd", 7);
        map.put("video", 7);
        map.put("video-vd", 7);
        map.put("video-sq", 7);
        map.put("muted", 10);
        map.put("star", 11);
        map.put("skip-countdowns", 19);
        map.put("skip-with-countdowns-skip-btn", 21);
        map.put("skip-with-countdowns-video-countdown", 13);
        map.put("skip-with-countdowns-skip-countdown", 20);
        map.put("skip-with-time", 14);
        map.put("skip-with-time-countdown", 13);
        map.put("skip-with-time-skip-btn", 15);
        map.put("skip", 27);
        map.put("timedown", 13);
        map.put(RewardPlus.ICON, 16);
        map.put("scoreCountWithIcon", 6);
        map.put("split-line", 18);
        map.put("creative-playable-bait", 0);
        map.put("score-count-type-2", 0);
        map.put("lottie", 28);
    }

    public TRI ExN() {
        return this.We;
    }

    public int TRI() {
        return this.We.gsl();
    }

    public String We() {
        return this.TRI;
    }

    public String pFF() {
        return this.pFF;
    }

    public void pFF(TRI tri) {
        this.ExN = tri;
    }

    public void pFF(String str) {
        this.zY = str;
    }

    public TRI qr() {
        return this.ExN;
    }

    public int sc() {
        if (TextUtils.isEmpty(this.pFF)) {
            return 0;
        }
        if (this.pFF.equals("logo")) {
            String str = this.pFF + this.zY;
            this.pFF = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.pFF.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = f26747sc;
        if (map.get(this.pFF) != null) {
            return map.get(this.pFF).intValue();
        }
        return -1;
    }

    public void sc(TRI tri) {
        this.We = tri;
    }

    public void sc(String str) {
        this.pFF = str;
    }

    public String toString() {
        return "DynamicLayoutBrick{type='" + this.pFF + "', data='" + this.zY + "', value=" + this.We + ", themeValue=" + this.ExN + ", dataExtraInfo='" + this.TRI + "'}";
    }

    public String zY() {
        return this.zY;
    }

    public void zY(String str) {
        this.TRI = str;
    }
}
