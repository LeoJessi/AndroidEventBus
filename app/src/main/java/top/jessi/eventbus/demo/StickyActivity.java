/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 Umeng, Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package top.jessi.eventbus.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import top.jessi.eventbus.demo.bean.User;

import top.jessi.eventbus.EventBus;
import top.jessi.eventbus.Subscriber;


public class StickyActivity extends Activity {

    TextView nameTv;
    TextView ageTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sticky_activity);

        nameTv = (TextView) findViewById(R.id.name_tv);
        ageTv = (TextView) findViewById(R.id.age_tv);

        EventBus.getDefault().registerSticky(this);
    }

    @Subscriber
    private void onReceiveStickyEvent(User info) {
        nameTv.setText(info.name);
        ageTv.setText("age ----- 32");

        // Log.e("", "### 找到 接到sticky消息 " + info.name);
        // 接受到事件之后可以手动移除Sticky事件
        EventBus.getDefault().removeStickyEvent(info.getClass());
    }

    @Override
    protected void onDestroy() {
        // EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
