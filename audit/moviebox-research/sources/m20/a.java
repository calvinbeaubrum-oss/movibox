package m20;

import androidx.core.view.InputDeviceCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.cloud.config.utils.CommonUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.baselib.db.download.DownloadException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements l20.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a[] f70678x = new a[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f70679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f70680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f70681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f70682d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f70683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f70684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f70685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f70686i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f70687j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f70688k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f70689l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f70690m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f70691n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f70692o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f70693p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f70694q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f70695r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f70696s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f70697t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f70698u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final File f70699v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map<String, String> f70700w;

    public a(boolean z11) {
        this.f70679a = "";
        this.f70682d = 0L;
        this.f70683f = 0L;
        this.f70684g = 0L;
        this.f70688k = "";
        this.f70689l = "ustar\u0000";
        this.f70690m = "00";
        this.f70692o = "";
        this.f70693p = 0;
        this.f70694q = 0;
        this.f70700w = new HashMap();
        String property = System.getProperty("user.name", "");
        this.f70691n = property.length() > 31 ? property.substring(0, 31) : property;
        this.f70699v = null;
        this.f70680b = z11;
    }

    public a(byte[] bArr, u uVar, boolean z11) throws IOException {
        this(false);
        q(bArr, uVar, false, z11);
    }

    public static String o(String str, boolean z11) {
        String lowerCase;
        int iIndexOf;
        if (!z11 && (lowerCase = System.getProperty("os.name").toLowerCase(Locale.ENGLISH)) != null) {
            if (lowerCase.startsWith("windows")) {
                if (str.length() > 2) {
                    char cCharAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.contains("netware") && (iIndexOf = str.indexOf(58)) != -1) {
                str = str.substring(iIndexOf + 1);
            }
        }
        String strReplace = str.replace(File.separatorChar, '/');
        while (!z11 && strReplace.startsWith("/")) {
            strReplace = strReplace.substring(1);
        }
        return strReplace;
    }

    public void A(long j11) {
        this.f70682d = j11;
    }

    public void B(String str) {
        this.f70691n = str;
    }

    public void C(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            r(entry.getKey(), entry.getValue(), map);
        }
    }

    public boolean a(a aVar) {
        return aVar != null && f().equals(aVar.f());
    }

    public final int b(byte[] bArr) {
        if (o20.a.c("ustar ", bArr, InputDeviceCompat.SOURCE_KEYBOARD, 6)) {
            return 2;
        }
        if (o20.a.c("ustar\u0000", bArr, InputDeviceCompat.SOURCE_KEYBOARD, 6)) {
            return o20.a.c("tar\u0000", bArr, DownloadException.EXCEPTION_IO_MALFORMED_URL, 4) ? 4 : 3;
        }
        return 0;
    }

    public void c(Map<String, String> map) {
        this.f70697t = true;
        this.f70696s = Integer.parseInt(map.get("GNU.sparse.size"));
        if (map.containsKey("GNU.sparse.name")) {
            this.f70679a = map.get("GNU.sparse.name");
        }
    }

    public void d(Map<String, String> map) {
        this.f70697t = true;
        this.f70696s = Integer.parseInt(map.get("GNU.sparse.realsize"));
        this.f70679a = map.get("GNU.sparse.name");
    }

    public void e(Map<String, String> map) {
        this.f70698u = true;
        if (map.containsKey("SCHILY.realsize")) {
            this.f70696s = Long.parseLong(map.get("SCHILY.realsize"));
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return a((a) obj);
    }

    public String f() {
        return this.f70679a;
    }

    public long g() {
        return this.f70684g;
    }

    public boolean h() {
        File file = this.f70699v;
        if (file != null) {
            return file.isDirectory();
        }
        if (this.f70687j == 53) {
            return true;
        }
        return (n() || l() || !f().endsWith("/")) ? false : true;
    }

    public int hashCode() {
        return f().hashCode();
    }

    public boolean i() {
        return this.f70695r;
    }

    public boolean j() {
        return this.f70687j == 75;
    }

    public boolean k() {
        return this.f70687j == 76;
    }

    public boolean l() {
        return this.f70687j == 103;
    }

    public boolean m() {
        return this.f70687j == 83;
    }

    public boolean n() {
        byte b11 = this.f70687j;
        return b11 == 120 || b11 == 88;
    }

    public final long p(byte[] bArr, int i11, int i12, boolean z11) {
        if (!z11) {
            return d.h(bArr, i11, i12);
        }
        try {
            return d.h(bArr, i11, i12);
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    public final void q(byte[] bArr, u uVar, boolean z11, boolean z12) throws IOException {
        this.f70679a = z11 ? d.e(bArr, 0, 100) : d.f(bArr, 0, 100, uVar);
        this.f70681c = (int) p(bArr, 100, 8, z12);
        this.f70682d = (int) p(bArr, 108, 8, z12);
        this.f70683f = (int) p(bArr, 116, 8, z12);
        this.f70684g = d.h(bArr, 124, 12);
        this.f70685h = p(bArr, 136, 12, z12);
        this.f70686i = d.i(bArr);
        this.f70687j = bArr[156];
        this.f70688k = z11 ? d.e(bArr, 157, 100) : d.f(bArr, 157, 100, uVar);
        this.f70689l = d.e(bArr, InputDeviceCompat.SOURCE_KEYBOARD, 6);
        this.f70690m = d.e(bArr, 263, 2);
        this.f70691n = z11 ? d.e(bArr, 265, 32) : d.f(bArr, 265, 32, uVar);
        this.f70692o = z11 ? d.e(bArr, 297, 32) : d.f(bArr, 297, 32, uVar);
        byte b11 = this.f70687j;
        if (b11 == 51 || b11 == 52) {
            this.f70693p = (int) p(bArr, 329, 8, z12);
            this.f70694q = (int) p(bArr, 337, 8, z12);
        }
        int iB = b(bArr);
        if (iB == 2) {
            this.f70695r = d.d(bArr, 482);
            this.f70696s = d.g(bArr, 483, 12);
            return;
        }
        if (iB == 4) {
            String strE = z11 ? d.e(bArr, 345, 131) : d.f(bArr, 345, 131, uVar);
            if (strE.length() > 0) {
                this.f70679a = strE + "/" + this.f70679a;
                return;
            }
            return;
        }
        String strE2 = z11 ? d.e(bArr, 345, 155) : d.f(bArr, 345, 155, uVar);
        if (h() && !this.f70679a.endsWith("/")) {
            this.f70679a += "/";
        }
        if (strE2.length() > 0) {
            this.f70679a = strE2 + "/" + this.f70679a;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void r(String str, String str2, Map<String, String> map) {
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1916861932:
                if (str.equals("SCHILY.devmajor")) {
                    b11 = 0;
                }
                break;
            case -1916619760:
                if (str.equals("SCHILY.devminor")) {
                    b11 = 1;
                }
                break;
            case -277496563:
                if (str.equals("GNU.sparse.realsize")) {
                    b11 = 2;
                }
                break;
            case -160380561:
                if (str.equals("GNU.sparse.size")) {
                    b11 = 3;
                }
                break;
            case 102338:
                if (str.equals("gid")) {
                    b11 = 4;
                }
                break;
            case 115792:
                if (str.equals(CommonUtils.PARAM_UID)) {
                    b11 = 5;
                }
                break;
            case 3433509:
                if (str.equals(MBridgeConstans.DYNAMIC_VIEW_WX_PATH)) {
                    b11 = 6;
                }
                break;
            case 3530753:
                if (str.equals("size")) {
                    b11 = 7;
                }
                break;
            case 98496370:
                if (str.equals("gname")) {
                    b11 = 8;
                }
                break;
            case 104223930:
                if (str.equals("mtime")) {
                    b11 = 9;
                }
                break;
            case 111425664:
                if (str.equals("uname")) {
                    b11 = 10;
                }
                break;
            case 530706950:
                if (str.equals("SCHILY.filetype")) {
                    b11 = Ascii.VT;
                }
                break;
            case 1195018015:
                if (str.equals("linkpath")) {
                    b11 = Ascii.FF;
                }
                break;
        }
        switch (b11) {
            case 0:
                s(Integer.parseInt(str2));
                break;
            case 1:
                t(Integer.parseInt(str2));
                break;
            case 2:
                d(map);
                break;
            case 3:
                c(map);
                break;
            case 4:
                u(Long.parseLong(str2));
                break;
            case 5:
                A(Long.parseLong(str2));
                break;
            case 6:
                y(str2);
                break;
            case 7:
                z(Long.parseLong(str2));
                break;
            case 8:
                v(str2);
                break;
            case 9:
                x((long) (Double.parseDouble(str2) * 1000.0d));
                break;
            case 10:
                B(str2);
                break;
            case 11:
                if ("sparse".equals(str2)) {
                    e(map);
                }
                break;
            case 12:
                w(str2);
                break;
            default:
                this.f70700w.put(str, str2);
                break;
        }
    }

    public void s(int i11) {
        if (i11 >= 0) {
            this.f70693p = i11;
            return;
        }
        throw new IllegalArgumentException("Major device number is out of range: " + i11);
    }

    public void t(int i11) {
        if (i11 >= 0) {
            this.f70694q = i11;
            return;
        }
        throw new IllegalArgumentException("Minor device number is out of range: " + i11);
    }

    public void u(long j11) {
        this.f70683f = j11;
    }

    public void v(String str) {
        this.f70692o = str;
    }

    public void w(String str) {
        this.f70688k = str;
    }

    public void x(long j11) {
        this.f70685h = j11 / 1000;
    }

    public void y(String str) {
        this.f70679a = o(str, this.f70680b);
    }

    public void z(long j11) {
        if (j11 >= 0) {
            this.f70684g = j11;
            return;
        }
        throw new IllegalArgumentException("Size is out of range: " + j11);
    }
}
