package com.vungle.warren.ui.view;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.utility.ViewUtility;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class FullAdWidget extends RelativeLayout {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f62455w = "FullAdWidget";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<View, Integer> f62456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout.LayoutParams f62457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f62458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RelativeLayout f62459d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public WebView f62460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProgressBar f62461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f62462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f62463i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f62464j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageView f62465k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public j f62466l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.vungle.warren.ui.view.e f62467m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MediaPlayer.OnPreparedListener f62468n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public MediaPlayer.OnErrorListener f62469o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MediaPlayer.OnCompletionListener f62470p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f62471q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public GestureDetector f62472r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Runnable f62473s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f62474t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f62475u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View.OnClickListener f62476v;
    public final VideoView videoView;

    /* JADX INFO: compiled from: source.java */
    public static class DestroyRunnable implements Runnable {
        private WebView webView;

        public DestroyRunnable(WebView webView) {
            this.webView = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.webView.stopLoading();
            this.webView.setWebViewClient(null);
            if (Build.VERSION.SDK_INT >= 29) {
                this.webView.setWebViewRenderProcessClient(null);
            }
            this.webView.loadData("", null, null);
            this.webView.destroy();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            FullAdWidget.this.f62476v.onClick(FullAdWidget.this.f62459d);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FullAdWidget.this.f62472r.onTouchEvent(motionEvent);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements MediaPlayer.OnPreparedListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (Build.VERSION.SDK_INT >= 26) {
                mediaPlayer.seekTo(FullAdWidget.this.f62471q, 3);
            }
            if (FullAdWidget.this.f62468n != null) {
                FullAdWidget.this.f62468n.onPrepared(mediaPlayer);
            }
            FullAdWidget.this.f62462h.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
            if (FullAdWidget.this.f62469o != null) {
                return FullAdWidget.this.f62469o.onError(mediaPlayer, i11, i12);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements MediaPlayer.OnCompletionListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (FullAdWidget.this.f62470p != null) {
                FullAdWidget.this.f62470p.onCompletion(mediaPlayer);
            }
            FullAdWidget.this.f62462h.setEnabled(false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FullAdWidget.this.f62467m != null) {
                return FullAdWidget.this.f62467m.a(motionEvent);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FullAdWidget.this.s();
            FullAdWidget.this.p();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FullAdWidget.this.f62466l != null) {
                FullAdWidget.this.f62466l.a(FullAdWidget.this.q(view));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i extends ContextWrapper {
        public i(Context context) {
            super(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return MimeTypes.BASE_TYPE_AUDIO.equals(str) ? getApplicationContext().getSystemService(str) : super.getSystemService(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface j {
        void a(int i11);
    }

    public FullAdWidget(Context context, Window window) throws InstantiationException {
        super(context);
        this.f62456a = new HashMap();
        this.f62474t = new a();
        this.f62475u = new g();
        this.f62476v = new h();
        this.f62458c = window;
        Resources resources = getResources();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f62457b = layoutParams;
        setLayoutParams(layoutParams);
        this.f62473s = new Runnable() { // from class: com.vungle.warren.ui.view.FullAdWidget.1
            @Override // java.lang.Runnable
            public void run() {
                FullAdWidget.this.p();
            }
        };
        VideoView videoView = new VideoView(new i(context));
        this.videoView = videoView;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        videoView.setLayoutParams(layoutParams2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f62459d = relativeLayout;
        relativeLayout.setTag("videoViewContainer");
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(videoView, layoutParams2);
        addView(relativeLayout, layoutParams);
        this.f62472r = new GestureDetector(context, this.f62474t);
        WebView webViewC = ViewUtility.c(context);
        this.f62460f = webViewC;
        webViewC.setLayoutParams(layoutParams);
        this.f62460f.setTag("webView");
        addView(this.f62460f, layoutParams);
        ProgressBar progressBar = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        this.f62461g = progressBar;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 4.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(12);
        progressBar.setLayoutParams(layoutParams3);
        progressBar.setMax(100);
        progressBar.setIndeterminate(false);
        progressBar.setVisibility(4);
        addView(progressBar);
        int iApplyDimension = (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iApplyDimension, iApplyDimension);
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 12.0f, resources.getDisplayMetrics());
        layoutParams4.setMargins(iApplyDimension2, iApplyDimension2, iApplyDimension2, iApplyDimension2);
        ImageView imageView = new ImageView(context);
        this.f62462h = imageView;
        imageView.setImageBitmap(ViewUtility.b(ViewUtility.Asset.unMute, context));
        imageView.setLayoutParams(layoutParams4);
        imageView.setVisibility(8);
        addView(imageView);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iApplyDimension, iApplyDimension);
        layoutParams5.setMargins(iApplyDimension2, iApplyDimension2, iApplyDimension2, iApplyDimension2);
        ImageView imageView2 = new ImageView(context);
        this.f62463i = imageView2;
        imageView2.setTag("closeButton");
        imageView2.setImageBitmap(ViewUtility.b(ViewUtility.Asset.close, context));
        layoutParams5.addRule(11);
        imageView2.setLayoutParams(layoutParams5);
        imageView2.setVisibility(8);
        addView(imageView2);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(iApplyDimension, iApplyDimension);
        layoutParams6.addRule(12);
        layoutParams6.addRule(11);
        layoutParams6.setMargins(iApplyDimension2, iApplyDimension2, iApplyDimension2, iApplyDimension2);
        ImageView imageView3 = new ImageView(context);
        this.f62464j = imageView3;
        imageView3.setTag("ctaOverlay");
        imageView3.setLayoutParams(layoutParams6);
        imageView3.setImageBitmap(ViewUtility.b(ViewUtility.Asset.cta, getContext()));
        imageView3.setVisibility(8);
        addView(imageView3);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(iApplyDimension, iApplyDimension);
        layoutParams7.addRule(12);
        layoutParams7.addRule(9);
        layoutParams7.setMargins(iApplyDimension2, iApplyDimension2, iApplyDimension2, iApplyDimension2);
        ImageView imageView4 = new ImageView(context);
        this.f62465k = imageView4;
        imageView4.setLayoutParams(layoutParams7);
        imageView4.setVisibility(8);
        addView(imageView4);
        o();
        r();
    }

    public void destroyWebView(long j11) {
        WebView webView = this.f62460f;
        if (webView == null) {
            return;
        }
        webView.removeJavascriptInterface("Android");
        this.f62460f.setWebChromeClient(null);
        removeView(this.f62460f);
        this.f62460f.removeAllViews();
        if (j11 <= 0) {
            new DestroyRunnable(this.f62460f).run();
        } else {
            new com.vungle.warren.utility.j().a(new DestroyRunnable(this.f62460f), j11);
        }
        this.f62460f = null;
    }

    public int getCurrentVideoPosition() {
        return this.videoView.getCurrentPosition();
    }

    public String getUrl() {
        WebView webView = this.f62460f;
        if (webView == null) {
            return null;
        }
        return webView.getUrl();
    }

    public int getVideoDuration() {
        return this.videoView.getDuration();
    }

    @Nullable
    public WebView getWebView() {
        return this.f62460f;
    }

    public boolean hasWebView() {
        return this.f62460f != null;
    }

    public boolean isVideoPlaying() {
        return this.videoView.isPlaying();
    }

    public void linkWebView(WebViewClient webViewClient, a10.d dVar) {
        WebView webView = this.f62460f;
        if (webView == null) {
            return;
        }
        com.vungle.warren.ui.view.g.a(webView);
        this.f62460f.setWebViewClient(webViewClient);
        this.f62460f.addJavascriptInterface(dVar, "Android");
    }

    public final void n(View view, int i11) {
        this.f62456a.put(view, Integer.valueOf(i11));
        view.setOnClickListener(this.f62476v);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void o() {
        n(this.f62463i, 1);
        n(this.f62464j, 2);
        n(this.f62462h, 3);
        n(this.f62465k, 4);
        this.f62456a.put(this.f62459d, 5);
        this.f62459d.setOnTouchListener(new b());
        this.videoView.setOnPreparedListener(new c());
        this.videoView.setOnErrorListener(new d());
        this.videoView.setOnCompletionListener(new e());
        WebView webView = this.f62460f;
        if (webView != null) {
            webView.setOnTouchListener(new f());
        }
    }

    public final void p() {
        if (Build.VERSION.SDK_INT < 30) {
            this.f62458c.getDecorView().setSystemUiVisibility(5894);
            return;
        }
        this.f62458c.setDecorFitsSystemWindows(false);
        WindowInsetsController insetsController = this.f62458c.getInsetsController();
        if (insetsController != null) {
            insetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
            insetsController.setSystemBarsBehavior(2);
        }
    }

    public void pausePlayback() {
        this.videoView.pause();
    }

    public void pauseWeb() {
        WebView webView = this.f62460f;
        if (webView != null) {
            webView.onPause();
        }
        s();
        removeCallbacks(this.f62473s);
    }

    public void playVideo(Uri uri, int i11) {
        this.f62459d.setVisibility(0);
        this.videoView.setVideoURI(uri);
        this.f62465k.setImageBitmap(ViewUtility.b(ViewUtility.Asset.privacy, getContext()));
        this.f62465k.setVisibility(0);
        this.f62461g.setVisibility(0);
        this.f62461g.setMax(this.videoView.getDuration());
        startPlayback(i11);
    }

    public final int q(View view) {
        Integer num = this.f62456a.get(view);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public final void r() {
        WebView webView = this.f62460f;
        if (webView != null) {
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            this.f62460f.setVisibility(8);
        }
        this.f62459d.setVisibility(8);
    }

    public void release(long j11) {
        this.videoView.stopPlayback();
        this.videoView.setOnCompletionListener(null);
        this.videoView.setOnErrorListener(null);
        this.videoView.setOnPreparedListener(null);
        this.videoView.suspend();
        destroyWebView(j11);
    }

    public void resumeWeb() {
        WebView webView = this.f62460f;
        if (webView != null) {
            webView.onResume();
        }
        post(this.f62473s);
    }

    public final void s() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.f62475u);
        } else {
            Log.w(f62455w, "The view tree observer was not alive");
        }
    }

    public void setCtaEnabled(boolean z11) {
        this.f62464j.setVisibility(z11 ? 0 : 8);
    }

    public void setImmersiveMode() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f62475u);
        } else {
            Log.w(f62455w, "The view tree observer was not alive");
        }
    }

    public void setMuted(boolean z11) {
        Bitmap bitmapB = ViewUtility.b(ViewUtility.Asset.mute, getContext());
        Bitmap bitmapB2 = ViewUtility.b(ViewUtility.Asset.unMute, getContext());
        ImageView imageView = this.f62462h;
        if (!z11) {
            bitmapB = bitmapB2;
        }
        imageView.setImageBitmap(bitmapB);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f62470p = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f62469o = onErrorListener;
    }

    public void setOnItemClickListener(j jVar) {
        this.f62466l = jVar;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f62468n = onPreparedListener;
    }

    public void setOnViewTouchListener(com.vungle.warren.ui.view.e eVar) {
        this.f62467m = eVar;
    }

    public void setProgress(int i11, float f11) {
        this.f62461g.setMax((int) f11);
        this.f62461g.setProgress(i11);
    }

    public void showCloseButton(boolean z11) {
        this.f62463i.setVisibility(z11 ? 0 : 8);
    }

    public void showWebsite(String str) {
        if (this.f62460f == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loadJs: ");
        sb2.append(str);
        this.f62460f.loadUrl(str);
        this.f62460f.setVisibility(0);
        this.f62459d.setVisibility(8);
        this.f62459d.setOnClickListener(null);
        this.f62461g.setVisibility(8);
        this.f62463i.setVisibility(8);
        this.f62462h.setVisibility(8);
        this.f62464j.setVisibility(8);
        this.f62465k.setVisibility(8);
    }

    public boolean startPlayback(int i11) {
        if (!this.videoView.isPlaying()) {
            this.videoView.requestFocus();
            this.f62471q = i11;
            if (Build.VERSION.SDK_INT < 26) {
                this.videoView.seekTo(i11);
            }
            this.videoView.start();
        }
        return this.videoView.isPlaying();
    }

    public void stopPlayback() {
        this.videoView.stopPlayback();
    }

    public void updateWindow() {
        this.f62458c.setFlags(1024, 1024);
        this.f62458c.getDecorView().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }
}
