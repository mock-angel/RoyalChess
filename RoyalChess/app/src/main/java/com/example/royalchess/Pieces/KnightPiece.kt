package com.example.royalchess.Pieces

import com.example.royalchess.Position

class KnightPiece(gameBoard: GameBoard): Piece(PieceIdentity.Knight, gameBoard){
    override fun updateValidMoves(position: Position){
        pos = position

        listOfValidPos.clear()
    }
}