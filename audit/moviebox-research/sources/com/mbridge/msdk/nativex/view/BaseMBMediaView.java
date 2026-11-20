package com.mbridge.msdk.nativex.view;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.hisavana.common.tracking.TrackingKey;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.iab.omid.library.mmadbridge.adsession.media.PlayerState;
import com.iab.omid.library.mmadbridge.adsession.media.Position;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbnative.controller.NativeController;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.nativex.view.mbfullview.BaseView;
import com.mbridge.msdk.nativex.view.mbfullview.MBridgeFullView;
import com.mbridge.msdk.nativex.view.mbfullview.MBridgeTopFullView;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.out.OnMBMediaViewListener;
import com.mbridge.msdk.out.OnMBMediaViewListenerPlus;
import com.mbridge.msdk.playercommon.VideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.video.signal.communication.IRewardCommunication;
import com.mbridge.msdk.videocommon.download.j;
import com.mbridge.msdk.videocommon.view.MyImageView;
import com.mbridge.msdk.widget.MBAdChoice;
import com.transsion.gslb.Worker;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseMBMediaView extends LinearLayout implements VideoPlayerStatusListener, IRewardCommunication {
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_1_LANDING_PAGE = 1;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_2_NORMAL_FULLSCREEN = 2;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_3_NORMAL_FULLSCREEN_ENDCARD = 3;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_4_NORMAL_FULLSCREEN_LP = 4;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_6_SMALLVIDEO = 6;
    public static final String TAG = "BaseMBMediaView";
    public static final int WHAT_VIEW_FULL_SCREEN = 2;
    public static final int WHAT_VIEW_SMALL_SCREEN = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f45818p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static int f45819q = 1;
    private RelativeLayout A;
    private WindVaneWebViewForNV B;
    private WindVaneWebViewForNV C;
    private MyImageView D;
    private ProgressBar E;
    private View F;
    private BaseView G;
    private RelativeLayout H;
    private RelativeLayout I;
    private TextView J;
    private ProgressBar K;
    private RelativeLayout L;
    private int M;
    private Handler N;
    private CampaignEx O;
    private int P;
    private int Q;
    private double R;
    private double S;
    private int T;
    private int U;
    private e V;
    private SensorManager W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f45820a;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    private Sensor f45821aa;

    /* JADX INFO: renamed from: ab, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f45822ab;

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    private a f45823ac;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    private OnMBMediaViewListener f45824ad;

    /* JADX INFO: renamed from: ae, reason: collision with root package name */
    private OnMBMediaViewListenerPlus f45825ae;

    /* JADX INFO: renamed from: af, reason: collision with root package name */
    private int f45826af;

    /* JADX INFO: renamed from: ag, reason: collision with root package name */
    private boolean f45827ag;

    /* JADX INFO: renamed from: ah, reason: collision with root package name */
    private boolean f45828ah;

    /* JADX INFO: renamed from: ai, reason: collision with root package name */
    private RelativeLayout f45829ai;

    /* JADX INFO: renamed from: aj, reason: collision with root package name */
    private ImageView f45830aj;

    /* JADX INFO: renamed from: ak, reason: collision with root package name */
    private int f45831ak;

    /* JADX INFO: renamed from: al, reason: collision with root package name */
    private boolean f45832al;

    /* JADX INFO: renamed from: am, reason: collision with root package name */
    private Context f45833am;

    /* JADX INFO: renamed from: an, reason: collision with root package name */
    private boolean f45834an;

    /* JADX INFO: renamed from: ao, reason: collision with root package name */
    private Runnable f45835ao;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f45836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f45837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f45838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f45839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f45840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f45841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f45842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f45843i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f45844j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f45845k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f45846l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f45847m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ArrayList<String> f45848n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ArrayList<String> f45849o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f45850r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f45851s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private kn.b f45852t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private kn.a f45853u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.media.a f45854v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f45855w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private MediaViewPlayerView f45856x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private RelativeLayout f45857y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private RelativeLayout f45858z;

    /* JADX INFO: renamed from: com.mbridge.msdk.nativex.view.BaseMBMediaView$10, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass10 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f45860a;

        static {
            int[] iArr = new int[BaseView.a.values().length];
            f45860a = iArr;
            try {
                iArr[BaseView.a.FULL_MIDDLE_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45860a[BaseView.a.FULL_TOP_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum a {
        BIG_IMAGE,
        VIDEO,
        GIF
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<BaseMBMediaView> f45883a;

        public b(BaseMBMediaView baseMBMediaView) {
            this.f45883a = new WeakReference<>(baseMBMediaView);
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseMBMediaView baseMBMediaView = this.f45883a.get();
            if (baseMBMediaView != null) {
                try {
                    if (baseMBMediaView.f45823ac == null || baseMBMediaView.f45823ac != a.BIG_IMAGE) {
                        return;
                    }
                    baseMBMediaView.f();
                    baseMBMediaView.f45823ac = a.VIDEO;
                    baseMBMediaView.changeNoticeURL();
                } catch (Throwable th2) {
                    ad.a(BaseMBMediaView.TAG, th2.getMessage(), th2);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements com.mbridge.msdk.nativex.listener.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<BaseMBMediaView> f45884a;

        public c(BaseMBMediaView baseMBMediaView) {
            this.f45884a = new WeakReference<>(baseMBMediaView);
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public final void a() {
            BaseMBMediaView baseMBMediaView = this.f45884a.get();
            if (baseMBMediaView != null) {
                BaseMBMediaView.M(baseMBMediaView);
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public final void a(String str) {
            BaseMBMediaView baseMBMediaView = this.f45884a.get();
            if (baseMBMediaView != null) {
                baseMBMediaView.a(str);
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public final void b() {
            BaseMBMediaView baseMBMediaView = this.f45884a.get();
            if (baseMBMediaView != null) {
                BaseMBMediaView.N(baseMBMediaView);
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public final void b(String str) {
            BaseMBMediaView baseMBMediaView = this.f45884a.get();
            if (baseMBMediaView != null) {
                baseMBMediaView.b(str);
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public final void c() {
            BaseMBMediaView baseMBMediaView = this.f45884a.get();
            if (baseMBMediaView != null) {
                BaseMBMediaView.O(baseMBMediaView);
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public final void d() {
            BaseMBMediaView baseMBMediaView = this.f45884a.get();
            if (baseMBMediaView != null) {
                BaseMBMediaView.P(baseMBMediaView);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements com.mbridge.msdk.mbsignalcommon.base.a {
        private d() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.base.a
        public final boolean a(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (ah.a.b(str)) {
                        ah.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, (NativeListener.NativeTrackingListener) null);
                        return true;
                    }
                    if (URLUtil.isNetworkUrl(str)) {
                        return false;
                    }
                    ah.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, (BaseTrackingListener) null);
                    return true;
                }
            } catch (Exception e11) {
                ad.b(BaseMBMediaView.TAG, e11.getMessage());
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements SensorEventListener {
        private e() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i11) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            int iRound;
            if (BaseMBMediaView.this.f45832al) {
                return;
            }
            try {
                float[] fArr = sensorEvent.values;
                float f11 = -fArr[0];
                float f12 = -fArr[1];
                float f13 = -fArr[2];
                if (((f11 * f11) + (f12 * f12)) * 4.0f >= f13 * f13) {
                    iRound = 90 - Math.round(((float) Math.atan2(-f12, f11)) * 57.29578f);
                    while (iRound >= 360) {
                        iRound -= 360;
                    }
                    while (iRound < 0) {
                        iRound += 360;
                    }
                } else {
                    iRound = -1;
                }
                float fB = BaseMBMediaView.this.B();
                int iG = ai.g(BaseMBMediaView.this.getContext());
                if ((iRound > 45 && iRound < 135) || (iRound > 225 && iRound < 315)) {
                    if (fB < iG || BaseMBMediaView.this.f45845k) {
                        return;
                    }
                    BaseMBMediaView.this.f45844j = true;
                    BaseMBMediaView.this.f45845k = true;
                    BaseMBMediaView.this.N.postDelayed(new Runnable() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.e.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                com.mbridge.msdk.nativex.view.mbfullview.a.a(BaseMBMediaView.this.getContext()).a(BaseMBMediaView.this.G, BaseMBMediaView.this.f45844j);
                                BaseMBMediaView.this.E();
                                BaseMBMediaView.this.i();
                                BaseMBMediaView.this.g();
                                BaseMBMediaView.this.h();
                                if (BaseMBMediaView.this.C != null) {
                                    BaseMBMediaView.this.C.orientation(BaseMBMediaView.this.f45844j);
                                }
                            } catch (Exception e11) {
                                ad.b(BaseMBMediaView.TAG, e11.getMessage());
                            }
                        }
                    }, 200L);
                    return;
                }
                if (((iRound <= 135 || iRound >= 225) && ((iRound <= 315 || iRound >= 360) && ((iRound < 0 || iRound > 45) && iRound != -1))) || fB > iG || !BaseMBMediaView.this.f45845k) {
                    return;
                }
                BaseMBMediaView.this.f45844j = false;
                BaseMBMediaView.this.f45845k = false;
                BaseMBMediaView.this.N.postDelayed(new Runnable() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.e.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.mbridge.msdk.nativex.view.mbfullview.a.a(BaseMBMediaView.this.getContext()).a(BaseMBMediaView.this.G, BaseMBMediaView.this.f45844j);
                            BaseMBMediaView.this.D();
                            BaseMBMediaView.this.i();
                            BaseMBMediaView.this.g();
                            BaseMBMediaView.this.h();
                            if (BaseMBMediaView.this.C != null) {
                                BaseMBMediaView.this.C.orientation(BaseMBMediaView.this.f45844j);
                            }
                        } catch (Exception e11) {
                            ad.b(BaseMBMediaView.TAG, e11.getMessage());
                        }
                    }
                }, 200L);
            } catch (Throwable th2) {
                ad.a(BaseMBMediaView.TAG, th2.getMessage(), th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements com.mbridge.msdk.videocommon.listener.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<BaseMBMediaView> f45888a;

        public f(BaseMBMediaView baseMBMediaView) {
            this.f45888a = new WeakReference<>(baseMBMediaView);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str) {
            BaseMBMediaView baseMBMediaView = this.f45888a.get();
            if (baseMBMediaView != null) {
                baseMBMediaView.N.post(new b(baseMBMediaView));
            }
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str, String str2) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<BaseMBMediaView> f45889a;

        public g(BaseMBMediaView baseMBMediaView) {
            this.f45889a = new WeakReference<>(baseMBMediaView);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                BaseMBMediaView baseMBMediaView = this.f45889a.get();
                if (baseMBMediaView == null || baseMBMediaView.f45823ac == null || baseMBMediaView.f45823ac != a.BIG_IMAGE) {
                    return;
                }
                baseMBMediaView.m();
                baseMBMediaView.f45823ac = a.GIF;
                baseMBMediaView.changeNoticeURL();
            } catch (Exception e11) {
                ad.b(BaseMBMediaView.TAG, e11.getMessage());
            }
        }
    }

    public BaseMBMediaView(Context context) {
        super(context);
        this.f45836b = true;
        this.f45837c = true;
        this.f45838d = true;
        this.f45839e = true;
        this.f45840f = true;
        this.f45841g = false;
        this.f45842h = true;
        this.f45843i = false;
        this.f45844j = false;
        this.f45845k = false;
        this.f45846l = true;
        this.f45847m = true;
        this.f45848n = new ArrayList<>();
        this.f45849o = new ArrayList<>();
        this.f45850r = false;
        this.f45851s = false;
        this.f45852t = null;
        this.f45853u = null;
        this.f45854v = null;
        this.f45855w = 0;
        this.f45820a = false;
        this.f45822ab = null;
        this.f45823ac = null;
        this.f45827ag = false;
        this.f45828ah = false;
        this.f45832al = false;
        this.f45834an = false;
        this.f45835ao = new Runnable() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.9
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (!BaseMBMediaView.this.f45843i) {
                        BaseMBMediaView baseMBMediaView = BaseMBMediaView.this;
                        if (baseMBMediaView.a((View) baseMBMediaView)) {
                            BaseMBMediaView.S(BaseMBMediaView.this);
                        } else {
                            BaseMBMediaView.R(BaseMBMediaView.this);
                        }
                    }
                    BaseMBMediaView.this.N.postDelayed(this, 300L);
                } catch (Exception e11) {
                    ad.b(BaseMBMediaView.TAG, e11.getMessage());
                }
            }
        };
        a(context);
    }

    public BaseMBMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f45836b = true;
        this.f45837c = true;
        this.f45838d = true;
        this.f45839e = true;
        this.f45840f = true;
        this.f45841g = false;
        this.f45842h = true;
        this.f45843i = false;
        this.f45844j = false;
        this.f45845k = false;
        this.f45846l = true;
        this.f45847m = true;
        this.f45848n = new ArrayList<>();
        this.f45849o = new ArrayList<>();
        this.f45850r = false;
        this.f45851s = false;
        this.f45852t = null;
        this.f45853u = null;
        this.f45854v = null;
        this.f45855w = 0;
        this.f45820a = false;
        this.f45822ab = null;
        this.f45823ac = null;
        this.f45827ag = false;
        this.f45828ah = false;
        this.f45832al = false;
        this.f45834an = false;
        this.f45835ao = new Runnable() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.9
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (!BaseMBMediaView.this.f45843i) {
                        BaseMBMediaView baseMBMediaView = BaseMBMediaView.this;
                        if (baseMBMediaView.a((View) baseMBMediaView)) {
                            BaseMBMediaView.S(BaseMBMediaView.this);
                        } else {
                            BaseMBMediaView.R(BaseMBMediaView.this);
                        }
                    }
                    BaseMBMediaView.this.N.postDelayed(this, 300L);
                } catch (Exception e11) {
                    ad.b(BaseMBMediaView.TAG, e11.getMessage());
                }
            }
        };
        a(context);
    }

    private void A() {
        String[] strArrSplit;
        try {
            CampaignEx campaignEx = this.O;
            if (campaignEx == null || an.a(campaignEx.getVideoResolution()) || (strArrSplit = this.O.getVideoResolution().split("x")) == null || strArrSplit.length != 2) {
                return;
            }
            String str = strArrSplit[0];
            String str2 = strArrSplit[1];
            double dM = ai.m(str);
            double dM2 = ai.m(str2);
            if (dM <= 0.0d || dM2 <= 0.0d) {
                return;
            }
            this.R = dM;
            this.S = dM2;
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float B() {
        try {
            float fH = ai.h(getContext());
            return this.f45844j ? fH + ai.c(getContext()) : fH;
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
            return 0.0f;
        }
    }

    private float C() {
        try {
            float fG = ai.g(getContext());
            return !this.f45844j ? fG + ai.c(getContext()) : fG;
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
            return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        try {
            if (this.I == null && this.f45830aj == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ai.a(getContext(), 30.0f), ai.a(getContext(), 30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = ai.a(getContext(), 8.0f);
            layoutParams.rightMargin = ai.a(getContext(), 8.0f);
            RelativeLayout relativeLayout = this.I;
            if (relativeLayout != null) {
                relativeLayout.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.f45830aj;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            updateViewManger(false);
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        try {
            if (this.I == null && this.f45830aj == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ai.a(getContext(), 30.0f), ai.a(getContext(), 30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            if (this.f45826af == 0 && com.mbridge.msdk.foundation.tools.d.a(getContext())) {
                layoutParams.rightMargin = ai.c(getContext()) + ai.a(getContext(), 8.0f);
            } else {
                layoutParams.rightMargin = ai.a(getContext(), 8.0f);
            }
            layoutParams.topMargin = ai.a(getContext(), 8.0f);
            RelativeLayout relativeLayout = this.I;
            if (relativeLayout != null) {
                relativeLayout.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.f45830aj;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            updateViewManger(true);
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    private void F() {
        try {
            CampaignEx campaignEx = this.O;
            if (campaignEx == null || campaignEx.getNativeVideoTracking() == null) {
                return;
            }
            String[] strArrC = this.O.getNativeVideoTracking().c();
            int i11 = this.f45844j ? f45818p : f45819q;
            for (String str : strArrC) {
                if (!TextUtils.isEmpty(str)) {
                    Context context = getContext();
                    CampaignEx campaignEx2 = this.O;
                    com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), str + "&orienation=" + i11, false, false);
                }
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindVaneWebViewForNV G() {
        try {
            WindVaneWebViewForNV windVaneWebViewForNV = this.C;
            if (windVaneWebViewForNV != null && this.f45828ah) {
                return windVaneWebViewForNV;
            }
            if (this.f45828ah) {
                return null;
            }
            b(true);
            return null;
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
            return null;
        }
    }

    public static /* synthetic */ void M(BaseMBMediaView baseMBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = baseMBMediaView.O;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.f44226f || baseMBMediaView.O.getNativeVideoTracking() == null || baseMBMediaView.O.getNativeVideoTracking().j() == null) {
            return;
        }
        mediaViewHolder.f44226f = true;
        Context context = baseMBMediaView.getContext();
        CampaignEx campaignEx2 = baseMBMediaView.O;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), baseMBMediaView.O.getNativeVideoTracking().j(), false, false);
    }

    public static /* synthetic */ void N(BaseMBMediaView baseMBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = baseMBMediaView.O;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.f44230j || baseMBMediaView.O.getNativeVideoTracking() == null || baseMBMediaView.O.getNativeVideoTracking().k() == null) {
            return;
        }
        mediaViewHolder.f44230j = true;
        Context context = baseMBMediaView.getContext();
        CampaignEx campaignEx2 = baseMBMediaView.O;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), baseMBMediaView.O.getNativeVideoTracking().k(), false, false);
    }

    public static /* synthetic */ void O(BaseMBMediaView baseMBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = baseMBMediaView.O;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.f44227g || baseMBMediaView.O.getNativeVideoTracking() == null || baseMBMediaView.O.getNativeVideoTracking().m() == null) {
            return;
        }
        mediaViewHolder.f44227g = true;
        Context context = baseMBMediaView.getContext();
        CampaignEx campaignEx2 = baseMBMediaView.O;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), baseMBMediaView.O.getNativeVideoTracking().m(), false, false);
    }

    public static /* synthetic */ void P(BaseMBMediaView baseMBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = baseMBMediaView.O;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.f44229i || baseMBMediaView.O.getNativeVideoTracking() == null || baseMBMediaView.O.getNativeVideoTracking().n() == null) {
            return;
        }
        mediaViewHolder.f44229i = true;
        Context context = baseMBMediaView.getContext();
        CampaignEx campaignEx2 = baseMBMediaView.O;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), baseMBMediaView.O.getNativeVideoTracking().n(), false, false);
    }

    public static /* synthetic */ void R(BaseMBMediaView baseMBMediaView) {
        try {
            MediaViewPlayerView mediaViewPlayerView = baseMBMediaView.f45856x;
            if (mediaViewPlayerView != null && mediaViewPlayerView.hasPrepare() && baseMBMediaView.f45856x.isPlaying()) {
                try {
                    MediaViewPlayerView mediaViewPlayerView2 = baseMBMediaView.f45856x;
                    if (mediaViewPlayerView2 != null) {
                        mediaViewPlayerView2.pause();
                    }
                } catch (Throwable th2) {
                    ad.b(TAG, th2.getMessage());
                }
            }
        } catch (Throwable th3) {
            ad.b(TAG, th3.getMessage());
        }
    }

    public static /* synthetic */ void S(BaseMBMediaView baseMBMediaView) {
        try {
            MediaViewPlayerView mediaViewPlayerView = baseMBMediaView.f45856x;
            if (mediaViewPlayerView == null || !mediaViewPlayerView.hasPrepare() || baseMBMediaView.f45856x.isPlaying() || baseMBMediaView.f45856x.isComplete() || !baseMBMediaView.f45856x.hasPrepare()) {
                return;
            }
            baseMBMediaView.f45856x.startOrPlayVideo();
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    private a a(boolean z11) {
        try {
            CampaignEx campaignEx = this.O;
            if (campaignEx == null) {
                return null;
            }
            if (an.a(campaignEx.getVideoUrlEncode())) {
                a aVar = an.b(this.O.getImageUrl()) ? a.BIG_IMAGE : null;
                if (!an.b(this.O.getGifUrl())) {
                    return aVar;
                }
                if (an.a(this.O.getImageUrl())) {
                    aVar = a.GIF;
                }
                this.B.setWebViewClient(new g(this));
                o();
                return aVar;
            }
            if (!this.f45842h || this.f45822ab == null) {
                return a.BIG_IMAGE;
            }
            if (an.b(this.O.getVideoUrlEncode()) && an.a(this.O.getImageUrl())) {
                return a.VIDEO;
            }
            if (!an.b(this.O.getVideoUrlEncode()) || !an.b(this.O.getImageUrl())) {
                return null;
            }
            if (j.a(this.f45822ab, t())) {
                return a.VIDEO;
            }
            a aVar2 = a.BIG_IMAGE;
            if (z11 && this.f45836b) {
                this.f45822ab.b(new f(this));
            }
            return aVar2;
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
            return a.BIG_IMAGE;
        }
    }

    private String a(int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, i11);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            ad.b(TAG, "code to string is error");
            return "";
        }
    }

    private String a(List<CampaignEx> list, String str, String str2) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            JSONArray camplistToJson = CampaignEx.parseCamplistToJson(list);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("campaignList", camplistToJson);
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put("sdk_info", str2);
            return jSONObject.toString();
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
            return null;
        }
    }

    private void a(Context context) {
        try {
            d();
            c();
            this.f45833am = context;
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    private void a(View view, float f11, float f12) {
        if (view == null) {
            return;
        }
        try {
            double d11 = this.R;
            double d12 = 0.0d;
            if (d11 > 0.0d) {
                double d13 = this.S;
                if (d13 > 0.0d) {
                    double d14 = d11 / d13;
                    if (f11 > 0.0f && f12 > 0.0f) {
                        d12 = f11 / f12;
                    }
                    double dA = ai.a(Double.valueOf(d14));
                    double dA2 = ai.a(Double.valueOf(d12));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f45857y.getLayoutParams();
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    boolean z11 = c(getContext()) && this.f45844j;
                    int i11 = -1;
                    if (dA > dA2) {
                        double d15 = (((double) f11) * this.S) / this.R;
                        layoutParams2.width = -1;
                        if (!z11) {
                            i11 = (int) d15;
                        }
                        layoutParams2.height = i11;
                        layoutParams2.addRule(13);
                        layoutParams.width = this.Q;
                        layoutParams.height = (int) d15;
                        layoutParams.addRule(13);
                    } else if (dA < dA2) {
                        double d16 = ((double) f12) * d14;
                        layoutParams2.width = z11 ? -1 : (int) d16;
                        layoutParams2.height = -1;
                        layoutParams2.addRule(13);
                        layoutParams.width = (int) d16;
                        layoutParams.height = this.P;
                        layoutParams.addRule(13);
                    } else {
                        layoutParams2.width = -1;
                        layoutParams2.height = -1;
                        layoutParams.width = this.Q;
                        layoutParams.height = this.P;
                        layoutParams.addRule(13);
                    }
                    if (!this.f45843i) {
                        this.f45857y.setLayoutParams(layoutParams);
                    }
                    view.setLayoutParams(layoutParams2);
                    return;
                }
            }
            b(view);
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    public static /* synthetic */ void a(BaseMBMediaView baseMBMediaView, Campaign campaign, String str) {
        try {
            OnMBMediaViewListener onMBMediaViewListener = baseMBMediaView.f45824ad;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onStartRedirection(campaign, str);
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = baseMBMediaView.f45825ae;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onStartRedirection(campaign, str);
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    public static /* synthetic */ void a(BaseMBMediaView baseMBMediaView, String str) {
        n nVar;
        try {
            q qVarA = q.a(h.a(baseMBMediaView.getContext()));
            if (!TextUtils.isEmpty(baseMBMediaView.O.getNoticeUrl())) {
                int iL = z.l(baseMBMediaView.getContext());
                nVar = new n("2000021", iL, baseMBMediaView.O.getNoticeUrl(), str, z.a(baseMBMediaView.getContext(), iL));
            } else if (TextUtils.isEmpty(baseMBMediaView.O.getClickURL())) {
                nVar = null;
            } else {
                int iL2 = z.l(baseMBMediaView.getContext());
                nVar = new n("2000021", iL2, baseMBMediaView.O.getClickURL(), str, z.a(baseMBMediaView.getContext(), iL2));
            }
            if (nVar != null) {
                nVar.e(baseMBMediaView.O.getId());
                nVar.m(baseMBMediaView.O.getVideoUrlEncode());
                nVar.h(str);
                nVar.f(baseMBMediaView.O.getRequestId());
                nVar.g(baseMBMediaView.O.getRequestIdNotice());
                nVar.c(baseMBMediaView.p());
                qVarA.a(nVar);
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view) {
        try {
            CampaignEx campaignEx = this.O;
            return !aq.a(view, campaignEx == null ? 0 : campaignEx.getImpReportType());
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
            return false;
        }
    }

    private void b() {
        com.mbridge.msdk.videocommon.download.a aVar = this.f45822ab;
        if (aVar != null) {
            aVar.b((com.mbridge.msdk.videocommon.listener.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        try {
            try {
                OnMBMediaViewListener onMBMediaViewListener = this.f45824ad;
                if (onMBMediaViewListener != null) {
                    onMBMediaViewListener.onVideoAdClicked(this.O);
                }
                OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.f45825ae;
                if (onMBMediaViewListenerPlus != null) {
                    onMBMediaViewListenerPlus.onVideoAdClicked(this.O);
                }
            } catch (Exception e11) {
                ad.b(TAG, e11.getMessage());
            }
            if (this.O != null && !an.a(p())) {
                if (!this.O.isReportClick()) {
                    this.O.setReportClick(true);
                    CampaignEx campaignEx = this.O;
                    if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && this.O.getNativeVideoTracking().l() != null) {
                        Context context2 = getContext();
                        CampaignEx campaignEx2 = this.O;
                        com.mbridge.msdk.click.a.a(context2, campaignEx2, campaignEx2.getCampaignUnitId(), this.O.getNativeVideoTracking().l(), false, false);
                    }
                }
                com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(getContext(), p());
                aVar.a(new NativeListener.NativeTrackingListener() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.14
                    @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                    public final void onDismissLoading(Campaign campaign) {
                    }

                    @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                    public final void onDownloadFinish(Campaign campaign) {
                    }

                    @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                    public final void onDownloadProgress(int i11) {
                    }

                    @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                    public final void onDownloadStart(Campaign campaign) {
                    }

                    @Override // com.mbridge.msdk.out.BaseTrackingListener
                    public final void onFinishRedirection(Campaign campaign, String str) {
                        try {
                            BaseMBMediaView.o(BaseMBMediaView.this);
                            BaseMBMediaView.p(BaseMBMediaView.this);
                            BaseMBMediaView.c(BaseMBMediaView.this, campaign, str);
                        } catch (Exception e12) {
                            ad.b(BaseMBMediaView.TAG, e12.getMessage());
                        }
                    }

                    @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                    public final boolean onInterceptDefaultLoadingDialog() {
                        return true;
                    }

                    @Override // com.mbridge.msdk.out.BaseTrackingListener
                    public final void onRedirectionFailed(Campaign campaign, String str) {
                        try {
                            BaseMBMediaView.o(BaseMBMediaView.this);
                            BaseMBMediaView.p(BaseMBMediaView.this);
                            BaseMBMediaView.b(BaseMBMediaView.this, campaign, str);
                        } catch (Exception e12) {
                            ad.b(BaseMBMediaView.TAG, e12.getMessage());
                        }
                    }

                    @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                    public final void onShowLoading(Campaign campaign) {
                    }

                    @Override // com.mbridge.msdk.out.BaseTrackingListener
                    public final void onStartRedirection(Campaign campaign, String str) {
                        try {
                            BaseMBMediaView.m(BaseMBMediaView.this);
                            BaseMBMediaView.n(BaseMBMediaView.this);
                            BaseMBMediaView.a(BaseMBMediaView.this, campaign, str);
                        } catch (Exception e12) {
                            ad.b(BaseMBMediaView.TAG, e12.getMessage());
                        }
                    }
                });
                aVar.a(this.O);
            }
        } catch (Exception e12) {
            ad.b(TAG, e12.getMessage());
        }
    }

    private void b(View view) {
        if (view == null) {
            return;
        }
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = -1;
            if (this.f45844j) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = (((int) B()) * 9) / 16;
                layoutParams.addRule(13);
            }
            view.setLayoutParams(layoutParams);
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    public static /* synthetic */ void b(BaseMBMediaView baseMBMediaView) {
        CampaignEx campaignEx = baseMBMediaView.O;
        if (campaignEx == null || campaignEx.getMediaViewHolder() == null) {
            return;
        }
        com.mbridge.msdk.foundation.controller.c.m().a(baseMBMediaView.getContext());
        com.mbridge.msdk.mbnative.e.b.a(baseMBMediaView.O, baseMBMediaView.getContext(), baseMBMediaView.p(), null);
        CampaignEx.b mediaViewHolder = baseMBMediaView.O.getMediaViewHolder();
        if (!mediaViewHolder.f44232l && baseMBMediaView.f45823ac == a.VIDEO && an.b(baseMBMediaView.O.getImpressionURL())) {
            mediaViewHolder.f44232l = true;
            String impressionURL = baseMBMediaView.O.getImpressionURL();
            if (!impressionURL.contains("is_video=1")) {
                StringBuilder sb2 = new StringBuilder(impressionURL);
                if (impressionURL.contains("?")) {
                    sb2.append("&is_video=1");
                } else {
                    sb2.append("?is_video=1");
                }
                impressionURL = sb2.toString();
            }
            Context context = baseMBMediaView.getContext();
            CampaignEx campaignEx2 = baseMBMediaView.O;
            com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), impressionURL, false, true, com.mbridge.msdk.click.a.a.f43072g);
        }
    }

    public static /* synthetic */ void b(BaseMBMediaView baseMBMediaView, Campaign campaign, String str) {
        try {
            OnMBMediaViewListener onMBMediaViewListener = baseMBMediaView.f45824ad;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onRedirectionFailed(campaign, str);
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = baseMBMediaView.f45825ae;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onRedirectionFailed(campaign, str);
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    private void b(boolean z11) {
        try {
            int nvT2 = this.O.getNvT2();
            if (this.C == null) {
                WindVaneWebViewForNV windVaneWebViewForNV = new WindVaneWebViewForNV(getContext());
                this.C = windVaneWebViewForNV;
                windVaneWebViewForNV.setObject(this);
                this.C.setBackListener(new com.mbridge.msdk.nativex.listener.b() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.6
                    @Override // com.mbridge.msdk.nativex.listener.b
                    public final void a() {
                        BaseMBMediaView.this.exitFullScreen();
                    }
                });
                this.C.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.7
                    @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                    public final void a(WebView webView, int i11, String str, String str2) {
                        super.a(webView, i11, str, str2);
                        BaseMBMediaView.this.f45827ag = false;
                    }

                    @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                    public final void a(WebView webView, String str) {
                        super.a(webView, str);
                        BaseMBMediaView.this.f45827ag = true;
                    }
                });
            }
            if (nvT2 != 3) {
                if (nvT2 == 4) {
                    this.f45828ah = true;
                    CampaignEx campaignEx = this.O;
                    if (campaignEx != null) {
                        com.mbridge.msdk.foundation.same.g.a aVar = new com.mbridge.msdk.foundation.same.g.a(campaignEx);
                        aVar.a(this.O.getAppName());
                        this.C.setDownloadListener(aVar);
                        this.C.setFilter(new d());
                        return;
                    }
                    return;
                }
                return;
            }
            String str = this.O.getendcard_url();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.O.getMediaViewHolder();
            if (str.contains(".zip") && str.contains(ResourceManager.KEY_MD5FILENAME)) {
                String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(str);
                if (an.b(h5ResAddress)) {
                    this.f45828ah = true;
                    this.C.loadUrl(h5ResAddress);
                    return;
                }
                return;
            }
            String htmlContentFromUrl = HTMLResourceManager.getInstance().getHtmlContentFromUrl(str);
            if (an.b(htmlContentFromUrl)) {
                ad.a(TAG, "load html...");
                this.f45828ah = true;
                this.C.loadDataWithBaseURL(str, htmlContentFromUrl, "text/html", "UTF-8", null);
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    private void c() {
        int iA = v.a(getContext(), "mbridge_nativex_mbmediaview", TtmlNode.TAG_LAYOUT);
        if (iA == -1) {
            ad.b(TAG, "can not find mediaview resource");
            return;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(iA, (ViewGroup) null);
        this.f45858z = (RelativeLayout) viewInflate.findViewById(v.a(getContext(), "mbridge_rl_mediaview_root", "id"));
        this.f45857y = (RelativeLayout) viewInflate.findViewById(v.a(getContext(), "mbridge_ll_playerview_container", "id"));
        this.D = (MyImageView) viewInflate.findViewById(v.a(getContext(), "mbridge_my_big_img", "id"));
        this.E = (ProgressBar) viewInflate.findViewById(v.a(getContext(), "mbridge_native_pb", "id"));
        this.A = (RelativeLayout) viewInflate.findViewById(v.a(getContext(), "mbridge_nativex_webview_layout", "id"));
        this.B = (WindVaneWebViewForNV) viewInflate.findViewById(v.a(getContext(), "mbridge_nativex_webview_layout_webview", "id"));
        this.f45858z.setClickable(true);
        addView(viewInflate, -1, -1);
    }

    public static /* synthetic */ void c(BaseMBMediaView baseMBMediaView, Campaign campaign, String str) {
        try {
            OnMBMediaViewListener onMBMediaViewListener = baseMBMediaView.f45824ad;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onFinishRedirection(campaign, str);
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = baseMBMediaView.f45825ae;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onFinishRedirection(campaign, str);
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    private boolean c(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private void d() {
        this.N = new Handler() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                Object obj;
                if (message != null) {
                    try {
                        int i11 = message.what;
                        if (i11 == 1) {
                            BaseMBMediaView.this.r();
                        } else if (i11 == 3 && (obj = message.obj) != null && (obj instanceof View)) {
                            if (BaseMBMediaView.this.a((View) obj)) {
                                BaseMBMediaView.b(BaseMBMediaView.this);
                            }
                        }
                    } catch (Exception e11) {
                        ad.b(BaseMBMediaView.TAG, e11.getMessage());
                    }
                }
            }
        };
    }

    public static /* synthetic */ void d(BaseMBMediaView baseMBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = baseMBMediaView.O;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.f44231k || baseMBMediaView.O.getNativeVideoTracking() == null || baseMBMediaView.O.getNativeVideoTracking().t() == null) {
            return;
        }
        mediaViewHolder.f44231k = true;
        Context context = baseMBMediaView.getContext();
        CampaignEx campaignEx2 = baseMBMediaView.O;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), baseMBMediaView.O.getNativeVideoTracking().t(), false, false);
    }

    private void e() {
        kn.b bVar;
        try {
            this.f45823ac = a(true);
            changeNoticeURL();
            a aVar = this.f45823ac;
            if (aVar == a.BIG_IMAGE) {
                CampaignEx campaignEx = this.O;
                if (campaignEx != null && TextUtils.isEmpty(campaignEx.getVideoUrlEncode()) && (bVar = this.f45852t) != null) {
                    try {
                        bVar.d(this.D);
                        this.f45853u = kn.a.a(this.f45852t);
                        this.f45852t.g();
                        kn.a aVar2 = this.f45853u;
                        if (aVar2 != null) {
                            aVar2.b();
                        }
                    } catch (Exception e11) {
                        ad.a("omsdk", e11.getMessage());
                    }
                }
                k();
                n();
            } else if (aVar == a.VIDEO) {
                f();
            } else if (aVar == a.GIF) {
                o();
                m();
            }
            this.f45850r = true;
        } catch (Throwable th2) {
            ad.a(TAG, th2.getMessage(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        A();
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int i11;
        int i12;
        int i13;
        try {
            if (this.f45823ac != a.BIG_IMAGE || (i11 = this.Q) == 0 || (i12 = this.U) == 0 || (i13 = this.T) == 0) {
                return;
            }
            int i14 = (i11 * i12) / i13;
            MyImageView myImageView = this.D;
            if (myImageView == null || i14 == 0) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) myImageView.getLayoutParams();
            layoutParams.width = this.Q;
            layoutParams.height = i14;
            this.D.setLayoutParams(layoutParams);
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        RelativeLayout relativeLayout;
        int i11;
        int i12;
        try {
            if (this.f45823ac == a.GIF) {
                int i13 = this.Q;
                if (i13 != 0 && (i11 = this.U) != 0 && (i12 = this.T) != 0) {
                    int i14 = (i13 * i11) / i12;
                    RelativeLayout relativeLayout2 = this.A;
                    if (relativeLayout2 != null && i14 != 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
                        layoutParams.width = this.Q;
                        layoutParams.height = i14;
                        layoutParams.addRule(13);
                        this.A.setLayoutParams(layoutParams);
                    }
                } else if (i13 != 0 && (relativeLayout = this.A) != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                    int i15 = this.Q;
                    layoutParams2.width = i15;
                    layoutParams2.height = (i15 * 627) / 1200;
                    layoutParams2.addRule(13);
                    this.A.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    public static /* synthetic */ void h(BaseMBMediaView baseMBMediaView) {
        try {
            MediaViewPlayerView mediaViewPlayerView = baseMBMediaView.f45856x;
            if (mediaViewPlayerView == null) {
                return;
            }
            mediaViewPlayerView.onClickPlayerView();
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (this.f45823ac != a.VIDEO || this.f45857y == null) {
                return;
            }
            int iB = (int) B();
            int iG = ai.g(getContext());
            if (this.f45843i) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.H.getLayoutParams();
                layoutParams.width = iB;
                layoutParams.height = iG;
                layoutParams.addRule(13);
                this.H.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f45857y.getLayoutParams();
                layoutParams2.width = this.Q;
                layoutParams2.height = this.P;
                layoutParams2.addRule(13);
                this.f45857y.setLayoutParams(layoutParams2);
            }
            r();
            if (this.f45843i) {
                a(this.f45856x, iB, iG);
            } else {
                a(this.f45856x, this.Q, this.P);
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    private void j() {
        try {
            this.f45856x.showSoundIndicator(this.f45847m);
            this.f45856x.showProgressView(this.f45846l);
            OnMBMediaViewListener onMBMediaViewListener = this.f45824ad;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onExitFullscreen();
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.f45825ae;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onExitFullscreen();
            }
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f45854v;
            if (aVar != null) {
                aVar.k(PlayerState.NORMAL);
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    private void k() {
        try {
            ai.a((ImageView) this.D);
            this.D.setVisibility(0);
            this.f45857y.setVisibility(8);
            this.A.setVisibility(8);
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    private void l() {
        try {
            this.f45857y.setVisibility(0);
            this.D.setVisibility(8);
            this.A.setVisibility(8);
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            this.f45857y.setVisibility(8);
            this.D.setVisibility(8);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    public static /* synthetic */ void m(BaseMBMediaView baseMBMediaView) {
        try {
            ProgressBar progressBar = baseMBMediaView.E;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    private void n() {
        try {
            CampaignEx campaignEx = this.O;
            if (campaignEx == null) {
                return;
            }
            String imageUrl = campaignEx.getImageUrl();
            if (an.a(imageUrl) || getContext() == null) {
                return;
            }
            com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(imageUrl, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.12
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    if (BaseMBMediaView.this.D == null || BaseMBMediaView.this.f45823ac != a.BIG_IMAGE) {
                        return;
                    }
                    if (bitmap != null) {
                        BaseMBMediaView.this.T = bitmap.getWidth();
                        BaseMBMediaView.this.U = bitmap.getHeight();
                        BaseMBMediaView.this.D.setImageUrl(str);
                        BaseMBMediaView.this.D.setImageBitmap(bitmap);
                    }
                    BaseMBMediaView.this.D.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.12.1
                        @Override // com.mbridge.msdk.widget.a
                        public final void a(View view) {
                            if (BaseMBMediaView.this.f45833am == null) {
                                BaseMBMediaView.this.b(view.getContext());
                            } else {
                                BaseMBMediaView baseMBMediaView = BaseMBMediaView.this;
                                baseMBMediaView.b(baseMBMediaView.f45833am);
                            }
                        }
                    });
                }
            });
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    public static /* synthetic */ void n(BaseMBMediaView baseMBMediaView) {
        try {
            ProgressBar progressBar = baseMBMediaView.K;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    private void o() {
        try {
            CampaignEx campaignEx = this.O;
            if (campaignEx == null) {
                return;
            }
            String gifUrl = campaignEx.getGifUrl();
            if (an.a(gifUrl) || getContext() == null) {
                return;
            }
            this.B.loadDataWithBaseURL(null, "<!DOCTYPE html><html lang=\"en\"><head>  <meta charset=\"UTF-8\">  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">  <title>Document</title>  <style>  *{    margin: 0;    padding: 0;  }  html, body{    width: 100%;    height: 100%;  }  body{    background-image: url('gifUrl');    background-position: center;    background-size: contain;    background-repeat: no-repeat;  }  </style></head><body></body></html>".replace("gifUrl", gifUrl), "text/html", "utf-8", null);
            this.B.setInterceptTouch(true);
            this.A.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.13
                @Override // com.mbridge.msdk.widget.a
                public final void a(View view) {
                    if (BaseMBMediaView.this.f45833am != null) {
                        BaseMBMediaView baseMBMediaView = BaseMBMediaView.this;
                        baseMBMediaView.b(baseMBMediaView.f45833am);
                    } else {
                        BaseMBMediaView.this.b(view.getContext());
                    }
                    ad.c(BaseMBMediaView.TAG, "CLICK WEBVIEW LAYOUT ");
                }
            });
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    public static /* synthetic */ void o(BaseMBMediaView baseMBMediaView) {
        try {
            ProgressBar progressBar = baseMBMediaView.E;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p() {
        try {
            CampaignEx campaignEx = this.O;
            if (campaignEx == null || !an.b(campaignEx.getCampaignUnitId())) {
                return null;
            }
            return this.O.getCampaignUnitId();
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
            return null;
        }
    }

    public static /* synthetic */ void p(BaseMBMediaView baseMBMediaView) {
        try {
            ProgressBar progressBar = baseMBMediaView.K;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    private void q() {
        try {
            if (this.O == null) {
                ad.c(TAG, "campaign is null addPlayerView return");
            }
            MediaViewPlayerView mediaViewPlayerView = this.f45856x;
            if (mediaViewPlayerView != null && mediaViewPlayerView.getParent() != null) {
                ((ViewGroup) this.f45856x.getParent()).removeView(this.f45856x);
            }
            l();
            MediaViewPlayerView mediaViewPlayerView2 = new MediaViewPlayerView(getContext());
            this.f45856x = mediaViewPlayerView2;
            mediaViewPlayerView2.showProgressView(this.f45846l);
            this.f45856x.showSoundIndicator(this.f45847m);
            if (this.f45841g) {
                this.f45856x.openSound();
            } else {
                this.f45856x.closeSound();
            }
            this.f45856x.setAllowLoopPlay(this.f45837c);
            this.f45856x.initPlayerViewData(s(), this.O, v(), this, this.f45822ab, p());
            this.f45856x.setOnMediaViewPlayerViewListener(new c(this));
            this.f45857y.addView(this.f45856x, -1, -1);
            try {
                MediaViewPlayerView mediaViewPlayerView3 = this.f45856x;
                if (mediaViewPlayerView3 != null) {
                    mediaViewPlayerView3.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.11
                        @Override // com.mbridge.msdk.widget.a
                        public final void a(View view) {
                            try {
                                if (!BaseMBMediaView.this.f45843i) {
                                    BaseMBMediaView.d(BaseMBMediaView.this);
                                }
                                BaseMBMediaView.this.f45856x.showSoundIndicator(true);
                                BaseMBMediaView.this.f45856x.showProgressView(true);
                                if (BaseMBMediaView.this.f45839e && !BaseMBMediaView.this.f45843i && (BaseMBMediaView.this.F == null || BaseMBMediaView.this.F.getParent() == null)) {
                                    if (!BaseMBMediaView.this.f45856x.halfLoadingViewisVisible() && BaseMBMediaView.this.f45856x.isPlaying()) {
                                        BaseMBMediaView.this.a();
                                        return;
                                    }
                                    ad.c(BaseMBMediaView.TAG, "is loading or no playing return;");
                                    return;
                                }
                                if (BaseMBMediaView.this.f45843i) {
                                    ad.c(BaseMBMediaView.TAG, "fullScreenShowUI");
                                    BaseMBMediaView.h(BaseMBMediaView.this);
                                    return;
                                }
                                if (BaseMBMediaView.this.f45833am != null) {
                                    BaseMBMediaView baseMBMediaView = BaseMBMediaView.this;
                                    baseMBMediaView.b(baseMBMediaView.f45833am);
                                } else {
                                    BaseMBMediaView.this.b(view.getContext());
                                }
                                if (BaseMBMediaView.this.f45854v != null) {
                                    BaseMBMediaView.this.f45854v.a(InteractionType.CLICK);
                                }
                            } catch (Throwable th2) {
                                ad.a(BaseMBMediaView.TAG, th2.getMessage(), th2);
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                ad.b(TAG, th2.getMessage());
            }
            kn.b bVar = this.f45852t;
            if (bVar != null) {
                MediaViewPlayerView mediaViewPlayerView4 = this.f45856x;
                if (mediaViewPlayerView4 != null) {
                    mediaViewPlayerView4.registerView(bVar);
                }
                this.f45853u = kn.a.a(this.f45852t);
                this.f45854v = com.iab.omid.library.mmadbridge.adsession.media.a.g(this.f45852t);
                this.f45852t.g();
                this.f45853u.c(com.iab.omid.library.mmadbridge.adsession.media.b.b(true, Position.STANDALONE));
                MediaViewPlayerView mediaViewPlayerView5 = this.f45856x;
                if (mediaViewPlayerView5 != null) {
                    mediaViewPlayerView5.setVideoEvents(this.f45854v);
                }
                try {
                    kn.a aVar = this.f45853u;
                    if (aVar != null) {
                        aVar.b();
                    }
                } catch (Exception e11) {
                    ad.a("omsdk", e11.getMessage());
                }
            }
        } catch (Throwable th3) {
            ad.b(TAG, th3.getMessage());
        }
    }

    public static /* synthetic */ void q(BaseMBMediaView baseMBMediaView) {
        CampaignEx campaignEx = baseMBMediaView.O;
        if (campaignEx == null || campaignEx.getMediaViewHolder() == null || baseMBMediaView.O.getMediaViewHolder().f44224d || TextUtils.isEmpty(baseMBMediaView.O.getCampaignUnitId()) || baseMBMediaView.O.getNativeVideoTracking() == null || baseMBMediaView.O.getNativeVideoTracking().o() == null) {
            return;
        }
        baseMBMediaView.O.getMediaViewHolder().f44224d = true;
        Context context = baseMBMediaView.getContext();
        CampaignEx campaignEx2 = baseMBMediaView.O;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), baseMBMediaView.O.getNativeVideoTracking().o(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        try {
            if (getVisibility() != 0) {
                return;
            }
            if (a((View) this)) {
                k kVarU = u();
                int i11 = 0;
                int iL = kVarU != null ? kVarU.l() : 0;
                CampaignEx campaignEx = this.O;
                if (campaignEx == null || campaignEx.getImpReportType() != 1) {
                    i11 = iL;
                }
                Message messageObtainMessage = this.N.obtainMessage();
                messageObtainMessage.what = 3;
                messageObtainMessage.obj = this;
                this.N.sendMessageDelayed(messageObtainMessage, (i11 == 0 ? 0L : ((long) i11) * 1000) + 300);
            }
            if (this.f45823ac == a.VIDEO) {
                MediaViewPlayerView mediaViewPlayerView = this.f45856x;
                if (mediaViewPlayerView == null) {
                    q();
                    return;
                }
                if (this.O != mediaViewPlayerView.getCampaign()) {
                    this.f45856x.release();
                    q();
                    if (getParent() != null) {
                        ((View) getParent()).invalidate();
                    }
                    requestLayout();
                }
            }
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    private String s() {
        try {
            if (this.O == null) {
                return null;
            }
            com.mbridge.msdk.videocommon.download.a aVar = this.f45822ab;
            if (aVar != null && aVar.k() == 5) {
                String strH = this.f45822ab.h();
                if (new File(strH).exists()) {
                    if (!this.f45822ab.i()) {
                        if (this.f45822ab.j() == ai.a(new File(strH))) {
                        }
                    }
                    return strH;
                }
            }
            String videoUrlEncode = this.O.getVideoUrlEncode();
            if (an.b(videoUrlEncode)) {
                return videoUrlEncode;
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
        return null;
    }

    private int t() {
        if (u() != null) {
            return u().p();
        }
        return 100;
    }

    private k u() {
        try {
            CampaignEx campaignEx = this.O;
            if (campaignEx != null && !an.a(campaignEx.getCampaignUnitId())) {
                String campaignUnitId = this.O.getCampaignUnitId();
                String strK = com.mbridge.msdk.foundation.controller.c.m().k();
                if (!an.a(campaignUnitId) && !an.a(strK)) {
                    k kVarD = com.mbridge.msdk.c.h.a().d(strK, campaignUnitId);
                    return kVarD != null ? kVarD : k.d(campaignUnitId);
                }
                return k.d(campaignUnitId);
            }
            return null;
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
            return null;
        }
    }

    private boolean v() {
        try {
            k kVarU = u();
            if (kVarU == null) {
                return false;
            }
            int iV = kVarU.v();
            if (iV == 1) {
                return ai.m(getContext());
            }
            if (iV == 2) {
                return false;
            }
            if (iV == 3) {
                return ai.k(getContext());
            }
            return ai.m(getContext());
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View w() {
        try {
            this.f45829ai = new RelativeLayout(getContext());
            this.f45829ai.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            ImageView imageView = new ImageView(getContext());
            this.f45830aj = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ai.a(getContext(), 30.0f), ai.a(getContext(), 30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = ai.a(getContext(), 8.0f);
            layoutParams.rightMargin = ai.a(getContext(), 8.0f);
            this.f45830aj.setLayoutParams(layoutParams);
            this.f45830aj.setBackgroundResource(v.a(getContext(), "mbridge_nativex_close", "drawable"));
            this.f45830aj.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseMBMediaView.this.exitFullScreen();
                }
            });
            this.C.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f45829ai.addView(this.C);
            this.f45829ai.addView(this.f45830aj);
            return this.f45829ai;
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        try {
            FrameLayout frameLayout = (FrameLayout) getRootView().findViewById(R.id.content);
            FrameLayout frameLayout2 = (FrameLayout) getRootView().findViewById(100);
            RelativeLayout relativeLayout = (RelativeLayout) getRootView().findViewById(101);
            RelativeLayout relativeLayout2 = (RelativeLayout) getRootView().findViewById(Worker.WHAT_SYNC_DATA);
            if (relativeLayout2 == null && relativeLayout != null) {
                relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(Worker.WHAT_SYNC_DATA);
            }
            RelativeLayout relativeLayout3 = (RelativeLayout) getRootView().findViewById(v.a(getContext(), "mbridge_full_rl_playcontainer", "id"));
            if (relativeLayout3 == null && relativeLayout2 != null) {
                relativeLayout3 = (RelativeLayout) relativeLayout2.findViewById(v.a(getContext(), "mbridge_full_rl_playcontainer", "id"));
            }
            RelativeLayout relativeLayout4 = (RelativeLayout) getRootView().findViewById(v.a(getContext(), "mbridge_full_player_parent", "id"));
            if (relativeLayout4 == null && relativeLayout3 != null) {
                relativeLayout4 = (RelativeLayout) relativeLayout3.findViewById(v.a(getContext(), "mbridge_full_player_parent", "id"));
            }
            ProgressBar progressBar = (ProgressBar) getRootView().findViewById(v.a(getContext(), "mbridge_full_pb_loading", "id"));
            RelativeLayout relativeLayout5 = (RelativeLayout) getRootView().findViewById(v.a(getContext(), "mbridge_full_rl_install", "id"));
            LinearLayout linearLayout = (LinearLayout) getRootView().findViewById(v.a(getContext(), "mbridge_full_ll_pro_dur", "id"));
            ViewGroup viewGroup = frameLayout2 != null ? (ViewGroup) frameLayout2.getParent() : null;
            if (relativeLayout2 != null) {
                relativeLayout2.removeView(linearLayout);
            } else if (linearLayout != null && linearLayout.getParent() != null) {
                ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
            }
            RelativeLayout relativeLayout6 = this.f45829ai;
            if (relativeLayout6 != null) {
                if (relativeLayout2 != null) {
                    relativeLayout2.removeView(relativeLayout6);
                } else if (relativeLayout6.getParent() != null) {
                    ((ViewGroup) this.f45829ai.getParent()).removeView(this.f45829ai);
                }
                this.C.setBackListener(null);
                this.C.setObject(null);
                this.C = null;
                this.f45829ai = null;
            }
            if (relativeLayout2 != null) {
                relativeLayout2.removeView(relativeLayout5);
            } else if (relativeLayout5 != null && relativeLayout5.getParent() != null) {
                ((ViewGroup) relativeLayout5.getParent()).removeView(relativeLayout5);
            }
            if (relativeLayout2 != null) {
                relativeLayout2.removeView(progressBar);
            } else if (progressBar != null && progressBar.getParent() != null) {
                ((ViewGroup) progressBar.getParent()).removeView(progressBar);
            }
            if (relativeLayout4 != null) {
                relativeLayout4.removeView(this.f45856x);
            }
            if (relativeLayout3 != null) {
                relativeLayout3.removeView(relativeLayout4);
            } else if (relativeLayout4 != null && relativeLayout4.getParent() != null) {
                ((ViewGroup) relativeLayout4.getParent()).removeView(relativeLayout4);
            }
            if (relativeLayout2 != null) {
                relativeLayout2.removeView(relativeLayout3);
            } else if (relativeLayout3 == null || relativeLayout3.getParent() == null) {
                BaseView baseView = this.G;
                if (baseView != null) {
                    baseView.removeView(this.H);
                }
            } else {
                ((ViewGroup) relativeLayout3.getParent()).removeView(relativeLayout3);
            }
            if (relativeLayout != null) {
                relativeLayout.removeView(relativeLayout2);
            } else if (relativeLayout2 == null || relativeLayout2.getParent() == null) {
                View view = this.F;
                if (view != null) {
                    ((ViewGroup) view).removeView(this.G);
                    ((ViewGroup) this.F.getParent()).removeView(this.F);
                }
            } else {
                ((ViewGroup) relativeLayout2.getParent()).removeView(relativeLayout2);
            }
            if (frameLayout != null) {
                if (relativeLayout != null) {
                    frameLayout.removeView(relativeLayout);
                } else {
                    frameLayout.removeView(this.F);
                    if (this.F.getParent() != null) {
                        ((ViewGroup) this.F.getParent()).removeView(this.F);
                        this.F.setVisibility(8);
                    }
                }
            }
            setVisibility(0);
            requestLayout();
            if (viewGroup != null) {
                if (this.f45856x.getParent() != null && this.f45856x.getParent() != viewGroup) {
                    ((ViewGroup) this.f45856x.getParent()).removeView(this.f45856x);
                }
                viewGroup.addView(this.f45856x, this.M);
                viewGroup.removeView(frameLayout2);
                viewGroup.invalidate();
            }
            j();
            this.f45843i = false;
            MediaViewPlayerView mediaViewPlayerView = this.f45856x;
            if (mediaViewPlayerView != null) {
                mediaViewPlayerView.setExitFullScreen();
                if (this.f45841g) {
                    this.f45856x.openSound();
                } else {
                    this.f45856x.closeSound();
                }
                this.f45856x.gonePauseView();
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    private boolean y() {
        try {
            this.H = this.G.getMBridgeFullPlayContainer();
            this.L = this.G.getMBridgeFullPlayerParent();
            this.I = this.G.getMBridgeFullClose();
            this.J = this.G.getMBridgeFullTvInstall();
            this.K = this.G.getMBridgeFullPb();
            return true;
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
            return false;
        }
    }

    private void z() {
        try {
            this.f45844j = ai.h(getContext()) >= ai.g(getContext());
            this.f45845k = this.f45844j;
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    public final void a() {
        BitmapDrawable bitmapDrawableA;
        CampaignEx campaignEx;
        try {
            if (getRootView() != null && (getRootView() instanceof ViewGroup)) {
                BaseView.a aVarHandleViewStyleResult = handleViewStyleResult(getContext());
                if (aVarHandleViewStyleResult == null) {
                    return;
                }
                BaseView fullScreenViewByStyle = getFullScreenViewByStyle(getContext(), aVarHandleViewStyleResult);
                this.G = fullScreenViewByStyle;
                if (fullScreenViewByStyle != null && y()) {
                    com.mbridge.msdk.nativex.view.mbfullview.a aVarA = com.mbridge.msdk.nativex.view.mbfullview.a.a(getContext());
                    BaseView baseView = this.G;
                    aVarA.a(baseView.style, this.O, baseView);
                    this.f45843i = true;
                    this.f45851s = false;
                    MediaViewPlayerView mediaViewPlayerView = this.f45856x;
                    if (mediaViewPlayerView != null) {
                        mediaViewPlayerView.setEnterFullScreen();
                        this.f45856x.setIsActivePause(false);
                    }
                    try {
                        OnMBMediaViewListener onMBMediaViewListener = this.f45824ad;
                        if (onMBMediaViewListener != null) {
                            onMBMediaViewListener.onEnterFullscreen();
                        }
                        OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.f45825ae;
                        if (onMBMediaViewListenerPlus != null) {
                            onMBMediaViewListenerPlus.onEnterFullscreen();
                        }
                        com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f45854v;
                        if (aVar != null) {
                            aVar.k(PlayerState.FULLSCREEN);
                        }
                    } catch (Exception e11) {
                        ad.b(TAG, e11.getMessage());
                    }
                    FrameLayout frameLayout = (FrameLayout) getRootView().findViewById(R.id.content);
                    RelativeLayout relativeLayout = new RelativeLayout(getContext());
                    this.F = relativeLayout;
                    relativeLayout.setClickable(true);
                    ViewGroup viewGroup = (ViewGroup) this.f45856x.getParent();
                    int childCount = viewGroup.getChildCount();
                    int i11 = 0;
                    while (i11 < childCount && viewGroup.getChildAt(i11) != this.f45856x) {
                        i11++;
                    }
                    this.M = i11;
                    FrameLayout frameLayout2 = new FrameLayout(getContext());
                    frameLayout2.setId(100);
                    viewGroup.addView(frameLayout2, i11, new ViewGroup.LayoutParams(getWidth(), getHeight()));
                    viewGroup.removeView(this.f45856x);
                    ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    relativeLayout.setId(101);
                    new RelativeLayout.LayoutParams(-1, -1);
                    this.L.addView(this.f45856x, new RelativeLayout.LayoutParams(-1, -1));
                    if (this.L != null && (campaignEx = this.O) != null && campaignEx.getPrivacyButtonTemplateVisibility() != 0) {
                        try {
                            MBAdChoice mBAdChoice = new MBAdChoice(com.mbridge.msdk.foundation.controller.c.m().c());
                            mBAdChoice.setCampaign(this.O);
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f), ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f));
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(12);
                            this.L.addView(mBAdChoice, layoutParams2);
                        } catch (Exception e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (this.f45820a && frameLayout != null && (bitmapDrawableA = com.mbridge.msdk.foundation.controller.c.m().a(p(), this.O.getAdType())) != null) {
                        ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
                        ai.a(imageView, bitmapDrawableA, getResources().getDisplayMetrics());
                        this.G.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
                    }
                    frameLayout.addView(relativeLayout, layoutParams);
                    int i12 = AnonymousClass10.f45860a[this.G.style.ordinal()] != 2 ? ViewCompat.MEASURED_STATE_MASK : -1;
                    int i13 = this.f45855w;
                    if (i13 != 0) {
                        relativeLayout.setBackgroundColor(i13);
                    } else {
                        relativeLayout.setBackgroundColor(i12);
                    }
                    this.G.setId(Worker.WHAT_SYNC_DATA);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                    int[] iArr = new int[2];
                    frameLayout.getLocationInWindow(iArr);
                    int i14 = iArr[1];
                    this.f45826af = i14;
                    if (i14 == 0) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            WindowInsets rootWindowInsets = getRootWindowInsets();
                            if (rootWindowInsets != null) {
                                layoutParams3.setMargins(0, rootWindowInsets.getStableInsetTop(), 0, 0);
                            }
                        } else {
                            layoutParams3.setMargins(0, ai.j(getContext()), 0, 0);
                        }
                    }
                    relativeLayout.addView(this.G, layoutParams3);
                    try {
                        z();
                        a(this.H, B(), C());
                        com.mbridge.msdk.nativex.view.mbfullview.a.a(getContext()).a(this.G, this.f45844j);
                        if (this.f45844j) {
                            E();
                        } else {
                            D();
                        }
                        this.N.postDelayed(new Runnable() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.5
                            @Override // java.lang.Runnable
                            public final void run() {
                                BaseMBMediaView.this.f45851s = true;
                                if (BaseMBMediaView.this.f45843i) {
                                    TextView unused = BaseMBMediaView.this.J;
                                }
                            }
                        }, 3000L);
                    } catch (Throwable th2) {
                        ad.b(TAG, th2.getMessage());
                    }
                    try {
                        this.F.setFocusableInTouchMode(true);
                        this.F.requestFocus();
                        this.F.setOnKeyListener(new View.OnKeyListener() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.18
                            @Override // android.view.View.OnKeyListener
                            public final boolean onKey(View view, int i15, KeyEvent keyEvent) {
                                try {
                                    if (keyEvent.getKeyCode() != 4) {
                                        return false;
                                    }
                                    BaseMBMediaView.this.x();
                                    return true;
                                } catch (Throwable th3) {
                                    ad.b(BaseMBMediaView.TAG, th3.getMessage());
                                    return false;
                                }
                            }
                        });
                        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                BaseMBMediaView.h(BaseMBMediaView.this);
                            }
                        });
                        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.3
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                BaseMBMediaView.this.x();
                            }
                        });
                        this.J.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.4
                            @Override // com.mbridge.msdk.widget.a
                            public final void a(View view) {
                                try {
                                    BaseMBMediaView.this.b(view.getContext());
                                    if (BaseMBMediaView.this.f45854v != null) {
                                        BaseMBMediaView.this.f45854v.a(InteractionType.CLICK);
                                    }
                                } catch (Exception e13) {
                                    ad.b(BaseMBMediaView.TAG, e13.getMessage());
                                }
                            }
                        });
                    } catch (Exception e13) {
                        ad.b(TAG, e13.getMessage());
                    }
                    MediaViewPlayerView mediaViewPlayerView2 = this.f45856x;
                    if (mediaViewPlayerView2 != null) {
                        mediaViewPlayerView2.openSound();
                        MediaViewPlayerView mediaViewPlayerView3 = this.f45856x;
                        mediaViewPlayerView3.setMediaViewPlayListener(new MediaViewPlayerView.a(mediaViewPlayerView3) { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.16
                            @Override // com.mbridge.msdk.nativex.view.MediaViewPlayerView.a
                            public final void a() {
                                int nvT2 = BaseMBMediaView.this.O.getNvT2();
                                if (!BaseMBMediaView.this.f45843i || (nvT2 != 3 && nvT2 != 4)) {
                                    super.a();
                                    return;
                                }
                                WindVaneWebViewForNV windVaneWebViewForNVG = BaseMBMediaView.this.G();
                                if (windVaneWebViewForNVG == null) {
                                    super.a();
                                    return;
                                }
                                View viewW = BaseMBMediaView.this.w();
                                if (viewW == null) {
                                    super.a();
                                    return;
                                }
                                if (nvT2 == 3 && BaseMBMediaView.this.f45827ag) {
                                    com.mbridge.msdk.nativex.view.mbfullview.a.a(BaseMBMediaView.this.getContext()).a(viewW, BaseMBMediaView.this.G);
                                    Context context = BaseMBMediaView.this.getContext();
                                    CampaignEx campaignEx2 = BaseMBMediaView.this.O;
                                    String campaignUnitId = BaseMBMediaView.this.O.getCampaignUnitId();
                                    if (campaignEx2 != null) {
                                        try {
                                            if (campaignEx2.getNativeVideoTracking() != null && campaignEx2.getNativeVideoTracking().r() != null) {
                                                for (String str : campaignEx2.getNativeVideoTracking().r()) {
                                                    if (!TextUtils.isEmpty(str)) {
                                                        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignUnitId, str, false, true);
                                                    }
                                                }
                                            }
                                        } catch (Exception e14) {
                                            e14.printStackTrace();
                                        }
                                    }
                                } else {
                                    if (nvT2 != 4) {
                                        super.a();
                                        return;
                                    }
                                    com.mbridge.msdk.nativex.view.mbfullview.a.a(BaseMBMediaView.this.getContext()).a(viewW, BaseMBMediaView.this.G);
                                    String clickURL = BaseMBMediaView.this.O.getClickURL();
                                    if (!TextUtils.isEmpty(clickURL)) {
                                        com.mbridge.msdk.click.a.a(BaseMBMediaView.this.getContext(), BaseMBMediaView.this.O, BaseMBMediaView.this.p(), BaseMBMediaView.this.getAddNVT2ToNoticeURL(), true, false, com.mbridge.msdk.click.a.a.f43074i);
                                        BaseMBMediaView.this.C.loadUrl(clickURL);
                                    }
                                }
                                windVaneWebViewForNVG.webViewShow(BaseMBMediaView.this.O, BaseMBMediaView.this.p());
                                windVaneWebViewForNVG.orientation(BaseMBMediaView.this.f45844j);
                            }
                        });
                    }
                    b(false);
                    CampaignEx campaignEx2 = this.O;
                    if (campaignEx2 == null || campaignEx2.getMediaViewHolder() == null || this.O.getMediaViewHolder().f44225e || TextUtils.isEmpty(this.O.getCampaignUnitId()) || this.O.getNativeVideoTracking() == null || this.O.getNativeVideoTracking().c() == null) {
                        return;
                    }
                    this.O.getMediaViewHolder().f44225e = true;
                    F();
                    return;
                }
                return;
            }
            ad.c(TAG, "rootView is null");
        } catch (Exception e14) {
            ad.b(TAG, e14.getMessage());
        }
    }

    public final void a(String str) {
        try {
            if (TextUtils.isEmpty(str) || this.f45848n.contains(str)) {
                return;
            }
            this.f45848n.add(str);
            OnMBMediaViewListener onMBMediaViewListener = this.f45824ad;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onVideoStart();
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.f45825ae;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onVideoStart();
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    public final void b(String str) {
        try {
            if (TextUtils.isEmpty(str) || this.f45849o.contains(str)) {
                return;
            }
            this.f45849o.add(str);
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.f45825ae;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onVideoComplete();
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void cai(Object obj, String str) {
        ad.a(TAG, "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                String strOptString = new JSONObject(str).optString("packageName");
                if (TextUtils.isEmpty(strOptString)) {
                    com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "packageName is empty");
                }
                int i11 = ai.c(com.mbridge.msdk.foundation.controller.c.m().c(), strOptString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TrackingKey.CODE, com.mbridge.msdk.mbsignalcommon.communication.d.f45733b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i11);
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e11) {
                    com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, e11.getMessage());
                    ad.a(TAG, e11.getMessage());
                }
            } catch (Throwable th2) {
                com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "exception: " + th2.getLocalizedMessage());
                ad.a(TAG, "cai", th2);
            }
        } catch (JSONException e12) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "exception: " + e12.getLocalizedMessage());
            ad.a(TAG, "cai", e12);
        }
    }

    public boolean canShowVideo() {
        return a(false) == a.VIDEO;
    }

    public void changeNoticeURL() {
        String str;
        CampaignEx campaignEx = this.O;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (TextUtils.isEmpty(noticeUrl)) {
                return;
            }
            if (noticeUrl.contains("is_video")) {
                a aVar = this.f45823ac;
                if (aVar == a.VIDEO) {
                    if (noticeUrl.contains("is_video=2")) {
                        noticeUrl = noticeUrl.replace("is_video=2", "is_video=1");
                    }
                } else if (aVar == a.BIG_IMAGE && noticeUrl.contains("is_video=1")) {
                    noticeUrl = noticeUrl.replace("is_video=1", "is_video=2");
                }
            } else {
                a aVar2 = this.f45823ac;
                if (aVar2 == a.VIDEO) {
                    str = "1";
                } else {
                    str = aVar2 == a.BIG_IMAGE ? "2" : "";
                }
                StringBuilder sb2 = new StringBuilder(noticeUrl);
                if (noticeUrl.contains("?")) {
                    sb2.append("&is_video=");
                    sb2.append(str);
                } else {
                    sb2.append("?is_video=");
                    sb2.append(str);
                }
                noticeUrl = sb2.toString();
            }
            this.O.setNoticeUrl(noticeUrl);
        }
    }

    public void destory() {
        try {
            MediaViewPlayerView mediaViewPlayerView = this.f45856x;
            if (mediaViewPlayerView != null) {
                mediaViewPlayerView.release();
            }
            b();
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    public void exitFullScreen() {
        try {
            x();
            if (this.f45837c) {
                this.f45856x.onClickPlayButton();
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    public String getAddNVT2ToNoticeURL() {
        CampaignEx campaignEx = this.O;
        if (campaignEx == null) {
            return null;
        }
        String noticeUrl = campaignEx.getNoticeUrl();
        if (TextUtils.isEmpty(noticeUrl) || noticeUrl.contains(CampaignEx.JSON_KEY_NV_T2)) {
            return noticeUrl;
        }
        return noticeUrl + "&nv_t2=" + this.O.getNvT2();
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.O);
            String strA = a(arrayList, p(), "MAL_16.7.21,3.0.1");
            String strEncodeToString = !TextUtils.isEmpty(strA) ? Base64.encodeToString(strA.getBytes(), 2) : "";
            ad.b(TAG, "getEndScreenInfo-mCampaign.name:" + this.O.getAppName());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, strEncodeToString);
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001f  */
    public BaseView getFullScreenViewByStyle(Context context, BaseView.a aVar) {
        BaseView mBridgeFullView;
        BaseView baseView;
        int i11 = AnonymousClass10.f45860a[aVar.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                baseView = null;
            } else {
                mBridgeFullView = new MBridgeTopFullView(context);
            }
            if (baseView != null) {
                baseView.setStytle(aVar);
            }
            return baseView;
        }
        mBridgeFullView = new MBridgeFullView(context);
        baseView = mBridgeFullView;
        if (baseView != null) {
            baseView.setStytle(aVar);
        }
        return baseView;
    }

    public BaseView.a handleViewStyleResult(Context context) {
        int nvT2 = this.O.getNvT2();
        if (nvT2 == 1) {
            b(context);
        } else {
            if (nvT2 == 2 || nvT2 == 3 || nvT2 == 4) {
                return BaseView.a.FULL_MIDDLE_VIEW;
            }
            if (nvT2 == 6) {
                return BaseView.a.FULL_TOP_VIEW;
            }
        }
        return null;
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
    }

    public void hideEndCardWebViewCloseBtn() {
        ImageView imageView = this.f45830aj;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.f45830aj.setVisibility(8);
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void install(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        try {
            Context context = this.f45833am;
            if (context != null) {
                b(context);
            } else {
                if (!(obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) || (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) == null) {
                    return;
                }
                b(windVaneWebView.getContext());
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
    }

    public boolean ismCurIsFullScreen() {
        return this.f45843i;
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.f45838d) {
                try {
                    SensorManager sensorManager = (SensorManager) getContext().getSystemService("sensor");
                    this.W = sensorManager;
                    this.f45821aa = sensorManager.getDefaultSensor(1);
                    e eVar = new e();
                    this.V = eVar;
                    this.W.registerListener(eVar, this.f45821aa, 2);
                } catch (Throwable th2) {
                    ad.b(TAG, th2.getMessage());
                }
            }
            this.f45842h = isHardwareAccelerated();
            this.f45831ak = getOrientation();
            e();
            this.N.postDelayed(this.f45835ao, 300L);
        } catch (Throwable th3) {
            ad.b(TAG, th3.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingEnd() {
        ad.c("bufferend", "bufferend");
        com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f45854v;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingStart(String str) {
        ad.c("bufferMsg", str);
        com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f45854v;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f45832al) {
            int i11 = this.f45831ak;
            int i12 = configuration.orientation;
            if (i11 == i12) {
                return;
            }
            this.f45831ak = i12;
            this.f45844j = i12 == 0;
            this.f45845k = this.f45831ak == 0;
            this.N.postDelayed(new Runnable() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.8
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.mbridge.msdk.nativex.view.mbfullview.a.a(BaseMBMediaView.this.getContext()).a(BaseMBMediaView.this.G, BaseMBMediaView.this.f45844j);
                        if (BaseMBMediaView.this.f45831ak == 0) {
                            BaseMBMediaView.this.E();
                        } else {
                            BaseMBMediaView.this.D();
                        }
                        BaseMBMediaView.this.i();
                        BaseMBMediaView.this.g();
                        BaseMBMediaView.this.h();
                        if (BaseMBMediaView.this.C != null) {
                            BaseMBMediaView.this.C.orientation(BaseMBMediaView.this.f45844j);
                        }
                    } catch (Exception e11) {
                        ad.b(BaseMBMediaView.TAG, e11.getMessage());
                    }
                }
            }, 200L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        e eVar;
        super.onDetachedFromWindow();
        try {
            if (this.f45852t != null) {
                MediaViewPlayerView mediaViewPlayerView = this.f45856x;
                if (mediaViewPlayerView != null) {
                    mediaViewPlayerView.unregisterView();
                }
                this.f45852t.c();
                this.f45852t = null;
            }
            if (this.f45854v != null) {
                this.f45854v = null;
            }
            if (this.f45853u != null) {
                this.f45853u = null;
            }
            this.N.removeCallbacks(this.f45835ao);
            Handler handler = this.N;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            try {
                SensorManager sensorManager = this.W;
                if (sensorManager != null && (eVar = this.V) != null) {
                    sensorManager.unregisterListener(eVar);
                }
            } catch (Throwable th2) {
                ad.b(TAG, th2.getMessage());
            }
            b();
        } catch (Throwable th3) {
            ad.b(TAG, th3.getMessage());
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        try {
            this.P = getHeight();
            int width = getWidth();
            this.Q = width;
            if (width == 0) {
                this.Q = getMeasuredWidth();
            }
            if (this.P == 0) {
                this.P = getMeasuredHeight();
            }
            if (this.Q == 0 && this.P == 0) {
                this.Q = (int) B();
            }
            a aVar = this.f45823ac;
            if (aVar != a.VIDEO || this.f45843i) {
                if (aVar == a.BIG_IMAGE && !this.f45843i) {
                    g();
                    return;
                } else {
                    if (aVar != a.GIF || this.f45843i) {
                        return;
                    }
                    h();
                    return;
                }
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (this.P == 0 || ((layoutParams != null && layoutParams.height == -2) || (layoutParams != null && layoutParams.height == -1))) {
                this.P = (int) ((((double) this.Q) * this.S) / this.R);
            }
            i();
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayCompleted() {
        com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f45854v;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayError(final String str) {
        try {
            ad.c("error", str);
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.nativex.view.BaseMBMediaView.15
                @Override // java.lang.Runnable
                public final void run() {
                    BaseMBMediaView.q(BaseMBMediaView.this);
                    BaseMBMediaView.a(BaseMBMediaView.this, str);
                    NativeController.insertExcludeId(BaseMBMediaView.this.O.getCampaignUnitId(), BaseMBMediaView.this.O);
                }
            };
            com.mbridge.msdk.foundation.controller.d.a();
            com.mbridge.msdk.foundation.same.f.b.b().execute(runnable);
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgress(int i11, int i12) {
        int i13;
        String str;
        CampaignEx.b mediaViewHolder;
        CampaignEx.b mediaViewHolder2;
        Map<Integer, String> map;
        try {
            CampaignEx campaignEx = this.O;
            if (campaignEx != null && (mediaViewHolder2 = campaignEx.getMediaViewHolder()) != null && !mediaViewHolder2.f44222b && (map = mediaViewHolder2.f44221a) != null && map.size() > 0) {
                Map<Integer, String> map2 = mediaViewHolder2.f44221a;
                Iterator<Map.Entry<Integer, String>> it = map2.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, String> next = it.next();
                    Integer key = next.getKey();
                    String value = next.getValue();
                    if (i11 >= key.intValue() && !TextUtils.isEmpty(value)) {
                        Context context = getContext();
                        CampaignEx campaignEx2 = this.O;
                        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), value, false, false);
                        it.remove();
                    }
                }
                if (map2.size() <= 0) {
                    mediaViewHolder2.f44222b = true;
                }
            }
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
        }
        try {
            CampaignEx campaignEx3 = this.O;
            if (campaignEx3 != null && (mediaViewHolder = campaignEx3.getMediaViewHolder()) != null && !mediaViewHolder.f44228h && i12 != 0) {
                List<Map<Integer, String>> listI = this.O.getNativeVideoTracking().i();
                int i14 = ((i11 + 1) * 100) / i12;
                if (listI != null) {
                    int i15 = 0;
                    while (i15 < listI.size()) {
                        Map<Integer, String> map3 = listI.get(i15);
                        if (map3 != null && map3.size() > 0) {
                            Iterator<Map.Entry<Integer, String>> it2 = map3.entrySet().iterator();
                            while (it2.hasNext()) {
                                Map.Entry<Integer, String> next2 = it2.next();
                                int iIntValue = next2.getKey().intValue();
                                String value2 = next2.getValue();
                                if (iIntValue <= i14 && !TextUtils.isEmpty(value2)) {
                                    Context context2 = getContext();
                                    CampaignEx campaignEx4 = this.O;
                                    com.mbridge.msdk.click.a.a(context2, campaignEx4, campaignEx4.getCampaignUnitId(), new String[]{value2}, false, true);
                                    it2.remove();
                                    listI.remove(i15);
                                    i15--;
                                }
                            }
                        }
                        i15++;
                    }
                    if (listI.size() <= 0) {
                        mediaViewHolder.f44228h = true;
                    }
                }
            }
        } catch (Throwable unused) {
            ad.b(TAG, "reportPlayPercentageData error");
        }
        com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f45854v;
        if (aVar != null) {
            int i16 = (i11 * 100) / i12;
            int i17 = ((i11 + 1) * 100) / i12;
            if (i16 <= 25 && 25 < i17) {
                aVar.h();
            } else if (i16 <= 50 && 50 < i17) {
                aVar.i();
            } else if (i16 <= 75 && 75 < i17) {
                aVar.o();
            }
        }
        if (t() == 100 || this.f45834an) {
            return;
        }
        int iG = u() != null ? u().g() : 0;
        int iT = t();
        if (iT == 0) {
            return;
        }
        if (iG > iT) {
            iG = iT / 2;
        }
        if (iG < 0 || i11 < (i13 = (iG * i12) / 100)) {
            return;
        }
        if (this.O.getAdType() == 94 || this.O.getAdType() == 287) {
            str = this.O.getRequestId() + this.O.getId() + this.O.getVideoUrlEncode();
        } else {
            str = this.O.getId() + this.O.getVideoUrlEncode() + this.O.getBidToken();
        }
        com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(p(), str);
        if (aVarA != null) {
            aVarA.p();
            this.f45834an = true;
            ad.b(TAG, "CDRate is : " + i13 + " and start download !");
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgressMS(int i11, int i12) {
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlaySetDataSourceError(String str) {
        ad.c("errorstr", str);
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayStarted(int i11) {
        com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f45854v;
        if (aVar != null) {
            try {
                aVar.n(i11, this.f45841g ? 1.0f : 0.0f);
            } catch (IllegalArgumentException e11) {
                ad.a("omsdk", e11.getMessage());
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        MediaViewPlayerView mediaViewPlayerView;
        super.onWindowFocusChanged(z11);
        try {
            this.f45840f = z11;
            if (this.f45823ac == a.VIDEO && (mediaViewPlayerView = this.f45856x) != null) {
                mediaViewPlayerView.setIsFrontDesk(z11);
            }
            try {
                if (this.f45843i) {
                    MediaViewPlayerView mediaViewPlayerView2 = this.f45856x;
                    if (mediaViewPlayerView2 == null) {
                        ad.b(TAG, "fullscreen playerview is null return");
                    } else if (!this.f45840f) {
                        mediaViewPlayerView2.pause();
                    } else if (mediaViewPlayerView2.isPlaying()) {
                        ad.c(TAG, "fullscreen windowfocuse true isPlaying do nothing return");
                    } else {
                        MediaViewPlayerView mediaViewPlayerView3 = this.f45856x;
                        if (mediaViewPlayerView3 != null && !mediaViewPlayerView3.isComplete() && !this.f45856x.getIsActiviePause()) {
                            this.f45856x.onClickPlayButton();
                        }
                    }
                }
            } catch (Throwable th2) {
                ad.b(TAG, th2.getMessage());
            }
            requestLayout();
        } catch (Throwable th3) {
            ad.b(TAG, th3.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        ad.b(TAG, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "params is null");
            return;
        }
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextC == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                    contextC = windVaneWebView.getContext();
                }
            } catch (Exception e11) {
                ad.b(TAG, e11.getMessage());
            }
        }
        if (contextC == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt == 1) {
                com.mbridge.msdk.click.c.c(contextC, strOptString);
            } else if (iOptInt == 2) {
                com.mbridge.msdk.click.c.e(contextC, strOptString);
            }
        } catch (JSONException e12) {
            ad.b(TAG, e12.getMessage());
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    public void setAllowLoopPlay(boolean z11) {
        this.f45837c = z11;
    }

    public void setAllowScreenChange(boolean z11) {
        this.f45838d = z11;
    }

    public void setAllowVideoRefresh(boolean z11) {
        this.f45836b = z11;
    }

    public void setFollowActivityOrientation(boolean z11) {
        this.f45832al = z11;
    }

    public void setFullScreenViewBackgroundColor(int i11) {
        this.f45855w = i11;
    }

    public void setIsAllowFullScreen(boolean z11) {
        this.f45839e = z11;
    }

    public void setNativeAd(Campaign campaign) {
        String str;
        if (campaign == null) {
            return;
        }
        try {
            CampaignEx campaignEx = this.O;
            if (campaignEx == null || campaignEx != campaign) {
                this.f45840f = true;
                this.f45842h = true;
                this.f45843i = false;
                this.f45844j = false;
                this.f45845k = false;
                this.f45851s = false;
                z();
                CampaignEx campaignEx2 = (CampaignEx) campaign;
                this.O = campaignEx2;
                if (campaignEx2.getMediaViewHolder() == null) {
                    CampaignEx.b bVar = new CampaignEx.b();
                    bVar.f44221a = this.O.getAdvImpList();
                    this.O.setMediaViewHolder(bVar);
                }
                if (this.O.getAdType() == 94 || this.O.getAdType() == 287) {
                    str = this.O.getRequestId() + this.O.getId() + this.O.getVideoUrlEncode();
                } else {
                    str = this.O.getId() + this.O.getVideoUrlEncode() + this.O.getBidToken();
                }
                this.f45822ab = com.mbridge.msdk.videocommon.download.b.getInstance().a(p(), str);
                if (this.f45850r) {
                    if (this.f45852t != null) {
                        MediaViewPlayerView mediaViewPlayerView = this.f45856x;
                        if (mediaViewPlayerView != null) {
                            mediaViewPlayerView.unregisterView();
                        }
                        this.f45852t.c();
                        this.f45852t = null;
                    }
                    if (this.f45854v != null) {
                        this.f45854v = null;
                    }
                    if (this.f45853u != null) {
                        this.f45853u = null;
                    }
                }
                CampaignEx campaignEx3 = this.O;
                if (campaignEx3 != null && campaignEx3.isActiveOm()) {
                    this.f45852t = com.mbridge.msdk.a.b.a(getContext(), TextUtils.isEmpty(this.O.getVideoUrlEncode()), this.O.getOmid(), this.O.getRequestId(), this.O.getId(), p(), "", this.O.getRequestIdNotice());
                }
                if (this.f45850r) {
                    e();
                }
            }
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
        }
    }

    public void setOnMediaViewListener(OnMBMediaViewListener onMBMediaViewListener) {
        this.f45824ad = onMBMediaViewListener;
    }

    public void setOnMediaViewListener(OnMBMediaViewListenerPlus onMBMediaViewListenerPlus) {
        this.f45825ae = onMBMediaViewListenerPlus;
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void setOrientation(Object obj, String str) {
    }

    public void setProgressVisibility(boolean z11) {
        this.f45846l = z11;
        MediaViewPlayerView mediaViewPlayerView = this.f45856x;
        if (mediaViewPlayerView != null) {
            mediaViewPlayerView.showProgressView(z11);
        }
    }

    public void setSoundIndicatorVisibility(boolean z11) {
        this.f45847m = z11;
        MediaViewPlayerView mediaViewPlayerView = this.f45856x;
        if (mediaViewPlayerView != null) {
            mediaViewPlayerView.showSoundIndicator(z11);
        }
    }

    public void setVideoSoundOnOff(boolean z11) {
        this.f45841g = z11;
        MediaViewPlayerView mediaViewPlayerView = this.f45856x;
        if (mediaViewPlayerView != null) {
            if (z11) {
                mediaViewPlayerView.openSound();
            } else {
                mediaViewPlayerView.closeSound();
            }
        }
    }

    public void showEndCardWebViewCloseBtn() {
        ImageView imageView = this.f45830aj;
        if (imageView == null || imageView.getVisibility() == 0) {
            return;
        }
        this.f45830aj.setVisibility(0);
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str).optInt("state", 1);
                } catch (Exception e11) {
                    ad.b(TAG, e11.getMessage());
                }
            }
            ad.b(TAG, "SHOW CLOSE BTN ");
            showEndCardWebViewCloseBtn();
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, a(0));
        } catch (Exception e12) {
            ad.b(TAG, e12.getMessage());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().b(obj, a(1));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        try {
            exitFullScreen();
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, a(0));
        } catch (Exception e11) {
            ad.b(TAG, e11.getMessage());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().b(obj, a(1));
        }
    }

    public void updateViewManger(boolean z11) {
        com.mbridge.msdk.nativex.view.mbfullview.a aVarA = com.mbridge.msdk.nativex.view.mbfullview.a.a(getContext());
        int i11 = 0;
        if (aVarA != null) {
            try {
                this.G.getmAnimationPlayer().clearAnimation();
                aVarA.a(z11, !this.f45856x.isComplete(), this.G);
                aVarA.a(z11, this.G, this.f45826af);
            } catch (NullPointerException e11) {
                e11.printStackTrace();
                return;
            }
        }
        BaseView baseView = this.G;
        if (!(baseView instanceof MBridgeTopFullView) || aVarA == null) {
            return;
        }
        boolean z12 = !z11;
        if (baseView instanceof MBridgeTopFullView) {
            MBridgeTopFullView mBridgeTopFullView = (MBridgeTopFullView) baseView;
            if (!z12) {
                i11 = 8;
            }
            mBridgeTopFullView.getMBridgeFullViewDisplayIcon().setVisibility(i11);
            mBridgeTopFullView.getMBridgeFullViewDisplayTitle().setVisibility(i11);
            mBridgeTopFullView.getMBridgeFullViewDisplayDscription().setVisibility(i11);
            mBridgeTopFullView.getStarLevelLayoutView().setVisibility(i11);
        }
    }
}
