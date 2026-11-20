package tm;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.zxing.NotFoundException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f77245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a> f77246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, a> f77247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, a> f77248d;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f77249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f77250b;

        public a(boolean z11, int i11) {
            this.f77249a = z11;
            this.f77250b = i11;
        }

        public static a a(int i11) {
            return new a(false, i11);
        }

        public static a b(int i11) {
            return new a(true, i11);
        }
    }

    static {
        HashMap map = new HashMap();
        f77245a = map;
        map.put("00", a.a(18));
        map.put("01", a.a(14));
        map.put("02", a.a(14));
        map.put(PrepareException.ERROR_MINI_APPID, a.b(20));
        map.put(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY, a.a(6));
        map.put(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN, a.a(6));
        map.put(PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION, a.a(6));
        map.put(PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION, a.a(6));
        map.put("17", a.a(6));
        map.put("20", a.a(2));
        map.put("21", a.b(20));
        map.put("22", a.b(29));
        map.put("30", a.b(8));
        map.put("37", a.b(8));
        for (int i11 = 90; i11 <= 99; i11++) {
            f77245a.put(String.valueOf(i11), a.b(30));
        }
        HashMap map2 = new HashMap();
        f77246b = map2;
        map2.put("240", a.b(30));
        map2.put("241", a.b(30));
        map2.put("242", a.b(6));
        map2.put("250", a.b(30));
        map2.put("251", a.b(30));
        map2.put("253", a.b(17));
        map2.put("254", a.b(20));
        map2.put("400", a.b(30));
        map2.put("401", a.b(30));
        map2.put("402", a.a(17));
        map2.put("403", a.b(30));
        map2.put("410", a.a(13));
        map2.put("411", a.a(13));
        map2.put("412", a.a(13));
        map2.put("413", a.a(13));
        map2.put("414", a.a(13));
        map2.put("420", a.b(20));
        map2.put("421", a.b(15));
        map2.put("422", a.a(3));
        map2.put("423", a.b(15));
        map2.put("424", a.a(3));
        map2.put("425", a.a(3));
        map2.put("426", a.a(3));
        f77247c = new HashMap();
        for (int i12 = 310; i12 <= 316; i12++) {
            f77247c.put(String.valueOf(i12), a.a(6));
        }
        for (int i13 = 320; i13 <= 336; i13++) {
            f77247c.put(String.valueOf(i13), a.a(6));
        }
        for (int i14 = 340; i14 <= 357; i14++) {
            f77247c.put(String.valueOf(i14), a.a(6));
        }
        for (int i15 = 360; i15 <= 369; i15++) {
            f77247c.put(String.valueOf(i15), a.a(6));
        }
        Map<String, a> map3 = f77247c;
        map3.put("390", a.b(15));
        map3.put("391", a.b(18));
        map3.put("392", a.b(15));
        map3.put("393", a.b(18));
        map3.put("703", a.b(30));
        HashMap map4 = new HashMap();
        f77248d = map4;
        map4.put("7001", a.a(13));
        map4.put("7002", a.b(30));
        map4.put("7003", a.a(10));
        map4.put("8001", a.a(14));
        map4.put("8002", a.b(20));
        map4.put("8003", a.b(30));
        map4.put("8004", a.b(30));
        map4.put("8005", a.a(6));
        map4.put("8006", a.a(18));
        map4.put("8007", a.b(30));
        map4.put("8008", a.b(12));
        map4.put("8018", a.a(18));
        map4.put("8020", a.b(25));
        map4.put("8100", a.a(6));
        map4.put("8101", a.a(10));
        map4.put("8102", a.a(2));
        map4.put("8110", a.b(70));
        map4.put("8200", a.b(70));
    }

    public static String a(String str) throws NotFoundException {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() < 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        a aVar = f77245a.get(str.substring(0, 2));
        if (aVar != null) {
            return aVar.f77249a ? c(2, aVar.f77250b, str) : b(2, aVar.f77250b, str);
        }
        if (str.length() < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        String strSubstring = str.substring(0, 3);
        a aVar2 = f77246b.get(strSubstring);
        if (aVar2 != null) {
            return aVar2.f77249a ? c(3, aVar2.f77250b, str) : b(3, aVar2.f77250b, str);
        }
        if (str.length() < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        a aVar3 = f77247c.get(strSubstring);
        if (aVar3 != null) {
            return aVar3.f77249a ? c(4, aVar3.f77250b, str) : b(4, aVar3.f77250b, str);
        }
        a aVar4 = f77248d.get(str.substring(0, 4));
        if (aVar4 != null) {
            return aVar4.f77249a ? c(4, aVar4.f77250b, str) : b(4, aVar4.f77250b, str);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static String b(int i11, int i12, String str) throws NotFoundException {
        if (str.length() < i11) {
            throw NotFoundException.getNotFoundInstance();
        }
        String strSubstring = str.substring(0, i11);
        int i13 = i12 + i11;
        if (str.length() < i13) {
            throw NotFoundException.getNotFoundInstance();
        }
        String strSubstring2 = str.substring(i11, i13);
        String str2 = '(' + strSubstring + ')' + strSubstring2;
        String strA = a(str.substring(i13));
        if (strA == null) {
            return str2;
        }
        return str2 + strA;
    }

    public static String c(int i11, int i12, String str) throws NotFoundException {
        String strSubstring = str.substring(0, i11);
        int iMin = Math.min(str.length(), i12 + i11);
        String strSubstring2 = str.substring(i11, iMin);
        String str2 = '(' + strSubstring + ')' + strSubstring2;
        String strA = a(str.substring(iMin));
        if (strA == null) {
            return str2;
        }
        return str2 + strA;
    }
}
