/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Random;

/**
 *
 * @author Stephanie
 */
public class AsteroidControlSystem implements IEntityProcessingService {

    Random r = new Random(System.currentTimeMillis()); // dot wanna create this for every proces call
        boolean UP = false;
        boolean LEFT = false;
        boolean RIGHT = false;
        private float size = 16;

    @Override
    public void process(GameData gameData, World world) {

         UP = ((r.nextInt()*100)<5);
         LEFT = ((r.nextInt()*100)<75);
         RIGHT = ((r.nextInt()*100)<5);

        for (Entity enemy : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);

            movingPart.setLeft(LEFT);
            movingPart.setRight(RIGHT);
            movingPart.setUp(UP);

            movingPart.process(gameData, enemy);
            positionPart.process(gameData, enemy);

            updateShape(enemy);
        }
    }
 
    private void updateShape(Entity entity) {
        float[] shapex = new float[5];
        float[] shapey = new float[5];
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians + 0 * 3.1415f / 5) * size);
        shapey[0] = (float) (y + Math.sin(radians + 0 * 3.1415f / 5) * size);

        shapex[1] = (float) (x + Math.cos(radians + 2 * 3.1415f / 5) * size);
        shapey[1] = (float) (y + Math.sin(radians + 2 * 3.1415f / 5) * size);
        
        shapex[2] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * size);
        shapey[2] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * size);

        shapex[3] = (float) (x + Math.cos(radians + 6 * 3.1415f / 5) * size);
        shapey[3] = (float) (y + Math.sin(radians + 6 * 3.1415f / 5) * size);

        shapex[4] = (float) (x + Math.cos(radians + 8 * 3.1415f / 5) * size);
        shapey[4] = (float) (y + Math.sin(radians + 8 * 3.1415f / 5) * size);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
    
}
