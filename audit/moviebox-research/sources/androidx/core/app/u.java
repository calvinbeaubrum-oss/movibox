package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f7761a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f7762b = new Object();

    public static c0 a(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("allowedDataTypes");
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return new c0(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), 0, bundle.getBundle("extras"), hashSet);
    }

    public static c0[] b(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        c0[] c0VarArr = new c0[bundleArr.length];
        for (int i11 = 0; i11 < bundleArr.length; i11++) {
            c0VarArr[i11] = a(bundleArr[i11]);
        }
        return c0VarArr;
    }

    public static NotificationCompat.b c(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("extras");
        return new NotificationCompat.b(bundle.getInt(RewardPlus.ICON), bundle.getCharSequence(CampaignEx.JSON_KEY_TITLE), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), b(d(bundle, "remoteInputs")), b(d(bundle, "dataOnlyRemoteInputs")), bundle2 != null ? bundle2.getBoolean("android.support.allowGeneratedReplies", false) : false, bundle.getInt("semanticAction"), bundle.getBoolean("showsUserInterface"), false, false);
    }

    public static Bundle[] d(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    public static Bundle e(NotificationCompat.b bVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatD = bVar.d();
        bundle.putInt(RewardPlus.ICON, iconCompatD != null ? iconCompatD.n() : 0);
        bundle.putCharSequence(CampaignEx.JSON_KEY_TITLE, bVar.h());
        bundle.putParcelable("actionIntent", bVar.a());
        Bundle bundle2 = bVar.c() != null ? new Bundle(bVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", bVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", g(bVar.e()));
        bundle.putBoolean("showsUserInterface", bVar.g());
        bundle.putInt("semanticAction", bVar.f());
        return bundle;
    }

    public static Bundle f(c0 c0Var) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c0Var.i());
        bundle.putCharSequence("label", c0Var.h());
        bundle.putCharSequenceArray("choices", c0Var.e());
        bundle.putBoolean("allowFreeFormInput", c0Var.c());
        bundle.putBundle("extras", c0Var.g());
        Set<String> setD = c0Var.d();
        if (setD != null && !setD.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setD.size());
            Iterator<String> it = setD.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static Bundle[] g(c0[] c0VarArr) {
        if (c0VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c0VarArr.length];
        for (int i11 = 0; i11 < c0VarArr.length; i11++) {
            bundleArr[i11] = f(c0VarArr[i11]);
        }
        return bundleArr;
    }
}
