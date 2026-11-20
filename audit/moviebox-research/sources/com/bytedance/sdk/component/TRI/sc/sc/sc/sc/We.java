package com.bytedance.sdk.component.TRI.sc.sc.sc.sc;

import android.content.Context;
import com.bytedance.sdk.component.TRI.sc.Qj;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends sc {
    public We(Context context, com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar) {
        super(context, scVar);
    }

    public static String zY(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.sc.sc.sc
    public byte We() {
        return (byte) 0;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.sc.sc.sc, com.bytedance.sdk.component.TRI.sc.sc.sc.sc.zY
    public String pFF() {
        com.bytedance.sdk.component.TRI.sc.sc.ExN exNWe = Qj.qr().We();
        if (exNWe != null) {
            return exNWe.sc();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.sc.sc.sc
    public byte zY() {
        return (byte) 1;
    }
}
