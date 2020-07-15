package com.example.royalchess.Pieces

import com.example.royalchess.Position

class RookPiece(gameBoard: GameBoard): Piece(PieceIdentity.Rook, gameBoard){
    override fun updateValidMoves(position: Position){
        pos = position

        listOfValidPos.clear()
    }
}