package athena;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.data.TrackData;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.push.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 3)
public class n extends l implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile n f13724f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f13726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13727c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13725a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13728d = 0;

    public n() {
        HandlerThread handlerThread = new HandlerThread("Athena-Worker");
        handlerThread.setPriority(10);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f13726b = handler;
        handler.sendEmptyMessage(303);
    }

    public static n i(Context context) {
        if (f13724f == null) {
            synchronized (h.class) {
                try {
                    if (f13724f == null) {
                        f13724f = new n();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f13724f;
    }

    @Override // athena.l
    public void d(Message message, long j11) {
        Handler handler = this.f13726b;
        if (handler != null) {
            handler.sendMessageDelayed(message, j11);
        }
    }

    @Override // athena.l
    public void e(Runnable runnable) {
        Handler handler = this.f13726b;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // athena.l
    public void f(String str, TrackData trackData, long j11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
            jSONObject.put("tid", j11);
            jSONObject.put("type", trackData.c());
            JSONObject jSONObjectA = trackData.a();
            String str2 = br.g.f14348a;
            jSONObject.put("_eparam", jSONObjectA);
        } catch (JSONException e11) {
            a0.c(Log.getStackTraceString(e11));
        }
        String string = jSONObject.toString();
        int i11 = this.f13727c;
        if (i11 < 5000) {
            this.f13727c = i11 + 1;
            Message messageObtainMessage = this.f13726b.obtainMessage(302);
            messageObtainMessage.obj = string;
            this.f13726b.sendMessage(messageObtainMessage);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i11 = message.what;
            if (i11 == 302) {
                this.f13727c--;
                l((String) message.obj);
                return false;
            }
            if (i11 != 303) {
                if (i11 == 400) {
                    j(message.arg1, (String) message.obj);
                    return false;
                }
                if (i11 != 405) {
                    return false;
                }
                k((cr.c) message.obj);
                return false;
            }
            a0.f13598a.m().r(br.g.D());
            a0.e("Athena SDK Version is 3.0.0.5");
            a0.e("Athena is in Lite mode");
            if (cr.b.d() == 0) {
                j0.e("HostAppId must be set up in LiteMode");
            }
            m();
            return false;
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            return false;
        }
    }

    public final void j(int i11, String str) {
        if (this.f13725a != 1) {
            a0.a("Failed to connect to DCS service");
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(PushConstants.PROVIDER_FIELD_APP_ID, Integer.valueOf(i11));
        if (TextUtils.isEmpty(str)) {
            contentValues.put("baseInfo", AppIdData.a(ws.a.a(), i11).f50748b);
        } else {
            contentValues.put("baseInfo", str);
        }
        ws.a.a().getContentResolver().insert(Uri.parse("content://com.transsion.dataservice.provider/bind"), contentValues);
    }

    public final void k(cr.c cVar) {
        if (this.f13725a != 1) {
            a0.a("Failed to connect to DCS service");
            return;
        }
        Cursor cursorQuery = ws.a.a().getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/property"), null, "prop_key = ?", new String[]{cVar.f62790a}, null);
        if (cursorQuery != null) {
            if (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(0);
                AthenaAnalytics.g gVar = cVar.f62791b.get();
                if (gVar != null) {
                    gVar.a(cVar.f62790a, string);
                }
            }
            cursorQuery.close();
        }
    }

    public final void l(String str) {
        if (this.f13725a == 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("trackObject", str);
            ws.a.a().getContentResolver().insert(Uri.parse("content://com.transsion.dataservice.provider/track"), contentValues);
            return;
        }
        a0.a("Failed to connect to DCS service");
        long j11 = this.f13728d + 1;
        this.f13728d = j11;
        long j12 = 20;
        if (j11 % j12 == 0 && j11 / j12 <= 5 && j0.t(ws.a.a())) {
            m();
        }
    }

    public final void m() {
        Context contextA = ws.a.a();
        Cursor cursorQuery = contextA.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/authorize"), null, "pkg = ?", new String[]{contextA.getPackageName()}, null);
        if (cursorQuery != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DCS authorize ");
            sb2.append(cursorQuery.getCount() == 1 ? "enable" : "disable");
            a0.a(sb2.toString());
            if (cursorQuery.getCount() == 1) {
                this.f13725a = 1;
            } else {
                this.f13725a = 2;
            }
            cursorQuery.close();
        }
    }
}
