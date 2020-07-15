package com.example.royalchess.Pieces

import android.util.Log
import android.util.Log.d
import com.example.royalchess.Player
import com.example.royalchess.Position

class GameBoard() {
    private val _board = ArrayList<ArrayList<Piece>>()

    companion object {
        lateinit var Instance : GameBoard
    }

    init {
        Instance = this

        for (r in 0 until 8) {
            val row = ArrayList<Piece>()

            for (c in 0 until 8) {
                val piece = Piece(PieceIdentity.Empty, this)
                piece.pos = Position(c, r)

                row.add(piece)
            }

            _board.add(row)
        }

        //resetBoard(-1)
        updateAllValidMoves()
    }

    fun resetBoard(playerPrimary: Player, playerSecondary: Player){
        //TODO: Need testing. Maybe need to refactor to multiple methods?
        d("functionCall", "resetBoard")

        var whitePlayer: Player
        var blackPlayer: Player

        when(playerPrimary.getTeam()){
            TeamEnum.WHITE -> whitePlayer = playerPrimary
            TeamEnum.BLACK -> blackPlayer = playerPrimary
            else -> {
                return
            }
        }

        when(playerSecondary.getTeam()){
            TeamEnum.WHITE -> whitePlayer = playerSecondary
            TeamEnum.BLACK -> blackPlayer = playerSecondary
            else -> {
                return
            }
        }

        //val direction = playerPrimary.getTeamDirection()



        for (r in 0 until 8) {
            for (c in 0 until 8) {
                val piece = Piece(PieceIdentity.Empty, this)
                piece.pos = Position(c, r)

                _board[r][c] = piece
            }
        }

        for(x in 0 until 8) {
            //prepare pawns for team 1
            val pawn1 = PawnPiece(this)
            pawn1.setTeam(playerPrimary.getTeam())
            _board[6][x] = pawn1
            //pawn1.pos = Position( x, 6)
            pawn1.setPlayer(playerPrimary)

            //prepare pawns for team 2
            val pawn2 = PawnPiece(this)
            pawn2.setTeam(playerSecondary.getTeam())
            _board[1][x] = pawn2
            //pawn2.pos = Position( x, 1)
            pawn2.setPlayer(playerSecondary)
        }

        for(m in 0 until 2) {
            //Create Rook
            val rook1 = RookPiece(this)
            rook1.setTeam(playerPrimary.getTeam())
            _board[7][m * 7 ] = rook1
            rook1.setPlayer(playerPrimary)

            val rook2 = RookPiece(this)
            rook2.setTeam(playerSecondary.getTeam())
            _board[0][m * 7] = rook2
            rook2.setPlayer(playerSecondary)

            //Create Knight
            val knight1 = KnightPiece(this)
            knight1.setTeam(playerPrimary.getTeam())
            _board[7][m * 5 + 1 ] = knight1
            knight1.setPlayer(playerPrimary)

            val knight2 = KnightPiece(this)
            knight2.setTeam(playerSecondary.getTeam())
            _board[0][m * 5 + 1] = knight2
            knight2.setPlayer(playerSecondary)

            //Create Bishop
            val bishop1 = BishopPiece(this)
            bishop1.setTeam(playerPrimary.getTeam())
            _board[7][m * 3 + 2 ] = bishop1
            bishop1.setPlayer(playerPrimary)

            val bishop2 = BishopPiece(this)
            bishop2.setTeam(playerSecondary.getTeam())
            _board[0][m * 3 + 2] = bishop2
            bishop2.setPlayer(playerSecondary)
        }

        val king1 = KingPiece(this)
        king1.setTeam(playerPrimary.getTeam())
        _board[7][4] = king1
        king1.setPlayer(playerPrimary)

        val king2 = KingPiece(this)
        king2.setTeam(playerSecondary.getTeam())
        _board[0][4] = king2
        king2.setPlayer(playerSecondary)

        val queen1 = QueenPiece(this)
        queen1.setTeam(playerPrimary.getTeam())
        _board[7][3] = queen1
        queen1.setPlayer(playerPrimary)

        val queen2 = QueenPiece(this)
        queen2.setTeam(playerSecondary.getTeam())
        _board[0][3] = queen2
        queen2.setPlayer(playerSecondary)
        
    }



    fun getPieceAt(pos: Position): Piece{
        return _board[pos.r][pos.c]
    }

    fun getPieceAt(r: Int, c: Int): Piece{
        return _board[r][c]
    }

    fun isInCheck(): Boolean{
        return true
    }

    fun getValidMovesFromPosition(pos: Position): List<Position>{
        return getPieceAt(pos).getValidMoves()
    }

    fun updateAllValidMoves(){
        for(r in 0 until 8)
            for (c in 0 until 8) _board[r][c].updateValidMoves(Position(c, r))
    }
}
