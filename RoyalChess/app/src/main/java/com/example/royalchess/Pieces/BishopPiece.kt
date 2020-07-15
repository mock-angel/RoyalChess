package com.example.royalchess.Pieces

import com.example.royalchess.Position

class BishopPiece(gameBoard: GameBoard): Piece(PieceIdentity.Bishop, gameBoard){
    override fun updateValidMoves(position: Position){
        pos = position

        listOfValidPos.clear()
    }
}