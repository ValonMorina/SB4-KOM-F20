package dk.sdu.mmmi.cbse;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {
    private Entity asteroid;
    private Random random = new Random();


    @Override
    public void start(GameData gameData, World world) {
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }


    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(asteroid);
    }

    private Entity createAsteroid(GameData gameData) {
        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;

        //Create random start position
        int randomX = random.nextInt(gameData.getDisplayWidth());
        int randomY = random.nextInt(gameData.getDisplayHeight());
        float randomRadians = 3.1415f * random.nextFloat();

        //Set asteroid start position
        float x = randomX;
        float y = randomY;
        float radians = randomRadians;

        Entity asteroid = new Asteroid();
        asteroid.add(new MovingPart(deacceleration,acceleration,maxSpeed,rotationSpeed));
        asteroid.add(new PositionPart(x,y,radians));

        return asteroid;
    }
}
