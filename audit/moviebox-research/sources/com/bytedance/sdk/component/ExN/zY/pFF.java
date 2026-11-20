package com.bytedance.sdk.component.ExN.zY;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.ExN.BT;
import com.bytedance.sdk.component.ExN.Ql;
import com.bytedance.sdk.component.ExN.Sfl;
import com.bytedance.sdk.component.ExN.WH;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF implements BT {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private volatile TRI f26509sc;

    private pFF() {
    }

    private void pFF(Context context, Ql ql2) {
        if (this.f26509sc != null) {
            Log.w("ImageLoader", "already init!");
        }
        if (ql2 == null) {
            ql2 = ExN.sc(context);
        }
        this.f26509sc = new TRI(context, ql2);
    }

    public static BT sc(Context context, Ql ql2) {
        pFF pff = new pFF();
        pff.pFF(context, ql2);
        return pff;
    }

    @Override // com.bytedance.sdk.component.ExN.BT
    public WH sc(String str) {
        return new zY.pFF(this.f26509sc).zY(str);
    }

    @Override // com.bytedance.sdk.component.ExN.BT
    public InputStream sc(String str, String str2) {
        if (this.f26509sc != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = com.bytedance.sdk.component.ExN.zY.zY.zY.sc(str);
            }
            Collection<Sfl> collectionPFF = this.f26509sc.pFF();
            if (collectionPFF != null) {
                Iterator<Sfl> it = collectionPFF.iterator();
                while (it.hasNext()) {
                    byte[] bArrSc = it.next().sc(str2);
                    if (bArrSc != null) {
                        return new ByteArrayInputStream(bArrSc);
                    }
                }
            }
            Collection<com.bytedance.sdk.component.ExN.zY> collectionZY = this.f26509sc.zY();
            if (collectionZY != null) {
                Iterator<com.bytedance.sdk.component.ExN.zY> it2 = collectionZY.iterator();
                while (it2.hasNext()) {
                    InputStream inputStreamSc = it2.next().sc(str2);
                    if (inputStreamSc != null) {
                        return inputStreamSc;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ExN.BT
    public boolean sc(String str, String str2, String str3) {
        if (this.f26509sc == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = com.bytedance.sdk.component.ExN.zY.zY.zY.sc(str);
        }
        com.bytedance.sdk.component.ExN.zY zYVarSc = this.f26509sc.sc(str3);
        if (zYVarSc != null) {
            return zYVarSc.pFF(str2);
        }
        return false;
    }
}
