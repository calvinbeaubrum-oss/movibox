package af;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e implements af.d, af.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f484c = Pattern.compile("\\{([^{}]*)\\}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<d> f486b;

    /* JADX INFO: compiled from: source.java */
    public static class a extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ThreadLocal<SimpleDateFormat> f488d;

        /* JADX INFO: renamed from: af.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0023a extends ThreadLocal<SimpleDateFormat> {
            public C0023a() {
            }

            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SimpleDateFormat initialValue() {
                return new SimpleDateFormat(a.this.f487c, Locale.US);
            }
        }

        public a(String str, String str2, String str3) {
            super(str, str2);
            C0023a c0023a = new C0023a();
            this.f488d = c0023a;
            this.f487c = str3;
            try {
                c0023a.get().format(new Date());
            } catch (Exception e11) {
                throw new IllegalArgumentException("Bad date pattern: " + str3, e11);
            }
        }

        @Override // af.e.d
        public String a(String str, long j11, int i11, String str2, String str3) {
            return str.replace(this.f491a, this.f488d.get().format(new Date(j11)));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f490c;

        public b(String str, String str2, boolean z11) {
            super(str, str2);
            this.f490c = z11;
        }

        @Override // af.e.d
        public String a(String str, long j11, int i11, String str2, String str3) {
            return this.f490c ? str.replace(this.f491a, ze.c.a(i11)) : str.replace(this.f491a, ze.c.b(i11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends d {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // af.e.d
        public String a(String str, long j11, int i11, String str2, String str3) {
            return str.replace(this.f491a, str3);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f492b;

        public d(String str, String str2) {
            this.f491a = str;
            this.f492b = str2;
        }

        public abstract String a(String str, long j11, int i11, String str2, String str3);
    }

    /* JADX INFO: renamed from: af.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0024e extends d {
        public C0024e(String str, String str2) {
            super(str, str2);
        }

        @Override // af.e.d
        public String a(String str, long j11, int i11, String str2, String str3) {
            return str.replace(this.f491a, str2);
        }
    }

    public e(String str) {
        if (str == null) {
            throw new NullPointerException("Pattern should not be null");
        }
        this.f485a = str;
        List<d> listG = g(h(str));
        this.f486b = listG;
        if (listG.size() != 0) {
            return;
        }
        throw new IllegalArgumentException("No recognizable parameter found in the pattern " + str);
    }

    public static a c(String str, String str2) {
        if (str2.startsWith("d ") && str2.length() > 2) {
            return new a(str, str2, str2.substring(2));
        }
        if (str2.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D)) {
            return new a(str, str2, "yyyy-MM-dd HH:mm:ss.SSS");
        }
        return null;
    }

    public static b d(String str, String str2) {
        if (str2.equals("l")) {
            return new b(str, str2, false);
        }
        if (str2.equals("L")) {
            return new b(str, str2, true);
        }
        return null;
    }

    public static c e(String str, String str2) {
        if (str2.equals("m")) {
            return new c(str, str2);
        }
        return null;
    }

    public static d f(String str) {
        String str2 = "{" + str + "}";
        String strTrim = str.trim();
        a aVarC = c(str2, strTrim);
        if (aVarC != null) {
            return aVarC;
        }
        b bVarD = d(str2, strTrim);
        if (bVarD != null) {
            return bVarD;
        }
        C0024e c0024eI = i(str2, strTrim);
        if (c0024eI != null) {
            return c0024eI;
        }
        c cVarE = e(str2, strTrim);
        if (cVarE != null) {
            return cVarE;
        }
        return null;
    }

    public static List<d> g(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            d dVarF = f(it.next());
            if (dVarF != null) {
                arrayList.add(dVarF);
            }
        }
        return arrayList;
    }

    public static List<String> h(String str) {
        ArrayList arrayList = new ArrayList(4);
        Matcher matcher = f484c.matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group(1));
        }
        return arrayList;
    }

    public static C0024e i(String str, String str2) {
        if (str2.equals("t")) {
            return new C0024e(str, str2);
        }
        return null;
    }

    @Override // af.c
    public CharSequence a(long j11, int i11, String str, String str2) {
        String str3 = this.f485a;
        Iterator<d> it = this.f486b.iterator();
        String strA = str3;
        while (it.hasNext()) {
            strA = it.next().a(strA, j11, i11, str, str2);
        }
        return strA;
    }

    @Override // af.d
    public CharSequence b(int i11, String str, String str2) {
        return a(System.currentTimeMillis(), i11, str, str2);
    }
}
