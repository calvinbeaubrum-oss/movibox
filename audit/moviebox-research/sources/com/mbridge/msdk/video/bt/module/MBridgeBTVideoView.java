package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.hisavana.common.tracking.TrackingKey;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.iab.omid.library.mmadbridge.adsession.media.Position;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerErrorConstant;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.widget.FeedBackButton;
import java.io.File;
import kn.b;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeBTVideoView extends BTBaseView {
    private static boolean K = false;
    private static long Q;
    private b A;
    private kn.a B;
    private com.iab.omid.library.mmadbridge.adsession.media.a C;
    private a D;
    private int E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private String J;
    private boolean L;
    private boolean M;
    private boolean N;
    private RelativeLayout O;
    private ProgressBar P;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private PlayerView f47466p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private SoundImageView f47467q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f47468r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private View f47469s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private FeedBackButton f47470t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ImageView f47471u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private WebView f47472v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f47473w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f47474x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f47475y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f47476z;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends DefaultVideoPlayerStatusListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MBridgeBTVideoView f47480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WebView f47481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.iab.omid.library.mmadbridge.adsession.media.a f47482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f47483d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f47484e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f47485f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f47486g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f47487h;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f47491l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f47492m;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f47488i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f47489j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f47490k = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f47493n = false;

        public a(MBridgeBTVideoView mBridgeBTVideoView, WebView webView, com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
            this.f47480a = mBridgeBTVideoView;
            this.f47481b = webView;
            this.f47482c = aVar;
            if (mBridgeBTVideoView != null) {
                this.f47483d = mBridgeBTVideoView.f47376d;
                this.f47484e = mBridgeBTVideoView.f47375c;
            }
        }

        public final void a(int i11, int i12) {
            int i13;
            MBridgeBTVideoView mBridgeBTVideoView;
            CampaignEx campaignEx;
            String str;
            this.f47491l = i11;
            this.f47492m = i12;
            if (!af.a().a("h_c_r_w_p_c", false) || (i13 = this.f47491l) == 100 || this.f47492m != 0 || this.f47493n || i13 == 0 || (mBridgeBTVideoView = this.f47480a) == null || (campaignEx = mBridgeBTVideoView.f47374b) == null) {
                return;
            }
            try {
                if (campaignEx.getAdType() == 94 || this.f47480a.f47374b.getAdType() == 287) {
                    str = this.f47480a.f47374b.getRequestId() + this.f47480a.f47374b.getId() + this.f47480a.f47374b.getVideoUrlEncode();
                } else {
                    str = this.f47480a.f47374b.getId() + this.f47480a.f47374b.getVideoUrlEncode() + this.f47480a.f47374b.getBidToken();
                }
                com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f47484e, str);
                if (aVarA != null) {
                    aVarA.p();
                    this.f47493n = true;
                    if (MBridgeConstans.DEBUG) {
                        ad.b("DefaultVideoPlayerStatusListener", "CDRate is : 0  and start download when player create!");
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("DefaultVideoPlayerStatusListener", e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f47482c;
                if (aVar != null) {
                    aVar.b();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f47482c;
                if (aVar != null) {
                    aVar.c();
                }
                if ((str.equals(PlayerErrorConstant.PREPARE_TIMEOUT) || str.equals(PlayerErrorConstant.PLAYERING_TIMEOUT)) && this.f47481b != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(TrackingKey.CODE, BTBaseView.f47371n);
                        jSONObject.put("id", this.f47483d);
                        jSONObject.put("data", new JSONObject());
                        g.a().a(this.f47481b, "onPlayerTimeout", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e11) {
                        d.c().a(this.f47481b, e11.getMessage());
                    }
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayCompleted() {
            super.onPlayCompleted();
            MBridgeBTVideoView mBridgeBTVideoView = this.f47480a;
            CampaignEx campaignEx = mBridgeBTVideoView.f47374b;
            if (campaignEx == null) {
                mBridgeBTVideoView.f47468r.setText("0");
            } else if (campaignEx.getVideoCompleteTime() > 0) {
                this.f47480a.f47468r.setText(v.a(c.m().c(), "mbridge_reward_video_view_reward_time_complete", "string"));
            } else {
                this.f47480a.f47468r.setText("0");
            }
            this.f47480a.f47466p.setClickable(false);
            WebView webView = this.f47481b;
            if (webView != null) {
                BTBaseView.a(webView, "onPlayerFinish", this.f47483d);
            }
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f47482c;
            if (aVar != null) {
                aVar.d();
                ad.a("omsdk", "play:  videoEvents.complete()");
            }
            this.f47485f = this.f47486g;
            boolean unused = MBridgeBTVideoView.K = true;
            this.f47480a.stop();
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayError(String str) {
            super.onPlayError(str);
            if (this.f47481b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TrackingKey.CODE, BTBaseView.f47372o);
                    jSONObject.put("id", this.f47483d);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("error", str);
                    jSONObject2.put("id", this.f47483d);
                    jSONObject.put("data", jSONObject2);
                    g.a().a(this.f47481b, "onPlayerFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e11) {
                    d.c().a(this.f47481b, e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayProgress(int i11, int i12) {
            int i13;
            int i14;
            String str;
            int videoCompleteTime;
            StringBuilder sb2;
            String str2;
            String string;
            super.onPlayProgress(i11, i12);
            if (MBridgeBTVideoView.Q == 0) {
                long unused = MBridgeBTVideoView.Q = System.currentTimeMillis();
            }
            MBridgeBTVideoView mBridgeBTVideoView = this.f47480a;
            if (mBridgeBTVideoView.f47380h) {
                CampaignEx campaignEx = mBridgeBTVideoView.f47374b;
                if (campaignEx != null) {
                    videoCompleteTime = campaignEx.getVideoCompleteTime();
                    com.mbridge.msdk.foundation.d.b.a().b(this.f47480a.f47374b.getCampaignUnitId() + "_1", i11);
                } else {
                    videoCompleteTime = 0;
                }
                if (videoCompleteTime > i12 || videoCompleteTime <= 0) {
                    videoCompleteTime = i12;
                }
                int i15 = videoCompleteTime <= 0 ? i12 - i11 : videoCompleteTime - i11;
                if (i15 <= 0) {
                    string = videoCompleteTime <= 0 ? "0" : (String) this.f47480a.getContext().getResources().getText(v.a(c.m().c(), "mbridge_reward_video_view_reward_time_complete", "string"));
                } else {
                    if (videoCompleteTime <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append(i15);
                        str2 = "";
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(i15);
                        str2 = (String) this.f47480a.getContext().getResources().getText(v.a(c.m().c(), "mbridge_reward_video_view_reward_time_left", "string"));
                    }
                    sb2.append(str2);
                    string = sb2.toString();
                }
                CampaignEx campaignEx2 = this.f47480a.f47374b;
                if (campaignEx2 != null && campaignEx2.getUseSkipTime() == 1) {
                    int iMin = Math.min(this.f47480a.f47374b.getVst(), i12);
                    if (iMin >= videoCompleteTime || iMin < 0) {
                        int i16 = videoCompleteTime - i11;
                        if (this.f47480a.f47374b.getAdType() == 287) {
                            if (i16 > 0) {
                                string = i16 + ((String) this.f47480a.getContext().getResources().getText(v.a(c.m().c(), "mbridge_reward_video_view_reward_time_left_skip_time", "string")));
                            } else if (i16 == 0) {
                                this.f47480a.f47468r.setVisibility(4);
                            }
                        }
                    } else {
                        int i17 = iMin - i11;
                        if (i17 > 0) {
                            string = i17 + ((String) this.f47480a.getContext().getResources().getText(v.a(c.m().c(), "mbridge_reward_video_view_reward_time_left_skip_time", "string")));
                        } else if (this.f47480a.f47374b.getAdType() == 287 && i17 == 0) {
                            this.f47480a.f47468r.setVisibility(4);
                        }
                    }
                }
                this.f47480a.f47468r.setText(string);
            }
            this.f47486g = i12;
            this.f47485f = i11;
            this.f47480a.P.setMax(this.f47486g);
            this.f47480a.P.setProgress(this.f47485f);
            if (this.f47481b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TrackingKey.CODE, BTBaseView.f47371n);
                    jSONObject.put("id", this.f47483d);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", this.f47483d);
                    jSONObject2.put(NotificationCompat.CATEGORY_PROGRESS, MBridgeBTVideoView.b(i11, i12));
                    jSONObject2.put("time", String.valueOf(i11));
                    jSONObject2.put("duration", String.valueOf(i12));
                    jSONObject.put("data", jSONObject2);
                    g.a().a(this.f47481b, "onPlayerProgressChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e11) {
                    d.c().a(this.f47481b, e11.getMessage());
                }
            }
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f47482c;
            if (aVar != null) {
                int i18 = (i11 * 100) / i12;
                int i19 = ((i11 + 1) * 100) / i12;
                if (i18 <= 25 && 25 < i19 && !this.f47488i) {
                    this.f47488i = true;
                    aVar.h();
                    ad.a("omsdk", "play:  videoEvents.firstQuartile()");
                } else if (i18 <= 50 && 50 < i19 && !this.f47489j) {
                    this.f47489j = true;
                    aVar.i();
                    ad.a("omsdk", "play:  videoEvents.midpoint()");
                } else if (i18 <= 75 && 75 < i19 && !this.f47490k) {
                    this.f47490k = true;
                    aVar.o();
                    ad.a("omsdk", "play:  videoEvents.thirdQuartile()");
                }
            }
            try {
                int i21 = this.f47491l;
                if (i21 == 100 || this.f47493n || i21 == 0 || (i13 = this.f47492m) < 0 || i11 < (i14 = (i12 * i13) / 100)) {
                    return;
                }
                if (this.f47480a.f47374b.getAdType() == 94 || this.f47480a.f47374b.getAdType() == 287) {
                    str = this.f47480a.f47374b.getRequestId() + this.f47480a.f47374b.getId() + this.f47480a.f47374b.getVideoUrlEncode();
                } else {
                    str = this.f47480a.f47374b.getId() + this.f47480a.f47374b.getVideoUrlEncode() + this.f47480a.f47374b.getBidToken();
                }
                com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f47484e, str);
                if (aVarA != null) {
                    aVarA.p();
                    this.f47493n = true;
                    ad.b("DefaultVideoPlayerStatusListener", "CDRate is : " + i14 + " and start download !");
                }
            } catch (Exception e12) {
                ad.b("DefaultVideoPlayerStatusListener", e12.getMessage());
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayStarted(int i11) {
            super.onPlayStarted(i11);
            if (!this.f47487h) {
                this.f47480a.P.setMax(i11);
                WebView webView = this.f47481b;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPlay", this.f47483d);
                }
                this.f47487h = true;
            }
            boolean unused = MBridgeBTVideoView.K = false;
        }
    }

    public MBridgeBTVideoView(Context context) {
        super(context);
        this.f47474x = 0;
        this.f47475y = 0;
        this.f47476z = 0;
        this.E = 2;
        this.G = false;
        this.H = 2;
        this.I = 1;
        this.L = false;
        this.M = false;
        this.N = false;
    }

    public MBridgeBTVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47474x = 0;
        this.f47475y = 0;
        this.f47476z = 0;
        this.E = 2;
        this.G = false;
        this.H = 2;
        this.I = 1;
        this.L = false;
        this.M = false;
        this.N = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i11, int i12) {
        if (i12 != 0) {
            try {
                return ai.a(Double.valueOf(i11 / i12)) + "";
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return i12 + "";
    }

    private boolean c() {
        try {
            this.f47466p = (PlayerView) findViewById(findID("mbridge_vfpv"));
            this.f47467q = (SoundImageView) findViewById(findID("mbridge_sound_switch"));
            this.f47468r = (TextView) findViewById(findID("mbridge_tv_count"));
            this.f47469s = findViewById(findID("mbridge_rl_playing_close"));
            this.O = (RelativeLayout) findViewById(findID("mbridge_top_control"));
            this.P = (ProgressBar) findViewById(findID("mbridge_video_progress_bar"));
            this.f47466p.setIsBTVideo(true);
            this.f47470t = (FeedBackButton) findViewById(findID("mbridge_native_endcard_feed_btn"));
            this.f47471u = (ImageView) findViewById(findID("mbridge_iv_link"));
            return isNotNULL(this.f47466p, this.f47467q, this.f47468r, this.f47469s);
        } catch (Throwable th2) {
            ad.a(BTBaseView.TAG, th2.getMessage(), th2);
            return false;
        }
    }

    private String d() {
        String videoUrlEncode = "";
        try {
            videoUrlEncode = this.f47374b.getVideoUrlEncode();
            com.mbridge.msdk.videocommon.download.a aVar = this.f47473w;
            if (aVar == null) {
                return videoUrlEncode;
            }
            String strH = aVar.h();
            return (an.a(strH) || !new File(strH).exists()) ? videoUrlEncode : strH;
        } catch (Throwable th2) {
            ad.a(BTBaseView.TAG, th2.getMessage(), th2);
            return videoUrlEncode;
        }
    }

    private int e() {
        int iH = 5;
        try {
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            iH = aVarB != null ? (int) aVarB.h() : 5;
            ad.c(BTBaseView.TAG, "MBridgeBaseView buffetTimeout:" + iH);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return iH;
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public final void a() {
        super.a();
        if (this.f47380h) {
            this.f47467q.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    boolean zIsSilent = MBridgeBTVideoView.this.f47466p.isSilent();
                    if (MBridgeBTVideoView.this.f47472v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(TrackingKey.CODE, BTBaseView.f47371n);
                            jSONObject.put("id", MBridgeBTVideoView.this.f47376d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, MBridgeBTVideoView.this.E);
                            jSONObject.put("data", jSONObject2);
                            g.a().a(MBridgeBTVideoView.this.f47472v, "onPlayerMuteBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                            ad.a("OperateViews", "onPlayerMuteBtnClicked isMute = " + zIsSilent + " mute = " + MBridgeBTVideoView.this.E);
                        } catch (Exception e11) {
                            d.c().a(MBridgeBTVideoView.this.f47472v, e11.getMessage());
                        }
                    }
                }
            });
            this.f47469s.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBridgeBTVideoView.this.f47472v != null) {
                        BTBaseView.a(MBridgeBTVideoView.this.f47472v, "onPlayerCloseBtnClicked", MBridgeBTVideoView.this.f47376d);
                    }
                }
            });
            setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBridgeBTVideoView.this.C != null) {
                        MBridgeBTVideoView.this.C.a(InteractionType.CLICK);
                    }
                    if (MBridgeBTVideoView.this.f47472v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(TrackingKey.CODE, BTBaseView.f47371n);
                            jSONObject.put("id", MBridgeBTVideoView.this.f47376d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("x", String.valueOf(view.getX()));
                            jSONObject2.put("y", String.valueOf(view.getY()));
                            jSONObject.put("data", jSONObject2);
                            g.a().a(MBridgeBTVideoView.this.f47472v, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        } catch (Exception unused) {
                            d.c().a(MBridgeBTVideoView.this.f47472v, "onClicked", MBridgeBTVideoView.this.f47376d);
                        }
                    }
                }
            });
        }
    }

    public int getMute() {
        return this.E;
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void init(Context context) {
        int iFindLayout = findLayout("mbridge_reward_videoview_item");
        if (iFindLayout > 0) {
            this.f47378f.inflate(iFindLayout, this);
            boolean zC = c();
            this.f47380h = zC;
            if (!zC) {
                ad.b(BTBaseView.TAG, "MBridgeVideoView init fail");
            }
            a();
        }
        K = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View rootView;
        super.onAttachedToWindow();
        if (!this.N) {
            this.H = d.c().e(this.f47375c);
        }
        View view = this.f47469s;
        if (view != null) {
            view.setVisibility(this.f47475y == 0 ? 8 : 0);
        }
        SoundImageView soundImageView = this.f47467q;
        if (soundImageView != null) {
            soundImageView.setVisibility(this.f47476z == 0 ? 8 : 0);
        }
        CampaignEx campaignEx = this.f47374b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.f47375c);
            com.mbridge.msdk.foundation.d.b.a().a(this.f47375c + "_1", this.f47374b);
        }
        TextView textView = this.f47468r;
        if (textView != null) {
            textView.setVisibility(this.f47474x == 0 ? 8 : 0);
            if (this.f47468r.getVisibility() == 0 && com.mbridge.msdk.foundation.d.b.a().b()) {
                com.mbridge.msdk.foundation.d.b.a().a(this.f47375c + "_1", this.f47470t);
            }
        }
        if (this.A == null || (rootView = getRootView()) == null) {
            return;
        }
        this.A.f(rootView);
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void onDestory() {
        try {
            PlayerView playerView = this.f47466p;
            if (playerView != null) {
                playerView.setOnClickListener(null);
                this.f47466p.release();
                this.f47466p = null;
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("duration", Long.valueOf(System.currentTimeMillis() - Q));
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000146", this.f47374b, dVar);
            }
            SoundImageView soundImageView = this.f47467q;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(null);
            }
            View view = this.f47469s;
            if (view != null) {
                view.setOnClickListener(null);
            }
            if (this.f47472v != null) {
                this.f47472v = null;
            }
            if (this.A != null) {
                this.A = null;
            }
            if (this.C != null) {
                this.C = null;
            }
            setOnClickListener(null);
        } catch (Throwable th2) {
            ad.a(BTBaseView.TAG, th2.getMessage());
        }
    }

    public void onPause() {
        PlayerView playerView = this.f47466p;
        if (playerView != null) {
            boolean zIsPlayIng = playerView.isPlayIng();
            this.M = zIsPlayIng;
            this.f47466p.setIsBTVideoPlaying(zIsPlayIng);
            this.f47466p.onPause();
        }
    }

    public void onResume() {
        PlayerView playerView = this.f47466p;
        if (playerView != null) {
            playerView.setDesk(true);
            this.f47466p.setIsCovered(false);
            if (this.M) {
                this.f47466p.start(true);
            }
        }
    }

    public void onStop() {
        PlayerView playerView = this.f47466p;
        if (playerView != null) {
            playerView.setIsCovered(true);
        }
    }

    public void pause() {
        try {
            PlayerView playerView = this.f47466p;
            if (playerView != null) {
                playerView.pause();
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.C;
                if (aVar != null) {
                    aVar.j();
                    ad.a("omsdk", "play:  videoEvents.pause()");
                }
                WebView webView = this.f47472v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPause", this.f47376d);
                }
            }
        } catch (Exception e11) {
            ad.a(BTBaseView.TAG, e11.getMessage(), e11);
        }
    }

    public void play() {
        a aVar;
        CampaignEx campaignEx;
        try {
            if (this.N) {
                if (this.G) {
                    this.f47466p.playVideo(0);
                    this.G = false;
                } else {
                    this.f47466p.start(false);
                }
                try {
                    com.iab.omid.library.mmadbridge.adsession.media.a aVar2 = this.C;
                    if (aVar2 != null) {
                        aVar2.l();
                        ad.a("omsdk", "play:  videoEvents.resume()");
                    }
                } catch (IllegalArgumentException e11) {
                    ad.a(BTBaseView.TAG, e11.getMessage());
                }
                WebView webView = this.f47472v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPlay", this.f47376d);
                    return;
                }
                return;
            }
            String strD = d();
            this.J = strD;
            this.f47466p.initVFPData(strD, this.f47374b.getVideoUrlEncode(), this.D);
            if (this.H == 1) {
                playMute();
            } else {
                playUnMute();
            }
            try {
                kn.a aVar3 = this.B;
                if (aVar3 != null) {
                    aVar3.b();
                }
                if (this.C != null) {
                    float duration = this.f47466p.getDuration();
                    if (duration == 0.0f && (campaignEx = this.f47374b) != null) {
                        duration = campaignEx.getVideoLength();
                    }
                    this.C.n(duration, getMute() == 2 ? 1.0f : 0.0f);
                    ad.a("omsdk", "play: videoEvents.start()");
                }
            } catch (IllegalArgumentException e12) {
                ad.a(BTBaseView.TAG, e12.getMessage());
            }
            if (!this.f47466p.playVideo() && (aVar = this.D) != null) {
                aVar.onPlayError("play video failed");
            }
            this.N = true;
            return;
        } catch (Exception e13) {
            ad.a(BTBaseView.TAG, e13.getMessage(), e13);
        }
        ad.a(BTBaseView.TAG, e13.getMessage(), e13);
    }

    public boolean playMute() {
        try {
            PlayerView playerView = this.f47466p;
            if (playerView != null && this.f47472v != null) {
                playerView.closeSound();
                this.f47467q.setSoundStatus(false);
                this.E = 1;
                try {
                    com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.C;
                    if (aVar != null) {
                        aVar.p(0.0f);
                    }
                } catch (IllegalArgumentException e11) {
                    ad.a("OMSDK", e11.getMessage());
                }
                BTBaseView.a(this.f47472v, "onPlayerMute", this.f47376d);
                return true;
            }
        } catch (Exception e12) {
            ad.b(BTBaseView.TAG, e12.getMessage());
        }
        return false;
    }

    public boolean playUnMute() {
        try {
            PlayerView playerView = this.f47466p;
            if (playerView == null || this.f47472v == null) {
                return false;
            }
            playerView.openSound();
            this.f47467q.setSoundStatus(true);
            this.E = 2;
            try {
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.C;
                if (aVar != null) {
                    aVar.p(1.0f);
                }
            } catch (IllegalArgumentException e11) {
                ad.a("OMSDK", e11.getMessage());
            }
            BTBaseView.a(this.f47472v, "onUnmute", this.f47376d);
            return true;
        } catch (Exception e12) {
            ad.b(BTBaseView.TAG, e12.getMessage());
            return false;
        }
    }

    public void preLoadData() {
        String str;
        if (this.f47374b.getAdType() == 94 || this.f47374b.getAdType() == 287) {
            str = this.f47374b.getRequestId() + this.f47374b.getId() + this.f47374b.getVideoUrlEncode();
        } else {
            str = this.f47374b.getId() + this.f47374b.getVideoUrlEncode() + this.f47374b.getBidToken();
        }
        com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f47375c, str);
        if (aVarA != null) {
            this.f47473w = aVarA;
        }
        this.F = e();
        try {
            CampaignEx campaignEx = this.f47374b;
            if (campaignEx != null && campaignEx.isActiveOm()) {
                this.A = com.mbridge.msdk.a.b.a(getContext(), false, this.f47374b.getOmid(), this.f47374b.getRequestId(), this.f47374b.getId(), this.f47375c, "", this.f47374b.getRequestIdNotice());
            }
            b bVar = this.A;
            if (bVar != null) {
                PlayerView playerView = this.f47466p;
                if (playerView != null) {
                    bVar.d(playerView);
                }
                SoundImageView soundImageView = this.f47467q;
                if (soundImageView != null) {
                    this.A.a(soundImageView, FriendlyObstructionPurpose.OTHER, null);
                }
                TextView textView = this.f47468r;
                if (textView != null) {
                    this.A.a(textView, FriendlyObstructionPurpose.OTHER, null);
                }
                View view = this.f47469s;
                if (view != null) {
                    this.A.a(view, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
                }
                this.B = kn.a.a(this.A);
                this.C = com.iab.omid.library.mmadbridge.adsession.media.a.g(this.A);
                this.A.g();
                this.B.c(com.iab.omid.library.mmadbridge.adsession.media.b.b(true, Position.STANDALONE));
            }
        } catch (Throwable th2) {
            ad.a(BTBaseView.TAG, th2.getMessage());
        }
        String strD = d();
        this.J = strD;
        if (this.f47380h && !TextUtils.isEmpty(strD) && this.f47374b != null) {
            b bVar2 = this.A;
            if (bVar2 != null) {
                bVar2.d(this.f47466p);
                b bVar3 = this.A;
                SoundImageView soundImageView2 = this.f47467q;
                FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
                bVar3.a(soundImageView2, friendlyObstructionPurpose, null);
                this.A.a(this.f47468r, friendlyObstructionPurpose, null);
                this.A.a(this.f47469s, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
            }
            a aVar = new a(this, this.f47472v, this.C);
            this.D = aVar;
            CampaignEx campaignEx2 = this.f47374b;
            int iR = (campaignEx2 == null || campaignEx2.getReady_rate() == -1) ? com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.f47375c, false).r() : campaignEx2.getReady_rate();
            aVar.a(iR, com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.f47375c, false).s());
            this.f47466p.setDesk(false);
            this.f47466p.initBufferIngParam(this.F);
            soundOperate(this.E, -1, null);
        }
        K = false;
    }

    public void resume() {
        try {
            PlayerView playerView = this.f47466p;
            if (playerView != null) {
                if (this.G) {
                    playerView.playVideo(0);
                    this.G = false;
                } else {
                    playerView.onResume();
                }
                try {
                    com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.C;
                    if (aVar != null) {
                        aVar.l();
                        ad.a("omsdk", "play:  videoEvents.resume()");
                    }
                } catch (IllegalArgumentException e11) {
                    ad.a(BTBaseView.TAG, e11.getMessage());
                }
                WebView webView = this.f47472v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerResume", this.f47376d);
                }
            }
        } catch (Exception e12) {
            ad.b(BTBaseView.TAG, e12.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void setCampaign(CampaignEx campaignEx) {
        super.setCampaign(campaignEx);
        if (campaignEx == null || campaignEx.getVideoCompleteTime() <= 0) {
            this.f47468r.setBackgroundResource(v.a(c.m().c(), "mbridge_reward_shape_progress", "drawable"));
            this.f47468r.setWidth(ai.a(c.m().c(), 30.0f));
            return;
        }
        this.f47468r.setBackgroundResource(v.a(c.m().c(), "mbridge_reward_video_time_count_num_bg", "drawable"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ai.a(c.m().c(), 30.0f));
        int iA = ai.a(c.m().c(), 5.0f);
        layoutParams.setMargins(iA, 0, 0, 0);
        this.f47468r.setPadding(iA, 0, iA, 0);
        this.f47468r.setLayoutParams(layoutParams);
    }

    public void setCloseViewVisable(int i11) {
        this.f47469s.setVisibility(i11 == 0 ? 4 : 0);
    }

    public void setCountDownTextViewVisable(int i11) {
        this.f47468r.setVisibility(i11 == 0 ? 4 : 0);
    }

    public void setCreateWebView(WebView webView) {
        this.f47472v = webView;
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14) {
        if (i11 <= 0) {
            i11 = this.O.getPaddingLeft();
        }
        if (i12 <= 0) {
            i12 = this.O.getPaddingRight();
        }
        if (i13 <= 0) {
            i13 = this.O.getPaddingTop();
        }
        if (i14 <= 0) {
            i14 = this.O.getPaddingBottom();
        }
        ad.b(BTBaseView.TAG, "NOTCH BTVideoView " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)));
        this.O.setPadding(i11, i13, i12, i14);
    }

    public void setOrientation(int i11) {
        this.I = i11;
    }

    public void setPlaybackParams(float f11) {
        PlayerView playerView = this.f47466p;
        if (playerView != null) {
            playerView.setPlaybackParams(f11);
        }
    }

    public void setProgressBarState(int i11) {
        ProgressBar progressBar = this.P;
        if (progressBar != null) {
            progressBar.setVisibility(i11 == 0 ? 8 : 0);
            CampaignEx campaignEx = this.f47374b;
            if (campaignEx == null || campaignEx.getProgressBarShow() != 1) {
                return;
            }
            this.P.setVisibility(0);
        }
    }

    public void setShowClose(int i11) {
        this.f47475y = i11;
    }

    public void setShowMute(int i11) {
        this.f47476z = i11;
    }

    public void setShowTime(int i11) {
        this.f47474x = i11;
    }

    public void setSoundImageViewVisble(int i11) {
        this.f47467q.setVisibility(i11 == 0 ? 4 : 0);
    }

    public void setVolume(float f11, float f12) {
        PlayerView playerView = this.f47466p;
        if (playerView != null) {
            playerView.setVolume(f11, f12);
        }
    }

    public void soundOperate(int i11, int i12, String str) {
        if (this.f47380h) {
            this.E = i11;
            if (i11 == 1) {
                this.f47467q.setSoundStatus(false);
                this.f47466p.closeSound();
            } else if (i11 == 2) {
                this.f47467q.setSoundStatus(true);
                this.f47466p.openSound();
            }
            if (i12 == 1) {
                this.f47467q.setVisibility(8);
            } else if (i12 == 2) {
                this.f47467q.setVisibility(0);
            }
        }
    }

    public void stop() {
        try {
            PlayerView playerView = this.f47466p;
            if (playerView != null) {
                playerView.pause();
                this.f47466p.stop();
                this.G = true;
                WebView webView = this.f47472v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerStop", this.f47376d);
                }
            }
        } catch (Exception e11) {
            ad.a(BTBaseView.TAG, e11.getMessage(), e11);
        }
    }
}
