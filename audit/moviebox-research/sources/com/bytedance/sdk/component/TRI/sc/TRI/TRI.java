package com.bytedance.sdk.component.TRI.sc.TRI;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.hisavana.common.tracking.TrackingKey;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI implements ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26587sc;

    public TRI(Context context) {
        this.f26587sc = context;
    }

    public static String pFF() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, retry INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI.ExN
    public void pFF(We we2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", we2.sc());
        contentValues.put("url", we2.pFF());
        contentValues.put("replaceholder", Integer.valueOf(we2.zY() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(we2.We()));
        contentValues.put(TrackingKey.ERROR_CODE, we2.qr());
        contentValues.put("error_msg", we2.Ol());
        contentValues.put("url_type", Integer.valueOf(we2.ExN()));
        contentValues.put("ad_id", we2.TRI());
        com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(this.f26587sc, "trackurl", contentValues, "id=?", new String[]{we2.sc()});
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI.ExN
    public We sc(String str) {
        Cursor cursorSc = com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(this.f26587sc, "trackurl", null, "id=?", new String[]{str}, null, null, null);
        if (cursorSc != null && cursorSc.moveToFirst()) {
            try {
                String string = cursorSc.getString(cursorSc.getColumnIndex("id"));
                String string2 = cursorSc.getString(cursorSc.getColumnIndex("url"));
                boolean z11 = cursorSc.getInt(cursorSc.getColumnIndex("replaceholder")) > 0;
                int i11 = cursorSc.getInt(cursorSc.getColumnIndex("retry"));
                int i12 = cursorSc.getInt(cursorSc.getColumnIndex("url_type"));
                String string3 = cursorSc.getString(cursorSc.getColumnIndex("ad_id"));
                String string4 = cursorSc.getString(cursorSc.getColumnIndex(TrackingKey.ERROR_CODE));
                String string5 = cursorSc.getString(cursorSc.getColumnIndex("error_msg"));
                We we2 = new We(string, string2, z11, i12, string3);
                we2.sc(i11);
                if (!TextUtils.isEmpty(string4)) {
                    we2.sc(string4);
                }
                if (!TextUtils.isEmpty(string5)) {
                    we2.pFF(string5);
                }
                cursorSc.close();
                return we2;
            } catch (Throwable th2) {
                try {
                    th2.getMessage();
                    cursorSc.close();
                    cursorSc = null;
                } catch (Throwable th3) {
                    cursorSc.close();
                    throw th3;
                }
            }
        }
        if (cursorSc != null) {
            cursorSc.close();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI.ExN
    public List<We> sc() {
        LinkedList linkedList = new LinkedList();
        Cursor cursorSc = com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(this.f26587sc, "trackurl", null, null, null, null, null, null);
        if (cursorSc != null) {
            while (cursorSc.moveToNext()) {
                try {
                    try {
                        String string = cursorSc.getString(cursorSc.getColumnIndex("id"));
                        String string2 = cursorSc.getString(cursorSc.getColumnIndex("url"));
                        boolean z11 = cursorSc.getInt(cursorSc.getColumnIndex("replaceholder")) > 0;
                        int i11 = cursorSc.getInt(cursorSc.getColumnIndex("retry"));
                        int i12 = cursorSc.getInt(cursorSc.getColumnIndex("url_type"));
                        String string3 = cursorSc.getString(cursorSc.getColumnIndex("ad_id"));
                        String string4 = cursorSc.getString(cursorSc.getColumnIndex(TrackingKey.ERROR_CODE));
                        String string5 = cursorSc.getString(cursorSc.getColumnIndex("error_msg"));
                        We we2 = new We(string, string2, z11, i12, string3);
                        we2.sc(i11);
                        if (!TextUtils.isEmpty(string4)) {
                            we2.sc(string4);
                        }
                        if (!TextUtils.isEmpty(string5)) {
                            we2.pFF(string5);
                        }
                        linkedList.add(we2);
                    } catch (Throwable unused) {
                    }
                } finally {
                    cursorSc.close();
                }
            }
            cursorSc.close();
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI.ExN
    public void sc(We we2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", we2.sc());
        contentValues.put("url", we2.pFF());
        contentValues.put("replaceholder", Integer.valueOf(we2.zY() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(we2.We()));
        contentValues.put("url_type", Integer.valueOf(we2.ExN()));
        contentValues.put("ad_id", we2.TRI());
        contentValues.put(TrackingKey.ERROR_CODE, we2.qr());
        contentValues.put("error_msg", we2.Ol());
        com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(this.f26587sc, "trackurl", contentValues);
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI.ExN
    public void zY(We we2) {
        com.bytedance.sdk.component.TRI.sc.sc.sc.zY.sc(this.f26587sc, "trackurl", "id=?", new String[]{we2.sc()});
    }
}
