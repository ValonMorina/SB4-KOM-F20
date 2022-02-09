package dk.sdu.mmmi.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;


public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;

    @Override
    public void start(GameData gameData, World world) {
        asteroid = createLargeAsteroid(gameData);
        world.addEntity(asteroid);
    }

    @Override
    public void stop(GameData gameData, World world) {

    }

    private Entity createLargeAsteroid(GameData gameData) {
        float speed = (float) Math.random() * 10f + 40f;
        float radians = 3.1415f / 2 + (float) Math.random();
        float x = gameData.getDisplayWidth() / 2 + 100;
        float y = gameData.getDisplayHeight() / 2 + 50;

        float[] color = new float[4];
        color[0] = 1.0f;
        color[1] = 1.0f;
        color[2] = 1.0f;
        color[3] = 1.0f;
        return null;
    }
}
