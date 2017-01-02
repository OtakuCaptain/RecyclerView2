package com.chen.recyclerview;

import android.view.View;

/**
 * Created by chen on 2016-12-30.
 */

public interface OnItemClickListener {
    void onItemClick(View view, int position);

    void onLongItemClick(View view, int position);
}
