package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {
/**
 * Prosses the entity
 * @param gameData
 * @param world 
 */
    void process(GameData gameData, World world);
}
