package xf;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    @Nullable
    public static AdvertisingIdClient.Info a(Context context) {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(context);
        } catch (GooglePlayServicesNotAvailableException e11) {
            com.facebook.biddingkit.logging.b.d("Utils", "Failed to get AdvertisingIdClient: ", e11);
            return null;
        } catch (GooglePlayServicesRepairableException e12) {
            com.facebook.biddingkit.logging.b.d("Utils", "Failed to get AdvertisingIdClient: ", e12);
            return null;
        } catch (Exception e13) {
            com.facebook.biddingkit.logging.b.d("Utils", "Failed to get AdvertisingIdClient: ", e13);
            return null;
        }
    }

    public static yf.b[] b(yf.a aVar) {
        yf.b[] bVarArr = new yf.b[2];
        if (aVar == null) {
            return bVarArr;
        }
        for (yf.b bVar : aVar.entries()) {
            if (tf.c.a(bVar.b())) {
                yf.b bVar2 = bVarArr[0];
                if (bVar2 == null) {
                    bVarArr[0] = bVar;
                } else if (bVar2.a() < bVar.a()) {
                    bVarArr[1] = bVarArr[0];
                    bVarArr[0] = bVar;
                } else {
                    yf.b bVar3 = bVarArr[1];
                    if (bVar3 == null) {
                        bVarArr[1] = bVar;
                    } else if (bVar3.a() < bVar.a()) {
                        bVarArr[1] = bVar;
                    }
                }
            }
        }
        return bVarArr;
    }

    public static String c(Context context) {
        AdvertisingIdClient.Info infoA = a(context);
        return infoA != null ? infoA.getId() : "";
    }

    public static boolean d(Context context) {
        AdvertisingIdClient.Info infoA = a(context);
        if (infoA != null) {
            return infoA.isLimitAdTrackingEnabled();
        }
        return false;
    }
}
