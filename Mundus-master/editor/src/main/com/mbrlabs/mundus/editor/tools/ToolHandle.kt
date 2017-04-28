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

package com.mbrlabs.mundus.editor.tools

import com.badlogic.gdx.graphics.g3d.ModelBatch
import com.badlogic.gdx.math.Quaternion
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.utils.Disposable
import com.mbrlabs.mundus.editor.tools.picker.PickerColorEncoder
import com.mbrlabs.mundus.editor.tools.picker.PickerIDAttribute

/**
 * A tool handle is the visual part of a tool (e.g. x arrow handle of the
 * translate tool).
 *
 * Handles, can be (much like game objects) picked, using the same (color coding
 * technique).
 *
 * @author Marcus Brummer
 * @version 07-03-2016
 */
abstract class ToolHandle(val id: Int) : Disposable {

    val position: Vector3 = Vector3()
    val rotationEuler: Vector3 = Vector3()
    val rotation: Quaternion = Quaternion()
    val scale: Vector3 = Vector3(1f, 1f, 1f)
    val idAttribute: PickerIDAttribute = PickerIDAttribute()

    init {
        PickerColorEncoder.encodeRaypickColorId(id, idAttribute)
    }

    abstract fun render(batch: ModelBatch)
    abstract fun renderPick(modelBatch: ModelBatch)
    abstract fun act()
    abstract fun applyTransform()

}
