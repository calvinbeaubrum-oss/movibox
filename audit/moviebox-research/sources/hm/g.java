package hm;

import com.google.zxing.common.CharacterSetECI;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<CharsetEncoder> f66518c = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharsetEncoder[] f66519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f66520b;

    static {
        String[] strArr = {"IBM437", "ISO-8859-2", "ISO-8859-3", "ISO-8859-4", "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9", "ISO-8859-10", "ISO-8859-11", "ISO-8859-13", "ISO-8859-14", "ISO-8859-15", "ISO-8859-16", "windows-1250", "windows-1251", "windows-1252", "windows-1256", "Shift_JIS"};
        for (int i11 = 0; i11 < 20; i11++) {
            String str = strArr[i11];
            if (CharacterSetECI.getCharacterSetECIByName(str) != null) {
                try {
                    f66518c.add(Charset.forName(str).newEncoder());
                } catch (UnsupportedCharsetException unused) {
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006e  */
    /* JADX WARN: Code duplicated, block: B:54:0x006f A[SYNTHETIC] */
    public g(String str, Charset charset, int i11) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        arrayList.add(StandardCharsets.ISO_8859_1.newEncoder());
        int i12 = 0;
        boolean z12 = charset != null && charset.name().startsWith("UTF");
        for (int i13 = 0; i13 < str.length(); i13++) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z11 = false;
                    break;
                }
                CharsetEncoder charsetEncoder = (CharsetEncoder) it.next();
                char cCharAt = str.charAt(i13);
                if (cCharAt == i11 || charsetEncoder.canEncode(cCharAt)) {
                    z11 = true;
                    break;
                }
            }
            if (!z11) {
                Iterator<CharsetEncoder> it2 = f66518c.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        CharsetEncoder next = it2.next();
                        if (next.canEncode(str.charAt(i13))) {
                            arrayList.add(next);
                        }
                    } else if (!z11) {
                        z12 = true;
                    }
                }
            } else if (!z11) {
                z12 = true;
            }
        }
        if (arrayList.size() != 1 || z12) {
            this.f66519a = new CharsetEncoder[arrayList.size() + 2];
            Iterator it3 = arrayList.iterator();
            int i14 = 0;
            while (it3.hasNext()) {
                this.f66519a[i14] = (CharsetEncoder) it3.next();
                i14++;
            }
            this.f66519a[i14] = StandardCharsets.UTF_8.newEncoder();
            this.f66519a[i14 + 1] = StandardCharsets.UTF_16BE.newEncoder();
        } else {
            this.f66519a = new CharsetEncoder[]{(CharsetEncoder) arrayList.get(0)};
        }
        if (charset != null) {
            while (true) {
                CharsetEncoder[] charsetEncoderArr = this.f66519a;
                if (i12 >= charsetEncoderArr.length) {
                    break;
                } else if (charsetEncoderArr[i12] == null || !charset.name().equals(this.f66519a[i12].charset().name())) {
                    i12++;
                }
            }
            i12 = -1;
        } else {
            i12 = -1;
        }
        this.f66520b = i12;
    }

    public boolean a(char c11, int i11) {
        return this.f66519a[i11].canEncode("" + c11);
    }

    public byte[] b(char c11, int i11) {
        return ("" + c11).getBytes(this.f66519a[i11].charset());
    }

    public byte[] c(String str, int i11) {
        return str.getBytes(this.f66519a[i11].charset());
    }

    public Charset d(int i11) {
        return this.f66519a[i11].charset();
    }

    public int e(int i11) {
        return CharacterSetECI.getCharacterSetECI(this.f66519a[i11].charset()).getValue();
    }

    public int f() {
        return this.f66520b;
    }

    public int g() {
        return this.f66519a.length;
    }
}
