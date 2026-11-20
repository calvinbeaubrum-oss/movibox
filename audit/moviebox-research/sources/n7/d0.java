package n7;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d0 implements z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f71594b = new d0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DecimalFormat f71595a;

    public d0() {
        this.f71595a = null;
    }

    public d0(String str) {
        this(new DecimalFormat(str));
    }

    public d0(DecimalFormat decimalFormat) {
        this.f71595a = decimalFormat;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.i0(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
            j1Var.g0();
            return;
        }
        DecimalFormat decimalFormat = this.f71595a;
        if (decimalFormat == null) {
            j1Var.o(dDoubleValue, true);
        } else {
            j1Var.write(decimalFormat.format(dDoubleValue));
        }
    }
}
