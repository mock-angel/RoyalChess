package com.example.royalchess.Pieces

import com.example.royalchess.Position

class KingPiece( gameBoard: GameBoard): Piece(PieceIdentity.King, gameBoard){
    override fun updateValidMoves(){

        listOfValidPos.clear()

        var searchPositions = ArrayList<Position>()

        //search around king and find positions to look for.
        for(x in pos.x - 1 until pos.x + 1)
            for (y in pos.y - 1 until pos.y + 1){
                if((x >= 0) and (x < 8) and (y >=0) and (y < 8))
                    searchPositions.add(Position(x, y))
            }

        for(searchPos in searchPositions)
            if(gameBoard.getPieceAt(searchPos) != null)
                listOfValidPos.add(searchPos)


    }
}