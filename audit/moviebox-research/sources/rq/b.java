package rq;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.v;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.ad.db.plan.MbAdDbPlans;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements rq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f75672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<MbAdDbPlans> f75673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.room.h<MbAdDbPlans> f75674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f75675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f75676e;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<List<MbAdDbPlans>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f75677a;

        public a(v vVar) {
            this.f75677a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<MbAdDbPlans> call() throws Exception {
            a aVar;
            Cursor cursorC = e6.b.c(b.this.f75672a, this.f75677a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, "version");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "startTime");
                int iE5 = e6.a.e(cursorC, "endTime");
                int iE6 = e6.a.e(cursorC, "extraConfig");
                int iE7 = e6.a.e(cursorC, "displayTimes");
                int iE8 = e6.a.e(cursorC, "showedTimes");
                int iE9 = e6.a.e(cursorC, "showDate");
                int iE10 = e6.a.e(cursorC, "advertiserName");
                int iE11 = e6.a.e(cursorC, "advertiserAvatar");
                int iE12 = e6.a.e(cursorC, "advertiserAvatarPath");
                int iE13 = e6.a.e(cursorC, "brand");
                int iE14 = e6.a.e(cursorC, "denyBrand");
                try {
                    int iE15 = e6.a.e(cursorC, "model");
                    int iE16 = e6.a.e(cursorC, "denyModel");
                    int iE17 = e6.a.e(cursorC, PlaceTypes.COUNTRY);
                    int iE18 = e6.a.e(cursorC, "scenes");
                    int iE19 = e6.a.e(cursorC, "adSource");
                    int iE20 = e6.a.e(cursorC, "extAdSlot");
                    int iE21 = e6.a.e(cursorC, "adMaterialList");
                    int iE22 = e6.a.e(cursorC, "adPlanUpdateTime");
                    int iE23 = e6.a.e(cursorC, "sort");
                    int iE24 = e6.a.e(cursorC, "adShowLevel");
                    int iE25 = e6.a.e(cursorC, "filterClientVersion");
                    int iE26 = e6.a.e(cursorC, "adPlanCreateTime");
                    int iE27 = e6.a.e(cursorC, "appStarDesc");
                    int iE28 = e6.a.e(cursorC, "appSizeDesc");
                    int iE29 = e6.a.e(cursorC, "ctxEnableExpr");
                    int iE30 = e6.a.e(cursorC, "ctxDisableExpr");
                    int iE31 = e6.a.e(cursorC, "ctxAttributeConfig");
                    int iE32 = e6.a.e(cursorC, "dispatchTimeStart");
                    int iE33 = e6.a.e(cursorC, "dispatchTimeEnd");
                    int iE34 = e6.a.e(cursorC, "extImage");
                    int iE35 = e6.a.e(cursorC, "bidEcpmCent");
                    int iE36 = e6.a.e(cursorC, "ecpmCent");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string5 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string6 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        Integer numValueOf = cursorC.isNull(iE7) ? null : Integer.valueOf(cursorC.getInt(iE7));
                        Integer numValueOf2 = cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8));
                        String string7 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        String string8 = cursorC.isNull(iE10) ? null : cursorC.getString(iE10);
                        String string9 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        String string10 = cursorC.isNull(iE12) ? null : cursorC.getString(iE12);
                        String string11 = cursorC.isNull(iE13) ? null : cursorC.getString(iE13);
                        String string12 = cursorC.isNull(i11) ? null : cursorC.getString(i11);
                        int i12 = iE15;
                        int i13 = iE;
                        String string13 = cursorC.isNull(i12) ? null : cursorC.getString(i12);
                        int i14 = iE16;
                        String string14 = cursorC.isNull(i14) ? null : cursorC.getString(i14);
                        int i15 = iE17;
                        String string15 = cursorC.isNull(i15) ? null : cursorC.getString(i15);
                        int i16 = iE18;
                        String string16 = cursorC.isNull(i16) ? null : cursorC.getString(i16);
                        int i17 = iE19;
                        String string17 = cursorC.isNull(i17) ? null : cursorC.getString(i17);
                        int i18 = iE20;
                        String string18 = cursorC.isNull(i18) ? null : cursorC.getString(i18);
                        int i19 = iE21;
                        String string19 = cursorC.isNull(i19) ? null : cursorC.getString(i19);
                        int i21 = iE22;
                        String string20 = cursorC.isNull(i21) ? null : cursorC.getString(i21);
                        int i22 = iE23;
                        Integer numValueOf3 = cursorC.isNull(i22) ? null : Integer.valueOf(cursorC.getInt(i22));
                        int i23 = iE24;
                        String string21 = cursorC.isNull(i23) ? null : cursorC.getString(i23);
                        int i24 = iE25;
                        String string22 = cursorC.isNull(i24) ? null : cursorC.getString(i24);
                        int i25 = iE26;
                        String string23 = cursorC.isNull(i25) ? null : cursorC.getString(i25);
                        int i26 = iE27;
                        String string24 = cursorC.isNull(i26) ? null : cursorC.getString(i26);
                        int i27 = iE28;
                        String string25 = cursorC.isNull(i27) ? null : cursorC.getString(i27);
                        int i28 = iE29;
                        String string26 = cursorC.isNull(i28) ? null : cursorC.getString(i28);
                        int i29 = iE30;
                        String string27 = cursorC.isNull(i29) ? null : cursorC.getString(i29);
                        int i31 = iE31;
                        String string28 = cursorC.isNull(i31) ? null : cursorC.getString(i31);
                        int i32 = iE32;
                        String string29 = cursorC.isNull(i32) ? null : cursorC.getString(i32);
                        int i33 = iE33;
                        String string30 = cursorC.isNull(i33) ? null : cursorC.getString(i33);
                        int i34 = iE34;
                        String string31 = cursorC.isNull(i34) ? null : cursorC.getString(i34);
                        int i35 = iE35;
                        Double dValueOf = cursorC.isNull(i35) ? null : Double.valueOf(cursorC.getDouble(i35));
                        int i36 = iE36;
                        arrayList.add(new MbAdDbPlans(string, string2, string3, string4, string5, string6, numValueOf, numValueOf2, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, numValueOf3, string21, string22, string23, string24, string25, string26, string27, string28, string29, string30, string31, dValueOf, cursorC.isNull(i36) ? null : Long.valueOf(cursorC.getLong(i36))));
                        iE = i13;
                        iE15 = i12;
                        iE16 = i14;
                        iE17 = i15;
                        iE18 = i16;
                        iE19 = i17;
                        iE20 = i18;
                        iE21 = i19;
                        iE22 = i21;
                        iE23 = i22;
                        iE24 = i23;
                        iE25 = i24;
                        iE26 = i25;
                        iE27 = i26;
                        iE28 = i27;
                        iE29 = i28;
                        iE30 = i29;
                        iE31 = i31;
                        iE32 = i32;
                        iE33 = i33;
                        iE34 = i34;
                        iE35 = i35;
                        iE36 = i36;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f75677a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    aVar = this;
                    cursorC.close();
                    aVar.f75677a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                aVar = this;
            }
        }
    }

    /* JADX INFO: renamed from: rq.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class CallableC0831b implements Callable<List<MbAdDbPlans>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f75679a;

        public CallableC0831b(v vVar) {
            this.f75679a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<MbAdDbPlans> call() throws Exception {
            CallableC0831b callableC0831b;
            Cursor cursorC = e6.b.c(b.this.f75672a, this.f75679a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, "version");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "startTime");
                int iE5 = e6.a.e(cursorC, "endTime");
                int iE6 = e6.a.e(cursorC, "extraConfig");
                int iE7 = e6.a.e(cursorC, "displayTimes");
                int iE8 = e6.a.e(cursorC, "showedTimes");
                int iE9 = e6.a.e(cursorC, "showDate");
                int iE10 = e6.a.e(cursorC, "advertiserName");
                int iE11 = e6.a.e(cursorC, "advertiserAvatar");
                int iE12 = e6.a.e(cursorC, "advertiserAvatarPath");
                int iE13 = e6.a.e(cursorC, "brand");
                int iE14 = e6.a.e(cursorC, "denyBrand");
                try {
                    int iE15 = e6.a.e(cursorC, "model");
                    int iE16 = e6.a.e(cursorC, "denyModel");
                    int iE17 = e6.a.e(cursorC, PlaceTypes.COUNTRY);
                    int iE18 = e6.a.e(cursorC, "scenes");
                    int iE19 = e6.a.e(cursorC, "adSource");
                    int iE20 = e6.a.e(cursorC, "extAdSlot");
                    int iE21 = e6.a.e(cursorC, "adMaterialList");
                    int iE22 = e6.a.e(cursorC, "adPlanUpdateTime");
                    int iE23 = e6.a.e(cursorC, "sort");
                    int iE24 = e6.a.e(cursorC, "adShowLevel");
                    int iE25 = e6.a.e(cursorC, "filterClientVersion");
                    int iE26 = e6.a.e(cursorC, "adPlanCreateTime");
                    int iE27 = e6.a.e(cursorC, "appStarDesc");
                    int iE28 = e6.a.e(cursorC, "appSizeDesc");
                    int iE29 = e6.a.e(cursorC, "ctxEnableExpr");
                    int iE30 = e6.a.e(cursorC, "ctxDisableExpr");
                    int iE31 = e6.a.e(cursorC, "ctxAttributeConfig");
                    int iE32 = e6.a.e(cursorC, "dispatchTimeStart");
                    int iE33 = e6.a.e(cursorC, "dispatchTimeEnd");
                    int iE34 = e6.a.e(cursorC, "extImage");
                    int iE35 = e6.a.e(cursorC, "bidEcpmCent");
                    int iE36 = e6.a.e(cursorC, "ecpmCent");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string5 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string6 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        Integer numValueOf = cursorC.isNull(iE7) ? null : Integer.valueOf(cursorC.getInt(iE7));
                        Integer numValueOf2 = cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8));
                        String string7 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        String string8 = cursorC.isNull(iE10) ? null : cursorC.getString(iE10);
                        String string9 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        String string10 = cursorC.isNull(iE12) ? null : cursorC.getString(iE12);
                        String string11 = cursorC.isNull(iE13) ? null : cursorC.getString(iE13);
                        String string12 = cursorC.isNull(i11) ? null : cursorC.getString(i11);
                        int i12 = iE15;
                        int i13 = iE;
                        String string13 = cursorC.isNull(i12) ? null : cursorC.getString(i12);
                        int i14 = iE16;
                        String string14 = cursorC.isNull(i14) ? null : cursorC.getString(i14);
                        int i15 = iE17;
                        String string15 = cursorC.isNull(i15) ? null : cursorC.getString(i15);
                        int i16 = iE18;
                        String string16 = cursorC.isNull(i16) ? null : cursorC.getString(i16);
                        int i17 = iE19;
                        String string17 = cursorC.isNull(i17) ? null : cursorC.getString(i17);
                        int i18 = iE20;
                        String string18 = cursorC.isNull(i18) ? null : cursorC.getString(i18);
                        int i19 = iE21;
                        String string19 = cursorC.isNull(i19) ? null : cursorC.getString(i19);
                        int i21 = iE22;
                        String string20 = cursorC.isNull(i21) ? null : cursorC.getString(i21);
                        int i22 = iE23;
                        Integer numValueOf3 = cursorC.isNull(i22) ? null : Integer.valueOf(cursorC.getInt(i22));
                        int i23 = iE24;
                        String string21 = cursorC.isNull(i23) ? null : cursorC.getString(i23);
                        int i24 = iE25;
                        String string22 = cursorC.isNull(i24) ? null : cursorC.getString(i24);
                        int i25 = iE26;
                        String string23 = cursorC.isNull(i25) ? null : cursorC.getString(i25);
                        int i26 = iE27;
                        String string24 = cursorC.isNull(i26) ? null : cursorC.getString(i26);
                        int i27 = iE28;
                        String string25 = cursorC.isNull(i27) ? null : cursorC.getString(i27);
                        int i28 = iE29;
                        String string26 = cursorC.isNull(i28) ? null : cursorC.getString(i28);
                        int i29 = iE30;
                        String string27 = cursorC.isNull(i29) ? null : cursorC.getString(i29);
                        int i31 = iE31;
                        String string28 = cursorC.isNull(i31) ? null : cursorC.getString(i31);
                        int i32 = iE32;
                        String string29 = cursorC.isNull(i32) ? null : cursorC.getString(i32);
                        int i33 = iE33;
                        String string30 = cursorC.isNull(i33) ? null : cursorC.getString(i33);
                        int i34 = iE34;
                        String string31 = cursorC.isNull(i34) ? null : cursorC.getString(i34);
                        int i35 = iE35;
                        Double dValueOf = cursorC.isNull(i35) ? null : Double.valueOf(cursorC.getDouble(i35));
                        int i36 = iE36;
                        arrayList.add(new MbAdDbPlans(string, string2, string3, string4, string5, string6, numValueOf, numValueOf2, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, numValueOf3, string21, string22, string23, string24, string25, string26, string27, string28, string29, string30, string31, dValueOf, cursorC.isNull(i36) ? null : Long.valueOf(cursorC.getLong(i36))));
                        iE = i13;
                        iE15 = i12;
                        iE16 = i14;
                        iE17 = i15;
                        iE18 = i16;
                        iE19 = i17;
                        iE20 = i18;
                        iE21 = i19;
                        iE22 = i21;
                        iE23 = i22;
                        iE24 = i23;
                        iE25 = i24;
                        iE26 = i25;
                        iE27 = i26;
                        iE28 = i27;
                        iE29 = i28;
                        iE30 = i29;
                        iE31 = i31;
                        iE32 = i32;
                        iE33 = i33;
                        iE34 = i34;
                        iE35 = i35;
                        iE36 = i36;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f75679a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    callableC0831b = this;
                    cursorC.close();
                    callableC0831b.f75679a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                callableC0831b = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Callable<List<MbAdDbPlans>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f75681a;

        public c(v vVar) {
            this.f75681a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<MbAdDbPlans> call() throws Exception {
            c cVar;
            Cursor cursorC = e6.b.c(b.this.f75672a, this.f75681a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, "version");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "startTime");
                int iE5 = e6.a.e(cursorC, "endTime");
                int iE6 = e6.a.e(cursorC, "extraConfig");
                int iE7 = e6.a.e(cursorC, "displayTimes");
                int iE8 = e6.a.e(cursorC, "showedTimes");
                int iE9 = e6.a.e(cursorC, "showDate");
                int iE10 = e6.a.e(cursorC, "advertiserName");
                int iE11 = e6.a.e(cursorC, "advertiserAvatar");
                int iE12 = e6.a.e(cursorC, "advertiserAvatarPath");
                int iE13 = e6.a.e(cursorC, "brand");
                int iE14 = e6.a.e(cursorC, "denyBrand");
                try {
                    int iE15 = e6.a.e(cursorC, "model");
                    int iE16 = e6.a.e(cursorC, "denyModel");
                    int iE17 = e6.a.e(cursorC, PlaceTypes.COUNTRY);
                    int iE18 = e6.a.e(cursorC, "scenes");
                    int iE19 = e6.a.e(cursorC, "adSource");
                    int iE20 = e6.a.e(cursorC, "extAdSlot");
                    int iE21 = e6.a.e(cursorC, "adMaterialList");
                    int iE22 = e6.a.e(cursorC, "adPlanUpdateTime");
                    int iE23 = e6.a.e(cursorC, "sort");
                    int iE24 = e6.a.e(cursorC, "adShowLevel");
                    int iE25 = e6.a.e(cursorC, "filterClientVersion");
                    int iE26 = e6.a.e(cursorC, "adPlanCreateTime");
                    int iE27 = e6.a.e(cursorC, "appStarDesc");
                    int iE28 = e6.a.e(cursorC, "appSizeDesc");
                    int iE29 = e6.a.e(cursorC, "ctxEnableExpr");
                    int iE30 = e6.a.e(cursorC, "ctxDisableExpr");
                    int iE31 = e6.a.e(cursorC, "ctxAttributeConfig");
                    int iE32 = e6.a.e(cursorC, "dispatchTimeStart");
                    int iE33 = e6.a.e(cursorC, "dispatchTimeEnd");
                    int iE34 = e6.a.e(cursorC, "extImage");
                    int iE35 = e6.a.e(cursorC, "bidEcpmCent");
                    int iE36 = e6.a.e(cursorC, "ecpmCent");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string5 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string6 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        Integer numValueOf = cursorC.isNull(iE7) ? null : Integer.valueOf(cursorC.getInt(iE7));
                        Integer numValueOf2 = cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8));
                        String string7 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        String string8 = cursorC.isNull(iE10) ? null : cursorC.getString(iE10);
                        String string9 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        String string10 = cursorC.isNull(iE12) ? null : cursorC.getString(iE12);
                        String string11 = cursorC.isNull(iE13) ? null : cursorC.getString(iE13);
                        String string12 = cursorC.isNull(i11) ? null : cursorC.getString(i11);
                        int i12 = iE15;
                        int i13 = iE;
                        String string13 = cursorC.isNull(i12) ? null : cursorC.getString(i12);
                        int i14 = iE16;
                        String string14 = cursorC.isNull(i14) ? null : cursorC.getString(i14);
                        int i15 = iE17;
                        String string15 = cursorC.isNull(i15) ? null : cursorC.getString(i15);
                        int i16 = iE18;
                        String string16 = cursorC.isNull(i16) ? null : cursorC.getString(i16);
                        int i17 = iE19;
                        String string17 = cursorC.isNull(i17) ? null : cursorC.getString(i17);
                        int i18 = iE20;
                        String string18 = cursorC.isNull(i18) ? null : cursorC.getString(i18);
                        int i19 = iE21;
                        String string19 = cursorC.isNull(i19) ? null : cursorC.getString(i19);
                        int i21 = iE22;
                        String string20 = cursorC.isNull(i21) ? null : cursorC.getString(i21);
                        int i22 = iE23;
                        Integer numValueOf3 = cursorC.isNull(i22) ? null : Integer.valueOf(cursorC.getInt(i22));
                        int i23 = iE24;
                        String string21 = cursorC.isNull(i23) ? null : cursorC.getString(i23);
                        int i24 = iE25;
                        String string22 = cursorC.isNull(i24) ? null : cursorC.getString(i24);
                        int i25 = iE26;
                        String string23 = cursorC.isNull(i25) ? null : cursorC.getString(i25);
                        int i26 = iE27;
                        String string24 = cursorC.isNull(i26) ? null : cursorC.getString(i26);
                        int i27 = iE28;
                        String string25 = cursorC.isNull(i27) ? null : cursorC.getString(i27);
                        int i28 = iE29;
                        String string26 = cursorC.isNull(i28) ? null : cursorC.getString(i28);
                        int i29 = iE30;
                        String string27 = cursorC.isNull(i29) ? null : cursorC.getString(i29);
                        int i31 = iE31;
                        String string28 = cursorC.isNull(i31) ? null : cursorC.getString(i31);
                        int i32 = iE32;
                        String string29 = cursorC.isNull(i32) ? null : cursorC.getString(i32);
                        int i33 = iE33;
                        String string30 = cursorC.isNull(i33) ? null : cursorC.getString(i33);
                        int i34 = iE34;
                        String string31 = cursorC.isNull(i34) ? null : cursorC.getString(i34);
                        int i35 = iE35;
                        Double dValueOf = cursorC.isNull(i35) ? null : Double.valueOf(cursorC.getDouble(i35));
                        int i36 = iE36;
                        arrayList.add(new MbAdDbPlans(string, string2, string3, string4, string5, string6, numValueOf, numValueOf2, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, numValueOf3, string21, string22, string23, string24, string25, string26, string27, string28, string29, string30, string31, dValueOf, cursorC.isNull(i36) ? null : Long.valueOf(cursorC.getLong(i36))));
                        iE = i13;
                        iE15 = i12;
                        iE16 = i14;
                        iE17 = i15;
                        iE18 = i16;
                        iE19 = i17;
                        iE20 = i18;
                        iE21 = i19;
                        iE22 = i21;
                        iE23 = i22;
                        iE24 = i23;
                        iE25 = i24;
                        iE26 = i25;
                        iE27 = i26;
                        iE28 = i27;
                        iE29 = i28;
                        iE30 = i29;
                        iE31 = i31;
                        iE32 = i32;
                        iE33 = i33;
                        iE34 = i34;
                        iE35 = i35;
                        iE36 = i36;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f75681a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cVar = this;
                    cursorC.close();
                    cVar.f75681a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<MbAdDbPlans> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f75683a;

        public d(v vVar) {
            this.f75683a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MbAdDbPlans call() throws Exception {
            MbAdDbPlans mbAdDbPlans;
            d dVar = this;
            Cursor cursorC = e6.b.c(b.this.f75672a, dVar.f75683a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, "version");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "startTime");
                int iE5 = e6.a.e(cursorC, "endTime");
                int iE6 = e6.a.e(cursorC, "extraConfig");
                int iE7 = e6.a.e(cursorC, "displayTimes");
                int iE8 = e6.a.e(cursorC, "showedTimes");
                int iE9 = e6.a.e(cursorC, "showDate");
                int iE10 = e6.a.e(cursorC, "advertiserName");
                int iE11 = e6.a.e(cursorC, "advertiserAvatar");
                int iE12 = e6.a.e(cursorC, "advertiserAvatarPath");
                int iE13 = e6.a.e(cursorC, "brand");
                int iE14 = e6.a.e(cursorC, "denyBrand");
                try {
                    int iE15 = e6.a.e(cursorC, "model");
                    int iE16 = e6.a.e(cursorC, "denyModel");
                    int iE17 = e6.a.e(cursorC, PlaceTypes.COUNTRY);
                    int iE18 = e6.a.e(cursorC, "scenes");
                    int iE19 = e6.a.e(cursorC, "adSource");
                    int iE20 = e6.a.e(cursorC, "extAdSlot");
                    int iE21 = e6.a.e(cursorC, "adMaterialList");
                    int iE22 = e6.a.e(cursorC, "adPlanUpdateTime");
                    int iE23 = e6.a.e(cursorC, "sort");
                    int iE24 = e6.a.e(cursorC, "adShowLevel");
                    int iE25 = e6.a.e(cursorC, "filterClientVersion");
                    int iE26 = e6.a.e(cursorC, "adPlanCreateTime");
                    int iE27 = e6.a.e(cursorC, "appStarDesc");
                    int iE28 = e6.a.e(cursorC, "appSizeDesc");
                    int iE29 = e6.a.e(cursorC, "ctxEnableExpr");
                    int iE30 = e6.a.e(cursorC, "ctxDisableExpr");
                    int iE31 = e6.a.e(cursorC, "ctxAttributeConfig");
                    int iE32 = e6.a.e(cursorC, "dispatchTimeStart");
                    int iE33 = e6.a.e(cursorC, "dispatchTimeEnd");
                    int iE34 = e6.a.e(cursorC, "extImage");
                    int iE35 = e6.a.e(cursorC, "bidEcpmCent");
                    int iE36 = e6.a.e(cursorC, "ecpmCent");
                    if (cursorC.moveToFirst()) {
                        mbAdDbPlans = new MbAdDbPlans(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : Integer.valueOf(cursorC.getInt(iE7)), cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8)), cursorC.isNull(iE9) ? null : cursorC.getString(iE9), cursorC.isNull(iE10) ? null : cursorC.getString(iE10), cursorC.isNull(iE11) ? null : cursorC.getString(iE11), cursorC.isNull(iE12) ? null : cursorC.getString(iE12), cursorC.isNull(iE13) ? null : cursorC.getString(iE13), cursorC.isNull(iE14) ? null : cursorC.getString(iE14), cursorC.isNull(r16) ? null : cursorC.getString(iE15), cursorC.isNull(r17) ? null : cursorC.getString(iE16), cursorC.isNull(r18) ? null : cursorC.getString(iE17), cursorC.isNull(r19) ? null : cursorC.getString(iE18), cursorC.isNull(r20) ? null : cursorC.getString(iE19), cursorC.isNull(r21) ? null : cursorC.getString(iE20), cursorC.isNull(r22) ? null : cursorC.getString(iE21), cursorC.isNull(r23) ? null : cursorC.getString(iE22), cursorC.isNull(r24) ? null : Integer.valueOf(cursorC.getInt(iE23)), cursorC.isNull(r25) ? null : cursorC.getString(iE24), cursorC.isNull(r26) ? null : cursorC.getString(iE25), cursorC.isNull(r27) ? null : cursorC.getString(iE26), cursorC.isNull(r28) ? null : cursorC.getString(iE27), cursorC.isNull(r29) ? null : cursorC.getString(iE28), cursorC.isNull(r30) ? null : cursorC.getString(iE29), cursorC.isNull(r31) ? null : cursorC.getString(iE30), cursorC.isNull(r32) ? null : cursorC.getString(iE31), cursorC.isNull(r33) ? null : cursorC.getString(iE32), cursorC.isNull(r34) ? null : cursorC.getString(iE33), cursorC.isNull(r35) ? null : cursorC.getString(iE34), cursorC.isNull(r36) ? null : Double.valueOf(cursorC.getDouble(iE35)), cursorC.isNull(iE36) ? null : Long.valueOf(cursorC.getLong(iE36)));
                    } else {
                        mbAdDbPlans = null;
                    }
                    cursorC.close();
                    this.f75683a.release();
                    return mbAdDbPlans;
                } catch (Throwable th2) {
                    th = th2;
                    dVar = this;
                    cursorC.close();
                    dVar.f75683a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Callable<List<MbAdDbPlans>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f75685a;

        public e(v vVar) {
            this.f75685a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<MbAdDbPlans> call() throws Exception {
            e eVar;
            Cursor cursorC = e6.b.c(b.this.f75672a, this.f75685a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, "version");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "startTime");
                int iE5 = e6.a.e(cursorC, "endTime");
                int iE6 = e6.a.e(cursorC, "extraConfig");
                int iE7 = e6.a.e(cursorC, "displayTimes");
                int iE8 = e6.a.e(cursorC, "showedTimes");
                int iE9 = e6.a.e(cursorC, "showDate");
                int iE10 = e6.a.e(cursorC, "advertiserName");
                int iE11 = e6.a.e(cursorC, "advertiserAvatar");
                int iE12 = e6.a.e(cursorC, "advertiserAvatarPath");
                int iE13 = e6.a.e(cursorC, "brand");
                int iE14 = e6.a.e(cursorC, "denyBrand");
                try {
                    int iE15 = e6.a.e(cursorC, "model");
                    int iE16 = e6.a.e(cursorC, "denyModel");
                    int iE17 = e6.a.e(cursorC, PlaceTypes.COUNTRY);
                    int iE18 = e6.a.e(cursorC, "scenes");
                    int iE19 = e6.a.e(cursorC, "adSource");
                    int iE20 = e6.a.e(cursorC, "extAdSlot");
                    int iE21 = e6.a.e(cursorC, "adMaterialList");
                    int iE22 = e6.a.e(cursorC, "adPlanUpdateTime");
                    int iE23 = e6.a.e(cursorC, "sort");
                    int iE24 = e6.a.e(cursorC, "adShowLevel");
                    int iE25 = e6.a.e(cursorC, "filterClientVersion");
                    int iE26 = e6.a.e(cursorC, "adPlanCreateTime");
                    int iE27 = e6.a.e(cursorC, "appStarDesc");
                    int iE28 = e6.a.e(cursorC, "appSizeDesc");
                    int iE29 = e6.a.e(cursorC, "ctxEnableExpr");
                    int iE30 = e6.a.e(cursorC, "ctxDisableExpr");
                    int iE31 = e6.a.e(cursorC, "ctxAttributeConfig");
                    int iE32 = e6.a.e(cursorC, "dispatchTimeStart");
                    int iE33 = e6.a.e(cursorC, "dispatchTimeEnd");
                    int iE34 = e6.a.e(cursorC, "extImage");
                    int iE35 = e6.a.e(cursorC, "bidEcpmCent");
                    int iE36 = e6.a.e(cursorC, "ecpmCent");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string5 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string6 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        Integer numValueOf = cursorC.isNull(iE7) ? null : Integer.valueOf(cursorC.getInt(iE7));
                        Integer numValueOf2 = cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8));
                        String string7 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        String string8 = cursorC.isNull(iE10) ? null : cursorC.getString(iE10);
                        String string9 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        String string10 = cursorC.isNull(iE12) ? null : cursorC.getString(iE12);
                        String string11 = cursorC.isNull(iE13) ? null : cursorC.getString(iE13);
                        String string12 = cursorC.isNull(i11) ? null : cursorC.getString(i11);
                        int i12 = iE15;
                        int i13 = iE;
                        String string13 = cursorC.isNull(i12) ? null : cursorC.getString(i12);
                        int i14 = iE16;
                        String string14 = cursorC.isNull(i14) ? null : cursorC.getString(i14);
                        int i15 = iE17;
                        String string15 = cursorC.isNull(i15) ? null : cursorC.getString(i15);
                        int i16 = iE18;
                        String string16 = cursorC.isNull(i16) ? null : cursorC.getString(i16);
                        int i17 = iE19;
                        String string17 = cursorC.isNull(i17) ? null : cursorC.getString(i17);
                        int i18 = iE20;
                        String string18 = cursorC.isNull(i18) ? null : cursorC.getString(i18);
                        int i19 = iE21;
                        String string19 = cursorC.isNull(i19) ? null : cursorC.getString(i19);
                        int i21 = iE22;
                        String string20 = cursorC.isNull(i21) ? null : cursorC.getString(i21);
                        int i22 = iE23;
                        Integer numValueOf3 = cursorC.isNull(i22) ? null : Integer.valueOf(cursorC.getInt(i22));
                        int i23 = iE24;
                        String string21 = cursorC.isNull(i23) ? null : cursorC.getString(i23);
                        int i24 = iE25;
                        String string22 = cursorC.isNull(i24) ? null : cursorC.getString(i24);
                        int i25 = iE26;
                        String string23 = cursorC.isNull(i25) ? null : cursorC.getString(i25);
                        int i26 = iE27;
                        String string24 = cursorC.isNull(i26) ? null : cursorC.getString(i26);
                        int i27 = iE28;
                        String string25 = cursorC.isNull(i27) ? null : cursorC.getString(i27);
                        int i28 = iE29;
                        String string26 = cursorC.isNull(i28) ? null : cursorC.getString(i28);
                        int i29 = iE30;
                        String string27 = cursorC.isNull(i29) ? null : cursorC.getString(i29);
                        int i31 = iE31;
                        String string28 = cursorC.isNull(i31) ? null : cursorC.getString(i31);
                        int i32 = iE32;
                        String string29 = cursorC.isNull(i32) ? null : cursorC.getString(i32);
                        int i33 = iE33;
                        String string30 = cursorC.isNull(i33) ? null : cursorC.getString(i33);
                        int i34 = iE34;
                        String string31 = cursorC.isNull(i34) ? null : cursorC.getString(i34);
                        int i35 = iE35;
                        Double dValueOf = cursorC.isNull(i35) ? null : Double.valueOf(cursorC.getDouble(i35));
                        int i36 = iE36;
                        arrayList.add(new MbAdDbPlans(string, string2, string3, string4, string5, string6, numValueOf, numValueOf2, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, numValueOf3, string21, string22, string23, string24, string25, string26, string27, string28, string29, string30, string31, dValueOf, cursorC.isNull(i36) ? null : Long.valueOf(cursorC.getLong(i36))));
                        iE = i13;
                        iE15 = i12;
                        iE16 = i14;
                        iE17 = i15;
                        iE18 = i16;
                        iE19 = i17;
                        iE20 = i18;
                        iE21 = i19;
                        iE22 = i21;
                        iE23 = i22;
                        iE24 = i23;
                        iE25 = i24;
                        iE26 = i25;
                        iE27 = i26;
                        iE28 = i27;
                        iE29 = i28;
                        iE30 = i29;
                        iE31 = i31;
                        iE32 = i32;
                        iE33 = i33;
                        iE34 = i34;
                        iE35 = i35;
                        iE36 = i36;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f75685a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    eVar = this;
                    cursorC.close();
                    eVar.f75685a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                eVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends androidx.room.i<MbAdDbPlans> {
        public f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `mb_ad_db_plans` (`id`,`version`,`name`,`startTime`,`endTime`,`extraConfig`,`displayTimes`,`showedTimes`,`showDate`,`advertiserName`,`advertiserAvatar`,`advertiserAvatarPath`,`brand`,`denyBrand`,`model`,`denyModel`,`country`,`scenes`,`adSource`,`extAdSlot`,`adMaterialList`,`adPlanUpdateTime`,`sort`,`adShowLevel`,`filterClientVersion`,`adPlanCreateTime`,`appStarDesc`,`appSizeDesc`,`ctxEnableExpr`,`ctxDisableExpr`,`ctxAttributeConfig`,`dispatchTimeStart`,`dispatchTimeEnd`,`extImage`,`bidEcpmCent`,`ecpmCent`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, MbAdDbPlans mbAdDbPlans) {
            if (mbAdDbPlans.getId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, mbAdDbPlans.getId());
            }
            if (mbAdDbPlans.getVersion() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, mbAdDbPlans.getVersion());
            }
            if (mbAdDbPlans.getName() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, mbAdDbPlans.getName());
            }
            if (mbAdDbPlans.getStartTime() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, mbAdDbPlans.getStartTime());
            }
            if (mbAdDbPlans.getEndTime() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, mbAdDbPlans.getEndTime());
            }
            if (mbAdDbPlans.getExtraConfig() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, mbAdDbPlans.getExtraConfig());
            }
            if (mbAdDbPlans.getDisplayTimes() == null) {
                kVar.m0(7);
            } else {
                kVar.V(7, mbAdDbPlans.getDisplayTimes().intValue());
            }
            if (mbAdDbPlans.getShowedTimes() == null) {
                kVar.m0(8);
            } else {
                kVar.V(8, mbAdDbPlans.getShowedTimes().intValue());
            }
            if (mbAdDbPlans.getShowDate() == null) {
                kVar.m0(9);
            } else {
                kVar.s(9, mbAdDbPlans.getShowDate());
            }
            if (mbAdDbPlans.getAdvertiserName() == null) {
                kVar.m0(10);
            } else {
                kVar.s(10, mbAdDbPlans.getAdvertiserName());
            }
            if (mbAdDbPlans.getAdvertiserAvatar() == null) {
                kVar.m0(11);
            } else {
                kVar.s(11, mbAdDbPlans.getAdvertiserAvatar());
            }
            if (mbAdDbPlans.getAdvertiserAvatarPath() == null) {
                kVar.m0(12);
            } else {
                kVar.s(12, mbAdDbPlans.getAdvertiserAvatarPath());
            }
            if (mbAdDbPlans.getBrand() == null) {
                kVar.m0(13);
            } else {
                kVar.s(13, mbAdDbPlans.getBrand());
            }
            if (mbAdDbPlans.getDenyBrand() == null) {
                kVar.m0(14);
            } else {
                kVar.s(14, mbAdDbPlans.getDenyBrand());
            }
            if (mbAdDbPlans.getModel() == null) {
                kVar.m0(15);
            } else {
                kVar.s(15, mbAdDbPlans.getModel());
            }
            if (mbAdDbPlans.getDenyModel() == null) {
                kVar.m0(16);
            } else {
                kVar.s(16, mbAdDbPlans.getDenyModel());
            }
            if (mbAdDbPlans.getCountry() == null) {
                kVar.m0(17);
            } else {
                kVar.s(17, mbAdDbPlans.getCountry());
            }
            if (mbAdDbPlans.getScenes() == null) {
                kVar.m0(18);
            } else {
                kVar.s(18, mbAdDbPlans.getScenes());
            }
            if (mbAdDbPlans.getAdSource() == null) {
                kVar.m0(19);
            } else {
                kVar.s(19, mbAdDbPlans.getAdSource());
            }
            if (mbAdDbPlans.getExtAdSlot() == null) {
                kVar.m0(20);
            } else {
                kVar.s(20, mbAdDbPlans.getExtAdSlot());
            }
            if (mbAdDbPlans.getAdMaterialList() == null) {
                kVar.m0(21);
            } else {
                kVar.s(21, mbAdDbPlans.getAdMaterialList());
            }
            if (mbAdDbPlans.getAdPlanUpdateTime() == null) {
                kVar.m0(22);
            } else {
                kVar.s(22, mbAdDbPlans.getAdPlanUpdateTime());
            }
            if (mbAdDbPlans.getSort() == null) {
                kVar.m0(23);
            } else {
                kVar.V(23, mbAdDbPlans.getSort().intValue());
            }
            if (mbAdDbPlans.getAdShowLevel() == null) {
                kVar.m0(24);
            } else {
                kVar.s(24, mbAdDbPlans.getAdShowLevel());
            }
            if (mbAdDbPlans.getFilterClientVersion() == null) {
                kVar.m0(25);
            } else {
                kVar.s(25, mbAdDbPlans.getFilterClientVersion());
            }
            if (mbAdDbPlans.getAdPlanCreateTime() == null) {
                kVar.m0(26);
            } else {
                kVar.s(26, mbAdDbPlans.getAdPlanCreateTime());
            }
            if (mbAdDbPlans.getAppStarDesc() == null) {
                kVar.m0(27);
            } else {
                kVar.s(27, mbAdDbPlans.getAppStarDesc());
            }
            if (mbAdDbPlans.getAppSizeDesc() == null) {
                kVar.m0(28);
            } else {
                kVar.s(28, mbAdDbPlans.getAppSizeDesc());
            }
            if (mbAdDbPlans.getCtxEnableExpr() == null) {
                kVar.m0(29);
            } else {
                kVar.s(29, mbAdDbPlans.getCtxEnableExpr());
            }
            if (mbAdDbPlans.getCtxDisableExpr() == null) {
                kVar.m0(30);
            } else {
                kVar.s(30, mbAdDbPlans.getCtxDisableExpr());
            }
            if (mbAdDbPlans.getCtxAttributeConfig() == null) {
                kVar.m0(31);
            } else {
                kVar.s(31, mbAdDbPlans.getCtxAttributeConfig());
            }
            if (mbAdDbPlans.getDispatchTimeStart() == null) {
                kVar.m0(32);
            } else {
                kVar.s(32, mbAdDbPlans.getDispatchTimeStart());
            }
            if (mbAdDbPlans.getDispatchTimeEnd() == null) {
                kVar.m0(33);
            } else {
                kVar.s(33, mbAdDbPlans.getDispatchTimeEnd());
            }
            if (mbAdDbPlans.getExtImage() == null) {
                kVar.m0(34);
            } else {
                kVar.s(34, mbAdDbPlans.getExtImage());
            }
            if (mbAdDbPlans.getBidEcpmCent() == null) {
                kVar.m0(35);
            } else {
                kVar.f(35, mbAdDbPlans.getBidEcpmCent().doubleValue());
            }
            if (mbAdDbPlans.getEcpmCent() == null) {
                kVar.m0(36);
            } else {
                kVar.V(36, mbAdDbPlans.getEcpmCent().longValue());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends androidx.room.h<MbAdDbPlans> {
        public g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `mb_ad_db_plans` SET `id` = ?,`version` = ?,`name` = ?,`startTime` = ?,`endTime` = ?,`extraConfig` = ?,`displayTimes` = ?,`showedTimes` = ?,`showDate` = ?,`advertiserName` = ?,`advertiserAvatar` = ?,`advertiserAvatarPath` = ?,`brand` = ?,`denyBrand` = ?,`model` = ?,`denyModel` = ?,`country` = ?,`scenes` = ?,`adSource` = ?,`extAdSlot` = ?,`adMaterialList` = ?,`adPlanUpdateTime` = ?,`sort` = ?,`adShowLevel` = ?,`filterClientVersion` = ?,`adPlanCreateTime` = ?,`appStarDesc` = ?,`appSizeDesc` = ?,`ctxEnableExpr` = ?,`ctxDisableExpr` = ?,`ctxAttributeConfig` = ?,`dispatchTimeStart` = ?,`dispatchTimeEnd` = ?,`extImage` = ?,`bidEcpmCent` = ?,`ecpmCent` = ? WHERE `id` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, MbAdDbPlans mbAdDbPlans) {
            if (mbAdDbPlans.getId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, mbAdDbPlans.getId());
            }
            if (mbAdDbPlans.getVersion() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, mbAdDbPlans.getVersion());
            }
            if (mbAdDbPlans.getName() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, mbAdDbPlans.getName());
            }
            if (mbAdDbPlans.getStartTime() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, mbAdDbPlans.getStartTime());
            }
            if (mbAdDbPlans.getEndTime() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, mbAdDbPlans.getEndTime());
            }
            if (mbAdDbPlans.getExtraConfig() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, mbAdDbPlans.getExtraConfig());
            }
            if (mbAdDbPlans.getDisplayTimes() == null) {
                kVar.m0(7);
            } else {
                kVar.V(7, mbAdDbPlans.getDisplayTimes().intValue());
            }
            if (mbAdDbPlans.getShowedTimes() == null) {
                kVar.m0(8);
            } else {
                kVar.V(8, mbAdDbPlans.getShowedTimes().intValue());
            }
            if (mbAdDbPlans.getShowDate() == null) {
                kVar.m0(9);
            } else {
                kVar.s(9, mbAdDbPlans.getShowDate());
            }
            if (mbAdDbPlans.getAdvertiserName() == null) {
                kVar.m0(10);
            } else {
                kVar.s(10, mbAdDbPlans.getAdvertiserName());
            }
            if (mbAdDbPlans.getAdvertiserAvatar() == null) {
                kVar.m0(11);
            } else {
                kVar.s(11, mbAdDbPlans.getAdvertiserAvatar());
            }
            if (mbAdDbPlans.getAdvertiserAvatarPath() == null) {
                kVar.m0(12);
            } else {
                kVar.s(12, mbAdDbPlans.getAdvertiserAvatarPath());
            }
            if (mbAdDbPlans.getBrand() == null) {
                kVar.m0(13);
            } else {
                kVar.s(13, mbAdDbPlans.getBrand());
            }
            if (mbAdDbPlans.getDenyBrand() == null) {
                kVar.m0(14);
            } else {
                kVar.s(14, mbAdDbPlans.getDenyBrand());
            }
            if (mbAdDbPlans.getModel() == null) {
                kVar.m0(15);
            } else {
                kVar.s(15, mbAdDbPlans.getModel());
            }
            if (mbAdDbPlans.getDenyModel() == null) {
                kVar.m0(16);
            } else {
                kVar.s(16, mbAdDbPlans.getDenyModel());
            }
            if (mbAdDbPlans.getCountry() == null) {
                kVar.m0(17);
            } else {
                kVar.s(17, mbAdDbPlans.getCountry());
            }
            if (mbAdDbPlans.getScenes() == null) {
                kVar.m0(18);
            } else {
                kVar.s(18, mbAdDbPlans.getScenes());
            }
            if (mbAdDbPlans.getAdSource() == null) {
                kVar.m0(19);
            } else {
                kVar.s(19, mbAdDbPlans.getAdSource());
            }
            if (mbAdDbPlans.getExtAdSlot() == null) {
                kVar.m0(20);
            } else {
                kVar.s(20, mbAdDbPlans.getExtAdSlot());
            }
            if (mbAdDbPlans.getAdMaterialList() == null) {
                kVar.m0(21);
            } else {
                kVar.s(21, mbAdDbPlans.getAdMaterialList());
            }
            if (mbAdDbPlans.getAdPlanUpdateTime() == null) {
                kVar.m0(22);
            } else {
                kVar.s(22, mbAdDbPlans.getAdPlanUpdateTime());
            }
            if (mbAdDbPlans.getSort() == null) {
                kVar.m0(23);
            } else {
                kVar.V(23, mbAdDbPlans.getSort().intValue());
            }
            if (mbAdDbPlans.getAdShowLevel() == null) {
                kVar.m0(24);
            } else {
                kVar.s(24, mbAdDbPlans.getAdShowLevel());
            }
            if (mbAdDbPlans.getFilterClientVersion() == null) {
                kVar.m0(25);
            } else {
                kVar.s(25, mbAdDbPlans.getFilterClientVersion());
            }
            if (mbAdDbPlans.getAdPlanCreateTime() == null) {
                kVar.m0(26);
            } else {
                kVar.s(26, mbAdDbPlans.getAdPlanCreateTime());
            }
            if (mbAdDbPlans.getAppStarDesc() == null) {
                kVar.m0(27);
            } else {
                kVar.s(27, mbAdDbPlans.getAppStarDesc());
            }
            if (mbAdDbPlans.getAppSizeDesc() == null) {
                kVar.m0(28);
            } else {
                kVar.s(28, mbAdDbPlans.getAppSizeDesc());
            }
            if (mbAdDbPlans.getCtxEnableExpr() == null) {
                kVar.m0(29);
            } else {
                kVar.s(29, mbAdDbPlans.getCtxEnableExpr());
            }
            if (mbAdDbPlans.getCtxDisableExpr() == null) {
                kVar.m0(30);
            } else {
                kVar.s(30, mbAdDbPlans.getCtxDisableExpr());
            }
            if (mbAdDbPlans.getCtxAttributeConfig() == null) {
                kVar.m0(31);
            } else {
                kVar.s(31, mbAdDbPlans.getCtxAttributeConfig());
            }
            if (mbAdDbPlans.getDispatchTimeStart() == null) {
                kVar.m0(32);
            } else {
                kVar.s(32, mbAdDbPlans.getDispatchTimeStart());
            }
            if (mbAdDbPlans.getDispatchTimeEnd() == null) {
                kVar.m0(33);
            } else {
                kVar.s(33, mbAdDbPlans.getDispatchTimeEnd());
            }
            if (mbAdDbPlans.getExtImage() == null) {
                kVar.m0(34);
            } else {
                kVar.s(34, mbAdDbPlans.getExtImage());
            }
            if (mbAdDbPlans.getBidEcpmCent() == null) {
                kVar.m0(35);
            } else {
                kVar.f(35, mbAdDbPlans.getBidEcpmCent().doubleValue());
            }
            if (mbAdDbPlans.getEcpmCent() == null) {
                kVar.m0(36);
            } else {
                kVar.V(36, mbAdDbPlans.getEcpmCent().longValue());
            }
            if (mbAdDbPlans.getId() == null) {
                kVar.m0(37);
            } else {
                kVar.s(37, mbAdDbPlans.getId());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends SharedSQLiteStatement {
        public h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM mb_ad_db_plans";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends SharedSQLiteStatement {
        public i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM mb_ad_db_plans WHERE version !=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MbAdDbPlans f75691a;

        public j(MbAdDbPlans mbAdDbPlans) {
            this.f75691a = mbAdDbPlans;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f75672a.e();
            try {
                b.this.f75673b.k(this.f75691a);
                b.this.f75672a.E();
                return Unit.f68710a;
            } finally {
                b.this.f75672a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f75693a;

        public k(List list) {
            this.f75693a = list;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f75672a.e();
            try {
                b.this.f75673b.j(this.f75693a);
                b.this.f75672a.E();
                return Unit.f68710a;
            } finally {
                b.this.f75672a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MbAdDbPlans f75695a;

        public l(MbAdDbPlans mbAdDbPlans) {
            this.f75695a = mbAdDbPlans;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f75672a.e();
            try {
                b.this.f75674c.j(this.f75695a);
                b.this.f75672a.E();
                return Unit.f68710a;
            } finally {
                b.this.f75672a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class m implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f75697a;

        public m(String str) {
            this.f75697a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = b.this.f75676e.b();
            String str = this.f75697a;
            if (str == null) {
                kVarB.m0(1);
            } else {
                kVarB.s(1, str);
            }
            b.this.f75672a.e();
            try {
                kVarB.F();
                b.this.f75672a.E();
                return Unit.f68710a;
            } finally {
                b.this.f75672a.i();
                b.this.f75676e.h(kVarB);
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f75672a = roomDatabase;
        this.f75673b = new f(roomDatabase);
        this.f75674c = new g(roomDatabase);
        this.f75675d = new h(roomDatabase);
        this.f75676e = new i(roomDatabase);
    }

    public static List<Class<?>> n() {
        return Collections.emptyList();
    }

    @Override // rq.a
    public Object a(Continuation<? super List<MbAdDbPlans>> continuation) {
        v vVarC = v.c("SELECT * FROM mb_ad_db_plans ORDER BY sort", 0);
        return CoroutinesRoom.a(this.f75672a, false, e6.b.a(), new a(vVarC), continuation);
    }

    @Override // rq.a
    public Object b(List<MbAdDbPlans> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f75672a, true, new k(list), continuation);
    }

    @Override // rq.a
    public Object c(MbAdDbPlans mbAdDbPlans, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f75672a, true, new j(mbAdDbPlans), continuation);
    }

    @Override // rq.a
    public Object d(Continuation<? super List<MbAdDbPlans>> continuation) {
        v vVarC = v.c("SELECT * FROM mb_ad_db_plans where adShowLevel='AdShowFinal' ORDER BY sort", 0);
        return CoroutinesRoom.a(this.f75672a, false, e6.b.a(), new c(vVarC), continuation);
    }

    @Override // rq.a
    public Object e(Continuation<? super List<MbAdDbPlans>> continuation) {
        v vVarC = v.c("SELECT * FROM mb_ad_db_plans where adShowLevel='AdShowFirst' ORDER BY sort", 0);
        return CoroutinesRoom.a(this.f75672a, false, e6.b.a(), new CallableC0831b(vVarC), continuation);
    }

    @Override // rq.a
    public Object f(String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f75672a, true, new m(str), continuation);
    }

    @Override // rq.a
    public Object g(String str, Continuation<? super MbAdDbPlans> continuation) {
        v vVarC = v.c("SELECT * FROM mb_ad_db_plans where id=?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f75672a, false, e6.b.a(), new d(vVarC), continuation);
    }

    @Override // rq.a
    public Object h(MbAdDbPlans mbAdDbPlans, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f75672a, true, new l(mbAdDbPlans), continuation);
    }

    @Override // rq.a
    public Object i(String str, Continuation<? super List<MbAdDbPlans>> continuation) {
        v vVarC = v.c("SELECT * FROM mb_ad_db_plans where adSource=?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f75672a, false, e6.b.a(), new e(vVarC), continuation);
    }
}
