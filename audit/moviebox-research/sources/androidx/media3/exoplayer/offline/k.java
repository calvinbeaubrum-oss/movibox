package androidx.media3.exoplayer.offline;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.R$string;
import com.vungle.warren.error.VungleException;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationCompat.m f10911a;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class a {
        @SuppressLint({"WrongConstant"})
        public static void a(NotificationCompat.m mVar) {
            mVar.x(1);
        }
    }

    public k(Context context, String str) {
        this.f10911a = new NotificationCompat.m(context.getApplicationContext(), str);
    }

    public final Notification a(Context context, int i11, @Nullable PendingIntent pendingIntent, @Nullable String str, @StringRes int i12, int i13, int i14, boolean z11, boolean z12, boolean z13) {
        this.f10911a.K(i11);
        this.f10911a.r(i12 == 0 ? null : context.getResources().getString(i12));
        this.f10911a.p(pendingIntent);
        this.f10911a.M(str != null ? new NotificationCompat.k().q(str) : null);
        this.f10911a.I(i13, i14, z11);
        this.f10911a.F(z12);
        this.f10911a.J(z13);
        if (u0.f81838a >= 31) {
            a.a(this.f10911a);
        }
        return this.f10911a.c();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0028  */
    /* JADX WARN: Code duplicated, block: B:17:0x0032  */
    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    /* JADX WARN: Code duplicated, block: B:21:0x0040  */
    /* JADX WARN: Code duplicated, block: B:42:0x0071  */
    /* JADX WARN: Code duplicated, block: B:44:0x0075  */
    /* JADX WARN: Code duplicated, block: B:49:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    public Notification b(Context context, int i11, @Nullable PendingIntent pendingIntent, @Nullable String str, List<c> list, int i12) {
        boolean z11;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z12;
        float fB;
        boolean z13;
        float f11 = 0.0f;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        int i17 = 0;
        boolean z19 = true;
        for (int i18 = 0; i18 < list.size(); i18++) {
            c cVar = list.get(i18);
            int i19 = cVar.f10902b;
            if (i19 == 0) {
                z16 = true;
            } else if (i19 == 2) {
                fB = cVar.b();
                if (fB != -1.0f) {
                    f11 += fB;
                    z19 = false;
                }
                if (cVar.a() > 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z17 |= z13;
                i17++;
                z15 = true;
            } else if (i19 == 5) {
                z18 = true;
            } else if (i19 == 7) {
                fB = cVar.b();
                if (fB != -1.0f) {
                    f11 += fB;
                    z19 = false;
                }
                if (cVar.a() > 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z17 |= z13;
                i17++;
                z15 = true;
            }
        }
        if (!z15) {
            if (z16 && i12 != 0) {
                i13 = (i12 & 2) != 0 ? R$string.exo_download_paused_for_wifi : (i12 & 1) != 0 ? R$string.exo_download_paused_for_network : R$string.exo_download_paused;
                z11 = false;
            } else if (z18) {
                i14 = R$string.exo_download_removing;
            } else {
                z11 = true;
                i13 = 0;
            }
            if (z11) {
                i15 = 0;
                i16 = 0;
                z12 = false;
            } else if (z15) {
                int i21 = (int) (f11 / i17);
                if (z19 && z17) {
                    z14 = true;
                }
                i16 = i21;
                z12 = z14;
                i15 = 100;
            } else {
                i15 = 100;
                i16 = 0;
                z12 = true;
            }
            return a(context, i11, pendingIntent, str, i13, i15, i16, z12, true, false);
        }
        i14 = R$string.exo_download_downloading;
        i13 = i14;
        z11 = true;
        if (z11) {
            i15 = 0;
            i16 = 0;
            z12 = false;
        } else if (z15) {
            int i22 = (int) (f11 / i17);
            if (z19) {
                z14 = true;
            }
            i16 = i22;
            z12 = z14;
            i15 = 100;
        } else {
            i15 = 100;
            i16 = 0;
            z12 = true;
        }
        return a(context, i11, pendingIntent, str, i13, i15, i16, z12, true, false);
    }
}
