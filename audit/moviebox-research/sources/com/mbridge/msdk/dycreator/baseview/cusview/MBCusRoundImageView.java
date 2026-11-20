package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.foundation.tools.ad;
import com.transsion.gslb.Utils;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBCusRoundImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f43407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f43408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f43409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Xfermode f43411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f43412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f43413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f43414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f43415i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f43416j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f43417k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f43418l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f43419m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f43420n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float[] f43421o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float[] f43422p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private RectF f43423q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private RectF f43424r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f43425s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f43426t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Path f43427u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Paint f43428v;

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f43429a;

        static {
            int[] iArr = new int[c.values().length];
            f43429a = iArr;
            try {
                iArr[c.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43429a[c.src.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43429a[c.background.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43429a[c.contentDescription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43429a[c.tag.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f43429a[c.visibility.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f43429a[c.scaleType.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f43429a[c.padding.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f43429a[c.paddingTop.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f43429a[c.paddingBottom.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f43429a[c.paddingLeft.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f43429a[c.paddingRight.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f43429a[c.layout_width.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f43429a[c.layout_height.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f43429a[c.gravity.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f43429a[c.layout_gravity.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public MBCusRoundImageView(Context context) {
        this(context, null);
    }

    public MBCusRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
        try {
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(context, attributeSet));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public MBCusRoundImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43427u = new Path();
        this.f43428v = new Paint();
        this.f43421o = new float[8];
        this.f43422p = new float[8];
        this.f43424r = new RectF();
        this.f43423q = new RectF();
        this.f43411e = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    public ViewGroup.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        HashMap<String, c> mapC = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            c cVar = mapC.get(attributeSet.getAttributeName(i11));
            if (cVar != null) {
                int i12 = AnonymousClass1.f43429a[cVar.ordinal()];
                if (i12 == 6) {
                    String attributeValue = attributeSet.getAttributeValue(i11);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        if (attributeValue.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                } else if (i12 == 13) {
                    String attributeValue2 = attributeSet.getAttributeValue(i11);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue2.startsWith("wrap")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue2);
                    }
                } else if (i12 == 14) {
                    String attributeValue3 = attributeSet.getAttributeValue(i11);
                    if (attributeValue3.startsWith("f") || attributeValue3.startsWith("m")) {
                        layoutParams.height = -1;
                    } else if (attributeValue3.startsWith("wrap")) {
                        layoutParams.height = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue3);
                    }
                }
            }
        }
        return layoutParams;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        try {
            canvas.saveLayer(this.f43423q, null, 31);
            int i11 = this.f43412f;
            int i12 = this.f43419m;
            int i13 = this.f43413g;
            canvas.scale(((i11 - (i12 * 2)) * 1.0f) / i11, ((i13 - (i12 * 2)) * 1.0f) / i13, i11 / 2.0f, i13 / 2.0f);
            super.onDraw(canvas);
            Paint paint = this.f43428v;
            if (paint != null) {
                paint.reset();
                this.f43428v.setAntiAlias(true);
                this.f43428v.setStyle(Paint.Style.FILL);
                this.f43428v.setXfermode(this.f43411e);
            }
            Path path = this.f43427u;
            if (path != null) {
                path.reset();
                this.f43427u.addRoundRect(this.f43423q, this.f43422p, Path.Direction.CCW);
            }
            canvas.drawPath(this.f43427u, this.f43428v);
            Paint paint2 = this.f43428v;
            if (paint2 != null) {
                paint2.setXfermode(null);
            }
            canvas.restore();
            if (this.f43425s) {
                int i14 = this.f43419m;
                int i15 = this.f43420n;
                RectF rectF = this.f43424r;
                float[] fArr = this.f43421o;
                try {
                    Path path2 = this.f43427u;
                    if (path2 != null) {
                        path2.reset();
                    }
                    Paint paint3 = this.f43428v;
                    if (paint3 != null) {
                        paint3.setStrokeWidth(i14);
                        this.f43428v.setColor(i15);
                        this.f43428v.setStyle(Paint.Style.STROKE);
                    }
                    Path path3 = this.f43427u;
                    if (path3 != null) {
                        path3.addRoundRect(rectF, fArr, Path.Direction.CCW);
                    }
                    canvas.drawPath(this.f43427u, this.f43428v);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        } catch (Exception e12) {
            ad.a("MBridgeImageView", e12.getMessage());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        super.onSizeChanged(i11, i12, i13, i14);
        try {
            this.f43412f = i11;
            this.f43413g = i12;
            int i18 = 0;
            if (this.f43426t) {
                try {
                    if (this.f43421o != null && this.f43422p != null) {
                        while (true) {
                            i15 = 2;
                            if (i18 >= 2) {
                                break;
                            }
                            float[] fArr = this.f43421o;
                            int i19 = this.f43415i;
                            fArr[i18] = i19;
                            this.f43422p[i18] = i19 - (this.f43419m / 2.0f);
                            i18++;
                        }
                        while (true) {
                            i16 = 4;
                            if (i15 >= 4) {
                                break;
                            }
                            float[] fArr2 = this.f43421o;
                            int i21 = this.f43416j;
                            fArr2[i15] = i21;
                            this.f43422p[i15] = i21 - (this.f43419m / 2.0f);
                            i15++;
                        }
                        while (true) {
                            if (i16 >= 6) {
                                break;
                            }
                            float[] fArr3 = this.f43421o;
                            int i22 = this.f43417k;
                            fArr3[i16] = i22;
                            this.f43422p[i16] = i22 - (this.f43419m / 2.0f);
                            i16++;
                        }
                        for (i17 = 6; i17 < 8; i17++) {
                            float[] fArr4 = this.f43421o;
                            int i23 = this.f43418l;
                            fArr4[i17] = i23;
                            this.f43422p[i17] = i23 - (this.f43419m / 2.0f);
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } else if (this.f43421o != null && this.f43422p != null) {
                while (true) {
                    try {
                        float[] fArr5 = this.f43421o;
                        if (i18 >= fArr5.length) {
                            break;
                        }
                        int i24 = this.f43414h;
                        fArr5[i18] = i24;
                        this.f43422p[i18] = i24 - (this.f43419m / 2.0f);
                        i18++;
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
            }
            RectF rectF = this.f43424r;
            if (rectF != null) {
                int i25 = this.f43419m;
                rectF.set(i25 / 2.0f, i25 / 2.0f, this.f43412f - (i25 / 2.0f), this.f43413g - (i25 / 2.0f));
            }
            RectF rectF2 = this.f43423q;
            if (rectF2 != null) {
                rectF2.set(0.0f, 0.0f, this.f43412f, this.f43413g);
            }
        } catch (Exception e13) {
            ad.b("MBridgeImageView", e13.getMessage());
        }
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        String[] strArrSplit;
        HashMap<String, c> mapC = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            c cVar = mapC.get(attributeSet.getAttributeName(i11));
            if (cVar != null) {
                switch (AnonymousClass1.f43429a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i11);
                        if (attributeValue.startsWith("@+id/")) {
                            setId(attributeValue.substring(5).hashCode());
                        }
                        break;
                    case 2:
                        b.a().a(attributeSet.getAttributeValue(i11), this);
                        break;
                    case 3:
                        String attributeValue2 = attributeSet.getAttributeValue(i11);
                        if (attributeValue2.startsWith(Utils.SEPARATOR)) {
                            try {
                                strArrSplit = attributeValue2.split("-");
                            } catch (Exception unused) {
                                strArrSplit = null;
                            }
                            if (strArrSplit != null && strArrSplit.length <= 2) {
                                setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i11)));
                            } else if (strArrSplit == null || strArrSplit.length != 3) {
                                setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i11)));
                            } else {
                                try {
                                    GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArrSplit[2]), new int[]{Color.parseColor(strArrSplit[0]), Color.parseColor(strArrSplit[1])});
                                    gradientDrawable.setGradientType(0);
                                    setBackground(gradientDrawable);
                                } catch (Exception unused2) {
                                    setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i11)));
                                }
                            }
                        } else {
                            if (attributeValue2.startsWith("@drawable/")) {
                                attributeValue2 = attributeValue2.substring(10);
                            }
                            setBackgroundResource(getResources().getIdentifier(attributeValue2, "drawable", getContext().getPackageName()));
                        }
                        break;
                    case 4:
                        String attributeValue3 = attributeSet.getAttributeValue(i11);
                        if (!TextUtils.isEmpty(attributeValue3)) {
                            CharSequence charSequence = (String) com.mbridge.msdk.dycreator.e.b.f43673a.get(attributeValue3.substring(8));
                            if (!TextUtils.isEmpty(charSequence)) {
                                setContentDescription(charSequence);
                            }
                        }
                        break;
                    case 5:
                        String attributeValue4 = attributeSet.getAttributeValue(i11);
                        if (!TextUtils.isEmpty(attributeValue4)) {
                            String str = com.mbridge.msdk.dycreator.e.b.f43673a.get(attributeValue4.substring(8));
                            if (!TextUtils.isEmpty(str)) {
                                setTag(str);
                            }
                        }
                        break;
                    case 6:
                        String attributeValue5 = attributeSet.getAttributeValue(i11);
                        if (!TextUtils.isEmpty(attributeValue5)) {
                            if (attributeValue5.equals("invisible")) {
                                setVisibility(4);
                            } else if (attributeValue5.equalsIgnoreCase("gone")) {
                                setVisibility(8);
                            }
                        }
                        break;
                    case 7:
                        String attributeValue6 = attributeSet.getAttributeValue(i11);
                        if (!TextUtils.isEmpty(attributeValue6)) {
                            if (attributeValue6.equals("fitXY")) {
                                setScaleType(ImageView.ScaleType.FIT_XY);
                            } else if (attributeValue6.equals("centerInside")) {
                                setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            } else if (attributeValue6.equals("centerCrop")) {
                                setScaleType(ImageView.ScaleType.CENTER_CROP);
                            }
                        }
                        break;
                    case 8:
                        int iB = b.a().b(attributeSet.getAttributeValue(i11));
                        this.f43410d = iB;
                        this.f43409c = iB;
                        this.f43408b = iB;
                        this.f43407a = iB;
                        setPadding(iB, iB, iB, iB);
                        break;
                    case 9:
                        int iB2 = b.a().b(attributeSet.getAttributeValue(i11));
                        this.f43408b = iB2;
                        setPadding(this.f43407a, iB2, this.f43409c, this.f43410d);
                        break;
                    case 10:
                        int iB3 = b.a().b(attributeSet.getAttributeValue(i11));
                        this.f43410d = iB3;
                        setPadding(this.f43407a, this.f43408b, this.f43409c, iB3);
                        break;
                    case 11:
                        int iB4 = b.a().b(attributeSet.getAttributeValue(i11));
                        this.f43407a = iB4;
                        setPadding(iB4, this.f43408b, this.f43409c, this.f43410d);
                        break;
                    case 12:
                        int iB5 = b.a().b(attributeSet.getAttributeValue(i11));
                        this.f43409c = iB5;
                        setPadding(this.f43407a, this.f43408b, iB5, this.f43410d);
                        break;
                }
            }
        }
    }

    public void setBorder(int i11, int i12, int i13) {
        this.f43425s = true;
        this.f43419m = i12;
        this.f43420n = i13;
        this.f43414h = i11;
    }

    public void setCornerRadius(int i11) {
        this.f43414h = i11;
    }

    public void setCustomBorder(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f43425s = true;
        this.f43426t = true;
        this.f43419m = i15;
        this.f43420n = i16;
        this.f43415i = i11;
        this.f43417k = i13;
        this.f43416j = i12;
        this.f43418l = i14;
    }
}
