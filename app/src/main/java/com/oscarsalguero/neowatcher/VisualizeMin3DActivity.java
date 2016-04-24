package com.oscarsalguero.neowatcher;

import android.graphics.Bitmap;
import android.os.Bundle;

import min3d.Shared;
import min3d.Utils;
import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.objectPrimitives.Sphere;
import min3d.vos.Light;

/**
 * Min3D Visualizer
 * <p/>
 * Created by RacZo on 4/23/16.
 */
public class VisualizeMin3DActivity extends RendererActivity {

    Object3dContainer _sun;
    Object3dContainer _earth;
    Object3dContainer _moon;

    int _count;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void initScene() {

        Light light = new Light();

        light.ambient.setAll((short) 64, (short) 64, (short) 64, (short) 255);
        light.position.setAll(3, 3, 3);
        scene.lights().add(light);

        // Add Sun to scene
        _sun = new Sphere(0.8f, 15, 10, true, true, false);
        scene.addChild(_sun);

        // Add Earth as a child of the Sun
        _earth = new Sphere(0.4f, 12, 9, true, true, false);
        _earth.position().x = 2.6f;
        _earth.rotation().x = 23;
        _sun.addChild(_earth);

        // Add the Moon as a child of Earth
        _moon = new Sphere(0.2f, 10, 8, true, true, false);
        _moon.position().x = 0.6f;
        _earth.addChild(_moon);

        // Add textures to TextureManager
        Bitmap b = Utils.makeBitmapFromResourceId(this, R.drawable.sun);
        Shared.textureManager().addTextureId(b, "sun", false);
        b.recycle();

        b = Utils.makeBitmapFromResourceId(this, R.drawable.earth);
        Shared.textureManager().addTextureId(b, "earth", false);
        b.recycle();

        b = Utils.makeBitmapFromResourceId(this, R.drawable.moon);
        Shared.textureManager().addTextureId(b, "moon", false);
        b.recycle();

        // Add textures to objects based on on the id's we assigned the textures in the texture manager
        _sun.textures().addById("sun");
        _earth.textures().addById("earth");
        _moon.textures().addById("moon");

        _count = 0;

    }

    @Override
    public void updateScene() {

        // Spin spheres
        _sun.rotation().y += 0.5f;
        _earth.rotation().y += 3.0f;
        _moon.rotation().y -= 3.0f;

        // Wobble Sun a little just for fun
        _count++;
        float mag = (float) (Math.sin(_count * 0.2 * Utils.DEG)) * 15;
        _sun.rotation().z = (float) Math.sin(_count * .33 * Utils.DEG) * mag;

        // Move camera around
        scene.camera().position.z = 10.5f + (float) Math.sin(_sun.rotation().y * Utils.DEG);
        scene.camera().target.x = (float) Math.sin((_sun.rotation().y + 90) * Utils.DEG) * 0.8f;

    }

}