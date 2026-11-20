package fo;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements h {
    @Override // fo.h
    public final String a() {
        return "aaid";
    }

    @Override // fo.h
    public final h.a b(p007do.m mVar, Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, IOException {
        com.google.common.base.m.w(GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context) == 0, "GMS not available");
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        String strE = com.google.common.base.p.e(advertisingIdInfo.getId());
        if (strE.matches("^[-0]+$")) {
            strE = "";
        }
        return new h.a(strE, advertisingIdInfo.isLimitAdTrackingEnabled());
    }
}
