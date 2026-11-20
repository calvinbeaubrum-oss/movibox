package com.hisavana.common.interfacz;

import com.hisavana.common.bean.Network;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface QueryPriceListener {
    void onQueryPriceFailed();

    void onQueryPriceSuccess(List<Network> list);
}
