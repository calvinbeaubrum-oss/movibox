package xn;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class n implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Collection<BarcodeFormat> f80630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<DecodeHintType, ?> f80631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f80632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f80633d;

    public n() {
    }

    public n(Collection<BarcodeFormat> collection) {
        this.f80630a = collection;
    }

    public n(Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, int i11) {
        this.f80630a = collection;
        this.f80631b = map;
        this.f80632c = str;
        this.f80633d = i11;
    }

    @Override // xn.k
    public j a(Map<DecodeHintType, ?> map) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(map);
        Map<DecodeHintType, ?> map2 = this.f80631b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection<BarcodeFormat> collection = this.f80630a;
        if (collection != null) {
            enumMap.put(DecodeHintType.POSSIBLE_FORMATS, collection);
        }
        String str = this.f80632c;
        if (str != null) {
            enumMap.put(DecodeHintType.CHARACTER_SET, str);
        }
        com.google.zxing.f fVar = new com.google.zxing.f();
        fVar.e(enumMap);
        int i11 = this.f80633d;
        if (i11 == 0) {
            return new j(fVar);
        }
        if (i11 != 1) {
            return i11 != 2 ? new j(fVar) : new p(fVar);
        }
        return new o(fVar);
    }
}
