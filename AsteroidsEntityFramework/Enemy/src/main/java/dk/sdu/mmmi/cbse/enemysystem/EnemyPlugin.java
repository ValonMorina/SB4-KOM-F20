package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.awt.*;
import java.util.Random;

import static java.awt.Color.RED;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;
    private Random random = new Random();


    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy);
    }

    private Entity createEnemyShip(GameData gameData) {

        // Create random start position
        int randomX = random.nextInt(gameData.getDisplayWidth());
        int randomY = random.nextInt(gameData.getDisplayHeight());
        float randomRadians = 3.1415f * random.nextFloat();

        // Set movement rules
        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;

        // Set enemy ship start position
        float x = randomX;
        float y = randomY;
        float radians = randomRadians;

        // create the enemy ship
        Entity enemyShip = new Enemy();
        enemyShip.add(new MovingPart(deacceleration,acceleration,maxSpeed,rotationSpeed));
        enemyShip.add(new PositionPart(x,y,radians));
        return enemyShip;
    }
}

