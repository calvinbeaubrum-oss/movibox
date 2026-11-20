package n7;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f71644a = new h();

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        if (b.a(obj)) {
            j1Var.w('{', AppMeasurementSdk.ConditionalUserProperty.VALUE, c.a(obj).longValue());
            j1Var.write(125);
        } else if (e.a(obj)) {
            j1Var.t('{', AppMeasurementSdk.ConditionalUserProperty.VALUE, f.a(obj).doubleValue());
            j1Var.write(125);
        }
    }
}
