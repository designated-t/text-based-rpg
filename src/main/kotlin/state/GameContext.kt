package state

import GameState
import Player
import map.Area

data class GameContext(
    var player: Player = Player,
    var gameState: GameState = GameState.AREA,
    var currentArea: Area
    //var interaction: Interaction
)