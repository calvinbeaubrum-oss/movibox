package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.v0;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.common.util.concurrent.s;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdna {
    private int zza;
    private com.google.android.gms.ads.internal.client.zzdq zzb;
    private zzbjf zzc;
    private View zzd;
    private List zze;
    private com.google.android.gms.ads.internal.client.zzel zzg;
    private Bundle zzh;
    private zzcjk zzi;
    private zzcjk zzj;

    @Nullable
    private zzcjk zzk;

    @Nullable
    private zzfod zzl;

    @Nullable
    private s zzm;

    @Nullable
    private zzceu zzn;
    private View zzo;
    private View zzp;
    private IObjectWrapper zzq;
    private double zzr;
    private zzbjm zzs;
    private zzbjm zzt;
    private String zzu;
    private float zzx;

    @Nullable
    private String zzy;
    private final v0 zzv = new v0();
    private final v0 zzw = new v0();
    private List zzf = Collections.emptyList();

    @Nullable
    public static zzdna zzag(zzbtg zzbtgVar) {
        try {
            zzdmz zzdmzVarZzak = zzak(zzbtgVar.zzg(), null);
            zzbjf zzbjfVarZzh = zzbtgVar.zzh();
            View view = (View) zzam(zzbtgVar.zzj());
            String strZzo = zzbtgVar.zzo();
            List listZzr = zzbtgVar.zzr();
            String strZzm = zzbtgVar.zzm();
            Bundle bundleZzf = zzbtgVar.zzf();
            String strZzn = zzbtgVar.zzn();
            View view2 = (View) zzam(zzbtgVar.zzk());
            IObjectWrapper iObjectWrapperZzl = zzbtgVar.zzl();
            String strZzq = zzbtgVar.zzq();
            String strZzp = zzbtgVar.zzp();
            double dZze = zzbtgVar.zze();
            zzbjm zzbjmVarZzi = zzbtgVar.zzi();
            zzdna zzdnaVar = new zzdna();
            zzdnaVar.zza = 2;
            zzdnaVar.zzb = zzdmzVarZzak;
            zzdnaVar.zzc = zzbjfVarZzh;
            zzdnaVar.zzd = view;
            zzdnaVar.zzZ("headline", strZzo);
            zzdnaVar.zze = listZzr;
            zzdnaVar.zzZ(TtmlNode.TAG_BODY, strZzm);
            zzdnaVar.zzh = bundleZzf;
            zzdnaVar.zzZ("call_to_action", strZzn);
            zzdnaVar.zzo = view2;
            zzdnaVar.zzq = iObjectWrapperZzl;
            zzdnaVar.zzZ(PlaceTypes.STORE, strZzq);
            zzdnaVar.zzZ(BidResponsed.KEY_PRICE, strZzp);
            zzdnaVar.zzr = dZze;
            zzdnaVar.zzs = zzbjmVarZzi;
            return zzdnaVar;
        } catch (RemoteException e11) {
            zzcec.zzk("Failed to get native ad from app install ad mapper", e11);
            return null;
        }
    }

    @Nullable
    public static zzdna zzah(zzbth zzbthVar) {
        try {
            zzdmz zzdmzVarZzak = zzak(zzbthVar.zzf(), null);
            zzbjf zzbjfVarZzg = zzbthVar.zzg();
            View view = (View) zzam(zzbthVar.zzi());
            String strZzo = zzbthVar.zzo();
            List listZzp = zzbthVar.zzp();
            String strZzm = zzbthVar.zzm();
            Bundle bundleZze = zzbthVar.zze();
            String strZzn = zzbthVar.zzn();
            View view2 = (View) zzam(zzbthVar.zzj());
            IObjectWrapper iObjectWrapperZzk = zzbthVar.zzk();
            String strZzl = zzbthVar.zzl();
            zzbjm zzbjmVarZzh = zzbthVar.zzh();
            zzdna zzdnaVar = new zzdna();
            zzdnaVar.zza = 1;
            zzdnaVar.zzb = zzdmzVarZzak;
            zzdnaVar.zzc = zzbjfVarZzg;
            zzdnaVar.zzd = view;
            zzdnaVar.zzZ("headline", strZzo);
            zzdnaVar.zze = listZzp;
            zzdnaVar.zzZ(TtmlNode.TAG_BODY, strZzm);
            zzdnaVar.zzh = bundleZze;
            zzdnaVar.zzZ("call_to_action", strZzn);
            zzdnaVar.zzo = view2;
            zzdnaVar.zzq = iObjectWrapperZzk;
            zzdnaVar.zzZ("advertiser", strZzl);
            zzdnaVar.zzt = zzbjmVarZzh;
            return zzdnaVar;
        } catch (RemoteException e11) {
            zzcec.zzk("Failed to get native ad from content ad mapper", e11);
            return null;
        }
    }

    @Nullable
    public static zzdna zzai(zzbtg zzbtgVar) {
        try {
            return zzal(zzak(zzbtgVar.zzg(), null), zzbtgVar.zzh(), (View) zzam(zzbtgVar.zzj()), zzbtgVar.zzo(), zzbtgVar.zzr(), zzbtgVar.zzm(), zzbtgVar.zzf(), zzbtgVar.zzn(), (View) zzam(zzbtgVar.zzk()), zzbtgVar.zzl(), zzbtgVar.zzq(), zzbtgVar.zzp(), zzbtgVar.zze(), zzbtgVar.zzi(), null, 0.0f);
        } catch (RemoteException e11) {
            zzcec.zzk("Failed to get native ad assets from app install ad mapper", e11);
            return null;
        }
    }

    @Nullable
    public static zzdna zzaj(zzbth zzbthVar) {
        try {
            return zzal(zzak(zzbthVar.zzf(), null), zzbthVar.zzg(), (View) zzam(zzbthVar.zzi()), zzbthVar.zzo(), zzbthVar.zzp(), zzbthVar.zzm(), zzbthVar.zze(), zzbthVar.zzn(), (View) zzam(zzbthVar.zzj()), zzbthVar.zzk(), null, null, -1.0d, zzbthVar.zzh(), zzbthVar.zzl(), 0.0f);
        } catch (RemoteException e11) {
            zzcec.zzk("Failed to get native ad assets from content ad mapper", e11);
            return null;
        }
    }

    @Nullable
    private static zzdmz zzak(com.google.android.gms.ads.internal.client.zzdq zzdqVar, @Nullable zzbtk zzbtkVar) {
        if (zzdqVar == null) {
            return null;
        }
        return new zzdmz(zzdqVar, zzbtkVar);
    }

    private static zzdna zzal(com.google.android.gms.ads.internal.client.zzdq zzdqVar, zzbjf zzbjfVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d11, zzbjm zzbjmVar, String str6, float f11) {
        zzdna zzdnaVar = new zzdna();
        zzdnaVar.zza = 6;
        zzdnaVar.zzb = zzdqVar;
        zzdnaVar.zzc = zzbjfVar;
        zzdnaVar.zzd = view;
        zzdnaVar.zzZ("headline", str);
        zzdnaVar.zze = list;
        zzdnaVar.zzZ(TtmlNode.TAG_BODY, str2);
        zzdnaVar.zzh = bundle;
        zzdnaVar.zzZ("call_to_action", str3);
        zzdnaVar.zzo = view2;
        zzdnaVar.zzq = iObjectWrapper;
        zzdnaVar.zzZ(PlaceTypes.STORE, str4);
        zzdnaVar.zzZ(BidResponsed.KEY_PRICE, str5);
        zzdnaVar.zzr = d11;
        zzdnaVar.zzs = zzbjmVar;
        zzdnaVar.zzZ("advertiser", str6);
        zzdnaVar.zzR(f11);
        return zzdnaVar;
    }

    private static Object zzam(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    @Nullable
    public static zzdna zzt(zzbtk zzbtkVar) {
        try {
            return zzal(zzak(zzbtkVar.zzj(), zzbtkVar), zzbtkVar.zzk(), (View) zzam(zzbtkVar.zzm()), zzbtkVar.zzs(), zzbtkVar.zzv(), zzbtkVar.zzq(), zzbtkVar.zzi(), zzbtkVar.zzr(), (View) zzam(zzbtkVar.zzn()), zzbtkVar.zzo(), zzbtkVar.zzu(), zzbtkVar.zzt(), zzbtkVar.zze(), zzbtkVar.zzl(), zzbtkVar.zzp(), zzbtkVar.zzf());
        } catch (RemoteException e11) {
            zzcec.zzk("Failed to get native ad assets from unified ad mapper", e11);
            return null;
        }
    }

    public final synchronized String zzA() {
        return this.zzu;
    }

    public final synchronized String zzB() {
        return zzF("headline");
    }

    @Nullable
    public final synchronized String zzC() {
        return this.zzy;
    }

    public final synchronized String zzD() {
        return zzF(BidResponsed.KEY_PRICE);
    }

    public final synchronized String zzE() {
        return zzF(PlaceTypes.STORE);
    }

    public final synchronized String zzF(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized List zzG() {
        return this.zze;
    }

    public final synchronized List zzH() {
        return this.zzf;
    }

    public final synchronized void zzI() {
        try {
            zzcjk zzcjkVar = this.zzi;
            if (zzcjkVar != null) {
                zzcjkVar.destroy();
                this.zzi = null;
            }
            zzcjk zzcjkVar2 = this.zzj;
            if (zzcjkVar2 != null) {
                zzcjkVar2.destroy();
                this.zzj = null;
            }
            zzcjk zzcjkVar3 = this.zzk;
            if (zzcjkVar3 != null) {
                zzcjkVar3.destroy();
                this.zzk = null;
            }
            s sVar = this.zzm;
            if (sVar != null) {
                sVar.cancel(false);
                this.zzm = null;
            }
            zzceu zzceuVar = this.zzn;
            if (zzceuVar != null) {
                zzceuVar.cancel(false);
                this.zzn = null;
            }
            this.zzl = null;
            this.zzv.clear();
            this.zzw.clear();
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzh = null;
            this.zzo = null;
            this.zzp = null;
            this.zzq = null;
            this.zzs = null;
            this.zzt = null;
            this.zzu = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void zzJ(zzbjf zzbjfVar) {
        this.zzc = zzbjfVar;
    }

    public final synchronized void zzK(String str) {
        this.zzu = str;
    }

    public final synchronized void zzL(@Nullable com.google.android.gms.ads.internal.client.zzel zzelVar) {
        this.zzg = zzelVar;
    }

    public final synchronized void zzM(zzbjm zzbjmVar) {
        this.zzs = zzbjmVar;
    }

    public final synchronized void zzN(String str, zzbiz zzbizVar) {
        try {
            if (zzbizVar == null) {
                this.zzv.remove(str);
            } else {
                this.zzv.put(str, zzbizVar);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void zzO(zzcjk zzcjkVar) {
        this.zzj = zzcjkVar;
    }

    public final synchronized void zzP(List list) {
        this.zze = list;
    }

    public final synchronized void zzQ(zzbjm zzbjmVar) {
        this.zzt = zzbjmVar;
    }

    public final synchronized void zzR(float f11) {
        this.zzx = f11;
    }

    public final synchronized void zzS(List list) {
        this.zzf = list;
    }

    public final synchronized void zzT(zzcjk zzcjkVar) {
        this.zzk = zzcjkVar;
    }

    public final synchronized void zzU(s sVar) {
        this.zzm = sVar;
    }

    public final synchronized void zzV(@Nullable String str) {
        this.zzy = str;
    }

    public final synchronized void zzW(zzfod zzfodVar) {
        this.zzl = zzfodVar;
    }

    public final synchronized void zzX(zzceu zzceuVar) {
        this.zzn = zzceuVar;
    }

    public final synchronized void zzY(double d11) {
        this.zzr = d11;
    }

    public final synchronized void zzZ(String str, String str2) {
        try {
            if (str2 == null) {
                this.zzw.remove(str);
            } else {
                this.zzw.put(str, str2);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized double zza() {
        return this.zzr;
    }

    public final synchronized void zzaa(int i11) {
        this.zza = i11;
    }

    public final synchronized void zzab(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.zzb = zzdqVar;
    }

    public final synchronized void zzac(View view) {
        this.zzo = view;
    }

    public final synchronized void zzad(zzcjk zzcjkVar) {
        this.zzi = zzcjkVar;
    }

    public final synchronized void zzae(View view) {
        this.zzp = view;
    }

    public final synchronized boolean zzaf() {
        return this.zzj != null;
    }

    public final synchronized float zzb() {
        return this.zzx;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        try {
            if (this.zzh == null) {
                this.zzh = new Bundle();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzo;
    }

    public final synchronized View zzg() {
        return this.zzp;
    }

    public final synchronized v0 zzh() {
        return this.zzv;
    }

    public final synchronized v0 zzi() {
        return this.zzw;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzdq zzj() {
        return this.zzb;
    }

    @Nullable
    public final synchronized com.google.android.gms.ads.internal.client.zzel zzk() {
        return this.zzg;
    }

    public final synchronized zzbjf zzl() {
        return this.zzc;
    }

    @Nullable
    public final zzbjm zzm() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbjl.zzg((IBinder) obj);
        }
        return null;
    }

    public final synchronized zzbjm zzn() {
        return this.zzs;
    }

    public final synchronized zzbjm zzo() {
        return this.zzt;
    }

    @Nullable
    public final synchronized zzceu zzp() {
        return this.zzn;
    }

    public final synchronized zzcjk zzq() {
        return this.zzj;
    }

    @Nullable
    public final synchronized zzcjk zzr() {
        return this.zzk;
    }

    public final synchronized zzcjk zzs() {
        return this.zzi;
    }

    @Nullable
    public final synchronized zzfod zzu() {
        return this.zzl;
    }

    public final synchronized IObjectWrapper zzv() {
        return this.zzq;
    }

    @Nullable
    public final synchronized s zzw() {
        return this.zzm;
    }

    public final synchronized String zzx() {
        return zzF("advertiser");
    }

    public final synchronized String zzy() {
        return zzF(TtmlNode.TAG_BODY);
    }

    public final synchronized String zzz() {
        return zzF("call_to_action");
    }
}
