package com.example.royalchess

import com.example.royalchess.Pieces.TeamDirectionEnum
import com.example.royalchess.Pieces.TeamEnum

class Player {
    private var team: TeamEnum = TeamEnum.NONE
    private var teamDirection = TeamDirectionEnum.NO_DIRECTION
    private var friendlyTeam = TeamEnum.NONE
    private lateinit var friendlyPlayer: Player

    fun setTeam(teamEnum: TeamEnum){
        team = teamEnum
    }
    fun getTeam():TeamEnum{
        return team
    }

    fun setTeamDirection(teamDirectionEnum: TeamDirectionEnum){
        teamDirection = teamDirectionEnum
    }

    fun getTeamDirection(): TeamDirectionEnum{
        return teamDirection
    }

    fun setFriendlyPlayer(player: Player){
        friendlyPlayer = player

        friendlyTeam = player.getTeam()
    }
}