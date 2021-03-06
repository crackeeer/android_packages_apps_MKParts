/*
 * Copyright (C) 2014 The CyanogenMod Project
 * Copyright (C) 2014 The MoKee Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mokee.mkparts.profiles.actions.item;

import org.mokee.mkparts.R;
import org.mokee.mkparts.profiles.actions.ItemListAdapter;

import mokee.app.Profile;

public class LockModeItem extends BaseItem {
    Profile mProfile;

    public LockModeItem(Profile profile) {
       mProfile = profile;
    }

    @Override
    public ItemListAdapter.RowType getRowType() {
        return ItemListAdapter.RowType.LOCKSCREENMODE_ITEM;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getTitle() {
        return getString(R.string.profile_lockmode_title);
    }

    @Override
    public String getSummary() {
        return getString(getSummaryString(mProfile));
    }

    public static int getSummaryString(Profile profile) {
        switch (profile.getScreenLockMode().getValue()) {
            case Profile.LockMode.DEFAULT:
                return R.string.profile_action_system; //"leave unchanged"
            case Profile.LockMode.DISABLE:
                return R.string.profile_lockmode_disabled_summary;
            case Profile.LockMode.INSECURE:
                return R.string.profile_lockmode_insecure_summary;
            default: return 0;
        }
    }
}
