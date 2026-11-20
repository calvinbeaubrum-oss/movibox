package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.android.gms.common.util.CollectionUtils;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbvq extends zzbvw {
    static final Set zza = CollectionUtils.setOf("top-left", "top-right", "top-center", TtmlNode.CENTER, "bottom-left", "bottom-right", "bottom-center");
    private String zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private final Object zzj;
    private final zzcjk zzk;
    private final Activity zzl;
    private zzcla zzm;
    private ImageView zzn;
    private LinearLayout zzo;
    private final zzbvx zzp;
    private PopupWindow zzq;
    private RelativeLayout zzr;
    private ViewGroup zzs;

    public zzbvq(zzcjk zzcjkVar, zzbvx zzbvxVar) {
        super(zzcjkVar, "resize");
        this.zzb = "top-right";
        this.zzc = true;
        this.zzd = 0;
        this.zze = 0;
        this.zzf = -1;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = -1;
        this.zzj = new Object();
        this.zzk = zzcjkVar;
        this.zzl = zzcjkVar.zzi();
        this.zzp = zzbvxVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzc(boolean z11) {
        this.zzq.dismiss();
        this.zzr.removeView((View) this.zzk);
        ViewGroup viewGroup = this.zzs;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzn);
            this.zzs.addView((View) this.zzk);
            this.zzk.zzah(this.zzm);
        }
        if (z11) {
            zzl(TmcEngineFactory.ENGINE_TYPE_DEFAULT);
            zzbvx zzbvxVar = this.zzp;
            if (zzbvxVar != null) {
                zzbvxVar.zzb();
            }
        }
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzo = null;
    }

    public final void zza(final boolean z11) {
        synchronized (this.zzj) {
            try {
                if (this.zzq != null) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkp)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                        zzc(z11);
                    } else {
                        zzcep.zze.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbvo
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzc(z11);
                            }
                        });
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:129:0x0262 A[Catch: all -> 0x0012, TryCatch #0 {all -> 0x0012, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:11:0x0015, B:13:0x001d, B:14:0x0022, B:16:0x0024, B:18:0x0030, B:19:0x0035, B:21:0x0037, B:23:0x003f, B:24:0x0044, B:26:0x0046, B:28:0x0054, B:29:0x0065, B:31:0x0073, B:32:0x0084, B:34:0x0092, B:35:0x00a3, B:37:0x00b1, B:38:0x00c2, B:40:0x00d0, B:41:0x00de, B:43:0x00ec, B:44:0x00ee, B:46:0x00f2, B:48:0x00f6, B:50:0x00fe, B:53:0x0106, B:57:0x012c, B:63:0x0138, B:129:0x0262, B:130:0x0267, B:132:0x0269, B:134:0x0289, B:136:0x028d, B:138:0x029a, B:140:0x02d6, B:172:0x038f, B:179:0x03be, B:180:0x03d6, B:181:0x03f7, B:183:0x03ff, B:184:0x0406, B:185:0x042c, B:188:0x042f, B:190:0x0454, B:191:0x0469, B:173:0x0396, B:174:0x039d, B:175:0x03a4, B:176:0x03ab, B:177:0x03b1, B:178:0x03b8, B:139:0x02d3, B:193:0x046b, B:194:0x0470, B:65:0x0140, B:67:0x0144, B:95:0x0197, B:96:0x01a1, B:105:0x01f4, B:107:0x01f7, B:109:0x01fb, B:112:0x0202, B:97:0x01a5, B:98:0x01af, B:99:0x01b6, B:100:0x01c2, B:101:0x01ca, B:102:0x01de, B:103:0x01ea, B:113:0x0213, B:119:0x023d, B:125:0x024d, B:122:0x0243, B:124:0x024b, B:116:0x0235, B:118:0x023b, B:126:0x0252, B:127:0x0259, B:196:0x0472, B:197:0x0477, B:199:0x0479, B:200:0x047e), top: B:204:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0269 A[Catch: all -> 0x0012, TryCatch #0 {all -> 0x0012, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:11:0x0015, B:13:0x001d, B:14:0x0022, B:16:0x0024, B:18:0x0030, B:19:0x0035, B:21:0x0037, B:23:0x003f, B:24:0x0044, B:26:0x0046, B:28:0x0054, B:29:0x0065, B:31:0x0073, B:32:0x0084, B:34:0x0092, B:35:0x00a3, B:37:0x00b1, B:38:0x00c2, B:40:0x00d0, B:41:0x00de, B:43:0x00ec, B:44:0x00ee, B:46:0x00f2, B:48:0x00f6, B:50:0x00fe, B:53:0x0106, B:57:0x012c, B:63:0x0138, B:129:0x0262, B:130:0x0267, B:132:0x0269, B:134:0x0289, B:136:0x028d, B:138:0x029a, B:140:0x02d6, B:172:0x038f, B:179:0x03be, B:180:0x03d6, B:181:0x03f7, B:183:0x03ff, B:184:0x0406, B:185:0x042c, B:188:0x042f, B:190:0x0454, B:191:0x0469, B:173:0x0396, B:174:0x039d, B:175:0x03a4, B:176:0x03ab, B:177:0x03b1, B:178:0x03b8, B:139:0x02d3, B:193:0x046b, B:194:0x0470, B:65:0x0140, B:67:0x0144, B:95:0x0197, B:96:0x01a1, B:105:0x01f4, B:107:0x01f7, B:109:0x01fb, B:112:0x0202, B:97:0x01a5, B:98:0x01af, B:99:0x01b6, B:100:0x01c2, B:101:0x01ca, B:102:0x01de, B:103:0x01ea, B:113:0x0213, B:119:0x023d, B:125:0x024d, B:122:0x0243, B:124:0x024b, B:116:0x0235, B:118:0x023b, B:126:0x0252, B:127:0x0259, B:196:0x0472, B:197:0x0477, B:199:0x0479, B:200:0x047e), top: B:204:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x0378  */
    /* JADX WARN: Code duplicated, block: B:88:0x018a  */
    public final void zzb(Map map) {
        int[] iArr;
        ViewParent parent;
        byte b11;
        byte b12;
        int i11;
        int i12;
        int i13;
        int i14;
        synchronized (this.zzj) {
            try {
                if (this.zzl == null) {
                    zzh("Not an activity context. Cannot resize.");
                    return;
                }
                if (this.zzk.zzO() == null) {
                    zzh("Webview is not yet available, size is not set.");
                    return;
                }
                if (this.zzk.zzO().zzi()) {
                    zzh("Is interstitial. Cannot resize an interstitial.");
                    return;
                }
                if (this.zzk.zzaC()) {
                    zzh("Cannot resize an expanded banner.");
                    return;
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    this.zzi = com.google.android.gms.ads.internal.util.zzt.zzN((String) map.get("width"));
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    this.zzf = com.google.android.gms.ads.internal.util.zzt.zzN((String) map.get("height"));
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    this.zzg = com.google.android.gms.ads.internal.util.zzt.zzN((String) map.get("offsetX"));
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    this.zzh = com.google.android.gms.ads.internal.util.zzt.zzN((String) map.get("offsetY"));
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
                    this.zzc = Boolean.parseBoolean((String) map.get("allowOffscreen"));
                }
                String str = (String) map.get("customClosePosition");
                if (!TextUtils.isEmpty(str)) {
                    this.zzb = str;
                }
                if (this.zzi < 0 || this.zzf < 0) {
                    zzh("Invalid width and height options. Cannot resize.");
                    return;
                }
                Window window = this.zzl.getWindow();
                if (window != null && window.getDecorView() != null) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    int[] iArrZzU = com.google.android.gms.ads.internal.util.zzt.zzU(this.zzl);
                    com.google.android.gms.ads.internal.zzt.zzp();
                    int[] iArrZzQ = com.google.android.gms.ads.internal.util.zzt.zzQ(this.zzl);
                    int i15 = iArrZzU[0];
                    int i16 = iArrZzU[1];
                    int i17 = this.zzi;
                    if (i17 < 50 || i17 > i15) {
                        zzcec.zzj("Width is too small or too large.");
                    } else {
                        int i18 = this.zzf;
                        if (i18 < 50 || i18 > i16) {
                            zzcec.zzj("Height is too small or too large.");
                        } else {
                            if (i18 != i16 || i17 != i15) {
                                if (this.zzc) {
                                    switch (this.zzb) {
                                        case "center":
                                            b12 = 2;
                                            break;
                                        case "top-left":
                                            b12 = 0;
                                            break;
                                        case "bottom-left":
                                            b12 = 3;
                                            break;
                                        case "bottom-right":
                                            b12 = 5;
                                            break;
                                        case "bottom-center":
                                            b12 = 4;
                                            break;
                                        case "top-center":
                                            b12 = 1;
                                            break;
                                        default:
                                            b12 = -1;
                                            break;
                                    }
                                    if (b12 == 0) {
                                        i11 = this.zzd + this.zzg;
                                        i12 = this.zze;
                                    } else if (b12 != 1) {
                                        if (b12 != 2) {
                                            if (b12 == 3) {
                                                i11 = this.zzd + this.zzg;
                                                i14 = this.zze;
                                            } else if (b12 == 4) {
                                                i11 = ((this.zzd + this.zzg) + (i17 >> 1)) - 25;
                                                i14 = this.zze;
                                            } else if (b12 != 5) {
                                                i11 = ((this.zzd + this.zzg) + i17) - 50;
                                                i12 = this.zze;
                                            } else {
                                                i11 = ((this.zzd + this.zzg) + i17) - 50;
                                                i14 = this.zze;
                                            }
                                            i13 = ((i14 + this.zzh) + i18) - 50;
                                        } else {
                                            i11 = ((this.zzd + this.zzg) + (i17 >> 1)) - 25;
                                            i13 = ((this.zze + this.zzh) + (i18 >> 1)) - 25;
                                        }
                                        if (i11 < 0 && i11 + 50 <= i15 && i13 >= iArrZzQ[0] && i13 + 50 <= iArrZzQ[1]) {
                                            iArr = new int[]{this.zzd + this.zzg, this.zze + this.zzh};
                                        }
                                    } else {
                                        i11 = ((this.zzd + this.zzg) + (i17 >> 1)) - 25;
                                        i12 = this.zze;
                                    }
                                    i13 = i12 + this.zzh;
                                    if (i11 < 0) {
                                    }
                                } else {
                                    com.google.android.gms.ads.internal.zzt.zzp();
                                    int[] iArrZzU2 = com.google.android.gms.ads.internal.util.zzt.zzU(this.zzl);
                                    com.google.android.gms.ads.internal.zzt.zzp();
                                    int[] iArrZzQ2 = com.google.android.gms.ads.internal.util.zzt.zzQ(this.zzl);
                                    int i19 = iArrZzU2[0];
                                    int i21 = this.zzd + this.zzg;
                                    int i22 = this.zze + this.zzh;
                                    if (i21 < 0) {
                                        i21 = 0;
                                    } else {
                                        int i23 = this.zzi;
                                        if (i21 + i23 > i19) {
                                            i21 = i19 - i23;
                                        }
                                    }
                                    int i24 = iArrZzQ2[0];
                                    if (i22 < i24) {
                                        i22 = i24;
                                    } else {
                                        int i25 = this.zzf;
                                        int i26 = i22 + i25;
                                        int i27 = iArrZzQ2[1];
                                        if (i26 > i27) {
                                            i22 = i27 - i25;
                                        }
                                    }
                                    iArr = new int[]{i21, i22};
                                }
                                if (iArr == null) {
                                    zzh("Resize location out of screen or close button is not visible.");
                                    return;
                                }
                                com.google.android.gms.ads.internal.client.zzay.zzb();
                                int iZzx = zzcdv.zzx(this.zzl, this.zzi);
                                com.google.android.gms.ads.internal.client.zzay.zzb();
                                int iZzx2 = zzcdv.zzx(this.zzl, this.zzf);
                                parent = ((View) this.zzk).getParent();
                                if (parent != null || !(parent instanceof ViewGroup)) {
                                    zzh("Webview is detached, probably in the middle of a resize or expand.");
                                    return;
                                }
                                ViewGroup viewGroup = (ViewGroup) parent;
                                viewGroup.removeView((View) this.zzk);
                                PopupWindow popupWindow = this.zzq;
                                if (popupWindow == null) {
                                    this.zzs = viewGroup;
                                    com.google.android.gms.ads.internal.zzt.zzp();
                                    Object obj = this.zzk;
                                    ((View) obj).setDrawingCacheEnabled(true);
                                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((View) obj).getDrawingCache());
                                    ((View) obj).setDrawingCacheEnabled(false);
                                    ImageView imageView = new ImageView(this.zzl);
                                    this.zzn = imageView;
                                    imageView.setImageBitmap(bitmapCreateBitmap);
                                    this.zzm = this.zzk.zzO();
                                    this.zzs.addView(this.zzn);
                                } else {
                                    popupWindow.dismiss();
                                }
                                RelativeLayout relativeLayout = new RelativeLayout(this.zzl);
                                this.zzr = relativeLayout;
                                relativeLayout.setBackgroundColor(0);
                                this.zzr.setLayoutParams(new ViewGroup.LayoutParams(iZzx, iZzx2));
                                com.google.android.gms.ads.internal.zzt.zzp();
                                PopupWindow popupWindow2 = new PopupWindow((View) this.zzr, iZzx, iZzx2, false);
                                this.zzq = popupWindow2;
                                popupWindow2.setOutsideTouchable(false);
                                this.zzq.setTouchable(true);
                                this.zzq.setClippingEnabled(!this.zzc);
                                this.zzr.addView((View) this.zzk, -1, -1);
                                this.zzo = new LinearLayout(this.zzl);
                                com.google.android.gms.ads.internal.client.zzay.zzb();
                                int iZzx3 = zzcdv.zzx(this.zzl, 50);
                                com.google.android.gms.ads.internal.client.zzay.zzb();
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iZzx3, zzcdv.zzx(this.zzl, 50));
                                switch (this.zzb) {
                                    case "center":
                                        b11 = 2;
                                        break;
                                    case "top-left":
                                        b11 = 0;
                                        break;
                                    case "bottom-left":
                                        b11 = 3;
                                        break;
                                    case "bottom-right":
                                        b11 = 5;
                                        break;
                                    case "bottom-center":
                                        b11 = 4;
                                        break;
                                    case "top-center":
                                        b11 = 1;
                                        break;
                                    default:
                                        b11 = -1;
                                        break;
                                }
                                if (b11 == 0) {
                                    layoutParams.addRule(10);
                                    layoutParams.addRule(9);
                                } else if (b11 == 1) {
                                    layoutParams.addRule(10);
                                    layoutParams.addRule(14);
                                } else if (b11 == 2) {
                                    layoutParams.addRule(13);
                                } else if (b11 == 3) {
                                    layoutParams.addRule(12);
                                    layoutParams.addRule(9);
                                } else if (b11 == 4) {
                                    layoutParams.addRule(12);
                                    layoutParams.addRule(14);
                                } else if (b11 != 5) {
                                    layoutParams.addRule(10);
                                    layoutParams.addRule(11);
                                } else {
                                    layoutParams.addRule(12);
                                    layoutParams.addRule(11);
                                }
                                this.zzo.setOnClickListener(new zzbvp(this));
                                this.zzo.setContentDescription("Close button");
                                this.zzr.addView(this.zzo, layoutParams);
                                try {
                                    PopupWindow popupWindow3 = this.zzq;
                                    View decorView = window.getDecorView();
                                    com.google.android.gms.ads.internal.client.zzay.zzb();
                                    int iZzx4 = zzcdv.zzx(this.zzl, iArr[0]);
                                    com.google.android.gms.ads.internal.client.zzay.zzb();
                                    popupWindow3.showAtLocation(decorView, 0, iZzx4, zzcdv.zzx(this.zzl, iArr[1]));
                                    int i28 = iArr[0];
                                    int i29 = iArr[1];
                                    zzbvx zzbvxVar = this.zzp;
                                    if (zzbvxVar != null) {
                                        zzbvxVar.zza(i28, i29, this.zzi, this.zzf);
                                    }
                                    this.zzk.zzah(zzcla.zzb(iZzx, iZzx2));
                                    int i31 = iArr[0];
                                    int i32 = iArr[1];
                                    com.google.android.gms.ads.internal.zzt.zzp();
                                    zzk(i31, i32 - com.google.android.gms.ads.internal.util.zzt.zzQ(this.zzl)[0], this.zzi, this.zzf);
                                    zzl("resized");
                                    return;
                                } catch (RuntimeException e11) {
                                    zzh("Cannot show popup window: " + e11.getMessage());
                                    this.zzr.removeView((View) this.zzk);
                                    ViewGroup viewGroup2 = this.zzs;
                                    if (viewGroup2 != null) {
                                        viewGroup2.removeView(this.zzn);
                                        this.zzs.addView((View) this.zzk);
                                        this.zzk.zzah(this.zzm);
                                    }
                                    return;
                                }
                            }
                            zzcec.zzj("Cannot resize to a full-screen ad.");
                        }
                    }
                    iArr = null;
                    if (iArr == null) {
                        zzh("Resize location out of screen or close button is not visible.");
                        return;
                    }
                    com.google.android.gms.ads.internal.client.zzay.zzb();
                    int iZzx5 = zzcdv.zzx(this.zzl, this.zzi);
                    com.google.android.gms.ads.internal.client.zzay.zzb();
                    int iZzx6 = zzcdv.zzx(this.zzl, this.zzf);
                    parent = ((View) this.zzk).getParent();
                    if (parent != null) {
                    }
                    zzh("Webview is detached, probably in the middle of a resize or expand.");
                    return;
                }
                zzh("Activity context is not ready, cannot get window or decor view.");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzd(int i11, int i12, boolean z11) {
        synchronized (this.zzj) {
            this.zzd = i11;
            this.zze = i12;
        }
    }

    public final void zze(int i11, int i12) {
        this.zzd = i11;
        this.zze = i12;
    }

    public final boolean zzf() {
        boolean z11;
        synchronized (this.zzj) {
            z11 = this.zzq != null;
        }
        return z11;
    }
}
