package com.example.royalchess.Pieces

import com.example.royalchess.Position

class BishopPiece(gameBoard: GameBoard): Piece(PieceIdentity.Queen, gameBoard){
    override fun updateValidMoves(){

        listOfValidPos.clear()
    }
}