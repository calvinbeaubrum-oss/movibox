package athena;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f13607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<Integer> f13609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f13611f;

    public c(String str, byte[] bArr, int i11, List<Integer> list, String str2, String str3) {
        this.f13606a = str;
        this.f13607b = bArr;
        this.f13608c = i11;
        this.f13609d = list;
        this.f13610e = str2;
        this.f13611f = str3;
    }

    public static c a(String str, byte[] bArr, int i11, List<Integer> list, String str2, String str3) {
        return new c(str, bArr, i11, list, str2, str3);
    }

    public String toString() {
        return "UploadEventsRequest{host='" + this.f13606a + "', data=" + Arrays.toString(this.f13607b) + ", lineNumber=" + this.f13608c + ", appidList=" + this.f13609d + ", packetUid='" + this.f13610e + "', dupid='" + this.f13611f + "'}";
    }
}
