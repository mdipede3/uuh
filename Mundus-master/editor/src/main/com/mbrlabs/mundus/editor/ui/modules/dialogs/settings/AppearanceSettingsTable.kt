/*
 * Copyright (c) 2016. See AUTHORS file.
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

package com.mbrlabs.mundus.editor.ui.modules.dialogs.settings

import com.kotcrab.vis.ui.widget.VisLabel

/**
 * @author Marcus Brummer
 * @version 26-10-2016
 */
class AppearanceSettingsTable : BaseSettingsTable() {

    init {
        top().left()
        padRight(5f).padLeft(6f)

        add(VisLabel("Appearance Settings")).left().row()
        addSeparator().padBottom(10f)
    }

    override fun onSave() {

    }

}