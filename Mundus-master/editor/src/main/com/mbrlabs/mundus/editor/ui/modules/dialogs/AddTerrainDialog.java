///*
// * Copyright (c) 2016. See AUTHORS file.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.mbrlabs.mundus.editor.ui.modules.dialogs;
//
//import com.badlogic.gdx.scenes.scene2d.ui.Table;
//import com.kotcrab.vis.ui.widget.VisLabel;
//import com.kotcrab.vis.ui.widget.VisTable;
//import com.kotcrab.vis.ui.widget.VisTextButton;
//import com.kotcrab.vis.ui.widget.VisTextField;
//import com.mbrlabs.mundus.editor.core.Inject;
//import com.mbrlabs.mundus.editor.Mundus;
//import com.mbrlabs.mundus.editor.core.project.ProjectManager;
//import com.mbrlabs.mundus.editor.shader.Shaders;
//
///**
// * @author Marcus Brummer
// * @version 01-12-2015
// */
//public class AddTerrainDialog extends BaseDialog {
//
//    // UI elements
//    private VisTextField name = new VisTextField("Terrain");
//
//    private VisTextField vertexResolution = new VisTextField("180");
//
//    private VisTextField terrainWidth = new VisTextField("1200");
//    private VisTextField terrainDepth = new VisTextField("1200");
//    private VisTextField positionX = new VisTextField("0");
//    private VisTextField positionZ = new VisTextField("0");
//
//    private VisTextButton generateBtn = new VisTextButton("GENERATE TERRAIN");
//
//    @Inject
//    private Shaders shaders;
//    @Inject
//    private ProjectManager projectManager;
//
//    public AddTerrainDialog() {
//        super("Add Terrain");
//        Mundus.inject(this);
//        setResizable(true);
//        setupUI();
//        setupListeners();
//    }
//
//    private void setupUI() {
//        Table root = new Table();
//        // root.debugAll();
//        root.padTop(6).padRight(6).padBottom(22);
//        add(root);
//
//        // left table
//        VisTable content = new VisTable();
//        content.left().top();
//        content.add(new VisLabel("Name: ")).left().padBottom(10);
//        content.add(name).fillX().expandX().row();
//        content.add(new VisLabel("Vertex resolution: ")).left().padBottom(10);
//        content.add(vertexResolution).fillX().expandX().row();
//        content.add(new VisLabel("Position on x-axis:")).left().padBottom(10);
//        content.add(positionX).fillX().expandX().row();
//        content.add(new VisLabel("Position on z-axis: ")).left().padBottom(10);
//        content.add(positionZ).fillX().expandX().row();
//        content.add(new VisLabel("Terrain width: ")).left().padBottom(10);
//        content.add(terrainWidth).fillX().expandX().row();
//        content.add(new VisLabel("Terrain depth")).left().padBottom(10);
//        content.add(terrainDepth).fillX().expandX().row();
//        content.add(generateBtn).fillX().expand().colspan(2).bottom();
//        root.add(content).width(500).height(400);
//    }
//
//    private void setupListeners() {
//
//        // terraform btn
//        //        generateBtn.addListener(new ClickListener() {
//        //            @Override
//        //            public void clicked(InputEvent event, float x, float y) {
//        //                super.clicked(event, x, y);
//        //                try {
//        //                    String nom = name.getText();
//        //
//        //                    int res = Integer.valueOf(vertexResolution.getText());
//        //                    int width = Integer.valueOf(terrainWidth.getText());
//        //                    int depth = Integer.valueOf(terrainDepth.getText());
//        //                    float posX = Float.valueOf(positionX.getText());
//        //                    float posZ = Float.valueOf(positionZ.getText());
//        //
//        //                    final ProjectContext projectContext = projectManager.current();
//        //                    Terrain terrainAsset = TerrainUtils.createTerrain(projectContext.obtainID(), nom, width, depth, res);
//        //                    terrainAsset.transform.setTranslation(posX, 0, posZ);
//        //                    projectContext.terrains.add(terrainAsset);
//        //                    projectContext.currScene.terrains.add(terrainAsset);
//        //                    GameObject terrainGO = TerrainUtils.createTerrainGO(projectContext.currScene.sceneGraph,
//        //                            shaders.terrainShader, projectContext.obtainID(), nom, terrainAsset);
//        //                    projectContext.currScene.sceneGraph.addGameObject(terrainGO);
//        //
//        //                    Mundus.postEvent(new SceneGraphChangedEvent());
//        //
//        //                } catch (NumberFormatException nfe) {
//        //                    Log.error(TAG, nfe.getMessage());
//        //                }
//        //
//        //            }
//        //        });
//
//    }
//
//}
