package com.cloud.tmc.miniapp.ui.adapter;

import android.content.Context;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T> extends BaseAdapter<a<T>.AbstractC0347a> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<T> f31777o;

    /* JADX INFO: renamed from: com.cloud.tmc.miniapp.ui.adapter.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public abstract class AbstractC0347a extends BaseAdapter<a<T>.AbstractC0347a>.a {
        public AbstractC0347a(int i11) {
            super(a.this, i11);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f31777o = new ArrayList();
    }

    public T getItem(int i11) {
        return this.f31777o.get(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return u();
    }

    public void r(List<T> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                this.f31777o.addAll(list);
                notifyItemRangeInserted(this.f31777o.size() - list.size(), list.size());
            } catch (Throwable th2) {
                TmcLogger.h("", th2);
            }
        }
    }

    public void s(int i11, T t11) {
        if (i11 < this.f31777o.size()) {
            this.f31777o.add(i11, t11);
        } else {
            this.f31777o.add(t11);
            i11 = this.f31777o.size() - 1;
        }
        notifyItemInserted(i11);
    }

    public void t(T t11) {
        s(this.f31777o.size(), t11);
    }

    public int u() {
        return this.f31777o.size();
    }

    public List<T> v() {
        return this.f31777o;
    }

    public void w(int i11) {
        this.f31777o.remove(i11);
        notifyItemRemoved(i11);
    }

    public void x(List<T> list) {
        if (list == null) {
            this.f31777o.clear();
        } else {
            this.f31777o = list;
        }
        notifyDataSetChanged();
    }
}
