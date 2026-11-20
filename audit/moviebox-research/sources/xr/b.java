package xr;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.v;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements xr.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f80684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<MsgBean> f80685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.room.h<MsgBean> f80686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.room.h<MsgBean> f80687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f80688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f80689f;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<List<MsgBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f80690a;

        public a(v vVar) {
            this.f80690a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<MsgBean> call() throws Exception {
            a aVar;
            Cursor cursorC = e6.b.c(b.this.f80684a, this.f80690a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, CampaignEx.JSON_KEY_DEEP_LINK_URL);
                int iE3 = e6.a.e(cursorC, CampaignEx.JSON_KEY_DESC);
                int iE4 = e6.a.e(cursorC, GifImagePreviewActivity.IMAGE_LIST);
                int iE5 = e6.a.e(cursorC, PushConstants.EXTRA_PUSH_MESSAGE_ID);
                int iE6 = e6.a.e(cursorC, "source");
                int iE7 = e6.a.e(cursorC, TtmlNode.TAG_STYLE);
                int iE8 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE9 = e6.a.e(cursorC, "type");
                int iE10 = e6.a.e(cursorC, "receive_time");
                int iE11 = e6.a.e(cursorC, "msg_status");
                int iE12 = e6.a.e(cursorC, TrackingKey.SHOW_TIME);
                int iE13 = e6.a.e(cursorC, "force_show");
                int iE14 = e6.a.e(cursorC, "has_screen_on");
                try {
                    int iE15 = e6.a.e(cursorC, "built_in");
                    int iE16 = e6.a.e(cursorC, "permanent_msg_status");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        int i12 = cursorC.getInt(iE);
                        String string = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string2 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string3 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string4 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        String string8 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        Long lValueOf = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        int i13 = cursorC.getInt(iE11);
                        Long lValueOf2 = cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12));
                        boolean z11 = cursorC.getInt(iE13) != 0;
                        boolean z12 = cursorC.getInt(i11) != 0;
                        int i14 = iE15;
                        int i15 = iE;
                        boolean z13 = cursorC.getInt(i14) != 0;
                        int i16 = iE16;
                        arrayList.add(new MsgBean(i12, string, string2, string3, string4, string5, string6, string7, string8, lValueOf, i13, lValueOf2, z11, z12, z13, cursorC.getInt(i16)));
                        iE = i15;
                        iE15 = i14;
                        iE16 = i16;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f80690a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    aVar = this;
                    cursorC.close();
                    aVar.f80690a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                aVar = this;
            }
        }
    }

    /* JADX INFO: renamed from: xr.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class CallableC0905b implements Callable<List<MsgBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f80692a;

        public CallableC0905b(v vVar) {
            this.f80692a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<MsgBean> call() throws Exception {
            CallableC0905b callableC0905b;
            Cursor cursorC = e6.b.c(b.this.f80684a, this.f80692a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, CampaignEx.JSON_KEY_DEEP_LINK_URL);
                int iE3 = e6.a.e(cursorC, CampaignEx.JSON_KEY_DESC);
                int iE4 = e6.a.e(cursorC, GifImagePreviewActivity.IMAGE_LIST);
                int iE5 = e6.a.e(cursorC, PushConstants.EXTRA_PUSH_MESSAGE_ID);
                int iE6 = e6.a.e(cursorC, "source");
                int iE7 = e6.a.e(cursorC, TtmlNode.TAG_STYLE);
                int iE8 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE9 = e6.a.e(cursorC, "type");
                int iE10 = e6.a.e(cursorC, "receive_time");
                int iE11 = e6.a.e(cursorC, "msg_status");
                int iE12 = e6.a.e(cursorC, TrackingKey.SHOW_TIME);
                int iE13 = e6.a.e(cursorC, "force_show");
                int iE14 = e6.a.e(cursorC, "has_screen_on");
                try {
                    int iE15 = e6.a.e(cursorC, "built_in");
                    int iE16 = e6.a.e(cursorC, "permanent_msg_status");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        int i12 = cursorC.getInt(iE);
                        String string = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string2 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string3 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string4 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        String string8 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        Long lValueOf = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        int i13 = cursorC.getInt(iE11);
                        Long lValueOf2 = cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12));
                        boolean z11 = cursorC.getInt(iE13) != 0;
                        boolean z12 = cursorC.getInt(i11) != 0;
                        int i14 = iE15;
                        int i15 = iE;
                        boolean z13 = cursorC.getInt(i14) != 0;
                        int i16 = iE16;
                        arrayList.add(new MsgBean(i12, string, string2, string3, string4, string5, string6, string7, string8, lValueOf, i13, lValueOf2, z11, z12, z13, cursorC.getInt(i16)));
                        iE = i15;
                        iE15 = i14;
                        iE16 = i16;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f80692a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    callableC0905b = this;
                    cursorC.close();
                    callableC0905b.f80692a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                callableC0905b = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Callable<MsgBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f80694a;

        public c(v vVar) {
            this.f80694a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MsgBean call() throws Exception {
            MsgBean msgBean;
            c cVar = this;
            Cursor cursorC = e6.b.c(b.this.f80684a, cVar.f80694a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, CampaignEx.JSON_KEY_DEEP_LINK_URL);
                int iE3 = e6.a.e(cursorC, CampaignEx.JSON_KEY_DESC);
                int iE4 = e6.a.e(cursorC, GifImagePreviewActivity.IMAGE_LIST);
                int iE5 = e6.a.e(cursorC, PushConstants.EXTRA_PUSH_MESSAGE_ID);
                int iE6 = e6.a.e(cursorC, "source");
                int iE7 = e6.a.e(cursorC, TtmlNode.TAG_STYLE);
                int iE8 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE9 = e6.a.e(cursorC, "type");
                int iE10 = e6.a.e(cursorC, "receive_time");
                int iE11 = e6.a.e(cursorC, "msg_status");
                int iE12 = e6.a.e(cursorC, TrackingKey.SHOW_TIME);
                int iE13 = e6.a.e(cursorC, "force_show");
                int iE14 = e6.a.e(cursorC, "has_screen_on");
                try {
                    int iE15 = e6.a.e(cursorC, "built_in");
                    int iE16 = e6.a.e(cursorC, "permanent_msg_status");
                    if (cursorC.moveToFirst()) {
                        msgBean = new MsgBean(cursorC.getInt(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8), cursorC.isNull(iE9) ? null : cursorC.getString(iE9), cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10)), cursorC.getInt(iE11), cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12)), cursorC.getInt(iE13) != 0, cursorC.getInt(iE14) != 0, cursorC.getInt(iE15) != 0, cursorC.getInt(iE16));
                    } else {
                        msgBean = null;
                    }
                    cursorC.close();
                    this.f80694a.release();
                    return msgBean;
                } catch (Throwable th2) {
                    th = th2;
                    cVar = this;
                    cursorC.close();
                    cVar.f80694a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<List<MsgBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f80696a;

        public d(v vVar) {
            this.f80696a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<MsgBean> call() throws Exception {
            d dVar;
            Cursor cursorC = e6.b.c(b.this.f80684a, this.f80696a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, CampaignEx.JSON_KEY_DEEP_LINK_URL);
                int iE3 = e6.a.e(cursorC, CampaignEx.JSON_KEY_DESC);
                int iE4 = e6.a.e(cursorC, GifImagePreviewActivity.IMAGE_LIST);
                int iE5 = e6.a.e(cursorC, PushConstants.EXTRA_PUSH_MESSAGE_ID);
                int iE6 = e6.a.e(cursorC, "source");
                int iE7 = e6.a.e(cursorC, TtmlNode.TAG_STYLE);
                int iE8 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE9 = e6.a.e(cursorC, "type");
                int iE10 = e6.a.e(cursorC, "receive_time");
                int iE11 = e6.a.e(cursorC, "msg_status");
                int iE12 = e6.a.e(cursorC, TrackingKey.SHOW_TIME);
                int iE13 = e6.a.e(cursorC, "force_show");
                int iE14 = e6.a.e(cursorC, "has_screen_on");
                try {
                    int iE15 = e6.a.e(cursorC, "built_in");
                    int iE16 = e6.a.e(cursorC, "permanent_msg_status");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        int i12 = cursorC.getInt(iE);
                        String string = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string2 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string3 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string4 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        String string8 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        Long lValueOf = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        int i13 = cursorC.getInt(iE11);
                        Long lValueOf2 = cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12));
                        boolean z11 = cursorC.getInt(iE13) != 0;
                        boolean z12 = cursorC.getInt(i11) != 0;
                        int i14 = iE15;
                        int i15 = iE;
                        boolean z13 = cursorC.getInt(i14) != 0;
                        int i16 = iE16;
                        arrayList.add(new MsgBean(i12, string, string2, string3, string4, string5, string6, string7, string8, lValueOf, i13, lValueOf2, z11, z12, z13, cursorC.getInt(i16)));
                        iE = i15;
                        iE15 = i14;
                        iE16 = i16;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f80696a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    dVar = this;
                    cursorC.close();
                    dVar.f80696a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends androidx.room.i<MsgBean> {
        public e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `msg` (`id`,`deep_link`,`desc`,`image_list`,`message_id`,`source`,`style`,`title`,`type`,`receive_time`,`msg_status`,`show_time`,`force_show`,`has_screen_on`,`built_in`,`permanent_msg_status`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, MsgBean msgBean) {
            kVar.V(1, msgBean.getId());
            if (msgBean.getDeeplink() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, msgBean.getDeeplink());
            }
            if (msgBean.getDesc() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, msgBean.getDesc());
            }
            if (msgBean.getImageList() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, msgBean.getImageList());
            }
            if (msgBean.getMessageId() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, msgBean.getMessageId());
            }
            if (msgBean.getSource() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, msgBean.getSource());
            }
            if (msgBean.getStyle() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, msgBean.getStyle());
            }
            if (msgBean.getTitle() == null) {
                kVar.m0(8);
            } else {
                kVar.s(8, msgBean.getTitle());
            }
            if (msgBean.getType() == null) {
                kVar.m0(9);
            } else {
                kVar.s(9, msgBean.getType());
            }
            if (msgBean.getReceiveTime() == null) {
                kVar.m0(10);
            } else {
                kVar.V(10, msgBean.getReceiveTime().longValue());
            }
            kVar.V(11, msgBean.getMsgStatus());
            if (msgBean.getShowTime() == null) {
                kVar.m0(12);
            } else {
                kVar.V(12, msgBean.getShowTime().longValue());
            }
            kVar.V(13, msgBean.getForceShow() ? 1L : 0L);
            kVar.V(14, msgBean.getHasScreenOn() ? 1L : 0L);
            kVar.V(15, msgBean.getBuiltIn() ? 1L : 0L);
            kVar.V(16, msgBean.getPermanentMsgStatus());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends androidx.room.h<MsgBean> {
        public f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM `msg` WHERE `id` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, MsgBean msgBean) {
            kVar.V(1, msgBean.getId());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends androidx.room.h<MsgBean> {
        public g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `msg` SET `id` = ?,`deep_link` = ?,`desc` = ?,`image_list` = ?,`message_id` = ?,`source` = ?,`style` = ?,`title` = ?,`type` = ?,`receive_time` = ?,`msg_status` = ?,`show_time` = ?,`force_show` = ?,`has_screen_on` = ?,`built_in` = ?,`permanent_msg_status` = ? WHERE `id` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, MsgBean msgBean) {
            kVar.V(1, msgBean.getId());
            if (msgBean.getDeeplink() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, msgBean.getDeeplink());
            }
            if (msgBean.getDesc() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, msgBean.getDesc());
            }
            if (msgBean.getImageList() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, msgBean.getImageList());
            }
            if (msgBean.getMessageId() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, msgBean.getMessageId());
            }
            if (msgBean.getSource() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, msgBean.getSource());
            }
            if (msgBean.getStyle() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, msgBean.getStyle());
            }
            if (msgBean.getTitle() == null) {
                kVar.m0(8);
            } else {
                kVar.s(8, msgBean.getTitle());
            }
            if (msgBean.getType() == null) {
                kVar.m0(9);
            } else {
                kVar.s(9, msgBean.getType());
            }
            if (msgBean.getReceiveTime() == null) {
                kVar.m0(10);
            } else {
                kVar.V(10, msgBean.getReceiveTime().longValue());
            }
            kVar.V(11, msgBean.getMsgStatus());
            if (msgBean.getShowTime() == null) {
                kVar.m0(12);
            } else {
                kVar.V(12, msgBean.getShowTime().longValue());
            }
            kVar.V(13, msgBean.getForceShow() ? 1L : 0L);
            kVar.V(14, msgBean.getHasScreenOn() ? 1L : 0L);
            kVar.V(15, msgBean.getBuiltIn() ? 1L : 0L);
            kVar.V(16, msgBean.getPermanentMsgStatus());
            kVar.V(17, msgBean.getId());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends SharedSQLiteStatement {
        public h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM MSG";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends SharedSQLiteStatement {
        public i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM MSG WHERE message_id = ?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MsgBean f80703a;

        public j(MsgBean msgBean) {
            this.f80703a = msgBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f80684a.e();
            try {
                b.this.f80685b.k(this.f80703a);
                b.this.f80684a.E();
                return Unit.f68710a;
            } finally {
                b.this.f80684a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MsgBean f80705a;

        public k(MsgBean msgBean) {
            this.f80705a = msgBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f80684a.e();
            try {
                b.this.f80687d.j(this.f80705a);
                b.this.f80684a.E();
                return Unit.f68710a;
            } finally {
                b.this.f80684a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l implements Callable<Unit> {
        public l() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = b.this.f80688e.b();
            b.this.f80684a.e();
            try {
                kVarB.F();
                b.this.f80684a.E();
                return Unit.f68710a;
            } finally {
                b.this.f80684a.i();
                b.this.f80688e.h(kVarB);
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f80684a = roomDatabase;
        this.f80685b = new e(roomDatabase);
        this.f80686c = new f(roomDatabase);
        this.f80687d = new g(roomDatabase);
        this.f80688e = new h(roomDatabase);
        this.f80689f = new i(roomDatabase);
    }

    public static List<Class<?>> l() {
        return Collections.emptyList();
    }

    @Override // xr.a
    public Object a(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f80684a, true, new l(), continuation);
    }

    @Override // xr.a
    public Object b(Continuation<? super List<MsgBean>> continuation) {
        v vVarC = v.c("SELECT * FROM MSG ORDER BY show_time DESC", 0);
        return CoroutinesRoom.a(this.f80684a, false, e6.b.a(), new CallableC0905b(vVarC), continuation);
    }

    @Override // xr.a
    public Object c(MsgBean msgBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f80684a, true, new k(msgBean), continuation);
    }

    @Override // xr.a
    public Object d(MsgBean msgBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f80684a, true, new j(msgBean), continuation);
    }

    @Override // xr.a
    public Object e(Continuation<? super List<MsgBean>> continuation) {
        v vVarC = v.c("SELECT * FROM MSG ORDER BY receive_time DESC", 0);
        return CoroutinesRoom.a(this.f80684a, false, e6.b.a(), new a(vVarC), continuation);
    }

    @Override // xr.a
    public Object f(String str, Continuation<? super MsgBean> continuation) {
        v vVarC = v.c("SELECT * FROM MSG WHERE message_id = ?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f80684a, false, e6.b.a(), new c(vVarC), continuation);
    }

    @Override // xr.a
    public Object g(String str, Continuation<? super List<MsgBean>> continuation) {
        v vVarC = v.c("SELECT * FROM MSG WHERE type = ? ORDER BY id ASC", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f80684a, false, e6.b.a(), new d(vVarC), continuation);
    }
}
