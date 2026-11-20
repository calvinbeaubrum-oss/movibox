package tr;

import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.v;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.baselib.db.download.DownloadRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f77376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<DownloadRange> f77377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f77378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f77379d;

    /* JADX INFO: compiled from: source.java */
    public class a extends androidx.room.i<DownloadRange> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `download_thread_range` (`threadId`,`rangeId`,`resourceId`,`start`,`end`,`progress`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, DownloadRange downloadRange) {
            kVar.V(1, downloadRange.getThreadId());
            kVar.V(2, downloadRange.getRangeId());
            if (downloadRange.getResourceId() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, downloadRange.getResourceId());
            }
            kVar.V(4, downloadRange.getStart());
            kVar.V(5, downloadRange.getEnd());
            kVar.V(6, downloadRange.getProgress());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends SharedSQLiteStatement {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM DOWNLOAD_THREAD_RANGE WHERE rangeId=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM DOWNLOAD_THREAD_RANGE WHERE resourceId=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadRange f77383a;

        public d(DownloadRange downloadRange) {
            this.f77383a = downloadRange;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            i.this.f77376a.e();
            try {
                i.this.f77377b.k(this.f77383a);
                i.this.f77376a.E();
                return Unit.f68710a;
            } finally {
                i.this.f77376a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f77385a;

        public e(String str) {
            this.f77385a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = i.this.f77379d.b();
            String str = this.f77385a;
            if (str == null) {
                kVarB.m0(1);
            } else {
                kVarB.s(1, str);
            }
            i.this.f77376a.e();
            try {
                kVarB.F();
                i.this.f77376a.E();
                return Unit.f68710a;
            } finally {
                i.this.f77376a.i();
                i.this.f77379d.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Callable<List<DownloadRange>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f77387a;

        public f(v vVar) {
            this.f77387a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<DownloadRange> call() throws Exception {
            Cursor cursorC = e6.b.c(i.this.f77376a, this.f77387a, false, null);
            try {
                int iE = e6.a.e(cursorC, "threadId");
                int iE2 = e6.a.e(cursorC, "rangeId");
                int iE3 = e6.a.e(cursorC, "resourceId");
                int iE4 = e6.a.e(cursorC, "start");
                int iE5 = e6.a.e(cursorC, TtmlNode.END);
                int iE6 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    DownloadRange downloadRange = new DownloadRange();
                    downloadRange.setThreadId(cursorC.getInt(iE));
                    downloadRange.setRangeId(cursorC.getInt(iE2));
                    downloadRange.setResourceId(cursorC.isNull(iE3) ? null : cursorC.getString(iE3));
                    downloadRange.setStart(cursorC.getLong(iE4));
                    downloadRange.setEnd(cursorC.getLong(iE5));
                    downloadRange.setProgress(cursorC.getLong(iE6));
                    arrayList.add(downloadRange);
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.f77387a.release();
            }
        }
    }

    public i(RoomDatabase roomDatabase) {
        this.f77376a = roomDatabase;
        this.f77377b = new a(roomDatabase);
        this.f77378c = new b(roomDatabase);
        this.f77379d = new c(roomDatabase);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // tr.h
    public Object a(String str, Continuation<? super List<DownloadRange>> continuation) {
        v vVarC = v.c("SELECT * FROM DOWNLOAD_THREAD_RANGE WHERE resourceId = ?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f77376a, false, e6.b.a(), new f(vVarC), continuation);
    }

    @Override // tr.h
    public Object b(String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77376a, true, new e(str), continuation);
    }

    @Override // tr.h
    public Object c(DownloadRange downloadRange, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77376a, true, new d(downloadRange), continuation);
    }
}
