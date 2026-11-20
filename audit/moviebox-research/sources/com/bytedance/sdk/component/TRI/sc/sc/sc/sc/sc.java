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
public class sc extends zY {
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc We;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected List<String> f26644sc;
    private final Context zY;

    public sc(Context context, com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar) {
        super(context);
        this.f26644sc = new ArrayList();
        this.zY = context;
        this.We = scVar;
        if (scVar == null) {
            this.We = com.bytedance.sdk.component.TRI.sc.We.pFF.sc.zY();
        }
    }

    public static String pFF(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    private void pFF(int i11, long j11) {
        if (j11 > 0 || i11 > 0) {
            com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(ExN(), pFF(), "gen_time <? OR retry >?", new String[]{String.valueOf(System.currentTimeMillis() - j11), String.valueOf(i11)});
            pFF();
        }
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

    public byte We() {
        return (byte) 0;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.sc.sc.zY
    public String pFF() {
        com.bytedance.sdk.component.TRI.sc.sc.ExN exNWe = Qj.qr().We();
        if (exNWe != null) {
            return exNWe.pFF();
        }
        return null;
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

    /* JADX WARN: Code duplicated, block: B:21:0x002a A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0 r1
  0x002a: PHI (r0v3 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:16:0x0034, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002a: PHI (r1v3 int) = (r1v0 int), (r1v5 int) binds: [B:16:0x0034, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public int sc() {
        Cursor cursorSc = null;
        int i11 = 0;
        try {
            cursorSc = com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(ExN(), pFF(), new String[]{"count(1)"}, null, null, null, null, null);
            if (cursorSc != null) {
                cursorSc.moveToFirst();
                i11 = cursorSc.getInt(0);
            }
        } catch (Exception unused) {
        } finally {
            if (cursorSc != null) {
                try {
                    cursorSc.close();
                } catch (Exception unused2) {
                }
            }
        }
        return i11;
    }

    public List<com.bytedance.sdk.component.TRI.sc.We.sc> sc(int i11, String str) {
        String str2;
        String[] strArr;
        long jSc = com.bytedance.sdk.component.TRI.sc.pFF.sc.sc(i11, ExN());
        pFF();
        if (jSc <= 0) {
            jSc = 1;
        } else if (jSc > 100) {
            jSc = 100;
        }
        String str3 = str + " DESC limit " + jSc;
        ArrayList arrayList = new ArrayList();
        this.f26644sc.clear();
        long jXc = Qj.qr().Xc();
        if (jXc > 0) {
            strArr = new String[]{String.valueOf(System.currentTimeMillis() - jXc)};
            str2 = "gen_time>?";
        } else {
            str2 = null;
            strArr = null;
        }
        Cursor cursorSc = (com.bytedance.sdk.component.TRI.sc.zY.sc.We() && We() == 3) ? com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(ExN(), pFF(), new String[]{"id", AppMeasurementSdk.ConditionalUserProperty.VALUE, "encrypt", "channel"}, str2, strArr, null, null, str3) : com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(ExN(), pFF(), new String[]{"id", AppMeasurementSdk.ConditionalUserProperty.VALUE, "encrypt"}, str2, strArr, null, null, str3);
        if (cursorSc != null) {
            try {
                com.bytedance.sdk.component.TRI.sc.ExN exNDE = Qj.qr().dE();
                while (cursorSc.moveToNext()) {
                    try {
                        String string = cursorSc.getString(cursorSc.getColumnIndex("id"));
                        String string2 = cursorSc.getString(cursorSc.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                        int i12 = cursorSc.getInt(cursorSc.getColumnIndex("encrypt"));
                        int i13 = (com.bytedance.sdk.component.TRI.sc.zY.sc.We() && We() == 3) ? cursorSc.getInt(cursorSc.getColumnIndex("channel")) : 0;
                        if (i12 == 1) {
                            string2 = exNDE.sc(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.f26644sc.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(string2);
                            com.bytedance.sdk.component.TRI.sc.We.sc.sc scVar = new com.bytedance.sdk.component.TRI.sc.We.sc.sc(string, jSONObject);
                            scVar.sc(We());
                            scVar.pFF(zY());
                            if (com.bytedance.sdk.component.TRI.sc.zY.sc.We() && We() == 3) {
                                scVar.sc(i13);
                            }
                            com.bytedance.sdk.component.TRI.sc.zY.sc.sc(jSONObject, scVar);
                            arrayList.add(scVar);
                        }
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                }
                try {
                    cursorSc.close();
                    if (!this.f26644sc.isEmpty()) {
                        sc(this.f26644sc);
                        this.f26644sc.clear();
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th3) {
                try {
                    cursorSc.close();
                    if (!this.f26644sc.isEmpty()) {
                        sc(this.f26644sc);
                        this.f26644sc.clear();
                    }
                } catch (Exception unused2) {
                }
                throw th3;
            }
        }
        pFF();
        arrayList.size();
        return arrayList;
    }

    public List<com.bytedance.sdk.component.TRI.sc.We.sc> sc(String str) {
        com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar = this.We;
        return scVar == null ? new ArrayList() : sc(scVar.pFF(), str);
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
        if (this.We == null) {
            return false;
        }
        int iSc = sc();
        int iSc2 = this.We.sc();
        pFF();
        if (com.bytedance.sdk.component.TRI.sc.zY.sc.zY() && (i11 == 1 || i11 == 2)) {
            return iSc > 0;
        }
        return iSc >= iSc2;
    }

    public byte zY() {
        return (byte) 2;
    }
}
