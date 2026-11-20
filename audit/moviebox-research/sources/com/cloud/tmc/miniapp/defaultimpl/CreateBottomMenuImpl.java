package com.cloud.tmc.miniapp.defaultimpl;

import OooO0o0.OooOOO;
import android.app.Activity;
import com.cloud.tmc.integration.model.AbilityConfig;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.AbilitiesUtils;
import com.cloud.tmc.integration.utils.MiniRequestUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.dialog.BottomDialog$MenuItem;
import com.cloud.tmc.miniapp.point.CreateBottomMenuPoint;
import com.cloud.tmc.miniapp.ui.OooO0OO;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class CreateBottomMenuImpl implements CreateBottomMenuPoint {
    public static final a Companion = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e5 A[LOOP:2: B:49:0x00c6->B:57:0x00e5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:60:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:90:0x00e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00e8 A[EDGE_INSN: B:91:0x00e8->B:59:0x00e8 BREAK  A[LOOP:2: B:49:0x00c6->B:57:0x00e5], SYNTHETIC] */
    @Override // com.cloud.tmc.miniapp.point.CreateBottomMenuPoint
    public void buildBottomDialog(Activity activity, OooOOO builder) {
        ArrayList<AbilityConfig.Ability> abilities;
        String id2;
        Iterator<T> it;
        int i11;
        Object next;
        int i12;
        Intrinsics.g(activity, "activity");
        Intrinsics.g(builder, "builder");
        if (activity instanceof OooO0OO) {
            App app = ((OooO0OO) activity).f31719d.getApp();
            Object obj = null;
            String appId = app != null ? app.getAppId() : null;
            if (appId == null) {
                return;
            }
            Intrinsics.f(appId, "activity.mActivityHelper.app?.appId ?: return");
            for (Object obj2 : AbilitiesUtils.f30983a.a()) {
                if (Intrinsics.b(((AbilityConfig) obj2).getMiniappId(), appId)) {
                    obj = obj2;
                    break;
                }
            }
            AbilityConfig abilityConfig = (AbilityConfig) obj;
            if (abilityConfig != null && (abilities = abilityConfig.getAbilities()) != null) {
                for (AbilityConfig.Ability ability : abilities) {
                    if (!Intrinsics.b(ability.getEnable(), Boolean.TRUE) && (id2 = ability.getAbility()) != null) {
                        int iHashCode = id2.hashCode();
                        if (iHashCode != -517618225) {
                            if (iHashCode != -321864378) {
                                if (iHashCode != -191501435) {
                                    if (iHashCode == 954925063 && id2.equals("message")) {
                                        builder.getClass();
                                        Intrinsics.g(id2, "id");
                                        it = builder.f65y.v().iterator();
                                        i11 = 0;
                                        while (true) {
                                            if (it.hasNext()) {
                                                i11 = -1;
                                                break;
                                            }
                                            next = it.next();
                                            i12 = i11 + 1;
                                            if (i11 < 0) {
                                                g.u();
                                            }
                                            if (Intrinsics.b(((BottomDialog$MenuItem) next).getId(), id2)) {
                                                break;
                                            } else {
                                                i11 = i12;
                                            }
                                        }
                                        if (i11 != -1) {
                                            builder.B.put(Integer.valueOf(i11), builder.f65y.getItem(i11));
                                            builder.f65y.v().remove(i11);
                                        }
                                        builder.f65y.notifyDataSetChanged();
                                    }
                                } else if (id2.equals("feedback")) {
                                    builder.getClass();
                                    Intrinsics.g(id2, "id");
                                    it = builder.f65y.v().iterator();
                                    i11 = 0;
                                    while (true) {
                                        if (it.hasNext()) {
                                            i11 = -1;
                                            break;
                                        }
                                        next = it.next();
                                        i12 = i11 + 1;
                                        if (i11 < 0) {
                                            g.u();
                                        }
                                        if (Intrinsics.b(((BottomDialog$MenuItem) next).getId(), id2)) {
                                            break;
                                            break;
                                        }
                                        i11 = i12;
                                    }
                                    if (i11 != -1) {
                                        builder.B.put(Integer.valueOf(i11), builder.f65y.getItem(i11));
                                        builder.f65y.v().remove(i11);
                                    }
                                    builder.f65y.notifyDataSetChanged();
                                }
                            } else if (id2.equals("refreshApp")) {
                                builder.getClass();
                                Intrinsics.g(id2, "id");
                                it = builder.f65y.v().iterator();
                                i11 = 0;
                                while (true) {
                                    if (it.hasNext()) {
                                        i11 = -1;
                                        break;
                                    }
                                    next = it.next();
                                    i12 = i11 + 1;
                                    if (i11 < 0) {
                                        g.u();
                                    }
                                    if (Intrinsics.b(((BottomDialog$MenuItem) next).getId(), id2)) {
                                        break;
                                        break;
                                    }
                                    i11 = i12;
                                }
                                if (i11 != -1) {
                                    builder.B.put(Integer.valueOf(i11), builder.f65y.getItem(i11));
                                    builder.f65y.v().remove(i11);
                                }
                                builder.f65y.notifyDataSetChanged();
                            }
                        } else if (id2.equals("permission")) {
                            builder.getClass();
                            Intrinsics.g(id2, "id");
                            it = builder.f65y.v().iterator();
                            i11 = 0;
                            while (true) {
                                if (it.hasNext()) {
                                    i11 = -1;
                                    break;
                                }
                                next = it.next();
                                i12 = i11 + 1;
                                if (i11 < 0) {
                                    g.u();
                                }
                                if (Intrinsics.b(((BottomDialog$MenuItem) next).getId(), id2)) {
                                    break;
                                    break;
                                }
                                i11 = i12;
                            }
                            if (i11 != -1) {
                                builder.B.put(Integer.valueOf(i11), builder.f65y.getItem(i11));
                                builder.f65y.v().remove(i11);
                            }
                            builder.f65y.notifyDataSetChanged();
                        }
                    }
                }
            }
            builder.f65y.notifyDataSetChanged();
        }
    }

    @Override // com.cloud.tmc.miniapp.point.CreateBottomMenuPoint, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.k("CreateBottomMenuImpl", "onFinalized");
    }

    @Override // com.cloud.tmc.miniapp.point.CreateBottomMenuPoint, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.k("CreateBottomMenuImpl", "onInitialized");
    }

    @Override // com.cloud.tmc.miniapp.point.CreateBottomMenuPoint
    public void requestBottomAbilityConfig() {
        MiniRequestUtils.b();
    }
}
