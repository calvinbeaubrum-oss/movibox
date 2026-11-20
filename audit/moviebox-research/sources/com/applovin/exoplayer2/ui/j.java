package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.applovin.exoplayer2.common.base.Charsets;
import com.applovin.impl.b1;
import com.applovin.impl.b5;
import com.applovin.impl.x2;
import com.applovin.impl.xp;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class j extends FrameLayout implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.exoplayer2.ui.a f17389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebView f17390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f17391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private x2 f17392d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f17393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f17395h;

    /* JADX INFO: compiled from: source.java */
    public class a extends WebView {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17397a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f17397a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17397a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17397a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17391c = Collections.emptyList();
        this.f17392d = x2.f24204g;
        this.f17393f = 0.0533f;
        this.f17394g = 0;
        this.f17395h = 0.08f;
        com.applovin.exoplayer2.ui.a aVar = new com.applovin.exoplayer2.ui.a(context, attributeSet);
        this.f17389a = aVar;
        a aVar2 = new a(context, attributeSet);
        this.f17390b = aVar2;
        aVar2.setBackgroundColor(0);
        addView(aVar);
        addView(aVar2);
    }

    private static int a(int i11) {
        if (i11 != 1) {
            return i11 != 2 ? 0 : -100;
        }
        return -50;
    }

    private String a(int i11, float f11) {
        float fA = h.a(i11, f11, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fA == -3.4028235E38f ? "unset" : xp.a("%.2fpx", Float.valueOf(fA / getContext().getResources().getDisplayMetrics().density));
    }

    private static String a(Layout.Alignment alignment) {
        if (alignment == null) {
            return TtmlNode.CENTER;
        }
        int i11 = b.f17397a[alignment.ordinal()];
        if (i11 != 1) {
            return i11 != 2 ? TtmlNode.CENTER : TtmlNode.END;
        }
        return "start";
    }

    private static String a(b5 b5Var) {
        float f11 = b5Var.f17848r;
        if (f11 == 0.0f) {
            return "";
        }
        int i11 = b5Var.f17847q;
        return xp.a("%s(%.2fdeg)", (i11 == 2 || i11 == 1) ? "skewY" : "skewX", Float.valueOf(f11));
    }

    private static String a(x2 x2Var) {
        int i11 = x2Var.f24208d;
        if (i11 == 1) {
            return xp.a("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", c.a(x2Var.f24209e));
        }
        if (i11 == 2) {
            return xp.a("0.1em 0.12em 0.15em %s", c.a(x2Var.f24209e));
        }
        if (i11 != 3) {
            return i11 != 4 ? "unset" : xp.a("-0.05em -0.05em 0.15em %s", c.a(x2Var.f24209e));
        }
        return xp.a("0.06em 0.08em 0.15em %s", c.a(x2Var.f24209e));
    }

    private static String b(int i11) {
        if (i11 != 1) {
            return i11 != 2 ? "horizontal-tb" : "vertical-lr";
        }
        return "vertical-rl";
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:26:0x010b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0125  */
    /* JADX WARN: Code duplicated, block: B:30:0x0128  */
    /* JADX WARN: Code duplicated, block: B:33:0x013f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0142 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0144  */
    /* JADX WARN: Code duplicated, block: B:38:0x0148 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x014b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0153 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0161  */
    /* JADX WARN: Code duplicated, block: B:53:0x0189  */
    /* JADX WARN: Code duplicated, block: B:59:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x0227  */
    /* JADX WARN: Code duplicated, block: B:64:0x0243  */
    private void b() {
        String strA;
        int iA;
        boolean z11;
        float f11;
        String strA2;
        int i11;
        int i12;
        int i13;
        String str;
        String str2;
        int i14;
        String str3;
        String str4;
        int i15;
        f.b bVarA;
        Iterator it;
        f.b bVar;
        Layout.Alignment alignment;
        String str5;
        boolean z12;
        j jVar = this;
        StringBuilder sb2 = new StringBuilder();
        float f12 = 1.2f;
        char c11 = 0;
        int i16 = 1;
        sb2.append(xp.a("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", c.a(jVar.f17392d.f24205a), jVar.a(jVar.f17394g, jVar.f17393f), Float.valueOf(1.2f), a(jVar.f17392d)));
        HashMap map = new HashMap();
        map.put(c.a("default_bg"), xp.a("background-color:%s;", c.a(jVar.f17392d.f24206b)));
        int i17 = 0;
        while (i17 < jVar.f17391c.size()) {
            b5 b5Var = (b5) jVar.f17391c.get(i17);
            float f13 = b5Var.f17839i;
            float f14 = f13 != -3.4028235E38f ? f13 * 100.0f : 50.0f;
            int iA2 = a(b5Var.f17840j);
            float f15 = b5Var.f17836f;
            if (f15 == -3.4028235E38f) {
                Object[] objArr = new Object[i16];
                objArr[c11] = Float.valueOf((1.0f - jVar.f17395h) * 100.0f);
                strA = xp.a("%.2f%%", objArr);
                iA = -100;
            } else if (b5Var.f17837g != i16) {
                Float fValueOf = Float.valueOf(f15 * 100.0f);
                Object[] objArr2 = new Object[i16];
                objArr2[c11] = fValueOf;
                strA = xp.a("%.2f%%", objArr2);
                iA = b5Var.f17847q == i16 ? -a(b5Var.f17838h) : a(b5Var.f17838h);
            } else {
                if (f15 >= 0.0f) {
                    Float fValueOf2 = Float.valueOf(f15 * f12);
                    Object[] objArr3 = new Object[i16];
                    objArr3[c11] = fValueOf2;
                    strA = xp.a("%.2fem", objArr3);
                    iA = 0;
                } else {
                    Float fValueOf3 = Float.valueOf(((-f15) - 1.0f) * f12);
                    Object[] objArr4 = new Object[i16];
                    objArr4[c11] = fValueOf3;
                    strA = xp.a("%.2fem", objArr4);
                    iA = 0;
                    z11 = true;
                }
                f11 = b5Var.f17841k;
                if (f11 != -3.4028235E38f) {
                    Object[] objArr5 = new Object[i16];
                    objArr5[c11] = Float.valueOf(f11 * 100.0f);
                    strA2 = xp.a("%.2f%%", objArr5);
                } else {
                    strA2 = "fit-content";
                }
                String strA3 = a(b5Var.f17833b);
                String strB = b(b5Var.f17847q);
                String strA4 = jVar.a(b5Var.f17845o, b5Var.f17846p);
                if (b5Var.f17843m) {
                    i11 = b5Var.f17844n;
                } else {
                    i11 = jVar.f17392d.f24207c;
                }
                String strA5 = c.a(i11);
                i12 = iA;
                i13 = b5Var.f17847q;
                str = TtmlNode.RIGHT;
                str2 = TtmlNode.LEFT;
                if (i13 != 1) {
                    if (z11) {
                        str = TtmlNode.LEFT;
                    }
                    str2 = "top";
                    i14 = 2;
                    str3 = str;
                } else if (i13 != 2) {
                    str3 = z11 ? "bottom" : "top";
                    i14 = 2;
                } else {
                    if (!z11) {
                        str = TtmlNode.LEFT;
                    }
                    str2 = "top";
                    i14 = 2;
                    str3 = str;
                }
                if (i13 != i14 || i13 == 1) {
                    str4 = "height";
                    i15 = i12;
                    i12 = iA2;
                } else {
                    str4 = "width";
                    i15 = iA2;
                }
                bVarA = f.a(b5Var.f17832a, getContext().getResources().getDisplayMetrics().density);
                it = map.keySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = it;
                    String str6 = (String) it.next();
                    f.b bVar2 = bVarA;
                    str5 = (String) map.put(str6, (String) map.get(str6));
                    if (str5 != null || str5.equals(map.get(str6))) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    b1.b(z12);
                    it = it2;
                    bVarA = bVar2;
                }
                bVar = bVarA;
                HashMap map2 = map;
                sb2.append(xp.a("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i17), str2, Float.valueOf(f14), str3, strA, str4, strA2, strA3, strB, strA4, strA5, Integer.valueOf(i15), Integer.valueOf(i12), a(b5Var)));
                sb2.append(xp.a("<span class='%s'>", "default_bg"));
                alignment = b5Var.f17834c;
                if (alignment != null) {
                    sb2.append(xp.a("<span style='display:inline-block; text-align:%s;'>", a(alignment)));
                    sb2.append(bVar.f17353a);
                    sb2.append("</span>");
                } else {
                    sb2.append(bVar.f17353a);
                }
                sb2.append("</span>");
                sb2.append("</div>");
                i17++;
                jVar = this;
                map = map2;
                i16 = 1;
                f12 = 1.2f;
                c11 = 0;
            }
            z11 = false;
            f11 = b5Var.f17841k;
            if (f11 != -3.4028235E38f) {
                Object[] objArr6 = new Object[i16];
                objArr6[c11] = Float.valueOf(f11 * 100.0f);
                strA2 = xp.a("%.2f%%", objArr6);
            } else {
                strA2 = "fit-content";
            }
            String strA6 = a(b5Var.f17833b);
            String strB2 = b(b5Var.f17847q);
            String strA7 = jVar.a(b5Var.f17845o, b5Var.f17846p);
            if (b5Var.f17843m) {
                i11 = b5Var.f17844n;
            } else {
                i11 = jVar.f17392d.f24207c;
            }
            String strA8 = c.a(i11);
            i12 = iA;
            i13 = b5Var.f17847q;
            str = TtmlNode.RIGHT;
            str2 = TtmlNode.LEFT;
            if (i13 != 1) {
                if (z11) {
                    str = TtmlNode.LEFT;
                }
                str2 = "top";
                i14 = 2;
                str3 = str;
            } else if (i13 != 2) {
                if (z11) {
                }
                i14 = 2;
            } else {
                if (!z11) {
                    str = TtmlNode.LEFT;
                }
                str2 = "top";
                i14 = 2;
                str3 = str;
            }
            if (i13 != i14) {
                str4 = "height";
                i15 = i12;
                i12 = iA2;
            } else {
                str4 = "height";
                i15 = i12;
                i12 = iA2;
            }
            bVarA = f.a(b5Var.f17832a, getContext().getResources().getDisplayMetrics().density);
            it = map.keySet().iterator();
            while (it.hasNext()) {
                Iterator it3 = it;
                String str7 = (String) it.next();
                f.b bVar3 = bVarA;
                str5 = (String) map.put(str7, (String) map.get(str7));
                if (str5 != null) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                b1.b(z12);
                it = it3;
                bVarA = bVar3;
            }
            bVar = bVarA;
            HashMap map3 = map;
            sb2.append(xp.a("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i17), str2, Float.valueOf(f14), str3, strA, str4, strA2, strA6, strB2, strA7, strA8, Integer.valueOf(i15), Integer.valueOf(i12), a(b5Var)));
            sb2.append(xp.a("<span class='%s'>", "default_bg"));
            alignment = b5Var.f17834c;
            if (alignment != null) {
                sb2.append(xp.a("<span style='display:inline-block; text-align:%s;'>", a(alignment)));
                sb2.append(bVar.f17353a);
                sb2.append("</span>");
            } else {
                sb2.append(bVar.f17353a);
            }
            sb2.append("</span>");
            sb2.append("</div>");
            i17++;
            jVar = this;
            map = map3;
            i16 = 1;
            f12 = 1.2f;
            c11 = 0;
        }
        Map map4 = map;
        sb2.append("</div></body></html>");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("<html><head><style>");
        for (String str8 : map4.keySet()) {
            sb3.append(str8);
            sb3.append("{");
            sb3.append((String) map4.get(str8));
            sb3.append("}");
        }
        sb3.append("</style></head>");
        sb2.insert(0, sb3.toString());
        this.f17390b.loadData(Base64.encodeToString(sb2.toString().getBytes(Charsets.UTF_8), 1), "text/html", "base64");
    }

    public void a() {
        this.f17390b.destroy();
    }

    @Override // com.applovin.exoplayer2.ui.SubtitleView.a
    public void a(List list, x2 x2Var, float f11, int i11, float f12) {
        this.f17392d = x2Var;
        this.f17393f = f11;
        this.f17394g = i11;
        this.f17395h = f12;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            b5 b5Var = (b5) list.get(i12);
            if (b5Var.f17835d != null) {
                arrayList.add(b5Var);
            } else {
                arrayList2.add(b5Var);
            }
        }
        if (!this.f17391c.isEmpty() || !arrayList2.isEmpty()) {
            this.f17391c = arrayList2;
            b();
        }
        this.f17389a.a(arrayList, x2Var, f11, i11, f12);
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (!z11 || this.f17391c.isEmpty()) {
            return;
        }
        b();
    }
}
