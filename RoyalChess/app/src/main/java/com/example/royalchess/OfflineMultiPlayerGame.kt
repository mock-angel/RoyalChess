package com.example.royalchess

import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.royalchess.Pieces.GameBoard
import com.example.royalchess.Pieces.TeamDirectionEnum
import com.example.royalchess.Pieces.TeamEnum

class OfflineMultiPlayerGame : AppCompatActivity() {


    private val board = GameBoard()

    private var isSelected = false
    private var selectedPosition : Position = Position(-1, -1)

    private var validPositions: List<Position> = emptyList()
    private var boardButtons: ArrayList<ArrayList<Button>> = ArrayList()

    var playersArrayList = ArrayList<Player>()
    lateinit var currentPlayerTurn : Player
    private lateinit var devicePlayer: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline_multiplayer_game)

        boardButtons.clear()

        //Get all buttons.
        for(r in 0 until 8 ){
            val row = ArrayList<Button>()

            for (c in 0 until 8){
                //R.id.b-
                val id = this.resources.
                    getIdentifier("$packageName:id/b-$r.$c", "string", this.packageName)

                //d("tag", " $id  --$r,$c $packageName")

                row.add( findViewById(id) )
            }

            boardButtons.add(row)
        }

        onClickStartGame();
    }

    fun onClickStartGame(){
        d("functionCall", "onClickStartGame")
        //Method to start game.

        var player_one : Player = Player()
        var player_two : Player = Player()


        player_one.setTeam(TeamEnum.WHITE)
        player_one.setTeamDirection(TeamDirectionEnum.BOTTOM_TO_TOP)

        player_two.setTeam(TeamEnum.BLACK)
        player_two.setTeamDirection(TeamDirectionEnum.TOP_TO_BOTTOM)

        playersArrayList.clear()
        playersArrayList.add(player_one)
        playersArrayList.add(player_two)

        for(player in playersArrayList) when (player.getTeamDirection()){
            TeamDirectionEnum.BOTTOM_TO_TOP -> player_one = player
            TeamDirectionEnum.TOP_TO_BOTTOM -> player_two = player
            else -> return
        }

        board.resetBoard(player_one, player_two)
        board.updateAllValidMoves()

        applyBoardToDisplay()
    }

    private fun getIdString(view: View): String {
        return if (view.id == View.NO_ID) "no-id" else view.resources.getResourceName(view.id)
    }

    private fun getPositionFromId(idString : String): Position {
        val idString = idString.split("/")[1].replace("b-", "");

        val rcString = idString.split(".")

        return Position(rcString[1].toInt(), rcString[0].toInt())
    }

    public fun onClickSquare(v: View){

        val position = getPositionFromId(getIdString(v))

        d("functionCall", "onClickSquare : ${position.x}, ${position.y}")

        if(selectedPosition == position)
            isSelected = !isSelected
        else {
            isSelected = true
            selectedPosition = position
        }

        applyBoardToDisplay()
    }

    private fun applyRawBoardToDisplay() {
        d("functionCall", "applyRawBoardToDisplay")

        for (r in 0 until 8)
            for (c in 0 until 8)
                boardButtons[r][c].text = board.getPieceAt(r, c).getPieceRepresentation()
    }

    private fun applyBoardToDisplay() {
        d("functionCall", "applyBoardToDisplay")

        applyRawBoardToDisplay()

        if(isSelected){
            validPositions =  board.getValidMovesFromPosition(selectedPosition)

            for(pos in validPositions) boardButtons[pos.r][pos.c].text = "${boardButtons[pos.r][pos.c].text}o"

        } else validPositions = emptyList()
    }
}