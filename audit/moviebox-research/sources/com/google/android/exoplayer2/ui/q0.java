package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class q0 extends FrameLayout implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.ui.b f35192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebView f35193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<vh.b> f35194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f35195d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f35196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f35197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f35198h;

    /* JADX INFO: compiled from: source.java */
    public class a extends WebView {
        public a(q0 q0Var, Context context, AttributeSet attributeSet) {
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
        public static final /* synthetic */ int[] f35199a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f35199a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35199a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35199a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public q0(Context context) {
        this(context, null);
    }

    public q0(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35194c = Collections.emptyList();
        this.f35195d = c.f35094g;
        this.f35196f = 0.0533f;
        this.f35197g = 0;
        this.f35198h = 0.08f;
        com.google.android.exoplayer2.ui.b bVar = new com.google.android.exoplayer2.ui.b(context, attributeSet);
        this.f35192a = bVar;
        a aVar = new a(this, context, attributeSet);
        this.f35193b = aVar;
        aVar.setBackgroundColor(0);
        addView(bVar);
        addView(aVar);
    }

    public static int b(int i11) {
        if (i11 != 1) {
            return i11 != 2 ? 0 : -100;
        }
        return -50;
    }

    public static String c(@Nullable Layout.Alignment alignment) {
        if (alignment == null) {
            return TtmlNode.CENTER;
        }
        int i11 = b.f35199a[alignment.ordinal()];
        if (i11 != 1) {
            return i11 != 2 ? TtmlNode.CENTER : TtmlNode.END;
        }
        return "start";
    }

    public static String d(c cVar) {
        int i11 = cVar.f35098d;
        if (i11 == 1) {
            return com.google.android.exoplayer2.util.o0.C("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", h.b(cVar.f35099e));
        }
        if (i11 == 2) {
            return com.google.android.exoplayer2.util.o0.C("0.1em 0.12em 0.15em %s", h.b(cVar.f35099e));
        }
        if (i11 != 3) {
            return i11 != 4 ? "unset" : com.google.android.exoplayer2.util.o0.C("-0.05em -0.05em 0.15em %s", h.b(cVar.f35099e));
        }
        return com.google.android.exoplayer2.util.o0.C("0.06em 0.08em 0.15em %s", h.b(cVar.f35099e));
    }

    public static String f(int i11) {
        if (i11 != 1) {
            return i11 != 2 ? "horizontal-tb" : "vertical-lr";
        }
        return "vertical-rl";
    }

    public static String h(vh.b bVar) {
        float f11 = bVar.f78834r;
        if (f11 == 0.0f) {
            return "";
        }
        int i11 = bVar.f78833q;
        return com.google.android.exoplayer2.util.o0.C("%s(%.2fdeg)", (i11 == 2 || i11 == 1) ? "skewY" : "skewX", Float.valueOf(f11));
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<vh.b> list, c cVar, float f11, int i11, float f12) {
        this.f35195d = cVar;
        this.f35196f = f11;
        this.f35197g = i11;
        this.f35198h = f12;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            vh.b bVar = list.get(i12);
            if (bVar.f78821d != null) {
                arrayList.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        if (!this.f35194c.isEmpty() || !arrayList2.isEmpty()) {
            this.f35194c = arrayList2;
            i();
        }
        this.f35192a.a(arrayList, cVar, f11, i11, f12);
        invalidate();
    }

    public final String e(int i11, float f11) {
        float fH = m0.h(i11, f11, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fH == -3.4028235E38f ? "unset" : com.google.android.exoplayer2.util.o0.C("%.2fpx", Float.valueOf(fH / getContext().getResources().getDisplayMetrics().density));
    }

    public void g() {
        this.f35193b.destroy();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:26:0x010c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0126  */
    /* JADX WARN: Code duplicated, block: B:30:0x0129  */
    /* JADX WARN: Code duplicated, block: B:33:0x0140  */
    /* JADX WARN: Code duplicated, block: B:35:0x0143 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0145  */
    /* JADX WARN: Code duplicated, block: B:38:0x0149 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x014c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0154 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0162  */
    /* JADX WARN: Code duplicated, block: B:53:0x018a  */
    /* JADX WARN: Code duplicated, block: B:59:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:63:0x0226  */
    /* JADX WARN: Code duplicated, block: B:64:0x0242  */
    public final void i() {
        String strC;
        int iB;
        boolean z11;
        float f11;
        String strC2;
        int i11;
        int i12;
        int i13;
        String str;
        String str2;
        int i14;
        String str3;
        String str4;
        int i15;
        k.b bVarA;
        Iterator it;
        k.b bVar;
        Layout.Alignment alignment;
        String str5;
        boolean z12;
        q0 q0Var = this;
        StringBuilder sb2 = new StringBuilder();
        char c11 = 0;
        int i16 = 1;
        float f12 = 1.2f;
        sb2.append(com.google.android.exoplayer2.util.o0.C("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", h.b(q0Var.f35195d.f35095a), q0Var.e(q0Var.f35197g, q0Var.f35196f), Float.valueOf(1.2f), d(q0Var.f35195d)));
        HashMap map = new HashMap();
        map.put(h.a("default_bg"), com.google.android.exoplayer2.util.o0.C("background-color:%s;", h.b(q0Var.f35195d.f35096b)));
        int i17 = 0;
        while (i17 < q0Var.f35194c.size()) {
            vh.b bVar2 = q0Var.f35194c.get(i17);
            float f13 = bVar2.f78825i;
            float f14 = f13 != -3.4028235E38f ? f13 * 100.0f : 50.0f;
            int iB2 = b(bVar2.f78826j);
            float f15 = bVar2.f78822f;
            if (f15 == -3.4028235E38f) {
                Object[] objArr = new Object[i16];
                objArr[c11] = Float.valueOf((1.0f - q0Var.f35198h) * 100.0f);
                strC = com.google.android.exoplayer2.util.o0.C("%.2f%%", objArr);
                iB = -100;
            } else if (bVar2.f78823g != i16) {
                Object[] objArr2 = new Object[i16];
                objArr2[c11] = Float.valueOf(f15 * 100.0f);
                strC = com.google.android.exoplayer2.util.o0.C("%.2f%%", objArr2);
                iB = bVar2.f78833q == i16 ? -b(bVar2.f78824h) : b(bVar2.f78824h);
            } else {
                if (f15 >= 0.0f) {
                    Object[] objArr3 = new Object[i16];
                    objArr3[c11] = Float.valueOf(f15 * f12);
                    strC = com.google.android.exoplayer2.util.o0.C("%.2fem", objArr3);
                    iB = 0;
                } else {
                    Object[] objArr4 = new Object[i16];
                    objArr4[c11] = Float.valueOf(((-f15) - 1.0f) * f12);
                    strC = com.google.android.exoplayer2.util.o0.C("%.2fem", objArr4);
                    iB = 0;
                    z11 = true;
                }
                f11 = bVar2.f78827k;
                if (f11 != -3.4028235E38f) {
                    Object[] objArr5 = new Object[i16];
                    objArr5[0] = Float.valueOf(f11 * 100.0f);
                    strC2 = com.google.android.exoplayer2.util.o0.C("%.2f%%", objArr5);
                } else {
                    strC2 = "fit-content";
                }
                String strC3 = c(bVar2.f78819b);
                String strF = f(bVar2.f78833q);
                String strE = q0Var.e(bVar2.f78831o, bVar2.f78832p);
                if (bVar2.f78829m) {
                    i11 = bVar2.f78830n;
                } else {
                    i11 = q0Var.f35195d.f35097c;
                }
                String strB = h.b(i11);
                i12 = iB;
                i13 = bVar2.f78833q;
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
                    i12 = iB2;
                } else {
                    str4 = "width";
                    i15 = iB2;
                }
                bVarA = k.a(bVar2.f78818a, getContext().getResources().getDisplayMetrics().density);
                it = map.keySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = it;
                    String str6 = (String) it.next();
                    k.b bVar3 = bVarA;
                    str5 = (String) map.put(str6, (String) map.get(str6));
                    if (str5 != null || str5.equals(map.get(str6))) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    com.google.android.exoplayer2.util.a.g(z12);
                    it = it2;
                    bVarA = bVar3;
                }
                bVar = bVarA;
                sb2.append(com.google.android.exoplayer2.util.o0.C("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i17), str2, Float.valueOf(f14), str3, strC, str4, strC2, strC3, strF, strE, strB, Integer.valueOf(i15), Integer.valueOf(i12), h(bVar2)));
                sb2.append(com.google.android.exoplayer2.util.o0.C("<span class='%s'>", "default_bg"));
                alignment = bVar2.f78820c;
                if (alignment != null) {
                    sb2.append(com.google.android.exoplayer2.util.o0.C("<span style='display:inline-block; text-align:%s;'>", c(alignment)));
                    sb2.append(bVar.f35177a);
                    sb2.append("</span>");
                } else {
                    sb2.append(bVar.f35177a);
                }
                sb2.append("</span>");
                sb2.append("</div>");
                i17++;
                f12 = 1.2f;
                c11 = 0;
                q0Var = this;
                i16 = 1;
            }
            z11 = false;
            f11 = bVar2.f78827k;
            if (f11 != -3.4028235E38f) {
                Object[] objArr6 = new Object[i16];
                objArr6[0] = Float.valueOf(f11 * 100.0f);
                strC2 = com.google.android.exoplayer2.util.o0.C("%.2f%%", objArr6);
            } else {
                strC2 = "fit-content";
            }
            String strC4 = c(bVar2.f78819b);
            String strF2 = f(bVar2.f78833q);
            String strE2 = q0Var.e(bVar2.f78831o, bVar2.f78832p);
            if (bVar2.f78829m) {
                i11 = bVar2.f78830n;
            } else {
                i11 = q0Var.f35195d.f35097c;
            }
            String strB2 = h.b(i11);
            i12 = iB;
            i13 = bVar2.f78833q;
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
                i12 = iB2;
            } else {
                str4 = "height";
                i15 = i12;
                i12 = iB2;
            }
            bVarA = k.a(bVar2.f78818a, getContext().getResources().getDisplayMetrics().density);
            it = map.keySet().iterator();
            while (it.hasNext()) {
                Iterator it3 = it;
                String str7 = (String) it.next();
                k.b bVar4 = bVarA;
                str5 = (String) map.put(str7, (String) map.get(str7));
                if (str5 != null) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                com.google.android.exoplayer2.util.a.g(z12);
                it = it3;
                bVarA = bVar4;
            }
            bVar = bVarA;
            sb2.append(com.google.android.exoplayer2.util.o0.C("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i17), str2, Float.valueOf(f14), str3, strC, str4, strC2, strC4, strF2, strE2, strB2, Integer.valueOf(i15), Integer.valueOf(i12), h(bVar2)));
            sb2.append(com.google.android.exoplayer2.util.o0.C("<span class='%s'>", "default_bg"));
            alignment = bVar2.f78820c;
            if (alignment != null) {
                sb2.append(com.google.android.exoplayer2.util.o0.C("<span style='display:inline-block; text-align:%s;'>", c(alignment)));
                sb2.append(bVar.f35177a);
                sb2.append("</span>");
            } else {
                sb2.append(bVar.f35177a);
            }
            sb2.append("</span>");
            sb2.append("</div>");
            i17++;
            f12 = 1.2f;
            c11 = 0;
            q0Var = this;
            i16 = 1;
        }
        sb2.append("</div></body></html>");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("<html><head><style>");
        for (String str8 : map.keySet()) {
            sb3.append(str8);
            sb3.append("{");
            sb3.append((String) map.get(str8));
            sb3.append("}");
        }
        sb3.append("</style></head>");
        sb2.insert(0, sb3.toString());
        this.f35193b.loadData(Base64.encodeToString(sb2.toString().getBytes(com.google.common.base.c.f38165c), 1), "text/html", "base64");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (!z11 || this.f35194c.isEmpty()) {
            return;
        }
        i();
    }
}
