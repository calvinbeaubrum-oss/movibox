package com.cloud.tmc.kernel.proxy.worker;

import com.cloud.tmc.kernel.node.Node;
import gd.a;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.miniapp.defaultimpl.WorkerImp")
public interface IWorkerFactory {
    a createWorker(String str, Node node);

    int workerType();
}
