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

package com.mbrlabs.mundus.editor.ui

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.kotcrab.vis.ui.VisUI
import com.kotcrab.vis.ui.widget.Separator
import com.kotcrab.vis.ui.widget.VisDialog
import com.kotcrab.vis.ui.widget.VisTable
import com.kotcrab.vis.ui.widget.color.ColorPicker
import com.kotcrab.vis.ui.widget.file.FileChooser
import com.mbrlabs.mundus.editor.ui.modules.MundusToolbar
import com.mbrlabs.mundus.editor.ui.modules.Outline
import com.mbrlabs.mundus.editor.ui.modules.StatusBar
import com.mbrlabs.mundus.editor.ui.modules.dialogs.*
import com.mbrlabs.mundus.editor.ui.modules.dialogs.assets.AssetPickerDialog
import com.mbrlabs.mundus.editor.ui.modules.dialogs.importer.ImportModelDialog
import com.mbrlabs.mundus.editor.ui.modules.dialogs.importer.ImportTextureDialog
import com.mbrlabs.mundus.editor.ui.modules.dialogs.settings.SettingsDialog
import com.mbrlabs.mundus.editor.ui.modules.dock.DockBar
import com.mbrlabs.mundus.editor.ui.modules.inspector.Inspector
import com.mbrlabs.mundus.editor.ui.modules.menu.MundusMenuBar
import com.mbrlabs.mundus.editor.ui.widgets.MundusMultiSplitPane
import com.mbrlabs.mundus.editor.ui.widgets.MundusSplitPane
import com.mbrlabs.mundus.editor.ui.widgets.RenderWidget
import com.mbrlabs.mundus.editor.utils.Toaster

/**
 * @author Marcus Brummer
 * @version 27-11-2015
 */
object UI : Stage(ScreenViewport()) {

    const val PAD_BOTTOM: Float = 2f
    const val PAD_BOTTOM_X2: Float = PAD_BOTTOM * 2

    const val PAD_SIDE: Float = 5f
    const val PAD_SIDE_X2: Float = PAD_SIDE * 2


    // reusable ui elements
    val toaster: Toaster = Toaster(this)
    val fileChooser: FileChooser = FileChooser(FileChooser.Mode.OPEN)
    val assetSelectionDialog: AssetPickerDialog = AssetPickerDialog()
    val colorPicker: ColorPicker = ColorPicker()

    // base elements
    private val root: VisTable
    private val splitPane: MundusSplitPane
    val menuBar: MundusMenuBar
    val toolbar: MundusToolbar
    val statusBar: StatusBar
    private val inspector: Inspector
    val outline: Outline
    private val docker: DockBar
    val sceneWidget: RenderWidget

    // dialogs
    val settingsDialog: SettingsDialog = SettingsDialog()
    val newProjectDialog: NewProjectDialog = NewProjectDialog()
    val loadingProjectDialog: LoadingProjectDialog = LoadingProjectDialog()
    val exportDialog: ExportDialog = ExportDialog()
    val importModelDialog: ImportModelDialog = ImportModelDialog()
    val importTextureDialog: ImportTextureDialog = ImportTextureDialog()
    val fogDialog: FogDialog = FogDialog()
    val skyboxDialog: SkyboxDialog = SkyboxDialog()
    val ambientLightDialog: AmbientLightDialog = AmbientLightDialog()
    val exitDialog: ExitDialog = ExitDialog()

    // styles
    val greenSeperatorStyle: Separator.SeparatorStyle

    init {
        FileChooser.setDefaultPrefsName("com.mbrlabs.mundus.editor")
        greenSeperatorStyle = Separator.SeparatorStyle(VisUI.getSkin().getDrawable("mundus-separator-green"), 1)

        root = VisTable()
        addActor(root)
        root.setFillParent(true)

        val mainContainer = VisTable()
        splitPane = MundusSplitPane(mainContainer, null, true)

        // row 1: add menu
        menuBar = MundusMenuBar()
        root.add(menuBar.table).fillX().expandX().row()

        // row 2: toolbar
        toolbar = MundusToolbar()
        root.add(toolbar.root).fillX().expandX().row()

        // row 3: sidebar & 3d viewport & inspector
        outline = Outline()
        inspector = Inspector()
        sceneWidget = RenderWidget()
        val multiSplit = MundusMultiSplitPane(false)
        multiSplit.setDraggable(false)
        multiSplit.setWidgets(outline, sceneWidget, inspector)
        multiSplit.setSplit(0, 0.2f)
        multiSplit.setSplit(1, 0.8f)
        mainContainer.add(multiSplit).grow().row()

        root.add(splitPane).grow().row()

        // row 4: DOCKER
        docker = DockBar(splitPane)
        root.add(docker).bottom().expandX().fillX().height(30f).row()

        // row 5: status bar
        statusBar = StatusBar()
        root.add(statusBar).expandX().fillX().height(25f).row()
    }

    fun showDialog(dialog: VisDialog) {
        dialog.show(this)
    }

}
