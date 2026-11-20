package com.blankj.utilcode.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class ShellUtils$1 extends Utils.Task<e0.a> {
    final /* synthetic */ String[] val$commands;
    final /* synthetic */ boolean val$isNeedResultMsg;
    final /* synthetic */ boolean val$isRooted;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShellUtils$1(Utils.b bVar, String[] strArr, boolean z11, boolean z12) {
        super(bVar);
        this.val$commands = strArr;
        this.val$isRooted = z11;
        this.val$isNeedResultMsg = z12;
    }

    @Override // com.blankj.utilcode.util.ThreadUtils.Task
    public e0.a doInBackground() {
        return e0.b(this.val$commands, this.val$isRooted, this.val$isNeedResultMsg);
    }
}
