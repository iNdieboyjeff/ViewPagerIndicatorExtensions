/*
 *  Copyright (c) 2015-2016 Jeff Sutton
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.example.sample3.behaviour;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * <p>This is a Behaviour for use with CoordinatorLayout. It allows you to position a view
 * beneath a {@link android.support.design.widget.CollapsingToolbarLayout} to take account
 * of it's variable size.</p>
 * <p>You can specify this in XML using <br />
 * app:layout_behavior="com.example.sample3.behaviour.RecyclerPositionBehavior"<br />
 * </p>
 *
 * @author Jeff Sutton
 * @version 1.0 (26/11/2015).
 */
public class RecyclerPositionBehavior extends AppBarLayout.ScrollingViewBehavior {

    private View layout;

    public RecyclerPositionBehavior() {
    }

    public RecyclerPositionBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        boolean result = super.onDependentViewChanged(parent, child, dependency);
        if (layout != null) {
            layout.setPadding(layout.getPaddingLeft(), layout.getPaddingTop(), layout
                    .getPaddingRight(), layout.getPaddingTop());
        }
        return result;
    }

    public void setLayout(View layout) {
        this.layout = layout;
    }
}