package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.MotionEventCompat;
import androidx.media3.common.PlaybackException;
import androidx.media3.container.MdtaMetadataEntry;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.Worker;
import com.vungle.warren.error.VungleException;
import java.nio.ByteBuffer;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaah extends zzsz implements zzaan {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private boolean zzA;
    private boolean zzB;
    private int zzC;

    @Nullable
    private zzaal zzD;

    @Nullable
    private zzabo zzE;
    private final Context zze;
    private final zzabp zzf;
    private final zzabj zzg;
    private final boolean zzh;
    private final zzaao zzi;
    private final zzaam zzj;
    private zzaag zzk;
    private boolean zzl;
    private boolean zzm;

    @Nullable
    private Surface zzn;

    @Nullable
    private zzaak zzo;
    private boolean zzp;
    private int zzq;
    private long zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private long zzv;
    private int zzw;
    private long zzx;
    private zzdp zzy;

    @Nullable
    private zzdp zzz;

    public zzaah(Context context, zzsq zzsqVar, zztb zztbVar, long j11, boolean z11, @Nullable Handler handler, @Nullable zzabk zzabkVar, int i11, float f11) {
        super(2, zzsqVar, zztbVar, false, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        this.zzg = new zzabj(handler, zzabkVar);
        zzzs zzzsVar = new zzzs(applicationContext);
        zzzsVar.zzc(new zzaao(applicationContext, this, 0L));
        zzaab zzaabVarZzd = zzzsVar.zzd();
        this.zzf = zzaabVarZzd;
        this.zzi = zzaabVarZzd.zza();
        this.zzj = new zzaam();
        this.zzh = "NVIDIA".equals(zzfy.zzc);
        this.zzq = 1;
        this.zzy = zzdp.zza;
        this.zzC = 0;
        this.zzz = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:101:0x0147  */
    /* JADX WARN: Code duplicated, block: B:102:0x014b  */
    /* JADX WARN: Code duplicated, block: B:104:0x0153  */
    /* JADX WARN: Code duplicated, block: B:105:0x0157  */
    /* JADX WARN: Code duplicated, block: B:107:0x015f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0163  */
    /* JADX WARN: Code duplicated, block: B:110:0x016b  */
    /* JADX WARN: Code duplicated, block: B:111:0x016f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0177  */
    /* JADX WARN: Code duplicated, block: B:114:0x017b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0183  */
    /* JADX WARN: Code duplicated, block: B:117:0x0187  */
    /* JADX WARN: Code duplicated, block: B:119:0x018f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0193  */
    /* JADX WARN: Code duplicated, block: B:122:0x019b  */
    /* JADX WARN: Code duplicated, block: B:123:0x019f  */
    /* JADX WARN: Code duplicated, block: B:125:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:126:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:128:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:129:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:131:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:132:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:134:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:135:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:138:0x01db  */
    /* JADX WARN: Code duplicated, block: B:140:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:141:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:143:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:144:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:146:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:147:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:149:0x0207  */
    /* JADX WARN: Code duplicated, block: B:150:0x020b  */
    /* JADX WARN: Code duplicated, block: B:152:0x0213  */
    /* JADX WARN: Code duplicated, block: B:153:0x0217  */
    /* JADX WARN: Code duplicated, block: B:155:0x021f  */
    /* JADX WARN: Code duplicated, block: B:156:0x0223  */
    /* JADX WARN: Code duplicated, block: B:158:0x022b  */
    /* JADX WARN: Code duplicated, block: B:159:0x022f  */
    /* JADX WARN: Code duplicated, block: B:161:0x0237  */
    /* JADX WARN: Code duplicated, block: B:162:0x023b  */
    /* JADX WARN: Code duplicated, block: B:164:0x0243  */
    /* JADX WARN: Code duplicated, block: B:165:0x0247  */
    /* JADX WARN: Code duplicated, block: B:167:0x024f  */
    /* JADX WARN: Code duplicated, block: B:168:0x0253  */
    /* JADX WARN: Code duplicated, block: B:170:0x025b  */
    /* JADX WARN: Code duplicated, block: B:171:0x025f  */
    /* JADX WARN: Code duplicated, block: B:173:0x0267  */
    /* JADX WARN: Code duplicated, block: B:174:0x026b  */
    /* JADX WARN: Code duplicated, block: B:176:0x0273  */
    /* JADX WARN: Code duplicated, block: B:177:0x0277  */
    /* JADX WARN: Code duplicated, block: B:179:0x027f  */
    /* JADX WARN: Code duplicated, block: B:180:0x0283  */
    /* JADX WARN: Code duplicated, block: B:182:0x028b  */
    /* JADX WARN: Code duplicated, block: B:183:0x028f  */
    /* JADX WARN: Code duplicated, block: B:185:0x0297  */
    /* JADX WARN: Code duplicated, block: B:186:0x029b  */
    /* JADX WARN: Code duplicated, block: B:188:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:189:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:191:0x02af  */
    /* JADX WARN: Code duplicated, block: B:192:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:194:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:195:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:197:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:198:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:200:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:201:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:203:0x02df  */
    /* JADX WARN: Code duplicated, block: B:204:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:206:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:207:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:209:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:210:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:212:0x0303  */
    /* JADX WARN: Code duplicated, block: B:213:0x0307  */
    /* JADX WARN: Code duplicated, block: B:215:0x030f  */
    /* JADX WARN: Code duplicated, block: B:216:0x0313  */
    /* JADX WARN: Code duplicated, block: B:218:0x031b  */
    /* JADX WARN: Code duplicated, block: B:219:0x031f  */
    /* JADX WARN: Code duplicated, block: B:221:0x0327  */
    /* JADX WARN: Code duplicated, block: B:222:0x032b  */
    /* JADX WARN: Code duplicated, block: B:224:0x0333  */
    /* JADX WARN: Code duplicated, block: B:225:0x0337  */
    /* JADX WARN: Code duplicated, block: B:227:0x033f  */
    /* JADX WARN: Code duplicated, block: B:228:0x0343  */
    /* JADX WARN: Code duplicated, block: B:230:0x034b  */
    /* JADX WARN: Code duplicated, block: B:231:0x034f  */
    /* JADX WARN: Code duplicated, block: B:233:0x0357  */
    /* JADX WARN: Code duplicated, block: B:234:0x035b  */
    /* JADX WARN: Code duplicated, block: B:236:0x0363  */
    /* JADX WARN: Code duplicated, block: B:237:0x0367  */
    /* JADX WARN: Code duplicated, block: B:239:0x036f  */
    /* JADX WARN: Code duplicated, block: B:240:0x0373  */
    /* JADX WARN: Code duplicated, block: B:242:0x037b  */
    /* JADX WARN: Code duplicated, block: B:243:0x037f  */
    /* JADX WARN: Code duplicated, block: B:245:0x0387  */
    /* JADX WARN: Code duplicated, block: B:246:0x038b  */
    /* JADX WARN: Code duplicated, block: B:248:0x0393  */
    /* JADX WARN: Code duplicated, block: B:249:0x0397  */
    /* JADX WARN: Code duplicated, block: B:251:0x039f  */
    /* JADX WARN: Code duplicated, block: B:252:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:254:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:255:0x03af  */
    /* JADX WARN: Code duplicated, block: B:257:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:258:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:260:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:261:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:263:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:264:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:266:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:267:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:269:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:270:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:272:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:273:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:275:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:276:0x0400  */
    /* JADX WARN: Code duplicated, block: B:278:0x0408  */
    /* JADX WARN: Code duplicated, block: B:279:0x040c  */
    /* JADX WARN: Code duplicated, block: B:281:0x0414  */
    /* JADX WARN: Code duplicated, block: B:282:0x0418  */
    /* JADX WARN: Code duplicated, block: B:284:0x0420  */
    /* JADX WARN: Code duplicated, block: B:285:0x0424  */
    /* JADX WARN: Code duplicated, block: B:287:0x042c  */
    /* JADX WARN: Code duplicated, block: B:288:0x0430  */
    /* JADX WARN: Code duplicated, block: B:290:0x0438  */
    /* JADX WARN: Code duplicated, block: B:291:0x043c  */
    /* JADX WARN: Code duplicated, block: B:293:0x0444  */
    /* JADX WARN: Code duplicated, block: B:294:0x0448  */
    /* JADX WARN: Code duplicated, block: B:296:0x0450  */
    /* JADX WARN: Code duplicated, block: B:297:0x0454  */
    /* JADX WARN: Code duplicated, block: B:299:0x045c  */
    /* JADX WARN: Code duplicated, block: B:300:0x0460  */
    /* JADX WARN: Code duplicated, block: B:302:0x0468  */
    /* JADX WARN: Code duplicated, block: B:303:0x046c  */
    /* JADX WARN: Code duplicated, block: B:305:0x0474  */
    /* JADX WARN: Code duplicated, block: B:306:0x0478  */
    /* JADX WARN: Code duplicated, block: B:308:0x0480  */
    /* JADX WARN: Code duplicated, block: B:309:0x0484  */
    /* JADX WARN: Code duplicated, block: B:311:0x048c  */
    /* JADX WARN: Code duplicated, block: B:312:0x0490  */
    /* JADX WARN: Code duplicated, block: B:314:0x0498  */
    /* JADX WARN: Code duplicated, block: B:315:0x049b  */
    /* JADX WARN: Code duplicated, block: B:317:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:318:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:320:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:321:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:323:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:324:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:327:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:329:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:330:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:332:0x04db  */
    /* JADX WARN: Code duplicated, block: B:333:0x04df  */
    /* JADX WARN: Code duplicated, block: B:335:0x04e7  */
    /* JADX WARN: Code duplicated, block: B:336:0x04eb  */
    /* JADX WARN: Code duplicated, block: B:338:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:339:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:341:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:342:0x0503  */
    /* JADX WARN: Code duplicated, block: B:344:0x050b  */
    /* JADX WARN: Code duplicated, block: B:345:0x050f  */
    /* JADX WARN: Code duplicated, block: B:347:0x0517  */
    /* JADX WARN: Code duplicated, block: B:348:0x051b  */
    /* JADX WARN: Code duplicated, block: B:350:0x0523  */
    /* JADX WARN: Code duplicated, block: B:351:0x0527  */
    /* JADX WARN: Code duplicated, block: B:353:0x052f  */
    /* JADX WARN: Code duplicated, block: B:354:0x0533  */
    /* JADX WARN: Code duplicated, block: B:356:0x053b  */
    /* JADX WARN: Code duplicated, block: B:357:0x053f  */
    /* JADX WARN: Code duplicated, block: B:359:0x0547  */
    /* JADX WARN: Code duplicated, block: B:360:0x054b  */
    /* JADX WARN: Code duplicated, block: B:362:0x0553  */
    /* JADX WARN: Code duplicated, block: B:363:0x0557  */
    /* JADX WARN: Code duplicated, block: B:365:0x055f  */
    /* JADX WARN: Code duplicated, block: B:366:0x0563  */
    /* JADX WARN: Code duplicated, block: B:368:0x056b  */
    /* JADX WARN: Code duplicated, block: B:369:0x056f  */
    /* JADX WARN: Code duplicated, block: B:371:0x0577  */
    /* JADX WARN: Code duplicated, block: B:372:0x057b  */
    /* JADX WARN: Code duplicated, block: B:374:0x0583  */
    /* JADX WARN: Code duplicated, block: B:375:0x0587  */
    /* JADX WARN: Code duplicated, block: B:377:0x058f  */
    /* JADX WARN: Code duplicated, block: B:378:0x0593  */
    /* JADX WARN: Code duplicated, block: B:380:0x059b  */
    /* JADX WARN: Code duplicated, block: B:381:0x059f  */
    /* JADX WARN: Code duplicated, block: B:383:0x05a7  */
    /* JADX WARN: Code duplicated, block: B:384:0x05ab  */
    /* JADX WARN: Code duplicated, block: B:386:0x05b3  */
    /* JADX WARN: Code duplicated, block: B:387:0x05b7  */
    /* JADX WARN: Code duplicated, block: B:389:0x05bf  */
    /* JADX WARN: Code duplicated, block: B:38:0x007b  */
    /* JADX WARN: Code duplicated, block: B:390:0x05c3  */
    /* JADX WARN: Code duplicated, block: B:392:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:393:0x05cf  */
    /* JADX WARN: Code duplicated, block: B:395:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:396:0x05db  */
    /* JADX WARN: Code duplicated, block: B:398:0x05e3  */
    /* JADX WARN: Code duplicated, block: B:399:0x05e7  */
    /* JADX WARN: Code duplicated, block: B:401:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:402:0x05f3  */
    /* JADX WARN: Code duplicated, block: B:404:0x05fb  */
    /* JADX WARN: Code duplicated, block: B:405:0x05ff  */
    /* JADX WARN: Code duplicated, block: B:407:0x0607  */
    /* JADX WARN: Code duplicated, block: B:408:0x060b  */
    /* JADX WARN: Code duplicated, block: B:410:0x0613  */
    /* JADX WARN: Code duplicated, block: B:411:0x0617  */
    /* JADX WARN: Code duplicated, block: B:413:0x061f  */
    /* JADX WARN: Code duplicated, block: B:414:0x0623  */
    /* JADX WARN: Code duplicated, block: B:416:0x062b  */
    /* JADX WARN: Code duplicated, block: B:417:0x062f  */
    /* JADX WARN: Code duplicated, block: B:419:0x0637  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:420:0x063b  */
    /* JADX WARN: Code duplicated, block: B:422:0x0643  */
    /* JADX WARN: Code duplicated, block: B:423:0x0647  */
    /* JADX WARN: Code duplicated, block: B:425:0x064f  */
    /* JADX WARN: Code duplicated, block: B:426:0x0653  */
    /* JADX WARN: Code duplicated, block: B:428:0x065b  */
    /* JADX WARN: Code duplicated, block: B:429:0x065e  */
    /* JADX WARN: Code duplicated, block: B:431:0x0666  */
    /* JADX WARN: Code duplicated, block: B:432:0x0669  */
    /* JADX WARN: Code duplicated, block: B:434:0x0671  */
    /* JADX WARN: Code duplicated, block: B:435:0x0675  */
    /* JADX WARN: Code duplicated, block: B:437:0x067d  */
    /* JADX WARN: Code duplicated, block: B:438:0x0681  */
    /* JADX WARN: Code duplicated, block: B:440:0x0689  */
    /* JADX WARN: Code duplicated, block: B:441:0x068d  */
    /* JADX WARN: Code duplicated, block: B:443:0x0695  */
    /* JADX WARN: Code duplicated, block: B:444:0x0699  */
    /* JADX WARN: Code duplicated, block: B:446:0x06a1  */
    /* JADX WARN: Code duplicated, block: B:447:0x06a5  */
    /* JADX WARN: Code duplicated, block: B:449:0x06ad  */
    /* JADX WARN: Code duplicated, block: B:44:0x0086  */
    /* JADX WARN: Code duplicated, block: B:450:0x06b1  */
    /* JADX WARN: Code duplicated, block: B:452:0x06b9  */
    /* JADX WARN: Code duplicated, block: B:453:0x06bd  */
    /* JADX WARN: Code duplicated, block: B:455:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:456:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:458:0x06d1  */
    /* JADX WARN: Code duplicated, block: B:459:0x06d5  */
    /* JADX WARN: Code duplicated, block: B:461:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:462:0x06e1  */
    /* JADX WARN: Code duplicated, block: B:464:0x06e9  */
    /* JADX WARN: Code duplicated, block: B:465:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:467:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:468:0x06f9  */
    /* JADX WARN: Code duplicated, block: B:470:0x0701  */
    /* JADX WARN: Code duplicated, block: B:471:0x0705  */
    /* JADX WARN: Code duplicated, block: B:473:0x070d  */
    /* JADX WARN: Code duplicated, block: B:474:0x0711  */
    /* JADX WARN: Code duplicated, block: B:476:0x0719  */
    /* JADX WARN: Code duplicated, block: B:477:0x071d  */
    /* JADX WARN: Code duplicated, block: B:479:0x0725  */
    /* JADX WARN: Code duplicated, block: B:480:0x0729  */
    /* JADX WARN: Code duplicated, block: B:482:0x0731  */
    /* JADX WARN: Code duplicated, block: B:483:0x0734  */
    /* JADX WARN: Code duplicated, block: B:485:0x073c  */
    /* JADX WARN: Code duplicated, block: B:486:0x073f  */
    /* JADX WARN: Code duplicated, block: B:488:0x0747  */
    /* JADX WARN: Code duplicated, block: B:489:0x074a  */
    /* JADX WARN: Code duplicated, block: B:491:0x0752  */
    /* JADX WARN: Code duplicated, block: B:492:0x0755  */
    /* JADX WARN: Code duplicated, block: B:494:0x075d  */
    /* JADX WARN: Code duplicated, block: B:495:0x0760  */
    /* JADX WARN: Code duplicated, block: B:497:0x0768  */
    /* JADX WARN: Code duplicated, block: B:498:0x076b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0095 A[Catch: all -> 0x0083, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:516:0x07a4, B:46:0x008a, B:49:0x0095, B:84:0x0104, B:509:0x0790, B:517:0x07a8), top: B:522:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:500:0x0773  */
    /* JADX WARN: Code duplicated, block: B:501:0x0776  */
    /* JADX WARN: Code duplicated, block: B:503:0x077e  */
    /* JADX WARN: Code duplicated, block: B:504:0x0781  */
    /* JADX WARN: Code duplicated, block: B:506:0x0789  */
    /* JADX WARN: Code duplicated, block: B:507:0x078c  */
    /* JADX WARN: Code duplicated, block: B:509:0x0790 A[Catch: all -> 0x0083, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:516:0x07a4, B:46:0x008a, B:49:0x0095, B:84:0x0104, B:509:0x0790, B:517:0x07a8), top: B:522:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:513:0x079a  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00be  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00de  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:82:0x0100  */
    /* JADX WARN: Code duplicated, block: B:84:0x0104 A[Catch: all -> 0x0083, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:516:0x07a4, B:46:0x008a, B:49:0x0095, B:84:0x0104, B:509:0x0790, B:517:0x07a8), top: B:522:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:87:0x010f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0117  */
    /* JADX WARN: Code duplicated, block: B:90:0x011b  */
    /* JADX WARN: Code duplicated, block: B:92:0x0123  */
    /* JADX WARN: Code duplicated, block: B:93:0x0127  */
    /* JADX WARN: Code duplicated, block: B:95:0x012f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0133  */
    /* JADX WARN: Code duplicated, block: B:98:0x013b  */
    /* JADX WARN: Code duplicated, block: B:99:0x013f  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final boolean zzaM(String str) {
        String str2;
        byte b11;
        String str3;
        byte b12;
        boolean z11 = false;
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (zzaah.class) {
            if (!zzc) {
                int i11 = zzfy.zza;
                byte b13 = Ascii.FS;
                if (i11 <= 28) {
                    String str4 = zzfy.zzb;
                    switch (str4.hashCode()) {
                        case -1339091551:
                            if (!str4.equals("dangal")) {
                                b12 = -1;
                            } else {
                                b12 = 1;
                            }
                            break;
                        case -1220081023:
                            if (!str4.equals("dangalFHD")) {
                                b12 = -1;
                            } else {
                                b12 = 3;
                            }
                            break;
                        case -1220066608:
                            if (!str4.equals("dangalUHD")) {
                                b12 = -1;
                            } else {
                                b12 = 2;
                            }
                            break;
                        case -1012436106:
                            if (!str4.equals("oneday")) {
                                b12 = -1;
                            } else {
                                b12 = 7;
                            }
                            break;
                        case -760312546:
                            if (!str4.equals("aquaman")) {
                                b12 = -1;
                            } else {
                                b12 = 0;
                            }
                            break;
                        case -64886864:
                            if (!str4.equals("magnolia")) {
                                b12 = -1;
                            } else {
                                b12 = 4;
                            }
                            break;
                        case 3415681:
                            if (!str4.equals("once")) {
                                b12 = -1;
                            } else {
                                b12 = 6;
                            }
                            break;
                        case 825323514:
                            if (!str4.equals("machuca")) {
                                b12 = -1;
                            } else {
                                b12 = 5;
                            }
                            break;
                        default:
                            b12 = -1;
                            break;
                    }
                    switch (b12) {
                        default:
                            if (i11 <= 27 || !"HWEML".equals(zzfy.zzb)) {
                                str2 = zzfy.zzd;
                                switch (str2.hashCode()) {
                                    case -349662828:
                                        if (!str2.equals("AFTJMST12")) {
                                            b11 = -1;
                                        } else {
                                            b11 = 6;
                                        }
                                        break;
                                    case -321033677:
                                        if (!str2.equals("AFTKMST12")) {
                                            b11 = -1;
                                        } else {
                                            b11 = 7;
                                        }
                                        break;
                                    case 2006354:
                                        if (!str2.equals("AFTA")) {
                                            b11 = -1;
                                        } else {
                                            b11 = 0;
                                        }
                                        break;
                                    case 2006367:
                                        if (!str2.equals("AFTN")) {
                                            b11 = -1;
                                        } else {
                                            b11 = 1;
                                        }
                                        break;
                                    case 2006371:
                                        if (!str2.equals("AFTR")) {
                                            b11 = -1;
                                        } else {
                                            b11 = 2;
                                        }
                                        break;
                                    case 1785421873:
                                        if (!str2.equals("AFTEU011")) {
                                            b11 = -1;
                                        } else {
                                            b11 = 3;
                                        }
                                        break;
                                    case 1785421876:
                                        if (!str2.equals("AFTEU014")) {
                                            b11 = -1;
                                        } else {
                                            b11 = 4;
                                        }
                                        break;
                                    case 1798172390:
                                        if (!str2.equals("AFTSO001")) {
                                            b11 = -1;
                                        } else {
                                            b11 = 8;
                                        }
                                        break;
                                    case 2119412532:
                                        if (!str2.equals("AFTEUFF014")) {
                                            b11 = -1;
                                        } else {
                                            b11 = 5;
                                        }
                                        break;
                                    default:
                                        b11 = -1;
                                        break;
                                }
                                switch (b11) {
                                    default:
                                        if (i11 <= 26) {
                                            str3 = zzfy.zzb;
                                            switch (str3.hashCode()) {
                                                case -2144781245:
                                                    if (!str3.equals("GIONEE_SWW1609")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 54;
                                                    }
                                                    break;
                                                case -2144781185:
                                                    if (!str3.equals("GIONEE_SWW1627")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 55;
                                                    }
                                                    break;
                                                case -2144781160:
                                                    if (!str3.equals("GIONEE_SWW1631")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 56;
                                                    }
                                                    break;
                                                case -2097309513:
                                                    if (!str3.equals("K50a40")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 74;
                                                    }
                                                    break;
                                                case -2022874474:
                                                    if (!str3.equals("CP8676_I02")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.SYN;
                                                    }
                                                    break;
                                                case -1978993182:
                                                    if (!str3.equals("NX541J")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 89;
                                                    }
                                                    break;
                                                case -1978990237:
                                                    if (!str3.equals("NX573J")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 90;
                                                    }
                                                    break;
                                                case -1936688988:
                                                    if (!str3.equals("PGN528")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 101;
                                                    }
                                                    break;
                                                case -1936688066:
                                                    if (!str3.equals("PGN610")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 102;
                                                    }
                                                    break;
                                                case -1936688065:
                                                    if (!str3.equals("PGN611")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 103;
                                                    }
                                                    break;
                                                case -1931988508:
                                                    if (!str3.equals("AquaPowerM")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.CR;
                                                    }
                                                    break;
                                                case -1885099851:
                                                    if (!str3.equals("RAIJIN")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 116;
                                                    }
                                                    break;
                                                case -1696512866:
                                                    if (!str3.equals("XT1663")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 137;
                                                    }
                                                    break;
                                                case -1680025915:
                                                    if (!str3.equals("ComioS1")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.NAK;
                                                    }
                                                    break;
                                                case -1615810839:
                                                    if (!str3.equals("Phantom6")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 104;
                                                    }
                                                    break;
                                                case -1600724499:
                                                    if (!str3.equals("pacificrim")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 95;
                                                    }
                                                    break;
                                                case -1554255044:
                                                    if (!str3.equals("vernee_M5")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 130;
                                                    }
                                                    break;
                                                case -1481772737:
                                                    if (!str3.equals("panell_dl")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 97;
                                                    }
                                                    break;
                                                case -1481772730:
                                                    if (!str3.equals("panell_ds")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 98;
                                                    }
                                                    break;
                                                case -1481772729:
                                                    if (!str3.equals("panell_dt")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 99;
                                                    }
                                                    break;
                                                case -1320080169:
                                                    if (!str3.equals("GiONEE_GBL7319")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 52;
                                                    }
                                                    break;
                                                case -1217592143:
                                                    if (!str3.equals("BRAVIA_ATV2")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.DC2;
                                                    }
                                                    break;
                                                case -1180384755:
                                                    if (!str3.equals("iris60")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 70;
                                                    }
                                                    break;
                                                case -1139198265:
                                                    if (!str3.equals("Slate_Pro")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 118;
                                                    }
                                                    break;
                                                case -1052835013:
                                                    if (!str3.equals("namath")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 87;
                                                    }
                                                    break;
                                                case -993250464:
                                                    if (!str3.equals("A10-70F")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 5;
                                                    }
                                                    break;
                                                case -993250458:
                                                    if (!str3.equals("A10-70L")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 6;
                                                    }
                                                    break;
                                                case -965403638:
                                                    if (!str3.equals("s905x018")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 120;
                                                    }
                                                    break;
                                                case -958336948:
                                                    if (!str3.equals("ELUGA_Ray_X")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 34;
                                                    }
                                                    break;
                                                case -879245230:
                                                    if (!str3.equals("tcl_eu")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 126;
                                                    }
                                                    break;
                                                case -842500323:
                                                    if (!str3.equals("nicklaus_f")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 88;
                                                    }
                                                    break;
                                                case -821392978:
                                                    if (!str3.equals("A7000-a")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 9;
                                                    }
                                                    break;
                                                case -797483286:
                                                    if (!str3.equals("SVP-DTV15")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 119;
                                                    }
                                                    break;
                                                case -794946968:
                                                    if (!str3.equals("watson")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 131;
                                                    }
                                                    break;
                                                case -788334647:
                                                    if (!str3.equals("whyred")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 132;
                                                    }
                                                    break;
                                                case -782144577:
                                                    if (!str3.equals("OnePlus5T")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 91;
                                                    }
                                                    break;
                                                case -575125681:
                                                    if (!str3.equals("GiONEE_CBL7513")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 51;
                                                    }
                                                    break;
                                                case -521118391:
                                                    if (!str3.equals("GIONEE_GBL7360")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 53;
                                                    }
                                                    break;
                                                case -430914369:
                                                    if (!str3.equals("Pixi4-7_3G")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 105;
                                                    }
                                                    break;
                                                case -290434366:
                                                    if (!str3.equals("taido_row")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 121;
                                                    }
                                                    break;
                                                case -282781963:
                                                    if (!str3.equals("BLACK-1X")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 17;
                                                    }
                                                    break;
                                                case -277133239:
                                                    if (!str3.equals("Z12_PRO")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 138;
                                                    }
                                                    break;
                                                case -173639913:
                                                    if (!str3.equals("ELUGA_A3_Pro")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.US;
                                                    }
                                                    break;
                                                case -56598463:
                                                    if (!str3.equals("woods_fn")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 134;
                                                    }
                                                    break;
                                                case 2126:
                                                    if (!str3.equals("C1")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.DC4;
                                                    }
                                                    break;
                                                case 2564:
                                                    if (!str3.equals("Q5")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 113;
                                                    }
                                                    break;
                                                case 2715:
                                                    if (!str3.equals("V1")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.DEL;
                                                    }
                                                    break;
                                                case 2719:
                                                    if (!str3.equals("V5")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 129;
                                                    }
                                                    break;
                                                case 3091:
                                                    if (!str3.equals("b5")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.DLE;
                                                    }
                                                    break;
                                                case 3483:
                                                    if (!str3.equals("mh")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 84;
                                                    }
                                                    break;
                                                case 73405:
                                                    if (!str3.equals("JGZ")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 73;
                                                    }
                                                    break;
                                                case 75537:
                                                    if (!str3.equals("M04")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 79;
                                                    }
                                                    break;
                                                case 75739:
                                                    if (!str3.equals("M5c")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 80;
                                                    }
                                                    break;
                                                case 76779:
                                                    if (!str3.equals("MX6")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 86;
                                                    }
                                                    break;
                                                case 78669:
                                                    if (!str3.equals("P85")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 94;
                                                    }
                                                    break;
                                                case 79305:
                                                    if (!str3.equals("PLE")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 107;
                                                    }
                                                    break;
                                                case 80618:
                                                    if (!str3.equals("QX1")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 115;
                                                    }
                                                    break;
                                                case 88274:
                                                    if (!str3.equals("Z80")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 139;
                                                    }
                                                    break;
                                                case 98846:
                                                    if (!str3.equals("cv1")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.SUB;
                                                    }
                                                    break;
                                                case 98848:
                                                    if (!str3.equals("cv3")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.ESC;
                                                    }
                                                    break;
                                                case 99329:
                                                    if (!str3.equals("deb")) {
                                                        b13 = -1;
                                                    }
                                                    break;
                                                case 101481:
                                                    if (!str3.equals("flo")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 49;
                                                    }
                                                    break;
                                                case 1513190:
                                                    if (!str3.equals("1601")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 0;
                                                    }
                                                    break;
                                                case 1514184:
                                                    if (!str3.equals("1713")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 1;
                                                    }
                                                    break;
                                                case 1514185:
                                                    if (!str3.equals("1714")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 2;
                                                    }
                                                    break;
                                                case 2133089:
                                                    if (!str3.equals("F01H")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 36;
                                                    }
                                                    break;
                                                case 2133091:
                                                    if (!str3.equals("F01J")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 37;
                                                    }
                                                    break;
                                                case 2133120:
                                                    if (!str3.equals("F02H")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 38;
                                                    }
                                                    break;
                                                case 2133151:
                                                    if (!str3.equals("F03H")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 39;
                                                    }
                                                    break;
                                                case 2133182:
                                                    if (!str3.equals("F04H")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 40;
                                                    }
                                                    break;
                                                case 2133184:
                                                    if (!str3.equals("F04J")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 41;
                                                    }
                                                    break;
                                                case 2436959:
                                                    if (!str3.equals("P681")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 93;
                                                    }
                                                    break;
                                                case 2463773:
                                                    if (!str3.equals("Q350")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 109;
                                                    }
                                                    break;
                                                case 2464648:
                                                    if (!str3.equals("Q427")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 111;
                                                    }
                                                    break;
                                                case 2689555:
                                                    if (!str3.equals("XE2X")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 136;
                                                    }
                                                    break;
                                                case 3154429:
                                                    if (!str3.equals("fugu")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 50;
                                                    }
                                                    break;
                                                case 3284551:
                                                    if (!str3.equals("kate")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 75;
                                                    }
                                                    break;
                                                case 3351335:
                                                    if (!str3.equals("mido")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 85;
                                                    }
                                                    break;
                                                case 3386211:
                                                    if (!str3.equals("p212")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 92;
                                                    }
                                                    break;
                                                case 41325051:
                                                    if (!str3.equals("MEIZU_M5")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 83;
                                                    }
                                                    break;
                                                case 51349633:
                                                    if (!str3.equals("601LV")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 3;
                                                    }
                                                    break;
                                                case 51350594:
                                                    if (!str3.equals("602LV")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 4;
                                                    }
                                                    break;
                                                case 55178625:
                                                    if (!str3.equals("Aura_Note_2")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.SI;
                                                    }
                                                    break;
                                                case 61542055:
                                                    if (!str3.equals("A1601")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 7;
                                                    }
                                                    break;
                                                case 65355429:
                                                    if (!str3.equals("E5643")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.RS;
                                                    }
                                                    break;
                                                case 66214468:
                                                    if (!str3.equals("F3111")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 42;
                                                    }
                                                    break;
                                                case 66214470:
                                                    if (!str3.equals("F3113")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 43;
                                                    }
                                                    break;
                                                case 66214473:
                                                    if (!str3.equals("F3116")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 44;
                                                    }
                                                    break;
                                                case 66215429:
                                                    if (!str3.equals("F3211")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 45;
                                                    }
                                                    break;
                                                case 66215431:
                                                    if (!str3.equals("F3213")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 46;
                                                    }
                                                    break;
                                                case 66215433:
                                                    if (!str3.equals("F3215")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 47;
                                                    }
                                                    break;
                                                case 66216390:
                                                    if (!str3.equals("F3311")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 48;
                                                    }
                                                    break;
                                                case 76402249:
                                                    if (!str3.equals("PRO7S")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 108;
                                                    }
                                                    break;
                                                case 76404105:
                                                    if (!str3.equals("Q4260")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 110;
                                                    }
                                                    break;
                                                case 76404911:
                                                    if (!str3.equals("Q4310")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 112;
                                                    }
                                                    break;
                                                case 80963634:
                                                    if (!str3.equals("V23GB")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 128;
                                                    }
                                                    break;
                                                case 82882791:
                                                    if (!str3.equals("X3_HK")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 135;
                                                    }
                                                    break;
                                                case 98715550:
                                                    if (!str3.equals("i9031")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 67;
                                                    }
                                                    break;
                                                case 101370885:
                                                    if (!str3.equals("l5460")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 76;
                                                    }
                                                    break;
                                                case 102844228:
                                                    if (!str3.equals("le_x6")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 77;
                                                    }
                                                    break;
                                                case 165221241:
                                                    if (!str3.equals("A2016a40")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 8;
                                                    }
                                                    break;
                                                case 182191441:
                                                    if (!str3.equals("CPY83_I00")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.EM;
                                                    }
                                                    break;
                                                case 245388979:
                                                    if (!str3.equals("marino_f")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 82;
                                                    }
                                                    break;
                                                case 287431619:
                                                    if (!str3.equals("griffin")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 60;
                                                    }
                                                    break;
                                                case 307593612:
                                                    if (!str3.equals("A7010a48")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.VT;
                                                    }
                                                    break;
                                                case 308517133:
                                                    if (!str3.equals("A7020a48")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.FF;
                                                    }
                                                    break;
                                                case 316215098:
                                                    if (!str3.equals("TB3-730F")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 122;
                                                    }
                                                    break;
                                                case 316215116:
                                                    if (!str3.equals("TB3-730X")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 123;
                                                    }
                                                    break;
                                                case 316246811:
                                                    if (!str3.equals("TB3-850F")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 124;
                                                    }
                                                    break;
                                                case 316246818:
                                                    if (!str3.equals("TB3-850M")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 125;
                                                    }
                                                    break;
                                                case 407160593:
                                                    if (!str3.equals("Pixi5-10_4G")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 106;
                                                    }
                                                    break;
                                                case 507412548:
                                                    if (!str3.equals("QM16XE_U")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 114;
                                                    }
                                                    break;
                                                case 793982701:
                                                    if (!str3.equals("GIONEE_WBL5708")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 57;
                                                    }
                                                    break;
                                                case 794038622:
                                                    if (!str3.equals("GIONEE_WBL7365")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 58;
                                                    }
                                                    break;
                                                case 794040393:
                                                    if (!str3.equals("GIONEE_WBL7519")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 59;
                                                    }
                                                    break;
                                                case 835649806:
                                                    if (!str3.equals("manning")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 81;
                                                    }
                                                    break;
                                                case 917340916:
                                                    if (!str3.equals("A7000plus")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 10;
                                                    }
                                                    break;
                                                case 958008161:
                                                    if (!str3.equals("j2xlteins")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 72;
                                                    }
                                                    break;
                                                case 1060579533:
                                                    if (!str3.equals("panell_d")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 96;
                                                    }
                                                    break;
                                                case 1150207623:
                                                    if (!str3.equals("LS-5017")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 78;
                                                    }
                                                    break;
                                                case 1176899427:
                                                    if (!str3.equals("itel_S41")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 71;
                                                    }
                                                    break;
                                                case 1280332038:
                                                    if (!str3.equals("hwALE-H")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 62;
                                                    }
                                                    break;
                                                case 1306947716:
                                                    if (!str3.equals("EverStar_S")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 35;
                                                    }
                                                    break;
                                                case 1349174697:
                                                    if (!str3.equals("htc_e56ml_dtul")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 61;
                                                    }
                                                    break;
                                                case 1522194893:
                                                    if (!str3.equals("woods_f")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 133;
                                                    }
                                                    break;
                                                case 1691543273:
                                                    if (!str3.equals("CPH1609")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.ETB;
                                                    }
                                                    break;
                                                case 1691544261:
                                                    if (!str3.equals("CPH1715")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.CAN;
                                                    }
                                                    break;
                                                case 1709443163:
                                                    if (!str3.equals("iball8735_9806")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 68;
                                                    }
                                                    break;
                                                case 1865889110:
                                                    if (!str3.equals("santoni")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 117;
                                                    }
                                                    break;
                                                case 1906253259:
                                                    if (!str3.equals("PB2-670M")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 100;
                                                    }
                                                    break;
                                                case 1977196784:
                                                    if (!str3.equals("Infinix-X572")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 69;
                                                    }
                                                    break;
                                                case 2006372676:
                                                    if (!str3.equals("BRAVIA_ATV3_4K")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 19;
                                                    }
                                                    break;
                                                case 2019281702:
                                                    if (!str3.equals("DM-01K")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.GS;
                                                    }
                                                    break;
                                                case 2029784656:
                                                    if (!str3.equals("HWBLN-H")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Utf8.REPLACEMENT_BYTE;
                                                    }
                                                    break;
                                                case 2030379515:
                                                    if (!str3.equals("HWCAM-H")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 64;
                                                    }
                                                    break;
                                                case 2033393791:
                                                    if (!str3.equals("ASUS_X00AD_2")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = Ascii.SO;
                                                    }
                                                    break;
                                                case 2047190025:
                                                    if (!str3.equals("ELUGA_Note")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 32;
                                                    }
                                                    break;
                                                case 2047252157:
                                                    if (!str3.equals("ELUGA_Prim")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 33;
                                                    }
                                                    break;
                                                case 2048319463:
                                                    if (!str3.equals("HWVNS-H")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 65;
                                                    }
                                                    break;
                                                case 2048855701:
                                                    if (!str3.equals("HWWAS-H")) {
                                                        b13 = -1;
                                                    } else {
                                                        b13 = 66;
                                                    }
                                                    break;
                                                default:
                                                    b13 = -1;
                                                    break;
                                            }
                                            switch (b13) {
                                                default:
                                                    if (str2.hashCode() == -594534941 && str2.equals("JSN-L21")) {
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
                                                    z11 = true;
                                                    break;
                                            }
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
                                        z11 = true;
                                        break;
                                }
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            z11 = true;
                            break;
                    }
                } else if (i11 <= 27) {
                    str2 = zzfy.zzd;
                    switch (str2.hashCode()) {
                        case -349662828:
                            if (!str2.equals("AFTJMST12")) {
                                b11 = -1;
                            } else {
                                b11 = 6;
                            }
                            break;
                        case -321033677:
                            if (!str2.equals("AFTKMST12")) {
                                b11 = -1;
                            } else {
                                b11 = 7;
                            }
                            break;
                        case 2006354:
                            if (!str2.equals("AFTA")) {
                                b11 = -1;
                            } else {
                                b11 = 0;
                            }
                            break;
                        case 2006367:
                            if (!str2.equals("AFTN")) {
                                b11 = -1;
                            } else {
                                b11 = 1;
                            }
                            break;
                        case 2006371:
                            if (!str2.equals("AFTR")) {
                                b11 = -1;
                            } else {
                                b11 = 2;
                            }
                            break;
                        case 1785421873:
                            if (!str2.equals("AFTEU011")) {
                                b11 = -1;
                            } else {
                                b11 = 3;
                            }
                            break;
                        case 1785421876:
                            if (!str2.equals("AFTEU014")) {
                                b11 = -1;
                            } else {
                                b11 = 4;
                            }
                            break;
                        case 1798172390:
                            if (!str2.equals("AFTSO001")) {
                                b11 = -1;
                            } else {
                                b11 = 8;
                            }
                            break;
                        case 2119412532:
                            if (!str2.equals("AFTEUFF014")) {
                                b11 = -1;
                            } else {
                                b11 = 5;
                            }
                            break;
                        default:
                            b11 = -1;
                            break;
                    }
                    switch (b11) {
                        default:
                            if (i11 <= 26) {
                                str3 = zzfy.zzb;
                                switch (str3.hashCode()) {
                                    case -2144781245:
                                        if (!str3.equals("GIONEE_SWW1609")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 54;
                                        }
                                        break;
                                    case -2144781185:
                                        if (!str3.equals("GIONEE_SWW1627")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 55;
                                        }
                                        break;
                                    case -2144781160:
                                        if (!str3.equals("GIONEE_SWW1631")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 56;
                                        }
                                        break;
                                    case -2097309513:
                                        if (!str3.equals("K50a40")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 74;
                                        }
                                        break;
                                    case -2022874474:
                                        if (!str3.equals("CP8676_I02")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.SYN;
                                        }
                                        break;
                                    case -1978993182:
                                        if (!str3.equals("NX541J")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 89;
                                        }
                                        break;
                                    case -1978990237:
                                        if (!str3.equals("NX573J")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 90;
                                        }
                                        break;
                                    case -1936688988:
                                        if (!str3.equals("PGN528")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 101;
                                        }
                                        break;
                                    case -1936688066:
                                        if (!str3.equals("PGN610")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 102;
                                        }
                                        break;
                                    case -1936688065:
                                        if (!str3.equals("PGN611")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 103;
                                        }
                                        break;
                                    case -1931988508:
                                        if (!str3.equals("AquaPowerM")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.CR;
                                        }
                                        break;
                                    case -1885099851:
                                        if (!str3.equals("RAIJIN")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 116;
                                        }
                                        break;
                                    case -1696512866:
                                        if (!str3.equals("XT1663")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 137;
                                        }
                                        break;
                                    case -1680025915:
                                        if (!str3.equals("ComioS1")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.NAK;
                                        }
                                        break;
                                    case -1615810839:
                                        if (!str3.equals("Phantom6")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 104;
                                        }
                                        break;
                                    case -1600724499:
                                        if (!str3.equals("pacificrim")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 95;
                                        }
                                        break;
                                    case -1554255044:
                                        if (!str3.equals("vernee_M5")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 130;
                                        }
                                        break;
                                    case -1481772737:
                                        if (!str3.equals("panell_dl")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 97;
                                        }
                                        break;
                                    case -1481772730:
                                        if (!str3.equals("panell_ds")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 98;
                                        }
                                        break;
                                    case -1481772729:
                                        if (!str3.equals("panell_dt")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 99;
                                        }
                                        break;
                                    case -1320080169:
                                        if (!str3.equals("GiONEE_GBL7319")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 52;
                                        }
                                        break;
                                    case -1217592143:
                                        if (!str3.equals("BRAVIA_ATV2")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.DC2;
                                        }
                                        break;
                                    case -1180384755:
                                        if (!str3.equals("iris60")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 70;
                                        }
                                        break;
                                    case -1139198265:
                                        if (!str3.equals("Slate_Pro")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 118;
                                        }
                                        break;
                                    case -1052835013:
                                        if (!str3.equals("namath")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 87;
                                        }
                                        break;
                                    case -993250464:
                                        if (!str3.equals("A10-70F")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 5;
                                        }
                                        break;
                                    case -993250458:
                                        if (!str3.equals("A10-70L")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 6;
                                        }
                                        break;
                                    case -965403638:
                                        if (!str3.equals("s905x018")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 120;
                                        }
                                        break;
                                    case -958336948:
                                        if (!str3.equals("ELUGA_Ray_X")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 34;
                                        }
                                        break;
                                    case -879245230:
                                        if (!str3.equals("tcl_eu")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 126;
                                        }
                                        break;
                                    case -842500323:
                                        if (!str3.equals("nicklaus_f")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 88;
                                        }
                                        break;
                                    case -821392978:
                                        if (!str3.equals("A7000-a")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 9;
                                        }
                                        break;
                                    case -797483286:
                                        if (!str3.equals("SVP-DTV15")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 119;
                                        }
                                        break;
                                    case -794946968:
                                        if (!str3.equals("watson")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 131;
                                        }
                                        break;
                                    case -788334647:
                                        if (!str3.equals("whyred")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 132;
                                        }
                                        break;
                                    case -782144577:
                                        if (!str3.equals("OnePlus5T")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 91;
                                        }
                                        break;
                                    case -575125681:
                                        if (!str3.equals("GiONEE_CBL7513")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 51;
                                        }
                                        break;
                                    case -521118391:
                                        if (!str3.equals("GIONEE_GBL7360")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 53;
                                        }
                                        break;
                                    case -430914369:
                                        if (!str3.equals("Pixi4-7_3G")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 105;
                                        }
                                        break;
                                    case -290434366:
                                        if (!str3.equals("taido_row")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 121;
                                        }
                                        break;
                                    case -282781963:
                                        if (!str3.equals("BLACK-1X")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 17;
                                        }
                                        break;
                                    case -277133239:
                                        if (!str3.equals("Z12_PRO")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 138;
                                        }
                                        break;
                                    case -173639913:
                                        if (!str3.equals("ELUGA_A3_Pro")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.US;
                                        }
                                        break;
                                    case -56598463:
                                        if (!str3.equals("woods_fn")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 134;
                                        }
                                        break;
                                    case 2126:
                                        if (!str3.equals("C1")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.DC4;
                                        }
                                        break;
                                    case 2564:
                                        if (!str3.equals("Q5")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 113;
                                        }
                                        break;
                                    case 2715:
                                        if (!str3.equals("V1")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.DEL;
                                        }
                                        break;
                                    case 2719:
                                        if (!str3.equals("V5")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 129;
                                        }
                                        break;
                                    case 3091:
                                        if (!str3.equals("b5")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.DLE;
                                        }
                                        break;
                                    case 3483:
                                        if (!str3.equals("mh")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 84;
                                        }
                                        break;
                                    case 73405:
                                        if (!str3.equals("JGZ")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 73;
                                        }
                                        break;
                                    case 75537:
                                        if (!str3.equals("M04")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 79;
                                        }
                                        break;
                                    case 75739:
                                        if (!str3.equals("M5c")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 80;
                                        }
                                        break;
                                    case 76779:
                                        if (!str3.equals("MX6")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 86;
                                        }
                                        break;
                                    case 78669:
                                        if (!str3.equals("P85")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 94;
                                        }
                                        break;
                                    case 79305:
                                        if (!str3.equals("PLE")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 107;
                                        }
                                        break;
                                    case 80618:
                                        if (!str3.equals("QX1")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 115;
                                        }
                                        break;
                                    case 88274:
                                        if (!str3.equals("Z80")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 139;
                                        }
                                        break;
                                    case 98846:
                                        if (!str3.equals("cv1")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.SUB;
                                        }
                                        break;
                                    case 98848:
                                        if (!str3.equals("cv3")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.ESC;
                                        }
                                        break;
                                    case 99329:
                                        if (!str3.equals("deb")) {
                                            b13 = -1;
                                        }
                                        break;
                                    case 101481:
                                        if (!str3.equals("flo")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 49;
                                        }
                                        break;
                                    case 1513190:
                                        if (!str3.equals("1601")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 0;
                                        }
                                        break;
                                    case 1514184:
                                        if (!str3.equals("1713")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 1;
                                        }
                                        break;
                                    case 1514185:
                                        if (!str3.equals("1714")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 2;
                                        }
                                        break;
                                    case 2133089:
                                        if (!str3.equals("F01H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 36;
                                        }
                                        break;
                                    case 2133091:
                                        if (!str3.equals("F01J")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 37;
                                        }
                                        break;
                                    case 2133120:
                                        if (!str3.equals("F02H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 38;
                                        }
                                        break;
                                    case 2133151:
                                        if (!str3.equals("F03H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 39;
                                        }
                                        break;
                                    case 2133182:
                                        if (!str3.equals("F04H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 40;
                                        }
                                        break;
                                    case 2133184:
                                        if (!str3.equals("F04J")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 41;
                                        }
                                        break;
                                    case 2436959:
                                        if (!str3.equals("P681")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 93;
                                        }
                                        break;
                                    case 2463773:
                                        if (!str3.equals("Q350")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 109;
                                        }
                                        break;
                                    case 2464648:
                                        if (!str3.equals("Q427")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 111;
                                        }
                                        break;
                                    case 2689555:
                                        if (!str3.equals("XE2X")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 136;
                                        }
                                        break;
                                    case 3154429:
                                        if (!str3.equals("fugu")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 50;
                                        }
                                        break;
                                    case 3284551:
                                        if (!str3.equals("kate")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 75;
                                        }
                                        break;
                                    case 3351335:
                                        if (!str3.equals("mido")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 85;
                                        }
                                        break;
                                    case 3386211:
                                        if (!str3.equals("p212")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 92;
                                        }
                                        break;
                                    case 41325051:
                                        if (!str3.equals("MEIZU_M5")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 83;
                                        }
                                        break;
                                    case 51349633:
                                        if (!str3.equals("601LV")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 3;
                                        }
                                        break;
                                    case 51350594:
                                        if (!str3.equals("602LV")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 4;
                                        }
                                        break;
                                    case 55178625:
                                        if (!str3.equals("Aura_Note_2")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.SI;
                                        }
                                        break;
                                    case 61542055:
                                        if (!str3.equals("A1601")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 7;
                                        }
                                        break;
                                    case 65355429:
                                        if (!str3.equals("E5643")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.RS;
                                        }
                                        break;
                                    case 66214468:
                                        if (!str3.equals("F3111")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 42;
                                        }
                                        break;
                                    case 66214470:
                                        if (!str3.equals("F3113")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 43;
                                        }
                                        break;
                                    case 66214473:
                                        if (!str3.equals("F3116")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 44;
                                        }
                                        break;
                                    case 66215429:
                                        if (!str3.equals("F3211")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 45;
                                        }
                                        break;
                                    case 66215431:
                                        if (!str3.equals("F3213")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 46;
                                        }
                                        break;
                                    case 66215433:
                                        if (!str3.equals("F3215")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 47;
                                        }
                                        break;
                                    case 66216390:
                                        if (!str3.equals("F3311")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 48;
                                        }
                                        break;
                                    case 76402249:
                                        if (!str3.equals("PRO7S")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 108;
                                        }
                                        break;
                                    case 76404105:
                                        if (!str3.equals("Q4260")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 110;
                                        }
                                        break;
                                    case 76404911:
                                        if (!str3.equals("Q4310")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 112;
                                        }
                                        break;
                                    case 80963634:
                                        if (!str3.equals("V23GB")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 128;
                                        }
                                        break;
                                    case 82882791:
                                        if (!str3.equals("X3_HK")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 135;
                                        }
                                        break;
                                    case 98715550:
                                        if (!str3.equals("i9031")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 67;
                                        }
                                        break;
                                    case 101370885:
                                        if (!str3.equals("l5460")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 76;
                                        }
                                        break;
                                    case 102844228:
                                        if (!str3.equals("le_x6")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 77;
                                        }
                                        break;
                                    case 165221241:
                                        if (!str3.equals("A2016a40")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 8;
                                        }
                                        break;
                                    case 182191441:
                                        if (!str3.equals("CPY83_I00")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.EM;
                                        }
                                        break;
                                    case 245388979:
                                        if (!str3.equals("marino_f")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 82;
                                        }
                                        break;
                                    case 287431619:
                                        if (!str3.equals("griffin")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 60;
                                        }
                                        break;
                                    case 307593612:
                                        if (!str3.equals("A7010a48")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.VT;
                                        }
                                        break;
                                    case 308517133:
                                        if (!str3.equals("A7020a48")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.FF;
                                        }
                                        break;
                                    case 316215098:
                                        if (!str3.equals("TB3-730F")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 122;
                                        }
                                        break;
                                    case 316215116:
                                        if (!str3.equals("TB3-730X")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 123;
                                        }
                                        break;
                                    case 316246811:
                                        if (!str3.equals("TB3-850F")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 124;
                                        }
                                        break;
                                    case 316246818:
                                        if (!str3.equals("TB3-850M")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 125;
                                        }
                                        break;
                                    case 407160593:
                                        if (!str3.equals("Pixi5-10_4G")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 106;
                                        }
                                        break;
                                    case 507412548:
                                        if (!str3.equals("QM16XE_U")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 114;
                                        }
                                        break;
                                    case 793982701:
                                        if (!str3.equals("GIONEE_WBL5708")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 57;
                                        }
                                        break;
                                    case 794038622:
                                        if (!str3.equals("GIONEE_WBL7365")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 58;
                                        }
                                        break;
                                    case 794040393:
                                        if (!str3.equals("GIONEE_WBL7519")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 59;
                                        }
                                        break;
                                    case 835649806:
                                        if (!str3.equals("manning")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 81;
                                        }
                                        break;
                                    case 917340916:
                                        if (!str3.equals("A7000plus")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 10;
                                        }
                                        break;
                                    case 958008161:
                                        if (!str3.equals("j2xlteins")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 72;
                                        }
                                        break;
                                    case 1060579533:
                                        if (!str3.equals("panell_d")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 96;
                                        }
                                        break;
                                    case 1150207623:
                                        if (!str3.equals("LS-5017")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 78;
                                        }
                                        break;
                                    case 1176899427:
                                        if (!str3.equals("itel_S41")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 71;
                                        }
                                        break;
                                    case 1280332038:
                                        if (!str3.equals("hwALE-H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 62;
                                        }
                                        break;
                                    case 1306947716:
                                        if (!str3.equals("EverStar_S")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 35;
                                        }
                                        break;
                                    case 1349174697:
                                        if (!str3.equals("htc_e56ml_dtul")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 61;
                                        }
                                        break;
                                    case 1522194893:
                                        if (!str3.equals("woods_f")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 133;
                                        }
                                        break;
                                    case 1691543273:
                                        if (!str3.equals("CPH1609")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.ETB;
                                        }
                                        break;
                                    case 1691544261:
                                        if (!str3.equals("CPH1715")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.CAN;
                                        }
                                        break;
                                    case 1709443163:
                                        if (!str3.equals("iball8735_9806")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 68;
                                        }
                                        break;
                                    case 1865889110:
                                        if (!str3.equals("santoni")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 117;
                                        }
                                        break;
                                    case 1906253259:
                                        if (!str3.equals("PB2-670M")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 100;
                                        }
                                        break;
                                    case 1977196784:
                                        if (!str3.equals("Infinix-X572")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 69;
                                        }
                                        break;
                                    case 2006372676:
                                        if (!str3.equals("BRAVIA_ATV3_4K")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 19;
                                        }
                                        break;
                                    case 2019281702:
                                        if (!str3.equals("DM-01K")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.GS;
                                        }
                                        break;
                                    case 2029784656:
                                        if (!str3.equals("HWBLN-H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Utf8.REPLACEMENT_BYTE;
                                        }
                                        break;
                                    case 2030379515:
                                        if (!str3.equals("HWCAM-H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 64;
                                        }
                                        break;
                                    case 2033393791:
                                        if (!str3.equals("ASUS_X00AD_2")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.SO;
                                        }
                                        break;
                                    case 2047190025:
                                        if (!str3.equals("ELUGA_Note")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 32;
                                        }
                                        break;
                                    case 2047252157:
                                        if (!str3.equals("ELUGA_Prim")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 33;
                                        }
                                        break;
                                    case 2048319463:
                                        if (!str3.equals("HWVNS-H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 65;
                                        }
                                        break;
                                    case 2048855701:
                                        if (!str3.equals("HWWAS-H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 66;
                                        }
                                        break;
                                    default:
                                        b13 = -1;
                                        break;
                                }
                                switch (b13) {
                                    default:
                                        if (str2.hashCode() == -594534941) {
                                            break;
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
                                        z11 = true;
                                        break;
                                }
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
                            z11 = true;
                            break;
                    }
                } else {
                    str2 = zzfy.zzd;
                    switch (str2.hashCode()) {
                        case -349662828:
                            if (!str2.equals("AFTJMST12")) {
                                b11 = -1;
                            } else {
                                b11 = 6;
                            }
                            break;
                        case -321033677:
                            if (!str2.equals("AFTKMST12")) {
                                b11 = -1;
                            } else {
                                b11 = 7;
                            }
                            break;
                        case 2006354:
                            if (!str2.equals("AFTA")) {
                                b11 = -1;
                            } else {
                                b11 = 0;
                            }
                            break;
                        case 2006367:
                            if (!str2.equals("AFTN")) {
                                b11 = -1;
                            } else {
                                b11 = 1;
                            }
                            break;
                        case 2006371:
                            if (!str2.equals("AFTR")) {
                                b11 = -1;
                            } else {
                                b11 = 2;
                            }
                            break;
                        case 1785421873:
                            if (!str2.equals("AFTEU011")) {
                                b11 = -1;
                            } else {
                                b11 = 3;
                            }
                            break;
                        case 1785421876:
                            if (!str2.equals("AFTEU014")) {
                                b11 = -1;
                            } else {
                                b11 = 4;
                            }
                            break;
                        case 1798172390:
                            if (!str2.equals("AFTSO001")) {
                                b11 = -1;
                            } else {
                                b11 = 8;
                            }
                            break;
                        case 2119412532:
                            if (!str2.equals("AFTEUFF014")) {
                                b11 = -1;
                            } else {
                                b11 = 5;
                            }
                            break;
                        default:
                            b11 = -1;
                            break;
                    }
                    switch (b11) {
                        default:
                            if (i11 <= 26) {
                                str3 = zzfy.zzb;
                                switch (str3.hashCode()) {
                                    case -2144781245:
                                        if (!str3.equals("GIONEE_SWW1609")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 54;
                                        }
                                        break;
                                    case -2144781185:
                                        if (!str3.equals("GIONEE_SWW1627")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 55;
                                        }
                                        break;
                                    case -2144781160:
                                        if (!str3.equals("GIONEE_SWW1631")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 56;
                                        }
                                        break;
                                    case -2097309513:
                                        if (!str3.equals("K50a40")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 74;
                                        }
                                        break;
                                    case -2022874474:
                                        if (!str3.equals("CP8676_I02")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.SYN;
                                        }
                                        break;
                                    case -1978993182:
                                        if (!str3.equals("NX541J")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 89;
                                        }
                                        break;
                                    case -1978990237:
                                        if (!str3.equals("NX573J")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 90;
                                        }
                                        break;
                                    case -1936688988:
                                        if (!str3.equals("PGN528")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 101;
                                        }
                                        break;
                                    case -1936688066:
                                        if (!str3.equals("PGN610")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 102;
                                        }
                                        break;
                                    case -1936688065:
                                        if (!str3.equals("PGN611")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 103;
                                        }
                                        break;
                                    case -1931988508:
                                        if (!str3.equals("AquaPowerM")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.CR;
                                        }
                                        break;
                                    case -1885099851:
                                        if (!str3.equals("RAIJIN")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 116;
                                        }
                                        break;
                                    case -1696512866:
                                        if (!str3.equals("XT1663")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 137;
                                        }
                                        break;
                                    case -1680025915:
                                        if (!str3.equals("ComioS1")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.NAK;
                                        }
                                        break;
                                    case -1615810839:
                                        if (!str3.equals("Phantom6")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 104;
                                        }
                                        break;
                                    case -1600724499:
                                        if (!str3.equals("pacificrim")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 95;
                                        }
                                        break;
                                    case -1554255044:
                                        if (!str3.equals("vernee_M5")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 130;
                                        }
                                        break;
                                    case -1481772737:
                                        if (!str3.equals("panell_dl")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 97;
                                        }
                                        break;
                                    case -1481772730:
                                        if (!str3.equals("panell_ds")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 98;
                                        }
                                        break;
                                    case -1481772729:
                                        if (!str3.equals("panell_dt")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 99;
                                        }
                                        break;
                                    case -1320080169:
                                        if (!str3.equals("GiONEE_GBL7319")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 52;
                                        }
                                        break;
                                    case -1217592143:
                                        if (!str3.equals("BRAVIA_ATV2")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.DC2;
                                        }
                                        break;
                                    case -1180384755:
                                        if (!str3.equals("iris60")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 70;
                                        }
                                        break;
                                    case -1139198265:
                                        if (!str3.equals("Slate_Pro")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 118;
                                        }
                                        break;
                                    case -1052835013:
                                        if (!str3.equals("namath")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 87;
                                        }
                                        break;
                                    case -993250464:
                                        if (!str3.equals("A10-70F")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 5;
                                        }
                                        break;
                                    case -993250458:
                                        if (!str3.equals("A10-70L")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 6;
                                        }
                                        break;
                                    case -965403638:
                                        if (!str3.equals("s905x018")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 120;
                                        }
                                        break;
                                    case -958336948:
                                        if (!str3.equals("ELUGA_Ray_X")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 34;
                                        }
                                        break;
                                    case -879245230:
                                        if (!str3.equals("tcl_eu")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 126;
                                        }
                                        break;
                                    case -842500323:
                                        if (!str3.equals("nicklaus_f")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 88;
                                        }
                                        break;
                                    case -821392978:
                                        if (!str3.equals("A7000-a")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 9;
                                        }
                                        break;
                                    case -797483286:
                                        if (!str3.equals("SVP-DTV15")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 119;
                                        }
                                        break;
                                    case -794946968:
                                        if (!str3.equals("watson")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 131;
                                        }
                                        break;
                                    case -788334647:
                                        if (!str3.equals("whyred")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 132;
                                        }
                                        break;
                                    case -782144577:
                                        if (!str3.equals("OnePlus5T")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 91;
                                        }
                                        break;
                                    case -575125681:
                                        if (!str3.equals("GiONEE_CBL7513")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 51;
                                        }
                                        break;
                                    case -521118391:
                                        if (!str3.equals("GIONEE_GBL7360")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 53;
                                        }
                                        break;
                                    case -430914369:
                                        if (!str3.equals("Pixi4-7_3G")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 105;
                                        }
                                        break;
                                    case -290434366:
                                        if (!str3.equals("taido_row")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 121;
                                        }
                                        break;
                                    case -282781963:
                                        if (!str3.equals("BLACK-1X")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 17;
                                        }
                                        break;
                                    case -277133239:
                                        if (!str3.equals("Z12_PRO")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 138;
                                        }
                                        break;
                                    case -173639913:
                                        if (!str3.equals("ELUGA_A3_Pro")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.US;
                                        }
                                        break;
                                    case -56598463:
                                        if (!str3.equals("woods_fn")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 134;
                                        }
                                        break;
                                    case 2126:
                                        if (!str3.equals("C1")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.DC4;
                                        }
                                        break;
                                    case 2564:
                                        if (!str3.equals("Q5")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 113;
                                        }
                                        break;
                                    case 2715:
                                        if (!str3.equals("V1")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.DEL;
                                        }
                                        break;
                                    case 2719:
                                        if (!str3.equals("V5")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 129;
                                        }
                                        break;
                                    case 3091:
                                        if (!str3.equals("b5")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.DLE;
                                        }
                                        break;
                                    case 3483:
                                        if (!str3.equals("mh")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 84;
                                        }
                                        break;
                                    case 73405:
                                        if (!str3.equals("JGZ")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 73;
                                        }
                                        break;
                                    case 75537:
                                        if (!str3.equals("M04")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 79;
                                        }
                                        break;
                                    case 75739:
                                        if (!str3.equals("M5c")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 80;
                                        }
                                        break;
                                    case 76779:
                                        if (!str3.equals("MX6")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 86;
                                        }
                                        break;
                                    case 78669:
                                        if (!str3.equals("P85")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 94;
                                        }
                                        break;
                                    case 79305:
                                        if (!str3.equals("PLE")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 107;
                                        }
                                        break;
                                    case 80618:
                                        if (!str3.equals("QX1")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 115;
                                        }
                                        break;
                                    case 88274:
                                        if (!str3.equals("Z80")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 139;
                                        }
                                        break;
                                    case 98846:
                                        if (!str3.equals("cv1")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.SUB;
                                        }
                                        break;
                                    case 98848:
                                        if (!str3.equals("cv3")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.ESC;
                                        }
                                        break;
                                    case 99329:
                                        if (!str3.equals("deb")) {
                                            b13 = -1;
                                        }
                                        break;
                                    case 101481:
                                        if (!str3.equals("flo")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 49;
                                        }
                                        break;
                                    case 1513190:
                                        if (!str3.equals("1601")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 0;
                                        }
                                        break;
                                    case 1514184:
                                        if (!str3.equals("1713")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 1;
                                        }
                                        break;
                                    case 1514185:
                                        if (!str3.equals("1714")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 2;
                                        }
                                        break;
                                    case 2133089:
                                        if (!str3.equals("F01H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 36;
                                        }
                                        break;
                                    case 2133091:
                                        if (!str3.equals("F01J")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 37;
                                        }
                                        break;
                                    case 2133120:
                                        if (!str3.equals("F02H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 38;
                                        }
                                        break;
                                    case 2133151:
                                        if (!str3.equals("F03H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 39;
                                        }
                                        break;
                                    case 2133182:
                                        if (!str3.equals("F04H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 40;
                                        }
                                        break;
                                    case 2133184:
                                        if (!str3.equals("F04J")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 41;
                                        }
                                        break;
                                    case 2436959:
                                        if (!str3.equals("P681")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 93;
                                        }
                                        break;
                                    case 2463773:
                                        if (!str3.equals("Q350")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 109;
                                        }
                                        break;
                                    case 2464648:
                                        if (!str3.equals("Q427")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 111;
                                        }
                                        break;
                                    case 2689555:
                                        if (!str3.equals("XE2X")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 136;
                                        }
                                        break;
                                    case 3154429:
                                        if (!str3.equals("fugu")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 50;
                                        }
                                        break;
                                    case 3284551:
                                        if (!str3.equals("kate")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 75;
                                        }
                                        break;
                                    case 3351335:
                                        if (!str3.equals("mido")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 85;
                                        }
                                        break;
                                    case 3386211:
                                        if (!str3.equals("p212")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 92;
                                        }
                                        break;
                                    case 41325051:
                                        if (!str3.equals("MEIZU_M5")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 83;
                                        }
                                        break;
                                    case 51349633:
                                        if (!str3.equals("601LV")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 3;
                                        }
                                        break;
                                    case 51350594:
                                        if (!str3.equals("602LV")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 4;
                                        }
                                        break;
                                    case 55178625:
                                        if (!str3.equals("Aura_Note_2")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.SI;
                                        }
                                        break;
                                    case 61542055:
                                        if (!str3.equals("A1601")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 7;
                                        }
                                        break;
                                    case 65355429:
                                        if (!str3.equals("E5643")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.RS;
                                        }
                                        break;
                                    case 66214468:
                                        if (!str3.equals("F3111")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 42;
                                        }
                                        break;
                                    case 66214470:
                                        if (!str3.equals("F3113")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 43;
                                        }
                                        break;
                                    case 66214473:
                                        if (!str3.equals("F3116")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 44;
                                        }
                                        break;
                                    case 66215429:
                                        if (!str3.equals("F3211")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 45;
                                        }
                                        break;
                                    case 66215431:
                                        if (!str3.equals("F3213")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 46;
                                        }
                                        break;
                                    case 66215433:
                                        if (!str3.equals("F3215")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 47;
                                        }
                                        break;
                                    case 66216390:
                                        if (!str3.equals("F3311")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 48;
                                        }
                                        break;
                                    case 76402249:
                                        if (!str3.equals("PRO7S")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 108;
                                        }
                                        break;
                                    case 76404105:
                                        if (!str3.equals("Q4260")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 110;
                                        }
                                        break;
                                    case 76404911:
                                        if (!str3.equals("Q4310")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 112;
                                        }
                                        break;
                                    case 80963634:
                                        if (!str3.equals("V23GB")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 128;
                                        }
                                        break;
                                    case 82882791:
                                        if (!str3.equals("X3_HK")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 135;
                                        }
                                        break;
                                    case 98715550:
                                        if (!str3.equals("i9031")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 67;
                                        }
                                        break;
                                    case 101370885:
                                        if (!str3.equals("l5460")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 76;
                                        }
                                        break;
                                    case 102844228:
                                        if (!str3.equals("le_x6")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 77;
                                        }
                                        break;
                                    case 165221241:
                                        if (!str3.equals("A2016a40")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 8;
                                        }
                                        break;
                                    case 182191441:
                                        if (!str3.equals("CPY83_I00")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.EM;
                                        }
                                        break;
                                    case 245388979:
                                        if (!str3.equals("marino_f")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 82;
                                        }
                                        break;
                                    case 287431619:
                                        if (!str3.equals("griffin")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 60;
                                        }
                                        break;
                                    case 307593612:
                                        if (!str3.equals("A7010a48")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.VT;
                                        }
                                        break;
                                    case 308517133:
                                        if (!str3.equals("A7020a48")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.FF;
                                        }
                                        break;
                                    case 316215098:
                                        if (!str3.equals("TB3-730F")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 122;
                                        }
                                        break;
                                    case 316215116:
                                        if (!str3.equals("TB3-730X")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 123;
                                        }
                                        break;
                                    case 316246811:
                                        if (!str3.equals("TB3-850F")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 124;
                                        }
                                        break;
                                    case 316246818:
                                        if (!str3.equals("TB3-850M")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 125;
                                        }
                                        break;
                                    case 407160593:
                                        if (!str3.equals("Pixi5-10_4G")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 106;
                                        }
                                        break;
                                    case 507412548:
                                        if (!str3.equals("QM16XE_U")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 114;
                                        }
                                        break;
                                    case 793982701:
                                        if (!str3.equals("GIONEE_WBL5708")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 57;
                                        }
                                        break;
                                    case 794038622:
                                        if (!str3.equals("GIONEE_WBL7365")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 58;
                                        }
                                        break;
                                    case 794040393:
                                        if (!str3.equals("GIONEE_WBL7519")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 59;
                                        }
                                        break;
                                    case 835649806:
                                        if (!str3.equals("manning")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 81;
                                        }
                                        break;
                                    case 917340916:
                                        if (!str3.equals("A7000plus")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 10;
                                        }
                                        break;
                                    case 958008161:
                                        if (!str3.equals("j2xlteins")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 72;
                                        }
                                        break;
                                    case 1060579533:
                                        if (!str3.equals("panell_d")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 96;
                                        }
                                        break;
                                    case 1150207623:
                                        if (!str3.equals("LS-5017")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 78;
                                        }
                                        break;
                                    case 1176899427:
                                        if (!str3.equals("itel_S41")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 71;
                                        }
                                        break;
                                    case 1280332038:
                                        if (!str3.equals("hwALE-H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 62;
                                        }
                                        break;
                                    case 1306947716:
                                        if (!str3.equals("EverStar_S")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 35;
                                        }
                                        break;
                                    case 1349174697:
                                        if (!str3.equals("htc_e56ml_dtul")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 61;
                                        }
                                        break;
                                    case 1522194893:
                                        if (!str3.equals("woods_f")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 133;
                                        }
                                        break;
                                    case 1691543273:
                                        if (!str3.equals("CPH1609")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.ETB;
                                        }
                                        break;
                                    case 1691544261:
                                        if (!str3.equals("CPH1715")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.CAN;
                                        }
                                        break;
                                    case 1709443163:
                                        if (!str3.equals("iball8735_9806")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 68;
                                        }
                                        break;
                                    case 1865889110:
                                        if (!str3.equals("santoni")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 117;
                                        }
                                        break;
                                    case 1906253259:
                                        if (!str3.equals("PB2-670M")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 100;
                                        }
                                        break;
                                    case 1977196784:
                                        if (!str3.equals("Infinix-X572")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 69;
                                        }
                                        break;
                                    case 2006372676:
                                        if (!str3.equals("BRAVIA_ATV3_4K")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 19;
                                        }
                                        break;
                                    case 2019281702:
                                        if (!str3.equals("DM-01K")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.GS;
                                        }
                                        break;
                                    case 2029784656:
                                        if (!str3.equals("HWBLN-H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Utf8.REPLACEMENT_BYTE;
                                        }
                                        break;
                                    case 2030379515:
                                        if (!str3.equals("HWCAM-H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 64;
                                        }
                                        break;
                                    case 2033393791:
                                        if (!str3.equals("ASUS_X00AD_2")) {
                                            b13 = -1;
                                        } else {
                                            b13 = Ascii.SO;
                                        }
                                        break;
                                    case 2047190025:
                                        if (!str3.equals("ELUGA_Note")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 32;
                                        }
                                        break;
                                    case 2047252157:
                                        if (!str3.equals("ELUGA_Prim")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 33;
                                        }
                                        break;
                                    case 2048319463:
                                        if (!str3.equals("HWVNS-H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 65;
                                        }
                                        break;
                                    case 2048855701:
                                        if (!str3.equals("HWWAS-H")) {
                                            b13 = -1;
                                        } else {
                                            b13 = 66;
                                        }
                                        break;
                                    default:
                                        b13 = -1;
                                        break;
                                }
                                switch (b13) {
                                    default:
                                        if (str2.hashCode() == -594534941) {
                                            break;
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
                                        z11 = true;
                                        break;
                                }
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
                            z11 = true;
                            break;
                    }
                }
                zzd = z11;
                zzc = true;
            }
        }
        return zzd;
    }

    private static List zzaN(Context context, zztb zztbVar, zzam zzamVar, boolean z11, boolean z12) throws zzth {
        String str = zzamVar.zzm;
        if (str == null) {
            return zzgaa.zzl();
        }
        if (zzfy.zza >= 26 && "video/dolby-vision".equals(str) && !zzaaf.zza(context)) {
            List listZzd = zztn.zzd(zztbVar, zzamVar, z11, z12);
            if (!listZzd.isEmpty()) {
                return listZzd;
            }
        }
        return zztn.zzf(zztbVar, zzamVar, z11, z12);
    }

    private final void zzaO() {
        zzdp zzdpVar = this.zzz;
        if (zzdpVar != null) {
            this.zzg.zzt(zzdpVar);
        }
    }

    @RequiresApi(17)
    private final void zzaP() {
        Surface surface = this.zzn;
        zzaak zzaakVar = this.zzo;
        if (surface == zzaakVar) {
            this.zzn = null;
        }
        if (zzaakVar != null) {
            zzaakVar.release();
            this.zzo = null;
        }
    }

    private final boolean zzaQ(zzsv zzsvVar) {
        if (zzfy.zza < 23 || zzaM(zzsvVar.zza)) {
            return false;
        }
        return !zzsvVar.zzf || zzaak.zzb(this.zze);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:40:0x0082  */
    public static int zzac(zzsv zzsvVar, zzam zzamVar) {
        int iIntValue;
        int i11 = zzamVar.zzr;
        int i12 = zzamVar.zzs;
        if (i11 != -1 && i12 != -1) {
            String str = zzamVar.zzm;
            str.getClass();
            if ("video/dolby-vision".equals(str)) {
                Pair pairZza = zztn.zza(zzamVar);
                str = (pairZza == null || !((iIntValue = ((Integer) pairZza.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? MimeTypes.VIDEO_H265 : MimeTypes.VIDEO_H264;
            }
            int i13 = 4;
            switch (str) {
                case "video/3gpp":
                case "video/mp4v-es":
                case "video/av01":
                case "video/x-vnd.on2.vp8":
                    return ((i11 * i12) * 3) / i13;
                case "video/hevc":
                    return Math.max(2097152, ((i11 * i12) * 3) / 4);
                case "video/avc":
                    String str2 = zzfy.zzd;
                    if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(zzfy.zzc) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !zzsvVar.zzf)))) {
                        return ((((i11 + 15) / 16) * ((i12 + 15) / 16)) * 768) / 4;
                    }
                    break;
                case "video/x-vnd.on2.vp9":
                    i13 = 8;
                    return ((i11 * i12) * 3) / i13;
            }
        }
        return -1;
    }

    public static int zzad(zzsv zzsvVar, zzam zzamVar) {
        if (zzamVar.zzn == -1) {
            return zzac(zzsvVar, zzamVar);
        }
        int size = zzamVar.zzo.size();
        int length = 0;
        for (int i11 = 0; i11 < size; i11++) {
            length += ((byte[]) zzamVar.zzo.get(i11)).length;
        }
        return zzamVar.zzn + length;
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final void zzA() {
        if (this.zzf.zzk()) {
            this.zzf.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    @TargetApi(17)
    public final void zzB() {
        try {
            super.zzB();
            this.zzB = false;
            if (this.zzo != null) {
            }
        } finally {
            this.zzB = false;
            if (this.zzo != null) {
                zzaP();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final void zzC() {
        this.zzs = 0;
        zzh();
        this.zzr = SystemClock.elapsedRealtime();
        this.zzv = 0L;
        this.zzw = 0;
        this.zzi.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final void zzD() {
        if (this.zzs > 0) {
            zzh();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.zzg.zzd(this.zzs, jElapsedRealtime - this.zzr);
            this.zzs = 0;
            this.zzr = jElapsedRealtime;
        }
        int i11 = this.zzw;
        if (i11 != 0) {
            this.zzg.zzr(this.zzv, i11);
            this.zzv = 0L;
            this.zzw = 0;
        }
        this.zzi.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmf
    public final void zzL(float f11, float f12) throws zziz {
        super.zzL(f11, f12);
        this.zzi.zzn(f11);
        if (this.zzE != null) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmf, com.google.android.gms.internal.ads.zzmh
    public final String zzT() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    @CallSuper
    public final void zzU(long j11, long j12) throws zziz {
        super.zzU(j11, j12);
        if (this.zzE == null) {
            return;
        }
        try {
            throw null;
        } catch (zzabn e11) {
            throw zzi(e11, e11.zza, false, 7001);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    public final boolean zzV() {
        if (!super.zzV()) {
            return false;
        }
        if (this.zzE == null) {
            return true;
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    public final boolean zzW() {
        boolean z11;
        zzaak zzaakVar;
        if (!super.zzW()) {
            z11 = false;
        } else {
            if (this.zzE != null) {
                throw null;
            }
            z11 = true;
        }
        if (!z11 || (((zzaakVar = this.zzo) == null || this.zzn != zzaakVar) && zzau() != null)) {
            return this.zzi.zzo(z11);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final float zzY(float f11, zzam zzamVar, zzam[] zzamVarArr) {
        float fMax = -1.0f;
        for (zzam zzamVar2 : zzamVarArr) {
            float f12 = zzamVar2.zzt;
            if (f12 != -1.0f) {
                fMax = Math.max(fMax, f12);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f11;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final int zzZ(zztb zztbVar, zzam zzamVar) throws zzth {
        boolean z11;
        if (!zzcb.zzh(zzamVar.zzm)) {
            return 128;
        }
        int i11 = 1;
        int i12 = 0;
        boolean z12 = zzamVar.zzp != null;
        List listZzaN = zzaN(this.zze, zztbVar, zzamVar, z12, false);
        if (z12 && listZzaN.isEmpty()) {
            listZzaN = zzaN(this.zze, zztbVar, zzamVar, false, false);
        }
        if (!listZzaN.isEmpty()) {
            if (zzsz.zzaJ(zzamVar)) {
                zzsv zzsvVar = (zzsv) listZzaN.get(0);
                boolean zZze = zzsvVar.zze(zzamVar);
                if (!zZze) {
                    int i13 = 1;
                    while (true) {
                        if (i13 >= listZzaN.size()) {
                            z11 = true;
                            break;
                        }
                        zzsv zzsvVar2 = (zzsv) listZzaN.get(i13);
                        if (zzsvVar2.zze(zzamVar)) {
                            zzsvVar = zzsvVar2;
                            z11 = false;
                            zZze = true;
                            break;
                        }
                        i13++;
                    }
                } else {
                    z11 = true;
                    break;
                }
                int i14 = true != zZze ? 3 : 4;
                int i15 = true != zzsvVar.zzf(zzamVar) ? 8 : 16;
                int i16 = true != zzsvVar.zzg ? 0 : 64;
                int i17 = true != z11 ? 0 : 128;
                if (zzfy.zza >= 26 && "video/dolby-vision".equals(zzamVar.zzm) && !zzaaf.zza(this.zze)) {
                    i17 = 256;
                }
                if (zZze) {
                    List listZzaN2 = zzaN(this.zze, zztbVar, zzamVar, z12, true);
                    if (!listZzaN2.isEmpty()) {
                        zzsv zzsvVar3 = (zzsv) zztn.zzg(listZzaN2, zzamVar).get(0);
                        if (zzsvVar3.zze(zzamVar) && zzsvVar3.zzf(zzamVar)) {
                            i12 = 32;
                        }
                    }
                }
                return i14 | i15 | i12 | i16 | i17;
            }
            i11 = 2;
        }
        return i11 | 128;
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final boolean zza(long j11, long j12, boolean z11) {
        return j11 < -30000 && !z11;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    @CallSuper
    public final void zzaA(zzam zzamVar) throws zziz {
        if (this.zzA && !this.zzB && !this.zzf.zzk()) {
            try {
                this.zzf.zzd(zzamVar);
                this.zzf.zzh(zzas());
                zzaal zzaalVar = this.zzD;
                if (zzaalVar != null) {
                    this.zzf.zzj(zzaalVar);
                }
            } catch (zzabn e11) {
                throw zzi(e11, zzamVar, false, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED);
            }
        }
        if (this.zzE != null || !this.zzf.zzk()) {
            this.zzB = true;
        } else {
            this.zzE = this.zzf.zzb();
            zzgfe.zzb();
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    @CallSuper
    public final void zzaC() {
        super.zzaC();
        this.zzu = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final boolean zzaI(zzsv zzsvVar) {
        return this.zzn != null || zzaQ(zzsvVar);
    }

    public final void zzaK(int i11, int i12) {
        zzir zzirVar = ((zzsz) this).zza;
        zzirVar.zzh += i11;
        int i13 = i11 + i12;
        zzirVar.zzg += i13;
        this.zzs += i13;
        int i14 = this.zzt + i13;
        this.zzt = i14;
        zzirVar.zzi = Math.max(i14, zzirVar.zzi);
    }

    public final void zzaL(long j11) {
        zzir zzirVar = ((zzsz) this).zza;
        zzirVar.zzk += j11;
        zzirVar.zzl++;
        this.zzv += j11;
        this.zzw++;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final zzis zzaa(zzsv zzsvVar, zzam zzamVar, zzam zzamVar2) {
        int i11;
        int i12;
        zzis zzisVarZzb = zzsvVar.zzb(zzamVar, zzamVar2);
        int i13 = zzisVarZzb.zze;
        zzaag zzaagVar = this.zzk;
        zzaagVar.getClass();
        if (zzamVar2.zzr > zzaagVar.zza || zzamVar2.zzs > zzaagVar.zzb) {
            i13 |= 256;
        }
        if (zzad(zzsvVar, zzamVar2) > zzaagVar.zzc) {
            i13 |= 64;
        }
        String str = zzsvVar.zza;
        if (i13 != 0) {
            i12 = i13;
            i11 = 0;
        } else {
            i11 = zzisVarZzb.zzd;
            i12 = 0;
        }
        return new zzis(str, zzamVar, zzamVar2, i11, i12);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    @Nullable
    public final zzis zzab(zzlb zzlbVar) throws zziz {
        zzis zzisVarZzab = super.zzab(zzlbVar);
        zzam zzamVar = zzlbVar.zza;
        zzamVar.getClass();
        this.zzg.zzf(zzamVar, zzisVarZzab);
        return zzisVarZzab;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0229  */
    /* JADX WARN: Code duplicated, block: B:69:0x0171  */
    /* JADX WARN: Code duplicated, block: B:72:0x0181  */
    /* JADX WARN: Code duplicated, block: B:74:0x019a  */
    /* JADX WARN: Code duplicated, block: B:82:0x01db  */
    /* JADX WARN: Code duplicated, block: B:84:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:86:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:89:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:91:0x0204  */
    /* JADX WARN: Code duplicated, block: B:93:0x0208  */
    /* JADX WARN: Code duplicated, block: B:95:0x0217  */
    /* JADX WARN: Code duplicated, block: B:99:0x0221  */
    @Override // com.google.android.gms.internal.ads.zzsz
    @TargetApi(17)
    public final zzsp zzae(zzsv zzsvVar, zzam zzamVar, @Nullable MediaCrypto mediaCrypto, float f11) {
        String str;
        Point pointZza;
        int i11;
        int i12;
        boolean z11;
        MediaFormat mediaFormat;
        float f12;
        zzt zztVar;
        Pair pairZza;
        byte[] bArr;
        int iZzac;
        zzaak zzaakVar = this.zzo;
        if (zzaakVar != null) {
            if (zzaakVar.zza != zzsvVar.zzf) {
                zzaP();
            }
        }
        String str2 = zzsvVar.zzc;
        zzam[] zzamVarArrZzS = zzS();
        int iMax = zzamVar.zzr;
        int iMax2 = zzamVar.zzs;
        int iZzad = zzad(zzsvVar, zzamVar);
        int length = zzamVarArrZzS.length;
        if (length != 1) {
            boolean z12 = false;
            for (int i13 = 0; i13 < length; i13++) {
                zzam zzamVarZzac = zzamVarArrZzS[i13];
                if (zzamVar.zzy != null && zzamVarZzac.zzy == null) {
                    zzak zzakVarZzb = zzamVarZzac.zzb();
                    zzakVarZzb.zzA(zzamVar.zzy);
                    zzamVarZzac = zzakVarZzb.zzac();
                }
                if (zzsvVar.zzb(zzamVar, zzamVarZzac).zzd != 0) {
                    int i14 = zzamVarZzac.zzr;
                    z12 |= i14 == -1 || zzamVarZzac.zzs == -1;
                    iMax = Math.max(iMax, i14);
                    iMax2 = Math.max(iMax2, zzamVarZzac.zzs);
                    iZzad = Math.max(iZzad, zzad(zzsvVar, zzamVarZzac));
                }
            }
            if (z12) {
                zzff.zzf("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
                int i15 = zzamVar.zzs;
                int i16 = zzamVar.zzr;
                boolean z13 = i15 > i16;
                int i17 = z13 ? i15 : i16;
                if (true == z13) {
                    i15 = i16;
                }
                int[] iArr = zzb;
                int i18 = 0;
                while (true) {
                    if (i18 < 9) {
                        float f13 = i15;
                        float f14 = i17;
                        str = str2;
                        int i19 = iArr[i18];
                        int[] iArr2 = iArr;
                        float f15 = i19;
                        if (i19 > i17 && (i11 = (int) (f15 * (f13 / f14))) > i15) {
                            int i21 = zzfy.zza;
                            int i22 = true != z13 ? i19 : i11;
                            if (true != z13) {
                                i19 = i11;
                            }
                            pointZza = zzsvVar.zza(i22, i19);
                            float f16 = zzamVar.zzt;
                            if (pointZza != null) {
                                i12 = i15;
                                if (zzsvVar.zzg(pointZza.x, pointZza.y, f16)) {
                                    break;
                                }
                            } else {
                                i12 = i15;
                            }
                            i18++;
                            str2 = str;
                            iArr = iArr2;
                            i15 = i12;
                        }
                    } else {
                        str = str2;
                    }
                    pointZza = null;
                    break;
                }
                if (pointZza != null) {
                    iMax = Math.max(iMax, pointZza.x);
                    iMax2 = Math.max(iMax2, pointZza.y);
                    zzak zzakVarZzb2 = zzamVar.zzb();
                    zzakVarZzb2.zzab(iMax);
                    zzakVarZzb2.zzI(iMax2);
                    iZzad = Math.max(iZzad, zzac(zzsvVar, zzakVarZzb2.zzac()));
                    zzff.zzf("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
                }
            }
            zzaag zzaagVar = new zzaag(iMax, iMax2, iZzad);
            this.zzk = zzaagVar;
            z11 = this.zzh;
            mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", str);
            mediaFormat.setInteger("width", zzamVar.zzr);
            mediaFormat.setInteger("height", zzamVar.zzs);
            zzfi.zzb(mediaFormat, zzamVar.zzo);
            f12 = zzamVar.zzt;
            if (f12 != -1.0f) {
                mediaFormat.setFloat("frame-rate", f12);
            }
            zzfi.zza(mediaFormat, "rotation-degrees", zzamVar.zzu);
            zztVar = zzamVar.zzy;
            if (zztVar != null) {
                zzfi.zza(mediaFormat, "color-transfer", zztVar.zzf);
                zzfi.zza(mediaFormat, "color-standard", zztVar.zzd);
                zzfi.zza(mediaFormat, "color-range", zztVar.zze);
                bArr = zztVar.zzg;
                if (bArr != null) {
                    mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
                }
            }
            if ("video/dolby-vision".equals(zzamVar.zzm) && (pairZza = zztn.zza(zzamVar)) != null) {
                zzfi.zza(mediaFormat, Scopes.PROFILE, ((Integer) pairZza.first).intValue());
            }
            mediaFormat.setInteger("max-width", zzaagVar.zza);
            mediaFormat.setInteger("max-height", zzaagVar.zzb);
            zzfi.zza(mediaFormat, "max-input-size", zzaagVar.zzc);
            if (zzfy.zza >= 23) {
                mediaFormat.setInteger(TrackingKey.PRIORITY, 0);
                if (f11 != -1.0f) {
                    mediaFormat.setFloat("operating-rate", f11);
                }
            }
            if (z11) {
                mediaFormat.setInteger("no-post-process", 1);
                mediaFormat.setInteger("auto-frc", 0);
            }
            if (this.zzn == null) {
                if (zzaQ(zzsvVar)) {
                    throw new IllegalStateException();
                }
                if (this.zzo == null) {
                    this.zzo = zzaak.zza(this.zze, zzsvVar.zzf);
                }
                this.zzn = this.zzo;
            }
            if (this.zzE == null) {
                return zzsp.zzb(zzsvVar, mediaFormat, zzamVar, this.zzn, null);
            }
            throw null;
        }
        if (iZzad != -1 && (iZzac = zzac(zzsvVar, zzamVar)) != -1) {
            iZzad = Math.min((int) (iZzad * 1.5f), iZzac);
        }
        str = str2;
        zzaag zzaagVar2 = new zzaag(iMax, iMax2, iZzad);
        this.zzk = zzaagVar2;
        z11 = this.zzh;
        mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", zzamVar.zzr);
        mediaFormat.setInteger("height", zzamVar.zzs);
        zzfi.zzb(mediaFormat, zzamVar.zzo);
        f12 = zzamVar.zzt;
        if (f12 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f12);
        }
        zzfi.zza(mediaFormat, "rotation-degrees", zzamVar.zzu);
        zztVar = zzamVar.zzy;
        if (zztVar != null) {
            zzfi.zza(mediaFormat, "color-transfer", zztVar.zzf);
            zzfi.zza(mediaFormat, "color-standard", zztVar.zzd);
            zzfi.zza(mediaFormat, "color-range", zztVar.zze);
            bArr = zztVar.zzg;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(zzamVar.zzm)) {
            zzfi.zza(mediaFormat, Scopes.PROFILE, ((Integer) pairZza.first).intValue());
        }
        mediaFormat.setInteger("max-width", zzaagVar2.zza);
        mediaFormat.setInteger("max-height", zzaagVar2.zzb);
        zzfi.zza(mediaFormat, "max-input-size", zzaagVar2.zzc);
        if (zzfy.zza >= 23) {
            mediaFormat.setInteger(TrackingKey.PRIORITY, 0);
            if (f11 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f11);
            }
        }
        if (z11) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (this.zzn == null) {
            if (zzaQ(zzsvVar)) {
                throw new IllegalStateException();
            }
            if (this.zzo == null) {
                this.zzo = zzaak.zza(this.zze, zzsvVar.zzf);
            }
            this.zzn = this.zzo;
        }
        if (this.zzE == null) {
            return zzsp.zzb(zzsvVar, mediaFormat, zzamVar, this.zzn, null);
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final List zzaf(zztb zztbVar, zzam zzamVar, boolean z11) throws zzth {
        return zztn.zzg(zzaN(this.zze, zztbVar, zzamVar, false, false), zzamVar);
    }

    @RequiresApi(21)
    public final void zzag(zzsr zzsrVar, int i11, long j11, long j12) {
        Surface surface;
        int i12 = zzfy.zza;
        Trace.beginSection("releaseOutputBuffer");
        zzsrVar.zzm(i11, j12);
        Trace.endSection();
        ((zzsz) this).zza.zze++;
        this.zzt = 0;
        if (this.zzE == null) {
            zzdp zzdpVar = this.zzy;
            if (!zzdpVar.equals(zzdp.zza) && !zzdpVar.equals(this.zzz)) {
                this.zzz = zzdpVar;
                this.zzg.zzt(zzdpVar);
            }
            if (!this.zzi.zzp() || (surface = this.zzn) == null) {
                return;
            }
            this.zzg.zzq(surface);
            this.zzp = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    @TargetApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final void zzah(zzih zzihVar) throws zziz {
        if (this.zzm) {
            ByteBuffer byteBuffer = zzihVar.zzf;
            byteBuffer.getClass();
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
                        zzsr zzsrVarZzau = zzau();
                        zzsrVarZzau.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzsrVarZzau.zzp(bundle);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzai(Exception exc) {
        zzff.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzaj(String str, zzsp zzspVar, long j11, long j12) {
        this.zzg.zza(str, j11, j12);
        this.zzl = zzaM(str);
        zzsv zzsvVarZzaw = zzaw();
        zzsvVarZzaw.getClass();
        boolean z11 = false;
        if (zzfy.zza >= 29 && MimeTypes.VIDEO_VP9.equals(zzsvVarZzaw.zzb)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzsvVarZzaw.zzh()) {
                if (codecProfileLevel.profile == 16384) {
                    z11 = true;
                    break;
                }
            }
        }
        this.zzm = z11;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzak(String str) {
        this.zzg.zzb(str);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzal(zzam zzamVar, @Nullable MediaFormat mediaFormat) {
        zzsr zzsrVarZzau = zzau();
        if (zzsrVarZzau != null) {
            zzsrVarZzau.zzq(this.zzq);
        }
        mediaFormat.getClass();
        boolean z11 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z11 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer2 = z11 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        float f11 = zzamVar.zzv;
        int i11 = zzfy.zza;
        int i12 = zzamVar.zzu;
        if (i12 == 90 || i12 == 270) {
            f11 = 1.0f / f11;
            int i13 = integer2;
            integer2 = integer;
            integer = i13;
        }
        this.zzy = new zzdp(integer, integer2, 0, f11);
        this.zzi.zzl(zzamVar.zzt);
        if (this.zzE == null) {
            return;
        }
        zzak zzakVarZzb = zzamVar.zzb();
        zzakVarZzb.zzab(integer);
        zzakVarZzb.zzI(integer2);
        zzakVarZzb.zzV(0);
        zzakVarZzb.zzS(f11);
        zzakVarZzb.zzac();
        throw null;
    }

    public final void zzam(zzsr zzsrVar, int i11, long j11) {
        int i12 = zzfy.zza;
        Trace.beginSection("skipVideoBuffer");
        zzsrVar.zzn(i11, false);
        Trace.endSection();
        ((zzsz) this).zza.zzf++;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final void zzan() {
        this.zzi.zzf();
        int i11 = zzfy.zza;
        if (this.zzf.zzk()) {
            this.zzf.zzh(zzas());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final boolean zzap(long j11, long j12, @Nullable zzsr zzsrVar, @Nullable ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, zzam zzamVar) throws zziz {
        zzsrVar.getClass();
        long jZzas = j13 - zzas();
        int iZza = this.zzi.zza(j13, j11, j12, zzat(), z12, this.zzj);
        if (z11 && !z12) {
            zzam(zzsrVar, i11, jZzas);
            return true;
        }
        if (this.zzn == this.zzo) {
            if (this.zzj.zzc() < 30000) {
                zzam(zzsrVar, i11, jZzas);
                zzaL(this.zzj.zzc());
                return true;
            }
        } else {
            if (this.zzE != null) {
                try {
                    throw null;
                } catch (zzabn e11) {
                    throw zzi(e11, e11.zza, false, 7001);
                }
            }
            if (iZza == 0) {
                zzh();
                long jNanoTime = System.nanoTime();
                int i14 = zzfy.zza;
                zzag(zzsrVar, i11, jZzas, jNanoTime);
                zzaL(this.zzj.zzc());
                return true;
            }
            if (iZza == 1) {
                zzaam zzaamVar = this.zzj;
                long jZzd = zzaamVar.zzd();
                long jZzc = zzaamVar.zzc();
                int i15 = zzfy.zza;
                if (jZzd == this.zzx) {
                    zzam(zzsrVar, i11, jZzas);
                } else {
                    zzag(zzsrVar, i11, jZzas, jZzd);
                }
                zzaL(jZzc);
                this.zzx = jZzd;
                return true;
            }
            if (iZza == 2) {
                int i16 = zzfy.zza;
                Trace.beginSection("dropVideoBuffer");
                zzsrVar.zzn(i11, false);
                Trace.endSection();
                zzaK(0, 1);
                zzaL(this.zzj.zzc());
                return true;
            }
            if (iZza == 3) {
                zzam(zzsrVar, i11, jZzas);
                zzaL(this.zzj.zzc());
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final int zzar(zzih zzihVar) {
        int i11 = zzfy.zza;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    public final zzst zzav(Throwable th2, @Nullable zzsv zzsvVar) {
        return new zzaae(th2, zzsvVar, this.zzn);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    @CallSuper
    public final void zzay(long j11) {
        super.zzay(j11);
        this.zzu--;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    @CallSuper
    public final void zzaz(zzih zzihVar) throws zziz {
        this.zzu++;
        int i11 = zzfy.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final boolean zzb(long j11, long j12) {
        return j11 < -30000 && j12 > 100000;
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final boolean zzc(long j11, long j12, long j13, boolean z11, boolean z12) throws zziz {
        int iZzd;
        if (j11 >= -500000 || z11 || (iZzd = zzd(j12)) == 0) {
            return false;
        }
        if (z12) {
            zzir zzirVar = ((zzsz) this).zza;
            zzirVar.zzd += iZzd;
            zzirVar.zzf += this.zzu;
        } else {
            ((zzsz) this).zza.zzj++;
            zzaK(iZzd, this.zzu);
        }
        zzaE();
        if (this.zzE == null) {
            return true;
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmf
    public final void zzs() {
        this.zzi.zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.zzsr] */
    /* JADX WARN: Type inference failed for: r5v14, types: [com.google.android.gms.internal.ads.zzabp] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.google.android.gms.internal.ads.zzaao] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [com.google.android.gms.internal.ads.zzaak] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
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
    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzma
    public final void zzt(int i11, @Nullable Object obj) throws zziz {
        ?? Zza;
        ?? r11;
        ?? r12;
        Surface surface;
        Surface surface2;
        if (i11 != 1) {
            if (i11 == 7) {
                obj.getClass();
                zzaal zzaalVar = (zzaal) obj;
                this.zzD = zzaalVar;
                this.zzf.zzj(zzaalVar);
                return;
            }
            if (i11 == 10) {
                obj.getClass();
                int iIntValue = ((Integer) obj).intValue();
                if (this.zzC != iIntValue) {
                    this.zzC = iIntValue;
                    return;
                }
                return;
            }
            if (i11 == 4) {
                obj.getClass();
                int iIntValue2 = ((Integer) obj).intValue();
                this.zzq = iIntValue2;
                zzsr zzsrVarZzau = zzau();
                if (zzsrVarZzau != null) {
                    zzsrVarZzau.zzq(iIntValue2);
                    return;
                }
                return;
            }
            if (i11 == 5) {
                zzaao zzaaoVar = this.zzi;
                obj.getClass();
                zzaaoVar.zzj(((Integer) obj).intValue());
                return;
            } else if (i11 == 13) {
                obj.getClass();
                this.zzf.zzi((List) obj);
                this.zzA = true;
                return;
            } else {
                if (i11 != 14) {
                    return;
                }
                obj.getClass();
                zzfq zzfqVar = (zzfq) obj;
                if (zzfqVar.zzb() == 0 || zzfqVar.zza() == 0 || (surface2 = this.zzn) == null) {
                    return;
                }
                this.zzf.zzg(surface2, zzfqVar);
                return;
            }
        }
        if (obj instanceof Surface) {
            surface = (Surface) obj;
        } else {
            Zza = 0;
        }
        if (Zza == 0) {
            zzaak zzaakVar = this.zzo;
            if (zzaakVar != null) {
                Zza = surface;
                Zza = zzaakVar;
            } else {
                zzsv zzsvVarZzaw = zzaw();
                if (zzsvVarZzaw != null && zzaQ(zzsvVarZzaw)) {
                    Zza = surface;
                    Zza = zzaak.zza(this.zze, zzsvVarZzaw.zzf);
                    this.zzo = Zza;
                }
            }
        }
        Zza = surface;
        Zza = surface;
        Zza = surface;
        if (this.zzn == Zza) {
            if (Zza == 0 || Zza == this.zzo) {
                return;
            }
            zzaO();
            Surface surface3 = this.zzn;
            if (surface3 == null || !this.zzp) {
                return;
            }
            this.zzg.zzq(surface3);
            return;
        }
        this.zzn = Zza;
        this.zzi.zzm(Zza);
        this.zzp = false;
        int iZzbf = zzbf();
        ?? Zzau = zzau();
        if (Zzau != 0 && !this.zzf.zzk()) {
            if (zzfy.zza < 23) {
                r11 = Zza;
                r11 = Zza;
                r12 = Zza;
                zzaB();
                zzax();
                r11 = r12;
            } else {
                if (Zza != 0) {
                    r12 = Zza;
                    if (!this.zzl) {
                        Zzau.zzo(Zza);
                        r11 = Zza;
                    }
                } else {
                    r12 = 0;
                }
                r11 = Zza;
                r11 = Zza;
                r12 = Zza;
                zzaB();
                zzax();
                r11 = r12;
            }
        }
        if (r11 == 0 || r11 == this.zzo) {
            this.zzz = null;
            if (this.zzf.zzk()) {
                this.zzf.zzc();
            }
        } else {
            zzaO();
            if (iZzbf == 2) {
                this.zzi.zzc();
            }
            if (this.zzf.zzk()) {
                this.zzf.zzg(r11, zzfq.zza);
            }
        }
        int i12 = zzfy.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    public final void zzw() {
        this.zzz = null;
        this.zzi.zzd();
        int i11 = zzfy.zza;
        this.zzp = false;
        try {
            super.zzw();
        } finally {
            this.zzg.zzc(((zzsz) this).zza);
            this.zzg.zzt(zzdp.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    public final void zzx(boolean z11, boolean z12) throws zziz {
        super.zzx(z11, z12);
        zzm();
        this.zzg.zze(((zzsz) this).zza);
        this.zzi.zze(z12);
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final void zzy() {
        zzaao zzaaoVar = this.zzi;
        zzel zzelVarZzh = zzh();
        zzaaoVar.zzk(zzelVarZzh);
        this.zzf.zzf(zzelVarZzh);
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    public final void zzz(long j11, boolean z11) throws zziz {
        if (this.zzE != null) {
            throw null;
        }
        super.zzz(j11, z11);
        if (this.zzf.zzk()) {
            this.zzf.zzh(zzas());
        }
        this.zzi.zzi();
        if (z11) {
            this.zzi.zzc();
        }
        int i11 = zzfy.zza;
        this.zzt = 0;
    }
}
