package com.google.firebase.messaging;

import android.os.Bundle;
import com.transsion.push.PushConstants;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f40835a = TimeUnit.MINUTES.toMillis(3);

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static androidx.collection.a<String, String> a(Bundle bundle) {
            androidx.collection.a<String, String> aVar = new androidx.collection.a<>();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals(PushConstants.EXTRA_PUSH_MESSAGE_TYPE) && !str.equals("collapse_key")) {
                        aVar.put(str, str2);
                    }
                }
            }
            return aVar;
        }
    }
}
