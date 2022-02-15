package dk.sdu.mmmi.cbse;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class CollisionProcessor implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity : world.getEntities()) {
            for (Entity entity1 : world.getEntities()) {

                PositionPart firstEntityPosition = entity.getPart(PositionPart.class);
                PositionPart SecondEntityPosition = entity1.getPart(PositionPart.class);

                float x1 = firstEntityPosition.getX();
                float y1 = firstEntityPosition.getY();
                float radius = 8;
                float x2 = SecondEntityPosition.getX();
                float y2 = SecondEntityPosition.getY();
                float radius1 = 8;

                if (checkCollision(x1,y1,radius,x2,y2,radius1)) {
                    System.out.println("Collision" + entity.toString() + " : " + entity1.toString());
                } else {
                    System.out.println("NO COLLISION! :)");
                }
            }
        }
    }

    private boolean checkCollision(float x1, float y1, float radius, float x2, float y2, float radius1) {
        float distance = (float) Math.hypot((x1-x2),(y1-y2));

        if ((radius + radius1) > distance) {
            return true;
        }
         return false;
    }
}
