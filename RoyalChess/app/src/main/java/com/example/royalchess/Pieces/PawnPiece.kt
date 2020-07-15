package com.example.royalchess.Pieces

import android.util.Log.d
import com.example.royalchess.Position

class PawnPiece(gameBoard: GameBoard) : Piece(PieceIdentity.Pawn, gameBoard) {
    override fun updateValidMoves(position: Position){
        pos = position

        d("tag", "doing update now")
        listOfValidPos.clear()



        val sideMultilayer = 1;

        //if(!gameBoard.isInCheck()){
            //Valid moves go here

        //val position_ = Position(pos.x, pos.y + sideMultiplyer)
        val searchPositions = getSearchPositions(position)
        //val filterUnblockedPositions = filterUnblockedPositions(searchPositions)

        listOfValidPos.addAll(searchPositions)

        for (position in listOfValidPos ){

        }
    }

    fun getSearchPositions(position: Position): ArrayList<Position>{
        val searchPositions = ArrayList<Position>()

        val sideMultilayer = getDirectionMultiplier()

        if((pos.y + sideMultilayer >=0) and (pos.y + sideMultilayer < 8)) {

            val posFront = Position(pos.x, pos.y + sideMultilayer)
            if(gameBoard.getPieceAt(posFront).getPieceIdentity() == PieceIdentity.Empty)
                searchPositions.add(posFront)

            //val posLeft = Position(pos.x - 1, pos.y + sideMultilayer)
            if(pos.x - 1 >= 0)
                searchPositions.add(Position(pos.x - 1, pos.y + sideMultilayer))

            //val posRight = Position(pos.x + 1, pos.y + sideMultilayer)
            if(pos.x + 1 < 8)
                searchPositions.add(Position(pos.x + 1, pos.y + sideMultilayer))

        }

        return  searchPositions
    }

    fun getValidPositions() {

    }
}