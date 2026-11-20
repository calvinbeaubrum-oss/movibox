package com.applovin.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.applovin.impl.b1;
import com.applovin.impl.gb;
import com.applovin.impl.pa;
import com.applovin.impl.xp;
import com.applovin.impl.yn;
import com.applovin.impl.zi;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f17352a = Pattern.compile("(&#13;)?&#10;");

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f17354b;

        private b(String str, Map map) {
            this.f17353a = str;
            this.f17354b = map;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Comparator f17355e = new Comparator() { // from class: com.applovin.exoplayer2.ui.p
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return f.c.a((f.c) obj, (f.c) obj2);
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Comparator f17356f = new Comparator() { // from class: com.applovin.exoplayer2.ui.q
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return f.c.b((f.c) obj, (f.c) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f17359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f17360d;

        private c(int i11, int i12, String str, String str2) {
            this.f17357a = i11;
            this.f17358b = i12;
            this.f17359c = str;
            this.f17360d = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int a(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.f17358b, cVar.f17358b);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar.f17359c.compareTo(cVar2.f17359c);
            return iCompareTo != 0 ? iCompareTo : cVar.f17360d.compareTo(cVar2.f17360d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int b(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.f17357a, cVar.f17357a);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar2.f17359c.compareTo(cVar.f17359c);
            return iCompareTo != 0 ? iCompareTo : cVar2.f17360d.compareTo(cVar.f17360d);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f17361a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f17362b = new ArrayList();
    }

    private static SparseArray a(Spanned spanned, float f11) {
        SparseArray sparseArray = new SparseArray();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String strA = a(obj, f11);
            String strA2 = a(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (strA != null) {
                b1.a((Object) strA2);
                c cVar = new c(spanStart, spanEnd, strA, strA2);
                a(sparseArray, spanStart).f17361a.add(cVar);
                a(sparseArray, spanEnd).f17362b.add(cVar);
            }
        }
        return sparseArray;
    }

    public static b a(CharSequence charSequence, float f11) {
        if (charSequence == null) {
            return new b("", gb.h());
        }
        if (!(charSequence instanceof Spanned)) {
            return new b(a(charSequence), gb.h());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet hashSet = new HashSet();
        int i11 = 0;
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap map = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            map.put(com.applovin.exoplayer2.ui.c.a("bg_" + iIntValue), xp.a("background-color:%s;", com.applovin.exoplayer2.ui.c.a(iIntValue)));
        }
        SparseArray sparseArrayA = a(spanned, f11);
        StringBuilder sb2 = new StringBuilder(spanned.length());
        int i12 = 0;
        while (i11 < sparseArrayA.size()) {
            int iKeyAt = sparseArrayA.keyAt(i11);
            sb2.append(a(spanned.subSequence(i12, iKeyAt)));
            d dVar = (d) sparseArrayA.get(iKeyAt);
            Collections.sort(dVar.f17362b, c.f17356f);
            Iterator it2 = dVar.f17362b.iterator();
            while (it2.hasNext()) {
                sb2.append(((c) it2.next()).f17360d);
            }
            Collections.sort(dVar.f17361a, c.f17355e);
            Iterator it3 = dVar.f17361a.iterator();
            while (it3.hasNext()) {
                sb2.append(((c) it3.next()).f17359c);
            }
            i11++;
            i12 = iKeyAt;
        }
        sb2.append(a(spanned.subSequence(i12, spanned.length())));
        return new b(sb2.toString(), map);
    }

    private static d a(SparseArray sparseArray, int i11) {
        d dVar = (d) sparseArray.get(i11);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        sparseArray.put(i11, dVar2);
        return dVar2;
    }

    private static String a(int i11) {
        return i11 != 2 ? "over right" : "under left";
    }

    private static String a(int i11, int i12) {
        StringBuilder sb2 = new StringBuilder();
        if (i12 == 1) {
            sb2.append("filled ");
        } else if (i12 == 2) {
            sb2.append("open ");
        }
        if (i11 == 0) {
            sb2.append(DevicePublicKeyStringDef.NONE);
        } else if (i11 == 1) {
            sb2.append("circle");
        } else if (i11 == 2) {
            sb2.append("dot");
        } else if (i11 != 3) {
            sb2.append("unset");
        } else {
            sb2.append("sesame");
        }
        return sb2.toString();
    }

    private static String a(CharSequence charSequence) {
        return f17352a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    private static String a(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof pa) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof yn)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else {
            if (obj instanceof zi) {
                return "<rt>" + a((CharSequence) ((zi) obj).f24867a) + "</rt></ruby>";
            }
            if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    private static String a(Object obj, float f11) {
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return xp.a("<span style='color:%s;'>", com.applovin.exoplayer2.ui.c.a(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return xp.a("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof pa) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
            return xp.a("<span style='font-size:%.2fpx;'>", Float.valueOf(absoluteSizeSpan.getDip() ? absoluteSizeSpan.getSize() : absoluteSizeSpan.getSize() / f11));
        }
        if (obj instanceof RelativeSizeSpan) {
            return xp.a("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return xp.a("<span style='font-family:\"%s\";'>", family);
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (!(obj instanceof zi)) {
            if (obj instanceof UnderlineSpan) {
                return "<u>";
            }
            if (!(obj instanceof yn)) {
                return null;
            }
            yn ynVar = (yn) obj;
            return xp.a("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", a(ynVar.f24697a, ynVar.f24698b), a(ynVar.f24699c));
        }
        int i11 = ((zi) obj).f24868b;
        if (i11 == -1) {
            return "<ruby style='ruby-position:unset;'>";
        }
        if (i11 == 1) {
            return "<ruby style='ruby-position:over;'>";
        }
        if (i11 != 2) {
            return null;
        }
        return "<ruby style='ruby-position:under;'>";
    }
}
