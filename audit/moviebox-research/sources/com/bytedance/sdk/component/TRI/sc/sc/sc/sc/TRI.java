package com.bytedance.sdk.component.TRI.sc.sc.sc.sc;

import android.content.Context;
import com.bytedance.sdk.component.TRI.sc.Qj;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI extends qr {
    public TRI(Context context, com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar) {
        super(context, scVar);
    }

    public static String sc(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.sc.sc.qr, com.bytedance.sdk.component.TRI.sc.sc.sc.sc.zY
    public String pFF() {
        return Qj.qr().We().ExN();
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.sc.sc.qr
    public byte sc() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.sc.sc.qr
    public byte zY() {
        return (byte) 3;
    }
}
