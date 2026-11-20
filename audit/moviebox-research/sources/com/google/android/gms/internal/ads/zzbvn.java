package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.android.gms.ads.impl.R;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbvn extends zzbvw {
    private final Map zza;
    private final Context zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;
    private final String zzf;
    private final String zzg;

    public zzbvn(zzcjk zzcjkVar, Map map) {
        super(zzcjkVar, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzcjkVar.zzi();
        this.zzc = zze(TrackingKey.DESCRIPTION);
        this.zzf = zze("summary");
        this.zzd = zzd("start_ticks");
        this.zze = zzd("end_ticks");
        this.zzg = zze(RequestParameters.SUBRESOURCE_LOCATION);
    }

    private final long zzd(String str) {
        String str2 = (String) this.zza.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    private final String zze(String str) {
        return TextUtils.isEmpty((CharSequence) this.zza.get(str)) ? "" : (String) this.zza.get(str);
    }

    public final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra(CampaignEx.JSON_KEY_TITLE, this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra(TrackingKey.DESCRIPTION, this.zzf);
        long j11 = this.zzd;
        if (j11 > -1) {
            data.putExtra("beginTime", j11);
        }
        long j12 = this.zze;
        if (j12 > -1) {
            data.putExtra("endTime", j12);
        }
        data.setFlags(ASTNode.DEOP);
        return data;
    }

    public final void zzc() {
        if (this.zzb == null) {
            zzh("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        if (!new zzbfm(this.zzb).zzb()) {
            zzh("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder builderZzJ = com.google.android.gms.ads.internal.util.zzt.zzJ(this.zzb);
        Resources resourcesZze = com.google.android.gms.ads.internal.zzt.zzo().zze();
        builderZzJ.setTitle(resourcesZze != null ? resourcesZze.getString(R.string.f36077s5) : "Create calendar event");
        builderZzJ.setMessage(resourcesZze != null ? resourcesZze.getString(R.string.f36078s6) : "Allow Ad to create a calendar event?");
        builderZzJ.setPositiveButton(resourcesZze != null ? resourcesZze.getString(R.string.f36075s3) : "Accept", new zzbvl(this));
        builderZzJ.setNegativeButton(resourcesZze != null ? resourcesZze.getString(R.string.f36076s4) : "Decline", new zzbvm(this));
        builderZzJ.create().show();
    }
}
