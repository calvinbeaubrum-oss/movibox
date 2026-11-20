package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.hisavana.common.tracking.TrackingKey;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBAlertDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeVideoView extends MBridgeBaseView implements j {
    private static long aS = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f47922n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f47923o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f47924p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static int f47925q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static int f47926r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static boolean f47927s = false;
    private FeedBackButton A;
    private ImageView B;
    private MBridgeSegmentsProgressBar C;
    private com.mbridge.msdk.video.module.a.a D;
    private a E;
    private boolean F;
    private com.mbridge.msdk.video.dynview.e.a G;
    private int H;
    private boolean I;
    private FrameLayout J;
    private MBridgeClickCTAView K;
    private com.mbridge.msdk.video.signal.factory.b L;
    private int M;
    private int N;
    private RelativeLayout O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private String S;
    private int T;
    private int U;
    private int V;
    private MBAlertDialog W;
    private boolean aA;
    private boolean aB;
    private boolean aC;
    private boolean aD;
    private boolean aE;
    private AlphaAnimation aF;
    private MBridgeBaitClickView aG;
    private int aH;
    private int aI;
    private int aJ;
    private int aK;
    private AcquireRewardPopViewParameters aL;
    private MBAcquireRewardPopView aM;
    private boolean aN;
    private RelativeLayout aO;
    private CollapsibleWebView aP;
    private RelativeLayout aQ;
    private boolean aR;
    private int aT;
    private boolean aU;
    private c aV;
    private boolean aW;
    private Runnable aX;
    private final Runnable aY;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    private com.mbridge.msdk.widget.dialog.a f47928aa;

    /* JADX INFO: renamed from: ab, reason: collision with root package name */
    private String f47929ab;

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    private double f47930ac;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    private double f47931ad;

    /* JADX INFO: renamed from: ae, reason: collision with root package name */
    private boolean f47932ae;

    /* JADX INFO: renamed from: af, reason: collision with root package name */
    private boolean f47933af;

    /* JADX INFO: renamed from: ag, reason: collision with root package name */
    private boolean f47934ag;

    /* JADX INFO: renamed from: ah, reason: collision with root package name */
    private boolean f47935ah;

    /* JADX INFO: renamed from: ai, reason: collision with root package name */
    private boolean f47936ai;

    /* JADX INFO: renamed from: aj, reason: collision with root package name */
    private boolean f47937aj;

    /* JADX INFO: renamed from: ak, reason: collision with root package name */
    private boolean f47938ak;

    /* JADX INFO: renamed from: al, reason: collision with root package name */
    private boolean f47939al;

    /* JADX INFO: renamed from: am, reason: collision with root package name */
    private boolean f47940am;

    /* JADX INFO: renamed from: an, reason: collision with root package name */
    private int f47941an;

    /* JADX INFO: renamed from: ao, reason: collision with root package name */
    private boolean f47942ao;

    /* JADX INFO: renamed from: ap, reason: collision with root package name */
    private int f47943ap;

    /* JADX INFO: renamed from: aq, reason: collision with root package name */
    private kn.b f47944aq;

    /* JADX INFO: renamed from: ar, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.media.a f47945ar;

    /* JADX INFO: renamed from: as, reason: collision with root package name */
    private String f47946as;

    /* JADX INFO: renamed from: at, reason: collision with root package name */
    private int f47947at;

    /* JADX INFO: renamed from: au, reason: collision with root package name */
    private int f47948au;

    /* JADX INFO: renamed from: av, reason: collision with root package name */
    private int f47949av;

    /* JADX INFO: renamed from: aw, reason: collision with root package name */
    private boolean f47950aw;

    /* JADX INFO: renamed from: ax, reason: collision with root package name */
    private boolean f47951ax;

    /* JADX INFO: renamed from: ay, reason: collision with root package name */
    private boolean f47952ay;

    /* JADX INFO: renamed from: az, reason: collision with root package name */
    private boolean f47953az;
    public List<CampaignEx> mCampOrderViewData;
    public int mCampaignSize;
    public int mCurrPlayNum;
    public int mCurrentPlayProgressTime;
    public int mMuteSwitch;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private PlayerView f47954t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private SoundImageView f47955u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f47956v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private View f47957w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private RelativeLayout f47958x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ImageView f47959y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ProgressBar f47960z;

    /* JADX INFO: renamed from: com.mbridge.msdk.video.module.MBridgeVideoView$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass4 implements com.mbridge.msdk.foundation.same.c.c {
        public AnonymousClass4() {
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(String str, String str2) {
            ad.b(MBridgeBaseView.TAG, str);
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(final Bitmap bitmap, String str) {
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled() || MBridgeVideoView.this.f47959y == null) {
                        return;
                    }
                    com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                final Bitmap bitmapA = o.a(bitmap, 10);
                                MBridgeVideoView.this.f47959y.post(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.4.1.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        MBridgeVideoView.this.f47959y.setVisibility(0);
                                        MBridgeVideoView.this.f47959y.setImageBitmap(bitmapA);
                                    }
                                });
                            } catch (Exception e11) {
                                ad.b(MBridgeBaseView.TAG, e11.getMessage());
                            }
                        }
                    });
                } catch (Throwable th2) {
                    ad.b(MBridgeBaseView.TAG, th2.getMessage());
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f47992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f47993b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f47994c;

        public final String toString() {
            return "ProgressData{curPlayPosition=" + this.f47992a + ", allDuration=" + this.f47993b + '}';
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends DefaultVideoPlayerStatusListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MBridgeVideoView f47995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f47996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f47997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f47998d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f47999e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private com.iab.omid.library.mmadbridge.adsession.media.a f48000f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f48005k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f48006l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private CampaignEx f48007m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f48008n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f48009o;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private b f48001g = new b();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f48002h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f48003i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f48004j = false;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f48010p = false;

        public c(MBridgeVideoView mBridgeVideoView) {
            this.f47995a = mBridgeVideoView;
            if (mBridgeVideoView != null) {
                this.f48006l = mBridgeVideoView.getUnitId();
                this.f48007m = mBridgeVideoView.getCampaign();
            }
        }

        private void d() {
            MBridgeVideoView mBridgeVideoView = this.f47995a;
            if (mBridgeVideoView == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mBridgeVideoView.f47956v.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -2;
                layoutParams.height = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 25.0f);
                this.f47995a.f47956v.setLayoutParams(layoutParams);
            }
            int iA = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 5.0f);
            this.f47995a.f47956v.setPadding(iA, 0, iA, 0);
        }

        public final int a() {
            return this.f47996b;
        }

        public final void a(int i11, int i12) {
            int i13;
            CampaignEx campaignEx;
            String str;
            this.f48008n = i11;
            this.f48009o = i12;
            if (!af.a().a("h_c_r_w_p_c", false) || (i13 = this.f48008n) == 100 || this.f48009o != 0 || this.f48010p || i13 == 0 || (campaignEx = this.f48007m) == null) {
                return;
            }
            try {
                if (campaignEx.getAdType() == 94 || this.f48007m.getAdType() == 287) {
                    str = this.f48007m.getRequestId() + this.f48007m.getId() + this.f48007m.getVideoUrlEncode();
                } else {
                    str = this.f48007m.getId() + this.f48007m.getVideoUrlEncode() + this.f48007m.getBidToken();
                }
                com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f48006l, str);
                if (aVarA != null) {
                    aVarA.p();
                    this.f48010p = true;
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

        public final void a(CampaignEx campaignEx) {
            this.f48007m = campaignEx;
        }

        public final void a(String str) {
            this.f48006l = str;
        }

        public final void a(boolean z11) {
            this.f48005k = z11;
        }

        public final int b() {
            return this.f47998d;
        }

        public final void c() {
            this.f47995a = null;
            boolean unused = MBridgeVideoView.f47927s = false;
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f48000f;
                if (aVar != null) {
                    aVar.b();
                    ad.a("omsdk", "play:  videoEvents.bufferFinish()");
                }
                this.f47995a.f47794e.a(14, "");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f48000f;
                if (aVar != null) {
                    aVar.c();
                }
                this.f47995a.f47794e.a(13, "");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayCompleted() {
            MBridgeVideoView mBridgeVideoView;
            super.onPlayCompleted();
            this.f47995a.aA = true;
            CampaignEx campaignEx = this.f48007m;
            if (campaignEx != null) {
                if (this.f48005k && campaignEx.getRewardTemplateMode() != null && this.f48007m.getRewardTemplateMode().f() == 5002010) {
                    this.f47995a.f47956v.setText("0");
                } else {
                    this.f47995a.f47956v.setText(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_complete", "string"));
                }
                this.f48007m.setVideoPlayProgress(100);
                if (this.f48007m.getAdSpaceT() == 2) {
                    this.f47995a.f47957w.setVisibility(4);
                    if (this.f47995a.A != null) {
                        this.f47995a.A.setClickable(false);
                    }
                    if (this.f47995a.f47955u != null) {
                        this.f47995a.f47955u.setClickable(false);
                    }
                }
            } else {
                this.f47995a.f47956v.setText("0");
            }
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f48000f;
            if (aVar != null) {
                aVar.d();
                ad.a("omsdk", "play:  videoEvents.complete()");
            }
            this.f47995a.f47954t.setClickable(false);
            String strB = this.f47995a.b(true);
            CampaignEx campaignEx2 = this.f48007m;
            if (campaignEx2 != null && campaignEx2.getRewardTemplateMode() != null && this.f48007m.getRewardTemplateMode().f() == 5002010) {
                this.f47995a.j();
            }
            CampaignEx campaignEx3 = this.f48007m;
            if (campaignEx3 != null && campaignEx3.getDynamicTempCode() == 5 && (mBridgeVideoView = this.f47995a) != null && mBridgeVideoView.G != null) {
                MBridgeVideoView mBridgeVideoView2 = this.f47995a;
                if (mBridgeVideoView2.mCampaignSize > mBridgeVideoView2.mCurrPlayNum) {
                    HashMap map = new HashMap();
                    map.put(RequestParameters.POSITION, Integer.valueOf(this.f47995a.mCurrPlayNum));
                    int i11 = this.f47995a.mMuteSwitch;
                    if (i11 != 0) {
                        map.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, Integer.valueOf(i11));
                    }
                    this.f47995a.G.a(map);
                    return;
                }
            }
            MBridgeVideoView mBridgeVideoView3 = this.f47995a;
            if (mBridgeVideoView3 != null) {
                mBridgeVideoView3.f47794e.a(121, "");
                this.f47995a.f47794e.a(11, strB);
            }
            int i12 = this.f47997c;
            this.f47996b = i12;
            this.f47995a.mCurrentPlayProgressTime = i12;
            boolean unused = MBridgeVideoView.f47927s = true;
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayError(String str) {
            ad.b("DefaultVideoPlayerStatusListener", "errorStr" + str);
            super.onPlayError(str);
            MBridgeVideoView mBridgeVideoView = this.f47995a;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.f47794e.a(12, str);
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayProgress(int i11, int i12) {
            int i13;
            String str;
            CampaignEx campaignEx;
            int videoCompleteTime;
            StringBuilder sb2;
            String str2;
            int i14;
            StringBuilder sb3;
            super.onPlayProgress(i11, i12);
            if (MBridgeVideoView.aS == 0) {
                long unused = MBridgeVideoView.aS = System.currentTimeMillis();
            }
            if (this.f47995a.f47795f) {
                CampaignEx campaignEx2 = this.f48007m;
                int i15 = 0;
                if (campaignEx2 != null) {
                    videoCompleteTime = campaignEx2.getVideoCompleteTime();
                    if (videoCompleteTime <= 0) {
                        videoCompleteTime = i12;
                    }
                    com.mbridge.msdk.foundation.d.b.a().b(this.f48007m.getCampaignUnitId() + "_1", i11);
                } else {
                    videoCompleteTime = 0;
                }
                CampaignEx campaignEx3 = this.f48007m;
                String string = "0";
                if (campaignEx3 != null && campaignEx3.isDynamicView() && this.f48007m.getDynamicTempCode() == 5) {
                    try {
                        int i16 = this.f47995a.H;
                        MBridgeVideoView mBridgeVideoView = this.f47995a;
                        if (mBridgeVideoView != null) {
                            String string2 = (String) mBridgeVideoView.getContext().getResources().getText(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_complete", "string"));
                            String str3 = (String) this.f47995a.getContext().getResources().getText(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_left", "string"));
                            if (videoCompleteTime >= 0) {
                                if (this.f48007m.getUseSkipTime() == 1) {
                                    int iMin = Math.min(this.f47995a.T, videoCompleteTime);
                                    if (iMin >= videoCompleteTime || iMin <= 0) {
                                        i14 = videoCompleteTime - i11;
                                        if (this.f48005k) {
                                            if (i14 <= 0) {
                                                this.f47995a.f47956v.setVisibility(4);
                                            } else {
                                                str3 = (String) this.f47995a.getContext().getResources().getText(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_left_skip_time", "string"));
                                            }
                                        }
                                    } else {
                                        i14 = iMin - i11;
                                        if (i14 <= 0) {
                                            i14 = videoCompleteTime - i11;
                                            if (this.f48005k) {
                                                this.f47995a.f47956v.setVisibility(4);
                                            }
                                        } else {
                                            str3 = (String) this.f47995a.getContext().getResources().getText(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_left_skip_time", "string"));
                                        }
                                    }
                                } else {
                                    i14 = videoCompleteTime - i11;
                                }
                                if (i14 > 0) {
                                    string2 = i14 + str3;
                                }
                            } else {
                                i14 = i16 - i11;
                                if (i14 <= 0) {
                                    if (videoCompleteTime <= 0) {
                                    }
                                    this.f48001g.f47992a = i11;
                                    this.f47995a.f47956v.setText(string);
                                    if (this.f47995a.f47960z != null && this.f47995a.f47960z.getVisibility() == 0) {
                                        this.f47995a.f47960z.setProgress(i11);
                                    }
                                    if (i14 < this.f47995a.aK && this.f47995a.aM != null && this.f47995a.R) {
                                        this.f47995a.aM.onTimeLessThanReduce(i14);
                                    }
                                } else {
                                    if (videoCompleteTime <= 0) {
                                        sb3 = new StringBuilder();
                                        sb3.append(i14);
                                        sb3.append("");
                                    } else {
                                        sb3 = new StringBuilder();
                                        sb3.append(i14);
                                        sb3.append(str3);
                                    }
                                    string2 = sb3.toString();
                                }
                            }
                            string = string2;
                            this.f48001g.f47992a = i11;
                            this.f47995a.f47956v.setText(string);
                            if (this.f47995a.f47960z != null) {
                                this.f47995a.f47960z.setProgress(i11);
                            }
                            if (i14 < this.f47995a.aK) {
                                this.f47995a.aM.onTimeLessThanReduce(i14);
                            }
                        }
                    } catch (Exception e11) {
                        ad.b("DefaultVideoPlayerStatusListener", e11.getMessage());
                    }
                } else {
                    MBridgeVideoView mBridgeVideoView2 = this.f47995a;
                    if (mBridgeVideoView2 != null) {
                        if (this.f48005k) {
                            str2 = String.format("%s", Integer.valueOf(i12 - i11));
                        } else {
                            if (videoCompleteTime > i12) {
                                videoCompleteTime = i12;
                            }
                            int i17 = videoCompleteTime <= 0 ? i12 - i11 : videoCompleteTime - i11;
                            if (i17 > 0) {
                                if (videoCompleteTime <= 0) {
                                    sb2 = new StringBuilder();
                                    sb2.append(i17);
                                    sb2.append("");
                                } else {
                                    sb2 = new StringBuilder();
                                    sb2.append(i17);
                                    sb2.append((String) this.f47995a.getContext().getResources().getText(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_left", "string")));
                                }
                                string = sb2.toString();
                                i15 = i17;
                            } else if (videoCompleteTime > 0) {
                                string = (String) mBridgeVideoView2.getContext().getResources().getText(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_complete", "string"));
                            }
                            if (i15 < this.f47995a.aK && this.f47995a.aM != null && this.f47995a.R) {
                                this.f47995a.aM.onTimeLessThanReduce(i15);
                            }
                            str2 = string;
                        }
                        CampaignEx campaignEx4 = this.f48007m;
                        if (campaignEx4 != null && campaignEx4.getUseSkipTime() == 1) {
                            int iMin2 = Math.min(this.f47995a.T, i12);
                            if (iMin2 >= videoCompleteTime || iMin2 < 0) {
                                int i18 = videoCompleteTime - i11;
                                if (this.f48005k) {
                                    if (i18 > 0) {
                                        str2 = i18 + ((String) this.f47995a.getContext().getResources().getText(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_left_skip_time", "string")));
                                    } else if (i18 == 0) {
                                        this.f47995a.f47956v.setVisibility(4);
                                    }
                                }
                            } else {
                                int i19 = iMin2 - i11;
                                if (i19 > 0) {
                                    str2 = i19 + ((String) this.f47995a.getContext().getResources().getText(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_left_skip_time", "string")));
                                } else if (this.f48005k && i19 == 0) {
                                    this.f47995a.f47956v.setVisibility(4);
                                }
                            }
                        }
                        this.f47995a.f47956v.setText(str2);
                        if (this.f47995a.f47960z != null && this.f47995a.f47960z.getVisibility() == 0) {
                            this.f47995a.f47960z.setProgress(i11);
                        }
                    }
                    this.f48001g.f47992a = i11;
                }
            }
            this.f47997c = i12;
            b bVar = this.f48001g;
            bVar.f47993b = i12;
            bVar.f47994c = this.f47995a.aC;
            this.f47996b = i11;
            if (this.f47995a.B != null) {
                this.f47995a.B.setTag("" + this.f47996b);
            }
            MBridgeVideoView mBridgeVideoView3 = this.f47995a;
            mBridgeVideoView3.mCurrentPlayProgressTime = i11;
            mBridgeVideoView3.f47794e.a(15, this.f48001g);
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f48000f;
            if (aVar != null) {
                int i21 = (i11 * 100) / i12;
                int i22 = ((i11 + 1) * 100) / i12;
                if (i21 <= 25 && 25 < i22 && !this.f48002h) {
                    this.f48002h = true;
                    aVar.h();
                    ad.a("omsdk", "play:  videoEvents.firstQuartile()");
                } else if (i21 <= 50 && 50 < i22 && !this.f48003i) {
                    this.f48003i = true;
                    aVar.i();
                    ad.a("omsdk", "play:  videoEvents.midpoint()");
                } else if (i21 <= 75 && 75 < i22 && !this.f48004j) {
                    this.f48004j = true;
                    aVar.o();
                    ad.a("omsdk", "play:  videoEvents.thirdQuartile()");
                }
            }
            if (this.f47995a.f47942ao && !this.f47995a.f47950aw && this.f47995a.f47947at == com.mbridge.msdk.foundation.same.a.H) {
                this.f47995a.e();
            }
            try {
                MBridgeVideoView mBridgeVideoView4 = this.f47995a;
                if (mBridgeVideoView4 != null && mBridgeVideoView4.C != null) {
                    int i23 = (i11 * 100) / i12;
                    this.f47995a.C.setProgress(i23, this.f47995a.mCurrPlayNum - 1);
                    this.f48007m.setVideoPlayProgress(i23);
                }
                MBridgeVideoView mBridgeVideoView5 = this.f47995a;
                if (mBridgeVideoView5 != null) {
                    int i24 = mBridgeVideoView5.N != -5 ? this.f47995a.N : this.f47995a.M;
                    if (i24 != -1 && i11 == i24 && (campaignEx = this.f47995a.f47791b) != null && campaignEx.isDynamicView()) {
                        this.f47995a.setCTALayoutVisibleOrGone();
                    }
                }
            } catch (Throwable th2) {
                ad.b("DefaultVideoPlayerStatusListener", th2.getMessage());
            }
            int i25 = this.f48008n;
            if (i25 == 100 || this.f48010p || i25 == 0) {
                return;
            }
            if (this.f48009o > i25) {
                this.f48009o = i25 / 2;
            }
            int i26 = this.f48009o;
            if (i26 < 0 || i11 < (i13 = (i12 * i26) / 100)) {
                return;
            }
            if (this.f48007m.getAdType() == 94 || this.f48007m.getAdType() == 287) {
                str = this.f48007m.getRequestId() + this.f48007m.getId() + this.f48007m.getVideoUrlEncode();
            } else {
                str = this.f48007m.getId() + this.f48007m.getVideoUrlEncode() + this.f48007m.getBidToken();
            }
            com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f48006l, str);
            if (aVarA != null) {
                aVarA.p();
                this.f48010p = true;
                ad.b("DefaultVideoPlayerStatusListener", "CDRate is : " + i13 + " and start download !");
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0074  */
        /* JADX WARN: Code duplicated, block: B:30:0x0076  */
        /* JADX WARN: Code duplicated, block: B:34:0x0082  */
        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayStarted(int i11) {
            CampaignEx campaignEx;
            CampaignEx campaignEx2;
            super.onPlayStarted(i11);
            MBridgeVideoView mBridgeVideoView = this.f47995a;
            if (mBridgeVideoView != null) {
                MBridgeVideoView.C(mBridgeVideoView);
            }
            if (!this.f47999e) {
                MBridgeVideoView mBridgeVideoView2 = this.f47995a;
                if (mBridgeVideoView2 != null) {
                    mBridgeVideoView2.I = true;
                    this.f47995a.f47794e.a(10, this.f48001g);
                }
                this.f47999e = true;
            }
            this.f47998d = i11;
            CampaignEx campaignEx3 = this.f48007m;
            if (campaignEx3 != null) {
                int videoCompleteTime = campaignEx3.getVideoCompleteTime();
                if (videoCompleteTime <= 0) {
                    videoCompleteTime = i11;
                }
                String str = "mbridge_reward_shape_progress";
                if (this.f48007m.isDynamicView()) {
                    MBridgeVideoView mBridgeVideoView3 = this.f47995a;
                    if (mBridgeVideoView3 != null && mBridgeVideoView3.f47956v != null) {
                        if (this.f48007m.getDynamicTempCode() == 5) {
                            MBridgeVideoView mBridgeVideoView4 = this.f47995a;
                            if (mBridgeVideoView4.mCurrPlayNum <= 1 || videoCompleteTime > 0) {
                                if (videoCompleteTime > 0) {
                                    if (this.f48005k || this.f48007m.getDynamicTempCode() == 5) {
                                        d();
                                    }
                                    str = "mbridge_reward_video_time_count_num_bg";
                                }
                                campaignEx2 = this.f48007m;
                                if (campaignEx2 != null && campaignEx2.getUseSkipTime() == 1 && this.f48005k) {
                                    d();
                                }
                                this.f47995a.f47956v.setBackgroundResource(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "drawable"));
                            } else {
                                mBridgeVideoView4.f47956v.setBackgroundResource(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_time_count_num_bg", "drawable"));
                                d();
                            }
                        } else {
                            if (videoCompleteTime > 0) {
                                if (this.f48005k) {
                                    d();
                                } else {
                                    d();
                                }
                                str = "mbridge_reward_video_time_count_num_bg";
                            }
                            campaignEx2 = this.f48007m;
                            if (campaignEx2 != null) {
                                d();
                            }
                            this.f47995a.f47956v.setBackgroundResource(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "drawable"));
                        }
                    }
                } else if (videoCompleteTime > 0) {
                    this.f47995a.f47956v.setBackgroundResource(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_time_count_num_bg", "drawable"));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 30.0f));
                    int iA = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 5.0f);
                    layoutParams.addRule(1, v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_native_endcard_feed_btn", "id"));
                    layoutParams.setMargins(iA, 0, 0, 0);
                    this.f47995a.f47956v.setPadding(iA, 0, iA, 0);
                    this.f47995a.f47956v.setLayoutParams(layoutParams);
                } else {
                    this.f47995a.f47956v.setBackgroundResource(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_shape_progress", "drawable"));
                }
            }
            MBridgeVideoView mBridgeVideoView5 = this.f47995a;
            if (mBridgeVideoView5 != null && mBridgeVideoView5.f47960z != null) {
                this.f47995a.f47960z.setMax(i11);
            }
            MBridgeVideoView mBridgeVideoView6 = this.f47995a;
            if (mBridgeVideoView6 != null && mBridgeVideoView6.f47958x != null && (campaignEx = this.f48007m) != null && campaignEx.getAdSpaceT() == 2) {
                this.f47995a.f47958x.setVisibility(0);
            }
            MBridgeVideoView mBridgeVideoView7 = this.f47995a;
            if (mBridgeVideoView7 != null && mBridgeVideoView7.f47956v != null && this.f47995a.f47956v.getVisibility() == 0) {
                this.f47995a.m();
            }
            boolean unused = MBridgeVideoView.f47927s = false;
            MBridgeVideoView mBridgeVideoView8 = this.f47995a;
            if (mBridgeVideoView8 != null) {
                if (mBridgeVideoView8.N != -5) {
                    if (this.f47995a.N == 0) {
                        this.f47995a.setCTALayoutVisibleOrGone();
                    }
                } else if (this.f47995a.M == 0) {
                    this.f47995a.setCTALayoutVisibleOrGone();
                }
            }
            MBridgeVideoView mBridgeVideoView9 = this.f47995a;
            if (mBridgeVideoView9 != null) {
                mBridgeVideoView9.showMoreOfferInPlayTemplate();
                this.f47995a.showBaitClickView();
                MBridgeVideoView.I(this.f47995a);
            }
        }
    }

    public MBridgeVideoView(Context context) {
        super(context);
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.mMuteSwitch = 0;
        this.F = false;
        this.H = 0;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.f47929ab = "";
        this.f47932ae = false;
        this.f47933af = false;
        this.f47934ag = false;
        this.f47935ah = false;
        this.f47936ai = false;
        this.f47937aj = false;
        this.f47938ak = false;
        this.f47939al = false;
        this.f47940am = false;
        this.f47942ao = false;
        this.f47943ap = 2;
        this.f47950aw = false;
        this.f47951ax = false;
        this.f47952ay = false;
        this.f47953az = true;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aE = false;
        this.aH = 0;
        this.aI = 5;
        this.aJ = 5;
        this.aK = 5;
        this.aN = false;
        this.aR = false;
        this.aT = 0;
        this.aU = false;
        this.aV = new c(this);
        this.aW = false;
        this.aX = new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (MBridgeVideoView.this.J != null) {
                    MBridgeVideoView.this.J.setVisibility(8);
                }
            }
        };
        this.aY = new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.13
            @Override // java.lang.Runnable
            public final void run() {
                if (MBridgeVideoView.this.aI <= 0) {
                    MBridgeVideoView.this.showRewardPopView();
                    MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                    mBridgeVideoView.removeCallbacks(mBridgeVideoView.aY);
                } else {
                    MBridgeVideoView.Z(MBridgeVideoView.this);
                    MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                    mBridgeVideoView2.postDelayed(mBridgeVideoView2.aY, 1000L);
                }
            }
        };
    }

    public MBridgeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.mMuteSwitch = 0;
        this.F = false;
        this.H = 0;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.f47929ab = "";
        this.f47932ae = false;
        this.f47933af = false;
        this.f47934ag = false;
        this.f47935ah = false;
        this.f47936ai = false;
        this.f47937aj = false;
        this.f47938ak = false;
        this.f47939al = false;
        this.f47940am = false;
        this.f47942ao = false;
        this.f47943ap = 2;
        this.f47950aw = false;
        this.f47951ax = false;
        this.f47952ay = false;
        this.f47953az = true;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aE = false;
        this.aH = 0;
        this.aI = 5;
        this.aJ = 5;
        this.aK = 5;
        this.aN = false;
        this.aR = false;
        this.aT = 0;
        this.aU = false;
        this.aV = new c(this);
        this.aW = false;
        this.aX = new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (MBridgeVideoView.this.J != null) {
                    MBridgeVideoView.this.J.setVisibility(8);
                }
            }
        };
        this.aY = new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.13
            @Override // java.lang.Runnable
            public final void run() {
                if (MBridgeVideoView.this.aI <= 0) {
                    MBridgeVideoView.this.showRewardPopView();
                    MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                    mBridgeVideoView.removeCallbacks(mBridgeVideoView.aY);
                } else {
                    MBridgeVideoView.Z(MBridgeVideoView.this);
                    MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                    mBridgeVideoView2.postDelayed(mBridgeVideoView2.aY, 1000L);
                }
            }
        };
    }

    public static /* synthetic */ void C(MBridgeVideoView mBridgeVideoView) {
        CollapsibleWebView collapsibleWebView = mBridgeVideoView.aP;
        if (collapsibleWebView == null || mBridgeVideoView.f47791b == null || !TextUtils.isEmpty(collapsibleWebView.getUrl())) {
            return;
        }
        mBridgeVideoView.aP.loadUrl(mBridgeVideoView.f47791b.getClickURL());
        mBridgeVideoView.aP.setToolBarTitle(mBridgeVideoView.f47791b.getAppName());
        g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarB == null) {
            h.a();
            gVarB = i.a();
        }
        mBridgeVideoView.aP.setPageLoadTimtout((int) gVarB.aq());
        mBridgeVideoView.aP.setPageLoadListener(new CollapsibleWebView.a() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.5
            private void a(String str, String str2) {
                if (MBridgeVideoView.this.aR) {
                    return;
                }
                MBridgeVideoView.this.aR = true;
                if (str == null) {
                    str = "";
                }
                if (MBridgeVideoView.this.aO != null && MBridgeVideoView.this.aO.getVisibility() == 0) {
                    MBridgeVideoView.this.aO.setVisibility(8);
                }
                d dVar = new d();
                dVar.a("result", 2);
                dVar.a("url", str);
                if (Build.VERSION.SDK_INT >= 23) {
                    dVar.a("reason", str2);
                }
                com.mbridge.msdk.foundation.same.report.d.c.a().a("m_webview_render", MBridgeVideoView.this.f47791b, dVar);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.a
            public final void a(View view, String str) {
                JSONObject jSONObject;
                if (MBridgeVideoView.this.aR) {
                    return;
                }
                MBridgeVideoView.this.aR = true;
                if (MBridgeVideoView.this.aO != null && MBridgeVideoView.this.aO.getVisibility() != 0) {
                    MBridgeVideoView.this.aO.setVisibility(0);
                }
                Context context = MBridgeVideoView.this.getContext();
                MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                com.mbridge.msdk.click.a.a(context, mBridgeVideoView2.f47791b, mBridgeVideoView2.getUnitId(), MBridgeVideoView.this.f47791b.getNoticeUrl(), true, false, com.mbridge.msdk.click.a.a.f43074i);
                com.mbridge.msdk.video.module.b.b.d(com.mbridge.msdk.foundation.controller.c.m().c().getApplicationContext(), MBridgeVideoView.this.f47791b);
                d dVar = new d();
                dVar.a("result", 1);
                if (MBridgeVideoView.this.D != null) {
                    JSONObject jSONObject2 = null;
                    try {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put(com.mbridge.msdk.foundation.same.a.f44374j, MBridgeVideoView.this.a(0));
                        } catch (JSONException e11) {
                            e = e11;
                            jSONObject2 = jSONObject;
                            e.printStackTrace();
                            jSONObject = jSONObject2;
                        }
                    } catch (JSONException e12) {
                        e = e12;
                    }
                    MBridgeVideoView.this.D.a(131, jSONObject);
                    MBridgeVideoView.this.f47791b.setClickType(1);
                    MBridgeVideoView.this.f47791b.setClickTempSource(1);
                    MBridgeVideoView.this.f47791b.setTriggerClickSource(2);
                    com.mbridge.msdk.foundation.same.report.d.c.a().a("2000149", MBridgeVideoView.this.f47791b);
                    dVar.a("type", 9);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("web_view");
                    dVar.a("click_path", arrayList.toString());
                    com.mbridge.msdk.foundation.same.report.d.c.a().a("2000150", MBridgeVideoView.this.f47791b, dVar);
                }
                dVar.a("url", str);
                com.mbridge.msdk.foundation.same.report.d.c.a().a("m_webview_render", MBridgeVideoView.this.f47791b, dVar);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.a
            public final void a(View view, Map<String, String> map) {
                String str;
                String str2 = "";
                if (map != null) {
                    String str3 = map.get("url");
                    str2 = str3 != null ? str3 : "";
                    str = map.get(TrackingKey.DESCRIPTION);
                } else {
                    str = "";
                }
                a(str2, str);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.a
            public final void b(View view, String str) {
                a(str, "timeout");
            }

            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.a
            public final void b(View view, Map<String, String> map) {
            }
        });
        mBridgeVideoView.aP.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.6
            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            }
        });
        mBridgeVideoView.aP.setCollapseListener(new CommonWebView.a() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.7
            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.a
            public final void a() {
                if (MBridgeVideoView.this.aQ != null) {
                    MBridgeVideoView.this.aQ.setVisibility(0);
                    d dVar = new d();
                    dVar.a(NotificationCompat.CATEGORY_STATUS, 1);
                    com.mbridge.msdk.foundation.same.report.d.c.a().a("m_webview_zoom", MBridgeVideoView.this.f47791b, dVar);
                }
                if (MBridgeVideoView.this.aP != null) {
                    MBridgeVideoView.this.aP.setCustomizedToolBarMarginWidthPixel(0, 0, 0, 0);
                }
                MBridgeVideoView.this.h();
            }
        });
        mBridgeVideoView.aP.setExpandListener(new CommonWebView.a() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.8
            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.a
            public final void a() {
                if (MBridgeVideoView.this.aQ != null) {
                    MBridgeVideoView.this.aQ.setVisibility(8);
                    d dVar = new d();
                    dVar.a(NotificationCompat.CATEGORY_STATUS, 2);
                    com.mbridge.msdk.foundation.same.report.d.c.a().a("m_webview_zoom", MBridgeVideoView.this.f47791b, dVar);
                }
                if (MBridgeVideoView.this.aP != null) {
                    MBridgeVideoView.this.aP.setCustomizedToolBarMarginWidthPixel(0, MBridgeVideoView.this.aT, 0, 0);
                }
                MBridgeVideoView.this.g();
            }
        });
        mBridgeVideoView.aP.setExitsClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBridgeVideoView.this.aQ != null) {
                    MBridgeVideoView.this.aQ.setVisibility(0);
                }
                if (MBridgeVideoView.this.aO != null) {
                    MBridgeVideoView.this.aO.setVisibility(8);
                }
                if (MBridgeVideoView.this.aA) {
                    return;
                }
                MBridgeVideoView.this.h();
            }
        });
    }

    public static /* synthetic */ void I(MBridgeVideoView mBridgeVideoView) {
        String strE;
        CampaignEx campaignEx = mBridgeVideoView.f47791b;
        if (campaignEx == null || !campaignEx.isDynamicView() || mBridgeVideoView.P) {
            return;
        }
        if (!TextUtils.isEmpty(mBridgeVideoView.f47791b.getMof_template_url())) {
            strE = mBridgeVideoView.f47791b.getMof_template_url();
        } else if (mBridgeVideoView.f47791b.getRewardTemplateMode() == null) {
            return;
        } else {
            strE = mBridgeVideoView.f47791b.getRewardTemplateMode().e();
        }
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        try {
            String strA = ao.a(strE, "guideShow");
            String strA2 = ao.a(strE, "guideDelay");
            String strA3 = ao.a(strE, "guideTime");
            String strA4 = ao.a(strE, "guideRewardTime");
            if (!TextUtils.isEmpty(strA)) {
                mBridgeVideoView.aH = Integer.parseInt(strA);
            }
            if (!TextUtils.isEmpty(strA2)) {
                int i11 = Integer.parseInt(strA2);
                mBridgeVideoView.aI = i11;
                if (i11 > 10 || i11 < 3) {
                    mBridgeVideoView.aI = 5;
                }
            }
            if (!TextUtils.isEmpty(strA3)) {
                int i12 = Integer.parseInt(strA3);
                mBridgeVideoView.aJ = i12;
                if (i12 > 10 || i12 < 3) {
                    mBridgeVideoView.aJ = 5;
                }
            }
            if (!TextUtils.isEmpty(strA4)) {
                int i13 = Integer.parseInt(strA4);
                mBridgeVideoView.aK = i13;
                if (i13 > 10 || i13 < 5) {
                    mBridgeVideoView.aK = 5;
                }
            }
            int i14 = mBridgeVideoView.aH;
            if (i14 > 0 && i14 <= 2) {
                int iO = mBridgeVideoView.o();
                if (iO == 0 || iO > mBridgeVideoView.aI) {
                    int i15 = iO - mBridgeVideoView.aI;
                    if (i15 >= 0 && mBridgeVideoView.aK > i15) {
                        mBridgeVideoView.aK = i15;
                    }
                    int iP = mBridgeVideoView.p();
                    if (mBridgeVideoView.aK >= iP) {
                        mBridgeVideoView.aK = iP - mBridgeVideoView.aI;
                    }
                    if (mBridgeVideoView.aI >= iP) {
                        return;
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(mBridgeVideoView.f47791b.getAppName());
                    g gVarA = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
                    mBridgeVideoView.aL = new AcquireRewardPopViewParameters.Builder("", mBridgeVideoView.f47929ab, mBridgeVideoView.aH, gVarA != null ? gVarA.o() : "US").setAutoDismissTime(mBridgeVideoView.aJ).setReduceTime(mBridgeVideoView.aK).setBehaviourListener(new AcquireRewardPopViewBehaviourListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.11
                        @Override // com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener
                        public final void onOutOfContentClicked(float f11, float f12) {
                            if (MBridgeVideoView.this.D != null) {
                                MBridgeVideoView.this.D.a(105, "");
                            }
                        }

                        @Override // com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener
                        public final void onReceivedFail(String str) {
                            MBridgeVideoView.this.R = false;
                            if (com.mbridge.msdk.f.b.b()) {
                                MBridgeVideoView.this.setCover(false);
                            }
                            MBridgeVideoView.this.h();
                            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                            q.a(mBridgeVideoView2.f47791b, mBridgeVideoView2.f47929ab, MBridgeVideoView.this.aH, 2, str);
                        }

                        @Override // com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener
                        public final void onReceivedSuccess(int i16) {
                            MBridgeVideoView.this.R = false;
                            if (com.mbridge.msdk.f.b.b()) {
                                MBridgeVideoView.this.setCover(false);
                            }
                            int iO2 = MBridgeVideoView.this.o() - i16;
                            MBridgeVideoView.this.f47791b.setVideoCompleteTime(iO2);
                            MBridgeVideoView.this.h();
                            com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.f47794e;
                            if (aVar != null) {
                                aVar.a(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, Integer.valueOf(iO2));
                            }
                            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                            q.a(mBridgeVideoView2.f47791b, mBridgeVideoView2.f47929ab, MBridgeVideoView.this.aH, 1, "");
                        }
                    }).setRightAnswerList(arrayList).build();
                    mBridgeVideoView.postDelayed(mBridgeVideoView.aY, 1000L);
                }
            }
        } catch (Throwable th2) {
            ad.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    public static /* synthetic */ int Z(MBridgeVideoView mBridgeVideoView) {
        int i11 = mBridgeVideoView.aI;
        mBridgeVideoView.aI = i11 - 1;
        return i11;
    }

    private String a(int i11, int i12) {
        if (i12 != 0) {
            try {
                return ai.a(Double.valueOf(i11 / i12)) + "";
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return i12 + "";
    }

    public static /* synthetic */ void a(MBridgeVideoView mBridgeVideoView, String str) {
        JSONObject jSONObject;
        JSONException e11;
        if (mBridgeVideoView.D != null) {
            CampaignEx campaignEx = mBridgeVideoView.f47791b;
            if (campaignEx != null) {
                campaignEx.setClickTempSource(1);
                try {
                    CampaignEx.c rewardTemplateMode = mBridgeVideoView.f47791b.getRewardTemplateMode();
                    String str2 = "";
                    if (rewardTemplateMode != null) {
                        str2 = rewardTemplateMode.f() + "";
                    }
                    q.a(mBridgeVideoView.f47790a, str, mBridgeVideoView.f47791b.getCampaignUnitId(), mBridgeVideoView.f47791b.isBidCampaign(), mBridgeVideoView.f47791b.getRequestId(), mBridgeVideoView.f47791b.getRequestIdNotice(), mBridgeVideoView.f47791b.getId(), str2);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.f44374j, mBridgeVideoView.a(0));
                } catch (JSONException e13) {
                    e11 = e13;
                    e11.printStackTrace();
                }
            } catch (JSONException e14) {
                jSONObject = null;
                e11 = e14;
            }
            mBridgeVideoView.D.a(105, jSONObject);
            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                try {
                    com.mbridge.msdk.video.module.b.b.d(com.mbridge.msdk.foundation.controller.c.m().c().getApplicationContext(), mBridgeVideoView.f47791b);
                } catch (Exception e15) {
                    ad.b(MBridgeBaseView.TAG, e15.getMessage());
                }
            }
        }
    }

    private void a(String str) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(str, new AnonymousClass4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(boolean z11) {
        if (!this.f47942ao) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.f47950aw) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.F);
            }
            if (this.f47952ay) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.D);
            }
            if (this.f47951ax) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.E);
            }
            jSONObject.put("complete_info", z11 ? 1 : 2);
            return jSONObject.toString();
        } catch (Exception unused) {
            ad.b(MBridgeBaseView.TAG, "getIVRewardStatusString ERROR");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        PlayerView playerView;
        boolean zF = f();
        this.f47795f = zF;
        if (!zF) {
            ad.b(MBridgeBaseView.TAG, "MBridgeVideoView init fail");
        }
        if (af.a().a("i_l_s_t_r_i", false) && (playerView = this.f47954t) != null) {
            playerView.setNotifyListener(new PlayerView.OnPlayerViewVisibleListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.14
                @Override // com.mbridge.msdk.playercommon.PlayerView.OnPlayerViewVisibleListener
                public final void playerViewVisibleCallback() {
                    if (MBridgeVideoView.this.F) {
                        return;
                    }
                    MBridgeVideoView.this.F = true;
                    MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                    if (mBridgeVideoView.f47794e == null || mBridgeVideoView.E == null) {
                        return;
                    }
                    MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                    mBridgeVideoView2.f47794e.a(20, mBridgeVideoView2.E);
                }
            });
        }
        c();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.aF = alphaAnimation;
        alphaAnimation.setDuration(200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:108:0x0150 A[Catch: Exception -> 0x0031, TryCatch #0 {Exception -> 0x0031, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x000c, B:8:0x001b, B:10:0x001f, B:12:0x0023, B:14:0x0027, B:18:0x0035, B:21:0x003d, B:23:0x0043, B:25:0x0047, B:27:0x004b, B:29:0x004f, B:31:0x0053, B:33:0x005f, B:35:0x0063, B:37:0x0067, B:39:0x006b, B:41:0x0077, B:43:0x007b, B:45:0x008b, B:47:0x0098, B:49:0x00a6, B:51:0x00af, B:53:0x00b3, B:55:0x00b7, B:57:0x00c3, B:59:0x00c7, B:61:0x00cb, B:63:0x00cf, B:65:0x00db, B:67:0x00df, B:68:0x00e2, B:70:0x00e8, B:72:0x00ee, B:74:0x00f2, B:76:0x00f9, B:78:0x00fd, B:80:0x0101, B:82:0x0105, B:84:0x010c, B:46:0x0092, B:86:0x0110, B:88:0x0114, B:90:0x011a, B:92:0x012f, B:109:0x0154, B:111:0x0158, B:102:0x0141, B:104:0x0145, B:106:0x0149, B:108:0x0150, B:112:0x015e, B:114:0x0162), top: B:118:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    public void e() {
        com.mbridge.msdk.video.module.a.a aVar;
        int i11;
        com.mbridge.msdk.video.module.a.a aVar2;
        boolean z11;
        try {
            CampaignEx campaignEx = this.f47791b;
            if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f47791b.getRewardTemplateMode().f() == 5002010 && this.aU && !(z11 = this.aA)) {
                com.mbridge.msdk.video.module.a.a aVar3 = this.f47794e;
                if (aVar3 != null) {
                    this.aU = true;
                    aVar3.a(2, b(z11));
                    return;
                }
                return;
            }
            if (!this.f47942ao || ((i11 = this.f47947at) != com.mbridge.msdk.foundation.same.a.G && i11 != com.mbridge.msdk.foundation.same.a.H)) {
                CampaignEx campaignEx2 = this.f47791b;
                if (campaignEx2 == null || campaignEx2.getAdSpaceT() == 2) {
                    com.mbridge.msdk.video.module.a.a aVar4 = this.f47794e;
                    if (aVar4 != null) {
                        this.aU = true;
                        aVar4.a(2, "");
                        return;
                    }
                    return;
                }
                int iO = o();
                int curPosition = this.f47954t.getCurPosition() / 1000;
                if (this.f47791b.getDynamicTempCode() != 5 || this.mCurrPlayNum <= 1) {
                    if ((iO > 0 && curPosition < iO) || iO == 0) {
                        if (this.V == 1 && !this.f47940am) {
                            g();
                            aVar = this.f47794e;
                            if (aVar != null) {
                                aVar.a(8, "");
                                return;
                            }
                            return;
                        }
                    }
                } else if (iO != 0 && iO > 0 && curPosition < iO) {
                    if (this.V == 1) {
                        g();
                        aVar = this.f47794e;
                        if (aVar != null) {
                            aVar.a(8, "");
                            return;
                        }
                        return;
                    }
                }
                com.mbridge.msdk.video.module.a.a aVar5 = this.f47794e;
                if (aVar5 != null) {
                    this.aU = true;
                    aVar5.a(2, "");
                    return;
                }
                return;
            }
            if (this.f47950aw) {
                if (i11 != com.mbridge.msdk.foundation.same.a.H || (aVar2 = this.f47794e) == null) {
                    return;
                }
                this.aU = true;
                aVar2.a(2, b(this.aA));
                return;
            }
            if (i11 == com.mbridge.msdk.foundation.same.a.H && this.aD) {
                com.mbridge.msdk.video.module.a.a aVar6 = this.f47794e;
                if (aVar6 != null) {
                    this.aU = true;
                    aVar6.a(2, b(this.aA));
                    return;
                }
                return;
            }
            if (this.f47953az) {
                int curPosition2 = this.f47954t.getCurPosition() / 1000;
                int videoLength = (int) ((curPosition2 / (this.f47954t.getDuration() == 0 ? this.f47791b.getVideoLength() : this.f47954t.getDuration())) * 100.0f);
                if (this.f47947at == com.mbridge.msdk.foundation.same.a.G) {
                    g();
                    int i12 = this.f47948au;
                    if (i12 == com.mbridge.msdk.foundation.same.a.I && videoLength >= this.f47949av) {
                        com.mbridge.msdk.video.module.a.a aVar7 = this.f47794e;
                        if (aVar7 != null) {
                            this.aU = true;
                            aVar7.a(2, b(this.aA));
                            return;
                        }
                        return;
                    }
                    if (i12 == com.mbridge.msdk.foundation.same.a.J && curPosition2 >= this.f47949av) {
                        com.mbridge.msdk.video.module.a.a aVar8 = this.f47794e;
                        if (aVar8 != null) {
                            this.aU = true;
                            aVar8.a(2, b(this.aA));
                            return;
                        }
                        return;
                    }
                    com.mbridge.msdk.video.module.a.a aVar9 = this.f47794e;
                    if (aVar9 != null) {
                        aVar9.a(8, "");
                    }
                }
                if (this.f47947at == com.mbridge.msdk.foundation.same.a.H) {
                    int i13 = this.f47948au;
                    if (i13 == com.mbridge.msdk.foundation.same.a.I && videoLength >= this.f47949av) {
                        g();
                        com.mbridge.msdk.video.module.a.a aVar10 = this.f47794e;
                        if (aVar10 != null) {
                            aVar10.a(8, "");
                            return;
                        }
                        return;
                    }
                    if (i13 != com.mbridge.msdk.foundation.same.a.J || curPosition2 < this.f47949av) {
                        return;
                    }
                    g();
                    com.mbridge.msdk.video.module.a.a aVar11 = this.f47794e;
                    if (aVar11 != null) {
                        aVar11.a(8, "");
                    }
                }
            }
        } catch (Exception e11) {
            ad.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    private boolean f() {
        try {
            this.f47954t = (PlayerView) findViewById(filterFindViewId(this.aE, "mbridge_vfpv"));
            this.f47955u = (SoundImageView) findViewById(filterFindViewId(this.aE, "mbridge_sound_switch"));
            this.f47956v = (TextView) findViewById(filterFindViewId(this.aE, "mbridge_tv_count"));
            View viewFindViewById = findViewById(filterFindViewId(this.aE, "mbridge_rl_playing_close"));
            this.f47957w = viewFindViewById;
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(4);
            }
            this.f47958x = (RelativeLayout) findViewById(filterFindViewId(this.aE, "mbridge_top_control"));
            this.f47959y = (ImageView) findViewById(filterFindViewId(this.aE, "mbridge_videoview_bg"));
            this.f47960z = (ProgressBar) findViewById(filterFindViewId(this.aE, "mbridge_video_progress_bar"));
            this.A = (FeedBackButton) findViewById(filterFindViewId(this.aE, "mbridge_native_endcard_feed_btn"));
            this.B = (ImageView) findViewById(filterFindViewId(this.aE, "mbridge_iv_link"));
            this.aO = (RelativeLayout) findViewById(filterFindViewId(this.aE, "mbridge_reward_scale_webview_layout"));
            this.aQ = (RelativeLayout) findViewById(filterFindViewId(this.aE, "mbridge_reward_header_layout"));
            if (this.aO != null) {
                CollapsibleWebView collapsibleWebView = new CollapsibleWebView(getContext());
                this.aP = collapsibleWebView;
                this.aO.addView(collapsibleWebView, new RelativeLayout.LayoutParams(-1, -1));
            }
            ai.a(1, this.B, this.f47791b, this.f47790a, false, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.20
                @Override // com.mbridge.msdk.foundation.d.a
                public final void a() {
                    MBridgeVideoView.this.g();
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void a(String str) {
                    MBridgeVideoView.this.h();
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void b() {
                    MBridgeVideoView.this.h();
                }
            });
            this.C = (MBridgeSegmentsProgressBar) findViewById(filterFindViewId(this.aE, "mbridge_reward_segment_progressbar"));
            this.J = (FrameLayout) findViewById(filterFindViewId(this.aE, "mbridge_reward_cta_layout"));
            this.aG = (MBridgeBaitClickView) findViewById(filterFindViewId(this.aE, "mbridge_animation_click_view"));
            this.O = (RelativeLayout) findViewById(filterFindViewId(this.aE, "mbridge_reward_moreoffer_layout"));
            this.aM = (MBAcquireRewardPopView) findViewById(filterFindViewId(this.aE, "mbridge_reward_popview"));
            return isNotNULL(this.f47954t, this.f47955u, this.f47956v, this.f47957w);
        } catch (Throwable th2) {
            ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            PlayerView playerView = this.f47954t;
            if (playerView != null) {
                playerView.onPause();
                CampaignEx campaignEx = this.f47791b;
                if (campaignEx != null && !campaignEx.isRewardPopViewShowed) {
                    removeCallbacks(this.aY);
                }
                if (com.mbridge.msdk.f.b.a()) {
                    this.f47954t.setIsCovered(this.aN || this.Q || this.R);
                }
                CampaignEx campaignEx2 = this.f47791b;
                if (campaignEx2 != null && campaignEx2.getNativeVideoTracking() != null && !this.f47791b.isHasReportAdTrackPause()) {
                    this.f47791b.setHasReportAdTrackPause(true);
                    Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                    CampaignEx campaignEx3 = this.f47791b;
                    com.mbridge.msdk.click.a.a(contextC, campaignEx3, this.f47929ab, campaignEx3.getNativeVideoTracking().m(), false, false);
                }
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f47945ar;
                if (aVar != null) {
                    aVar.j();
                    ad.a("omsdk", "play:  videoEvents.pause()");
                }
            }
        } catch (Throwable th2) {
            ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        c cVar;
        CampaignEx campaignEx;
        RelativeLayout relativeLayout;
        try {
            CampaignEx campaignEx2 = this.f47791b;
            if (campaignEx2 == null || campaignEx2.getRewardTemplateMode() == null || this.f47791b.getRewardTemplateMode().f() != 5002010 || (relativeLayout = this.aQ) == null || relativeLayout.getVisibility() == 0) {
                if (this.f47933af) {
                    MBAcquireRewardPopView mBAcquireRewardPopView = this.aM;
                    if (mBAcquireRewardPopView != null && this.R) {
                        mBAcquireRewardPopView.onResume();
                    }
                    if (this.R) {
                        return;
                    }
                    if (!com.mbridge.msdk.f.b.a()) {
                        i();
                        return;
                    } else {
                        if (this.aN || this.Q) {
                            return;
                        }
                        this.f47954t.setIsCovered(false);
                        i();
                        return;
                    }
                }
                try {
                    if (this.f47945ar != null) {
                        float duration = this.f47954t.getDuration();
                        if (duration == 0.0f && (campaignEx = this.f47791b) != null) {
                            duration = campaignEx.getVideoLength();
                        }
                        this.f47945ar.n(duration, getMute() == 2 ? 1.0f : 0.0f);
                        ad.a("omsdk", "play: videoEvents.start()");
                    }
                } catch (IllegalArgumentException e11) {
                    ad.a(MBridgeBaseView.TAG, e11.getMessage());
                }
                boolean zPlayVideo = this.f47954t.playVideo();
                CampaignEx campaignEx3 = this.f47791b;
                if (campaignEx3 != null && campaignEx3.getPlayable_ads_without_video() != 2 && !zPlayVideo && (cVar = this.aV) != null) {
                    cVar.onPlayError("play video failed");
                }
                this.f47933af = true;
            }
        } catch (Exception e12) {
            ad.a(MBridgeBaseView.TAG, e12.getMessage(), e12);
        }
    }

    private void i() {
        if (this.aA) {
            if (!this.aB) {
                this.f47954t.seekToEndFrame();
            }
            this.aB = true;
        } else {
            this.f47954t.onResume();
        }
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx != null && !campaignEx.isRewardPopViewShowed) {
            post(this.aY);
        }
        try {
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f47945ar;
            if (aVar != null) {
                aVar.l();
                ad.a("omsdk", "play:  videoEvents.resume()");
            }
        } catch (IllegalArgumentException e11) {
            ad.a(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (!this.f47795f || this.f47957w.getVisibility() == 0) {
            return;
        }
        if (!this.f47798i || this.I) {
            this.f47957w.setVisibility(0);
        }
        this.f47936ai = true;
    }

    private void k() {
        int iB;
        int iF;
        float f11;
        float f12 = ai.f(this.f47790a);
        float fE = ai.e(this.f47790a);
        int iA = ai.a(getContext(), 58.0f);
        int iA2 = ai.a(getContext(), 104.0f);
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx != null && campaignEx.getAdSpaceT() == 2) {
            int iB2 = this.f47791b.getRewardTemplateMode() != null ? this.f47791b.getRewardTemplateMode().b() : 1;
            if (iB2 == 1) {
                f12 -= iA * 2;
                fE -= iA2 * 2;
            }
            if (iB2 == 2) {
                f12 -= iA2 * 2;
                fE -= iA * 2;
            }
            if (iB2 == 0) {
                if (this.f47793d == 1) {
                    f12 -= iA * 2;
                    f11 = iA2 * 2;
                } else {
                    f12 -= iA2 * 2;
                    f11 = iA * 2;
                }
                fE -= f11;
            }
        }
        double d11 = this.f47930ac;
        if (d11 > 0.0d) {
            double d12 = this.f47931ad;
            if (d12 > 0.0d && f12 > 0.0f && fE > 0.0f) {
                double d13 = d11 / d12;
                double d14 = f12 / fE;
                ad.c(MBridgeBaseView.TAG, "videoWHDivide:" + d13 + "  screenWHDivide:" + d14);
                double dA = ai.a(Double.valueOf(d13));
                double dA2 = ai.a(Double.valueOf(d14));
                ad.c(MBridgeBaseView.TAG, "videoWHDivideFinal:" + dA + "  screenWHDivideFinal:" + dA2);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f47954t.getLayoutParams();
                if (dA > dA2) {
                    double d15 = (((double) f12) * this.f47931ad) / this.f47930ac;
                    layoutParams.width = -1;
                    layoutParams.height = (int) d15;
                    layoutParams.gravity = 17;
                } else if (dA < dA2) {
                    layoutParams.width = (int) (((double) fE) * d13);
                    layoutParams.height = -1;
                    layoutParams.gravity = 17;
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                try {
                    CampaignEx campaignEx2 = this.f47791b;
                    if (campaignEx2 != null && campaignEx2.isDynamicView()) {
                        if (this.f47791b.getRewardTemplateMode() != null) {
                            iF = this.f47791b.getRewardTemplateMode().f();
                            iB = this.f47791b.getRewardTemplateMode().b();
                        } else {
                            iB = this.f47790a.getResources().getConfiguration().orientation;
                            iF = 904;
                        }
                        if (iF == 102 || iF == 202) {
                            if (iB == 1) {
                                layoutParams.width = -1;
                                layoutParams.gravity = 17;
                                layoutParams.height = (int) (this.f47931ad / (this.f47930ac / ((double) f12)));
                            } else {
                                layoutParams.height = -1;
                                layoutParams.gravity = 17;
                                layoutParams.width = (int) (((double) fE) * d13);
                            }
                        }
                        if (iF == 202 && !TextUtils.isEmpty(this.f47791b.getImageUrl())) {
                            a(this.f47791b.getImageUrl());
                        }
                        if (iF == 302 || iF == 802 || iF == 5002010) {
                            double d16 = this.f47930ac;
                            double d17 = this.f47931ad;
                            if (d16 / d17 > 1.0d) {
                                layoutParams.width = -1;
                                layoutParams.height = (int) ((d17 * ((double) f12)) / d16);
                            } else {
                                int iA3 = ai.a(getContext(), 220.0f);
                                layoutParams.width = (int) ((this.f47930ac * ((double) iA3)) / this.f47931ad);
                                layoutParams.height = iA3;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    ad.b(MBridgeBaseView.TAG, th2.getMessage());
                }
                this.f47954t.setLayoutParams(layoutParams);
                setMatchParent();
                return;
            }
        }
        l();
    }

    private void l() {
        try {
            setLayoutParam(0, 0, -1, -1);
            if (isLandscape() || !this.f47795f) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f47954t.getLayoutParams();
            int iF = ai.f(this.f47790a);
            layoutParams.width = -1;
            layoutParams.height = (iF * 9) / 16;
            layoutParams.gravity = 17;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.f47929ab);
            com.mbridge.msdk.foundation.d.b.a().a(this.f47929ab + "_1", this.f47791b);
        }
        if (!com.mbridge.msdk.foundation.d.b.a().b()) {
            FeedBackButton feedBackButton = this.A;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        if (this.A != null) {
            com.mbridge.msdk.foundation.d.b.a().a(this.f47929ab + "_1", this.A);
        }
    }

    private void n() {
        if (this.J == null) {
            return;
        }
        if (this.K == null) {
            MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(getContext());
            this.K = mBridgeClickCTAView;
            mBridgeClickCTAView.setCampaign(this.f47791b);
            this.K.setUnitId(this.f47929ab);
            com.mbridge.msdk.video.module.a.a aVar = this.D;
            if (aVar != null) {
                this.K.setNotifyListener(new com.mbridge.msdk.video.module.a.a.i(aVar));
            }
            this.K.preLoadData(this.L);
        }
        this.J.addView(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o() {
        int videoCompleteTime = 0;
        try {
            int iP = p();
            CampaignEx campaignEx = this.f47791b;
            if (campaignEx == null) {
                return iP;
            }
            videoCompleteTime = campaignEx.getVideoCompleteTime();
            if (this.f47791b.getDynamicTempCode() != 5 && videoCompleteTime > iP) {
                videoCompleteTime = iP;
            }
            if (videoCompleteTime <= 0) {
                return iP;
            }
        } catch (Throwable th2) {
            ad.b(MBridgeBaseView.TAG, th2.getMessage());
        }
        return videoCompleteTime;
    }

    private int p() {
        try {
            c cVar = this.aV;
            int iB = cVar != null ? cVar.b() : 0;
            return iB == 0 ? this.f47791b.getVideoLength() : iB;
        } catch (Throwable th2) {
            ad.b(MBridgeBaseView.TAG, th2.getMessage());
            return 0;
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void alertWebViewShowed() {
        this.Q = true;
        setShowingAlertViewCover(true);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public final void c() {
        super.c();
        if (this.f47795f) {
            if (!this.f47798i) {
                this.f47954t.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.16
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        if (MBridgeVideoView.this.f47794e != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.f44374j, MBridgeVideoView.this.f47954t.buildH5JsonObject(0));
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            MBridgeVideoView.this.f47791b.setClickTempSource(1);
                            MBridgeVideoView.this.f47791b.setTriggerClickSource(2);
                            MBridgeVideoView.this.f47794e.a(1, jSONObject);
                        }
                    }
                });
            } else if (com.mbridge.msdk.video.dynview.i.a.a(this.f47791b) == -1 || com.mbridge.msdk.video.dynview.i.a.a(this.f47791b) == 100) {
                this.f47954t.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.15
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        if (MBridgeVideoView.this.f47794e != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.f44374j, MBridgeVideoView.this.f47954t.buildH5JsonObject(0));
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            MBridgeVideoView.this.f47791b.setClickTempSource(1);
                            MBridgeVideoView.this.f47791b.setTriggerClickSource(2);
                            MBridgeVideoView.this.f47794e.a(1, jSONObject);
                        }
                        if (MBridgeVideoView.this.f47945ar != null) {
                            MBridgeVideoView.this.f47945ar.a(InteractionType.CLICK);
                        }
                        MBridgeVideoView.this.setCTALayoutVisibleOrGone();
                    }
                });
            }
            SoundImageView soundImageView = this.f47955u;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.17
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Integer num = 2;
                        if (MBridgeVideoView.this.f47954t != null && MBridgeVideoView.this.f47954t.isSilent()) {
                            num = 1;
                        }
                        if (num.intValue() == 1) {
                            MBridgeVideoView.this.mMuteSwitch = 2;
                        } else {
                            MBridgeVideoView.this.mMuteSwitch = 1;
                        }
                        com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.f47794e;
                        if (aVar != null) {
                            aVar.a(5, num);
                        }
                    }
                });
            }
            this.f47957w.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.18
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        d dVar = new d();
                        dVar.a("type", 1);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("2000152", dVar);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("2000148", MBridgeVideoView.this.f47791b, dVar);
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            e11.printStackTrace();
                        }
                    }
                    if (!MBridgeVideoView.this.f47942ao) {
                        CampaignEx campaignEx = MBridgeVideoView.this.f47791b;
                        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || MBridgeVideoView.this.f47791b.getRewardTemplateMode().f() != 5002010 || !MBridgeVideoView.this.aA) {
                            MBridgeVideoView.this.e();
                            return;
                        }
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        if (mBridgeVideoView.f47794e != null) {
                            mBridgeVideoView.aU = true;
                            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                            mBridgeVideoView2.f47794e.a(2, mBridgeVideoView2.b(mBridgeVideoView2.aA));
                            return;
                        }
                        return;
                    }
                    MBridgeVideoView.this.aD = true;
                    CampaignEx campaignEx2 = MBridgeVideoView.this.f47791b;
                    if (campaignEx2 != null && campaignEx2.getRewardTemplateMode() != null && MBridgeVideoView.this.f47791b.getRewardTemplateMode().f() == 5002010 && MBridgeVideoView.this.aA) {
                        MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                        if (mBridgeVideoView3.f47794e != null) {
                            mBridgeVideoView3.aU = true;
                            MBridgeVideoView mBridgeVideoView4 = MBridgeVideoView.this;
                            mBridgeVideoView4.f47794e.a(2, mBridgeVideoView4.b(mBridgeVideoView4.aA));
                            return;
                        }
                        return;
                    }
                    if (MBridgeVideoView.this.f47953az) {
                        MBridgeVideoView.this.e();
                        return;
                    }
                    com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.f47794e;
                    if (aVar != null) {
                        aVar.a(123, "");
                    }
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void closeVideoOperate(int i11, int i12) {
        if (i11 == 1) {
            this.aD = true;
            if (getVisibility() == 0) {
                e();
            }
            try {
                d dVar = new d();
                dVar.a("type", 1);
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000152", dVar);
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000148", this.f47791b, dVar);
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    th2.printStackTrace();
                }
            }
        }
        if (i12 == 1) {
            gonePlayingCloseView();
        } else if (i12 == 2) {
            if (this.aC && getVisibility() == 0) {
                return;
            }
            j();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
        this.f47932ae = true;
        showVideoLocation(0, 0, ai.f(this.f47790a), ai.e(this.f47790a), 0, 0, 0, 0, 0);
        videoOperate(1);
        if (this.T == 0) {
            closeVideoOperate(-1, 2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void dismissAllAlert() {
        MBAlertDialog mBAlertDialog = this.W;
        if (mBAlertDialog != null) {
            mBAlertDialog.dismiss();
        }
        com.mbridge.msdk.video.module.a.a aVar = this.f47794e;
        if (aVar != null) {
            aVar.a(125, "");
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewHeight() {
        return f47926r;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewLeft() {
        return f47924p;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewRadius() {
        return f47922n;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewTop() {
        return f47923o;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewWidth() {
        return f47925q;
    }

    public int getCloseAlert() {
        return this.V;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public String getCurrentProgress() {
        try {
            int iA = this.aV.a();
            CampaignEx campaignEx = this.f47791b;
            int videoLength = campaignEx != null ? campaignEx.getVideoLength() : 0;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, a(iA, videoLength));
            jSONObject.put("time", iA);
            jSONObject.put("duration", videoLength + "");
            return jSONObject.toString();
        } catch (Throwable th2) {
            ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
            return "{}";
        }
    }

    public int getMute() {
        return this.f47943ap;
    }

    public String getUnitId() {
        return this.f47929ab;
    }

    public int getVideoSkipTime() {
        return this.T;
    }

    public void gonePlayingCloseView() {
        if (this.f47795f && this.f47957w.getVisibility() != 8) {
            this.f47957w.setVisibility(8);
            this.f47936ai = false;
        }
        if (this.aW || this.f47939al || this.f47937aj) {
            return;
        }
        this.aW = true;
        int i11 = this.T;
        if (i11 < 0) {
            return;
        }
        if (i11 == 0) {
            this.f47939al = true;
        } else {
            new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.2
                @Override // java.lang.Runnable
                public final void run() {
                    MBridgeVideoView.this.f47939al = true;
                }
            }, this.T * 1000);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void hideAlertView(int i11) {
        if (this.Q) {
            this.Q = false;
            this.f47950aw = true;
            setShowingAlertViewCover(false);
            com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f47929ab, false);
            q.a(this.f47790a, this.f47791b, com.mbridge.msdk.videocommon.d.c.f48481a, this.f47929ab, 1, i11, 1);
            if (i11 == 0) {
                h();
                if (this.f47942ao) {
                    int i12 = this.f47947at;
                    if (i12 == com.mbridge.msdk.foundation.same.a.H || i12 == com.mbridge.msdk.foundation.same.a.G) {
                        this.f47951ax = true;
                        com.mbridge.msdk.video.module.a.a aVar = this.f47794e;
                        if (aVar != null) {
                            aVar.a(124, "");
                        }
                        CampaignEx campaignEx = this.f47791b;
                        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f47791b.getRewardTemplateMode().f() == 5002010) {
                            j();
                            return;
                        } else {
                            this.aC = true;
                            gonePlayingCloseView();
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.f47952ay = true;
            boolean z11 = this.f47942ao;
            if (z11 && this.f47947at == com.mbridge.msdk.foundation.same.a.H) {
                h();
                return;
            }
            if (z11 && this.f47947at == com.mbridge.msdk.foundation.same.a.G) {
                com.mbridge.msdk.video.module.a.a aVar2 = this.f47794e;
                if (aVar2 != null) {
                    this.aU = true;
                    aVar2.a(2, b(this.aA));
                    return;
                }
                return;
            }
            com.mbridge.msdk.video.module.a.a aVar3 = this.f47794e;
            if (aVar3 != null) {
                this.aU = true;
                aVar3.a(2, "");
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
    }

    @Override // com.mbridge.msdk.video.signal.j
    public boolean isH5Canvas() {
        return getLayoutParams().height < ai.e(this.f47790a.getApplicationContext());
    }

    public boolean isInstDialogShowing() {
        return this.aN;
    }

    public boolean isMiniCardShowing() {
        return this.f47935ah;
    }

    public boolean isRewardPopViewShowing() {
        return this.R;
    }

    public boolean isShowingAlertView() {
        return this.Q;
    }

    public boolean isShowingTransparent() {
        return this.f47940am;
    }

    public boolean isfront() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return false;
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int childCount = viewGroup.getChildCount();
        int i11 = iIndexOfChild + 1;
        boolean z11 = false;
        while (i11 <= childCount - 1) {
            if (viewGroup.getChildAt(i11).getVisibility() == 0 && this.f47935ah) {
                return false;
            }
            i11++;
            z11 = true;
        }
        return z11;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void notifyCloseBtn(int i11) {
        if (i11 == 0) {
            this.f47937aj = true;
            this.f47939al = false;
        } else if (i11 == 1) {
            this.f47938ak = true;
        }
    }

    public void notifyVideoClose() {
        this.aU = true;
        this.f47794e.a(2, "");
    }

    public void onActivityPause() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aM;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onPause();
            }
        } catch (Throwable th2) {
            ad.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    public void onActivityResume() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aM;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onResume();
            }
        } catch (Throwable th2) {
            ad.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    public void onActivityStop() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aM;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onStop();
            }
        } catch (Throwable th2) {
            ad.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    public void onBackPress() {
        boolean z11;
        if (this.f47935ah || this.Q || this.f47951ax) {
            return;
        }
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f47791b.getRewardTemplateMode().f() == 5002010 && (z11 = this.aA)) {
            com.mbridge.msdk.video.module.a.a aVar = this.f47794e;
            if (aVar != null) {
                this.aU = true;
                aVar.a(2, b(z11));
                return;
            }
            return;
        }
        if (this.f47936ai) {
            e();
            return;
        }
        boolean z12 = this.f47937aj;
        if (z12 && this.f47938ak) {
            e();
        } else {
            if (z12 || !this.f47939al) {
                return;
            }
            e();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CampaignEx campaignEx = this.f47791b;
        if ((campaignEx == null || !campaignEx.isDynamicView()) && this.f47795f && this.f47932ae) {
            k();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (this.aX != null) {
                getHandler().removeCallbacks(this.aX);
            }
            if (this.aH != 0) {
                removeCallbacks(this.aY);
            }
        } catch (Throwable th2) {
            ad.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.L = bVar;
        if (!this.f47795f) {
            com.mbridge.msdk.video.module.a.a aVar = this.f47794e;
            if (aVar != null) {
                aVar.a(12, "MBridgeVideoView initSuccess false");
            }
        } else if (!TextUtils.isEmpty(this.S) && this.f47791b != null) {
            kn.b bVar2 = this.f47944aq;
            if (bVar2 != null) {
                bVar2.d(this.f47954t);
                SoundImageView soundImageView = this.f47955u;
                if (soundImageView != null) {
                    this.f47944aq.a(soundImageView, FriendlyObstructionPurpose.OTHER, null);
                }
                this.f47944aq.a(this.f47956v, FriendlyObstructionPurpose.OTHER, null);
                this.f47944aq.a(this.f47957w, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
            }
            CampaignEx campaignEx = this.f47791b;
            if (campaignEx != null && an.b(campaignEx.getVideoResolution())) {
                String videoResolution = this.f47791b.getVideoResolution();
                ad.c(MBridgeBaseView.TAG, "MBridgeBaseView videoResolution:" + videoResolution);
                String[] strArrSplit = videoResolution.split("x");
                if (strArrSplit.length == 2) {
                    if (ai.m(strArrSplit[0]) > 0.0d) {
                        this.f47930ac = ai.m(strArrSplit[0]);
                    }
                    if (ai.m(strArrSplit[1]) > 0.0d) {
                        this.f47931ad = ai.m(strArrSplit[1]);
                    }
                    ad.c(MBridgeBaseView.TAG, "MBridgeBaseView mVideoW:" + this.f47930ac + "  mVideoH:" + this.f47931ad);
                }
                if (this.f47930ac <= 0.0d) {
                    this.f47930ac = 1280.0d;
                }
                if (this.f47931ad <= 0.0d) {
                    this.f47931ad = 720.0d;
                }
            }
            this.f47954t.initBufferIngParam(this.U);
            this.f47954t.initVFPData(this.S, this.f47791b.getVideoUrlEncode(), this.aV);
            soundOperate(this.f47943ap, -1, null);
        }
        f47927s = false;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void progressBarOperate(int i11) {
        ProgressBar progressBar;
        if (this.f47795f) {
            if (i11 == 1) {
                ProgressBar progressBar2 = this.f47960z;
                if (progressBar2 != null) {
                    progressBar2.setVisibility(8);
                    return;
                }
                return;
            }
            if (i11 != 2 || (progressBar = this.f47960z) == null) {
                return;
            }
            progressBar.setVisibility(0);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void progressOperate(int i11, int i12) {
        if (this.f47795f) {
            ad.c(MBridgeBaseView.TAG, "progressOperate progress:" + i11);
            CampaignEx campaignEx = this.f47791b;
            int videoLength = campaignEx != null ? campaignEx.getVideoLength() : 0;
            if (i11 > 0 && i11 <= videoLength && this.f47954t != null) {
                ad.c(MBridgeBaseView.TAG, "progressOperate progress:" + i11);
                this.f47954t.seekTo(i11 * 1000);
            }
            if (i12 == 1) {
                this.f47956v.setVisibility(8);
            } else if (i12 == 2) {
                this.f47956v.setVisibility(0);
            }
            if (this.f47956v.getVisibility() == 0) {
                m();
            }
        }
    }

    public void releasePlayer() {
        try {
            PlayerView playerView = this.f47954t;
            if (playerView != null && !this.f47934ag) {
                playerView.release();
                d dVar = new d();
                dVar.a("duration", Long.valueOf(System.currentTimeMillis() - aS));
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000146", this.f47791b, dVar);
            }
            c cVar = this.aV;
            if (cVar != null) {
                cVar.c();
            }
            if (this.D != null) {
                this.D = null;
            }
        } catch (Exception e11) {
            ad.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    public void setAdSession(kn.b bVar) {
        this.f47944aq = bVar;
    }

    public void setBufferTimeout(int i11) {
        this.U = i11;
    }

    public void setCTALayoutVisibleOrGone() {
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null || !campaignEx.isDynamicView() || this.J == null) {
            return;
        }
        int i11 = this.N;
        if (i11 != -5) {
            if (i11 == -3) {
                return;
            }
            if (this.K == null) {
                n();
            }
            if (this.N == -1) {
                if (this.J.getVisibility() != 0) {
                    this.J.setVisibility(0);
                    postDelayed(this.aX, 3000L);
                } else {
                    this.J.setVisibility(8);
                    getHandler().removeCallbacks(this.aX);
                }
            }
            if (this.N >= 0) {
                this.J.setVisibility(0);
                return;
            }
            return;
        }
        if (this.M < -1) {
            return;
        }
        if (this.K == null) {
            n();
        }
        int i12 = this.M;
        if (i12 >= 0) {
            this.J.setVisibility(0);
            return;
        }
        if (i12 == -1) {
            if (this.J.getVisibility() != 0) {
                this.J.setVisibility(0);
                postDelayed(this.aX, 3000L);
            } else {
                this.J.setVisibility(8);
                getHandler().removeCallbacks(this.aX);
            }
        }
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.e.a aVar, List<CampaignEx> list, int i11, int i12) {
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar;
        this.G = aVar;
        this.mCampaignSize = list.size();
        this.mCurrPlayNum = i11;
        this.H = i12;
        this.mCampOrderViewData = list;
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null || campaignEx.getDynamicTempCode() != 5) {
            CampaignEx campaignEx2 = this.f47791b;
            if (campaignEx2 == null || campaignEx2.getProgressBarShow() != 1 || (mBridgeSegmentsProgressBar = this.C) == null) {
                return;
            }
            mBridgeSegmentsProgressBar.init(1, 3);
            this.C.setVisibility(0);
            return;
        }
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar2 = this.C;
        if (mBridgeSegmentsProgressBar2 == null || this.mCampOrderViewData == null) {
            return;
        }
        if (this.mCampaignSize > 1) {
            mBridgeSegmentsProgressBar2.setVisibility(0);
            this.C.init(this.mCampaignSize, 2);
            for (int i13 = 0; i13 < this.mCampOrderViewData.size(); i13++) {
                int videoPlayProgress = this.mCampOrderViewData.get(i13).getVideoPlayProgress();
                if (videoPlayProgress > 0) {
                    this.C.setProgress(videoPlayProgress, i13);
                }
                if (this.mCampOrderViewData.get(i13).isRewardPopViewShowed) {
                    this.P = true;
                }
            }
            return;
        }
        CampaignEx campaignEx3 = this.f47791b;
        if (campaignEx3 == null || campaignEx3.getProgressBarShow() != 1) {
            this.C.setVisibility(8);
            return;
        }
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar3 = this.C;
        if (mBridgeSegmentsProgressBar3 != null) {
            mBridgeSegmentsProgressBar3.init(1, 3);
            this.C.setVisibility(0);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void setCampaign(CampaignEx campaignEx) {
        super.setCampaign(campaignEx);
        c cVar = this.aV;
        if (cVar != null) {
            cVar.a(campaignEx);
            c cVar2 = this.aV;
            int iR = (campaignEx == null || campaignEx.getReady_rate() == -1) ? com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f47929ab, false).r() : campaignEx.getReady_rate();
            cVar2.a(iR, com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f47929ab, false).s());
        }
    }

    public void setCloseAlert(int i11) {
        this.V = i11;
    }

    public void setContainerViewOnNotifyListener(com.mbridge.msdk.video.module.a.a aVar) {
        this.D = aVar;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setCover(boolean z11) {
        if (this.f47795f) {
            this.f47954t.setIsCovered(z11);
        }
    }

    public void setDialogRole(int i11) {
        this.f47953az = i11 == 1;
        ad.b(MBridgeBaseView.TAG, i11 + " " + this.f47953az);
    }

    public void setIVRewardEnable(int i11, int i12, int i13) {
        this.f47947at = i11;
        this.f47948au = i12;
        this.f47949av = i13;
    }

    public void setInstDialogState(boolean z11) {
        PlayerView playerView;
        this.aN = z11;
        if (!com.mbridge.msdk.f.b.a() || (playerView = this.f47954t) == null) {
            return;
        }
        playerView.setIsCovered(z11);
    }

    public void setIsIV(boolean z11) {
        this.f47942ao = z11;
        c cVar = this.aV;
        if (cVar != null) {
            cVar.a(z11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setMiniEndCardState(boolean z11) {
        this.f47935ah = z11;
    }

    public void setNotchPadding(final int i11, final int i12, final int i13, final int i14) {
        RelativeLayout relativeLayout;
        try {
            ad.b(MBridgeBaseView.TAG, "NOTCH VideoView " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            int i15 = layoutParams.leftMargin;
            int i16 = layoutParams.rightMargin;
            int i17 = layoutParams.topMargin;
            int i18 = layoutParams.bottomMargin;
            this.aT = i13;
            if (Math.max(Math.max(i15, i16), Math.max(i17, i18)) <= Math.max(Math.max(i11, i12), Math.max(i13, i14)) && (relativeLayout = this.f47958x) != null) {
                relativeLayout.postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (MBridgeVideoView.this.f47958x == null) {
                            return;
                        }
                        MBridgeVideoView.this.f47958x.setVisibility(0);
                        CampaignEx campaignEx = MBridgeVideoView.this.f47791b;
                        if (campaignEx == null || campaignEx.getAdSpaceT() == 2) {
                            return;
                        }
                        MBridgeVideoView.this.f47958x.setPadding(i11, i13, i12, i14);
                        MBridgeVideoView.this.f47958x.startAnimation(MBridgeVideoView.this.aF);
                    }
                }, 200L);
            }
            if (this.f47956v.getVisibility() == 0) {
                m();
            }
        } catch (Exception e11) {
            ad.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    public void setPlayURL(String str) {
        this.S = str;
    }

    public void setPlayerViewAttachListener(a aVar) {
        this.E = aVar;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setScaleFitXY(int i11) {
        this.f47941an = i11;
    }

    public void setShowingAlertViewCover(boolean z11) {
        MBAcquireRewardPopView mBAcquireRewardPopView;
        if (z11 && (mBAcquireRewardPopView = this.aM) != null && this.R && this.Q) {
            mBAcquireRewardPopView.onPause();
        }
        this.f47954t.setIsCovered(z11);
    }

    public void setShowingTransparent(boolean z11) {
        this.f47940am = z11;
    }

    public void setSoundState(int i11) {
        this.f47943ap = i11;
    }

    public void setUnitId(String str) {
        this.f47929ab = str;
        c cVar = this.aV;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void setVideoEvents(com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
        this.f47945ar = aVar;
        c cVar = this.aV;
        if (cVar != null) {
            cVar.f48000f = aVar;
        }
    }

    public void setVideoLayout(CampaignEx campaignEx) {
        if (campaignEx != null) {
            this.f47791b = campaignEx;
            this.f47798i = campaignEx.isDynamicView();
        }
        if (this.f47798i) {
            final com.mbridge.msdk.video.dynview.c cVarA = new com.mbridge.msdk.video.dynview.j.c().a(this, campaignEx);
            com.mbridge.msdk.video.dynview.b.a().a(cVarA, new com.mbridge.msdk.video.dynview.e.g() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.12
                @Override // com.mbridge.msdk.video.dynview.e.g
                public final void a(com.mbridge.msdk.video.dynview.a aVar) {
                    if (aVar != null) {
                        if (this != null && aVar.a() != null) {
                            aVar.a().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                            this.addView(aVar.a());
                        }
                        if (aVar.b() != null) {
                            Iterator<View> it = aVar.b().iterator();
                            while (it.hasNext()) {
                                it.next().setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.12.1
                                    @Override // com.mbridge.msdk.widget.a
                                    public final void a(View view) {
                                        if (view instanceof TextView) {
                                            MBridgeVideoView.this.f47791b.setTriggerClickSource(1);
                                        } else {
                                            MBridgeVideoView.this.f47791b.setTriggerClickSource(2);
                                        }
                                        MBridgeVideoView.a(MBridgeVideoView.this, "video_play_click");
                                    }
                                });
                            }
                        }
                        MBridgeVideoView.this.aE = aVar.c();
                        MBridgeVideoView.this.b();
                        boolean unused = MBridgeVideoView.f47927s = false;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        CampaignEx campaignEx2 = mBridgeVideoView.f47791b;
                        if (campaignEx2 != null) {
                            campaignEx2.setTemplateRenderSucc(mBridgeVideoView.aE);
                        }
                        MBridgeVideoView.this.M = cVarA.j();
                        MBridgeVideoView.this.N = cVarA.m();
                    }
                }

                @Override // com.mbridge.msdk.video.dynview.e.g
                public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                    ad.b(MBridgeBaseView.TAG, "errorMsg：" + aVar.b());
                }
            });
            return;
        }
        int iFindLayout = findLayout("mbridge_reward_videoview_item");
        if (iFindLayout > 0) {
            this.f47792c.inflate(iFindLayout, this);
            b();
        }
        CampaignEx campaignEx2 = this.f47791b;
        if (campaignEx2 != null) {
            campaignEx2.setTemplateRenderSucc(false);
        }
        f47927s = false;
    }

    public void setVideoSkipTime(int i11) {
        this.T = i11;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setVisible(int i11) {
        setVisibility(i11);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showAlertView() {
        CampaignEx campaignEx;
        if (this.f47935ah) {
            return;
        }
        if (this.f47928aa == null) {
            this.f47928aa = new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.19
                @Override // com.mbridge.msdk.widget.dialog.a
                public final void a() {
                    MBridgeVideoView.this.Q = false;
                    MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                    mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.Q);
                    if (MBridgeVideoView.this.f47942ao && (MBridgeVideoView.this.f47947at == com.mbridge.msdk.foundation.same.a.H || MBridgeVideoView.this.f47947at == com.mbridge.msdk.foundation.same.a.G)) {
                        MBridgeVideoView.this.f47951ax = true;
                        com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.f47794e;
                        if (aVar != null) {
                            aVar.a(124, "");
                        }
                        MBridgeVideoView.this.aC = true;
                        MBridgeVideoView.this.gonePlayingCloseView();
                    }
                    MBridgeVideoView.this.h();
                    MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                    q.a(mBridgeVideoView2.f47790a, mBridgeVideoView2.f47791b, mBridgeVideoView2.f47946as, MBridgeVideoView.this.f47929ab, 1, 0, 1);
                }

                @Override // com.mbridge.msdk.widget.dialog.a
                public final void b() {
                    MBridgeVideoView.this.Q = false;
                    MBridgeVideoView.this.f47952ay = true;
                    MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                    mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.Q);
                    MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                    q.a(mBridgeVideoView2.f47790a, mBridgeVideoView2.f47791b, mBridgeVideoView2.f47946as, MBridgeVideoView.this.f47929ab, 1, 1, 1);
                    if (MBridgeVideoView.this.f47942ao && MBridgeVideoView.this.f47947at == com.mbridge.msdk.foundation.same.a.G) {
                        MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                        if (mBridgeVideoView3.f47794e != null) {
                            mBridgeVideoView3.aU = true;
                            MBridgeVideoView mBridgeVideoView4 = MBridgeVideoView.this;
                            mBridgeVideoView4.f47794e.a(2, mBridgeVideoView4.b(mBridgeVideoView4.aA));
                            return;
                        }
                        return;
                    }
                    if (MBridgeVideoView.this.f47942ao && MBridgeVideoView.this.f47947at == com.mbridge.msdk.foundation.same.a.H) {
                        MBridgeVideoView.this.h();
                        return;
                    }
                    MBridgeVideoView mBridgeVideoView5 = MBridgeVideoView.this;
                    if (mBridgeVideoView5.f47794e != null) {
                        mBridgeVideoView5.aU = true;
                        MBridgeVideoView.this.f47794e.a(2, "");
                    }
                }

                @Override // com.mbridge.msdk.widget.dialog.a
                public final void c() {
                }
            };
        }
        if (this.W == null) {
            MBAlertDialog mBAlertDialog = new MBAlertDialog(getContext(), this.f47928aa);
            this.W = mBAlertDialog;
            kn.b bVar = this.f47944aq;
            if (bVar != null) {
                bVar.a(mBAlertDialog.getWindow().getDecorView(), FriendlyObstructionPurpose.NOT_VISIBLE, null);
            }
        }
        if (this.f47942ao) {
            this.W.makeIVAlertView(this.f47947at, this.f47929ab);
        } else {
            this.W.makeRVAlertView(this.f47929ab);
        }
        PlayerView playerView = this.f47954t;
        if (playerView != null) {
            if (playerView.isComplete() && ((campaignEx = this.f47791b) == null || campaignEx.getRewardTemplateMode() == null || this.f47791b.getRewardTemplateMode().f() != 5002010)) {
                return;
            }
            this.W.show();
            this.f47950aw = true;
            this.Q = true;
            setShowingAlertViewCover(true);
            com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f47929ab, false);
            String str = com.mbridge.msdk.videocommon.d.c.f48481a;
            this.f47946as = str;
            q.a(this.f47790a, this.f47791b, str, this.f47929ab, 1, 1);
        }
    }

    public void showBaitClickView() {
        int i11;
        MBridgeBaitClickView mBridgeBaitClickView;
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null || !campaignEx.isDynamicView() || this.f47791b.getRewardTemplateMode() == null) {
            return;
        }
        String strE = this.f47791b.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        try {
            String strA = ao.a(strE, "bait_click");
            if (TextUtils.isEmpty(strA) || (i11 = Integer.parseInt(strA)) == 0 || (mBridgeBaitClickView = this.aG) == null) {
                return;
            }
            mBridgeBaitClickView.setVisibility(0);
            this.aG.init(i11);
            this.aG.startAnimation();
            this.aG.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                    if (mBridgeVideoView.f47794e != null) {
                        mBridgeVideoView.f47791b.setTriggerClickSource(2);
                        MBridgeVideoView.a(MBridgeVideoView.this, "bait_click_clicked");
                    }
                }
            });
        } catch (Exception e11) {
            ad.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showIVRewardAlertView(String str) {
        this.f47794e.a(8, "");
    }

    public void showMoreOfferInPlayTemplate() {
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null || this.O == null || !campaignEx.isDynamicView() || this.f47791b.getRewardTemplateMode() == null) {
            return;
        }
        String strE = this.f47791b.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        try {
            String strA = ao.a(strE, "mof");
            if (TextUtils.isEmpty(strA) || Integer.parseInt(strA) != 1) {
                return;
            }
            com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f47791b, this, new com.mbridge.msdk.video.module.a.a.i(this.D), 1);
        } catch (Exception e11) {
            ad.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    public void showRewardPopView() {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters;
        MBAcquireRewardPopView mBAcquireRewardPopView = this.aM;
        if (mBAcquireRewardPopView == null || (acquireRewardPopViewParameters = this.aL) == null) {
            return;
        }
        try {
            mBAcquireRewardPopView.init(acquireRewardPopViewParameters);
            this.aM.setVisibility(0);
            setCover(true);
            g();
            this.R = true;
            CampaignEx campaignEx = this.f47791b;
            if (campaignEx != null) {
                campaignEx.isRewardPopViewShowed = true;
            }
        } catch (Exception e11) {
            ad.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showVideoLocation(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        float f11;
        ad.c(MBridgeBaseView.TAG, "showVideoLocation marginTop:" + i11 + " marginLeft:" + i12 + " width:" + i13 + "  height:" + i14 + " radius:" + i15 + " borderTop:" + i16 + " borderLeft:" + i17 + " borderWidth:" + i18 + " borderHeight:" + i19);
        if (this.f47795f) {
            this.f47958x.setPadding(0, 0, 0, 0);
            setVisibility(0);
            if (this.f47958x.getVisibility() != 0) {
                this.f47958x.setVisibility(0);
            }
            if (this.f47956v.getVisibility() == 0) {
                m();
            }
            int iF = ai.f(this.f47790a);
            int iE = ai.e(this.f47790a);
            if (i13 <= 0 || i14 <= 0 || iF < i13 || iE < i14 || this.f47932ae) {
                k();
                return;
            }
            f47923o = i16;
            f47924p = i17;
            f47925q = i18 + 4;
            f47926r = i19 + 4;
            float f12 = i13 / i14;
            try {
                f11 = (float) (this.f47930ac / this.f47931ad);
            } catch (Throwable th2) {
                ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
                f11 = 0.0f;
            }
            if (i15 > 0) {
                f47922n = i15;
                if (i15 > 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(ai.a(getContext(), i15));
                    gradientDrawable.setColor(-1);
                    gradientDrawable.setStroke(1, 0);
                    setBackground(gradientDrawable);
                    this.f47954t.setBackground(gradientDrawable);
                    setClipToOutline(true);
                    this.f47954t.setClipToOutline(true);
                }
            }
            if (Math.abs(f12 - f11) > 0.1f && this.f47941an != 1) {
                k();
                videoOperate(1);
                return;
            }
            k();
            if (!this.f47940am) {
                setLayoutParam(i12, i11, i13, i14);
                return;
            }
            setLayoutCenter(i13, i14);
            if (f47927s) {
                this.f47794e.a(114, "");
            } else {
                this.f47794e.a(116, "");
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void soundOperate(int i11, int i12) {
        soundOperate(i11, i12, "2");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void soundOperate(int i11, int i12, String str) {
        com.mbridge.msdk.video.module.a.a aVar;
        SoundImageView soundImageView;
        if (this.f47795f) {
            this.f47943ap = i11;
            if (i11 == 1) {
                SoundImageView soundImageView2 = this.f47955u;
                if (soundImageView2 != null) {
                    soundImageView2.setSoundStatus(false);
                }
                this.f47954t.closeSound();
                try {
                    com.iab.omid.library.mmadbridge.adsession.media.a aVar2 = this.f47945ar;
                    if (aVar2 != null) {
                        aVar2.p(0.0f);
                    }
                } catch (IllegalArgumentException e11) {
                    ad.a("OMSDK", e11.getMessage());
                }
            } else if (i11 == 2) {
                SoundImageView soundImageView3 = this.f47955u;
                if (soundImageView3 != null) {
                    soundImageView3.setSoundStatus(true);
                }
                this.f47954t.openSound();
                try {
                    com.iab.omid.library.mmadbridge.adsession.media.a aVar3 = this.f47945ar;
                    if (aVar3 != null) {
                        aVar3.p(1.0f);
                    }
                } catch (IllegalArgumentException e12) {
                    ad.a("OMSDK", e12.getMessage());
                }
            }
            CampaignEx campaignEx = this.f47791b;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                SoundImageView soundImageView4 = this.f47955u;
                if (soundImageView4 != null) {
                    soundImageView4.setVisibility(0);
                }
            } else if (i12 == 1) {
                SoundImageView soundImageView5 = this.f47955u;
                if (soundImageView5 != null) {
                    soundImageView5.setVisibility(8);
                }
            } else if (i12 == 2 && (soundImageView = this.f47955u) != null) {
                soundImageView.setVisibility(0);
            }
        }
        if (str == null || !str.equals("2") || (aVar = this.f47794e) == null) {
            return;
        }
        aVar.a(7, Integer.valueOf(i11));
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void videoOperate(int i11) {
        ad.a(MBridgeBaseView.TAG, "VideoView videoOperate:" + i11);
        if (this.f47795f) {
            if (i11 == 1) {
                if (getVisibility() == 0 && isfront()) {
                    ad.a(MBridgeBaseView.TAG, "VideoView videoOperate:play");
                    RelativeLayout relativeLayout = this.aQ;
                    if ((relativeLayout != null && relativeLayout.getVisibility() != 0) || this.Q || com.mbridge.msdk.foundation.d.b.f44150c) {
                        return;
                    }
                    if (!com.mbridge.msdk.f.b.a()) {
                        h();
                        return;
                    } else {
                        if (this.f47935ah || this.aN) {
                            return;
                        }
                        h();
                        return;
                    }
                }
                return;
            }
            if (i11 == 2) {
                if (getVisibility() == 0 && isfront()) {
                    ad.a(MBridgeBaseView.TAG, "VideoView videoOperate:pause");
                    g();
                    return;
                }
                return;
            }
            if (i11 == 3) {
                if (this.f47934ag) {
                    return;
                }
                this.f47954t.stop();
                CampaignEx campaignEx = this.f47791b;
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || this.f47791b.getRewardTemplateMode().f() != 5002010) {
                    this.f47954t.release();
                    this.f47934ag = true;
                    d dVar = new d();
                    dVar.a("duration", Long.valueOf(System.currentTimeMillis() - aS));
                    com.mbridge.msdk.foundation.same.report.d.c.a().a("2000146", this.f47791b, dVar);
                    return;
                }
                return;
            }
            if (i11 == 5) {
                if (com.mbridge.msdk.f.b.a()) {
                    this.aN = true;
                    if (this.f47934ag) {
                        return;
                    }
                    g();
                    return;
                }
                return;
            }
            if (i11 == 4) {
                if (com.mbridge.msdk.f.b.a()) {
                    this.aN = false;
                    if (this.f47934ag || isMiniCardShowing()) {
                        return;
                    }
                    h();
                    return;
                }
                return;
            }
            if (i11 != 6 || this.f47934ag) {
                return;
            }
            this.f47954t.release();
            this.f47934ag = true;
            d dVar2 = new d();
            dVar2.a("duration", Long.valueOf(System.currentTimeMillis() - aS));
            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000146", this.f47791b, dVar2);
        }
    }
}
