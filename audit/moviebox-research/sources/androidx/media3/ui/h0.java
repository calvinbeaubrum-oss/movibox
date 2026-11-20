package androidx.media3.ui;

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
import androidx.annotation.Nullable;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f12063a = Pattern.compile("(&#13;)?&#10;");

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f12065b;

        public b(String str, Map<String, String> map) {
            this.f12064a = str;
            this.f12065b = map;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Comparator<c> f12066e = new Comparator() { // from class: androidx.media3.ui.i0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return h0.c.e((h0.c) obj, (h0.c) obj2);
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Comparator<c> f12067f = new Comparator() { // from class: androidx.media3.ui.j0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return h0.c.f((h0.c) obj, (h0.c) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f12070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f12071d;

        public c(int i11, int i12, String str, String str2) {
            this.f12068a = i11;
            this.f12069b = i12;
            this.f12070c = str;
            this.f12071d = str2;
        }

        public static /* synthetic */ int e(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.f12069b, cVar.f12069b);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar.f12070c.compareTo(cVar2.f12070c);
            return iCompareTo != 0 ? iCompareTo : cVar.f12071d.compareTo(cVar2.f12071d);
        }

        public static /* synthetic */ int f(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.f12068a, cVar.f12068a);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar2.f12070c.compareTo(cVar.f12070c);
            return iCompareTo != 0 ? iCompareTo : cVar2.f12071d.compareTo(cVar.f12071d);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c> f12072a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c> f12073b = new ArrayList();
    }

    public static b a(@Nullable CharSequence charSequence, float f11) {
        if (charSequence == null) {
            return new b("", ImmutableMap.of());
        }
        if (!(charSequence instanceof Spanned)) {
            return new b(b(charSequence), ImmutableMap.of());
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
            map.put(h.a("bg_" + iIntValue), u0.G("background-color:%s;", h.b(iIntValue)));
        }
        SparseArray<d> sparseArrayC = c(spanned, f11);
        StringBuilder sb2 = new StringBuilder(spanned.length());
        int i12 = 0;
        while (i11 < sparseArrayC.size()) {
            int iKeyAt = sparseArrayC.keyAt(i11);
            sb2.append(b(spanned.subSequence(i12, iKeyAt)));
            d dVar = sparseArrayC.get(iKeyAt);
            Collections.sort(dVar.f12073b, c.f12067f);
            Iterator it2 = dVar.f12073b.iterator();
            while (it2.hasNext()) {
                sb2.append(((c) it2.next()).f12071d);
            }
            Collections.sort(dVar.f12072a, c.f12066e);
            Iterator it3 = dVar.f12072a.iterator();
            while (it3.hasNext()) {
                sb2.append(((c) it3.next()).f12070c);
            }
            i11++;
            i12 = iKeyAt;
        }
        sb2.append(b(spanned.subSequence(i12, spanned.length())));
        return new b(sb2.toString(), map);
    }

    public static String b(CharSequence charSequence) {
        return f12063a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    public static SparseArray<d> c(Spanned spanned, float f11) {
        SparseArray<d> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String strE = e(obj, f11);
            String strD = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (strE != null) {
                z3.a.e(strD);
                c cVar = new c(spanStart, spanEnd, strE, strD);
                f(sparseArray, spanStart).f12072a.add(cVar);
                f(sparseArray, spanEnd).f12073b.add(cVar);
            }
        }
        return sparseArray;
    }

    @Nullable
    public static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof y3.d) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof y3.h)) {
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
            if (obj instanceof y3.f) {
                return "<rt>" + b(((y3.f) obj).f81156a) + "</rt></ruby>";
            }
            if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    @Nullable
    public static String e(Object obj, float f11) {
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return u0.G("<span style='color:%s;'>", h.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return u0.G("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof y3.d) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
            return u0.G("<span style='font-size:%.2fpx;'>", Float.valueOf(absoluteSizeSpan.getDip() ? absoluteSizeSpan.getSize() : absoluteSizeSpan.getSize() / f11));
        }
        if (obj instanceof RelativeSizeSpan) {
            return u0.G("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return u0.G("<span style='font-family:\"%s\";'>", family);
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
        if (!(obj instanceof y3.f)) {
            if (obj instanceof UnderlineSpan) {
                return "<u>";
            }
            if (!(obj instanceof y3.h)) {
                return null;
            }
            y3.h hVar = (y3.h) obj;
            return u0.G("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(hVar.f81161a, hVar.f81162b), g(hVar.f81163c));
        }
        int i11 = ((y3.f) obj).f81157b;
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

    public static d f(SparseArray<d> sparseArray, int i11) {
        d dVar = sparseArray.get(i11);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        sparseArray.put(i11, dVar2);
        return dVar2;
    }

    public static String g(int i11) {
        return i11 != 2 ? "over right" : "under left";
    }

    public static String h(int i11, int i12) {
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
}
