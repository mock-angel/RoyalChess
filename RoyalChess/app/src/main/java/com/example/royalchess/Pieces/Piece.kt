package com.example.royalchess.Pieces

import com.example.royalchess.Player
import com.example.royalchess.Position




open class Piece(private val pieceIdentity: PieceIdentity, protected val gameBoard: GameBoard) {

    private var team = TeamEnum.NONE

    private lateinit var position: Position

    protected val listOfValidPos = ArrayList<Position>()

    protected lateinit var playerOwner: Player

    var pos: Position
        get() { return position }
        set(value) {position = value}

    fun setTeam (team: TeamEnum){
        this.team = team
    }

    fun getPieceIdentity(): PieceIdentity{
        return pieceIdentity
    }

    fun setPlayer (player: Player){
        playerOwner = player
    }

    private fun isValidMove(t_pos: Position): Boolean{
        return listOfValidPos.contains(t_pos)
    }

    fun moveTo( t_pos: Position){

        if(isValidMove(t_pos)) {
            pos = t_pos

            //gameBoard.
            //Do remaining methods
        }
    }

    open fun updateValidMoves(_position: Position){
        pos = _position
    }

    fun getValidMoves(): List<Position>{
        return listOfValidPos
    }

    fun getPieceRepresentation(): String{

        var retString = when(pieceIdentity){
            PieceIdentity.Pawn -> "p"
            PieceIdentity.King -> "K"
            PieceIdentity.Queen -> "Q"
            PieceIdentity.Bishop -> "B"
            PieceIdentity.Rook -> "R"
            PieceIdentity.Knight -> "H"
            PieceIdentity.Empty -> ""
        }

        retString = when(team){
            TeamEnum.WHITE -> "w-$retString"
            TeamEnum.BLACK -> "b-$retString"
            TeamEnum.RED -> "r-$retString"
            TeamEnum.YELLOW -> "y-$retString"
            TeamEnum.NONE -> "-$retString"
        }

        return retString
    }

    protected fun getDirectionMultiplier(): Int {

        return when(playerOwner.getTeamDirection()){
            TeamDirectionEnum.TOP_TO_BOTTOM -> 1
            TeamDirectionEnum.BOTTOM_TO_TOP -> -1
            else -> 0
        }
    }
}