package com.cloud.tmc.miniapp.utils;

import hd.j;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class MsgSwitchResultBean extends b {
    private Boolean success;

    public MsgSwitchResultBean(Boolean bool) {
        this.success = bool;
    }

    public static /* synthetic */ MsgSwitchResultBean copy$default(MsgSwitchResultBean msgSwitchResultBean, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = msgSwitchResultBean.success;
        }
        return msgSwitchResultBean.copy(bool);
    }

    public final Boolean component1() {
        return this.success;
    }

    public final MsgSwitchResultBean copy(Boolean bool) {
        return new MsgSwitchResultBean(bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MsgSwitchResultBean) && Intrinsics.b(this.success, ((MsgSwitchResultBean) obj).success);
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        Boolean bool = this.success;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public final void setSuccess(Boolean bool) {
        this.success = bool;
    }

    public String toString() {
        StringBuilder sbA = j.a("MsgSwitchResultBean(success=");
        sbA.append(this.success);
        sbA.append(')');
        return sbA.toString();
    }
}
