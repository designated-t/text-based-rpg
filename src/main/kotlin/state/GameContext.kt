package state

import Player
import enums.GameState
import serialization.serializable.map.Area
import serialization.serializable.map.MapHandler

data class GameContext(
    var player: Player = Player,
    var gameState: GameState = GameState.AREA,
    var currentArea: Area = generateWorld()
    //var interaction: Interaction
) {


    companion object {
        fun generateWorld(): Area {
            //if savestate has a world, load that
            //else
            // TODO: Maybe create a cool random gen?
            // Or just get premade maps from file

            return MapHandler.provideAreaById("starter_area")
        }
    }
}