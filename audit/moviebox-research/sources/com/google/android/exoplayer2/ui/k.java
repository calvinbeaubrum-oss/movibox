package com.google.android.exoplayer2.ui;

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

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f35176a = Pattern.compile("(&#13;)?&#10;");

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f35177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f35178b;

        public b(String str, Map<String, String> map) {
            this.f35177a = str;
            this.f35178b = map;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Comparator<c> f35179e = new Comparator() { // from class: com.google.android.exoplayer2.ui.l
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return k.c.e((k.c) obj, (k.c) obj2);
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Comparator<c> f35180f = new Comparator() { // from class: com.google.android.exoplayer2.ui.m
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return k.c.f((k.c) obj, (k.c) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f35183c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f35184d;

        public c(int i11, int i12, String str, String str2) {
            this.f35181a = i11;
            this.f35182b = i12;
            this.f35183c = str;
            this.f35184d = str2;
        }

        public static /* synthetic */ int e(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.f35182b, cVar.f35182b);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar.f35183c.compareTo(cVar2.f35183c);
            return iCompareTo != 0 ? iCompareTo : cVar.f35184d.compareTo(cVar2.f35184d);
        }

        public static /* synthetic */ int f(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.f35181a, cVar.f35181a);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar2.f35183c.compareTo(cVar.f35183c);
            return iCompareTo != 0 ? iCompareTo : cVar2.f35184d.compareTo(cVar.f35184d);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c> f35185a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c> f35186b = new ArrayList();
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
            map.put(h.a("bg_" + iIntValue), com.google.android.exoplayer2.util.o0.C("background-color:%s;", h.b(iIntValue)));
        }
        SparseArray<d> sparseArrayC = c(spanned, f11);
        StringBuilder sb2 = new StringBuilder(spanned.length());
        int i12 = 0;
        while (i11 < sparseArrayC.size()) {
            int iKeyAt = sparseArrayC.keyAt(i11);
            sb2.append(b(spanned.subSequence(i12, iKeyAt)));
            d dVar = sparseArrayC.get(iKeyAt);
            Collections.sort(dVar.f35186b, c.f35180f);
            Iterator it2 = dVar.f35186b.iterator();
            while (it2.hasNext()) {
                sb2.append(((c) it2.next()).f35184d);
            }
            Collections.sort(dVar.f35185a, c.f35179e);
            Iterator it3 = dVar.f35185a.iterator();
            while (it3.hasNext()) {
                sb2.append(((c) it3.next()).f35183c);
            }
            i11++;
            i12 = iKeyAt;
        }
        sb2.append(b(spanned.subSequence(i12, spanned.length())));
        return new b(sb2.toString(), map);
    }

    public static String b(CharSequence charSequence) {
        return f35176a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    public static SparseArray<d> c(Spanned spanned, float f11) {
        SparseArray<d> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String strE = e(obj, f11);
            String strD = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (strE != null) {
                com.google.android.exoplayer2.util.a.e(strD);
                c cVar = new c(spanStart, spanEnd, strE, strD);
                f(sparseArray, spanStart).f35185a.add(cVar);
                f(sparseArray, spanEnd).f35186b.add(cVar);
            }
        }
        return sparseArray;
    }

    @Nullable
    public static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof zh.a) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof zh.e)) {
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
            if (obj instanceof zh.c) {
                return "<rt>" + b(((zh.c) obj).f82049a) + "</rt></ruby>";
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
            return com.google.android.exoplayer2.util.o0.C("<span style='color:%s;'>", h.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return com.google.android.exoplayer2.util.o0.C("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof zh.a) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
            return com.google.android.exoplayer2.util.o0.C("<span style='font-size:%.2fpx;'>", Float.valueOf(absoluteSizeSpan.getDip() ? absoluteSizeSpan.getSize() : absoluteSizeSpan.getSize() / f11));
        }
        if (obj instanceof RelativeSizeSpan) {
            return com.google.android.exoplayer2.util.o0.C("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return com.google.android.exoplayer2.util.o0.C("<span style='font-family:\"%s\";'>", family);
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
        if (!(obj instanceof zh.c)) {
            if (obj instanceof UnderlineSpan) {
                return "<u>";
            }
            if (!(obj instanceof zh.e)) {
                return null;
            }
            zh.e eVar = (zh.e) obj;
            return com.google.android.exoplayer2.util.o0.C("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(eVar.f82051a, eVar.f82052b), g(eVar.f82053c));
        }
        int i11 = ((zh.c) obj).f82050b;
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
