package e6;

import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import g6.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class f {
    public static final Map<String, e.a> a(g gVar, String str) {
        Cursor cursorF0 = gVar.f0("PRAGMA table_info(`" + str + "`)");
        try {
            if (cursorF0.getColumnCount() <= 0) {
                Map<String, e.a> mapH = s.h();
                CloseableKt.a(cursorF0, null);
                return mapH;
            }
            int columnIndex = cursorF0.getColumnIndex("name");
            int columnIndex2 = cursorF0.getColumnIndex("type");
            int columnIndex3 = cursorF0.getColumnIndex("notnull");
            int columnIndex4 = cursorF0.getColumnIndex("pk");
            int columnIndex5 = cursorF0.getColumnIndex("dflt_value");
            Map mapC = r.c();
            while (cursorF0.moveToNext()) {
                String name = cursorF0.getString(columnIndex);
                String type = cursorF0.getString(columnIndex2);
                boolean z11 = cursorF0.getInt(columnIndex3) != 0;
                int i11 = cursorF0.getInt(columnIndex4);
                String string = cursorF0.getString(columnIndex5);
                Intrinsics.f(name, "name");
                Intrinsics.f(type, "type");
                mapC.put(name, new e.a(name, type, z11, i11, string, 2));
            }
            Map<String, e.a> mapB = r.b(mapC);
            CloseableKt.a(cursorF0, null);
            return mapB;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(cursorF0, th2);
                throw th3;
            }
        }
    }

    public static final List<e.d> b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        List listC = kotlin.collections.f.c();
        while (cursor.moveToNext()) {
            int i11 = cursor.getInt(columnIndex);
            int i12 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            Intrinsics.f(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            Intrinsics.f(string2, "cursor.getString(toColumnIndex)");
            listC.add(new e.d(i11, i12, string, string2));
        }
        return CollectionsKt___CollectionsKt.D0(kotlin.collections.f.a(listC));
    }

    public static final Set<e.c> c(g gVar, String str) {
        Cursor cursorF0 = gVar.f0("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = cursorF0.getColumnIndex("id");
            int columnIndex2 = cursorF0.getColumnIndex("seq");
            int columnIndex3 = cursorF0.getColumnIndex("table");
            int columnIndex4 = cursorF0.getColumnIndex("on_delete");
            int columnIndex5 = cursorF0.getColumnIndex("on_update");
            List<e.d> listB = b(cursorF0);
            cursorF0.moveToPosition(-1);
            Set setB = v.b();
            while (cursorF0.moveToNext()) {
                if (cursorF0.getInt(columnIndex2) == 0) {
                    int i11 = cursorF0.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<e.d> arrayList3 = new ArrayList();
                    for (Object obj : listB) {
                        if (((e.d) obj).c() == i11) {
                            arrayList3.add(obj);
                        }
                    }
                    for (e.d dVar : arrayList3) {
                        arrayList.add(dVar.b());
                        arrayList2.add(dVar.d());
                    }
                    String string = cursorF0.getString(columnIndex3);
                    Intrinsics.f(string, "cursor.getString(tableColumnIndex)");
                    String string2 = cursorF0.getString(columnIndex4);
                    Intrinsics.f(string2, "cursor.getString(onDeleteColumnIndex)");
                    String string3 = cursorF0.getString(columnIndex5);
                    Intrinsics.f(string3, "cursor.getString(onUpdateColumnIndex)");
                    setB.add(new e.c(string, string2, string3, arrayList, arrayList2));
                }
            }
            Set<e.c> setA = v.a(setB);
            CloseableKt.a(cursorF0, null);
            return setA;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(cursorF0, th2);
                throw th3;
            }
        }
    }

    public static final e.C0658e d(g gVar, String str, boolean z11) {
        Cursor cursorF0 = gVar.f0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorF0.getColumnIndex("seqno");
            int columnIndex2 = cursorF0.getColumnIndex(BidResponsedEx.KEY_CID);
            int columnIndex3 = cursorF0.getColumnIndex("name");
            int columnIndex4 = cursorF0.getColumnIndex(CampaignEx.JSON_KEY_DESC);
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursorF0.moveToNext()) {
                    if (cursorF0.getInt(columnIndex2) >= 0) {
                        int i11 = cursorF0.getInt(columnIndex);
                        String columnName = cursorF0.getString(columnIndex3);
                        String str2 = cursorF0.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer numValueOf = Integer.valueOf(i11);
                        Intrinsics.f(columnName, "columnName");
                        treeMap.put(numValueOf, columnName);
                        treeMap2.put(Integer.valueOf(i11), str2);
                    }
                }
                Collection collectionValues = treeMap.values();
                Intrinsics.f(collectionValues, "columnsMap.values");
                List listJ0 = CollectionsKt___CollectionsKt.J0(collectionValues);
                Collection collectionValues2 = treeMap2.values();
                Intrinsics.f(collectionValues2, "ordersMap.values");
                e.C0658e c0658e = new e.C0658e(str, z11, listJ0, CollectionsKt___CollectionsKt.J0(collectionValues2));
                CloseableKt.a(cursorF0, null);
                return c0658e;
            }
            CloseableKt.a(cursorF0, null);
            return null;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(cursorF0, th2);
                throw th3;
            }
        }
    }

    public static final Set<e.C0658e> e(g gVar, String str) {
        Cursor cursorF0 = gVar.f0("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = cursorF0.getColumnIndex("name");
            int columnIndex2 = cursorF0.getColumnIndex("origin");
            int columnIndex3 = cursorF0.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                Set setB = v.b();
                while (cursorF0.moveToNext()) {
                    if (Intrinsics.b("c", cursorF0.getString(columnIndex2))) {
                        String name = cursorF0.getString(columnIndex);
                        boolean z11 = true;
                        if (cursorF0.getInt(columnIndex3) != 1) {
                            z11 = false;
                        }
                        Intrinsics.f(name, "name");
                        e.C0658e c0658eD = d(gVar, name, z11);
                        if (c0658eD == null) {
                            CloseableKt.a(cursorF0, null);
                            return null;
                        }
                        setB.add(c0658eD);
                    }
                }
                Set<e.C0658e> setA = v.a(setB);
                CloseableKt.a(cursorF0, null);
                return setA;
            }
            CloseableKt.a(cursorF0, null);
            return null;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(cursorF0, th2);
                throw th3;
            }
        }
    }

    public static final e f(g database, String tableName) {
        Intrinsics.g(database, "database");
        Intrinsics.g(tableName, "tableName");
        return new e(tableName, a(database, tableName), c(database, tableName), e(database, tableName));
    }
}
