package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.foundation.same.report.BatchReportMessage;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BatchReportDao extends a<BatchReportMessage> implements NoProGuard, Serializable {
    private static volatile BatchReportDao instance;
    private final Object lock;

    public BatchReportDao(g gVar) {
        super(gVar);
        this.lock = new Object();
    }

    public static BatchReportDao getInstance(Context context) {
        if (instance == null) {
            synchronized (BatchReportDao.class) {
                try {
                    if (instance == null) {
                        instance = new BatchReportDao(h.a(context));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return instance;
    }

    public static BatchReportDao getInstance(g gVar) {
        if (instance == null) {
            synchronized (BatchReportDao.class) {
                try {
                    if (instance == null) {
                        instance = new BatchReportDao(gVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return instance;
    }

    public void addReportMessage(String str, int i11) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (com.mbridge.msdk.f.d.a(writableDatabase)) {
            try {
                synchronized (this.lock) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("report_message", str);
                        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                        contentValues.put("uuid", UUID.randomUUID().toString().replace("-", ""));
                        contentValues.put("report_state", (Integer) 0);
                        contentValues.put("type", Integer.valueOf(i11));
                        writableDatabase.insert("batch_report", null, contentValues);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void deleteBatchReportMessagesByTimestamp(long j11) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (com.mbridge.msdk.f.d.a(writableDatabase)) {
            try {
                synchronized (this.lock) {
                    writableDatabase.execSQL("delete from batch_report where time <= " + j11);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public ArrayList<BatchReportMessage> getBatchReportMessages(long j11, int i11) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursor = null;
        if (!com.mbridge.msdk.f.d.a(writableDatabase)) {
            return null;
        }
        ArrayList<BatchReportMessage> arrayList = new ArrayList<>();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM ");
        sb2.append("batch_report");
        sb2.append(" WHERE ");
        sb2.append("time");
        sb2.append(" <= ");
        sb2.append(j11);
        sb2.append(" AND ");
        sb2.append("report_state");
        sb2.append(" = 0");
        sb2.append(" AND ");
        sb2.append("type");
        sb2.append(" = " + i11);
        sb2.append(" ORDER BY ");
        sb2.append("time");
        sb2.append(" ASC ");
        synchronized (this.lock) {
            try {
                try {
                    Cursor cursorRawQuery = writableDatabase.rawQuery(sb2.toString(), null);
                    if (cursorRawQuery != null) {
                        while (cursorRawQuery.moveToNext()) {
                            try {
                                arrayList.add(new BatchReportMessage(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("uuid")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("report_message")), cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("time"))));
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursorRawQuery;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Exception unused2) {
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("report_state", (Integer) 1);
                    writableDatabase.update("batch_report", contentValues, "time <= " + j11, null);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return arrayList;
    }

    public void updateMessagesReportState(ArrayList<BatchReportMessage> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (arrayList == null || arrayList.size() == 0 || !com.mbridge.msdk.f.d.a(writableDatabase)) {
            return;
        }
        for (BatchReportMessage batchReportMessage : arrayList) {
            try {
                synchronized (this.lock) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("report_state", (Integer) 0);
                        writableDatabase.update("batch_report", contentValues, "uuid = '" + batchReportMessage.getUuid() + "'", null);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
