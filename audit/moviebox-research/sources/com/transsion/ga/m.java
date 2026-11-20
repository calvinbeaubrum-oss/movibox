package com.transsion.ga;

import android.text.TextUtils;
import android.util.Log;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.layout.a0;
import androidx.window.layout.r;
import athena.j0;
import com.hisavana.common.tracking.TrackingKey;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements androidx.core.util.a<a0> {
    @Override // androidx.core.util.a
    public void accept(a0 a0Var) {
        String str;
        Object obj;
        a0 a0Var2 = a0Var;
        athena.a0.a(" \n------------------------------------------------------------\nLayoutStateChangeCallback accept : " + a0Var2 + "\n------------------------------------------------------------\n");
        List<androidx.window.layout.l> listA = a0Var2.a();
        if (listA.size() > 0) {
            int i11 = 0;
            androidx.window.layout.l lVar = listA.get(0);
            if (lVar instanceof r) {
                r rVar = (r) lVar;
                if (TextUtils.isEmpty(j0.u())) {
                    try {
                        HardwareFoldingFeature.a aVar = HardwareFoldingFeature.Companion;
                        Field[] declaredFields = HardwareFoldingFeature.class.getDeclaredFields();
                        int length = declaredFields.length;
                        int i12 = 0;
                        while (true) {
                            if (i12 >= length) {
                                obj = null;
                                break;
                            }
                            Field field = declaredFields[i12];
                            if (field.getName().equals("type")) {
                                field.setAccessible(true);
                                obj = field.get(rVar);
                                break;
                            }
                            i12++;
                        }
                        if (obj == null) {
                            str = "";
                            break;
                        }
                        HardwareFoldingFeature.Type.a aVar2 = HardwareFoldingFeature.Type.Companion;
                        Field[] declaredFields2 = HardwareFoldingFeature.Type.class.getDeclaredFields();
                        int length2 = declaredFields2.length;
                        while (true) {
                            if (i11 >= length2) {
                                str = "";
                                break;
                            }
                            Field field2 = declaredFields2[i11];
                            if (field2.getName().equals(TrackingKey.DESCRIPTION)) {
                                field2.setAccessible(true);
                                str = (String) field2.get(obj);
                                break;
                            }
                            i11++;
                            str = "";
                            break;
                        }
                    } catch (ClassNotFoundException | IllegalAccessException e11) {
                        athena.a0.c(Log.getStackTraceString(e11));
                    }
                    j0.k(str != null ? str : "");
                }
                if (rVar != null && rVar.getState() == r.c.f13209d && rVar.getOrientation() == r.b.f13205d) {
                    j0.q("4");
                    return;
                }
                if (rVar != null && rVar.getState() == r.c.f13209d && rVar.getOrientation() == r.b.f13204c) {
                    j0.q("5");
                    return;
                }
                if (rVar != null && rVar.getState() == r.c.f13208c && rVar.getOrientation() == r.b.f13204c) {
                    j0.q("2");
                } else if (rVar != null && rVar.getState() == r.c.f13208c && rVar.getOrientation() == r.b.f13205d) {
                    j0.q("3");
                } else {
                    j0.q("1");
                }
            }
        }
    }
}
