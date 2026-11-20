package androidx.media3.exoplayer.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.MotionEventCompat;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.t0;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.x2;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.Worker;
import com.vungle.warren.error.VungleException;
import java.nio.ByteBuffer;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;
import z3.j0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends MediaCodecRenderer implements p.b {

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final int[] f11634m1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static boolean f11635n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static boolean f11636o1;
    public final Context H0;
    public final g0 I0;
    public final f0.a J0;
    public final int K0;
    public final boolean L0;
    public final p M0;
    public final p.a N0;
    public c O0;
    public boolean P0;
    public boolean Q0;

    @Nullable
    public Surface R0;

    @Nullable
    public z3.e0 S0;

    @Nullable
    public PlaceholderSurface T0;
    public boolean U0;
    public int V0;
    public long W0;
    public int X0;
    public int Y0;
    public int Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public long f11637a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f11638b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public long f11639c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public t0 f11640d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    @Nullable
    public t0 f11641e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public boolean f11642f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f11643g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f11644h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public int f11645i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    @Nullable
    public d f11646j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    @Nullable
    public o f11647k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    @Nullable
    public VideoSink f11648l1;

    /* JADX INFO: compiled from: source.java */
    public class a implements VideoSink.a {
        public a() {
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.a
        public void a(VideoSink videoSink) {
            z3.a.i(j.this.R0);
            j.this.V1();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.a
        public void b(VideoSink videoSink, t0 t0Var) {
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.a
        public void c(VideoSink videoSink) {
            j.this.n2(0, 1);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static final class b {
        public static boolean a(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null || !display.isHdr()) {
                return false;
            }
            for (int i11 : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i11 == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11652c;

        public c(int i11, int i12, int i13) {
            this.f11650a = i11;
            this.f11651b = i12;
            this.f11652c = i13;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public final class d implements androidx.media3.exoplayer.mediacodec.c.InterfaceC0102c, Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f11653a;

        public d(androidx.media3.exoplayer.mediacodec.c cVar) {
            Handler handlerB = u0.B(this);
            this.f11653a = handlerB;
            cVar.m(this, handlerB);
        }

        @Override // androidx.media3.exoplayer.mediacodec.c.InterfaceC0102c
        public void a(androidx.media3.exoplayer.mediacodec.c cVar, long j11, long j12) {
            if (u0.f81838a >= 30) {
                b(j11);
            } else {
                this.f11653a.sendMessageAtFrontOfQueue(Message.obtain(this.f11653a, 0, (int) (j11 >> 32), (int) j11));
            }
        }

        public final void b(long j11) {
            j jVar = j.this;
            if (this != jVar.f11646j1 || jVar.l0() == null) {
                return;
            }
            if (j11 == Long.MAX_VALUE) {
                j.this.X1();
                return;
            }
            try {
                j.this.W1(j11);
            } catch (ExoPlaybackException e11) {
                j.this.h1(e11);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(u0.y1(message.arg1, message.arg2));
            return true;
        }
    }

    public j(Context context, androidx.media3.exoplayer.mediacodec.c.b bVar, androidx.media3.exoplayer.mediacodec.f fVar, long j11, boolean z11, @Nullable Handler handler, @Nullable f0 f0Var, int i11) {
        this(context, bVar, fVar, j11, z11, handler, f0Var, i11, 30.0f);
    }

    public j(Context context, androidx.media3.exoplayer.mediacodec.c.b bVar, androidx.media3.exoplayer.mediacodec.f fVar, long j11, boolean z11, @Nullable Handler handler, @Nullable f0 f0Var, int i11, float f11) {
        this(context, bVar, fVar, j11, z11, handler, f0Var, i11, f11, null);
    }

    public j(Context context, androidx.media3.exoplayer.mediacodec.c.b bVar, androidx.media3.exoplayer.mediacodec.f fVar, long j11, boolean z11, @Nullable Handler handler, @Nullable f0 f0Var, int i11, float f11, @Nullable g0 g0Var) {
        super(2, bVar, fVar, z11, f11);
        this.K0 = i11;
        Context applicationContext = context.getApplicationContext();
        this.H0 = applicationContext;
        this.J0 = new f0.a(handler, f0Var);
        g0 g0VarC = g0Var == null ? new f.b(applicationContext).c() : g0Var;
        if (g0VarC.f() == null) {
            g0VarC.a(new p(applicationContext, this, j11));
        }
        this.I0 = g0VarC;
        this.M0 = (p) z3.a.i(g0VarC.f());
        this.N0 = new p.a();
        this.L0 = A1();
        this.V0 = 1;
        this.f11640d1 = t0.f9443e;
        this.f11645i1 = 0;
        this.f11641e1 = null;
    }

    public static boolean A1() {
        return "NVIDIA".equals(u0.f81840c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:49:0x0097  */
    /* JADX WARN: Code duplicated, block: B:6:0x001b  */
    /* JADX WARN: Code duplicated, block: B:91:0x0111  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean C1() {
        int i11 = u0.f81838a;
        byte b11 = 7;
        if (i11 <= 28) {
            String str = u0.f81839b;
            str.hashCode();
            switch (str) {
                case "dangal":
                case "dangalFHD":
                case "dangalUHD":
                case "oneday":
                case "aquaman":
                case "magnolia":
                case "once":
                case "machuca":
                    return true;
            }
        }
        if (i11 <= 27 && "HWEML".equals(u0.f81839b)) {
            return true;
        }
        String str2 = u0.f81841d;
        str2.hashCode();
        switch (str2) {
            case "AFTJMST12":
            case "AFTKMST12":
            case "AFTA":
            case "AFTN":
            case "AFTR":
            case "AFTEU011":
            case "AFTEU014":
            case "AFTSO001":
            case "AFTEUFF014":
                return true;
            default:
                if (i11 <= 26) {
                    String str3 = u0.f81839b;
                    str3.hashCode();
                    switch (str3.hashCode()) {
                        case -2144781245:
                            if (!str3.equals("GIONEE_SWW1609")) {
                                b11 = -1;
                            } else {
                                b11 = 0;
                            }
                            break;
                        case -2144781185:
                            if (!str3.equals("GIONEE_SWW1627")) {
                                b11 = -1;
                            } else {
                                b11 = 1;
                            }
                            break;
                        case -2144781160:
                            if (!str3.equals("GIONEE_SWW1631")) {
                                b11 = -1;
                            } else {
                                b11 = 2;
                            }
                            break;
                        case -2097309513:
                            if (!str3.equals("K50a40")) {
                                b11 = -1;
                            } else {
                                b11 = 3;
                            }
                            break;
                        case -2022874474:
                            if (!str3.equals("CP8676_I02")) {
                                b11 = -1;
                            } else {
                                b11 = 4;
                            }
                            break;
                        case -1978993182:
                            if (!str3.equals("NX541J")) {
                                b11 = -1;
                            } else {
                                b11 = 5;
                            }
                            break;
                        case -1978990237:
                            if (!str3.equals("NX573J")) {
                                b11 = -1;
                            } else {
                                b11 = 6;
                            }
                            break;
                        case -1936688988:
                            if (!str3.equals("PGN528")) {
                                b11 = -1;
                            }
                            break;
                        case -1936688066:
                            if (!str3.equals("PGN610")) {
                                b11 = -1;
                            } else {
                                b11 = 8;
                            }
                            break;
                        case -1936688065:
                            if (!str3.equals("PGN611")) {
                                b11 = -1;
                            } else {
                                b11 = 9;
                            }
                            break;
                        case -1931988508:
                            if (!str3.equals("AquaPowerM")) {
                                b11 = -1;
                            } else {
                                b11 = 10;
                            }
                            break;
                        case -1885099851:
                            if (!str3.equals("RAIJIN")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.VT;
                            }
                            break;
                        case -1696512866:
                            if (!str3.equals("XT1663")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.FF;
                            }
                            break;
                        case -1680025915:
                            if (!str3.equals("ComioS1")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.CR;
                            }
                            break;
                        case -1615810839:
                            if (!str3.equals("Phantom6")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.SO;
                            }
                            break;
                        case -1600724499:
                            if (!str3.equals("pacificrim")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.SI;
                            }
                            break;
                        case -1554255044:
                            if (!str3.equals("vernee_M5")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.DLE;
                            }
                            break;
                        case -1481772737:
                            if (!str3.equals("panell_dl")) {
                                b11 = -1;
                            } else {
                                b11 = 17;
                            }
                            break;
                        case -1481772730:
                            if (!str3.equals("panell_ds")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.DC2;
                            }
                            break;
                        case -1481772729:
                            if (!str3.equals("panell_dt")) {
                                b11 = -1;
                            } else {
                                b11 = 19;
                            }
                            break;
                        case -1320080169:
                            if (!str3.equals("GiONEE_GBL7319")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.DC4;
                            }
                            break;
                        case -1217592143:
                            if (!str3.equals("BRAVIA_ATV2")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.NAK;
                            }
                            break;
                        case -1180384755:
                            if (!str3.equals("iris60")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.SYN;
                            }
                            break;
                        case -1139198265:
                            if (!str3.equals("Slate_Pro")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.ETB;
                            }
                            break;
                        case -1052835013:
                            if (!str3.equals("namath")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.CAN;
                            }
                            break;
                        case -993250464:
                            if (!str3.equals("A10-70F")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.EM;
                            }
                            break;
                        case -993250458:
                            if (!str3.equals("A10-70L")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.SUB;
                            }
                            break;
                        case -965403638:
                            if (!str3.equals("s905x018")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.ESC;
                            }
                            break;
                        case -958336948:
                            if (!str3.equals("ELUGA_Ray_X")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.FS;
                            }
                            break;
                        case -879245230:
                            if (!str3.equals("tcl_eu")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.GS;
                            }
                            break;
                        case -842500323:
                            if (!str3.equals("nicklaus_f")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.RS;
                            }
                            break;
                        case -821392978:
                            if (!str3.equals("A7000-a")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.US;
                            }
                            break;
                        case -797483286:
                            if (!str3.equals("SVP-DTV15")) {
                                b11 = -1;
                            } else {
                                b11 = 32;
                            }
                            break;
                        case -794946968:
                            if (!str3.equals("watson")) {
                                b11 = -1;
                            } else {
                                b11 = 33;
                            }
                            break;
                        case -788334647:
                            if (!str3.equals("whyred")) {
                                b11 = -1;
                            } else {
                                b11 = 34;
                            }
                            break;
                        case -782144577:
                            if (!str3.equals("OnePlus5T")) {
                                b11 = -1;
                            } else {
                                b11 = 35;
                            }
                            break;
                        case -575125681:
                            if (!str3.equals("GiONEE_CBL7513")) {
                                b11 = -1;
                            } else {
                                b11 = 36;
                            }
                            break;
                        case -521118391:
                            if (!str3.equals("GIONEE_GBL7360")) {
                                b11 = -1;
                            } else {
                                b11 = 37;
                            }
                            break;
                        case -430914369:
                            if (!str3.equals("Pixi4-7_3G")) {
                                b11 = -1;
                            } else {
                                b11 = 38;
                            }
                            break;
                        case -290434366:
                            if (!str3.equals("taido_row")) {
                                b11 = -1;
                            } else {
                                b11 = 39;
                            }
                            break;
                        case -282781963:
                            if (!str3.equals("BLACK-1X")) {
                                b11 = -1;
                            } else {
                                b11 = 40;
                            }
                            break;
                        case -277133239:
                            if (!str3.equals("Z12_PRO")) {
                                b11 = -1;
                            } else {
                                b11 = 41;
                            }
                            break;
                        case -173639913:
                            if (!str3.equals("ELUGA_A3_Pro")) {
                                b11 = -1;
                            } else {
                                b11 = 42;
                            }
                            break;
                        case -56598463:
                            if (!str3.equals("woods_fn")) {
                                b11 = -1;
                            } else {
                                b11 = 43;
                            }
                            break;
                        case 2126:
                            if (!str3.equals("C1")) {
                                b11 = -1;
                            } else {
                                b11 = 44;
                            }
                            break;
                        case 2564:
                            if (!str3.equals("Q5")) {
                                b11 = -1;
                            } else {
                                b11 = 45;
                            }
                            break;
                        case 2715:
                            if (!str3.equals("V1")) {
                                b11 = -1;
                            } else {
                                b11 = 46;
                            }
                            break;
                        case 2719:
                            if (!str3.equals("V5")) {
                                b11 = -1;
                            } else {
                                b11 = 47;
                            }
                            break;
                        case 3091:
                            if (!str3.equals("b5")) {
                                b11 = -1;
                            } else {
                                b11 = 48;
                            }
                            break;
                        case 3483:
                            if (!str3.equals("mh")) {
                                b11 = -1;
                            } else {
                                b11 = 49;
                            }
                            break;
                        case 73405:
                            if (!str3.equals("JGZ")) {
                                b11 = -1;
                            } else {
                                b11 = 50;
                            }
                            break;
                        case 75537:
                            if (!str3.equals("M04")) {
                                b11 = -1;
                            } else {
                                b11 = 51;
                            }
                            break;
                        case 75739:
                            if (!str3.equals("M5c")) {
                                b11 = -1;
                            } else {
                                b11 = 52;
                            }
                            break;
                        case 76779:
                            if (!str3.equals("MX6")) {
                                b11 = -1;
                            } else {
                                b11 = 53;
                            }
                            break;
                        case 78669:
                            if (!str3.equals("P85")) {
                                b11 = -1;
                            } else {
                                b11 = 54;
                            }
                            break;
                        case 79305:
                            if (!str3.equals("PLE")) {
                                b11 = -1;
                            } else {
                                b11 = 55;
                            }
                            break;
                        case 80618:
                            if (!str3.equals("QX1")) {
                                b11 = -1;
                            } else {
                                b11 = 56;
                            }
                            break;
                        case 88274:
                            if (!str3.equals("Z80")) {
                                b11 = -1;
                            } else {
                                b11 = 57;
                            }
                            break;
                        case 98846:
                            if (!str3.equals("cv1")) {
                                b11 = -1;
                            } else {
                                b11 = 58;
                            }
                            break;
                        case 98848:
                            if (!str3.equals("cv3")) {
                                b11 = -1;
                            } else {
                                b11 = 59;
                            }
                            break;
                        case 99329:
                            if (!str3.equals("deb")) {
                                b11 = -1;
                            } else {
                                b11 = 60;
                            }
                            break;
                        case 101481:
                            if (!str3.equals("flo")) {
                                b11 = -1;
                            } else {
                                b11 = 61;
                            }
                            break;
                        case 1513190:
                            if (!str3.equals("1601")) {
                                b11 = -1;
                            } else {
                                b11 = 62;
                            }
                            break;
                        case 1514184:
                            if (!str3.equals("1713")) {
                                b11 = -1;
                            } else {
                                b11 = Utf8.REPLACEMENT_BYTE;
                            }
                            break;
                        case 1514185:
                            if (!str3.equals("1714")) {
                                b11 = -1;
                            } else {
                                b11 = 64;
                            }
                            break;
                        case 2133089:
                            if (!str3.equals("F01H")) {
                                b11 = -1;
                            } else {
                                b11 = 65;
                            }
                            break;
                        case 2133091:
                            if (!str3.equals("F01J")) {
                                b11 = -1;
                            } else {
                                b11 = 66;
                            }
                            break;
                        case 2133120:
                            if (!str3.equals("F02H")) {
                                b11 = -1;
                            } else {
                                b11 = 67;
                            }
                            break;
                        case 2133151:
                            if (!str3.equals("F03H")) {
                                b11 = -1;
                            } else {
                                b11 = 68;
                            }
                            break;
                        case 2133182:
                            if (!str3.equals("F04H")) {
                                b11 = -1;
                            } else {
                                b11 = 69;
                            }
                            break;
                        case 2133184:
                            if (!str3.equals("F04J")) {
                                b11 = -1;
                            } else {
                                b11 = 70;
                            }
                            break;
                        case 2436959:
                            if (!str3.equals("P681")) {
                                b11 = -1;
                            } else {
                                b11 = 71;
                            }
                            break;
                        case 2463773:
                            if (!str3.equals("Q350")) {
                                b11 = -1;
                            } else {
                                b11 = 72;
                            }
                            break;
                        case 2464648:
                            if (!str3.equals("Q427")) {
                                b11 = -1;
                            } else {
                                b11 = 73;
                            }
                            break;
                        case 2689555:
                            if (!str3.equals("XE2X")) {
                                b11 = -1;
                            } else {
                                b11 = 74;
                            }
                            break;
                        case 3154429:
                            if (!str3.equals("fugu")) {
                                b11 = -1;
                            } else {
                                b11 = 75;
                            }
                            break;
                        case 3284551:
                            if (!str3.equals("kate")) {
                                b11 = -1;
                            } else {
                                b11 = 76;
                            }
                            break;
                        case 3351335:
                            if (!str3.equals("mido")) {
                                b11 = -1;
                            } else {
                                b11 = 77;
                            }
                            break;
                        case 3386211:
                            if (!str3.equals("p212")) {
                                b11 = -1;
                            } else {
                                b11 = 78;
                            }
                            break;
                        case 41325051:
                            if (!str3.equals("MEIZU_M5")) {
                                b11 = -1;
                            } else {
                                b11 = 79;
                            }
                            break;
                        case 51349633:
                            if (!str3.equals("601LV")) {
                                b11 = -1;
                            } else {
                                b11 = 80;
                            }
                            break;
                        case 51350594:
                            if (!str3.equals("602LV")) {
                                b11 = -1;
                            } else {
                                b11 = 81;
                            }
                            break;
                        case 55178625:
                            if (!str3.equals("Aura_Note_2")) {
                                b11 = -1;
                            } else {
                                b11 = 82;
                            }
                            break;
                        case 61542055:
                            if (!str3.equals("A1601")) {
                                b11 = -1;
                            } else {
                                b11 = 83;
                            }
                            break;
                        case 65355429:
                            if (!str3.equals("E5643")) {
                                b11 = -1;
                            } else {
                                b11 = 84;
                            }
                            break;
                        case 66214468:
                            if (!str3.equals("F3111")) {
                                b11 = -1;
                            } else {
                                b11 = 85;
                            }
                            break;
                        case 66214470:
                            if (!str3.equals("F3113")) {
                                b11 = -1;
                            } else {
                                b11 = 86;
                            }
                            break;
                        case 66214473:
                            if (!str3.equals("F3116")) {
                                b11 = -1;
                            } else {
                                b11 = 87;
                            }
                            break;
                        case 66215429:
                            if (!str3.equals("F3211")) {
                                b11 = -1;
                            } else {
                                b11 = 88;
                            }
                            break;
                        case 66215431:
                            if (!str3.equals("F3213")) {
                                b11 = -1;
                            } else {
                                b11 = 89;
                            }
                            break;
                        case 66215433:
                            if (!str3.equals("F3215")) {
                                b11 = -1;
                            } else {
                                b11 = 90;
                            }
                            break;
                        case 66216390:
                            if (!str3.equals("F3311")) {
                                b11 = -1;
                            } else {
                                b11 = 91;
                            }
                            break;
                        case 76402249:
                            if (!str3.equals("PRO7S")) {
                                b11 = -1;
                            } else {
                                b11 = 92;
                            }
                            break;
                        case 76404105:
                            if (!str3.equals("Q4260")) {
                                b11 = -1;
                            } else {
                                b11 = 93;
                            }
                            break;
                        case 76404911:
                            if (!str3.equals("Q4310")) {
                                b11 = -1;
                            } else {
                                b11 = 94;
                            }
                            break;
                        case 80963634:
                            if (!str3.equals("V23GB")) {
                                b11 = -1;
                            } else {
                                b11 = 95;
                            }
                            break;
                        case 82882791:
                            if (!str3.equals("X3_HK")) {
                                b11 = -1;
                            } else {
                                b11 = 96;
                            }
                            break;
                        case 98715550:
                            if (!str3.equals("i9031")) {
                                b11 = -1;
                            } else {
                                b11 = 97;
                            }
                            break;
                        case 101370885:
                            if (!str3.equals("l5460")) {
                                b11 = -1;
                            } else {
                                b11 = 98;
                            }
                            break;
                        case 102844228:
                            if (!str3.equals("le_x6")) {
                                b11 = -1;
                            } else {
                                b11 = 99;
                            }
                            break;
                        case 165221241:
                            if (!str3.equals("A2016a40")) {
                                b11 = -1;
                            } else {
                                b11 = 100;
                            }
                            break;
                        case 182191441:
                            if (!str3.equals("CPY83_I00")) {
                                b11 = -1;
                            } else {
                                b11 = 101;
                            }
                            break;
                        case 245388979:
                            if (!str3.equals("marino_f")) {
                                b11 = -1;
                            } else {
                                b11 = 102;
                            }
                            break;
                        case 287431619:
                            if (!str3.equals("griffin")) {
                                b11 = -1;
                            } else {
                                b11 = 103;
                            }
                            break;
                        case 307593612:
                            if (!str3.equals("A7010a48")) {
                                b11 = -1;
                            } else {
                                b11 = 104;
                            }
                            break;
                        case 308517133:
                            if (!str3.equals("A7020a48")) {
                                b11 = -1;
                            } else {
                                b11 = 105;
                            }
                            break;
                        case 316215098:
                            if (!str3.equals("TB3-730F")) {
                                b11 = -1;
                            } else {
                                b11 = 106;
                            }
                            break;
                        case 316215116:
                            if (!str3.equals("TB3-730X")) {
                                b11 = -1;
                            } else {
                                b11 = 107;
                            }
                            break;
                        case 316246811:
                            if (!str3.equals("TB3-850F")) {
                                b11 = -1;
                            } else {
                                b11 = 108;
                            }
                            break;
                        case 316246818:
                            if (!str3.equals("TB3-850M")) {
                                b11 = -1;
                            } else {
                                b11 = 109;
                            }
                            break;
                        case 407160593:
                            if (!str3.equals("Pixi5-10_4G")) {
                                b11 = -1;
                            } else {
                                b11 = 110;
                            }
                            break;
                        case 507412548:
                            if (!str3.equals("QM16XE_U")) {
                                b11 = -1;
                            } else {
                                b11 = 111;
                            }
                            break;
                        case 793982701:
                            if (!str3.equals("GIONEE_WBL5708")) {
                                b11 = -1;
                            } else {
                                b11 = 112;
                            }
                            break;
                        case 794038622:
                            if (!str3.equals("GIONEE_WBL7365")) {
                                b11 = -1;
                            } else {
                                b11 = 113;
                            }
                            break;
                        case 794040393:
                            if (!str3.equals("GIONEE_WBL7519")) {
                                b11 = -1;
                            } else {
                                b11 = 114;
                            }
                            break;
                        case 835649806:
                            if (!str3.equals("manning")) {
                                b11 = -1;
                            } else {
                                b11 = 115;
                            }
                            break;
                        case 917340916:
                            if (!str3.equals("A7000plus")) {
                                b11 = -1;
                            } else {
                                b11 = 116;
                            }
                            break;
                        case 958008161:
                            if (!str3.equals("j2xlteins")) {
                                b11 = -1;
                            } else {
                                b11 = 117;
                            }
                            break;
                        case 1060579533:
                            if (!str3.equals("panell_d")) {
                                b11 = -1;
                            } else {
                                b11 = 118;
                            }
                            break;
                        case 1150207623:
                            if (!str3.equals("LS-5017")) {
                                b11 = -1;
                            } else {
                                b11 = 119;
                            }
                            break;
                        case 1176899427:
                            if (!str3.equals("itel_S41")) {
                                b11 = -1;
                            } else {
                                b11 = 120;
                            }
                            break;
                        case 1280332038:
                            if (!str3.equals("hwALE-H")) {
                                b11 = -1;
                            } else {
                                b11 = 121;
                            }
                            break;
                        case 1306947716:
                            if (!str3.equals("EverStar_S")) {
                                b11 = -1;
                            } else {
                                b11 = 122;
                            }
                            break;
                        case 1349174697:
                            if (!str3.equals("htc_e56ml_dtul")) {
                                b11 = -1;
                            } else {
                                b11 = 123;
                            }
                            break;
                        case 1522194893:
                            if (!str3.equals("woods_f")) {
                                b11 = -1;
                            } else {
                                b11 = 124;
                            }
                            break;
                        case 1691543273:
                            if (!str3.equals("CPH1609")) {
                                b11 = -1;
                            } else {
                                b11 = 125;
                            }
                            break;
                        case 1691544261:
                            if (!str3.equals("CPH1715")) {
                                b11 = -1;
                            } else {
                                b11 = 126;
                            }
                            break;
                        case 1709443163:
                            if (!str3.equals("iball8735_9806")) {
                                b11 = -1;
                            } else {
                                b11 = Ascii.DEL;
                            }
                            break;
                        case 1865889110:
                            if (!str3.equals("santoni")) {
                                b11 = -1;
                            } else {
                                b11 = 128;
                            }
                            break;
                        case 1906253259:
                            if (!str3.equals("PB2-670M")) {
                                b11 = -1;
                            } else {
                                b11 = 129;
                            }
                            break;
                        case 1977196784:
                            if (!str3.equals("Infinix-X572")) {
                                b11 = -1;
                            } else {
                                b11 = 130;
                            }
                            break;
                        case 2006372676:
                            if (!str3.equals("BRAVIA_ATV3_4K")) {
                                b11 = -1;
                            } else {
                                b11 = 131;
                            }
                            break;
                        case 2019281702:
                            if (!str3.equals("DM-01K")) {
                                b11 = -1;
                            } else {
                                b11 = 132;
                            }
                            break;
                        case 2029784656:
                            if (!str3.equals("HWBLN-H")) {
                                b11 = -1;
                            } else {
                                b11 = 133;
                            }
                            break;
                        case 2030379515:
                            if (!str3.equals("HWCAM-H")) {
                                b11 = -1;
                            } else {
                                b11 = 134;
                            }
                            break;
                        case 2033393791:
                            if (!str3.equals("ASUS_X00AD_2")) {
                                b11 = -1;
                            } else {
                                b11 = 135;
                            }
                            break;
                        case 2047190025:
                            if (!str3.equals("ELUGA_Note")) {
                                b11 = -1;
                            } else {
                                b11 = 136;
                            }
                            break;
                        case 2047252157:
                            if (!str3.equals("ELUGA_Prim")) {
                                b11 = -1;
                            } else {
                                b11 = 137;
                            }
                            break;
                        case 2048319463:
                            if (!str3.equals("HWVNS-H")) {
                                b11 = -1;
                            } else {
                                b11 = 138;
                            }
                            break;
                        case 2048855701:
                            if (!str3.equals("HWWAS-H")) {
                                b11 = -1;
                            } else {
                                b11 = 139;
                            }
                            break;
                        default:
                            b11 = -1;
                            break;
                    }
                    switch (b11) {
                        default:
                            str2.hashCode();
                            if (!str2.equals("JSN-L21")) {
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                        case 30:
                        case VungleException.WEB_CRASH /* 31 */:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                        case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                        case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                        case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                        case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                        case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                        case 66:
                        case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 82:
                        case 83:
                        case 84:
                        case 85:
                        case ModuleDescriptor.MODULE_VERSION /* 86 */:
                        case 87:
                        case 88:
                        case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                        case 90:
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                        case 95:
                        case 96:
                        case 97:
                        case 98:
                        case 99:
                        case 100:
                        case 101:
                        case 102:
                        case Worker.WHAT_SYNC_DATA /* 103 */:
                        case 104:
                        case 105:
                        case 106:
                        case 107:
                        case 108:
                        case 109:
                        case Worker.WHAT_QUIT /* 110 */:
                        case 111:
                        case 112:
                        case 113:
                        case 114:
                        case 115:
                        case 116:
                        case 117:
                        case 118:
                        case 119:
                        case 120:
                        case 121:
                        case 122:
                        case 123:
                        case 124:
                        case 125:
                        case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                        case 127:
                        case 128:
                        case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                        case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                        case 131:
                        case 132:
                        case 133:
                        case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
                        case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
                        case 136:
                        case 137:
                        case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                        case 139:
                            return true;
                    }
                }
                return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x0045  */
    public static int D1(androidx.media3.exoplayer.mediacodec.d dVar, androidx.media3.common.y yVar) {
        int iIntValue;
        int i11 = yVar.f9506r;
        int i12 = yVar.f9507s;
        if (i11 == -1 || i12 == -1) {
            return -1;
        }
        String str = (String) z3.a.e(yVar.f9501m);
        if ("video/dolby-vision".equals(str)) {
            Pair<Integer, Integer> pairR = MediaCodecUtil.r(yVar);
            str = (pairR == null || !((iIntValue = ((Integer) pairR.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? MimeTypes.VIDEO_H265 : MimeTypes.VIDEO_H264;
        }
        str.hashCode();
        switch (str) {
            case "video/3gpp":
            case "video/av01":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                return I1(i11 * i12, 2);
            case "video/hevc":
                return Math.max(2097152, I1(i11 * i12, 2));
            case "video/avc":
                String str2 = u0.f81841d;
                if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(u0.f81840c) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && dVar.f10762g)))) {
                    return -1;
                }
                return I1(u0.k(i11, 16) * u0.k(i12, 16) * 256, 2);
            case "video/x-vnd.on2.vp9":
                return I1(i11 * i12, 4);
            default:
                return -1;
        }
    }

    @Nullable
    public static Point E1(androidx.media3.exoplayer.mediacodec.d dVar, androidx.media3.common.y yVar) {
        int i11 = yVar.f9507s;
        int i12 = yVar.f9506r;
        boolean z11 = i11 > i12;
        int i13 = z11 ? i11 : i12;
        if (z11) {
            i11 = i12;
        }
        float f11 = i11 / i13;
        for (int i14 : f11634m1) {
            int i15 = (int) (i14 * f11);
            if (i14 <= i13 || i15 <= i11) {
                break;
            }
            if (u0.f81838a >= 21) {
                int i16 = z11 ? i15 : i14;
                if (!z11) {
                    i14 = i15;
                }
                Point pointB = dVar.b(i16, i14);
                float f12 = yVar.f9508t;
                if (pointB != null && dVar.v(pointB.x, pointB.y, f12)) {
                    return pointB;
                }
            } else {
                try {
                    int iK = u0.k(i14, 16) * 16;
                    int iK2 = u0.k(i15, 16) * 16;
                    if (iK * iK2 <= MediaCodecUtil.P()) {
                        int i17 = z11 ? iK2 : iK;
                        if (!z11) {
                            iK = iK2;
                        }
                        return new Point(i17, iK);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    public static List<androidx.media3.exoplayer.mediacodec.d> G1(Context context, androidx.media3.exoplayer.mediacodec.f fVar, androidx.media3.common.y yVar, boolean z11, boolean z12) throws MediaCodecUtil.DecoderQueryException {
        String str = yVar.f9501m;
        if (str == null) {
            return ImmutableList.of();
        }
        if (u0.f81838a >= 26 && "video/dolby-vision".equals(str) && !b.a(context)) {
            List<androidx.media3.exoplayer.mediacodec.d> listN = MediaCodecUtil.n(fVar, yVar, z11, z12);
            if (!listN.isEmpty()) {
                return listN;
            }
        }
        return MediaCodecUtil.v(fVar, yVar, z11, z12);
    }

    public static int H1(androidx.media3.exoplayer.mediacodec.d dVar, androidx.media3.common.y yVar) {
        if (yVar.f9502n == -1) {
            return D1(dVar, yVar);
        }
        int size = yVar.f9503o.size();
        int length = 0;
        for (int i11 = 0; i11 < size; i11++) {
            length += yVar.f9503o.get(i11).length;
        }
        return yVar.f9502n + length;
    }

    public static int I1(int i11, int i12) {
        return (i11 * 3) / (i12 * 2);
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static void d2(androidx.media3.exoplayer.mediacodec.c cVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        cVar.b(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.media3.exoplayer.video.p] */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.media3.exoplayer.video.g0] */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.media3.exoplayer.m, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.video.j] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r6v8, types: [androidx.media3.exoplayer.video.PlaceholderSurface] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void e2(@Nullable Object obj) throws ExoPlaybackException {
        ?? NewInstanceV17;
        Surface surface;
        if (obj instanceof Surface) {
            surface = (Surface) obj;
        } else {
            NewInstanceV17 = 0;
        }
        if (NewInstanceV17 == 0) {
            PlaceholderSurface placeholderSurface = this.T0;
            if (placeholderSurface != null) {
                NewInstanceV17 = surface;
                NewInstanceV17 = placeholderSurface;
            } else {
                androidx.media3.exoplayer.mediacodec.d dVarN0 = n0();
                if (dVarN0 != null && l2(dVarN0)) {
                    NewInstanceV17 = surface;
                    NewInstanceV17 = PlaceholderSurface.newInstanceV17(this.H0, dVarN0.f10762g);
                    this.T0 = NewInstanceV17;
                }
            }
        }
        NewInstanceV17 = surface;
        NewInstanceV17 = surface;
        NewInstanceV17 = surface;
        if (this.R0 == NewInstanceV17) {
            if (NewInstanceV17 == 0 || NewInstanceV17 == this.T0) {
                return;
            }
            R1();
            Q1();
            return;
        }
        this.R0 = NewInstanceV17;
        this.M0.q(NewInstanceV17);
        this.U0 = false;
        int state = getState();
        androidx.media3.exoplayer.mediacodec.c cVarL0 = l0();
        if (cVarL0 != null && !this.I0.isInitialized()) {
            if (u0.f81838a < 23 || NewInstanceV17 == 0 || this.P0) {
                Y0();
                H0();
            } else {
                f2(cVarL0, NewInstanceV17);
            }
        }
        if (NewInstanceV17 == 0 || NewInstanceV17 == this.T0) {
            this.f11641e1 = null;
            if (this.I0.isInitialized()) {
                this.I0.i();
            }
        } else {
            R1();
            if (state == 2) {
                this.M0.e();
            }
            if (this.I0.isInitialized()) {
                this.I0.j(NewInstanceV17, z3.e0.f81770c);
            }
        }
        T1();
    }

    public static boolean x1() {
        return u0.f81838a >= 21;
    }

    @RequiresApi(21)
    public static void z1(MediaFormat mediaFormat, int i11) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m
    public void A(boolean z11, boolean z12) throws ExoPlaybackException {
        super.A(z11, z12);
        boolean z13 = s().f11787b;
        z3.a.g((z13 && this.f11645i1 == 0) ? false : true);
        if (this.f11644h1 != z13) {
            this.f11644h1 = z13;
            Y0();
        }
        this.J0.o(this.C0);
        this.M0.h(z12);
    }

    @Override // androidx.media3.exoplayer.m
    public void B() {
        super.B();
        z3.d dVarR = r();
        this.M0.o(dVarR);
        this.I0.d(dVarR);
    }

    public void B1(androidx.media3.exoplayer.mediacodec.c cVar, int i11, long j11) {
        j0.a("dropVideoBuffer");
        cVar.k(i11, false);
        j0.c();
        n2(0, 1);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m
    public void C(long j11, boolean z11) throws ExoPlaybackException {
        VideoSink videoSink = this.f11648l1;
        if (videoSink != null) {
            videoSink.flush();
        }
        super.C(j11, z11);
        if (this.I0.isInitialized()) {
            this.I0.l(t0());
        }
        this.M0.m();
        if (z11) {
            this.M0.e();
        }
        T1();
        this.Y0 = 0;
    }

    @Override // androidx.media3.exoplayer.m
    public void D() {
        super.D();
        if (this.I0.isInitialized()) {
            this.I0.release();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m
    @TargetApi(17)
    public void F() {
        try {
            super.F();
        } finally {
            this.f11643g1 = false;
            if (this.T0 != null) {
                Z1();
            }
        }
    }

    public c F1(androidx.media3.exoplayer.mediacodec.d dVar, androidx.media3.common.y yVar, androidx.media3.common.y[] yVarArr) {
        int iD1;
        int iMax = yVar.f9506r;
        int iMax2 = yVar.f9507s;
        int iH1 = H1(dVar, yVar);
        if (yVarArr.length == 1) {
            if (iH1 != -1 && (iD1 = D1(dVar, yVar)) != -1) {
                iH1 = Math.min((int) (iH1 * 1.5f), iD1);
            }
            return new c(iMax, iMax2, iH1);
        }
        int length = yVarArr.length;
        boolean z11 = false;
        for (int i11 = 0; i11 < length; i11++) {
            androidx.media3.common.y yVarI = yVarArr[i11];
            if (yVar.f9513y != null && yVarI.f9513y == null) {
                yVarI = yVarI.b().N(yVar.f9513y).I();
            }
            if (dVar.e(yVar, yVarI).f10792d != 0) {
                int i12 = yVarI.f9506r;
                z11 |= i12 == -1 || yVarI.f9507s == -1;
                iMax = Math.max(iMax, i12);
                iMax2 = Math.max(iMax2, yVarI.f9507s);
                iH1 = Math.max(iH1, H1(dVar, yVarI));
            }
        }
        if (z11) {
            z3.o.h("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointE1 = E1(dVar, yVar);
            if (pointE1 != null) {
                iMax = Math.max(iMax, pointE1.x);
                iMax2 = Math.max(iMax2, pointE1.y);
                iH1 = Math.max(iH1, D1(dVar, yVar.b().r0(iMax).V(iMax2).I()));
                z3.o.h("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new c(iMax, iMax2, iH1);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m
    public void G() {
        super.G();
        this.X0 = 0;
        this.W0 = r().elapsedRealtime();
        this.f11637a1 = 0L;
        this.f11638b1 = 0;
        this.M0.k();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m
    public void H() {
        L1();
        N1();
        this.M0.l();
        super.H();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void J0(Exception exc) {
        z3.o.d("MediaCodecVideoRenderer", "Video codec error", exc);
        this.J0.C(exc);
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat J1(androidx.media3.common.y yVar, String str, c cVar, float f11, boolean z11, int i11) {
        Pair<Integer, Integer> pairR;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", yVar.f9506r);
        mediaFormat.setInteger("height", yVar.f9507s);
        z3.r.e(mediaFormat, yVar.f9503o);
        z3.r.c(mediaFormat, "frame-rate", yVar.f9508t);
        z3.r.d(mediaFormat, "rotation-degrees", yVar.f9509u);
        z3.r.b(mediaFormat, yVar.f9513y);
        if ("video/dolby-vision".equals(yVar.f9501m) && (pairR = MediaCodecUtil.r(yVar)) != null) {
            z3.r.d(mediaFormat, Scopes.PROFILE, ((Integer) pairR.first).intValue());
        }
        mediaFormat.setInteger("max-width", cVar.f11650a);
        mediaFormat.setInteger("max-height", cVar.f11651b);
        z3.r.d(mediaFormat, "max-input-size", cVar.f11652c);
        if (u0.f81838a >= 23) {
            mediaFormat.setInteger(TrackingKey.PRIORITY, 0);
            if (f11 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f11);
            }
        }
        if (z11) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i11 != 0) {
            z1(mediaFormat, i11);
        }
        return mediaFormat;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void K0(String str, androidx.media3.exoplayer.mediacodec.c.a aVar, long j11, long j12) {
        this.J0.k(str, j11, j12);
        this.P0 = y1(str);
        this.Q0 = ((androidx.media3.exoplayer.mediacodec.d) z3.a.e(n0())).o();
        T1();
    }

    public boolean K1(long j11, boolean z11) throws ExoPlaybackException {
        int iM = M(j11);
        if (iM == 0) {
            return false;
        }
        if (z11) {
            androidx.media3.exoplayer.n nVar = this.C0;
            nVar.f10775d += iM;
            nVar.f10777f += this.Z0;
        } else {
            this.C0.f10781j++;
            n2(iM, this.Z0);
        }
        i0();
        VideoSink videoSink = this.f11648l1;
        if (videoSink != null) {
            videoSink.flush();
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void L0(String str) {
        this.J0.l(str);
    }

    public final void L1() {
        if (this.X0 > 0) {
            long jElapsedRealtime = r().elapsedRealtime();
            this.J0.n(this.X0, jElapsedRealtime - this.W0);
            this.X0 = 0;
            this.W0 = jElapsedRealtime;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @Nullable
    public androidx.media3.exoplayer.o M0(t1 t1Var) throws ExoPlaybackException {
        androidx.media3.exoplayer.o oVarM0 = super.M0(t1Var);
        this.J0.p((androidx.media3.common.y) z3.a.e(t1Var.f11382b), oVarM0);
        return oVarM0;
    }

    public final void M1() {
        if (!this.M0.i() || this.R0 == null) {
            return;
        }
        V1();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void N0(androidx.media3.common.y yVar, @Nullable MediaFormat mediaFormat) {
        int integer;
        int integer2;
        androidx.media3.exoplayer.mediacodec.c cVarL0 = l0();
        if (cVarL0 != null) {
            cVarL0.setVideoScalingMode(this.V0);
        }
        int i11 = 0;
        if (this.f11644h1) {
            integer = yVar.f9506r;
            integer2 = yVar.f9507s;
        } else {
            z3.a.e(mediaFormat);
            boolean z11 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            integer = z11 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            integer2 = z11 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f11 = yVar.f9510v;
        if (x1()) {
            int i12 = yVar.f9509u;
            if (i12 == 90 || i12 == 270) {
                f11 = 1.0f / f11;
                int i13 = integer2;
                integer2 = integer;
                integer = i13;
            }
        } else if (this.f11648l1 == null) {
            i11 = yVar.f9509u;
        }
        this.f11640d1 = new t0(integer, integer2, i11, f11);
        this.M0.p(yVar.f9508t);
        if (this.f11648l1 == null || mediaFormat == null) {
            return;
        }
        Y1();
        ((VideoSink) z3.a.e(this.f11648l1)).b(1, yVar.b().r0(integer).V(integer2).j0(i11).g0(f11).I());
    }

    public final void N1() {
        int i11 = this.f11638b1;
        if (i11 != 0) {
            this.J0.B(this.f11637a1, i11);
            this.f11637a1 = 0L;
            this.f11638b1 = 0;
        }
    }

    public final void O1(t0 t0Var) {
        if (t0Var.equals(t0.f9443e) || t0Var.equals(this.f11641e1)) {
            return;
        }
        this.f11641e1 = t0Var;
        this.J0.D(t0Var);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public androidx.media3.exoplayer.o P(androidx.media3.exoplayer.mediacodec.d dVar, androidx.media3.common.y yVar, androidx.media3.common.y yVar2) {
        androidx.media3.exoplayer.o oVarE = dVar.e(yVar, yVar2);
        int i11 = oVarE.f10793e;
        c cVar = (c) z3.a.e(this.O0);
        if (yVar2.f9506r > cVar.f11650a || yVar2.f9507s > cVar.f11651b) {
            i11 |= 256;
        }
        if (H1(dVar, yVar2) > cVar.f11652c) {
            i11 |= 64;
        }
        int i12 = i11;
        return new androidx.media3.exoplayer.o(dVar.f10756a, yVar, yVar2, i12 != 0 ? 0 : oVarE.f10792d, i12);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @CallSuper
    public void P0(long j11) {
        super.P0(j11);
        if (this.f11644h1) {
            return;
        }
        this.Z0--;
    }

    public final boolean P1(androidx.media3.exoplayer.mediacodec.c cVar, int i11, long j11, androidx.media3.common.y yVar) {
        long jG = this.N0.g();
        long jF = this.N0.f();
        if (u0.f81838a >= 21) {
            if (k2() && jG == this.f11639c1) {
                m2(cVar, i11, j11);
            } else {
                U1(j11, jG, yVar);
                c2(cVar, i11, j11, jG);
            }
            o2(jF);
            this.f11639c1 = jG;
            return true;
        }
        if (jF >= 30000) {
            return false;
        }
        if (jF > 11000) {
            try {
                Thread.sleep((jF - 10000) / 1000);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        U1(j11, jG, yVar);
        a2(cVar, i11, j11);
        o2(jF);
        return true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void Q0() {
        super.Q0();
        this.M0.j();
        T1();
        if (this.I0.isInitialized()) {
            this.I0.l(t0());
        }
    }

    public final void Q1() {
        Surface surface = this.R0;
        if (surface == null || !this.U0) {
            return;
        }
        this.J0.A(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @CallSuper
    public void R0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z11 = this.f11644h1;
        if (!z11) {
            this.Z0++;
        }
        if (u0.f81838a >= 23 || !z11) {
            return;
        }
        W1(decoderInputBuffer.f9782f);
    }

    public final void R1() {
        t0 t0Var = this.f11641e1;
        if (t0Var != null) {
            this.J0.D(t0Var);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @CallSuper
    public void S0(androidx.media3.common.y yVar) throws ExoPlaybackException {
        z3.e0 e0Var;
        if (this.f11642f1 && !this.f11643g1 && !this.I0.isInitialized()) {
            try {
                this.I0.g(yVar);
                this.I0.l(t0());
                o oVar = this.f11647k1;
                if (oVar != null) {
                    this.I0.c(oVar);
                }
                Surface surface = this.R0;
                if (surface != null && (e0Var = this.S0) != null) {
                    this.I0.j(surface, e0Var);
                }
            } catch (VideoSink.VideoSinkException e11) {
                throw p(e11, yVar, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED);
            }
        }
        if (this.f11648l1 == null && this.I0.isInitialized()) {
            VideoSink videoSinkK = this.I0.k();
            this.f11648l1 = videoSinkK;
            videoSinkK.e(new a(), MoreExecutors.a());
        }
        this.f11643g1 = true;
    }

    public final void S1(MediaFormat mediaFormat) {
        VideoSink videoSink = this.f11648l1;
        if (videoSink == null || videoSink.c()) {
            return;
        }
        mediaFormat.setInteger("allow-frame-drop", 0);
    }

    public final void T1() {
        int i11;
        androidx.media3.exoplayer.mediacodec.c cVarL0;
        if (!this.f11644h1 || (i11 = u0.f81838a) < 23 || (cVarL0 = l0()) == null) {
            return;
        }
        this.f11646j1 = new d(cVarL0);
        if (i11 >= 33) {
            Bundle bundle = new Bundle();
            bundle.putInt("tunnel-peek", 1);
            cVarL0.b(bundle);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public boolean U0(long j11, long j12, @Nullable androidx.media3.exoplayer.mediacodec.c cVar, @Nullable ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, androidx.media3.common.y yVar) throws ExoPlaybackException {
        z3.a.e(cVar);
        long jT0 = j13 - t0();
        int iC = this.M0.c(j13, j11, j12, u0(), z12, this.N0);
        if (z11 && !z12) {
            m2(cVar, i11, jT0);
            return true;
        }
        if (this.R0 == this.T0) {
            if (this.N0.f() >= 30000) {
                return false;
            }
            m2(cVar, i11, jT0);
            o2(this.N0.f());
            return true;
        }
        VideoSink videoSink = this.f11648l1;
        if (videoSink != null) {
            try {
                videoSink.render(j11, j12);
                long jA = this.f11648l1.a(jT0, z12);
                if (jA == C.TIME_UNSET) {
                    return false;
                }
                b2(cVar, i11, jT0, jA);
                return true;
            } catch (VideoSink.VideoSinkException e11) {
                throw p(e11, e11.format, 7001);
            }
        }
        if (iC == 0) {
            long jNanoTime = r().nanoTime();
            U1(jT0, jNanoTime, yVar);
            b2(cVar, i11, jT0, jNanoTime);
            o2(this.N0.f());
            return true;
        }
        if (iC == 1) {
            return P1((androidx.media3.exoplayer.mediacodec.c) z3.a.i(cVar), i11, jT0, yVar);
        }
        if (iC == 2) {
            B1(cVar, i11, jT0);
            o2(this.N0.f());
            return true;
        }
        if (iC == 3) {
            m2(cVar, i11, jT0);
            o2(this.N0.f());
            return true;
        }
        if (iC == 4 || iC == 5) {
            return false;
        }
        throw new IllegalStateException(String.valueOf(iC));
    }

    public final void U1(long j11, long j12, androidx.media3.common.y yVar) {
        o oVar = this.f11647k1;
        if (oVar != null) {
            oVar.e(j11, j12, yVar, q0());
        }
    }

    public final void V1() {
        this.J0.A(this.R0);
        this.U0 = true;
    }

    public void W1(long j11) throws ExoPlaybackException {
        r1(j11);
        O1(this.f11640d1);
        this.C0.f10776e++;
        M1();
        P0(j11);
    }

    public final void X1() {
        g1();
    }

    public void Y1() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public MediaCodecDecoderException Z(Throwable th2, @Nullable androidx.media3.exoplayer.mediacodec.d dVar) {
        return new MediaCodecVideoDecoderException(th2, dVar, this.R0);
    }

    @RequiresApi(17)
    public final void Z1() {
        Surface surface = this.R0;
        PlaceholderSurface placeholderSurface = this.T0;
        if (surface == placeholderSurface) {
            this.R0 = null;
        }
        if (placeholderSurface != null) {
            placeholderSurface.release();
            this.T0 = null;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @CallSuper
    public void a1() {
        super.a1();
        this.Z0 = 0;
    }

    public void a2(androidx.media3.exoplayer.mediacodec.c cVar, int i11, long j11) {
        j0.a("releaseOutputBuffer");
        cVar.k(i11, true);
        j0.c();
        this.C0.f10776e++;
        this.Y0 = 0;
        if (this.f11648l1 == null) {
            O1(this.f11640d1);
            M1();
        }
    }

    public final void b2(androidx.media3.exoplayer.mediacodec.c cVar, int i11, long j11, long j12) {
        if (u0.f81838a >= 21) {
            c2(cVar, i11, j11, j12);
        } else {
            a2(cVar, i11, j11);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m, androidx.media3.exoplayer.w2
    public void c(float f11, float f12) throws ExoPlaybackException {
        super.c(f11, f12);
        this.M0.r(f11);
        VideoSink videoSink = this.f11648l1;
        if (videoSink != null) {
            videoSink.setPlaybackSpeed(f11);
        }
    }

    @RequiresApi(21)
    public void c2(androidx.media3.exoplayer.mediacodec.c cVar, int i11, long j11, long j12) {
        j0.a("releaseOutputBuffer");
        cVar.h(i11, j12);
        j0.c();
        this.C0.f10776e++;
        this.Y0 = 0;
        if (this.f11648l1 == null) {
            O1(this.f11640d1);
            M1();
        }
    }

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.w2
    public void f() {
        this.M0.a();
    }

    @RequiresApi(23)
    public void f2(androidx.media3.exoplayer.mediacodec.c cVar, Surface surface) {
        cVar.e(surface);
    }

    public void g2(List<androidx.media3.common.p> list) {
        this.I0.e(list);
        this.f11642f1 = true;
    }

    @Override // androidx.media3.exoplayer.w2, androidx.media3.exoplayer.y2
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    public boolean h2(long j11, long j12, boolean z11) {
        return j11 < -500000 && !z11;
    }

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.t2.b
    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
        Surface surface;
        if (i11 == 1) {
            e2(obj);
            return;
        }
        if (i11 == 7) {
            o oVar = (o) z3.a.e(obj);
            this.f11647k1 = oVar;
            this.I0.c(oVar);
            return;
        }
        if (i11 == 10) {
            int iIntValue = ((Integer) z3.a.e(obj)).intValue();
            if (this.f11645i1 != iIntValue) {
                this.f11645i1 = iIntValue;
                if (this.f11644h1) {
                    Y0();
                    return;
                }
                return;
            }
            return;
        }
        if (i11 == 4) {
            this.V0 = ((Integer) z3.a.e(obj)).intValue();
            androidx.media3.exoplayer.mediacodec.c cVarL0 = l0();
            if (cVarL0 != null) {
                cVarL0.setVideoScalingMode(this.V0);
                return;
            }
            return;
        }
        if (i11 == 5) {
            this.M0.n(((Integer) z3.a.e(obj)).intValue());
            return;
        }
        if (i11 == 13) {
            g2((List) z3.a.e(obj));
            return;
        }
        if (i11 != 14) {
            super.handleMessage(i11, obj);
            return;
        }
        this.S0 = (z3.e0) z3.a.e(obj);
        if (!this.I0.isInitialized() || ((z3.e0) z3.a.e(this.S0)).b() == 0 || ((z3.e0) z3.a.e(this.S0)).a() == 0 || (surface = this.R0) == null) {
            return;
        }
        this.I0.j(surface, (z3.e0) z3.a.e(this.S0));
    }

    public boolean i2(long j11, long j12, boolean z11) {
        return j11 < -30000 && !z11;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.w2
    public boolean isEnded() {
        VideoSink videoSink;
        return super.isEnded() && ((videoSink = this.f11648l1) == null || videoSink.isEnded());
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.w2
    public boolean isReady() {
        PlaceholderSurface placeholderSurface;
        VideoSink videoSink;
        boolean z11 = super.isReady() && ((videoSink = this.f11648l1) == null || videoSink.isReady());
        if (z11 && (((placeholderSurface = this.T0) != null && this.R0 == placeholderSurface) || l0() == null || this.f11644h1)) {
            return true;
        }
        return this.M0.d(z11);
    }

    @Override // androidx.media3.exoplayer.video.p.b
    public boolean j(long j11, long j12) {
        return j2(j11, j12);
    }

    public boolean j2(long j11, long j12) {
        return j11 < -30000 && j12 > 100000;
    }

    @Override // androidx.media3.exoplayer.video.p.b
    public boolean k(long j11, long j12, long j13, boolean z11, boolean z12) throws ExoPlaybackException {
        return h2(j11, j13, z11) && K1(j12, z12);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public boolean k1(androidx.media3.exoplayer.mediacodec.d dVar) {
        return this.R0 != null || l2(dVar);
    }

    public boolean k2() {
        return true;
    }

    public final boolean l2(androidx.media3.exoplayer.mediacodec.d dVar) {
        return u0.f81838a >= 23 && !this.f11644h1 && !y1(dVar.f10756a) && (!dVar.f10762g || PlaceholderSurface.isSecureSupported(this.H0));
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public int m0(DecoderInputBuffer decoderInputBuffer) {
        return (u0.f81838a < 34 || !this.f11644h1 || decoderInputBuffer.f9782f >= v()) ? 0 : 32;
    }

    public void m2(androidx.media3.exoplayer.mediacodec.c cVar, int i11, long j11) {
        j0.a("skipVideoBuffer");
        cVar.k(i11, false);
        j0.c();
        this.C0.f10777f++;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public int n1(androidx.media3.exoplayer.mediacodec.f fVar, androidx.media3.common.y yVar) throws MediaCodecUtil.DecoderQueryException {
        boolean z11;
        int i11 = 0;
        if (!androidx.media3.common.f0.s(yVar.f9501m)) {
            return x2.a(0);
        }
        boolean z12 = yVar.f9504p != null;
        List<androidx.media3.exoplayer.mediacodec.d> listG1 = G1(this.H0, fVar, yVar, z12, false);
        if (z12 && listG1.isEmpty()) {
            listG1 = G1(this.H0, fVar, yVar, false, false);
        }
        if (listG1.isEmpty()) {
            return x2.a(1);
        }
        if (!MediaCodecRenderer.o1(yVar)) {
            return x2.a(2);
        }
        androidx.media3.exoplayer.mediacodec.d dVar = listG1.get(0);
        boolean zN = dVar.n(yVar);
        if (!zN) {
            int i12 = 1;
            while (true) {
                if (i12 >= listG1.size()) {
                    z11 = true;
                    break;
                }
                androidx.media3.exoplayer.mediacodec.d dVar2 = listG1.get(i12);
                if (dVar2.n(yVar)) {
                    dVar = dVar2;
                    z11 = false;
                    zN = true;
                    break;
                }
                i12++;
            }
        } else {
            z11 = true;
            break;
        }
        int i13 = zN ? 4 : 3;
        int i14 = dVar.q(yVar) ? 16 : 8;
        int i15 = dVar.f10763h ? 64 : 0;
        int i16 = z11 ? 128 : 0;
        if (u0.f81838a >= 26 && "video/dolby-vision".equals(yVar.f9501m) && !b.a(this.H0)) {
            i16 = 256;
        }
        if (zN) {
            List<androidx.media3.exoplayer.mediacodec.d> listG2 = G1(this.H0, fVar, yVar, z12, true);
            if (!listG2.isEmpty()) {
                androidx.media3.exoplayer.mediacodec.d dVar3 = MediaCodecUtil.w(listG2, yVar).get(0);
                if (dVar3.n(yVar) && dVar3.q(yVar)) {
                    i11 = 32;
                }
            }
        }
        return x2.d(i13, i14, i11, i15, i16);
    }

    public void n2(int i11, int i12) {
        androidx.media3.exoplayer.n nVar = this.C0;
        nVar.f10779h += i11;
        int i13 = i11 + i12;
        nVar.f10778g += i13;
        this.X0 += i13;
        int i14 = this.Y0 + i13;
        this.Y0 = i14;
        nVar.f10780i = Math.max(i14, nVar.f10780i);
        int i15 = this.K0;
        if (i15 <= 0 || this.X0 < i15) {
            return;
        }
        L1();
    }

    @Override // androidx.media3.exoplayer.video.p.b
    public boolean o(long j11, long j12, boolean z11) {
        return i2(j11, j12, z11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public boolean o0() {
        return this.f11644h1 && u0.f81838a < 23;
    }

    public void o2(long j11) {
        this.C0.a(j11);
        this.f11637a1 += j11;
        this.f11638b1++;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public float p0(float f11, androidx.media3.common.y yVar, androidx.media3.common.y[] yVarArr) {
        float fMax = -1.0f;
        for (androidx.media3.common.y yVar2 : yVarArr) {
            float f12 = yVar2.f9508t;
            if (f12 != -1.0f) {
                fMax = Math.max(fMax, f12);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f11;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public List<androidx.media3.exoplayer.mediacodec.d> r0(androidx.media3.exoplayer.mediacodec.f fVar, androidx.media3.common.y yVar, boolean z11) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.w(G1(this.H0, fVar, yVar, z11, this.f11644h1), yVar);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.w2
    @CallSuper
    public void render(long j11, long j12) throws ExoPlaybackException {
        super.render(j11, j12);
        VideoSink videoSink = this.f11648l1;
        if (videoSink != null) {
            try {
                videoSink.render(j11, j12);
            } catch (VideoSink.VideoSinkException e11) {
                throw p(e11, e11.format, 7001);
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @TargetApi(17)
    public androidx.media3.exoplayer.mediacodec.c.a s0(androidx.media3.exoplayer.mediacodec.d dVar, androidx.media3.common.y yVar, @Nullable MediaCrypto mediaCrypto, float f11) {
        PlaceholderSurface placeholderSurface = this.T0;
        if (placeholderSurface != null && placeholderSurface.secure != dVar.f10762g) {
            Z1();
        }
        String str = dVar.f10758c;
        c cVarF1 = F1(dVar, yVar, x());
        this.O0 = cVarF1;
        MediaFormat mediaFormatJ1 = J1(yVar, str, cVarF1, f11, this.L0, this.f11644h1 ? this.f11645i1 : 0);
        if (this.R0 == null) {
            if (!l2(dVar)) {
                throw new IllegalStateException();
            }
            if (this.T0 == null) {
                this.T0 = PlaceholderSurface.newInstanceV17(this.H0, dVar.f10762g);
            }
            this.R0 = this.T0;
        }
        S1(mediaFormatJ1);
        VideoSink videoSink = this.f11648l1;
        return androidx.media3.exoplayer.mediacodec.c.a.b(dVar, mediaFormatJ1, yVar, videoSink != null ? videoSink.d() : this.R0, mediaCrypto);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @TargetApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public void v0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.Q0) {
            ByteBuffer byteBuffer = (ByteBuffer) z3.a.e(decoderInputBuffer.f9783g);
            if (byteBuffer.remaining() >= 7) {
                byte b11 = byteBuffer.get();
                short s11 = byteBuffer.getShort();
                short s12 = byteBuffer.getShort();
                byte b12 = byteBuffer.get();
                byte b13 = byteBuffer.get();
                byteBuffer.position(0);
                if (b11 == -75 && s11 == 60 && s12 == 1 && b12 == 4) {
                    if (b13 == 0 || b13 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        d2((androidx.media3.exoplayer.mediacodec.c) z3.a.e(l0()), bArr);
                    }
                }
            }
        }
    }

    public boolean y1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (j.class) {
            try {
                if (!f11635n1) {
                    f11636o1 = C1();
                    f11635n1 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f11636o1;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m
    public void z() {
        this.f11641e1 = null;
        this.M0.g();
        T1();
        this.U0 = false;
        this.f11646j1 = null;
        try {
            super.z();
        } finally {
            this.J0.m(this.C0);
            this.J0.D(t0.f9443e);
        }
    }
}
