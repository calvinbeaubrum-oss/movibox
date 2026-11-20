package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.applovin.impl.Cif;
import com.applovin.impl.b1;
import com.applovin.impl.bf;
import com.applovin.impl.c20;
import com.applovin.impl.d20;
import com.applovin.impl.eb;
import com.applovin.impl.fo;
import com.applovin.impl.nh;
import com.applovin.impl.ph;
import com.applovin.impl.po;
import com.applovin.impl.qh;
import com.applovin.impl.r6;
import com.applovin.impl.rk;
import com.applovin.impl.rq;
import com.applovin.impl.so;
import com.applovin.impl.t;
import com.applovin.impl.t4;
import com.applovin.impl.t7;
import com.applovin.impl.td;
import com.applovin.impl.to;
import com.applovin.impl.vd;
import com.applovin.impl.xp;
import com.applovin.impl.xq;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends FrameLayout {
    private boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f17324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AspectRatioFrameLayout f17325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f17326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f17327d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f17328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ImageView f17329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SubtitleView f17330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View f17331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TextView f17332j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d f17333k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final FrameLayout f17334l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final FrameLayout f17335m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private qh f17336n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f17337o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private d.e f17338p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f17339q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Drawable f17340r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f17341s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f17342t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CharSequence f17343u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f17344v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f17345w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f17346x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f17347y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f17348z;

    /* JADX INFO: compiled from: source.java */
    public final class a implements qh.e, View.OnLayoutChangeListener, View.OnClickListener, d.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final fo.b f17349a = new fo.b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f17350b;

        public a() {
        }

        @Override // com.applovin.impl.qh.e
        public void a() {
            if (e.this.f17326c != null) {
                e.this.f17326c.setVisibility(4);
            }
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a(float f11) {
            d20.b(this, f11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(int i11) {
            d20.c(this, i11);
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a(int i11, int i12) {
            d20.d(this, i11, i12);
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a(bf bfVar) {
            d20.e(this, bfVar);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(fo foVar, int i11) {
            d20.f(this, foVar, i11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(nh nhVar) {
            d20.g(this, nhVar);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(ph phVar) {
            d20.h(this, phVar);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public void a(po poVar, to toVar) {
            qh qhVar = (qh) b1.a(e.this.f17336n);
            fo foVarN = qhVar.n();
            if (foVarN.c()) {
                this.f17350b = null;
            } else if (qhVar.k().a()) {
                Object obj = this.f17350b;
                if (obj != null) {
                    int iA = foVarN.a(obj);
                    if (iA != -1) {
                        if (qhVar.t() == foVarN.a(iA, this.f17349a).f19033c) {
                            return;
                        }
                    }
                    this.f17350b = null;
                }
            } else {
                this.f17350b = foVarN.a(qhVar.v(), this.f17349a, true).f19032b;
            }
            e.this.c(false);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(qh.b bVar) {
            d20.j(this, bVar);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public void a(qh.f fVar, qh.f fVar2, int i11) {
            if (e.this.d() && e.this.f17346x) {
                e.this.c();
            }
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(qh qhVar, qh.d dVar) {
            d20.l(this, qhVar, dVar);
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a(r6 r6Var) {
            d20.m(this, r6Var);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(td tdVar, int i11) {
            d20.n(this, tdVar, i11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(vd vdVar) {
            d20.o(this, vdVar);
        }

        @Override // com.applovin.impl.qh.e
        public void a(xq xqVar) {
            e.this.h();
        }

        @Override // com.applovin.impl.qh.e
        public void a(List list) {
            if (e.this.f17330h != null) {
                e.this.f17330h.setCues(list);
            }
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a(boolean z11) {
            d20.r(this, z11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public void a(boolean z11, int i11) {
            e.this.i();
            e.this.k();
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void b() {
            c20.l(this);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public void b(int i11) {
            e.this.i();
            e.this.l();
            e.this.k();
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void b(int i11, boolean z11) {
            d20.u(this, i11, z11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void b(nh nhVar) {
            d20.v(this, nhVar);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void b(boolean z11) {
            d20.w(this, z11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void b(boolean z11, int i11) {
            c20.o(this, z11, i11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void c(int i11) {
            d20.x(this, i11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void c(boolean z11) {
            d20.y(this, z11);
        }

        @Override // com.applovin.exoplayer2.ui.d.e
        public void d(int i11) {
            e.this.j();
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void d(boolean z11) {
            d20.z(this, z11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void e(int i11) {
            c20.s(this, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void e(boolean z11) {
            c20.t(this, z11);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.g();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            e.b((TextureView) view, e.this.f17348z);
        }
    }

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i11) {
        int i12;
        boolean z11;
        int i13;
        int integer;
        boolean z12;
        boolean z13;
        int i14;
        boolean z14;
        int i15;
        boolean z15;
        int i16;
        boolean z16;
        boolean z17;
        boolean z18;
        super(context, attributeSet, i11);
        a aVar = new a();
        this.f17324a = aVar;
        if (isInEditMode()) {
            this.f17325b = null;
            this.f17326c = null;
            this.f17327d = null;
            this.f17328f = false;
            this.f17329g = null;
            this.f17330h = null;
            this.f17331i = null;
            this.f17332j = null;
            this.f17333k = null;
            this.f17334l = null;
            this.f17335m = null;
            ImageView imageView = new ImageView(context);
            if (xp.f24372a >= 23) {
                b(getResources(), imageView);
            } else {
                a(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i17 = R.layout.applovin_exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AppLovinPlayerView, i11, 0);
            try {
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppLovinPlayerView_al_shutter_background_color);
                int color = typedArrayObtainStyledAttributes.getColor(R.styleable.AppLovinPlayerView_al_shutter_background_color, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppLovinPlayerView_al_player_layout_id, i17);
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppLovinPlayerView_al_default_artwork, 0);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_use_controller, true);
                int i18 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerView_al_surface_type, 1);
                int i19 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerView_al_resize_mode, 0);
                int i21 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerView_al_show_timeout, 5000);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_hide_on_touch, true);
                boolean z23 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_auto_show, true);
                integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.AppLovinPlayerView_al_show_buffering, 0);
                this.f17342t = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_keep_content_on_player_reset, this.f17342t);
                boolean z24 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                z13 = z22;
                z11 = z23;
                i13 = i19;
                z16 = z21;
                i16 = resourceId2;
                z15 = z19;
                i15 = color;
                z14 = zHasValue;
                i14 = i18;
                i17 = resourceId;
                i12 = i21;
                z12 = z24;
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            i12 = 5000;
            z11 = true;
            i13 = 0;
            integer = 0;
            z12 = true;
            z13 = true;
            i14 = 1;
            z14 = false;
            i15 = 0;
            z15 = true;
            i16 = 0;
            z16 = true;
        }
        LayoutInflater.from(context).inflate(i17, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.id.al_exo_content_frame);
        this.f17325b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            a(aspectRatioFrameLayout, i13);
        }
        View viewFindViewById = findViewById(R.id.al_exo_shutter);
        this.f17326c = viewFindViewById;
        if (viewFindViewById != null && z14) {
            viewFindViewById.setBackgroundColor(i15);
        }
        if (aspectRatioFrameLayout == null || i14 == 0) {
            this.f17327d = null;
            z17 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i14 != 2) {
                if (i14 == 3) {
                    try {
                        int i22 = rk.f22121n;
                        this.f17327d = (View) rk.class.getConstructor(Context.class).newInstance(context);
                        z18 = true;
                    } catch (Exception e11) {
                        throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e11);
                    }
                } else if (i14 != 4) {
                    this.f17327d = new SurfaceView(context);
                } else {
                    try {
                        int i23 = rq.f22171b;
                        this.f17327d = (View) rq.class.getConstructor(Context.class).newInstance(context);
                    } catch (Exception e12) {
                        throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e12);
                    }
                }
                this.f17327d.setLayoutParams(layoutParams);
                this.f17327d.setOnClickListener(aVar);
                this.f17327d.setClickable(false);
                aspectRatioFrameLayout.addView(this.f17327d, 0);
                z17 = z18;
            } else {
                this.f17327d = new TextureView(context);
            }
            z18 = false;
            this.f17327d.setLayoutParams(layoutParams);
            this.f17327d.setOnClickListener(aVar);
            this.f17327d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f17327d, 0);
            z17 = z18;
        }
        this.f17328f = z17;
        this.f17334l = (FrameLayout) findViewById(R.id.al_exo_ad_overlay);
        this.f17335m = (FrameLayout) findViewById(R.id.al_exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R.id.al_exo_artwork);
        this.f17329g = imageView2;
        this.f17339q = z15 && imageView2 != null;
        if (i16 != 0) {
            this.f17340r = z2.a.getDrawable(getContext(), i16);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.al_exo_subtitles);
        this.f17330h = subtitleView;
        if (subtitleView != null) {
            subtitleView.c();
            subtitleView.d();
        }
        View viewFindViewById2 = findViewById(R.id.al_exo_buffering);
        this.f17331i = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.f17341s = integer;
        TextView textView = (TextView) findViewById(R.id.al_exo_error_message);
        this.f17332j = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        d dVar = (d) findViewById(R.id.al_exo_controller);
        View viewFindViewById3 = findViewById(R.id.al_exo_controller_placeholder);
        if (dVar != null) {
            this.f17333k = dVar;
        } else if (viewFindViewById3 != null) {
            d dVar2 = new d(context, null, 0, attributeSet);
            this.f17333k = dVar2;
            dVar2.setId(R.id.al_exo_controller);
            dVar2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(dVar2, iIndexOfChild);
        } else {
            this.f17333k = null;
        }
        d dVar3 = this.f17333k;
        this.f17344v = dVar3 != null ? i12 : 0;
        this.f17347y = z13;
        this.f17345w = z11;
        this.f17346x = z12;
        this.f17337o = z16 && dVar3 != null;
        c();
        j();
        d dVar4 = this.f17333k;
        if (dVar4 != null) {
            dVar4.a(aVar);
        }
    }

    private void a() {
        View view = this.f17326c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void a(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.applovin_exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R.color.al_exo_edit_mode_background_color));
    }

    private static void a(AspectRatioFrameLayout aspectRatioFrameLayout, int i11) {
        aspectRatioFrameLayout.setResizeMode(i11);
    }

    private void a(boolean z11) {
        if (!(d() && this.f17346x) && n()) {
            boolean z12 = this.f17333k.c() && this.f17333k.getShowTimeoutMs() <= 0;
            boolean zE = e();
            if (z11 || z12 || zE) {
                b(zE);
            }
        }
    }

    private boolean a(int i11) {
        return i11 == 19 || i11 == 270 || i11 == 22 || i11 == 271 || i11 == 20 || i11 == 269 || i11 == 21 || i11 == 268 || i11 == 23;
    }

    private boolean a(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                a(this.f17325b, intrinsicWidth / intrinsicHeight);
                this.f17329g.setImageDrawable(drawable);
                this.f17329g.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private boolean a(vd vdVar) {
        byte[] bArr = vdVar.f23837l;
        if (bArr == null) {
            return false;
        }
        return a(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    private void b() {
        ImageView imageView = this.f17329g;
        if (imageView != null) {
            imageView.setImageResource(android.R.color.transparent);
            this.f17329g.setVisibility(4);
        }
    }

    private static void b(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.applovin_exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(R.color.al_exo_edit_mode_background_color, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(TextureView textureView, int i11) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i11 != 0) {
            float f11 = width / 2.0f;
            float f12 = height / 2.0f;
            matrix.postRotate(i11, f11, f12);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f11, f12);
        }
        textureView.setTransform(matrix);
    }

    private void b(boolean z11) {
        if (n()) {
            this.f17333k.setShowTimeoutMs(z11 ? 0 : this.f17344v);
            this.f17333k.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z11) {
        qh qhVar = this.f17336n;
        if (qhVar == null || qhVar.k().a()) {
            if (this.f17342t) {
                return;
            }
            b();
            a();
            return;
        }
        if (z11 && !this.f17342t) {
            a();
        }
        to toVarA = qhVar.A();
        for (int i11 = 0; i11 < toVarA.f23420a; i11++) {
            so soVarA = toVarA.a(i11);
            if (soVarA != null) {
                for (int i12 = 0; i12 < soVarA.b(); i12++) {
                    if (Cif.e(soVarA.a(i12).f18900m) == 2) {
                        b();
                        return;
                    }
                }
            }
        }
        a();
        if (m() && (a(qhVar.C()) || a(this.f17340r))) {
            return;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        qh qhVar = this.f17336n;
        return qhVar != null && qhVar.d() && this.f17336n.l();
    }

    private boolean e() {
        qh qhVar = this.f17336n;
        if (qhVar == null) {
            return true;
        }
        int iO = qhVar.o();
        return this.f17345w && (iO == 1 || iO == 4 || !this.f17336n.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (!n() || this.f17336n == null) {
            return false;
        }
        if (!this.f17333k.c()) {
            a(true);
        } else if (this.f17347y) {
            this.f17333k.a();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        qh qhVar = this.f17336n;
        xq xqVarZ = qhVar != null ? qhVar.z() : xq.f24387f;
        int i11 = xqVarZ.f24389a;
        int i12 = xqVarZ.f24390b;
        int i13 = xqVarZ.f24391c;
        float f11 = (i12 == 0 || i11 == 0) ? 0.0f : (i11 * xqVarZ.f24392d) / i12;
        View view = this.f17327d;
        if (view instanceof TextureView) {
            if (f11 > 0.0f && (i13 == 90 || i13 == 270)) {
                f11 = 1.0f / f11;
            }
            if (this.f17348z != 0) {
                view.removeOnLayoutChangeListener(this.f17324a);
            }
            this.f17348z = i13;
            if (i13 != 0) {
                this.f17327d.addOnLayoutChangeListener(this.f17324a);
            }
            b((TextureView) this.f17327d, this.f17348z);
        }
        a(this.f17325b, this.f17328f ? 0.0f : f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x0020  */
    public void i() {
        boolean z11;
        if (this.f17331i != null) {
            qh qhVar = this.f17336n;
            if (qhVar == null || qhVar.o() != 2) {
                z11 = false;
            } else {
                int i11 = this.f17341s;
                z11 = true;
                if (i11 != 2 && (i11 != 1 || !this.f17336n.l())) {
                    z11 = false;
                }
            }
            this.f17331i.setVisibility(z11 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        d dVar = this.f17333k;
        if (dVar == null || !this.f17337o) {
            setContentDescription(null);
        } else if (dVar.getVisibility() == 0) {
            setContentDescription(this.f17347y ? getResources().getString(R.string.al_exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R.string.al_exo_controls_show));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (d() && this.f17346x) {
            c();
        } else {
            a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        TextView textView = this.f17332j;
        if (textView != null) {
            CharSequence charSequence = this.f17343u;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f17332j.setVisibility(0);
            } else {
                qh qhVar = this.f17336n;
                if (qhVar != null) {
                    qhVar.c();
                }
                this.f17332j.setVisibility(8);
            }
        }
    }

    private boolean m() {
        if (!this.f17339q) {
            return false;
        }
        b1.b(this.f17329g);
        return true;
    }

    private boolean n() {
        if (!this.f17337o) {
            return false;
        }
        b1.b(this.f17333k);
        return true;
    }

    public void a(AspectRatioFrameLayout aspectRatioFrameLayout, float f11) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f11);
        }
    }

    public boolean a(KeyEvent keyEvent) {
        return n() && this.f17333k.a(keyEvent);
    }

    public void c() {
        d dVar = this.f17333k;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        qh qhVar = this.f17336n;
        if (qhVar != null && qhVar.d()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean zA = a(keyEvent.getKeyCode());
        if (zA && n() && !this.f17333k.c()) {
            a(true);
            return true;
        }
        if (a(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            a(true);
            return true;
        }
        if (zA && n()) {
            a(true);
        }
        return false;
    }

    public void f() {
        b(e());
    }

    public List<t> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f17335m;
        if (frameLayout != null) {
            arrayList.add(new t(frameLayout, 3, "Transparent overlay does not impact viewability"));
        }
        d dVar = this.f17333k;
        if (dVar != null) {
            arrayList.add(new t(dVar, 0));
        }
        return eb.a((Collection) arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) b1.a(this.f17334l, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f17345w;
    }

    public boolean getControllerHideOnTouch() {
        return this.f17347y;
    }

    public int getControllerShowTimeoutMs() {
        return this.f17344v;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f17340r;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f17335m;
    }

    @Nullable
    public qh getPlayer() {
        return this.f17336n;
    }

    public int getResizeMode() {
        b1.b(this.f17325b);
        return this.f17325b.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f17330h;
    }

    public boolean getUseArtwork() {
        return this.f17339q;
    }

    public boolean getUseController() {
        return this.f17337o;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.f17327d;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!n() || this.f17336n == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.A = true;
            return true;
        }
        if (action != 1 || !this.A) {
            return false;
        }
        this.A = false;
        performClick();
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!n() || this.f17336n == null) {
            return false;
        }
        a(true);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return g();
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.b bVar) {
        b1.b(this.f17325b);
        this.f17325b.setAspectRatioListener(bVar);
    }

    @Deprecated
    public void setControlDispatcher(t4 t4Var) {
        b1.b(this.f17333k);
        this.f17333k.setControlDispatcher(t4Var);
    }

    public void setControllerAutoShow(boolean z11) {
        this.f17345w = z11;
    }

    public void setControllerHideDuringAds(boolean z11) {
        this.f17346x = z11;
    }

    public void setControllerHideOnTouch(boolean z11) {
        b1.b(this.f17333k);
        this.f17347y = z11;
        j();
    }

    public void setControllerShowTimeoutMs(int i11) {
        b1.b(this.f17333k);
        this.f17344v = i11;
        if (this.f17333k.c()) {
            f();
        }
    }

    public void setControllerVisibilityListener(@Nullable d.e eVar) {
        b1.b(this.f17333k);
        d.e eVar2 = this.f17338p;
        if (eVar2 == eVar) {
            return;
        }
        if (eVar2 != null) {
            this.f17333k.b(eVar2);
        }
        this.f17338p = eVar;
        if (eVar != null) {
            this.f17333k.a(eVar);
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        b1.b(this.f17332j != null);
        this.f17343u = charSequence;
        l();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f17340r != drawable) {
            this.f17340r = drawable;
            c(false);
        }
    }

    public void setErrorMessageProvider(@Nullable t7 t7Var) {
        if (t7Var != null) {
            l();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z11) {
        if (this.f17342t != z11) {
            this.f17342t = z11;
            c(false);
        }
    }

    public void setPlayer(@Nullable qh qhVar) {
        b1.b(Looper.myLooper() == Looper.getMainLooper());
        b1.a(qhVar == null || qhVar.p() == Looper.getMainLooper());
        qh qhVar2 = this.f17336n;
        if (qhVar2 == qhVar) {
            return;
        }
        if (qhVar2 != null) {
            qhVar2.a(this.f17324a);
            if (qhVar2.b(26)) {
                View view = this.f17327d;
                if (view instanceof TextureView) {
                    qhVar2.b((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    qhVar2.b((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.f17330h;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f17336n = qhVar;
        if (n()) {
            this.f17333k.setPlayer(qhVar);
        }
        i();
        l();
        c(true);
        if (qhVar == null) {
            c();
            return;
        }
        if (qhVar.b(26)) {
            View view2 = this.f17327d;
            if (view2 instanceof TextureView) {
                qhVar.a((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                qhVar.a((SurfaceView) view2);
            }
            h();
        }
        if (this.f17330h != null && qhVar.b(27)) {
            this.f17330h.setCues(qhVar.x());
        }
        qhVar.b(this.f17324a);
        a(false);
    }

    public void setRepeatToggleModes(int i11) {
        b1.b(this.f17333k);
        this.f17333k.setRepeatToggleModes(i11);
    }

    public void setResizeMode(int i11) {
        b1.b(this.f17325b);
        this.f17325b.setResizeMode(i11);
    }

    public void setShowBuffering(int i11) {
        if (this.f17341s != i11) {
            this.f17341s = i11;
            i();
        }
    }

    public void setShowFastForwardButton(boolean z11) {
        b1.b(this.f17333k);
        this.f17333k.setShowFastForwardButton(z11);
    }

    public void setShowMultiWindowTimeBar(boolean z11) {
        b1.b(this.f17333k);
        this.f17333k.setShowMultiWindowTimeBar(z11);
    }

    public void setShowNextButton(boolean z11) {
        b1.b(this.f17333k);
        this.f17333k.setShowNextButton(z11);
    }

    public void setShowPreviousButton(boolean z11) {
        b1.b(this.f17333k);
        this.f17333k.setShowPreviousButton(z11);
    }

    public void setShowRewindButton(boolean z11) {
        b1.b(this.f17333k);
        this.f17333k.setShowRewindButton(z11);
    }

    public void setShowShuffleButton(boolean z11) {
        b1.b(this.f17333k);
        this.f17333k.setShowShuffleButton(z11);
    }

    public void setShutterBackgroundColor(int i11) {
        View view = this.f17326c;
        if (view != null) {
            view.setBackgroundColor(i11);
        }
    }

    public void setUseArtwork(boolean z11) {
        b1.b((z11 && this.f17329g == null) ? false : true);
        if (this.f17339q != z11) {
            this.f17339q = z11;
            c(false);
        }
    }

    public void setUseController(boolean z11) {
        b1.b((z11 && this.f17333k == null) ? false : true);
        if (this.f17337o == z11) {
            return;
        }
        this.f17337o = z11;
        if (n()) {
            this.f17333k.setPlayer(this.f17336n);
        } else {
            d dVar = this.f17333k;
            if (dVar != null) {
                dVar.a();
                this.f17333k.setPlayer(null);
            }
        }
        j();
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        View view = this.f17327d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i11);
        }
    }
}
