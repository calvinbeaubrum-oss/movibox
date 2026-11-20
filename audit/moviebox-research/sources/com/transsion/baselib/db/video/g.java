package com.transsion.baselib.db.video;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.i;
import g6.k;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i<VideoLandAdBean> f51166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f51167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f51168d;

    /* JADX INFO: compiled from: source.java */
    public class a extends i<VideoLandAdBean> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `video_land_ad` (`resourceId`,`startAdDayKey`,`endAdDayKey`) VALUES (?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, VideoLandAdBean videoLandAdBean) {
            if (videoLandAdBean.getResourceId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, videoLandAdBean.getResourceId());
            }
            kVar.V(2, videoLandAdBean.getStartAdDayKey());
            kVar.V(3, videoLandAdBean.getEndAdDayKey());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends SharedSQLiteStatement {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE VIDEO_LAND_AD SET startAdDayKey = ? WHERE resourceId = ? ";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE VIDEO_LAND_AD SET endAdDayKey = ? WHERE resourceId = ? ";
        }
    }

    public g(RoomDatabase roomDatabase) {
        this.f51165a = roomDatabase;
        this.f51166b = new a(roomDatabase);
        this.f51167c = new b(roomDatabase);
        this.f51168d = new c(roomDatabase);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }
}
