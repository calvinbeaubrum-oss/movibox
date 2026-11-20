package com.bytedance.adsdk.ugeno.pFF;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.adsdk.ugeno.core.BT;
import com.bytedance.adsdk.ugeno.core.ExN;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.core.Qj;
import com.bytedance.adsdk.ugeno.core.Ql;
import com.bytedance.adsdk.ugeno.core.TRI;
import com.bytedance.adsdk.ugeno.core.Tf;
import com.bytedance.adsdk.ugeno.core.UFX;
import com.bytedance.adsdk.ugeno.core.WH;
import com.bytedance.adsdk.ugeno.core.pFF.We;
import com.bytedance.adsdk.ugeno.core.qr;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.warren.error.VungleException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zY<T extends View> implements View.OnTouchListener, Tf.pFF, Tf.sc, com.bytedance.adsdk.ugeno.zY {
    protected float AZJ;
    protected boolean BR;
    protected String BT;
    protected float Bs;
    protected boolean CYO;
    protected float Cb;
    protected boolean DNB;
    protected float Dl;
    private boolean EOI;
    private boolean EZl;
    protected Context ExN;
    private float Eyy;
    protected float FI;
    private boolean Flm;
    protected ImageView.ScaleType GI;
    private boolean GOt;
    protected float Gb;
    private boolean HBq;
    private boolean HC;
    protected float HJN;
    protected float IEI;
    protected boolean II;
    protected Tf JP;
    protected float JPJ;
    protected boolean JoC;
    protected boolean McK;
    protected float Mrq;
    protected float MxZ;
    protected ViewGroup.LayoutParams NP;
    protected int NQ;
    protected float OKY;
    protected float OXF;
    protected sc<ViewGroup> Ol;
    protected float PPh;
    private boolean Pu;
    protected boolean QLv;
    protected float QST;
    protected T Qj;
    protected boolean Ql;
    protected String SR;
    protected float Sfl;
    private boolean TEo;
    private boolean TI;
    protected JSONObject TRI;
    protected Qj Tf;
    protected boolean TpG;
    protected ExN.sc UFX;
    private boolean VZ;
    protected sc<ViewGroup> WH;
    protected Ql WMT;
    protected boolean WP;
    private boolean We;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.pFF.pFF WgX;
    protected float Xc;
    protected float YIK;
    protected int YdT;
    protected float Yhz;
    protected boolean ZM;
    private boolean Zn;

    /* JADX INFO: renamed from: ag, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.core.sc f26420ag;
    private boolean auq;
    protected String bSP;
    private String bZj;

    /* JADX INFO: renamed from: bp, reason: collision with root package name */
    @Deprecated
    private com.bytedance.adsdk.ugeno.core.pFF.sc f26421bp;
    protected float cD;
    protected boolean cJ;
    protected boolean cvk;
    protected float dE;
    protected float dix;

    /* JADX INFO: renamed from: ds, reason: collision with root package name */
    protected com.bytedance.adsdk.ugeno.qr.sc.C0234sc f26422ds;

    /* JADX INFO: renamed from: ef, reason: collision with root package name */
    private GradientDrawable f26423ef;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    protected boolean f26424eo;
    protected float eoh;
    protected boolean fT;

    /* JADX INFO: renamed from: fb, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.We.ExN f26425fb;
    protected float gsl;

    /* JADX INFO: renamed from: gx, reason: collision with root package name */
    protected float f26426gx;
    protected Map<Integer, WH> hE;

    /* JADX INFO: renamed from: ht, reason: collision with root package name */
    protected boolean f26427ht;
    protected boolean idT;
    private boolean jcs;
    private boolean jxU;
    protected float kDg;
    protected boolean kX;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    protected float f26428ko;
    private BT lD;
    protected float mD;
    protected float mbO;
    protected com.bytedance.adsdk.ugeno.sc.sc otH;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.pFF.ExN pCa;
    private boolean pFF;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    protected String f26429pc;
    protected int qKn;
    private qr qOv;
    private JSONObject qY;
    protected float qfG;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected JSONObject f26430qr;

    /* JADX INFO: renamed from: ra, reason: collision with root package name */
    @Deprecated
    private We f26431ra;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private boolean f26432sc;
    protected float uEA;
    protected TRI vYl;

    /* JADX INFO: renamed from: vl, reason: collision with root package name */
    private String f26433vl;
    protected float wjp;
    private com.bytedance.adsdk.ugeno.We.sc.sc xP;
    protected float yL;
    private boolean ymG;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.pFF.zY.sc ypJ;
    private boolean zY;

    public zY(Context context) {
        this(context, null);
    }

    public zY(Context context, sc<ViewGroup> scVar) {
        this.dE = -2.0f;
        this.Xc = -2.0f;
        this.bSP = "solid";
        this.NQ = 0;
        this.DNB = true;
        this.mD = 0.0f;
        this.dix = 0.0f;
        this.IEI = 0.0f;
        this.PPh = 1.0f;
        this.gsl = 1.0f;
        this.QST = 1.0f;
        this.eoh = 0.0f;
        this.Mrq = 0.0f;
        this.f26426gx = 0.0f;
        this.AZJ = 0.0f;
        this.mbO = 1.0f;
        this.Pu = true;
        this.jxU = true;
        this.Zn = false;
        this.EOI = false;
        this.Eyy = 12.0f;
        this.ExN = context;
        this.Ol = scVar;
        this.hE = new HashMap();
        this.f26423ef = new GradientDrawable();
        this.Qj = (T) We();
    }

    private boolean Qj(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, "hidden");
    }

    private void Yhz() {
        if (TextUtils.equals("dashed", this.bSP)) {
            GradientDrawable gradientDrawable = this.f26423ef;
            float f11 = this.Bs;
            gradientDrawable.setStroke((int) f11, this.YdT, 3.0f * f11, f11);
        } else {
            if (!TextUtils.equals("dotted", this.bSP)) {
                this.f26423ef.setStroke((int) this.Bs, this.YdT);
                return;
            }
            GradientDrawable gradientDrawable2 = this.f26423ef;
            float f12 = this.Bs;
            gradientDrawable2.setStroke((int) f12, this.YdT, f12 / 2.0f, f12);
        }
    }

    private void eo() {
        WH wh2;
        if (this.JP == null || !pFF(18) || (wh2 = this.hE.get(18)) == null) {
            return;
        }
        JSONObject jSONObjectZY = wh2.zY();
        if (jSONObjectZY != null) {
            try {
                jSONObjectZY.put("rotateZ", com.bytedance.adsdk.ugeno.zY.pFF.sc(jSONObjectZY.optString("rotateZ"), this.f26430qr));
            } catch (JSONException unused) {
            }
        }
        this.JP.sc(wh2, this, this);
    }

    private void qfG() {
        float f11 = this.f26427ht ? this.Yhz : this.yL;
        float f12 = this.ZM ? this.OKY : this.yL;
        float f13 = this.idT ? this.qfG : this.yL;
        float f14 = this.fT ? this.f26428ko : this.yL;
        this.f26423ef.setCornerRadii(new float[]{f11, f11, f12, f12, f14, f14, f13, f13});
    }

    private ImageView.ScaleType qr(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.GI = ImageView.ScaleType.CENTER;
                break;
            case "fit":
                this.GI = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.GI = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                this.GI = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.GI;
    }

    private void sc() {
        if (this.f26432sc) {
            this.Qj.setTranslationX(this.dix);
        }
        if (this.pFF) {
            this.Qj.setTranslationY(this.IEI);
        }
        if (this.zY) {
            this.Qj.setScaleX(this.gsl);
        }
        if (this.We) {
            this.Qj.setScaleY(this.QST);
        }
        if (this.jcs) {
            this.Qj.setRotation(this.eoh);
        }
        if (this.HC) {
            this.Qj.setRotationX(this.Mrq);
        }
        if (this.ymG) {
            this.Qj.setRotationY(this.f26426gx);
        }
        if (this.GOt) {
            this.Qj.setAlpha(this.mbO);
        }
        float f11 = this.AZJ;
        if (f11 != 0.0f) {
            this.Qj.setRotation(f11);
        }
    }

    private void yL() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.SR);
        this.Qj.setContentDescription(sb2);
    }

    @Deprecated
    private void zY() {
        com.bytedance.adsdk.ugeno.core.pFF.zY zYVarWe;
        this.Qj.setVisibility(this.NQ);
        float f11 = this.AZJ;
        if (f11 != 0.0f) {
            this.Qj.setRotation(f11);
        }
        ExN.sc scVar = this.UFX;
        if (scVar != null && TextUtils.isEmpty(scVar.pFF())) {
            this.Qj.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.pFF.zY.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    zY zYVar = zY.this;
                    if (zYVar.vYl != null) {
                        boolean unused = zYVar.jxU;
                    }
                }
            });
        } else if (pFF(1) && !this.Flm) {
            this.Qj.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.pFF.zY.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    zY zYVar = zY.this;
                    if (zYVar.JP == null || !zYVar.jxU) {
                        return;
                    }
                    zY zYVar2 = zY.this;
                    Tf tf2 = zYVar2.JP;
                    WH wh2 = zYVar2.hE.get(1);
                    zY zYVar3 = zY.this;
                    tf2.sc(wh2, zYVar3, zYVar3);
                }
            });
        }
        if (this.JP != null && pFF(4)) {
            if (pFF(1)) {
                this.EZl = true;
                this.f26431ra = new We(this.ExN, this.hE.get(4), this.hE.get(1), this.EZl);
            } else {
                this.f26431ra = new We(this.ExN, this.hE.get(4), this.EZl);
            }
        }
        if (this.JP != null && pFF(1) && this.Flm) {
            this.WgX = new com.bytedance.adsdk.ugeno.core.pFF.pFF(this.ExN, this.hE.get(1));
        }
        eo();
        if (this.JP != null && pFF(3) && (zYVarWe = com.bytedance.adsdk.ugeno.We.sc().We()) != null) {
            this.ypJ = zYVarWe.sc(this.ExN);
            new Object() { // from class: com.bytedance.adsdk.ugeno.pFF.zY.3
            };
        }
        if (this.JP != null && pFF(9)) {
            com.bytedance.adsdk.ugeno.core.pFF.ExN exN = new com.bytedance.adsdk.ugeno.core.pFF.ExN(this.ExN, this.hE.get(9), this);
            this.pCa = exN;
            exN.sc(this.JP);
        }
        if (pFF(10)) {
            com.bytedance.adsdk.ugeno.core.pFF.sc scVar2 = new com.bytedance.adsdk.ugeno.core.pFF.sc(this.ExN, this.hE.get(10), this);
            this.f26421bp = scVar2;
            scVar2.sc(this.JP);
        }
    }

    public com.bytedance.adsdk.ugeno.We.sc.sc BR() {
        return this.xP;
    }

    public float BT() {
        return this.QST;
    }

    public void CYO() {
    }

    public int Cb() {
        return (int) this.dE;
    }

    public Tf Dl() {
        return this.JP;
    }

    @Override // com.bytedance.adsdk.ugeno.zY
    public void ExN() {
        if (this.lD == null || this.auq) {
            return;
        }
        this.auq = true;
    }

    public void ExN(int i11) {
        if (!McK()) {
            ViewGroup.LayoutParams layoutParams = this.Qj.getLayoutParams();
            layoutParams.width = i11;
            this.Qj.setLayoutParams(layoutParams);
            return;
        }
        T t11 = this.Qj;
        if (t11 instanceof pFF) {
            ((pFF) t11).sc(i11);
            return;
        }
        ViewParent viewParent = (ViewGroup) t11.getParent();
        if (viewParent instanceof pFF) {
            ((pFF) viewParent).sc(this.Qj, i11);
        }
    }

    public void ExN(String str) {
        this.SR = str;
    }

    public void FI() {
        com.bytedance.adsdk.ugeno.We.sc().pFF().sc(this.Tf, this.f26429pc, new com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc() { // from class: com.bytedance.adsdk.ugeno.pFF.zY.4
            @Override // com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc
            public void sc(final Bitmap bitmap) {
                if (bitmap != null) {
                    zY zYVar = zY.this;
                    if (!zYVar.QLv) {
                        com.bytedance.adsdk.ugeno.qr.Qj.sc(new Runnable() { // from class: com.bytedance.adsdk.ugeno.pFF.zY.4.2
                            @Override // java.lang.Runnable
                            public void run() {
                                zY.this.sc(new BitmapDrawable(bitmap));
                            }
                        });
                        return;
                    }
                    final Bitmap bitmapSc = com.bytedance.adsdk.ugeno.qr.Qj.sc(zYVar.ExN, bitmap, (int) zYVar.MxZ);
                    if (bitmapSc != null) {
                        com.bytedance.adsdk.ugeno.qr.Qj.sc(new Runnable() { // from class: com.bytedance.adsdk.ugeno.pFF.zY.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                zY.this.sc(new BitmapDrawable(bitmapSc));
                            }
                        });
                    }
                }
            }
        });
    }

    public float GI() {
        T t11 = this.Qj;
        if (t11 instanceof com.bytedance.adsdk.ugeno.sc.ExN) {
            return ((com.bytedance.adsdk.ugeno.sc.ExN) t11).getStretch();
        }
        return 0.0f;
    }

    public String Gb() {
        return this.SR;
    }

    public sc HJN() {
        return this.Ol;
    }

    public ExN.sc II() {
        return this.UFX;
    }

    public void JPJ() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmapSc;
        if (TextUtils.isEmpty(this.f26429pc)) {
            if (this.TpG) {
                sc(this.f26422ds);
                return;
            } else {
                this.f26423ef.setColor(this.qKn);
                We(this.qKn);
                return;
            }
        }
        if (!this.f26429pc.startsWith("local://")) {
            FI();
            return;
        }
        String strReplace = this.f26429pc.replace("local://", "");
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = this.QLv ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
            options.inPurgeable = true;
            options.inInputShareable = true;
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.ExN.getResources().openRawResource(com.bytedance.adsdk.ugeno.qr.We.sc(this.ExN, strReplace)), null, options);
            if (!this.QLv || (bitmapSc = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, bitmapDecodeStream, (int) this.MxZ)) == null) {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.ExN.getResources(), bitmapDecodeStream);
                bitmapDrawable = bitmapDrawable2;
            } else {
                bitmapDrawable = new BitmapDrawable(this.ExN.getResources(), bitmapSc);
            }
            sc(bitmapDrawable);
        } catch (Throwable unused) {
        }
    }

    public void JoC() {
    }

    public boolean McK() {
        return this.Ql;
    }

    public float MxZ() {
        T t11 = this.Qj;
        if (t11 instanceof com.bytedance.adsdk.ugeno.sc.ExN) {
            return ((com.bytedance.adsdk.ugeno.sc.ExN) t11).getRubIn();
        }
        return 0.0f;
    }

    public int OXF() {
        return (int) this.Xc;
    }

    public T Ol() {
        return this.Qj;
    }

    public boolean QLv() {
        return this.VZ;
    }

    public void Qj() {
        qr qrVar = this.qOv;
        if (qrVar != null) {
            qrVar.pFF();
        }
        com.bytedance.adsdk.ugeno.sc.sc scVar = this.otH;
        if (scVar != null) {
            scVar.pFF();
        }
    }

    public float Ql() {
        return this.IEI;
    }

    public float SR() {
        return this.gsl;
    }

    public float Sfl() {
        return this.mbO;
    }

    @Override // com.bytedance.adsdk.ugeno.zY
    public void TRI() {
        if (this.lD == null || this.TI) {
            return;
        }
        this.TI = true;
    }

    public void TRI(int i11) {
        if (!McK()) {
            ViewGroup.LayoutParams layoutParams = this.Qj.getLayoutParams();
            layoutParams.height = i11;
            this.Qj.setLayoutParams(layoutParams);
            return;
        }
        T t11 = this.Qj;
        if (t11 instanceof pFF) {
            ((pFF) t11).pFF(i11);
            return;
        }
        ViewParent viewParent = (ViewGroup) t11.getParent();
        if (viewParent instanceof pFF) {
            ((pFF) viewParent).pFF(this.Qj, i11);
        }
    }

    public void TRI(String str) {
        this.BT = str;
    }

    public float Tf() {
        return this.dix;
    }

    public void UFX() {
        this.Qj.setPadding((int) (this.kX ? this.Gb : this.HJN), (int) (this.JoC ? this.Cb : this.HJN), (int) (this.BR ? this.cD : this.HJN), (int) (this.CYO ? this.OXF : this.HJN));
    }

    public JSONObject WH() {
        return this.f26430qr;
    }

    public ViewGroup.LayoutParams WP() {
        return this.NP;
    }

    public T We() {
        return null;
    }

    public zY<T> We(String str) {
        return pFF(str);
    }

    public void We(int i11) {
        this.f26423ef.setShape(0);
        this.f26423ef.setColor(i11);
        qfG();
        Yhz();
        this.Qj.setBackground(this.f26423ef);
    }

    public float Xc() {
        return this.f26426gx;
    }

    public float YIK() {
        return this.yL;
    }

    public String cD() {
        return this.BT;
    }

    public boolean cJ() {
        return this.DNB;
    }

    public void cvk() {
        if (this.Qj != null) {
            sc(this.NP);
            ExN((int) this.dE);
            TRI((int) this.Xc);
        }
    }

    public float dE() {
        return this.Mrq;
    }

    public int kX() {
        return this.qKn;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        We we2;
        Tf tf2;
        com.bytedance.adsdk.ugeno.core.pFF.pFF pff;
        int action = motionEvent.getAction();
        if (action == 0) {
            JoC();
        } else if (action == 1 || action == 3) {
            CYO();
        }
        Ql ql2 = this.WMT;
        if (ql2 != null) {
            ql2.sc(this, motionEvent);
        }
        if (pFF(17) && motionEvent.getAction() == 0) {
            this.JP.sc(this.hE.get(17), this, this);
        }
        if (pFF(1) && this.Flm && (tf2 = this.JP) != null && (pff = this.WgX) != null) {
            return pff.sc(tf2, this, motionEvent);
        }
        Tf tf3 = this.JP;
        if (tf3 != null && (we2 = this.f26431ra) != null) {
            return we2.sc(tf3, this, motionEvent);
        }
        com.bytedance.adsdk.ugeno.We.ExN exN = this.f26425fb;
        if (exN != null) {
            return exN.sc(motionEvent);
        }
        return false;
    }

    public zY pFF(zY zYVar) {
        return (zYVar.HJN() == null && (zYVar instanceof sc)) ? zYVar : pFF(zYVar.HJN());
    }

    public zY<T> pFF(String str) {
        if (TextUtils.isEmpty(this.BT) || !TextUtils.equals(this.BT, str)) {
            return null;
        }
        return this;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void pFF() {
        JPJ();
        UFX();
        zY(this.NQ);
        sc();
        zY();
        com.bytedance.adsdk.ugeno.We.ExN exN = this.f26425fb;
        if (exN != null) {
            exN.sc();
            this.f26425fb.pFF();
            this.f26425fb.zY();
        }
        this.Qj.setOnTouchListener(this);
        yL();
        ViewGroup viewGroup = (ViewGroup) this.Qj.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.Pu);
        }
        com.bytedance.adsdk.ugeno.sc.sc scVar = this.otH;
        if (scVar != null) {
            scVar.zY();
        }
        if (this.JP == null || !pFF(22)) {
            return;
        }
        this.JP.sc(this.hE.get(22), this, this);
    }

    @Override // com.bytedance.adsdk.ugeno.zY
    public void pFF(int i11, int i12, int i13, int i14) {
        qr qrVar = this.qOv;
        if (qrVar != null) {
            qrVar.sc(i11, i12);
        }
        com.bytedance.adsdk.ugeno.sc.sc scVar = this.otH;
        if (scVar != null) {
            scVar.sc(i11, i12);
        }
    }

    public void pFF(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.hE == null) {
            return;
        }
        try {
            int iSc = UFX.sc(str).sc();
            WH wh2 = new WH();
            wh2.sc(iSc);
            wh2.sc(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (iSc == 3) {
                try {
                    this.Eyy = Float.parseFloat(com.bytedance.adsdk.ugeno.zY.pFF.sc(jSONObject.optString("shakeAmplitude"), this.f26430qr));
                } catch (NumberFormatException unused) {
                    this.Eyy = 12.0f;
                }
            }
            Tf tf2 = this.JP;
            if (!(tf2 instanceof com.bytedance.adsdk.ugeno.core.sc.sc)) {
                sc(iSc, jSONObject, wh2);
            } else if (!((com.bytedance.adsdk.ugeno.core.sc.sc) tf2).sc()) {
                sc(iSc, jSONObject, wh2);
            } else {
                wh2.sc(jSONObject);
                this.hE.put(Integer.valueOf(iSc), wh2);
            }
        } catch (JSONException unused2) {
        }
    }

    public void pFF(JSONObject jSONObject) {
        this.TRI = jSONObject;
    }

    public boolean pFF(int i11) {
        Map<Integer, WH> map = this.hE;
        return map != null && map.containsKey(Integer.valueOf(i11));
    }

    public float pc() {
        T t11 = this.Qj;
        if (t11 instanceof com.bytedance.adsdk.ugeno.sc.ExN) {
            return ((com.bytedance.adsdk.ugeno.sc.ExN) t11).getShine();
        }
        return 0.0f;
    }

    public float qKn() {
        T t11 = this.Qj;
        if (t11 instanceof com.bytedance.adsdk.ugeno.sc.ExN) {
            return ((com.bytedance.adsdk.ugeno.sc.ExN) t11).getRipple();
        }
        return 0.0f;
    }

    public void qr() {
        com.bytedance.adsdk.ugeno.core.sc scVar = this.f26420ag;
        if (scVar != null) {
            qr qrVar = new qr(this.Qj, scVar);
            this.qOv = qrVar;
            qrVar.sc();
        }
        com.bytedance.adsdk.ugeno.sc.sc scVar2 = this.otH;
        if (scVar2 != null) {
            scVar2.sc();
        }
        com.bytedance.adsdk.ugeno.We.ExN exN = this.f26425fb;
        if (exN != null) {
            exN.We();
        }
        if (this.f26421bp != null && pFF(10)) {
            this.f26421bp.sc();
        }
        if (this.pCa == null || !pFF(9)) {
            return;
        }
        this.pCa.sc();
    }

    public zY<T> sc(String str) {
        if (TextUtils.isEmpty(this.SR) || !TextUtils.equals(this.SR, str)) {
            return null;
        }
        return this;
    }

    @Override // com.bytedance.adsdk.ugeno.zY
    public void sc(int i11, int i12, int i13, int i14) {
        if (this.lD == null || this.TEo) {
            return;
        }
        this.TEo = true;
    }

    @Deprecated
    public void sc(int i11, JSONObject jSONObject, WH wh2) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
        if (jSONObjectOptJSONObject != null) {
            WH wh3 = new WH();
            wh3.sc(jSONObjectOptJSONObject);
            wh3.sc(this);
            wh2.sc(wh3);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("fail");
        if (jSONObjectOptJSONObject2 != null) {
            WH wh4 = new WH();
            wh4.sc(jSONObjectOptJSONObject2);
            wh4.sc(this);
            wh2.pFF(wh4);
        }
        wh2.sc(jSONObject);
        this.hE.put(Integer.valueOf(i11), wh2);
    }

    @Override // com.bytedance.adsdk.ugeno.zY
    public void sc(Canvas canvas) {
        com.bytedance.adsdk.ugeno.sc.sc scVar = this.otH;
        if (scVar != null) {
            scVar.sc(canvas);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.zY
    public void sc(Canvas canvas, IAnimation iAnimation) {
        qr qrVar = this.qOv;
        if (qrVar != null) {
            qrVar.sc(canvas, iAnimation);
        }
    }

    public void sc(Drawable drawable) {
        this.Qj.setBackground(drawable);
    }

    public void sc(ViewGroup.LayoutParams layoutParams) {
        T t11 = this.Qj;
        if (t11 != null) {
            t11.setLayoutParams(layoutParams);
        }
        this.NP = layoutParams;
    }

    public void sc(com.bytedance.adsdk.ugeno.We.sc.sc scVar) {
        this.xP = scVar;
    }

    public void sc(BT bt2) {
        this.lD = bt2;
    }

    public void sc(ExN.sc scVar) {
        this.UFX = scVar;
    }

    public void sc(Qj qj2) {
        this.Tf = qj2;
    }

    public void sc(Ql ql2) {
        this.WMT = ql2;
    }

    public void sc(TRI tri) {
        this.vYl = tri;
    }

    public void sc(Tf tf2) {
        this.JP = tf2;
    }

    @Override // com.bytedance.adsdk.ugeno.core.Tf.pFF
    public void sc(WH wh2) {
        sc<ViewGroup> scVar;
        zY<T> zYVarZY;
        if (wh2 == null || wh2.zY() == null || !TextUtils.equals(wh2.zY().optString("type"), "onDismiss")) {
            return;
        }
        String strOptString = wh2.zY().optString("nodeId");
        zY(8);
        this.WH = (sc) pFF(this);
        if (TextUtils.isEmpty(strOptString) || (scVar = this.WH) == null || (zYVarZY = scVar.zY(strOptString)) == null) {
            return;
        }
        zYVarZY.zY(8);
    }

    public void sc(sc scVar) {
        this.Ol = scVar;
    }

    public void sc(com.bytedance.adsdk.ugeno.qr.sc.C0234sc c0234sc) {
        if (c0234sc == null) {
            return;
        }
        this.f26423ef.setShape(0);
        this.f26423ef.setOrientation(c0234sc.f26444sc);
        if (Build.VERSION.SDK_INT >= 29) {
            this.f26423ef.setColors(c0234sc.pFF, c0234sc.zY);
        } else {
            this.f26423ef.setColors(c0234sc.pFF);
        }
        qfG();
        Yhz();
        this.Qj.setBackground(this.f26423ef);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void sc(String str, String str2) {
        sc<ViewGroup> scVar;
        sc<ViewGroup> scVar2;
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1964681502:
                if (str.equals("clickable")) {
                    b11 = 0;
                }
                break;
            case -1901681170:
                if (str.equals("onRenderSuccess")) {
                    b11 = 1;
                }
                break;
            case -1721943862:
                if (str.equals("translateX")) {
                    b11 = 2;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    b11 = 3;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    b11 = 4;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    b11 = 5;
                }
                break;
            case -1351184668:
                if (str.equals("onDelay")) {
                    b11 = 6;
                }
                break;
            case -1337252761:
                if (str.equals("onShake")) {
                    b11 = 7;
                }
                break;
            case -1337126126:
                if (str.equals("onSlide")) {
                    b11 = 8;
                }
                break;
            case -1336288090:
                if (str.equals("onTimer")) {
                    b11 = 9;
                }
                break;
            case -1335874424:
                if (str.equals("onTwist")) {
                    b11 = 10;
                }
                break;
            case -1332194002:
                if (str.equals("background")) {
                    b11 = Ascii.VT;
                }
                break;
            case -1291329255:
                if (str.equals("events")) {
                    b11 = Ascii.FF;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    b11 = Ascii.CR;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    b11 = Ascii.SO;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    b11 = Ascii.SI;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    b11 = Ascii.DLE;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    b11 = 17;
                }
                break;
            case -1013407967:
                if (str.equals("onDown")) {
                    b11 = Ascii.DC2;
                }
                break;
            case -933876756:
                if (str.equals("backgroundDrawable")) {
                    b11 = 19;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    b11 = Ascii.DC4;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b11 = Ascii.NAK;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b11 = Ascii.SYN;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    b11 = Ascii.ETB;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    b11 = Ascii.CAN;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    b11 = Ascii.EM;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    b11 = Ascii.SUB;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    b11 = Ascii.ESC;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    b11 = Ascii.FS;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b11 = Ascii.GS;
                }
                break;
            case 87811796:
                if (str.equals("backgroundImageBlur")) {
                    b11 = Ascii.RS;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    b11 = Ascii.US;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    b11 = 32;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    b11 = 33;
                }
                break;
            case 108285963:
                if (str.equals("ratio")) {
                    b11 = 34;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    b11 = 35;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b11 = 36;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    b11 = 37;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    b11 = 38;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    b11 = 39;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    b11 = 40;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    b11 = 41;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    b11 = 42;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    b11 = 43;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    b11 = 44;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    b11 = 45;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    b11 = 46;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    b11 = 47;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    b11 = 48;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    b11 = 49;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    b11 = 50;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    b11 = 51;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    b11 = 52;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    b11 = 53;
                }
                break;
            case 1287124693:
                if (str.equals(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    b11 = 54;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    b11 = 55;
                }
                break;
            case 1301532860:
                if (str.equals("backgroundScale")) {
                    b11 = 56;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    b11 = 57;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    b11 = 58;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    b11 = 59;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    b11 = 60;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    b11 = 61;
                }
                break;
            case 1671308008:
                if (str.equals("disable")) {
                    b11 = 62;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    b11 = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    b11 = 64;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    b11 = 65;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    b11 = 66;
                }
                break;
        }
        switch (b11) {
            case 0:
                this.jxU = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, true);
                break;
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 18:
            case 33:
            case 38:
            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
            case 50:
            case 53:
            case 61:
            case 63:
                pFF(str, str2);
                break;
            case 2:
                this.f26432sc = true;
                this.dix = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f));
                break;
            case 3:
                this.pFF = true;
                this.IEI = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f));
                break;
            case 4:
                this.Gb = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.kX = true;
                break;
            case 5:
                this.JPJ = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 11:
            case 54:
                if (!com.bytedance.adsdk.ugeno.qr.sc.zY(str2)) {
                    this.qKn = com.bytedance.adsdk.ugeno.qr.sc.sc(str2, 0);
                    this.TpG = false;
                } else {
                    this.TpG = true;
                    this.f26422ds = com.bytedance.adsdk.ugeno.qr.sc.pFF(str2);
                }
                break;
            case 12:
                this.f26425fb = com.bytedance.adsdk.ugeno.We.ExN.sc(this, str2);
                break;
            case 13:
                this.GOt = true;
                this.mbO = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 1.0f);
                break;
            case 14:
                this.Yhz = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.f26427ht = true;
                break;
            case 15:
                if (TextUtils.equals(str2, "match_parent")) {
                    if (McK() && (scVar = this.Ol) != null && scVar.OXF() == -2) {
                        this.Xc = -2.0f;
                    } else {
                        this.Xc = -1.0f;
                    }
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.Xc = -2.0f;
                } else {
                    this.Xc = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                }
                this.EOI = true;
                break;
            case 16:
                this.wjp = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                break;
            case 17:
                this.Dl = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.II = true;
                break;
            case 19:
            case 55:
                this.f26429pc = str2;
                break;
            case 20:
                this.jcs = true;
                this.eoh = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 21:
                this.zY = true;
                this.gsl = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 22:
                this.We = true;
                this.QST = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 23:
                this.HJN = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.cJ = true;
                break;
            case 24:
                this.bZj = str2;
                break;
            case 25:
                this.uEA = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.McK = true;
                break;
            case 26:
                this.FI = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 27:
                this.SR = str2;
                break;
            case 28:
                this.qY = com.bytedance.adsdk.ugeno.qr.pFF.sc(str2, (JSONObject) null);
                break;
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                this.BT = str2;
                break;
            case 30:
                float fSc = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                this.MxZ = fSc;
                if (fSc > 0.0f) {
                    this.QLv = true;
                }
                break;
            case VungleException.WEB_CRASH /* 31 */:
                this.Cb = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.JoC = true;
                break;
            case 32:
                this.f26433vl = str2;
                break;
            case 34:
                this.kDg = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 35:
                this.zY = true;
                this.We = true;
                float[] fArrZY = com.bytedance.adsdk.ugeno.sc.zY.zY(str2);
                this.gsl = fArrZY[0];
                this.QST = fArrZY[1];
                break;
            case 36:
                if (TextUtils.equals(str2, "match_parent")) {
                    if (McK() && (scVar2 = this.Ol) != null && scVar2.Cb() == -2) {
                        this.dE = -2.0f;
                    } else {
                        this.dE = -1.0f;
                    }
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.dE = -2.0f;
                } else {
                    this.dE = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                }
                this.Zn = true;
                break;
            case 37:
                this.OXF = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.CYO = true;
                break;
            case 39:
                this.OKY = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.ZM = true;
                break;
            case 40:
                this.Pu = Qj(str2);
                break;
            case 41:
                this.qfG = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.idT = true;
                break;
            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                this.f26428ko = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.fT = true;
                break;
            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                this.cD = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.BR = true;
                break;
            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                this.YdT = com.bytedance.adsdk.ugeno.qr.sc.sc(str2);
                break;
            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                this.bSP = str2;
                break;
            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                this.Bs = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                break;
            case 48:
                this.YIK = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.cvk = true;
                break;
            case 49:
                this.f26432sc = true;
                this.pFF = true;
                float[] fArrZY2 = com.bytedance.adsdk.ugeno.sc.zY.zY(str2);
                this.dix = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, fArrZY2[0]);
                this.IEI = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, fArrZY2[1]);
                break;
            case 51:
                try {
                    this.otH = new com.bytedance.adsdk.ugeno.sc.sc(this.ExN, this, com.bytedance.adsdk.ugeno.sc.zY.sc(new JSONObject(str2)));
                } catch (JSONException unused) {
                    return;
                }
                break;
            case 52:
                this.f26420ag = com.bytedance.adsdk.ugeno.core.sc.sc(str2, this);
                break;
            case 56:
                this.f26424eo = true;
                this.GI = qr(str2);
                break;
            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                this.yL = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                break;
            case 58:
                this.HC = true;
                this.Mrq = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 59:
                this.ymG = true;
                this.f26426gx = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 60:
                this.AZJ = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 62:
                this.VZ = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, false);
                break;
            case 64:
                if (TextUtils.equals("visible", str2)) {
                    this.NQ = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.NQ = 4;
                } else if (TextUtils.equals("gone", str2) || TextUtils.equals("hidden", str2)) {
                    this.NQ = 8;
                }
                this.Qj.setVisibility(this.NQ);
                break;
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                this.Sfl = com.bytedance.adsdk.ugeno.qr.Qj.sc(this.ExN, str2);
                this.WP = true;
                break;
            case 66:
                this.DNB = !TextUtils.equals(str2, "unavailable");
                break;
        }
    }

    public void sc(JSONObject jSONObject) {
        this.f26430qr = jSONObject;
        JSONObject jSONObject2 = this.TRI;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        sc<ViewGroup> scVar = this.Ol;
        sc.C0233sc c0233scZY = scVar instanceof sc ? scVar.zY() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strSc = com.bytedance.adsdk.ugeno.zY.pFF.sc(this.TRI.optString(next), jSONObject);
            sc(next, strSc);
            if (c0233scZY != null) {
                c0233scZY.sc(this.ExN, next, strSc);
            }
        }
        if (c0233scZY != null) {
            sc(c0233scZY.sc());
        }
        if (this.qY == null || this.f26430qr == null) {
            return;
        }
        try {
            if (!McK()) {
                this.f26430qr.put("i18n", this.qY);
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("i18n", this.qY);
            this.f26430qr.put("xNode", jSONObject3);
        } catch (JSONException unused) {
        }
    }

    public void sc(boolean z11) {
        this.Ql = z11;
    }

    @Override // com.bytedance.adsdk.ugeno.zY
    public int[] sc(int i11, int i12) {
        if (this.kDg > 0.0f) {
            if (this.Zn) {
                int size = View.MeasureSpec.getSize(i11);
                float f11 = this.kDg;
                if (f11 != 0.0f) {
                    i12 = View.MeasureSpec.makeMeasureSpec((int) (size / f11), 1073741824);
                }
            } else if (this.EOI) {
                int size2 = View.MeasureSpec.getSize(i12);
                float f12 = this.kDg;
                if (f12 != 0.0f) {
                    i11 = View.MeasureSpec.makeMeasureSpec((int) (size2 * f12), 1073741824);
                }
            }
        }
        if (this.lD != null && !this.HBq) {
            this.HBq = true;
        }
        return new int[]{i11, i12};
    }

    public JSONObject uEA() {
        return this.TRI;
    }

    public float wjp() {
        return this.AZJ;
    }

    public zY<T> zY(String str) {
        return sc(str);
    }

    public void zY(int i11) {
        ViewParent viewParent = (ViewGroup) this.Qj.getParent();
        if (viewParent instanceof pFF) {
            ((pFF) viewParent).zY(this.Qj, i11);
        } else {
            this.Qj.setVisibility(i11);
        }
    }
}
