package com.bytedance.sdk.component.TRI.sc.sc.sc.sc;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.component.TRI.sc.Qj;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr extends zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected List<String> f26643sc;
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc zY;

    public qr(Context context, com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar) {
        super(context);
        this.f26643sc = new ArrayList();
        this.zY = scVar;
        if (scVar == null) {
            this.zY = com.bytedance.sdk.component.TRI.sc.We.pFF.sc.zY();
        }
    }

    private void pFF(int i11, long j11) {
        com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(ExN(), pFF(), "gen_time <? AND retry >?", new String[]{String.valueOf(System.currentTimeMillis() - j11), String.valueOf(i11)});
    }

    private static String sc(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }

    private static String sc(String str, List<?> list, int i11, boolean z11) {
        String str2 = z11 ? " IN " : " NOT IN ";
        String str3 = z11 ? " OR " : " AND ";
        int iMin = Math.min(i11, 1000);
        int size = list.size();
        int i12 = size % iMin == 0 ? size / iMin : (size / iMin) + 1;
        StringBuilder sb2 = new StringBuilder();
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 * iMin;
            String strSc = sc(TextUtils.join("','", list.subList(i14, Math.min(i14 + iMin, size))), "");
            if (i13 != 0) {
                sb2.append(str3);
            }
            sb2.append(str);
            sb2.append(str2);
            sb2.append("('");
            sb2.append(strSc);
            sb2.append("')");
        }
        return sc(sb2.toString(), str + str2 + "('')");
    }

    public static String zY(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0027 A[EXC_TOP_SPLITTER, PHI: r0 r1
  0x0027: PHI (r0v2 int) = (r0v0 int), (r0v6 int) binds: [B:12:0x002c, B:8:0x0025] A[DONT_GENERATE, DONT_INLINE]
  0x0027: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:12:0x002c, B:8:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public int We() {
        Cursor cursorSc;
        int i11 = 0;
        try {
            cursorSc = com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(ExN(), pFF(), new String[]{"count(1)"}, null, null, null, null, null);
            if (cursorSc != null) {
                try {
                    cursorSc.moveToFirst();
                    i11 = cursorSc.getInt(0);
                } catch (Throwable unused) {
                    if (cursorSc != null) {
                        try {
                            cursorSc.close();
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (cursorSc != null) {
                cursorSc.close();
            }
        } catch (Throwable unused3) {
            cursorSc = null;
        }
        return i11;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.sc.sc.zY
    public String pFF() {
        return Qj.qr().We().We();
    }

    public List<com.bytedance.sdk.component.TRI.sc.We.sc> pFF(String str) {
        com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar = this.zY;
        return scVar == null ? new ArrayList() : sc(scVar.pFF(), str);
    }

    public void pFF(List<com.bytedance.sdk.component.TRI.sc.We.sc> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.sdk.component.TRI.sc.We.sc scVar : list) {
            linkedList.add(scVar.zY());
            com.bytedance.sdk.component.TRI.sc.zY.sc.WH(scVar);
        }
        pFF();
        linkedList.size();
        com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(ExN(), "DELETE FROM " + pFF() + " WHERE " + sc("id", linkedList, 1000, true));
        zY(linkedList);
    }

    public byte sc() {
        return (byte) 1;
    }

    public List<com.bytedance.sdk.component.TRI.sc.We.sc> sc(int i11, String str) {
        long jSc = com.bytedance.sdk.component.TRI.sc.pFF.sc.sc(i11, ExN());
        if (jSc <= 0) {
            jSc = 1;
        } else if (jSc > 100) {
            jSc = 100;
        }
        ArrayList arrayList = new ArrayList();
        this.f26643sc.clear();
        Cursor cursorSc = com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(ExN(), pFF(), new String[]{"id", AppMeasurementSdk.ConditionalUserProperty.VALUE, "encrypt"}, null, null, null, null, str + " DESC limit " + jSc);
        if (cursorSc != null) {
            while (cursorSc.moveToNext()) {
                try {
                    try {
                        String string = cursorSc.getString(cursorSc.getColumnIndex("id"));
                        String string2 = cursorSc.getString(cursorSc.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                        if (cursorSc.getInt(cursorSc.getColumnIndex("encrypt")) == 1) {
                            string2 = Qj.qr().dE().sc(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.f26643sc.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            com.bytedance.sdk.component.TRI.sc.We.sc.sc scVar = new com.bytedance.sdk.component.TRI.sc.We.sc.sc(string, new JSONObject(string2));
                            scVar.pFF(zY());
                            scVar.sc(sc());
                            arrayList.add(scVar);
                        }
                    } catch (Throwable unused) {
                    }
                } finally {
                    try {
                        cursorSc.close();
                        if (!this.f26643sc.isEmpty()) {
                            sc(this.f26643sc);
                            this.f26643sc.clear();
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        return arrayList;
    }

    public void sc(int i11, long j11) {
        pFF(i11, j11);
    }

    public void sc(List<String> list) {
        pFF();
        list.size();
        com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(ExN(), "DELETE FROM " + pFF() + " WHERE " + sc("id", list, 1000, true));
        com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.ZM(), list.size());
        zY(list);
    }

    public boolean sc(int i11) {
        return this.zY != null && We() >= this.zY.sc();
    }

    public byte zY() {
        return (byte) 2;
    }
}
