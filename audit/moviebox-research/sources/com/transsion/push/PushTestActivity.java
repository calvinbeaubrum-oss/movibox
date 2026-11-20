package com.transsion.push;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.n;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.baselib.db.notification.MsgConfig;
import com.transsion.push.helper.PushMsgHelper;
import com.transsion.push.utils.NotificationUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PushTestActivity extends AppCompatActivity {
    public static final void R(PushTestActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        MsgBean msgBean = (MsgBean) n.d(this$0.O(), MsgBean.class);
        msgBean.setPermanent(true);
        msgBean.setMessageId("611451061");
        msgBean.setTitle(this$0.Q());
        j.d(v.a(this$0), null, null, new PushTestActivity$initView$1$1(null), 3, null);
    }

    public static final void S(PushTestActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        MsgBean msgBean = (MsgBean) n.d(this$0.O(), MsgBean.class);
        msgBean.setTitle(this$0.Q());
        msgBean.setMessageId(String.valueOf(System.currentTimeMillis()));
        msgBean.setFloat(true);
        PushMsgHelper pushMsgHelper = PushMsgHelper.f56891a;
        Intrinsics.f(msgBean, "msgBean");
        pushMsgHelper.b(this$0, msgBean);
    }

    private final void initView() {
        ((AppCompatButton) findViewById(R$id.show_permanent_notification)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.R(this.f56831a, view);
            }
        });
        ((AppCompatButton) findViewById(R$id.show_notification)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.S(this.f56832a, view);
            }
        });
        MsgConfig msgConfigB = NotificationUtil.f57032a.B();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("config = ");
        sb2.append(msgConfigB);
    }

    public final String O() {
        return "{\n\"messageId\": \"61145106\",\n\"title\": \"Kedidir Kedi\",\n\"desc\": \"Kedidir Kedi\",\n\"source\": \"push\",\n\"type\": \"1\",\n\"style\": \"1\",\n\"deeplink\": \"oneroom://com.community.oneroom?type=/post/detail&id=8861784091733843488&channel=push&msg_type=LocalPush\",\n\"imageList\": \"https://pacdn.aoneroom.com/image/2024/11/01/209d0b40e1b24b81a4fbd9ea150165ec.jpeg\"\n}";
    }

    public final String Q() {
        EditText editText = (EditText) findViewById(R$id.edTitle);
        Editable text = editText != null ? editText.getText() : null;
        return (text == null || text.length() == 0) ? "Notification Title Test ------- Notification Title Test ------- Notification Title Test" : text.toString();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_push_test);
        initView();
        NotificationUtil.f57032a.q(this, null);
    }
}
