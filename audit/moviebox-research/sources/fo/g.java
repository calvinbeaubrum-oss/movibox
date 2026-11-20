package fo;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class g {
    public static h a(Context context) {
        try {
            int i11 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
            Constructor declaredConstructor = l.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            return (h) declaredConstructor.newInstance(null);
        } catch (Exception e11) {
            throw new UnsupportedOperationException("GMS not available", e11);
        }
    }
}
