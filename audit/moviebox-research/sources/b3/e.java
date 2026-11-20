package b3;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.R$styleable;
import com.google.logging.type.LogSeverity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a {
        public static int a(TypedArray typedArray, int i11) {
            return typedArray.getType(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final d[] f13964a;

        public c(@NonNull d[] dVarArr) {
            this.f13964a = dVarArr;
        }

        @NonNull
        public d[] a() {
            return this.f13964a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final String f13965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f13967c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f13968d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f13969e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f13970f;

        public d(@NonNull String str, int i11, boolean z11, @Nullable String str2, int i12, int i13) {
            this.f13965a = str;
            this.f13966b = i11;
            this.f13967c = z11;
            this.f13968d = str2;
            this.f13969e = i12;
            this.f13970f = i13;
        }

        @NonNull
        public String a() {
            return this.f13965a;
        }

        public int b() {
            return this.f13970f;
        }

        public int c() {
            return this.f13969e;
        }

        @Nullable
        public String d() {
            return this.f13968d;
        }

        public int e() {
            return this.f13966b;
        }

        public boolean f() {
            return this.f13967c;
        }
    }

    /* JADX INFO: renamed from: b3.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0139e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final androidx.core.provider.e f13971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final String f13974d;

        public C0139e(@NonNull androidx.core.provider.e eVar, int i11, int i12, @Nullable String str) {
            this.f13971a = eVar;
            this.f13973c = i11;
            this.f13972b = i12;
            this.f13974d = str;
        }

        public int a() {
            return this.f13973c;
        }

        @NonNull
        public androidx.core.provider.e b() {
            return this.f13971a;
        }

        @Nullable
        public String c() {
            return this.f13974d;
        }

        public int d() {
            return this.f13972b;
        }
    }

    public static int a(TypedArray typedArray, int i11) {
        return a.a(typedArray, i11);
    }

    @Nullable
    public static b b(@NonNull XmlPullParser xmlPullParser, @NonNull Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    public static List<List<byte[]>> c(@NonNull Resources resources, int i11) {
        if (i11 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i11);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i12 = 0; i12 < typedArrayObtainTypedArray.length(); i12++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i12, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i11)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    @Nullable
    public static b d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    @Nullable
    public static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamily);
        String string = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderSystemFontFamily);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new C0139e(new androidx.core.provider.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    public static d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyFont);
        int i11 = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(R$styleable.FontFamilyFont_fontWeight) ? R$styleable.FontFamilyFont_fontWeight : R$styleable.FontFamilyFont_android_fontWeight, LogSeverity.WARNING_VALUE);
        boolean z11 = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(R$styleable.FontFamilyFont_fontStyle) ? R$styleable.FontFamilyFont_fontStyle : R$styleable.FontFamilyFont_android_fontStyle, 0);
        int i12 = typedArrayObtainAttributes.hasValue(R$styleable.FontFamilyFont_ttcIndex) ? R$styleable.FontFamilyFont_ttcIndex : R$styleable.FontFamilyFont_android_ttcIndex;
        String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(R$styleable.FontFamilyFont_fontVariationSettings) ? R$styleable.FontFamilyFont_fontVariationSettings : R$styleable.FontFamilyFont_android_fontVariationSettings);
        int i13 = typedArrayObtainAttributes.getInt(i12, 0);
        int i14 = typedArrayObtainAttributes.hasValue(R$styleable.FontFamilyFont_font) ? R$styleable.FontFamilyFont_font : R$styleable.FontFamilyFont_android_font;
        int resourceId = typedArrayObtainAttributes.getResourceId(i14, 0);
        String string2 = typedArrayObtainAttributes.getString(i14);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i11, z11, string, i13, resourceId);
    }

    public static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i11 = 1;
        while (i11 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i11++;
            } else if (next == 3) {
                i11--;
            }
        }
    }

    public static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
