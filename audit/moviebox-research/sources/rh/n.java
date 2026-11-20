package rh;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f75480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f75481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f75482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f75483d;

    public n(String[] strArr, int[] iArr, String[] strArr2, int i11) {
        this.f75480a = strArr;
        this.f75481b = iArr;
        this.f75482c = strArr2;
        this.f75483d = i11;
    }

    public static n b(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new n(strArr, iArr, strArr2, c(str, strArr, iArr, strArr2));
    }

    public static int c(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String strSubstring;
        strArr[0] = "";
        int length = 0;
        int i11 = 0;
        while (length < str.length()) {
            int iIndexOf = str.indexOf("$", length);
            if (iIndexOf == -1) {
                strArr[i11] = strArr[i11] + str.substring(length);
                length = str.length();
            } else if (iIndexOf != length) {
                strArr[i11] = strArr[i11] + str.substring(length, iIndexOf);
                length = iIndexOf;
            } else if (str.startsWith("$$", length)) {
                strArr[i11] = strArr[i11] + "$";
                length += 2;
            } else {
                int i12 = length + 1;
                int iIndexOf2 = str.indexOf("$", i12);
                String strSubstring2 = str.substring(i12, iIndexOf2);
                if (strSubstring2.equals("RepresentationID")) {
                    iArr[i11] = 1;
                } else {
                    int iIndexOf3 = strSubstring2.indexOf("%0");
                    if (iIndexOf3 != -1) {
                        strSubstring = strSubstring2.substring(iIndexOf3);
                        if (!strSubstring.endsWith(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D) && !strSubstring.endsWith("x") && !strSubstring.endsWith("X")) {
                            strSubstring = strSubstring + DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D;
                        }
                        strSubstring2 = strSubstring2.substring(0, iIndexOf3);
                    } else {
                        strSubstring = "%01d";
                    }
                    strSubstring2.hashCode();
                    switch (strSubstring2) {
                        case "Number":
                            iArr[i11] = 2;
                            break;
                        case "Time":
                            iArr[i11] = 4;
                            break;
                        case "Bandwidth":
                            iArr[i11] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    strArr2[i11] = strSubstring;
                }
                i11++;
                strArr[i11] = "";
                length = iIndexOf2 + 1;
            }
        }
        return i11;
    }

    public String a(String str, long j11, int i11, long j12) {
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        while (true) {
            int i13 = this.f75483d;
            if (i12 >= i13) {
                sb2.append(this.f75480a[i13]);
                return sb2.toString();
            }
            sb2.append(this.f75480a[i12]);
            int i14 = this.f75481b[i12];
            if (i14 == 1) {
                sb2.append(str);
            } else if (i14 == 2) {
                sb2.append(String.format(Locale.US, this.f75482c[i12], Long.valueOf(j11)));
            } else if (i14 == 3) {
                sb2.append(String.format(Locale.US, this.f75482c[i12], Integer.valueOf(i11)));
            } else if (i14 == 4) {
                sb2.append(String.format(Locale.US, this.f75482c[i12], Long.valueOf(j12)));
            }
            i12++;
        }
    }
}
