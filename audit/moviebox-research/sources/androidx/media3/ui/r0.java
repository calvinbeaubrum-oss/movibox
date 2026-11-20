package androidx.media3.ui;

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
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends FrameLayout implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.ui.a f12115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebView f12116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<y3.a> f12117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.media3.ui.b f12118d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f12119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12121h;

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
        public static final /* synthetic */ int[] f12123a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f12123a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12123a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12123a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public r0(Context context) {
        this(context, null);
    }

    public r0(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12117c = Collections.emptyList();
        this.f12118d = androidx.media3.ui.b.f12011g;
        this.f12119f = 0.0533f;
        this.f12120g = 0;
        this.f12121h = 0.08f;
        androidx.media3.ui.a aVar = new androidx.media3.ui.a(context, attributeSet);
        this.f12115a = aVar;
        a aVar2 = new a(context, attributeSet);
        this.f12116b = aVar2;
        aVar2.setBackgroundColor(0);
        addView(aVar);
        addView(aVar2);
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
        int i11 = b.f12123a[alignment.ordinal()];
        if (i11 != 1) {
            return i11 != 2 ? TtmlNode.CENTER : TtmlNode.END;
        }
        return "start";
    }

    public static String d(androidx.media3.ui.b bVar) {
        int i11 = bVar.f12015d;
        if (i11 == 1) {
            return u0.G("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", h.b(bVar.f12016e));
        }
        if (i11 == 2) {
            return u0.G("0.1em 0.12em 0.15em %s", h.b(bVar.f12016e));
        }
        if (i11 != 3) {
            return i11 != 4 ? "unset" : u0.G("-0.05em -0.05em 0.15em %s", h.b(bVar.f12016e));
        }
        return u0.G("0.06em 0.08em 0.15em %s", h.b(bVar.f12016e));
    }

    public static String f(int i11) {
        if (i11 != 1) {
            return i11 != 2 ? "horizontal-tb" : "vertical-lr";
        }
        return "vertical-rl";
    }

    public static String h(y3.a aVar) {
        float f11 = aVar.f81125q;
        if (f11 == 0.0f) {
            return "";
        }
        int i11 = aVar.f81124p;
        return u0.G("%s(%.2fdeg)", (i11 == 2 || i11 == 1) ? "skewY" : "skewX", Float.valueOf(f11));
    }

    @Override // androidx.media3.ui.SubtitleView.a
    public void a(List<y3.a> list, androidx.media3.ui.b bVar, float f11, int i11, float f12) {
        this.f12118d = bVar;
        this.f12119f = f11;
        this.f12120g = i11;
        this.f12121h = f12;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            y3.a aVar = list.get(i12);
            if (aVar.f81112d != null) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        if (!this.f12117c.isEmpty() || !arrayList2.isEmpty()) {
            this.f12117c = arrayList2;
            i();
        }
        this.f12115a.a(arrayList, bVar, f11, i11, f12);
        invalidate();
    }

    public final String e(int i11, float f11) {
        float fH = n0.h(i11, f11, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fH == -3.4028235E38f ? "unset" : u0.G("%.2fpx", Float.valueOf(fH / getContext().getResources().getDisplayMetrics().density));
    }

    public void g() {
        this.f12116b.destroy();
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
        String strG;
        int iB;
        boolean z11;
        float f11;
        String strG2;
        int i11;
        int i12;
        int i13;
        String str;
        String str2;
        int i14;
        String str3;
        String str4;
        int i15;
        h0.b bVarA;
        Iterator it;
        h0.b bVar;
        Layout.Alignment alignment;
        String str5;
        boolean z12;
        r0 r0Var = this;
        StringBuilder sb2 = new StringBuilder();
        char c11 = 0;
        int i16 = 1;
        float f12 = 1.2f;
        sb2.append(u0.G("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", h.b(r0Var.f12118d.f12012a), r0Var.e(r0Var.f12120g, r0Var.f12119f), Float.valueOf(1.2f), d(r0Var.f12118d)));
        HashMap map = new HashMap();
        map.put(h.a("default_bg"), u0.G("background-color:%s;", h.b(r0Var.f12118d.f12013b)));
        int i17 = 0;
        while (i17 < r0Var.f12117c.size()) {
            y3.a aVar = r0Var.f12117c.get(i17);
            float f13 = aVar.f81116h;
            float f14 = f13 != -3.4028235E38f ? f13 * 100.0f : 50.0f;
            int iB2 = b(aVar.f81117i);
            float f15 = aVar.f81113e;
            if (f15 == -3.4028235E38f) {
                Object[] objArr = new Object[i16];
                objArr[c11] = Float.valueOf((1.0f - r0Var.f12121h) * 100.0f);
                strG = u0.G("%.2f%%", objArr);
                iB = -100;
            } else if (aVar.f81114f != i16) {
                Object[] objArr2 = new Object[i16];
                objArr2[c11] = Float.valueOf(f15 * 100.0f);
                strG = u0.G("%.2f%%", objArr2);
                iB = aVar.f81124p == i16 ? -b(aVar.f81115g) : b(aVar.f81115g);
            } else {
                if (f15 >= 0.0f) {
                    Object[] objArr3 = new Object[i16];
                    objArr3[c11] = Float.valueOf(f15 * f12);
                    strG = u0.G("%.2fem", objArr3);
                    iB = 0;
                } else {
                    Object[] objArr4 = new Object[i16];
                    objArr4[c11] = Float.valueOf(((-f15) - 1.0f) * f12);
                    strG = u0.G("%.2fem", objArr4);
                    iB = 0;
                    z11 = true;
                }
                f11 = aVar.f81118j;
                if (f11 != -3.4028235E38f) {
                    Object[] objArr5 = new Object[i16];
                    objArr5[0] = Float.valueOf(f11 * 100.0f);
                    strG2 = u0.G("%.2f%%", objArr5);
                } else {
                    strG2 = "fit-content";
                }
                String strC = c(aVar.f81110b);
                String strF = f(aVar.f81124p);
                String strE = r0Var.e(aVar.f81122n, aVar.f81123o);
                if (aVar.f81120l) {
                    i11 = aVar.f81121m;
                } else {
                    i11 = r0Var.f12118d.f12014c;
                }
                String strB = h.b(i11);
                i12 = iB;
                i13 = aVar.f81124p;
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
                bVarA = h0.a(aVar.f81109a, getContext().getResources().getDisplayMetrics().density);
                it = map.keySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = it;
                    String str6 = (String) it.next();
                    h0.b bVar2 = bVarA;
                    str5 = (String) map.put(str6, (String) map.get(str6));
                    if (str5 != null || str5.equals(map.get(str6))) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z3.a.g(z12);
                    it = it2;
                    bVarA = bVar2;
                }
                bVar = bVarA;
                sb2.append(u0.G("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i17), str2, Float.valueOf(f14), str3, strG, str4, strG2, strC, strF, strE, strB, Integer.valueOf(i15), Integer.valueOf(i12), h(aVar)));
                sb2.append(u0.G("<span class='%s'>", "default_bg"));
                alignment = aVar.f81111c;
                if (alignment != null) {
                    sb2.append(u0.G("<span style='display:inline-block; text-align:%s;'>", c(alignment)));
                    sb2.append(bVar.f12064a);
                    sb2.append("</span>");
                } else {
                    sb2.append(bVar.f12064a);
                }
                sb2.append("</span>");
                sb2.append("</div>");
                i17++;
                f12 = 1.2f;
                c11 = 0;
                r0Var = this;
                i16 = 1;
            }
            z11 = false;
            f11 = aVar.f81118j;
            if (f11 != -3.4028235E38f) {
                Object[] objArr6 = new Object[i16];
                objArr6[0] = Float.valueOf(f11 * 100.0f);
                strG2 = u0.G("%.2f%%", objArr6);
            } else {
                strG2 = "fit-content";
            }
            String strC2 = c(aVar.f81110b);
            String strF2 = f(aVar.f81124p);
            String strE2 = r0Var.e(aVar.f81122n, aVar.f81123o);
            if (aVar.f81120l) {
                i11 = aVar.f81121m;
            } else {
                i11 = r0Var.f12118d.f12014c;
            }
            String strB2 = h.b(i11);
            i12 = iB;
            i13 = aVar.f81124p;
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
            bVarA = h0.a(aVar.f81109a, getContext().getResources().getDisplayMetrics().density);
            it = map.keySet().iterator();
            while (it.hasNext()) {
                Iterator it3 = it;
                String str7 = (String) it.next();
                h0.b bVar3 = bVarA;
                str5 = (String) map.put(str7, (String) map.get(str7));
                if (str5 != null) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                z3.a.g(z12);
                it = it3;
                bVarA = bVar3;
            }
            bVar = bVarA;
            sb2.append(u0.G("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i17), str2, Float.valueOf(f14), str3, strG, str4, strG2, strC2, strF2, strE2, strB2, Integer.valueOf(i15), Integer.valueOf(i12), h(aVar)));
            sb2.append(u0.G("<span class='%s'>", "default_bg"));
            alignment = aVar.f81111c;
            if (alignment != null) {
                sb2.append(u0.G("<span style='display:inline-block; text-align:%s;'>", c(alignment)));
                sb2.append(bVar.f12064a);
                sb2.append("</span>");
            } else {
                sb2.append(bVar.f12064a);
            }
            sb2.append("</span>");
            sb2.append("</div>");
            i17++;
            f12 = 1.2f;
            c11 = 0;
            r0Var = this;
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
        this.f12116b.loadData(Base64.encodeToString(sb2.toString().getBytes(com.google.common.base.c.f38165c), 1), "text/html", "base64");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (!z11 || this.f12117c.isEmpty()) {
            return;
        }
        i();
    }
}
