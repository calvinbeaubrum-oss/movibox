package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbnr implements zzbng {

    @Nullable
    private final com.google.android.gms.ads.internal.zzb zza;

    @Nullable
    private final zzdwf zzb;

    @Nullable
    private final zzflw zzc;

    @Nullable
    private final zzbvq zze;

    @Nullable
    private final zzehh zzf;

    @Nullable
    private final zzcse zzg;
    private com.google.android.gms.ads.internal.overlay.zzy zzh = null;
    private final zzgey zzi = zzcep.zzf;
    private final zzceh zzd = new zzceh(null);

    public zzbnr(com.google.android.gms.ads.internal.zzb zzbVar, zzbvq zzbvqVar, zzehh zzehhVar, zzdwf zzdwfVar, zzflw zzflwVar, zzcse zzcseVar) {
        this.zza = zzbVar;
        this.zze = zzbvqVar;
        this.zzf = zzehhVar;
        this.zzb = zzdwfVar;
        this.zzc = zzflwVar;
        this.zzg = zzcseVar;
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if (TtmlNode.TAG_P.equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    public static Uri zzc(Context context, zzavi zzaviVar, Uri uri, View view, @Nullable Activity activity, @Nullable zzfhl zzfhlVar) {
        if (zzaviVar == null) {
            return uri;
        }
        try {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlr)).booleanValue() || zzfhlVar == null) {
                if (zzaviVar.zze(uri)) {
                    uri = zzaviVar.zza(uri, context, view, activity);
                }
            } else if (zzaviVar.zze(uri)) {
                uri = zzfhlVar.zza(uri, context, view, activity);
            }
        } catch (zzavj unused) {
        } catch (Exception e11) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "OpenGmsgHandler.maybeAddClickSignalsToUri");
        }
        return uri;
    }

    public static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e11) {
            zzcec.zzh("Error adding click uptime parameter to url: ".concat(String.valueOf(uri.toString())), e11);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:108:0x02b7  */
    public final void zzh(String str, com.google.android.gms.ads.internal.client.zza zzaVar, Map map, String str2) {
        String str3;
        boolean z11;
        boolean z12;
        String string;
        zzcjk zzcjkVar = (zzcjk) zzaVar;
        zzfgm zzfgmVarZzD = zzcjkVar.zzD();
        zzfgp zzfgpVarZzP = zzcjkVar.zzP();
        boolean z13 = false;
        if (zzfgmVarZzD == null || zzfgpVarZzP == null) {
            str3 = "";
            z11 = false;
        } else {
            String str4 = zzfgpVarZzP.zzb;
            z11 = zzfgmVarZzD.zzaj;
            str3 = str4;
        }
        boolean z14 = (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkk)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("0")) ? false : true;
        if ("expand".equalsIgnoreCase(str2)) {
            if (zzcjkVar.zzaC()) {
                zzcec.zzj("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzk(false);
                ((zzckq) zzaVar).zzaH(zzf(map), zzb(map), z14);
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str2)) {
            zzk(false);
            boolean z15 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlm)).booleanValue() && Objects.equals(map.get("is_allowed_for_lock_screen"), "1");
            if (str != null) {
                ((zzckq) zzaVar).zzaJ(zzf(map), zzb(map), str, z14, z15);
                return;
            } else {
                ((zzckq) zzaVar).zzaI(zzf(map), zzb(map), (String) map.get("html"), (String) map.get("baseurl"), z14);
                return;
            }
        }
        if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
            zzcjkVar.getContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzew)).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeA)).booleanValue()) {
                    com.google.android.gms.ads.internal.util.zze.zza("User opt out chrome custom tab.");
                } else {
                    z13 = true;
                }
            }
            boolean zZzg = zzbhd.zzg(zzcjkVar.getContext());
            if (z13) {
                if (zZzg) {
                    zzk(true);
                    if (TextUtils.isEmpty(str)) {
                        zzcec.zzj("Cannot open browser with null or empty url");
                        zzm(7);
                        return;
                    }
                    Uri uriZzd = zzd(zzc(zzcjkVar.getContext(), zzcjkVar.zzI(), Uri.parse(str), zzcjkVar.zzF(), zzcjkVar.zzi(), zzcjkVar.zzQ()));
                    if (z11 && this.zzf != null && zzl(zzaVar, zzcjkVar.getContext(), uriZzd.toString(), str3)) {
                        return;
                    }
                    this.zzh = new zzbno(this);
                    ((zzckq) zzaVar).zzaF(new com.google.android.gms.ads.internal.overlay.zzc(null, uriZzd.toString(), null, null, null, null, null, null, ObjectWrapper.wrap(this.zzh).asBinder(), true), z14);
                    return;
                }
                zzm(4);
            }
            map.put("use_first_package", "true");
            map.put("use_running_process", "true");
            zzj(zzaVar, map, z11, str3, z14);
            return;
        }
        if (MBridgeConstans.DYNAMIC_VIEW_WX_APP.equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
            zzj(zzaVar, map, z11, str3, z14);
            return;
        }
        if ("open_app".equalsIgnoreCase(str2)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzid)).booleanValue()) {
                zzk(true);
                String str5 = (String) map.get(TtmlNode.TAG_P);
                if (str5 == null) {
                    zzcec.zzj("Package name missing from open app action.");
                    return;
                }
                if (z11 && this.zzf != null && zzl(zzaVar, zzcjkVar.getContext(), str5, str3)) {
                    return;
                }
                PackageManager packageManager = zzcjkVar.getContext().getPackageManager();
                if (packageManager == null) {
                    zzcec.zzj("Cannot get package manager from open app action.");
                    return;
                }
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str5);
                if (launchIntentForPackage != null) {
                    ((zzckq) zzaVar).zzaF(new com.google.android.gms.ads.internal.overlay.zzc(launchIntentForPackage, this.zzh), z14);
                    return;
                }
                return;
            }
            return;
        }
        zzk(true);
        String str6 = (String) map.get("intent_url");
        Intent uri = null;
        if (!TextUtils.isEmpty(str6)) {
            try {
                uri = Intent.parseUri(str6, 0);
            } catch (URISyntaxException e11) {
                zzcec.zzh("Error parsing the url: ".concat(String.valueOf(str6)), e11);
            }
        }
        Intent intent = uri;
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            if (!Uri.EMPTY.equals(data)) {
                Uri uriZzd2 = zzd(zzc(zzcjkVar.getContext(), zzcjkVar.zzI(), data, zzcjkVar.zzF(), zzcjkVar.zzi(), zzcjkVar.zzQ()));
                if (TextUtils.isEmpty(intent.getType())) {
                    intent.setData(uriZzd2);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzie)).booleanValue()) {
                        intent.setDataAndType(uriZzd2, intent.getType());
                    } else {
                        intent.setData(uriZzd2);
                    }
                }
            }
        }
        boolean z16 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziv)).booleanValue() && "intent_async".equalsIgnoreCase(str2) && map.containsKey("event_id");
        HashMap map2 = new HashMap();
        if (z16) {
            this.zzh = new zzbnp(this, z14, zzaVar, map2, map);
            z12 = false;
        } else {
            z12 = z14;
        }
        if (intent != null) {
            if (!z11 || this.zzf == null || !zzl(zzaVar, zzcjkVar.getContext(), intent.getData().toString(), str3)) {
                ((zzckq) zzaVar).zzaF(new com.google.android.gms.ads.internal.overlay.zzc(intent, this.zzh), z12);
                return;
            } else {
                if (z16) {
                    map2.put((String) map.get("event_id"), Boolean.TRUE);
                    ((zzbqa) zzaVar).zzd("openIntentAsync", map2);
                    return;
                }
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            string = str;
        } else {
            string = zzd(zzc(zzcjkVar.getContext(), zzcjkVar.zzI(), Uri.parse(str), zzcjkVar.zzF(), zzcjkVar.zzi(), zzcjkVar.zzQ())).toString();
        }
        if (!z11 || this.zzf == null || !zzl(zzaVar, zzcjkVar.getContext(), string, str3)) {
            ((zzckq) zzaVar).zzaF(new com.google.android.gms.ads.internal.overlay.zzc((String) map.get("i"), string, (String) map.get("m"), (String) map.get(TtmlNode.TAG_P), (String) map.get("c"), (String) map.get("f"), (String) map.get("e"), this.zzh), z12);
        } else if (z16) {
            map2.put((String) map.get("event_id"), Boolean.TRUE);
            ((zzbqa) zzaVar).zzd("openIntentAsync", map2);
        }
    }

    private final void zzi(Context context, String str, String str2) {
        this.zzf.zzc(str);
        zzdwf zzdwfVar = this.zzb;
        if (zzdwfVar != null) {
            zzehs.zzc(context, zzdwfVar, this.zzc, this.zzf, str, "dialog_not_shown", zzgad.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0107  */
    /* JADX WARN: Code duplicated, block: B:32:0x010f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0156 A[PHI: r21
  0x0156: PHI (r21v2 java.util.ArrayList) = (r21v1 java.util.ArrayList), (r21v1 java.util.ArrayList), (r21v1 java.util.ArrayList), (r21v3 java.util.ArrayList) binds: [B:32:0x010f, B:33:0x0111, B:35:0x0117, B:65:0x0156] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x015a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v22, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    private final void zzj(com.google.android.gms.ads.internal.client.zza zzaVar, Map map, boolean z11, String str, boolean z12) {
        ?? r11;
        ArrayList arrayList;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ResolveInfo resolveInfoZzc;
        Intent intentZzb;
        com.google.android.gms.ads.internal.client.zza zzaVar2;
        boolean z13 = true;
        zzk(true);
        zzcjk zzcjkVar = (zzcjk) zzaVar;
        Context context = zzcjkVar.getContext();
        zzavi zzaviVarZzI = zzcjkVar.zzI();
        View viewZzF = zzcjkVar.zzF();
        zzfhl zzfhlVarZzQ = zzcjkVar.zzQ();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str2 = (String) map.get("u");
        Object objBuild = null;
        if (TextUtils.isEmpty(str2)) {
            r11 = objBuild;
        } else {
            Uri uriZzd = zzd(zzc(context, zzaviVarZzI, Uri.parse(str2), viewZzF, null, zzfhlVarZzQ));
            boolean z14 = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean z15 = Boolean.parseBoolean((String) map.get("use_running_process"));
            if (!Boolean.parseBoolean((String) map.get("use_custom_tabs"))) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeu)).booleanValue()) {
                    z13 = false;
                }
            }
            if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(uriZzd.getScheme())) {
                objBuild = uriZzd.buildUpon().scheme("https").build();
            } else if ("https".equalsIgnoreCase(uriZzd.getScheme())) {
                objBuild = uriZzd.buildUpon().scheme(HttpHost.DEFAULT_SCHEME_NAME).build();
            }
            ?? r12 = objBuild;
            ArrayList arrayList2 = new ArrayList();
            Intent intentZza = zzbnq.zza(uriZzd, context, zzaviVarZzI, viewZzF, zzfhlVarZzQ);
            Intent intentZza2 = zzbnq.zza(r12, context, zzaviVarZzI, viewZzF, zzfhlVarZzQ);
            if (z13) {
                com.google.android.gms.ads.internal.zzt.zzp();
                com.google.android.gms.ads.internal.util.zzt.zzo(context, intentZza);
                com.google.android.gms.ads.internal.zzt.zzp();
                com.google.android.gms.ads.internal.util.zzt.zzo(context, intentZza2);
            }
            ArrayList arrayList3 = arrayList2;
            ResolveInfo resolveInfoZzd = zzbnq.zzd(intentZza, arrayList2, context, zzaviVarZzI, viewZzF, zzfhlVarZzQ);
            if (resolveInfoZzd != null) {
                objBuild = zzbnq.zzb(intentZza, resolveInfoZzd, context, zzaviVarZzI, viewZzF, zzfhlVarZzQ);
            } else if (intentZza2 == null || (resolveInfoZzc = zzbnq.zzc(intentZza2, context, zzaviVarZzI, viewZzF, zzfhlVarZzQ)) == null) {
                r11 = intentZzb;
                if (!arrayList3.isEmpty()) {
                    if (z15 || activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                        arrayList = arrayList3;
                        if (z14) {
                            objBuild = zzbnq.zzb(intentZza, (ResolveInfo) arrayList.get(0), context, zzaviVarZzI, viewZzF, zzfhlVarZzQ);
                        }
                    } else {
                        int size = arrayList3.size();
                        int i11 = 0;
                        while (true) {
                            if (i11 < size) {
                                ArrayList arrayList4 = arrayList3;
                                ResolveInfo resolveInfo = (ResolveInfo) arrayList4.get(i11);
                                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                                while (true) {
                                    int i12 = i11 + 1;
                                    if (!it.hasNext()) {
                                        arrayList3 = arrayList4;
                                        i11 = i12;
                                    } else if (it.next().processName.equals(resolveInfo.activityInfo.packageName)) {
                                        objBuild = zzbnq.zzb(intentZza, resolveInfo, context, zzaviVarZzI, viewZzF, zzfhlVarZzQ);
                                    }
                                }
                            } else {
                                arrayList = arrayList3;
                                if (z14) {
                                    objBuild = zzbnq.zzb(intentZza, (ResolveInfo) arrayList.get(0), context, zzaviVarZzI, viewZzF, zzfhlVarZzQ);
                                }
                            }
                        }
                    }
                }
                r11 = intentZza;
            } else {
                intentZzb = zzbnq.zzb(intentZza, resolveInfoZzc, context, zzaviVarZzI, viewZzF, zzfhlVarZzQ);
                if (zzbnq.zzc(intentZzb, context, zzaviVarZzI, viewZzF, zzfhlVarZzQ) == null) {
                    r11 = intentZzb;
                    if (!arrayList3.isEmpty()) {
                        if (z15) {
                            arrayList = arrayList3;
                            if (z14) {
                                objBuild = zzbnq.zzb(intentZza, (ResolveInfo) arrayList.get(0), context, zzaviVarZzI, viewZzF, zzfhlVarZzQ);
                            }
                        } else {
                            arrayList = arrayList3;
                            if (z14) {
                                objBuild = zzbnq.zzb(intentZza, (ResolveInfo) arrayList.get(0), context, zzaviVarZzI, viewZzF, zzfhlVarZzQ);
                            }
                        }
                    }
                    r11 = intentZza;
                }
            }
            r11 = objBuild;
        }
        if (!z11 || this.zzf == null || r11 == 0) {
            zzaVar2 = zzaVar;
        } else {
            zzaVar2 = zzaVar;
            if (zzl(zzaVar2, zzcjkVar.getContext(), r11.getData().toString(), str)) {
                return;
            }
        }
        try {
            ((zzckq) zzaVar2).zzaF(new com.google.android.gms.ads.internal.overlay.zzc(r11, this.zzh), z12);
        } catch (ActivityNotFoundException e11) {
            zzcec.zzj(e11.getMessage());
        }
    }

    private final void zzk(boolean z11) {
        zzbvq zzbvqVar = this.zze;
        if (zzbvqVar != null) {
            zzbvqVar.zza(z11);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
    
        if (r2 != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzl(com.google.android.gms.ads.internal.client.zza zzaVar, Context context, String str, String str2) {
        boolean zBooleanValue;
        zzdwf zzdwfVar = this.zzb;
        if (zzdwfVar != null) {
            zzehs.zzc(context, zzdwfVar, this.zzc, this.zzf, str2, "offline_open", new HashMap());
        }
        if (com.google.android.gms.ads.internal.zzt.zzo().zzz(context)) {
            this.zzf.zzh(this.zzd, str2);
            return false;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        com.google.android.gms.ads.internal.util.zzbt zzbtVarZzy = com.google.android.gms.ads.internal.util.zzt.zzy(context);
        com.google.android.gms.ads.internal.zzt.zzp();
        boolean zAreNotificationsEnabled = NotificationManagerCompat.from(context).areNotificationsEnabled();
        boolean zZzh = com.google.android.gms.ads.internal.zzt.zzq().zzh(context, "offline_notification_channel");
        zzcjk zzcjkVar = (zzcjk) zzaVar;
        boolean z11 = zzcjkVar.zzO().zzi() && zzcjkVar.zzi() == null;
        if (!zAreNotificationsEnabled) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                if (Build.VERSION.SDK_INT < 33) {
                    zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzio)).booleanValue();
                } else {
                    zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzin)).booleanValue();
                }
            }
            zzi(context, str2, "notifications_disabled");
            return false;
        }
        if (zZzh) {
            zzi(context, str2, "notification_channel_disabled");
            return false;
        }
        if (zzbtVarZzy == null) {
            zzi(context, str2, "work_manager_unavailable");
            return false;
        }
        if (z11) {
            zzi(context, str2, "ad_no_activity");
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzil)).booleanValue()) {
            zzi(context, str2, "notification_flow_disabled");
            return false;
        }
        if (zzcjkVar.zzL() == null || zzcjkVar.zzi() == null) {
            ((zzckq) zzaVar).zzaG(str2, str, 14);
        } else {
            zzeht zzehtVarZze = zzehu.zze();
            zzehtVarZze.zza(zzcjkVar.zzi());
            zzehtVarZze.zzb(null);
            zzehtVarZze.zzc(str2);
            zzehtVarZze.zzd(str);
            try {
                zzcjkVar.zzL().zzf(zzehtVarZze.zze());
            } catch (Exception e11) {
                zzi(context, str2, e11.getMessage());
                return false;
            }
        }
        zzaVar.onAdClicked();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm(int i11) {
        if (this.zzb == null) {
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
            zzdwe zzdweVarZza = this.zzb.zza();
            zzdweVarZza.zzb("action", "cct_action");
            zzdweVarZza.zzb("cct_open_status", zzbhc.zza(i11));
            zzdweVarZza.zzg();
            return;
        }
        zzflw zzflwVar = this.zzc;
        String strZza = zzbhc.zza(i11);
        zzflv zzflvVarZzb = zzflv.zzb("cct_action");
        zzflvVarZzb.zza("cct_open_status", strZza);
        zzflwVar.zzb(zzflvVarZzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        com.google.android.gms.ads.internal.client.zza zzaVar = (com.google.android.gms.ads.internal.client.zza) obj;
        String strZzc = zzccj.zzc((String) map.get("u"), ((zzcjk) zzaVar).getContext(), true);
        String str = (String) map.get("a");
        if (str == null) {
            zzcec.zzj("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.zza;
        if (zzbVar == null || zzbVar.zzc()) {
            zzgen.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjL)).booleanValue() && this.zzg != null && zzcse.zzh(strZzc)) ? this.zzg.zzb(strZzc, com.google.android.gms.ads.internal.client.zzay.zze()) : zzgen.zzh(strZzc), new zzbnn(this, zzaVar, map, str), this.zzi);
        } else {
            zzbVar.zzb(strZzc);
        }
    }
}
