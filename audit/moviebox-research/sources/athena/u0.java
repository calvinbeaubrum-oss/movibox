package athena;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class u0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static u0 f13750g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f13751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f13753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13755e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f13756f;

    public u0(Context context) {
        this.f13753c = context;
    }

    public static u0 b(Context context) {
        if (f13750g == null) {
            f13750g = new u0(context);
        }
        return f13750g;
    }

    public long a(long j11, long j12) {
        if (!this.f13754d) {
            return j11;
        }
        t tVar = this.f13751a;
        return (tVar.f13747a + j12) - tVar.f13748b;
    }

    public String c() {
        return this.f13752b;
    }

    public void d(cr.a aVar) {
        if (!this.f13754d) {
            if (TextUtils.isEmpty(this.f13752b)) {
                return;
            }
            aVar.j(this.f13752b);
        } else {
            long jG = this.f13751a.f13747a + (aVar.g() - this.f13751a.f13748b);
            if (jG < 1633017600000L) {
                jG = aVar.i();
            }
            aVar.r(jG);
        }
    }

    public void e(boolean z11) {
        this.f13756f = z11;
        if (z11) {
            this.f13755e = SystemClock.elapsedRealtime();
        }
    }

    public boolean f(long j11) {
        this.f13756f = false;
        this.f13755e = -1L;
        if (j11 > 1633017600000L) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f13751a = new t(j11, SystemClock.elapsedRealtime(), this.f13752b);
            if (Math.abs(jCurrentTimeMillis - j11) > TTAdConstant.AD_MAX_EVENT_TIME) {
                this.f13754d = true;
            }
            try {
                if (!TextUtils.isEmpty(this.f13752b)) {
                    m0 m0VarA = m0.a(this.f13753c);
                    t tVar = this.f13751a;
                    tVar.getClass();
                    m0VarA.g("base_time", new JSONObject().put("serverTime", tVar.f13747a).put("elapsedRealtime", tVar.f13748b).put("bootId", tVar.f13749c).toString());
                }
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
            }
        } else {
            this.f13751a = new t(System.currentTimeMillis(), SystemClock.elapsedRealtime(), this.f13752b);
            this.f13754d = false;
        }
        return this.f13754d;
    }

    public long g() {
        t tVar = this.f13751a;
        if (tVar != null) {
            return tVar.f13747a - tVar.f13748b;
        }
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:66:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public void h() throws Throwable {
        Exception e11;
        FileInputStream fileInputStream;
        String strTrim;
        try {
            String strI = m0.a(this.f13753c).i("base_time");
            a0.a("baseTimeJs = " + strI);
            if (!TextUtils.isEmpty(strI)) {
                this.f13751a = new t(strI);
            }
        } catch (Exception e12) {
            a0.c(Log.getStackTraceString(e12));
        }
        String str = j0.f13693a;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File("/proc/sys/kernel/random/boot_id"));
                try {
                    byte[] bArr = new byte[1024];
                    int i11 = fileInputStream.read(bArr);
                    if (i11 > 0) {
                        strTrim = new String(bArr, 0, i11).trim();
                        try {
                            fileInputStream.close();
                        } catch (IOException e13) {
                            a0.c(Log.getStackTraceString(e13));
                        }
                    } else {
                        fileInputStream.close();
                        strTrim = null;
                    }
                } catch (Exception e14) {
                    e11 = e14;
                    try {
                        a0.c(Log.getStackTraceString(e11));
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        strTrim = null;
                        this.f13752b = strTrim;
                        if (this.f13751a != null) {
                            return;
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e15) {
                                a0.c(Log.getStackTraceString(e15));
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e16) {
                a0.c(Log.getStackTraceString(e16));
            }
        } catch (Exception e17) {
            e11 = e17;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        this.f13752b = strTrim;
        if (this.f13751a != null || TextUtils.isEmpty(strTrim)) {
            return;
        }
        if (!this.f13752b.equals(this.f13751a.f13749c)) {
            this.f13751a = null;
            m0.a(this.f13753c).g("base_time", "");
        } else {
            if (Math.abs((this.f13751a.f13747a + (SystemClock.elapsedRealtime() - this.f13751a.f13748b)) - System.currentTimeMillis()) > TTAdConstant.AD_MAX_EVENT_TIME) {
                this.f13754d = true;
            }
        }
    }

    public boolean i() {
        return this.f13756f;
    }

    public boolean j() {
        if (this.f13755e > 0 && SystemClock.elapsedRealtime() - this.f13755e > ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
            return false;
        }
        t tVar = this.f13751a;
        return tVar == null || !TextUtils.equals(tVar.f13749c, this.f13752b);
    }
}
