package a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.transsion.core.utils.d;
import com.transsion.push.PushConstants;
import com.transsion.push.utils.ServiceUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            ws.a.b(context.getApplicationContext());
            if (d.a()) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString(PushConstants.EXTRA_PUSH_SERVICE_TYPE, PushConstants.PUSH_SERVICE_TYPE_SYNC_CONFIG);
                    ServiceUtils.startJobThread(context.getApplicationContext(), bundle);
                } catch (Exception unused) {
                }
            }
        }
    }
}
