package state

import GameState
import Player

data class GameContext(
    var player: Player = Player,
    var gameState: GameState = GameState.AREA,
    //var interaction: Interaction
)