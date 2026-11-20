package androidx.media3.exoplayer.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.StreamKey;
import androidx.media3.database.DatabaseIOException;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10890f = p(3, 4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f10891g = {"id", "mime_type", "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded", "key_set_id"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b4.a f10894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f10895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10896e;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Cursor f10897a;

        public b(Cursor cursor) {
            this.f10897a = cursor;
        }

        @Override // androidx.media3.exoplayer.offline.e
        public c N() {
            return a.n(this.f10897a);
        }

        @Override // androidx.media3.exoplayer.offline.e, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f10897a.close();
        }

        @Override // androidx.media3.exoplayer.offline.e
        public int getPosition() {
            return this.f10897a.getPosition();
        }

        @Override // androidx.media3.exoplayer.offline.e
        public /* synthetic */ boolean moveToNext() {
            return d.a(this);
        }

        @Override // androidx.media3.exoplayer.offline.e
        public boolean moveToPosition(int i11) {
            return this.f10897a.moveToPosition(i11);
        }
    }

    public a(b4.a aVar) {
        this(aVar, "");
    }

    public a(b4.a aVar, String str) {
        this.f10892a = str;
        this.f10894c = aVar;
        this.f10893b = "ExoPlayerDownloads" + str;
        this.f10895d = new Object();
    }

    public static List<StreamKey> j(@Nullable String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String str2 : u0.o1(str, ",")) {
            String[] strArrO1 = u0.o1(str2, "\\.");
            z3.a.g(strArrO1.length == 3);
            arrayList.add(new StreamKey(Integer.parseInt(strArrO1[0]), Integer.parseInt(strArrO1[1]), Integer.parseInt(strArrO1[2])));
        }
        return arrayList;
    }

    public static String k(List<StreamKey> list) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            StreamKey streamKey = list.get(i11);
            sb2.append(streamKey.periodIndex);
            sb2.append('.');
            sb2.append(streamKey.groupIndex);
            sb2.append('.');
            sb2.append(streamKey.streamIndex);
            sb2.append(',');
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    public static c n(Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        DownloadRequest.b bVarF = new DownloadRequest.b((String) z3.a.e(cursor.getString(0)), Uri.parse((String) z3.a.e(cursor.getString(2)))).e(cursor.getString(1)).f(j(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        DownloadRequest downloadRequestA = bVarF.d(blob).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        l lVar = new l();
        lVar.f10912a = cursor.getLong(13);
        lVar.f10913b = cursor.getFloat(12);
        int i11 = cursor.getInt(6);
        return new c(downloadRequestA, i11, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i11 == 4 ? cursor.getInt(11) : 0, lVar);
    }

    public static c o(Cursor cursor) {
        DownloadRequest downloadRequestA = new DownloadRequest.b((String) z3.a.e(cursor.getString(0)), Uri.parse((String) z3.a.e(cursor.getString(2)))).e(q(cursor.getString(1))).f(j(cursor.getString(3))).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        l lVar = new l();
        lVar.f10912a = cursor.getLong(13);
        lVar.f10913b = cursor.getFloat(12);
        int i11 = cursor.getInt(6);
        return new c(downloadRequestA, i11, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i11 == 4 ? cursor.getInt(11) : 0, lVar);
    }

    public static String p(int... iArr) {
        if (iArr.length == 0) {
            return "1";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("state");
        sb2.append(" IN (");
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (i11 > 0) {
                sb2.append(',');
            }
            sb2.append(iArr[i11]);
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static String q(@Nullable String str) {
        if ("dash".equals(str)) {
            return MimeTypes.APPLICATION_MPD;
        }
        if ("hls".equals(str)) {
            return MimeTypes.APPLICATION_M3U8;
        }
        return "ss".equals(str) ? MimeTypes.APPLICATION_SS : MimeTypes.VIDEO_UNKNOWN;
    }

    @Override // androidx.media3.exoplayer.offline.t
    public void a(String str, int i11) throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i11));
            this.f10894c.getWritableDatabase().update(this.f10893b, contentValues, f10890f + " AND id = ?", new String[]{str});
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.t
    public void b(c cVar) throws DatabaseIOException {
        l();
        try {
            s(cVar, this.f10894c.getWritableDatabase());
        } catch (SQLiteException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.t
    public void c(String str) throws DatabaseIOException {
        l();
        try {
            this.f10894c.getWritableDatabase().delete(this.f10893b, "id = ?", new String[]{str});
        } catch (SQLiteException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.t
    public void d(int i11) throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i11));
            this.f10894c.getWritableDatabase().update(this.f10893b, contentValues, f10890f, null);
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.f
    public e e(int... iArr) throws DatabaseIOException {
        l();
        return new b(m(p(iArr), null));
    }

    @Override // androidx.media3.exoplayer.offline.t
    public void f() throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 5);
            contentValues.put("failure_reason", (Integer) 0);
            this.f10894c.getWritableDatabase().update(this.f10893b, contentValues, null, null);
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.t
    public void g() throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 0);
            this.f10894c.getWritableDatabase().update(this.f10893b, contentValues, "state = 2", null);
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.f
    @Nullable
    public c h(String str) throws DatabaseIOException {
        l();
        try {
            Cursor cursorM = m("id = ?", new String[]{str});
            try {
                if (cursorM.getCount() == 0) {
                    cursorM.close();
                    return null;
                }
                cursorM.moveToNext();
                c cVarN = n(cursorM);
                cursorM.close();
                return cVarN;
            } catch (Throwable th2) {
                if (cursorM != null) {
                    try {
                        cursorM.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        } catch (SQLiteException e11) {
            throw new DatabaseIOException(e11);
        }
        throw new DatabaseIOException(e11);
    }

    public final void l() throws DatabaseIOException {
        synchronized (this.f10895d) {
            if (this.f10896e) {
                return;
            }
            try {
                int iB = b4.c.b(this.f10894c.getReadableDatabase(), 0, this.f10892a);
                if (iB != 3) {
                    SQLiteDatabase writableDatabase = this.f10894c.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        b4.c.d(writableDatabase, 0, this.f10892a, 3);
                        List<c> listR = iB == 2 ? r(writableDatabase) : new ArrayList<>();
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.f10893b);
                        writableDatabase.execSQL("CREATE TABLE " + this.f10893b + " (id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)");
                        Iterator<c> it = listR.iterator();
                        while (it.hasNext()) {
                            s(it.next(), writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th2) {
                        writableDatabase.endTransaction();
                        throw th2;
                    }
                }
                this.f10896e = true;
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }
    }

    public final Cursor m(String str, @Nullable String[] strArr) throws DatabaseIOException {
        try {
            return this.f10894c.getReadableDatabase().query(this.f10893b, f10891g, str, strArr, null, null, "start_time_ms ASC");
        } catch (SQLiteException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public final List<c> r(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        if (!u0.t1(sQLiteDatabase, this.f10893b)) {
            return arrayList;
        }
        Cursor cursorQuery = sQLiteDatabase.query(this.f10893b, new String[]{"id", CampaignEx.JSON_KEY_TITLE, "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded"}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(o(cursorQuery));
            } catch (Throwable th2) {
                if (cursorQuery == null) {
                    throw th2;
                }
                try {
                    cursorQuery.close();
                    throw th2;
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                    throw th2;
                }
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    public final void s(c cVar, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = cVar.f10901a.keySetId;
        if (bArr == null) {
            bArr = u0.f81843f;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", cVar.f10901a.f10832id);
        contentValues.put("mime_type", cVar.f10901a.mimeType);
        contentValues.put("uri", cVar.f10901a.uri.toString());
        contentValues.put("stream_keys", k(cVar.f10901a.streamKeys));
        contentValues.put("custom_cache_key", cVar.f10901a.customCacheKey);
        contentValues.put("data", cVar.f10901a.data);
        contentValues.put("state", Integer.valueOf(cVar.f10902b));
        contentValues.put("start_time_ms", Long.valueOf(cVar.f10903c));
        contentValues.put("update_time_ms", Long.valueOf(cVar.f10904d));
        contentValues.put("content_length", Long.valueOf(cVar.f10905e));
        contentValues.put("stop_reason", Integer.valueOf(cVar.f10906f));
        contentValues.put("failure_reason", Integer.valueOf(cVar.f10907g));
        contentValues.put("percent_downloaded", Float.valueOf(cVar.b()));
        contentValues.put("bytes_downloaded", Long.valueOf(cVar.a()));
        contentValues.put("key_set_id", bArr);
        sQLiteDatabase.replaceOrThrow(this.f10893b, null, contentValues);
    }
}
